package com.crashlytics.android.core;

import b.a.a.a.a.b.h;
import b.a.a.a.c;
import com.facebook.appevents.AppEventsConstants;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ReportUploader {
    private static final String CLS_FILE_EXT = ".cls";
    private final String apiKey;
    private final CreateReportSpiCall createReportCall;
    private final Object fileAccessLock = new Object();
    private Thread uploadThread;
    private static final FilenameFilter crashFileFilter = new FilenameFilter() { // from class: com.crashlytics.android.core.ReportUploader.1
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.endsWith(".cls") && !str.contains("Session");
        }
    };
    static final Map<String, String> HEADER_INVALID_CLS_FILE = Collections.singletonMap("X-CRASHLYTICS-INVALID-SESSION", AppEventsConstants.EVENT_PARAM_VALUE_YES);
    private static final short[] RETRY_INTERVALS = {10, 20, 30, 60, 120, 300};

    public ReportUploader(String str, CreateReportSpiCall createReportSpiCall) {
        if (createReportSpiCall == null) {
            throw new IllegalArgumentException("createReportCall must not be null.");
        }
        this.createReportCall = createReportSpiCall;
        this.apiKey = str;
    }

    public void uploadReports() {
        uploadReports(0.0f);
    }

    public synchronized void uploadReports(float f) {
        if (this.uploadThread == null) {
            this.uploadThread = new Thread(new Worker(f), "Crashlytics Report Uploader");
            this.uploadThread.start();
        }
    }

    boolean isUploading() {
        return this.uploadThread != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean forceUpload(Report report) {
        boolean z = false;
        synchronized (this.fileAccessLock) {
            try {
                boolean invoke = this.createReportCall.invoke(new CreateReportRequest(this.apiKey, report));
                c.h().c(CrashlyticsCore.TAG, "Crashlytics report upload " + (invoke ? "complete: " : "FAILED: ") + report.getIdentifier());
                if (invoke) {
                    report.remove();
                    z = true;
                }
            } catch (Exception e) {
                c.h().e(CrashlyticsCore.TAG, "Error occurred sending report " + report, e);
            }
        }
        return z;
    }

    List<Report> findReports() {
        File[] listFiles;
        File[] listFiles2;
        c.h().a(CrashlyticsCore.TAG, "Checking for crash reports...");
        CrashlyticsCore crashlyticsCore = CrashlyticsCore.getInstance();
        CrashlyticsUncaughtExceptionHandler handler = crashlyticsCore.getHandler();
        synchronized (this.fileAccessLock) {
            listFiles = crashlyticsCore.getSdkDirectory().listFiles(crashFileFilter);
            listFiles2 = handler.getInvalidFilesDir().listFiles();
        }
        LinkedList linkedList = new LinkedList();
        for (File file : listFiles) {
            c.h().a(CrashlyticsCore.TAG, "Found crash report " + file.getPath());
            linkedList.add(new SessionReport(file));
        }
        HashMap hashMap = new HashMap();
        if (listFiles2 != null) {
            for (File file2 : listFiles2) {
                String sessionIdFromSessionFile = CrashlyticsUncaughtExceptionHandler.getSessionIdFromSessionFile(file2);
                if (!hashMap.containsKey(sessionIdFromSessionFile)) {
                    hashMap.put(sessionIdFromSessionFile, new LinkedList());
                }
                ((List) hashMap.get(sessionIdFromSessionFile)).add(file2);
            }
        }
        for (String str : hashMap.keySet()) {
            c.h().a(CrashlyticsCore.TAG, "Found invalid session: " + str);
            List list = (List) hashMap.get(str);
            linkedList.add(new InvalidSessionReport(str, (File[]) list.toArray(new File[list.size()])));
        }
        if (linkedList.isEmpty()) {
            c.h().a(CrashlyticsCore.TAG, "No reports found.");
        }
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class Worker extends h {
        private final float delay;

        Worker(float f) {
            this.delay = f;
        }

        @Override // b.a.a.a.a.b.h
        public void onRun() {
            try {
                attemptUploadWithRetry();
            } catch (Exception e) {
                c.h().e(CrashlyticsCore.TAG, "An unexpected error occurred while attempting to upload crash reports.", e);
            }
            ReportUploader.this.uploadThread = null;
        }

        private void attemptUploadWithRetry() {
            c.h().a(CrashlyticsCore.TAG, "Starting report processing in " + this.delay + " second(s)...");
            if (this.delay > 0.0f) {
                try {
                    Thread.sleep(this.delay * 1000.0f);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            CrashlyticsCore crashlyticsCore = CrashlyticsCore.getInstance();
            CrashlyticsUncaughtExceptionHandler handler = crashlyticsCore.getHandler();
            List<Report> findReports = ReportUploader.this.findReports();
            if (!handler.isHandlingException()) {
                if (!findReports.isEmpty() && !crashlyticsCore.canSendWithUserApproval()) {
                    c.h().a(CrashlyticsCore.TAG, "User declined to send. Removing " + findReports.size() + " Report(s).");
                    for (Report report : findReports) {
                        report.remove();
                    }
                    return;
                }
                List<Report> list = findReports;
                int i = 0;
                while (!list.isEmpty() && !CrashlyticsCore.getInstance().getHandler().isHandlingException()) {
                    c.h().a(CrashlyticsCore.TAG, "Attempting to send " + list.size() + " report(s)");
                    for (Report report2 : list) {
                        ReportUploader.this.forceUpload(report2);
                    }
                    List<Report> findReports2 = ReportUploader.this.findReports();
                    if (findReports2.isEmpty()) {
                        list = findReports2;
                    } else {
                        int i2 = i + 1;
                        long j = ReportUploader.RETRY_INTERVALS[Math.min(i, ReportUploader.RETRY_INTERVALS.length - 1)];
                        c.h().a(CrashlyticsCore.TAG, "Report submisson: scheduling delayed retry in " + j + " seconds");
                        try {
                            Thread.sleep(j * 1000);
                            i = i2;
                            list = findReports2;
                        } catch (InterruptedException e2) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                }
            }
        }
    }
}

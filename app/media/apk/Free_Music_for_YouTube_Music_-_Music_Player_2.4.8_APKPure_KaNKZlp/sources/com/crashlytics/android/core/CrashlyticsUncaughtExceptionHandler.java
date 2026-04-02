package com.crashlytics.android.core;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import b.a.a.a.a.b.i;
import b.a.a.a.a.b.l;
import b.a.a.a.a.b.o;
import b.a.a.a.a.f.a;
import b.a.a.a.a.g.p;
import b.a.a.a.a.g.q;
import b.a.a.a.c;
import com.crashlytics.android.core.internal.models.SessionEventData;
import com.facebook.appevents.AppEventsConstants;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Thread;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CrashlyticsUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static final int ANALYZER_VERSION = 1;
    private static final String EVENT_TYPE_CRASH = "crash";
    private static final String EVENT_TYPE_LOGGED = "error";
    private static final String GENERATOR_FORMAT = "Crashlytics Android SDK/%s";
    static final String INVALID_CLS_CACHE_DIR = "invalidClsFiles";
    private static final int MAX_COMPLETE_SESSIONS_COUNT = 4;
    static final int MAX_INVALID_SESSIONS = 4;
    private static final int MAX_LOCAL_LOGGED_EXCEPTIONS = 64;
    static final int MAX_OPEN_SESSIONS = 8;
    static final int MAX_STACK_SIZE = 1024;
    static final int NUM_STACK_REPETITIONS_ALLOWED = 10;
    static final String SESSION_BEGIN_TAG = "BeginSession";
    static final String SESSION_EVENT_MISSING_BINARY_IMGS_TAG = "SessionMissingBinaryImages";
    static final String SESSION_FATAL_TAG = "SessionCrash";
    private static final int SESSION_ID_LENGTH = 35;
    static final String SESSION_NON_FATAL_TAG = "SessionEvent";
    private final CrashlyticsCore crashlyticsCore;
    private final Thread.UncaughtExceptionHandler defaultHandler;
    private final DevicePowerStateListener devicePowerStateListener;
    private final CrashlyticsExecutorServiceWrapper executorServiceWrapper;
    private final a fileStore;
    private final o idManager;
    private final LogFileManager logFileManager;
    private final StackTraceTrimmingStrategy stackTraceTrimmingStrategy;
    private final String unityVersion;
    static final FilenameFilter SESSION_FILE_FILTER = new FilenameFilter() { // from class: com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.1
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.length() == ClsFileOutputStream.SESSION_FILE_EXTENSION.length() + 35 && str.endsWith(ClsFileOutputStream.SESSION_FILE_EXTENSION);
        }
    };
    static final Comparator<File> LARGEST_FILE_NAME_FIRST = new Comparator<File>() { // from class: com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.2
        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            return file2.getName().compareTo(file.getName());
        }
    };
    static final Comparator<File> SMALLEST_FILE_NAME_FIRST = new Comparator<File>() { // from class: com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.3
        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    };
    static final FilenameFilter ANY_SESSION_FILENAME_FILTER = new FilenameFilter() { // from class: com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.4
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return CrashlyticsUncaughtExceptionHandler.SESSION_FILE_PATTERN.matcher(str).matches();
        }
    };
    private static final Pattern SESSION_FILE_PATTERN = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
    private static final Map<String, String> SEND_AT_CRASHTIME_HEADER = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", AppEventsConstants.EVENT_PARAM_VALUE_YES);
    static final String SESSION_USER_TAG = "SessionUser";
    static final String SESSION_APP_TAG = "SessionApp";
    static final String SESSION_OS_TAG = "SessionOS";
    static final String SESSION_DEVICE_TAG = "SessionDevice";
    private static final String[] INITIAL_SESSION_PART_TAGS = {SESSION_USER_TAG, SESSION_APP_TAG, SESSION_OS_TAG, SESSION_DEVICE_TAG};
    private final AtomicInteger eventCounter = new AtomicInteger(0);
    private final AtomicBoolean isHandlingException = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class FileNameContainsFilter implements FilenameFilter {
        private final String string;

        public FileNameContainsFilter(String str) {
            this.string = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.contains(this.string) && !str.endsWith(ClsFileOutputStream.IN_PROGRESS_SESSION_FILE_EXTENSION);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SessionPartFileFilter implements FilenameFilter {
        private final String sessionId;

        public SessionPartFileFilter(String str) {
            this.sessionId = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return (str.equals(new StringBuilder().append(this.sessionId).append(ClsFileOutputStream.SESSION_FILE_EXTENSION).toString()) || !str.contains(this.sessionId) || str.endsWith(ClsFileOutputStream.IN_PROGRESS_SESSION_FILE_EXTENSION)) ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class AnySessionPartFileFilter implements FilenameFilter {
        private AnySessionPartFileFilter() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return !CrashlyticsUncaughtExceptionHandler.SESSION_FILE_FILTER.accept(file, str) && CrashlyticsUncaughtExceptionHandler.SESSION_FILE_PATTERN.matcher(str).matches();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class InvalidPartFileFilter implements FilenameFilter {
        InvalidPartFileFilter() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return ClsFileOutputStream.TEMP_FILENAME_FILTER.accept(file, str) || str.contains(CrashlyticsUncaughtExceptionHandler.SESSION_EVENT_MISSING_BINARY_IMGS_TAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CrashlyticsUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, CrashlyticsExecutorServiceWrapper crashlyticsExecutorServiceWrapper, o oVar, UnityVersionProvider unityVersionProvider, a aVar, CrashlyticsCore crashlyticsCore) {
        this.defaultHandler = uncaughtExceptionHandler;
        this.executorServiceWrapper = crashlyticsExecutorServiceWrapper;
        this.idManager = oVar;
        this.crashlyticsCore = crashlyticsCore;
        this.unityVersion = unityVersionProvider.getUnityVersion();
        this.fileStore = aVar;
        Context context = crashlyticsCore.getContext();
        this.logFileManager = new LogFileManager(context, aVar);
        this.devicePowerStateListener = new DevicePowerStateListener(context);
        this.stackTraceTrimmingStrategy = new MiddleOutFallbackStrategy(1024, new RemoveRepeatsStrategy(10));
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public synchronized void uncaughtException(final Thread thread, final Throwable th) {
        this.isHandlingException.set(true);
        try {
            c.h().a(CrashlyticsCore.TAG, "Crashlytics is handling uncaught exception \"" + th + "\" from thread " + thread.getName());
            this.devicePowerStateListener.dispose();
            final Date date = new Date();
            this.executorServiceWrapper.executeSyncLoggingException(new Callable<Void>() { // from class: com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.5
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    CrashlyticsUncaughtExceptionHandler.this.handleUncaughtException(date, thread, th);
                    return null;
                }
            });
            c.h().a(CrashlyticsCore.TAG, "Crashlytics completed exception processing. Invoking default exception handler.");
            this.defaultHandler.uncaughtException(thread, th);
            this.isHandlingException.set(false);
        } catch (Exception e) {
            c.h().e(CrashlyticsCore.TAG, "An error occurred in the uncaught exception handler", e);
            c.h().a(CrashlyticsCore.TAG, "Crashlytics completed exception processing. Invoking default exception handler.");
            this.defaultHandler.uncaughtException(thread, th);
            this.isHandlingException.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUncaughtException(Date date, Thread thread, Throwable th) throws Exception {
        this.crashlyticsCore.createCrashMarker();
        writeFatal(date, thread, th);
        doCloseSessions();
        doOpenSession();
        trimSessionFiles();
        if (!this.crashlyticsCore.shouldPromptUserBeforeSendingCrashReports()) {
            sendSessionReports();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isHandlingException() {
        return this.isHandlingException.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File getInvalidFilesDir() {
        return new File(getFilesDir(), INVALID_CLS_CACHE_DIR);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeToLog(final long j, final String str) {
        this.executorServiceWrapper.executeAsync(new Callable<Void>() { // from class: com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.6
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                if (!CrashlyticsUncaughtExceptionHandler.this.isHandlingException.get()) {
                    CrashlyticsUncaughtExceptionHandler.this.logFileManager.writeToLog(j, str);
                    return null;
                }
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeNonFatalException(final Thread thread, final Throwable th) {
        final Date date = new Date();
        this.executorServiceWrapper.executeAsync(new Runnable() { // from class: com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.7
            @Override // java.lang.Runnable
            public void run() {
                if (!CrashlyticsUncaughtExceptionHandler.this.isHandlingException.get()) {
                    CrashlyticsUncaughtExceptionHandler.this.doWriteNonFatal(date, thread, th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cacheUserData(final String str, final String str2, final String str3) {
        this.executorServiceWrapper.executeAsync(new Callable<Void>() { // from class: com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.8
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                new MetaDataStore(CrashlyticsUncaughtExceptionHandler.this.getFilesDir()).writeUserData(CrashlyticsUncaughtExceptionHandler.this.getCurrentSessionId(), new UserMetaData(str, str2, str3));
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cacheKeyData(final Map<String, String> map) {
        this.executorServiceWrapper.executeAsync(new Callable<Void>() { // from class: com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.9
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                new MetaDataStore(CrashlyticsUncaughtExceptionHandler.this.getFilesDir()).writeKeyData(CrashlyticsUncaughtExceptionHandler.this.getCurrentSessionId(), map);
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void openSession() {
        this.executorServiceWrapper.executeAsync(new Callable<Void>() { // from class: com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.10
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                CrashlyticsUncaughtExceptionHandler.this.doOpenSession();
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCurrentSessionId() {
        File[] listSortedSessionBeginFiles = listSortedSessionBeginFiles();
        if (listSortedSessionBeginFiles.length > 0) {
            return getSessionIdFromSessionFile(listSortedSessionBeginFiles[0]);
        }
        return null;
    }

    private String getPreviousSessionId() {
        File[] listSortedSessionBeginFiles = listSortedSessionBeginFiles();
        if (listSortedSessionBeginFiles.length > 1) {
            return getSessionIdFromSessionFile(listSortedSessionBeginFiles[1]);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getSessionIdFromSessionFile(File file) {
        return file.getName().substring(0, 35);
    }

    boolean hasOpenSession() {
        return listSessionBeginFiles().length > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean finalizeSessions() {
        return ((Boolean) this.executorServiceWrapper.executeSyncLoggingException(new Callable<Boolean>() { // from class: com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.11
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Boolean call() throws Exception {
                if (CrashlyticsUncaughtExceptionHandler.this.isHandlingException.get()) {
                    c.h().a(CrashlyticsCore.TAG, "Skipping session finalization because a crash has already occurred.");
                    return Boolean.FALSE;
                }
                c.h().a(CrashlyticsCore.TAG, "Finalizing previously open sessions.");
                CrashlyticsUncaughtExceptionHandler.this.doCloseSessions(true);
                c.h().a(CrashlyticsCore.TAG, "Closed all previously open sessions");
                return Boolean.TRUE;
            }
        })).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doOpenSession() throws Exception {
        Date date = new Date();
        String clsuuid = new CLSUUID(this.idManager).toString();
        c.h().a(CrashlyticsCore.TAG, "Opening an new session with ID " + clsuuid);
        writeBeginSession(clsuuid, date);
        writeSessionApp(clsuuid);
        writeSessionOS(clsuuid);
        writeSessionDevice(clsuuid);
        this.logFileManager.setCurrentSession(clsuuid);
    }

    void doCloseSessions() throws Exception {
        doCloseSessions(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doCloseSessions(boolean z) throws Exception {
        int i = z ? 1 : 0;
        trimOpenSessions(i + 8);
        File[] listSortedSessionBeginFiles = listSortedSessionBeginFiles();
        if (listSortedSessionBeginFiles.length <= i) {
            c.h().a(CrashlyticsCore.TAG, "No open sessions to be closed.");
            return;
        }
        writeSessionUser(getSessionIdFromSessionFile(listSortedSessionBeginFiles[i]));
        CrashlyticsCore crashlyticsCore = this.crashlyticsCore;
        p sessionSettingsData = CrashlyticsCore.getSessionSettingsData();
        if (sessionSettingsData == null) {
            c.h().a(CrashlyticsCore.TAG, "Unable to close session. Settings are not loaded.");
        } else {
            closeOpenSessions(listSortedSessionBeginFiles, i, sessionSettingsData.f241c);
        }
    }

    private void closeOpenSessions(File[] fileArr, int i, int i2) {
        c.h().a(CrashlyticsCore.TAG, "Closing open sessions.");
        while (i < fileArr.length) {
            File file = fileArr[i];
            String sessionIdFromSessionFile = getSessionIdFromSessionFile(file);
            c.h().a(CrashlyticsCore.TAG, "Closing session: " + sessionIdFromSessionFile);
            writeSessionPartsToSessionFile(file, sessionIdFromSessionFile, i2);
            i++;
        }
    }

    private void closeWithoutRenamingOrLog(ClsFileOutputStream clsFileOutputStream) {
        if (clsFileOutputStream != null) {
            try {
                clsFileOutputStream.closeInProgressStream();
            } catch (IOException e) {
                c.h().e(CrashlyticsCore.TAG, "Error closing session file stream in the presence of an exception", e);
            }
        }
    }

    private void deleteSessionPartFilesFor(String str) {
        for (File file : listSessionPartFilesFor(str)) {
            file.delete();
        }
    }

    private File[] listSessionPartFilesFor(String str) {
        return listFilesMatching(new SessionPartFileFilter(str));
    }

    private File[] listCompleteSessionFiles() {
        return listFilesMatching(SESSION_FILE_FILTER);
    }

    File[] listSessionBeginFiles() {
        return listFilesMatching(new FileNameContainsFilter(SESSION_BEGIN_TAG));
    }

    private File[] listSortedSessionBeginFiles() {
        File[] listSessionBeginFiles = listSessionBeginFiles();
        Arrays.sort(listSessionBeginFiles, LARGEST_FILE_NAME_FIRST);
        return listSessionBeginFiles;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File[] listFilesMatching(FilenameFilter filenameFilter) {
        return listFilesMatching(getFilesDir(), filenameFilter);
    }

    private File[] listFilesMatching(File file, FilenameFilter filenameFilter) {
        return ensureFileArrayNotNull(file.listFiles(filenameFilter));
    }

    private File[] listFiles(File file) {
        return ensureFileArrayNotNull(file.listFiles());
    }

    private File[] ensureFileArrayNotNull(File[] fileArr) {
        return fileArr == null ? new File[0] : fileArr;
    }

    private void trimSessionEventFiles(String str, int i) {
        Utils.capFileCount(getFilesDir(), new FileNameContainsFilter(str + SESSION_NON_FATAL_TAG), i, SMALLEST_FILE_NAME_FIRST);
    }

    void trimSessionFiles() {
        Utils.capFileCount(getFilesDir(), SESSION_FILE_FILTER, 4, SMALLEST_FILE_NAME_FIRST);
    }

    private void trimOpenSessions(int i) {
        HashSet hashSet = new HashSet();
        File[] listSortedSessionBeginFiles = listSortedSessionBeginFiles();
        int min = Math.min(i, listSortedSessionBeginFiles.length);
        for (int i2 = 0; i2 < min; i2++) {
            hashSet.add(getSessionIdFromSessionFile(listSortedSessionBeginFiles[i2]));
        }
        this.logFileManager.discardOldLogFiles(hashSet);
        retainSessions(listFilesMatching(new AnySessionPartFileFilter()), hashSet);
    }

    private void retainSessions(File[] fileArr, Set<String> set) {
        for (File file : fileArr) {
            String name = file.getName();
            Matcher matcher = SESSION_FILE_PATTERN.matcher(name);
            if (!matcher.matches()) {
                c.h().a(CrashlyticsCore.TAG, "Deleting unknown file: " + name);
                file.delete();
                return;
            }
            if (!set.contains(matcher.group(1))) {
                c.h().a(CrashlyticsCore.TAG, "Trimming session file: " + name);
                file.delete();
            }
        }
    }

    private File[] getTrimmedNonFatalFiles(String str, File[] fileArr, int i) {
        if (fileArr.length > i) {
            c.h().a(CrashlyticsCore.TAG, String.format(Locale.US, "Trimming down to %d logged exceptions.", Integer.valueOf(i)));
            trimSessionEventFiles(str, i);
            return listFilesMatching(new FileNameContainsFilter(str + SESSION_NON_FATAL_TAG));
        }
        return fileArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cleanInvalidTempFiles() {
        this.executorServiceWrapper.executeAsync(new Runnable() { // from class: com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.12
            @Override // java.lang.Runnable
            public void run() {
                CrashlyticsUncaughtExceptionHandler.this.doCleanInvalidTempFiles(CrashlyticsUncaughtExceptionHandler.this.listFilesMatching(new InvalidPartFileFilter()));
            }
        });
    }

    void doCleanInvalidTempFiles(File[] fileArr) {
        File[] listFilesMatching;
        final HashSet hashSet = new HashSet();
        for (File file : fileArr) {
            c.h().a(CrashlyticsCore.TAG, "Found invalid session part file: " + file);
            hashSet.add(getSessionIdFromSessionFile(file));
        }
        if (!hashSet.isEmpty()) {
            File invalidFilesDir = getInvalidFilesDir();
            if (!invalidFilesDir.exists()) {
                invalidFilesDir.mkdir();
            }
            for (File file2 : listFilesMatching(new FilenameFilter() { // from class: com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.13
                @Override // java.io.FilenameFilter
                public boolean accept(File file3, String str) {
                    if (str.length() < 35) {
                        return false;
                    }
                    return hashSet.contains(str.substring(0, 35));
                }
            })) {
                c.h().a(CrashlyticsCore.TAG, "Moving session file: " + file2);
                if (!file2.renameTo(new File(invalidFilesDir, file2.getName()))) {
                    c.h().a(CrashlyticsCore.TAG, "Could not move session file. Deleting " + file2);
                    file2.delete();
                }
            }
            trimInvalidSessionFiles();
        }
    }

    private void trimInvalidSessionFiles() {
        File invalidFilesDir = getInvalidFilesDir();
        if (invalidFilesDir.exists()) {
            File[] listFilesMatching = listFilesMatching(invalidFilesDir, new InvalidPartFileFilter());
            Arrays.sort(listFilesMatching, Collections.reverseOrder());
            HashSet hashSet = new HashSet();
            for (int i = 0; i < listFilesMatching.length && hashSet.size() < 4; i++) {
                hashSet.add(getSessionIdFromSessionFile(listFilesMatching[i]));
            }
            retainSessions(listFiles(invalidFilesDir), hashSet);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Closeable] */
    private void writeFatal(Date date, Thread thread, Throwable th) {
        ClsFileOutputStream clsFileOutputStream;
        CodedOutputStream codedOutputStream = null;
        try {
            String currentSessionId = getCurrentSessionId();
            if (currentSessionId == null) {
                c.h().e(CrashlyticsCore.TAG, "Tried to write a fatal exception while no session was open.", null);
                i.a((Flushable) null, "Failed to flush to session begin file.");
                i.a((Closeable) null, "Failed to close fatal exception file output stream.");
            } else {
                CrashlyticsCore.recordFatalExceptionEvent(currentSessionId, th.getClass().getName());
                ClsFileOutputStream clsFileOutputStream2 = new ClsFileOutputStream(getFilesDir(), currentSessionId + SESSION_FATAL_TAG);
                try {
                    codedOutputStream = CodedOutputStream.newInstance(clsFileOutputStream2);
                    writeSessionEvent(codedOutputStream, date, thread, th, EVENT_TYPE_CRASH, true);
                    i.a(codedOutputStream, "Failed to flush to session begin file.");
                    i.a((Closeable) clsFileOutputStream2, "Failed to close fatal exception file output stream.");
                } catch (Exception e) {
                    e = e;
                    clsFileOutputStream = clsFileOutputStream2;
                    try {
                        c.h().e(CrashlyticsCore.TAG, "An error occurred in the fatal exception logger", e);
                        i.a(codedOutputStream, "Failed to flush to session begin file.");
                        i.a((Closeable) clsFileOutputStream, "Failed to close fatal exception file output stream.");
                    } catch (Throwable th2) {
                        th = th2;
                        i.a(codedOutputStream, "Failed to flush to session begin file.");
                        i.a((Closeable) clsFileOutputStream, "Failed to close fatal exception file output stream.");
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    clsFileOutputStream = clsFileOutputStream2;
                    i.a(codedOutputStream, "Failed to flush to session begin file.");
                    i.a((Closeable) clsFileOutputStream, "Failed to close fatal exception file output stream.");
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            clsFileOutputStream = codedOutputStream;
        } catch (Throwable th4) {
            th = th4;
            clsFileOutputStream = codedOutputStream;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternalCrashEvent(final SessionEventData sessionEventData) {
        this.executorServiceWrapper.executeAsync(new Callable<Void>() { // from class: com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.14
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                if (!CrashlyticsUncaughtExceptionHandler.this.isHandlingException.get()) {
                    CrashlyticsUncaughtExceptionHandler.this.doWriteExternalCrashEvent(sessionEventData);
                    return null;
                }
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doWriteExternalCrashEvent(SessionEventData sessionEventData) throws IOException {
        ClsFileOutputStream clsFileOutputStream;
        boolean z = true;
        CodedOutputStream codedOutputStream = null;
        try {
            String previousSessionId = getPreviousSessionId();
            if (previousSessionId == null) {
                c.h().e(CrashlyticsCore.TAG, "Tried to write a native crash while no session was open.", null);
                i.a((Flushable) null, "Failed to flush to session begin file.");
                i.a((Closeable) null, "Failed to close fatal exception file output stream.");
                return;
            }
            CrashlyticsCore.recordFatalExceptionEvent(previousSessionId, String.format(Locale.US, "<native-crash [%s (%s)]>", sessionEventData.signal.code, sessionEventData.signal.name));
            if (sessionEventData.binaryImages == null || sessionEventData.binaryImages.length <= 0) {
                z = false;
            }
            clsFileOutputStream = new ClsFileOutputStream(getFilesDir(), previousSessionId + (z ? SESSION_FATAL_TAG : SESSION_EVENT_MISSING_BINARY_IMGS_TAG));
            try {
                try {
                    codedOutputStream = CodedOutputStream.newInstance(clsFileOutputStream);
                    NativeCrashWriter.writeNativeCrash(sessionEventData, new LogFileManager(this.crashlyticsCore.getContext(), this.fileStore, previousSessionId), new MetaDataStore(getFilesDir()).readKeyData(previousSessionId), codedOutputStream);
                    i.a(codedOutputStream, "Failed to flush to session begin file.");
                    i.a((Closeable) clsFileOutputStream, "Failed to close fatal exception file output stream.");
                } catch (Exception e) {
                    e = e;
                    c.h().e(CrashlyticsCore.TAG, "An error occurred in the native crash logger", e);
                    i.a(codedOutputStream, "Failed to flush to session begin file.");
                    i.a((Closeable) clsFileOutputStream, "Failed to close fatal exception file output stream.");
                }
            } catch (Throwable th) {
                th = th;
                i.a(codedOutputStream, "Failed to flush to session begin file.");
                i.a((Closeable) clsFileOutputStream, "Failed to close fatal exception file output stream.");
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            clsFileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            clsFileOutputStream = null;
            i.a(codedOutputStream, "Failed to flush to session begin file.");
            i.a((Closeable) clsFileOutputStream, "Failed to close fatal exception file output stream.");
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doWriteNonFatal(Date date, Thread thread, Throwable th) {
        ClsFileOutputStream clsFileOutputStream;
        ClsFileOutputStream clsFileOutputStream2;
        CodedOutputStream codedOutputStream = null;
        String currentSessionId = getCurrentSessionId();
        if (currentSessionId == null) {
            c.h().e(CrashlyticsCore.TAG, "Tried to write a non-fatal exception while no session was open.", null);
            return;
        }
        CrashlyticsCore.recordLoggedExceptionEvent(currentSessionId, th.getClass().getName());
        try {
            c.h().a(CrashlyticsCore.TAG, "Crashlytics is logging non-fatal exception \"" + th + "\" from thread " + thread.getName());
            clsFileOutputStream2 = new ClsFileOutputStream(getFilesDir(), currentSessionId + SESSION_NON_FATAL_TAG + i.a(this.eventCounter.getAndIncrement()));
        } catch (Exception e) {
            e = e;
            clsFileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            clsFileOutputStream = null;
        }
        try {
            try {
                codedOutputStream = CodedOutputStream.newInstance(clsFileOutputStream2);
                writeSessionEvent(codedOutputStream, date, thread, th, "error", false);
                i.a(codedOutputStream, "Failed to flush to non-fatal file.");
                i.a((Closeable) clsFileOutputStream2, "Failed to close non-fatal file output stream.");
            } catch (Exception e2) {
                e = e2;
                clsFileOutputStream = clsFileOutputStream2;
                try {
                    c.h().e(CrashlyticsCore.TAG, "An error occurred in the non-fatal exception logger", e);
                    i.a(codedOutputStream, "Failed to flush to non-fatal file.");
                    i.a((Closeable) clsFileOutputStream, "Failed to close non-fatal file output stream.");
                    trimSessionEventFiles(currentSessionId, 64);
                } catch (Throwable th3) {
                    th = th3;
                    i.a(codedOutputStream, "Failed to flush to non-fatal file.");
                    i.a((Closeable) clsFileOutputStream, "Failed to close non-fatal file output stream.");
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                clsFileOutputStream = clsFileOutputStream2;
                i.a(codedOutputStream, "Failed to flush to non-fatal file.");
                i.a((Closeable) clsFileOutputStream, "Failed to close non-fatal file output stream.");
                throw th;
            }
            trimSessionEventFiles(currentSessionId, 64);
        } catch (Exception e3) {
            c.h().e(CrashlyticsCore.TAG, "An error occurred when trimming non-fatal files.", e3);
        }
    }

    private void writeBeginSession(String str, Date date) throws Exception {
        ClsFileOutputStream clsFileOutputStream;
        CodedOutputStream codedOutputStream = null;
        try {
            clsFileOutputStream = new ClsFileOutputStream(getFilesDir(), str + SESSION_BEGIN_TAG);
            try {
                codedOutputStream = CodedOutputStream.newInstance(clsFileOutputStream);
                SessionProtobufHelper.writeBeginSession(codedOutputStream, str, String.format(Locale.US, GENERATOR_FORMAT, this.crashlyticsCore.getVersion()), date.getTime() / 1000);
                i.a(codedOutputStream, "Failed to flush to session begin file.");
                i.a((Closeable) clsFileOutputStream, "Failed to close begin session file.");
            } catch (Throwable th) {
                th = th;
                i.a(codedOutputStream, "Failed to flush to session begin file.");
                i.a((Closeable) clsFileOutputStream, "Failed to close begin session file.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            clsFileOutputStream = null;
        }
    }

    private void writeSessionApp(String str) throws Exception {
        ClsFileOutputStream clsFileOutputStream;
        CodedOutputStream newInstance;
        CodedOutputStream codedOutputStream = null;
        try {
            ClsFileOutputStream clsFileOutputStream2 = new ClsFileOutputStream(getFilesDir(), str + SESSION_APP_TAG);
            try {
                newInstance = CodedOutputStream.newInstance(clsFileOutputStream2);
            } catch (Throwable th) {
                th = th;
                clsFileOutputStream = clsFileOutputStream2;
            }
            try {
                SessionProtobufHelper.writeSessionApp(newInstance, this.idManager.c(), this.crashlyticsCore.getApiKey(), this.crashlyticsCore.getVersionCode(), this.crashlyticsCore.getVersionName(), this.idManager.b(), l.a(this.crashlyticsCore.getInstallerPackageName()).a(), this.unityVersion);
                i.a(newInstance, "Failed to flush to session app file.");
                i.a((Closeable) clsFileOutputStream2, "Failed to close session app file.");
            } catch (Throwable th2) {
                clsFileOutputStream = clsFileOutputStream2;
                th = th2;
                codedOutputStream = newInstance;
                i.a(codedOutputStream, "Failed to flush to session app file.");
                i.a((Closeable) clsFileOutputStream, "Failed to close session app file.");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            clsFileOutputStream = null;
        }
    }

    private void writeSessionOS(String str) throws Exception {
        ClsFileOutputStream clsFileOutputStream;
        CodedOutputStream codedOutputStream = null;
        try {
            clsFileOutputStream = new ClsFileOutputStream(getFilesDir(), str + SESSION_OS_TAG);
            try {
                codedOutputStream = CodedOutputStream.newInstance(clsFileOutputStream);
                SessionProtobufHelper.writeSessionOS(codedOutputStream, i.g(this.crashlyticsCore.getContext()));
                i.a(codedOutputStream, "Failed to flush to session OS file.");
                i.a((Closeable) clsFileOutputStream, "Failed to close session OS file.");
            } catch (Throwable th) {
                th = th;
                i.a(codedOutputStream, "Failed to flush to session OS file.");
                i.a((Closeable) clsFileOutputStream, "Failed to close session OS file.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            clsFileOutputStream = null;
        }
    }

    private void writeSessionDevice(String str) throws Exception {
        ClsFileOutputStream clsFileOutputStream = null;
        CodedOutputStream codedOutputStream = null;
        try {
            ClsFileOutputStream clsFileOutputStream2 = new ClsFileOutputStream(getFilesDir(), str + SESSION_DEVICE_TAG);
            try {
                codedOutputStream = CodedOutputStream.newInstance(clsFileOutputStream2);
                Context context = this.crashlyticsCore.getContext();
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                SessionProtobufHelper.writeSessionDevice(codedOutputStream, this.idManager.h(), i.a(), Build.MODEL, Runtime.getRuntime().availableProcessors(), i.b(), statFs.getBlockCount() * statFs.getBlockSize(), i.f(context), this.idManager.i(), i.h(context), Build.MANUFACTURER, Build.PRODUCT);
                i.a(codedOutputStream, "Failed to flush session device info.");
                i.a((Closeable) clsFileOutputStream2, "Failed to close session device file.");
            } catch (Throwable th) {
                th = th;
                clsFileOutputStream = clsFileOutputStream2;
                i.a(codedOutputStream, "Failed to flush session device info.");
                i.a((Closeable) clsFileOutputStream, "Failed to close session device file.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void writeSessionUser(String str) throws Exception {
        ClsFileOutputStream clsFileOutputStream;
        CodedOutputStream codedOutputStream = null;
        try {
            clsFileOutputStream = new ClsFileOutputStream(getFilesDir(), str + SESSION_USER_TAG);
            try {
                codedOutputStream = CodedOutputStream.newInstance(clsFileOutputStream);
                UserMetaData userMetaData = getUserMetaData(str);
                if (userMetaData.isEmpty()) {
                    i.a(codedOutputStream, "Failed to flush session user file.");
                    i.a((Closeable) clsFileOutputStream, "Failed to close session user file.");
                    return;
                }
                SessionProtobufHelper.writeSessionUser(codedOutputStream, userMetaData.id, userMetaData.name, userMetaData.email);
                i.a(codedOutputStream, "Failed to flush session user file.");
                i.a((Closeable) clsFileOutputStream, "Failed to close session user file.");
            } catch (Throwable th) {
                th = th;
                i.a(codedOutputStream, "Failed to flush session user file.");
                i.a((Closeable) clsFileOutputStream, "Failed to close session user file.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            clsFileOutputStream = null;
        }
    }

    private void writeSessionEvent(CodedOutputStream codedOutputStream, Date date, Thread thread, Throwable th, String str, boolean z) throws Exception {
        Thread[] threadArr;
        Map<String, String> treeMap;
        TrimmedThrowableData trimmedThrowableData = new TrimmedThrowableData(th, this.stackTraceTrimmingStrategy);
        Context context = this.crashlyticsCore.getContext();
        long time = date.getTime() / 1000;
        Float c2 = i.c(context);
        int a2 = i.a(context, this.devicePowerStateListener.isPowerConnected());
        boolean d = i.d(context);
        int i = context.getResources().getConfiguration().orientation;
        long b2 = i.b() - i.b(context);
        long b3 = i.b(Environment.getDataDirectory().getPath());
        ActivityManager.RunningAppProcessInfo a3 = i.a(context.getPackageName(), context);
        LinkedList linkedList = new LinkedList();
        StackTraceElement[] stackTraceElementArr = trimmedThrowableData.stacktrace;
        String buildId = this.crashlyticsCore.getBuildId();
        String c3 = this.idManager.c();
        if (z) {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            threadArr = new Thread[allStackTraces.size()];
            int i2 = 0;
            Iterator<Map.Entry<Thread, StackTraceElement[]>> it = allStackTraces.entrySet().iterator();
            while (true) {
                int i3 = i2;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Thread, StackTraceElement[]> next = it.next();
                threadArr[i3] = next.getKey();
                linkedList.add(this.stackTraceTrimmingStrategy.getTrimmedStackTrace(next.getValue()));
                i2 = i3 + 1;
            }
        } else {
            threadArr = new Thread[0];
        }
        if (!i.a(context, "com.crashlytics.CollectCustomKeys", true)) {
            treeMap = new TreeMap<>();
        } else {
            Map<String, String> attributes = this.crashlyticsCore.getAttributes();
            treeMap = (attributes == null || attributes.size() <= 1) ? attributes : new TreeMap<>(attributes);
        }
        SessionProtobufHelper.writeSessionEvent(codedOutputStream, time, str, trimmedThrowableData, thread, stackTraceElementArr, threadArr, linkedList, treeMap, this.logFileManager, a3, i, c3, buildId, c2, a2, d, b2, b3);
    }

    private void writeSessionPartsToSessionFile(File file, String str, int i) {
        c.h().a(CrashlyticsCore.TAG, "Collecting session parts for ID " + str);
        File[] listFilesMatching = listFilesMatching(new FileNameContainsFilter(str + SESSION_FATAL_TAG));
        boolean z = listFilesMatching != null && listFilesMatching.length > 0;
        c.h().a(CrashlyticsCore.TAG, String.format(Locale.US, "Session %s has fatal exception: %s", str, Boolean.valueOf(z)));
        File[] listFilesMatching2 = listFilesMatching(new FileNameContainsFilter(str + SESSION_NON_FATAL_TAG));
        boolean z2 = listFilesMatching2 != null && listFilesMatching2.length > 0;
        c.h().a(CrashlyticsCore.TAG, String.format(Locale.US, "Session %s has non-fatal exceptions: %s", str, Boolean.valueOf(z2)));
        if (z || z2) {
            synthesizeSessionFile(file, str, getTrimmedNonFatalFiles(str, listFilesMatching2, i), z ? listFilesMatching[0] : null);
        } else {
            c.h().a(CrashlyticsCore.TAG, "No events present for session ID " + str);
        }
        c.h().a(CrashlyticsCore.TAG, "Removing session part files for ID " + str);
        deleteSessionPartFilesFor(str);
    }

    private void synthesizeSessionFile(File file, String str, File[] fileArr, File file2) {
        ClsFileOutputStream clsFileOutputStream;
        CodedOutputStream codedOutputStream = null;
        boolean z = file2 != null;
        try {
            clsFileOutputStream = new ClsFileOutputStream(getFilesDir(), str);
            try {
                try {
                    codedOutputStream = CodedOutputStream.newInstance(clsFileOutputStream);
                    c.h().a(CrashlyticsCore.TAG, "Collecting SessionStart data for session ID " + str);
                    writeToCosFromFile(codedOutputStream, file);
                    codedOutputStream.writeUInt64(4, new Date().getTime() / 1000);
                    codedOutputStream.writeBool(5, z);
                    codedOutputStream.writeUInt32(11, 1);
                    codedOutputStream.writeEnum(12, 3);
                    writeInitialPartsTo(codedOutputStream, str);
                    writeNonFatalEventsTo(codedOutputStream, fileArr, str);
                    if (z) {
                        writeToCosFromFile(codedOutputStream, file2);
                    }
                    i.a(codedOutputStream, "Error flushing session file stream");
                    i.a((Closeable) clsFileOutputStream, "Failed to close CLS file");
                } catch (Exception e) {
                    e = e;
                    c.h().e(CrashlyticsCore.TAG, "Failed to write session file for session ID: " + str, e);
                    i.a(codedOutputStream, "Error flushing session file stream");
                    closeWithoutRenamingOrLog(clsFileOutputStream);
                }
            } catch (Throwable th) {
                th = th;
                i.a(codedOutputStream, "Error flushing session file stream");
                i.a((Closeable) clsFileOutputStream, "Failed to close CLS file");
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            clsFileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            clsFileOutputStream = null;
            i.a(codedOutputStream, "Error flushing session file stream");
            i.a((Closeable) clsFileOutputStream, "Failed to close CLS file");
            throw th;
        }
    }

    private static void writeNonFatalEventsTo(CodedOutputStream codedOutputStream, File[] fileArr, String str) {
        Arrays.sort(fileArr, i.f97a);
        for (File file : fileArr) {
            try {
                c.h().a(CrashlyticsCore.TAG, String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", str, file.getName()));
                writeToCosFromFile(codedOutputStream, file);
            } catch (Exception e) {
                c.h().e(CrashlyticsCore.TAG, "Error writting non-fatal to session.", e);
            }
        }
    }

    private void writeInitialPartsTo(CodedOutputStream codedOutputStream, String str) throws IOException {
        String[] strArr;
        for (String str2 : INITIAL_SESSION_PART_TAGS) {
            File[] listFilesMatching = listFilesMatching(new FileNameContainsFilter(str + str2));
            if (listFilesMatching.length == 0) {
                c.h().e(CrashlyticsCore.TAG, "Can't find " + str2 + " data for session ID " + str, null);
            } else {
                c.h().a(CrashlyticsCore.TAG, "Collecting " + str2 + " data for session ID " + str);
                writeToCosFromFile(codedOutputStream, listFilesMatching[0]);
            }
        }
    }

    private static void writeToCosFromFile(CodedOutputStream codedOutputStream, File file) throws IOException {
        FileInputStream fileInputStream;
        if (!file.exists()) {
            c.h().e(CrashlyticsCore.TAG, "Tried to include a file that doesn't exist: " + file.getName(), null);
            return;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                copyToCodedOutputStream(fileInputStream, codedOutputStream, (int) file.length());
                i.a((Closeable) fileInputStream, "Failed to close file input stream.");
            } catch (Throwable th) {
                th = th;
                i.a((Closeable) fileInputStream, "Failed to close file input stream.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    private static void copyToCodedOutputStream(InputStream inputStream, CodedOutputStream codedOutputStream, int i) throws IOException {
        int read;
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < bArr.length && (read = inputStream.read(bArr, i2, bArr.length - i2)) >= 0) {
            i2 += read;
        }
        codedOutputStream.writeRawBytes(bArr);
    }

    private UserMetaData getUserMetaData(String str) {
        return isHandlingException() ? new UserMetaData(this.crashlyticsCore.getUserIdentifier(), this.crashlyticsCore.getUserName(), this.crashlyticsCore.getUserEmail()) : new MetaDataStore(getFilesDir()).readUserData(str);
    }

    private void sendSessionReports() {
        for (File file : listCompleteSessionFiles()) {
            this.executorServiceWrapper.executeAsync(new SendSessionRunnable(this.crashlyticsCore, file));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File getFilesDir() {
        return this.fileStore.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class SendSessionRunnable implements Runnable {
        private final CrashlyticsCore crashlyticsCore;
        private final File fileToSend;

        public SendSessionRunnable(CrashlyticsCore crashlyticsCore, File file) {
            this.crashlyticsCore = crashlyticsCore;
            this.fileToSend = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (i.n(this.crashlyticsCore.getContext())) {
                c.h().a(CrashlyticsCore.TAG, "Attempting to send crash report at time of crash...");
                CreateReportSpiCall createReportSpiCall = this.crashlyticsCore.getCreateReportSpiCall(q.a().b());
                if (createReportSpiCall != null) {
                    new ReportUploader(this.crashlyticsCore.getApiKey(), createReportSpiCall).forceUpload(new SessionReport(this.fileToSend, CrashlyticsUncaughtExceptionHandler.SEND_AT_CRASHTIME_HEADER));
                }
            }
        }
    }
}

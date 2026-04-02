package com.crashlytics.android.core;

import android.content.Context;
import b.a.a.a.a.b.i;
import b.a.a.a.a.f.a;
import b.a.a.a.c;
import java.io.File;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class LogFileManager {
    private static final String DIRECTORY_NAME = "log-files";
    private static final String LOGFILE_EXT = ".temp";
    private static final String LOGFILE_PREFIX = "crashlytics-userlog-";
    static final int MAX_LOG_SIZE = 65536;
    private static final NoopLogStore NOOP_LOG_STORE = new NoopLogStore();
    private final Context context;
    private FileLogStore currentLog;
    private final a fileStore;

    public LogFileManager(Context context, a aVar) {
        this(context, aVar, null);
    }

    public LogFileManager(Context context, a aVar, String str) {
        this.context = context;
        this.fileStore = aVar;
        this.currentLog = NOOP_LOG_STORE;
        setCurrentSession(str);
    }

    public final void setCurrentSession(String str) {
        this.currentLog.closeLogFile();
        this.currentLog = NOOP_LOG_STORE;
        if (str != null) {
            if (!isLoggingEnabled()) {
                c.h().a(CrashlyticsCore.TAG, "Preferences requested no custom logs. Aborting log file creation.");
            } else {
                setLogFile(getWorkingFileForSession(str), 65536);
            }
        }
    }

    public void writeToLog(long j, String str) {
        this.currentLog.writeToLog(j, str);
    }

    public ByteString getByteStringForLog() {
        return this.currentLog.getLogAsByteString();
    }

    public void clearLog() {
        this.currentLog.deleteLogFile();
    }

    public void discardOldLogFiles(Set<String> set) {
        File[] listFiles = getLogFileDir().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (!set.contains(getSessionIdForFile(file))) {
                    file.delete();
                }
            }
        }
    }

    void setLogFile(File file, int i) {
        this.currentLog = new QueueFileLogStore(file, i);
    }

    private File getWorkingFileForSession(String str) {
        return new File(getLogFileDir(), LOGFILE_PREFIX + str + LOGFILE_EXT);
    }

    private String getSessionIdForFile(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(LOGFILE_EXT);
        return lastIndexOf == -1 ? name : name.substring(LOGFILE_PREFIX.length(), lastIndexOf);
    }

    private boolean isLoggingEnabled() {
        return i.a(this.context, "com.crashlytics.CollectCustomLogs", true);
    }

    private File getLogFileDir() {
        File file = new File(this.fileStore.a(), DIRECTORY_NAME);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class NoopLogStore implements FileLogStore {
        private NoopLogStore() {
        }

        @Override // com.crashlytics.android.core.FileLogStore
        public void writeToLog(long j, String str) {
        }

        @Override // com.crashlytics.android.core.FileLogStore
        public ByteString getLogAsByteString() {
            return null;
        }

        @Override // com.crashlytics.android.core.FileLogStore
        public void closeLogFile() {
        }

        @Override // com.crashlytics.android.core.FileLogStore
        public void deleteLogFile() {
        }
    }
}

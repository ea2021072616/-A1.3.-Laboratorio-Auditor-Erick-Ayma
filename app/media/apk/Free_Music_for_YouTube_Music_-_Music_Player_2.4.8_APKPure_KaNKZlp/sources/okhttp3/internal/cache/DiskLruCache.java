package okhttp3.internal.cache;

import c.d;
import c.e;
import c.l;
import c.r;
import c.s;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okhttp3.internal.Util;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
/* loaded from: classes2.dex */
public final class DiskLruCache implements Closeable, Flushable {
    static final /* synthetic */ boolean $assertionsDisabled;
    static final long ANY_SEQUENCE_NUMBER = -1;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final Pattern LEGAL_KEY_PATTERN;
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    boolean closed;
    final File directory;
    private final Executor executor;
    final FileSystem fileSystem;
    boolean hasJournalErrors;
    boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    d journalWriter;
    private long maxSize;
    boolean mostRecentRebuildFailed;
    boolean mostRecentTrimFailed;
    int redundantOpCount;
    final int valueCount;
    private long size = 0;
    final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap<>(0, 0.75f, true);
    private long nextSequenceNumber = 0;
    private final Runnable cleanupRunnable = new Runnable() { // from class: okhttp3.internal.cache.DiskLruCache.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (DiskLruCache.this) {
                if (!((DiskLruCache.this.initialized ? false : true) | DiskLruCache.this.closed)) {
                    try {
                        DiskLruCache.this.trimToSize();
                    } catch (IOException e) {
                        DiskLruCache.this.mostRecentTrimFailed = true;
                    }
                    try {
                        if (DiskLruCache.this.journalRebuildRequired()) {
                            DiskLruCache.this.rebuildJournal();
                            DiskLruCache.this.redundantOpCount = 0;
                        }
                    } catch (IOException e2) {
                        DiskLruCache.this.mostRecentRebuildFailed = true;
                        DiskLruCache.this.journalWriter = l.a(l.a());
                    }
                }
            }
        }
    };

    static {
        $assertionsDisabled = !DiskLruCache.class.desiredAssertionStatus();
        LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,120}");
    }

    DiskLruCache(FileSystem fileSystem, File file, int i, int i2, long j, Executor executor) {
        this.fileSystem = fileSystem;
        this.directory = file;
        this.appVersion = i;
        this.journalFile = new File(file, JOURNAL_FILE);
        this.journalFileTmp = new File(file, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new File(file, JOURNAL_FILE_BACKUP);
        this.valueCount = i2;
        this.maxSize = j;
        this.executor = executor;
    }

    public synchronized void initialize() throws IOException {
        if (!$assertionsDisabled && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.initialized) {
            if (this.fileSystem.exists(this.journalFileBackup)) {
                if (this.fileSystem.exists(this.journalFile)) {
                    this.fileSystem.delete(this.journalFileBackup);
                } else {
                    this.fileSystem.rename(this.journalFileBackup, this.journalFile);
                }
            }
            if (this.fileSystem.exists(this.journalFile)) {
                try {
                    readJournal();
                    processJournal();
                    this.initialized = true;
                } catch (IOException e) {
                    Platform.get().log(5, "DiskLruCache " + this.directory + " is corrupt: " + e.getMessage() + ", removing", e);
                    delete();
                    this.closed = false;
                }
            }
            rebuildJournal();
            this.initialized = true;
        }
    }

    public static DiskLruCache create(FileSystem fileSystem, File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        return new DiskLruCache(fileSystem, file, i, i2, j, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp DiskLruCache", true)));
    }

    private void readJournal() throws IOException {
        e a2 = l.a(this.fileSystem.source(this.journalFile));
        try {
            String s = a2.s();
            String s2 = a2.s();
            String s3 = a2.s();
            String s4 = a2.s();
            String s5 = a2.s();
            if (!MAGIC.equals(s) || !"1".equals(s2) || !Integer.toString(this.appVersion).equals(s3) || !Integer.toString(this.valueCount).equals(s4) || !"".equals(s5)) {
                throw new IOException("unexpected journal header: [" + s + ", " + s2 + ", " + s4 + ", " + s5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    readJournalLine(a2.s());
                    i++;
                } catch (EOFException e) {
                    this.redundantOpCount = i - this.lruEntries.size();
                    if (!a2.f()) {
                        rebuildJournal();
                    } else {
                        this.journalWriter = newJournalWriter();
                    }
                    Util.closeQuietly(a2);
                    return;
                }
            }
        } catch (Throwable th) {
            Util.closeQuietly(a2);
            throw th;
        }
    }

    private d newJournalWriter() throws FileNotFoundException {
        return l.a(new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile)) { // from class: okhttp3.internal.cache.DiskLruCache.2
            static final /* synthetic */ boolean $assertionsDisabled;

            static {
                $assertionsDisabled = !DiskLruCache.class.desiredAssertionStatus();
            }

            @Override // okhttp3.internal.cache.FaultHidingSink
            protected void onException(IOException iOException) {
                if (!$assertionsDisabled && !Thread.holdsLock(DiskLruCache.this)) {
                    throw new AssertionError();
                }
                DiskLruCache.this.hasJournalErrors = true;
            }
        });
    }

    private void readJournalLine(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            String substring2 = str.substring(i);
            if (indexOf == REMOVE.length() && str.startsWith(REMOVE)) {
                this.lruEntries.remove(substring2);
                return;
            }
            substring = substring2;
        } else {
            substring = str.substring(i, indexOf2);
        }
        Entry entry = this.lruEntries.get(substring);
        if (entry == null) {
            entry = new Entry(substring);
            this.lruEntries.put(substring, entry);
        }
        if (indexOf2 != -1 && indexOf == CLEAN.length() && str.startsWith(CLEAN)) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            entry.readable = true;
            entry.currentEditor = null;
            entry.setLengths(split);
        } else if (indexOf2 == -1 && indexOf == DIRTY.length() && str.startsWith(DIRTY)) {
            entry.currentEditor = new Editor(entry);
        } else if (indexOf2 != -1 || indexOf != READ.length() || !str.startsWith(READ)) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private void processJournal() throws IOException {
        this.fileSystem.delete(this.journalFileTmp);
        Iterator<Entry> it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            if (next.currentEditor == null) {
                for (int i = 0; i < this.valueCount; i++) {
                    this.size += next.lengths[i];
                }
            } else {
                next.currentEditor = null;
                for (int i2 = 0; i2 < this.valueCount; i2++) {
                    this.fileSystem.delete(next.cleanFiles[i2]);
                    this.fileSystem.delete(next.dirtyFiles[i2]);
                }
                it.remove();
            }
        }
    }

    synchronized void rebuildJournal() throws IOException {
        if (this.journalWriter != null) {
            this.journalWriter.close();
        }
        d a2 = l.a(this.fileSystem.sink(this.journalFileTmp));
        a2.b(MAGIC).i(10);
        a2.b("1").i(10);
        a2.m(this.appVersion).i(10);
        a2.m(this.valueCount).i(10);
        a2.i(10);
        for (Entry entry : this.lruEntries.values()) {
            if (entry.currentEditor != null) {
                a2.b(DIRTY).i(32);
                a2.b(entry.key);
                a2.i(10);
            } else {
                a2.b(CLEAN).i(32);
                a2.b(entry.key);
                entry.writeLengths(a2);
                a2.i(10);
            }
        }
        a2.close();
        if (this.fileSystem.exists(this.journalFile)) {
            this.fileSystem.rename(this.journalFile, this.journalFileBackup);
        }
        this.fileSystem.rename(this.journalFileTmp, this.journalFile);
        this.fileSystem.delete(this.journalFileBackup);
        this.journalWriter = newJournalWriter();
        this.hasJournalErrors = false;
        this.mostRecentRebuildFailed = false;
    }

    public synchronized Snapshot get(String str) throws IOException {
        Snapshot snapshot;
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = this.lruEntries.get(str);
        if (entry == null || !entry.readable) {
            snapshot = null;
        } else {
            snapshot = entry.snapshot();
            if (snapshot == null) {
                snapshot = null;
            } else {
                this.redundantOpCount++;
                this.journalWriter.b(READ).i(32).b(str).i(10);
                if (journalRebuildRequired()) {
                    this.executor.execute(this.cleanupRunnable);
                }
            }
        }
        return snapshot;
    }

    public Editor edit(String str) throws IOException {
        return edit(str, -1L);
    }

    synchronized Editor edit(String str, long j) throws IOException {
        Editor editor;
        Entry entry;
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry2 = this.lruEntries.get(str);
        if (j != -1 && (entry2 == null || entry2.sequenceNumber != j)) {
            editor = null;
        } else if (entry2 != null && entry2.currentEditor != null) {
            editor = null;
        } else if (this.mostRecentTrimFailed || this.mostRecentRebuildFailed) {
            this.executor.execute(this.cleanupRunnable);
            editor = null;
        } else {
            this.journalWriter.b(DIRTY).i(32).b(str).i(10);
            this.journalWriter.flush();
            if (this.hasJournalErrors) {
                editor = null;
            } else {
                if (entry2 == null) {
                    Entry entry3 = new Entry(str);
                    this.lruEntries.put(str, entry3);
                    entry = entry3;
                } else {
                    entry = entry2;
                }
                editor = new Editor(entry);
                entry.currentEditor = editor;
            }
        }
        return editor;
    }

    public File getDirectory() {
        return this.directory;
    }

    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    public synchronized void setMaxSize(long j) {
        this.maxSize = j;
        if (this.initialized) {
            this.executor.execute(this.cleanupRunnable);
        }
    }

    public synchronized long size() throws IOException {
        initialize();
        return this.size;
    }

    synchronized void completeEdit(Editor editor, boolean z) throws IOException {
        synchronized (this) {
            Entry entry = editor.entry;
            if (entry.currentEditor != editor) {
                throw new IllegalStateException();
            }
            if (z && !entry.readable) {
                for (int i = 0; i < this.valueCount; i++) {
                    if (!editor.written[i]) {
                        editor.abort();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    } else if (!this.fileSystem.exists(entry.dirtyFiles[i])) {
                        editor.abort();
                        break;
                    }
                }
            }
            for (int i2 = 0; i2 < this.valueCount; i2++) {
                File file = entry.dirtyFiles[i2];
                if (z) {
                    if (this.fileSystem.exists(file)) {
                        File file2 = entry.cleanFiles[i2];
                        this.fileSystem.rename(file, file2);
                        long j = entry.lengths[i2];
                        long size = this.fileSystem.size(file2);
                        entry.lengths[i2] = size;
                        this.size = (this.size - j) + size;
                    }
                } else {
                    this.fileSystem.delete(file);
                }
            }
            this.redundantOpCount++;
            entry.currentEditor = null;
            if (entry.readable | z) {
                entry.readable = true;
                this.journalWriter.b(CLEAN).i(32);
                this.journalWriter.b(entry.key);
                entry.writeLengths(this.journalWriter);
                this.journalWriter.i(10);
                if (z) {
                    long j2 = this.nextSequenceNumber;
                    this.nextSequenceNumber = 1 + j2;
                    entry.sequenceNumber = j2;
                }
            } else {
                this.lruEntries.remove(entry.key);
                this.journalWriter.b(REMOVE).i(32);
                this.journalWriter.b(entry.key);
                this.journalWriter.i(10);
            }
            this.journalWriter.flush();
            if (this.size > this.maxSize || journalRebuildRequired()) {
                this.executor.execute(this.cleanupRunnable);
            }
        }
    }

    boolean journalRebuildRequired() {
        return this.redundantOpCount >= 2000 && this.redundantOpCount >= this.lruEntries.size();
    }

    public synchronized boolean remove(String str) throws IOException {
        boolean removeEntry;
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = this.lruEntries.get(str);
        if (entry == null) {
            removeEntry = false;
        } else {
            removeEntry = removeEntry(entry);
            if (removeEntry && this.size <= this.maxSize) {
                this.mostRecentTrimFailed = false;
            }
        }
        return removeEntry;
    }

    boolean removeEntry(Entry entry) throws IOException {
        if (entry.currentEditor != null) {
            entry.currentEditor.detach();
        }
        for (int i = 0; i < this.valueCount; i++) {
            this.fileSystem.delete(entry.cleanFiles[i]);
            this.size -= entry.lengths[i];
            entry.lengths[i] = 0;
        }
        this.redundantOpCount++;
        this.journalWriter.b(REMOVE).i(32).b(entry.key).i(10);
        this.lruEntries.remove(entry.key);
        if (journalRebuildRequired()) {
            this.executor.execute(this.cleanupRunnable);
            return true;
        }
        return true;
    }

    public synchronized boolean isClosed() {
        return this.closed;
    }

    private synchronized void checkNotClosed() {
        if (isClosed()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.initialized) {
            checkNotClosed();
            trimToSize();
            this.journalWriter.flush();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        Entry[] entryArr;
        if (!this.initialized || this.closed) {
            this.closed = true;
        } else {
            for (Entry entry : (Entry[]) this.lruEntries.values().toArray(new Entry[this.lruEntries.size()])) {
                if (entry.currentEditor != null) {
                    entry.currentEditor.abort();
                }
            }
            trimToSize();
            this.journalWriter.close();
            this.journalWriter = null;
            this.closed = true;
        }
    }

    void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            removeEntry(this.lruEntries.values().iterator().next());
        }
        this.mostRecentTrimFailed = false;
    }

    public void delete() throws IOException {
        close();
        this.fileSystem.deleteContents(this.directory);
    }

    public synchronized void evictAll() throws IOException {
        synchronized (this) {
            initialize();
            for (Entry entry : (Entry[]) this.lruEntries.values().toArray(new Entry[this.lruEntries.size()])) {
                removeEntry(entry);
            }
            this.mostRecentTrimFailed = false;
        }
    }

    private void validateKey(String str) {
        if (!LEGAL_KEY_PATTERN.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    public synchronized Iterator<Snapshot> snapshots() throws IOException {
        initialize();
        return new Iterator<Snapshot>() { // from class: okhttp3.internal.cache.DiskLruCache.3
            final Iterator<Entry> delegate;
            Snapshot nextSnapshot;
            Snapshot removeSnapshot;

            {
                this.delegate = new ArrayList(DiskLruCache.this.lruEntries.values()).iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                boolean z;
                if (this.nextSnapshot != null) {
                    return true;
                }
                synchronized (DiskLruCache.this) {
                    if (!DiskLruCache.this.closed) {
                        while (true) {
                            if (!this.delegate.hasNext()) {
                                z = false;
                                break;
                            }
                            Snapshot snapshot = this.delegate.next().snapshot();
                            if (snapshot != null) {
                                this.nextSnapshot = snapshot;
                                z = true;
                                break;
                            }
                        }
                    } else {
                        z = false;
                    }
                }
                return z;
            }

            @Override // java.util.Iterator
            public Snapshot next() {
                if (hasNext()) {
                    this.removeSnapshot = this.nextSnapshot;
                    this.nextSnapshot = null;
                    return this.removeSnapshot;
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                if (this.removeSnapshot == null) {
                    throw new IllegalStateException("remove() before next()");
                }
                try {
                    DiskLruCache.this.remove(this.removeSnapshot.key);
                } catch (IOException e) {
                } finally {
                    this.removeSnapshot = null;
                }
            }
        };
    }

    /* loaded from: classes2.dex */
    public final class Snapshot implements Closeable {
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final s[] sources;

        Snapshot(String str, long j, s[] sVarArr, long[] jArr) {
            this.key = str;
            this.sequenceNumber = j;
            this.sources = sVarArr;
            this.lengths = jArr;
        }

        public String key() {
            return this.key;
        }

        public Editor edit() throws IOException {
            return DiskLruCache.this.edit(this.key, this.sequenceNumber);
        }

        public s getSource(int i) {
            return this.sources[i];
        }

        public long getLength(int i) {
            return this.lengths[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (s sVar : this.sources) {
                Util.closeQuietly(sVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public final class Editor {
        private boolean done;
        final Entry entry;
        final boolean[] written;

        Editor(Entry entry) {
            this.entry = entry;
            this.written = entry.readable ? null : new boolean[DiskLruCache.this.valueCount];
        }

        void detach() {
            if (this.entry.currentEditor == this) {
                for (int i = 0; i < DiskLruCache.this.valueCount; i++) {
                    try {
                        DiskLruCache.this.fileSystem.delete(this.entry.dirtyFiles[i]);
                    } catch (IOException e) {
                    }
                }
                this.entry.currentEditor = null;
            }
        }

        public s newSource(int i) {
            s sVar = null;
            synchronized (DiskLruCache.this) {
                if (this.done) {
                    throw new IllegalStateException();
                }
                if (this.entry.readable && this.entry.currentEditor == this) {
                    try {
                        sVar = DiskLruCache.this.fileSystem.source(this.entry.cleanFiles[i]);
                    } catch (FileNotFoundException e) {
                    }
                }
                return sVar;
            }
        }

        public r newSink(int i) {
            r a2;
            synchronized (DiskLruCache.this) {
                if (this.done) {
                    throw new IllegalStateException();
                }
                if (this.entry.currentEditor != this) {
                    a2 = l.a();
                } else {
                    if (!this.entry.readable) {
                        this.written[i] = true;
                    }
                    try {
                        a2 = new FaultHidingSink(DiskLruCache.this.fileSystem.sink(this.entry.dirtyFiles[i])) { // from class: okhttp3.internal.cache.DiskLruCache.Editor.1
                            @Override // okhttp3.internal.cache.FaultHidingSink
                            protected void onException(IOException iOException) {
                                synchronized (DiskLruCache.this) {
                                    Editor.this.detach();
                                }
                            }
                        };
                    } catch (FileNotFoundException e) {
                        a2 = l.a();
                    }
                }
                return a2;
            }
        }

        public void commit() throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.done) {
                    throw new IllegalStateException();
                }
                if (this.entry.currentEditor == this) {
                    DiskLruCache.this.completeEdit(this, true);
                }
                this.done = true;
            }
        }

        public void abort() throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.done) {
                    throw new IllegalStateException();
                }
                if (this.entry.currentEditor == this) {
                    DiskLruCache.this.completeEdit(this, false);
                }
                this.done = true;
            }
        }

        public void abortUnlessCommitted() {
            synchronized (DiskLruCache.this) {
                if (!this.done && this.entry.currentEditor == this) {
                    try {
                        DiskLruCache.this.completeEdit(this, false);
                    } catch (IOException e) {
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class Entry {
        final File[] cleanFiles;
        Editor currentEditor;
        final File[] dirtyFiles;
        final String key;
        final long[] lengths;
        boolean readable;
        long sequenceNumber;

        Entry(String str) {
            this.key = str;
            this.lengths = new long[DiskLruCache.this.valueCount];
            this.cleanFiles = new File[DiskLruCache.this.valueCount];
            this.dirtyFiles = new File[DiskLruCache.this.valueCount];
            StringBuilder append = new StringBuilder(str).append('.');
            int length = append.length();
            for (int i = 0; i < DiskLruCache.this.valueCount; i++) {
                append.append(i);
                this.cleanFiles[i] = new File(DiskLruCache.this.directory, append.toString());
                append.append(".tmp");
                this.dirtyFiles[i] = new File(DiskLruCache.this.directory, append.toString());
                append.setLength(length);
            }
        }

        void setLengths(String[] strArr) throws IOException {
            if (strArr.length != DiskLruCache.this.valueCount) {
                throw invalidLengths(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.lengths[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException e) {
                    throw invalidLengths(strArr);
                }
            }
        }

        void writeLengths(d dVar) throws IOException {
            for (long j : this.lengths) {
                dVar.i(32).m(j);
            }
        }

        private IOException invalidLengths(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        Snapshot snapshot() {
            if (Thread.holdsLock(DiskLruCache.this)) {
                s[] sVarArr = new s[DiskLruCache.this.valueCount];
                long[] jArr = (long[]) this.lengths.clone();
                for (int i = 0; i < DiskLruCache.this.valueCount; i++) {
                    try {
                        sVarArr[i] = DiskLruCache.this.fileSystem.source(this.cleanFiles[i]);
                    } catch (FileNotFoundException e) {
                        for (int i2 = 0; i2 < DiskLruCache.this.valueCount && sVarArr[i2] != null; i2++) {
                            Util.closeQuietly(sVarArr[i2]);
                        }
                        try {
                            DiskLruCache.this.removeEntry(this);
                        } catch (IOException e2) {
                        }
                        return null;
                    }
                }
                return new Snapshot(this.key, this.sequenceNumber, sVarArr, jArr);
            }
            throw new AssertionError();
        }
    }
}

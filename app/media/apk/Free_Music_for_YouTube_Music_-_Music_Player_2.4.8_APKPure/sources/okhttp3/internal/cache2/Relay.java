package okhttp3.internal.cache2;

import c.c;
import c.f;
import c.s;
import c.t;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import okhttp3.internal.Util;
/* loaded from: classes2.dex */
final class Relay {
    private static final long FILE_HEADER_SIZE = 32;
    static final f PREFIX_CLEAN = f.a("OkHttp cache v1\n");
    static final f PREFIX_DIRTY = f.a("OkHttp DIRTY :(\n");
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    final long bufferMaxSize;
    boolean complete;
    RandomAccessFile file;
    private final f metadata;
    int sourceCount;
    s upstream;
    long upstreamPos;
    Thread upstreamReader;
    final c upstreamBuffer = new c();
    final c buffer = new c();

    private Relay(RandomAccessFile randomAccessFile, s sVar, long j, f fVar, long j2) {
        this.file = randomAccessFile;
        this.upstream = sVar;
        this.complete = sVar == null;
        this.upstreamPos = j;
        this.metadata = fVar;
        this.bufferMaxSize = j2;
    }

    public static Relay edit(File file, s sVar, f fVar, long j) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        Relay relay = new Relay(randomAccessFile, sVar, 0L, fVar, j);
        randomAccessFile.setLength(0L);
        relay.writeHeader(PREFIX_DIRTY, -1L, -1L);
        return relay;
    }

    public static Relay read(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        FileOperator fileOperator = new FileOperator(randomAccessFile.getChannel());
        c cVar = new c();
        fileOperator.read(0L, cVar, 32L);
        if (cVar.d(PREFIX_CLEAN.h()).equals(PREFIX_CLEAN)) {
            long l = cVar.l();
            long l2 = cVar.l();
            c cVar2 = new c();
            fileOperator.read(32 + l, cVar2, l2);
            return new Relay(randomAccessFile, null, l, cVar2.q(), 0L);
        }
        throw new IOException("unreadable cache file");
    }

    private void writeHeader(f fVar, long j, long j2) throws IOException {
        c cVar = new c();
        cVar.b(fVar);
        cVar.n(j);
        cVar.n(j2);
        if (cVar.a() != 32) {
            throw new IllegalArgumentException();
        }
        new FileOperator(this.file.getChannel()).write(0L, cVar, 32L);
    }

    private void writeMetadata(long j) throws IOException {
        c cVar = new c();
        cVar.b(this.metadata);
        new FileOperator(this.file.getChannel()).write(32 + j, cVar, this.metadata.h());
    }

    void commit(long j) throws IOException {
        writeMetadata(j);
        this.file.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j, this.metadata.h());
        this.file.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
        }
        Util.closeQuietly(this.upstream);
        this.upstream = null;
    }

    boolean isClosed() {
        return this.file == null;
    }

    public f metadata() {
        return this.metadata;
    }

    public s newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }

    /* loaded from: classes2.dex */
    class RelaySource implements s {
        private FileOperator fileOperator;
        private long sourcePos;
        private final t timeout = new t();

        RelaySource() {
            this.fileOperator = new FileOperator(Relay.this.file.getChannel());
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x003f, code lost:
            if (r0 != 2) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0041, code lost:
            r4 = java.lang.Math.min(r14, r8 - r12.sourcePos);
            r12.fileOperator.read(32 + r12.sourcePos, r13, r4);
            r12.sourcePos += r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0089, code lost:
            r10 = r12.this$0.upstream.read(r12.this$0.upstreamBuffer, r12.this$0.bufferMaxSize);
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x009d, code lost:
            if (r10 != (-1)) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x009f, code lost:
            r12.this$0.commit(r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00a4, code lost:
            r1 = r12.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00a8, code lost:
            monitor-enter(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00a9, code lost:
            r12.this$0.upstreamReader = null;
            r12.this$0.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00b3, code lost:
            monitor-exit(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00b9, code lost:
            r4 = java.lang.Math.min(r10, r14);
            r12.this$0.upstreamBuffer.a(r13, 0, r4);
            r12.sourcePos += r4;
            r12.fileOperator.write(32 + r8, r12.this$0.upstreamBuffer.clone(), r10);
            r1 = r12.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00df, code lost:
            monitor-enter(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00e0, code lost:
            r12.this$0.buffer.write(r12.this$0.upstreamBuffer, r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00f9, code lost:
            if (r12.this$0.buffer.a() <= r12.this$0.bufferMaxSize) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00fb, code lost:
            r12.this$0.buffer.h(r12.this$0.buffer.a() - r12.this$0.bufferMaxSize);
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x010f, code lost:
            r12.this$0.upstreamPos += r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0116, code lost:
            monitor-exit(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0117, code lost:
            r1 = r12.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x0119, code lost:
            monitor-enter(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x011a, code lost:
            r12.this$0.upstreamReader = null;
            r12.this$0.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x0124, code lost:
            monitor-exit(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x012d, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x0130, code lost:
            monitor-enter(r12.this$0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x0131, code lost:
            r12.this$0.upstreamReader = null;
            r12.this$0.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x013c, code lost:
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:?, code lost:
            return r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:?, code lost:
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:?, code lost:
            return r4;
         */
        @Override // c.s
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public long read(c.c r13, long r14) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 320
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache2.Relay.RelaySource.read(c.c, long):long");
        }

        @Override // c.s
        public t timeout() {
            return this.timeout;
        }

        @Override // c.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            RandomAccessFile randomAccessFile = null;
            if (this.fileOperator != null) {
                this.fileOperator = null;
                synchronized (Relay.this) {
                    Relay relay = Relay.this;
                    relay.sourceCount--;
                    if (Relay.this.sourceCount == 0) {
                        randomAccessFile = Relay.this.file;
                        Relay.this.file = null;
                    }
                }
                if (randomAccessFile != null) {
                    Util.closeQuietly(randomAccessFile);
                }
            }
        }
    }
}

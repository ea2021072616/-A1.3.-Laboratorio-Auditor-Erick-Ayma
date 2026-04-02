package com.acrcloud.rec.a;

import android.media.AudioRecord;
import android.support.graphics.drawable.PathInterpolatorCompat;
import com.acrcloud.rec.b.b.h;
import com.acrcloud.rec.b.b.j;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* compiled from: ACRCloudRecorder.java */
/* loaded from: classes.dex */
public class a {
    private static a g = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f317a = "ACRCloudRecorder";

    /* renamed from: b  reason: collision with root package name */
    private int f318b = 16000;

    /* renamed from: c  reason: collision with root package name */
    private int f319c = PathInterpolatorCompat.MAX_NUM_POINTS;
    private BlockingQueue<byte[]> d = new LinkedBlockingQueue();
    private C0013a e = null;
    private AudioRecord f = null;
    private com.acrcloud.rec.b.a h = null;
    private int i = 5;

    private a() {
    }

    public static a a() {
        return g;
    }

    public byte[] b() {
        try {
            return this.d.poll(200L, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
            return null;
        }
    }

    public boolean c() {
        return this.d.size() > 0;
    }

    public void a(int i) {
        this.f319c = i;
    }

    public boolean a(com.acrcloud.rec.b.a aVar) {
        for (int i = 0; i < this.i; i++) {
            try {
                h.b("ACRCloudRecorder", "Try get AudioRecord : " + i);
                if (this.f != null || e()) {
                    if (this.f.getRecordingState() != 3) {
                        this.f.startRecording();
                    }
                    if (this.f.getRecordingState() == 3) {
                        break;
                    }
                    h.a("ACRCloudRecorder", "Start record error!");
                    f();
                }
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
        }
        if (this.f == null) {
            return false;
        }
        if (this.e == null) {
            this.e = new C0013a();
            this.e.start();
        }
        this.h = aVar;
        return true;
    }

    public void d() {
        try {
            if (this.e != null) {
                this.e.a();
                this.e = null;
                this.d.clear();
            }
            if (this.f != null && this.f.getRecordingState() == 3) {
                this.f.stop();
            }
            f();
            this.h = null;
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public boolean e() {
        try {
            int minBufferSize = AudioRecord.getMinBufferSize(8000, 16, 2);
            if (minBufferSize > 0) {
                this.f318b = minBufferSize * 5;
            }
            this.f = new AudioRecord(1, 8000, 16, 2, this.f318b);
            if (this.f.getState() != 1) {
                f();
                return false;
            }
            return true;
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
            this.f = null;
            return false;
        }
    }

    public void f() {
        try {
            if (this.f != null) {
                this.f.release();
                this.f = null;
                h.a("ACRCloudRecorder", "releaseAutoRecord");
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    /* compiled from: ACRCloudRecorder.java */
    /* renamed from: com.acrcloud.rec.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0013a extends Thread {

        /* renamed from: b  reason: collision with root package name */
        private volatile boolean f321b = false;

        C0013a() {
        }

        public void a() {
            this.f321b = false;
        }

        public void a(byte[] bArr) {
            try {
                if (a.this.d.size() >= (((a.this.f319c * 8000) * 2) / 1000) / 1600) {
                    a.this.d.poll();
                }
                double a2 = j.a(bArr, bArr.length);
                if (a.this.h != null) {
                    a.this.h.a(a2);
                }
                a.this.d.put(bArr);
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
            r7.f321b = false;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r7 = this;
                r3 = 5
                r1 = 0
                r0 = 1
                r7.f321b = r0     // Catch: java.lang.Exception -> L3a
                r2 = r3
            L6:
                boolean r0 = r7.f321b     // Catch: java.lang.Exception -> L3a
                if (r0 == 0) goto L2e
                r0 = 1600(0x640, float:2.242E-42)
                byte[] r4 = new byte[r0]     // Catch: java.lang.Exception -> L3a
                com.acrcloud.rec.a.a r0 = com.acrcloud.rec.a.a.this     // Catch: java.lang.Exception -> L3a
                android.media.AudioRecord r0 = com.acrcloud.rec.a.a.d(r0)     // Catch: java.lang.Exception -> L3a
                if (r0 == 0) goto L41
                com.acrcloud.rec.a.a r0 = com.acrcloud.rec.a.a.this     // Catch: java.lang.Exception -> L3a
                android.media.AudioRecord r0 = com.acrcloud.rec.a.a.d(r0)     // Catch: java.lang.Exception -> L3a
                r5 = 0
                r6 = 1600(0x640, float:2.242E-42)
                int r0 = r0.read(r4, r5, r6)     // Catch: java.lang.Exception -> L3a
            L23:
                if (r0 > 0) goto L35
                if (r2 <= 0) goto L2b
                int r0 = r2 + (-1)
                r2 = r0
                goto L6
            L2b:
                r0 = 0
                r7.f321b = r0     // Catch: java.lang.Exception -> L3a
            L2e:
                com.acrcloud.rec.a.a r0 = com.acrcloud.rec.a.a.this
                r1 = 0
                com.acrcloud.rec.a.a.a(r0, r1)
                return
            L35:
                r7.a(r4)     // Catch: java.lang.Exception -> L3a
                r2 = r3
                goto L6
            L3a:
                r0 = move-exception
                com.google.devtools.build.android.desugar.runtime.ThrowableExtension.printStackTrace(r0)
                r7.f321b = r1
                goto L2e
            L41:
                r0 = r1
                goto L23
            */
            throw new UnsupportedOperationException("Method not decompiled: com.acrcloud.rec.a.a.C0013a.run():void");
        }
    }
}

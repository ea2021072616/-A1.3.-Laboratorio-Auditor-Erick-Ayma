package a;

import java.io.Closeable;
/* compiled from: CancellationTokenRegistration.java */
/* loaded from: classes.dex */
public class f implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final Object f14a;

    /* renamed from: b  reason: collision with root package name */
    private g f15b;

    /* renamed from: c  reason: collision with root package name */
    private Runnable f16c;
    private boolean d;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f14a) {
            if (!this.d) {
                this.d = true;
                this.f15b.a(this);
                this.f15b = null;
                this.f16c = null;
            }
        }
    }
}

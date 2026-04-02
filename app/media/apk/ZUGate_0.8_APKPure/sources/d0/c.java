package d0;

import android.os.CancellationSignal;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2498a;

    /* renamed from: b  reason: collision with root package name */
    public b f2499b;

    /* renamed from: c  reason: collision with root package name */
    public CancellationSignal f2500c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2501d;

    public final void a() {
        synchronized (this) {
            if (this.f2498a) {
                return;
            }
            this.f2498a = true;
            this.f2501d = true;
            b bVar = this.f2499b;
            CancellationSignal cancellationSignal = this.f2500c;
            if (bVar != null) {
                try {
                    bVar.c();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f2501d = false;
                        notifyAll();
                        throw th;
                    }
                }
            }
            if (cancellationSignal != null) {
                cancellationSignal.cancel();
            }
            synchronized (this) {
                this.f2501d = false;
                notifyAll();
            }
        }
    }

    public final void b(b bVar) {
        synchronized (this) {
            while (this.f2501d) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                }
            }
            if (this.f2499b == bVar) {
                return;
            }
            this.f2499b = bVar;
            if (this.f2498a) {
                bVar.c();
            }
        }
    }
}

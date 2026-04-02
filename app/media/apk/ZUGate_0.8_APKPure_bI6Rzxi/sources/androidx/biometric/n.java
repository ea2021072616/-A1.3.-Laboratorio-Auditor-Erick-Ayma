package androidx.biometric;

import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class n implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f627b;

    /* renamed from: c  reason: collision with root package name */
    public final WeakReference f628c;

    public n(o oVar) {
        this.f627b = 0;
        this.f628c = new WeakReference(oVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        WeakReference weakReference = this.f628c;
        switch (this.f627b) {
            case 0:
                if (weakReference.get() != null) {
                    ((o) weakReference.get()).q();
                    return;
                }
                return;
            case 1:
                if (weakReference.get() != null) {
                    ((x) weakReference.get()).o = false;
                    return;
                }
                return;
            default:
                if (weakReference.get() != null) {
                    ((x) weakReference.get()).f657p = false;
                    return;
                }
                return;
        }
    }

    public n(x xVar, int i5) {
        this.f627b = i5;
        if (i5 != 2) {
            this.f628c = new WeakReference(xVar);
        } else {
            this.f628c = new WeakReference(xVar);
        }
    }
}

package androidx.biometric;

import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class v extends d {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference f643a;

    public v(x xVar) {
        this.f643a = new WeakReference(xVar);
    }

    @Override // androidx.biometric.d
    public final void a(int i5, CharSequence charSequence) {
        WeakReference weakReference = this.f643a;
        if (weakReference.get() == null || ((x) weakReference.get()).f656n || !((x) weakReference.get()).f655m) {
            return;
        }
        ((x) weakReference.get()).e(new e(i5, charSequence));
    }

    @Override // androidx.biometric.d
    public final void b() {
        WeakReference weakReference = this.f643a;
        if (weakReference.get() == null || !((x) weakReference.get()).f655m) {
            return;
        }
        x xVar = (x) weakReference.get();
        if (xVar.f661t == null) {
            xVar.f661t = new androidx.lifecycle.a0();
        }
        x.i(xVar.f661t, Boolean.TRUE);
    }

    @Override // androidx.biometric.d
    public final void c(s sVar) {
        WeakReference weakReference = this.f643a;
        if (weakReference.get() == null || !((x) weakReference.get()).f655m) {
            return;
        }
        int i5 = -1;
        if (sVar.f635b == -1) {
            int c5 = ((x) weakReference.get()).c();
            if (((c5 & 32767) != 0) && !m0.a.q(c5)) {
                i5 = 2;
            }
            sVar = new s(sVar.f634a, i5);
        }
        x xVar = (x) weakReference.get();
        if (xVar.f658q == null) {
            xVar.f658q = new androidx.lifecycle.a0();
        }
        x.i(xVar.f658q, sVar);
    }
}

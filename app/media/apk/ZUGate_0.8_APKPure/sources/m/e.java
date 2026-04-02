package m;

import com.google.android.gms.internal.play_billing.i0;
/* loaded from: classes.dex */
public final class e extends i0 {
    public e() {
        super(0);
    }

    @Override // com.google.android.gms.internal.play_billing.i0
    public final void K(f fVar, f fVar2) {
        fVar.f3917b = fVar2;
    }

    @Override // com.google.android.gms.internal.play_billing.i0
    public final void L(f fVar, Thread thread) {
        fVar.f3916a = thread;
    }

    @Override // com.google.android.gms.internal.play_billing.i0
    public final boolean d(g gVar, c cVar) {
        c cVar2 = c.f3909b;
        synchronized (gVar) {
            if (gVar.f3923c == cVar) {
                gVar.f3923c = cVar2;
                return true;
            }
            return false;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.i0
    public final boolean e(g gVar, Object obj, Object obj2) {
        synchronized (gVar) {
            if (gVar.f3922b == obj) {
                gVar.f3922b = obj2;
                return true;
            }
            return false;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.i0
    public final boolean f(g gVar, f fVar, f fVar2) {
        synchronized (gVar) {
            if (gVar.f3924d == fVar) {
                gVar.f3924d = fVar2;
                return true;
            }
            return false;
        }
    }
}

package androidx.biometric;
/* loaded from: classes.dex */
public final class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f621b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ o f622c;

    public /* synthetic */ g(o oVar, int i5) {
        this.f621b = i5;
        this.f622c = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5 = this.f621b;
        o oVar = this.f622c;
        switch (i5) {
            case 0:
                x xVar = oVar.f630h;
                if (xVar.f646d == null) {
                    xVar.f646d = new u();
                }
                xVar.f646d.getClass();
                return;
            default:
                oVar.f630h.f663v = false;
                return;
        }
    }
}

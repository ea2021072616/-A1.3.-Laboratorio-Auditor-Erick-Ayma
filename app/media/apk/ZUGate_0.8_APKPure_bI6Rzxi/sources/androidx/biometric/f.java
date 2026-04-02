package androidx.biometric;
/* loaded from: classes.dex */
public final class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f617b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f618c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CharSequence f619d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ o f620e;

    public /* synthetic */ f(o oVar, int i5, CharSequence charSequence, int i6) {
        this.f617b = i6;
        this.f620e = oVar;
        this.f618c = i5;
        this.f619d = charSequence;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5 = this.f617b;
        int i6 = this.f618c;
        o oVar = this.f620e;
        switch (i5) {
            case 0:
                x xVar = oVar.f630h;
                if (xVar.f646d == null) {
                    xVar.f646d = new u();
                }
                xVar.f646d.J(i6);
                return;
            default:
                oVar.m(i6, this.f619d);
                return;
        }
    }
}

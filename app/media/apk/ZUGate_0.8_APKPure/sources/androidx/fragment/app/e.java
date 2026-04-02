package androidx.fragment.app;
/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f863b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f864c;

    public /* synthetic */ e(int i5, Object obj) {
        this.f863b = i5;
        this.f864c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5 = this.f863b;
        Object obj = this.f864c;
        switch (i5) {
            case 0:
                f fVar = (f) obj;
                fVar.f872b.endViewTransition(fVar.f873c);
                fVar.f874d.a();
                return;
            case 1:
                r rVar = (r) obj;
                rVar.f981j.onDismiss(rVar.f988r);
                return;
            default:
                ((w0) obj).x(true);
                return;
        }
    }
}

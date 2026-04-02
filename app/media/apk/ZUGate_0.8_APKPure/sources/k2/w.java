package k2;
/* loaded from: classes.dex */
public final class w implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f3626b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f3627c;

    public /* synthetic */ w(int i5, Object obj) {
        this.f3626b = i5;
        this.f3627c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5 = this.f3626b;
        Object obj = this.f3627c;
        switch (i5) {
            case 0:
                ((x) obj).f3635g.b(new i2.a(4));
                return;
            case 1:
                ((o) obj).h();
                return;
            default:
                l2.f fVar = ((n) obj).f3596a.f3598b;
                fVar.d(fVar.getClass().getName().concat(" disconnecting because it was signed out."));
                return;
        }
    }
}

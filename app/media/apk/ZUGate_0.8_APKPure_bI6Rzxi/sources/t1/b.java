package t1;
/* loaded from: classes.dex */
public final class b extends d {

    /* renamed from: d  reason: collision with root package name */
    public static final e f4984d;

    /* renamed from: b  reason: collision with root package name */
    public double f4985b = 0.0d;

    /* renamed from: c  reason: collision with root package name */
    public double f4986c = 0.0d;

    static {
        e a5 = e.a(64, new b());
        f4984d = a5;
        a5.f4997f = 0.5f;
    }

    public static b b(double d5, double d6) {
        b bVar = (b) f4984d.b();
        bVar.f4985b = d5;
        bVar.f4986c = d6;
        return bVar;
    }

    public static void c(b bVar) {
        f4984d.c(bVar);
    }

    @Override // t1.d
    public final d a() {
        return new b();
    }

    public final String toString() {
        return "MPPointD, x: " + this.f4985b + ", y: " + this.f4986c;
    }
}

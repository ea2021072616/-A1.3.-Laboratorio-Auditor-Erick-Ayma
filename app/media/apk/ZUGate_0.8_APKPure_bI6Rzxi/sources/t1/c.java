package t1;
/* loaded from: classes.dex */
public final class c extends d {

    /* renamed from: d  reason: collision with root package name */
    public static final e f4987d;

    /* renamed from: b  reason: collision with root package name */
    public float f4988b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    public float f4989c = 0.0f;

    static {
        e a5 = e.a(32, new c(0));
        f4987d = a5;
        a5.f4997f = 0.5f;
    }

    public c(int i5) {
    }

    public static c b(float f5, float f6) {
        c cVar = (c) f4987d.b();
        cVar.f4988b = f5;
        cVar.f4989c = f6;
        return cVar;
    }

    @Override // t1.d
    public final d a() {
        return new c(0);
    }
}

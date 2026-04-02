package t1;
/* loaded from: classes.dex */
public final class e {

    /* renamed from: g  reason: collision with root package name */
    public static int f4991g;

    /* renamed from: a  reason: collision with root package name */
    public int f4992a;

    /* renamed from: b  reason: collision with root package name */
    public int f4993b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f4994c;

    /* renamed from: d  reason: collision with root package name */
    public int f4995d;

    /* renamed from: e  reason: collision with root package name */
    public final d f4996e;

    /* renamed from: f  reason: collision with root package name */
    public float f4997f;

    public e(int i5, d dVar) {
        if (i5 <= 0) {
            throw new IllegalArgumentException("Object Pool must be instantiated with a capacity greater than 0!");
        }
        this.f4993b = i5;
        this.f4994c = new Object[i5];
        this.f4995d = 0;
        this.f4996e = dVar;
        this.f4997f = 1.0f;
        d();
    }

    public static synchronized e a(int i5, d dVar) {
        e eVar;
        synchronized (e.class) {
            eVar = new e(i5, dVar);
            int i6 = f4991g;
            eVar.f4992a = i6;
            f4991g = i6 + 1;
        }
        return eVar;
    }

    public final synchronized d b() {
        d dVar;
        if (this.f4995d == -1 && this.f4997f > 0.0f) {
            d();
        }
        Object[] objArr = this.f4994c;
        int i5 = this.f4995d;
        dVar = (d) objArr[i5];
        dVar.f4990a = -1;
        this.f4995d = i5 - 1;
        return dVar;
    }

    public final synchronized void c(d dVar) {
        int i5 = dVar.f4990a;
        if (i5 != -1) {
            if (i5 == this.f4992a) {
                throw new IllegalArgumentException("The object passed is already stored in this pool!");
            }
            throw new IllegalArgumentException("The object to recycle already belongs to poolId " + dVar.f4990a + ".  Object cannot belong to two different pool instances simultaneously!");
        }
        int i6 = this.f4995d + 1;
        this.f4995d = i6;
        if (i6 >= this.f4994c.length) {
            int i7 = this.f4993b;
            int i8 = i7 * 2;
            this.f4993b = i8;
            Object[] objArr = new Object[i8];
            for (int i9 = 0; i9 < i7; i9++) {
                objArr[i9] = this.f4994c[i9];
            }
            this.f4994c = objArr;
        }
        dVar.f4990a = this.f4992a;
        this.f4994c[this.f4995d] = dVar;
    }

    public final void d() {
        float f5 = this.f4997f;
        int i5 = this.f4993b;
        int i6 = (int) (i5 * f5);
        if (i6 < 1) {
            i5 = 1;
        } else if (i6 <= i5) {
            i5 = i6;
        }
        for (int i7 = 0; i7 < i5; i7++) {
            this.f4994c[i7] = this.f4996e.a();
        }
        this.f4995d = i5 - 1;
    }
}

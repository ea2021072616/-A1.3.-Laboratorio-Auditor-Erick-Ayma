package t1;
/* loaded from: classes.dex */
public final class a extends d {

    /* renamed from: d  reason: collision with root package name */
    public static final e f4981d;

    /* renamed from: b  reason: collision with root package name */
    public float f4982b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    public float f4983c = 0.0f;

    static {
        e a5 = e.a(256, new a());
        f4981d = a5;
        a5.f4997f = 0.5f;
    }

    public static a b(float f5, float f6) {
        a aVar = (a) f4981d.b();
        aVar.f4982b = f5;
        aVar.f4983c = f6;
        return aVar;
    }

    @Override // t1.d
    public final d a() {
        return new a();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f4982b == aVar.f4982b && this.f4983c == aVar.f4983c;
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.f4982b) ^ Float.floatToIntBits(this.f4983c);
    }

    public final String toString() {
        return this.f4982b + "x" + this.f4983c;
    }
}

package n0;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public int f4045a;

    /* renamed from: b  reason: collision with root package name */
    public int f4046b;

    /* renamed from: c  reason: collision with root package name */
    public float f4047c;

    /* renamed from: d  reason: collision with root package name */
    public float f4048d;

    /* renamed from: h  reason: collision with root package name */
    public float f4052h;

    /* renamed from: i  reason: collision with root package name */
    public int f4053i;

    /* renamed from: e  reason: collision with root package name */
    public long f4049e = Long.MIN_VALUE;

    /* renamed from: g  reason: collision with root package name */
    public long f4051g = -1;

    /* renamed from: f  reason: collision with root package name */
    public long f4050f = 0;

    public final float a(long j5) {
        long j6 = this.f4049e;
        if (j5 < j6) {
            return 0.0f;
        }
        long j7 = this.f4051g;
        if (j7 < 0 || j5 < j7) {
            return g.b(((float) (j5 - j6)) / this.f4045a, 0.0f, 1.0f) * 0.5f;
        }
        float f5 = this.f4052h;
        return (g.b(((float) (j5 - j7)) / this.f4053i, 0.0f, 1.0f) * f5) + (1.0f - f5);
    }
}

package d;
/* loaded from: classes.dex */
public final class y0 {

    /* renamed from: d  reason: collision with root package name */
    public static y0 f2490d;

    /* renamed from: a  reason: collision with root package name */
    public long f2491a;

    /* renamed from: b  reason: collision with root package name */
    public long f2492b;

    /* renamed from: c  reason: collision with root package name */
    public int f2493c;

    public final void a(long j5, double d5, double d6) {
        float f5;
        float f6;
        double d7;
        double d8 = (0.01720197f * (((float) (j5 - 946728000000L)) / 8.64E7f)) + 6.24006f;
        double sin = (Math.sin(f6 * 3.0f) * 5.236000106378924E-6d) + (Math.sin(2.0f * f6) * 3.4906598739326E-4d) + (Math.sin(d8) * 0.03341960161924362d) + d8 + 1.796593063d + 3.141592653589793d;
        double sin2 = (Math.sin(2.0d * sin) * (-0.0069d)) + (Math.sin(d8) * 0.0053d) + ((float) Math.round((f5 - 9.0E-4f) - d7)) + 9.0E-4f + ((-d6) / 360.0d);
        double asin = Math.asin(Math.sin(0.4092797040939331d) * Math.sin(sin));
        double d9 = 0.01745329238474369d * d5;
        double sin3 = (Math.sin(-0.10471975803375244d) - (Math.sin(asin) * Math.sin(d9))) / (Math.cos(asin) * Math.cos(d9));
        if (sin3 >= 1.0d) {
            this.f2493c = 1;
            this.f2491a = -1L;
            this.f2492b = -1L;
        } else if (sin3 <= -1.0d) {
            this.f2493c = 0;
            this.f2491a = -1L;
            this.f2492b = -1L;
        } else {
            double acos = (float) (Math.acos(sin3) / 6.283185307179586d);
            this.f2491a = Math.round((sin2 + acos) * 8.64E7d) + 946728000000L;
            long round = Math.round((sin2 - acos) * 8.64E7d) + 946728000000L;
            this.f2492b = round;
            if (round >= j5 || this.f2491a <= j5) {
                this.f2493c = 1;
            } else {
                this.f2493c = 0;
            }
        }
    }
}

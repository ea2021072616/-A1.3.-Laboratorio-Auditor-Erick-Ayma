package l1;

import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class a extends b {

    /* renamed from: f  reason: collision with root package name */
    public n1.d f3710f;

    /* renamed from: m  reason: collision with root package name */
    public int f3717m;

    /* renamed from: n  reason: collision with root package name */
    public int f3718n;

    /* renamed from: v  reason: collision with root package name */
    public final ArrayList f3725v;

    /* renamed from: g  reason: collision with root package name */
    public final int f3711g = -7829368;

    /* renamed from: h  reason: collision with root package name */
    public final float f3712h = 1.0f;

    /* renamed from: i  reason: collision with root package name */
    public final int f3713i = -7829368;

    /* renamed from: j  reason: collision with root package name */
    public final float f3714j = 1.0f;

    /* renamed from: k  reason: collision with root package name */
    public float[] f3715k = new float[0];

    /* renamed from: l  reason: collision with root package name */
    public float[] f3716l = new float[0];
    public final int o = 6;

    /* renamed from: p  reason: collision with root package name */
    public float f3719p = 1.0f;

    /* renamed from: q  reason: collision with root package name */
    public boolean f3720q = false;

    /* renamed from: r  reason: collision with root package name */
    public boolean f3721r = true;

    /* renamed from: s  reason: collision with root package name */
    public final boolean f3722s = true;

    /* renamed from: t  reason: collision with root package name */
    public final boolean f3723t = true;

    /* renamed from: u  reason: collision with root package name */
    public boolean f3724u = false;

    /* renamed from: w  reason: collision with root package name */
    public final boolean f3726w = true;

    /* renamed from: x  reason: collision with root package name */
    public float f3727x = 0.0f;

    /* renamed from: y  reason: collision with root package name */
    public float f3728y = 0.0f;

    /* renamed from: z  reason: collision with root package name */
    public boolean f3729z = false;
    public float A = 0.0f;
    public float B = 0.0f;
    public float C = 0.0f;

    public a() {
        this.f3733d = t1.g.c(10.0f);
        this.f3731b = t1.g.c(5.0f);
        this.f3732c = t1.g.c(5.0f);
        this.f3725v = new ArrayList();
    }

    public void a(float f5, float f6) {
        float f7 = this.f3729z ? this.B : f5 - this.f3727x;
        float f8 = f6 + this.f3728y;
        if (Math.abs(f8 - f7) == 0.0f) {
            f8 += 1.0f;
            f7 -= 1.0f;
        }
        this.B = f7;
        this.A = f8;
        this.C = Math.abs(f8 - f7);
    }

    public final String b() {
        String str;
        int i5 = 0;
        String str2 = "";
        while (true) {
            float[] fArr = this.f3715k;
            if (i5 >= fArr.length) {
                return str2;
            }
            if (i5 < 0 || i5 >= fArr.length) {
                str = "";
            } else {
                n1.d dVar = this.f3710f;
                if (dVar == null || ((dVar instanceof n1.a) && ((n1.a) dVar).f4079b != this.f3718n)) {
                    this.f3710f = new n1.a(this.f3718n);
                }
                str = this.f3710f.a(this.f3715k[i5]);
            }
            if (str != null && str2.length() < str.length()) {
                str2 = str;
            }
            i5++;
        }
    }
}

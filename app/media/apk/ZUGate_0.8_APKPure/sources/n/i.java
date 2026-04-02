package n;

import java.util.Arrays;
/* loaded from: classes.dex */
public final class i implements Comparable {

    /* renamed from: b  reason: collision with root package name */
    public boolean f4033b;

    /* renamed from: f  reason: collision with root package name */
    public float f4037f;

    /* renamed from: m  reason: collision with root package name */
    public int f4044m;

    /* renamed from: c  reason: collision with root package name */
    public int f4034c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f4035d = -1;

    /* renamed from: e  reason: collision with root package name */
    public int f4036e = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4038g = false;

    /* renamed from: h  reason: collision with root package name */
    public final float[] f4039h = new float[9];

    /* renamed from: i  reason: collision with root package name */
    public final float[] f4040i = new float[9];

    /* renamed from: j  reason: collision with root package name */
    public c[] f4041j = new c[16];

    /* renamed from: k  reason: collision with root package name */
    public int f4042k = 0;

    /* renamed from: l  reason: collision with root package name */
    public int f4043l = 0;

    public i(int i5) {
        this.f4044m = i5;
    }

    public final void a(c cVar) {
        int i5 = 0;
        while (true) {
            int i6 = this.f4042k;
            if (i5 >= i6) {
                c[] cVarArr = this.f4041j;
                if (i6 >= cVarArr.length) {
                    this.f4041j = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
                }
                c[] cVarArr2 = this.f4041j;
                int i7 = this.f4042k;
                cVarArr2[i7] = cVar;
                this.f4042k = i7 + 1;
                return;
            } else if (this.f4041j[i5] == cVar) {
                return;
            } else {
                i5++;
            }
        }
    }

    public final void b(c cVar) {
        int i5 = this.f4042k;
        int i6 = 0;
        while (i6 < i5) {
            if (this.f4041j[i6] == cVar) {
                while (i6 < i5 - 1) {
                    c[] cVarArr = this.f4041j;
                    int i7 = i6 + 1;
                    cVarArr[i6] = cVarArr[i7];
                    i6 = i7;
                }
                this.f4042k--;
                return;
            }
            i6++;
        }
    }

    public final void c() {
        this.f4044m = 5;
        this.f4036e = 0;
        this.f4034c = -1;
        this.f4035d = -1;
        this.f4037f = 0.0f;
        this.f4038g = false;
        int i5 = this.f4042k;
        for (int i6 = 0; i6 < i5; i6++) {
            this.f4041j[i6] = null;
        }
        this.f4042k = 0;
        this.f4043l = 0;
        this.f4033b = false;
        Arrays.fill(this.f4040i, 0.0f);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f4034c - ((i) obj).f4034c;
    }

    public final void d(d dVar, float f5) {
        this.f4037f = f5;
        this.f4038g = true;
        int i5 = this.f4042k;
        this.f4035d = -1;
        for (int i6 = 0; i6 < i5; i6++) {
            this.f4041j[i6].h(dVar, this, false);
        }
        this.f4042k = 0;
    }

    public final void e(d dVar, c cVar) {
        int i5 = this.f4042k;
        for (int i6 = 0; i6 < i5; i6++) {
            this.f4041j[i6].i(dVar, cVar, false);
        }
        this.f4042k = 0;
    }

    public final String toString() {
        return "" + this.f4034c;
    }
}

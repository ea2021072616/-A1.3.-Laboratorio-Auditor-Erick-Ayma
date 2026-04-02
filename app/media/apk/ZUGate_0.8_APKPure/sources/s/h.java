package s;

import java.util.Arrays;
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public int[] f4700a = new int[10];

    /* renamed from: b  reason: collision with root package name */
    public int[] f4701b = new int[10];

    /* renamed from: c  reason: collision with root package name */
    public int f4702c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int[] f4703d = new int[10];

    /* renamed from: e  reason: collision with root package name */
    public float[] f4704e = new float[10];

    /* renamed from: f  reason: collision with root package name */
    public int f4705f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int[] f4706g = new int[5];

    /* renamed from: h  reason: collision with root package name */
    public String[] f4707h = new String[5];

    /* renamed from: i  reason: collision with root package name */
    public int f4708i = 0;

    /* renamed from: j  reason: collision with root package name */
    public int[] f4709j = new int[4];

    /* renamed from: k  reason: collision with root package name */
    public boolean[] f4710k = new boolean[4];

    /* renamed from: l  reason: collision with root package name */
    public int f4711l = 0;

    public final void a(int i5, float f5) {
        int i6 = this.f4705f;
        int[] iArr = this.f4703d;
        if (i6 >= iArr.length) {
            this.f4703d = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f4704e;
            this.f4704e = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f4703d;
        int i7 = this.f4705f;
        iArr2[i7] = i5;
        float[] fArr2 = this.f4704e;
        this.f4705f = i7 + 1;
        fArr2[i7] = f5;
    }

    public final void b(int i5, int i6) {
        int i7 = this.f4702c;
        int[] iArr = this.f4700a;
        if (i7 >= iArr.length) {
            this.f4700a = Arrays.copyOf(iArr, iArr.length * 2);
            int[] iArr2 = this.f4701b;
            this.f4701b = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f4700a;
        int i8 = this.f4702c;
        iArr3[i8] = i5;
        int[] iArr4 = this.f4701b;
        this.f4702c = i8 + 1;
        iArr4[i8] = i6;
    }

    public final void c(int i5, String str) {
        int i6 = this.f4708i;
        int[] iArr = this.f4706g;
        if (i6 >= iArr.length) {
            this.f4706g = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f4707h;
            this.f4707h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
        }
        int[] iArr2 = this.f4706g;
        int i7 = this.f4708i;
        iArr2[i7] = i5;
        String[] strArr2 = this.f4707h;
        this.f4708i = i7 + 1;
        strArr2[i7] = str;
    }

    public final void d(int i5, boolean z4) {
        int i6 = this.f4711l;
        int[] iArr = this.f4709j;
        if (i6 >= iArr.length) {
            this.f4709j = Arrays.copyOf(iArr, iArr.length * 2);
            boolean[] zArr = this.f4710k;
            this.f4710k = Arrays.copyOf(zArr, zArr.length * 2);
        }
        int[] iArr2 = this.f4709j;
        int i7 = this.f4711l;
        iArr2[i7] = i5;
        boolean[] zArr2 = this.f4710k;
        this.f4711l = i7 + 1;
        zArr2[i7] = z4;
    }
}

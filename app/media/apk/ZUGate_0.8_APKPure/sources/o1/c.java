package o1;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final float f4094a;

    /* renamed from: b  reason: collision with root package name */
    public final float f4095b;

    /* renamed from: c  reason: collision with root package name */
    public final float f4096c;

    /* renamed from: d  reason: collision with root package name */
    public final float f4097d;

    /* renamed from: e  reason: collision with root package name */
    public final int f4098e;

    /* renamed from: f  reason: collision with root package name */
    public final int f4099f;

    /* renamed from: g  reason: collision with root package name */
    public final int f4100g;

    public c(float f5, float f6, float f7, float f8, int i5, int i6) {
        this.f4094a = Float.NaN;
        this.f4095b = Float.NaN;
        this.f4099f = -1;
        this.f4094a = f5;
        this.f4095b = f6;
        this.f4096c = f7;
        this.f4097d = f8;
        this.f4098e = i5;
        this.f4100g = i6;
    }

    public final boolean a(c cVar) {
        return cVar != null && this.f4098e == cVar.f4098e && this.f4094a == cVar.f4094a && this.f4099f == cVar.f4099f;
    }

    public final String toString() {
        return "Highlight, x: " + this.f4094a + ", y: " + this.f4095b + ", dataSetIndex: " + this.f4098e + ", stackIndex (only stacked barentry): " + this.f4099f;
    }

    public c(float f5, float f6, float f7, float f8, int i5, int i6, int i7) {
        this(f5, f6, f7, f8, i5, i6);
        this.f4099f = -1;
    }
}

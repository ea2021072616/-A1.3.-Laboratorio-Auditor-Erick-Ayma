package f1;

import android.graphics.Paint;
/* loaded from: classes.dex */
public final class g extends j {

    /* renamed from: e  reason: collision with root package name */
    public y.c f2755e;

    /* renamed from: f  reason: collision with root package name */
    public float f2756f;

    /* renamed from: g  reason: collision with root package name */
    public y.c f2757g;

    /* renamed from: h  reason: collision with root package name */
    public float f2758h;

    /* renamed from: i  reason: collision with root package name */
    public float f2759i;

    /* renamed from: j  reason: collision with root package name */
    public float f2760j;

    /* renamed from: k  reason: collision with root package name */
    public float f2761k;

    /* renamed from: l  reason: collision with root package name */
    public float f2762l;

    /* renamed from: m  reason: collision with root package name */
    public Paint.Cap f2763m;

    /* renamed from: n  reason: collision with root package name */
    public Paint.Join f2764n;
    public float o;

    public g() {
        this.f2756f = 0.0f;
        this.f2758h = 1.0f;
        this.f2759i = 1.0f;
        this.f2760j = 0.0f;
        this.f2761k = 1.0f;
        this.f2762l = 0.0f;
        this.f2763m = Paint.Cap.BUTT;
        this.f2764n = Paint.Join.MITER;
        this.o = 4.0f;
    }

    @Override // f1.i
    public final boolean a() {
        return this.f2757g.b() || this.f2755e.b();
    }

    @Override // f1.i
    public final boolean b(int[] iArr) {
        return this.f2755e.c(iArr) | this.f2757g.c(iArr);
    }

    public float getFillAlpha() {
        return this.f2759i;
    }

    public int getFillColor() {
        return this.f2757g.f5543a;
    }

    public float getStrokeAlpha() {
        return this.f2758h;
    }

    public int getStrokeColor() {
        return this.f2755e.f5543a;
    }

    public float getStrokeWidth() {
        return this.f2756f;
    }

    public float getTrimPathEnd() {
        return this.f2761k;
    }

    public float getTrimPathOffset() {
        return this.f2762l;
    }

    public float getTrimPathStart() {
        return this.f2760j;
    }

    public void setFillAlpha(float f5) {
        this.f2759i = f5;
    }

    public void setFillColor(int i5) {
        this.f2757g.f5543a = i5;
    }

    public void setStrokeAlpha(float f5) {
        this.f2758h = f5;
    }

    public void setStrokeColor(int i5) {
        this.f2755e.f5543a = i5;
    }

    public void setStrokeWidth(float f5) {
        this.f2756f = f5;
    }

    public void setTrimPathEnd(float f5) {
        this.f2761k = f5;
    }

    public void setTrimPathOffset(float f5) {
        this.f2762l = f5;
    }

    public void setTrimPathStart(float f5) {
        this.f2760j = f5;
    }

    public g(g gVar) {
        super(gVar);
        this.f2756f = 0.0f;
        this.f2758h = 1.0f;
        this.f2759i = 1.0f;
        this.f2760j = 0.0f;
        this.f2761k = 1.0f;
        this.f2762l = 0.0f;
        this.f2763m = Paint.Cap.BUTT;
        this.f2764n = Paint.Join.MITER;
        this.o = 4.0f;
        this.f2755e = gVar.f2755e;
        this.f2756f = gVar.f2756f;
        this.f2758h = gVar.f2758h;
        this.f2757g = gVar.f2757g;
        this.f2779c = gVar.f2779c;
        this.f2759i = gVar.f2759i;
        this.f2760j = gVar.f2760j;
        this.f2761k = gVar.f2761k;
        this.f2762l = gVar.f2762l;
        this.f2763m = gVar.f2763m;
        this.f2764n = gVar.f2764n;
        this.o = gVar.o;
    }
}

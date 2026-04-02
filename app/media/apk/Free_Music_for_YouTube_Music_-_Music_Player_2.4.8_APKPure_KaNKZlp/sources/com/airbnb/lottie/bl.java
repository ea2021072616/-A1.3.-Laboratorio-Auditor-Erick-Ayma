package com.airbnb.lottie;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.bm;
import com.airbnb.lottie.bz;
import com.airbnb.lottie.n;
import java.util.List;
/* compiled from: PolystarContent.java */
/* loaded from: classes.dex */
class bl implements bg, n.a {

    /* renamed from: a  reason: collision with root package name */
    private final Path f452a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final String f453b;

    /* renamed from: c  reason: collision with root package name */
    private final ax f454c;
    private final bm.b d;
    private final n<?, Float> e;
    private final n<?, PointF> f;
    private final n<?, Float> g;
    @Nullable
    private final n<?, Float> h;
    private final n<?, Float> i;
    @Nullable
    private final n<?, Float> j;
    private final n<?, Float> k;
    @Nullable
    private cg l;
    private boolean m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(ax axVar, o oVar, bm bmVar) {
        this.f454c = axVar;
        this.f453b = bmVar.a();
        this.d = bmVar.b();
        this.e = bmVar.c().b();
        this.f = bmVar.d().b();
        this.g = bmVar.e().b();
        this.i = bmVar.g().b();
        this.k = bmVar.i().b();
        if (this.d == bm.b.Star) {
            this.h = bmVar.f().b();
            this.j = bmVar.h().b();
        } else {
            this.h = null;
            this.j = null;
        }
        oVar.a(this.e);
        oVar.a(this.f);
        oVar.a(this.g);
        oVar.a(this.i);
        oVar.a(this.k);
        if (this.d == bm.b.Star) {
            oVar.a(this.h);
            oVar.a(this.j);
        }
        this.e.a(this);
        this.f.a(this);
        this.g.a(this);
        this.i.a(this);
        this.k.a(this);
        if (this.d == bm.b.Star) {
            this.i.a(this);
            this.k.a(this);
        }
    }

    @Override // com.airbnb.lottie.n.a
    public void a() {
        b();
    }

    private void b() {
        this.m = false;
        this.f454c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.x
    public void a(List<x> list, List<x> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                x xVar = list.get(i2);
                if ((xVar instanceof cg) && ((cg) xVar).b() == bz.b.Simultaneously) {
                    this.l = (cg) xVar;
                    this.l.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.bg
    public Path d() {
        if (this.m) {
            return this.f452a;
        }
        this.f452a.reset();
        switch (this.d) {
            case Star:
                c();
                break;
            case Polygon:
                f();
                break;
        }
        this.f452a.close();
        ch.a(this.f452a, this.l);
        this.m = true;
        return this.f452a;
    }

    @Override // com.airbnb.lottie.x
    public String e() {
        return this.f453b;
    }

    private void c() {
        float f;
        double d;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float floatValue = this.e.b().floatValue();
        double radians = Math.toRadians((this.g == null ? 0.0d : this.g.b().floatValue()) - 90.0d);
        float f8 = (float) (6.283185307179586d / floatValue);
        float f9 = f8 / 2.0f;
        float f10 = floatValue - ((int) floatValue);
        double d2 = f10 != 0.0f ? radians + ((1.0f - f10) * f9) : radians;
        float floatValue2 = this.i.b().floatValue();
        float floatValue3 = this.h.b().floatValue();
        if (this.j == null) {
            f = 0.0f;
        } else {
            f = this.j.b().floatValue() / 100.0f;
        }
        float f11 = 0.0f;
        if (this.k != null) {
            f11 = this.k.b().floatValue() / 100.0f;
        }
        if (f10 != 0.0f) {
            float f12 = ((floatValue2 - floatValue3) * f10) + floatValue3;
            float cos = (float) (f12 * Math.cos(d2));
            float sin = (float) (f12 * Math.sin(d2));
            this.f452a.moveTo(cos, sin);
            d = d2 + ((f8 * f10) / 2.0f);
            f2 = f12;
            f3 = sin;
            f4 = cos;
        } else {
            float cos2 = (float) (floatValue2 * Math.cos(d2));
            float sin2 = (float) (floatValue2 * Math.sin(d2));
            this.f452a.moveTo(cos2, sin2);
            d = d2 + f9;
            f2 = 0.0f;
            f3 = sin2;
            f4 = cos2;
        }
        double ceil = Math.ceil(floatValue) * 2.0d;
        int i = 0;
        boolean z = false;
        float f13 = f3;
        float f14 = f4;
        while (true) {
            double d3 = d;
            if (i < ceil) {
                float f15 = z ? floatValue2 : floatValue3;
                float f16 = (f2 == 0.0f || ((double) i) != ceil - 2.0d) ? f9 : (f8 * f10) / 2.0f;
                if (f2 != 0.0f && i == ceil - 1.0d) {
                    f15 = f2;
                }
                float cos3 = (float) (f15 * Math.cos(d3));
                float sin3 = (float) (f15 * Math.sin(d3));
                if (f == 0.0f && f11 == 0.0f) {
                    this.f452a.lineTo(cos3, sin3);
                } else {
                    float atan2 = (float) (Math.atan2(f13, f14) - 1.5707963267948966d);
                    float cos4 = (float) Math.cos(atan2);
                    float sin4 = (float) Math.sin(atan2);
                    float atan22 = (float) (Math.atan2(sin3, cos3) - 1.5707963267948966d);
                    float cos5 = (float) Math.cos(atan22);
                    float sin5 = (float) Math.sin(atan22);
                    float f17 = z ? f : f11;
                    float f18 = z ? f11 : f;
                    float f19 = z ? floatValue3 : floatValue2;
                    float f20 = z ? floatValue2 : floatValue3;
                    float f21 = cos4 * f19 * f17 * 0.47829f;
                    float f22 = f19 * f17 * 0.47829f * sin4;
                    float f23 = f20 * f18 * 0.47829f * cos5;
                    float f24 = f20 * f18 * 0.47829f * sin5;
                    if (f10 != 0.0f) {
                        if (i == 0) {
                            f22 *= f10;
                            f5 = f24;
                            f6 = f21 * f10;
                            f7 = f23;
                        } else if (i == ceil - 1.0d) {
                            float f25 = f23 * f10;
                            f5 = f24 * f10;
                            f6 = f21;
                            f7 = f25;
                        }
                        this.f452a.cubicTo(f14 - f6, f13 - f22, f7 + cos3, f5 + sin3, cos3, sin3);
                    }
                    f5 = f24;
                    f6 = f21;
                    f7 = f23;
                    this.f452a.cubicTo(f14 - f6, f13 - f22, f7 + cos3, f5 + sin3, cos3, sin3);
                }
                d = d3 + f16;
                i++;
                z = !z;
                f13 = sin3;
                f14 = cos3;
            } else {
                PointF b2 = this.f.b();
                this.f452a.offset(b2.x, b2.y);
                this.f452a.close();
                return;
            }
        }
    }

    private void f() {
        int floor = (int) Math.floor(this.e.b().floatValue());
        double radians = Math.toRadians((this.g == null ? 0.0d : this.g.b().floatValue()) - 90.0d);
        float f = (float) (6.283185307179586d / floor);
        float floatValue = this.k.b().floatValue() / 100.0f;
        float floatValue2 = this.i.b().floatValue();
        float cos = (float) (floatValue2 * Math.cos(radians));
        float sin = (float) (floatValue2 * Math.sin(radians));
        this.f452a.moveTo(cos, sin);
        double d = radians + f;
        double ceil = Math.ceil(floor);
        int i = 0;
        while (true) {
            int i2 = i;
            float f2 = cos;
            double d2 = d;
            float f3 = sin;
            if (i2 < ceil) {
                cos = (float) (floatValue2 * Math.cos(d2));
                sin = (float) (floatValue2 * Math.sin(d2));
                if (floatValue != 0.0f) {
                    float atan2 = (float) (Math.atan2(f3, f2) - 1.5707963267948966d);
                    float cos2 = (float) Math.cos(atan2);
                    float sin2 = (float) Math.sin(atan2);
                    float atan22 = (float) (Math.atan2(sin, cos) - 1.5707963267948966d);
                    this.f452a.cubicTo(f2 - (cos2 * ((floatValue2 * floatValue) * 0.25f)), f3 - (((floatValue2 * floatValue) * 0.25f) * sin2), cos + (((float) Math.cos(atan22)) * floatValue2 * floatValue * 0.25f), (((float) Math.sin(atan22)) * floatValue2 * floatValue * 0.25f) + sin, cos, sin);
                } else {
                    this.f452a.lineTo(cos, sin);
                }
                d = d2 + f;
                i = i2 + 1;
            } else {
                PointF b2 = this.f.b();
                this.f452a.offset(b2.x, b2.y);
                this.f452a.close();
                return;
            }
        }
    }
}

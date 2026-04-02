package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;
import java.util.List;
/* compiled from: GradientStrokeContent.java */
/* loaded from: classes.dex */
public class al extends p {

    /* renamed from: b  reason: collision with root package name */
    private final String f396b;

    /* renamed from: c  reason: collision with root package name */
    private final LongSparseArray<LinearGradient> f397c;
    private final LongSparseArray<RadialGradient> d;
    private final RectF e;
    private final am f;
    private final int g;
    private final au<ag> h;
    private final au<PointF> i;
    private final au<PointF> j;

    @Override // com.airbnb.lottie.p, com.airbnb.lottie.n.a
    public /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.airbnb.lottie.p, com.airbnb.lottie.aa
    public /* bridge */ /* synthetic */ void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
    }

    @Override // com.airbnb.lottie.p, com.airbnb.lottie.x
    public /* bridge */ /* synthetic */ void a(List list, List list2) {
        super.a(list, list2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ax axVar, o oVar, ak akVar) {
        super(axVar, oVar, akVar.h().a(), akVar.i().a(), akVar.d(), akVar.g(), akVar.j(), akVar.k());
        this.f397c = new LongSparseArray<>();
        this.d = new LongSparseArray<>();
        this.e = new RectF();
        this.f396b = akVar.a();
        this.f = akVar.b();
        this.g = (int) (axVar.k().b() / 32);
        this.h = akVar.c().b();
        this.h.a(this);
        oVar.a(this.h);
        this.i = akVar.e().b();
        this.i.a(this);
        oVar.a(this.i);
        this.j = akVar.f().b();
        this.j.a(this);
        oVar.a(this.j);
    }

    @Override // com.airbnb.lottie.p, com.airbnb.lottie.aa
    public void a(Canvas canvas, Matrix matrix, int i) {
        a(this.e, matrix);
        if (this.f == am.Linear) {
            this.f547a.setShader(b());
        } else {
            this.f547a.setShader(c());
        }
        super.a(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.aa
    public void a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
    }

    @Override // com.airbnb.lottie.x
    public String e() {
        return this.f396b;
    }

    private LinearGradient b() {
        int d = d();
        LinearGradient linearGradient = this.f397c.get(d);
        if (linearGradient == null) {
            PointF pointF = (PointF) this.i.b();
            PointF pointF2 = (PointF) this.j.b();
            ag agVar = (ag) this.h.b();
            LinearGradient linearGradient2 = new LinearGradient((int) (this.e.left + (this.e.width() / 2.0f) + pointF.x), (int) (pointF.y + this.e.top + (this.e.height() / 2.0f)), (int) (this.e.left + (this.e.width() / 2.0f) + pointF2.x), (int) (this.e.top + (this.e.height() / 2.0f) + pointF2.y), agVar.b(), agVar.a(), Shader.TileMode.CLAMP);
            this.f397c.put(d, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient c() {
        int d = d();
        RadialGradient radialGradient = this.d.get(d);
        if (radialGradient == null) {
            PointF pointF = (PointF) this.i.b();
            PointF pointF2 = (PointF) this.j.b();
            ag agVar = (ag) this.h.b();
            int[] b2 = agVar.b();
            float[] a2 = agVar.a();
            int width = (int) (this.e.left + (this.e.width() / 2.0f) + pointF.x);
            int height = (int) (pointF.y + this.e.top + (this.e.height() / 2.0f));
            float f = pointF2.y;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.e.left + (this.e.width() / 2.0f)) + pointF2.x)) - width, ((int) (f + (this.e.top + (this.e.height() / 2.0f)))) - height), b2, a2, Shader.TileMode.CLAMP);
            this.d.put(d, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int d() {
        int round = Math.round(this.i.c() * this.g);
        return round * 527 * 31 * Math.round(this.j.c() * this.g) * 31 * Math.round(this.h.c() * this.g);
    }
}

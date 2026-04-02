package k1;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.AnimationUtils;
import l1.g;
import l1.h;
import m1.d;
import s1.e;
import s1.f;
/* loaded from: classes.dex */
public abstract class a extends c implements p1.b {
    public int I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public Paint R;
    public Paint S;
    public boolean T;
    public boolean U;
    public boolean V;
    public float W;

    /* renamed from: a0  reason: collision with root package name */
    public boolean f3524a0;

    /* renamed from: b0  reason: collision with root package name */
    public h f3525b0;

    /* renamed from: c0  reason: collision with root package name */
    public h f3526c0;

    /* renamed from: d0  reason: collision with root package name */
    public f f3527d0;

    /* renamed from: e0  reason: collision with root package name */
    public f f3528e0;

    /* renamed from: f0  reason: collision with root package name */
    public t1.f f3529f0;

    /* renamed from: g0  reason: collision with root package name */
    public t1.f f3530g0;

    /* renamed from: h0  reason: collision with root package name */
    public e f3531h0;

    /* renamed from: i0  reason: collision with root package name */
    public long f3532i0;

    /* renamed from: j0  reason: collision with root package name */
    public long f3533j0;

    /* renamed from: k0  reason: collision with root package name */
    public final RectF f3534k0;

    /* renamed from: l0  reason: collision with root package name */
    public final Matrix f3535l0;

    /* renamed from: m0  reason: collision with root package name */
    public final t1.b f3536m0;

    /* renamed from: n0  reason: collision with root package name */
    public final t1.b f3537n0;

    /* renamed from: o0  reason: collision with root package name */
    public final float[] f3538o0;

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.I = 100;
        this.J = false;
        this.K = false;
        this.L = true;
        this.M = true;
        this.N = true;
        this.O = true;
        this.P = true;
        this.Q = true;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = 15.0f;
        this.f3524a0 = false;
        this.f3532i0 = 0L;
        this.f3533j0 = 0L;
        this.f3534k0 = new RectF();
        this.f3535l0 = new Matrix();
        new Matrix();
        this.f3536m0 = t1.b.b(0.0d, 0.0d);
        this.f3537n0 = t1.b.b(0.0d, 0.0d);
        this.f3538o0 = new float[2];
    }

    @Override // k1.c
    public final void a() {
        RectF rectF = this.f3534k0;
        rectF.left = 0.0f;
        rectF.right = 0.0f;
        rectF.top = 0.0f;
        rectF.bottom = 0.0f;
        l1.e eVar = this.f3551r;
        t1.h hVar = this.f3557x;
        if (eVar != null && eVar.f3730a && !eVar.f3741j) {
            int b5 = n.h.b(eVar.f3740i);
            if (b5 == 0) {
                int b6 = n.h.b(this.f3551r.f3739h);
                if (b6 == 0) {
                    float f5 = rectF.top;
                    l1.e eVar2 = this.f3551r;
                    rectF.top = Math.min(eVar2.f3750t, hVar.f5015d * eVar2.f3748r) + this.f3551r.f3732c + f5;
                } else if (b6 == 2) {
                    float f6 = rectF.bottom;
                    l1.e eVar3 = this.f3551r;
                    rectF.bottom = Math.min(eVar3.f3750t, hVar.f5015d * eVar3.f3748r) + this.f3551r.f3732c + f6;
                }
            } else if (b5 == 1) {
                int b7 = n.h.b(this.f3551r.f3738g);
                if (b7 == 0) {
                    float f7 = rectF.left;
                    l1.e eVar4 = this.f3551r;
                    rectF.left = Math.min(eVar4.f3749s, hVar.f5014c * eVar4.f3748r) + this.f3551r.f3731b + f7;
                } else if (b7 == 1) {
                    int b8 = n.h.b(this.f3551r.f3739h);
                    if (b8 == 0) {
                        float f8 = rectF.top;
                        l1.e eVar5 = this.f3551r;
                        rectF.top = Math.min(eVar5.f3750t, hVar.f5015d * eVar5.f3748r) + this.f3551r.f3732c + f8;
                    } else if (b8 == 2) {
                        float f9 = rectF.bottom;
                        l1.e eVar6 = this.f3551r;
                        rectF.bottom = Math.min(eVar6.f3750t, hVar.f5015d * eVar6.f3748r) + this.f3551r.f3732c + f9;
                    }
                } else if (b7 == 2) {
                    float f10 = rectF.right;
                    l1.e eVar7 = this.f3551r;
                    rectF.right = Math.min(eVar7.f3749s, hVar.f5014c * eVar7.f3748r) + this.f3551r.f3731b + f10;
                }
            }
        }
        float f11 = rectF.left + 0.0f;
        float f12 = rectF.top + 0.0f;
        float f13 = rectF.right + 0.0f;
        float f14 = rectF.bottom + 0.0f;
        h hVar2 = this.f3525b0;
        boolean z4 = false;
        if (hVar2.f3730a && hVar2.f3723t && hVar2.H == 1) {
            f11 += hVar2.c(this.f3527d0.f4830e);
        }
        h hVar3 = this.f3526c0;
        if (hVar3.f3730a && hVar3.f3723t && hVar3.H == 1) {
            z4 = true;
        }
        if (z4) {
            f13 += hVar3.c(this.f3528e0.f4830e);
        }
        g gVar = this.o;
        if (gVar.f3730a && gVar.f3723t) {
            float f15 = gVar.D + gVar.f3732c;
            int i5 = gVar.E;
            if (i5 == 2) {
                f14 += f15;
            } else {
                if (i5 != 1) {
                    if (i5 == 3) {
                        f14 += f15;
                    }
                }
                f12 += f15;
            }
        }
        float extraTopOffset = getExtraTopOffset() + f12;
        float extraRightOffset = getExtraRightOffset() + f13;
        float extraBottomOffset = getExtraBottomOffset() + f14;
        float extraLeftOffset = getExtraLeftOffset() + f11;
        float c5 = t1.g.c(this.W);
        hVar.f5013b.set(Math.max(c5, extraLeftOffset), Math.max(c5, extraTopOffset), hVar.f5014c - Math.max(c5, extraRightOffset), hVar.f5015d - Math.max(c5, extraBottomOffset));
        if (this.f3541g) {
            Log.i("MPAndroidChart", "offsetLeft: " + extraLeftOffset + ", offsetTop: " + extraTopOffset + ", offsetRight: " + extraRightOffset + ", offsetBottom: " + extraBottomOffset);
            StringBuilder sb = new StringBuilder("Content: ");
            sb.append(hVar.f5013b.toString());
            Log.i("MPAndroidChart", sb.toString());
        }
        t1.f fVar = this.f3530g0;
        this.f3526c0.getClass();
        fVar.d();
        t1.f fVar2 = this.f3529f0;
        this.f3525b0.getClass();
        fVar2.d();
        if (this.f3541g) {
            Log.i("MPAndroidChart", "Preparing Value-Px Matrix, xmin: " + this.o.B + ", xmax: " + this.o.A + ", xdelta: " + this.o.C);
        }
        t1.f fVar3 = this.f3530g0;
        g gVar2 = this.o;
        float f16 = gVar2.B;
        float f17 = gVar2.C;
        h hVar4 = this.f3526c0;
        fVar3.e(f16, f17, hVar4.C, hVar4.B);
        t1.f fVar4 = this.f3529f0;
        g gVar3 = this.o;
        float f18 = gVar3.B;
        float f19 = gVar3.C;
        h hVar5 = this.f3525b0;
        fVar4.e(f18, f19, hVar5.C, hVar5.B);
    }

    @Override // android.view.View
    public final void computeScroll() {
        r1.b bVar = this.f3552s;
        if (bVar instanceof r1.a) {
            r1.a aVar = (r1.a) bVar;
            t1.c cVar = aVar.f4480v;
            if (cVar.f4988b == 0.0f && cVar.f4989c == 0.0f) {
                return;
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float f5 = cVar.f4988b;
            c cVar2 = aVar.f4486j;
            a aVar2 = (a) cVar2;
            cVar.f4988b = aVar2.getDragDecelerationFrictionCoef() * f5;
            float dragDecelerationFrictionCoef = aVar2.getDragDecelerationFrictionCoef() * cVar.f4989c;
            cVar.f4989c = dragDecelerationFrictionCoef;
            float f6 = ((float) (currentAnimationTimeMillis - aVar.f4478t)) / 1000.0f;
            float f7 = cVar.f4988b * f6;
            float f8 = dragDecelerationFrictionCoef * f6;
            t1.c cVar3 = aVar.f4479u;
            float f9 = cVar3.f4988b + f7;
            cVar3.f4988b = f9;
            float f10 = cVar3.f4989c + f8;
            cVar3.f4989c = f10;
            MotionEvent obtain = MotionEvent.obtain(currentAnimationTimeMillis, currentAnimationTimeMillis, 2, f9, f10, 0);
            boolean z4 = aVar2.N;
            t1.c cVar4 = aVar.f4472m;
            float f11 = z4 ? cVar3.f4988b - cVar4.f4988b : 0.0f;
            float f12 = aVar2.O ? cVar3.f4989c - cVar4.f4989c : 0.0f;
            aVar.f4470k.set(aVar.f4471l);
            ((a) cVar2).getOnChartGestureListener();
            aVar.b();
            aVar.f4470k.postTranslate(f11, f12);
            obtain.recycle();
            t1.h viewPortHandler = aVar2.getViewPortHandler();
            Matrix matrix = aVar.f4470k;
            viewPortHandler.e(matrix, cVar2, false);
            aVar.f4470k = matrix;
            aVar.f4478t = currentAnimationTimeMillis;
            if (Math.abs(cVar.f4988b) >= 0.01d || Math.abs(cVar.f4989c) >= 0.01d) {
                DisplayMetrics displayMetrics = t1.g.f5003a;
                cVar2.postInvalidateOnAnimation();
                return;
            }
            aVar2.a();
            aVar2.postInvalidate();
            t1.c cVar5 = aVar.f4480v;
            cVar5.f4988b = 0.0f;
            cVar5.f4989c = 0.0f;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02a7  */
    @Override // k1.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d() {
        /*
            Method dump skipped, instructions count: 958
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k1.a.d():void");
    }

    public final t1.f f(int i5) {
        return i5 == 1 ? this.f3529f0 : this.f3530g0;
    }

    public h getAxisLeft() {
        return this.f3525b0;
    }

    public h getAxisRight() {
        return this.f3526c0;
    }

    @Override // k1.c, p1.c, p1.b
    public /* bridge */ /* synthetic */ d getData() {
        return (d) super.getData();
    }

    public r1.e getDrawListener() {
        return null;
    }

    public float getHighestVisibleX() {
        t1.f f5 = f(1);
        RectF rectF = this.f3557x.f5013b;
        float f6 = rectF.right;
        float f7 = rectF.bottom;
        t1.b bVar = this.f3537n0;
        f5.a(f6, f7, bVar);
        return (float) Math.min(this.o.A, bVar.f4985b);
    }

    public float getLowestVisibleX() {
        t1.f f5 = f(1);
        RectF rectF = this.f3557x.f5013b;
        float f6 = rectF.left;
        float f7 = rectF.bottom;
        t1.b bVar = this.f3536m0;
        f5.a(f6, f7, bVar);
        return (float) Math.max(this.o.B, bVar.f4985b);
    }

    @Override // k1.c, p1.c
    public int getMaxVisibleCount() {
        return this.I;
    }

    public float getMinOffset() {
        return this.W;
    }

    public f getRendererLeftYAxis() {
        return this.f3527d0;
    }

    public f getRendererRightYAxis() {
        return this.f3528e0;
    }

    public e getRendererXAxis() {
        return this.f3531h0;
    }

    @Override // android.view.View
    public float getScaleX() {
        t1.h hVar = this.f3557x;
        if (hVar == null) {
            return 1.0f;
        }
        return hVar.f5020i;
    }

    @Override // android.view.View
    public float getScaleY() {
        t1.h hVar = this.f3557x;
        if (hVar == null) {
            return 1.0f;
        }
        return hVar.f5021j;
    }

    public float getVisibleXRange() {
        return Math.abs(getHighestVisibleX() - getLowestVisibleX());
    }

    @Override // k1.c
    public float getYChartMax() {
        return Math.max(this.f3525b0.A, this.f3526c0.A);
    }

    @Override // k1.c
    public float getYChartMin() {
        return Math.min(this.f3525b0.B, this.f3526c0.B);
    }

    /* JADX WARN: Removed duplicated region for block: B:188:0x0472  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x06fd  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x07f6  */
    /* JADX WARN: Removed duplicated region for block: B:440:0x04cc A[SYNTHETIC] */
    @Override // k1.c, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onDraw(android.graphics.Canvas r42) {
        /*
            Method dump skipped, instructions count: 2508
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k1.a.onDraw(android.graphics.Canvas):void");
    }

    @Override // k1.c, android.view.View
    public final void onSizeChanged(int i5, int i6, int i7, int i8) {
        float[] fArr = this.f3538o0;
        fArr[1] = 0.0f;
        fArr[0] = 0.0f;
        boolean z4 = this.f3524a0;
        t1.h hVar = this.f3557x;
        if (z4) {
            RectF rectF = hVar.f5013b;
            fArr[0] = rectF.left;
            fArr[1] = rectF.top;
            f(1).b(fArr);
        }
        super.onSizeChanged(i5, i6, i7, i8);
        if (!this.f3524a0) {
            hVar.e(hVar.f5012a, this, true);
            return;
        }
        f(1).c(fArr);
        Matrix matrix = hVar.f5025n;
        matrix.reset();
        matrix.set(hVar.f5012a);
        float f5 = fArr[0];
        RectF rectF2 = hVar.f5013b;
        matrix.postTranslate(-(f5 - rectF2.left), -(fArr[1] - rectF2.top));
        hVar.e(matrix, this, true);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        r1.b bVar = this.f3552s;
        if (bVar == null || this.f3542h == null || !this.f3549p) {
            return false;
        }
        ((r1.a) bVar).onTouch(this, motionEvent);
        return true;
    }

    public void setAutoScaleMinMaxEnabled(boolean z4) {
        this.J = z4;
    }

    public void setBorderColor(int i5) {
        this.S.setColor(i5);
    }

    public void setBorderWidth(float f5) {
        this.S.setStrokeWidth(t1.g.c(f5));
    }

    public void setClipValuesToContent(boolean z4) {
        this.V = z4;
    }

    public void setDoubleTapToZoomEnabled(boolean z4) {
        this.L = z4;
    }

    public void setDragEnabled(boolean z4) {
        this.N = z4;
        this.O = z4;
    }

    public void setDragOffsetX(float f5) {
        t1.h hVar = this.f3557x;
        hVar.getClass();
        hVar.f5023l = t1.g.c(f5);
    }

    public void setDragOffsetY(float f5) {
        t1.h hVar = this.f3557x;
        hVar.getClass();
        hVar.f5024m = t1.g.c(f5);
    }

    public void setDragXEnabled(boolean z4) {
        this.N = z4;
    }

    public void setDragYEnabled(boolean z4) {
        this.O = z4;
    }

    public void setDrawBorders(boolean z4) {
        this.U = z4;
    }

    public void setDrawGridBackground(boolean z4) {
        this.T = z4;
    }

    public void setGridBackgroundColor(int i5) {
        this.R.setColor(i5);
    }

    public void setHighlightPerDragEnabled(boolean z4) {
        this.M = z4;
    }

    public void setKeepPositionOnRotation(boolean z4) {
        this.f3524a0 = z4;
    }

    public void setMaxVisibleValueCount(int i5) {
        this.I = i5;
    }

    public void setMinOffset(float f5) {
        this.W = f5;
    }

    public void setOnDrawListener(r1.e eVar) {
    }

    public void setPinchZoom(boolean z4) {
        this.K = z4;
    }

    public void setRendererLeftYAxis(f fVar) {
        this.f3527d0 = fVar;
    }

    public void setRendererRightYAxis(f fVar) {
        this.f3528e0 = fVar;
    }

    public void setScaleEnabled(boolean z4) {
        this.P = z4;
        this.Q = z4;
    }

    public void setScaleXEnabled(boolean z4) {
        this.P = z4;
    }

    public void setScaleYEnabled(boolean z4) {
        this.Q = z4;
    }

    public void setVisibleXRangeMaximum(float f5) {
        float f6 = this.o.C / f5;
        t1.h hVar = this.f3557x;
        hVar.getClass();
        if (f6 < 1.0f) {
            f6 = 1.0f;
        }
        hVar.f5018g = f6;
        hVar.d(hVar.f5012a, hVar.f5013b);
    }

    public void setVisibleXRangeMinimum(float f5) {
        float f6 = this.o.C / f5;
        t1.h hVar = this.f3557x;
        hVar.getClass();
        if (f6 == 0.0f) {
            f6 = Float.MAX_VALUE;
        }
        hVar.f5019h = f6;
        hVar.d(hVar.f5012a, hVar.f5013b);
    }

    public void setXAxisRenderer(e eVar) {
        this.f3531h0 = eVar;
    }
}

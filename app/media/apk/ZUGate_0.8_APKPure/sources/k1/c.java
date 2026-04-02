package k1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.github.mikephil.charting.charts.BarChart;
import java.util.ArrayList;
import java.util.Iterator;
import l1.e;
import l1.g;
import m1.f;
import s1.d;
import t1.h;
/* loaded from: classes.dex */
public abstract class c extends ViewGroup implements p1.c {
    public float A;
    public float B;
    public float C;
    public boolean D;
    public o1.c[] E;
    public float F;
    public final ArrayList G;
    public boolean H;

    /* renamed from: g  reason: collision with root package name */
    public boolean f3541g;

    /* renamed from: h  reason: collision with root package name */
    public f f3542h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3543i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3544j;

    /* renamed from: k  reason: collision with root package name */
    public float f3545k;

    /* renamed from: l  reason: collision with root package name */
    public final n1.b f3546l;

    /* renamed from: m  reason: collision with root package name */
    public Paint f3547m;

    /* renamed from: n  reason: collision with root package name */
    public Paint f3548n;
    public g o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f3549p;

    /* renamed from: q  reason: collision with root package name */
    public l1.c f3550q;

    /* renamed from: r  reason: collision with root package name */
    public e f3551r;

    /* renamed from: s  reason: collision with root package name */
    public r1.b f3552s;

    /* renamed from: t  reason: collision with root package name */
    public String f3553t;

    /* renamed from: u  reason: collision with root package name */
    public d f3554u;

    /* renamed from: v  reason: collision with root package name */
    public s1.c f3555v;

    /* renamed from: w  reason: collision with root package name */
    public o1.b f3556w;

    /* renamed from: x  reason: collision with root package name */
    public final h f3557x;

    /* renamed from: y  reason: collision with root package name */
    public i1.a f3558y;

    /* renamed from: z  reason: collision with root package name */
    public float f3559z;

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3541g = false;
        this.f3542h = null;
        this.f3543i = true;
        this.f3544j = true;
        this.f3545k = 0.9f;
        this.f3546l = new n1.b(0);
        this.f3549p = true;
        this.f3553t = "No chart data available.";
        this.f3557x = new h();
        this.f3559z = 0.0f;
        this.A = 0.0f;
        this.B = 0.0f;
        this.C = 0.0f;
        this.D = false;
        this.F = 0.0f;
        this.G = new ArrayList();
        this.H = false;
        BarChart barChart = (BarChart) this;
        barChart.setWillNotDraw(false);
        barChart.f3558y = new i1.a();
        Context context2 = barChart.getContext();
        DisplayMetrics displayMetrics = t1.g.f5003a;
        if (context2 == null) {
            t1.g.f5004b = ViewConfiguration.getMinimumFlingVelocity();
            t1.g.f5005c = ViewConfiguration.getMaximumFlingVelocity();
            Log.e("MPChartLib-Utils", "Utils.init(...) PROVIDED CONTEXT OBJECT IS NULL");
        } else {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context2);
            t1.g.f5004b = viewConfiguration.getScaledMinimumFlingVelocity();
            t1.g.f5005c = viewConfiguration.getScaledMaximumFlingVelocity();
            t1.g.f5003a = context2.getResources().getDisplayMetrics();
        }
        barChart.F = t1.g.c(500.0f);
        barChart.f3550q = new l1.c();
        e eVar = new e();
        barChart.f3551r = eVar;
        h hVar = barChart.f3557x;
        barChart.f3554u = new d(hVar, eVar);
        barChart.o = new g();
        barChart.f3547m = new Paint(1);
        Paint paint = new Paint(1);
        barChart.f3548n = paint;
        paint.setColor(Color.rgb(247, 189, 51));
        barChart.f3548n.setTextAlign(Paint.Align.CENTER);
        barChart.f3548n.setTextSize(t1.g.c(12.0f));
        if (barChart.f3541g) {
            Log.i("", "Chart.init()");
        }
        barChart.f3525b0 = new l1.h(1);
        barChart.f3526c0 = new l1.h(2);
        barChart.f3529f0 = new t1.f(hVar);
        barChart.f3530g0 = new t1.f(hVar);
        barChart.f3527d0 = new s1.f(hVar, barChart.f3525b0, barChart.f3529f0);
        barChart.f3528e0 = new s1.f(hVar, barChart.f3526c0, barChart.f3530g0);
        barChart.f3531h0 = new s1.e(hVar, barChart.o, barChart.f3529f0);
        barChart.setHighlighter(new o1.b(barChart));
        barChart.f3552s = new r1.a(barChart, hVar.f5012a);
        Paint paint2 = new Paint();
        barChart.R = paint2;
        paint2.setStyle(Paint.Style.FILL);
        barChart.R.setColor(Color.rgb(240, 240, 240));
        Paint paint3 = new Paint();
        barChart.S = paint3;
        paint3.setStyle(Paint.Style.STROKE);
        barChart.S.setColor(-16777216);
        barChart.S.setStrokeWidth(t1.g.c(1.0f));
        barChart.f3555v = new s1.b(barChart, barChart.f3558y, hVar);
        barChart.setHighlighter(new o1.a(barChart));
        barChart.getXAxis().f3727x = 0.5f;
        barChart.getXAxis().f3728y = 0.5f;
    }

    public static void e(View view) {
        if (view.getBackground() != null) {
            view.getBackground().setCallback(null);
        }
        if (!(view instanceof ViewGroup)) {
            return;
        }
        int i5 = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i5 >= viewGroup.getChildCount()) {
                viewGroup.removeAllViews();
                return;
            } else {
                e(viewGroup.getChildAt(i5));
                i5++;
            }
        }
    }

    public abstract void a();

    public abstract o1.c b(float f5, float f6);

    public final void c(o1.c cVar) {
        m1.g gVar;
        int d5;
        if (cVar == null) {
            this.E = null;
        } else {
            if (this.f3541g) {
                Log.i("MPAndroidChart", "Highlighted: " + cVar.toString());
            }
            f fVar = this.f3542h;
            fVar.getClass();
            ArrayList arrayList = fVar.f3943i;
            int size = arrayList.size();
            int i5 = cVar.f4098e;
            if (((i5 < size && (d5 = (gVar = (m1.g) ((q1.b) arrayList.get(i5))).d(cVar.f4094a, cVar.f4095b, 3)) > -1) ? (m1.h) gVar.o.get(d5) : null) == null) {
                this.E = null;
            } else {
                this.E = new o1.c[]{cVar};
            }
        }
        setLastHighlighted(this.E);
        invalidate();
    }

    public abstract void d();

    public i1.a getAnimator() {
        return this.f3558y;
    }

    public t1.c getCenter() {
        return t1.c.b(getWidth() / 2.0f, getHeight() / 2.0f);
    }

    public t1.c getCenterOfView() {
        return getCenter();
    }

    public t1.c getCenterOffsets() {
        RectF rectF = this.f3557x.f5013b;
        return t1.c.b(rectF.centerX(), rectF.centerY());
    }

    public Bitmap getChartBitmap() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        Drawable background = getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(-1);
        }
        draw(canvas);
        return createBitmap;
    }

    public RectF getContentRect() {
        return this.f3557x.f5013b;
    }

    public f getData() {
        return this.f3542h;
    }

    public n1.d getDefaultValueFormatter() {
        return this.f3546l;
    }

    public l1.c getDescription() {
        return this.f3550q;
    }

    public float getDragDecelerationFrictionCoef() {
        return this.f3545k;
    }

    public float getExtraBottomOffset() {
        return this.B;
    }

    public float getExtraLeftOffset() {
        return this.C;
    }

    public float getExtraRightOffset() {
        return this.A;
    }

    public float getExtraTopOffset() {
        return this.f3559z;
    }

    public o1.c[] getHighlighted() {
        return this.E;
    }

    public o1.d getHighlighter() {
        return this.f3556w;
    }

    public ArrayList<Runnable> getJobs() {
        return this.G;
    }

    public e getLegend() {
        return this.f3551r;
    }

    public d getLegendRenderer() {
        return this.f3554u;
    }

    public l1.d getMarker() {
        return null;
    }

    @Deprecated
    public l1.d getMarkerView() {
        getMarker();
        return null;
    }

    @Override // p1.c
    public float getMaxHighlightDistance() {
        return this.F;
    }

    public abstract /* synthetic */ int getMaxVisibleCount();

    public r1.c getOnChartGestureListener() {
        return null;
    }

    public r1.b getOnTouchListener() {
        return this.f3552s;
    }

    public s1.c getRenderer() {
        return this.f3555v;
    }

    public h getViewPortHandler() {
        return this.f3557x;
    }

    public g getXAxis() {
        return this.o;
    }

    public float getXChartMax() {
        return this.o.A;
    }

    public float getXChartMin() {
        return this.o.B;
    }

    public float getXRange() {
        return this.o.C;
    }

    public abstract /* synthetic */ float getYChartMax();

    public abstract /* synthetic */ float getYChartMin();

    public float getYMax() {
        return this.f3542h.f3935a;
    }

    public float getYMin() {
        return this.f3542h.f3936b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.H) {
            e(this);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f3542h == null) {
            if (!TextUtils.isEmpty(this.f3553t)) {
                t1.c center = getCenter();
                canvas.drawText(this.f3553t, center.f4988b, center.f4989c, this.f3548n);
            }
        } else if (this.D) {
        } else {
            a();
            this.D = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            getChildAt(i9).layout(i5, i6, i7, i8);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        int c5 = (int) t1.g.c(50.0f);
        setMeasuredDimension(Math.max(getSuggestedMinimumWidth(), View.resolveSize(c5, i5)), Math.max(getSuggestedMinimumHeight(), View.resolveSize(c5, i6)));
    }

    @Override // android.view.View
    public void onSizeChanged(int i5, int i6, int i7, int i8) {
        if (this.f3541g) {
            Log.i("MPAndroidChart", "OnSizeChanged()");
        }
        if (i5 > 0 && i6 > 0 && i5 < 10000 && i6 < 10000) {
            if (this.f3541g) {
                Log.i("MPAndroidChart", "Setting chart dimens, width: " + i5 + ", height: " + i6);
            }
            float f5 = i5;
            float f6 = i6;
            h hVar = this.f3557x;
            RectF rectF = hVar.f5013b;
            float f7 = rectF.left;
            float f8 = rectF.top;
            float f9 = hVar.f5014c - rectF.right;
            hVar.f5015d = f6;
            hVar.f5014c = f5;
            rectF.set(f7, f8, f5 - f9, f6 - (hVar.f5015d - rectF.bottom));
        } else if (this.f3541g) {
            Log.w("MPAndroidChart", "*Avoiding* setting chart dimens! width: " + i5 + ", height: " + i6);
        }
        d();
        ArrayList arrayList = this.G;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            post((Runnable) it.next());
        }
        arrayList.clear();
        super.onSizeChanged(i5, i6, i7, i8);
    }

    public void setData(f fVar) {
        this.f3542h = fVar;
        this.D = false;
        if (fVar == null) {
            return;
        }
        float f5 = fVar.f3936b;
        float f6 = fVar.f3935a;
        float d5 = t1.g.d(fVar.e() < 2 ? Math.max(Math.abs(f5), Math.abs(f6)) : Math.abs(f6 - f5));
        int ceil = Float.isInfinite(d5) ? 0 : ((int) Math.ceil(-Math.log10(d5))) + 2;
        n1.b bVar = this.f3546l;
        bVar.b(ceil);
        Iterator it = this.f3542h.f3943i.iterator();
        while (it.hasNext()) {
            m1.g gVar = (m1.g) ((q1.b) it.next());
            Object obj = gVar.f3949f;
            if (!(obj == null)) {
                if (obj == null) {
                    obj = t1.g.f5009g;
                }
                if (obj == bVar) {
                }
            }
            gVar.f3949f = bVar;
        }
        d();
        if (this.f3541g) {
            Log.i("MPAndroidChart", "Data is set.");
        }
    }

    public void setDescription(l1.c cVar) {
        this.f3550q = cVar;
    }

    public void setDragDecelerationEnabled(boolean z4) {
        this.f3544j = z4;
    }

    public void setDragDecelerationFrictionCoef(float f5) {
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        if (f5 >= 1.0f) {
            f5 = 0.999f;
        }
        this.f3545k = f5;
    }

    @Deprecated
    public void setDrawMarkerViews(boolean z4) {
        setDrawMarkers(z4);
    }

    public void setDrawMarkers(boolean z4) {
    }

    public void setExtraBottomOffset(float f5) {
        this.B = t1.g.c(f5);
    }

    public void setExtraLeftOffset(float f5) {
        this.C = t1.g.c(f5);
    }

    public void setExtraRightOffset(float f5) {
        this.A = t1.g.c(f5);
    }

    public void setExtraTopOffset(float f5) {
        this.f3559z = t1.g.c(f5);
    }

    public void setHardwareAccelerationEnabled(boolean z4) {
        if (z4) {
            setLayerType(2, null);
        } else {
            setLayerType(1, null);
        }
    }

    public void setHighlightPerTapEnabled(boolean z4) {
        this.f3543i = z4;
    }

    public void setHighlighter(o1.b bVar) {
        this.f3556w = bVar;
    }

    public void setLastHighlighted(o1.c[] cVarArr) {
        o1.c cVar;
        if (cVarArr == null || cVarArr.length <= 0 || (cVar = cVarArr[0]) == null) {
            this.f3552s.f4484h = null;
        } else {
            this.f3552s.f4484h = cVar;
        }
    }

    public void setLogEnabled(boolean z4) {
        this.f3541g = z4;
    }

    public void setMarker(l1.d dVar) {
    }

    @Deprecated
    public void setMarkerView(l1.d dVar) {
        setMarker(dVar);
    }

    public void setMaxHighlightDistance(float f5) {
        this.F = t1.g.c(f5);
    }

    public void setNoDataText(String str) {
        this.f3553t = str;
    }

    public void setNoDataTextColor(int i5) {
        this.f3548n.setColor(i5);
    }

    public void setNoDataTextTypeface(Typeface typeface) {
        this.f3548n.setTypeface(typeface);
    }

    public void setOnChartGestureListener(r1.c cVar) {
    }

    public void setOnChartValueSelectedListener(r1.d dVar) {
    }

    public void setOnTouchListener(r1.b bVar) {
        this.f3552s = bVar;
    }

    public void setRenderer(s1.c cVar) {
        if (cVar != null) {
            this.f3555v = cVar;
        }
    }

    public void setTouchEnabled(boolean z4) {
        this.f3549p = z4;
    }

    public void setUnbindEnabled(boolean z4) {
        this.H = z4;
    }
}

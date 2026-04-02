package r1;

import android.graphics.Matrix;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import t1.g;
import t1.h;
/* loaded from: classes.dex */
public final class a extends b {

    /* renamed from: k  reason: collision with root package name */
    public Matrix f4470k;

    /* renamed from: l  reason: collision with root package name */
    public final Matrix f4471l;

    /* renamed from: m  reason: collision with root package name */
    public final t1.c f4472m;

    /* renamed from: n  reason: collision with root package name */
    public final t1.c f4473n;
    public float o;

    /* renamed from: p  reason: collision with root package name */
    public float f4474p;

    /* renamed from: q  reason: collision with root package name */
    public float f4475q;

    /* renamed from: r  reason: collision with root package name */
    public q1.a f4476r;

    /* renamed from: s  reason: collision with root package name */
    public VelocityTracker f4477s;

    /* renamed from: t  reason: collision with root package name */
    public long f4478t;

    /* renamed from: u  reason: collision with root package name */
    public final t1.c f4479u;

    /* renamed from: v  reason: collision with root package name */
    public final t1.c f4480v;

    /* renamed from: w  reason: collision with root package name */
    public final float f4481w;

    /* renamed from: x  reason: collision with root package name */
    public final float f4482x;

    public a(k1.a aVar, Matrix matrix) {
        super(aVar);
        this.f4470k = new Matrix();
        this.f4471l = new Matrix();
        this.f4472m = t1.c.b(0.0f, 0.0f);
        this.f4473n = t1.c.b(0.0f, 0.0f);
        this.o = 1.0f;
        this.f4474p = 1.0f;
        this.f4475q = 1.0f;
        this.f4478t = 0L;
        this.f4479u = t1.c.b(0.0f, 0.0f);
        this.f4480v = t1.c.b(0.0f, 0.0f);
        this.f4470k = matrix;
        this.f4481w = g.c(3.0f);
        this.f4482x = g.c(3.5f);
    }

    public static float d(MotionEvent motionEvent) {
        float x5 = motionEvent.getX(0) - motionEvent.getX(1);
        float y5 = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((y5 * y5) + (x5 * x5));
    }

    public final t1.c a(float f5, float f6) {
        k1.a aVar = (k1.a) this.f4486j;
        h viewPortHandler = aVar.getViewPortHandler();
        b();
        return t1.c.b(f5 - viewPortHandler.f5013b.left, -((aVar.getMeasuredHeight() - f6) - (viewPortHandler.f5015d - viewPortHandler.f5013b.bottom)));
    }

    public final void b() {
        q1.a aVar = this.f4476r;
        k1.c cVar = this.f4486j;
        if (aVar == null) {
            k1.a aVar2 = (k1.a) cVar;
            aVar2.f3525b0.getClass();
            aVar2.f3526c0.getClass();
        }
        q1.a aVar3 = this.f4476r;
        if (aVar3 != null) {
            k1.a aVar4 = (k1.a) cVar;
            (((m1.g) aVar3).f3947d == 1 ? aVar4.f3525b0 : aVar4.f3526c0).getClass();
        }
    }

    public final void c(MotionEvent motionEvent) {
        this.f4471l.set(this.f4470k);
        float x5 = motionEvent.getX();
        t1.c cVar = this.f4472m;
        cVar.f4988b = x5;
        cVar.f4989c = motionEvent.getY();
        k1.a aVar = (k1.a) this.f4486j;
        o1.c b5 = aVar.b(motionEvent.getX(), motionEvent.getY());
        this.f4476r = b5 != null ? (q1.a) ((m1.d) aVar.f3542h).c(b5.f4098e) : null;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        k1.a aVar = (k1.a) this.f4486j;
        aVar.getOnChartGestureListener();
        if (aVar.L && ((m1.d) aVar.getData()).e() > 0) {
            t1.c a5 = a(motionEvent.getX(), motionEvent.getY());
            float f5 = aVar.P ? 1.4f : 1.0f;
            float f6 = aVar.Q ? 1.4f : 1.0f;
            Matrix matrix = aVar.f3535l0;
            h hVar = aVar.f3557x;
            hVar.getClass();
            matrix.reset();
            matrix.set(hVar.f5012a);
            matrix.postScale(f5, f6, a5.f4988b, -a5.f4989c);
            hVar.e(matrix, aVar, false);
            aVar.a();
            aVar.postInvalidate();
            if (aVar.f3541g) {
                Log.i("BarlineChartTouch", "Double-Tap, Zooming In, x: " + a5.f4988b + ", y: " + a5.f4989c);
            }
            t1.c.f4987d.c(a5);
        }
        return super.onDoubleTap(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f5, float f6) {
        ((k1.a) this.f4486j).getOnChartGestureListener();
        return super.onFling(motionEvent, motionEvent2, f5, f6);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
        ((k1.a) this.f4486j).getOnChartGestureListener();
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        k1.c cVar = this.f4486j;
        k1.a aVar = (k1.a) cVar;
        aVar.getOnChartGestureListener();
        if (aVar.f3543i) {
            o1.c b5 = aVar.b(motionEvent.getX(), motionEvent.getY());
            if (b5 == null || b5.a(this.f4484h)) {
                cVar.c(null);
                this.f4484h = null;
            } else {
                cVar.c(b5);
                this.f4484h = b5;
            }
            return super.onSingleTapUp(motionEvent);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:0x01d8, code lost:
        if ((r3.f5023l <= 0.0f && r3.f5024m <= 0.0f) == false) goto L134;
     */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0207  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r17, android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 977
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r1.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}

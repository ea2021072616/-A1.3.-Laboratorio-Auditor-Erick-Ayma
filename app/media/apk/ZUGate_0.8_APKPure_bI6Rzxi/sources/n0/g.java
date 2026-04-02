package n0;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
/* loaded from: classes.dex */
public final class g implements View.OnTouchListener {

    /* renamed from: x  reason: collision with root package name */
    public static final int f4054x = ViewConfiguration.getTapTimeout();

    /* renamed from: g  reason: collision with root package name */
    public final a f4055g;

    /* renamed from: h  reason: collision with root package name */
    public final AccelerateInterpolator f4056h;

    /* renamed from: i  reason: collision with root package name */
    public final View f4057i;

    /* renamed from: j  reason: collision with root package name */
    public androidx.activity.j f4058j;

    /* renamed from: k  reason: collision with root package name */
    public final float[] f4059k;

    /* renamed from: l  reason: collision with root package name */
    public final float[] f4060l;

    /* renamed from: m  reason: collision with root package name */
    public int f4061m;

    /* renamed from: n  reason: collision with root package name */
    public int f4062n;
    public final float[] o;

    /* renamed from: p  reason: collision with root package name */
    public final float[] f4063p;

    /* renamed from: q  reason: collision with root package name */
    public final float[] f4064q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f4065r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f4066s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f4067t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f4068u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f4069v;

    /* renamed from: w  reason: collision with root package name */
    public final ListView f4070w;

    public g(ListView listView) {
        a aVar = new a();
        this.f4055g = aVar;
        this.f4056h = new AccelerateInterpolator();
        float[] fArr = {0.0f, 0.0f};
        this.f4059k = fArr;
        float[] fArr2 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f4060l = fArr2;
        float[] fArr3 = {0.0f, 0.0f};
        this.o = fArr3;
        float[] fArr4 = {0.0f, 0.0f};
        this.f4063p = fArr4;
        float[] fArr5 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f4064q = fArr5;
        this.f4057i = listView;
        float f5 = Resources.getSystem().getDisplayMetrics().density;
        float f6 = ((int) ((1575.0f * f5) + 0.5f)) / 1000.0f;
        fArr5[0] = f6;
        fArr5[1] = f6;
        float f7 = ((int) ((f5 * 315.0f) + 0.5f)) / 1000.0f;
        fArr4[0] = f7;
        fArr4[1] = f7;
        this.f4061m = 1;
        fArr2[0] = Float.MAX_VALUE;
        fArr2[1] = Float.MAX_VALUE;
        fArr[0] = 0.2f;
        fArr[1] = 0.2f;
        fArr3[0] = 0.001f;
        fArr3[1] = 0.001f;
        this.f4062n = f4054x;
        aVar.f4045a = 500;
        aVar.f4046b = 500;
        this.f4070w = listView;
    }

    public static float b(float f5, float f6, float f7) {
        return f5 > f7 ? f7 : f5 < f6 ? f6 : f5;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float a(float r4, float r5, float r6, int r7) {
        /*
            r3 = this;
            float[] r0 = r3.f4059k
            r0 = r0[r7]
            float[] r1 = r3.f4060l
            r1 = r1[r7]
            float r0 = r0 * r5
            r2 = 0
            float r0 = b(r0, r2, r1)
            float r1 = r3.c(r4, r0)
            float r5 = r5 - r4
            float r4 = r3.c(r5, r0)
            float r4 = r4 - r1
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            android.view.animation.AccelerateInterpolator r0 = r3.f4056h
            if (r5 >= 0) goto L25
            float r4 = -r4
            float r4 = r0.getInterpolation(r4)
            float r4 = -r4
            goto L2d
        L25:
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r5 <= 0) goto L36
            float r4 = r0.getInterpolation(r4)
        L2d:
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            float r4 = b(r4, r5, r0)
            goto L37
        L36:
            r4 = r2
        L37:
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r5 != 0) goto L3c
            goto L58
        L3c:
            float[] r0 = r3.o
            r0 = r0[r7]
            float[] r1 = r3.f4063p
            r1 = r1[r7]
            float[] r2 = r3.f4064q
            r7 = r2[r7]
            float r0 = r0 * r6
            if (r5 <= 0) goto L51
            float r4 = r4 * r0
            float r2 = b(r4, r1, r7)
            goto L58
        L51:
            float r4 = -r4
            float r4 = r4 * r0
            float r4 = b(r4, r1, r7)
            float r2 = -r4
        L58:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: n0.g.a(float, float, float, int):float");
    }

    public final float c(float f5, float f6) {
        if (f6 == 0.0f) {
            return 0.0f;
        }
        int i5 = this.f4061m;
        if (i5 == 0 || i5 == 1) {
            if (f5 < f6) {
                return f5 >= 0.0f ? 1.0f - (f5 / f6) : (this.f4068u && i5 == 1) ? 1.0f : 0.0f;
            }
            return 0.0f;
        } else if (i5 == 2 && f5 < 0.0f) {
            return f5 / (-f6);
        } else {
            return 0.0f;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
        if (r0 != 3) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(android.view.View r8, android.view.MotionEvent r9) {
        /*
            r7 = this;
            boolean r0 = r7.f4069v
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r9.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r8 = 3
            if (r0 == r8) goto L16
            goto L7c
        L16:
            r7.e()
            goto L7c
        L1a:
            r7.f4067t = r2
            r7.f4065r = r1
        L1e:
            float r0 = r9.getX()
            int r3 = r8.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r7.f4057i
            int r5 = r4.getWidth()
            float r5 = (float) r5
            float r0 = r7.a(r0, r3, r5, r1)
            float r9 = r9.getY()
            int r8 = r8.getHeight()
            float r8 = (float) r8
            int r3 = r4.getHeight()
            float r3 = (float) r3
            float r8 = r7.a(r9, r8, r3, r2)
            n0.a r9 = r7.f4055g
            r9.f4047c = r0
            r9.f4048d = r8
            boolean r8 = r7.f4068u
            if (r8 != 0) goto L7c
            boolean r8 = r7.f()
            if (r8 == 0) goto L7c
            androidx.activity.j r8 = r7.f4058j
            if (r8 != 0) goto L60
            androidx.activity.j r8 = new androidx.activity.j
            r9 = 7
            r8.<init>(r9, r7)
            r7.f4058j = r8
        L60:
            r7.f4068u = r2
            r7.f4066s = r2
            boolean r8 = r7.f4065r
            if (r8 != 0) goto L75
            int r8 = r7.f4062n
            if (r8 <= 0) goto L75
            androidx.activity.j r9 = r7.f4058j
            long r5 = (long) r8
            java.util.WeakHashMap r8 = h0.z0.f3233a
            r4.postOnAnimationDelayed(r9, r5)
            goto L7a
        L75:
            androidx.activity.j r8 = r7.f4058j
            r8.run()
        L7a:
            r7.f4065r = r2
        L7c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: n0.g.d(android.view.View, android.view.MotionEvent):boolean");
    }

    public final void e() {
        int i5 = 0;
        if (this.f4066s) {
            this.f4068u = false;
            return;
        }
        a aVar = this.f4055g;
        aVar.getClass();
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i6 = (int) (currentAnimationTimeMillis - aVar.f4049e);
        int i7 = aVar.f4046b;
        if (i6 > i7) {
            i5 = i7;
        } else if (i6 >= 0) {
            i5 = i6;
        }
        aVar.f4053i = i5;
        aVar.f4052h = aVar.a(currentAnimationTimeMillis);
        aVar.f4051g = currentAnimationTimeMillis;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f() {
        /*
            r8 = this;
            n0.a r0 = r8.f4055g
            float r1 = r0.f4048d
            float r2 = java.lang.Math.abs(r1)
            float r1 = r1 / r2
            int r1 = (int) r1
            float r0 = r0.f4047c
            java.lang.Math.abs(r0)
            r0 = 0
            if (r1 == 0) goto L50
            android.widget.ListView r2 = r8.f4070w
            int r3 = r2.getCount()
            r4 = 1
            if (r3 != 0) goto L1c
            goto L4b
        L1c:
            int r5 = r2.getChildCount()
            int r6 = r2.getFirstVisiblePosition()
            int r7 = r6 + r5
            if (r1 <= 0) goto L3a
            if (r7 < r3) goto L49
            int r5 = r5 - r4
            android.view.View r1 = r2.getChildAt(r5)
            int r1 = r1.getBottom()
            int r2 = r2.getHeight()
            if (r1 > r2) goto L49
            goto L4b
        L3a:
            if (r1 >= 0) goto L4b
            if (r6 > 0) goto L49
            android.view.View r1 = r2.getChildAt(r0)
            int r1 = r1.getTop()
            if (r1 < 0) goto L49
            goto L4b
        L49:
            r1 = r4
            goto L4c
        L4b:
            r1 = r0
        L4c:
            if (r1 != 0) goto L4f
            goto L50
        L4f:
            r0 = r4
        L50:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: n0.g.f():boolean");
    }

    @Override // android.view.View.OnTouchListener
    public final /* bridge */ /* synthetic */ boolean onTouch(View view, MotionEvent motionEvent) {
        d(view, motionEvent);
        return false;
    }
}

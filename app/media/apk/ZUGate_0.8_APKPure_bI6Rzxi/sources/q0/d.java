package q0;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.OverScroller;
import b4.j;
import h0.z0;
import java.util.Arrays;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: v  reason: collision with root package name */
    public static final c f4433v = new c(0);

    /* renamed from: a  reason: collision with root package name */
    public int f4434a;

    /* renamed from: b  reason: collision with root package name */
    public int f4435b;

    /* renamed from: d  reason: collision with root package name */
    public float[] f4437d;

    /* renamed from: e  reason: collision with root package name */
    public float[] f4438e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f4439f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f4440g;

    /* renamed from: h  reason: collision with root package name */
    public int[] f4441h;

    /* renamed from: i  reason: collision with root package name */
    public int[] f4442i;

    /* renamed from: j  reason: collision with root package name */
    public int[] f4443j;

    /* renamed from: k  reason: collision with root package name */
    public int f4444k;

    /* renamed from: l  reason: collision with root package name */
    public VelocityTracker f4445l;

    /* renamed from: m  reason: collision with root package name */
    public final float f4446m;

    /* renamed from: n  reason: collision with root package name */
    public final float f4447n;
    public final int o;

    /* renamed from: p  reason: collision with root package name */
    public final OverScroller f4448p;

    /* renamed from: q  reason: collision with root package name */
    public final j f4449q;

    /* renamed from: r  reason: collision with root package name */
    public View f4450r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f4451s;

    /* renamed from: t  reason: collision with root package name */
    public final ViewGroup f4452t;

    /* renamed from: c  reason: collision with root package name */
    public int f4436c = -1;

    /* renamed from: u  reason: collision with root package name */
    public final androidx.activity.j f4453u = new androidx.activity.j(8, this);

    public d(Context context, ViewGroup viewGroup, j jVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f4452t = viewGroup;
        this.f4449q = jVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f4435b = viewConfiguration.getScaledTouchSlop();
        this.f4446m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f4447n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f4448p = new OverScroller(context, f4433v);
    }

    public final void a() {
        this.f4436c = -1;
        float[] fArr = this.f4437d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f4438e, 0.0f);
            Arrays.fill(this.f4439f, 0.0f);
            Arrays.fill(this.f4440g, 0.0f);
            Arrays.fill(this.f4441h, 0);
            Arrays.fill(this.f4442i, 0);
            Arrays.fill(this.f4443j, 0);
            this.f4444k = 0;
        }
        VelocityTracker velocityTracker = this.f4445l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f4445l = null;
        }
    }

    public final void b(View view, int i5) {
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = this.f4452t;
        if (parent != viewGroup) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + viewGroup + ")");
        }
        this.f4450r = view;
        this.f4436c = i5;
        this.f4449q.G(view, i5);
        p(1);
    }

    public final boolean c(float f5, float f6, int i5, int i6) {
        float abs = Math.abs(f5);
        float abs2 = Math.abs(f6);
        if ((this.f4441h[i5] & i6) != i6 || (0 & i6) == 0 || (this.f4443j[i5] & i6) == i6 || (this.f4442i[i5] & i6) == i6) {
            return false;
        }
        int i7 = this.f4435b;
        if (abs > i7 || abs2 > i7) {
            if (abs < abs2 * 0.5f) {
                this.f4449q.getClass();
            }
            return (this.f4442i[i5] & i6) == 0 && abs > ((float) this.f4435b);
        }
        return false;
    }

    public final boolean d(View view, float f5, float f6) {
        if (view == null) {
            return false;
        }
        j jVar = this.f4449q;
        boolean z4 = jVar.z(view) > 0;
        boolean z5 = jVar.A() > 0;
        if (!z4 || !z5) {
            return z4 ? Math.abs(f5) > ((float) this.f4435b) : z5 && Math.abs(f6) > ((float) this.f4435b);
        }
        float f7 = f6 * f6;
        int i5 = this.f4435b;
        return f7 + (f5 * f5) > ((float) (i5 * i5));
    }

    public final void e(int i5) {
        float[] fArr = this.f4437d;
        if (fArr != null) {
            int i6 = this.f4444k;
            int i7 = 1 << i5;
            if ((i7 & i6) != 0) {
                fArr[i5] = 0.0f;
                this.f4438e[i5] = 0.0f;
                this.f4439f[i5] = 0.0f;
                this.f4440g[i5] = 0.0f;
                this.f4441h[i5] = 0;
                this.f4442i[i5] = 0;
                this.f4443j[i5] = 0;
                this.f4444k = (~i7) & i6;
            }
        }
    }

    public final int f(int i5, int i6, int i7) {
        int width;
        if (i5 == 0) {
            return 0;
        }
        float width2 = this.f4452t.getWidth() / 2;
        float sin = (((float) Math.sin((Math.min(1.0f, Math.abs(i5) / width) - 0.5f) * 0.47123894f)) * width2) + width2;
        int abs = Math.abs(i6);
        return Math.min(abs > 0 ? Math.round(Math.abs(sin / abs) * 1000.0f) * 4 : (int) (((Math.abs(i5) / i7) + 1.0f) * 256.0f), 600);
    }

    public final boolean g() {
        if (this.f4434a == 2) {
            OverScroller overScroller = this.f4448p;
            boolean computeScrollOffset = overScroller.computeScrollOffset();
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int left = currX - this.f4450r.getLeft();
            int top = currY - this.f4450r.getTop();
            if (left != 0) {
                View view = this.f4450r;
                WeakHashMap weakHashMap = z0.f3233a;
                view.offsetLeftAndRight(left);
            }
            if (top != 0) {
                View view2 = this.f4450r;
                WeakHashMap weakHashMap2 = z0.f3233a;
                view2.offsetTopAndBottom(top);
            }
            if (left != 0 || top != 0) {
                this.f4449q.I(this.f4450r, currX, currY);
            }
            if (computeScrollOffset && currX == overScroller.getFinalX() && currY == overScroller.getFinalY()) {
                overScroller.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                this.f4452t.post(this.f4453u);
            }
        }
        return this.f4434a == 2;
    }

    public final View h(int i5, int i6) {
        ViewGroup viewGroup = this.f4452t;
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            this.f4449q.getClass();
            View childAt = viewGroup.getChildAt(childCount);
            if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && i6 >= childAt.getTop() && i6 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i(int r11, int r12, int r13, int r14) {
        /*
            r10 = this;
            android.view.View r0 = r10.f4450r
            int r2 = r0.getLeft()
            android.view.View r0 = r10.f4450r
            int r3 = r0.getTop()
            int r4 = r11 - r2
            int r5 = r12 - r3
            android.widget.OverScroller r1 = r10.f4448p
            r11 = 0
            if (r4 != 0) goto L1e
            if (r5 != 0) goto L1e
            r1.abortAnimation()
            r10.p(r11)
            return r11
        L1e:
            android.view.View r12 = r10.f4450r
            float r0 = r10.f4447n
            int r0 = (int) r0
            float r6 = r10.f4446m
            int r6 = (int) r6
            int r7 = java.lang.Math.abs(r13)
            if (r7 >= r0) goto L2e
            r13 = r11
            goto L35
        L2e:
            if (r7 <= r6) goto L35
            if (r13 <= 0) goto L34
            r13 = r6
            goto L35
        L34:
            int r13 = -r6
        L35:
            int r7 = java.lang.Math.abs(r14)
            if (r7 >= r0) goto L3c
            goto L43
        L3c:
            if (r7 <= r6) goto L44
            if (r14 <= 0) goto L42
            r14 = r6
            goto L44
        L42:
            int r11 = -r6
        L43:
            r14 = r11
        L44:
            int r11 = java.lang.Math.abs(r4)
            int r0 = java.lang.Math.abs(r5)
            int r6 = java.lang.Math.abs(r13)
            int r7 = java.lang.Math.abs(r14)
            int r8 = r6 + r7
            int r9 = r11 + r0
            if (r13 == 0) goto L5d
            float r11 = (float) r6
            float r6 = (float) r8
            goto L5f
        L5d:
            float r11 = (float) r11
            float r6 = (float) r9
        L5f:
            float r11 = r11 / r6
            if (r14 == 0) goto L65
            float r0 = (float) r7
            float r6 = (float) r8
            goto L67
        L65:
            float r0 = (float) r0
            float r6 = (float) r9
        L67:
            float r0 = r0 / r6
            b4.j r6 = r10.f4449q
            int r12 = r6.z(r12)
            int r12 = r10.f(r4, r13, r12)
            int r13 = r6.A()
            int r13 = r10.f(r5, r14, r13)
            float r12 = (float) r12
            float r12 = r12 * r11
            float r11 = (float) r13
            float r11 = r11 * r0
            float r11 = r11 + r12
            int r6 = (int) r11
            r1.startScroll(r2, r3, r4, r5, r6)
            r11 = 2
            r10.p(r11)
            r11 = 1
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: q0.d.i(int, int, int, int):boolean");
    }

    public final boolean j(int i5) {
        if ((this.f4444k & (1 << i5)) != 0) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i5 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public final void k(MotionEvent motionEvent) {
        int i5;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f4445l == null) {
            this.f4445l = VelocityTracker.obtain();
        }
        this.f4445l.addMovement(motionEvent);
        int i6 = 0;
        j jVar = this.f4449q;
        if (actionMasked == 0) {
            float x5 = motionEvent.getX();
            float y5 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View h5 = h((int) x5, (int) y5);
            n(x5, y5, pointerId);
            s(h5, pointerId);
            if ((this.f4441h[pointerId] & 0) != 0) {
                jVar.getClass();
            }
        } else if (actionMasked == 1) {
            if (this.f4434a == 1) {
                l();
            }
            a();
        } else if (actionMasked == 2) {
            if (this.f4434a != 1) {
                int pointerCount = motionEvent.getPointerCount();
                while (i6 < pointerCount) {
                    int pointerId2 = motionEvent.getPointerId(i6);
                    if (j(pointerId2)) {
                        float x6 = motionEvent.getX(i6);
                        float y6 = motionEvent.getY(i6);
                        float f5 = x6 - this.f4437d[pointerId2];
                        float f6 = y6 - this.f4438e[pointerId2];
                        m(f5, f6, pointerId2);
                        if (this.f4434a != 1) {
                            View h6 = h((int) x6, (int) y6);
                            if (d(h6, f5, f6) && s(h6, pointerId2)) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    i6++;
                }
                o(motionEvent);
            } else if (j(this.f4436c)) {
                int findPointerIndex = motionEvent.findPointerIndex(this.f4436c);
                float x7 = motionEvent.getX(findPointerIndex);
                float y7 = motionEvent.getY(findPointerIndex);
                float[] fArr = this.f4439f;
                int i7 = this.f4436c;
                int i8 = (int) (x7 - fArr[i7]);
                int i9 = (int) (y7 - this.f4440g[i7]);
                int left = this.f4450r.getLeft() + i8;
                int top = this.f4450r.getTop() + i9;
                int left2 = this.f4450r.getLeft();
                int top2 = this.f4450r.getTop();
                if (i8 != 0) {
                    left = jVar.h(this.f4450r, left);
                    WeakHashMap weakHashMap = z0.f3233a;
                    this.f4450r.offsetLeftAndRight(left - left2);
                }
                if (i9 != 0) {
                    top = jVar.i(this.f4450r, top);
                    WeakHashMap weakHashMap2 = z0.f3233a;
                    this.f4450r.offsetTopAndBottom(top - top2);
                }
                if (i8 != 0 || i9 != 0) {
                    jVar.I(this.f4450r, left, top);
                }
                o(motionEvent);
            }
        } else if (actionMasked == 3) {
            if (this.f4434a == 1) {
                this.f4451s = true;
                jVar.J(this.f4450r, 0.0f, 0.0f);
                this.f4451s = false;
                if (this.f4434a == 1) {
                    p(0);
                }
            }
            a();
        } else if (actionMasked != 5) {
            if (actionMasked != 6) {
                return;
            }
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            if (this.f4434a == 1 && pointerId3 == this.f4436c) {
                int pointerCount2 = motionEvent.getPointerCount();
                while (true) {
                    if (i6 >= pointerCount2) {
                        i5 = -1;
                        break;
                    }
                    int pointerId4 = motionEvent.getPointerId(i6);
                    if (pointerId4 != this.f4436c) {
                        View h7 = h((int) motionEvent.getX(i6), (int) motionEvent.getY(i6));
                        View view = this.f4450r;
                        if (h7 == view && s(view, pointerId4)) {
                            i5 = this.f4436c;
                            break;
                        }
                    }
                    i6++;
                }
                if (i5 == -1) {
                    l();
                }
            }
            e(pointerId3);
        } else {
            int pointerId5 = motionEvent.getPointerId(actionIndex);
            float x8 = motionEvent.getX(actionIndex);
            float y8 = motionEvent.getY(actionIndex);
            n(x8, y8, pointerId5);
            if (this.f4434a == 0) {
                s(h((int) x8, (int) y8), pointerId5);
                if ((this.f4441h[pointerId5] & 0) != 0) {
                    jVar.getClass();
                    return;
                }
                return;
            }
            int i10 = (int) x8;
            int i11 = (int) y8;
            View view2 = this.f4450r;
            if (view2 != null && i10 >= view2.getLeft() && i10 < view2.getRight() && i11 >= view2.getTop() && i11 < view2.getBottom()) {
                i6 = 1;
            }
            if (i6 != 0) {
                s(this.f4450r, pointerId5);
            }
        }
    }

    public final void l() {
        VelocityTracker velocityTracker = this.f4445l;
        float f5 = this.f4446m;
        velocityTracker.computeCurrentVelocity(1000, f5);
        float xVelocity = this.f4445l.getXVelocity(this.f4436c);
        float abs = Math.abs(xVelocity);
        float f6 = this.f4447n;
        float f7 = 0.0f;
        if (abs < f6) {
            xVelocity = 0.0f;
        } else if (abs > f5) {
            xVelocity = xVelocity > 0.0f ? f5 : -f5;
        }
        float yVelocity = this.f4445l.getYVelocity(this.f4436c);
        float abs2 = Math.abs(yVelocity);
        if (abs2 >= f6) {
            if (abs2 > f5) {
                if (yVelocity <= 0.0f) {
                    f5 = -f5;
                }
                f7 = f5;
            } else {
                f7 = yVelocity;
            }
        }
        this.f4451s = true;
        this.f4449q.J(this.f4450r, xVelocity, f7);
        this.f4451s = false;
        if (this.f4434a == 1) {
            p(0);
        }
    }

    public final void m(float f5, float f6, int i5) {
        boolean c5 = c(f5, f6, i5, 1);
        if (c(f6, f5, i5, 4)) {
            c5 |= true;
        }
        if (c(f5, f6, i5, 2)) {
            c5 |= true;
        }
        if (c(f6, f5, i5, 8)) {
            c5 |= true;
        }
        if (c5) {
            int[] iArr = this.f4442i;
            iArr[i5] = iArr[i5] | c5;
            this.f4449q.getClass();
        }
    }

    public final void n(float f5, float f6, int i5) {
        float[] fArr = this.f4437d;
        if (fArr == null || fArr.length <= i5) {
            int i6 = i5 + 1;
            float[] fArr2 = new float[i6];
            float[] fArr3 = new float[i6];
            float[] fArr4 = new float[i6];
            float[] fArr5 = new float[i6];
            int[] iArr = new int[i6];
            int[] iArr2 = new int[i6];
            int[] iArr3 = new int[i6];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f4438e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f4439f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f4440g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f4441h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f4442i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f4443j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f4437d = fArr2;
            this.f4438e = fArr3;
            this.f4439f = fArr4;
            this.f4440g = fArr5;
            this.f4441h = iArr;
            this.f4442i = iArr2;
            this.f4443j = iArr3;
        }
        float[] fArr9 = this.f4437d;
        this.f4439f[i5] = f5;
        fArr9[i5] = f5;
        float[] fArr10 = this.f4438e;
        this.f4440g[i5] = f6;
        fArr10[i5] = f6;
        int[] iArr7 = this.f4441h;
        int i7 = (int) f5;
        int i8 = (int) f6;
        ViewGroup viewGroup = this.f4452t;
        int left = viewGroup.getLeft();
        int i9 = this.o;
        int i10 = i7 < left + i9 ? 1 : 0;
        if (i8 < viewGroup.getTop() + i9) {
            i10 |= 4;
        }
        if (i7 > viewGroup.getRight() - i9) {
            i10 |= 2;
        }
        if (i8 > viewGroup.getBottom() - i9) {
            i10 |= 8;
        }
        iArr7[i5] = i10;
        this.f4444k |= 1 << i5;
    }

    public final void o(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i5 = 0; i5 < pointerCount; i5++) {
            int pointerId = motionEvent.getPointerId(i5);
            if (j(pointerId)) {
                float x5 = motionEvent.getX(i5);
                float y5 = motionEvent.getY(i5);
                this.f4439f[pointerId] = x5;
                this.f4440g[pointerId] = y5;
            }
        }
    }

    public final void p(int i5) {
        this.f4452t.removeCallbacks(this.f4453u);
        if (this.f4434a != i5) {
            this.f4434a = i5;
            this.f4449q.H(i5);
            if (this.f4434a == 0) {
                this.f4450r = null;
            }
        }
    }

    public final boolean q(int i5, int i6) {
        if (this.f4451s) {
            return i(i5, i6, (int) this.f4445l.getXVelocity(this.f4436c), (int) this.f4445l.getYVelocity(this.f4436c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00d2, code lost:
        if (r13 != r12) goto L57;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean r(android.view.MotionEvent r19) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q0.d.r(android.view.MotionEvent):boolean");
    }

    public final boolean s(View view, int i5) {
        if (view == this.f4450r && this.f4436c == i5) {
            return true;
        }
        if (view == null || !this.f4449q.d0(view, i5)) {
            return false;
        }
        this.f4436c = i5;
        b(view, i5);
        return true;
    }
}

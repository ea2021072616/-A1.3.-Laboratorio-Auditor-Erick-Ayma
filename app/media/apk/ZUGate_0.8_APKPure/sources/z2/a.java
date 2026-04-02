package z2;

import android.view.View;
import android.view.ViewParent;
import b4.j;
import com.google.android.material.behavior.SwipeDismissBehavior;
import h0.z0;
import java.util.WeakHashMap;
import r3.h;
import r3.i;
import r3.l;
import r3.q;
import r3.r;
/* loaded from: classes.dex */
public final class a extends j {

    /* renamed from: x  reason: collision with root package name */
    public int f5808x;

    /* renamed from: y  reason: collision with root package name */
    public int f5809y = -1;

    /* renamed from: z  reason: collision with root package name */
    public final /* synthetic */ SwipeDismissBehavior f5810z;

    public a(SwipeDismissBehavior swipeDismissBehavior) {
        this.f5810z = swipeDismissBehavior;
    }

    @Override // b4.j
    public final void G(View view, int i5) {
        this.f5809y = i5;
        this.f5808x = view.getLeft();
        ViewParent parent = view.getParent();
        if (parent != null) {
            SwipeDismissBehavior swipeDismissBehavior = this.f5810z;
            swipeDismissBehavior.f2015d = true;
            parent.requestDisallowInterceptTouchEvent(true);
            swipeDismissBehavior.f2015d = false;
        }
    }

    @Override // b4.j
    public final void H(int i5) {
        h hVar = this.f5810z.f2013b;
        if (hVar != null) {
            l lVar = hVar.f4501g;
            if (i5 == 0) {
                r b5 = r.b();
                i iVar = lVar.f4538t;
                synchronized (b5.f4547a) {
                    if (b5.c(iVar)) {
                        q qVar = b5.f4549c;
                        if (qVar.f4545c) {
                            qVar.f4545c = false;
                            b5.d(qVar);
                        }
                    }
                }
            } else if (i5 == 1 || i5 == 2) {
                r b6 = r.b();
                i iVar2 = lVar.f4538t;
                synchronized (b6.f4547a) {
                    if (b6.c(iVar2)) {
                        q qVar2 = b6.f4549c;
                        if (!qVar2.f4545c) {
                            qVar2.f4545c = true;
                            b6.f4548b.removeCallbacksAndMessages(qVar2);
                        }
                    }
                }
            }
        }
    }

    @Override // b4.j
    public final void I(View view, int i5, int i6) {
        SwipeDismissBehavior swipeDismissBehavior = this.f5810z;
        float width = view.getWidth() * swipeDismissBehavior.f2018g;
        float width2 = view.getWidth() * swipeDismissBehavior.f2019h;
        float abs = Math.abs(i5 - this.f5808x);
        if (abs <= width) {
            view.setAlpha(1.0f);
        } else if (abs >= width2) {
            view.setAlpha(0.0f);
        } else {
            view.setAlpha(Math.min(Math.max(0.0f, 1.0f - ((abs - width) / (width2 - width))), 1.0f));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
        if (java.lang.Math.abs(r9.getLeft() - r8.f5808x) >= java.lang.Math.round(r9.getWidth() * r3.f2017f)) goto L39;
     */
    @Override // b4.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void J(android.view.View r9, float r10, float r11) {
        /*
            r8 = this;
            r11 = -1
            r8.f5809y = r11
            int r11 = r9.getWidth()
            r0 = 0
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            r2 = 1
            com.google.android.material.behavior.SwipeDismissBehavior r3 = r8.f5810z
            r4 = 0
            if (r1 == 0) goto L39
            java.util.WeakHashMap r5 = h0.z0.f3233a
            int r5 = r9.getLayoutDirection()
            if (r5 != r2) goto L1a
            r5 = r2
            goto L1b
        L1a:
            r5 = r4
        L1b:
            int r6 = r3.f2016e
            r7 = 2
            if (r6 != r7) goto L21
            goto L52
        L21:
            if (r6 != 0) goto L2d
            if (r5 == 0) goto L2a
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L54
            goto L52
        L2a:
            if (r1 <= 0) goto L54
            goto L52
        L2d:
            if (r6 != r2) goto L54
            if (r5 == 0) goto L34
            if (r1 <= 0) goto L54
            goto L52
        L34:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L54
            goto L52
        L39:
            int r1 = r9.getLeft()
            int r5 = r8.f5808x
            int r1 = r1 - r5
            int r5 = r9.getWidth()
            float r5 = (float) r5
            float r6 = r3.f2017f
            float r5 = r5 * r6
            int r5 = java.lang.Math.round(r5)
            int r1 = java.lang.Math.abs(r1)
            if (r1 < r5) goto L54
        L52:
            r1 = r2
            goto L55
        L54:
            r1 = r4
        L55:
            if (r1 == 0) goto L6b
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 < 0) goto L66
            int r10 = r9.getLeft()
            int r0 = r8.f5808x
            if (r10 >= r0) goto L64
            goto L66
        L64:
            int r0 = r0 + r11
            goto L6e
        L66:
            int r10 = r8.f5808x
            int r0 = r10 - r11
            goto L6e
        L6b:
            int r0 = r8.f5808x
            r2 = r4
        L6e:
            q0.d r10 = r3.f2012a
            int r11 = r9.getTop()
            boolean r10 = r10.q(r0, r11)
            if (r10 == 0) goto L85
            z2.b r10 = new z2.b
            r10.<init>(r3, r9, r2)
            java.util.WeakHashMap r11 = h0.z0.f3233a
            r9.postOnAnimation(r10)
            goto L8e
        L85:
            if (r2 == 0) goto L8e
            r3.h r10 = r3.f2013b
            if (r10 == 0) goto L8e
            r10.b(r9)
        L8e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: z2.a.J(android.view.View, float, float):void");
    }

    @Override // b4.j
    public final boolean d0(View view, int i5) {
        int i6 = this.f5809y;
        return (i6 == -1 || i6 == i5) && this.f5810z.v(view);
    }

    @Override // b4.j
    public final int h(View view, int i5) {
        int width;
        int width2;
        int width3;
        WeakHashMap weakHashMap = z0.f3233a;
        boolean z4 = view.getLayoutDirection() == 1;
        int i6 = this.f5810z.f2016e;
        if (i6 == 0) {
            if (z4) {
                width = this.f5808x - view.getWidth();
                width2 = this.f5808x;
            } else {
                width = this.f5808x;
                width3 = view.getWidth();
                width2 = width3 + width;
            }
        } else if (i6 != 1) {
            width = this.f5808x - view.getWidth();
            width2 = view.getWidth() + this.f5808x;
        } else if (z4) {
            width = this.f5808x;
            width3 = view.getWidth();
            width2 = width3 + width;
        } else {
            width = this.f5808x - view.getWidth();
            width2 = this.f5808x;
        }
        return Math.min(Math.max(width, i5), width2);
    }

    @Override // b4.j
    public final int i(View view, int i5) {
        return view.getTop();
    }

    @Override // b4.j
    public final int z(View view) {
        return view.getWidth();
    }
}

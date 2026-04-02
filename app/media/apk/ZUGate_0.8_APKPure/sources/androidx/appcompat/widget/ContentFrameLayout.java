package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: g  reason: collision with root package name */
    public TypedValue f212g;

    /* renamed from: h  reason: collision with root package name */
    public TypedValue f213h;

    /* renamed from: i  reason: collision with root package name */
    public TypedValue f214i;

    /* renamed from: j  reason: collision with root package name */
    public TypedValue f215j;

    /* renamed from: k  reason: collision with root package name */
    public TypedValue f216k;

    /* renamed from: l  reason: collision with root package name */
    public TypedValue f217l;

    /* renamed from: m  reason: collision with root package name */
    public final Rect f218m;

    /* renamed from: n  reason: collision with root package name */
    public q1 f219n;

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f218m = new Rect();
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f216k == null) {
            this.f216k = new TypedValue();
        }
        return this.f216k;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f217l == null) {
            this.f217l = new TypedValue();
        }
        return this.f217l;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f214i == null) {
            this.f214i = new TypedValue();
        }
        return this.f214i;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f215j == null) {
            this.f215j = new TypedValue();
        }
        return this.f215j;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f212g == null) {
            this.f212g = new TypedValue();
        }
        return this.f212g;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f213h == null) {
            this.f213h = new TypedValue();
        }
        return this.f213h;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        q1 q1Var = this.f219n;
        if (q1Var != null) {
            q1Var.getClass();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        n nVar;
        super.onDetachedFromWindow();
        q1 q1Var = this.f219n;
        if (q1Var != null) {
            d.n0 n0Var = ((d.a0) q1Var).f2280h;
            r1 r1Var = n0Var.f2439x;
            if (r1Var != null) {
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) r1Var;
                actionBarOverlayLayout.k();
                ActionMenuView actionMenuView = ((p3) actionBarOverlayLayout.f188k).f486a.f249g;
                if (actionMenuView != null && (nVar = actionMenuView.f207z) != null) {
                    nVar.f();
                    i iVar = nVar.f432z;
                    if (iVar != null && iVar.b()) {
                        iVar.f3087j.dismiss();
                    }
                }
            }
            if (n0Var.C != null) {
                n0Var.f2433r.getDecorView().removeCallbacks(n0Var.D);
                if (n0Var.C.isShowing()) {
                    try {
                        n0Var.C.dismiss();
                    } catch (IllegalArgumentException unused) {
                    }
                }
                n0Var.C = null;
            }
            h0.k1 k1Var = n0Var.E;
            if (k1Var != null) {
                k1Var.b();
            }
            h.o oVar = n0Var.B(0).f2406h;
            if (oVar != null) {
                oVar.c(true);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ac A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r17, int r18) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(q1 q1Var) {
        this.f219n = q1Var;
    }
}

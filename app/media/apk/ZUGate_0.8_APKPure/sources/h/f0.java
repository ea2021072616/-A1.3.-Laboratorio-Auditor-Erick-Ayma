package h;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.b2;
import androidx.appcompat.widget.j0;
import androidx.appcompat.widget.t2;
import com.github.appintro.R;
/* loaded from: classes.dex */
public final class f0 extends w implements PopupWindow.OnDismissListener, View.OnKeyListener {
    public boolean A;

    /* renamed from: h  reason: collision with root package name */
    public final Context f2968h;

    /* renamed from: i  reason: collision with root package name */
    public final o f2969i;

    /* renamed from: j  reason: collision with root package name */
    public final l f2970j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f2971k;

    /* renamed from: l  reason: collision with root package name */
    public final int f2972l;

    /* renamed from: m  reason: collision with root package name */
    public final int f2973m;

    /* renamed from: n  reason: collision with root package name */
    public final int f2974n;
    public final t2 o;

    /* renamed from: r  reason: collision with root package name */
    public PopupWindow.OnDismissListener f2977r;

    /* renamed from: s  reason: collision with root package name */
    public View f2978s;

    /* renamed from: t  reason: collision with root package name */
    public View f2979t;

    /* renamed from: u  reason: collision with root package name */
    public z f2980u;

    /* renamed from: v  reason: collision with root package name */
    public ViewTreeObserver f2981v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f2982w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f2983x;

    /* renamed from: y  reason: collision with root package name */
    public int f2984y;

    /* renamed from: p  reason: collision with root package name */
    public final e f2975p = new e(1, this);

    /* renamed from: q  reason: collision with root package name */
    public final f f2976q = new f(1, this);

    /* renamed from: z  reason: collision with root package name */
    public int f2985z = 0;

    public f0(int i5, int i6, Context context, View view, o oVar, boolean z4) {
        this.f2968h = context;
        this.f2969i = oVar;
        this.f2971k = z4;
        this.f2970j = new l(oVar, LayoutInflater.from(context), z4, R.layout.abc_popup_menu_item_layout);
        this.f2973m = i5;
        this.f2974n = i6;
        Resources resources = context.getResources();
        this.f2972l = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f2978s = view;
        this.o = new t2(context, i5, i6);
        oVar.b(this, context);
    }

    @Override // h.e0
    public final boolean a() {
        return !this.f2982w && this.o.a();
    }

    @Override // h.a0
    public final void b(o oVar, boolean z4) {
        if (oVar != this.f2969i) {
            return;
        }
        dismiss();
        z zVar = this.f2980u;
        if (zVar != null) {
            zVar.b(oVar, z4);
        }
    }

    @Override // h.a0
    public final void c(z zVar) {
        this.f2980u = zVar;
    }

    @Override // h.e0
    public final void dismiss() {
        if (a()) {
            this.o.dismiss();
        }
    }

    @Override // h.a0
    public final boolean e() {
        return false;
    }

    @Override // h.e0
    public final void f() {
        View view;
        boolean z4 = true;
        if (!a()) {
            if (this.f2982w || (view = this.f2978s) == null) {
                z4 = false;
            } else {
                this.f2979t = view;
                t2 t2Var = this.o;
                t2Var.F.setOnDismissListener(this);
                t2Var.f464v = this;
                t2Var.E = true;
                j0 j0Var = t2Var.F;
                j0Var.setFocusable(true);
                View view2 = this.f2979t;
                boolean z5 = this.f2981v == null;
                ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                this.f2981v = viewTreeObserver;
                if (z5) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.f2975p);
                }
                view2.addOnAttachStateChangeListener(this.f2976q);
                t2Var.f463u = view2;
                t2Var.f460r = this.f2985z;
                boolean z6 = this.f2983x;
                Context context = this.f2968h;
                l lVar = this.f2970j;
                if (!z6) {
                    this.f2984y = w.m(lVar, context, this.f2972l);
                    this.f2983x = true;
                }
                t2Var.r(this.f2984y);
                j0Var.setInputMethodMode(2);
                Rect rect = this.f3076g;
                t2Var.D = rect != null ? new Rect(rect) : null;
                t2Var.f();
                b2 b2Var = t2Var.f452i;
                b2Var.setOnKeyListener(this);
                if (this.A) {
                    o oVar = this.f2969i;
                    if (oVar.f3036s != null) {
                        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) b2Var, false);
                        TextView textView = (TextView) frameLayout.findViewById(16908310);
                        if (textView != null) {
                            textView.setText(oVar.f3036s);
                        }
                        frameLayout.setEnabled(false);
                        b2Var.addHeaderView(frameLayout, null, false);
                    }
                }
                t2Var.o(lVar);
                t2Var.f();
            }
        }
        if (!z4) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // h.a0
    public final void h() {
        this.f2983x = false;
        l lVar = this.f2970j;
        if (lVar != null) {
            lVar.notifyDataSetChanged();
        }
    }

    @Override // h.e0
    public final b2 j() {
        return this.o.f452i;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    @Override // h.a0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean k(h.g0 r10) {
        /*
            r9 = this;
            boolean r0 = r10.hasVisibleItems()
            r1 = 0
            if (r0 == 0) goto L78
            h.y r0 = new h.y
            android.content.Context r5 = r9.f2968h
            android.view.View r6 = r9.f2979t
            boolean r8 = r9.f2971k
            int r3 = r9.f2973m
            int r4 = r9.f2974n
            r2 = r0
            r7 = r10
            r2.<init>(r3, r4, r5, r6, r7, r8)
            h.z r2 = r9.f2980u
            r0.f3086i = r2
            h.w r3 = r0.f3087j
            if (r3 == 0) goto L23
            r3.c(r2)
        L23:
            boolean r2 = h.w.u(r10)
            r0.f3085h = r2
            h.w r3 = r0.f3087j
            if (r3 == 0) goto L30
            r3.o(r2)
        L30:
            android.widget.PopupWindow$OnDismissListener r2 = r9.f2977r
            r0.f3088k = r2
            r2 = 0
            r9.f2977r = r2
            h.o r2 = r9.f2969i
            r2.c(r1)
            androidx.appcompat.widget.t2 r2 = r9.o
            int r3 = r2.f455l
            int r2 = r2.e()
            int r4 = r9.f2985z
            android.view.View r5 = r9.f2978s
            int r5 = r5.getLayoutDirection()
            int r4 = android.view.Gravity.getAbsoluteGravity(r4, r5)
            r4 = r4 & 7
            r5 = 5
            if (r4 != r5) goto L5c
            android.view.View r4 = r9.f2978s
            int r4 = r4.getWidth()
            int r3 = r3 + r4
        L5c:
            boolean r4 = r0.b()
            r5 = 1
            if (r4 == 0) goto L64
            goto L6d
        L64:
            android.view.View r4 = r0.f3083f
            if (r4 != 0) goto L6a
            r0 = r1
            goto L6e
        L6a:
            r0.d(r3, r2, r5, r5)
        L6d:
            r0 = r5
        L6e:
            if (r0 == 0) goto L78
            h.z r0 = r9.f2980u
            if (r0 == 0) goto L77
            r0.h(r10)
        L77:
            return r5
        L78:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: h.f0.k(h.g0):boolean");
    }

    @Override // h.w
    public final void l(o oVar) {
    }

    @Override // h.w
    public final void n(View view) {
        this.f2978s = view;
    }

    @Override // h.w
    public final void o(boolean z4) {
        this.f2970j.f3021c = z4;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.f2982w = true;
        this.f2969i.c(true);
        ViewTreeObserver viewTreeObserver = this.f2981v;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f2981v = this.f2979t.getViewTreeObserver();
            }
            this.f2981v.removeGlobalOnLayoutListener(this.f2975p);
            this.f2981v = null;
        }
        this.f2979t.removeOnAttachStateChangeListener(this.f2976q);
        PopupWindow.OnDismissListener onDismissListener = this.f2977r;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i5, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i5 == 82) {
            dismiss();
            return true;
        }
        return false;
    }

    @Override // h.w
    public final void p(int i5) {
        this.f2985z = i5;
    }

    @Override // h.w
    public final void q(int i5) {
        this.o.f455l = i5;
    }

    @Override // h.w
    public final void r(PopupWindow.OnDismissListener onDismissListener) {
        this.f2977r = onDismissListener;
    }

    @Override // h.w
    public final void s(boolean z4) {
        this.A = z4;
    }

    @Override // h.w
    public final void t(int i5) {
        this.o.n(i5);
    }
}

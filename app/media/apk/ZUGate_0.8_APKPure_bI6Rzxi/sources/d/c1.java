package d;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.k3;
import androidx.appcompat.widget.p3;
import androidx.appcompat.widget.s1;
import com.github.appintro.R;
import h0.k1;
import java.util.ArrayList;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class c1 extends b implements androidx.appcompat.widget.f {

    /* renamed from: y  reason: collision with root package name */
    public static final AccelerateInterpolator f2292y = new AccelerateInterpolator();

    /* renamed from: z  reason: collision with root package name */
    public static final DecelerateInterpolator f2293z = new DecelerateInterpolator();

    /* renamed from: a  reason: collision with root package name */
    public Context f2294a;

    /* renamed from: b  reason: collision with root package name */
    public Context f2295b;

    /* renamed from: c  reason: collision with root package name */
    public ActionBarOverlayLayout f2296c;

    /* renamed from: d  reason: collision with root package name */
    public ActionBarContainer f2297d;

    /* renamed from: e  reason: collision with root package name */
    public s1 f2298e;

    /* renamed from: f  reason: collision with root package name */
    public ActionBarContextView f2299f;

    /* renamed from: g  reason: collision with root package name */
    public final View f2300g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2301h;

    /* renamed from: i  reason: collision with root package name */
    public b1 f2302i;

    /* renamed from: j  reason: collision with root package name */
    public b1 f2303j;

    /* renamed from: k  reason: collision with root package name */
    public g.a f2304k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f2305l;

    /* renamed from: m  reason: collision with root package name */
    public final ArrayList f2306m;

    /* renamed from: n  reason: collision with root package name */
    public int f2307n;
    public boolean o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f2308p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f2309q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f2310r;

    /* renamed from: s  reason: collision with root package name */
    public g.l f2311s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f2312t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f2313u;

    /* renamed from: v  reason: collision with root package name */
    public final a1 f2314v;

    /* renamed from: w  reason: collision with root package name */
    public final a1 f2315w;

    /* renamed from: x  reason: collision with root package name */
    public final u0 f2316x;

    public c1(Activity activity, boolean z4) {
        new ArrayList();
        this.f2306m = new ArrayList();
        this.f2307n = 0;
        this.o = true;
        this.f2310r = true;
        this.f2314v = new a1(this, 0);
        this.f2315w = new a1(this, 1);
        this.f2316x = new u0(1, this);
        View decorView = activity.getWindow().getDecorView();
        r(decorView);
        if (z4) {
            return;
        }
        this.f2300g = decorView.findViewById(16908290);
    }

    @Override // d.b
    public final boolean b() {
        s1 s1Var = this.f2298e;
        if (s1Var != null) {
            k3 k3Var = ((p3) s1Var).f486a.S;
            if ((k3Var == null || k3Var.f400h == null) ? false : true) {
                k3 k3Var2 = ((p3) s1Var).f486a.S;
                h.q qVar = k3Var2 == null ? null : k3Var2.f400h;
                if (qVar != null) {
                    qVar.collapseActionView();
                }
                return true;
            }
        }
        return false;
    }

    @Override // d.b
    public final void c(boolean z4) {
        if (z4 == this.f2305l) {
            return;
        }
        this.f2305l = z4;
        ArrayList arrayList = this.f2306m;
        if (arrayList.size() <= 0) {
            return;
        }
        androidx.appcompat.widget.b0.n(arrayList.get(0));
        throw null;
    }

    @Override // d.b
    public final int d() {
        return ((p3) this.f2298e).f487b;
    }

    @Override // d.b
    public final Context e() {
        if (this.f2295b == null) {
            TypedValue typedValue = new TypedValue();
            this.f2294a.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            int i5 = typedValue.resourceId;
            if (i5 != 0) {
                this.f2295b = new ContextThemeWrapper(this.f2294a, i5);
            } else {
                this.f2295b = this.f2294a;
            }
        }
        return this.f2295b;
    }

    @Override // d.b
    public final void g() {
        s(this.f2294a.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs));
    }

    @Override // d.b
    public final boolean i(int i5, KeyEvent keyEvent) {
        h.o oVar;
        b1 b1Var = this.f2302i;
        if (b1Var == null || (oVar = b1Var.f2286j) == null) {
            return false;
        }
        oVar.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return oVar.performShortcut(i5, keyEvent, 0);
    }

    @Override // d.b
    public final void l(boolean z4) {
        if (this.f2301h) {
            return;
        }
        m(z4);
    }

    @Override // d.b
    public final void m(boolean z4) {
        int i5 = z4 ? 4 : 0;
        p3 p3Var = (p3) this.f2298e;
        int i6 = p3Var.f487b;
        this.f2301h = true;
        p3Var.b((i5 & 4) | ((-5) & i6));
    }

    @Override // d.b
    public final void n(boolean z4) {
        g.l lVar;
        this.f2312t = z4;
        if (z4 || (lVar = this.f2311s) == null) {
            return;
        }
        lVar.a();
    }

    @Override // d.b
    public final void o(CharSequence charSequence) {
        p3 p3Var = (p3) this.f2298e;
        if (p3Var.f492g) {
            return;
        }
        p3Var.f493h = charSequence;
        if ((p3Var.f487b & 8) != 0) {
            Toolbar toolbar = p3Var.f486a;
            toolbar.setTitle(charSequence);
            if (p3Var.f492g) {
                h0.z0.o(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override // d.b
    public final g.b p(c0 c0Var) {
        b1 b1Var = this.f2302i;
        if (b1Var != null) {
            b1Var.a();
        }
        this.f2296c.setHideOnContentScrollEnabled(false);
        this.f2299f.e();
        b1 b1Var2 = new b1(this, this.f2299f.getContext(), c0Var);
        h.o oVar = b1Var2.f2286j;
        oVar.w();
        try {
            if (b1Var2.f2287k.c(b1Var2, oVar)) {
                this.f2302i = b1Var2;
                b1Var2.i();
                this.f2299f.c(b1Var2);
                q(true);
                return b1Var2;
            }
            return null;
        } finally {
            oVar.v();
        }
    }

    public final void q(boolean z4) {
        k1 l5;
        k1 k1Var;
        if (z4) {
            if (!this.f2309q) {
                this.f2309q = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.f2296c;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                t(false);
            }
        } else if (this.f2309q) {
            this.f2309q = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f2296c;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            t(false);
        }
        if (!this.f2297d.isLaidOut()) {
            if (z4) {
                ((p3) this.f2298e).f486a.setVisibility(4);
                this.f2299f.setVisibility(0);
                return;
            }
            ((p3) this.f2298e).f486a.setVisibility(0);
            this.f2299f.setVisibility(8);
            return;
        }
        if (z4) {
            p3 p3Var = (p3) this.f2298e;
            l5 = h0.z0.a(p3Var.f486a);
            l5.a(0.0f);
            l5.c(100L);
            l5.d(new g.k(p3Var, 4));
            k1Var = this.f2299f.l(200L, 0);
        } else {
            p3 p3Var2 = (p3) this.f2298e;
            k1 a5 = h0.z0.a(p3Var2.f486a);
            a5.a(1.0f);
            a5.c(200L);
            a5.d(new g.k(p3Var2, 0));
            l5 = this.f2299f.l(100L, 8);
            k1Var = a5;
        }
        g.l lVar = new g.l();
        ArrayList arrayList = lVar.f2920a;
        arrayList.add(l5);
        View view = (View) l5.f3165a.get();
        long duration = view != null ? view.animate().getDuration() : 0L;
        View view2 = (View) k1Var.f3165a.get();
        if (view2 != null) {
            view2.animate().setStartDelay(duration);
        }
        arrayList.add(k1Var);
        lVar.b();
    }

    public final void r(View view) {
        s1 wrapper;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R.id.decor_content_parent);
        this.f2296c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        View findViewById = view.findViewById(R.id.action_bar);
        if (findViewById instanceof s1) {
            wrapper = (s1) findViewById;
        } else if (!(findViewById instanceof Toolbar)) {
            throw new IllegalStateException("Can't make a decor toolbar out of ".concat(findViewById != null ? findViewById.getClass().getSimpleName() : "null"));
        } else {
            wrapper = ((Toolbar) findViewById).getWrapper();
        }
        this.f2298e = wrapper;
        this.f2299f = (ActionBarContextView) view.findViewById(R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R.id.action_bar_container);
        this.f2297d = actionBarContainer;
        s1 s1Var = this.f2298e;
        if (s1Var == null || this.f2299f == null || actionBarContainer == null) {
            throw new IllegalStateException(c1.class.getSimpleName().concat(" can only be used with a compatible window decor layout"));
        }
        Context a5 = ((p3) s1Var).a();
        this.f2294a = a5;
        if ((((p3) this.f2298e).f487b & 4) != 0) {
            this.f2301h = true;
        }
        if (a5.getApplicationInfo().targetSdkVersion < 14) {
        }
        this.f2298e.getClass();
        s(a5.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs));
        TypedArray obtainStyledAttributes = this.f2294a.obtainStyledAttributes(null, c.a.f1684a, R.attr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(14, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f2296c;
            if (!actionBarOverlayLayout2.f190m) {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
            this.f2313u = true;
            actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(12, 0);
        if (dimensionPixelSize != 0) {
            ActionBarContainer actionBarContainer2 = this.f2297d;
            WeakHashMap weakHashMap = h0.z0.f3233a;
            h0.o0.s(actionBarContainer2, dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    public final void s(boolean z4) {
        if (z4) {
            this.f2297d.setTabContainer(null);
            ((p3) this.f2298e).getClass();
        } else {
            ((p3) this.f2298e).getClass();
            this.f2297d.setTabContainer(null);
        }
        this.f2298e.getClass();
        ((p3) this.f2298e).f486a.setCollapsible(false);
        this.f2296c.setHasNonEmbeddedTabs(false);
    }

    public final void t(boolean z4) {
        int[] iArr;
        int[] iArr2;
        boolean z5 = this.f2309q || !this.f2308p;
        final u0 u0Var = this.f2316x;
        View view = this.f2300g;
        if (!z5) {
            if (this.f2310r) {
                this.f2310r = false;
                g.l lVar = this.f2311s;
                if (lVar != null) {
                    lVar.a();
                }
                int i5 = this.f2307n;
                a1 a1Var = this.f2314v;
                if (i5 != 0 || (!this.f2312t && !z4)) {
                    a1Var.a();
                    return;
                }
                this.f2297d.setAlpha(1.0f);
                this.f2297d.setTransitioning(true);
                g.l lVar2 = new g.l();
                float f5 = -this.f2297d.getHeight();
                if (z4) {
                    this.f2297d.getLocationInWindow(new int[]{0, 0});
                    f5 -= iArr[1];
                }
                k1 a5 = h0.z0.a(this.f2297d);
                a5.e(f5);
                final View view2 = (View) a5.f3165a.get();
                if (view2 != null) {
                    view2.animate().setUpdateListener(u0Var != null ? new ValueAnimator.AnimatorUpdateListener(view2) { // from class: h0.i1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            ((View) ((d.c1) d.u0.this.f2463h).f2297d.getParent()).invalidate();
                        }
                    } : null);
                }
                boolean z6 = lVar2.f2924e;
                ArrayList arrayList = lVar2.f2920a;
                if (!z6) {
                    arrayList.add(a5);
                }
                if (this.o && view != null) {
                    k1 a6 = h0.z0.a(view);
                    a6.e(f5);
                    if (!lVar2.f2924e) {
                        arrayList.add(a6);
                    }
                }
                AccelerateInterpolator accelerateInterpolator = f2292y;
                boolean z7 = lVar2.f2924e;
                if (!z7) {
                    lVar2.f2922c = accelerateInterpolator;
                }
                if (!z7) {
                    lVar2.f2921b = 250L;
                }
                if (!z7) {
                    lVar2.f2923d = a1Var;
                }
                this.f2311s = lVar2;
                lVar2.b();
            }
        } else if (this.f2310r) {
        } else {
            this.f2310r = true;
            g.l lVar3 = this.f2311s;
            if (lVar3 != null) {
                lVar3.a();
            }
            this.f2297d.setVisibility(0);
            int i6 = this.f2307n;
            a1 a1Var2 = this.f2315w;
            if (i6 == 0 && (this.f2312t || z4)) {
                this.f2297d.setTranslationY(0.0f);
                float f6 = -this.f2297d.getHeight();
                if (z4) {
                    this.f2297d.getLocationInWindow(new int[]{0, 0});
                    f6 -= iArr2[1];
                }
                this.f2297d.setTranslationY(f6);
                g.l lVar4 = new g.l();
                k1 a7 = h0.z0.a(this.f2297d);
                a7.e(0.0f);
                final View view3 = (View) a7.f3165a.get();
                if (view3 != null) {
                    view3.animate().setUpdateListener(u0Var != null ? new ValueAnimator.AnimatorUpdateListener(view3) { // from class: h0.i1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            ((View) ((d.c1) d.u0.this.f2463h).f2297d.getParent()).invalidate();
                        }
                    } : null);
                }
                boolean z8 = lVar4.f2924e;
                ArrayList arrayList2 = lVar4.f2920a;
                if (!z8) {
                    arrayList2.add(a7);
                }
                if (this.o && view != null) {
                    view.setTranslationY(f6);
                    k1 a8 = h0.z0.a(view);
                    a8.e(0.0f);
                    if (!lVar4.f2924e) {
                        arrayList2.add(a8);
                    }
                }
                DecelerateInterpolator decelerateInterpolator = f2293z;
                boolean z9 = lVar4.f2924e;
                if (!z9) {
                    lVar4.f2922c = decelerateInterpolator;
                }
                if (!z9) {
                    lVar4.f2921b = 250L;
                }
                if (!z9) {
                    lVar4.f2923d = a1Var2;
                }
                this.f2311s = lVar4;
                lVar4.b();
            } else {
                this.f2297d.setAlpha(1.0f);
                this.f2297d.setTranslationY(0.0f);
                if (this.o && view != null) {
                    view.setTranslationY(0.0f);
                }
                a1Var2.a();
            }
            ActionBarOverlayLayout actionBarOverlayLayout = this.f2296c;
            if (actionBarOverlayLayout != null) {
                WeakHashMap weakHashMap = h0.z0.f3233a;
                h0.m0.c(actionBarOverlayLayout);
            }
        }
    }

    public c1(Dialog dialog) {
        new ArrayList();
        this.f2306m = new ArrayList();
        this.f2307n = 0;
        this.o = true;
        this.f2310r = true;
        this.f2314v = new a1(this, 0);
        this.f2315w = new a1(this, 1);
        this.f2316x = new u0(1, this);
        r(dialog.getWindow().getDecorView());
    }
}

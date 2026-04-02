package d;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.p3;
import androidx.appcompat.widget.r1;
import androidx.appcompat.widget.u3;
import androidx.appcompat.widget.v3;
import com.github.appintro.R;
import h0.h2;
import h0.k1;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class n0 extends y implements h.m, LayoutInflater.Factory2 {

    /* renamed from: n0  reason: collision with root package name */
    public static final l.j f2415n0 = new l.j();

    /* renamed from: o0  reason: collision with root package name */
    public static final int[] f2416o0 = {16842836};

    /* renamed from: p0  reason: collision with root package name */
    public static final boolean f2417p0 = !"robolectric".equals(Build.FINGERPRINT);
    public g.b A;
    public ActionBarContextView B;
    public PopupWindow C;
    public z D;
    public boolean F;
    public ViewGroup G;
    public TextView H;
    public View I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public m0[] R;
    public m0 S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;
    public Configuration X;
    public final int Y;
    public int Z;

    /* renamed from: a0  reason: collision with root package name */
    public int f2418a0;

    /* renamed from: b0  reason: collision with root package name */
    public boolean f2419b0;

    /* renamed from: c0  reason: collision with root package name */
    public i0 f2420c0;

    /* renamed from: d0  reason: collision with root package name */
    public i0 f2421d0;

    /* renamed from: e0  reason: collision with root package name */
    public boolean f2422e0;

    /* renamed from: f0  reason: collision with root package name */
    public int f2423f0;

    /* renamed from: h0  reason: collision with root package name */
    public boolean f2425h0;

    /* renamed from: i0  reason: collision with root package name */
    public Rect f2426i0;

    /* renamed from: j0  reason: collision with root package name */
    public Rect f2427j0;

    /* renamed from: k0  reason: collision with root package name */
    public r0 f2428k0;

    /* renamed from: l0  reason: collision with root package name */
    public OnBackInvokedDispatcher f2429l0;

    /* renamed from: m0  reason: collision with root package name */
    public OnBackInvokedCallback f2430m0;

    /* renamed from: p  reason: collision with root package name */
    public final Object f2431p;

    /* renamed from: q  reason: collision with root package name */
    public final Context f2432q;

    /* renamed from: r  reason: collision with root package name */
    public Window f2433r;

    /* renamed from: s  reason: collision with root package name */
    public h0 f2434s;

    /* renamed from: t  reason: collision with root package name */
    public final r f2435t;

    /* renamed from: u  reason: collision with root package name */
    public b f2436u;

    /* renamed from: v  reason: collision with root package name */
    public g.j f2437v;

    /* renamed from: w  reason: collision with root package name */
    public CharSequence f2438w;

    /* renamed from: x  reason: collision with root package name */
    public r1 f2439x;

    /* renamed from: y  reason: collision with root package name */
    public a0 f2440y;

    /* renamed from: z  reason: collision with root package name */
    public a0 f2441z;
    public k1 E = null;

    /* renamed from: g0  reason: collision with root package name */
    public final z f2424g0 = new z(this, 0);

    public n0(Context context, Window window, r rVar, Object obj) {
        q qVar;
        this.Y = -100;
        this.f2432q = context;
        this.f2435t = rVar;
        this.f2431p = obj;
        if (obj instanceof Dialog) {
            while (context != null) {
                if (!(context instanceof q)) {
                    if (!(context instanceof ContextWrapper)) {
                        break;
                    }
                    context = ((ContextWrapper) context).getBaseContext();
                } else {
                    qVar = (q) context;
                    break;
                }
            }
            qVar = null;
            if (qVar != null) {
                this.Y = ((n0) qVar.getDelegate()).Y;
            }
        }
        if (this.Y == -100) {
            l.j jVar = f2415n0;
            Integer num = (Integer) jVar.getOrDefault(this.f2431p.getClass().getName(), null);
            if (num != null) {
                this.Y = num.intValue();
                jVar.remove(this.f2431p.getClass().getName());
            }
        }
        if (window != null) {
            q(window);
        }
        androidx.appcompat.widget.y.c();
    }

    public static d0.g r(Context context) {
        d0.g gVar;
        d0.g gVar2;
        if (Build.VERSION.SDK_INT < 33 && (gVar = y.f2484i) != null) {
            d0.g b5 = e0.b(context.getApplicationContext().getResources().getConfiguration());
            d0.h hVar = gVar.f2504a;
            if (((d0.i) hVar).f2505a.isEmpty()) {
                gVar2 = d0.g.f2503b;
            } else {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                int i5 = 0;
                while (i5 < ((d0.i) b5.f2504a).f2505a.size() + ((d0.i) hVar).f2505a.size()) {
                    Locale locale = i5 < ((d0.i) hVar).f2505a.size() ? ((d0.i) hVar).f2505a.get(i5) : ((d0.i) b5.f2504a).f2505a.get(i5 - ((d0.i) hVar).f2505a.size());
                    if (locale != null) {
                        linkedHashSet.add(locale);
                    }
                    i5++;
                }
                gVar2 = new d0.g(new d0.i(d0.f.a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]))));
            }
            return ((d0.i) gVar2.f2504a).f2505a.isEmpty() ? b5 : gVar2;
        }
        return null;
    }

    public static Configuration v(Context context, int i5, d0.g gVar, Configuration configuration, boolean z4) {
        int i6 = i5 != 1 ? i5 != 2 ? z4 ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i6 | (configuration2.uiMode & (-49));
        if (gVar != null) {
            e0.d(configuration2, gVar);
        }
        return configuration2;
    }

    public final k0 A(Context context) {
        if (this.f2420c0 == null) {
            if (e.f2319k == null) {
                Context applicationContext = context.getApplicationContext();
                e.f2319k = new e(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
            }
            this.f2420c0 = new i0(this, e.f2319k);
        }
        return this.f2420c0;
    }

    public final m0 B(int i5) {
        m0[] m0VarArr = this.R;
        if (m0VarArr == null || m0VarArr.length <= i5) {
            m0[] m0VarArr2 = new m0[i5 + 1];
            if (m0VarArr != null) {
                System.arraycopy(m0VarArr, 0, m0VarArr2, 0, m0VarArr.length);
            }
            this.R = m0VarArr2;
            m0VarArr = m0VarArr2;
        }
        m0 m0Var = m0VarArr[i5];
        if (m0Var == null) {
            m0 m0Var2 = new m0(i5);
            m0VarArr[i5] = m0Var2;
            return m0Var2;
        }
        return m0Var;
    }

    public final Window.Callback C() {
        return this.f2433r.getCallback();
    }

    public final void D() {
        y();
        if (this.L && this.f2436u == null) {
            Object obj = this.f2431p;
            if (obj instanceof Activity) {
                this.f2436u = new c1((Activity) obj, this.M);
            } else if (obj instanceof Dialog) {
                this.f2436u = new c1((Dialog) obj);
            }
            b bVar = this.f2436u;
            if (bVar != null) {
                bVar.l(this.f2425h0);
            }
        }
    }

    public final int E(Context context, int i5) {
        if (i5 != -100) {
            if (i5 != -1) {
                if (i5 == 0) {
                    if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                        return -1;
                    }
                    return A(context).b();
                } else if (i5 != 1 && i5 != 2) {
                    if (i5 == 3) {
                        if (this.f2421d0 == null) {
                            this.f2421d0 = new i0(this, context);
                        }
                        return this.f2421d0.b();
                    }
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
            }
            return i5;
        }
        return -1;
    }

    public final boolean F() {
        boolean z4 = this.T;
        this.T = false;
        m0 B = B(0);
        if (B.f2411m) {
            if (!z4) {
                u(B, true);
            }
            return true;
        }
        g.b bVar = this.A;
        if (bVar != null) {
            bVar.a();
            return true;
        }
        D();
        b bVar2 = this.f2436u;
        return bVar2 != null && bVar2.b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x0155, code lost:
        if (r2 != null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0179, code lost:
        if (r2.f3018l.getCount() > 0) goto L70;
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0181  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void G(d.m0 r18, android.view.KeyEvent r19) {
        /*
            Method dump skipped, instructions count: 484
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d.n0.G(d.m0, android.view.KeyEvent):void");
    }

    public final boolean H(m0 m0Var, int i5, KeyEvent keyEvent) {
        h.o oVar;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((m0Var.f2409k || I(m0Var, keyEvent)) && (oVar = m0Var.f2406h) != null) {
            return oVar.performShortcut(i5, keyEvent, 1);
        }
        return false;
    }

    public final boolean I(m0 m0Var, KeyEvent keyEvent) {
        r1 r1Var;
        r1 r1Var2;
        Resources.Theme theme;
        r1 r1Var3;
        r1 r1Var4;
        if (this.W) {
            return false;
        }
        if (m0Var.f2409k) {
            return true;
        }
        m0 m0Var2 = this.S;
        if (m0Var2 != null && m0Var2 != m0Var) {
            u(m0Var2, false);
        }
        Window.Callback C = C();
        int i5 = m0Var.f2399a;
        if (C != null) {
            m0Var.f2405g = C.onCreatePanelView(i5);
        }
        boolean z4 = i5 == 0 || i5 == 108;
        if (z4 && (r1Var4 = this.f2439x) != null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) r1Var4;
            actionBarOverlayLayout.k();
            ((p3) actionBarOverlayLayout.f188k).f497l = true;
        }
        if (m0Var.f2405g == null && (!z4 || !(this.f2436u instanceof x0))) {
            h.o oVar = m0Var.f2406h;
            if (oVar == null || m0Var.o) {
                if (oVar == null) {
                    Context context = this.f2432q;
                    if ((i5 == 0 || i5 == 108) && this.f2439x != null) {
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme theme2 = context.getTheme();
                        theme2.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            theme = context.getResources().newTheme();
                            theme.setTo(theme2);
                            theme.applyStyle(typedValue.resourceId, true);
                            theme.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
                        } else {
                            theme2.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
                            theme = null;
                        }
                        if (typedValue.resourceId != 0) {
                            if (theme == null) {
                                theme = context.getResources().newTheme();
                                theme.setTo(theme2);
                            }
                            theme.applyStyle(typedValue.resourceId, true);
                        }
                        if (theme != null) {
                            g.d dVar = new g.d(context, 0);
                            dVar.getTheme().setTo(theme);
                            context = dVar;
                        }
                    }
                    h.o oVar2 = new h.o(context);
                    oVar2.f3029k = this;
                    h.o oVar3 = m0Var.f2406h;
                    if (oVar2 != oVar3) {
                        if (oVar3 != null) {
                            oVar3.r(m0Var.f2407i);
                        }
                        m0Var.f2406h = oVar2;
                        h.k kVar = m0Var.f2407i;
                        if (kVar != null) {
                            oVar2.b(kVar, oVar2.f3025g);
                        }
                    }
                    if (m0Var.f2406h == null) {
                        return false;
                    }
                }
                if (z4 && (r1Var2 = this.f2439x) != null) {
                    if (this.f2440y == null) {
                        this.f2440y = new a0(this, 4);
                    }
                    ((ActionBarOverlayLayout) r1Var2).l(m0Var.f2406h, this.f2440y);
                }
                m0Var.f2406h.w();
                if (!C.onCreatePanelMenu(i5, m0Var.f2406h)) {
                    h.o oVar4 = m0Var.f2406h;
                    if (oVar4 != null) {
                        if (oVar4 != null) {
                            oVar4.r(m0Var.f2407i);
                        }
                        m0Var.f2406h = null;
                    }
                    if (z4 && (r1Var = this.f2439x) != null) {
                        ((ActionBarOverlayLayout) r1Var).l(null, this.f2440y);
                    }
                    return false;
                }
                m0Var.o = false;
            }
            m0Var.f2406h.w();
            Bundle bundle = m0Var.f2413p;
            if (bundle != null) {
                m0Var.f2406h.s(bundle);
                m0Var.f2413p = null;
            }
            if (!C.onPreparePanel(0, m0Var.f2405g, m0Var.f2406h)) {
                if (z4 && (r1Var3 = this.f2439x) != null) {
                    ((ActionBarOverlayLayout) r1Var3).l(null, this.f2440y);
                }
                m0Var.f2406h.v();
                return false;
            }
            m0Var.f2406h.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            m0Var.f2406h.v();
        }
        m0Var.f2409k = true;
        m0Var.f2410l = false;
        this.S = m0Var;
        return true;
    }

    public final void J() {
        if (this.F) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final void K() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean z4 = false;
            if (this.f2429l0 != null && (B(0).f2411m || this.A != null)) {
                z4 = true;
            }
            if (z4 && this.f2430m0 == null) {
                this.f2430m0 = g0.b(this.f2429l0, this);
            } else if (z4 || (onBackInvokedCallback = this.f2430m0) == null) {
            } else {
                g0.c(this.f2429l0, onBackInvokedCallback);
                this.f2430m0 = null;
            }
        }
    }

    public final int L(h2 h2Var, Rect rect) {
        boolean z4;
        boolean z5;
        int e5 = h2Var != null ? h2Var.e() : rect != null ? rect.top : 0;
        ActionBarContextView actionBarContextView = this.B;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z4 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.B.getLayoutParams();
            if (this.B.isShown()) {
                if (this.f2426i0 == null) {
                    this.f2426i0 = new Rect();
                    this.f2427j0 = new Rect();
                }
                Rect rect2 = this.f2426i0;
                Rect rect3 = this.f2427j0;
                if (h2Var == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(h2Var.c(), h2Var.e(), h2Var.d(), h2Var.b());
                }
                ViewGroup viewGroup = this.G;
                if (Build.VERSION.SDK_INT >= 29) {
                    boolean z6 = v3.f560a;
                    u3.a(viewGroup, rect2, rect3);
                } else {
                    if (!v3.f560a) {
                        v3.f560a = true;
                        try {
                            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
                            v3.f561b = declaredMethod;
                            if (!declaredMethod.isAccessible()) {
                                v3.f561b.setAccessible(true);
                            }
                        } catch (NoSuchMethodException unused) {
                            Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
                        }
                    }
                    Method method = v3.f561b;
                    if (method != null) {
                        try {
                            method.invoke(viewGroup, rect2, rect3);
                        } catch (Exception e6) {
                            Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e6);
                        }
                    }
                }
                int i5 = rect2.top;
                int i6 = rect2.left;
                int i7 = rect2.right;
                ViewGroup viewGroup2 = this.G;
                WeakHashMap weakHashMap = h0.z0.f3233a;
                h2 a5 = h0.p0.a(viewGroup2);
                int c5 = a5 == null ? 0 : a5.c();
                int d5 = a5 == null ? 0 : a5.d();
                if (marginLayoutParams.topMargin == i5 && marginLayoutParams.leftMargin == i6 && marginLayoutParams.rightMargin == i7) {
                    z5 = false;
                } else {
                    marginLayoutParams.topMargin = i5;
                    marginLayoutParams.leftMargin = i6;
                    marginLayoutParams.rightMargin = i7;
                    z5 = true;
                }
                Context context = this.f2432q;
                if (i5 <= 0 || this.I != null) {
                    View view = this.I;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        int i8 = marginLayoutParams2.height;
                        int i9 = marginLayoutParams.topMargin;
                        if (i8 != i9 || marginLayoutParams2.leftMargin != c5 || marginLayoutParams2.rightMargin != d5) {
                            marginLayoutParams2.height = i9;
                            marginLayoutParams2.leftMargin = c5;
                            marginLayoutParams2.rightMargin = d5;
                            this.I.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(context);
                    this.I = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = c5;
                    layoutParams.rightMargin = d5;
                    this.G.addView(this.I, -1, layoutParams);
                }
                View view3 = this.I;
                z4 = view3 != null;
                if (z4 && view3.getVisibility() != 0) {
                    View view4 = this.I;
                    view4.setBackgroundColor((view4.getWindowSystemUiVisibility() & 8192) != 0 ? x.b.a(context, R.color.abc_decor_view_status_guard_light) : x.b.a(context, R.color.abc_decor_view_status_guard));
                }
                if (!this.N && z4) {
                    e5 = 0;
                }
                r5 = z5;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z4 = false;
            } else {
                r5 = false;
                z4 = false;
            }
            if (r5) {
                this.B.setLayoutParams(marginLayoutParams);
            }
        }
        View view5 = this.I;
        if (view5 != null) {
            view5.setVisibility(z4 ? 0 : 8);
        }
        return e5;
    }

    @Override // d.y
    public final void a(View view, ViewGroup.LayoutParams layoutParams) {
        y();
        ((ViewGroup) this.G.findViewById(16908290)).addView(view, layoutParams);
        this.f2434s.a(this.f2433r.getCallback());
    }

    @Override // d.y
    public final void b() {
        LayoutInflater from = LayoutInflater.from(this.f2432q);
        if (from.getFactory() == null) {
            from.setFactory2(this);
        } else if (from.getFactory2() instanceof n0) {
        } else {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x005d, code lost:
        if (r6 == false) goto L84;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b5  */
    @Override // h.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(h.o r6) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d.n0.c(h.o):void");
    }

    @Override // h.m
    public final boolean d(h.o oVar, MenuItem menuItem) {
        int i5;
        int i6;
        m0 m0Var;
        Window.Callback C = C();
        if (C != null && !this.W) {
            h.o k5 = oVar.k();
            m0[] m0VarArr = this.R;
            if (m0VarArr != null) {
                i5 = m0VarArr.length;
                i6 = 0;
            } else {
                i5 = 0;
                i6 = 0;
            }
            while (true) {
                if (i6 < i5) {
                    m0Var = m0VarArr[i6];
                    if (m0Var != null && m0Var.f2406h == k5) {
                        break;
                    }
                    i6++;
                } else {
                    m0Var = null;
                    break;
                }
            }
            if (m0Var != null) {
                return C.onMenuItemSelected(m0Var.f2399a, menuItem);
            }
        }
        return false;
    }

    @Override // d.y
    public final void e() {
        if (this.f2436u != null) {
            D();
            if (this.f2436u.f()) {
                return;
            }
            this.f2423f0 |= 1;
            if (this.f2422e0) {
                return;
            }
            View decorView = this.f2433r.getDecorView();
            WeakHashMap weakHashMap = h0.z0.f3233a;
            decorView.postOnAnimation(this.f2424g0);
            this.f2422e0 = true;
        }
    }

    @Override // d.y
    public final void g() {
        String str;
        this.U = true;
        p(false, true);
        z();
        Object obj = this.f2431p;
        if (obj instanceof Activity) {
            try {
                Activity activity = (Activity) obj;
                try {
                    str = m0.a.m(activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e5) {
                    throw new IllegalArgumentException(e5);
                }
            } catch (IllegalArgumentException unused) {
                str = null;
            }
            if (str != null) {
                b bVar = this.f2436u;
                if (bVar == null) {
                    this.f2425h0 = true;
                } else {
                    bVar.l(true);
                }
            }
            synchronized (y.f2489n) {
                y.i(this);
                y.f2488m.add(new WeakReference(this));
            }
        }
        this.X = new Configuration(this.f2432q.getResources().getConfiguration());
        this.V = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    @Override // d.y
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f2431p
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L11
            java.lang.Object r0 = d.y.f2489n
            monitor-enter(r0)
            d.y.i(r3)     // Catch: java.lang.Throwable -> Le
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            goto L11
        Le:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            throw r1
        L11:
            boolean r0 = r3.f2422e0
            if (r0 == 0) goto L20
            android.view.Window r0 = r3.f2433r
            android.view.View r0 = r0.getDecorView()
            d.z r1 = r3.f2424g0
            r0.removeCallbacks(r1)
        L20:
            r0 = 1
            r3.W = r0
            int r0 = r3.Y
            r1 = -100
            if (r0 == r1) goto L4d
            java.lang.Object r0 = r3.f2431p
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L4d
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L4d
            l.j r0 = d.n0.f2415n0
            java.lang.Object r1 = r3.f2431p
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.Y
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L5c
        L4d:
            l.j r0 = d.n0.f2415n0
            java.lang.Object r1 = r3.f2431p
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L5c:
            d.b r0 = r3.f2436u
            if (r0 == 0) goto L63
            r0.h()
        L63:
            d.i0 r0 = r3.f2420c0
            if (r0 == 0) goto L6a
            r0.a()
        L6a:
            d.i0 r0 = r3.f2421d0
            if (r0 == 0) goto L71
            r0.a()
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.n0.h():void");
    }

    @Override // d.y
    public final boolean j(int i5) {
        if (i5 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i5 = 108;
        } else if (i5 == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i5 = 109;
        }
        if (this.P && i5 == 108) {
            return false;
        }
        if (this.L && i5 == 1) {
            this.L = false;
        }
        if (i5 == 1) {
            J();
            this.P = true;
            return true;
        } else if (i5 == 2) {
            J();
            this.J = true;
            return true;
        } else if (i5 == 5) {
            J();
            this.K = true;
            return true;
        } else if (i5 == 10) {
            J();
            this.N = true;
            return true;
        } else if (i5 == 108) {
            J();
            this.L = true;
            return true;
        } else if (i5 != 109) {
            return this.f2433r.requestFeature(i5);
        } else {
            J();
            this.M = true;
            return true;
        }
    }

    @Override // d.y
    public final void k(int i5) {
        y();
        ViewGroup viewGroup = (ViewGroup) this.G.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f2432q).inflate(i5, viewGroup);
        this.f2434s.a(this.f2433r.getCallback());
    }

    @Override // d.y
    public final void l(View view) {
        y();
        ViewGroup viewGroup = (ViewGroup) this.G.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f2434s.a(this.f2433r.getCallback());
    }

    @Override // d.y
    public final void m(View view, ViewGroup.LayoutParams layoutParams) {
        y();
        ViewGroup viewGroup = (ViewGroup) this.G.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f2434s.a(this.f2433r.getCallback());
    }

    @Override // d.y
    public final void n(CharSequence charSequence) {
        this.f2438w = charSequence;
        r1 r1Var = this.f2439x;
        if (r1Var != null) {
            r1Var.setWindowTitle(charSequence);
            return;
        }
        b bVar = this.f2436u;
        if (bVar != null) {
            bVar.o(charSequence);
            return;
        }
        TextView textView = this.H;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0049  */
    @Override // d.y
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final g.b o(g.a r9) {
        /*
            Method dump skipped, instructions count: 430
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d.n0.o(g.a):g.b");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0115, code lost:
        if (r10.equals("ImageButton") == false) goto L129;
     */
    @Override // android.view.LayoutInflater.Factory2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View onCreateView(android.view.View r9, java.lang.String r10, android.content.Context r11, android.util.AttributeSet r12) {
        /*
            Method dump skipped, instructions count: 740
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d.n0.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ff A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean p(boolean r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 456
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d.n0.p(boolean, boolean):boolean");
    }

    public final void q(Window window) {
        Drawable drawable;
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        OnBackInvokedCallback onBackInvokedCallback;
        int resourceId;
        if (this.f2433r != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof h0) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        h0 h0Var = new h0(this, callback);
        this.f2434s = h0Var;
        window.setCallback(h0Var);
        int[] iArr = f2416o0;
        Context context = this.f2432q;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        if (!obtainStyledAttributes.hasValue(0) || (resourceId = obtainStyledAttributes.getResourceId(0, 0)) == 0) {
            drawable = null;
        } else {
            androidx.appcompat.widget.y a5 = androidx.appcompat.widget.y.a();
            synchronized (a5) {
                drawable = a5.f598a.f(context, resourceId, true);
            }
        }
        if (drawable != null) {
            window.setBackgroundDrawable(drawable);
        }
        obtainStyledAttributes.recycle();
        this.f2433r = window;
        if (Build.VERSION.SDK_INT < 33 || (onBackInvokedDispatcher = this.f2429l0) != null) {
            return;
        }
        if (onBackInvokedDispatcher != null && (onBackInvokedCallback = this.f2430m0) != null) {
            g0.c(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f2430m0 = null;
        }
        Object obj = this.f2431p;
        if (obj instanceof Activity) {
            Activity activity = (Activity) obj;
            if (activity.getWindow() != null) {
                this.f2429l0 = g0.a(activity);
                K();
            }
        }
        this.f2429l0 = null;
        K();
    }

    public final void s(int i5, m0 m0Var, h.o oVar) {
        if (oVar == null) {
            if (m0Var == null && i5 >= 0) {
                m0[] m0VarArr = this.R;
                if (i5 < m0VarArr.length) {
                    m0Var = m0VarArr[i5];
                }
            }
            if (m0Var != null) {
                oVar = m0Var.f2406h;
            }
        }
        if ((m0Var == null || m0Var.f2411m) && !this.W) {
            h0 h0Var = this.f2434s;
            Window.Callback callback = this.f2433r.getCallback();
            h0Var.getClass();
            try {
                h0Var.f2337k = true;
                callback.onPanelClosed(i5, oVar);
            } finally {
                h0Var.f2337k = false;
            }
        }
    }

    public final void t(h.o oVar) {
        androidx.appcompat.widget.n nVar;
        if (this.Q) {
            return;
        }
        this.Q = true;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f2439x;
        actionBarOverlayLayout.k();
        ActionMenuView actionMenuView = ((p3) actionBarOverlayLayout.f188k).f486a.f249g;
        if (actionMenuView != null && (nVar = actionMenuView.f207z) != null) {
            nVar.f();
            androidx.appcompat.widget.i iVar = nVar.f432z;
            if (iVar != null && iVar.b()) {
                iVar.f3087j.dismiss();
            }
        }
        Window.Callback C = C();
        if (C != null && !this.W) {
            C.onPanelClosed(108, oVar);
        }
        this.Q = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(d.m0 r6, boolean r7) {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            if (r7 == 0) goto L35
            int r2 = r6.f2399a
            if (r2 != 0) goto L35
            androidx.appcompat.widget.r1 r2 = r5.f2439x
            if (r2 == 0) goto L35
            androidx.appcompat.widget.ActionBarOverlayLayout r2 = (androidx.appcompat.widget.ActionBarOverlayLayout) r2
            r2.k()
            androidx.appcompat.widget.s1 r2 = r2.f188k
            androidx.appcompat.widget.p3 r2 = (androidx.appcompat.widget.p3) r2
            androidx.appcompat.widget.Toolbar r2 = r2.f486a
            androidx.appcompat.widget.ActionMenuView r2 = r2.f249g
            if (r2 == 0) goto L2c
            androidx.appcompat.widget.n r2 = r2.f207z
            if (r2 == 0) goto L27
            boolean r2 = r2.j()
            if (r2 == 0) goto L27
            r2 = r0
            goto L28
        L27:
            r2 = r1
        L28:
            if (r2 == 0) goto L2c
            r2 = r0
            goto L2d
        L2c:
            r2 = r1
        L2d:
            if (r2 == 0) goto L35
            h.o r6 = r6.f2406h
            r5.t(r6)
            return
        L35:
            android.content.Context r2 = r5.f2432q
            java.lang.String r3 = "window"
            java.lang.Object r2 = r2.getSystemService(r3)
            android.view.WindowManager r2 = (android.view.WindowManager) r2
            r3 = 0
            if (r2 == 0) goto L54
            boolean r4 = r6.f2411m
            if (r4 == 0) goto L54
            d.l0 r4 = r6.f2403e
            if (r4 == 0) goto L54
            r2.removeView(r4)
            if (r7 == 0) goto L54
            int r7 = r6.f2399a
            r5.s(r7, r6, r3)
        L54:
            r6.f2409k = r1
            r6.f2410l = r1
            r6.f2411m = r1
            r6.f2404f = r3
            r6.f2412n = r0
            d.m0 r7 = r5.S
            if (r7 != r6) goto L64
            r5.S = r3
        L64:
            int r6 = r6.f2399a
            if (r6 != 0) goto L6b
            r5.K()
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.n0.u(d.m0, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x00ff, code lost:
        if ((r7 != null && r7.l()) != false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0120, code lost:
        if ((r7 != null && r7.f()) != false) goto L77;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean w(android.view.KeyEvent r7) {
        /*
            Method dump skipped, instructions count: 366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d.n0.w(android.view.KeyEvent):boolean");
    }

    public final void x(int i5) {
        m0 B = B(i5);
        if (B.f2406h != null) {
            Bundle bundle = new Bundle();
            B.f2406h.t(bundle);
            if (bundle.size() > 0) {
                B.f2413p = bundle;
            }
            B.f2406h.w();
            B.f2406h.clear();
        }
        B.o = true;
        B.f2412n = true;
        if ((i5 == 108 || i5 == 0) && this.f2439x != null) {
            m0 B2 = B(0);
            B2.f2409k = false;
            I(B2, null);
        }
    }

    public final void y() {
        ViewGroup viewGroup;
        if (this.F) {
            return;
        }
        int[] iArr = c.a.f1693j;
        Context context = this.f2432q;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        if (!obtainStyledAttributes.hasValue(117)) {
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (obtainStyledAttributes.getBoolean(126, false)) {
            j(1);
        } else if (obtainStyledAttributes.getBoolean(117, false)) {
            j(108);
        }
        if (obtainStyledAttributes.getBoolean(118, false)) {
            j(109);
        }
        if (obtainStyledAttributes.getBoolean(119, false)) {
            j(10);
        }
        this.O = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        z();
        this.f2433r.getDecorView();
        LayoutInflater from = LayoutInflater.from(context);
        if (this.P) {
            viewGroup = this.N ? (ViewGroup) from.inflate(R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) from.inflate(R.layout.abc_screen_simple, (ViewGroup) null);
        } else if (this.O) {
            viewGroup = (ViewGroup) from.inflate(R.layout.abc_dialog_title_material, (ViewGroup) null);
            this.M = false;
            this.L = false;
        } else if (this.L) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new g.d(context, typedValue.resourceId) : context).inflate(R.layout.abc_screen_toolbar, (ViewGroup) null);
            r1 r1Var = (r1) viewGroup.findViewById(R.id.decor_content_parent);
            this.f2439x = r1Var;
            r1Var.setWindowCallback(C());
            if (this.M) {
                ((ActionBarOverlayLayout) this.f2439x).j(109);
            }
            if (this.J) {
                ((ActionBarOverlayLayout) this.f2439x).j(2);
            }
            if (this.K) {
                ((ActionBarOverlayLayout) this.f2439x).j(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.L + ", windowActionBarOverlay: " + this.M + ", android:windowIsFloating: " + this.O + ", windowActionModeOverlay: " + this.N + ", windowNoTitle: " + this.P + " }");
        }
        a0 a0Var = new a0(this, 0);
        WeakHashMap weakHashMap = h0.z0.f3233a;
        h0.o0.u(viewGroup, a0Var);
        if (this.f2439x == null) {
            this.H = (TextView) viewGroup.findViewById(R.id.title);
        }
        boolean z4 = v3.f560a;
        try {
            Method method = viewGroup.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(viewGroup, new Object[0]);
        } catch (IllegalAccessException e5) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e5);
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        } catch (InvocationTargetException e6) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e6);
        }
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R.id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.f2433r.findViewById(16908290);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(16908290);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f2433r.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new a0(this, 2));
        this.G = viewGroup;
        Object obj = this.f2431p;
        CharSequence title = obj instanceof Activity ? ((Activity) obj).getTitle() : this.f2438w;
        if (!TextUtils.isEmpty(title)) {
            r1 r1Var2 = this.f2439x;
            if (r1Var2 != null) {
                r1Var2.setWindowTitle(title);
            } else {
                b bVar = this.f2436u;
                if (bVar != null) {
                    bVar.o(title);
                } else {
                    TextView textView = this.H;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
        }
        ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.G.findViewById(16908290);
        View decorView = this.f2433r.getDecorView();
        contentFrameLayout2.f218m.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        if (contentFrameLayout2.isLaidOut()) {
            contentFrameLayout2.requestLayout();
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(iArr);
        obtainStyledAttributes2.getValue(124, contentFrameLayout2.getMinWidthMajor());
        obtainStyledAttributes2.getValue(125, contentFrameLayout2.getMinWidthMinor());
        if (obtainStyledAttributes2.hasValue(122)) {
            obtainStyledAttributes2.getValue(122, contentFrameLayout2.getFixedWidthMajor());
        }
        if (obtainStyledAttributes2.hasValue(123)) {
            obtainStyledAttributes2.getValue(123, contentFrameLayout2.getFixedWidthMinor());
        }
        if (obtainStyledAttributes2.hasValue(120)) {
            obtainStyledAttributes2.getValue(120, contentFrameLayout2.getFixedHeightMajor());
        }
        if (obtainStyledAttributes2.hasValue(121)) {
            obtainStyledAttributes2.getValue(121, contentFrameLayout2.getFixedHeightMinor());
        }
        obtainStyledAttributes2.recycle();
        contentFrameLayout2.requestLayout();
        this.F = true;
        m0 B = B(0);
        if (this.W || B.f2406h != null) {
            return;
        }
        this.f2423f0 |= 4096;
        if (this.f2422e0) {
            return;
        }
        View decorView2 = this.f2433r.getDecorView();
        WeakHashMap weakHashMap2 = h0.z0.f3233a;
        decorView2.postOnAnimation(this.f2424g0);
        this.f2422e0 = true;
    }

    public final void z() {
        if (this.f2433r == null) {
            Object obj = this.f2431p;
            if (obj instanceof Activity) {
                q(((Activity) obj).getWindow());
            }
        }
        if (this.f2433r == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}

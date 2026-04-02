package r3;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.LinearInterpolator;
import com.github.appintro.R;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.SnackbarContentLayout;
import h0.o0;
import h0.z0;
import java.util.List;
import java.util.WeakHashMap;
import y0.b0;
/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    public final int f4520a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4521b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4522c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeInterpolator f4523d;

    /* renamed from: e  reason: collision with root package name */
    public final TimeInterpolator f4524e;

    /* renamed from: f  reason: collision with root package name */
    public final TimeInterpolator f4525f;

    /* renamed from: g  reason: collision with root package name */
    public final ViewGroup f4526g;

    /* renamed from: h  reason: collision with root package name */
    public final Context f4527h;

    /* renamed from: i  reason: collision with root package name */
    public final k f4528i;

    /* renamed from: j  reason: collision with root package name */
    public final m f4529j;

    /* renamed from: k  reason: collision with root package name */
    public int f4530k;

    /* renamed from: m  reason: collision with root package name */
    public int f4532m;

    /* renamed from: n  reason: collision with root package name */
    public int f4533n;
    public int o;

    /* renamed from: p  reason: collision with root package name */
    public int f4534p;

    /* renamed from: q  reason: collision with root package name */
    public int f4535q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f4536r;

    /* renamed from: s  reason: collision with root package name */
    public final AccessibilityManager f4537s;

    /* renamed from: u  reason: collision with root package name */
    public static final v0.b f4514u = x2.a.f5485b;

    /* renamed from: v  reason: collision with root package name */
    public static final LinearInterpolator f4515v = x2.a.f5484a;

    /* renamed from: w  reason: collision with root package name */
    public static final v0.c f4516w = x2.a.f5487d;

    /* renamed from: y  reason: collision with root package name */
    public static final int[] f4518y = {R.attr.snackbarStyle};

    /* renamed from: z  reason: collision with root package name */
    public static final String f4519z = l.class.getSimpleName();

    /* renamed from: x  reason: collision with root package name */
    public static final Handler f4517x = new Handler(Looper.getMainLooper(), new f());

    /* renamed from: l  reason: collision with root package name */
    public final g f4531l = new g(this, 0);

    /* renamed from: t  reason: collision with root package name */
    public final i f4538t = new i(this);

    public l(Context context, ViewGroup viewGroup, SnackbarContentLayout snackbarContentLayout, SnackbarContentLayout snackbarContentLayout2) {
        if (snackbarContentLayout == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        if (snackbarContentLayout2 == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
        this.f4526g = viewGroup;
        this.f4529j = snackbarContentLayout2;
        this.f4527h = context;
        b4.j.g(context, b4.j.f1675n, "Theme.AppCompat");
        LayoutInflater from = LayoutInflater.from(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f4518y);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        k kVar = (k) from.inflate(resourceId != -1 ? R.layout.mtrl_layout_snackbar : R.layout.design_layout_snackbar, viewGroup, false);
        this.f4528i = kVar;
        k.a(kVar, this);
        float actionTextColorAlpha = kVar.getActionTextColorAlpha();
        if (actionTextColorAlpha != 1.0f) {
            snackbarContentLayout.f2196h.setTextColor(e4.e.B(e4.e.l(snackbarContentLayout, R.attr.colorSurface), actionTextColorAlpha, snackbarContentLayout.f2196h.getCurrentTextColor()));
        }
        snackbarContentLayout.setMaxInlineActionWidth(kVar.getMaxInlineActionWidth());
        kVar.addView(snackbarContentLayout);
        WeakHashMap weakHashMap = z0.f3233a;
        kVar.setAccessibilityLiveRegion(1);
        kVar.setImportantForAccessibility(1);
        kVar.setFitsSystemWindows(true);
        o0.u(kVar, new h(this));
        z0.n(kVar, new b0(5, this));
        this.f4537s = (AccessibilityManager) context.getSystemService("accessibility");
        this.f4522c = p2.a.Q(context, R.attr.motionDurationLong2, 250);
        this.f4520a = p2.a.Q(context, R.attr.motionDurationLong2, 150);
        this.f4521b = p2.a.Q(context, R.attr.motionDurationMedium1, 75);
        this.f4523d = p2.a.R(context, R.attr.motionEasingEmphasizedInterpolator, f4515v);
        this.f4525f = p2.a.R(context, R.attr.motionEasingEmphasizedInterpolator, f4516w);
        this.f4524e = p2.a.R(context, R.attr.motionEasingEmphasizedInterpolator, f4514u);
    }

    public final void a(int i5) {
        r b5 = r.b();
        i iVar = this.f4538t;
        synchronized (b5.f4547a) {
            if (b5.c(iVar)) {
                b5.a(b5.f4549c, i5);
            } else {
                q qVar = b5.f4550d;
                boolean z4 = false;
                if (qVar != null) {
                    if (iVar != null && qVar.f4543a.get() == iVar) {
                        z4 = true;
                    }
                }
                if (z4) {
                    b5.a(b5.f4550d, i5);
                }
            }
        }
    }

    public final void b() {
        r b5 = r.b();
        i iVar = this.f4538t;
        synchronized (b5.f4547a) {
            if (b5.c(iVar)) {
                b5.f4549c = null;
                if (b5.f4550d != null) {
                    b5.e();
                }
            }
        }
        ViewParent parent = this.f4528i.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f4528i);
        }
    }

    public final void c() {
        r b5 = r.b();
        i iVar = this.f4538t;
        synchronized (b5.f4547a) {
            if (b5.c(iVar)) {
                b5.d(b5.f4549c);
            }
        }
    }

    public final void d() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        boolean z4 = true;
        AccessibilityManager accessibilityManager = this.f4537s;
        if (accessibilityManager != null && ((enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1)) == null || !enabledAccessibilityServiceList.isEmpty())) {
            z4 = false;
        }
        k kVar = this.f4528i;
        if (z4) {
            kVar.post(new g(this, 2));
            return;
        }
        if (kVar.getParent() != null) {
            kVar.setVisibility(0);
        }
        c();
    }

    public final void e() {
        k kVar = this.f4528i;
        ViewGroup.LayoutParams layoutParams = kVar.getLayoutParams();
        boolean z4 = layoutParams instanceof ViewGroup.MarginLayoutParams;
        String str = f4519z;
        if (!z4) {
            Log.w(str, "Unable to update margins because layout params are not MarginLayoutParams");
        } else if (kVar.f4512p == null) {
            Log.w(str, "Unable to update margins because original view margins are not set");
        } else if (kVar.getParent() == null) {
        } else {
            int i5 = this.f4532m;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            Rect rect = kVar.f4512p;
            int i6 = rect.bottom + i5;
            int i7 = rect.left + this.f4533n;
            int i8 = rect.right + this.o;
            int i9 = rect.top;
            boolean z5 = false;
            boolean z6 = (marginLayoutParams.bottomMargin == i6 && marginLayoutParams.leftMargin == i7 && marginLayoutParams.rightMargin == i8 && marginLayoutParams.topMargin == i9) ? false : true;
            if (z6) {
                marginLayoutParams.bottomMargin = i6;
                marginLayoutParams.leftMargin = i7;
                marginLayoutParams.rightMargin = i8;
                marginLayoutParams.topMargin = i9;
                kVar.requestLayout();
            }
            if ((z6 || this.f4535q != this.f4534p) && Build.VERSION.SDK_INT >= 29) {
                if (this.f4534p > 0) {
                    ViewGroup.LayoutParams layoutParams2 = kVar.getLayoutParams();
                    if ((layoutParams2 instanceof u.d) && (((u.d) layoutParams2).f5096a instanceof SwipeDismissBehavior)) {
                        z5 = true;
                    }
                }
                if (z5) {
                    g gVar = this.f4531l;
                    kVar.removeCallbacks(gVar);
                    kVar.post(gVar);
                }
            }
        }
    }
}

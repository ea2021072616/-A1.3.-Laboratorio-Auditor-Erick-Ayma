package y4;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.widget.n2;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.github.appintro.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import d.p0;
import h0.o0;
import h0.z0;
import java.util.ArrayList;
import java.util.WeakHashMap;
import ru.zdevs.zugate.ZApp;
import y0.b0;
/* loaded from: classes.dex */
public final class a extends p0 {

    /* renamed from: l  reason: collision with root package name */
    public BottomSheetBehavior f5709l;

    /* renamed from: m  reason: collision with root package name */
    public FrameLayout f5710m;

    /* renamed from: n  reason: collision with root package name */
    public CoordinatorLayout f5711n;
    public FrameLayout o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f5712p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f5713q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f5714r;

    /* renamed from: s  reason: collision with root package name */
    public b3.f f5715s;

    /* renamed from: t  reason: collision with root package name */
    public final boolean f5716t;

    /* renamed from: u  reason: collision with root package name */
    public k3.f f5717u;

    /* renamed from: v  reason: collision with root package name */
    public final b3.e f5718v;

    /* renamed from: w  reason: collision with root package name */
    public int f5719w;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a(android.content.Context r5) {
        /*
            r4 = this;
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            android.content.res.Resources$Theme r1 = r5.getTheme()
            r2 = 2130968706(0x7f040082, float:1.7546073E38)
            r3 = 1
            boolean r1 = r1.resolveAttribute(r2, r0, r3)
            if (r1 == 0) goto L16
            int r0 = r0.resourceId
            goto L19
        L16:
            r0 = 2131952204(0x7f13024c, float:1.9540844E38)
        L19:
            r4.<init>(r5, r0)
            r4.f5712p = r3
            r4.f5713q = r3
            b3.e r5 = new b3.e
            r5.<init>(r4)
            r4.f5718v = r5
            d.y r5 = r4.c()
            r5.j(r3)
            android.content.Context r5 = r4.getContext()
            android.content.res.Resources$Theme r5 = r5.getTheme()
            r0 = 2130969031(0x7f0401c7, float:1.7546732E38)
            int[] r1 = new int[]{r0}
            android.content.res.TypedArray r5 = r5.obtainStyledAttributes(r1)
            r1 = 0
            boolean r5 = r5.getBoolean(r1, r1)
            r4.f5716t = r5
            android.content.Context r5 = r4.getContext()
            android.content.res.Resources$Theme r5 = r5.getTheme()
            int[] r0 = new int[]{r0}
            android.content.res.TypedArray r5 = r5.obtainStyledAttributes(r0)
            boolean r5 = r5.getBoolean(r1, r1)
            r4.f5716t = r5
            r5 = -2
            r4.f5719w = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.a.<init>(android.content.Context):void");
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    /* renamed from: f */
    public final void cancel() {
        if (this.f5709l == null) {
            g();
        }
        super.cancel();
    }

    public final void g() {
        if (this.f5710m == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, null);
            this.f5710m = frameLayout;
            this.f5711n = (CoordinatorLayout) frameLayout.findViewById(R.id.coordinator);
            FrameLayout frameLayout2 = (FrameLayout) this.f5710m.findViewById(R.id.design_bottom_sheet);
            this.o = frameLayout2;
            BottomSheetBehavior A = BottomSheetBehavior.A(frameLayout2);
            this.f5709l = A;
            ArrayList arrayList = A.W;
            b3.e eVar = this.f5718v;
            if (!arrayList.contains(eVar)) {
                arrayList.add(eVar);
            }
            this.f5709l.F(this.f5712p);
            this.f5717u = new k3.f(this.f5709l, this.o);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    /* renamed from: h */
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            boolean z4 = this.f5716t && Color.alpha(window.getNavigationBarColor()) < 255;
            FrameLayout frameLayout = this.f5710m;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z4);
            }
            CoordinatorLayout coordinatorLayout = this.f5711n;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z4);
            }
            b4.j.W(window, !z4);
            b3.f fVar = this.f5715s;
            if (fVar != null) {
                fVar.e(window);
            }
        }
        k3.f fVar2 = this.f5717u;
        if (fVar2 == null) {
            return;
        }
        boolean z5 = this.f5712p;
        View view = fVar2.f3651c;
        k3.c cVar = fVar2.f3649a;
        if (z5) {
            if (cVar != null) {
                cVar.b(fVar2.f3650b, view, false);
            }
        } else if (cVar != null) {
            cVar.c(view);
        }
    }

    public final void i(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(0);
            window.addFlags(Integer.MIN_VALUE);
            window.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    /* renamed from: j */
    public final void onDetachedFromWindow() {
        k3.c cVar;
        b3.f fVar = this.f5715s;
        if (fVar != null) {
            fVar.e(null);
        }
        k3.f fVar2 = this.f5717u;
        if (fVar2 == null || (cVar = fVar2.f3649a) == null) {
            return;
        }
        cVar.c(fVar2.f3651c);
    }

    @Override // androidx.activity.p, android.app.Dialog
    /* renamed from: k */
    public final void onStart() {
        super.onStart();
        BottomSheetBehavior bottomSheetBehavior = this.f5709l;
        if (bottomSheetBehavior == null || bottomSheetBehavior.L != 5) {
            return;
        }
        bottomSheetBehavior.H(4);
    }

    @Override // android.app.Dialog
    /* renamed from: l */
    public final void setCancelable(boolean z4) {
        k3.f fVar;
        super.setCancelable(z4);
        if (this.f5712p != z4) {
            this.f5712p = z4;
            BottomSheetBehavior bottomSheetBehavior = this.f5709l;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.F(z4);
            }
            if (getWindow() == null || (fVar = this.f5717u) == null) {
                return;
            }
            boolean z5 = this.f5712p;
            View view = fVar.f3651c;
            k3.c cVar = fVar.f3649a;
            if (z5) {
                if (cVar != null) {
                    cVar.b(fVar.f3650b, view, false);
                }
            } else if (cVar != null) {
                cVar.c(view);
            }
        }
    }

    @Override // android.app.Dialog
    /* renamed from: m */
    public final void setCanceledOnTouchOutside(boolean z4) {
        super.setCanceledOnTouchOutside(z4);
        if (z4 && !this.f5712p) {
            this.f5712p = true;
        }
        this.f5713q = z4;
        this.f5714r = true;
    }

    @Override // d.p0, androidx.activity.p, android.app.Dialog
    /* renamed from: n */
    public final void setContentView(int i5) {
        super.setContentView(q(null, i5, null));
    }

    @Override // d.p0, androidx.activity.p, android.app.Dialog
    /* renamed from: o */
    public final void setContentView(View view) {
        super.setContentView(q(view, 0, null));
    }

    @Override // d.p0, androidx.activity.p, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        i(bundle);
        if (!((ZApp.f4571h.getResources().getConfiguration().screenLayout & 15) >= 3)) {
            if (!(ZApp.f4571h.getResources().getConfiguration().orientation == 2)) {
                return;
            }
        }
        Window window = getWindow();
        if (window != null) {
            window.setLayout(this.f5719w, -1);
        }
    }

    @Override // d.p0, androidx.activity.p, android.app.Dialog
    /* renamed from: p */
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(q(view, 0, layoutParams));
    }

    public final FrameLayout q(View view, int i5, ViewGroup.LayoutParams layoutParams) {
        g();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f5710m.findViewById(R.id.coordinator);
        if (i5 != 0 && view == null) {
            view = getLayoutInflater().inflate(i5, (ViewGroup) coordinatorLayout, false);
        }
        if (this.f5716t) {
            FrameLayout frameLayout = this.o;
            n2.b bVar = new n2.b(this);
            WeakHashMap weakHashMap = z0.f3233a;
            o0.u(frameLayout, bVar);
        }
        this.o.removeAllViews();
        if (layoutParams == null) {
            this.o.addView(view);
        } else {
            this.o.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new d.d(3, this));
        z0.n(this.o, new b0(1, this));
        this.o.setOnTouchListener(new n2(1, this));
        return this.f5710m;
    }
}

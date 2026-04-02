package b3;

import android.content.res.ColorStateList;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import h0.h2;
import h0.n2;
import h0.o0;
import h0.z0;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class f extends c {

    /* renamed from: a  reason: collision with root package name */
    public final Boolean f1643a;

    /* renamed from: b  reason: collision with root package name */
    public final h2 f1644b;

    /* renamed from: c  reason: collision with root package name */
    public Window f1645c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1646d;

    public f(FrameLayout frameLayout, h2 h2Var) {
        ColorStateList g5;
        this.f1644b = h2Var;
        p3.g gVar = BottomSheetBehavior.A(frameLayout).f2034i;
        if (gVar != null) {
            g5 = gVar.f4294g.f4276c;
        } else {
            WeakHashMap weakHashMap = z0.f3233a;
            g5 = o0.g(frameLayout);
        }
        if (g5 != null) {
            this.f1643a = Boolean.valueOf(e4.e.A(g5.getDefaultColor()));
            return;
        }
        ColorStateList n5 = e4.e.n(frameLayout.getBackground());
        Integer valueOf = n5 != null ? Integer.valueOf(n5.getDefaultColor()) : null;
        if (valueOf != null) {
            this.f1643a = Boolean.valueOf(e4.e.A(valueOf.intValue()));
        } else {
            this.f1643a = null;
        }
    }

    @Override // b3.c
    public final void a(View view) {
        d(view);
    }

    @Override // b3.c
    public final void b(View view) {
        d(view);
    }

    @Override // b3.c
    public final void c(View view, int i5) {
        d(view);
    }

    public final void d(View view) {
        int top = view.getTop();
        h2 h2Var = this.f1644b;
        if (top < h2Var.e()) {
            Window window = this.f1645c;
            if (window != null) {
                Boolean bool = this.f1643a;
                new n2(window, window.getDecorView()).f3183a.v(bool == null ? this.f1646d : bool.booleanValue());
            }
            view.setPadding(view.getPaddingLeft(), h2Var.e() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
        } else if (view.getTop() != 0) {
            Window window2 = this.f1645c;
            if (window2 != null) {
                new n2(window2, window2.getDecorView()).f3183a.v(this.f1646d);
            }
            view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
        }
    }

    public final void e(Window window) {
        if (this.f1645c == window) {
            return;
        }
        this.f1645c = window;
        if (window != null) {
            this.f1646d = new n2(window, window.getDecorView()).f3183a.o();
        }
    }
}

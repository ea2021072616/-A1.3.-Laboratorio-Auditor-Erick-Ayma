package androidx.activity;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.SearchView$SearchAutoComplete;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.b2;
import androidx.biometric.e0;
import androidx.recyclerview.widget.RecyclerView;
import com.github.appintro.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import d.x0;
import h0.z0;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f61b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f62c;

    public /* synthetic */ j(int i5, Object obj) {
        this.f61b = i5;
        this.f62c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        androidx.appcompat.widget.n nVar;
        Object obj;
        boolean z4 = true;
        switch (this.f61b) {
            case 0:
                try {
                    ComponentActivity.access$001((ComponentActivity) this.f62c);
                    return;
                } catch (IllegalStateException e5) {
                    if (!TextUtils.equals(e5.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                        throw e5;
                    }
                    return;
                } catch (NullPointerException e6) {
                    if (!TextUtils.equals(e6.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                        throw e6;
                    }
                    return;
                }
            case 1:
                x0 x0Var = (x0) this.f62c;
                Window.Callback callback = x0Var.f2475b;
                Menu q5 = x0Var.q();
                h.o oVar = q5 instanceof h.o ? (h.o) q5 : null;
                if (oVar != null) {
                    oVar.w();
                }
                try {
                    q5.clear();
                    if (!callback.onCreatePanelMenu(0, q5) || !callback.onPreparePanel(0, null, q5)) {
                        q5.clear();
                    }
                    if (oVar != null) {
                        return;
                    }
                    return;
                } finally {
                    if (oVar != null) {
                        oVar.v();
                    }
                }
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                e.b bVar = (e.b) this.f62c;
                bVar.a(true);
                bVar.invalidateSelf();
                return;
            case 3:
                b2 b2Var = (b2) this.f62c;
                b2Var.f296r = null;
                b2Var.drawableStateChanged();
                return;
            case 4:
                SearchView$SearchAutoComplete searchView$SearchAutoComplete = (SearchView$SearchAutoComplete) this.f62c;
                if (searchView$SearchAutoComplete.f223l) {
                    ((InputMethodManager) searchView$SearchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(searchView$SearchAutoComplete, 0);
                    searchView$SearchAutoComplete.f223l = false;
                    return;
                }
                return;
            case 5:
                ActionMenuView actionMenuView = ((Toolbar) this.f62c).f249g;
                if (actionMenuView == null || (nVar = actionMenuView.f207z) == null) {
                    return;
                }
                nVar.l();
                return;
            case 6:
                e0 e0Var = (e0) this.f62c;
                Context context = e0Var.getContext();
                if (context == null) {
                    Log.w("FingerprintFragment", "Not resetting the dialog. Context is null.");
                    return;
                }
                e0Var.f615y.g(1);
                e0Var.f615y.f(context.getString(R.string.fingerprint_dialog_touch_sensor));
                return;
            case 7:
                n0.g gVar = (n0.g) this.f62c;
                if (gVar.f4068u) {
                    if (gVar.f4066s) {
                        gVar.f4066s = false;
                        n0.a aVar = gVar.f4055g;
                        aVar.getClass();
                        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                        aVar.f4049e = currentAnimationTimeMillis;
                        aVar.f4051g = -1L;
                        aVar.f4050f = currentAnimationTimeMillis;
                        aVar.f4052h = 0.5f;
                    }
                    n0.a aVar2 = gVar.f4055g;
                    if (aVar2.f4051g <= 0 || AnimationUtils.currentAnimationTimeMillis() <= aVar2.f4051g + aVar2.f4053i) {
                        z4 = false;
                    }
                    if (z4 || !gVar.f()) {
                        gVar.f4068u = false;
                        return;
                    }
                    if (gVar.f4067t) {
                        gVar.f4067t = false;
                        long uptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                        gVar.f4057i.onTouchEvent(obtain);
                        obtain.recycle();
                    }
                    if (aVar2.f4050f == 0) {
                        throw new RuntimeException("Cannot compute scroll delta before calling start()");
                    }
                    long currentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                    float a5 = aVar2.a(currentAnimationTimeMillis2);
                    aVar2.f4050f = currentAnimationTimeMillis2;
                    gVar.f4070w.scrollListBy((int) (((float) (currentAnimationTimeMillis2 - aVar2.f4050f)) * ((a5 * 4.0f) + ((-4.0f) * a5 * a5)) * aVar2.f4048d));
                    View view = gVar.f4057i;
                    WeakHashMap weakHashMap = z0.f3233a;
                    view.postOnAnimation(this);
                    return;
                }
                return;
            case 8:
                ((q0.d) this.f62c).p(0);
                return;
            case 9:
                synchronized (((androidx.lifecycle.z) this.f62c).f1165a) {
                    obj = ((androidx.lifecycle.z) this.f62c).f1170f;
                    ((androidx.lifecycle.z) this.f62c).f1170f = androidx.lifecycle.z.f1164k;
                }
                ((androidx.lifecycle.z) this.f62c).f(obj);
                return;
            case 10:
                ((y0.d) this.f62c).p();
                return;
            case 11:
                RecyclerView recyclerView = ((y0.s) this.f62c).f5638i;
                recyclerView.focusableViewAvailable(recyclerView);
                return;
            case 12:
            default:
                CheckableImageButton checkableImageButton = ((TextInputLayout) this.f62c).f2211i.f4902m;
                checkableImageButton.performClick();
                checkableImageButton.jumpDrawablesToCurrentState();
                return;
            case 13:
                ((y0.v) this.f62c).k();
                return;
            case 14:
                androidx.viewpager.widget.l lVar = (androidx.viewpager.widget.l) this.f62c;
                lVar.setScrollState(0);
                lVar.populate();
                return;
            case 15:
                h1.r rVar = (h1.r) this.f62c;
                rVar.f3315d.f3241a = 0;
                rVar.f3315d.f3247g = null;
                h1.g gVar2 = h1.u.f3328k;
                rVar.f3315d.i(h1.s.a(24, 6, gVar2));
                rVar.a(gVar2);
                return;
            case 16:
                try {
                    ((Runnable) this.f62c).run();
                    return;
                } catch (Exception e7) {
                    b4.j.n("Executor", "Background execution failure.", e7);
                    return;
                }
            case 17:
                h1.e eVar = (h1.e) this.f62c;
                eVar.f3271b = false;
                q0.d dVar = ((BottomSheetBehavior) eVar.f3274e).M;
                if (dVar != null && dVar.g()) {
                    eVar.a(eVar.f3272c);
                    return;
                }
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) eVar.f3274e;
                if (bottomSheetBehavior.L == 2) {
                    bottomSheetBehavior.I(eVar.f3272c);
                    return;
                }
                return;
        }
    }
}

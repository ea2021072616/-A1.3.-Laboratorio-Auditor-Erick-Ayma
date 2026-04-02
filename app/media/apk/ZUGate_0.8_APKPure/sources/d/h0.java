package d;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;
/* loaded from: classes.dex */
public final class h0 implements Window.Callback {

    /* renamed from: g  reason: collision with root package name */
    public final Window.Callback f2333g;

    /* renamed from: h  reason: collision with root package name */
    public v0 f2334h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2335i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2336j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f2337k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ n0 f2338l;

    public h0(n0 n0Var, Window.Callback callback) {
        this.f2338l = n0Var;
        if (callback == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.f2333g = callback;
    }

    public final void a(Window.Callback callback) {
        try {
            this.f2335i = true;
            callback.onContentChanged();
        } finally {
            this.f2335i = false;
        }
    }

    @Override // android.view.Window.Callback
    /* renamed from: b */
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f2333g.dispatchGenericMotionEvent(motionEvent);
    }

    public final boolean c(KeyEvent keyEvent) {
        return this.f2333g.dispatchKeyEvent(keyEvent);
    }

    public final boolean d(KeyEvent keyEvent) {
        return this.f2333g.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f2336j ? this.f2333g.dispatchKeyEvent(keyEvent) : this.f2338l.w(keyEvent) || c(keyEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0046, code lost:
        if (r6 != false) goto L7;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    @Override // android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchKeyShortcutEvent(android.view.KeyEvent r6) {
        /*
            r5 = this;
            boolean r0 = r5.d(r6)
            r1 = 1
            if (r0 != 0) goto L4f
            int r0 = r6.getKeyCode()
            d.n0 r2 = r5.f2338l
            r2.D()
            d.b r3 = r2.f2436u
            r4 = 0
            if (r3 == 0) goto L1c
            boolean r0 = r3.i(r0, r6)
            if (r0 == 0) goto L1c
            goto L48
        L1c:
            d.m0 r0 = r2.S
            if (r0 == 0) goto L31
            int r3 = r6.getKeyCode()
            boolean r0 = r2.H(r0, r3, r6)
            if (r0 == 0) goto L31
            d.m0 r6 = r2.S
            if (r6 == 0) goto L48
            r6.f2410l = r1
            goto L48
        L31:
            d.m0 r0 = r2.S
            if (r0 != 0) goto L4a
            d.m0 r0 = r2.B(r4)
            r2.I(r0, r6)
            int r3 = r6.getKeyCode()
            boolean r6 = r2.H(r0, r3, r6)
            r0.f2409k = r4
            if (r6 == 0) goto L4a
        L48:
            r6 = r1
            goto L4b
        L4a:
            r6 = r4
        L4b:
            if (r6 == 0) goto L4e
            goto L4f
        L4e:
            r1 = r4
        L4f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: d.h0.dispatchKeyShortcutEvent(android.view.KeyEvent):boolean");
    }

    @Override // android.view.Window.Callback
    /* renamed from: e */
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f2333g.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    /* renamed from: f */
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f2333g.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    /* renamed from: g */
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f2333g.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    /* renamed from: h */
    public final void onActionModeFinished(ActionMode actionMode) {
        this.f2333g.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    /* renamed from: i */
    public final void onActionModeStarted(ActionMode actionMode) {
        this.f2333g.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    /* renamed from: j */
    public final void onAttachedToWindow() {
        this.f2333g.onAttachedToWindow();
    }

    public final boolean k(int i5, Menu menu) {
        return this.f2333g.onCreatePanelMenu(i5, menu);
    }

    public final View l(int i5) {
        return this.f2333g.onCreatePanelView(i5);
    }

    @Override // android.view.Window.Callback
    /* renamed from: m */
    public final void onDetachedFromWindow() {
        this.f2333g.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    /* renamed from: n */
    public final boolean onMenuItemSelected(int i5, MenuItem menuItem) {
        return this.f2333g.onMenuItemSelected(i5, menuItem);
    }

    public final boolean o(int i5, Menu menu) {
        return this.f2333g.onMenuOpened(i5, menu);
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        if (this.f2335i) {
            this.f2333g.onContentChanged();
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i5, Menu menu) {
        if (i5 != 0 || (menu instanceof h.o)) {
            return k(i5, menu);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int i5) {
        v0 v0Var = this.f2334h;
        if (v0Var != null) {
            View view = i5 == 0 ? new View(v0Var.f2467g.f2474a.a()) : null;
            if (view != null) {
                return view;
            }
        }
        return l(i5);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int i5, Menu menu) {
        o(i5, menu);
        n0 n0Var = this.f2338l;
        if (i5 == 108) {
            n0Var.D();
            b bVar = n0Var.f2436u;
            if (bVar != null) {
                bVar.c(true);
            }
        } else {
            n0Var.getClass();
        }
        return true;
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int i5, Menu menu) {
        if (this.f2337k) {
            this.f2333g.onPanelClosed(i5, menu);
            return;
        }
        p(i5, menu);
        n0 n0Var = this.f2338l;
        if (i5 == 108) {
            n0Var.D();
            b bVar = n0Var.f2436u;
            if (bVar != null) {
                bVar.c(false);
            }
        } else if (i5 != 0) {
            n0Var.getClass();
        } else {
            m0 B = n0Var.B(i5);
            if (B.f2411m) {
                n0Var.u(B, false);
            }
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i5, View view, Menu menu) {
        h.o oVar = menu instanceof h.o ? (h.o) menu : null;
        if (i5 == 0 && oVar == null) {
            return false;
        }
        if (oVar != null) {
            oVar.D = true;
        }
        v0 v0Var = this.f2334h;
        if (v0Var != null && i5 == 0) {
            x0 x0Var = v0Var.f2467g;
            if (!x0Var.f2477d) {
                x0Var.f2474a.f497l = true;
                x0Var.f2477d = true;
            }
        }
        boolean r5 = r(i5, view, menu);
        if (oVar != null) {
            oVar.D = false;
        }
        return r5;
    }

    @Override // android.view.Window.Callback
    public final void onProvideKeyboardShortcuts(List list, Menu menu, int i5) {
        h.o oVar = this.f2338l.B(0).f2406h;
        if (oVar != null) {
            s(list, oVar, i5);
        } else {
            s(list, menu, i5);
        }
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }

    public final void p(int i5, Menu menu) {
        this.f2333g.onPanelClosed(i5, menu);
    }

    @Override // android.view.Window.Callback
    /* renamed from: q */
    public final void onPointerCaptureChanged(boolean z4) {
        g.o.a(this.f2333g, z4);
    }

    public final boolean r(int i5, View view, Menu menu) {
        return this.f2333g.onPreparePanel(i5, view, menu);
    }

    public final void s(List list, Menu menu, int i5) {
        g.n.a(this.f2333g, list, menu, i5);
    }

    @Override // android.view.Window.Callback
    /* renamed from: t */
    public final boolean onSearchRequested() {
        return this.f2333g.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    /* renamed from: u */
    public final boolean onSearchRequested(SearchEvent searchEvent) {
        return g.m.a(this.f2333g, searchEvent);
    }

    @Override // android.view.Window.Callback
    /* renamed from: v */
    public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f2333g.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    /* renamed from: w */
    public final void onWindowFocusChanged(boolean z4) {
        this.f2333g.onWindowFocusChanged(z4);
    }

    public final ActionMode x(ActionMode.Callback callback, int i5) {
        return g.m.b(this.f2333g, callback, i5);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i5) {
        n0 n0Var = this.f2338l;
        n0Var.getClass();
        if (i5 != 0) {
            return x(callback, i5);
        }
        g.f fVar = new g.f(n0Var.f2432q, callback);
        g.b o = n0Var.o(fVar);
        if (o != null) {
            return fVar.f(o);
        }
        return null;
    }
}

package h;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
/* loaded from: classes.dex */
public final class p implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, z {

    /* renamed from: g  reason: collision with root package name */
    public final o f3044g;

    /* renamed from: h  reason: collision with root package name */
    public d.n f3045h;

    /* renamed from: i  reason: collision with root package name */
    public k f3046i;

    public p(o oVar) {
        this.f3044g = oVar;
    }

    @Override // h.z
    public final void b(o oVar, boolean z4) {
        d.n nVar;
        if ((z4 || oVar == this.f3044g) && (nVar = this.f3045h) != null) {
            nVar.dismiss();
        }
    }

    @Override // h.z
    public final boolean h(o oVar) {
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i5) {
        k kVar = this.f3046i;
        if (kVar.f3018l == null) {
            kVar.f3018l = new j(kVar);
        }
        this.f3044g.q(kVar.f3018l.getItem(i5), null, 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.f3046i.b(this.f3044g, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i5, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        o oVar = this.f3044g;
        if (i5 == 82 || i5 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f3045h.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f3045h.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                oVar.c(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return oVar.performShortcut(i5, keyEvent, 0);
    }
}

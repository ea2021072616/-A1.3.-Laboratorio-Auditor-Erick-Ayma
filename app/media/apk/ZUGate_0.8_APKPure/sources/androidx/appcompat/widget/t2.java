package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.widget.PopupWindow;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class t2 extends o2 implements p2 {
    public static final Method J;
    public p2 I;

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                J = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public t2(Context context, int i5, int i6) {
        super(context, null, i5, i6);
    }

    @Override // androidx.appcompat.widget.p2
    public final void g(h.o oVar, MenuItem menuItem) {
        p2 p2Var = this.I;
        if (p2Var != null) {
            p2Var.g(oVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.p2
    public final void l(h.o oVar, h.q qVar) {
        p2 p2Var = this.I;
        if (p2Var != null) {
            p2Var.l(oVar, qVar);
        }
    }

    @Override // androidx.appcompat.widget.o2
    public final b2 q(Context context, boolean z4) {
        s2 s2Var = new s2(context, z4);
        s2Var.setHoverListener(this);
        return s2Var;
    }
}

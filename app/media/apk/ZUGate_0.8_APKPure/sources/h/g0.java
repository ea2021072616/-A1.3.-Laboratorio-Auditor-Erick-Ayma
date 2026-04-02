package h;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
/* loaded from: classes.dex */
public final class g0 extends o implements SubMenu {
    public final o F;
    public final q G;

    public g0(Context context, o oVar, q qVar) {
        super(context);
        this.F = oVar;
        this.G = qVar;
    }

    @Override // h.o
    public final boolean d(q qVar) {
        return this.F.d(qVar);
    }

    @Override // h.o
    public final boolean e(o oVar, MenuItem menuItem) {
        return super.e(oVar, menuItem) || this.F.e(oVar, menuItem);
    }

    @Override // h.o
    public final boolean f(q qVar) {
        return this.F.f(qVar);
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return this.G;
    }

    @Override // h.o
    public final String j() {
        q qVar = this.G;
        int i5 = qVar != null ? qVar.f3047g : 0;
        if (i5 == 0) {
            return null;
        }
        return androidx.appcompat.widget.b0.f("android:menu:actionviewstates:", i5);
    }

    @Override // h.o
    public final o k() {
        return this.F.k();
    }

    @Override // h.o
    public final boolean m() {
        return this.F.m();
    }

    @Override // h.o
    public final boolean n() {
        return this.F.n();
    }

    @Override // h.o
    public final boolean o() {
        return this.F.o();
    }

    @Override // h.o, android.view.Menu
    public final void setGroupDividerEnabled(boolean z4) {
        this.F.setGroupDividerEnabled(z4);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable drawable) {
        u(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        u(0, charSequence, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        u(0, null, 0, null, view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.G.setIcon(drawable);
        return this;
    }

    @Override // h.o, android.view.Menu
    public final void setQwertyMode(boolean z4) {
        this.F.setQwertyMode(z4);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i5) {
        u(0, null, i5, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i5) {
        u(i5, null, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i5) {
        this.G.setIcon(i5);
        return this;
    }
}

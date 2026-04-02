package h;

import android.view.MenuItem;
/* loaded from: classes.dex */
public final class t implements MenuItem.OnActionExpandListener {

    /* renamed from: a  reason: collision with root package name */
    public final MenuItem.OnActionExpandListener f3070a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ v f3071b;

    public t(v vVar, MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f3071b = vVar;
        this.f3070a = onActionExpandListener;
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return this.f3070a.onMenuItemActionCollapse(this.f3071b.m(menuItem));
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionExpand(MenuItem menuItem) {
        return this.f3070a.onMenuItemActionExpand(this.f3071b.m(menuItem));
    }
}

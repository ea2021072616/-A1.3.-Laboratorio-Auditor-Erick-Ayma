package h;

import android.view.MenuItem;
/* loaded from: classes.dex */
public final class u implements MenuItem.OnMenuItemClickListener {

    /* renamed from: g  reason: collision with root package name */
    public final MenuItem.OnMenuItemClickListener f3072g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ v f3073h;

    public u(v vVar, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f3073h = vVar;
        this.f3072g = onMenuItemClickListener;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        return this.f3072g.onMenuItemClick(this.f3073h.m(menuItem));
    }
}

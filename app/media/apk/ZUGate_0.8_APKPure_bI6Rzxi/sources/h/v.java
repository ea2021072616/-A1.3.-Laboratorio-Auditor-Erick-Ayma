package h;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class v extends d implements MenuItem {

    /* renamed from: j  reason: collision with root package name */
    public final c0.b f3074j;

    /* renamed from: k  reason: collision with root package name */
    public Method f3075k;

    public v(Context context, c0.b bVar) {
        super(context);
        if (bVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f3074j = bVar;
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        return this.f3074j.collapseActionView();
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        return this.f3074j.expandActionView();
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        r a5 = this.f3074j.a();
        if (a5 instanceof r) {
            return a5.f3067b;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        View actionView = this.f3074j.getActionView();
        return actionView instanceof s ? (View) ((s) actionView).f3069g : actionView;
    }

    @Override // android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f3074j.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f3074j.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f3074j.getContentDescription();
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.f3074j.getGroupId();
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        return this.f3074j.getIcon();
    }

    @Override // android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f3074j.getIconTintList();
    }

    @Override // android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f3074j.getIconTintMode();
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f3074j.getIntent();
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return this.f3074j.getItemId();
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f3074j.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f3074j.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f3074j.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.f3074j.getOrder();
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.f3074j.getSubMenu();
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f3074j.getTitle();
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        return this.f3074j.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f3074j.getTooltipText();
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return this.f3074j.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.f3074j.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return this.f3074j.isCheckable();
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return this.f3074j.isChecked();
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return this.f3074j.isEnabled();
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        return this.f3074j.isVisible();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        r rVar = new r(this, actionProvider);
        if (actionProvider == null) {
            rVar = null;
        }
        this.f3074j.b(rVar);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new s(view);
        }
        this.f3074j.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c5) {
        this.f3074j.setAlphabeticShortcut(c5);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z4) {
        this.f3074j.setCheckable(z4);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z4) {
        this.f3074j.setChecked(z4);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setContentDescription(CharSequence charSequence) {
        this.f3074j.setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z4) {
        this.f3074j.setEnabled(z4);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f3074j.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f3074j.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f3074j.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f3074j.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c5) {
        this.f3074j.setNumericShortcut(c5);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f3074j.setOnActionExpandListener(onActionExpandListener != null ? new t(this, onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f3074j.setOnMenuItemClickListener(onMenuItemClickListener != null ? new u(this, onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c5, char c6) {
        this.f3074j.setShortcut(c5, c6);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i5) {
        this.f3074j.setShowAsAction(i5);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i5) {
        this.f3074j.setShowAsActionFlags(i5);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f3074j.setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f3074j.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTooltipText(CharSequence charSequence) {
        this.f3074j.setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z4) {
        return this.f3074j.setVisible(z4);
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c5, int i5) {
        this.f3074j.setAlphabeticShortcut(c5, i5);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i5) {
        this.f3074j.setIcon(i5);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c5, int i5) {
        this.f3074j.setNumericShortcut(c5, i5);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c5, char c6, int i5, int i6) {
        this.f3074j.setShortcut(c5, c6, i5, i6);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i5) {
        this.f3074j.setTitle(i5);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i5) {
        c0.b bVar = this.f3074j;
        bVar.setActionView(i5);
        View actionView = bVar.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            bVar.setActionView(new s(actionView));
        }
        return this;
    }
}

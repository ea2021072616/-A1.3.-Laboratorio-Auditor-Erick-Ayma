package y4;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
/* loaded from: classes.dex */
public final class b implements MenuItem {

    /* renamed from: g  reason: collision with root package name */
    public final int f5720g;

    /* renamed from: h  reason: collision with root package name */
    public CharSequence f5721h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f5722i = null;

    /* renamed from: j  reason: collision with root package name */
    public boolean f5723j = true;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ d f5724k;

    public b(d dVar, int i5, CharSequence charSequence) {
        this.f5724k = dVar;
        this.f5720g = i5;
        this.f5721h = charSequence;
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        return null;
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        return null;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return (char) 0;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        return this.f5722i;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return null;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return this.f5720g;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return (char) 0;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f5721h;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        return null;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        return this.f5723j;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i5) {
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c5) {
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z4) {
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z4) {
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z4) {
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i5) {
        this.f5722i = x.a.b(this.f5724k.f5725g, i5);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c5) {
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c5, char c6) {
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i5) {
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i5) {
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i5) {
        this.f5721h = this.f5724k.f5725g.getText(i5);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z4) {
        this.f5723j = z4;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f5721h = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f5722i = drawable;
        return this;
    }
}

package h;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
/* loaded from: classes.dex */
public final class a implements c0.b {

    /* renamed from: g  reason: collision with root package name */
    public CharSequence f2944g;

    /* renamed from: h  reason: collision with root package name */
    public CharSequence f2945h;

    /* renamed from: i  reason: collision with root package name */
    public Intent f2946i;

    /* renamed from: j  reason: collision with root package name */
    public char f2947j;

    /* renamed from: l  reason: collision with root package name */
    public char f2949l;

    /* renamed from: n  reason: collision with root package name */
    public Drawable f2951n;
    public final Context o;

    /* renamed from: p  reason: collision with root package name */
    public CharSequence f2952p;

    /* renamed from: q  reason: collision with root package name */
    public CharSequence f2953q;

    /* renamed from: k  reason: collision with root package name */
    public int f2948k = 4096;

    /* renamed from: m  reason: collision with root package name */
    public int f2950m = 4096;

    /* renamed from: r  reason: collision with root package name */
    public ColorStateList f2954r = null;

    /* renamed from: s  reason: collision with root package name */
    public PorterDuff.Mode f2955s = null;

    /* renamed from: t  reason: collision with root package name */
    public boolean f2956t = false;

    /* renamed from: u  reason: collision with root package name */
    public boolean f2957u = false;

    /* renamed from: v  reason: collision with root package name */
    public int f2958v = 16;

    public a(Context context, CharSequence charSequence) {
        this.o = context;
        this.f2944g = charSequence;
    }

    @Override // c0.b
    public final r a() {
        return null;
    }

    @Override // c0.b
    public final c0.b b(r rVar) {
        throw new UnsupportedOperationException();
    }

    public final void c() {
        Drawable drawable = this.f2951n;
        if (drawable != null) {
            if (this.f2956t || this.f2957u) {
                this.f2951n = drawable;
                Drawable mutate = drawable.mutate();
                this.f2951n = mutate;
                if (this.f2956t) {
                    a0.a.h(mutate, this.f2954r);
                }
                if (this.f2957u) {
                    a0.a.i(this.f2951n, this.f2955s);
                }
            }
        }
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
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        return null;
    }

    @Override // c0.b, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f2950m;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f2949l;
    }

    @Override // c0.b, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f2952p;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        return this.f2951n;
    }

    @Override // c0.b, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f2954r;
    }

    @Override // c0.b, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f2955s;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f2946i;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return 16908332;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // c0.b, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f2948k;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f2947j;
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
        return this.f2944g;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f2945h;
        return charSequence != null ? charSequence : this.f2944g;
    }

    @Override // c0.b, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f2953q;
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
        return (this.f2958v & 1) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f2958v & 2) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f2958v & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        return (this.f2958v & 8) == 0;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c5) {
        this.f2949l = Character.toLowerCase(c5);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z4) {
        this.f2958v = (z4 ? 1 : 0) | (this.f2958v & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z4) {
        this.f2958v = (z4 ? 2 : 0) | (this.f2958v & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setContentDescription(CharSequence charSequence) {
        this.f2952p = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z4) {
        this.f2958v = (z4 ? 16 : 0) | (this.f2958v & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f2951n = drawable;
        c();
        return this;
    }

    @Override // c0.b, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f2954r = colorStateList;
        this.f2956t = true;
        c();
        return this;
    }

    @Override // c0.b, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f2955s = mode;
        this.f2957u = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f2946i = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c5) {
        this.f2947j = c5;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c5, char c6) {
        this.f2947j = c5;
        this.f2949l = Character.toLowerCase(c6);
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
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f2944g = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f2945h = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTooltipText(CharSequence charSequence) {
        this.f2953q = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z4) {
        this.f2958v = (this.f2958v & 8) | (z4 ? 0 : 8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i5) {
        throw new UnsupportedOperationException();
    }

    @Override // c0.b, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c5, int i5) {
        this.f2949l = Character.toLowerCase(c5);
        this.f2950m = KeyEvent.normalizeMetaState(i5);
        return this;
    }

    @Override // c0.b, android.view.MenuItem
    public final c0.b setContentDescription(CharSequence charSequence) {
        this.f2952p = charSequence;
        return this;
    }

    @Override // c0.b, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c5, int i5) {
        this.f2947j = c5;
        this.f2948k = KeyEvent.normalizeMetaState(i5);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i5) {
        this.f2944g = this.o.getResources().getString(i5);
        return this;
    }

    @Override // c0.b, android.view.MenuItem
    public final c0.b setTooltipText(CharSequence charSequence) {
        this.f2953q = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i5) {
        this.f2951n = x.a.b(this.o, i5);
        c();
        return this;
    }

    @Override // c0.b, android.view.MenuItem
    public final MenuItem setShortcut(char c5, char c6, int i5, int i6) {
        this.f2947j = c5;
        this.f2948k = KeyEvent.normalizeMetaState(i5);
        this.f2949l = Character.toLowerCase(c6);
        this.f2950m = KeyEvent.normalizeMetaState(i6);
        return this;
    }
}

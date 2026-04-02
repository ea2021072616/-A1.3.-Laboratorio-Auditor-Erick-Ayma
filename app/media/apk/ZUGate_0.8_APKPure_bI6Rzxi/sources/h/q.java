package h;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import d.u0;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class q implements c0.b {
    public int E;
    public View F;
    public r G;
    public MenuItem.OnActionExpandListener H;

    /* renamed from: g  reason: collision with root package name */
    public final int f3047g;

    /* renamed from: h  reason: collision with root package name */
    public final int f3048h;

    /* renamed from: i  reason: collision with root package name */
    public final int f3049i;

    /* renamed from: j  reason: collision with root package name */
    public final int f3050j;

    /* renamed from: k  reason: collision with root package name */
    public CharSequence f3051k;

    /* renamed from: l  reason: collision with root package name */
    public CharSequence f3052l;

    /* renamed from: m  reason: collision with root package name */
    public Intent f3053m;

    /* renamed from: n  reason: collision with root package name */
    public char f3054n;

    /* renamed from: p  reason: collision with root package name */
    public char f3055p;

    /* renamed from: r  reason: collision with root package name */
    public Drawable f3057r;

    /* renamed from: t  reason: collision with root package name */
    public final o f3059t;

    /* renamed from: u  reason: collision with root package name */
    public g0 f3060u;

    /* renamed from: v  reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f3061v;

    /* renamed from: w  reason: collision with root package name */
    public CharSequence f3062w;

    /* renamed from: x  reason: collision with root package name */
    public CharSequence f3063x;
    public int o = 4096;

    /* renamed from: q  reason: collision with root package name */
    public int f3056q = 4096;

    /* renamed from: s  reason: collision with root package name */
    public int f3058s = 0;

    /* renamed from: y  reason: collision with root package name */
    public ColorStateList f3064y = null;

    /* renamed from: z  reason: collision with root package name */
    public PorterDuff.Mode f3065z = null;
    public boolean A = false;
    public boolean B = false;
    public boolean C = false;
    public int D = 16;
    public boolean I = false;

    public q(o oVar, int i5, int i6, int i7, int i8, CharSequence charSequence, int i9) {
        this.f3059t = oVar;
        this.f3047g = i6;
        this.f3048h = i5;
        this.f3049i = i7;
        this.f3050j = i8;
        this.f3051k = charSequence;
        this.E = i9;
    }

    public static void c(int i5, int i6, String str, StringBuilder sb) {
        if ((i5 & i6) == i6) {
            sb.append(str);
        }
    }

    @Override // c0.b
    public final r a() {
        return this.G;
    }

    @Override // c0.b
    public final c0.b b(r rVar) {
        r rVar2 = this.G;
        if (rVar2 != null) {
            rVar2.getClass();
        }
        this.F = null;
        this.G = rVar;
        this.f3059t.p(true);
        r rVar3 = this.G;
        if (rVar3 != null) {
            rVar3.f3066a = new u0(3, this);
            rVar3.f3067b.setVisibilityListener(rVar3);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        if ((this.E & 8) == 0) {
            return false;
        }
        if (this.F == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.H;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f3059t.d(this);
        }
        return false;
    }

    public final Drawable d(Drawable drawable) {
        if (drawable != null && this.C && (this.A || this.B)) {
            drawable = drawable.mutate();
            if (this.A) {
                a0.a.h(drawable, this.f3064y);
            }
            if (this.B) {
                a0.a.i(drawable, this.f3065z);
            }
            this.C = false;
        }
        return drawable;
    }

    public final boolean e() {
        r rVar;
        if ((this.E & 8) != 0) {
            if (this.F == null && (rVar = this.G) != null) {
                this.F = rVar.f3067b.onCreateActionView(this);
            }
            if (this.F != null) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        if (e()) {
            MenuItem.OnActionExpandListener onActionExpandListener = this.H;
            if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
                return this.f3059t.f(this);
            }
            return false;
        }
        return false;
    }

    public final boolean f() {
        return (this.D & 32) == 32;
    }

    public final void g(boolean z4) {
        if (z4) {
            this.D |= 32;
        } else {
            this.D &= -33;
        }
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        View view = this.F;
        if (view != null) {
            return view;
        }
        r rVar = this.G;
        if (rVar != null) {
            View onCreateActionView = rVar.f3067b.onCreateActionView(this);
            this.F = onCreateActionView;
            return onCreateActionView;
        }
        return null;
    }

    @Override // c0.b, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f3056q;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f3055p;
    }

    @Override // c0.b, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f3062w;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.f3048h;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        Drawable drawable = this.f3057r;
        if (drawable != null) {
            return d(drawable);
        }
        int i5 = this.f3058s;
        if (i5 != 0) {
            Drawable x5 = p2.a.x(this.f3059t.f3025g, i5);
            this.f3058s = 0;
            this.f3057r = x5;
            return d(x5);
        }
        return null;
    }

    @Override // c0.b, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f3064y;
    }

    @Override // c0.b, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f3065z;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f3053m;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return this.f3047g;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // c0.b, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.o;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f3054n;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.f3049i;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.f3060u;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f3051k;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f3052l;
        return charSequence != null ? charSequence : this.f3051k;
    }

    @Override // c0.b, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f3063x;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return this.f3060u != null;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.I;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.D & 1) == 1;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.D & 2) == 2;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.D & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        r rVar = this.G;
        return (rVar == null || !rVar.f3067b.overridesItemVisibility()) ? (this.D & 8) == 0 : (this.D & 8) == 0 && this.G.f3067b.isVisible();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        int i5;
        this.F = view;
        this.G = null;
        if (view != null && view.getId() == -1 && (i5 = this.f3047g) > 0) {
            view.setId(i5);
        }
        o oVar = this.f3059t;
        oVar.f3034q = true;
        oVar.p(true);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c5) {
        if (this.f3055p == c5) {
            return this;
        }
        this.f3055p = Character.toLowerCase(c5);
        this.f3059t.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z4) {
        int i5 = this.D;
        int i6 = (z4 ? 1 : 0) | (i5 & (-2));
        this.D = i6;
        if (i5 != i6) {
            this.f3059t.p(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z4) {
        int i5 = this.D;
        int i6 = i5 & 4;
        o oVar = this.f3059t;
        if (i6 != 0) {
            oVar.getClass();
            ArrayList arrayList = oVar.f3030l;
            int size = arrayList.size();
            oVar.w();
            for (int i7 = 0; i7 < size; i7++) {
                q qVar = (q) arrayList.get(i7);
                if (qVar.f3048h == this.f3048h) {
                    if (((qVar.D & 4) != 0) && qVar.isCheckable()) {
                        boolean z5 = qVar == this;
                        int i8 = qVar.D;
                        int i9 = (z5 ? 2 : 0) | (i8 & (-3));
                        qVar.D = i9;
                        if (i8 != i9) {
                            qVar.f3059t.p(false);
                        }
                    }
                }
            }
            oVar.v();
        } else {
            int i10 = (z4 ? 2 : 0) | (i5 & (-3));
            this.D = i10;
            if (i5 != i10) {
                oVar.p(false);
            }
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z4) {
        if (z4) {
            this.D |= 16;
        } else {
            this.D &= -17;
        }
        this.f3059t.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f3058s = 0;
        this.f3057r = drawable;
        this.C = true;
        this.f3059t.p(false);
        return this;
    }

    @Override // c0.b, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f3064y = colorStateList;
        this.A = true;
        this.C = true;
        this.f3059t.p(false);
        return this;
    }

    @Override // c0.b, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f3065z = mode;
        this.B = true;
        this.C = true;
        this.f3059t.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f3053m = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c5) {
        if (this.f3054n == c5) {
            return this;
        }
        this.f3054n = c5;
        this.f3059t.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.H = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f3061v = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c5, char c6) {
        this.f3054n = c5;
        this.f3055p = Character.toLowerCase(c6);
        this.f3059t.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i5) {
        int i6 = i5 & 3;
        if (i6 != 0 && i6 != 1 && i6 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.E = i5;
        o oVar = this.f3059t;
        oVar.f3034q = true;
        oVar.p(true);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i5) {
        setShowAsAction(i5);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f3051k = charSequence;
        this.f3059t.p(false);
        g0 g0Var = this.f3060u;
        if (g0Var != null) {
            g0Var.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f3052l = charSequence;
        this.f3059t.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z4) {
        int i5 = this.D;
        int i6 = (z4 ? 0 : 8) | (i5 & (-9));
        this.D = i6;
        if (i5 != i6) {
            o oVar = this.f3059t;
            oVar.f3032n = true;
            oVar.p(true);
        }
        return this;
    }

    public final String toString() {
        CharSequence charSequence = this.f3051k;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // c0.b, android.view.MenuItem
    public final c0.b setContentDescription(CharSequence charSequence) {
        this.f3062w = charSequence;
        this.f3059t.p(false);
        return this;
    }

    @Override // c0.b, android.view.MenuItem
    public final c0.b setTooltipText(CharSequence charSequence) {
        this.f3063x = charSequence;
        this.f3059t.p(false);
        return this;
    }

    @Override // c0.b, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c5, int i5) {
        if (this.f3055p == c5 && this.f3056q == i5) {
            return this;
        }
        this.f3055p = Character.toLowerCase(c5);
        this.f3056q = KeyEvent.normalizeMetaState(i5);
        this.f3059t.p(false);
        return this;
    }

    @Override // c0.b, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c5, int i5) {
        if (this.f3054n == c5 && this.o == i5) {
            return this;
        }
        this.f3054n = c5;
        this.o = KeyEvent.normalizeMetaState(i5);
        this.f3059t.p(false);
        return this;
    }

    @Override // c0.b, android.view.MenuItem
    public final MenuItem setShortcut(char c5, char c6, int i5, int i6) {
        this.f3054n = c5;
        this.o = KeyEvent.normalizeMetaState(i5);
        this.f3055p = Character.toLowerCase(c6);
        this.f3056q = KeyEvent.normalizeMetaState(i6);
        this.f3059t.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i5) {
        this.f3057r = null;
        this.f3058s = i5;
        this.C = true;
        this.f3059t.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i5) {
        setTitle(this.f3059t.f3025g.getString(i5));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i5) {
        int i6;
        o oVar = this.f3059t;
        Context context = oVar.f3025g;
        View inflate = LayoutInflater.from(context).inflate(i5, (ViewGroup) new LinearLayout(context), false);
        this.F = inflate;
        this.G = null;
        if (inflate != null && inflate.getId() == -1 && (i6 = this.f3047g) > 0) {
            inflate.setId(i6);
        }
        oVar.f3034q = true;
        oVar.p(true);
        return this;
    }
}

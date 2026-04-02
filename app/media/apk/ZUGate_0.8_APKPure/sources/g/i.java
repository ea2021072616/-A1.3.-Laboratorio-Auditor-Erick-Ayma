package g;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import h.q;
import h.r;
import h.v;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class i {
    public CharSequence A;
    public CharSequence B;
    public final /* synthetic */ j E;

    /* renamed from: a  reason: collision with root package name */
    public final Menu f2886a;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2893h;

    /* renamed from: i  reason: collision with root package name */
    public int f2894i;

    /* renamed from: j  reason: collision with root package name */
    public int f2895j;

    /* renamed from: k  reason: collision with root package name */
    public CharSequence f2896k;

    /* renamed from: l  reason: collision with root package name */
    public CharSequence f2897l;

    /* renamed from: m  reason: collision with root package name */
    public int f2898m;

    /* renamed from: n  reason: collision with root package name */
    public char f2899n;
    public int o;

    /* renamed from: p  reason: collision with root package name */
    public char f2900p;

    /* renamed from: q  reason: collision with root package name */
    public int f2901q;

    /* renamed from: r  reason: collision with root package name */
    public int f2902r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f2903s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f2904t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f2905u;

    /* renamed from: v  reason: collision with root package name */
    public int f2906v;

    /* renamed from: w  reason: collision with root package name */
    public int f2907w;

    /* renamed from: x  reason: collision with root package name */
    public String f2908x;

    /* renamed from: y  reason: collision with root package name */
    public String f2909y;

    /* renamed from: z  reason: collision with root package name */
    public r f2910z;
    public ColorStateList C = null;
    public PorterDuff.Mode D = null;

    /* renamed from: b  reason: collision with root package name */
    public int f2887b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f2888c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f2889d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f2890e = 0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2891f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2892g = true;

    public i(j jVar, Menu menu) {
        this.E = jVar;
        this.f2886a = menu;
    }

    public final Object a(String str, Class[] clsArr, Object[] objArr) {
        try {
            Constructor<?> constructor = Class.forName(str, false, this.E.f2915c.getClassLoader()).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Exception e5) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e5);
            return null;
        }
    }

    public final void b(MenuItem menuItem) {
        boolean z4 = false;
        menuItem.setChecked(this.f2903s).setVisible(this.f2904t).setEnabled(this.f2905u).setCheckable(this.f2902r >= 1).setTitleCondensed(this.f2897l).setIcon(this.f2898m);
        int i5 = this.f2906v;
        if (i5 >= 0) {
            menuItem.setShowAsAction(i5);
        }
        String str = this.f2909y;
        j jVar = this.E;
        if (str != null) {
            if (jVar.f2915c.isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            if (jVar.f2916d == null) {
                jVar.f2916d = j.a(jVar.f2915c);
            }
            menuItem.setOnMenuItemClickListener(new h(jVar.f2916d, this.f2909y));
        }
        if (this.f2902r >= 2) {
            if (menuItem instanceof q) {
                q qVar = (q) menuItem;
                qVar.D = (qVar.D & (-5)) | 4;
            } else if (menuItem instanceof v) {
                v vVar = (v) menuItem;
                try {
                    Method method = vVar.f3075k;
                    c0.b bVar = vVar.f3074j;
                    if (method == null) {
                        vVar.f3075k = bVar.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                    }
                    vVar.f3075k.invoke(bVar, Boolean.TRUE);
                } catch (Exception e5) {
                    Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e5);
                }
            }
        }
        String str2 = this.f2908x;
        if (str2 != null) {
            menuItem.setActionView((View) a(str2, j.f2911e, jVar.f2913a));
            z4 = true;
        }
        int i6 = this.f2907w;
        if (i6 > 0) {
            if (z4) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            } else {
                menuItem.setActionView(i6);
            }
        }
        r rVar = this.f2910z;
        if (rVar != null) {
            if (menuItem instanceof c0.b) {
                ((c0.b) menuItem).b(rVar);
            } else {
                Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
            }
        }
        CharSequence charSequence = this.A;
        boolean z5 = menuItem instanceof c0.b;
        if (z5) {
            ((c0.b) menuItem).setContentDescription(charSequence);
        } else {
            h0.r.h(menuItem, charSequence);
        }
        CharSequence charSequence2 = this.B;
        if (z5) {
            ((c0.b) menuItem).setTooltipText(charSequence2);
        } else {
            h0.r.m(menuItem, charSequence2);
        }
        char c5 = this.f2899n;
        int i7 = this.o;
        if (z5) {
            ((c0.b) menuItem).setAlphabeticShortcut(c5, i7);
        } else {
            h0.r.g(menuItem, c5, i7);
        }
        char c6 = this.f2900p;
        int i8 = this.f2901q;
        if (z5) {
            ((c0.b) menuItem).setNumericShortcut(c6, i8);
        } else {
            h0.r.k(menuItem, c6, i8);
        }
        PorterDuff.Mode mode = this.D;
        if (mode != null) {
            if (z5) {
                ((c0.b) menuItem).setIconTintMode(mode);
            } else {
                h0.r.j(menuItem, mode);
            }
        }
        ColorStateList colorStateList = this.C;
        if (colorStateList != null) {
            if (z5) {
                ((c0.b) menuItem).setIconTintList(colorStateList);
            } else {
                h0.r.i(menuItem, colorStateList);
            }
        }
    }
}

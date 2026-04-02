package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.github.appintro.R;
/* loaded from: classes.dex */
public final class p3 implements s1 {

    /* renamed from: a  reason: collision with root package name */
    public final Toolbar f486a;

    /* renamed from: b  reason: collision with root package name */
    public int f487b;

    /* renamed from: c  reason: collision with root package name */
    public View f488c;

    /* renamed from: d  reason: collision with root package name */
    public Drawable f489d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f490e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f491f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f492g;

    /* renamed from: h  reason: collision with root package name */
    public CharSequence f493h;

    /* renamed from: i  reason: collision with root package name */
    public CharSequence f494i;

    /* renamed from: j  reason: collision with root package name */
    public CharSequence f495j;

    /* renamed from: k  reason: collision with root package name */
    public Window.Callback f496k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f497l;

    /* renamed from: m  reason: collision with root package name */
    public n f498m;

    /* renamed from: n  reason: collision with root package name */
    public int f499n;
    public Drawable o;

    public p3(Toolbar toolbar, boolean z4) {
        Drawable drawable;
        this.f499n = 0;
        this.f486a = toolbar;
        this.f493h = toolbar.getTitle();
        this.f494i = toolbar.getSubtitle();
        this.f492g = this.f493h != null;
        this.f491f = toolbar.getNavigationIcon();
        z2 m5 = z2.m(toolbar.getContext(), null, c.a.f1684a, R.attr.actionBarStyle);
        int i5 = 15;
        this.o = m5.e(15);
        if (z4) {
            CharSequence k5 = m5.k(27);
            if (!TextUtils.isEmpty(k5)) {
                this.f492g = true;
                this.f493h = k5;
                if ((this.f487b & 8) != 0) {
                    toolbar.setTitle(k5);
                    if (this.f492g) {
                        h0.z0.o(toolbar.getRootView(), k5);
                    }
                }
            }
            CharSequence k6 = m5.k(25);
            if (!TextUtils.isEmpty(k6)) {
                this.f494i = k6;
                if ((this.f487b & 8) != 0) {
                    toolbar.setSubtitle(k6);
                }
            }
            Drawable e5 = m5.e(20);
            if (e5 != null) {
                this.f490e = e5;
                c();
            }
            Drawable e6 = m5.e(17);
            if (e6 != null) {
                this.f489d = e6;
                c();
            }
            if (this.f491f == null && (drawable = this.o) != null) {
                this.f491f = drawable;
                if ((this.f487b & 4) != 0) {
                    toolbar.setNavigationIcon(drawable);
                } else {
                    toolbar.setNavigationIcon((Drawable) null);
                }
            }
            b(m5.h(10, 0));
            int i6 = m5.i(9, 0);
            if (i6 != 0) {
                View inflate = LayoutInflater.from(toolbar.getContext()).inflate(i6, (ViewGroup) toolbar, false);
                View view = this.f488c;
                if (view != null && (this.f487b & 16) != 0) {
                    toolbar.removeView(view);
                }
                this.f488c = inflate;
                if (inflate != null && (this.f487b & 16) != 0) {
                    toolbar.addView(inflate);
                }
                b(this.f487b | 16);
            }
            int layoutDimension = ((TypedArray) m5.f606b).getLayoutDimension(13, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = toolbar.getLayoutParams();
                layoutParams.height = layoutDimension;
                toolbar.setLayoutParams(layoutParams);
            }
            int c5 = m5.c(7, -1);
            int c6 = m5.c(3, -1);
            if (c5 >= 0 || c6 >= 0) {
                int max = Math.max(c5, 0);
                int max2 = Math.max(c6, 0);
                if (toolbar.f267z == null) {
                    toolbar.f267z = new x2();
                }
                toolbar.f267z.a(max, max2);
            }
            int i7 = m5.i(28, 0);
            if (i7 != 0) {
                Context context = toolbar.getContext();
                toolbar.f259r = i7;
                i1 i1Var = toolbar.f250h;
                if (i1Var != null) {
                    i1Var.setTextAppearance(context, i7);
                }
            }
            int i8 = m5.i(26, 0);
            if (i8 != 0) {
                Context context2 = toolbar.getContext();
                toolbar.f260s = i8;
                i1 i1Var2 = toolbar.f251i;
                if (i1Var2 != null) {
                    i1Var2.setTextAppearance(context2, i8);
                }
            }
            int i9 = m5.i(22, 0);
            if (i9 != 0) {
                toolbar.setPopupTheme(i9);
            }
        } else {
            if (toolbar.getNavigationIcon() != null) {
                this.o = toolbar.getNavigationIcon();
            } else {
                i5 = 11;
            }
            this.f487b = i5;
        }
        m5.n();
        if (R.string.abc_action_bar_up_description != this.f499n) {
            this.f499n = R.string.abc_action_bar_up_description;
            if (TextUtils.isEmpty(toolbar.getNavigationContentDescription())) {
                int i10 = this.f499n;
                String string = i10 != 0 ? a().getString(i10) : null;
                this.f495j = string;
                if ((this.f487b & 4) != 0) {
                    if (TextUtils.isEmpty(string)) {
                        toolbar.setNavigationContentDescription(this.f499n);
                    } else {
                        toolbar.setNavigationContentDescription(this.f495j);
                    }
                }
            }
        }
        this.f495j = toolbar.getNavigationContentDescription();
        toolbar.setNavigationOnClickListener(new c(this));
    }

    public final Context a() {
        return this.f486a.getContext();
    }

    public final void b(int i5) {
        View view;
        int i6 = this.f487b ^ i5;
        this.f487b = i5;
        if (i6 != 0) {
            int i7 = i6 & 4;
            Toolbar toolbar = this.f486a;
            if (i7 != 0) {
                if ((i5 & 4) != 0 && (i5 & 4) != 0) {
                    if (TextUtils.isEmpty(this.f495j)) {
                        toolbar.setNavigationContentDescription(this.f499n);
                    } else {
                        toolbar.setNavigationContentDescription(this.f495j);
                    }
                }
                if ((this.f487b & 4) != 0) {
                    Drawable drawable = this.f491f;
                    if (drawable == null) {
                        drawable = this.o;
                    }
                    toolbar.setNavigationIcon(drawable);
                } else {
                    toolbar.setNavigationIcon((Drawable) null);
                }
            }
            if ((i6 & 3) != 0) {
                c();
            }
            if ((i6 & 8) != 0) {
                if ((i5 & 8) != 0) {
                    toolbar.setTitle(this.f493h);
                    toolbar.setSubtitle(this.f494i);
                } else {
                    toolbar.setTitle((CharSequence) null);
                    toolbar.setSubtitle((CharSequence) null);
                }
            }
            if ((i6 & 16) == 0 || (view = this.f488c) == null) {
                return;
            }
            if ((i5 & 16) != 0) {
                toolbar.addView(view);
            } else {
                toolbar.removeView(view);
            }
        }
    }

    public final void c() {
        Drawable drawable;
        int i5 = this.f487b;
        if ((i5 & 2) == 0) {
            drawable = null;
        } else if ((i5 & 1) != 0) {
            drawable = this.f490e;
            if (drawable == null) {
                drawable = this.f489d;
            }
        } else {
            drawable = this.f489d;
        }
        this.f486a.setLogo(drawable);
    }
}

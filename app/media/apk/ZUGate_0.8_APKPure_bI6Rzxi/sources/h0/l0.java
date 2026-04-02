package h0;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes.dex */
public abstract class l0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f3166a;

    /* renamed from: b  reason: collision with root package name */
    public final Class f3167b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3168c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3169d;

    public l0(int i5, Class cls, int i6, int i7) {
        this.f3166a = i5;
        this.f3167b = cls;
        this.f3169d = i6;
        this.f3168c = i7;
    }

    public static boolean a(Boolean bool, Boolean bool2) {
        return (bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue());
    }

    public final Object b(View view) {
        if (!(Build.VERSION.SDK_INT >= this.f3168c)) {
            Object tag = view.getTag(this.f3166a);
            if (this.f3167b.isInstance(tag)) {
                return tag;
            }
            return null;
        }
        j0 j0Var = (j0) this;
        int i5 = j0Var.f3158e;
        switch (i5) {
            case 0:
                return j0Var.d(view);
            case 1:
                switch (i5) {
                    case 1:
                        return s0.b(view);
                    default:
                        return u0.b(view);
                }
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                switch (i5) {
                    case 1:
                        return s0.b(view);
                    default:
                        return u0.b(view);
                }
            default:
                return j0Var.d(view);
        }
    }

    public final void c(View view, Object obj) {
        boolean a5;
        if (Build.VERSION.SDK_INT >= this.f3168c) {
            int i5 = ((j0) this).f3158e;
            switch (i5) {
                case 0:
                    Boolean bool = (Boolean) obj;
                    switch (i5) {
                        case 0:
                            s0.j(view, bool.booleanValue());
                            return;
                        default:
                            s0.g(view, bool.booleanValue());
                            return;
                    }
                case 1:
                    CharSequence charSequence = (CharSequence) obj;
                    switch (i5) {
                        case 1:
                            s0.h(view, charSequence);
                            return;
                        default:
                            u0.f(view, charSequence);
                            return;
                    }
                case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                    CharSequence charSequence2 = (CharSequence) obj;
                    switch (i5) {
                        case 1:
                            s0.h(view, charSequence2);
                            return;
                        default:
                            u0.f(view, charSequence2);
                            return;
                    }
                default:
                    Boolean bool2 = (Boolean) obj;
                    switch (i5) {
                        case 0:
                            s0.j(view, bool2.booleanValue());
                            return;
                        default:
                            s0.g(view, bool2.booleanValue());
                            return;
                    }
            }
        }
        Object b5 = b(view);
        int i6 = ((j0) this).f3158e;
        switch (i6) {
            case 0:
                Boolean bool3 = (Boolean) b5;
                Boolean bool4 = (Boolean) obj;
                switch (i6) {
                    case 0:
                        a5 = a(bool3, bool4);
                        break;
                    default:
                        a5 = a(bool3, bool4);
                        break;
                }
            case 1:
                CharSequence charSequence3 = (CharSequence) b5;
                CharSequence charSequence4 = (CharSequence) obj;
                switch (i6) {
                    case 1:
                        a5 = TextUtils.equals(charSequence3, charSequence4);
                        break;
                    default:
                        a5 = TextUtils.equals(charSequence3, charSequence4);
                        break;
                }
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                CharSequence charSequence5 = (CharSequence) b5;
                CharSequence charSequence6 = (CharSequence) obj;
                switch (i6) {
                    case 1:
                        a5 = TextUtils.equals(charSequence5, charSequence6);
                        break;
                    default:
                        a5 = TextUtils.equals(charSequence5, charSequence6);
                        break;
                }
            default:
                Boolean bool5 = (Boolean) b5;
                Boolean bool6 = (Boolean) obj;
                switch (i6) {
                    case 0:
                        a5 = a(bool5, bool6);
                        break;
                    default:
                        a5 = a(bool5, bool6);
                        break;
                }
        }
        if (!a5) {
            View.AccessibilityDelegate d5 = z0.d(view);
            b bVar = d5 == null ? null : d5 instanceof a ? ((a) d5).f3090a : new b(d5);
            if (bVar == null) {
                bVar = new b();
            }
            z0.n(view, bVar);
            view.setTag(this.f3166a, obj);
            z0.h(view, this.f3169d);
        }
    }
}

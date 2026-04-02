package androidx.appcompat.widget;

import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public abstract /* synthetic */ class b0 {
    public static final void a(int i5, View view) {
        if (i5 == 0) {
            throw null;
        }
        int i6 = i5 - 1;
        if (i6 == 0) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                if (androidx.fragment.app.w0.I(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                }
                viewGroup.removeView(view);
            }
        } else if (i6 == 1) {
            if (androidx.fragment.app.w0.I(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
            }
            view.setVisibility(0);
        } else if (i6 == 2) {
            if (androidx.fragment.app.w0.I(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
            }
            view.setVisibility(8);
        } else if (i6 != 3) {
        } else {
            if (androidx.fragment.app.w0.I(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
            }
            view.setVisibility(4);
        }
    }

    public static int b(int i5) {
        if (i5 != 0) {
            if (i5 != 4) {
                if (i5 == 8) {
                    return 3;
                }
                throw new IllegalArgumentException(f("Unknown visibility ", i5));
            }
            return 4;
        }
        return 2;
    }

    public static int c(View view) {
        if (view.getAlpha() == 0.0f && view.getVisibility() == 0) {
            return 4;
        }
        return b(view.getVisibility());
    }

    public static /* synthetic */ long d(int i5) {
        if (i5 == 1) {
            return 0L;
        }
        if (i5 == 2) {
            return 1L;
        }
        if (i5 == 3) {
            return 2L;
        }
        if (i5 == 4) {
            return 3L;
        }
        if (i5 == 5) {
            return 4L;
        }
        throw null;
    }

    public static String e(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.B());
        return sb.toString();
    }

    public static String f(String str, int i5) {
        return str + i5;
    }

    public static String g(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    public static String h(String str, String str2) {
        return str + str2;
    }

    public static String i(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static /* synthetic */ void j(Parcelable parcelable) {
        if (parcelable != null) {
            throw new ClassCastException();
        }
    }

    public static /* synthetic */ void k(com.google.android.gms.internal.play_billing.r0 r0Var) {
        if (r0Var != null) {
            throw new ClassCastException();
        }
    }

    public static /* synthetic */ void l(j2.a aVar) {
        if (aVar != null) {
            throw new ClassCastException();
        }
    }

    public static /* synthetic */ void m(Object obj) {
        throw new ClassCastException();
    }

    public static /* synthetic */ void n(Object obj) {
        if (obj != null) {
            throw new ClassCastException();
        }
    }

    public static /* synthetic */ String o(int i5) {
        return i5 == 1 ? "NONE" : i5 == 2 ? "ADDING" : i5 == 3 ? "REMOVING" : "null";
    }

    public static /* synthetic */ String p(int i5) {
        return i5 == 1 ? "REMOVED" : i5 == 2 ? "VISIBLE" : i5 == 3 ? "GONE" : i5 == 4 ? "INVISIBLE" : "null";
    }

    public static /* synthetic */ String q(int i5) {
        return i5 == 1 ? "UNKNOWN" : i5 == 2 ? "HORIZONTAL_DIMENSION" : i5 == 3 ? "VERTICAL_DIMENSION" : i5 == 4 ? "LEFT" : i5 == 5 ? "RIGHT" : i5 == 6 ? "TOP" : i5 == 7 ? "BOTTOM" : i5 == 8 ? "BASELINE" : "null";
    }

    public static /* synthetic */ String r(int i5) {
        return i5 == 1 ? "OK" : i5 == 2 ? "TRANSIENT_ERROR" : i5 == 3 ? "FATAL_ERROR" : i5 == 4 ? "INVALID_PAYLOAD" : "null";
    }
}

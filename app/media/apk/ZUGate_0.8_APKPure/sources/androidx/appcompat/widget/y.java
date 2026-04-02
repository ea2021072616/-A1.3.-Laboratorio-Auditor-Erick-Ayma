package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
/* loaded from: classes.dex */
public final class y {

    /* renamed from: b  reason: collision with root package name */
    public static final PorterDuff.Mode f596b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c  reason: collision with root package name */
    public static y f597c;

    /* renamed from: a  reason: collision with root package name */
    public v2 f598a;

    public static synchronized y a() {
        y yVar;
        synchronized (y.class) {
            if (f597c == null) {
                c();
            }
            yVar = f597c;
        }
        return yVar;
    }

    public static synchronized void c() {
        synchronized (y.class) {
            if (f597c == null) {
                y yVar = new y();
                f597c = yVar;
                yVar.f598a = v2.c();
                v2 v2Var = f597c.f598a;
                x xVar = new x(0);
                synchronized (v2Var) {
                    v2Var.f559e = xVar;
                }
            }
        }
    }

    public static void d(Drawable drawable, f3 f3Var, int[] iArr) {
        PorterDuff.Mode mode = v2.f552f;
        int[] state = drawable.getState();
        if (!(drawable.mutate() == drawable)) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z4 = f3Var.f347b;
        if (!z4 && !f3Var.f346a) {
            drawable.clearColorFilter();
            return;
        }
        PorterDuffColorFilter porterDuffColorFilter = null;
        ColorStateList colorStateList = z4 ? (ColorStateList) f3Var.f348c : null;
        PorterDuff.Mode mode2 = f3Var.f346a ? (PorterDuff.Mode) f3Var.f349d : v2.f552f;
        if (colorStateList != null && mode2 != null) {
            porterDuffColorFilter = v2.g(colorStateList.getColorForState(iArr, 0), mode2);
        }
        drawable.setColorFilter(porterDuffColorFilter);
    }

    public final synchronized Drawable b(Context context, int i5) {
        return this.f598a.e(context, i5);
    }
}

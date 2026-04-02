package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
/* loaded from: classes.dex */
public final class z2 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f605a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f606b;

    /* renamed from: c  reason: collision with root package name */
    public Object f607c;

    public z2(Context context, TypedArray typedArray) {
        this.f605a = context;
        this.f606b = typedArray;
    }

    public static z2 m(Context context, AttributeSet attributeSet, int[] iArr, int i5) {
        return new z2(context, context.obtainStyledAttributes(attributeSet, iArr, i5, 0));
    }

    public final boolean a(int i5, boolean z4) {
        return ((TypedArray) this.f606b).getBoolean(i5, z4);
    }

    public final ColorStateList b(int i5) {
        int resourceId;
        ColorStateList u3;
        Object obj = this.f606b;
        return (!((TypedArray) obj).hasValue(i5) || (resourceId = ((TypedArray) obj).getResourceId(i5, 0)) == 0 || (u3 = p2.a.u((Context) this.f605a, resourceId)) == null) ? ((TypedArray) obj).getColorStateList(i5) : u3;
    }

    public final int c(int i5, int i6) {
        return ((TypedArray) this.f606b).getDimensionPixelOffset(i5, i6);
    }

    public final int d(int i5, int i6) {
        return ((TypedArray) this.f606b).getDimensionPixelSize(i5, i6);
    }

    public final Drawable e(int i5) {
        int resourceId;
        Object obj = this.f606b;
        return (!((TypedArray) obj).hasValue(i5) || (resourceId = ((TypedArray) obj).getResourceId(i5, 0)) == 0) ? ((TypedArray) obj).getDrawable(i5) : p2.a.x((Context) this.f605a, resourceId);
    }

    public final Drawable f(int i5) {
        int resourceId;
        Drawable f5;
        if (!((TypedArray) this.f606b).hasValue(i5) || (resourceId = ((TypedArray) this.f606b).getResourceId(i5, 0)) == 0) {
            return null;
        }
        y a5 = y.a();
        Context context = (Context) this.f605a;
        synchronized (a5) {
            f5 = a5.f598a.f(context, resourceId, true);
        }
        return f5;
    }

    public final Typeface g(int i5, int i6, z0 z0Var) {
        int resourceId = ((TypedArray) this.f606b).getResourceId(i5, 0);
        if (resourceId == 0) {
            return null;
        }
        if (((TypedValue) this.f607c) == null) {
            this.f607c = new TypedValue();
        }
        Context context = (Context) this.f605a;
        TypedValue typedValue = (TypedValue) this.f607c;
        ThreadLocal threadLocal = y.q.f5568a;
        if (context.isRestricted()) {
            return null;
        }
        return y.q.c(context, resourceId, typedValue, i6, z0Var, true, false);
    }

    public final int h(int i5, int i6) {
        return ((TypedArray) this.f606b).getInt(i5, i6);
    }

    public final int i(int i5, int i6) {
        return ((TypedArray) this.f606b).getResourceId(i5, i6);
    }

    public final String j(int i5) {
        return ((TypedArray) this.f606b).getString(i5);
    }

    public final CharSequence k(int i5) {
        return ((TypedArray) this.f606b).getText(i5);
    }

    public final boolean l(int i5) {
        return ((TypedArray) this.f606b).hasValue(i5);
    }

    public final void n() {
        ((TypedArray) this.f606b).recycle();
    }
}

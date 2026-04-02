package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public final class g0 {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f350a;

    /* renamed from: b  reason: collision with root package name */
    public f3 f351b;

    /* renamed from: c  reason: collision with root package name */
    public int f352c = 0;

    public g0(ImageView imageView) {
        this.f350a = imageView;
    }

    public final void a() {
        f3 f3Var;
        ImageView imageView = this.f350a;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            v1.a(drawable);
        }
        if (drawable == null || (f3Var = this.f351b) == null) {
            return;
        }
        y.d(drawable, f3Var, imageView.getDrawableState());
    }

    public final void b(AttributeSet attributeSet, int i5) {
        int i6;
        ImageView imageView = this.f350a;
        Context context = imageView.getContext();
        int[] iArr = c.a.f1689f;
        z2 m5 = z2.m(context, attributeSet, iArr, i5);
        h0.z0.m(imageView, imageView.getContext(), iArr, attributeSet, (TypedArray) m5.f606b, i5);
        try {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null && (i6 = m5.i(1, -1)) != -1 && (drawable = p2.a.x(imageView.getContext(), i6)) != null) {
                imageView.setImageDrawable(drawable);
            }
            if (drawable != null) {
                v1.a(drawable);
            }
            if (m5.l(2)) {
                n0.f.c(imageView, m5.b(2));
            }
            if (m5.l(3)) {
                n0.f.d(imageView, v1.c(m5.h(3, -1), null));
            }
        } finally {
            m5.n();
        }
    }

    public final void c(int i5) {
        ImageView imageView = this.f350a;
        if (i5 != 0) {
            Drawable x5 = p2.a.x(imageView.getContext(), i5);
            if (x5 != null) {
                v1.a(x5);
            }
            imageView.setImageDrawable(x5);
        } else {
            imageView.setImageDrawable(null);
        }
        a();
    }
}

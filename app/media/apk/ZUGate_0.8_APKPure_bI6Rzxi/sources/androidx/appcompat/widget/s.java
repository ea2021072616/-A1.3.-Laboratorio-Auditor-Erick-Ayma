package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import java.util.List;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f515a;

    /* renamed from: b  reason: collision with root package name */
    public int f516b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f517c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f518d;

    /* renamed from: e  reason: collision with root package name */
    public Object f519e;

    /* renamed from: f  reason: collision with root package name */
    public Object f520f;

    /* renamed from: g  reason: collision with root package name */
    public Object f521g;

    public s(View view) {
        this.f515a = 0;
        this.f516b = -1;
        this.f517c = view;
        this.f518d = y.a();
    }

    public static s b(Context context, int i5) {
        p2.a.h("Cannot create a CalendarItemStyle with a styleResId of 0", i5 != 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i5, w2.a.f5398m);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(0, 0), obtainStyledAttributes.getDimensionPixelOffset(2, 0), obtainStyledAttributes.getDimensionPixelOffset(1, 0), obtainStyledAttributes.getDimensionPixelOffset(3, 0));
        ColorStateList v5 = p2.a.v(context, obtainStyledAttributes, 4);
        ColorStateList v6 = p2.a.v(context, obtainStyledAttributes, 9);
        ColorStateList v7 = p2.a.v(context, obtainStyledAttributes, 7);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        p3.j jVar = new p3.j(p3.j.a(context, obtainStyledAttributes.getResourceId(5, 0), obtainStyledAttributes.getResourceId(6, 0), new p3.a(0)));
        obtainStyledAttributes.recycle();
        return new s(v5, v6, v7, dimensionPixelSize, jVar, rect);
    }

    public final void a() {
        View view = (View) this.f517c;
        Drawable background = view.getBackground();
        if (background != null) {
            boolean z4 = false;
            if (((f3) this.f519e) != null) {
                if (((f3) this.f521g) == null) {
                    this.f521g = new f3(0);
                }
                f3 f3Var = (f3) this.f521g;
                f3Var.f348c = null;
                f3Var.f347b = false;
                f3Var.f349d = null;
                f3Var.f346a = false;
                WeakHashMap weakHashMap = h0.z0.f3233a;
                ColorStateList g5 = h0.o0.g(view);
                if (g5 != null) {
                    f3Var.f347b = true;
                    f3Var.f348c = g5;
                }
                PorterDuff.Mode h5 = h0.o0.h(view);
                if (h5 != null) {
                    f3Var.f346a = true;
                    f3Var.f349d = h5;
                }
                if (f3Var.f347b || f3Var.f346a) {
                    y.d(background, f3Var, view.getDrawableState());
                    z4 = true;
                }
                if (z4) {
                    return;
                }
            }
            f3 f3Var2 = (f3) this.f520f;
            if (f3Var2 != null) {
                y.d(background, f3Var2, view.getDrawableState());
                return;
            }
            f3 f3Var3 = (f3) this.f519e;
            if (f3Var3 != null) {
                y.d(background, f3Var3, view.getDrawableState());
            }
        }
    }

    public final ColorStateList c() {
        Object obj = this.f520f;
        if (((f3) obj) != null) {
            return (ColorStateList) ((f3) obj).f348c;
        }
        return null;
    }

    public final PorterDuff.Mode d() {
        Object obj = this.f520f;
        if (((f3) obj) != null) {
            return (PorterDuff.Mode) ((f3) obj).f349d;
        }
        return null;
    }

    public final void e(AttributeSet attributeSet, int i5) {
        ColorStateList h5;
        Object obj = this.f517c;
        View view = (View) obj;
        Context context = view.getContext();
        int[] iArr = c.a.f1708z;
        z2 m5 = z2.m(context, attributeSet, iArr, i5);
        h0.z0.m(view, view.getContext(), iArr, attributeSet, (TypedArray) m5.f606b, i5);
        try {
            if (m5.l(0)) {
                this.f516b = m5.i(0, -1);
                y yVar = (y) this.f518d;
                Context context2 = ((View) obj).getContext();
                int i6 = this.f516b;
                synchronized (yVar) {
                    h5 = yVar.f598a.h(context2, i6);
                }
                if (h5 != null) {
                    h(h5);
                }
            }
            if (m5.l(1)) {
                h0.o0.q((View) obj, m5.b(1));
            }
            if (m5.l(2)) {
                h0.o0.r((View) obj, v1.c(m5.h(2, -1), null));
            }
        } finally {
            m5.n();
        }
    }

    public final void f() {
        this.f516b = -1;
        h(null);
        a();
    }

    public final void g(int i5) {
        ColorStateList colorStateList;
        this.f516b = i5;
        y yVar = (y) this.f518d;
        if (yVar != null) {
            Context context = ((View) this.f517c).getContext();
            synchronized (yVar) {
                colorStateList = yVar.f598a.h(context, i5);
            }
        } else {
            colorStateList = null;
        }
        h(colorStateList);
        a();
    }

    public final void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (((f3) this.f519e) == null) {
                this.f519e = new f3(0);
            }
            Object obj = this.f519e;
            ((f3) obj).f348c = colorStateList;
            ((f3) obj).f347b = true;
        } else {
            this.f519e = null;
        }
        a();
    }

    public final void i(ColorStateList colorStateList) {
        if (((f3) this.f520f) == null) {
            this.f520f = new f3(0);
        }
        f3 f3Var = (f3) this.f520f;
        f3Var.f348c = colorStateList;
        f3Var.f347b = true;
        a();
    }

    public final void j(PorterDuff.Mode mode) {
        if (((f3) this.f520f) == null) {
            this.f520f = new f3(0);
        }
        f3 f3Var = (f3) this.f520f;
        f3Var.f349d = mode;
        f3Var.f346a = true;
        a();
    }

    public final String toString() {
        switch (this.f515a) {
            case 1:
                StringBuilder sb = new StringBuilder();
                sb.append("FontRequest {mProviderAuthority: " + ((String) this.f517c) + ", mProviderPackage: " + ((String) this.f518d) + ", mQuery: " + ((String) this.f519e) + ", mCertificates:");
                for (int i5 = 0; i5 < ((List) this.f520f).size(); i5++) {
                    sb.append(" [");
                    List list = (List) ((List) this.f520f).get(i5);
                    for (int i6 = 0; i6 < list.size(); i6++) {
                        sb.append(" \"");
                        sb.append(Base64.encodeToString((byte[]) list.get(i6), 0));
                        sb.append("\"");
                    }
                    sb.append(" ]");
                }
                sb.append("}");
                sb.append("mCertificatesArray: " + this.f516b);
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public s(String str, String str2, String str3, List list) {
        this.f515a = 1;
        str.getClass();
        this.f517c = str;
        str2.getClass();
        this.f518d = str2;
        this.f519e = str3;
        list.getClass();
        this.f520f = list;
        this.f516b = 0;
        this.f521g = str + "-" + str2 + "-" + str3;
    }

    public s(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i5, p3.j jVar, Rect rect) {
        this.f515a = 2;
        p2.a.i(rect.left);
        p2.a.i(rect.top);
        p2.a.i(rect.right);
        p2.a.i(rect.bottom);
        this.f517c = rect;
        this.f518d = colorStateList2;
        this.f519e = colorStateList;
        this.f520f = colorStateList3;
        this.f516b = i5;
        this.f521g = jVar;
    }
}

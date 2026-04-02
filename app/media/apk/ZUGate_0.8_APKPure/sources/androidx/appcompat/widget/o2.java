package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class o2 implements h.e0 {
    public static final Method G;
    public static final Method H;
    public final Handler B;
    public Rect D;
    public boolean E;
    public final j0 F;

    /* renamed from: g  reason: collision with root package name */
    public final Context f450g;

    /* renamed from: h  reason: collision with root package name */
    public ListAdapter f451h;

    /* renamed from: i  reason: collision with root package name */
    public b2 f452i;

    /* renamed from: l  reason: collision with root package name */
    public int f455l;

    /* renamed from: m  reason: collision with root package name */
    public int f456m;
    public boolean o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f458p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f459q;

    /* renamed from: t  reason: collision with root package name */
    public l2 f462t;

    /* renamed from: u  reason: collision with root package name */
    public View f463u;

    /* renamed from: v  reason: collision with root package name */
    public AdapterView.OnItemClickListener f464v;

    /* renamed from: w  reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f465w;

    /* renamed from: j  reason: collision with root package name */
    public final int f453j = -2;

    /* renamed from: k  reason: collision with root package name */
    public int f454k = -2;

    /* renamed from: n  reason: collision with root package name */
    public final int f457n = 1002;

    /* renamed from: r  reason: collision with root package name */
    public int f460r = 0;

    /* renamed from: s  reason: collision with root package name */
    public final int f461s = Integer.MAX_VALUE;

    /* renamed from: x  reason: collision with root package name */
    public final h2 f466x = new h2(this, 2);

    /* renamed from: y  reason: collision with root package name */
    public final n2 f467y = new n2(0, this);

    /* renamed from: z  reason: collision with root package name */
    public final m2 f468z = new m2(this);
    public final h2 A = new h2(this, 1);
    public final Rect C = new Rect();

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                G = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                H = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
    }

    public o2(Context context, AttributeSet attributeSet, int i5, int i6) {
        this.f450g = context;
        this.B = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.o, i5, i6);
        this.f455l = obtainStyledAttributes.getDimensionPixelOffset(0, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.f456m = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.o = true;
        }
        obtainStyledAttributes.recycle();
        j0 j0Var = new j0(context, attributeSet, i5, i6);
        this.F = j0Var;
        j0Var.setInputMethodMode(1);
    }

    @Override // h.e0
    public final boolean a() {
        return this.F.isShowing();
    }

    public final void b(int i5) {
        this.f455l = i5;
    }

    public final int c() {
        return this.f455l;
    }

    @Override // h.e0
    public final void dismiss() {
        j0 j0Var = this.F;
        j0Var.dismiss();
        j0Var.setContentView(null);
        this.f452i = null;
        this.B.removeCallbacks(this.f466x);
    }

    public final int e() {
        if (this.o) {
            return this.f456m;
        }
        return 0;
    }

    @Override // h.e0
    public final void f() {
        int i5;
        int paddingBottom;
        b2 b2Var;
        b2 b2Var2 = this.f452i;
        j0 j0Var = this.F;
        Context context = this.f450g;
        if (b2Var2 == null) {
            b2 q5 = q(context, !this.E);
            this.f452i = q5;
            q5.setAdapter(this.f451h);
            this.f452i.setOnItemClickListener(this.f464v);
            this.f452i.setFocusable(true);
            this.f452i.setFocusableInTouchMode(true);
            this.f452i.setOnItemSelectedListener(new i2(0, this));
            this.f452i.setOnScrollListener(this.f468z);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f465w;
            if (onItemSelectedListener != null) {
                this.f452i.setOnItemSelectedListener(onItemSelectedListener);
            }
            j0Var.setContentView(this.f452i);
        } else {
            ViewGroup viewGroup = (ViewGroup) j0Var.getContentView();
        }
        Drawable background = j0Var.getBackground();
        Rect rect = this.C;
        if (background != null) {
            background.getPadding(rect);
            int i6 = rect.top;
            i5 = rect.bottom + i6;
            if (!this.o) {
                this.f456m = -i6;
            }
        } else {
            rect.setEmpty();
            i5 = 0;
        }
        int a5 = j2.a(j0Var, this.f463u, this.f456m, j0Var.getInputMethodMode() == 2);
        int i7 = this.f453j;
        if (i7 == -1) {
            paddingBottom = a5 + i5;
        } else {
            int i8 = this.f454k;
            int a6 = this.f452i.a(i8 != -2 ? i8 != -1 ? View.MeasureSpec.makeMeasureSpec(i8, 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), Integer.MIN_VALUE), a5 + 0);
            paddingBottom = a6 + (a6 > 0 ? this.f452i.getPaddingBottom() + this.f452i.getPaddingTop() + i5 + 0 : 0);
        }
        boolean z4 = j0Var.getInputMethodMode() == 2;
        n0.l.d(j0Var, this.f457n);
        if (j0Var.isShowing()) {
            if (this.f463u.isAttachedToWindow()) {
                int i9 = this.f454k;
                if (i9 == -1) {
                    i9 = -1;
                } else if (i9 == -2) {
                    i9 = this.f463u.getWidth();
                }
                if (i7 == -1) {
                    i7 = z4 ? paddingBottom : -1;
                    if (z4) {
                        j0Var.setWidth(this.f454k == -1 ? -1 : 0);
                        j0Var.setHeight(0);
                    } else {
                        j0Var.setWidth(this.f454k == -1 ? -1 : 0);
                        j0Var.setHeight(-1);
                    }
                } else if (i7 == -2) {
                    i7 = paddingBottom;
                }
                j0Var.setOutsideTouchable(true);
                View view = this.f463u;
                int i10 = this.f455l;
                int i11 = this.f456m;
                if (i9 < 0) {
                    i9 = -1;
                }
                j0Var.update(view, i10, i11, i9, i7 < 0 ? -1 : i7);
                return;
            }
            return;
        }
        int i12 = this.f454k;
        if (i12 == -1) {
            i12 = -1;
        } else if (i12 == -2) {
            i12 = this.f463u.getWidth();
        }
        if (i7 == -1) {
            i7 = -1;
        } else if (i7 == -2) {
            i7 = paddingBottom;
        }
        j0Var.setWidth(i12);
        j0Var.setHeight(i7);
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = G;
            if (method != null) {
                try {
                    method.invoke(j0Var, Boolean.TRUE);
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            k2.b(j0Var, true);
        }
        j0Var.setOutsideTouchable(true);
        j0Var.setTouchInterceptor(this.f467y);
        if (this.f459q) {
            n0.l.c(j0Var, this.f458p);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method2 = H;
            if (method2 != null) {
                try {
                    method2.invoke(j0Var, this.D);
                } catch (Exception e5) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e5);
                }
            }
        } else {
            k2.a(j0Var, this.D);
        }
        j0Var.showAsDropDown(this.f463u, this.f455l, this.f456m, this.f460r);
        this.f452i.setSelection(-1);
        if ((!this.E || this.f452i.isInTouchMode()) && (b2Var = this.f452i) != null) {
            b2Var.setListSelectionHidden(true);
            b2Var.requestLayout();
        }
        if (this.E) {
            return;
        }
        this.B.post(this.A);
    }

    public final Drawable h() {
        return this.F.getBackground();
    }

    @Override // h.e0
    public final b2 j() {
        return this.f452i;
    }

    public final void m(Drawable drawable) {
        this.F.setBackgroundDrawable(drawable);
    }

    public final void n(int i5) {
        this.f456m = i5;
        this.o = true;
    }

    public void o(ListAdapter listAdapter) {
        l2 l2Var = this.f462t;
        if (l2Var == null) {
            this.f462t = new l2(this);
        } else {
            ListAdapter listAdapter2 = this.f451h;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(l2Var);
            }
        }
        this.f451h = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f462t);
        }
        b2 b2Var = this.f452i;
        if (b2Var != null) {
            b2Var.setAdapter(this.f451h);
        }
    }

    public b2 q(Context context, boolean z4) {
        return new b2(context, z4);
    }

    public final void r(int i5) {
        Drawable background = this.F.getBackground();
        if (background == null) {
            this.f454k = i5;
            return;
        }
        Rect rect = this.C;
        background.getPadding(rect);
        this.f454k = rect.left + rect.right + i5;
    }
}

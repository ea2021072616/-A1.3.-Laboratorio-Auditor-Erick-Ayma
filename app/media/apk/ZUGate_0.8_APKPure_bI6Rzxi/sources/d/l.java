package d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.core.widget.NestedScrollView;
import com.github.appintro.R;
/* loaded from: classes.dex */
public final class l {
    public TextView A;
    public TextView B;
    public View C;
    public ListAdapter D;
    public final int F;
    public final int G;
    public final int H;
    public final int I;
    public final int J;
    public final boolean K;
    public final j L;

    /* renamed from: a  reason: collision with root package name */
    public final Context f2372a;

    /* renamed from: b  reason: collision with root package name */
    public final p0 f2373b;

    /* renamed from: c  reason: collision with root package name */
    public final Window f2374c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2375d;

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f2376e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f2377f;

    /* renamed from: g  reason: collision with root package name */
    public AlertController$RecycleListView f2378g;

    /* renamed from: h  reason: collision with root package name */
    public View f2379h;

    /* renamed from: i  reason: collision with root package name */
    public int f2380i;

    /* renamed from: k  reason: collision with root package name */
    public Button f2382k;

    /* renamed from: l  reason: collision with root package name */
    public CharSequence f2383l;

    /* renamed from: m  reason: collision with root package name */
    public Message f2384m;

    /* renamed from: n  reason: collision with root package name */
    public Drawable f2385n;
    public Button o;

    /* renamed from: p  reason: collision with root package name */
    public CharSequence f2386p;

    /* renamed from: q  reason: collision with root package name */
    public Message f2387q;

    /* renamed from: r  reason: collision with root package name */
    public Drawable f2388r;

    /* renamed from: s  reason: collision with root package name */
    public Button f2389s;

    /* renamed from: t  reason: collision with root package name */
    public CharSequence f2390t;

    /* renamed from: u  reason: collision with root package name */
    public Message f2391u;

    /* renamed from: v  reason: collision with root package name */
    public Drawable f2392v;

    /* renamed from: w  reason: collision with root package name */
    public NestedScrollView f2393w;

    /* renamed from: y  reason: collision with root package name */
    public Drawable f2395y;

    /* renamed from: z  reason: collision with root package name */
    public ImageView f2396z;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2381j = false;

    /* renamed from: x  reason: collision with root package name */
    public int f2394x = 0;
    public int E = -1;
    public final d M = new d(0, this);

    public l(Context context, p0 p0Var, Window window) {
        this.f2372a = context;
        this.f2373b = p0Var;
        this.f2374c = window;
        this.L = new j(p0Var);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, c.a.f1688e, R.attr.alertDialogStyle, 0);
        this.F = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.getResourceId(2, 0);
        this.G = obtainStyledAttributes.getResourceId(4, 0);
        this.H = obtainStyledAttributes.getResourceId(5, 0);
        this.I = obtainStyledAttributes.getResourceId(7, 0);
        this.J = obtainStyledAttributes.getResourceId(3, 0);
        this.K = obtainStyledAttributes.getBoolean(6, true);
        this.f2375d = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
        p0Var.c().j(1);
    }

    public static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            while (childCount > 0) {
                childCount--;
                if (a(viewGroup.getChildAt(childCount))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    public static void c(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    public static ViewGroup d(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public final void e(int i5, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        Message obtainMessage = onClickListener != null ? this.L.obtainMessage(i5, onClickListener) : null;
        if (i5 == -3) {
            this.f2390t = charSequence;
            this.f2391u = obtainMessage;
            this.f2392v = null;
        } else if (i5 == -2) {
            this.f2386p = charSequence;
            this.f2387q = obtainMessage;
            this.f2388r = null;
        } else if (i5 != -1) {
            throw new IllegalArgumentException("Button does not exist");
        } else {
            this.f2383l = charSequence;
            this.f2384m = obtainMessage;
            this.f2385n = null;
        }
    }
}

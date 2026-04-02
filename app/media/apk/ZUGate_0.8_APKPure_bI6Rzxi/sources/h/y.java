package h;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.github.appintro.R;
/* loaded from: classes.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    public final Context f3078a;

    /* renamed from: b  reason: collision with root package name */
    public final o f3079b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f3080c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3081d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3082e;

    /* renamed from: f  reason: collision with root package name */
    public View f3083f;

    /* renamed from: g  reason: collision with root package name */
    public int f3084g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3085h;

    /* renamed from: i  reason: collision with root package name */
    public z f3086i;

    /* renamed from: j  reason: collision with root package name */
    public w f3087j;

    /* renamed from: k  reason: collision with root package name */
    public PopupWindow.OnDismissListener f3088k;

    /* renamed from: l  reason: collision with root package name */
    public final x f3089l;

    public y(Context context, o oVar, View view, boolean z4) {
        this(R.attr.actionOverflowMenuStyle, 0, context, view, oVar, z4);
    }

    public final w a() {
        w f0Var;
        if (this.f3087j == null) {
            Context context = this.f3078a;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            if (Math.min(point.x, point.y) >= context.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
                f0Var = new i(this.f3078a, this.f3083f, this.f3081d, this.f3082e, this.f3080c);
            } else {
                f0Var = new f0(this.f3081d, this.f3082e, this.f3078a, this.f3083f, this.f3079b, this.f3080c);
            }
            f0Var.l(this.f3079b);
            f0Var.r(this.f3089l);
            f0Var.n(this.f3083f);
            f0Var.c(this.f3086i);
            f0Var.o(this.f3085h);
            f0Var.p(this.f3084g);
            this.f3087j = f0Var;
        }
        return this.f3087j;
    }

    public final boolean b() {
        w wVar = this.f3087j;
        return wVar != null && wVar.a();
    }

    public void c() {
        this.f3087j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f3088k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final void d(int i5, int i6, boolean z4, boolean z5) {
        w a5 = a();
        a5.s(z5);
        if (z4) {
            if ((Gravity.getAbsoluteGravity(this.f3084g, this.f3083f.getLayoutDirection()) & 7) == 5) {
                i5 -= this.f3083f.getWidth();
            }
            a5.q(i5);
            a5.t(i6);
            int i7 = (int) ((this.f3078a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            a5.f3076g = new Rect(i5 - i7, i6 - i7, i5 + i7, i6 + i7);
        }
        a5.f();
    }

    public y(int i5, int i6, Context context, View view, o oVar, boolean z4) {
        this.f3084g = 8388611;
        this.f3089l = new x(this);
        this.f3078a = context;
        this.f3079b = oVar;
        this.f3083f = view;
        this.f3080c = z4;
        this.f3081d = i5;
        this.f3082e = i6;
    }
}

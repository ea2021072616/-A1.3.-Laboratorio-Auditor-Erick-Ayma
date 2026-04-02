package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import com.github.appintro.R;
/* loaded from: classes.dex */
public final class u0 extends o2 implements w0 {
    public CharSequence I;
    public ListAdapter J;
    public final Rect K;
    public int L;
    public final /* synthetic */ x0 M;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u0(x0 x0Var, Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.spinnerStyle, 0);
        this.M = x0Var;
        this.K = new Rect();
        this.f463u = x0Var;
        this.E = true;
        this.F.setFocusable(true);
        this.f464v = new d.g(this, 1, x0Var);
    }

    @Override // androidx.appcompat.widget.w0
    public final void d(int i5, int i6) {
        ViewTreeObserver viewTreeObserver;
        boolean a5 = a();
        s();
        j0 j0Var = this.F;
        j0Var.setInputMethodMode(2);
        f();
        b2 b2Var = this.f452i;
        b2Var.setChoiceMode(1);
        b2Var.setTextDirection(i5);
        b2Var.setTextAlignment(i6);
        x0 x0Var = this.M;
        int selectedItemPosition = x0Var.getSelectedItemPosition();
        b2 b2Var2 = this.f452i;
        if (a() && b2Var2 != null) {
            b2Var2.setListSelectionHidden(false);
            b2Var2.setSelection(selectedItemPosition);
            if (b2Var2.getChoiceMode() != 0) {
                b2Var2.setItemChecked(selectedItemPosition, true);
            }
        }
        if (a5 || (viewTreeObserver = x0Var.getViewTreeObserver()) == null) {
            return;
        }
        h.e eVar = new h.e(3, this);
        viewTreeObserver.addOnGlobalLayoutListener(eVar);
        j0Var.setOnDismissListener(new t0(this, eVar));
    }

    @Override // androidx.appcompat.widget.w0
    public final CharSequence i() {
        return this.I;
    }

    @Override // androidx.appcompat.widget.w0
    public final void k(CharSequence charSequence) {
        this.I = charSequence;
    }

    @Override // androidx.appcompat.widget.o2, androidx.appcompat.widget.w0
    public final void o(ListAdapter listAdapter) {
        super.o(listAdapter);
        this.J = listAdapter;
    }

    @Override // androidx.appcompat.widget.w0
    public final void p(int i5) {
        this.L = i5;
    }

    public final void s() {
        int i5;
        Drawable h5 = h();
        x0 x0Var = this.M;
        if (h5 != null) {
            h5.getPadding(x0Var.f583n);
            boolean z4 = v3.f560a;
            boolean z5 = x0Var.getLayoutDirection() == 1;
            Rect rect = x0Var.f583n;
            i5 = z5 ? rect.right : -rect.left;
        } else {
            Rect rect2 = x0Var.f583n;
            rect2.right = 0;
            rect2.left = 0;
            i5 = 0;
        }
        int paddingLeft = x0Var.getPaddingLeft();
        int paddingRight = x0Var.getPaddingRight();
        int width = x0Var.getWidth();
        int i6 = x0Var.f582m;
        if (i6 == -2) {
            int a5 = x0Var.a((SpinnerAdapter) this.J, h());
            int i7 = x0Var.getContext().getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = x0Var.f583n;
            int i8 = (i7 - rect3.left) - rect3.right;
            if (a5 > i8) {
                a5 = i8;
            }
            r(Math.max(a5, (width - paddingLeft) - paddingRight));
        } else if (i6 == -1) {
            r((width - paddingLeft) - paddingRight);
        } else {
            r(i6);
        }
        boolean z6 = v3.f560a;
        this.f455l = x0Var.getLayoutDirection() == 1 ? (((width - paddingRight) - this.f454k) - this.L) + i5 : paddingLeft + this.L + i5;
    }
}

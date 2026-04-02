package com.google.android.material.internal;

import a0.a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.f2;
import androidx.appcompat.widget.q3;
import com.github.appintro.R;
import h.b0;
import h.q;
import h0.z0;
import j3.d;
import java.util.WeakHashMap;
import y.i;
/* loaded from: classes.dex */
public class NavigationMenuItemView extends d implements b0 {
    public static final int[] M = {16842912};
    public int B;
    public boolean C;
    public boolean D;
    public final boolean E;
    public final CheckedTextView F;
    public FrameLayout G;
    public q H;
    public ColorStateList I;
    public boolean J;
    public Drawable K;
    public final y0.b0 L;

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.E = true;
        y0.b0 b0Var = new y0.b0(4, this);
        this.L = b0Var;
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(R.dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(R.id.design_menu_item_text);
        this.F = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        z0.n(checkedTextView, b0Var);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.G == null) {
                this.G = (FrameLayout) ((ViewStub) findViewById(R.id.design_menu_item_action_area_stub)).inflate();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.G.removeAllViews();
            this.G.addView(view);
        }
    }

    @Override // h.b0
    public final void c(q qVar) {
        StateListDrawable stateListDrawable;
        this.H = qVar;
        int i5 = qVar.f3047g;
        if (i5 > 0) {
            setId(i5);
        }
        setVisibility(qVar.isVisible() ? 0 : 8);
        boolean z4 = true;
        if (getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(R.attr.colorControlHighlight, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(M, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            WeakHashMap weakHashMap = z0.f3233a;
            setBackground(stateListDrawable);
        }
        setCheckable(qVar.isCheckable());
        setChecked(qVar.isChecked());
        setEnabled(qVar.isEnabled());
        setTitle(qVar.f3051k);
        setIcon(qVar.getIcon());
        setActionView(qVar.getActionView());
        setContentDescription(qVar.f3062w);
        q3.a(this, qVar.f3063x);
        q qVar2 = this.H;
        if (qVar2.f3051k != null || qVar2.getIcon() != null || this.H.getActionView() == null) {
            z4 = false;
        }
        CheckedTextView checkedTextView = this.F;
        if (z4) {
            checkedTextView.setVisibility(8);
            FrameLayout frameLayout = this.G;
            if (frameLayout != null) {
                f2 f2Var = (f2) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) f2Var).width = -1;
                this.G.setLayoutParams(f2Var);
                return;
            }
            return;
        }
        checkedTextView.setVisibility(0);
        FrameLayout frameLayout2 = this.G;
        if (frameLayout2 != null) {
            f2 f2Var2 = (f2) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) f2Var2).width = -2;
            this.G.setLayoutParams(f2Var2);
        }
    }

    @Override // h.b0
    public q getItemData() {
        return this.H;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i5) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i5 + 1);
        q qVar = this.H;
        if (qVar != null && qVar.isCheckable() && this.H.isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, M);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z4) {
        refreshDrawableState();
        if (this.D != z4) {
            this.D = z4;
            this.L.h(this.F, 2048);
        }
    }

    public void setChecked(boolean z4) {
        refreshDrawableState();
        CheckedTextView checkedTextView = this.F;
        checkedTextView.setChecked(z4);
        checkedTextView.setTypeface(checkedTextView.getTypeface(), (z4 && this.E) ? 1 : 0);
    }

    public void setHorizontalPadding(int i5) {
        setPadding(i5, getPaddingTop(), i5, getPaddingBottom());
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.J) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = drawable.mutate();
                a.h(drawable, this.I);
            }
            int i5 = this.B;
            drawable.setBounds(0, 0, i5, i5);
        } else if (this.C) {
            if (this.K == null) {
                Resources resources = getResources();
                Resources.Theme theme = getContext().getTheme();
                ThreadLocal threadLocal = y.q.f5568a;
                Drawable a5 = i.a(resources, R.drawable.navigation_empty_icon, theme);
                this.K = a5;
                if (a5 != null) {
                    int i6 = this.B;
                    a5.setBounds(0, 0, i6, i6);
                }
            }
            drawable = this.K;
        }
        this.F.setCompoundDrawablesRelative(drawable, null, null, null);
    }

    public void setIconPadding(int i5) {
        this.F.setCompoundDrawablePadding(i5);
    }

    public void setIconSize(int i5) {
        this.B = i5;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.I = colorStateList;
        this.J = colorStateList != null;
        q qVar = this.H;
        if (qVar != null) {
            setIcon(qVar.getIcon());
        }
    }

    public void setMaxLines(int i5) {
        this.F.setMaxLines(i5);
    }

    public void setNeedsEmptyIcon(boolean z4) {
        this.C = z4;
    }

    public void setTextAppearance(int i5) {
        this.F.setTextAppearance(i5);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.F.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.F.setText(charSequence);
    }
}

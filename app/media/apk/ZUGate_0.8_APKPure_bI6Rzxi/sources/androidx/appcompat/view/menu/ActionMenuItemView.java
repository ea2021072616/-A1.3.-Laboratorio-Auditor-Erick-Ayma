package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.i1;
import androidx.appcompat.widget.o;
import androidx.appcompat.widget.q3;
import c.a;
import h.b;
import h.b0;
import h.c;
import h.n;
import h.q;
/* loaded from: classes.dex */
public class ActionMenuItemView extends i1 implements b0, View.OnClickListener, o {

    /* renamed from: n  reason: collision with root package name */
    public q f129n;
    public CharSequence o;

    /* renamed from: p  reason: collision with root package name */
    public Drawable f130p;

    /* renamed from: q  reason: collision with root package name */
    public n f131q;

    /* renamed from: r  reason: collision with root package name */
    public b f132r;

    /* renamed from: s  reason: collision with root package name */
    public c f133s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f134t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f135u;

    /* renamed from: v  reason: collision with root package name */
    public final int f136v;

    /* renamed from: w  reason: collision with root package name */
    public int f137w;

    /* renamed from: x  reason: collision with root package name */
    public final int f138x;

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Resources resources = context.getResources();
        this.f134t = n();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f1686c, 0, 0);
        this.f136v = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.f138x = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f137w = -1;
        setSaveEnabled(false);
    }

    @Override // androidx.appcompat.widget.o
    public final boolean a() {
        return m();
    }

    @Override // androidx.appcompat.widget.o
    public final boolean b() {
        return m() && this.f129n.getIcon() == null;
    }

    @Override // h.b0
    public final void c(q qVar) {
        this.f129n = qVar;
        setIcon(qVar.getIcon());
        setTitle(qVar.getTitleCondensed());
        setId(qVar.f3047g);
        setVisibility(qVar.isVisible() ? 0 : 8);
        setEnabled(qVar.isEnabled());
        if (qVar.hasSubMenu() && this.f132r == null) {
            this.f132r = new b(this);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // h.b0
    public q getItemData() {
        return this.f129n;
    }

    public final boolean m() {
        return !TextUtils.isEmpty(getText());
    }

    public final boolean n() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i5 = configuration.screenWidthDp;
        return i5 >= 480 || (i5 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    public final void o() {
        boolean z4 = true;
        boolean z5 = !TextUtils.isEmpty(this.o);
        if (this.f130p != null) {
            if (!((this.f129n.E & 4) == 4) || (!this.f134t && !this.f135u)) {
                z4 = false;
            }
        }
        boolean z6 = z5 & z4;
        setText(z6 ? this.o : null);
        CharSequence charSequence = this.f129n.f3062w;
        if (TextUtils.isEmpty(charSequence)) {
            setContentDescription(z6 ? null : this.f129n.f3051k);
        } else {
            setContentDescription(charSequence);
        }
        CharSequence charSequence2 = this.f129n.f3063x;
        if (TextUtils.isEmpty(charSequence2)) {
            q3.a(this, z6 ? null : this.f129n.f3051k);
        } else {
            q3.a(this, charSequence2);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        n nVar = this.f131q;
        if (nVar != null) {
            nVar.b(this.f129n);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f134t = n();
        o();
    }

    @Override // androidx.appcompat.widget.i1, android.widget.TextView, android.view.View
    public final void onMeasure(int i5, int i6) {
        int i7;
        boolean m5 = m();
        if (m5 && (i7 = this.f137w) >= 0) {
            super.setPadding(i7, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i5, i6);
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i5);
        int measuredWidth = getMeasuredWidth();
        int i8 = this.f136v;
        int min = mode == Integer.MIN_VALUE ? Math.min(size, i8) : i8;
        if (mode != 1073741824 && i8 > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i6);
        }
        if (m5 || this.f130p == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f130p.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        b bVar;
        if (this.f129n.hasSubMenu() && (bVar = this.f132r) != null && bVar.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z4) {
    }

    public void setChecked(boolean z4) {
    }

    public void setExpandedFormat(boolean z4) {
        if (this.f135u != z4) {
            this.f135u = z4;
            q qVar = this.f129n;
            if (qVar != null) {
                h.o oVar = qVar.f3059t;
                oVar.f3034q = true;
                oVar.p(true);
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f130p = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i5 = this.f138x;
            if (intrinsicWidth > i5) {
                intrinsicHeight = (int) (intrinsicHeight * (i5 / intrinsicWidth));
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > i5) {
                intrinsicWidth = (int) (intrinsicWidth * (i5 / intrinsicHeight));
            } else {
                i5 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i5);
        }
        setCompoundDrawables(drawable, null, null, null);
        o();
    }

    public void setItemInvoker(n nVar) {
        this.f131q = nVar;
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i5, int i6, int i7, int i8) {
        this.f137w = i5;
        super.setPadding(i5, i6, i7, i8);
    }

    public void setPopupCallback(c cVar) {
        this.f133s = cVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.o = charSequence;
        o();
    }
}

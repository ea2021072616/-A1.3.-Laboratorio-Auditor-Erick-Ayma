package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.widget.z2;
import c.a;
import com.github.appintro.R;
import h.b0;
import h.q;
/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements b0, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: g  reason: collision with root package name */
    public q f141g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f142h;

    /* renamed from: i  reason: collision with root package name */
    public RadioButton f143i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f144j;

    /* renamed from: k  reason: collision with root package name */
    public CheckBox f145k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f146l;

    /* renamed from: m  reason: collision with root package name */
    public ImageView f147m;

    /* renamed from: n  reason: collision with root package name */
    public ImageView f148n;
    public LinearLayout o;

    /* renamed from: p  reason: collision with root package name */
    public final Drawable f149p;

    /* renamed from: q  reason: collision with root package name */
    public final int f150q;

    /* renamed from: r  reason: collision with root package name */
    public final Context f151r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f152s;

    /* renamed from: t  reason: collision with root package name */
    public final Drawable f153t;

    /* renamed from: u  reason: collision with root package name */
    public final boolean f154u;

    /* renamed from: v  reason: collision with root package name */
    public LayoutInflater f155v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f156w;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        z2 m5 = z2.m(getContext(), attributeSet, a.f1700r, R.attr.listMenuViewStyle);
        this.f149p = m5.e(5);
        this.f150q = m5.i(1, -1);
        this.f152s = m5.a(7, false);
        this.f151r = context;
        this.f153t = m5.e(8);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{16843049}, R.attr.dropDownListViewStyle, 0);
        this.f154u = obtainStyledAttributes.hasValue(0);
        m5.n();
        obtainStyledAttributes.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.f155v == null) {
            this.f155v = LayoutInflater.from(getContext());
        }
        return this.f155v;
    }

    private void setSubMenuArrowVisible(boolean z4) {
        ImageView imageView = this.f147m;
        if (imageView != null) {
            imageView.setVisibility(z4 ? 0 : 8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f148n;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f148n.getLayoutParams();
        rect.top = this.f148n.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0055, code lost:
        if (r0 == false) goto L55;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x011f  */
    @Override // h.b0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(h.q r11) {
        /*
            Method dump skipped, instructions count: 319
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.ListMenuItemView.c(h.q):void");
    }

    @Override // h.b0
    public q getItemData() {
        return this.f141g;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        setBackground(this.f149p);
        TextView textView = (TextView) findViewById(R.id.title);
        this.f144j = textView;
        int i5 = this.f150q;
        if (i5 != -1) {
            textView.setTextAppearance(this.f151r, i5);
        }
        this.f146l = (TextView) findViewById(R.id.shortcut);
        ImageView imageView = (ImageView) findViewById(R.id.submenuarrow);
        this.f147m = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f153t);
        }
        this.f148n = (ImageView) findViewById(R.id.group_divider);
        this.o = (LinearLayout) findViewById(R.id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i5, int i6) {
        if (this.f142h != null && this.f152s) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f142h.getLayoutParams();
            int i7 = layoutParams.height;
            if (i7 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i7;
            }
        }
        super.onMeasure(i5, i6);
    }

    public void setCheckable(boolean z4) {
        CompoundButton compoundButton;
        View view;
        if (!z4 && this.f143i == null && this.f145k == null) {
            return;
        }
        if ((this.f141g.D & 4) != 0) {
            if (this.f143i == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f143i = radioButton;
                LinearLayout linearLayout = this.o;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f143i;
            view = this.f145k;
        } else {
            if (this.f145k == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f145k = checkBox;
                LinearLayout linearLayout2 = this.o;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f145k;
            view = this.f143i;
        }
        if (z4) {
            compoundButton.setChecked(this.f141g.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox2 = this.f145k;
        if (checkBox2 != null) {
            checkBox2.setVisibility(8);
        }
        RadioButton radioButton2 = this.f143i;
        if (radioButton2 != null) {
            radioButton2.setVisibility(8);
        }
    }

    public void setChecked(boolean z4) {
        CompoundButton compoundButton;
        if ((this.f141g.D & 4) != 0) {
            if (this.f143i == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f143i = radioButton;
                LinearLayout linearLayout = this.o;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f143i;
        } else {
            if (this.f145k == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f145k = checkBox;
                LinearLayout linearLayout2 = this.o;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f145k;
        }
        compoundButton.setChecked(z4);
    }

    public void setForceShowIcon(boolean z4) {
        this.f156w = z4;
        this.f152s = z4;
    }

    public void setGroupDividerEnabled(boolean z4) {
        ImageView imageView = this.f148n;
        if (imageView != null) {
            imageView.setVisibility((this.f154u || !z4) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        this.f141g.f3059t.getClass();
        boolean z4 = this.f156w;
        if (z4 || this.f152s) {
            ImageView imageView = this.f142h;
            if (imageView == null && drawable == null && !this.f152s) {
                return;
            }
            if (imageView == null) {
                ImageView imageView2 = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
                this.f142h = imageView2;
                LinearLayout linearLayout = this.o;
                if (linearLayout != null) {
                    linearLayout.addView(imageView2, 0);
                } else {
                    addView(imageView2, 0);
                }
            }
            if (drawable == null && !this.f152s) {
                this.f142h.setVisibility(8);
                return;
            }
            ImageView imageView3 = this.f142h;
            if (!z4) {
                drawable = null;
            }
            imageView3.setImageDrawable(drawable);
            if (this.f142h.getVisibility() != 0) {
                this.f142h.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f144j.getVisibility() != 8) {
                this.f144j.setVisibility(8);
                return;
            }
            return;
        }
        this.f144j.setText(charSequence);
        if (this.f144j.getVisibility() != 0) {
            this.f144j.setVisibility(0);
        }
    }
}

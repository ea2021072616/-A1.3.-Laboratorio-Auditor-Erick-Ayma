package l3;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.l0;
import b4.j;
import com.github.appintro.R;
import e4.e;
import n0.b;
/* loaded from: classes.dex */
public final class a extends l0 {

    /* renamed from: m  reason: collision with root package name */
    public static final int[][] f3903m = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};

    /* renamed from: k  reason: collision with root package name */
    public ColorStateList f3904k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f3905l;

    public a(Context context, AttributeSet attributeSet) {
        super(p2.a.b0(context, attributeSet, R.attr.radioButtonStyle, 2131952705), attributeSet);
        Context context2 = getContext();
        TypedArray D = j.D(context2, attributeSet, w2.a.o, R.attr.radioButtonStyle, 2131952705, new int[0]);
        if (D.hasValue(0)) {
            b.c(this, p2.a.v(context2, D, 0));
        }
        this.f3905l = D.getBoolean(1, false);
        D.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f3904k == null) {
            int l5 = e.l(this, R.attr.colorControlActivated);
            int l6 = e.l(this, R.attr.colorOnSurface);
            int l7 = e.l(this, R.attr.colorSurface);
            this.f3904k = new ColorStateList(f3903m, new int[]{e.B(l7, 1.0f, l5), e.B(l7, 0.54f, l6), e.B(l7, 0.38f, l6), e.B(l7, 0.38f, l6)});
        }
        return this.f3904k;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f3905l && b.a(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z4) {
        this.f3905l = z4;
        if (z4) {
            b.c(this, getMaterialThemeColorsTintList());
        } else {
            b.c(this, null);
        }
    }
}

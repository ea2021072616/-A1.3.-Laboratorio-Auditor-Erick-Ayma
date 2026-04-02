package t3;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.i1;
import com.github.appintro.R;
import e4.e;
/* loaded from: classes.dex */
public final class a extends i1 {
    public a(Context context, AttributeSet attributeSet) {
        super(p2.a.b0(context, attributeSet, 16842884, 0), attributeSet, 16842884);
        Context context2 = getContext();
        if (e.O(context2, R.attr.textAppearanceLineHeightEnabled, true)) {
            Resources.Theme theme = context2.getTheme();
            int[] iArr = w2.a.f5402r;
            TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, iArr, 16842884, 0);
            int n5 = n(context2, obtainStyledAttributes, 1, 2);
            obtainStyledAttributes.recycle();
            if (n5 != -1) {
                return;
            }
            TypedArray obtainStyledAttributes2 = theme.obtainStyledAttributes(attributeSet, iArr, 16842884, 0);
            int resourceId = obtainStyledAttributes2.getResourceId(0, -1);
            obtainStyledAttributes2.recycle();
            if (resourceId != -1) {
                m(resourceId, theme);
            }
        }
    }

    public static int n(Context context, TypedArray typedArray, int... iArr) {
        int i5 = -1;
        for (int i6 = 0; i6 < iArr.length && i5 < 0; i6++) {
            int i7 = iArr[i6];
            TypedValue typedValue = new TypedValue();
            if (typedArray.getValue(i7, typedValue) && typedValue.type == 2) {
                TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
                int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, -1);
                obtainStyledAttributes.recycle();
                i5 = dimensionPixelSize;
            } else {
                i5 = typedArray.getDimensionPixelSize(i7, -1);
            }
        }
        return i5;
    }

    public final void m(int i5, Resources.Theme theme) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(i5, w2.a.f5401q);
        int n5 = n(getContext(), obtainStyledAttributes, 1, 2);
        obtainStyledAttributes.recycle();
        if (n5 >= 0) {
            setLineHeight(n5);
        }
    }

    @Override // androidx.appcompat.widget.i1, android.widget.TextView
    public final void setTextAppearance(Context context, int i5) {
        super.setTextAppearance(context, i5);
        if (e.O(context, R.attr.textAppearanceLineHeightEnabled, true)) {
            m(i5, context.getTheme());
        }
    }
}

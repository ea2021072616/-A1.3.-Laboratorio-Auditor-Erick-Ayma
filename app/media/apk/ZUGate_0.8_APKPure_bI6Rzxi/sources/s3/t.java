package s3;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import h0.z0;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class t extends ArrayAdapter {

    /* renamed from: a  reason: collision with root package name */
    public ColorStateList f4951a;

    /* renamed from: b  reason: collision with root package name */
    public ColorStateList f4952b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ u f4953c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(u uVar, Context context, int i5, String[] strArr) {
        super(context, i5, strArr);
        this.f4953c = uVar;
        a();
    }

    public final void a() {
        ColorStateList colorStateList;
        u uVar = this.f4953c;
        ColorStateList colorStateList2 = uVar.f4960r;
        ColorStateList colorStateList3 = null;
        if (colorStateList2 != null) {
            int[] iArr = {16842919};
            colorStateList = new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{colorStateList2.getColorForState(iArr, 0), 0});
        } else {
            colorStateList = null;
        }
        this.f4952b = colorStateList;
        if (uVar.f4959q != 0) {
            if (uVar.f4960r != null) {
                int[] iArr2 = {16843623, -16842919};
                int[] iArr3 = {16842913, -16842919};
                colorStateList3 = new ColorStateList(new int[][]{iArr3, iArr2, new int[0]}, new int[]{z.a.b(uVar.f4960r.getColorForState(iArr3, 0), uVar.f4959q), z.a.b(uVar.f4960r.getColorForState(iArr2, 0), uVar.f4959q), uVar.f4959q});
            }
        }
        this.f4951a = colorStateList3;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i5, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i5, view, viewGroup);
        if (view2 instanceof TextView) {
            TextView textView = (TextView) view2;
            u uVar = this.f4953c;
            RippleDrawable rippleDrawable = null;
            if (uVar.getText().toString().contentEquals(textView.getText())) {
                if (uVar.f4959q != 0) {
                    ColorDrawable colorDrawable = new ColorDrawable(uVar.f4959q);
                    if (this.f4952b != null) {
                        a0.a.h(colorDrawable, this.f4951a);
                        rippleDrawable = new RippleDrawable(this.f4952b, colorDrawable, null);
                    } else {
                        rippleDrawable = colorDrawable;
                    }
                }
            }
            WeakHashMap weakHashMap = z0.f3233a;
            textView.setBackground(rippleDrawable);
        }
        return view2;
    }
}

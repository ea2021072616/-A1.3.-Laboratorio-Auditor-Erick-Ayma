package s;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public int f4769a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f4770b = 0;

    /* renamed from: c  reason: collision with root package name */
    public float f4771c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    public float f4772d = Float.NaN;

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, q.f4799g);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i5 = 0; i5 < indexCount; i5++) {
            int index = obtainStyledAttributes.getIndex(i5);
            if (index == 1) {
                this.f4771c = obtainStyledAttributes.getFloat(index, this.f4771c);
            } else if (index == 0) {
                int i6 = obtainStyledAttributes.getInt(index, this.f4769a);
                this.f4769a = i6;
                this.f4769a = n.f4787d[i6];
            } else if (index == 4) {
                this.f4770b = obtainStyledAttributes.getInt(index, this.f4770b);
            } else if (index == 3) {
                this.f4772d = obtainStyledAttributes.getFloat(index, this.f4772d);
            }
        }
        obtainStyledAttributes.recycle();
    }
}

package s;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
/* loaded from: classes.dex */
public final class k {

    /* renamed from: j  reason: collision with root package name */
    public static final SparseIntArray f4759j;

    /* renamed from: a  reason: collision with root package name */
    public int f4760a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f4761b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f4762c = -1;

    /* renamed from: d  reason: collision with root package name */
    public float f4763d = Float.NaN;

    /* renamed from: e  reason: collision with root package name */
    public float f4764e = Float.NaN;

    /* renamed from: f  reason: collision with root package name */
    public float f4765f = Float.NaN;

    /* renamed from: g  reason: collision with root package name */
    public int f4766g = -1;

    /* renamed from: h  reason: collision with root package name */
    public String f4767h = null;

    /* renamed from: i  reason: collision with root package name */
    public int f4768i = -1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f4759j = sparseIntArray;
        sparseIntArray.append(3, 1);
        sparseIntArray.append(5, 2);
        sparseIntArray.append(9, 3);
        sparseIntArray.append(2, 4);
        sparseIntArray.append(1, 5);
        sparseIntArray.append(0, 6);
        sparseIntArray.append(4, 7);
        sparseIntArray.append(8, 8);
        sparseIntArray.append(7, 9);
        sparseIntArray.append(6, 10);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, q.f4798f);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i5 = 0; i5 < indexCount; i5++) {
            int index = obtainStyledAttributes.getIndex(i5);
            switch (f4759j.get(index)) {
                case 1:
                    this.f4764e = obtainStyledAttributes.getFloat(index, this.f4764e);
                    break;
                case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                    this.f4762c = obtainStyledAttributes.getInt(index, this.f4762c);
                    break;
                case 3:
                    if (obtainStyledAttributes.peekValue(index).type == 3) {
                        obtainStyledAttributes.getString(index);
                        break;
                    } else {
                        String str = p2.a.f4255j[obtainStyledAttributes.getInteger(index, 0)];
                        break;
                    }
                case 4:
                    obtainStyledAttributes.getInt(index, 0);
                    break;
                case 5:
                    this.f4760a = n.f(obtainStyledAttributes, index, this.f4760a);
                    break;
                case 6:
                    this.f4761b = obtainStyledAttributes.getInteger(index, this.f4761b);
                    break;
                case 7:
                    this.f4763d = obtainStyledAttributes.getFloat(index, this.f4763d);
                    break;
                case 8:
                    this.f4766g = obtainStyledAttributes.getInteger(index, this.f4766g);
                    break;
                case 9:
                    this.f4765f = obtainStyledAttributes.getFloat(index, this.f4765f);
                    break;
                case 10:
                    int i6 = obtainStyledAttributes.peekValue(index).type;
                    if (i6 == 1) {
                        this.f4768i = obtainStyledAttributes.getResourceId(index, -1);
                        break;
                    } else if (i6 == 3) {
                        String string = obtainStyledAttributes.getString(index);
                        this.f4767h = string;
                        if (string.indexOf("/") > 0) {
                            this.f4768i = obtainStyledAttributes.getResourceId(index, -1);
                            break;
                        } else {
                            break;
                        }
                    } else {
                        obtainStyledAttributes.getInteger(index, this.f4768i);
                        break;
                    }
            }
        }
        obtainStyledAttributes.recycle();
    }
}

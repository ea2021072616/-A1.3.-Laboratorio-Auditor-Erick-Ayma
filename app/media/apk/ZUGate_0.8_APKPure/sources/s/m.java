package s;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
/* loaded from: classes.dex */
public final class m {

    /* renamed from: n  reason: collision with root package name */
    public static final SparseIntArray f4773n;

    /* renamed from: a  reason: collision with root package name */
    public float f4774a = 0.0f;

    /* renamed from: b  reason: collision with root package name */
    public float f4775b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    public float f4776c = 0.0f;

    /* renamed from: d  reason: collision with root package name */
    public float f4777d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    public float f4778e = 1.0f;

    /* renamed from: f  reason: collision with root package name */
    public float f4779f = Float.NaN;

    /* renamed from: g  reason: collision with root package name */
    public float f4780g = Float.NaN;

    /* renamed from: h  reason: collision with root package name */
    public int f4781h = -1;

    /* renamed from: i  reason: collision with root package name */
    public float f4782i = 0.0f;

    /* renamed from: j  reason: collision with root package name */
    public float f4783j = 0.0f;

    /* renamed from: k  reason: collision with root package name */
    public float f4784k = 0.0f;

    /* renamed from: l  reason: collision with root package name */
    public boolean f4785l = false;

    /* renamed from: m  reason: collision with root package name */
    public float f4786m = 0.0f;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f4773n = sparseIntArray;
        sparseIntArray.append(6, 1);
        sparseIntArray.append(7, 2);
        sparseIntArray.append(8, 3);
        sparseIntArray.append(4, 4);
        sparseIntArray.append(5, 5);
        sparseIntArray.append(0, 6);
        sparseIntArray.append(1, 7);
        sparseIntArray.append(2, 8);
        sparseIntArray.append(3, 9);
        sparseIntArray.append(9, 10);
        sparseIntArray.append(10, 11);
        sparseIntArray.append(11, 12);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, q.f4801i);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i5 = 0; i5 < indexCount; i5++) {
            int index = obtainStyledAttributes.getIndex(i5);
            switch (f4773n.get(index)) {
                case 1:
                    this.f4774a = obtainStyledAttributes.getFloat(index, this.f4774a);
                    break;
                case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                    this.f4775b = obtainStyledAttributes.getFloat(index, this.f4775b);
                    break;
                case 3:
                    this.f4776c = obtainStyledAttributes.getFloat(index, this.f4776c);
                    break;
                case 4:
                    this.f4777d = obtainStyledAttributes.getFloat(index, this.f4777d);
                    break;
                case 5:
                    this.f4778e = obtainStyledAttributes.getFloat(index, this.f4778e);
                    break;
                case 6:
                    this.f4779f = obtainStyledAttributes.getDimension(index, this.f4779f);
                    break;
                case 7:
                    this.f4780g = obtainStyledAttributes.getDimension(index, this.f4780g);
                    break;
                case 8:
                    this.f4782i = obtainStyledAttributes.getDimension(index, this.f4782i);
                    break;
                case 9:
                    this.f4783j = obtainStyledAttributes.getDimension(index, this.f4783j);
                    break;
                case 10:
                    this.f4784k = obtainStyledAttributes.getDimension(index, this.f4784k);
                    break;
                case 11:
                    this.f4785l = true;
                    this.f4786m = obtainStyledAttributes.getDimension(index, this.f4786m);
                    break;
                case 12:
                    this.f4781h = n.f(obtainStyledAttributes, index, this.f4781h);
                    break;
            }
        }
        obtainStyledAttributes.recycle();
    }
}

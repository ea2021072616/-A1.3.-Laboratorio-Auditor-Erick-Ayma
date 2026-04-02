package s0;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
/* loaded from: classes.dex */
public final class h extends p3.e {

    /* renamed from: k  reason: collision with root package name */
    public final TextView f4818k;

    /* renamed from: l  reason: collision with root package name */
    public final f f4819l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f4820m;

    public h(TextView textView) {
        super(19);
        this.f4818k = textView;
        this.f4820m = true;
        this.f4819l = new f(textView);
    }

    @Override // p3.e
    public final InputFilter[] f(InputFilter[] inputFilterArr) {
        if (!this.f4820m) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i5 = 0; i5 < inputFilterArr.length; i5++) {
                InputFilter inputFilter = inputFilterArr[i5];
                if (inputFilter instanceof f) {
                    sparseArray.put(i5, inputFilter);
                }
            }
            if (sparseArray.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArray.size()];
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                if (sparseArray.indexOfKey(i7) < 0) {
                    inputFilterArr2[i6] = inputFilterArr[i7];
                    i6++;
                }
            }
            return inputFilterArr2;
        }
        int length2 = inputFilterArr.length;
        int i8 = 0;
        while (true) {
            f fVar = this.f4819l;
            if (i8 >= length2) {
                InputFilter[] inputFilterArr3 = new InputFilter[inputFilterArr.length + 1];
                System.arraycopy(inputFilterArr, 0, inputFilterArr3, 0, length2);
                inputFilterArr3[length2] = fVar;
                return inputFilterArr3;
            } else if (inputFilterArr[i8] == fVar) {
                return inputFilterArr;
            } else {
                i8++;
            }
        }
    }

    @Override // p3.e
    public final boolean p() {
        return this.f4820m;
    }

    @Override // p3.e
    public final void t(boolean z4) {
        if (z4) {
            TextView textView = this.f4818k;
            textView.setTransformationMethod(z(textView.getTransformationMethod()));
        }
    }

    @Override // p3.e
    public final void w(boolean z4) {
        this.f4820m = z4;
        TextView textView = this.f4818k;
        textView.setTransformationMethod(z(textView.getTransformationMethod()));
        textView.setFilters(f(textView.getFilters()));
    }

    @Override // p3.e
    public final TransformationMethod z(TransformationMethod transformationMethod) {
        return this.f4820m ? ((transformationMethod instanceof k) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new k(transformationMethod) : transformationMethod instanceof k ? ((k) transformationMethod).f4826a : transformationMethod;
    }
}

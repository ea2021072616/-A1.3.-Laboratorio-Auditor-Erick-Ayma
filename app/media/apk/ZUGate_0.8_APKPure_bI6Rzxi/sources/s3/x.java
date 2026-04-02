package s3;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
import h0.z0;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class x implements TextWatcher {

    /* renamed from: g  reason: collision with root package name */
    public int f4973g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ EditText f4974h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f4975i;

    public x(TextInputLayout textInputLayout, EditText editText) {
        this.f4975i = textInputLayout;
        this.f4974h = editText;
        this.f4973g = editText.getLineCount();
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        TextInputLayout textInputLayout = this.f4975i;
        textInputLayout.u(!textInputLayout.G0, false);
        if (textInputLayout.f2226q) {
            textInputLayout.n(editable);
        }
        if (textInputLayout.f2242y) {
            textInputLayout.v(editable);
        }
        EditText editText = this.f4974h;
        int lineCount = editText.getLineCount();
        int i5 = this.f4973g;
        if (lineCount != i5) {
            if (lineCount < i5) {
                WeakHashMap weakHashMap = z0.f3233a;
                int minimumHeight = editText.getMinimumHeight();
                int i6 = textInputLayout.f2245z0;
                if (minimumHeight != i6) {
                    editText.setMinimumHeight(i6);
                }
            }
            this.f4973g = lineCount;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
    }
}

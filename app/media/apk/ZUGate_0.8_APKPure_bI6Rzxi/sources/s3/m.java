package s3;

import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ n f4895a;

    public m(n nVar) {
        this.f4895a = nVar;
    }

    public final void a(TextInputLayout textInputLayout) {
        n nVar = this.f4895a;
        if (nVar.f4913y == textInputLayout.getEditText()) {
            return;
        }
        EditText editText = nVar.f4913y;
        l lVar = nVar.B;
        if (editText != null) {
            editText.removeTextChangedListener(lVar);
            if (nVar.f4913y.getOnFocusChangeListener() == nVar.b().e()) {
                nVar.f4913y.setOnFocusChangeListener(null);
            }
        }
        EditText editText2 = textInputLayout.getEditText();
        nVar.f4913y = editText2;
        if (editText2 != null) {
            editText2.addTextChangedListener(lVar);
        }
        nVar.b().m(nVar.f4913y);
        nVar.j(nVar.b());
    }
}

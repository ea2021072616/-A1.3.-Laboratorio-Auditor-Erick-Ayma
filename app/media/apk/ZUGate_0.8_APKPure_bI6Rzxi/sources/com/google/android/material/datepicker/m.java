package com.google.android.material.datepicker;

import android.text.Editable;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
public final /* synthetic */ class m implements View.OnClickListener {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f2135g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Object f2136h;

    public /* synthetic */ m(int i5, Object obj) {
        this.f2135g = i5;
        this.f2136h = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i5 = this.f2135g;
        Object obj = this.f2136h;
        switch (i5) {
            case 0:
                int i6 = n.U;
                ((n) obj).k();
                throw null;
            case 1:
                s3.d dVar = (s3.d) obj;
                EditText editText = dVar.f4872i;
                if (editText == null) {
                    return;
                }
                Editable text = editText.getText();
                if (text != null) {
                    text.clear();
                }
                dVar.q();
                return;
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                ((s3.k) obj).u();
                return;
            default:
                s3.v vVar = (s3.v) obj;
                EditText editText2 = vVar.f4962f;
                if (editText2 == null) {
                    return;
                }
                int selectionEnd = editText2.getSelectionEnd();
                EditText editText3 = vVar.f4962f;
                if (editText3 != null && (editText3.getTransformationMethod() instanceof PasswordTransformationMethod)) {
                    vVar.f4962f.setTransformationMethod(null);
                } else {
                    vVar.f4962f.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                if (selectionEnd >= 0) {
                    vVar.f4962f.setSelection(selectionEnd);
                }
                vVar.q();
                return;
        }
    }
}

package y0;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.preference.EditTextPreference;
/* loaded from: classes.dex */
public class d extends q {
    public EditText E;
    public CharSequence F;
    public final androidx.activity.j G = new androidx.activity.j(10, this);
    public long H = -1;

    @Override // y0.q
    public final void l(View view) {
        super.l(view);
        EditText editText = (EditText) view.findViewById(16908291);
        this.E = editText;
        if (editText == null) {
            throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
        }
        editText.requestFocus();
        this.E.setText(this.F);
        EditText editText2 = this.E;
        editText2.setSelection(editText2.getText().length());
        ((EditTextPreference) k()).getClass();
    }

    @Override // y0.q
    public final void m(boolean z4) {
        if (z4) {
            String obj = this.E.getText().toString();
            EditTextPreference editTextPreference = (EditTextPreference) k();
            if (editTextPreference.a(obj)) {
                editTextPreference.A(obj);
            }
        }
    }

    @Override // y0.q
    public final void o() {
        this.H = SystemClock.currentThreadTimeMillis();
        p();
    }

    @Override // y0.q, androidx.fragment.app.r, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.F = ((EditTextPreference) k()).U;
        } else {
            this.F = bundle.getCharSequence("EditTextPreferenceDialogFragment.text");
        }
    }

    @Override // y0.q, androidx.fragment.app.r, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.F);
    }

    public final void p() {
        long j5 = this.H;
        if (j5 != -1 && j5 + 1000 > SystemClock.currentThreadTimeMillis()) {
            EditText editText = this.E;
            if (editText == null || !editText.isFocused()) {
                this.H = -1L;
            } else if (((InputMethodManager) this.E.getContext().getSystemService("input_method")).showSoftInput(this.E, 0)) {
                this.H = -1L;
            } else {
                EditText editText2 = this.E;
                androidx.activity.j jVar = this.G;
                editText2.removeCallbacks(jVar);
                this.E.postDelayed(jVar, 50L);
            }
        }
    }
}

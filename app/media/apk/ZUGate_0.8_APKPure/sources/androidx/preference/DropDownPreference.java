package androidx.preference;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.appcompat.widget.i2;
import com.github.appintro.R;
import y0.d0;
/* loaded from: classes.dex */
public class DropDownPreference extends ListPreference {
    public final ArrayAdapter Z;

    /* renamed from: a0  reason: collision with root package name */
    public Spinner f1175a0;

    /* renamed from: b0  reason: collision with root package name */
    public final i2 f1176b0;

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.dropdownPreferenceStyle);
        this.f1176b0 = new i2(1, this);
        ArrayAdapter arrayAdapter = new ArrayAdapter(context, 17367049);
        this.Z = arrayAdapter;
        arrayAdapter.clear();
        CharSequence[] charSequenceArr = this.U;
        if (charSequenceArr != null) {
            for (CharSequence charSequence : charSequenceArr) {
                arrayAdapter.add(charSequence.toString());
            }
        }
    }

    @Override // androidx.preference.Preference
    public final void i() {
        super.i();
        ArrayAdapter arrayAdapter = this.Z;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.preference.Preference
    public final void m(d0 d0Var) {
        CharSequence[] charSequenceArr;
        Spinner spinner = (Spinner) d0Var.f1376a.findViewById(R.id.spinner);
        this.f1175a0 = spinner;
        spinner.setAdapter((SpinnerAdapter) this.Z);
        this.f1175a0.setOnItemSelectedListener(this.f1176b0);
        Spinner spinner2 = this.f1175a0;
        String str = this.W;
        int i5 = -1;
        if (str != null && (charSequenceArr = this.V) != null) {
            int length = charSequenceArr.length - 1;
            while (true) {
                if (length < 0) {
                    break;
                } else if (TextUtils.equals(charSequenceArr[length].toString(), str)) {
                    i5 = length;
                    break;
                } else {
                    length--;
                }
            }
        }
        spinner2.setSelection(i5);
        super.m(d0Var);
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    public final void n() {
        this.f1175a0.performClick();
    }
}

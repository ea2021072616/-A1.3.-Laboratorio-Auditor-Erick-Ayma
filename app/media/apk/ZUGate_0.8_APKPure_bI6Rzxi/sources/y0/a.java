package y0;

import android.widget.CompoundButton;
import androidx.preference.CheckBoxPreference;
import androidx.preference.SwitchPreference;
import androidx.preference.SwitchPreferenceCompat;
import androidx.preference.TwoStatePreference;
/* loaded from: classes.dex */
public final class a implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5582a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TwoStatePreference f5583b;

    public /* synthetic */ a(TwoStatePreference twoStatePreference, int i5) {
        this.f5582a = i5;
        this.f5583b = twoStatePreference;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        int i5 = this.f5582a;
        TwoStatePreference twoStatePreference = this.f5583b;
        switch (i5) {
            case 0:
                CheckBoxPreference checkBoxPreference = (CheckBoxPreference) twoStatePreference;
                if (checkBoxPreference.a(Boolean.valueOf(z4))) {
                    checkBoxPreference.A(z4);
                    return;
                } else {
                    compoundButton.setChecked(!z4);
                    return;
                }
            case 1:
                SwitchPreference switchPreference = (SwitchPreference) twoStatePreference;
                if (switchPreference.a(Boolean.valueOf(z4))) {
                    switchPreference.A(z4);
                    return;
                } else {
                    compoundButton.setChecked(!z4);
                    return;
                }
            default:
                SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) twoStatePreference;
                if (switchPreferenceCompat.a(Boolean.valueOf(z4))) {
                    switchPreferenceCompat.A(z4);
                    return;
                } else {
                    compoundButton.setChecked(!z4);
                    return;
                }
        }
    }
}

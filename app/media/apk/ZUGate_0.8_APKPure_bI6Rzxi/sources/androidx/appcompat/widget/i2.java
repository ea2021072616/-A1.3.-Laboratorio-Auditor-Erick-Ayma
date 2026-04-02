package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
import androidx.preference.DropDownPreference;
/* loaded from: classes.dex */
public final class i2 implements AdapterView.OnItemSelectedListener {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f389g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Object f390h;

    public /* synthetic */ i2(int i5, Object obj) {
        this.f389g = i5;
        this.f390h = obj;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i5, long j5) {
        b2 b2Var;
        int i6 = this.f389g;
        Object obj = this.f390h;
        switch (i6) {
            case 0:
                if (i5 == -1 || (b2Var = ((o2) obj).f452i) == null) {
                    return;
                }
                b2Var.setListSelectionHidden(false);
                return;
            default:
                if (i5 >= 0) {
                    DropDownPreference dropDownPreference = (DropDownPreference) obj;
                    String charSequence = dropDownPreference.V[i5].toString();
                    if (charSequence.equals(dropDownPreference.W) || !dropDownPreference.a(charSequence)) {
                        return;
                    }
                    dropDownPreference.C(charSequence);
                    return;
                }
                return;
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
    }
}

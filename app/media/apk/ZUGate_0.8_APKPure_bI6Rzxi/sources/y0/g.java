package y0;

import android.os.Bundle;
import androidx.preference.ListPreference;
/* loaded from: classes.dex */
public class g extends q {
    public int E;
    public CharSequence[] F;
    public CharSequence[] G;

    @Override // y0.q
    public final void m(boolean z4) {
        int i5;
        if (!z4 || (i5 = this.E) < 0) {
            return;
        }
        String charSequence = this.G[i5].toString();
        ListPreference listPreference = (ListPreference) k();
        if (listPreference.a(charSequence)) {
            listPreference.C(charSequence);
        }
    }

    @Override // y0.q
    public final void n(d.m mVar) {
        CharSequence[] charSequenceArr = this.F;
        int i5 = this.E;
        androidx.biometric.w wVar = new androidx.biometric.w(this, 2);
        Object obj = mVar.f2398h;
        d.i iVar = (d.i) obj;
        iVar.f2353p = charSequenceArr;
        iVar.f2355r = wVar;
        iVar.f2361x = i5;
        iVar.f2360w = true;
        d.i iVar2 = (d.i) obj;
        iVar2.f2345g = null;
        iVar2.f2346h = null;
    }

    @Override // y0.q, androidx.fragment.app.r, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        CharSequence[] charSequenceArr;
        super.onCreate(bundle);
        if (bundle != null) {
            this.E = bundle.getInt("ListPreferenceDialogFragment.index", 0);
            this.F = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entries");
            this.G = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entryValues");
            return;
        }
        ListPreference listPreference = (ListPreference) k();
        if (listPreference.U == null || (charSequenceArr = listPreference.V) == null) {
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
        }
        this.E = listPreference.A(listPreference.W);
        this.F = listPreference.U;
        this.G = charSequenceArr;
    }

    @Override // y0.q, androidx.fragment.app.r, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("ListPreferenceDialogFragment.index", this.E);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entries", this.F);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entryValues", this.G);
    }
}

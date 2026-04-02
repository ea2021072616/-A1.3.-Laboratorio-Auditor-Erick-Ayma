package y0;

import android.os.Bundle;
import androidx.preference.MultiSelectListPreference;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes.dex */
public class j extends q {
    public final HashSet E = new HashSet();
    public boolean F;
    public CharSequence[] G;
    public CharSequence[] H;

    @Override // y0.q
    public final void m(boolean z4) {
        if (z4 && this.F) {
            MultiSelectListPreference multiSelectListPreference = (MultiSelectListPreference) k();
            HashSet hashSet = this.E;
            if (multiSelectListPreference.a(hashSet)) {
                multiSelectListPreference.C(hashSet);
            }
        }
        this.F = false;
    }

    @Override // y0.q
    public final void n(d.m mVar) {
        int length = this.H.length;
        boolean[] zArr = new boolean[length];
        for (int i5 = 0; i5 < length; i5++) {
            zArr[i5] = this.E.contains(this.H[i5].toString());
        }
        CharSequence[] charSequenceArr = this.G;
        i iVar = new i(this);
        d.i iVar2 = (d.i) mVar.f2398h;
        iVar2.f2353p = charSequenceArr;
        iVar2.f2362y = iVar;
        iVar2.f2358u = zArr;
        iVar2.f2359v = true;
    }

    @Override // y0.q, androidx.fragment.app.r, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        HashSet hashSet = this.E;
        if (bundle != null) {
            hashSet.clear();
            hashSet.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values"));
            this.F = bundle.getBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", false);
            this.G = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
            this.H = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
            return;
        }
        MultiSelectListPreference multiSelectListPreference = (MultiSelectListPreference) k();
        if (multiSelectListPreference.A() == null || multiSelectListPreference.B() == null) {
            throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
        }
        hashSet.clear();
        hashSet.addAll(multiSelectListPreference.W);
        this.F = false;
        this.G = multiSelectListPreference.A();
        this.H = multiSelectListPreference.B();
    }

    @Override // y0.q, androidx.fragment.app.r, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values", new ArrayList<>(this.E));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", this.F);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries", this.G);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues", this.H);
    }
}

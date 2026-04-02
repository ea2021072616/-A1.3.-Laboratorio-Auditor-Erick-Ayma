package ru.zdevs.zugate.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.preference.MultiSelectListPreference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import ru.zdevs.zugate.jni.MbedTLS;
/* loaded from: classes.dex */
public class HWListPreference extends MultiSelectListPreference {
    public static final CharSequence[] Y = {"AES", "AES-XTS", "SHA1", "SHA256", "SHA512", "CRC32", "CRC32C", "XTS / CBC"};
    public static final int[] Z = {1, 2, 4, 8, 16, 32, 64, 128};
    public final CharSequence[] X;

    public HWListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int a5 = MbedTLS.a();
        ArrayList arrayList = new ArrayList(8);
        for (int i5 = 0; i5 < 8; i5++) {
            if ((Z[i5] & a5) != 0) {
                arrayList.add(Y[i5]);
            }
        }
        this.X = (CharSequence[]) arrayList.toArray(new CharSequence[0]);
    }

    public static int D(Set set) {
        int i5 = 0;
        for (int i6 = 0; i6 < 8; i6++) {
            if (set.contains(Y[i6].toString())) {
                i5 |= Z[i6];
            }
        }
        return i5;
    }

    public static HashSet E(int i5) {
        HashSet hashSet = new HashSet();
        for (int i6 = 0; i6 < 8; i6++) {
            if ((Z[i6] & i5) != 0) {
                hashSet.add(Y[i6].toString());
            }
        }
        return hashSet;
    }

    @Override // androidx.preference.MultiSelectListPreference
    public final CharSequence[] A() {
        return this.X;
    }

    @Override // androidx.preference.MultiSelectListPreference
    public final CharSequence[] B() {
        return this.X;
    }

    @Override // androidx.preference.MultiSelectListPreference
    public final void C(Set set) {
        HashSet hashSet = this.W;
        hashSet.clear();
        hashSet.addAll(set);
        u(D(set));
        i();
    }

    @Override // androidx.preference.MultiSelectListPreference, androidx.preference.Preference
    public final Object p(TypedArray typedArray, int i5) {
        return E(typedArray.getInt(i5, -1));
    }

    @Override // androidx.preference.MultiSelectListPreference, androidx.preference.Preference
    public final void s(Object obj) {
        C(E(e(obj == null ? -1 : D((Set) obj))));
    }
}

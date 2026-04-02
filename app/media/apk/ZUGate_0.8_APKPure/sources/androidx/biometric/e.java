package androidx.biometric;

import java.util.Arrays;
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final int f611a;

    /* renamed from: b  reason: collision with root package name */
    public final CharSequence f612b;

    public e(int i5, CharSequence charSequence) {
        this.f611a = i5;
        this.f612b = charSequence;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.f611a == eVar.f611a) {
                CharSequence charSequence = this.f612b;
                String charSequence2 = charSequence != null ? charSequence.toString() : null;
                CharSequence charSequence3 = eVar.f612b;
                String charSequence4 = charSequence3 != null ? charSequence3.toString() : null;
                return (charSequence2 == null && charSequence4 == null) || (charSequence2 != null && charSequence2.equals(charSequence4));
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        Integer valueOf = Integer.valueOf(this.f611a);
        CharSequence charSequence = this.f612b;
        return Arrays.hashCode(new Object[]{valueOf, charSequence != null ? charSequence.toString() : null});
    }
}

package y0;

import android.text.TextUtils;
import androidx.preference.Preference;
/* loaded from: classes.dex */
public final class u {

    /* renamed from: a  reason: collision with root package name */
    public final int f5645a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5646b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5647c;

    public u(Preference preference) {
        this.f5647c = preference.getClass().getName();
        this.f5645a = preference.F;
        this.f5646b = preference.G;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof u) {
            u uVar = (u) obj;
            return this.f5645a == uVar.f5645a && this.f5646b == uVar.f5646b && TextUtils.equals(this.f5647c, uVar.f5647c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f5647c.hashCode() + ((((527 + this.f5645a) * 31) + this.f5646b) * 31);
    }
}

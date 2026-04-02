package l2;

import java.util.Arrays;
/* loaded from: classes.dex */
public final class l implements j2.a {

    /* renamed from: b  reason: collision with root package name */
    public static final l f3868b = new l(null);

    /* renamed from: a  reason: collision with root package name */
    public final String f3869a;

    public /* synthetic */ l(String str) {
        this.f3869a = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l) {
            return b4.j.p(this.f3869a, ((l) obj).f3869a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3869a});
    }
}

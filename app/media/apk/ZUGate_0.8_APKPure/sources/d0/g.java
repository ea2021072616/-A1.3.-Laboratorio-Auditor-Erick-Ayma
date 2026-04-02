package d0;

import java.util.Locale;
/* loaded from: classes.dex */
public final class g {

    /* renamed from: b  reason: collision with root package name */
    public static final g f2503b = new g(new i(f.a(new Locale[0])));

    /* renamed from: a  reason: collision with root package name */
    public final h f2504a;

    public g(i iVar) {
        this.f2504a = iVar;
    }

    public static g a(String str) {
        if (str == null || str.isEmpty()) {
            return f2503b;
        }
        String[] split = str.split(",", -1);
        int length = split.length;
        Locale[] localeArr = new Locale[length];
        for (int i5 = 0; i5 < length; i5++) {
            localeArr[i5] = e.a(split[i5]);
        }
        return new g(new i(f.a(localeArr)));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof g) {
            if (this.f2504a.equals(((g) obj).f2504a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f2504a.hashCode();
    }

    public final String toString() {
        return this.f2504a.toString();
    }
}

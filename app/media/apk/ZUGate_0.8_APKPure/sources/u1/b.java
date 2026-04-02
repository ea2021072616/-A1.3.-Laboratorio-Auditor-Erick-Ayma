package u1;

import androidx.appcompat.widget.b0;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f5131a;

    public b(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        this.f5131a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            return this.f5131a.equals(((b) obj).f5131a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f5131a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return b0.i(new StringBuilder("Encoding{name=\""), this.f5131a, "\"}");
    }
}

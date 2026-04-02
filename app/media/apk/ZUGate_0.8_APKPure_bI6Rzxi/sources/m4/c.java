package m4;
/* loaded from: classes.dex */
public final class c extends a {
    static {
        new c(1, 0);
    }

    public c(int i5, int i6) {
        super(i5, i6, 1);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (this.f3986b == cVar.f3986b) {
                    if (this.f3987c == cVar.f3987c) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f3986b * 31) + this.f3987c;
    }

    public final boolean isEmpty() {
        return this.f3986b > this.f3987c;
    }

    public final String toString() {
        return this.f3986b + ".." + this.f3987c;
    }
}

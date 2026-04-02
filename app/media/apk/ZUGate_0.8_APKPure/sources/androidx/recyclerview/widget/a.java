package androidx.recyclerview.widget;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public int f1270a;

    /* renamed from: b  reason: collision with root package name */
    public int f1271b;

    /* renamed from: c  reason: collision with root package name */
    public Object f1272c;

    /* renamed from: d  reason: collision with root package name */
    public int f1273d;

    public a(Object obj, int i5, int i6, int i7) {
        this.f1270a = i5;
        this.f1271b = i6;
        this.f1273d = i7;
        this.f1272c = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            int i5 = this.f1270a;
            if (i5 != aVar.f1270a) {
                return false;
            }
            if (i5 == 8 && Math.abs(this.f1273d - this.f1271b) == 1 && this.f1273d == aVar.f1271b && this.f1271b == aVar.f1273d) {
                return true;
            }
            if (this.f1273d == aVar.f1273d && this.f1271b == aVar.f1271b) {
                Object obj2 = this.f1272c;
                if (obj2 != null) {
                    if (!obj2.equals(aVar.f1272c)) {
                        return false;
                    }
                } else if (aVar.f1272c != null) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return (((this.f1270a * 31) + this.f1271b) * 31) + this.f1273d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[");
        int i5 = this.f1270a;
        sb.append(i5 != 1 ? i5 != 2 ? i5 != 4 ? i5 != 8 ? "??" : "mv" : "up" : "rm" : "add");
        sb.append(",s:");
        sb.append(this.f1271b);
        sb.append("c:");
        sb.append(this.f1273d);
        sb.append(",p:");
        sb.append(this.f1272c);
        sb.append("]");
        return sb.toString();
    }
}

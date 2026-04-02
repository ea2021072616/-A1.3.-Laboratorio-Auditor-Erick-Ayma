package a4;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class a implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public final Object f28b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f29c;

    public a(Object obj, Object obj2) {
        this.f28b = obj;
        this.f29c = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return e4.e.a(this.f28b, aVar.f28b) && e4.e.a(this.f29c, aVar.f29c);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f28b;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f29c;
        return hashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.f28b + ", " + this.f29c + ')';
    }
}

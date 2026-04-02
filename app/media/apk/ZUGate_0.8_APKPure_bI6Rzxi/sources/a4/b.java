package a4;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class b implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public final Throwable f30b;

    public b(Throwable th) {
        e4.e.f(th, "exception");
        this.f30b = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            if (e4.e.a(this.f30b, ((b) obj).f30b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f30b.hashCode();
    }

    public final String toString() {
        return "Failure(" + this.f30b + ')';
    }
}

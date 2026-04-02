package j4;
/* loaded from: classes.dex */
public final class h implements b {

    /* renamed from: a  reason: collision with root package name */
    public final Class f3522a;

    public h(Class cls) {
        e4.e.f(cls, "jClass");
        this.f3522a = cls;
    }

    @Override // j4.b
    public final Class a() {
        return this.f3522a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            if (e4.e.a(this.f3522a, ((h) obj).f3522a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f3522a.hashCode();
    }

    public final String toString() {
        return this.f3522a.toString() + " (Kotlin reflection is not available)";
    }
}

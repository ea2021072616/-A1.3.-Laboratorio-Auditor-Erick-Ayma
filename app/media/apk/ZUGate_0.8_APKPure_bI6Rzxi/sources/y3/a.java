package y3;
/* loaded from: classes.dex */
public final class a implements e {

    /* renamed from: a  reason: collision with root package name */
    public final int f5691a;

    /* renamed from: b  reason: collision with root package name */
    public final d f5692b;

    public a(int i5, d dVar) {
        this.f5691a = i5;
        this.f5692b = dVar;
    }

    @Override // java.lang.annotation.Annotation
    public final Class annotationType() {
        return e.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.f5691a == ((a) eVar).f5691a && this.f5692b.equals(((a) eVar).f5692b);
        }
        return false;
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return (14552422 ^ this.f5691a) + (this.f5692b.hashCode() ^ 2041407134);
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.f5691a + "intEncoding=" + this.f5692b + ')';
    }
}

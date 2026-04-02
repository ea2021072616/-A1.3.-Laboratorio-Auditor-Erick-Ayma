package h1;
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public String f3297a;

    /* renamed from: b  reason: collision with root package name */
    public String f3298b;

    public /* synthetic */ l(int i5) {
    }

    public final m a() {
        if ("first_party".equals(this.f3298b)) {
            throw new IllegalArgumentException("Serialized doc id must be provided for first party products.");
        }
        if (this.f3297a != null) {
            if (this.f3298b != null) {
                return new m(this);
            }
            throw new IllegalArgumentException("Product type must be provided.");
        }
        throw new IllegalArgumentException("Product id must be provided.");
    }
}

package z1;
/* loaded from: classes.dex */
public final class a implements z3.a {

    /* renamed from: i  reason: collision with root package name */
    public static final Object f5805i = new Object();

    /* renamed from: g  reason: collision with root package name */
    public volatile z3.a f5806g;

    /* renamed from: h  reason: collision with root package name */
    public volatile Object f5807h = f5805i;

    public a(b bVar) {
        this.f5806g = bVar;
    }

    public static z3.a a(b bVar) {
        return bVar instanceof a ? bVar : new a(bVar);
    }

    @Override // z3.a
    public final Object get() {
        Object obj = this.f5807h;
        Object obj2 = f5805i;
        if (obj == obj2) {
            synchronized (this) {
                obj = this.f5807h;
                if (obj == obj2) {
                    obj = this.f5806g.get();
                    Object obj3 = this.f5807h;
                    if ((obj3 != obj2) && obj3 != obj) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + obj + ". This is likely due to a circular dependency.");
                    }
                    this.f5807h = obj;
                    this.f5806g = null;
                }
            }
        }
        return obj;
    }
}

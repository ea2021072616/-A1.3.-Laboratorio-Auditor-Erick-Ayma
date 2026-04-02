package e4;
/* loaded from: classes.dex */
public final class b implements c4.b {

    /* renamed from: b  reason: collision with root package name */
    public static final b f2703b = new b();

    @Override // c4.b
    public final c4.f a() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // c4.b
    public final void c(Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public final String toString() {
        return "This continuation is already complete";
    }
}

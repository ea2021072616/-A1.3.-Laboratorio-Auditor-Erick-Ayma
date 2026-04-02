package j2;
/* loaded from: classes.dex */
public final class i extends UnsupportedOperationException {

    /* renamed from: b  reason: collision with root package name */
    public final i2.c f3450b;

    public i(i2.c cVar) {
        this.f3450b = cVar;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return "Missing ".concat(String.valueOf(this.f3450b));
    }
}

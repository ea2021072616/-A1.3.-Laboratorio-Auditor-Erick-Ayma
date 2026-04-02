package b.a.a.a.a.c.a;
/* compiled from: RetryState.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final int f159a;

    /* renamed from: b  reason: collision with root package name */
    private final a f160b;

    /* renamed from: c  reason: collision with root package name */
    private final d f161c;

    public e(a aVar, d dVar) {
        this(0, aVar, dVar);
    }

    public e(int i, a aVar, d dVar) {
        this.f159a = i;
        this.f160b = aVar;
        this.f161c = dVar;
    }

    public long a() {
        return this.f160b.getDelayMillis(this.f159a);
    }

    public e b() {
        return new e(this.f159a + 1, this.f160b, this.f161c);
    }

    public e c() {
        return new e(this.f160b, this.f161c);
    }
}

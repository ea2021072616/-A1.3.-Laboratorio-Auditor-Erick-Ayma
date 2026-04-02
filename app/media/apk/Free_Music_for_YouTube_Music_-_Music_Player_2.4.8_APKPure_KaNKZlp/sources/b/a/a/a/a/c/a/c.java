package b.a.a.a.a.c.a;
/* compiled from: ExponentialBackoff.java */
/* loaded from: classes.dex */
public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    private final long f151a;

    /* renamed from: b  reason: collision with root package name */
    private final int f152b;

    public c(long j, int i) {
        this.f151a = j;
        this.f152b = i;
    }

    @Override // b.a.a.a.a.c.a.a
    public long getDelayMillis(int i) {
        return (long) (this.f151a * Math.pow(this.f152b, i));
    }
}

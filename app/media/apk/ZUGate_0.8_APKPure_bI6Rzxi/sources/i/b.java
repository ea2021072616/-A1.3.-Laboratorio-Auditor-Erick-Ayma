package i;
/* loaded from: classes.dex */
public final class b extends p2.a {

    /* renamed from: v  reason: collision with root package name */
    public static volatile b f3351v;

    /* renamed from: u  reason: collision with root package name */
    public final e f3352u = new e();

    public static b c0() {
        if (f3351v != null) {
            return f3351v;
        }
        synchronized (b.class) {
            if (f3351v == null) {
                f3351v = new b();
            }
        }
        return f3351v;
    }

    public final boolean d0() {
        return this.f3352u.d0();
    }

    public final void e0(Runnable runnable) {
        this.f3352u.e0(runnable);
    }
}

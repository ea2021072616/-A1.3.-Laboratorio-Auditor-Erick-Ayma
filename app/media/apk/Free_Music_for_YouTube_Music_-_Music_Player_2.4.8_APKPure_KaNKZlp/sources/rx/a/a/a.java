package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: RxAndroidPlugins.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final a f5219a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicReference<b> f5220b = new AtomicReference<>();

    public static a a() {
        return f5219a;
    }

    a() {
    }

    public b b() {
        if (this.f5220b.get() == null) {
            this.f5220b.compareAndSet(null, b.a());
        }
        return this.f5220b.get();
    }
}

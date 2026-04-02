package e0;

import java.util.concurrent.ThreadFactory;
/* loaded from: classes.dex */
public final class i implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final String f2583a = "fonts-androidx";

    /* renamed from: b  reason: collision with root package name */
    public final int f2584b = 10;

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new h(runnable, this.f2583a, this.f2584b);
    }
}

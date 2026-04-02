package i;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public final class e extends p2.a {

    /* renamed from: u  reason: collision with root package name */
    public final Object f3356u = new Object();

    /* renamed from: v  reason: collision with root package name */
    public volatile Handler f3357v;

    public e() {
        Executors.newFixedThreadPool(4, new c(this));
    }

    public static Handler c0(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return d.a(looper);
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            return new Handler(looper);
        } catch (InvocationTargetException unused2) {
            return new Handler(looper);
        }
    }

    public final boolean d0() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public final void e0(Runnable runnable) {
        if (this.f3357v == null) {
            synchronized (this.f3356u) {
                if (this.f3357v == null) {
                    this.f3357v = c0(Looper.getMainLooper());
                }
            }
        }
        this.f3357v.post(runnable);
    }
}

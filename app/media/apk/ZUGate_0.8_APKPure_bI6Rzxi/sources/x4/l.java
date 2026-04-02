package x4;

import android.content.Context;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class l implements Callable {

    /* renamed from: e  reason: collision with root package name */
    public static final ThreadPoolExecutor f5531e = new ThreadPoolExecutor(0, 3, 3, TimeUnit.SECONDS, new SynchronousQueue());

    /* renamed from: a  reason: collision with root package name */
    public c f5532a;

    /* renamed from: b  reason: collision with root package name */
    public k f5533b;

    /* renamed from: c  reason: collision with root package name */
    public final List f5534c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicBoolean f5535d = new AtomicBoolean();

    public l(List list) {
        this.f5534c = list;
    }

    public abstract a a();

    public final void b(Context context, c cVar) {
        try {
            this.f5532a = cVar;
            this.f5533b = new k(this, this);
            f(context);
            f5531e.execute(this.f5533b);
            List list = this.f5534c;
            if (list != null) {
                list.add(this);
            }
        } catch (RejectedExecutionException unused) {
            e();
        } catch (Exception unused2) {
        }
    }

    public int c() {
        return -1;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        List list = this.f5534c;
        try {
            return a();
        } finally {
            if (list != null) {
                list.remove(this);
            }
        }
    }

    public final boolean d() {
        return this.f5535d.get();
    }

    public void e() {
    }

    public void f(Context context) {
    }

    public final void g(a aVar) {
        c cVar = this.f5532a;
        if (cVar == null || aVar == null) {
            return;
        }
        if (!cVar.f5512a) {
            cVar.b(aVar);
            cVar.f5512a = cVar.f5514c.isEmpty();
        }
        if (cVar.f5512a) {
            cVar.f5513b.offer(aVar);
        }
    }
}

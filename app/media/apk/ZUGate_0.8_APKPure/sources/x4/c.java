package x4;

import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import ru.zdevs.zugate.ZApp;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f5512a = true;

    /* renamed from: b  reason: collision with root package name */
    public final ConcurrentLinkedQueue f5513b = new ConcurrentLinkedQueue();

    /* renamed from: c  reason: collision with root package name */
    public final l.i f5514c = new l.i();

    public final void a(b bVar) {
        if (this.f5514c.add(bVar) && this.f5512a) {
            this.f5512a = false;
            while (!this.f5513b.isEmpty()) {
                b((a) this.f5513b.poll());
            }
        }
    }

    public final void b(a aVar) {
        if (aVar == null) {
            return;
        }
        ZApp zApp = ZApp.f4571h;
        Handler handler = zApp == null ? null : zApp.f4573g;
        Iterator it = this.f5514c.iterator();
        while (it.hasNext()) {
            handler.post(new e0.a(this, (b) it.next(), aVar, 8));
        }
    }
}

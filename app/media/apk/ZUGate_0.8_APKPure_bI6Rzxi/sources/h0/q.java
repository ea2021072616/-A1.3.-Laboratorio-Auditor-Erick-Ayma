package h0;

import android.view.MenuItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a  reason: collision with root package name */
    public final Runnable f3194a;

    /* renamed from: b  reason: collision with root package name */
    public final CopyOnWriteArrayList f3195b = new CopyOnWriteArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final HashMap f3196c = new HashMap();

    public q(Runnable runnable) {
        this.f3194a = runnable;
    }

    public final boolean a(MenuItem menuItem) {
        Iterator it = this.f3195b.iterator();
        while (it.hasNext()) {
            if (((androidx.fragment.app.p0) ((s) it.next())).f966a.o(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void b(s sVar) {
        this.f3195b.remove(sVar);
        p pVar = (p) this.f3196c.remove(sVar);
        if (pVar != null) {
            pVar.f3190a.b(pVar.f3191b);
            pVar.f3191b = null;
        }
        this.f3194a.run();
    }
}

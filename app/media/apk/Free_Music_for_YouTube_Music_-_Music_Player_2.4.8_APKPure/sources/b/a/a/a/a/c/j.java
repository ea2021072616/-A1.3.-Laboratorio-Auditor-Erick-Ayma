package b.a.a.a.a.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: PriorityTask.java */
/* loaded from: classes.dex */
public class j implements b<l>, i, l {
    private final List<l> dependencies = new ArrayList();
    private final AtomicBoolean hasRun = new AtomicBoolean(false);
    private final AtomicReference<Throwable> throwable = new AtomicReference<>(null);

    @Override // b.a.a.a.a.c.b
    public synchronized Collection<l> getDependencies() {
        return Collections.unmodifiableCollection(this.dependencies);
    }

    @Override // b.a.a.a.a.c.b
    public synchronized void addDependency(l lVar) {
        this.dependencies.add(lVar);
    }

    @Override // b.a.a.a.a.c.b
    public boolean areDependenciesMet() {
        for (l lVar : getDependencies()) {
            if (!lVar.isFinished()) {
                return false;
            }
        }
        return true;
    }

    @Override // b.a.a.a.a.c.l
    public synchronized void setFinished(boolean z) {
        this.hasRun.set(z);
    }

    @Override // b.a.a.a.a.c.l
    public boolean isFinished() {
        return this.hasRun.get();
    }

    @Override // b.a.a.a.a.c.i
    public e getPriority() {
        return e.NORMAL;
    }

    @Override // b.a.a.a.a.c.l
    public void setError(Throwable th) {
        this.throwable.set(th);
    }

    public Throwable getError() {
        return this.throwable.get();
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return e.a(this, obj);
    }

    public static boolean isProperDelegate(Object obj) {
        try {
            return (((b) obj) == null || ((l) obj) == null || ((i) obj) == null) ? false : true;
        } catch (ClassCastException e) {
            return false;
        }
    }
}

package b.a.a.a.a.c;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* compiled from: PriorityFutureTask.java */
/* loaded from: classes.dex */
public class h<V> extends FutureTask<V> implements b<l>, i, l {

    /* renamed from: b  reason: collision with root package name */
    final Object f171b;

    public h(Callable<V> callable) {
        super(callable);
        this.f171b = a(callable);
    }

    public h(Runnable runnable, V v) {
        super(runnable, v);
        this.f171b = a(runnable);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return ((i) a()).compareTo(obj);
    }

    @Override // b.a.a.a.a.c.b
    /* renamed from: a */
    public void addDependency(l lVar) {
        ((b) ((i) a())).addDependency(lVar);
    }

    @Override // b.a.a.a.a.c.b
    public Collection<l> getDependencies() {
        return ((b) ((i) a())).getDependencies();
    }

    @Override // b.a.a.a.a.c.b
    public boolean areDependenciesMet() {
        return ((b) ((i) a())).areDependenciesMet();
    }

    @Override // b.a.a.a.a.c.i
    public e getPriority() {
        return ((i) a()).getPriority();
    }

    @Override // b.a.a.a.a.c.l
    public void setFinished(boolean z) {
        ((l) ((i) a())).setFinished(z);
    }

    @Override // b.a.a.a.a.c.l
    public boolean isFinished() {
        return ((l) ((i) a())).isFinished();
    }

    @Override // b.a.a.a.a.c.l
    public void setError(Throwable th) {
        ((l) ((i) a())).setError(th);
    }

    /* JADX WARN: Incorrect return type in method signature: <T::Lb/a/a/a/a/c/b<Lb/a/a/a/a/c/l;>;:Lb/a/a/a/a/c/i;:Lb/a/a/a/a/c/l;>()TT; */
    public b a() {
        return (b) this.f171b;
    }

    /* JADX WARN: Incorrect return type in method signature: <T::Lb/a/a/a/a/c/b<Lb/a/a/a/a/c/l;>;:Lb/a/a/a/a/c/i;:Lb/a/a/a/a/c/l;>(Ljava/lang/Object;)TT; */
    protected b a(Object obj) {
        return j.isProperDelegate(obj) ? (b) obj : new j();
    }
}

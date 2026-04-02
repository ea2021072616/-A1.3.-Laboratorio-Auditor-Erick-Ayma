package b.a.a.a.a.c;

import b.a.a.a.a.c.a;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* compiled from: PriorityAsyncTask.java */
/* loaded from: classes.dex */
public abstract class f<Params, Progress, Result> extends b.a.a.a.a.c.a<Params, Progress, Result> implements b<l>, i, l {

    /* renamed from: a  reason: collision with root package name */
    private final j f167a = new j();

    public final void a(ExecutorService executorService, Params... paramsArr) {
        super.a(new a(executorService, this), paramsArr);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return e.a(this, obj);
    }

    @Override // b.a.a.a.a.c.b
    /* renamed from: a */
    public void addDependency(l lVar) {
        if (b() != a.d.PENDING) {
            throw new IllegalStateException("Must not add Dependency after task is running");
        }
        ((b) ((i) e())).addDependency(lVar);
    }

    @Override // b.a.a.a.a.c.b
    public Collection<l> getDependencies() {
        return ((b) ((i) e())).getDependencies();
    }

    @Override // b.a.a.a.a.c.b
    public boolean areDependenciesMet() {
        return ((b) ((i) e())).areDependenciesMet();
    }

    @Override // b.a.a.a.a.c.i
    public e getPriority() {
        return ((i) e()).getPriority();
    }

    @Override // b.a.a.a.a.c.l
    public void setFinished(boolean z) {
        ((l) ((i) e())).setFinished(z);
    }

    @Override // b.a.a.a.a.c.l
    public boolean isFinished() {
        return ((l) ((i) e())).isFinished();
    }

    @Override // b.a.a.a.a.c.l
    public void setError(Throwable th) {
        ((l) ((i) e())).setError(th);
    }

    /* JADX WARN: Incorrect return type in method signature: <T::Lb/a/a/a/a/c/b<Lb/a/a/a/a/c/l;>;:Lb/a/a/a/a/c/i;:Lb/a/a/a/a/c/l;>()TT; */
    public b e() {
        return this.f167a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PriorityAsyncTask.java */
    /* loaded from: classes.dex */
    public static class a<Result> implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private final Executor f168a;

        /* renamed from: b  reason: collision with root package name */
        private final f f169b;

        public a(Executor executor, f fVar) {
            this.f168a = executor;
            this.f169b = fVar;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f168a.execute(new h<Result>(runnable, null) { // from class: b.a.a.a.a.c.f.a.1
                /* JADX WARN: Incorrect return type in method signature: <T::Lb/a/a/a/a/c/b<Lb/a/a/a/a/c/l;>;:Lb/a/a/a/a/c/i;:Lb/a/a/a/a/c/l;>()TT; */
                @Override // b.a.a.a.a.c.h
                public b a() {
                    return a.this.f169b;
                }
            });
        }
    }
}

package a;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* compiled from: Task.java */
/* loaded from: classes.dex */
public class j<TResult> {
    private static volatile b d;
    private boolean f;
    private boolean g;
    private TResult h;
    private Exception i;
    private boolean j;
    private l k;

    /* renamed from: a  reason: collision with root package name */
    public static final ExecutorService f20a = d.a();

    /* renamed from: c  reason: collision with root package name */
    private static final Executor f22c = d.b();

    /* renamed from: b  reason: collision with root package name */
    public static final Executor f21b = a.a.b();
    private static j<?> m = new j<>((Object) null);
    private static j<Boolean> n = new j<>(true);
    private static j<Boolean> o = new j<>(false);
    private static j<?> p = new j<>(true);
    private final Object e = new Object();
    private List<h<TResult, Void>> l = new ArrayList();

    /* compiled from: Task.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(j<?> jVar, m mVar);
    }

    public static b a() {
        return d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j() {
    }

    private j(TResult tresult) {
        b((j<TResult>) tresult);
    }

    private j(boolean z) {
        if (z) {
            i();
        } else {
            b((j<TResult>) null);
        }
    }

    public static <TResult> j<TResult>.a b() {
        j jVar = new j();
        jVar.getClass();
        return new a();
    }

    public boolean c() {
        boolean z;
        synchronized (this.e) {
            z = this.f;
        }
        return z;
    }

    public boolean d() {
        boolean z;
        synchronized (this.e) {
            z = this.g;
        }
        return z;
    }

    public boolean e() {
        boolean z;
        synchronized (this.e) {
            z = g() != null;
        }
        return z;
    }

    public TResult f() {
        TResult tresult;
        synchronized (this.e) {
            tresult = this.h;
        }
        return tresult;
    }

    public Exception g() {
        Exception exc;
        synchronized (this.e) {
            if (this.i != null) {
                this.j = true;
                if (this.k != null) {
                    this.k.a();
                    this.k = null;
                }
            }
            exc = this.i;
        }
        return exc;
    }

    public static <TResult> j<TResult> a(TResult tresult) {
        if (tresult == null) {
            return (j<TResult>) m;
        }
        if (tresult instanceof Boolean) {
            return ((Boolean) tresult).booleanValue() ? (j<TResult>) n : (j<TResult>) o;
        }
        k kVar = new k();
        kVar.b((k) tresult);
        return kVar.a();
    }

    public static <TResult> j<TResult> a(Exception exc) {
        k kVar = new k();
        kVar.b(exc);
        return kVar.a();
    }

    public static <TResult> j<TResult> h() {
        return (j<TResult>) p;
    }

    public <TContinuationResult> j<TContinuationResult> a(final h<TResult, TContinuationResult> hVar, final Executor executor, final e eVar) {
        boolean c2;
        final k kVar = new k();
        synchronized (this.e) {
            c2 = c();
            if (!c2) {
                this.l.add(new h<TResult, Void>() { // from class: a.j.1
                    @Override // a.h
                    /* renamed from: a */
                    public Void then(j<TResult> jVar) {
                        j.c(kVar, hVar, jVar, executor, eVar);
                        return null;
                    }
                });
            }
        }
        if (c2) {
            c(kVar, hVar, this, executor, eVar);
        }
        return kVar.a();
    }

    public <TContinuationResult> j<TContinuationResult> a(h<TResult, TContinuationResult> hVar) {
        return a(hVar, f22c, null);
    }

    public <TContinuationResult> j<TContinuationResult> a(h<TResult, j<TContinuationResult>> hVar, Executor executor) {
        return b(hVar, executor, null);
    }

    public <TContinuationResult> j<TContinuationResult> b(final h<TResult, j<TContinuationResult>> hVar, final Executor executor, final e eVar) {
        boolean c2;
        final k kVar = new k();
        synchronized (this.e) {
            c2 = c();
            if (!c2) {
                this.l.add(new h<TResult, Void>() { // from class: a.j.2
                    @Override // a.h
                    /* renamed from: a */
                    public Void then(j<TResult> jVar) {
                        j.d(kVar, hVar, jVar, executor, eVar);
                        return null;
                    }
                });
            }
        }
        if (c2) {
            d(kVar, hVar, this, executor, eVar);
        }
        return kVar.a();
    }

    public <TContinuationResult> j<TContinuationResult> c(final h<TResult, TContinuationResult> hVar, Executor executor, final e eVar) {
        return a(new h<TResult, j<TContinuationResult>>() { // from class: a.j.3
            @Override // a.h
            /* renamed from: a */
            public j<TContinuationResult> then(j<TResult> jVar) {
                if (eVar != null && eVar.a()) {
                    return j.h();
                }
                if (jVar.e()) {
                    return j.a(jVar.g());
                }
                if (jVar.d()) {
                    return j.h();
                }
                return jVar.a((h) hVar);
            }
        }, executor);
    }

    public <TContinuationResult> j<TContinuationResult> b(h<TResult, TContinuationResult> hVar) {
        return c(hVar, f22c, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <TContinuationResult, TResult> void c(final k<TContinuationResult> kVar, final h<TResult, TContinuationResult> hVar, final j<TResult> jVar, Executor executor, final e eVar) {
        try {
            executor.execute(new Runnable() { // from class: a.j.4
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (e.this != null && e.this.a()) {
                        kVar.c();
                        return;
                    }
                    try {
                        kVar.b((k) hVar.then(jVar));
                    } catch (CancellationException e) {
                        kVar.c();
                    } catch (Exception e2) {
                        kVar.b(e2);
                    }
                }
            });
        } catch (Exception e) {
            kVar.b(new i(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <TContinuationResult, TResult> void d(final k<TContinuationResult> kVar, final h<TResult, j<TContinuationResult>> hVar, final j<TResult> jVar, Executor executor, final e eVar) {
        try {
            executor.execute(new Runnable() { // from class: a.j.5
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0026 -> B:18:0x0011). Please submit an issue!!! */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0036 -> B:18:0x0011). Please submit an issue!!! */
                @Override // java.lang.Runnable
                public void run() {
                    if (e.this != null && e.this.a()) {
                        kVar.c();
                        return;
                    }
                    try {
                        j jVar2 = (j) hVar.then(jVar);
                        if (jVar2 == null) {
                            kVar.b((k) null);
                        } else {
                            jVar2.a((h) new h<TContinuationResult, Void>() { // from class: a.j.5.1
                                @Override // a.h
                                /* renamed from: a */
                                public Void then(j<TContinuationResult> jVar3) {
                                    if (e.this != null && e.this.a()) {
                                        kVar.c();
                                    } else if (jVar3.d()) {
                                        kVar.c();
                                    } else if (jVar3.e()) {
                                        kVar.b(jVar3.g());
                                    } else {
                                        kVar.b((k) jVar3.f());
                                    }
                                    return null;
                                }
                            });
                        }
                    } catch (CancellationException e) {
                        kVar.c();
                    } catch (Exception e2) {
                        kVar.b(e2);
                    }
                }
            });
        } catch (Exception e) {
            kVar.b(new i(e));
        }
    }

    private void j() {
        synchronized (this.e) {
            for (h<TResult, Void> hVar : this.l) {
                try {
                    hVar.then(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.l = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i() {
        boolean z = true;
        synchronized (this.e) {
            if (this.f) {
                z = false;
            } else {
                this.f = true;
                this.g = true;
                this.e.notifyAll();
                j();
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(TResult tresult) {
        boolean z = true;
        synchronized (this.e) {
            if (this.f) {
                z = false;
            } else {
                this.f = true;
                this.h = tresult;
                this.e.notifyAll();
                j();
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Exception exc) {
        synchronized (this.e) {
            if (this.f) {
                return false;
            }
            this.f = true;
            this.i = exc;
            this.j = false;
            this.e.notifyAll();
            j();
            if (!this.j && a() != null) {
                this.k = new l(this);
            }
            return true;
        }
    }

    /* compiled from: Task.java */
    /* loaded from: classes.dex */
    public class a extends k<TResult> {
        a() {
        }
    }
}

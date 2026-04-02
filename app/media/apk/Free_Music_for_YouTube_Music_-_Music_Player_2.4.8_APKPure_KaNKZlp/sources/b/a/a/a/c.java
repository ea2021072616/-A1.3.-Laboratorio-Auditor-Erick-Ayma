package b.a.a.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import b.a.a.a.a;
import b.a.a.a.a.b.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: Fabric.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    static volatile c f257a;

    /* renamed from: b  reason: collision with root package name */
    static final l f258b = new b();

    /* renamed from: c  reason: collision with root package name */
    final l f259c;
    final boolean d;
    private final Context e;
    private final Map<Class<? extends i>, i> f;
    private final ExecutorService g;
    private final Handler h;
    private final f<c> i;
    private final f<?> j;
    private final o k;
    private b.a.a.a.a l;
    private WeakReference<Activity> m;
    private AtomicBoolean n = new AtomicBoolean(false);

    /* compiled from: Fabric.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final Context f264a;

        /* renamed from: b  reason: collision with root package name */
        private i[] f265b;

        /* renamed from: c  reason: collision with root package name */
        private b.a.a.a.a.c.k f266c;
        private Handler d;
        private l e;
        private boolean f;
        private String g;
        private String h;
        private f<c> i;

        public a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.f264a = context;
        }

        public a a(i... iVarArr) {
            if (this.f265b != null) {
                throw new IllegalStateException("Kits already set.");
            }
            this.f265b = iVarArr;
            return this;
        }

        public a a(boolean z) {
            this.f = z;
            return this;
        }

        public c a() {
            Map b2;
            if (this.f266c == null) {
                this.f266c = b.a.a.a.a.c.k.a();
            }
            if (this.d == null) {
                this.d = new Handler(Looper.getMainLooper());
            }
            if (this.e == null) {
                if (this.f) {
                    this.e = new b(3);
                } else {
                    this.e = new b();
                }
            }
            if (this.h == null) {
                this.h = this.f264a.getPackageName();
            }
            if (this.i == null) {
                this.i = f.d;
            }
            if (this.f265b != null) {
                b2 = c.b(Arrays.asList(this.f265b));
            } else {
                b2 = new HashMap();
            }
            return new c(this.f264a, b2, this.f266c, this.d, this.e, this.f, this.i, new o(this.f264a, this.h, this.g, b2.values()));
        }
    }

    static c a() {
        if (f257a == null) {
            throw new IllegalStateException("Must Initialize Fabric before using singleton()");
        }
        return f257a;
    }

    c(Context context, Map<Class<? extends i>, i> map, b.a.a.a.a.c.k kVar, Handler handler, l lVar, boolean z, f fVar, o oVar) {
        this.e = context.getApplicationContext();
        this.f = map;
        this.g = kVar;
        this.h = handler;
        this.f259c = lVar;
        this.d = z;
        this.i = fVar;
        this.j = a(map.size());
        this.k = oVar;
        a(c(context));
    }

    public static c a(c cVar) {
        if (f257a == null) {
            synchronized (c.class) {
                if (f257a == null) {
                    d(cVar);
                }
            }
        }
        return f257a;
    }

    private static void d(c cVar) {
        f257a = cVar;
        cVar.k();
    }

    public c a(Activity activity) {
        this.m = new WeakReference<>(activity);
        return this;
    }

    public Activity b() {
        if (this.m != null) {
            return this.m.get();
        }
        return null;
    }

    private void k() {
        this.l = new b.a.a.a.a(this.e);
        this.l.a(new a.b() { // from class: b.a.a.a.c.1
            @Override // b.a.a.a.a.b
            public void onActivityCreated(Activity activity, Bundle bundle) {
                c.this.a(activity);
            }

            @Override // b.a.a.a.a.b
            public void onActivityStarted(Activity activity) {
                c.this.a(activity);
            }

            @Override // b.a.a.a.a.b
            public void onActivityResumed(Activity activity) {
                c.this.a(activity);
            }
        });
        a(this.e);
    }

    public String c() {
        return "1.3.14.143";
    }

    public String d() {
        return "io.fabric.sdk.android:fabric";
    }

    void a(Context context) {
        StringBuilder sb;
        Future<Map<String, k>> b2 = b(context);
        Collection<i> g = g();
        m mVar = new m(b2, g);
        ArrayList<i> arrayList = new ArrayList(g);
        Collections.sort(arrayList);
        mVar.injectParameters(context, this, f.d, this.k);
        for (i iVar : arrayList) {
            iVar.injectParameters(context, this, this.j, this.k);
        }
        mVar.initialize();
        if (h().a("Fabric", 3)) {
            sb = new StringBuilder("Initializing ").append(d()).append(" [Version: ").append(c()).append("], with the following kits:\n");
        } else {
            sb = null;
        }
        for (i iVar2 : arrayList) {
            iVar2.initializationTask.addDependency(mVar.initializationTask);
            a(this.f, iVar2);
            iVar2.initialize();
            if (sb != null) {
                sb.append(iVar2.getIdentifier()).append(" [Version: ").append(iVar2.getVersion()).append("]\n");
            }
        }
        if (sb != null) {
            h().a("Fabric", sb.toString());
        }
    }

    void a(Map<Class<? extends i>, i> map, i iVar) {
        Class<?>[] a2;
        b.a.a.a.a.c.d dVar = iVar.dependsOnAnnotation;
        if (dVar != null) {
            for (Class<?> cls : dVar.a()) {
                if (cls.isInterface()) {
                    for (i iVar2 : map.values()) {
                        if (cls.isAssignableFrom(iVar2.getClass())) {
                            iVar.initializationTask.addDependency(iVar2.initializationTask);
                        }
                    }
                } else if (map.get(cls) == null) {
                    throw new b.a.a.a.a.c.m("Referenced Kit was null, does the kit exist?");
                } else {
                    iVar.initializationTask.addDependency(map.get(cls).initializationTask);
                }
            }
        }
    }

    private Activity c(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    public b.a.a.a.a e() {
        return this.l;
    }

    public ExecutorService f() {
        return this.g;
    }

    public Collection<i> g() {
        return this.f.values();
    }

    public static <T extends i> T a(Class<T> cls) {
        return (T) a().f.get(cls);
    }

    public static l h() {
        return f257a == null ? f258b : f257a.f259c;
    }

    public static boolean i() {
        if (f257a == null) {
            return false;
        }
        return f257a.d;
    }

    public static boolean j() {
        return f257a != null && f257a.n.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<Class<? extends i>, i> b(Collection<? extends i> collection) {
        HashMap hashMap = new HashMap(collection.size());
        a(hashMap, collection);
        return hashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void a(Map<Class<? extends i>, i> map, Collection<? extends i> collection) {
        for (i iVar : collection) {
            map.put(iVar.getClass(), iVar);
            if (iVar instanceof j) {
                a(map, ((j) iVar).getKits());
            }
        }
    }

    f<?> a(final int i) {
        return new f() { // from class: b.a.a.a.c.2

            /* renamed from: a  reason: collision with root package name */
            final CountDownLatch f261a;

            {
                this.f261a = new CountDownLatch(i);
            }

            @Override // b.a.a.a.f
            public void a(Object obj) {
                this.f261a.countDown();
                if (this.f261a.getCount() == 0) {
                    c.this.n.set(true);
                    c.this.i.a((f) c.this);
                }
            }

            @Override // b.a.a.a.f
            public void a(Exception exc) {
                c.this.i.a(exc);
            }
        };
    }

    Future<Map<String, k>> b(Context context) {
        return f().submit(new e(context.getPackageCodePath()));
    }
}

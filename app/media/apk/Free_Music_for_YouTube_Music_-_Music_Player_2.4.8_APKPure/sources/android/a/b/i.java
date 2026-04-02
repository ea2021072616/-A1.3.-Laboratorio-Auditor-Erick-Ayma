package android.a.b;

import android.a.b.g;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* compiled from: LifecycleRegistry.java */
/* loaded from: classes.dex */
public class i extends g {

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<h> f68c;

    /* renamed from: a  reason: collision with root package name */
    private android.a.a.a.a<Object, a> f66a = new android.a.a.a.a<>();
    private int d = 0;
    private boolean e = false;
    private boolean f = false;
    private ArrayList<g.b> g = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private g.b f67b = g.b.INITIALIZED;

    public i(@NonNull h hVar) {
        this.f68c = new WeakReference<>(hVar);
    }

    @MainThread
    public void a(@NonNull g.b bVar) {
        b(bVar);
    }

    public void a(@NonNull g.a aVar) {
        b(b(aVar));
    }

    private void b(g.b bVar) {
        if (this.f67b != bVar) {
            this.f67b = bVar;
            if (this.e || this.d != 0) {
                this.f = true;
                return;
            }
            this.e = true;
            d();
            this.e = false;
        }
    }

    private boolean b() {
        if (this.f66a.a() == 0) {
            return true;
        }
        g.b bVar = this.f66a.d().getValue().f71a;
        g.b bVar2 = this.f66a.e().getValue().f71a;
        return bVar == bVar2 && this.f67b == bVar2;
    }

    private void c() {
        this.g.remove(this.g.size() - 1);
    }

    private void c(g.b bVar) {
        this.g.add(bVar);
    }

    @Override // android.a.b.g
    public g.b a() {
        return this.f67b;
    }

    static g.b b(g.a aVar) {
        switch (aVar) {
            case ON_CREATE:
            case ON_STOP:
                return g.b.CREATED;
            case ON_START:
            case ON_PAUSE:
                return g.b.STARTED;
            case ON_RESUME:
                return g.b.RESUMED;
            case ON_DESTROY:
                return g.b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + aVar);
        }
    }

    private static g.a d(g.b bVar) {
        switch (bVar) {
            case INITIALIZED:
                throw new IllegalArgumentException();
            case CREATED:
                return g.a.ON_DESTROY;
            case STARTED:
                return g.a.ON_STOP;
            case RESUMED:
                return g.a.ON_PAUSE;
            case DESTROYED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + bVar);
        }
    }

    private static g.a e(g.b bVar) {
        switch (bVar) {
            case INITIALIZED:
            case DESTROYED:
                return g.a.ON_CREATE;
            case CREATED:
                return g.a.ON_START;
            case STARTED:
                return g.a.ON_RESUME;
            case RESUMED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + bVar);
        }
    }

    private void a(h hVar) {
        android.a.a.a.b<Object, a>.d c2 = this.f66a.c();
        while (c2.hasNext() && !this.f) {
            Map.Entry next = c2.next();
            a aVar = (a) next.getValue();
            while (aVar.f71a.compareTo(this.f67b) < 0 && !this.f && this.f66a.a((android.a.a.a.a<Object, a>) next.getKey())) {
                c(aVar.f71a);
                aVar.a(hVar, e(aVar.f71a));
                c();
            }
        }
    }

    private void b(h hVar) {
        Iterator<Map.Entry<Object, a>> b2 = this.f66a.b();
        while (b2.hasNext() && !this.f) {
            Map.Entry<Object, a> next = b2.next();
            a value = next.getValue();
            while (value.f71a.compareTo(this.f67b) > 0 && !this.f && this.f66a.a((android.a.a.a.a<Object, a>) next.getKey())) {
                g.a d = d(value.f71a);
                c(b(d));
                value.a(hVar, d);
                c();
            }
        }
    }

    private void d() {
        h hVar = this.f68c.get();
        if (hVar == null) {
            Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
            return;
        }
        while (!b()) {
            this.f = false;
            if (this.f67b.compareTo(this.f66a.d().getValue().f71a) < 0) {
                b(hVar);
            }
            Map.Entry<Object, a> e = this.f66a.e();
            if (!this.f && e != null && this.f67b.compareTo(e.getValue().f71a) > 0) {
                a(hVar);
            }
        }
        this.f = false;
    }

    static g.b a(@NonNull g.b bVar, @Nullable g.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LifecycleRegistry.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        g.b f71a;

        /* renamed from: b  reason: collision with root package name */
        f f72b;

        void a(h hVar, g.a aVar) {
            g.b b2 = i.b(aVar);
            this.f71a = i.a(this.f71a, b2);
            this.f72b.a(hVar, aVar);
            this.f71a = b2;
        }
    }
}

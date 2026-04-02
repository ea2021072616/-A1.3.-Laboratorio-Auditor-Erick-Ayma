package b.a.a.a.a.g;

import android.content.Context;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: Settings.java */
/* loaded from: classes.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<t> f242a;

    /* renamed from: b  reason: collision with root package name */
    private final CountDownLatch f243b;

    /* renamed from: c  reason: collision with root package name */
    private s f244c;
    private boolean d;

    /* compiled from: Settings.java */
    /* loaded from: classes.dex */
    public interface b<T> {
        T usingSettings(t tVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Settings.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final q f245a = new q();
    }

    public static q a() {
        return a.f245a;
    }

    private q() {
        this.f242a = new AtomicReference<>();
        this.f243b = new CountDownLatch(1);
        this.d = false;
    }

    public synchronized q a(b.a.a.a.i iVar, b.a.a.a.a.b.o oVar, b.a.a.a.a.e.e eVar, String str, String str2, String str3) {
        q qVar;
        if (this.d) {
            qVar = this;
        } else {
            if (this.f244c == null) {
                Context context = iVar.getContext();
                String c2 = oVar.c();
                String a2 = new b.a.a.a.a.b.g().a(context);
                String j = oVar.j();
                this.f244c = new j(iVar, new w(a2, oVar.g(), oVar.f(), oVar.e(), oVar.m(), oVar.b(), oVar.n(), b.a.a.a.a.b.i.a(b.a.a.a.a.b.i.m(context)), str2, str, b.a.a.a.a.b.l.a(j).a(), b.a.a.a.a.b.i.k(context)), new b.a.a.a.a.b.s(), new k(), new i(iVar), new l(iVar, str3, String.format(Locale.US, "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", c2), eVar));
            }
            this.d = true;
            qVar = this;
        }
        return qVar;
    }

    public <T> T a(b<T> bVar, T t) {
        t tVar = this.f242a.get();
        return tVar == null ? t : bVar.usingSettings(tVar);
    }

    public t b() {
        try {
            this.f243b.await();
            return this.f242a.get();
        } catch (InterruptedException e) {
            b.a.a.a.c.h().e("Fabric", "Interrupted while waiting for settings data.");
            return null;
        }
    }

    public synchronized boolean c() {
        t a2;
        a2 = this.f244c.a();
        a(a2);
        return a2 != null;
    }

    public synchronized boolean d() {
        t a2;
        a2 = this.f244c.a(r.SKIP_CACHE_LOOKUP);
        a(a2);
        if (a2 == null) {
            b.a.a.a.c.h().e("Fabric", "Failed to force reload of settings from Crashlytics.", null);
        }
        return a2 != null;
    }

    private void a(t tVar) {
        this.f242a.set(tVar);
        this.f243b.countDown();
    }
}

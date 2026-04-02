package b.a.a.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import b.a.a.a.a.g.n;
import b.a.a.a.a.g.q;
import b.a.a.a.a.g.t;
import b.a.a.a.a.g.y;
import com.facebook.appevents.AppEventsConstants;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Onboarding.java */
/* loaded from: classes.dex */
public class m extends i<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    private final b.a.a.a.a.e.e f274a = new b.a.a.a.a.e.b();

    /* renamed from: b  reason: collision with root package name */
    private PackageManager f275b;

    /* renamed from: c  reason: collision with root package name */
    private String f276c;
    private PackageInfo d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private final Future<Map<String, k>> j;
    private final Collection<i> k;

    public m(Future<Map<String, k>> future, Collection<i> collection) {
        this.j = future;
        this.k = collection;
    }

    @Override // b.a.a.a.i
    public String getVersion() {
        return "1.3.14.143";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b.a.a.a.i
    public boolean onPreExecute() {
        boolean z = false;
        try {
            this.g = getIdManager().j();
            this.f275b = getContext().getPackageManager();
            this.f276c = getContext().getPackageName();
            this.d = this.f275b.getPackageInfo(this.f276c, 0);
            this.e = Integer.toString(this.d.versionCode);
            this.f = this.d.versionName == null ? "0.0" : this.d.versionName;
            this.h = this.f275b.getApplicationLabel(getContext().getApplicationInfo()).toString();
            this.i = Integer.toString(getContext().getApplicationInfo().targetSdkVersion);
            z = true;
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            c.h().e("Fabric", "Failed init", e);
            return z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b.a.a.a.i
    /* renamed from: a */
    public Boolean doInBackground() {
        Map<String, k> hashMap;
        boolean a2;
        String k = b.a.a.a.a.b.i.k(getContext());
        t c2 = c();
        if (c2 != null) {
            try {
                if (this.j != null) {
                    hashMap = this.j.get();
                } else {
                    hashMap = new HashMap<>();
                }
                a2 = a(k, c2.f249a, a(hashMap, this.k).values());
            } catch (Exception e) {
                c.h().e("Fabric", "Error performing auto configuration.", e);
            }
            return Boolean.valueOf(a2);
        }
        a2 = false;
        return Boolean.valueOf(a2);
    }

    private t c() {
        try {
            q.a().a(this, this.idManager, this.f274a, this.e, this.f, b()).c();
            return q.a().b();
        } catch (Exception e) {
            c.h().e("Fabric", "Error dealing with settings", e);
            return null;
        }
    }

    Map<String, k> a(Map<String, k> map, Collection<i> collection) {
        for (i iVar : collection) {
            if (!map.containsKey(iVar.getIdentifier())) {
                map.put(iVar.getIdentifier(), new k(iVar.getIdentifier(), iVar.getVersion(), "binary"));
            }
        }
        return map;
    }

    @Override // b.a.a.a.i
    public String getIdentifier() {
        return "io.fabric.sdk.android:fabric";
    }

    private boolean a(String str, b.a.a.a.a.g.e eVar, Collection<k> collection) {
        if ("new".equals(eVar.f222b)) {
            if (b(str, eVar, collection)) {
                return q.a().d();
            }
            c.h().e("Fabric", "Failed to create app with Crashlytics service.", null);
            return false;
        } else if ("configured".equals(eVar.f222b)) {
            return q.a().d();
        } else {
            if (!eVar.e) {
                return true;
            }
            c.h().a("Fabric", "Server says an update is required - forcing a full App update.");
            c(str, eVar, collection);
            return true;
        }
    }

    private boolean b(String str, b.a.a.a.a.g.e eVar, Collection<k> collection) {
        return new b.a.a.a.a.g.h(this, b(), eVar.f223c, this.f274a).a(a(n.a(getContext(), str), collection));
    }

    private boolean c(String str, b.a.a.a.a.g.e eVar, Collection<k> collection) {
        return a(eVar, n.a(getContext(), str), collection);
    }

    private boolean a(b.a.a.a.a.g.e eVar, n nVar, Collection<k> collection) {
        return new y(this, b(), eVar.f223c, this.f274a).a(a(nVar, collection));
    }

    private b.a.a.a.a.g.d a(n nVar, Collection<k> collection) {
        Context context = getContext();
        return new b.a.a.a.a.g.d(new b.a.a.a.a.b.g().a(context), getIdManager().c(), this.f, this.e, b.a.a.a.a.b.i.a(b.a.a.a.a.b.i.m(context)), this.h, b.a.a.a.a.b.l.a(this.g).a(), this.i, AppEventsConstants.EVENT_PARAM_VALUE_NO, nVar, collection);
    }

    String b() {
        return b.a.a.a.a.b.i.b(getContext(), "com.crashlytics.ApiEndpoint");
    }
}

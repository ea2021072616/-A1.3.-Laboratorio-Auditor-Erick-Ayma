package b.a.a.a.a.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
/* compiled from: AdvertisingInfoProvider.java */
/* loaded from: classes.dex */
class c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f88a;

    /* renamed from: b  reason: collision with root package name */
    private final b.a.a.a.a.f.c f89b;

    public c(Context context) {
        this.f88a = context.getApplicationContext();
        this.f89b = new b.a.a.a.a.f.d(context, "TwitterAdvertisingInfoPreferences");
    }

    public b a() {
        b b2 = b();
        if (c(b2)) {
            b.a.a.a.c.h().a("Fabric", "Using AdvertisingInfo from Preference Store");
            a(b2);
            return b2;
        }
        b e = e();
        b(e);
        return e;
    }

    private void a(final b bVar) {
        new Thread(new h() { // from class: b.a.a.a.a.b.c.1
            @Override // b.a.a.a.a.b.h
            public void onRun() {
                b e = c.this.e();
                if (!bVar.equals(e)) {
                    b.a.a.a.c.h().a("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
                    c.this.b(e);
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CommitPrefEdits"})
    public void b(b bVar) {
        if (c(bVar)) {
            this.f89b.a(this.f89b.b().putString("advertising_id", bVar.f86a).putBoolean("limit_ad_tracking_enabled", bVar.f87b));
        } else {
            this.f89b.a(this.f89b.b().remove("advertising_id").remove("limit_ad_tracking_enabled"));
        }
    }

    protected b b() {
        return new b(this.f89b.a().getString("advertising_id", ""), this.f89b.a().getBoolean("limit_ad_tracking_enabled", false));
    }

    public f c() {
        return new d(this.f88a);
    }

    public f d() {
        return new e(this.f88a);
    }

    private boolean c(b bVar) {
        return (bVar == null || TextUtils.isEmpty(bVar.f86a)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b e() {
        b a2 = c().a();
        if (!c(a2)) {
            a2 = d().a();
            if (!c(a2)) {
                b.a.a.a.c.h().a("Fabric", "AdvertisingInfo not present");
            } else {
                b.a.a.a.c.h().a("Fabric", "Using AdvertisingInfo from Service Provider");
            }
        } else {
            b.a.a.a.c.h().a("Fabric", "Using AdvertisingInfo from Reflection Provider");
        }
        return a2;
    }
}

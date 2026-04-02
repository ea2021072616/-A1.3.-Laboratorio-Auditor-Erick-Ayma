package com.facebook.ads.internal.b;

import android.os.Bundle;
import com.facebook.ads.internal.util.ad;
/* loaded from: classes.dex */
public class d implements ad<Bundle> {

    /* renamed from: a  reason: collision with root package name */
    private c f1250a;

    /* renamed from: b  reason: collision with root package name */
    private final c f1251b;

    /* renamed from: c  reason: collision with root package name */
    private final b f1252c;
    private boolean d;
    private boolean e;
    private boolean f;

    public d(b bVar) {
        this.d = false;
        this.e = false;
        this.f = false;
        this.f1252c = bVar;
        this.f1251b = new c(bVar.f1242a);
        this.f1250a = new c(bVar.f1242a);
    }

    public d(b bVar, Bundle bundle) {
        this.d = false;
        this.e = false;
        this.f = false;
        this.f1252c = bVar;
        this.f1251b = (c) bundle.getSerializable("testStats");
        this.f1250a = (c) bundle.getSerializable("viewableStats");
        this.d = bundle.getBoolean("ended");
        this.e = bundle.getBoolean("passed");
        this.f = bundle.getBoolean("complete");
    }

    private void a() {
        this.e = true;
        b();
    }

    private void b() {
        this.f = true;
        c();
    }

    private void c() {
        this.d = true;
        this.f1252c.a(this.f, this.e, this.e ? this.f1250a : this.f1251b);
    }

    public void a(double d, double d2) {
        if (this.d) {
            return;
        }
        this.f1251b.a(d, d2);
        this.f1250a.a(d, d2);
        double f = this.f1250a.b().f();
        if (this.f1252c.d && d2 < this.f1252c.f1242a) {
            this.f1250a = new c(this.f1252c.f1242a);
        }
        if (this.f1252c.f1243b >= 0.0d && this.f1251b.b().e() > this.f1252c.f1243b && f == 0.0d) {
            b();
        } else if (f >= this.f1252c.f1244c) {
            a();
        }
    }

    @Override // com.facebook.ads.internal.util.ad
    public Bundle getSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("viewableStats", this.f1250a);
        bundle.putSerializable("testStats", this.f1251b);
        bundle.putBoolean("ended", this.d);
        bundle.putBoolean("passed", this.e);
        bundle.putBoolean("complete", this.f);
        return bundle;
    }
}

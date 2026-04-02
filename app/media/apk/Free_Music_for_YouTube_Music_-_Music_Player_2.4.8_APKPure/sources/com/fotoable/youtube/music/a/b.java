package com.fotoable.youtube.music.a;

import android.content.Context;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.util.v;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* compiled from: AdsManager.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f2226a;

    /* renamed from: b  reason: collision with root package name */
    private Context f2227b;

    /* renamed from: c  reason: collision with root package name */
    private d f2228c;
    private a d;
    private boolean e = false;

    public static b a(Context context) {
        if (f2226a == null) {
            synchronized (b.class) {
                if (f2226a == null) {
                    f2226a = new b(context.getApplicationContext());
                }
            }
        }
        return f2226a;
    }

    public d a() {
        return this.f2228c;
    }

    public a b() {
        return this.d;
    }

    private b(Context context) {
        try {
            this.f2227b = context;
            this.f2228c = d.a(this.f2227b);
            this.d = a.a(this.f2227b);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public void a(boolean z) {
        this.e = z;
    }

    public boolean c() {
        return this.e;
    }

    public void d() {
        if (!MusicApplication.c().a() && this.d != null && this.d.c()) {
            this.d.b();
        }
    }

    public boolean e() {
        return (MusicApplication.c().a() || this.d == null || !this.d.c()) ? false : true;
    }

    public void f() {
        try {
            if (!MusicApplication.c().a()) {
                if (System.currentTimeMillis() - v.a(this.f2227b, com.fotoable.youtube.music.b.m, 0L) > 86400000) {
                    v.b(this.f2227b, com.fotoable.youtube.music.b.k, 1);
                    v.b(this.f2227b, com.fotoable.youtube.music.b.l, 1);
                    v.b(this.f2227b, com.fotoable.youtube.music.b.m, System.currentTimeMillis());
                }
                v.a(this.f2227b, com.fotoable.youtube.music.b.k, 1);
                v.a(this.f2227b, com.fotoable.youtube.music.b.l, 1);
                com.fotoable.youtube.music.util.b.b("广告 请求Admob广告");
                this.d.a();
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }
}

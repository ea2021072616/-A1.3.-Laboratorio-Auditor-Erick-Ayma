package com.fotoable.youtube.music.base;

import android.app.Service;
import android.content.Intent;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.c.a.k;
import com.fotoable.youtube.music.c.b.ac;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import rx.m;
/* loaded from: classes.dex */
public abstract class BaseService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private rx.g.b f2311a;

    protected abstract void d();

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        d();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    protected com.fotoable.youtube.music.c.a.b a() {
        return MusicApplication.c().e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public k b() {
        return com.fotoable.youtube.music.c.a.g.a().a(a()).a(c()).a();
    }

    protected ac c() {
        return new ac(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(m mVar) {
        if (this.f2311a == null) {
            this.f2311a = new rx.g.b();
        }
        this.f2311a.a(mVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        if (this.f2311a != null && !this.f2311a.isUnsubscribed()) {
            this.f2311a.unsubscribe();
            this.f2311a = null;
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        try {
            e();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }
}

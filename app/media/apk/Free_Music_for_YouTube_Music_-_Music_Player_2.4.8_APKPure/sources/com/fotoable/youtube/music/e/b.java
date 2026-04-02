package com.fotoable.youtube.music.e;

import com.fotoable.youtube.music.util.s;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import rx.f;
import rx.f.c;
import rx.f.d;
import rx.m;
/* compiled from: RxBus.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f2729a;

    /* renamed from: b  reason: collision with root package name */
    private final d f2730b = new c(rx.f.b.e());

    private b() {
    }

    public static b a() {
        b bVar = f2729a;
        if (f2729a == null) {
            synchronized (b.class) {
                bVar = f2729a;
                if (f2729a == null) {
                    bVar = new b();
                    f2729a = bVar;
                }
            }
        }
        return bVar;
    }

    public void a(Object obj) {
        this.f2730b.onNext(obj);
    }

    public <T> f a(Class<T> cls) {
        return this.f2730b.b(cls);
    }

    public <T> m a(Class<T> cls, rx.c.b<T> bVar) {
        return this.f2730b.b(cls).a((f.c<? super R, ? extends R>) s.a()).a(bVar, new rx.c.b<Throwable>() { // from class: com.fotoable.youtube.music.e.b.1
            @Override // rx.c.b
            /* renamed from: a */
            public void call(Throwable th) {
                if (th != null) {
                    ThrowableExtension.printStackTrace(th);
                }
            }
        });
    }
}

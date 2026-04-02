package com.fotoable.youtube.music.b.c;

import com.fotoable.youtube.music.util.s;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import rx.l;
/* compiled from: LastFmClient.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f2291a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static a f2292b;

    /* renamed from: c  reason: collision with root package name */
    private b f2293c;

    public static a a() {
        a aVar;
        synchronized (f2291a) {
            if (f2292b == null) {
                f2292b = new a();
                f2292b.f2293c = (b) c.a("http://ws.audioscrobbler.com/2.0/", b.class);
            }
            aVar = f2292b;
        }
        return aVar;
    }

    public void a(com.fotoable.youtube.music.b.c.b.b bVar, final com.fotoable.youtube.music.b.c.a.a aVar) {
        this.f2293c.a(bVar.f2297a).a(s.a()).b(new l<com.fotoable.youtube.music.b.c.b.a>() { // from class: com.fotoable.youtube.music.b.c.a.1
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                aVar.a();
                ThrowableExtension.printStackTrace(th);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(com.fotoable.youtube.music.b.c.b.a aVar2) {
                if (aVar2 != null) {
                    aVar.a(aVar2.f2296a);
                }
            }
        });
    }
}

package com.fotoable.youtube.music.d;

import com.fotoable.youtube.music.bean.GlobalRankBean;
import com.fotoable.youtube.music.d.a.g;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import javax.inject.Inject;
import rx.f;
/* compiled from: GlobalMusicPresenter.java */
/* loaded from: classes.dex */
public class w extends aq<g.a> {

    /* renamed from: a  reason: collision with root package name */
    com.fotoable.youtube.music.b.c f2592a;

    /* renamed from: b  reason: collision with root package name */
    private g.a f2593b;

    @Inject
    public w(com.fotoable.youtube.music.b.c cVar) {
        this.f2592a = cVar;
        c();
    }

    private void c() {
        b(com.fotoable.youtube.music.e.b.a().a(com.fotoable.youtube.music.e.a.class).a(rx.a.b.a.a()).a(x.f2596a, new rx.c.b<Throwable>() { // from class: com.fotoable.youtube.music.d.w.1
            @Override // rx.c.b
            /* renamed from: a */
            public void call(Throwable th) {
                ThrowableExtension.printStackTrace(th);
            }
        }));
    }

    public void a() {
        this.f2593b.e_(true);
        b(this.f2592a.d().a(com.fotoable.youtube.music.util.s.a()).a((f.c<? super R, ? extends R>) com.fotoable.youtube.music.util.s.b()).b(new rx.l<ArrayList<GlobalRankBean>>() { // from class: com.fotoable.youtube.music.d.w.2
            @Override // rx.g
            public void onCompleted() {
                w.this.f2593b.e_(false);
            }

            @Override // rx.g
            public void onError(Throwable th) {
                w.this.f2593b.a(null);
                w.this.f2593b.e_(false);
                ThrowableExtension.printStackTrace(th);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(ArrayList<GlobalRankBean> arrayList) {
                w.this.f2593b.a(arrayList);
            }
        }));
    }

    public void a(g.a aVar) {
        this.f2593b = aVar;
    }

    public void b() {
        b_();
        this.f2593b = null;
    }
}

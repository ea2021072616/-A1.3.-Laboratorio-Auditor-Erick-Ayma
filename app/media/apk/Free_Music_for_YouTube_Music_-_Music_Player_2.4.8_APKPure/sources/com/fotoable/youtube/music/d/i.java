package com.fotoable.youtube.music.d;

import com.fotoable.youtube.music.bean.ClassifiedRankBean;
import com.fotoable.youtube.music.d.a.b;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import javax.inject.Inject;
import rx.f;
/* compiled from: ClassifiedMusicPresenter.java */
/* loaded from: classes.dex */
public class i extends aq<b.a> {

    /* renamed from: a  reason: collision with root package name */
    com.fotoable.youtube.music.b.c f2549a;

    /* renamed from: b  reason: collision with root package name */
    private b.a f2550b;
    private boolean d = false;

    @Inject
    public i(com.fotoable.youtube.music.b.c cVar) {
        this.f2549a = cVar;
        c();
    }

    private void c() {
        b(com.fotoable.youtube.music.e.b.a().a(com.fotoable.youtube.music.e.a.class).a(rx.a.b.a.a()).a(j.f2553a, new rx.c.b<Throwable>() { // from class: com.fotoable.youtube.music.d.i.1
            @Override // rx.c.b
            /* renamed from: a */
            public void call(Throwable th) {
                ThrowableExtension.printStackTrace(th);
            }
        }));
    }

    public void a(b.a aVar) {
        this.f2550b = aVar;
    }

    public void a() {
        b_();
        this.f2550b = null;
    }

    public void b() {
        this.f2550b.b_(true);
        b(this.f2549a.e().a(com.fotoable.youtube.music.util.s.a()).a((f.c<? super R, ? extends R>) com.fotoable.youtube.music.util.s.b()).b(new rx.l<ArrayList<ClassifiedRankBean>>() { // from class: com.fotoable.youtube.music.d.i.2
            @Override // rx.g
            public void onCompleted() {
                i.this.f2550b.b_(false);
            }

            @Override // rx.g
            public void onError(Throwable th) {
                i.this.f2550b.a(null);
                i.this.f2550b.b_(false);
                ThrowableExtension.printStackTrace(th);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(ArrayList<ClassifiedRankBean> arrayList) {
                i.this.f2550b.a(arrayList);
            }
        }));
    }
}

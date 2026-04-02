package com.fotoable.youtube.music.d;

import com.fotoable.youtube.music.bean.RadioCountryBean;
import com.fotoable.youtube.music.d.a.e;
import java.util.List;
import rx.f;
/* compiled from: CountryPresenter.java */
/* loaded from: classes.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private rx.g.b f2566a;

    /* renamed from: b  reason: collision with root package name */
    private e.a f2567b;

    /* renamed from: c  reason: collision with root package name */
    private com.fotoable.youtube.music.b.c f2568c;

    public o(e.a aVar, com.fotoable.youtube.music.b.c cVar) {
        this.f2567b = aVar;
        this.f2568c = cVar;
    }

    public void a() {
        a(this.f2568c.m().a(com.fotoable.youtube.music.util.s.a()).a((f.c<? super R, ? extends R>) com.fotoable.youtube.music.util.s.b()).a((rx.g) new rx.g<List<RadioCountryBean>>() { // from class: com.fotoable.youtube.music.d.o.1
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(List<RadioCountryBean> list) {
                o.this.f2567b.a(list);
            }
        }));
    }

    public void a(rx.m mVar) {
        if (this.f2566a == null) {
            this.f2566a = new rx.g.b();
        }
        this.f2566a.a(mVar);
    }
}

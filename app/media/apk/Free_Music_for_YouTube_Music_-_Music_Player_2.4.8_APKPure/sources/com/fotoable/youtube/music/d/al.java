package com.fotoable.youtube.music.d;

import com.fotoable.youtube.music.bean.SubBean;
import com.fotoable.youtube.music.d.a.m;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
/* compiled from: MySubscriptionPresenter.java */
/* loaded from: classes.dex */
public class al extends aq<m.a> {

    /* renamed from: a  reason: collision with root package name */
    com.fotoable.youtube.music.db.a f2489a;

    /* renamed from: b  reason: collision with root package name */
    private m.a f2490b;

    @Inject
    public al(com.fotoable.youtube.music.db.a aVar) {
        this.f2489a = aVar;
        c();
    }

    private void c() {
        b(com.fotoable.youtube.music.e.b.a().a(com.fotoable.youtube.music.e.a.class).a(rx.a.b.a.a()).a(new rx.c.b(this) { // from class: com.fotoable.youtube.music.d.am

            /* renamed from: a  reason: collision with root package name */
            private final al f2494a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2494a = this;
            }

            @Override // rx.c.b
            public void call(Object obj) {
                this.f2494a.a(obj);
            }
        }, new rx.c.b<Throwable>() { // from class: com.fotoable.youtube.music.d.al.1
            @Override // rx.c.b
            /* renamed from: a */
            public void call(Throwable th) {
                ThrowableExtension.printStackTrace(th);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(Object obj) {
        com.fotoable.youtube.music.e.a aVar = (com.fotoable.youtube.music.e.a) obj;
        switch (aVar.f2726a) {
            case 1002:
                SubBean subBean = (SubBean) aVar.f2727b;
                if (subBean != null) {
                    a(subBean.getPlaylistid());
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void a() {
        this.f2490b.a(true);
        b(this.f2489a.a().a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<List<SubBean>>() { // from class: com.fotoable.youtube.music.d.al.2
            @Override // rx.g
            public void onCompleted() {
                al.this.f2490b.a(false);
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
                al.this.f2490b.a((List<SubBean>) null);
                al.this.f2490b.a(false);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(List<SubBean> list) {
                if (list != null && list.size() > 0) {
                    Collections.reverse(list);
                }
                al.this.f2490b.a(list);
            }
        }));
    }

    public void a(String str) {
        b(this.f2489a.a(str).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.d.al.3
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(Boolean bool) {
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2010));
                al.this.f2490b.b(bool.booleanValue());
            }
        }));
    }

    public void a(m.a aVar) {
        this.f2490b = aVar;
    }

    public void b() {
        b_();
        this.f2490b = null;
    }
}

package com.fotoable.youtube.music.d;

import android.support.v4.view.PointerIconCompat;
import com.fotoable.youtube.music.bean.FavBean;
import com.fotoable.youtube.music.d.a.k;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
/* compiled from: MyFavoritePresenter.java */
/* loaded from: classes.dex */
public class ad extends aq<k.a> {

    /* renamed from: b  reason: collision with root package name */
    private static final String f2465b = ad.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    com.fotoable.youtube.music.db.a f2466a;
    private k.a d;

    @Inject
    public ad(com.fotoable.youtube.music.db.a aVar) {
        this.f2466a = aVar;
        d();
    }

    private void d() {
        b(com.fotoable.youtube.music.e.b.a().a(com.fotoable.youtube.music.e.a.class).a(rx.a.b.a.a()).a(new rx.c.b(this) { // from class: com.fotoable.youtube.music.d.ae

            /* renamed from: a  reason: collision with root package name */
            private final ad f2471a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2471a = this;
            }

            @Override // rx.c.b
            public void call(Object obj) {
                this.f2471a.a(obj);
            }
        }, new rx.c.b<Throwable>() { // from class: com.fotoable.youtube.music.d.ad.1
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
            case 1005:
                FavBean favBean = (FavBean) aVar.f2727b;
                if (favBean != null) {
                    a(favBean);
                    return;
                }
                return;
            case PointerIconCompat.TYPE_NO_DROP /* 1012 */:
                this.d.b((String) aVar.f2727b);
                return;
            case PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW /* 1014 */:
                this.d.b("");
                return;
            case 1031:
                if (this.d != null) {
                    if (aVar.e) {
                        a();
                        com.fotoable.youtube.music.util.h.a(f2465b, "重新查询数据");
                        return;
                    }
                    this.d.a(aVar.f2728c);
                    com.fotoable.youtube.music.util.h.a(f2465b, "删除指定数据：" + aVar.f2728c);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void a() {
        this.d.a(true);
        b(this.f2466a.c().a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<List<FavBean>>() { // from class: com.fotoable.youtube.music.d.ad.2
            @Override // rx.g
            public void onCompleted() {
                ad.this.d.a(false);
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
                ad.this.d.a((List<FavBean>) null);
                ad.this.d.a(false);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(List<FavBean> list) {
                if (list != null && list.size() > 0) {
                    Collections.reverse(list);
                }
                ad.this.d.a(list);
            }
        }));
    }

    public void a(FavBean favBean) {
        b(this.f2466a.c(favBean.getVideoid()).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.d.ad.3
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
                ad.this.d.a(bool);
            }
        }));
    }

    public void b() {
        b(this.f2466a.b().a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.d.ad.4
            @Override // rx.g
            public void onCompleted() {
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(1024));
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(Boolean bool) {
                ad.this.d.i_();
            }
        }));
    }

    public void a(k.a aVar) {
        this.d = aVar;
    }

    public void c() {
        b_();
        this.d = null;
    }
}

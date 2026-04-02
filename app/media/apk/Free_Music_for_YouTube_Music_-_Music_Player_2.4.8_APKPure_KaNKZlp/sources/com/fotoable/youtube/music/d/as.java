package com.fotoable.youtube.music.d;

import android.support.v4.view.PointerIconCompat;
import com.fotoable.youtube.music.bean.FavBean;
import com.fotoable.youtube.music.bean.GlobalRankVideoBean;
import com.fotoable.youtube.music.bean.MyHttpResponse;
import com.fotoable.youtube.music.bean.RecentlyWatchBean;
import com.fotoable.youtube.music.d.a.q;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import javax.inject.Inject;
/* compiled from: Top100Presenter.java */
/* loaded from: classes.dex */
public class as extends aq<q.a> {

    /* renamed from: a  reason: collision with root package name */
    private q.a f2518a;

    /* renamed from: b  reason: collision with root package name */
    private com.fotoable.youtube.music.b.c f2519b;
    private com.fotoable.youtube.music.db.a d;
    private boolean e = false;
    private int f = 0;
    private int g = 50;
    private long h = 0;
    private boolean i = false;

    @Inject
    public as(com.fotoable.youtube.music.b.c cVar, com.fotoable.youtube.music.db.a aVar) {
        this.f2519b = cVar;
        this.d = aVar;
        f();
    }

    private void f() {
        b(com.fotoable.youtube.music.e.b.a().a(com.fotoable.youtube.music.e.a.class).a(rx.a.b.a.a()).a(new rx.c.b(this) { // from class: com.fotoable.youtube.music.d.at

            /* renamed from: a  reason: collision with root package name */
            private final as f2525a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2525a = this;
            }

            @Override // rx.c.b
            public void call(Object obj) {
                this.f2525a.a(obj);
            }
        }, new rx.c.b<Throwable>() { // from class: com.fotoable.youtube.music.d.as.1
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
            case PointerIconCompat.TYPE_NO_DROP /* 1012 */:
                String str = (String) aVar.f2727b;
                if (this.f2518a != null) {
                    this.f2518a.a(str);
                    return;
                }
                return;
            case PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW /* 1014 */:
                if (this.f2518a != null) {
                    this.f2518a.a("");
                    return;
                }
                return;
            case 1027:
                a(true, (FavBean) aVar.f2727b);
                return;
            case 1028:
                a(false, (FavBean) aVar.f2727b);
                return;
            case 1031:
                if (this.f2518a != null) {
                    this.f2518a.a(aVar.f2728c, aVar.e);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void b() {
        if (!this.i) {
            this.i = true;
            b(this.f2519b.b(this.f, this.g, this.h).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<MyHttpResponse<ArrayList<GlobalRankVideoBean>>>() { // from class: com.fotoable.youtube.music.d.as.2
                @Override // rx.g
                public void onCompleted() {
                    as.this.i = false;
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                    if (as.this.f2518a != null) {
                        as.this.f2518a.c();
                    }
                    as.this.i = false;
                }

                private void a() {
                    as.this.e = false;
                    if (as.this.f2518a != null) {
                        as.this.f2518a.b();
                        as.this.f2518a.c();
                    }
                    as.this.i = false;
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(MyHttpResponse<ArrayList<GlobalRankVideoBean>> myHttpResponse) {
                    if (myHttpResponse != null && myHttpResponse.getData() != null && myHttpResponse.getData().size() != 0) {
                        as.this.e = true;
                        as.this.f += as.this.g;
                        as.this.h = myHttpResponse.getMeta().getMixid();
                        if (as.this.f2518a != null) {
                            as.this.f2518a.a(myHttpResponse.getData());
                            return;
                        }
                        return;
                    }
                    a();
                }
            }));
        }
    }

    public void a(boolean z, FavBean favBean) {
        rx.m b2;
        if (z) {
            b2 = this.d.a(favBean).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.d.as.3
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
                }
            });
        } else {
            b2 = this.d.b(favBean).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.d.as.4
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
                }
            });
        }
        b(b2);
        a(favBean);
    }

    public void a(FavBean favBean) {
        RecentlyWatchBean recentlyWatchBean = new RecentlyWatchBean();
        recentlyWatchBean.setIsFav(favBean.getIsFav());
        recentlyWatchBean.setDesc(favBean.getDesc());
        recentlyWatchBean.setImgUrl(favBean.getImgUrl());
        recentlyWatchBean.setVideoid(favBean.getVideoid());
        recentlyWatchBean.setTitle(favBean.getTitle());
        recentlyWatchBean.setDuration(favBean.getDuration());
        recentlyWatchBean.setArtists(favBean.getArtists());
        b(this.d.b(recentlyWatchBean).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.d.as.5
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
            }
        }));
    }

    public void c() {
        this.h = 0L;
        this.f = 0;
        this.e = true;
    }

    public void a(q.a aVar) {
        this.f2518a = aVar;
    }

    public void d() {
        b_();
        this.f2518a = null;
    }

    public boolean e() {
        return this.e;
    }
}

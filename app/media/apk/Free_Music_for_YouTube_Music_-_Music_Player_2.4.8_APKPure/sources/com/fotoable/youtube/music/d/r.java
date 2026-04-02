package com.fotoable.youtube.music.d;

import android.support.v4.view.PointerIconCompat;
import com.fotoable.youtube.music.bean.FavBean;
import com.fotoable.youtube.music.bean.GlobalRankVideoBean;
import com.fotoable.youtube.music.bean.MyHttpResponse;
import com.fotoable.youtube.music.bean.RecentlyWatchBean;
import com.fotoable.youtube.music.d.a.h;
import com.fotoable.youtube.music.d.r;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import java.util.Map;
import javax.inject.Inject;
import rx.f;
/* compiled from: GlobalMusicDetailsPresenter.java */
/* loaded from: classes.dex */
public class r extends aq<h.a> {

    /* renamed from: a  reason: collision with root package name */
    com.fotoable.youtube.music.b.c f2576a;

    /* renamed from: b  reason: collision with root package name */
    com.fotoable.youtube.music.db.a f2577b;
    private h.a d;
    private boolean e = false;
    private int f = 0;
    private int g = 15;
    private long h = 0;
    private boolean i = false;

    @Inject
    public r(com.fotoable.youtube.music.b.c cVar, com.fotoable.youtube.music.db.a aVar) {
        this.f2576a = cVar;
        this.f2577b = aVar;
        e();
    }

    private void e() {
        b(com.fotoable.youtube.music.e.b.a().a(com.fotoable.youtube.music.e.a.class).a(rx.a.b.a.a()).a(new rx.c.b(this) { // from class: com.fotoable.youtube.music.d.s

            /* renamed from: a  reason: collision with root package name */
            private final r f2586a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2586a = this;
            }

            @Override // rx.c.b
            public void call(Object obj) {
                this.f2586a.a(obj);
            }
        }, new rx.c.b<Throwable>() { // from class: com.fotoable.youtube.music.d.r.1
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
                if (this.d != null) {
                    this.d.a(str);
                    return;
                }
                return;
            case PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW /* 1014 */:
                if (this.d != null) {
                    this.d.a("");
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
                if (this.d != null) {
                    this.d.a(aVar.f2728c, aVar.e);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void a() {
    }

    public void a(int i) {
        if (!this.i) {
            this.i = true;
            b(this.f2576a.a(this.f, this.g, this.h, i).b(new AnonymousClass3()).a((f.c<? super R, ? extends R>) com.fotoable.youtube.music.util.s.a()).b(new rx.l<MyHttpResponse<ArrayList<GlobalRankVideoBean>>>() { // from class: com.fotoable.youtube.music.d.r.2
                @Override // rx.g
                public void onCompleted() {
                    r.this.i = false;
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                    r.this.e = false;
                    if (r.this.d != null) {
                        r.this.d.f_();
                        r.this.d.e_();
                    }
                    r.this.i = false;
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(MyHttpResponse<ArrayList<GlobalRankVideoBean>> myHttpResponse) {
                    if (myHttpResponse != null && myHttpResponse.getData() != null && myHttpResponse.getData().size() != 0) {
                        r.this.e = true;
                        r.this.f += r.this.g;
                        r.this.h = myHttpResponse.getMeta().getMixid();
                        if (r.this.d != null) {
                            r.this.d.a(myHttpResponse.getData());
                            return;
                        }
                        return;
                    }
                    onError(new Throwable());
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GlobalMusicDetailsPresenter.java */
    /* renamed from: com.fotoable.youtube.music.d.r$3  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass3 implements rx.c.e<MyHttpResponse<ArrayList<GlobalRankVideoBean>>, rx.f<MyHttpResponse<ArrayList<GlobalRankVideoBean>>>> {
        AnonymousClass3() {
        }

        @Override // rx.c.e
        public rx.f<MyHttpResponse<ArrayList<GlobalRankVideoBean>>> a(final MyHttpResponse<ArrayList<GlobalRankVideoBean>> myHttpResponse) {
            if (myHttpResponse == null || myHttpResponse.getData() == null) {
                return rx.f.a(new f.a(myHttpResponse) { // from class: com.fotoable.youtube.music.d.t

                    /* renamed from: a  reason: collision with root package name */
                    private final MyHttpResponse f2587a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f2587a = myHttpResponse;
                    }

                    @Override // rx.c.b
                    public void call(Object obj) {
                        r.AnonymousClass3.a(this.f2587a, (rx.l) obj);
                    }
                });
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < myHttpResponse.getData().size()) {
                    arrayList.add(myHttpResponse.getData().get(i2).getVideoid() + "");
                    i = i2 + 1;
                } else {
                    return r.this.f2577b.b(arrayList).b(new AnonymousClass1(myHttpResponse));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: GlobalMusicDetailsPresenter.java */
        /* renamed from: com.fotoable.youtube.music.d.r$3$1  reason: invalid class name */
        /* loaded from: classes.dex */
        public class AnonymousClass1 implements rx.c.e<Map<String, Integer>, rx.f<MyHttpResponse<ArrayList<GlobalRankVideoBean>>>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ MyHttpResponse f2581a;

            AnonymousClass1(MyHttpResponse myHttpResponse) {
                this.f2581a = myHttpResponse;
            }

            @Override // rx.c.e
            public rx.f<MyHttpResponse<ArrayList<GlobalRankVideoBean>>> a(Map<String, Integer> map) {
                if (map != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= ((ArrayList) this.f2581a.getData()).size()) {
                            break;
                        }
                        Integer num = map.get(((GlobalRankVideoBean) ((ArrayList) this.f2581a.getData()).get(i2)).getVideoid());
                        if (num != null) {
                            ((GlobalRankVideoBean) ((ArrayList) this.f2581a.getData()).get(i2)).setIsFav(num.intValue());
                        }
                        i = i2 + 1;
                    }
                }
                final MyHttpResponse myHttpResponse = this.f2581a;
                return rx.f.a(new f.a(myHttpResponse) { // from class: com.fotoable.youtube.music.d.u

                    /* renamed from: a  reason: collision with root package name */
                    private final MyHttpResponse f2588a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f2588a = myHttpResponse;
                    }

                    @Override // rx.c.b
                    public void call(Object obj) {
                        r.AnonymousClass3.AnonymousClass1.a(this.f2588a, (rx.l) obj);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public static final /* synthetic */ void a(MyHttpResponse myHttpResponse, rx.l lVar) {
                if (lVar != null && !lVar.isUnsubscribed()) {
                    lVar.onNext(myHttpResponse);
                    lVar.onCompleted();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final /* synthetic */ void a(MyHttpResponse myHttpResponse, rx.l lVar) {
            if (lVar != null && !lVar.isUnsubscribed()) {
                lVar.onNext(myHttpResponse);
                lVar.onCompleted();
            }
        }
    }

    public void a(boolean z, FavBean favBean) {
        rx.m b2;
        if (z) {
            b2 = this.f2577b.a(favBean).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.d.r.4
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
            b2 = this.f2577b.b(favBean).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.d.r.5
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
        b(this.f2577b.b(recentlyWatchBean).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.d.r.6
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

    public void b() {
        this.h = 0L;
        this.f = 0;
        this.e = true;
    }

    public void a(h.a aVar) {
        this.d = aVar;
    }

    public void c() {
        b_();
        this.d = null;
    }

    public boolean d() {
        return this.e;
    }
}

package com.fotoable.youtube.music.d;

import android.support.v4.view.PointerIconCompat;
import com.fotoable.youtube.music.bean.ClassifiedRankVideoBean;
import com.fotoable.youtube.music.bean.FavBean;
import com.fotoable.youtube.music.bean.MyHttpResponse;
import com.fotoable.youtube.music.bean.RecentlyWatchBean;
import com.fotoable.youtube.music.d.a.c;
import com.fotoable.youtube.music.d.d;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import java.util.Map;
import javax.inject.Inject;
import rx.f;
/* compiled from: ClassifiedMusicDetailsPresenter.java */
/* loaded from: classes.dex */
public class d extends aq<c.a> {

    /* renamed from: a  reason: collision with root package name */
    com.fotoable.youtube.music.b.c f2533a;

    /* renamed from: b  reason: collision with root package name */
    com.fotoable.youtube.music.db.a f2534b;
    private c.a d;
    private boolean e = false;
    private int f = 0;
    private int g = 15;
    private long h = 0;
    private boolean i = false;

    @Inject
    public d(com.fotoable.youtube.music.b.c cVar, com.fotoable.youtube.music.db.a aVar) {
        this.f2533a = cVar;
        this.f2534b = aVar;
        e();
    }

    private void e() {
        b(com.fotoable.youtube.music.e.b.a().a(com.fotoable.youtube.music.e.a.class).a(rx.a.b.a.a()).a(new rx.c.b(this) { // from class: com.fotoable.youtube.music.d.e

            /* renamed from: a  reason: collision with root package name */
            private final d f2543a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2543a = this;
            }

            @Override // rx.c.b
            public void call(Object obj) {
                this.f2543a.a(obj);
            }
        }, new rx.c.b<Throwable>() { // from class: com.fotoable.youtube.music.d.d.1
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
            case 1029:
                a(true, (FavBean) aVar.f2727b);
                return;
            case 1030:
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
            b(this.f2533a.b(this.f, this.g, this.h, i).b(new AnonymousClass3()).a((f.c<? super R, ? extends R>) com.fotoable.youtube.music.util.s.a()).b(new rx.l<MyHttpResponse<ArrayList<ClassifiedRankVideoBean>>>() { // from class: com.fotoable.youtube.music.d.d.2
                @Override // rx.g
                public void onCompleted() {
                    d.this.i = false;
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                    d.this.e = false;
                    d.this.d.d_();
                    d.this.d.c_();
                    d.this.i = false;
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(MyHttpResponse<ArrayList<ClassifiedRankVideoBean>> myHttpResponse) {
                    if (myHttpResponse != null && myHttpResponse.getData() != null && myHttpResponse.getData().size() != 0) {
                        d.this.e = true;
                        d.this.f += d.this.g;
                        d.this.h = myHttpResponse.getMeta().getMixid();
                        d.this.d.a(myHttpResponse.getData());
                        return;
                    }
                    onError(new Throwable());
                }
            }));
        }
    }

    /* compiled from: ClassifiedMusicDetailsPresenter.java */
    /* renamed from: com.fotoable.youtube.music.d.d$3  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 implements rx.c.e<MyHttpResponse<ArrayList<ClassifiedRankVideoBean>>, rx.f<MyHttpResponse<ArrayList<ClassifiedRankVideoBean>>>> {
        AnonymousClass3() {
        }

        @Override // rx.c.e
        public rx.f<MyHttpResponse<ArrayList<ClassifiedRankVideoBean>>> a(final MyHttpResponse<ArrayList<ClassifiedRankVideoBean>> myHttpResponse) {
            if (myHttpResponse == null || myHttpResponse.getData() == null) {
                return rx.f.a(new f.a(myHttpResponse) { // from class: com.fotoable.youtube.music.d.f

                    /* renamed from: a  reason: collision with root package name */
                    private final MyHttpResponse f2544a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f2544a = myHttpResponse;
                    }

                    @Override // rx.c.b
                    public void call(Object obj) {
                        d.AnonymousClass3.a(this.f2544a, (rx.l) obj);
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
                    return d.this.f2534b.b(arrayList).b(new AnonymousClass1(myHttpResponse));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ClassifiedMusicDetailsPresenter.java */
        /* renamed from: com.fotoable.youtube.music.d.d$3$1  reason: invalid class name */
        /* loaded from: classes.dex */
        public class AnonymousClass1 implements rx.c.e<Map<String, Integer>, rx.f<MyHttpResponse<ArrayList<ClassifiedRankVideoBean>>>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ MyHttpResponse f2538a;

            AnonymousClass1(MyHttpResponse myHttpResponse) {
                this.f2538a = myHttpResponse;
            }

            @Override // rx.c.e
            public rx.f<MyHttpResponse<ArrayList<ClassifiedRankVideoBean>>> a(Map<String, Integer> map) {
                if (map != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= ((ArrayList) this.f2538a.getData()).size()) {
                            break;
                        }
                        Integer num = map.get(((ClassifiedRankVideoBean) ((ArrayList) this.f2538a.getData()).get(i2)).getVideoid());
                        if (num != null) {
                            ((ClassifiedRankVideoBean) ((ArrayList) this.f2538a.getData()).get(i2)).setIsFav(num.intValue());
                        }
                        i = i2 + 1;
                    }
                }
                final MyHttpResponse myHttpResponse = this.f2538a;
                return rx.f.a(new f.a(myHttpResponse) { // from class: com.fotoable.youtube.music.d.g

                    /* renamed from: a  reason: collision with root package name */
                    private final MyHttpResponse f2545a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f2545a = myHttpResponse;
                    }

                    @Override // rx.c.b
                    public void call(Object obj) {
                        d.AnonymousClass3.AnonymousClass1.a(this.f2545a, (rx.l) obj);
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
            b2 = this.f2534b.a(favBean).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.d.d.4
                @Override // rx.g
                public void onCompleted() {
                }

                @Override // rx.g
                public void onError(Throwable th) {
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(Boolean bool) {
                }
            });
        } else {
            b2 = this.f2534b.b(favBean).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.d.d.5
                @Override // rx.g
                public void onCompleted() {
                }

                @Override // rx.g
                public void onError(Throwable th) {
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
        b(this.f2534b.b(recentlyWatchBean).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.d.d.6
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

    public void a(c.a aVar) {
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

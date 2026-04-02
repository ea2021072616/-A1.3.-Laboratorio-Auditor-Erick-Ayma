package com.fotoable.youtube.music.d;

import android.support.v4.view.PointerIconCompat;
import com.fotoable.youtube.music.bean.FavBean;
import com.fotoable.youtube.music.bean.RecentlyWatchBean;
import com.fotoable.youtube.music.d.a.l;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import rx.f;
/* compiled from: MyRecentlyWatchedPresenter.java */
/* loaded from: classes.dex */
public class ag extends aq<l.a> {

    /* renamed from: a  reason: collision with root package name */
    private l.a f2475a;

    /* renamed from: b  reason: collision with root package name */
    private com.fotoable.youtube.music.db.a f2476b;

    @Inject
    public ag(com.fotoable.youtube.music.db.a aVar) {
        this.f2476b = aVar;
        d();
    }

    private void d() {
        b(com.fotoable.youtube.music.e.b.a().a(com.fotoable.youtube.music.e.a.class).a(rx.a.b.a.a()).a(new rx.c.b(this) { // from class: com.fotoable.youtube.music.d.ah

            /* renamed from: a  reason: collision with root package name */
            private final ag f2483a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2483a = this;
            }

            @Override // rx.c.b
            public void call(Object obj) {
                this.f2483a.a(obj);
            }
        }, new rx.c.b<Throwable>() { // from class: com.fotoable.youtube.music.d.ag.1
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
            case PointerIconCompat.TYPE_CELL /* 1006 */:
                a(true, (FavBean) aVar.f2727b);
                return;
            case PointerIconCompat.TYPE_CROSSHAIR /* 1007 */:
                a(false, (FavBean) aVar.f2727b);
                return;
            case PointerIconCompat.TYPE_VERTICAL_TEXT /* 1009 */:
                RecentlyWatchBean recentlyWatchBean = (RecentlyWatchBean) aVar.f2727b;
                if (recentlyWatchBean != null) {
                    a(recentlyWatchBean.getVideoid());
                    return;
                }
                return;
            case PointerIconCompat.TYPE_NO_DROP /* 1012 */:
                boolean a2 = this.f2475a.a((String) aVar.f2727b);
                if (this.f2475a != null && !a2) {
                    a();
                    return;
                }
                return;
            case PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW /* 1014 */:
                this.f2475a.a("");
                return;
            case 1031:
                if (this.f2475a != null) {
                    this.f2475a.a(aVar.f2728c, aVar.e);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void a() {
        this.f2475a.a(true);
        b(this.f2476b.f().b(new rx.c.e(this) { // from class: com.fotoable.youtube.music.d.ai

            /* renamed from: a  reason: collision with root package name */
            private final ag f2484a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2484a = this;
            }

            @Override // rx.c.e
            public Object a(Object obj) {
                return this.f2484a.a((List) obj);
            }
        }).a((f.c<? super R, ? extends R>) com.fotoable.youtube.music.util.s.a()).b(new rx.l<List<RecentlyWatchBean>>() { // from class: com.fotoable.youtube.music.d.ag.2
            @Override // rx.g
            public void onCompleted() {
                ag.this.f2475a.a(false);
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ag.this.f2475a.a((List<RecentlyWatchBean>) null);
                ag.this.f2475a.a(false);
                ThrowableExtension.printStackTrace(th);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(List<RecentlyWatchBean> list) {
                if (list != null && list.size() > 0) {
                    Collections.reverse(list);
                }
                ag.this.f2475a.a(list);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ rx.f a(final List list) {
        return (list == null || list.size() <= 0) ? rx.f.a(new f.a(list) { // from class: com.fotoable.youtube.music.d.aj

            /* renamed from: a  reason: collision with root package name */
            private final List f2485a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2485a = list;
            }

            @Override // rx.c.b
            public void call(Object obj) {
                ag.a(this.f2485a, (rx.l) obj);
            }
        }) : this.f2476b.a(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(List list, rx.l lVar) {
        if (lVar != null && !lVar.isUnsubscribed()) {
            lVar.onNext(list);
            lVar.onCompleted();
        }
    }

    public void a(String str) {
        b(this.f2476b.e(str).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.d.ag.3
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
                ag.this.f2475a.a(bool);
            }
        }));
    }

    public void a(boolean z, FavBean favBean) {
        rx.m b2;
        if (z) {
            b2 = this.f2476b.a(favBean).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.d.ag.4
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
            b2 = this.f2476b.b(favBean).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.d.ag.5
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
    }

    public void b() {
        b(this.f2476b.e().a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.d.ag.6
            @Override // rx.g
            public void onCompleted() {
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(1046));
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(Boolean bool) {
                ag.this.f2475a.j_();
            }
        }));
    }

    public void a(l.a aVar) {
        this.f2475a = aVar;
    }

    public void c() {
        b_();
        this.f2475a = null;
    }
}

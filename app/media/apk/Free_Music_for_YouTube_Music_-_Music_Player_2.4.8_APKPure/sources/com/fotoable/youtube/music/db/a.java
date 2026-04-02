package com.fotoable.youtube.music.db;

import android.content.Context;
import android.text.TextUtils;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.bean.ArtistsCoverModel;
import com.fotoable.youtube.music.bean.DurationBean;
import com.fotoable.youtube.music.bean.FavBean;
import com.fotoable.youtube.music.bean.FeaturedDetailBean;
import com.fotoable.youtube.music.bean.LocalPlayListBean;
import com.fotoable.youtube.music.bean.LocalPlayListModel;
import com.fotoable.youtube.music.bean.LocalPlayListMusicModel;
import com.fotoable.youtube.music.bean.LocalRecentlyModel;
import com.fotoable.youtube.music.bean.LocalSongBean;
import com.fotoable.youtube.music.bean.MyHttpResponse;
import com.fotoable.youtube.music.bean.PlayListModel;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import com.fotoable.youtube.music.bean.RadioBean;
import com.fotoable.youtube.music.bean.RecentlyWatchBean;
import com.fotoable.youtube.music.bean.SubBean;
import com.fotoable.youtube.music.bean.YoutubeCommentLocalLikeModel;
import com.fotoable.youtube.music.db.greendao.gen.ArtistsCoverModelDao;
import com.fotoable.youtube.music.db.greendao.gen.DurationBeanDao;
import com.fotoable.youtube.music.db.greendao.gen.FavBeanDao;
import com.fotoable.youtube.music.db.greendao.gen.LocalPlayListModelDao;
import com.fotoable.youtube.music.db.greendao.gen.LocalPlayListMusicModelDao;
import com.fotoable.youtube.music.db.greendao.gen.LocalRecentlyModelDao;
import com.fotoable.youtube.music.db.greendao.gen.LocalSongBeanDao;
import com.fotoable.youtube.music.db.greendao.gen.PlayListModelDao;
import com.fotoable.youtube.music.db.greendao.gen.PlayMusicModelDao;
import com.fotoable.youtube.music.db.greendao.gen.RadioBeanDao;
import com.fotoable.youtube.music.db.greendao.gen.RecentlyWatchBeanDao;
import com.fotoable.youtube.music.db.greendao.gen.SubBeanDao;
import com.fotoable.youtube.music.db.greendao.gen.YoutubeCommentLocalLikeModelDao;
import com.fotoable.youtube.music.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;
import rx.f;
/* compiled from: GreenDAOHelper.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2610a = a.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private com.fotoable.youtube.music.db.greendao.gen.a f2611b;

    /* renamed from: c  reason: collision with root package name */
    private com.fotoable.youtube.music.db.greendao.gen.b f2612c;
    private SubBeanDao d;
    private FavBeanDao e;
    private RecentlyWatchBeanDao f;
    private DurationBeanDao g;
    private PlayListModelDao h;
    private PlayMusicModelDao i;
    private LocalSongBeanDao j;
    private RadioBeanDao k;
    private ArtistsCoverModelDao l;
    private LocalRecentlyModelDao m;
    private LocalPlayListModelDao n;
    private LocalPlayListMusicModelDao o;
    private YoutubeCommentLocalLikeModelDao p;

    public a(Context context) {
        this.f2611b = new com.fotoable.youtube.music.db.greendao.gen.a(new n(context, "youtubemusic-db", null).getWritableDatabase());
        this.f2612c = this.f2611b.newSession();
        this.d = this.f2612c.j();
        this.e = this.f2612c.c();
        this.f = this.f2612c.l();
        this.g = this.f2612c.h();
        this.h = this.f2612c.k();
        this.i = this.f2612c.i();
        this.j = this.f2612c.m();
        this.k = this.f2612c.e();
        this.l = this.f2612c.b();
        this.m = this.f2612c.d();
        this.n = this.f2612c.a();
        this.o = this.f2612c.g();
        this.p = this.f2612c.f();
    }

    public rx.f<Boolean> a(final SubBean subBean) {
        return rx.f.a((f.a) new f.a<Boolean>() { // from class: com.fotoable.youtube.music.db.a.1
            @Override // rx.c.b
            /* renamed from: a */
            public void call(rx.l<? super Boolean> lVar) {
                a.this.d.insertOrReplace(subBean);
                lVar.onNext(true);
                lVar.onCompleted();
            }
        });
    }

    public rx.f<Boolean> b(final SubBean subBean) {
        return rx.f.a((f.a) new f.a<Boolean>() { // from class: com.fotoable.youtube.music.db.a.19
            @Override // rx.c.b
            /* renamed from: a */
            public void call(rx.l<? super Boolean> lVar) {
                a.this.d.deleteByKey(subBean.getPlaylistid());
                lVar.onNext(true);
                lVar.onCompleted();
            }
        });
    }

    public rx.f<Boolean> a(final String str) {
        return rx.f.a((f.a) new f.a<Boolean>() { // from class: com.fotoable.youtube.music.db.a.27
            @Override // rx.c.b
            /* renamed from: a */
            public void call(rx.l<? super Boolean> lVar) {
                a.this.d.deleteByKey(str);
                lVar.onNext(true);
                lVar.onCompleted();
            }
        });
    }

    public rx.f<List<SubBean>> b(final String str) {
        return rx.f.a((f.a) new f.a<List<SubBean>>() { // from class: com.fotoable.youtube.music.db.a.28
            @Override // rx.c.b
            /* renamed from: a */
            public void call(rx.l<? super List<SubBean>> lVar) {
                lVar.onNext(a.this.d.queryBuilder().where(SubBeanDao.Properties.f2710b.eq(str), new WhereCondition[0]).list());
                lVar.onCompleted();
            }
        });
    }

    public rx.f<List<SubBean>> a() {
        return rx.f.a((f.a) new f.a<List<SubBean>>() { // from class: com.fotoable.youtube.music.db.a.29
            @Override // rx.c.b
            /* renamed from: a */
            public void call(rx.l<? super List<SubBean>> lVar) {
                lVar.onNext(a.this.d.queryBuilder().list());
                lVar.onCompleted();
            }
        });
    }

    public rx.f<Boolean> a(final FavBean favBean) {
        return rx.f.a((f.a) new f.a<Boolean>() { // from class: com.fotoable.youtube.music.db.a.31
            @Override // rx.c.b
            /* renamed from: a */
            public void call(rx.l<? super Boolean> lVar) {
                a.this.e.insertOrReplace(favBean);
                lVar.onNext(true);
                lVar.onCompleted();
                com.fotoable.youtube.music.util.h.a(a.f2610a, "addFav");
                v.b(MusicApplication.c(), "last_favorite_cover", favBean.getImgUrl());
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(1047));
            }
        }).a((rx.c.b) new rx.c.b<Boolean>() { // from class: com.fotoable.youtube.music.db.a.30
            @Override // rx.c.b
            /* renamed from: a */
            public void call(Boolean bool) {
                com.fotoable.youtube.music.newplayer.e.a().a(favBean.getVideoid(), true);
            }
        });
    }

    public rx.f<Boolean> b(final FavBean favBean) {
        return rx.f.a((f.a) new f.a<Boolean>() { // from class: com.fotoable.youtube.music.db.a.3
            @Override // rx.c.b
            /* renamed from: a */
            public void call(rx.l<? super Boolean> lVar) {
                a.this.e.delete(favBean);
                lVar.onNext(true);
                lVar.onCompleted();
            }
        }).a((rx.c.b) new rx.c.b<Boolean>() { // from class: com.fotoable.youtube.music.db.a.2
            @Override // rx.c.b
            /* renamed from: a */
            public void call(Boolean bool) {
                com.fotoable.youtube.music.newplayer.e.a().a(favBean.getVideoid(), false);
            }
        });
    }

    public rx.f<Boolean> c(final String str) {
        return rx.f.a((f.a) new f.a<Boolean>() { // from class: com.fotoable.youtube.music.db.a.5
            @Override // rx.c.b
            /* renamed from: a */
            public void call(rx.l<? super Boolean> lVar) {
                if (!TextUtils.isEmpty(str)) {
                    a.this.e.deleteByKey(str);
                    lVar.onNext(true);
                } else {
                    lVar.onNext(false);
                }
                lVar.onCompleted();
            }
        }).a((rx.c.b) new rx.c.b<Boolean>() { // from class: com.fotoable.youtube.music.db.a.4
            @Override // rx.c.b
            /* renamed from: a */
            public void call(Boolean bool) {
                com.fotoable.youtube.music.newplayer.e.a().a(str, false);
            }
        });
    }

    public rx.f<Boolean> b() {
        return rx.f.a((f.a) new f.a<Boolean>() { // from class: com.fotoable.youtube.music.db.a.6
            @Override // rx.c.b
            /* renamed from: a */
            public void call(rx.l<? super Boolean> lVar) {
                a.this.e.deleteAll();
                lVar.onNext(true);
                lVar.onCompleted();
            }
        });
    }

    public rx.f<List<FavBean>> d(final String str) {
        return rx.f.a((f.a) new f.a<List<FavBean>>() { // from class: com.fotoable.youtube.music.db.a.7
            @Override // rx.c.b
            /* renamed from: a */
            public void call(rx.l<? super List<FavBean>> lVar) {
                lVar.onNext(a.this.e.queryBuilder().where(FavBeanDao.Properties.f2682a.eq(str), new WhereCondition[0]).list());
                lVar.onCompleted();
            }
        });
    }

    public rx.f<List<FavBean>> c() {
        return rx.f.a((f.a) new f.a<List<FavBean>>() { // from class: com.fotoable.youtube.music.db.a.8
            @Override // rx.c.b
            /* renamed from: a */
            public void call(rx.l<? super List<FavBean>> lVar) {
                lVar.onNext(a.this.e.queryBuilder().list());
                lVar.onCompleted();
            }
        });
    }

    public long d() {
        return this.e.queryBuilder().count();
    }

    public rx.f<Boolean> a(final RecentlyWatchBean recentlyWatchBean) {
        return rx.f.a((f.a) new f.a<Boolean>() { // from class: com.fotoable.youtube.music.db.a.9
            @Override // rx.c.b
            /* renamed from: a */
            public void call(rx.l<? super Boolean> lVar) {
                a.this.f.insertOrReplace(recentlyWatchBean);
                lVar.onNext(true);
                lVar.onCompleted();
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(1046));
            }
        });
    }

    public rx.f<Boolean> b(final RecentlyWatchBean recentlyWatchBean) {
        return rx.f.a((f.a) new f.a<Boolean>() { // from class: com.fotoable.youtube.music.db.a.10
            @Override // rx.c.b
            /* renamed from: a */
            public void call(rx.l<? super Boolean> lVar) {
                a.this.f.update(recentlyWatchBean);
                lVar.onNext(true);
                lVar.onCompleted();
            }
        });
    }

    public rx.f<Boolean> e(final String str) {
        return rx.f.a((f.a) new f.a<Boolean>() { // from class: com.fotoable.youtube.music.db.a.11
            @Override // rx.c.b
            /* renamed from: a */
            public void call(rx.l<? super Boolean> lVar) {
                a.this.f.deleteByKey(str);
                lVar.onNext(true);
                lVar.onCompleted();
            }
        });
    }

    public rx.f<Boolean> e() {
        return rx.f.a((f.a) new f.a<Boolean>() { // from class: com.fotoable.youtube.music.db.a.12
            @Override // rx.c.b
            /* renamed from: a */
            public void call(rx.l<? super Boolean> lVar) {
                a.this.f.deleteAll();
                lVar.onNext(true);
                lVar.onCompleted();
            }
        });
    }

    public rx.f<List<RecentlyWatchBean>> f() {
        return rx.f.a((f.a) new f.a<List<RecentlyWatchBean>>() { // from class: com.fotoable.youtube.music.db.a.13
            @Override // rx.c.b
            /* renamed from: a */
            public void call(rx.l<? super List<RecentlyWatchBean>> lVar) {
                lVar.onNext(a.this.f.queryBuilder().list());
                lVar.onCompleted();
            }
        });
    }

    public rx.f<Long> g() {
        return rx.f.a(new f.a(this) { // from class: com.fotoable.youtube.music.db.b

            /* renamed from: a  reason: collision with root package name */
            private final a f2667a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2667a = this;
            }

            @Override // rx.c.b
            public void call(Object obj) {
                this.f2667a.b((rx.l) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b(rx.l lVar) {
        if (lVar != null && !lVar.isUnsubscribed()) {
            lVar.onNext(Long.valueOf(this.f.count()));
            lVar.onCompleted();
        }
    }

    public DurationBean f(String str) {
        return this.g.queryBuilder().where(DurationBeanDao.Properties.f2680a.eq(str), new WhereCondition[0]).unique();
    }

    public rx.f<Boolean> a(final DurationBean durationBean) {
        return rx.f.a((f.a) new f.a<Boolean>() { // from class: com.fotoable.youtube.music.db.a.14
            @Override // rx.c.b
            /* renamed from: a */
            public void call(rx.l<? super Boolean> lVar) {
                a.this.g.insertOrReplace(durationBean);
                lVar.onNext(true);
                lVar.onCompleted();
            }
        });
    }

    public rx.f<List<RecentlyWatchBean>> a(final List<RecentlyWatchBean> list) {
        com.fotoable.youtube.music.util.h.a(f2610a, "查询收藏状态");
        return rx.f.a(new f.a(this, list) { // from class: com.fotoable.youtube.music.db.g

            /* renamed from: a  reason: collision with root package name */
            private final a f2675a;

            /* renamed from: b  reason: collision with root package name */
            private final List f2676b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2675a = this;
                this.f2676b = list;
            }

            @Override // rx.c.b
            public void call(Object obj) {
                this.f2675a.a(this.f2676b, (rx.l) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(List list, rx.l lVar) {
        if (lVar != null && !lVar.isUnsubscribed()) {
            HashSet hashSet = new HashSet();
            for (int i = 0; i < list.size(); i++) {
                RecentlyWatchBean recentlyWatchBean = (RecentlyWatchBean) list.get(i);
                if (recentlyWatchBean != null && !TextUtils.isEmpty(recentlyWatchBean.getVideoid())) {
                    hashSet.add(recentlyWatchBean.getVideoid() + "");
                }
            }
            List<FavBean> list2 = this.e.queryBuilder().where(FavBeanDao.Properties.f2682a.in(hashSet), new WhereCondition[0]).build().list();
            HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < list2.size(); i2++) {
                FavBean favBean = list2.get(i2);
                hashMap.put(favBean.getVideoid(), Integer.valueOf(favBean.getIsFav()));
            }
            for (int i3 = 0; i3 < list.size(); i3++) {
                RecentlyWatchBean recentlyWatchBean2 = (RecentlyWatchBean) list.get(i3);
                if (recentlyWatchBean2 != null && !TextUtils.isEmpty(recentlyWatchBean2.getVideoid()) && hashMap.get(recentlyWatchBean2.getVideoid()) != null) {
                    recentlyWatchBean2.setIsFav(((Integer) hashMap.get(recentlyWatchBean2.getVideoid())).intValue());
                    com.fotoable.youtube.music.util.h.a(f2610a, "查询收藏状态：" + recentlyWatchBean2.getVideoid() + "   " + hashMap.get(recentlyWatchBean2.getVideoid()));
                }
            }
            hashMap.clear();
            lVar.onNext(list);
            lVar.onCompleted();
        }
    }

    public rx.f<Map<String, Integer>> b(final List<String> list) {
        return rx.f.a((f.a) new f.a<Map<String, Integer>>() { // from class: com.fotoable.youtube.music.db.a.15
            @Override // rx.c.b
            /* renamed from: a */
            public void call(rx.l<? super Map<String, Integer>> lVar) {
                int i = 0;
                if (lVar != null && !lVar.isUnsubscribed()) {
                    List<FavBean> list2 = a.this.e.queryBuilder().where(FavBeanDao.Properties.f2682a.in(list), new WhereCondition[0]).build().list();
                    HashMap hashMap = new HashMap();
                    while (true) {
                        int i2 = i;
                        if (i2 < list2.size()) {
                            FavBean favBean = list2.get(i2);
                            hashMap.put(favBean.getVideoid(), Integer.valueOf(favBean.getIsFav()));
                            i = i2 + 1;
                        } else {
                            lVar.onNext(hashMap);
                            lVar.onCompleted();
                            return;
                        }
                    }
                }
            }
        });
    }

    public Map<String, Integer> c(List<String> list) {
        int i = 0;
        List<FavBean> list2 = this.e.queryBuilder().where(FavBeanDao.Properties.f2682a.in(list), new WhereCondition[0]).build().list();
        HashMap hashMap = new HashMap();
        while (true) {
            int i2 = i;
            if (i2 < list2.size()) {
                FavBean favBean = list2.get(i2);
                hashMap.put(favBean.getVideoid(), Integer.valueOf(favBean.getIsFav()));
                i = i2 + 1;
            } else {
                return hashMap;
            }
        }
    }

    public boolean g(String str) {
        return this.e.queryBuilder().where(DurationBeanDao.Properties.f2680a.eq(str), new WhereCondition[0]).unique() != null;
    }

    public rx.f<List<PlayListModel>> h() {
        return rx.f.a((f.a) new f.a<List<PlayListModel>>() { // from class: com.fotoable.youtube.music.db.a.16
            @Override // rx.c.b
            /* renamed from: a */
            public void call(rx.l<? super List<PlayListModel>> lVar) {
                if (lVar != null && !lVar.isUnsubscribed()) {
                    lVar.onNext(a.this.h.queryBuilder().list());
                    lVar.onCompleted();
                }
            }
        });
    }

    public long a(PlayListModel playListModel) {
        return this.h.insert(playListModel);
    }

    public rx.f<Boolean> a(final Long l) {
        return rx.f.a((f.a) new f.a<Boolean>() { // from class: com.fotoable.youtube.music.db.a.17
            @Override // rx.c.b
            /* renamed from: a */
            public void call(rx.l<? super Boolean> lVar) {
                a.this.h.delete(a.this.h.queryBuilder().where(PlayListModelDao.Properties.f2697a.eq(l), new WhereCondition[0]).unique());
                for (PlayMusicModel playMusicModel : a.this.i.queryBuilder().where(PlayMusicModelDao.Properties.i.eq(l), new WhereCondition[0]).list()) {
                    a.this.i.delete(playMusicModel);
                }
                if (lVar != null && !lVar.isUnsubscribed()) {
                    lVar.onNext(true);
                    lVar.onCompleted();
                }
            }
        });
    }

    public void a(Long l, String str) {
        PlayListModel unique = this.h.queryBuilder().where(PlayListModelDao.Properties.f2697a.eq(l), new WhereCondition[0]).unique();
        if (unique != null) {
            unique.setName(str);
            this.h.update(unique);
        }
    }

    public void b(Long l, String str) {
        PlayListModel unique = this.h.queryBuilder().where(PlayListModelDao.Properties.f2697a.eq(l), new WhereCondition[0]).unique();
        if (unique != null) {
            unique.setCover(str);
            this.h.update(unique);
        }
    }

    public PlayListModel b(Long l) {
        return this.h.queryBuilder().where(PlayListModelDao.Properties.f2697a.eq(l), new WhereCondition[0]).unique();
    }

    public long c(Long l) {
        return this.i.queryBuilder().where(PlayMusicModelDao.Properties.i.eq(l), new WhereCondition[0]).count();
    }

    public void a(PlayMusicModel playMusicModel) {
        if (playMusicModel.getPlaylistId() != null && this.i.queryBuilder().where(PlayMusicModelDao.Properties.f2701b.eq(playMusicModel.getVideoId()), PlayMusicModelDao.Properties.i.eq(playMusicModel.getPlaylistId())).unique() == null) {
            this.i.insert(playMusicModel);
            if (!TextUtils.isEmpty(playMusicModel.getCoverImg())) {
                b(playMusicModel.getPlaylistId(), playMusicModel.getCoverImg());
            }
        }
    }

    public void c(Long l, String str) {
        this.i.delete(this.i.queryBuilder().where(PlayMusicModelDao.Properties.f2701b.eq(str), PlayMusicModelDao.Properties.i.eq(l)).unique());
    }

    public rx.f<List<PlayMusicModel>> d(final Long l) {
        return rx.f.a((f.a) new f.a<List<PlayMusicModel>>() { // from class: com.fotoable.youtube.music.db.a.18
            @Override // rx.c.b
            /* renamed from: a */
            public void call(rx.l<? super List<PlayMusicModel>> lVar) {
                if (lVar != null && !lVar.isUnsubscribed()) {
                    lVar.onNext(a.this.i.queryBuilder().where(PlayMusicModelDao.Properties.i.eq(l), new WhereCondition[0]).list());
                    lVar.onCompleted();
                }
            }
        });
    }

    public rx.f<Boolean> a(boolean z, LocalSongBean localSongBean) {
        if (!z) {
            com.fotoable.youtube.music.util.h.a(f2610a, "添加收藏");
            return a(localSongBean);
        }
        com.fotoable.youtube.music.util.h.a(f2610a, "删除收藏");
        return e(localSongBean.songId);
    }

    public rx.f<Boolean> a(LocalSongBean localSongBean) {
        return rx.f.a(localSongBean).c(new rx.c.e(this) { // from class: com.fotoable.youtube.music.db.h

            /* renamed from: a  reason: collision with root package name */
            private final a f2718a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2718a = this;
            }

            @Override // rx.c.e
            public Object a(Object obj) {
                return this.f2718a.b((LocalSongBean) obj);
            }
        }).d(i.f2719a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Boolean b(LocalSongBean localSongBean) {
        this.j.insertOrReplace(localSongBean);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ Boolean b(Throwable th) {
        return false;
    }

    public rx.f<Boolean> e(final Long l) {
        return rx.f.a(l).c(new rx.c.e(this, l) { // from class: com.fotoable.youtube.music.db.j

            /* renamed from: a  reason: collision with root package name */
            private final a f2720a;

            /* renamed from: b  reason: collision with root package name */
            private final Long f2721b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2720a = this;
                this.f2721b = l;
            }

            @Override // rx.c.e
            public Object a(Object obj) {
                return this.f2720a.b(this.f2721b, (Long) obj);
            }
        }).d(k.f2722a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Boolean b(Long l, Long l2) {
        this.j.deleteByKey(l);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ Boolean a(Throwable th) {
        return false;
    }

    public rx.f<Boolean> f(final Long l) {
        return rx.f.a(l).c(new rx.c.e(this, l) { // from class: com.fotoable.youtube.music.db.l

            /* renamed from: a  reason: collision with root package name */
            private final a f2723a;

            /* renamed from: b  reason: collision with root package name */
            private final Long f2724b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2723a = this;
                this.f2724b = l;
            }

            @Override // rx.c.e
            public Object a(Object obj) {
                return this.f2723a.a(this.f2724b, (Long) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Boolean a(Long l, Long l2) {
        boolean z = false;
        List<LocalSongBean> list = this.j.queryBuilder().where(LocalSongBeanDao.Properties.f2694a.eq(l), new WhereCondition[0]).list();
        if (list != null && list.size() > 0) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public rx.f<List<LocalSongBean>> i() {
        return rx.f.a(new f.a(this) { // from class: com.fotoable.youtube.music.db.c

            /* renamed from: a  reason: collision with root package name */
            private final a f2668a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2668a = this;
            }

            @Override // rx.c.b
            public void call(Object obj) {
                this.f2668a.a((rx.l) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(rx.l lVar) {
        if (lVar != null && !lVar.isUnsubscribed()) {
            QueryBuilder<LocalSongBean> orderDesc = this.j.queryBuilder().orderDesc(new Property[0]);
            if (orderDesc.list() != null) {
                lVar.onNext(orderDesc.list());
            }
        }
        lVar.onCompleted();
    }

    public rx.f<Boolean> a(final int i) {
        return rx.f.a((f.a) new f.a<Boolean>() { // from class: com.fotoable.youtube.music.db.a.20
            @Override // rx.c.b
            /* renamed from: a */
            public void call(rx.l<? super Boolean> lVar) {
                if (lVar != null && !lVar.isUnsubscribed()) {
                    if (a.this.k.queryBuilder().where(RadioBeanDao.Properties.f2704b.eq(Integer.valueOf(i)), new WhereCondition[0]).unique() != null) {
                        lVar.onNext(true);
                    } else {
                        lVar.onNext(false);
                    }
                    lVar.onCompleted();
                }
            }
        });
    }

    public rx.f<Boolean> a(final RadioBean radioBean) {
        return rx.f.a((f.a) new f.a<Boolean>() { // from class: com.fotoable.youtube.music.db.a.21
            @Override // rx.c.b
            /* renamed from: a */
            public void call(rx.l<? super Boolean> lVar) {
                if (lVar != null && !lVar.isUnsubscribed()) {
                    RadioBean unique = a.this.k.queryBuilder().where(RadioBeanDao.Properties.f2704b.eq(Integer.valueOf(radioBean.getId())), new WhereCondition[0]).unique();
                    if (unique != null) {
                        radioBean.setOriginalId(unique.getOriginalId());
                    }
                    a.this.k.insertOrReplace(radioBean);
                    lVar.onNext(true);
                    lVar.onCompleted();
                    com.fotoable.youtube.music.util.b.b("电台-添加收藏");
                    com.fotoable.youtube.music.util.b.a("电台-添加收藏");
                    com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(1045));
                }
            }
        });
    }

    public rx.f<List<RadioBean>> j() {
        return rx.f.a((f.a) new f.a<List<RadioBean>>() { // from class: com.fotoable.youtube.music.db.a.22
            @Override // rx.c.b
            /* renamed from: a */
            public void call(rx.l<? super List<RadioBean>> lVar) {
                if (lVar != null && !lVar.isUnsubscribed()) {
                    List<RadioBean> list = a.this.k.queryBuilder().list();
                    if (list != null) {
                        lVar.onNext(list);
                    } else {
                        lVar.onError(new Throwable());
                    }
                    lVar.onCompleted();
                }
            }
        });
    }

    public rx.f<Boolean> b(final RadioBean radioBean) {
        return rx.f.a((f.a) new f.a<Boolean>() { // from class: com.fotoable.youtube.music.db.a.23
            @Override // rx.c.b
            /* renamed from: a */
            public void call(rx.l<? super Boolean> lVar) {
                if (lVar != null && !lVar.isUnsubscribed()) {
                    if (radioBean.getOriginalId() != null) {
                        a.this.k.delete(radioBean);
                    } else {
                        RadioBean unique = a.this.k.queryBuilder().where(RadioBeanDao.Properties.f2704b.eq(Integer.valueOf(radioBean.getId())), new WhereCondition[0]).unique();
                        if (unique != null) {
                            a.this.k.delete(unique);
                        }
                    }
                    lVar.onNext(true);
                    lVar.onCompleted();
                    com.fotoable.youtube.music.util.b.b("电台-取消收藏");
                    com.fotoable.youtube.music.util.b.a("电台-取消收藏");
                }
            }
        });
    }

    public rx.f<Boolean> a(final ArtistsCoverModel artistsCoverModel) {
        return rx.f.a((f.a) new f.a<Boolean>() { // from class: com.fotoable.youtube.music.db.a.24
            @Override // rx.c.b
            /* renamed from: a */
            public void call(rx.l<? super Boolean> lVar) {
                if (lVar != null && !lVar.isUnsubscribed()) {
                    a.this.l.insertOrReplace(artistsCoverModel);
                    lVar.onNext(true);
                    lVar.onCompleted();
                }
            }
        });
    }

    public List<ArtistsCoverModel> d(List<String> list) {
        return this.l.queryBuilder().where(ArtistsCoverModelDao.Properties.f2678b.in(list), new WhereCondition[0]).build().list();
    }

    public rx.f<Boolean> a(final LocalRecentlyModel localRecentlyModel) {
        return rx.f.a(new f.a(this, localRecentlyModel) { // from class: com.fotoable.youtube.music.db.d

            /* renamed from: a  reason: collision with root package name */
            private final a f2669a;

            /* renamed from: b  reason: collision with root package name */
            private final LocalRecentlyModel f2670b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2669a = this;
                this.f2670b = localRecentlyModel;
            }

            @Override // rx.c.b
            public void call(Object obj) {
                this.f2669a.a(this.f2670b, (rx.l) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(LocalRecentlyModel localRecentlyModel, rx.l lVar) {
        if (lVar != null && !lVar.isUnsubscribed()) {
            LocalRecentlyModel unique = this.m.queryBuilder().where(LocalRecentlyModelDao.Properties.f2692b.eq(localRecentlyModel.getSongId()), new WhereCondition[0]).unique();
            if (unique != null) {
                unique.setModifyTime(localRecentlyModel.getModifyTime());
                unique.setPlayedCount(Integer.valueOf(unique.getPlayedCount() != null ? unique.getPlayedCount().intValue() + 1 : 1));
                this.m.update(unique);
            } else {
                localRecentlyModel.setPlayedCount(1);
                this.m.insertOrReplace(localRecentlyModel);
            }
            lVar.onNext(true);
            lVar.onCompleted();
            com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(1048));
        }
    }

    public LocalPlayListBean k() {
        LocalPlayListBean localPlayListBean = new LocalPlayListBean();
        localPlayListBean.setCoverDefId(R.mipmap.icon_myfavoriteplaylist);
        localPlayListBean.setTitle(R.string.favorites);
        localPlayListBean.setCoverHintId(R.mipmap.icon_my_favorite_top);
        List<LocalSongBean> list = this.j.queryBuilder().orderDesc(new Property[0]).list();
        if (list != null && list.size() > 0) {
            localPlayListBean.setCount(list.size());
            localPlayListBean.setCoverUrl(list.get(0).albumData);
        } else {
            localPlayListBean.setCount(0);
        }
        return localPlayListBean;
    }

    public LocalPlayListBean l() {
        LocalPlayListBean localPlayListBean = new LocalPlayListBean();
        localPlayListBean.setCoverDefId(R.mipmap.local_last_played_def);
        localPlayListBean.setTitle(R.string.recently_played);
        localPlayListBean.setCoverHintId(R.mipmap.local_last_played_hint);
        List<LocalRecentlyModel> list = this.m.queryBuilder().orderDesc(LocalRecentlyModelDao.Properties.f2693c).list();
        if (list != null && list.size() > 0) {
            localPlayListBean.setCount(list.size());
            int i = 0;
            while (true) {
                if (i >= list.size()) {
                    break;
                }
                LocalSongBean a2 = com.fotoable.youtube.music.helper.localmusic.d.a(list.get(0).getSongId().longValue());
                if (a2 == null) {
                    i++;
                } else {
                    localPlayListBean.setCoverUrl(a2.albumData);
                    break;
                }
            }
        } else {
            localPlayListBean.setCount(0);
        }
        return localPlayListBean;
    }

    public LocalPlayListBean m() {
        LocalPlayListBean localPlayListBean = new LocalPlayListBean();
        localPlayListBean.setCoverDefId(R.mipmap.local_added_def);
        localPlayListBean.setTitle(R.string.recently_added);
        localPlayListBean.setCoverHintId(R.mipmap.local_added_hint);
        List<LocalSongBean> a2 = com.fotoable.youtube.music.helper.localmusic.d.a();
        if (a2 != null && a2.size() > 0) {
            localPlayListBean.setCount(a2.size());
            int i = 0;
            while (true) {
                if (i >= a2.size()) {
                    break;
                }
                LocalSongBean a3 = com.fotoable.youtube.music.helper.localmusic.d.a(a2.get(0).getSongId().longValue());
                if (a3 == null) {
                    i++;
                } else {
                    localPlayListBean.setCoverUrl(a3.albumData);
                    break;
                }
            }
        } else {
            localPlayListBean.setCount(0);
        }
        return localPlayListBean;
    }

    public List<LocalSongBean> n() {
        ArrayList arrayList = new ArrayList();
        List<LocalRecentlyModel> list = this.m.queryBuilder().orderDesc(LocalRecentlyModelDao.Properties.f2693c).list();
        if (list != null && list.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                arrayList2.add(list.get(i).getSongId());
            }
            List<LocalSongBean> a2 = com.fotoable.youtube.music.helper.localmusic.d.a(arrayList2);
            arrayList2.clear();
            if (a2 != null && a2.size() > 0) {
                HashMap hashMap = new HashMap();
                for (int i2 = 0; i2 < a2.size(); i2++) {
                    LocalSongBean localSongBean = a2.get(i2);
                    if (localSongBean != null) {
                        hashMap.put(localSongBean.getSongId(), localSongBean);
                    }
                }
                for (int i3 = 0; i3 < list.size(); i3++) {
                    LocalSongBean localSongBean2 = (LocalSongBean) hashMap.get(list.get(i3).getSongId());
                    if (localSongBean2 != null) {
                        arrayList.add(localSongBean2);
                    }
                }
            }
        }
        return arrayList;
    }

    public List<LocalSongBean> o() {
        return com.fotoable.youtube.music.helper.localmusic.d.a();
    }

    public rx.f<MyHttpResponse<List<FeaturedDetailBean>>> a(final MyHttpResponse<List<FeaturedDetailBean>> myHttpResponse) {
        com.fotoable.youtube.music.util.h.a(f2610a, "查询收藏状态");
        return rx.f.a(new f.a(this, myHttpResponse) { // from class: com.fotoable.youtube.music.db.e

            /* renamed from: a  reason: collision with root package name */
            private final a f2671a;

            /* renamed from: b  reason: collision with root package name */
            private final MyHttpResponse f2672b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2671a = this;
                this.f2672b = myHttpResponse;
            }

            @Override // rx.c.b
            public void call(Object obj) {
                this.f2671a.a(this.f2672b, (rx.l) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(MyHttpResponse myHttpResponse, rx.l lVar) {
        if (lVar != null && !lVar.isUnsubscribed()) {
            HashSet hashSet = new HashSet();
            List list = (List) myHttpResponse.getData();
            for (int i = 0; i < list.size(); i++) {
                FeaturedDetailBean featuredDetailBean = (FeaturedDetailBean) list.get(i);
                if (featuredDetailBean != null && !TextUtils.isEmpty(featuredDetailBean.getVideoid())) {
                    hashSet.add(featuredDetailBean.getVideoid() + "");
                }
            }
            List<FavBean> list2 = this.e.queryBuilder().where(FavBeanDao.Properties.f2682a.in(hashSet), new WhereCondition[0]).build().list();
            HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < list2.size(); i2++) {
                FavBean favBean = list2.get(i2);
                hashMap.put(favBean.getVideoid(), Integer.valueOf(favBean.getIsFav()));
            }
            for (int i3 = 0; i3 < list.size(); i3++) {
                FeaturedDetailBean featuredDetailBean2 = (FeaturedDetailBean) list.get(i3);
                if (featuredDetailBean2 != null && !TextUtils.isEmpty(featuredDetailBean2.getVideoid()) && hashMap.get(featuredDetailBean2.getVideoid()) != null) {
                    featuredDetailBean2.setIsFav(((Integer) hashMap.get(featuredDetailBean2.getVideoid())).intValue());
                    com.fotoable.youtube.music.util.h.a(f2610a, "查询收藏状态：" + featuredDetailBean2.getVideoid() + "   " + hashMap.get(featuredDetailBean2.getVideoid()));
                }
            }
            hashMap.clear();
            myHttpResponse.setData(list);
            lVar.onNext(myHttpResponse);
            lVar.onCompleted();
        }
    }

    public List<LocalPlayListModel> p() {
        List<LocalPlayListMusicModel> i;
        List<LocalSongBean> a2;
        List<LocalPlayListModel> list = this.n.queryBuilder().orderAsc(LocalPlayListModelDao.Properties.f2687c).list();
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                LocalPlayListModel localPlayListModel = list.get(i2);
                if (localPlayListModel != null && (i = i(list.get(i2).getId())) != null && i.size() > 0) {
                    localPlayListModel.setMusicCount(i.size());
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < i.size(); i3++) {
                        LocalPlayListMusicModel localPlayListMusicModel = i.get(i3);
                        if (localPlayListMusicModel != null) {
                            arrayList.add(localPlayListMusicModel.getSongId());
                        }
                    }
                    if (arrayList.size() > 0 && (a2 = com.fotoable.youtube.music.helper.localmusic.d.a(arrayList)) != null && a2.size() > 0) {
                        localPlayListModel.setMusicCount(a2.size());
                        localPlayListModel.setCover(a2.get(0).getAlbumData());
                    }
                }
            }
        }
        return list;
    }

    public rx.f<List<LocalPlayListModel>> q() {
        return rx.f.a((f.a) new f.a<List<LocalPlayListModel>>() { // from class: com.fotoable.youtube.music.db.a.25
            @Override // rx.c.b
            /* renamed from: a */
            public void call(rx.l<? super List<LocalPlayListModel>> lVar) {
                List<LocalPlayListModel> list = a.this.n.queryBuilder().orderAsc(LocalPlayListModelDao.Properties.f2687c).list();
                if (lVar != null && !lVar.isUnsubscribed()) {
                    lVar.onNext(list);
                    lVar.onCompleted();
                }
            }
        });
    }

    public void d(Long l, String str) {
        LocalPlayListModel unique = this.n.queryBuilder().where(LocalPlayListModelDao.Properties.f2685a.eq(l), new WhereCondition[0]).unique();
        if (unique != null) {
            unique.setName(str);
            this.n.update(unique);
        }
    }

    private List<LocalPlayListMusicModel> i(Long l) {
        return this.o.queryBuilder().where(LocalPlayListMusicModelDao.Properties.f2690c.eq(l), new WhereCondition[0]).orderDesc(LocalPlayListMusicModelDao.Properties.d).list();
    }

    public void a(LocalPlayListModel localPlayListModel) {
        localPlayListModel.setId(Long.valueOf(this.n.insert(localPlayListModel)));
    }

    public boolean a(LocalPlayListMusicModel localPlayListMusicModel) {
        if (this.o.queryBuilder().where(LocalPlayListMusicModelDao.Properties.f2690c.eq(localPlayListMusicModel.getPlayListId()), LocalPlayListMusicModelDao.Properties.f2689b.eq(localPlayListMusicModel.getSongId())).unique() == null) {
            localPlayListMusicModel.setId(Long.valueOf(this.o.insert(localPlayListMusicModel)));
            return false;
        }
        return true;
    }

    public LocalPlayListBean r() {
        LocalPlayListBean localPlayListBean = new LocalPlayListBean();
        localPlayListBean.setCoverDefId(R.mipmap.most_played_def);
        localPlayListBean.setTitle(R.string.most_player);
        localPlayListBean.setCoverHintId(R.mipmap.local_most_played_hint);
        List<LocalRecentlyModel> list = this.m.queryBuilder().orderDesc(LocalRecentlyModelDao.Properties.d).list();
        if (list != null && list.size() > 0) {
            localPlayListBean.setCount(list.size());
            int i = 0;
            while (true) {
                if (i >= list.size()) {
                    break;
                }
                LocalSongBean a2 = com.fotoable.youtube.music.helper.localmusic.d.a(list.get(0).getSongId().longValue());
                if (a2 == null) {
                    i++;
                } else {
                    localPlayListBean.setCoverUrl(a2.albumData);
                    break;
                }
            }
        } else {
            localPlayListBean.setCount(0);
        }
        return localPlayListBean;
    }

    public List<LocalSongBean> s() {
        List<LocalSongBean> a2;
        List<LocalRecentlyModel> list = this.m.queryBuilder().orderDesc(LocalRecentlyModelDao.Properties.d).list();
        com.fotoable.youtube.music.util.h.a(f2610a, "list:" + list);
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                com.fotoable.youtube.music.util.h.a(f2610a, "playCount:" + list.get(i).getPlayedCount());
                arrayList.add(list.get(i).getSongId());
            }
            if (arrayList.size() > 0 && (a2 = com.fotoable.youtube.music.helper.localmusic.d.a(arrayList)) != null && a2.size() > 0) {
                HashMap hashMap = new HashMap();
                for (int i2 = 0; i2 < a2.size(); i2++) {
                    LocalSongBean localSongBean = a2.get(i2);
                    if (localSongBean != null) {
                        hashMap.put(localSongBean.getSongId(), localSongBean);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    LocalSongBean localSongBean2 = (LocalSongBean) hashMap.get(arrayList.get(i3));
                    if (localSongBean2 != null) {
                        arrayList2.add(localSongBean2);
                    }
                }
                hashMap.clear();
                arrayList.clear();
                return arrayList2;
            }
        }
        return null;
    }

    public rx.f<List<LocalSongBean>> g(final Long l) {
        return rx.f.a(new f.a(this, l) { // from class: com.fotoable.youtube.music.db.f

            /* renamed from: a  reason: collision with root package name */
            private final a f2673a;

            /* renamed from: b  reason: collision with root package name */
            private final Long f2674b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2673a = this;
                this.f2674b = l;
            }

            @Override // rx.c.b
            public void call(Object obj) {
                this.f2673a.a(this.f2674b, (rx.l) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(Long l, rx.l lVar) {
        List<LocalSongBean> list;
        List<LocalPlayListMusicModel> i = i(l);
        if (i != null && i.size() > 0) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i.size()) {
                    break;
                }
                LocalPlayListMusicModel localPlayListMusicModel = i.get(i3);
                if (localPlayListMusicModel != null) {
                    arrayList.add(localPlayListMusicModel.getSongId());
                }
                i2 = i3 + 1;
            }
            if (arrayList.size() > 0) {
                list = com.fotoable.youtube.music.helper.localmusic.d.a(arrayList);
                if (lVar == null && !lVar.isUnsubscribed()) {
                    lVar.onNext(list);
                    lVar.onCompleted();
                    return;
                }
            }
        }
        list = null;
        if (lVar == null) {
        }
    }

    public rx.f<Boolean> h(final Long l) {
        return rx.f.a((f.a) new f.a<Boolean>() { // from class: com.fotoable.youtube.music.db.a.26
            @Override // rx.c.b
            /* renamed from: a */
            public void call(rx.l<? super Boolean> lVar) {
                LocalPlayListModel unique = a.this.n.queryBuilder().where(LocalPlayListModelDao.Properties.f2685a.eq(l), new WhereCondition[0]).unique();
                if (unique != null) {
                    a.this.n.delete(unique);
                }
                a.this.o.queryBuilder().where(LocalPlayListMusicModelDao.Properties.f2690c.eq(l), new WhereCondition[0]).buildDelete();
                if (lVar != null && !lVar.isUnsubscribed()) {
                    lVar.onNext(true);
                    lVar.onCompleted();
                }
            }
        });
    }

    public boolean h(String str) {
        return this.p.queryBuilder().where(YoutubeCommentLocalLikeModelDao.Properties.f2713b.eq(str), new WhereCondition[0]).count() > 0;
    }

    public void i(String str) {
        YoutubeCommentLocalLikeModel youtubeCommentLocalLikeModel = new YoutubeCommentLocalLikeModel();
        youtubeCommentLocalLikeModel.setCid(str);
        if (MusicApplication.c().h() != null) {
            youtubeCommentLocalLikeModel.setUid(MusicApplication.c().h().getUid() + "");
        }
        youtubeCommentLocalLikeModel.setModifyTime(Long.valueOf(System.currentTimeMillis()));
        if (this.p.queryBuilder().where(YoutubeCommentLocalLikeModelDao.Properties.f2713b.eq(str), new WhereCondition[0]).count() == 0) {
            this.p.insert(youtubeCommentLocalLikeModel);
        }
    }

    public void j(String str) {
        if (MusicApplication.c().h() != null) {
            this.p.queryBuilder().where(YoutubeCommentLocalLikeModelDao.Properties.f2713b.eq(str), YoutubeCommentLocalLikeModelDao.Properties.f2714c.eq(MusicApplication.c().h().getUid() + "")).buildDelete().executeDeleteWithoutDetachingEntities();
        } else {
            this.p.queryBuilder().where(YoutubeCommentLocalLikeModelDao.Properties.f2713b.eq(str), new WhereCondition[0]).buildDelete().executeDeleteWithoutDetachingEntities();
        }
    }

    public List<YoutubeCommentLocalLikeModel> e(List<String> list) {
        return this.p.queryBuilder().where(YoutubeCommentLocalLikeModelDao.Properties.f2713b.in(list), new WhereCondition[0]).list();
    }
}

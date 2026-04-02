package com.fotoable.youtube.music.db.greendao.gen;

import com.fotoable.youtube.music.bean.ArtistsCoverModel;
import com.fotoable.youtube.music.bean.DurationBean;
import com.fotoable.youtube.music.bean.FavBean;
import com.fotoable.youtube.music.bean.LocalPlayListModel;
import com.fotoable.youtube.music.bean.LocalPlayListMusicModel;
import com.fotoable.youtube.music.bean.LocalRecentlyModel;
import com.fotoable.youtube.music.bean.LocalSongBean;
import com.fotoable.youtube.music.bean.PlayListModel;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import com.fotoable.youtube.music.bean.RadioBean;
import com.fotoable.youtube.music.bean.RecentlyWatchBean;
import com.fotoable.youtube.music.bean.SubBean;
import com.fotoable.youtube.music.bean.YoutubeCommentLocalLikeModel;
import java.util.Map;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;
/* compiled from: DaoSession.java */
/* loaded from: classes.dex */
public class b extends AbstractDaoSession {

    /* renamed from: a  reason: collision with root package name */
    private final DaoConfig f2715a;

    /* renamed from: b  reason: collision with root package name */
    private final DaoConfig f2716b;

    /* renamed from: c  reason: collision with root package name */
    private final DaoConfig f2717c;
    private final DaoConfig d;
    private final DaoConfig e;
    private final DaoConfig f;
    private final DaoConfig g;
    private final DaoConfig h;
    private final DaoConfig i;
    private final DaoConfig j;
    private final DaoConfig k;
    private final DaoConfig l;
    private final DaoConfig m;
    private final LocalPlayListModelDao n;
    private final ArtistsCoverModelDao o;
    private final FavBeanDao p;
    private final LocalRecentlyModelDao q;
    private final RadioBeanDao r;
    private final YoutubeCommentLocalLikeModelDao s;
    private final LocalPlayListMusicModelDao t;
    private final DurationBeanDao u;
    private final PlayMusicModelDao v;
    private final SubBeanDao w;
    private final PlayListModelDao x;
    private final RecentlyWatchBeanDao y;
    private final LocalSongBeanDao z;

    public b(Database database, IdentityScopeType identityScopeType, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> map) {
        super(database);
        this.f2715a = map.get(LocalPlayListModelDao.class).clone();
        this.f2715a.initIdentityScope(identityScopeType);
        this.f2716b = map.get(ArtistsCoverModelDao.class).clone();
        this.f2716b.initIdentityScope(identityScopeType);
        this.f2717c = map.get(FavBeanDao.class).clone();
        this.f2717c.initIdentityScope(identityScopeType);
        this.d = map.get(LocalRecentlyModelDao.class).clone();
        this.d.initIdentityScope(identityScopeType);
        this.e = map.get(RadioBeanDao.class).clone();
        this.e.initIdentityScope(identityScopeType);
        this.f = map.get(YoutubeCommentLocalLikeModelDao.class).clone();
        this.f.initIdentityScope(identityScopeType);
        this.g = map.get(LocalPlayListMusicModelDao.class).clone();
        this.g.initIdentityScope(identityScopeType);
        this.h = map.get(DurationBeanDao.class).clone();
        this.h.initIdentityScope(identityScopeType);
        this.i = map.get(PlayMusicModelDao.class).clone();
        this.i.initIdentityScope(identityScopeType);
        this.j = map.get(SubBeanDao.class).clone();
        this.j.initIdentityScope(identityScopeType);
        this.k = map.get(PlayListModelDao.class).clone();
        this.k.initIdentityScope(identityScopeType);
        this.l = map.get(RecentlyWatchBeanDao.class).clone();
        this.l.initIdentityScope(identityScopeType);
        this.m = map.get(LocalSongBeanDao.class).clone();
        this.m.initIdentityScope(identityScopeType);
        this.n = new LocalPlayListModelDao(this.f2715a, this);
        this.o = new ArtistsCoverModelDao(this.f2716b, this);
        this.p = new FavBeanDao(this.f2717c, this);
        this.q = new LocalRecentlyModelDao(this.d, this);
        this.r = new RadioBeanDao(this.e, this);
        this.s = new YoutubeCommentLocalLikeModelDao(this.f, this);
        this.t = new LocalPlayListMusicModelDao(this.g, this);
        this.u = new DurationBeanDao(this.h, this);
        this.v = new PlayMusicModelDao(this.i, this);
        this.w = new SubBeanDao(this.j, this);
        this.x = new PlayListModelDao(this.k, this);
        this.y = new RecentlyWatchBeanDao(this.l, this);
        this.z = new LocalSongBeanDao(this.m, this);
        registerDao(LocalPlayListModel.class, this.n);
        registerDao(ArtistsCoverModel.class, this.o);
        registerDao(FavBean.class, this.p);
        registerDao(LocalRecentlyModel.class, this.q);
        registerDao(RadioBean.class, this.r);
        registerDao(YoutubeCommentLocalLikeModel.class, this.s);
        registerDao(LocalPlayListMusicModel.class, this.t);
        registerDao(DurationBean.class, this.u);
        registerDao(PlayMusicModel.class, this.v);
        registerDao(SubBean.class, this.w);
        registerDao(PlayListModel.class, this.x);
        registerDao(RecentlyWatchBean.class, this.y);
        registerDao(LocalSongBean.class, this.z);
    }

    public LocalPlayListModelDao a() {
        return this.n;
    }

    public ArtistsCoverModelDao b() {
        return this.o;
    }

    public FavBeanDao c() {
        return this.p;
    }

    public LocalRecentlyModelDao d() {
        return this.q;
    }

    public RadioBeanDao e() {
        return this.r;
    }

    public YoutubeCommentLocalLikeModelDao f() {
        return this.s;
    }

    public LocalPlayListMusicModelDao g() {
        return this.t;
    }

    public DurationBeanDao h() {
        return this.u;
    }

    public PlayMusicModelDao i() {
        return this.v;
    }

    public SubBeanDao j() {
        return this.w;
    }

    public PlayListModelDao k() {
        return this.x;
    }

    public RecentlyWatchBeanDao l() {
        return this.y;
    }

    public LocalSongBeanDao m() {
        return this.z;
    }
}

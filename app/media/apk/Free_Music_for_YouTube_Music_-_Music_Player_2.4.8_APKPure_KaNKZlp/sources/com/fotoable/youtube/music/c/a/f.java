package com.fotoable.youtube.music.c.a;

import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.c.b.aa;
import com.fotoable.youtube.music.c.b.ab;
import com.fotoable.youtube.music.c.b.z;
import com.fotoable.youtube.music.d.as;
import com.fotoable.youtube.music.d.au;
import com.fotoable.youtube.music.d.n;
import com.fotoable.youtube.music.d.p;
import com.fotoable.youtube.music.d.q;
import com.fotoable.youtube.music.d.w;
import com.fotoable.youtube.music.d.y;
import com.fotoable.youtube.music.ui.fragment.ArtistsFragment;
import com.fotoable.youtube.music.ui.fragment.CategoryPlaylistFragment;
import com.fotoable.youtube.music.ui.fragment.ChartsFragment;
import com.fotoable.youtube.music.ui.fragment.ClassifiedMusicFragment;
import com.fotoable.youtube.music.ui.fragment.CommunityFragment;
import com.fotoable.youtube.music.ui.fragment.DiscoverFragment;
import com.fotoable.youtube.music.ui.fragment.FeaturedFragment;
import com.fotoable.youtube.music.ui.fragment.GenresFragment;
import com.fotoable.youtube.music.ui.fragment.GlobalMusicFragment;
import com.fotoable.youtube.music.ui.fragment.LocalArtistsFragment;
import com.fotoable.youtube.music.ui.fragment.LocalFavoriteFragment;
import com.fotoable.youtube.music.ui.fragment.LocalMusicFragment;
import com.fotoable.youtube.music.ui.fragment.LocalPlayListFragment;
import com.fotoable.youtube.music.ui.fragment.LocalSongsFragment;
import com.fotoable.youtube.music.ui.fragment.MyMusicFragment;
import com.fotoable.youtube.music.ui.fragment.PlayListFragment;
import com.fotoable.youtube.music.ui.fragment.RadioFavoriteFragment;
import com.fotoable.youtube.music.ui.fragment.RadioFragment;
import com.fotoable.youtube.music.ui.fragment.RadioHistoryFragment;
import com.fotoable.youtube.music.ui.fragment.RankFragment;
import com.fotoable.youtube.music.ui.fragment.SearchAlbumsFragment;
import com.fotoable.youtube.music.ui.fragment.SearchArtistsFragment;
import com.fotoable.youtube.music.ui.fragment.SearchPlayListFragment;
import com.fotoable.youtube.music.ui.fragment.SearchSongsFragment;
import com.fotoable.youtube.music.ui.fragment.Top100Fragment;
import com.fotoable.youtube.music.ui.fragment.af;
import com.fotoable.youtube.music.ui.fragment.ah;
import com.fotoable.youtube.music.ui.fragment.ak;
import com.fotoable.youtube.music.ui.fragment.aq;
import com.fotoable.youtube.music.ui.fragment.at;
import com.fotoable.youtube.music.ui.fragment.ax;
import com.fotoable.youtube.music.ui.fragment.ay;
import com.fotoable.youtube.music.ui.fragment.az;
import com.fotoable.youtube.music.ui.fragment.bc;
import com.fotoable.youtube.music.ui.fragment.bd;
import com.fotoable.youtube.music.ui.fragment.be;
import com.fotoable.youtube.music.ui.fragment.bf;
import com.fotoable.youtube.music.ui.fragment.bh;
import com.fotoable.youtube.music.ui.fragment.bj;
import com.fotoable.youtube.music.ui.fragment.x;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import javax.inject.Provider;
/* compiled from: DaggerFragmentComponent.java */
/* loaded from: classes.dex */
public final class f implements j {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2355a;
    private MembersInjector<LocalArtistsFragment> A;
    private MembersInjector<LocalMusicFragment> B;
    private MembersInjector<LocalPlayListFragment> C;
    private MembersInjector<CategoryPlaylistFragment> D;
    private Provider<as> E;
    private MembersInjector<Top100Fragment> F;
    private Provider<com.fotoable.youtube.music.d.l> G;
    private MembersInjector<CommunityFragment> H;

    /* renamed from: b  reason: collision with root package name */
    private Provider<BaseActivity> f2356b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<com.fotoable.youtube.music.base.i> f2357c;
    private Provider<com.fotoable.youtube.music.b.c> d;
    private Provider<com.fotoable.youtube.music.db.a> e;
    private MembersInjector<FeaturedFragment> f;
    private MembersInjector<PlayListFragment> g;
    private MembersInjector<RankFragment> h;
    private MembersInjector<MyMusicFragment> i;
    private MembersInjector<SearchAlbumsFragment> j;
    private MembersInjector<SearchArtistsFragment> k;
    private Provider<com.fotoable.youtube.music.b.e> l;
    private MembersInjector<SearchSongsFragment> m;
    private MembersInjector<SearchPlayListFragment> n;
    private Provider<w> o;
    private MembersInjector<GlobalMusicFragment> p;
    private Provider<com.fotoable.youtube.music.d.i> q;
    private MembersInjector<ClassifiedMusicFragment> r;
    private Provider<com.fotoable.youtube.music.d.a> s;
    private MembersInjector<ArtistsFragment> t;
    private Provider<p> u;
    private MembersInjector<GenresFragment> v;
    private MembersInjector<LocalSongsFragment> w;
    private MembersInjector<RadioFragment> x;
    private MembersInjector<LocalFavoriteFragment> y;
    private MembersInjector<RadioFavoriteFragment> z;

    static {
        f2355a = !f.class.desiredAssertionStatus();
    }

    private f(a aVar) {
        if (!f2355a && aVar == null) {
            throw new AssertionError();
        }
        a(aVar);
    }

    public static a a() {
        return new a();
    }

    private void a(final a aVar) {
        this.f2356b = DoubleCheck.provider(aa.a(aVar.f2367a));
        this.f2357c = DoubleCheck.provider(ab.a(aVar.f2367a));
        this.d = new Factory<com.fotoable.youtube.music.b.c>() { // from class: com.fotoable.youtube.music.c.a.f.1

            /* renamed from: c  reason: collision with root package name */
            private final b f2360c;

            {
                this.f2360c = aVar.f2368b;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public com.fotoable.youtube.music.b.c get() {
                return (com.fotoable.youtube.music.b.c) Preconditions.checkNotNull(this.f2360c.a(), "Cannot return null from a non-@Nullable component method");
            }
        };
        this.e = new Factory<com.fotoable.youtube.music.db.a>() { // from class: com.fotoable.youtube.music.c.a.f.2

            /* renamed from: c  reason: collision with root package name */
            private final b f2363c;

            {
                this.f2363c = aVar.f2368b;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public com.fotoable.youtube.music.db.a get() {
                return (com.fotoable.youtube.music.db.a) Preconditions.checkNotNull(this.f2363c.d(), "Cannot return null from a non-@Nullable component method");
            }
        };
        this.f = com.fotoable.youtube.music.ui.fragment.j.a(this.d, this.e);
        this.g = ax.a(this.d);
        this.h = bc.a(this.d);
        this.i = at.a(this.e);
        this.j = bd.a(this.e);
        this.k = be.a(this.e);
        this.l = new Factory<com.fotoable.youtube.music.b.e>() { // from class: com.fotoable.youtube.music.c.a.f.3

            /* renamed from: c  reason: collision with root package name */
            private final b f2366c;

            {
                this.f2366c = aVar.f2368b;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public com.fotoable.youtube.music.b.e get() {
                return (com.fotoable.youtube.music.b.e) Preconditions.checkNotNull(this.f2366c.b(), "Cannot return null from a non-@Nullable component method");
            }
        };
        this.m = bh.a(this.l, this.e);
        this.n = bf.a(this.l);
        this.o = y.a(MembersInjectors.noOp(), this.d);
        this.p = com.fotoable.youtube.music.ui.fragment.l.a(this.o);
        this.q = com.fotoable.youtube.music.d.k.a(MembersInjectors.noOp(), this.d);
        this.r = com.fotoable.youtube.music.ui.fragment.c.a(this.q);
        this.s = com.fotoable.youtube.music.d.c.a(MembersInjectors.noOp(), this.d);
        this.t = com.fotoable.youtube.music.ui.fragment.a.a(this.s);
        this.u = q.a(MembersInjectors.noOp(), this.d);
        this.v = com.fotoable.youtube.music.ui.fragment.k.a(this.u);
        this.w = aq.a(this.e);
        this.x = az.a(this.d);
        this.y = af.a(this.e);
        this.z = ay.a(this.e);
        this.A = x.a(this.e);
        this.B = ah.a(this.e);
        this.C = ak.a(this.e);
        this.D = com.fotoable.youtube.music.ui.fragment.b.a(this.d);
        this.E = au.a(MembersInjectors.noOp(), this.d, this.e);
        this.F = bj.a(this.d, this.E);
        this.G = n.a(MembersInjectors.noOp(), this.d, this.e);
        this.H = com.fotoable.youtube.music.ui.fragment.h.a(this.G, this.e, this.d);
    }

    @Override // com.fotoable.youtube.music.c.a.j
    public void a(FeaturedFragment featuredFragment) {
        this.f.injectMembers(featuredFragment);
    }

    @Override // com.fotoable.youtube.music.c.a.j
    public void a(PlayListFragment playListFragment) {
        this.g.injectMembers(playListFragment);
    }

    @Override // com.fotoable.youtube.music.c.a.j
    public void a(RankFragment rankFragment) {
        this.h.injectMembers(rankFragment);
    }

    @Override // com.fotoable.youtube.music.c.a.j
    public void a(DiscoverFragment discoverFragment) {
        MembersInjectors.noOp().injectMembers(discoverFragment);
    }

    @Override // com.fotoable.youtube.music.c.a.j
    public void a(MyMusicFragment myMusicFragment) {
        this.i.injectMembers(myMusicFragment);
    }

    @Override // com.fotoable.youtube.music.c.a.j
    public void a(SearchAlbumsFragment searchAlbumsFragment) {
        this.j.injectMembers(searchAlbumsFragment);
    }

    @Override // com.fotoable.youtube.music.c.a.j
    public void a(SearchArtistsFragment searchArtistsFragment) {
        this.k.injectMembers(searchArtistsFragment);
    }

    @Override // com.fotoable.youtube.music.c.a.j
    public void a(SearchSongsFragment searchSongsFragment) {
        this.m.injectMembers(searchSongsFragment);
    }

    @Override // com.fotoable.youtube.music.c.a.j
    public void a(SearchPlayListFragment searchPlayListFragment) {
        this.n.injectMembers(searchPlayListFragment);
    }

    @Override // com.fotoable.youtube.music.c.a.j
    public void a(ChartsFragment chartsFragment) {
        MembersInjectors.noOp().injectMembers(chartsFragment);
    }

    @Override // com.fotoable.youtube.music.c.a.j
    public void a(GlobalMusicFragment globalMusicFragment) {
        this.p.injectMembers(globalMusicFragment);
    }

    @Override // com.fotoable.youtube.music.c.a.j
    public void a(ClassifiedMusicFragment classifiedMusicFragment) {
        this.r.injectMembers(classifiedMusicFragment);
    }

    @Override // com.fotoable.youtube.music.c.a.j
    public void a(ArtistsFragment artistsFragment) {
        this.t.injectMembers(artistsFragment);
    }

    @Override // com.fotoable.youtube.music.c.a.j
    public void a(GenresFragment genresFragment) {
        this.v.injectMembers(genresFragment);
    }

    @Override // com.fotoable.youtube.music.c.a.j
    public void a(LocalSongsFragment localSongsFragment) {
        this.w.injectMembers(localSongsFragment);
    }

    @Override // com.fotoable.youtube.music.c.a.j
    public void a(RadioFragment radioFragment) {
        this.x.injectMembers(radioFragment);
    }

    @Override // com.fotoable.youtube.music.c.a.j
    public void a(LocalFavoriteFragment localFavoriteFragment) {
        this.y.injectMembers(localFavoriteFragment);
    }

    @Override // com.fotoable.youtube.music.c.a.j
    public void a(RadioFavoriteFragment radioFavoriteFragment) {
        this.z.injectMembers(radioFavoriteFragment);
    }

    @Override // com.fotoable.youtube.music.c.a.j
    public void a(RadioHistoryFragment radioHistoryFragment) {
        MembersInjectors.noOp().injectMembers(radioHistoryFragment);
    }

    @Override // com.fotoable.youtube.music.c.a.j
    public void a(LocalArtistsFragment localArtistsFragment) {
        this.A.injectMembers(localArtistsFragment);
    }

    @Override // com.fotoable.youtube.music.c.a.j
    public void a(LocalMusicFragment localMusicFragment) {
        this.B.injectMembers(localMusicFragment);
    }

    @Override // com.fotoable.youtube.music.c.a.j
    public void a(LocalPlayListFragment localPlayListFragment) {
        this.C.injectMembers(localPlayListFragment);
    }

    @Override // com.fotoable.youtube.music.c.a.j
    public void a(CategoryPlaylistFragment categoryPlaylistFragment) {
        this.D.injectMembers(categoryPlaylistFragment);
    }

    @Override // com.fotoable.youtube.music.c.a.j
    public void a(Top100Fragment top100Fragment) {
        this.F.injectMembers(top100Fragment);
    }

    @Override // com.fotoable.youtube.music.c.a.j
    public void a(CommunityFragment communityFragment) {
        this.H.injectMembers(communityFragment);
    }

    /* compiled from: DaggerFragmentComponent.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private z f2367a;

        /* renamed from: b  reason: collision with root package name */
        private b f2368b;

        private a() {
        }

        public j a() {
            if (this.f2367a == null) {
                throw new IllegalStateException(z.class.getCanonicalName() + " must be set");
            }
            if (this.f2368b == null) {
                throw new IllegalStateException(b.class.getCanonicalName() + " must be set");
            }
            return new f(this);
        }

        public a a(z zVar) {
            this.f2367a = (z) Preconditions.checkNotNull(zVar);
            return this;
        }

        public a a(b bVar) {
            this.f2368b = (b) Preconditions.checkNotNull(bVar);
            return this;
        }
    }
}

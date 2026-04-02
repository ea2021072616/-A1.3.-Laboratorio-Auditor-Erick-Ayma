package com.fotoable.youtube.music.c.a;

import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.d.ad;
import com.fotoable.youtube.music.d.af;
import com.fotoable.youtube.music.d.ag;
import com.fotoable.youtube.music.d.ak;
import com.fotoable.youtube.music.d.al;
import com.fotoable.youtube.music.d.an;
import com.fotoable.youtube.music.d.r;
import com.fotoable.youtube.music.d.v;
import com.fotoable.youtube.music.ui.activity.AboutActivity;
import com.fotoable.youtube.music.ui.activity.ArtistsActivity;
import com.fotoable.youtube.music.ui.activity.ArtistsDetailActivity;
import com.fotoable.youtube.music.ui.activity.ChartsActivity;
import com.fotoable.youtube.music.ui.activity.ClassifiedMusicDetailsActivity;
import com.fotoable.youtube.music.ui.activity.CommunityPostActivity;
import com.fotoable.youtube.music.ui.activity.CommunityPostDetailActivity;
import com.fotoable.youtube.music.ui.activity.CommunityPostImagePreviewActivity;
import com.fotoable.youtube.music.ui.activity.CountryActivity;
import com.fotoable.youtube.music.ui.activity.EditorChoicePlayListActivity;
import com.fotoable.youtube.music.ui.activity.FeaturedPlayListDetailsActivity;
import com.fotoable.youtube.music.ui.activity.GenresActivity;
import com.fotoable.youtube.music.ui.activity.GenresDetailActivity;
import com.fotoable.youtube.music.ui.activity.GlobalMusicDetailsActivity;
import com.fotoable.youtube.music.ui.activity.HomeListActivity;
import com.fotoable.youtube.music.ui.activity.LocalCreatedPlaylistDetailActivity;
import com.fotoable.youtube.music.ui.activity.LocalPlayListDetailActivity;
import com.fotoable.youtube.music.ui.activity.LocalSearchMusicActivity;
import com.fotoable.youtube.music.ui.activity.MainActivity;
import com.fotoable.youtube.music.ui.activity.MusicRecognitionActivity;
import com.fotoable.youtube.music.ui.activity.MusicRecognitionHistoryActivity;
import com.fotoable.youtube.music.ui.activity.MyFavoriteActivity;
import com.fotoable.youtube.music.ui.activity.MyPlaylistActivity;
import com.fotoable.youtube.music.ui.activity.MyPlaylistDetailActivity;
import com.fotoable.youtube.music.ui.activity.MyRecentlyWatchedActivity;
import com.fotoable.youtube.music.ui.activity.MySubscriptionActivity;
import com.fotoable.youtube.music.ui.activity.PlayListDetailsActivity;
import com.fotoable.youtube.music.ui.activity.PlaySettingsActivity;
import com.fotoable.youtube.music.ui.activity.PlayerActivity;
import com.fotoable.youtube.music.ui.activity.Radio1Activity;
import com.fotoable.youtube.music.ui.activity.RadioActivity;
import com.fotoable.youtube.music.ui.activity.RadioHomeActivity;
import com.fotoable.youtube.music.ui.activity.RadioListActivity;
import com.fotoable.youtube.music.ui.activity.SearchActivity;
import com.fotoable.youtube.music.ui.activity.SettingsActivity;
import com.fotoable.youtube.music.ui.activity.SplashActivity;
import com.fotoable.youtube.music.ui.activity.UserInfoActivity;
import com.fotoable.youtube.music.ui.activity.YoutubeCommentActivity;
import com.fotoable.youtube.music.ui.activity.ab;
import com.fotoable.youtube.music.ui.activity.ai;
import com.fotoable.youtube.music.ui.activity.am;
import com.fotoable.youtube.music.ui.activity.ao;
import com.fotoable.youtube.music.ui.activity.ar;
import com.fotoable.youtube.music.ui.activity.as;
import com.fotoable.youtube.music.ui.activity.au;
import com.fotoable.youtube.music.ui.activity.av;
import com.fotoable.youtube.music.ui.activity.aw;
import com.fotoable.youtube.music.ui.activity.ba;
import com.fotoable.youtube.music.ui.activity.bb;
import com.fotoable.youtube.music.ui.activity.bc;
import com.fotoable.youtube.music.ui.activity.be;
import com.fotoable.youtube.music.ui.activity.bf;
import com.fotoable.youtube.music.ui.activity.bj;
import com.fotoable.youtube.music.ui.activity.bm;
import com.fotoable.youtube.music.ui.activity.bq;
import com.fotoable.youtube.music.ui.activity.p;
import com.fotoable.youtube.music.ui.activity.q;
import com.fotoable.youtube.music.ui.activity.u;
import com.fotoable.youtube.music.ui.activity.y;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import javax.inject.Provider;
/* compiled from: DaggerActivityComponent.java */
/* loaded from: classes.dex */
public final class c implements com.fotoable.youtube.music.c.a.a {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2325a;
    private MembersInjector<PlayerActivity> A;
    private MembersInjector<RadioListActivity> B;
    private MembersInjector<CountryActivity> C;
    private MembersInjector<LocalPlayListDetailActivity> D;
    private MembersInjector<EditorChoicePlayListActivity> E;
    private MembersInjector<FeaturedPlayListDetailsActivity> F;
    private MembersInjector<LocalCreatedPlaylistDetailActivity> G;
    private MembersInjector<UserInfoActivity> H;
    private MembersInjector<YoutubeCommentActivity> I;
    private MembersInjector<CommunityPostActivity> J;
    private MembersInjector<CommunityPostDetailActivity> K;
    private MembersInjector<CommunityPostImagePreviewActivity> L;

    /* renamed from: b  reason: collision with root package name */
    private Provider<com.fotoable.youtube.music.b.c> f2326b;

    /* renamed from: c  reason: collision with root package name */
    private MembersInjector<SplashActivity> f2327c;
    private MembersInjector<MainActivity> d;
    private Provider<com.fotoable.youtube.music.b.a> e;
    private Provider<com.fotoable.youtube.music.b.e> f;
    private MembersInjector<SearchActivity> g;
    private Provider<com.fotoable.youtube.music.db.a> h;
    private Provider<ad> i;
    private MembersInjector<MyFavoriteActivity> j;
    private Provider<al> k;
    private MembersInjector<MySubscriptionActivity> l;
    private Provider<ag> m;
    private MembersInjector<MyRecentlyWatchedActivity> n;
    private Provider<BaseActivity> o;
    private MembersInjector<PlayListDetailsActivity> p;
    private Provider<r> q;
    private MembersInjector<GlobalMusicDetailsActivity> r;
    private Provider<com.fotoable.youtube.music.d.d> s;
    private MembersInjector<ClassifiedMusicDetailsActivity> t;
    private MembersInjector<MusicRecognitionActivity> u;
    private MembersInjector<MusicRecognitionHistoryActivity> v;
    private MembersInjector<MyPlaylistDetailActivity> w;
    private MembersInjector<MyPlaylistActivity> x;
    private MembersInjector<HomeListActivity> y;
    private MembersInjector<Radio1Activity> z;

    static {
        f2325a = !c.class.desiredAssertionStatus();
    }

    private c(a aVar) {
        if (!f2325a && aVar == null) {
            throw new AssertionError();
        }
        a(aVar);
    }

    public static a a() {
        return new a();
    }

    private void a(final a aVar) {
        this.f2326b = new Factory<com.fotoable.youtube.music.b.c>() { // from class: com.fotoable.youtube.music.c.a.c.1

            /* renamed from: c  reason: collision with root package name */
            private final b f2330c;

            {
                this.f2330c = aVar.f2341b;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public com.fotoable.youtube.music.b.c get() {
                return (com.fotoable.youtube.music.b.c) Preconditions.checkNotNull(this.f2330c.a(), "Cannot return null from a non-@Nullable component method");
            }
        };
        this.f2327c = bj.a(this.f2326b);
        this.d = am.a(this.f2326b);
        this.e = new Factory<com.fotoable.youtube.music.b.a>() { // from class: com.fotoable.youtube.music.c.a.c.2

            /* renamed from: c  reason: collision with root package name */
            private final b f2333c;

            {
                this.f2333c = aVar.f2341b;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public com.fotoable.youtube.music.b.a get() {
                return (com.fotoable.youtube.music.b.a) Preconditions.checkNotNull(this.f2333c.c(), "Cannot return null from a non-@Nullable component method");
            }
        };
        this.f = new Factory<com.fotoable.youtube.music.b.e>() { // from class: com.fotoable.youtube.music.c.a.c.3

            /* renamed from: c  reason: collision with root package name */
            private final b f2336c;

            {
                this.f2336c = aVar.f2341b;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public com.fotoable.youtube.music.b.e get() {
                return (com.fotoable.youtube.music.b.e) Preconditions.checkNotNull(this.f2336c.b(), "Cannot return null from a non-@Nullable component method");
            }
        };
        this.g = bf.a(this.f2326b, this.e, this.f);
        this.h = new Factory<com.fotoable.youtube.music.db.a>() { // from class: com.fotoable.youtube.music.c.a.c.4

            /* renamed from: c  reason: collision with root package name */
            private final b f2339c;

            {
                this.f2339c = aVar.f2341b;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public com.fotoable.youtube.music.db.a get() {
                return (com.fotoable.youtube.music.db.a) Preconditions.checkNotNull(this.f2339c.d(), "Cannot return null from a non-@Nullable component method");
            }
        };
        this.i = af.a(MembersInjectors.noOp(), this.h);
        this.j = ar.a(this.h, this.i);
        this.k = an.a(MembersInjectors.noOp(), this.h);
        this.l = aw.a(this.h, this.k);
        this.m = ak.a(MembersInjectors.noOp(), this.h);
        this.n = av.a(this.h, this.m);
        this.o = DoubleCheck.provider(com.fotoable.youtube.music.c.b.b.a(aVar.f2340a));
        this.p = ba.a(this.f, this.h, this.f2326b);
        this.q = v.a(MembersInjectors.noOp(), this.f2326b, this.h);
        this.r = ab.a(this.q, this.f2326b);
        this.s = com.fotoable.youtube.music.d.h.a(MembersInjectors.noOp(), this.f2326b, this.h);
        this.t = com.fotoable.youtube.music.ui.activity.d.a(this.s);
        this.u = com.fotoable.youtube.music.ui.activity.an.a(this.f, this.h);
        this.v = ao.a(this.h);
        this.w = au.a(this.h);
        this.x = as.a(this.h);
        this.y = com.fotoable.youtube.music.ui.activity.ad.a(this.h, this.f2326b);
        this.z = bc.a(this.f2326b);
        this.A = bb.a(this.h, this.f2326b);
        this.B = be.a(this.f2326b);
        this.C = com.fotoable.youtube.music.ui.activity.r.a(this.f2326b);
        this.D = com.fotoable.youtube.music.ui.activity.ak.a(this.h);
        this.E = u.a(this.f2326b);
        this.F = y.a(this.h, this.f2326b);
        this.G = ai.a(this.h);
        this.H = bm.a(this.f2326b);
        this.I = bq.a(this.h, this.f2326b);
        this.J = com.fotoable.youtube.music.ui.activity.h.a(this.f2326b);
        this.K = p.a(this.h, this.f2326b);
        this.L = q.a(this.f2326b);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(SplashActivity splashActivity) {
        this.f2327c.injectMembers(splashActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(MainActivity mainActivity) {
        this.d.injectMembers(mainActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(SearchActivity searchActivity) {
        this.g.injectMembers(searchActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(MyFavoriteActivity myFavoriteActivity) {
        this.j.injectMembers(myFavoriteActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(MySubscriptionActivity mySubscriptionActivity) {
        this.l.injectMembers(mySubscriptionActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(MyRecentlyWatchedActivity myRecentlyWatchedActivity) {
        this.n.injectMembers(myRecentlyWatchedActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(SettingsActivity settingsActivity) {
        MembersInjectors.noOp().injectMembers(settingsActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(PlayListDetailsActivity playListDetailsActivity) {
        this.p.injectMembers(playListDetailsActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(GlobalMusicDetailsActivity globalMusicDetailsActivity) {
        this.r.injectMembers(globalMusicDetailsActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(ClassifiedMusicDetailsActivity classifiedMusicDetailsActivity) {
        this.t.injectMembers(classifiedMusicDetailsActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(MusicRecognitionActivity musicRecognitionActivity) {
        this.u.injectMembers(musicRecognitionActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(MusicRecognitionHistoryActivity musicRecognitionHistoryActivity) {
        this.v.injectMembers(musicRecognitionHistoryActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(ArtistsDetailActivity artistsDetailActivity) {
        MembersInjectors.noOp().injectMembers(artistsDetailActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(GenresDetailActivity genresDetailActivity) {
        MembersInjectors.noOp().injectMembers(genresDetailActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(MyPlaylistDetailActivity myPlaylistDetailActivity) {
        this.w.injectMembers(myPlaylistDetailActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(MyPlaylistActivity myPlaylistActivity) {
        this.x.injectMembers(myPlaylistActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(HomeListActivity homeListActivity) {
        this.y.injectMembers(homeListActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(PlaySettingsActivity playSettingsActivity) {
        MembersInjectors.noOp().injectMembers(playSettingsActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(Radio1Activity radio1Activity) {
        this.z.injectMembers(radio1Activity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(PlayerActivity playerActivity) {
        this.A.injectMembers(playerActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(RadioActivity radioActivity) {
        MembersInjectors.noOp().injectMembers(radioActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(RadioListActivity radioListActivity) {
        this.B.injectMembers(radioListActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(CountryActivity countryActivity) {
        this.C.injectMembers(countryActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(RadioHomeActivity radioHomeActivity) {
        MembersInjectors.noOp().injectMembers(radioHomeActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(ArtistsActivity artistsActivity) {
        MembersInjectors.noOp().injectMembers(artistsActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(GenresActivity genresActivity) {
        MembersInjectors.noOp().injectMembers(genresActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(ChartsActivity chartsActivity) {
        MembersInjectors.noOp().injectMembers(chartsActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(AboutActivity aboutActivity) {
        MembersInjectors.noOp().injectMembers(aboutActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(LocalSearchMusicActivity localSearchMusicActivity) {
        MembersInjectors.noOp().injectMembers(localSearchMusicActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(LocalPlayListDetailActivity localPlayListDetailActivity) {
        this.D.injectMembers(localPlayListDetailActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(EditorChoicePlayListActivity editorChoicePlayListActivity) {
        this.E.injectMembers(editorChoicePlayListActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(FeaturedPlayListDetailsActivity featuredPlayListDetailsActivity) {
        this.F.injectMembers(featuredPlayListDetailsActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(LocalCreatedPlaylistDetailActivity localCreatedPlaylistDetailActivity) {
        this.G.injectMembers(localCreatedPlaylistDetailActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(UserInfoActivity userInfoActivity) {
        this.H.injectMembers(userInfoActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(YoutubeCommentActivity youtubeCommentActivity) {
        this.I.injectMembers(youtubeCommentActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(CommunityPostActivity communityPostActivity) {
        this.J.injectMembers(communityPostActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(CommunityPostDetailActivity communityPostDetailActivity) {
        this.K.injectMembers(communityPostDetailActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.a
    public void a(CommunityPostImagePreviewActivity communityPostImagePreviewActivity) {
        this.L.injectMembers(communityPostImagePreviewActivity);
    }

    /* compiled from: DaggerActivityComponent.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private com.fotoable.youtube.music.c.b.a f2340a;

        /* renamed from: b  reason: collision with root package name */
        private b f2341b;

        private a() {
        }

        public com.fotoable.youtube.music.c.a.a a() {
            if (this.f2340a == null) {
                throw new IllegalStateException(com.fotoable.youtube.music.c.b.a.class.getCanonicalName() + " must be set");
            }
            if (this.f2341b == null) {
                throw new IllegalStateException(b.class.getCanonicalName() + " must be set");
            }
            return new c(this);
        }

        public a a(com.fotoable.youtube.music.c.b.a aVar) {
            this.f2340a = (com.fotoable.youtube.music.c.b.a) Preconditions.checkNotNull(aVar);
            return this;
        }

        public a a(b bVar) {
            this.f2341b = (b) Preconditions.checkNotNull(bVar);
            return this;
        }
    }
}

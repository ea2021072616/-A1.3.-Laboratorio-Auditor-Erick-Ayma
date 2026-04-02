package com.fotoable.youtube.music.b;

import android.content.Context;
import android.text.TextUtils;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.bean.ArtistBean;
import com.fotoable.youtube.music.bean.CarouselBean;
import com.fotoable.youtube.music.bean.CategoryListBean;
import com.fotoable.youtube.music.bean.ClassifiedRankBean;
import com.fotoable.youtube.music.bean.ClassifiedRankVideoBean;
import com.fotoable.youtube.music.bean.CountryCodeModel;
import com.fotoable.youtube.music.bean.EditorChoiceBean;
import com.fotoable.youtube.music.bean.FeaturedDetailBean;
import com.fotoable.youtube.music.bean.FeaturedPlaylistBean;
import com.fotoable.youtube.music.bean.GenresBean;
import com.fotoable.youtube.music.bean.GlobalRankBean;
import com.fotoable.youtube.music.bean.GlobalRankVideoBean;
import com.fotoable.youtube.music.bean.HomeListNewBean;
import com.fotoable.youtube.music.bean.HotKeyBean;
import com.fotoable.youtube.music.bean.MyHttpResponse;
import com.fotoable.youtube.music.bean.PlayBean;
import com.fotoable.youtube.music.bean.PostBean;
import com.fotoable.youtube.music.bean.Radio1Bean;
import com.fotoable.youtube.music.bean.RadioBean;
import com.fotoable.youtube.music.bean.RadioCountryBean;
import com.fotoable.youtube.music.bean.RanBean;
import com.fotoable.youtube.music.bean.UpdateInfo;
import com.fotoable.youtube.music.bean.UserInfoModel;
import com.fotoable.youtube.music.bean.YouTubekeyBean;
import com.fotoable.youtube.music.bean.YoutubeComment;
import com.fotoable.youtube.music.util.h;
import com.fotoable.youtube.music.util.p;
import com.fotoable.youtube.music.util.s;
import com.fotoable.youtube.music.util.v;
import com.fotoable.youtube.music.util.w;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import rx.f;
import rx.l;
import rx.schedulers.Schedulers;
/* compiled from: MusicApiManager.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2248a = c.class.getSimpleName();
    private com.fotoable.youtube.music.b.b.b f;
    private com.fotoable.youtube.music.b.d.d h;
    private com.fotoable.youtube.music.b.d.c i;
    private com.fotoable.youtube.music.b.d.b j;
    private Gson g = new Gson();

    /* renamed from: b  reason: collision with root package name */
    private com.fotoable.youtube.music.b.a.b f2249b = com.fotoable.youtube.music.b.a.b.a();

    /* renamed from: c  reason: collision with root package name */
    private com.fotoable.youtube.music.b.a.a f2250c = com.fotoable.youtube.music.b.a.a.a();
    private com.fotoable.youtube.music.b.b.a d = new com.fotoable.youtube.music.b.b.a(this.f2249b);
    private com.fotoable.youtube.music.b.b.a e = new com.fotoable.youtube.music.b.b.a(this.f2250c);

    public c(com.fotoable.youtube.music.b.d.d dVar, com.fotoable.youtube.music.b.d.c cVar, com.fotoable.youtube.music.b.d.b bVar) {
        this.h = dVar;
        this.i = cVar;
        this.j = bVar;
        this.f = new com.fotoable.youtube.music.b.b.b(dVar, this.f2249b, this.f2250c);
    }

    public f<MyHttpResponse<ArrayList<HomeListNewBean>>> a(int i, String str) {
        return this.h.a(i, str).e(new p(3, 50));
    }

    public f<MyHttpResponse<ArrayList<HomeListNewBean>>> b(int i, String str) {
        return this.h.b(i, str).e(new p(3, 50));
    }

    public f<MyHttpResponse<ArrayList<PlayBean>>> a(int i, int i2, long j) {
        return this.h.a(i, i2, j).e(new p(3, 50));
    }

    public f<MyHttpResponse<ArrayList<RanBean>>> a() {
        return this.h.a().e(new p(3, 50));
    }

    public f<MyHttpResponse<List<HotKeyBean>>> b() {
        return this.h.b().e(new p(3, 50));
    }

    public f<MyHttpResponse<YouTubekeyBean>> c() {
        return this.h.c().e(new p(3, 50));
    }

    public f<MyHttpResponse<ArrayList<GlobalRankBean>>> d() {
        return this.h.d().e(new p(3, 50));
    }

    public f<MyHttpResponse<ArrayList<GlobalRankVideoBean>>> a(int i, int i2, long j, int i3) {
        return this.h.a(i, i2, j, i3).e(new p(3, 50));
    }

    public f<MyHttpResponse<ArrayList<ClassifiedRankBean>>> e() {
        return this.h.e().e(new p(3, 50));
    }

    public f<MyHttpResponse<ArrayList<ClassifiedRankVideoBean>>> b(int i, int i2, long j, int i3) {
        return this.h.b(i, i2, j, i3).e(new p(3, 50));
    }

    public void f() {
        this.i.a(System.currentTimeMillis()).b(Schedulers.io()).b(new l<CountryCodeModel>() { // from class: com.fotoable.youtube.music.b.c.1
            @Override // rx.g
            public void onCompleted() {
                h.a(c.f2248a, "国家码," + v.a(MusicApplication.c(), "country_code", (String) null));
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(CountryCodeModel countryCodeModel) {
                if (countryCodeModel != null && !TextUtils.isEmpty(countryCodeModel.getCountryCode())) {
                    String countryCode = countryCodeModel.getCountryCode();
                    if (!TextUtils.equals(v.a(MusicApplication.c(), "country_code", (String) null), countryCode)) {
                        v.b(MusicApplication.c(), "country_code", countryCode);
                    }
                    v.b((Context) MusicApplication.c(), "country_code_is_local", false);
                    h.a(c.f2248a, "获取国家码成功：" + countryCode);
                }
            }
        });
    }

    public f<MyHttpResponse<UpdateInfo>> g() {
        return this.h.a(w.c(MusicApplication.c()), w.e(MusicApplication.c()));
    }

    public f<MyHttpResponse<ArrayList<ArtistBean>>> h() {
        return this.h.f().e(new p(3, 50));
    }

    public f<MyHttpResponse<ArrayList<GenresBean>>> i() {
        return f.a(new f.a(this) { // from class: com.fotoable.youtube.music.b.d

            /* renamed from: a  reason: collision with root package name */
            private final c f2300a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2300a = this;
            }

            @Override // rx.c.b
            public void call(Object obj) {
                this.f2300a.a((l) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(l lVar) {
        if (lVar != null && !lVar.isUnsubscribed()) {
            String a2 = com.fotoable.youtube.music.util.e.a(MusicApplication.c(), "genres.json");
            h.a(f2248a, "读取流派数据");
            if (!TextUtils.isEmpty(a2)) {
                MyHttpResponse myHttpResponse = (MyHttpResponse) this.g.fromJson(a2, new TypeToken<MyHttpResponse<ArrayList<GenresBean>>>() { // from class: com.fotoable.youtube.music.b.c.12
                }.getType());
                h.a(f2248a, "解析流派数据");
                if (myHttpResponse != null) {
                    if (myHttpResponse.getData() != null && ((ArrayList) myHttpResponse.getData()).size() > 0 && myHttpResponse.getData() != null && ((ArrayList) myHttpResponse.getData()).size() > 0) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= ((ArrayList) myHttpResponse.getData()).size()) {
                                break;
                            }
                            GenresBean genresBean = (GenresBean) ((ArrayList) myHttpResponse.getData()).get(i2);
                            if (genresBean != null) {
                                genresBean.setNameEs(genresBean.getName());
                                genresBean.setGroup(b.a().a(genresBean.getGroup()));
                                genresBean.setKeywords(b.a().c(genresBean.getName()));
                                genresBean.setName(b.a().b(genresBean.getName()));
                            }
                            i = i2 + 1;
                        }
                        h.a(f2248a, "设置流派数据多语言映射");
                    }
                    lVar.onNext(myHttpResponse);
                } else {
                    lVar.onNext(null);
                }
            } else {
                lVar.onNext(null);
            }
            lVar.onCompleted();
        }
    }

    public f<MyHttpResponse<ArrayList<CarouselBean>>> j() {
        return this.h.g().e(new p(3, 50));
    }

    public f<MyHttpResponse> a(String str, int i) {
        return this.h.a(str, i);
    }

    public f<MyHttpResponse<List<Radio1Bean>>> k() {
        return f.a((f.a) new f.a<MyHttpResponse<List<Radio1Bean>>>() { // from class: com.fotoable.youtube.music.b.c.14
            @Override // rx.c.b
            /* renamed from: a */
            public void call(l<? super MyHttpResponse<List<Radio1Bean>>> lVar) {
                if (lVar != null && !lVar.isUnsubscribed()) {
                    String a2 = com.fotoable.youtube.music.util.e.a(MusicApplication.c(), "radio.json");
                    if (!TextUtils.isEmpty(a2)) {
                        lVar.onNext((MyHttpResponse) c.this.g.fromJson(a2, new TypeToken<MyHttpResponse<List<Radio1Bean>>>() { // from class: com.fotoable.youtube.music.b.c.14.1
                        }.getType()));
                    } else {
                        lVar.onNext(null);
                    }
                }
            }
        });
    }

    public f<MyHttpResponse<List<RadioBean>>> a(int i, int i2) {
        return this.h.a(i, i2, v.a(MusicApplication.c(), "country_code", ""));
    }

    public f<MyHttpResponse<List<RadioCountryBean>>> l() {
        return this.h.h();
    }

    public f<MyHttpResponse<List<RadioBean>>> a(int i, int i2, String str) {
        return this.h.b(i, i2, str);
    }

    public f<MyHttpResponse> a(String str, String str2) {
        return this.h.b(str, str2);
    }

    public f<MyHttpResponse<List<RadioCountryBean>>> m() {
        return this.h.i();
    }

    public f<MyHttpResponse<List<EditorChoiceBean>>> a(String str) {
        return this.h.a(str);
    }

    public f<MyHttpResponse<List<PlayBean>>> a(int i, int i2, int i3, long j) {
        return this.h.a(i, i2, i3, j, Locale.US.getCountry()).e(new p(3, 50));
    }

    public f<MyHttpResponse<List<FeaturedPlaylistBean>>> n() {
        return this.h.b(Locale.US.getCountry());
    }

    public f<MyHttpResponse<CategoryListBean>> o() {
        return this.h.j();
    }

    public f<MyHttpResponse<List<PlayBean>>> b(int i, int i2, int i3, long j) {
        return this.h.a(i, i2, i3, j);
    }

    public f<MyHttpResponse<List<FeaturedDetailBean>>> a(int i, String str, int i2, int i3, long j) {
        return this.h.a(i, str, i2, i3, j);
    }

    public f<MyHttpResponse<ArrayList<GlobalRankVideoBean>>> b(int i, int i2, long j) {
        return this.h.b(i, i2, j).e(new p(3, 50));
    }

    public void p() {
        UserInfoModel userInfoModel;
        try {
            if (MusicApplication.c().h() == null) {
                String a2 = v.a(MusicApplication.c(), "user_info_data", (String) null);
                if (!TextUtils.isEmpty(a2) && (userInfoModel = (UserInfoModel) this.g.fromJson(a2, (Class<Object>) UserInfoModel.class)) != null && !TextUtils.isEmpty(userInfoModel.getAuth())) {
                    MusicApplication.c().a(userInfoModel);
                    com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2020));
                    h.a(f2248a, "读取用户本地数据");
                }
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public void a(UserInfoModel userInfoModel) {
        if (userInfoModel != null && !TextUtils.isEmpty(userInfoModel.getAuth())) {
            v.b(MusicApplication.c(), "user_info_data", this.g.toJson(userInfoModel));
        }
    }

    public void q() {
        p();
        this.j.a(w.a()).e(new p(3, 50)).a(s.a()).a((f.c<? super R, ? extends R>) s.b()).b(new l<UserInfoModel>() { // from class: com.fotoable.youtube.music.b.c.15
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(UserInfoModel userInfoModel) {
                if (userInfoModel != null && !TextUtils.isEmpty(userInfoModel.getAuth())) {
                    v.b(MusicApplication.c(), "user_info_data", c.this.g.toJson(userInfoModel));
                    MusicApplication.c().a(userInfoModel);
                    com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2020));
                    h.a(c.f2248a, "获取用户数据成功");
                }
            }
        });
    }

    private f<UserInfoModel> t() {
        return this.j.a(w.a()).e(new p(3, 50)).a(s.b()).a(new rx.c.b<UserInfoModel>() { // from class: com.fotoable.youtube.music.b.c.16
            @Override // rx.c.b
            /* renamed from: a */
            public void call(UserInfoModel userInfoModel) {
                if (userInfoModel != null && !TextUtils.isEmpty(userInfoModel.getAuth())) {
                    v.b(MusicApplication.c(), "user_info_data", c.this.g.toJson(userInfoModel));
                    MusicApplication.c().a(userInfoModel);
                    com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2020));
                    h.a(c.f2248a, "获取用户数据成功");
                    return;
                }
                throw new NullPointerException("获取到用户数据为空");
            }
        });
    }

    public f<MyHttpResponse<UserInfoModel>> b(final String str) {
        String str2;
        p();
        if (MusicApplication.c().h() == null) {
            return t().b(new rx.c.e<UserInfoModel, f<MyHttpResponse<UserInfoModel>>>() { // from class: com.fotoable.youtube.music.b.c.17
                @Override // rx.c.e
                public f<MyHttpResponse<UserInfoModel>> a(UserInfoModel userInfoModel) {
                    RequestBody create = RequestBody.create(MediaType.parse("image/jpg"), new File(str));
                    String str3 = str;
                    try {
                        str3 = str3.substring(str3.lastIndexOf("/") + 1);
                    } catch (Exception e) {
                        ThrowableExtension.printStackTrace(e);
                    }
                    return c.this.j.a(MultipartBody.Part.createFormData("avatar", "" + str3, create)).e(new p(3, 50));
                }
            });
        }
        try {
            str2 = str.substring(str.lastIndexOf("/") + 1);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
            str2 = str;
        }
        return this.j.a(MultipartBody.Part.createFormData("avatar", str2, RequestBody.create(MediaType.parse("image/jpg"), new File(str)))).e(new p(3, 50));
    }

    public f<MyHttpResponse<UserInfoModel>> c(final String str) {
        p();
        return MusicApplication.c().h() == null ? t().b(new rx.c.e<UserInfoModel, f<MyHttpResponse<UserInfoModel>>>() { // from class: com.fotoable.youtube.music.b.c.18
            @Override // rx.c.e
            public f<MyHttpResponse<UserInfoModel>> a(UserInfoModel userInfoModel) {
                return c.this.j.b(str).e(new p(3, 50));
            }
        }) : this.j.b(str).e(new p(3, 50));
    }

    public f<MyHttpResponse<List<YoutubeComment>>> a(final String str, final int i, final int i2, final long j, final int i3) {
        p();
        return MusicApplication.c().h() == null ? t().b(new rx.c.e<UserInfoModel, f<MyHttpResponse<List<YoutubeComment>>>>() { // from class: com.fotoable.youtube.music.b.c.19
            @Override // rx.c.e
            public f<MyHttpResponse<List<YoutubeComment>>> a(UserInfoModel userInfoModel) {
                return c.this.j.a(str, i, i2, j, i3).e(new p(3, 50));
            }
        }) : this.j.a(str, i, i2, j, i3).e(new p(3, 50));
    }

    public f<MyHttpResponse<YoutubeComment>> a(final String str, final String str2, final int i, final int i2, final String str3, final String str4) {
        p();
        return MusicApplication.c().h() == null ? t().b(new rx.c.e<UserInfoModel, f<MyHttpResponse<YoutubeComment>>>() { // from class: com.fotoable.youtube.music.b.c.2
            @Override // rx.c.e
            public f<MyHttpResponse<YoutubeComment>> a(UserInfoModel userInfoModel) {
                return c.this.j.a(str, str2, i, i2, str3, str4).e(new p(3, 50));
            }
        }) : this.j.a(str, str2, i, i2, str3, str4).e(new p(3, 50));
    }

    public f<MyHttpResponse<YoutubeComment>> b(final String str, final String str2) {
        p();
        return MusicApplication.c().h() == null ? t().b(new rx.c.e<UserInfoModel, f<MyHttpResponse<YoutubeComment>>>() { // from class: com.fotoable.youtube.music.b.c.3
            @Override // rx.c.e
            public f<MyHttpResponse<YoutubeComment>> a(UserInfoModel userInfoModel) {
                return c.this.j.a(str, str2).e(new p(3, 50));
            }
        }) : this.j.a(str, str2).e(new p(3, 50));
    }

    public f<MyHttpResponse<YoutubeComment>> c(final String str, final String str2) {
        p();
        return MusicApplication.c().h() == null ? t().b(new rx.c.e<UserInfoModel, f<MyHttpResponse<YoutubeComment>>>() { // from class: com.fotoable.youtube.music.b.c.4
            @Override // rx.c.e
            public f<MyHttpResponse<YoutubeComment>> a(UserInfoModel userInfoModel) {
                return c.this.j.b(str, str2).e(new p(3, 50));
            }
        }) : this.j.b(str, str2).e(new p(3, 50));
    }

    public f<MyHttpResponse<YoutubeComment>> d(final String str) {
        p();
        return MusicApplication.c().h() == null ? t().b(new rx.c.e<UserInfoModel, f<MyHttpResponse<YoutubeComment>>>() { // from class: com.fotoable.youtube.music.b.c.5
            @Override // rx.c.e
            public f<MyHttpResponse<YoutubeComment>> a(UserInfoModel userInfoModel) {
                return c.this.j.c(str).e(new p(3, 50));
            }
        }) : this.j.c(str).e(new p(3, 50));
    }

    public f<MyHttpResponse<PostBean>> a(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8, final List<MultipartBody.Part> list) {
        p();
        if (MusicApplication.c().h() == null) {
            return t().b(new rx.c.e<UserInfoModel, f<MyHttpResponse<PostBean>>>() { // from class: com.fotoable.youtube.music.b.c.6
                @Override // rx.c.e
                public f<MyHttpResponse<PostBean>> a(UserInfoModel userInfoModel) {
                    if (list == null || list.size() == 0) {
                        return c.this.j.a(str, str2, str3, str4, str5, str6, str7, str8).e(new p(3, 50));
                    }
                    return c.this.j.a(str, str2, str3, str4, str5, str6, str7, str8, list).e(new p(3, 50));
                }
            });
        }
        if (list == null || list.size() == 0) {
            return this.j.a(str, str2, str3, str4, str5, str6, str7, str8).e(new p(3, 50));
        }
        return this.j.a(str, str2, str3, str4, str5, str6, str7, str8, list).e(new p(3, 50));
    }

    public f<MyHttpResponse<List<PostBean>>> a(final String str, final int i, final int i2, final long j) {
        p();
        final String language = Locale.getDefault().getLanguage();
        return MusicApplication.c().h() == null ? t().b(new rx.c.e<UserInfoModel, f<MyHttpResponse<List<PostBean>>>>() { // from class: com.fotoable.youtube.music.b.c.7
            @Override // rx.c.e
            public f<MyHttpResponse<List<PostBean>>> a(UserInfoModel userInfoModel) {
                return c.this.j.a(str, i, i2, j, language).e(new p(3, 50));
            }
        }) : this.j.a(str, i, i2, j, language).e(new p(3, 50));
    }

    public f<MyHttpResponse<PostBean>> e(final String str) {
        p();
        return MusicApplication.c().h() == null ? t().b(new rx.c.e<UserInfoModel, f<MyHttpResponse<PostBean>>>() { // from class: com.fotoable.youtube.music.b.c.8
            @Override // rx.c.e
            public f<MyHttpResponse<PostBean>> a(UserInfoModel userInfoModel) {
                return c.this.j.d(str).e(new p(3, 50));
            }
        }) : this.j.d(str).e(new p(3, 50));
    }

    public f<MyHttpResponse<PostBean>> d(final String str, final String str2) {
        p();
        return MusicApplication.c().h() == null ? t().b(new rx.c.e<UserInfoModel, f<MyHttpResponse<PostBean>>>() { // from class: com.fotoable.youtube.music.b.c.9
            @Override // rx.c.e
            public f<MyHttpResponse<PostBean>> a(UserInfoModel userInfoModel) {
                return c.this.j.c(str, str2).e(new p(3, 50));
            }
        }) : this.j.c(str, str2).e(new p(3, 50));
    }

    public f<MyHttpResponse<PostBean>> f(final String str) {
        p();
        return MusicApplication.c().h() == null ? t().b(new rx.c.e<UserInfoModel, f<MyHttpResponse<PostBean>>>() { // from class: com.fotoable.youtube.music.b.c.10
            @Override // rx.c.e
            public f<MyHttpResponse<PostBean>> a(UserInfoModel userInfoModel) {
                return c.this.j.e(str).e(new p(3, 50));
            }
        }) : this.j.e(str).e(new p(3, 50));
    }

    public f<ResponseBody> g(String str) {
        return this.j.f(str);
    }

    public f<MyHttpResponse<PostBean>> h(final String str) {
        p();
        return MusicApplication.c().h() == null ? t().b(new rx.c.e<UserInfoModel, f<MyHttpResponse<PostBean>>>() { // from class: com.fotoable.youtube.music.b.c.11
            @Override // rx.c.e
            public f<MyHttpResponse<PostBean>> a(UserInfoModel userInfoModel) {
                return c.this.j.g(str).e(new p(3, 50));
            }
        }) : this.j.g(str).e(new p(3, 50));
    }

    public f<MyHttpResponse<UserInfoModel>> r() {
        p();
        if (MusicApplication.c().h() == null) {
            return t().b(new rx.c.e<UserInfoModel, f<MyHttpResponse<UserInfoModel>>>() { // from class: com.fotoable.youtube.music.b.c.13
                @Override // rx.c.e
                public f<MyHttpResponse<UserInfoModel>> a(UserInfoModel userInfoModel) {
                    return c.this.j.a(com.fotoable.youtube.music.a.h() ? 1 : 0).e(new p(3, 50));
                }
            });
        }
        return this.j.a(com.fotoable.youtube.music.a.h() ? 1 : 0).e(new p(3, 50));
    }
}

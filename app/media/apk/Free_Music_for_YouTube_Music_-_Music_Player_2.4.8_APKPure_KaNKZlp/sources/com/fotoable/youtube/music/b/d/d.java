package com.fotoable.youtube.music.b.d;

import com.fotoable.youtube.music.bean.ArtistBean;
import com.fotoable.youtube.music.bean.CarouselBean;
import com.fotoable.youtube.music.bean.CategoryListBean;
import com.fotoable.youtube.music.bean.ClassifiedRankBean;
import com.fotoable.youtube.music.bean.ClassifiedRankVideoBean;
import com.fotoable.youtube.music.bean.EditorChoiceBean;
import com.fotoable.youtube.music.bean.FeaturedDetailBean;
import com.fotoable.youtube.music.bean.FeaturedPlaylistBean;
import com.fotoable.youtube.music.bean.GlobalRankBean;
import com.fotoable.youtube.music.bean.GlobalRankVideoBean;
import com.fotoable.youtube.music.bean.HomeListNewBean;
import com.fotoable.youtube.music.bean.HotKeyBean;
import com.fotoable.youtube.music.bean.MyHttpResponse;
import com.fotoable.youtube.music.bean.PlayBean;
import com.fotoable.youtube.music.bean.RadioBean;
import com.fotoable.youtube.music.bean.RadioCountryBean;
import com.fotoable.youtube.music.bean.RanBean;
import com.fotoable.youtube.music.bean.UpdateInfo;
import com.fotoable.youtube.music.bean.YouTubekeyBean;
import java.util.ArrayList;
import java.util.List;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.f;
/* compiled from: YoutubeMusicApiService.java */
/* loaded from: classes.dex */
public interface d {
    @GET("home/rank")
    f<MyHttpResponse<ArrayList<RanBean>>> a();

    @GET("home/categoryPlaylistLists")
    f<MyHttpResponse<List<PlayBean>>> a(@Query("categoryid") int i, @Query("skip") int i2, @Query("limit") int i3, @Query("mixid") long j);

    @GET("home/choicePlaylist")
    f<MyHttpResponse<List<PlayBean>>> a(@Query("choiceid") int i, @Query("skip") int i2, @Query("limit") int i3, @Query("mixid") long j, @Query("countryCode") String str);

    @GET("home/playlists")
    f<MyHttpResponse<ArrayList<PlayBean>>> a(@Query("skip") int i, @Query("limit") int i2, @Query("mixid") long j);

    @GET("/home/globalRankVideoLists")
    f<MyHttpResponse<ArrayList<GlobalRankVideoBean>>> a(@Query("skip") int i, @Query("limit") int i2, @Query("mixid") long j, @Query("chartsid") int i3);

    @GET("radio/hotRadios")
    f<MyHttpResponse<List<RadioBean>>> a(@Query("skip") int i, @Query("limit") int i2, @Query("countryCode") String str);

    @GET("home/homeLists")
    f<MyHttpResponse<ArrayList<HomeListNewBean>>> a(@Query("limit") int i, @Query("pageToken") String str);

    @GET("/home/categoryPlaylistVideoLists")
    f<MyHttpResponse<List<FeaturedDetailBean>>> a(@Query("type") int i, @Query("playlistid") String str, @Query("skip") int i2, @Query("limit") int i3, @Query("mixid") long j);

    @GET("home/choice")
    f<MyHttpResponse<List<EditorChoiceBean>>> a(@Query("countryCode") String str);

    @FormUrlEncoded
    @POST("public/offlineVideo")
    f<MyHttpResponse> a(@Field("id") String str, @Field("type") int i);

    @GET("public/appVersionCode?os=android")
    f<MyHttpResponse<UpdateInfo>> a(@Query("packageName") String str, @Query("versionCode") String str2);

    @GET("/search/trending")
    f<MyHttpResponse<List<HotKeyBean>>> b();

    @GET("/country/countryChartsVideoLists")
    f<MyHttpResponse<ArrayList<GlobalRankVideoBean>>> b(@Query("skip") int i, @Query("limit") int i2, @Query("mixid") long j);

    @GET("/home/categoryRankVideoLists")
    f<MyHttpResponse<ArrayList<ClassifiedRankVideoBean>>> b(@Query("skip") int i, @Query("limit") int i2, @Query("mixid") long j, @Query("chartsid") int i3);

    @GET("radio/allRadios")
    f<MyHttpResponse<List<RadioBean>>> b(@Query("skip") int i, @Query("limit") int i2, @Query("countryCode") String str);

    @GET("/home/newVideoLists")
    f<MyHttpResponse<ArrayList<HomeListNewBean>>> b(@Query("limit") int i, @Query("pageToken") String str);

    @GET("home/featured")
    f<MyHttpResponse<List<FeaturedPlaylistBean>>> b(@Query("countryCode") String str);

    @GET("radio/feedback")
    f<MyHttpResponse> b(@Query("id") String str, @Query("countryCode") String str2);

    @GET("/user/getConf")
    f<MyHttpResponse<YouTubekeyBean>> c();

    @GET("/home/globalRank")
    f<MyHttpResponse<ArrayList<GlobalRankBean>>> d();

    @GET("/home/categoryRank")
    f<MyHttpResponse<ArrayList<ClassifiedRankBean>>> e();

    @GET("/artist/lists")
    f<MyHttpResponse<ArrayList<ArtistBean>>> f();

    @GET("home/slideshows")
    f<MyHttpResponse<ArrayList<CarouselBean>>> g();

    @GET("radio/hotCountries")
    f<MyHttpResponse<List<RadioCountryBean>>> h();

    @GET("radio/allCountries")
    f<MyHttpResponse<List<RadioCountryBean>>> i();

    @GET("home/playlistCategoryLists")
    f<MyHttpResponse<CategoryListBean>> j();
}

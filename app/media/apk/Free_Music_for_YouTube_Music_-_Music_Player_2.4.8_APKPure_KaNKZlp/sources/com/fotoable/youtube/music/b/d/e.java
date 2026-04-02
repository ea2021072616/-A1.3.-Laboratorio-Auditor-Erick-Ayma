package com.fotoable.youtube.music.b.d;

import com.fotoable.youtube.music.bean.DurationResultBean;
import com.fotoable.youtube.music.bean.PlayListDetailBean;
import com.fotoable.youtube.music.bean.SearchResultBean;
import com.fotoable.youtube.music.bean.VideoInfoBean;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.f;
/* compiled from: YoutubeOfficialApiService.java */
/* loaded from: classes.dex */
public interface e {
    @GET("/youtube/v3/videos")
    f<DurationResultBean> a(@Query("part") String str, @Query("id") String str2, @Query("key") String str3);

    @GET("/youtube/v3/playlistItems")
    f<PlayListDetailBean> a(@Query("part") String str, @Query("playlistId") String str2, @Query("key") String str3, @Query("maxResults") int i, @Query("pageToken") String str4);

    @GET("/youtube/v3/search")
    f<SearchResultBean> a(@Query("part") String str, @Query("key") String str2, @Query("type") String str3, @Query("q") String str4, @Query("maxResults") int i, @Query("videoCategoryId") int i2, @Query("pageToken") String str5, @Query("videoEmbeddable") String str6);

    @GET("/youtube/v3/search")
    f<SearchResultBean> a(@Query("part") String str, @Query("key") String str2, @Query("type") String str3, @Query("q") String str4, @Query("maxResults") int i, @Query("pageToken") String str5);

    @GET("/youtube/v3/videos")
    f<VideoInfoBean> b(@Query("part") String str, @Query("id") String str2, @Query("key") String str3);
}

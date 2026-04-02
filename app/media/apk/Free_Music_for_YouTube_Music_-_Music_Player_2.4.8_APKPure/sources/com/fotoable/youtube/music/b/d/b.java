package com.fotoable.youtube.music.b.d;

import com.fotoable.youtube.music.bean.MyHttpResponse;
import com.fotoable.youtube.music.bean.PostBean;
import com.fotoable.youtube.music.bean.UserInfoModel;
import com.fotoable.youtube.music.bean.YoutubeComment;
import java.util.List;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import rx.f;
/* compiled from: CommunityApiService.java */
/* loaded from: classes.dex */
public interface b {
    @FormUrlEncoded
    @POST("/user/update")
    f<MyHttpResponse<UserInfoModel>> a(@Field("isVip") int i);

    @FormUrlEncoded
    @POST("/user/login")
    f<MyHttpResponse<UserInfoModel>> a(@Field("deviceid") String str);

    @FormUrlEncoded
    @POST("/comments/lists")
    f<MyHttpResponse<List<YoutubeComment>>> a(@Field("bigid") String str, @Field("skip") int i, @Field("limit") int i2, @Field("mixid") long j, @Field("type") int i3);

    @FormUrlEncoded
    @POST("/post/lists")
    f<MyHttpResponse<List<PostBean>>> a(@Field("categoryid") String str, @Field("skip") int i, @Field("limit") int i2, @Field("mixid") long j, @Field("language") String str2);

    @FormUrlEncoded
    @POST("/comments/report")
    f<MyHttpResponse<YoutubeComment>> a(@Field("cid") String str, @Field("body") String str2);

    @FormUrlEncoded
    @POST("/comments/add")
    f<MyHttpResponse<YoutubeComment>> a(@Field("bigid") String str, @Field("body") String str2, @Field("type") int i, @Field("isReplyComment") int i2, @Field("cid") String str3, @Field("cuid") String str4);

    @FormUrlEncoded
    @POST("/post/add")
    f<MyHttpResponse<PostBean>> a(@Field("categoryid") String str, @Field("body") String str2, @Field("videoid") String str3, @Field("videoTitle") String str4, @Field("videoArtists") String str5, @Field("videoImgUrl") String str6, @Field("videoDuration") String str7, @Field("language") String str8);

    @POST("/post/add")
    @Multipart
    f<MyHttpResponse<PostBean>> a(@Query("categoryid") String str, @Query("body") String str2, @Query("videoid") String str3, @Query("videoTitle") String str4, @Query("videoArtists") String str5, @Query("videoImgUrl") String str6, @Query("videoDuration") String str7, @Query("language") String str8, @Part List<MultipartBody.Part> list);

    @POST("/user/update")
    @Multipart
    f<MyHttpResponse<UserInfoModel>> a(@Part MultipartBody.Part part);

    @FormUrlEncoded
    @POST("/user/update")
    f<MyHttpResponse<UserInfoModel>> b(@Field("name") String str);

    @FormUrlEncoded
    @POST("/likes/comments")
    f<MyHttpResponse<YoutubeComment>> b(@Field("cid") String str, @Field("bigid") String str2);

    @FormUrlEncoded
    @POST("/comments/del")
    f<MyHttpResponse<YoutubeComment>> c(@Field("cid") String str);

    @FormUrlEncoded
    @POST("/post/report")
    f<MyHttpResponse<PostBean>> c(@Field("bigid") String str, @Field("body") String str2);

    @FormUrlEncoded
    @POST("/likes/posts")
    f<MyHttpResponse<PostBean>> d(@Field("bigid") String str);

    @FormUrlEncoded
    @POST("/post/del")
    f<MyHttpResponse<PostBean>> e(@Field("bigid") String str);

    @Streaming
    @GET
    f<ResponseBody> f(@Url String str);

    @FormUrlEncoded
    @POST("/post/adminExamine")
    f<MyHttpResponse<PostBean>> g(@Field("bigid") String str);
}

package com.fotoable.youtube.music.b.c;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.f;
/* compiled from: LastFmRestService.java */
/* loaded from: classes.dex */
public interface b {
    @Headers({"Cache-Control: public"})
    @GET("?method=artist.getinfo&api_key=fdb3a51437d4281d4d64964d333531d4&format=json")
    f<com.fotoable.youtube.music.b.c.b.a> a(@Query("artist") String str);
}

package com.fotoable.youtube.music.b.d;

import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.f;
/* compiled from: BingApiService.java */
/* loaded from: classes.dex */
public interface a {
    @GET("/osjson.aspx")
    f<List<Object>> a(@Query("query") String str);
}

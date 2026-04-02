package com.fotoable.youtube.music.b.d;

import com.fotoable.youtube.music.bean.CountryCodeModel;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.f;
/* compiled from: CountryApiService.java */
/* loaded from: classes.dex */
public interface c {
    @GET("?")
    f<CountryCodeModel> a(@Query("time") long j);
}

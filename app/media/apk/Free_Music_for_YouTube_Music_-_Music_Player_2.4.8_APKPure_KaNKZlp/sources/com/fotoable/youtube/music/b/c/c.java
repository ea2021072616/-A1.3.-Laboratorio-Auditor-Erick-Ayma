package com.fotoable.youtube.music.b.c;

import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.util.v;
import com.fotoable.youtube.music.util.w;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
/* compiled from: RestServiceFactory.java */
/* loaded from: classes.dex */
public class c {
    public static <T> T a(String str, Class<T> cls) {
        Cache cache = new Cache(new File(MusicApplication.c().getApplicationContext().getCacheDir(), "http"), 5242880L);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        return (T) new Retrofit.Builder().client(builder.cache(cache).addInterceptor(b()).addInterceptor(a()).build()).baseUrl(str).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build().create(cls);
    }

    @NonNull
    private static Interceptor a() {
        return new Interceptor() { // from class: com.fotoable.youtube.music.b.c.c.1
            @Override // okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request.Builder newBuilder = chain.request().newBuilder();
                if (!TextUtils.isEmpty(com.fotoable.youtube.music.a.x())) {
                    newBuilder.addHeader("auth", com.fotoable.youtube.music.a.x());
                }
                if (!w.f(MusicApplication.c())) {
                    newBuilder.cacheControl(new CacheControl.Builder().onlyIfCached().maxStale(604800, TimeUnit.SECONDS).build());
                }
                return chain.proceed(newBuilder.removeHeader(b.a.a.a.a.b.a.HEADER_USER_AGENT).addHeader(b.a.a.a.a.b.a.HEADER_USER_AGENT, w.b()).addHeader("devicename", Build.MODEL).addHeader("client", "android").addHeader("vername", w.d(MusicApplication.c())).addHeader("vercode", w.e(MusicApplication.c())).build());
            }
        };
    }

    private static Interceptor b() {
        return new Interceptor() { // from class: com.fotoable.youtube.music.b.c.c.2
            @Override // okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request request = chain.request();
                if (request.url().toString().contains("fotoable")) {
                    return chain.proceed(request.newBuilder().url(request.url().newBuilder().addQueryParameter("countryCode", v.a(MusicApplication.c(), "country_code", "")).build()).build());
                }
                return chain.proceed(request);
            }
        };
    }
}

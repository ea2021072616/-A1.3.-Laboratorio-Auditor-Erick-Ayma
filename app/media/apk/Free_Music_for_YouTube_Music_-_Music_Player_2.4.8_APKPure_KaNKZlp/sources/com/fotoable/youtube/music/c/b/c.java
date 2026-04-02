package com.fotoable.youtube.music.c.b;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.fotoable.youtube.music.MusicApplication;
import dagger.Module;
import dagger.Provides;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.inject.Named;
import javax.inject.Singleton;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
/* compiled from: ApiModule.java */
@Module
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2400a;

    public c(Context context) {
        this.f2400a = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public com.fotoable.youtube.music.b.c a(com.fotoable.youtube.music.b.d.d dVar, com.fotoable.youtube.music.b.d.c cVar, com.fotoable.youtube.music.b.d.b bVar) {
        return new com.fotoable.youtube.music.b.c(dVar, cVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public com.fotoable.youtube.music.b.e a(com.fotoable.youtube.music.b.d.e eVar) {
        return new com.fotoable.youtube.music.b.e(eVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public com.fotoable.youtube.music.b.a a(com.fotoable.youtube.music.b.d.a aVar) {
        return new com.fotoable.youtube.music.b.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public GsonConverterFactory a() {
        return GsonConverterFactory.create();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public RxJavaCallAdapterFactory b() {
        return RxJavaCallAdapterFactory.create();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    @Named("base_url")
    public String c() {
        return "https://cdn-freemusic.fotoable.net";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    @Named("base_community_url")
    public String d() {
        return "http://forum.autoskymobi.net";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    @Named("official_url")
    public String e() {
        return "https://www.googleapis.com";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    @Named("country_url")
    public String f() {
        return "http://geoip.fotoable.net/";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    @Named("bing_url")
    public String g() {
        return "http://api.bing.com";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    @Named("base_client")
    public OkHttpClient h() {
        Cache cache = new Cache(new File(this.f2400a.getCacheDir(), "http"), 52428800L);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        return builder.cache(cache).addInterceptor(k()).addInterceptor(i()).addNetworkInterceptor(j()).build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public com.fotoable.youtube.music.b.d.b a(@Named("base_community_url") String str, @Named("base_client") OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory, RxJavaCallAdapterFactory rxJavaCallAdapterFactory) {
        return (com.fotoable.youtube.music.b.d.b) new Retrofit.Builder().client(okHttpClient).baseUrl(str).addConverterFactory(gsonConverterFactory).addCallAdapterFactory(rxJavaCallAdapterFactory).build().create(com.fotoable.youtube.music.b.d.b.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public com.fotoable.youtube.music.b.d.d b(@Named("base_url") String str, @Named("base_client") OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory, RxJavaCallAdapterFactory rxJavaCallAdapterFactory) {
        return (com.fotoable.youtube.music.b.d.d) new Retrofit.Builder().client(okHttpClient).baseUrl(str).addConverterFactory(gsonConverterFactory).addCallAdapterFactory(rxJavaCallAdapterFactory).build().create(com.fotoable.youtube.music.b.d.d.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public com.fotoable.youtube.music.b.d.e c(@Named("official_url") String str, @Named("base_client") OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory, RxJavaCallAdapterFactory rxJavaCallAdapterFactory) {
        return (com.fotoable.youtube.music.b.d.e) new Retrofit.Builder().client(okHttpClient).baseUrl(str).addConverterFactory(gsonConverterFactory).addCallAdapterFactory(rxJavaCallAdapterFactory).build().create(com.fotoable.youtube.music.b.d.e.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public com.fotoable.youtube.music.b.d.c d(@Named("country_url") String str, @Named("base_client") OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory, RxJavaCallAdapterFactory rxJavaCallAdapterFactory) {
        return (com.fotoable.youtube.music.b.d.c) new Retrofit.Builder().client(okHttpClient).baseUrl(str).addConverterFactory(gsonConverterFactory).addCallAdapterFactory(rxJavaCallAdapterFactory).build().create(com.fotoable.youtube.music.b.d.c.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public com.fotoable.youtube.music.b.d.a e(@Named("bing_url") String str, @Named("base_client") OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory, RxJavaCallAdapterFactory rxJavaCallAdapterFactory) {
        return (com.fotoable.youtube.music.b.d.a) new Retrofit.Builder().client(okHttpClient).baseUrl(str).addConverterFactory(gsonConverterFactory).addCallAdapterFactory(rxJavaCallAdapterFactory).build().create(com.fotoable.youtube.music.b.d.a.class);
    }

    @NonNull
    private Interceptor i() {
        return new Interceptor() { // from class: com.fotoable.youtube.music.c.b.c.1
            @Override // okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request.Builder newBuilder = chain.request().newBuilder();
                if (!TextUtils.isEmpty(com.fotoable.youtube.music.a.x())) {
                    newBuilder.addHeader("auth", com.fotoable.youtube.music.a.x());
                }
                if (!com.fotoable.youtube.music.util.w.f(MusicApplication.c())) {
                    newBuilder.cacheControl(new CacheControl.Builder().onlyIfCached().maxStale(604800, TimeUnit.SECONDS).build());
                }
                return chain.proceed(newBuilder.removeHeader(b.a.a.a.a.b.a.HEADER_USER_AGENT).addHeader(b.a.a.a.a.b.a.HEADER_USER_AGENT, com.fotoable.youtube.music.util.w.b()).addHeader("devicename", Build.MODEL).addHeader("client", "android").addHeader("vername", com.fotoable.youtube.music.util.w.d(MusicApplication.c())).addHeader("vercode", com.fotoable.youtube.music.util.w.e(MusicApplication.c())).build());
            }
        };
    }

    private Interceptor j() {
        return new Interceptor() { // from class: com.fotoable.youtube.music.c.b.c.2
            @Override // okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) throws IOException {
                return chain.proceed(chain.request()).newBuilder().removeHeader("Pragma").removeHeader("Cache-Control").header("Cache-Control", "public, max-age=30").build();
            }
        };
    }

    private Interceptor k() {
        return new Interceptor() { // from class: com.fotoable.youtube.music.c.b.c.3
            @Override // okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request request = chain.request();
                if (request.url().toString().contains("fotoable") && !request.url().toString().contains("radio")) {
                    return chain.proceed(request.newBuilder().addHeader("auth", MusicApplication.c().h() != null ? MusicApplication.c().h().getAuth() : "").url(request.url().newBuilder().addQueryParameter("countryCode", com.fotoable.youtube.music.util.v.a(MusicApplication.c(), "country_code", "")).build()).build());
                } else if (request.url().toString().contains("http://forum.autoskymobi.net")) {
                    return chain.proceed(request.newBuilder().addHeader("auth", MusicApplication.c().h() != null ? MusicApplication.c().h().getAuth() : "").build());
                } else {
                    return chain.proceed(request);
                }
            }
        };
    }
}

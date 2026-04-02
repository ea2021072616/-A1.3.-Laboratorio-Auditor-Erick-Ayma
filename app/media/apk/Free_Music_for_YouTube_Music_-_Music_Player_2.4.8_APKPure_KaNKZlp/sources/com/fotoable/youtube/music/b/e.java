package com.fotoable.youtube.music.b;

import com.facebook.internal.ServerProtocol;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.bean.DurationResultBean;
import com.fotoable.youtube.music.bean.PlayListDetailBean;
import com.fotoable.youtube.music.bean.SearchResultBean;
import com.fotoable.youtube.music.bean.VideoInfoBean;
import com.fotoable.youtube.music.util.p;
import com.fotoable.youtube.music.util.v;
import rx.f;
/* compiled from: MusicOfficialManager.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private com.fotoable.youtube.music.b.d.e f2301a;

    public e(com.fotoable.youtube.music.b.d.e eVar) {
        this.f2301a = eVar;
    }

    public f<SearchResultBean> a(String str, String str2) {
        return this.f2301a.a("snippet", v.a(MusicApplication.c(), "YOU_TUBE_KEY", "AIzaSyBwn6_nAqZvzNb93MeB4PRJ0ZenXCQxJVk"), "video", str, 50, 10, str2, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE).e(new p(3, 50));
    }

    public f<SearchResultBean> b(String str, String str2) {
        return this.f2301a.a("snippet", v.a(MusicApplication.c(), "YOU_TUBE_KEY", "AIzaSyBwn6_nAqZvzNb93MeB4PRJ0ZenXCQxJVk"), "playlist", str, 50, str2).e(new p(3, 50));
    }

    public f<PlayListDetailBean> a(String str, String str2, int i, String str3) {
        return this.f2301a.a("snippet,contentDetails", str, str2, i, str3).e(new p(3, 50));
    }

    public f<DurationResultBean> a(String str) {
        return this.f2301a.a("contentDetails", str, v.a(MusicApplication.c(), "YOU_TUBE_KEY", "AIzaSyBwn6_nAqZvzNb93MeB4PRJ0ZenXCQxJVk")).e(new p(3, 50));
    }

    public f<VideoInfoBean> b(String str) {
        return this.f2301a.b("snippet,contentDetails", str, v.a(MusicApplication.c(), "YOU_TUBE_KEY", "AIzaSyBwn6_nAqZvzNb93MeB4PRJ0ZenXCQxJVk")).e(new p(3, 50));
    }
}

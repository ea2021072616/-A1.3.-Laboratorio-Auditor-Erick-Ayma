package com.fotoable.youtube.music.d;

import android.text.TextUtils;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.bean.HotKeyBean;
import com.fotoable.youtube.music.d.a.p;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import rx.f;
/* compiled from: SearchPresenter.java */
/* loaded from: classes.dex */
public class ar {

    /* renamed from: a  reason: collision with root package name */
    List<String> f2511a;

    /* renamed from: b  reason: collision with root package name */
    private com.fotoable.youtube.music.b.c f2512b;

    /* renamed from: c  reason: collision with root package name */
    private com.fotoable.youtube.music.b.a f2513c;
    private p.a d;
    private Gson e = new Gson();
    private rx.g.b f;

    public ar(p.a aVar, com.fotoable.youtube.music.b.c cVar, com.fotoable.youtube.music.b.a aVar2) {
        this.d = aVar;
        this.f2512b = cVar;
        this.f2513c = aVar2;
    }

    public void a() {
        e();
        a(this.f2512b.b().a(com.fotoable.youtube.music.util.s.a()).a((f.c<? super R, ? extends R>) com.fotoable.youtube.music.util.s.b()).a((rx.g) new rx.g<List<HotKeyBean>>() { // from class: com.fotoable.youtube.music.d.ar.1
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(List<HotKeyBean> list) {
                ar.this.d.a(list);
                ar.this.d(ar.this.e.toJson(list));
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.fotoable.youtube.music.util.v.b(MusicApplication.c(), "SEARCH_HOT_KEY", str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void e() {
        List list;
        String a2 = com.fotoable.youtube.music.util.v.a(MusicApplication.c(), "SEARCH_HOT_KEY", "");
        if (!TextUtils.isEmpty(a2)) {
            try {
                list = (List) this.e.fromJson(a2, new TypeToken<List<HotKeyBean>>() { // from class: com.fotoable.youtube.music.d.ar.2
                }.getType());
            } catch (JsonSyntaxException e) {
                ThrowableExtension.printStackTrace(e);
                com.fotoable.youtube.music.util.v.b(MusicApplication.c(), "SEARCH_HOT_KEY", "");
                list = null;
            }
            this.d.a(list);
        }
    }

    public void a(String str) {
        b();
        if (!this.f2511a.contains(str)) {
            if (this.f2511a.size() > 4) {
                this.f2511a.add(0, str);
                this.f2511a.remove(this.f2511a.size() - 1);
            } else {
                this.f2511a.add(0, str);
            }
            com.fotoable.youtube.music.util.v.b(MusicApplication.c(), "SEARCH_HISTORY", this.e.toJson(this.f2511a));
        }
    }

    public List<String> b() {
        String a2 = com.fotoable.youtube.music.util.v.a(MusicApplication.c(), "SEARCH_HISTORY", "");
        if (!TextUtils.isEmpty(a2)) {
            this.f2511a = (List) this.e.fromJson(a2, new TypeToken<List<String>>() { // from class: com.fotoable.youtube.music.d.ar.3
            }.getType());
        } else {
            this.f2511a = new ArrayList();
        }
        return this.f2511a;
    }

    public boolean b(String str) {
        b();
        if (this.f2511a.remove(str)) {
            com.fotoable.youtube.music.util.v.b(MusicApplication.c(), "SEARCH_HISTORY", this.e.toJson(this.f2511a));
            return true;
        }
        return false;
    }

    public boolean c() {
        com.fotoable.youtube.music.util.v.b(MusicApplication.c(), "SEARCH_HISTORY", "");
        return true;
    }

    public void c(String str) {
        a(this.f2513c.a(str).a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<List<Object>>() { // from class: com.fotoable.youtube.music.d.ar.4
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(List<Object> list) {
                List<String> list2;
                if (list != null && list.size() > 1 && (list2 = (List) list.get(1)) != null && list2.size() > 0) {
                    ar.this.d.b(list2);
                }
            }
        }));
    }

    public void a(rx.m mVar) {
        if (this.f == null) {
            this.f = new rx.g.b();
        }
        this.f.a(mVar);
    }

    public void d() {
        if (this.f != null) {
            this.f.unsubscribe();
            this.f = null;
        }
    }
}

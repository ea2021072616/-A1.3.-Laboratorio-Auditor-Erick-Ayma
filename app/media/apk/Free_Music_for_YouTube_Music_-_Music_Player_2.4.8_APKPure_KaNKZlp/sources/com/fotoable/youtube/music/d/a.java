package com.fotoable.youtube.music.d;

import android.text.TextUtils;
import com.fotoable.youtube.music.bean.ArtistBean;
import com.fotoable.youtube.music.bean.MyHttpResponse;
import com.fotoable.youtube.music.d.a.a;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import javax.inject.Inject;
/* compiled from: ArtistsPresenter.java */
/* loaded from: classes.dex */
public class a extends aq<a.InterfaceC0057a> {

    /* renamed from: a  reason: collision with root package name */
    com.fotoable.youtube.music.b.c f2455a;

    /* renamed from: b  reason: collision with root package name */
    private a.InterfaceC0057a f2456b;

    @Inject
    public a(com.fotoable.youtube.music.b.c cVar) {
        this.f2455a = cVar;
        c();
    }

    private void c() {
        b(com.fotoable.youtube.music.e.b.a().a(com.fotoable.youtube.music.e.a.class).a(rx.a.b.a.a()).a(b.f2529a, new rx.c.b<Throwable>() { // from class: com.fotoable.youtube.music.d.a.1
            @Override // rx.c.b
            /* renamed from: a */
            public void call(Throwable th) {
                ThrowableExtension.printStackTrace(th);
            }
        }));
    }

    public void a(a.InterfaceC0057a interfaceC0057a) {
        this.f2456b = interfaceC0057a;
    }

    public void a() {
        b_();
        this.f2456b = null;
    }

    public void b() {
        this.f2456b.a_(true);
        b(this.f2455a.h().a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<MyHttpResponse<ArrayList<ArtistBean>>>() { // from class: com.fotoable.youtube.music.d.a.2
            @Override // rx.g
            public void onCompleted() {
                a.this.f2456b.a_(false);
                a.this.f2456b.b(false);
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
                a.this.f2456b.a_(false);
                a.this.f2456b.b(true);
                com.fotoable.youtube.music.util.b.b("Dev_歌手库接口", "失败原因", "" + th.getMessage());
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(MyHttpResponse<ArrayList<ArtistBean>> myHttpResponse) {
                if (myHttpResponse != null && myHttpResponse.getMeta() != null && !TextUtils.isEmpty(myHttpResponse.getMeta().getGroups()) && myHttpResponse.getData() != null && myHttpResponse.getData().size() != 0) {
                    a.this.f2456b.a(myHttpResponse.getMeta().getGroups().split(","));
                    a.this.f2456b.a(myHttpResponse.getData());
                    return;
                }
                onError(new Throwable("歌手列表获取失败"));
            }
        }));
    }
}

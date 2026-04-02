package com.fotoable.youtube.music.d;

import com.fotoable.youtube.music.bean.MyHttpResponse;
import com.fotoable.youtube.music.bean.PostBean;
import com.fotoable.youtube.music.bean.YoutubeCommentLocalLikeModel;
import com.fotoable.youtube.music.d.a.d;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
/* compiled from: CommunityPresenter.java */
/* loaded from: classes.dex */
public class l extends aq<d.a> {

    /* renamed from: a  reason: collision with root package name */
    com.fotoable.youtube.music.b.c f2557a;

    /* renamed from: b  reason: collision with root package name */
    com.fotoable.youtube.music.db.a f2558b;
    private d.a d;
    private boolean e = false;
    private int f = 0;
    private int g = 50;
    private long h = 0;
    private boolean i = false;
    private String j = "all";

    @Inject
    public l(com.fotoable.youtube.music.b.c cVar, com.fotoable.youtube.music.db.a aVar) {
        this.f2557a = cVar;
        this.f2558b = aVar;
        f();
    }

    private void f() {
        b(com.fotoable.youtube.music.e.b.a().a(com.fotoable.youtube.music.e.a.class).a(rx.a.b.a.a()).a(m.f2562a, new rx.c.b<Throwable>() { // from class: com.fotoable.youtube.music.d.l.1
            @Override // rx.c.b
            /* renamed from: a */
            public void call(Throwable th) {
                ThrowableExtension.printStackTrace(th);
            }
        }));
    }

    public void a(d.a aVar) {
        this.d = aVar;
    }

    public void a() {
        b_();
        this.d = null;
    }

    public void a(String str) {
        this.j = str + "";
    }

    public String b() {
        return this.j;
    }

    public void c() {
        if (!this.i) {
            this.i = true;
            b(this.f2557a.a(this.j + "", this.f, this.g, this.h).a(new rx.c.b<MyHttpResponse<List<PostBean>>>() { // from class: com.fotoable.youtube.music.d.l.3
                @Override // rx.c.b
                /* renamed from: a */
                public void call(MyHttpResponse<List<PostBean>> myHttpResponse) {
                    PostBean postBean;
                    if (myHttpResponse != null && myHttpResponse.isSuccess() && myHttpResponse.getData() != null && myHttpResponse.getData().size() > 0) {
                        HashMap hashMap = new HashMap();
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < myHttpResponse.getData().size(); i++) {
                            PostBean postBean2 = myHttpResponse.getData().get(i);
                            if (postBean2 != null) {
                                hashMap.put(postBean2.getBigId(), postBean2);
                                arrayList.add(postBean2.getBigId());
                            }
                        }
                        List<YoutubeCommentLocalLikeModel> e = l.this.f2558b.e(arrayList);
                        if (e != null) {
                            for (int i2 = 0; i2 < e.size(); i2++) {
                                YoutubeCommentLocalLikeModel youtubeCommentLocalLikeModel = e.get(i2);
                                if (youtubeCommentLocalLikeModel != null && (postBean = (PostBean) hashMap.get(youtubeCommentLocalLikeModel.getCid())) != null) {
                                    postBean.setLike(true);
                                }
                            }
                            e.clear();
                            hashMap.clear();
                        }
                        arrayList.clear();
                    }
                }
            }).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<MyHttpResponse<List<PostBean>>>() { // from class: com.fotoable.youtube.music.d.l.2
                @Override // rx.g
                public void onCompleted() {
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                    if (l.this.d != null) {
                        l.this.d.c_(l.this.f == 0);
                    }
                    l.this.i = false;
                }

                private void a() {
                    l.this.e = false;
                    if (l.this.d != null) {
                        l.this.d.c_(l.this.f == 0);
                    }
                    l.this.i = false;
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(MyHttpResponse<List<PostBean>> myHttpResponse) {
                    if (myHttpResponse == null) {
                        a();
                    } else if (myHttpResponse.getData() == null || myHttpResponse.getData().size() == 0) {
                        l.this.i = false;
                        l.this.e = false;
                        if (myHttpResponse.getMeta() == null || myHttpResponse.getMeta().getTotal() != 0) {
                            if (l.this.d != null) {
                                l.this.d.c_(l.this.f == 0);
                            }
                        } else if (l.this.d != null) {
                            l.this.d.a(l.this.f == 0, myHttpResponse.getData());
                        }
                    } else {
                        if (l.this.d != null) {
                            l.this.d.a(l.this.f == 0, myHttpResponse.getData());
                        }
                        l.this.e = true;
                        l.this.f += l.this.g;
                        l.this.h = myHttpResponse.getMeta().getMixid();
                        l.this.i = false;
                    }
                }
            }));
        }
    }

    public void d() {
        if (!this.i) {
            this.h = 0L;
            this.f = 0;
            this.e = true;
        }
    }

    public boolean e() {
        return this.e;
    }
}

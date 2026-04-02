package com.fotoable.youtube.music.d;

import com.fotoable.youtube.music.bean.MyHttpResponse;
import com.fotoable.youtube.music.bean.RadioBean;
import com.fotoable.youtube.music.d.a.n;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.List;
import rx.f;
/* compiled from: RadioListPresenter.java */
/* loaded from: classes.dex */
public class ao {

    /* renamed from: a  reason: collision with root package name */
    private rx.g.b f2498a;

    /* renamed from: b  reason: collision with root package name */
    private com.fotoable.youtube.music.b.c f2499b;

    /* renamed from: c  reason: collision with root package name */
    private n.a f2500c;

    public ao(com.fotoable.youtube.music.b.c cVar, n.a aVar) {
        this.f2500c = aVar;
        this.f2499b = cVar;
    }

    public void a(final int i, int i2) {
        try {
            a(this.f2499b.a(i, i2).a(com.fotoable.youtube.music.util.s.a()).a((f.c<? super R, ? extends R>) com.fotoable.youtube.music.util.s.b()).a((rx.g) new rx.g<List<RadioBean>>() { // from class: com.fotoable.youtube.music.d.ao.1
                @Override // rx.g
                public void onCompleted() {
                }

                @Override // rx.g
                public void onError(Throwable th) {
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(List<RadioBean> list) {
                    if (i == 0) {
                        ao.this.f2500c.a(list, true);
                    } else {
                        ao.this.f2500c.a(list, false);
                    }
                }
            }));
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public void a(final int i, int i2, String str) {
        try {
            a(this.f2499b.a(i, i2, str).a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<MyHttpResponse<List<RadioBean>>>() { // from class: com.fotoable.youtube.music.d.ao.2
                @Override // rx.g
                public void onCompleted() {
                }

                @Override // rx.g
                public void onError(Throwable th) {
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(MyHttpResponse<List<RadioBean>> myHttpResponse) {
                    if (i == 0) {
                        ao.this.f2500c.a(myHttpResponse.getData(), true);
                        ao.this.f2500c.a(myHttpResponse.getMeta());
                        return;
                    }
                    ao.this.f2500c.a(myHttpResponse.getData(), false);
                }
            }));
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public void a(rx.m mVar) {
        if (this.f2498a == null) {
            this.f2498a = new rx.g.b();
        }
        this.f2498a.a(mVar);
    }

    public void a() {
        if (this.f2498a != null) {
            this.f2498a.unsubscribe();
            this.f2498a = null;
        }
    }
}

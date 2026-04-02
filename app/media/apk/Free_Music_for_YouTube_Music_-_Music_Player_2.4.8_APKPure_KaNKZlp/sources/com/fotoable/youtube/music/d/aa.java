package com.fotoable.youtube.music.d;

import com.fotoable.youtube.music.bean.LocalSongBean;
import com.fotoable.youtube.music.d.a.j;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.List;
/* compiled from: LocalSearchPresenter.java */
/* loaded from: classes.dex */
public class aa {

    /* renamed from: a  reason: collision with root package name */
    private j.a f2459a;

    /* renamed from: b  reason: collision with root package name */
    private rx.g.b f2460b;

    public aa(j.a aVar) {
        this.f2459a = aVar;
    }

    public void a(String str) {
        a(rx.f.a(com.fotoable.youtube.music.helper.localmusic.d.a(str, 4), com.fotoable.youtube.music.helper.localmusic.d.a(str), ab.f2463a).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<List<LocalSongBean>>() { // from class: com.fotoable.youtube.music.d.aa.1
            @Override // rx.g
            public void onCompleted() {
                if (aa.this.f2459a != null) {
                    aa.this.f2459a.g_();
                }
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
                if (aa.this.f2459a != null) {
                    aa.this.f2459a.g_();
                }
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(List<LocalSongBean> list) {
                if (aa.this.f2459a != null) {
                    aa.this.f2459a.g_();
                    if (list != null) {
                        aa.this.f2459a.a(list);
                    }
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ List b(List list, List list2) {
        if (list != null && list2 != null) {
            list.addAll(list2);
            return list;
        } else if (list == null) {
            if (list2 != null) {
                return list2;
            }
            return null;
        } else {
            return list;
        }
    }

    public void b(String str) {
        a(rx.f.a(com.fotoable.youtube.music.helper.localmusic.d.a(str, 4), com.fotoable.youtube.music.helper.localmusic.d.a(str), ac.f2464a).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<List<LocalSongBean>>() { // from class: com.fotoable.youtube.music.d.aa.2
            @Override // rx.g
            public void onCompleted() {
                if (aa.this.f2459a != null) {
                    aa.this.f2459a.g_();
                }
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
                if (aa.this.f2459a != null) {
                    aa.this.f2459a.g_();
                }
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(List<LocalSongBean> list) {
                if (aa.this.f2459a != null) {
                    aa.this.f2459a.g_();
                    if (list != null) {
                        aa.this.f2459a.a(list);
                    }
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ List a(List list, List list2) {
        if (list != null && list2 != null) {
            list.addAll(list2);
            return list;
        } else if (list == null) {
            if (list2 != null) {
                return list2;
            }
            return null;
        } else {
            return list;
        }
    }

    protected void a(rx.m mVar) {
        if (this.f2460b == null) {
            this.f2460b = new rx.g.b();
        }
        this.f2460b.a(mVar);
    }

    protected void a() {
        if (this.f2460b != null && !this.f2460b.isUnsubscribed()) {
            this.f2460b.unsubscribe();
            this.f2460b = null;
        }
    }

    public void b() {
        a();
    }
}

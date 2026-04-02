package com.fotoable.youtube.music.d;

import com.fotoable.youtube.music.bean.GenresBean;
import com.fotoable.youtube.music.d.a.f;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import javax.inject.Inject;
import rx.f;
/* compiled from: GenresPresenter.java */
/* loaded from: classes.dex */
public class p extends aq<f.a> {

    /* renamed from: a  reason: collision with root package name */
    com.fotoable.youtube.music.b.c f2570a;

    /* renamed from: b  reason: collision with root package name */
    private f.a f2571b;

    @Inject
    public p(com.fotoable.youtube.music.b.c cVar) {
        this.f2570a = cVar;
    }

    public void a() {
        this.f2571b.d_(true);
        b(this.f2570a.i().a(com.fotoable.youtube.music.util.s.b()).a((f.c<? super R, ? extends R>) com.fotoable.youtube.music.util.s.a()).b(new rx.l<ArrayList<GenresBean>>() { // from class: com.fotoable.youtube.music.d.p.1
            @Override // rx.g
            public void onCompleted() {
                p.this.f2571b.d_(false);
                p.this.f2571b.b(false);
            }

            @Override // rx.g
            public void onError(Throwable th) {
                p.this.f2571b.d_(false);
                p.this.f2571b.b(true);
                ThrowableExtension.printStackTrace(th);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(ArrayList<GenresBean> arrayList) {
                if (arrayList == null || arrayList.size() <= 0) {
                    onError(new Throwable("获取分类列表失败"));
                    return;
                }
                ArrayList<GenresBean> arrayList2 = new ArrayList<>();
                int i = 0;
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    if (i2 == 0) {
                        GenresBean genresBean = new GenresBean();
                        genresBean.setType(1);
                        genresBean.setGroup(arrayList.get(0).getGroup());
                        genresBean.setGroupid(arrayList.get(0).getGroupid());
                        genresBean.setGroupImgUrl(arrayList.get(0).getGroupImgUrl());
                        arrayList2.add(genresBean);
                    } else if (!arrayList.get(i2).getGroupid().equalsIgnoreCase(arrayList.get(i2 - 1).getGroupid())) {
                        if (i % 2 != 0) {
                            GenresBean genresBean2 = new GenresBean();
                            genresBean2.setType(2);
                            arrayList2.add(genresBean2);
                        }
                        GenresBean genresBean3 = new GenresBean();
                        genresBean3.setType(1);
                        genresBean3.setGroup(arrayList.get(i2).getGroup());
                        genresBean3.setGroupid(arrayList.get(i2).getGroupid());
                        genresBean3.setGroupImgUrl(arrayList.get(i2).getGroupImgUrl());
                        arrayList2.add(genresBean3);
                        i = 0;
                    }
                    i++;
                    arrayList2.add(arrayList.get(i2));
                }
                p.this.f2571b.a(arrayList2);
            }
        }));
    }

    public void a(f.a aVar) {
        this.f2571b = aVar;
    }

    public void b() {
        b_();
        this.f2571b = null;
    }
}

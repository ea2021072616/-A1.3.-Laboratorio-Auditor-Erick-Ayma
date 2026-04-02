package com.fotoable.youtube.music.d;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.fotoable.youtube.music.bean.HomeListNewBean;
import com.fotoable.youtube.music.d.a.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.f;
/* compiled from: HomeListPresenter.java */
/* loaded from: classes.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    private rx.g.b f2600a;

    /* renamed from: b  reason: collision with root package name */
    private com.fotoable.youtube.music.b.c f2601b;

    /* renamed from: c  reason: collision with root package name */
    private i.a f2602c;
    private com.fotoable.youtube.music.db.a d;

    public z(com.fotoable.youtube.music.b.c cVar, i.a aVar, com.fotoable.youtube.music.db.a aVar2) {
        this.f2601b = cVar;
        this.f2602c = aVar;
        this.d = aVar2;
    }

    public void a(final String str) {
        a(this.f2601b.a(10, str).a(com.fotoable.youtube.music.util.s.a()).a((f.c<? super R, ? extends R>) com.fotoable.youtube.music.util.s.b()).b(b()).a((rx.g) new rx.g<ArrayList<HomeListNewBean>>() { // from class: com.fotoable.youtube.music.d.z.1
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(ArrayList<HomeListNewBean> arrayList) {
                if (TextUtils.isEmpty(str)) {
                    z.this.f2602c.a(arrayList, true);
                } else {
                    z.this.f2602c.a(arrayList, false);
                }
            }
        }));
    }

    public void b(final String str) {
        a(this.f2601b.b(10, str).a(com.fotoable.youtube.music.util.s.a()).a((f.c<? super R, ? extends R>) com.fotoable.youtube.music.util.s.b()).b(b()).a((rx.g) new rx.g<ArrayList<HomeListNewBean>>() { // from class: com.fotoable.youtube.music.d.z.2
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(ArrayList<HomeListNewBean> arrayList) {
                if (TextUtils.isEmpty(str)) {
                    z.this.f2602c.a(arrayList, true);
                } else {
                    z.this.f2602c.a(arrayList, false);
                }
            }
        }));
    }

    @NonNull
    private rx.c.e<ArrayList<HomeListNewBean>, rx.f<ArrayList<HomeListNewBean>>> b() {
        return new rx.c.e<ArrayList<HomeListNewBean>, rx.f<ArrayList<HomeListNewBean>>>() { // from class: com.fotoable.youtube.music.d.z.3
            @Override // rx.c.e
            public rx.f<ArrayList<HomeListNewBean>> a(final ArrayList<HomeListNewBean> arrayList) {
                return rx.f.a((f.a) new f.a<ArrayList<HomeListNewBean>>() { // from class: com.fotoable.youtube.music.d.z.3.1
                    @Override // rx.c.b
                    /* renamed from: a */
                    public void call(rx.l<? super ArrayList<HomeListNewBean>> lVar) {
                        Map<String, Integer> c2 = z.this.d.c(z.this.a(arrayList));
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            HomeListNewBean homeListNewBean = (HomeListNewBean) it.next();
                            if (c2.containsKey(homeListNewBean.getVideoid())) {
                                homeListNewBean.setIsFav(c2.get(homeListNewBean.getVideoid()).intValue());
                            }
                        }
                        if (lVar != null && !lVar.isUnsubscribed()) {
                            lVar.onNext(arrayList);
                            lVar.onCompleted();
                        }
                    }
                });
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> a(ArrayList<HomeListNewBean> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                arrayList2.add(arrayList.get(i2).getVideoid());
                i = i2 + 1;
            } else {
                return arrayList2;
            }
        }
    }

    public void a(rx.m mVar) {
        if (this.f2600a == null) {
            this.f2600a = new rx.g.b();
        }
        this.f2600a.a(mVar);
    }

    public void a() {
        if (this.f2600a != null) {
            this.f2600a.unsubscribe();
            this.f2600a = null;
        }
    }
}

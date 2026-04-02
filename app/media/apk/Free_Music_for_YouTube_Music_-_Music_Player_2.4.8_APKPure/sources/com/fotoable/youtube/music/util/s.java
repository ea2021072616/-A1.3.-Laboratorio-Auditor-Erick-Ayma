package com.fotoable.youtube.music.util;

import com.fotoable.youtube.music.bean.MyHttpResponse;
import rx.f;
import rx.schedulers.Schedulers;
/* compiled from: RxUtil.java */
/* loaded from: classes.dex */
public class s {
    public static <T> f.c<T, T> a() {
        return new f.c<T, T>() { // from class: com.fotoable.youtube.music.util.s.1
            @Override // rx.c.e
            public /* bridge */ /* synthetic */ Object a(Object obj) {
                return a((rx.f) ((rx.f) obj));
            }

            public rx.f<T> a(rx.f<T> fVar) {
                return fVar.b(Schedulers.io()).a(rx.a.b.a.a());
            }
        };
    }

    public static <T> f.c<MyHttpResponse<T>, T> b() {
        return new f.c<MyHttpResponse<T>, T>() { // from class: com.fotoable.youtube.music.util.s.2
            @Override // rx.c.e
            public /* bridge */ /* synthetic */ Object a(Object obj) {
                return a((rx.f) ((rx.f) obj));
            }

            public rx.f<T> a(rx.f<MyHttpResponse<T>> fVar) {
                return (rx.f<T>) fVar.b(new rx.c.e<MyHttpResponse<T>, rx.f<T>>() { // from class: com.fotoable.youtube.music.util.s.2.1
                    @Override // rx.c.e
                    public /* bridge */ /* synthetic */ Object a(Object obj) {
                        return a((MyHttpResponse) ((MyHttpResponse) obj));
                    }

                    public rx.f<T> a(MyHttpResponse<T> myHttpResponse) {
                        return myHttpResponse.getCode() == 200 ? s.a(myHttpResponse.getData()) : rx.f.a((Throwable) new Exception());
                    }
                });
            }
        };
    }

    public static <T> rx.f<T> a(final T t) {
        return rx.f.a((f.a) new f.a<T>() { // from class: com.fotoable.youtube.music.util.s.3
            @Override // rx.c.b
            /* renamed from: a */
            public void call(rx.l<? super T> lVar) {
                try {
                    lVar.onNext((Object) t);
                    lVar.onCompleted();
                } catch (Exception e) {
                    lVar.onError(e);
                }
            }
        });
    }
}

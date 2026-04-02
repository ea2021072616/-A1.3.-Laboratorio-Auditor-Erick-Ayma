package rx.c;
/* compiled from: Functions.java */
/* loaded from: classes2.dex */
public final class h {
    public static <T0, T1, R> g<R> a(final f<? super T0, ? super T1, ? extends R> fVar) {
        return new g<R>() { // from class: rx.c.h.1
            @Override // rx.c.g
            public R a(Object... objArr) {
                if (objArr.length != 2) {
                    throw new IllegalArgumentException("Func2 expecting 2 arguments.");
                }
                return (R) f.this.a(objArr[0], objArr[1]);
            }
        };
    }
}

package rx.internal.util;
/* compiled from: UtilityFunctions.java */
/* loaded from: classes2.dex */
public final class k {
    public static <T> rx.c.e<? super T, Boolean> a() {
        return a.INSTANCE;
    }

    public static <T> rx.c.e<T, T> b() {
        return b.INSTANCE;
    }

    /* compiled from: UtilityFunctions.java */
    /* loaded from: classes2.dex */
    enum a implements rx.c.e<Object, Boolean> {
        INSTANCE;

        @Override // rx.c.e
        /* renamed from: b */
        public Boolean a(Object obj) {
            return true;
        }
    }

    /* compiled from: UtilityFunctions.java */
    /* loaded from: classes2.dex */
    enum b implements rx.c.e<Object, Object> {
        INSTANCE;

        @Override // rx.c.e
        public Object a(Object obj) {
            return obj;
        }
    }
}

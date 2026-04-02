package rx.internal.a;

import java.io.Serializable;
/* compiled from: NotificationLite.java */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f5326a = new Serializable() { // from class: rx.internal.a.d.1
        private static final long serialVersionUID = 1;

        public String toString() {
            return "Notification=>Completed";
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final Object f5327b = new Serializable() { // from class: rx.internal.a.d.2
        private static final long serialVersionUID = 2;

        public String toString() {
            return "Notification=>NULL";
        }
    };

    /* compiled from: NotificationLite.java */
    /* loaded from: classes2.dex */
    static final class a implements Serializable {
        private static final long serialVersionUID = 3;

        /* renamed from: a  reason: collision with root package name */
        final Throwable f5328a;

        public a(Throwable th) {
            this.f5328a = th;
        }

        public String toString() {
            return "Notification=>Error:" + this.f5328a;
        }
    }

    public static <T> Object a(T t) {
        if (t == null) {
            return f5327b;
        }
        return t;
    }

    public static Object a() {
        return f5326a;
    }

    public static Object a(Throwable th) {
        return new a(th);
    }

    public static <T> boolean a(rx.g<? super T> gVar, Object obj) {
        if (obj == f5326a) {
            gVar.onCompleted();
            return true;
        } else if (obj == f5327b) {
            gVar.onNext(null);
            return false;
        } else if (obj != null) {
            if (obj.getClass() == a.class) {
                gVar.onError(((a) obj).f5328a);
                return true;
            }
            gVar.onNext(obj);
            return false;
        } else {
            throw new IllegalArgumentException("The lite notification can not be null");
        }
    }

    public static boolean b(Object obj) {
        return obj == f5326a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T c(Object obj) {
        if (obj == f5327b) {
            return null;
        }
        return obj;
    }
}

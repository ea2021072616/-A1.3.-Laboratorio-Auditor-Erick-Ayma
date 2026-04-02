package rx.b;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/* compiled from: OnErrorThrowable.java */
/* loaded from: classes2.dex */
public final class g extends RuntimeException {
    private static final long serialVersionUID = -569558213262703934L;

    public static Throwable a(Throwable th, Object obj) {
        if (th == null) {
            th = new NullPointerException();
        }
        Throwable c2 = b.c(th);
        if (!(c2 instanceof a) || ((a) c2).a() != obj) {
            b.a(th, new a(obj));
        }
        return th;
    }

    /* compiled from: OnErrorThrowable.java */
    /* loaded from: classes2.dex */
    public static class a extends RuntimeException {
        private static final long serialVersionUID = -3454462756050397899L;

        /* renamed from: a  reason: collision with root package name */
        private final Object f5246a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OnErrorThrowable.java */
        /* renamed from: rx.b.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0108a {

            /* renamed from: a  reason: collision with root package name */
            static final Set<Class<?>> f5247a = a();

            private static Set<Class<?>> a() {
                HashSet hashSet = new HashSet();
                hashSet.add(Boolean.class);
                hashSet.add(Character.class);
                hashSet.add(Byte.class);
                hashSet.add(Short.class);
                hashSet.add(Integer.class);
                hashSet.add(Long.class);
                hashSet.add(Float.class);
                hashSet.add(Double.class);
                return hashSet;
            }
        }

        public a(Object obj) {
            super("OnError while emitting onNext value: " + a(obj));
            if (!(obj instanceof Serializable)) {
                try {
                    obj = String.valueOf(obj);
                } catch (Throwable th) {
                    obj = th.getMessage();
                }
            }
            this.f5246a = obj;
        }

        public Object a() {
            return this.f5246a;
        }

        static String a(Object obj) {
            if (obj == null) {
                return "null";
            }
            if (C0108a.f5247a.contains(obj.getClass())) {
                return obj.toString();
            }
            if (obj instanceof String) {
                return (String) obj;
            }
            if (obj instanceof Enum) {
                return ((Enum) obj).name();
            }
            String a2 = rx.e.f.a().b().a(obj);
            return a2 != null ? a2 : obj.getClass().getName() + ".class";
        }
    }
}

package rx.b;

import java.util.HashSet;
import java.util.List;
import rx.k;
/* compiled from: Exceptions.java */
/* loaded from: classes2.dex */
public final class b {
    public static RuntimeException a(Throwable th) {
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
        throw new RuntimeException(th);
    }

    public static void b(Throwable th) {
        if (th instanceof f) {
            throw ((f) th);
        }
        if (th instanceof e) {
            throw ((e) th);
        }
        if (th instanceof d) {
            throw ((d) th);
        }
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }

    public static void a(Throwable th, Throwable th2) {
        HashSet hashSet = new HashSet();
        int i = 0;
        while (th.getCause() != null) {
            int i2 = i + 1;
            if (i < 25) {
                th = th.getCause();
                if (!hashSet.contains(th.getCause())) {
                    hashSet.add(th.getCause());
                    i = i2;
                }
            } else {
                return;
            }
        }
        try {
            th.initCause(th2);
        } catch (Throwable th3) {
        }
    }

    public static Throwable c(Throwable th) {
        int i = 0;
        while (th.getCause() != null) {
            int i2 = i + 1;
            if (i >= 25) {
                return new RuntimeException("Stack too deep to get final cause");
            }
            th = th.getCause();
            i = i2;
        }
        return th;
    }

    public static void a(List<? extends Throwable> list) {
        if (list != null && !list.isEmpty()) {
            if (list.size() == 1) {
                Throwable th = list.get(0);
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                }
                if (th instanceof Error) {
                    throw ((Error) th);
                }
                throw new RuntimeException(th);
            }
            throw new a(list);
        }
    }

    public static void a(Throwable th, rx.g<?> gVar, Object obj) {
        b(th);
        gVar.onError(g.a(th, obj));
    }

    public static void a(Throwable th, rx.g<?> gVar) {
        b(th);
        gVar.onError(th);
    }

    public static void a(Throwable th, k<?> kVar) {
        b(th);
        kVar.a(th);
    }
}

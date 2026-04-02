package com.google.android.gms.internal.play_billing;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public abstract class l0 extends r {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected w1 zzc = w1.f1985f;

    public static l0 e(Class cls) {
        Map map = zzb;
        l0 l0Var = (l0) map.get(cls);
        if (l0Var == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                l0Var = (l0) map.get(cls);
            } catch (ClassNotFoundException e5) {
                throw new IllegalStateException("Class initialization cannot fail.", e5);
            }
        }
        if (l0Var == null) {
            l0Var = (l0) ((l0) f2.i(cls)).l(6);
            if (l0Var == null) {
                throw new IllegalStateException();
            }
            map.put(cls, l0Var);
        }
        return l0Var;
    }

    public static Object f(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e5) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e5);
        } catch (InvocationTargetException e6) {
            Throwable cause = e6.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static void h(Class cls, l0 l0Var) {
        l0Var.g();
        zzb.put(cls, l0Var);
    }

    public static final boolean j(l0 l0Var, boolean z4) {
        byte byteValue = ((Byte) l0Var.l(1)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean h5 = q1.f1939c.a(l0Var.getClass()).h(l0Var);
        if (z4) {
            l0Var.l(2);
        }
        return h5;
    }

    @Override // com.google.android.gms.internal.play_billing.r
    public final int a(t1 t1Var) {
        if (k()) {
            int e5 = t1Var.e(this);
            if (e5 >= 0) {
                return e5;
            }
            throw new IllegalStateException(androidx.appcompat.widget.b0.f("serialized size must be non-negative, was ", e5));
        }
        int i5 = this.zzd & Integer.MAX_VALUE;
        if (i5 == Integer.MAX_VALUE) {
            int e6 = t1Var.e(this);
            if (e6 >= 0) {
                this.zzd = (this.zzd & Integer.MIN_VALUE) | e6;
                return e6;
            }
            throw new IllegalStateException(androidx.appcompat.widget.b0.f("serialized size must be non-negative, was ", e6));
        }
        return i5;
    }

    public final void c(b0 b0Var) {
        t1 a5 = q1.f1939c.a(getClass());
        d0 d0Var = b0Var.f1842u;
        if (d0Var == null) {
            d0Var = new d0(b0Var);
        }
        a5.c(this, d0Var);
    }

    public final int d() {
        int i5;
        if (k()) {
            i5 = q1.f1939c.a(getClass()).e(this);
            if (i5 < 0) {
                throw new IllegalStateException(androidx.appcompat.widget.b0.f("serialized size must be non-negative, was ", i5));
            }
        } else {
            i5 = this.zzd & Integer.MAX_VALUE;
            if (i5 == Integer.MAX_VALUE) {
                i5 = q1.f1939c.a(getClass()).e(this);
                if (i5 < 0) {
                    throw new IllegalStateException(androidx.appcompat.widget.b0.f("serialized size must be non-negative, was ", i5));
                }
                this.zzd = (this.zzd & Integer.MIN_VALUE) | i5;
            }
        }
        return i5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return q1.f1939c.a(getClass()).g(this, (l0) obj);
        }
        return false;
    }

    public final void g() {
        this.zzd &= Integer.MAX_VALUE;
    }

    public final int hashCode() {
        if (k()) {
            return q1.f1939c.a(getClass()).i(this);
        }
        int i5 = this.zza;
        if (i5 == 0) {
            int i6 = q1.f1939c.a(getClass()).i(this);
            this.zza = i6;
            return i6;
        }
        return i5;
    }

    public final void i() {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final boolean k() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public abstract Object l(int i5);

    public final String toString() {
        String obj = super.toString();
        char[] cArr = k1.f1904a;
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        k1.c(this, sb, 0);
        return sb.toString();
    }
}

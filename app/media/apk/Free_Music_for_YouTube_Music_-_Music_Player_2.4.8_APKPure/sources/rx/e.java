package rx;
/* compiled from: Notification.java */
/* loaded from: classes2.dex */
public final class e<T> {
    private static final e<Void> d = new e<>(a.OnCompleted, null, null);

    /* renamed from: a  reason: collision with root package name */
    private final a f5264a;

    /* renamed from: b  reason: collision with root package name */
    private final Throwable f5265b;

    /* renamed from: c  reason: collision with root package name */
    private final T f5266c;

    /* compiled from: Notification.java */
    /* loaded from: classes2.dex */
    public enum a {
        OnNext,
        OnError,
        OnCompleted
    }

    public static <T> e<T> a(T t) {
        return new e<>(a.OnNext, t, null);
    }

    public static <T> e<T> a(Throwable th) {
        return new e<>(a.OnError, null, th);
    }

    public static <T> e<T> a() {
        return (e<T>) d;
    }

    private e(a aVar, T t, Throwable th) {
        this.f5266c = t;
        this.f5265b = th;
        this.f5264a = aVar;
    }

    public Throwable b() {
        return this.f5265b;
    }

    public T c() {
        return this.f5266c;
    }

    public boolean d() {
        return i() && this.f5266c != null;
    }

    public boolean e() {
        return g() && this.f5265b != null;
    }

    public a f() {
        return this.f5264a;
    }

    public boolean g() {
        return f() == a.OnError;
    }

    public boolean h() {
        return f() == a.OnCompleted;
    }

    public boolean i() {
        return f() == a.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(f());
        if (d()) {
            append.append(' ').append(c());
        }
        if (e()) {
            append.append(' ').append(b().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = f().hashCode();
        if (d()) {
            hashCode = (hashCode * 31) + c().hashCode();
        }
        if (e()) {
            return (hashCode * 31) + b().hashCode();
        }
        return hashCode;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj.getClass() == getClass()) {
            e eVar = (e) obj;
            if (eVar.f() != f() || ((this.f5266c != eVar.f5266c && (this.f5266c == null || !this.f5266c.equals(eVar.f5266c))) || (this.f5265b != eVar.f5265b && (this.f5265b == null || !this.f5265b.equals(eVar.f5265b))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}

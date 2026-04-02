package androidx.fragment.app;
/* loaded from: classes.dex */
public final class q0 {

    /* renamed from: b  reason: collision with root package name */
    public static final l.j f974b = new l.j();

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ w0 f975a;

    public q0(w0 w0Var) {
        this.f975a = w0Var;
    }

    public static Class b(ClassLoader classLoader, String str) {
        l.j jVar = f974b;
        l.j jVar2 = (l.j) jVar.getOrDefault(classLoader, null);
        if (jVar2 == null) {
            jVar2 = new l.j();
            jVar.put(classLoader, jVar2);
        }
        Class cls = (Class) jVar2.getOrDefault(str, null);
        if (cls == null) {
            Class<?> cls2 = Class.forName(str, false, classLoader);
            jVar2.put(str, cls2);
            return cls2;
        }
        return cls;
    }

    public static Class c(ClassLoader classLoader, String str) {
        try {
            return b(classLoader, str);
        } catch (ClassCastException e5) {
            throw new y("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e5);
        } catch (ClassNotFoundException e6) {
            throw new y("Unable to instantiate fragment " + str + ": make sure class name exists", e6);
        }
    }

    public final Fragment a(String str) {
        return Fragment.instantiate(this.f975a.f1043t.f919h, str, null);
    }
}

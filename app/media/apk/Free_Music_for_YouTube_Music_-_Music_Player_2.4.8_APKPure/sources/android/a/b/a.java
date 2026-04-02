package android.a.b;

import android.a.b.g;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: ClassesInfoCache.java */
/* loaded from: classes.dex */
class a {

    /* renamed from: a  reason: collision with root package name */
    static a f54a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class, C0002a> f55b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class, Boolean> f56c = new HashMap();

    a() {
    }

    /* compiled from: ClassesInfoCache.java */
    /* renamed from: android.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0002a {

        /* renamed from: a  reason: collision with root package name */
        final Map<g.a, List<b>> f57a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(h hVar, g.a aVar, Object obj) {
            a(this.f57a.get(aVar), hVar, aVar, obj);
            a(this.f57a.get(g.a.ON_ANY), hVar, aVar, obj);
        }

        private static void a(List<b> list, h hVar, g.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(hVar, aVar, obj);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ClassesInfoCache.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final int f58a;

        /* renamed from: b  reason: collision with root package name */
        final Method f59b;

        void a(h hVar, g.a aVar, Object obj) {
            try {
                switch (this.f58a) {
                    case 0:
                        this.f59b.invoke(obj, new Object[0]);
                        return;
                    case 1:
                        this.f59b.invoke(obj, hVar);
                        return;
                    case 2:
                        this.f59b.invoke(obj, hVar, aVar);
                        return;
                    default:
                        return;
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("Failed to call observer method", e2.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f58a == bVar.f58a && this.f59b.getName().equals(bVar.f59b.getName());
        }

        public int hashCode() {
            return (this.f58a * 31) + this.f59b.getName().hashCode();
        }
    }
}

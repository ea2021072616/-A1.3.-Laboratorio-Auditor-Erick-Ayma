package c1;

import android.content.Context;
import android.os.Bundle;
import android.os.Trace;
import androidx.fragment.app.y;
import b4.j;
import com.github.appintro.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f1709d;

    /* renamed from: e  reason: collision with root package name */
    public static final Object f1710e = new Object();

    /* renamed from: c  reason: collision with root package name */
    public final Context f1713c;

    /* renamed from: b  reason: collision with root package name */
    public final HashSet f1712b = new HashSet();

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1711a = new HashMap();

    public a(Context context) {
        this.f1713c = context.getApplicationContext();
    }

    public static a c(Context context) {
        if (f1709d == null) {
            synchronized (f1710e) {
                if (f1709d == null) {
                    f1709d = new a(context);
                }
            }
        }
        return f1709d;
    }

    public final void a(Bundle bundle) {
        HashSet hashSet;
        String string = this.f1713c.getString(R.string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet2 = new HashSet();
                Iterator<String> it = bundle.keySet().iterator();
                while (true) {
                    boolean hasNext = it.hasNext();
                    hashSet = this.f1712b;
                    if (!hasNext) {
                        break;
                    }
                    String next = it.next();
                    if (string.equals(bundle.getString(next, null))) {
                        Class<?> cls = Class.forName(next);
                        if (b.class.isAssignableFrom(cls)) {
                            hashSet.add(cls);
                        }
                    }
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    b((Class) it2.next(), hashSet2);
                }
            } catch (ClassNotFoundException e5) {
                throw new y(e5);
            }
        }
    }

    public final Object b(Class cls, HashSet hashSet) {
        Object obj;
        if (j.B()) {
            try {
                Trace.beginSection(cls.getSimpleName());
            } finally {
                Trace.endSection();
            }
        }
        if (hashSet.contains(cls)) {
            throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
        }
        HashMap hashMap = this.f1711a;
        if (hashMap.containsKey(cls)) {
            obj = hashMap.get(cls);
        } else {
            hashSet.add(cls);
            b bVar = (b) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            List<Class> a5 = bVar.a();
            if (!a5.isEmpty()) {
                for (Class cls2 : a5) {
                    if (!hashMap.containsKey(cls2)) {
                        b(cls2, hashSet);
                    }
                }
            }
            obj = bVar.b(this.f1713c);
            hashSet.remove(cls);
            hashMap.put(cls, obj);
        }
        return obj;
    }
}

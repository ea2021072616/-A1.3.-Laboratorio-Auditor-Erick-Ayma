package h;

import android.content.Context;
import android.view.MenuItem;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: g  reason: collision with root package name */
    public Object f2960g;

    /* renamed from: h  reason: collision with root package name */
    public Object f2961h;

    /* renamed from: i  reason: collision with root package name */
    public l.i f2962i;

    public d(Context context) {
        this.f2960g = context;
    }

    public static boolean l(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static boolean n(Map map, Collection collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public abstract void c();

    public abstract Object d(int i5, int i6);

    public abstract l.b e();

    public abstract int f();

    public abstract int g(Object obj);

    public abstract int h(Object obj);

    public abstract void i(Object obj, Object obj2);

    public abstract void j(int i5);

    public abstract Object k(int i5, Object obj);

    public final MenuItem m(MenuItem menuItem) {
        if (menuItem instanceof c0.b) {
            c0.b bVar = (c0.b) menuItem;
            if (((l.j) this.f2961h) == null) {
                this.f2961h = new l.j();
            }
            MenuItem menuItem2 = (MenuItem) ((l.j) this.f2961h).getOrDefault(bVar, null);
            if (menuItem2 == null) {
                v vVar = new v((Context) this.f2960g, bVar);
                ((l.j) this.f2961h).put(bVar, vVar);
                return vVar;
            }
            return menuItem2;
        }
        return menuItem;
    }

    public final Object[] o(int i5, Object[] objArr) {
        int f5 = f();
        if (objArr.length < f5) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), f5);
        }
        for (int i6 = 0; i6 < f5; i6++) {
            objArr[i6] = d(i6, i5);
        }
        if (objArr.length > f5) {
            objArr[f5] = null;
        }
        return objArr;
    }
}

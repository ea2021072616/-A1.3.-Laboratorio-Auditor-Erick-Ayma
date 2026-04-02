package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1096a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final Map f1097b;

    public b(HashMap hashMap) {
        this.f1097b = hashMap;
        for (Map.Entry entry : hashMap.entrySet()) {
            m mVar = (m) entry.getValue();
            List list = (List) this.f1096a.get(mVar);
            if (list == null) {
                list = new ArrayList();
                this.f1096a.put(mVar, list);
            }
            list.add((c) entry.getKey());
        }
    }

    public static void a(List list, t tVar, m mVar, Object obj) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                c cVar = (c) list.get(size);
                cVar.getClass();
                try {
                    int i5 = cVar.f1098a;
                    Method method = cVar.f1099b;
                    if (i5 == 0) {
                        method.invoke(obj, new Object[0]);
                    } else if (i5 == 1) {
                        method.invoke(obj, tVar);
                    } else if (i5 == 2) {
                        method.invoke(obj, tVar, mVar);
                    }
                } catch (IllegalAccessException e5) {
                    throw new RuntimeException(e5);
                } catch (InvocationTargetException e6) {
                    throw new RuntimeException("Failed to call observer method", e6.getCause());
                }
            }
        }
    }
}

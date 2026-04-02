package b4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class i extends p2.a {
    public static final Map c0(ArrayList arrayList) {
        g gVar = g.f1660b;
        int size = arrayList.size();
        if (size != 0) {
            if (size != 1) {
                LinkedHashMap linkedHashMap = new LinkedHashMap(p2.a.H(arrayList.size()));
                d0(arrayList, linkedHashMap);
                return linkedHashMap;
            }
            a4.a aVar = (a4.a) arrayList.get(0);
            e4.e.f(aVar, "pair");
            Map singletonMap = Collections.singletonMap(aVar.f28b, aVar.f29c);
            e4.e.e(singletonMap, "singletonMap(pair.first, pair.second)");
            return singletonMap;
        }
        return gVar;
    }

    public static final void d0(ArrayList arrayList, LinkedHashMap linkedHashMap) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a4.a aVar = (a4.a) it.next();
            linkedHashMap.put(aVar.f28b, aVar.f29c);
        }
    }
}

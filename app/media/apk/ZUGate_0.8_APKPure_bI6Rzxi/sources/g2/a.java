package g2;

import android.util.SparseArray;
import androidx.appcompat.widget.b0;
import java.util.HashMap;
import u1.c;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final SparseArray f2938a = new SparseArray();

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap f2939b;

    static {
        HashMap hashMap = new HashMap();
        f2939b = hashMap;
        hashMap.put(c.DEFAULT, 0);
        hashMap.put(c.VERY_LOW, 1);
        hashMap.put(c.HIGHEST, 2);
        for (c cVar : hashMap.keySet()) {
            f2938a.append(((Integer) f2939b.get(cVar)).intValue(), cVar);
        }
    }

    public static int a(c cVar) {
        Integer num = (Integer) f2939b.get(cVar);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + cVar);
    }

    public static c b(int i5) {
        c cVar = (c) f2938a.get(i5);
        if (cVar != null) {
            return cVar;
        }
        throw new IllegalArgumentException(b0.f("Unknown Priority for value ", i5));
    }
}

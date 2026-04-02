package androidx.recyclerview.widget;

import android.util.SparseArray;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
/* loaded from: classes.dex */
public final class x0 {

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray f1561a = new SparseArray();

    /* renamed from: b  reason: collision with root package name */
    public int f1562b = 0;

    /* renamed from: c  reason: collision with root package name */
    public final Set f1563c = Collections.newSetFromMap(new IdentityHashMap());

    public final w0 a(int i5) {
        SparseArray sparseArray = this.f1561a;
        w0 w0Var = (w0) sparseArray.get(i5);
        if (w0Var == null) {
            w0 w0Var2 = new w0();
            sparseArray.put(i5, w0Var2);
            return w0Var2;
        }
        return w0Var;
    }
}

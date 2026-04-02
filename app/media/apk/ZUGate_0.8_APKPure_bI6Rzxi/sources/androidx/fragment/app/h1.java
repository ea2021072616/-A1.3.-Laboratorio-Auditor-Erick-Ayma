package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class h1 {

    /* renamed from: a  reason: collision with root package name */
    public static final m1 f913a = new m1();

    /* renamed from: b  reason: collision with root package name */
    public static final o1 f914b;

    static {
        o1 o1Var;
        try {
            o1Var = (o1) e1.l.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            o1Var = null;
        }
        f914b = o1Var;
    }

    public static void a(ArrayList arrayList, int i5) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((View) arrayList.get(size)).setVisibility(i5);
        }
    }
}

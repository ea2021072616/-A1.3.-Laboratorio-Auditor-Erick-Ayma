package e1;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: b  reason: collision with root package name */
    public final View f2586b;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f2585a = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f2587c = new ArrayList();

    public a0(View view) {
        this.f2586b = view;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a0) {
            a0 a0Var = (a0) obj;
            return this.f2586b == a0Var.f2586b && this.f2585a.equals(a0Var.f2585a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2585a.hashCode() + (this.f2586b.hashCode() * 31);
    }

    public final String toString() {
        HashMap hashMap;
        String h5 = androidx.appcompat.widget.b0.h(("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f2586b + "\n", "    values:");
        for (String str : this.f2585a.keySet()) {
            h5 = h5 + "    " + str + ": " + hashMap.get(str) + "\n";
        }
        return h5;
    }
}

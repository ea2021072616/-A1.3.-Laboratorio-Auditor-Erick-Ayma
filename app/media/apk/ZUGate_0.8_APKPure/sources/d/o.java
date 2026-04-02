package d;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes.dex */
public final class o implements b1.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2442a = 1;

    /* renamed from: b  reason: collision with root package name */
    public final Object f2443b;

    public o(b1.d dVar) {
        e4.e.f(dVar, "registry");
        this.f2443b = new LinkedHashSet();
        dVar.c("androidx.savedstate.Restarter", this);
    }

    @Override // b1.c
    public final Bundle a() {
        int i5 = this.f2442a;
        Object obj = this.f2443b;
        switch (i5) {
            case 0:
                Bundle bundle = new Bundle();
                ((q) obj).getDelegate().getClass();
                return bundle;
            default:
                Bundle bundle2 = new Bundle();
                bundle2.putStringArrayList("classes_to_restore", new ArrayList<>((Set) obj));
                return bundle2;
        }
    }

    public o(q qVar) {
        this.f2443b = qVar;
    }
}

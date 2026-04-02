package androidx.fragment.app;

import java.util.HashSet;
/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    public final s1 f943a;

    /* renamed from: b  reason: collision with root package name */
    public final d0.c f944b;

    public l(s1 s1Var, d0.c cVar) {
        this.f943a = s1Var;
        this.f944b = cVar;
    }

    public final void a() {
        s1 s1Var = this.f943a;
        HashSet hashSet = s1Var.f1003e;
        if (hashSet.remove(this.f944b) && hashSet.isEmpty()) {
            s1Var.b();
        }
    }

    public final boolean b() {
        s1 s1Var = this.f943a;
        int c5 = androidx.appcompat.widget.b0.c(s1Var.f1001c.mView);
        int i5 = s1Var.f999a;
        return c5 == i5 || !(c5 == 2 || i5 == 2);
    }
}

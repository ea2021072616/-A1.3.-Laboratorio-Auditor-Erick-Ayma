package androidx.fragment.app;

import java.util.ArrayList;
/* loaded from: classes.dex */
public final class v0 implements u0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f1017a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1018b = 1;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ w0 f1019c;

    public v0(w0 w0Var, int i5) {
        this.f1019c = w0Var;
        this.f1017a = i5;
    }

    @Override // androidx.fragment.app.u0
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        w0 w0Var = this.f1019c;
        Fragment fragment = w0Var.f1046w;
        int i5 = this.f1017a;
        if (fragment == null || i5 >= 0 || !fragment.getChildFragmentManager().P()) {
            return w0Var.R(arrayList, arrayList2, i5, this.f1018b);
        }
        return false;
    }
}

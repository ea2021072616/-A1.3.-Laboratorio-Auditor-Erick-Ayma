package androidx.appcompat.widget;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
public final class l2 extends DataSetObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o2 f409a;

    public l2(o2 o2Var) {
        this.f409a = o2Var;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        o2 o2Var = this.f409a;
        if (o2Var.a()) {
            o2Var.f();
        }
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        this.f409a.dismiss();
    }
}

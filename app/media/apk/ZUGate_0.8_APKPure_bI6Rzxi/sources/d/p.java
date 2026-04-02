package d;

import android.content.Context;
/* loaded from: classes.dex */
public final class p implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q f2445a;

    public p(q qVar) {
        this.f2445a = qVar;
    }

    @Override // a.b
    public final void a(Context context) {
        q qVar = this.f2445a;
        y delegate = qVar.getDelegate();
        delegate.b();
        qVar.getSavedStateRegistry().a("androidx:appcompat");
        delegate.g();
    }
}

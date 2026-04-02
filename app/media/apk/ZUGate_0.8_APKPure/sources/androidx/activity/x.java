package androidx.activity;

import androidx.fragment.app.o0;
/* loaded from: classes.dex */
public final class x implements c {

    /* renamed from: a  reason: collision with root package name */
    public final o0 f117a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ z f118b;

    public x(z zVar, o0 o0Var) {
        this.f118b = zVar;
        this.f117a = o0Var;
    }

    @Override // androidx.activity.c
    public final void cancel() {
        z zVar = this.f118b;
        b4.c cVar = zVar.f121b;
        o0 o0Var = this.f117a;
        cVar.remove(o0Var);
        if (e4.e.a(zVar.f122c, o0Var)) {
            o0Var.getClass();
            zVar.f122c = null;
        }
        o0Var.getClass();
        o0Var.f962b.remove(this);
        i4.a aVar = o0Var.f963c;
        if (aVar != null) {
            aVar.a();
        }
        o0Var.f963c = null;
    }
}

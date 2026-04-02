package androidx.recyclerview.widget;

import android.os.Bundle;
/* loaded from: classes.dex */
public class b0 implements l2.b, z1.b {

    /* renamed from: g  reason: collision with root package name */
    public final Object f1296g;

    public /* synthetic */ b0(Object obj) {
        this.f1296g = obj;
    }

    @Override // l2.b
    public void a(i2.a aVar) {
        boolean z4 = aVar.f3381c == 0;
        Object obj = this.f1296g;
        if (z4) {
            l2.f fVar = (l2.f) obj;
            fVar.h(null, fVar.f3828w);
            return;
        }
        b0 b0Var = ((l2.f) obj).o;
        if (b0Var != null) {
            ((k2.h) b0Var.f1296g).a(aVar);
        }
    }

    public i0.j b(int i5) {
        return null;
    }

    public i0.j c(int i5) {
        return null;
    }

    public boolean d(int i5, int i6, Bundle bundle) {
        return false;
    }

    @Override // z3.a
    public Object get() {
        return this.f1296g;
    }

    public b0() {
        this.f1296g = new i0.l(this);
    }
}

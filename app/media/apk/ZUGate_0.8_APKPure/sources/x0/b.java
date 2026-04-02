package x0;

import androidx.appcompat.widget.b0;
import androidx.lifecycle.r0;
import l.k;
import p3.e;
/* loaded from: classes.dex */
public final class b extends r0 {

    /* renamed from: e  reason: collision with root package name */
    public static final e f5431e = new e(1);

    /* renamed from: d  reason: collision with root package name */
    public final k f5432d = new k();

    @Override // androidx.lifecycle.r0
    public final void b() {
        k kVar = this.f5432d;
        int i5 = kVar.f3709d;
        if (i5 > 0) {
            b0.n(kVar.f3708c[0]);
            throw null;
        }
        Object[] objArr = kVar.f3708c;
        for (int i6 = 0; i6 < i5; i6++) {
            objArr[i6] = null;
        }
        kVar.f3709d = 0;
    }
}

package android.a.b;

import android.a.b.g;
import android.support.annotation.RestrictTo;
/* compiled from: CompositeGeneratedAdaptersObserver.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class b implements f {

    /* renamed from: a  reason: collision with root package name */
    private final e[] f60a;

    @Override // android.a.b.f
    public void a(h hVar, g.a aVar) {
        k kVar = new k();
        for (e eVar : this.f60a) {
            eVar.a(hVar, aVar, false, kVar);
        }
        for (e eVar2 : this.f60a) {
            eVar2.a(hVar, aVar, true, kVar);
        }
    }
}

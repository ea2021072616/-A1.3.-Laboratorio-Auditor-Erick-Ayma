package androidx.emoji2.text;

import android.os.Build;
import com.google.android.gms.internal.play_billing.i0;
/* loaded from: classes.dex */
public final class g extends b4.j {

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ h f760x;

    public g(h hVar) {
        this.f760x = hVar;
    }

    @Override // b4.j
    public final void E(Throwable th) {
        ((m) this.f760x.f2463h).d(th);
    }

    @Override // b4.j
    public final void F(g.f fVar) {
        h hVar = this.f760x;
        hVar.f764j = fVar;
        g.f fVar2 = hVar.f764j;
        Object obj = hVar.f2463h;
        m mVar = (m) obj;
        p3.e eVar = mVar.f776g;
        f fVar3 = mVar.f778i;
        ((m) obj).getClass();
        hVar.f763i = new w(fVar2, eVar, fVar3, Build.VERSION.SDK_INT >= 34 ? r.a() : i0.A());
        ((m) hVar.f2463h).e();
    }
}

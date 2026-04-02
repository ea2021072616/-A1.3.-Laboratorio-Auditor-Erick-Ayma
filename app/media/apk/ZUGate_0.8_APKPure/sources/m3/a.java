package m3;

import android.graphics.Typeface;
/* loaded from: classes.dex */
public final class a extends p2.a {

    /* renamed from: u  reason: collision with root package name */
    public final Typeface f3963u;

    /* renamed from: v  reason: collision with root package name */
    public final n2.b f3964v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f3965w;

    public a(n2.b bVar, Typeface typeface) {
        this.f3963u = typeface;
        this.f3964v = bVar;
    }

    @Override // p2.a
    public final void M(int i5) {
        if (this.f3965w) {
            return;
        }
        j3.b bVar = (j3.b) this.f3964v.f4085g;
        if (bVar.j(this.f3963u)) {
            bVar.h(false);
        }
    }

    @Override // p2.a
    public final void N(Typeface typeface, boolean z4) {
        if (this.f3965w) {
            return;
        }
        j3.b bVar = (j3.b) this.f3964v.f4085g;
        if (bVar.j(typeface)) {
            bVar.h(false);
        }
    }
}

package j;

import java.util.Iterator;
/* loaded from: classes.dex */
public final class d extends f implements Iterator {

    /* renamed from: b  reason: collision with root package name */
    public c f3424b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3425c = true;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ g f3426d;

    public d(g gVar) {
        this.f3426d = gVar;
    }

    @Override // j.f
    public final void a(c cVar) {
        c cVar2 = this.f3424b;
        if (cVar == cVar2) {
            c cVar3 = cVar2.f3423e;
            this.f3424b = cVar3;
            this.f3425c = cVar3 == null;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f3425c) {
            return this.f3426d.f3429b != null;
        }
        c cVar = this.f3424b;
        return (cVar == null || cVar.f3422d == null) ? false : true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f3425c) {
            this.f3425c = false;
            this.f3424b = this.f3426d.f3429b;
        } else {
            c cVar = this.f3424b;
            this.f3424b = cVar != null ? cVar.f3422d : null;
        }
        return this.f3424b;
    }
}

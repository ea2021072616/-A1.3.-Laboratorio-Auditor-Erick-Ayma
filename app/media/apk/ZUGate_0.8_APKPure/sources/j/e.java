package j;

import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class e extends f implements Iterator {

    /* renamed from: b  reason: collision with root package name */
    public c f3427b;

    /* renamed from: c  reason: collision with root package name */
    public c f3428c;

    public e(c cVar, c cVar2) {
        this.f3427b = cVar2;
        this.f3428c = cVar;
    }

    @Override // j.f
    public final void a(c cVar) {
        c cVar2;
        if (this.f3427b == cVar && cVar == this.f3428c) {
            this.f3428c = null;
            this.f3427b = null;
        }
        c cVar3 = this.f3427b;
        if (cVar3 == cVar) {
            switch (((b) this).f3419d) {
                case 0:
                    cVar2 = cVar3.f3423e;
                    break;
                default:
                    cVar2 = cVar3.f3422d;
                    break;
            }
            this.f3427b = cVar2;
        }
        if (this.f3428c == cVar) {
            this.f3428c = b();
        }
    }

    public final c b() {
        c cVar = this.f3428c;
        c cVar2 = this.f3427b;
        if (cVar == cVar2 || cVar2 == null) {
            return null;
        }
        switch (((b) this).f3419d) {
            case 0:
                return cVar.f3422d;
            default:
                return cVar.f3423e;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3428c != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        c cVar = this.f3428c;
        this.f3428c = b();
        return cVar;
    }
}

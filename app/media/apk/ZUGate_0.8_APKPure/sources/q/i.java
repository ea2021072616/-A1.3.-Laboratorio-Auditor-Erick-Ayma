package q;

import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class i extends o {
    @Override // q.d
    public final void a(d dVar) {
        p.a aVar = (p.a) this.f4418b;
        int i5 = aVar.f4120s0;
        f fVar = this.f4424h;
        Iterator it = fVar.f4396l.iterator();
        int i6 = 0;
        int i7 = -1;
        while (it.hasNext()) {
            int i8 = ((f) it.next()).f4391g;
            if (i7 == -1 || i8 < i7) {
                i7 = i8;
            }
            if (i6 < i8) {
                i6 = i8;
            }
        }
        if (i5 == 0 || i5 == 2) {
            fVar.d(i7 + aVar.f4122u0);
        } else {
            fVar.d(i6 + aVar.f4122u0);
        }
    }

    @Override // q.o
    public final void d() {
        p.e eVar = this.f4418b;
        if (eVar instanceof p.a) {
            f fVar = this.f4424h;
            fVar.f4386b = true;
            p.a aVar = (p.a) eVar;
            int i5 = aVar.f4120s0;
            boolean z4 = aVar.f4121t0;
            ArrayList arrayList = fVar.f4396l;
            int i6 = 0;
            if (i5 == 0) {
                fVar.f4389e = 4;
                while (i6 < aVar.f4242r0) {
                    p.e eVar2 = aVar.f4241q0[i6];
                    if (z4 || eVar2.f4171g0 != 8) {
                        f fVar2 = eVar2.f4164d.f4424h;
                        fVar2.f4395k.add(fVar);
                        arrayList.add(fVar2);
                    }
                    i6++;
                }
                m(this.f4418b.f4164d.f4424h);
                m(this.f4418b.f4164d.f4425i);
            } else if (i5 == 1) {
                fVar.f4389e = 5;
                while (i6 < aVar.f4242r0) {
                    p.e eVar3 = aVar.f4241q0[i6];
                    if (z4 || eVar3.f4171g0 != 8) {
                        f fVar3 = eVar3.f4164d.f4425i;
                        fVar3.f4395k.add(fVar);
                        arrayList.add(fVar3);
                    }
                    i6++;
                }
                m(this.f4418b.f4164d.f4424h);
                m(this.f4418b.f4164d.f4425i);
            } else if (i5 == 2) {
                fVar.f4389e = 6;
                while (i6 < aVar.f4242r0) {
                    p.e eVar4 = aVar.f4241q0[i6];
                    if (z4 || eVar4.f4171g0 != 8) {
                        f fVar4 = eVar4.f4166e.f4424h;
                        fVar4.f4395k.add(fVar);
                        arrayList.add(fVar4);
                    }
                    i6++;
                }
                m(this.f4418b.f4166e.f4424h);
                m(this.f4418b.f4166e.f4425i);
            } else if (i5 != 3) {
            } else {
                fVar.f4389e = 7;
                while (i6 < aVar.f4242r0) {
                    p.e eVar5 = aVar.f4241q0[i6];
                    if (z4 || eVar5.f4171g0 != 8) {
                        f fVar5 = eVar5.f4166e.f4425i;
                        fVar5.f4395k.add(fVar);
                        arrayList.add(fVar5);
                    }
                    i6++;
                }
                m(this.f4418b.f4166e.f4424h);
                m(this.f4418b.f4166e.f4425i);
            }
        }
    }

    @Override // q.o
    public final void e() {
        p.e eVar = this.f4418b;
        if (eVar instanceof p.a) {
            int i5 = ((p.a) eVar).f4120s0;
            f fVar = this.f4424h;
            if (i5 == 0 || i5 == 1) {
                eVar.Y = fVar.f4391g;
            } else {
                eVar.Z = fVar.f4391g;
            }
        }
    }

    @Override // q.o
    public final void f() {
        this.f4419c = null;
        this.f4424h.c();
    }

    @Override // q.o
    public final boolean k() {
        return false;
    }

    public final void m(f fVar) {
        f fVar2 = this.f4424h;
        fVar2.f4395k.add(fVar);
        fVar.f4396l.add(fVar2);
    }
}

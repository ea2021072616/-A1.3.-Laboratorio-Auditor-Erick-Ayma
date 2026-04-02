package q;
/* loaded from: classes.dex */
public final class h extends o {
    public h(p.e eVar) {
        super(eVar);
        eVar.f4164d.f();
        eVar.f4166e.f();
        this.f4422f = ((p.i) eVar).f4239u0;
    }

    @Override // q.d
    public final void a(d dVar) {
        f fVar = this.f4424h;
        if (fVar.f4387c && !fVar.f4394j) {
            fVar.d((int) ((((f) fVar.f4396l.get(0)).f4391g * ((p.i) this.f4418b).f4235q0) + 0.5f));
        }
    }

    @Override // q.o
    public final void d() {
        p.e eVar = this.f4418b;
        p.i iVar = (p.i) eVar;
        int i5 = iVar.f4236r0;
        int i6 = iVar.f4237s0;
        int i7 = iVar.f4239u0;
        f fVar = this.f4424h;
        if (i7 == 1) {
            if (i5 != -1) {
                fVar.f4396l.add(eVar.T.f4164d.f4424h);
                this.f4418b.T.f4164d.f4424h.f4395k.add(fVar);
                fVar.f4390f = i5;
            } else if (i6 != -1) {
                fVar.f4396l.add(eVar.T.f4164d.f4425i);
                this.f4418b.T.f4164d.f4425i.f4395k.add(fVar);
                fVar.f4390f = -i6;
            } else {
                fVar.f4386b = true;
                fVar.f4396l.add(eVar.T.f4164d.f4425i);
                this.f4418b.T.f4164d.f4425i.f4395k.add(fVar);
            }
            m(this.f4418b.f4164d.f4424h);
            m(this.f4418b.f4164d.f4425i);
            return;
        }
        if (i5 != -1) {
            fVar.f4396l.add(eVar.T.f4166e.f4424h);
            this.f4418b.T.f4166e.f4424h.f4395k.add(fVar);
            fVar.f4390f = i5;
        } else if (i6 != -1) {
            fVar.f4396l.add(eVar.T.f4166e.f4425i);
            this.f4418b.T.f4166e.f4425i.f4395k.add(fVar);
            fVar.f4390f = -i6;
        } else {
            fVar.f4386b = true;
            fVar.f4396l.add(eVar.T.f4166e.f4425i);
            this.f4418b.T.f4166e.f4425i.f4395k.add(fVar);
        }
        m(this.f4418b.f4166e.f4424h);
        m(this.f4418b.f4166e.f4425i);
    }

    @Override // q.o
    public final void e() {
        p.e eVar = this.f4418b;
        int i5 = ((p.i) eVar).f4239u0;
        f fVar = this.f4424h;
        if (i5 == 1) {
            eVar.Y = fVar.f4391g;
        } else {
            eVar.Z = fVar.f4391g;
        }
    }

    @Override // q.o
    public final void f() {
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

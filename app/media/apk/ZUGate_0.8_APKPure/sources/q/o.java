package q;
/* loaded from: classes.dex */
public abstract class o implements d {

    /* renamed from: a  reason: collision with root package name */
    public int f4417a;

    /* renamed from: b  reason: collision with root package name */
    public p.e f4418b;

    /* renamed from: c  reason: collision with root package name */
    public k f4419c;

    /* renamed from: d  reason: collision with root package name */
    public int f4420d;

    /* renamed from: e  reason: collision with root package name */
    public final g f4421e = new g(this);

    /* renamed from: f  reason: collision with root package name */
    public int f4422f = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4423g = false;

    /* renamed from: h  reason: collision with root package name */
    public final f f4424h = new f(this);

    /* renamed from: i  reason: collision with root package name */
    public final f f4425i = new f(this);

    /* renamed from: j  reason: collision with root package name */
    public int f4426j = 1;

    public o(p.e eVar) {
        this.f4418b = eVar;
    }

    public static void b(f fVar, f fVar2, int i5) {
        fVar.f4396l.add(fVar2);
        fVar.f4390f = i5;
        fVar2.f4395k.add(fVar);
    }

    public static f h(p.d dVar) {
        p.d dVar2 = dVar.f4154f;
        if (dVar2 == null) {
            return null;
        }
        int ordinal = dVar2.f4153e.ordinal();
        p.e eVar = dVar2.f4152d;
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        if (ordinal != 5) {
                            return null;
                        }
                        return eVar.f4166e.f4401k;
                    }
                    return eVar.f4166e.f4425i;
                }
                return eVar.f4164d.f4425i;
            }
            return eVar.f4166e.f4424h;
        }
        return eVar.f4164d.f4424h;
    }

    public static f i(p.d dVar, int i5) {
        p.d dVar2 = dVar.f4154f;
        if (dVar2 == null) {
            return null;
        }
        p.e eVar = dVar2.f4152d;
        o oVar = i5 == 0 ? eVar.f4164d : eVar.f4166e;
        int ordinal = dVar2.f4153e.ordinal();
        if (ordinal == 1 || ordinal == 2) {
            return oVar.f4424h;
        }
        if (ordinal == 3 || ordinal == 4) {
            return oVar.f4425i;
        }
        return null;
    }

    public final void c(f fVar, f fVar2, int i5, g gVar) {
        fVar.f4396l.add(fVar2);
        fVar.f4396l.add(this.f4421e);
        fVar.f4392h = i5;
        fVar.f4393i = gVar;
        fVar2.f4395k.add(fVar);
        gVar.f4395k.add(fVar);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i5, int i6) {
        int max;
        if (i6 == 0) {
            p.e eVar = this.f4418b;
            int i7 = eVar.f4194v;
            max = Math.max(eVar.f4193u, i5);
            if (i7 > 0) {
                max = Math.min(i7, i5);
            }
            if (max == i5) {
                return i5;
            }
        } else {
            p.e eVar2 = this.f4418b;
            int i8 = eVar2.f4197y;
            max = Math.max(eVar2.f4196x, i5);
            if (i8 > 0) {
                max = Math.min(i8, i5);
            }
            if (max == i5) {
                return i5;
            }
        }
        return max;
    }

    public long j() {
        g gVar = this.f4421e;
        if (gVar.f4394j) {
            return gVar.f4391g;
        }
        return 0L;
    }

    public abstract boolean k();

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0051, code lost:
        if (r9.f4417a == 3) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(p.d r12, p.d r13, int r14) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q.o.l(p.d, p.d, int):void");
    }
}

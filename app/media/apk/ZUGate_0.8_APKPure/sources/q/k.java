package q;

import java.util.ArrayList;
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final o f4399a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f4400b = new ArrayList();

    public k(o oVar) {
        this.f4399a = null;
        this.f4399a = oVar;
    }

    public static long a(f fVar, long j5) {
        o oVar = fVar.f4388d;
        if (oVar instanceof i) {
            return j5;
        }
        ArrayList arrayList = fVar.f4395k;
        int size = arrayList.size();
        long j6 = j5;
        for (int i5 = 0; i5 < size; i5++) {
            d dVar = (d) arrayList.get(i5);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f4388d != oVar) {
                    j6 = Math.min(j6, a(fVar2, fVar2.f4390f + j5));
                }
            }
        }
        if (fVar == oVar.f4425i) {
            long j7 = oVar.j();
            f fVar3 = oVar.f4424h;
            long j8 = j5 - j7;
            return Math.min(Math.min(j6, a(fVar3, j8)), j8 - fVar3.f4390f);
        }
        return j6;
    }

    public static long b(f fVar, long j5) {
        o oVar = fVar.f4388d;
        if (oVar instanceof i) {
            return j5;
        }
        ArrayList arrayList = fVar.f4395k;
        int size = arrayList.size();
        long j6 = j5;
        for (int i5 = 0; i5 < size; i5++) {
            d dVar = (d) arrayList.get(i5);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f4388d != oVar) {
                    j6 = Math.max(j6, b(fVar2, fVar2.f4390f + j5));
                }
            }
        }
        if (fVar == oVar.f4424h) {
            long j7 = oVar.j();
            f fVar3 = oVar.f4425i;
            long j8 = j5 + j7;
            return Math.max(Math.max(j6, b(fVar3, j8)), j8 - fVar3.f4390f);
        }
        return j6;
    }
}

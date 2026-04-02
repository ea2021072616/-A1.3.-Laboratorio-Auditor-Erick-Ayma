package q;

import androidx.appcompat.widget.b0;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class n {

    /* renamed from: f  reason: collision with root package name */
    public static int f4411f;

    /* renamed from: b  reason: collision with root package name */
    public final int f4413b;

    /* renamed from: c  reason: collision with root package name */
    public int f4414c;

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f4412a = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f4415d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f4416e = -1;

    public n(int i5) {
        this.f4413b = -1;
        int i6 = f4411f;
        f4411f = i6 + 1;
        this.f4413b = i6;
        this.f4414c = i5;
    }

    public final void a(ArrayList arrayList) {
        int size = this.f4412a.size();
        if (this.f4416e != -1 && size > 0) {
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                n nVar = (n) arrayList.get(i5);
                if (this.f4416e == nVar.f4413b) {
                    c(this.f4414c, nVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public final int b(n.d dVar, int i5) {
        int n5;
        int n6;
        ArrayList arrayList = this.f4412a;
        if (arrayList.size() == 0) {
            return 0;
        }
        p.f fVar = (p.f) ((p.e) arrayList.get(0)).T;
        dVar.t();
        fVar.c(dVar, false);
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            ((p.e) arrayList.get(i6)).c(dVar, false);
        }
        if (i5 == 0 && fVar.f4207z0 > 0) {
            p2.a.a(fVar, dVar, arrayList, 0);
        }
        if (i5 == 1 && fVar.A0 > 0) {
            p2.a.a(fVar, dVar, arrayList, 1);
        }
        try {
            dVar.p();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        this.f4415d = new ArrayList();
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            this.f4415d.add(new m(this, (p.e) arrayList.get(i7), dVar, i5));
        }
        if (i5 == 0) {
            n5 = n.d.n(fVar.I);
            n6 = n.d.n(fVar.K);
            dVar.t();
        } else {
            n5 = n.d.n(fVar.J);
            n6 = n.d.n(fVar.L);
            dVar.t();
        }
        return n6 - n5;
    }

    public final void c(int i5, n nVar) {
        Iterator it = this.f4412a.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            int i6 = nVar.f4413b;
            if (!hasNext) {
                this.f4416e = i6;
                return;
            }
            p.e eVar = (p.e) it.next();
            ArrayList arrayList = nVar.f4412a;
            if (!arrayList.contains(eVar)) {
                arrayList.add(eVar);
            }
            if (i5 == 0) {
                eVar.f4185n0 = i6;
            } else {
                eVar.f4186o0 = i6;
            }
        }
    }

    public final String toString() {
        Iterator it;
        StringBuilder sb = new StringBuilder();
        int i5 = this.f4414c;
        sb.append(i5 == 0 ? "Horizontal" : i5 == 1 ? "Vertical" : i5 == 2 ? "Both" : "Unknown");
        sb.append(" [");
        sb.append(this.f4413b);
        sb.append("] <");
        String sb2 = sb.toString();
        while (this.f4412a.iterator().hasNext()) {
            sb2 = sb2 + " " + ((p.e) it.next()).f4173h0;
        }
        return b0.h(sb2, " >");
    }
}

package q;

import androidx.appcompat.widget.b0;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class f implements d {

    /* renamed from: d  reason: collision with root package name */
    public final o f4388d;

    /* renamed from: f  reason: collision with root package name */
    public int f4390f;

    /* renamed from: g  reason: collision with root package name */
    public int f4391g;

    /* renamed from: a  reason: collision with root package name */
    public o f4385a = null;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4386b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4387c = false;

    /* renamed from: e  reason: collision with root package name */
    public int f4389e = 1;

    /* renamed from: h  reason: collision with root package name */
    public int f4392h = 1;

    /* renamed from: i  reason: collision with root package name */
    public g f4393i = null;

    /* renamed from: j  reason: collision with root package name */
    public boolean f4394j = false;

    /* renamed from: k  reason: collision with root package name */
    public final ArrayList f4395k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    public final ArrayList f4396l = new ArrayList();

    public f(o oVar) {
        this.f4388d = oVar;
    }

    @Override // q.d
    public final void a(d dVar) {
        ArrayList arrayList = this.f4396l;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!((f) it.next()).f4394j) {
                return;
            }
        }
        this.f4387c = true;
        o oVar = this.f4385a;
        if (oVar != null) {
            oVar.a(this);
        }
        if (this.f4386b) {
            this.f4388d.a(this);
            return;
        }
        Iterator it2 = arrayList.iterator();
        f fVar = null;
        int i5 = 0;
        while (it2.hasNext()) {
            f fVar2 = (f) it2.next();
            if (!(fVar2 instanceof g)) {
                i5++;
                fVar = fVar2;
            }
        }
        if (fVar != null && i5 == 1 && fVar.f4394j) {
            g gVar = this.f4393i;
            if (gVar != null) {
                if (!gVar.f4394j) {
                    return;
                }
                this.f4390f = this.f4392h * gVar.f4391g;
            }
            d(fVar.f4391g + this.f4390f);
        }
        o oVar2 = this.f4385a;
        if (oVar2 != null) {
            oVar2.a(this);
        }
    }

    public final void b(d dVar) {
        this.f4395k.add(dVar);
        if (this.f4394j) {
            dVar.a(dVar);
        }
    }

    public final void c() {
        this.f4396l.clear();
        this.f4395k.clear();
        this.f4394j = false;
        this.f4391g = 0;
        this.f4387c = false;
        this.f4386b = false;
    }

    public void d(int i5) {
        if (this.f4394j) {
            return;
        }
        this.f4394j = true;
        this.f4391g = i5;
        Iterator it = this.f4395k.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            dVar.a(dVar);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4388d.f4418b.f4173h0);
        sb.append(":");
        sb.append(b0.q(this.f4389e));
        sb.append("(");
        sb.append(this.f4394j ? Integer.valueOf(this.f4391g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.f4396l.size());
        sb.append(":d=");
        sb.append(this.f4395k.size());
        sb.append(">");
        return sb.toString();
    }
}

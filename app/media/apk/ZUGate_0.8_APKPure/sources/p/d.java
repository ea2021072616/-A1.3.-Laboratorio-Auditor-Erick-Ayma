package p;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import q.n;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: b  reason: collision with root package name */
    public int f4150b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4151c;

    /* renamed from: d  reason: collision with root package name */
    public final e f4152d;

    /* renamed from: e  reason: collision with root package name */
    public final c f4153e;

    /* renamed from: f  reason: collision with root package name */
    public d f4154f;

    /* renamed from: i  reason: collision with root package name */
    public n.i f4157i;

    /* renamed from: a  reason: collision with root package name */
    public HashSet f4149a = null;

    /* renamed from: g  reason: collision with root package name */
    public int f4155g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f4156h = Integer.MIN_VALUE;

    public d(e eVar, c cVar) {
        this.f4152d = eVar;
        this.f4153e = cVar;
    }

    public final void a(d dVar, int i5) {
        b(dVar, i5, Integer.MIN_VALUE, false);
    }

    public final boolean b(d dVar, int i5, int i6, boolean z4) {
        if (dVar == null) {
            j();
            return true;
        } else if (z4 || i(dVar)) {
            this.f4154f = dVar;
            if (dVar.f4149a == null) {
                dVar.f4149a = new HashSet();
            }
            HashSet hashSet = this.f4154f.f4149a;
            if (hashSet != null) {
                hashSet.add(this);
            }
            this.f4155g = i5;
            this.f4156h = i6;
            return true;
        } else {
            return false;
        }
    }

    public final void c(int i5, n nVar, ArrayList arrayList) {
        HashSet hashSet = this.f4149a;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                m0.a.e(((d) it.next()).f4152d, i5, arrayList, nVar);
            }
        }
    }

    public final int d() {
        if (this.f4151c) {
            return this.f4150b;
        }
        return 0;
    }

    public final int e() {
        d dVar;
        if (this.f4152d.f4171g0 == 8) {
            return 0;
        }
        int i5 = this.f4156h;
        return (i5 == Integer.MIN_VALUE || (dVar = this.f4154f) == null || dVar.f4152d.f4171g0 != 8) ? this.f4155g : i5;
    }

    public final d f() {
        c cVar = this.f4153e;
        int ordinal = cVar.ordinal();
        e eVar = this.f4152d;
        switch (ordinal) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
                return eVar.K;
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                return eVar.L;
            case 3:
                return eVar.I;
            case 4:
                return eVar.J;
            default:
                throw new AssertionError(cVar.name());
        }
    }

    public final boolean g() {
        HashSet hashSet = this.f4149a;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((d) it.next()).f().h()) {
                return true;
            }
        }
        return false;
    }

    public final boolean h() {
        return this.f4154f != null;
    }

    public final boolean i(d dVar) {
        boolean z4 = false;
        if (dVar == null) {
            return false;
        }
        c cVar = c.BASELINE;
        c cVar2 = this.f4153e;
        e eVar = dVar.f4152d;
        c cVar3 = dVar.f4153e;
        if (cVar3 == cVar2) {
            return cVar2 != cVar || (eVar.E && this.f4152d.E);
        }
        int ordinal = cVar2.ordinal();
        c cVar4 = c.CENTER_Y;
        c cVar5 = c.RIGHT;
        c cVar6 = c.CENTER_X;
        c cVar7 = c.LEFT;
        switch (ordinal) {
            case 0:
            case 7:
            case 8:
                return false;
            case 1:
            case 3:
                boolean z5 = cVar3 == cVar7 || cVar3 == cVar5;
                if (eVar instanceof i) {
                    if (z5 || cVar3 == cVar6) {
                        z4 = true;
                    }
                    return z4;
                }
                return z5;
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
            case 4:
                boolean z6 = cVar3 == c.TOP || cVar3 == c.BOTTOM;
                if (eVar instanceof i) {
                    if (z6 || cVar3 == cVar4) {
                        z4 = true;
                    }
                    return z4;
                }
                return z6;
            case 5:
                return (cVar3 == cVar7 || cVar3 == cVar5) ? false : true;
            case 6:
                return (cVar3 == cVar || cVar3 == cVar6 || cVar3 == cVar4) ? false : true;
            default:
                throw new AssertionError(cVar2.name());
        }
    }

    public final void j() {
        HashSet hashSet;
        d dVar = this.f4154f;
        if (dVar != null && (hashSet = dVar.f4149a) != null) {
            hashSet.remove(this);
            if (this.f4154f.f4149a.size() == 0) {
                this.f4154f.f4149a = null;
            }
        }
        this.f4149a = null;
        this.f4154f = null;
        this.f4155g = 0;
        this.f4156h = Integer.MIN_VALUE;
        this.f4151c = false;
        this.f4150b = 0;
    }

    public final void k() {
        n.i iVar = this.f4157i;
        if (iVar == null) {
            this.f4157i = new n.i(1);
        } else {
            iVar.c();
        }
    }

    public final void l(int i5) {
        this.f4150b = i5;
        this.f4151c = true;
    }

    public final String toString() {
        return this.f4152d.f4173h0 + ":" + this.f4153e.toString();
    }
}

package androidx.recyclerview.widget;

import android.view.View;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public final class u1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1536a;

    /* renamed from: b  reason: collision with root package name */
    public Object f1537b;

    /* renamed from: c  reason: collision with root package name */
    public Object f1538c;

    public u1(int i5) {
        this.f1536a = i5;
        if (i5 != 1) {
            this.f1537b = new l.j();
            this.f1538c = new l.d();
        }
    }

    public final void a(i1 i1Var) {
        t1 t1Var = (t1) ((l.j) this.f1537b).getOrDefault(i1Var, null);
        if (t1Var == null) {
            t1Var = t1.a();
            ((l.j) this.f1537b).put(i1Var, t1Var);
        }
        t1Var.f1531a |= 1;
    }

    public final void b(i1 i1Var, m0 m0Var) {
        t1 t1Var = (t1) ((l.j) this.f1537b).getOrDefault(i1Var, null);
        if (t1Var == null) {
            t1Var = t1.a();
            ((l.j) this.f1537b).put(i1Var, t1Var);
        }
        t1Var.f1533c = m0Var;
        t1Var.f1531a |= 8;
    }

    public final void c(i1 i1Var, m0 m0Var) {
        t1 t1Var = (t1) ((l.j) this.f1537b).getOrDefault(i1Var, null);
        if (t1Var == null) {
            t1Var = t1.a();
            ((l.j) this.f1537b).put(i1Var, t1Var);
        }
        t1Var.f1532b = m0Var;
        t1Var.f1531a |= 4;
    }

    public final void d() {
        switch (this.f1536a) {
            case 0:
                ((l.j) this.f1537b).clear();
                ((l.d) this.f1538c).a();
                return;
            default:
                int[] iArr = (int[]) this.f1537b;
                if (iArr != null) {
                    Arrays.fill(iArr, -1);
                }
                this.f1538c = null;
                return;
        }
    }

    public final void e(int i5) {
        Object obj = this.f1537b;
        if (((int[]) obj) == null) {
            int[] iArr = new int[Math.max(i5, 10) + 1];
            this.f1537b = iArr;
            Arrays.fill(iArr, -1);
        } else if (i5 >= ((int[]) obj).length) {
            int[] iArr2 = (int[]) obj;
            int length = ((int[]) obj).length;
            while (length <= i5) {
                length *= 2;
            }
            int[] iArr3 = new int[length];
            this.f1537b = iArr3;
            System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
            Object obj2 = this.f1537b;
            Arrays.fill((int[]) obj2, iArr2.length, ((int[]) obj2).length, -1);
        }
    }

    public final View f(int i5, int i6, int i7, int i8) {
        int G;
        View u3;
        p0 p0Var = (p0) ((s1) this.f1537b);
        int i9 = p0Var.f1445a;
        r0 r0Var = p0Var.f1446b;
        switch (i9) {
            case 0:
                G = r0Var.E();
                break;
            default:
                G = r0Var.G();
                break;
        }
        int c5 = ((p0) ((s1) this.f1537b)).c();
        int i10 = i6 > i5 ? 1 : -1;
        View view = null;
        while (i5 != i6) {
            p0 p0Var2 = (p0) ((s1) this.f1537b);
            int i11 = p0Var2.f1445a;
            r0 r0Var2 = p0Var2.f1446b;
            switch (i11) {
                case 0:
                    u3 = r0Var2.u(i5);
                    break;
                default:
                    u3 = r0Var2.u(i5);
                    break;
            }
            int b5 = ((p0) ((s1) this.f1537b)).b(u3);
            int a5 = ((p0) ((s1) this.f1537b)).a(u3);
            Object obj = this.f1538c;
            r1 r1Var = (r1) obj;
            r1Var.f1511b = G;
            r1Var.f1512c = c5;
            r1Var.f1513d = b5;
            r1Var.f1514e = a5;
            if (i7 != 0) {
                ((r1) obj).f1510a = i7 | 0;
                if (((r1) obj).a()) {
                    return u3;
                }
            }
            if (i8 != 0) {
                Object obj2 = this.f1538c;
                ((r1) obj2).f1510a = i8 | 0;
                if (((r1) obj2).a()) {
                    view = u3;
                }
            }
            i5 += i10;
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int g(int r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f1537b
            int[] r0 = (int[]) r0
            r1 = -1
            if (r0 != 0) goto L8
            return r1
        L8:
            int r0 = r0.length
            if (r6 < r0) goto Lc
            return r1
        Lc:
            java.lang.Object r0 = r5.f1538c
            r2 = r0
            java.util.List r2 = (java.util.List) r2
            if (r2 != 0) goto L14
            goto L71
        L14:
            java.util.List r0 = (java.util.List) r0
            r2 = 0
            if (r0 != 0) goto L1a
            goto L34
        L1a:
            int r0 = r0.size()
            int r0 = r0 + r1
        L1f:
            if (r0 < 0) goto L34
            java.lang.Object r3 = r5.f1538c
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r3 = r3.get(r0)
            androidx.recyclerview.widget.o1 r3 = (androidx.recyclerview.widget.o1) r3
            int r4 = r3.f1440b
            if (r4 != r6) goto L31
            r2 = r3
            goto L34
        L31:
            int r0 = r0 + (-1)
            goto L1f
        L34:
            if (r2 == 0) goto L3d
            java.lang.Object r0 = r5.f1538c
            java.util.List r0 = (java.util.List) r0
            r0.remove(r2)
        L3d:
            java.lang.Object r0 = r5.f1538c
            java.util.List r0 = (java.util.List) r0
            int r0 = r0.size()
            r2 = 0
        L46:
            if (r2 >= r0) goto L5a
            java.lang.Object r3 = r5.f1538c
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r3 = r3.get(r2)
            androidx.recyclerview.widget.o1 r3 = (androidx.recyclerview.widget.o1) r3
            int r3 = r3.f1440b
            if (r3 < r6) goto L57
            goto L5b
        L57:
            int r2 = r2 + 1
            goto L46
        L5a:
            r2 = r1
        L5b:
            if (r2 == r1) goto L71
            java.lang.Object r0 = r5.f1538c
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r0 = r0.get(r2)
            androidx.recyclerview.widget.o1 r0 = (androidx.recyclerview.widget.o1) r0
            java.lang.Object r3 = r5.f1538c
            java.util.List r3 = (java.util.List) r3
            r3.remove(r2)
            int r0 = r0.f1440b
            goto L72
        L71:
            r0 = r1
        L72:
            if (r0 != r1) goto L82
            java.lang.Object r0 = r5.f1537b
            int[] r0 = (int[]) r0
            int r2 = r0.length
            java.util.Arrays.fill(r0, r6, r2, r1)
            java.lang.Object r6 = r5.f1537b
            int[] r6 = (int[]) r6
            int r6 = r6.length
            return r6
        L82:
            int r0 = r0 + 1
            java.lang.Object r2 = r5.f1537b
            int[] r2 = (int[]) r2
            int r2 = r2.length
            int r0 = java.lang.Math.min(r0, r2)
            java.lang.Object r2 = r5.f1537b
            int[] r2 = (int[]) r2
            java.util.Arrays.fill(r2, r6, r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.u1.g(int):int");
    }

    public final boolean h(View view) {
        int G;
        r1 r1Var = (r1) this.f1538c;
        p0 p0Var = (p0) ((s1) this.f1537b);
        int i5 = p0Var.f1445a;
        r0 r0Var = p0Var.f1446b;
        switch (i5) {
            case 0:
                G = r0Var.E();
                break;
            default:
                G = r0Var.G();
                break;
        }
        int c5 = ((p0) ((s1) this.f1537b)).c();
        int b5 = ((p0) ((s1) this.f1537b)).b(view);
        int a5 = ((p0) ((s1) this.f1537b)).a(view);
        r1Var.f1511b = G;
        r1Var.f1512c = c5;
        r1Var.f1513d = b5;
        r1Var.f1514e = a5;
        Object obj = this.f1538c;
        ((r1) obj).f1510a = 24579 | 0;
        return ((r1) obj).a();
    }

    public final void i(int i5, int i6) {
        int[] iArr = (int[]) this.f1537b;
        if (iArr == null || i5 >= iArr.length) {
            return;
        }
        int i7 = i5 + i6;
        e(i7);
        int[] iArr2 = (int[]) this.f1537b;
        System.arraycopy(iArr2, i5, iArr2, i7, (iArr2.length - i5) - i6);
        Arrays.fill((int[]) this.f1537b, i5, i7, -1);
        List list = (List) this.f1538c;
        if (list == null) {
            return;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            o1 o1Var = (o1) ((List) this.f1538c).get(size);
            int i8 = o1Var.f1440b;
            if (i8 >= i5) {
                o1Var.f1440b = i8 + i6;
            }
        }
    }

    public final void j(int i5, int i6) {
        int[] iArr = (int[]) this.f1537b;
        if (iArr == null || i5 >= iArr.length) {
            return;
        }
        int i7 = i5 + i6;
        e(i7);
        int[] iArr2 = (int[]) this.f1537b;
        System.arraycopy(iArr2, i7, iArr2, i5, (iArr2.length - i5) - i6);
        int[] iArr3 = (int[]) this.f1537b;
        Arrays.fill(iArr3, iArr3.length - i6, iArr3.length, -1);
        List list = (List) this.f1538c;
        if (list == null) {
            return;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            o1 o1Var = (o1) ((List) this.f1538c).get(size);
            int i8 = o1Var.f1440b;
            if (i8 >= i5) {
                if (i8 < i7) {
                    ((List) this.f1538c).remove(size);
                } else {
                    o1Var.f1440b = i8 - i6;
                }
            }
        }
    }

    public final m0 k(i1 i1Var, int i5) {
        t1 t1Var;
        m0 m0Var;
        int e5 = ((l.j) this.f1537b).e(i1Var);
        if (e5 >= 0 && (t1Var = (t1) ((l.j) this.f1537b).j(e5)) != null) {
            int i6 = t1Var.f1531a;
            if ((i6 & i5) != 0) {
                int i7 = i6 & (~i5);
                t1Var.f1531a = i7;
                if (i5 == 4) {
                    m0Var = t1Var.f1532b;
                } else if (i5 != 8) {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                } else {
                    m0Var = t1Var.f1533c;
                }
                if ((i7 & 12) == 0) {
                    ((l.j) this.f1537b).i(e5);
                    t1Var.f1531a = 0;
                    t1Var.f1532b = null;
                    t1Var.f1533c = null;
                    t1.f1530d.b(t1Var);
                }
                return m0Var;
            }
        }
        return null;
    }

    public final void l(i1 i1Var) {
        t1 t1Var = (t1) ((l.j) this.f1537b).getOrDefault(i1Var, null);
        if (t1Var == null) {
            return;
        }
        t1Var.f1531a &= -2;
    }

    public final void m(i1 i1Var) {
        l.d dVar = (l.d) this.f1538c;
        if (dVar.f3677b) {
            dVar.c();
        }
        int i5 = dVar.f3680e - 1;
        while (true) {
            if (i5 < 0) {
                break;
            } else if (i1Var == ((l.d) this.f1538c).f(i5)) {
                l.d dVar2 = (l.d) this.f1538c;
                Object[] objArr = dVar2.f3679d;
                Object obj = objArr[i5];
                Object obj2 = l.d.f3676f;
                if (obj != obj2) {
                    objArr[i5] = obj2;
                    dVar2.f3677b = true;
                }
            } else {
                i5--;
            }
        }
        t1 t1Var = (t1) ((l.j) this.f1537b).remove(i1Var);
        if (t1Var != null) {
            t1Var.f1531a = 0;
            t1Var.f1532b = null;
            t1Var.f1533c = null;
            t1.f1530d.b(t1Var);
        }
    }

    public u1(p0 p0Var) {
        this.f1536a = 2;
        this.f1537b = p0Var;
        this.f1538c = new r1();
    }
}

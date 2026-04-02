package androidx.recyclerview.widget;

import java.util.ArrayList;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: d  reason: collision with root package name */
    public final h0 f1293d;

    /* renamed from: a  reason: collision with root package name */
    public final n.e f1290a = new n.e(30, 1);

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f1291b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f1292c = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public int f1295f = 0;

    /* renamed from: e  reason: collision with root package name */
    public final b0 f1294e = new b0(this);

    public b(h0 h0Var) {
        this.f1293d = h0Var;
    }

    public final boolean a(int i5) {
        ArrayList arrayList = this.f1292c;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            a aVar = (a) arrayList.get(i6);
            int i7 = aVar.f1270a;
            if (i7 == 8) {
                if (f(aVar.f1273d, i6 + 1) == i5) {
                    return true;
                }
            } else if (i7 == 1) {
                int i8 = aVar.f1271b;
                int i9 = aVar.f1273d + i8;
                while (i8 < i9) {
                    if (f(i8, i6 + 1) == i5) {
                        return true;
                    }
                    i8++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    public final void b() {
        ArrayList arrayList = this.f1292c;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.f1293d.a((a) arrayList.get(i5));
        }
        k(arrayList);
        this.f1295f = 0;
    }

    public final void c() {
        b();
        ArrayList arrayList = this.f1291b;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            a aVar = (a) arrayList.get(i5);
            int i6 = aVar.f1270a;
            h0 h0Var = this.f1293d;
            if (i6 == 1) {
                h0Var.a(aVar);
                h0Var.e(aVar.f1271b, aVar.f1273d);
            } else if (i6 == 2) {
                h0Var.a(aVar);
                int i7 = aVar.f1271b;
                int i8 = aVar.f1273d;
                RecyclerView recyclerView = h0Var.f1358a;
                recyclerView.R(i7, true, i8);
                recyclerView.f1238p0 = true;
                recyclerView.f1233m0.f1324c += i8;
            } else if (i6 == 4) {
                h0Var.a(aVar);
                h0Var.d(aVar.f1271b, aVar.f1273d, aVar.f1272c);
            } else if (i6 == 8) {
                h0Var.a(aVar);
                h0Var.f(aVar.f1271b, aVar.f1273d);
            }
        }
        k(arrayList);
        this.f1295f = 0;
    }

    public final void d(a aVar) {
        int i5;
        n.e eVar;
        int i6 = aVar.f1270a;
        if (i6 == 1 || i6 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int l5 = l(aVar.f1271b, i6);
        int i7 = aVar.f1271b;
        int i8 = aVar.f1270a;
        if (i8 == 2) {
            i5 = 0;
        } else if (i8 != 4) {
            throw new IllegalArgumentException("op should be remove or update." + aVar);
        } else {
            i5 = 1;
        }
        int i9 = 1;
        int i10 = 1;
        while (true) {
            int i11 = aVar.f1273d;
            eVar = this.f1290a;
            if (i9 >= i11) {
                break;
            }
            int l6 = l((i5 * i9) + aVar.f1271b, aVar.f1270a);
            int i12 = aVar.f1270a;
            if (i12 == 2 ? l6 == l5 : i12 == 4 && l6 == l5 + 1) {
                i10++;
            } else {
                a h5 = h(aVar.f1272c, i12, l5, i10);
                e(h5, i7);
                h5.f1272c = null;
                eVar.b(h5);
                if (aVar.f1270a == 4) {
                    i7 += i10;
                }
                i10 = 1;
                l5 = l6;
            }
            i9++;
        }
        Object obj = aVar.f1272c;
        aVar.f1272c = null;
        eVar.b(aVar);
        if (i10 > 0) {
            a h6 = h(obj, aVar.f1270a, l5, i10);
            e(h6, i7);
            h6.f1272c = null;
            eVar.b(h6);
        }
    }

    public final void e(a aVar, int i5) {
        h0 h0Var = this.f1293d;
        h0Var.a(aVar);
        int i6 = aVar.f1270a;
        if (i6 != 2) {
            if (i6 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            h0Var.d(i5, aVar.f1273d, aVar.f1272c);
            return;
        }
        int i7 = aVar.f1273d;
        RecyclerView recyclerView = h0Var.f1358a;
        recyclerView.R(i5, true, i7);
        recyclerView.f1238p0 = true;
        recyclerView.f1233m0.f1324c += i7;
    }

    public final int f(int i5, int i6) {
        ArrayList arrayList = this.f1292c;
        int size = arrayList.size();
        while (i6 < size) {
            a aVar = (a) arrayList.get(i6);
            int i7 = aVar.f1270a;
            if (i7 == 8) {
                int i8 = aVar.f1271b;
                if (i8 == i5) {
                    i5 = aVar.f1273d;
                } else {
                    if (i8 < i5) {
                        i5--;
                    }
                    if (aVar.f1273d <= i5) {
                        i5++;
                    }
                }
            } else {
                int i9 = aVar.f1271b;
                if (i9 > i5) {
                    continue;
                } else if (i7 == 2) {
                    int i10 = aVar.f1273d;
                    if (i5 < i9 + i10) {
                        return -1;
                    }
                    i5 -= i10;
                } else if (i7 == 1) {
                    i5 += aVar.f1273d;
                }
            }
            i6++;
        }
        return i5;
    }

    public final boolean g() {
        return this.f1291b.size() > 0;
    }

    public final a h(Object obj, int i5, int i6, int i7) {
        a aVar = (a) this.f1290a.a();
        if (aVar == null) {
            return new a(obj, i5, i6, i7);
        }
        aVar.f1270a = i5;
        aVar.f1271b = i6;
        aVar.f1273d = i7;
        aVar.f1272c = obj;
        return aVar;
    }

    public final void i(a aVar) {
        this.f1292c.add(aVar);
        int i5 = aVar.f1270a;
        h0 h0Var = this.f1293d;
        if (i5 == 1) {
            h0Var.e(aVar.f1271b, aVar.f1273d);
        } else if (i5 == 2) {
            int i6 = aVar.f1271b;
            int i7 = aVar.f1273d;
            RecyclerView recyclerView = h0Var.f1358a;
            recyclerView.R(i6, false, i7);
            recyclerView.f1238p0 = true;
        } else if (i5 == 4) {
            h0Var.d(aVar.f1271b, aVar.f1273d, aVar.f1272c);
        } else if (i5 == 8) {
            h0Var.f(aVar.f1271b, aVar.f1273d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + aVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:184:0x00aa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0138 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0124 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x00d8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0009 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j() {
        /*
            Method dump skipped, instructions count: 688
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.b.j():void");
    }

    public final void k(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            a aVar = (a) arrayList.get(i5);
            aVar.f1272c = null;
            this.f1290a.b(aVar);
        }
        arrayList.clear();
    }

    public final int l(int i5, int i6) {
        int i7;
        int i8;
        ArrayList arrayList = this.f1292c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            a aVar = (a) arrayList.get(size);
            int i9 = aVar.f1270a;
            if (i9 == 8) {
                int i10 = aVar.f1271b;
                int i11 = aVar.f1273d;
                if (i10 < i11) {
                    i8 = i10;
                    i7 = i11;
                } else {
                    i7 = i10;
                    i8 = i11;
                }
                if (i5 < i8 || i5 > i7) {
                    if (i5 < i10) {
                        if (i6 == 1) {
                            aVar.f1271b = i10 + 1;
                            aVar.f1273d = i11 + 1;
                        } else if (i6 == 2) {
                            aVar.f1271b = i10 - 1;
                            aVar.f1273d = i11 - 1;
                        }
                    }
                } else if (i8 == i10) {
                    if (i6 == 1) {
                        aVar.f1273d = i11 + 1;
                    } else if (i6 == 2) {
                        aVar.f1273d = i11 - 1;
                    }
                    i5++;
                } else {
                    if (i6 == 1) {
                        aVar.f1271b = i10 + 1;
                    } else if (i6 == 2) {
                        aVar.f1271b = i10 - 1;
                    }
                    i5--;
                }
            } else {
                int i12 = aVar.f1271b;
                if (i12 <= i5) {
                    if (i9 == 1) {
                        i5 -= aVar.f1273d;
                    } else if (i9 == 2) {
                        i5 += aVar.f1273d;
                    }
                } else if (i6 == 1) {
                    aVar.f1271b = i12 + 1;
                } else if (i6 == 2) {
                    aVar.f1271b = i12 - 1;
                }
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            a aVar2 = (a) arrayList.get(size2);
            int i13 = aVar2.f1270a;
            n.e eVar = this.f1290a;
            if (i13 == 8) {
                int i14 = aVar2.f1273d;
                if (i14 == aVar2.f1271b || i14 < 0) {
                    arrayList.remove(size2);
                    aVar2.f1272c = null;
                    eVar.b(aVar2);
                }
            } else if (aVar2.f1273d <= 0) {
                arrayList.remove(size2);
                aVar2.f1272c = null;
                eVar.b(aVar2);
            }
        }
        return i5;
    }
}

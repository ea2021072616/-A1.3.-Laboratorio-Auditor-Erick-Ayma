package androidx.recyclerview.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class k extends n0 {

    /* renamed from: s  reason: collision with root package name */
    public static TimeInterpolator f1401s;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f1402g = true;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList f1403h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList f1404i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public final ArrayList f1405j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public final ArrayList f1406k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    public final ArrayList f1407l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    public final ArrayList f1408m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    public final ArrayList f1409n = new ArrayList();
    public final ArrayList o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    public final ArrayList f1410p = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    public final ArrayList f1411q = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    public final ArrayList f1412r = new ArrayList();

    public static void h(ArrayList arrayList) {
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            }
            ((i1) arrayList.get(size)).f1376a.animate().cancel();
        }
    }

    @Override // androidx.recyclerview.widget.n0
    public final boolean a(i1 i1Var, i1 i1Var2, m0 m0Var, m0 m0Var2) {
        int i5;
        int i6;
        int i7 = m0Var.f1419a;
        int i8 = m0Var.f1420b;
        if (i1Var2.o()) {
            int i9 = m0Var.f1419a;
            i6 = m0Var.f1420b;
            i5 = i9;
        } else {
            i5 = m0Var2.f1419a;
            i6 = m0Var2.f1420b;
        }
        if (i1Var == i1Var2) {
            return g(i1Var, i7, i8, i5, i6);
        }
        View view = i1Var.f1376a;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        float alpha = view.getAlpha();
        l(i1Var);
        view.setTranslationX(translationX);
        view.setTranslationY(translationY);
        view.setAlpha(alpha);
        l(i1Var2);
        View view2 = i1Var2.f1376a;
        view2.setTranslationX(-((int) ((i5 - i7) - translationX)));
        view2.setTranslationY(-((int) ((i6 - i8) - translationY)));
        view2.setAlpha(0.0f);
        this.f1406k.add(new i(i1Var, i1Var2, i7, i8, i5, i6));
        return true;
    }

    @Override // androidx.recyclerview.widget.n0
    public final void d(i1 i1Var) {
        View view = i1Var.f1376a;
        view.animate().cancel();
        ArrayList arrayList = this.f1405j;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (((j) arrayList.get(size)).f1394a == i1Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                c(i1Var);
                arrayList.remove(size);
            }
        }
        j(i1Var, this.f1406k);
        if (this.f1403h.remove(i1Var)) {
            view.setAlpha(1.0f);
            c(i1Var);
        }
        if (this.f1404i.remove(i1Var)) {
            view.setAlpha(1.0f);
            c(i1Var);
        }
        ArrayList arrayList2 = this.f1409n;
        int size2 = arrayList2.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                break;
            }
            ArrayList arrayList3 = (ArrayList) arrayList2.get(size2);
            j(i1Var, arrayList3);
            if (arrayList3.isEmpty()) {
                arrayList2.remove(size2);
            }
        }
        ArrayList arrayList4 = this.f1408m;
        int size3 = arrayList4.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            ArrayList arrayList5 = (ArrayList) arrayList4.get(size3);
            int size4 = arrayList5.size();
            while (true) {
                size4--;
                if (size4 < 0) {
                    break;
                } else if (((j) arrayList5.get(size4)).f1394a == i1Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    c(i1Var);
                    arrayList5.remove(size4);
                    if (arrayList5.isEmpty()) {
                        arrayList4.remove(size3);
                    }
                }
            }
        }
        ArrayList arrayList6 = this.f1407l;
        int size5 = arrayList6.size();
        while (true) {
            size5--;
            if (size5 < 0) {
                this.f1411q.remove(i1Var);
                this.o.remove(i1Var);
                this.f1412r.remove(i1Var);
                this.f1410p.remove(i1Var);
                i();
                return;
            }
            ArrayList arrayList7 = (ArrayList) arrayList6.get(size5);
            if (arrayList7.remove(i1Var)) {
                view.setAlpha(1.0f);
                c(i1Var);
                if (arrayList7.isEmpty()) {
                    arrayList6.remove(size5);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.n0
    public final void e() {
        ArrayList arrayList = this.f1405j;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            j jVar = (j) arrayList.get(size);
            View view = jVar.f1394a.f1376a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            c(jVar.f1394a);
            arrayList.remove(size);
        }
        ArrayList arrayList2 = this.f1403h;
        int size2 = arrayList2.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                break;
            }
            c((i1) arrayList2.get(size2));
            arrayList2.remove(size2);
        }
        ArrayList arrayList3 = this.f1404i;
        int size3 = arrayList3.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            i1 i1Var = (i1) arrayList3.get(size3);
            i1Var.f1376a.setAlpha(1.0f);
            c(i1Var);
            arrayList3.remove(size3);
        }
        ArrayList arrayList4 = this.f1406k;
        int size4 = arrayList4.size();
        while (true) {
            size4--;
            if (size4 < 0) {
                break;
            }
            i iVar = (i) arrayList4.get(size4);
            i1 i1Var2 = iVar.f1366a;
            if (i1Var2 != null) {
                k(iVar, i1Var2);
            }
            i1 i1Var3 = iVar.f1367b;
            if (i1Var3 != null) {
                k(iVar, i1Var3);
            }
        }
        arrayList4.clear();
        if (f()) {
            ArrayList arrayList5 = this.f1408m;
            int size5 = arrayList5.size();
            while (true) {
                size5--;
                if (size5 < 0) {
                    break;
                }
                ArrayList arrayList6 = (ArrayList) arrayList5.get(size5);
                int size6 = arrayList6.size();
                while (true) {
                    size6--;
                    if (size6 >= 0) {
                        j jVar2 = (j) arrayList6.get(size6);
                        View view2 = jVar2.f1394a.f1376a;
                        view2.setTranslationY(0.0f);
                        view2.setTranslationX(0.0f);
                        c(jVar2.f1394a);
                        arrayList6.remove(size6);
                        if (arrayList6.isEmpty()) {
                            arrayList5.remove(arrayList6);
                        }
                    }
                }
            }
            ArrayList arrayList7 = this.f1407l;
            int size7 = arrayList7.size();
            while (true) {
                size7--;
                if (size7 < 0) {
                    break;
                }
                ArrayList arrayList8 = (ArrayList) arrayList7.get(size7);
                int size8 = arrayList8.size();
                while (true) {
                    size8--;
                    if (size8 >= 0) {
                        i1 i1Var4 = (i1) arrayList8.get(size8);
                        i1Var4.f1376a.setAlpha(1.0f);
                        c(i1Var4);
                        arrayList8.remove(size8);
                        if (arrayList8.isEmpty()) {
                            arrayList7.remove(arrayList8);
                        }
                    }
                }
            }
            ArrayList arrayList9 = this.f1409n;
            int size9 = arrayList9.size();
            while (true) {
                size9--;
                if (size9 < 0) {
                    break;
                }
                ArrayList arrayList10 = (ArrayList) arrayList9.get(size9);
                int size10 = arrayList10.size();
                while (true) {
                    size10--;
                    if (size10 >= 0) {
                        i iVar2 = (i) arrayList10.get(size10);
                        i1 i1Var5 = iVar2.f1366a;
                        if (i1Var5 != null) {
                            k(iVar2, i1Var5);
                        }
                        i1 i1Var6 = iVar2.f1367b;
                        if (i1Var6 != null) {
                            k(iVar2, i1Var6);
                        }
                        if (arrayList10.isEmpty()) {
                            arrayList9.remove(arrayList10);
                        }
                    }
                }
            }
            h(this.f1411q);
            h(this.f1410p);
            h(this.o);
            h(this.f1412r);
            ArrayList arrayList11 = this.f1432b;
            if (arrayList11.size() <= 0) {
                arrayList11.clear();
            } else {
                androidx.appcompat.widget.b0.n(arrayList11.get(0));
                throw null;
            }
        }
    }

    @Override // androidx.recyclerview.widget.n0
    public final boolean f() {
        return (this.f1404i.isEmpty() && this.f1406k.isEmpty() && this.f1405j.isEmpty() && this.f1403h.isEmpty() && this.f1410p.isEmpty() && this.f1411q.isEmpty() && this.o.isEmpty() && this.f1412r.isEmpty() && this.f1408m.isEmpty() && this.f1407l.isEmpty() && this.f1409n.isEmpty()) ? false : true;
    }

    public final boolean g(i1 i1Var, int i5, int i6, int i7, int i8) {
        View view = i1Var.f1376a;
        int translationX = i5 + ((int) view.getTranslationX());
        int translationY = i6 + ((int) i1Var.f1376a.getTranslationY());
        l(i1Var);
        int i9 = i7 - translationX;
        int i10 = i8 - translationY;
        if (i9 == 0 && i10 == 0) {
            c(i1Var);
            return false;
        }
        if (i9 != 0) {
            view.setTranslationX(-i9);
        }
        if (i10 != 0) {
            view.setTranslationY(-i10);
        }
        this.f1405j.add(new j(i1Var, translationX, translationY, i7, i8));
        return true;
    }

    public final void i() {
        if (f()) {
            return;
        }
        ArrayList arrayList = this.f1432b;
        if (arrayList.size() <= 0) {
            arrayList.clear();
        } else {
            androidx.appcompat.widget.b0.n(arrayList.get(0));
            throw null;
        }
    }

    public final void j(i1 i1Var, ArrayList arrayList) {
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            }
            i iVar = (i) arrayList.get(size);
            if (k(iVar, i1Var) && iVar.f1366a == null && iVar.f1367b == null) {
                arrayList.remove(iVar);
            }
        }
    }

    public final boolean k(i iVar, i1 i1Var) {
        if (iVar.f1367b == i1Var) {
            iVar.f1367b = null;
        } else if (iVar.f1366a != i1Var) {
            return false;
        } else {
            iVar.f1366a = null;
        }
        i1Var.f1376a.setAlpha(1.0f);
        View view = i1Var.f1376a;
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        c(i1Var);
        return true;
    }

    public final void l(i1 i1Var) {
        if (f1401s == null) {
            f1401s = new ValueAnimator().getInterpolator();
        }
        i1Var.f1376a.animate().setInterpolator(f1401s);
        d(i1Var);
    }
}

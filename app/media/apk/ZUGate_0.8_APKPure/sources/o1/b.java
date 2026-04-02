package o1;

import java.util.ArrayList;
import java.util.Iterator;
import m1.g;
import m1.h;
import t1.f;
/* loaded from: classes.dex */
public class b implements d {

    /* renamed from: a  reason: collision with root package name */
    public final p1.b f4092a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f4093b = new ArrayList();

    public b(k1.a aVar) {
        this.f4092a = aVar;
    }

    public static float d(ArrayList arrayList, float f5, int i5) {
        float f6 = Float.MAX_VALUE;
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            c cVar = (c) arrayList.get(i6);
            if (cVar.f4100g == i5) {
                float abs = Math.abs(cVar.f4097d - f5);
                if (abs < f6) {
                    f6 = abs;
                }
            }
        }
        return f6;
    }

    @Override // o1.d
    public c a(float f5, float f6) {
        float f7;
        m1.d dVar;
        int i5;
        int i6;
        p1.b bVar = this.f4092a;
        f f8 = ((k1.a) bVar).f(1);
        f8.getClass();
        t1.b b5 = t1.b.b(0.0d, 0.0d);
        f8.a(f5, f6, b5);
        float f9 = (float) b5.f4985b;
        t1.b.c(b5);
        ArrayList arrayList = this.f4093b;
        arrayList.clear();
        m1.d b6 = b();
        char c5 = 0;
        if (b6 != null) {
            int d5 = b6.d();
            int i7 = 0;
            while (i7 < d5) {
                g gVar = (g) b6.c(i7);
                if (gVar.f3948e) {
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList b7 = gVar.b(f9);
                    if (b7.size() == 0) {
                        int d6 = gVar.d(f9, Float.NaN, 3);
                        h hVar = d6 > -1 ? (h) gVar.o.get(d6) : null;
                        if (hVar != null) {
                            b7 = gVar.b(hVar.f3962d);
                        }
                    }
                    if (b7.size() != 0) {
                        Iterator it = b7.iterator();
                        while (it.hasNext()) {
                            h hVar2 = (h) it.next();
                            f f10 = ((k1.a) bVar).f(gVar.f3947d);
                            float f11 = hVar2.f3962d;
                            float a5 = hVar2.a();
                            float f12 = f9;
                            float[] fArr = f10.f5002e;
                            fArr[c5] = f11;
                            fArr[1] = a5;
                            f10.c(fArr);
                            int i8 = d5;
                            t1.b b8 = t1.b.b(fArr[c5], fArr[1]);
                            Iterator it2 = it;
                            ArrayList arrayList3 = arrayList2;
                            int i9 = i7;
                            arrayList3.add(new c(hVar2.f3962d, hVar2.a(), (float) b8.f4985b, (float) b8.f4986c, i9, gVar.f3947d));
                            arrayList2 = arrayList3;
                            gVar = gVar;
                            i7 = i9;
                            f9 = f12;
                            d5 = i8;
                            b6 = b6;
                            it = it2;
                            c5 = 0;
                        }
                    }
                    f7 = f9;
                    dVar = b6;
                    i5 = d5;
                    i6 = i7;
                    arrayList.addAll(arrayList2);
                } else {
                    f7 = f9;
                    dVar = b6;
                    i5 = d5;
                    i6 = i7;
                }
                i7 = i6 + 1;
                f9 = f7;
                d5 = i5;
                b6 = dVar;
                c5 = 0;
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        int i10 = d(arrayList, f6, 1) < d(arrayList, f6, 2) ? 1 : 2;
        float maxHighlightDistance = bVar.getMaxHighlightDistance();
        c cVar = null;
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            c cVar2 = (c) arrayList.get(i11);
            if (cVar2.f4100g == i10) {
                float c6 = c(f5, f6, cVar2.f4096c, cVar2.f4097d);
                if (c6 < maxHighlightDistance) {
                    cVar = cVar2;
                    maxHighlightDistance = c6;
                }
            }
        }
        return cVar;
    }

    public m1.d b() {
        return this.f4092a.getData();
    }

    public float c(float f5, float f6, float f7, float f8) {
        return (float) Math.hypot(f5 - f7, f6 - f8);
    }
}

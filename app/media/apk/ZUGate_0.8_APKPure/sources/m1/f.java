package m1;

import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    public float f3935a = -3.4028235E38f;

    /* renamed from: b  reason: collision with root package name */
    public float f3936b = Float.MAX_VALUE;

    /* renamed from: c  reason: collision with root package name */
    public float f3937c = -3.4028235E38f;

    /* renamed from: d  reason: collision with root package name */
    public float f3938d = Float.MAX_VALUE;

    /* renamed from: e  reason: collision with root package name */
    public float f3939e = -3.4028235E38f;

    /* renamed from: f  reason: collision with root package name */
    public float f3940f = Float.MAX_VALUE;

    /* renamed from: g  reason: collision with root package name */
    public float f3941g = -3.4028235E38f;

    /* renamed from: h  reason: collision with root package name */
    public float f3942h = Float.MAX_VALUE;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList f3943i = new ArrayList();

    public final void a() {
        Object obj;
        q1.b bVar;
        ArrayList arrayList = this.f3943i;
        if (arrayList == null) {
            return;
        }
        this.f3935a = -3.4028235E38f;
        this.f3936b = Float.MAX_VALUE;
        this.f3937c = -3.4028235E38f;
        this.f3938d = Float.MAX_VALUE;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            b((q1.b) it.next());
        }
        this.f3939e = -3.4028235E38f;
        this.f3940f = Float.MAX_VALUE;
        this.f3941g = -3.4028235E38f;
        this.f3942h = Float.MAX_VALUE;
        Iterator it2 = arrayList.iterator();
        while (true) {
            obj = null;
            if (!it2.hasNext()) {
                bVar = null;
                break;
            }
            bVar = (q1.b) it2.next();
            if (((g) bVar).f3947d == 1) {
                break;
            }
        }
        if (bVar != null) {
            g gVar = (g) bVar;
            this.f3939e = gVar.f3958p;
            this.f3940f = gVar.f3959q;
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                g gVar2 = (g) ((q1.b) it3.next());
                if (gVar2.f3947d == 1) {
                    float f5 = gVar2.f3959q;
                    if (f5 < this.f3940f) {
                        this.f3940f = f5;
                    }
                    float f6 = gVar2.f3958p;
                    if (f6 > this.f3939e) {
                        this.f3939e = f6;
                    }
                }
            }
        }
        Iterator it4 = arrayList.iterator();
        while (true) {
            if (!it4.hasNext()) {
                break;
            }
            Object obj2 = (q1.b) it4.next();
            if (((g) obj2).f3947d == 2) {
                obj = obj2;
                break;
            }
        }
        if (obj != null) {
            g gVar3 = (g) obj;
            this.f3941g = gVar3.f3958p;
            this.f3942h = gVar3.f3959q;
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                g gVar4 = (g) ((q1.b) it5.next());
                if (gVar4.f3947d == 2) {
                    float f7 = gVar4.f3959q;
                    if (f7 < this.f3942h) {
                        this.f3942h = f7;
                    }
                    float f8 = gVar4.f3958p;
                    if (f8 > this.f3941g) {
                        this.f3941g = f8;
                    }
                }
            }
        }
    }

    public final void b(q1.b bVar) {
        float f5 = this.f3935a;
        g gVar = (g) bVar;
        float f6 = gVar.f3958p;
        if (f5 < f6) {
            this.f3935a = f6;
        }
        float f7 = this.f3936b;
        float f8 = gVar.f3959q;
        if (f7 > f8) {
            this.f3936b = f8;
        }
        float f9 = this.f3937c;
        float f10 = gVar.f3960r;
        if (f9 < f10) {
            this.f3937c = f10;
        }
        float f11 = this.f3938d;
        float f12 = gVar.f3961s;
        if (f11 > f12) {
            this.f3938d = f12;
        }
        if (gVar.f3947d == 1) {
            if (this.f3939e < f6) {
                this.f3939e = f6;
            }
            if (this.f3940f > f8) {
                this.f3940f = f8;
                return;
            }
            return;
        }
        if (this.f3941g < f6) {
            this.f3941g = f6;
        }
        if (this.f3942h > f8) {
            this.f3942h = f8;
        }
    }

    public final q1.b c(int i5) {
        ArrayList arrayList = this.f3943i;
        if (arrayList == null || i5 < 0 || i5 >= arrayList.size()) {
            return null;
        }
        return (q1.b) arrayList.get(i5);
    }

    public final int d() {
        ArrayList arrayList = this.f3943i;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final int e() {
        Iterator it = this.f3943i.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            i5 += ((g) ((q1.b) it.next())).c();
        }
        return i5;
    }

    public final float f(int i5) {
        if (i5 == 1) {
            float f5 = this.f3939e;
            return f5 == -3.4028235E38f ? this.f3941g : f5;
        }
        float f6 = this.f3941g;
        return f6 == -3.4028235E38f ? this.f3939e : f6;
    }

    public final float g(int i5) {
        if (i5 == 1) {
            float f5 = this.f3940f;
            return f5 == Float.MAX_VALUE ? this.f3942h : f5;
        }
        float f6 = this.f3942h;
        return f6 == Float.MAX_VALUE ? this.f3940f : f6;
    }
}

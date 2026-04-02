package m1;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class g implements q1.b {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f3944a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f3945b;

    /* renamed from: c  reason: collision with root package name */
    public final String f3946c;

    /* renamed from: f  reason: collision with root package name */
    public transient n1.d f3949f;
    public final List o;

    /* renamed from: p  reason: collision with root package name */
    public float f3958p;

    /* renamed from: q  reason: collision with root package name */
    public float f3959q;

    /* renamed from: r  reason: collision with root package name */
    public float f3960r;

    /* renamed from: s  reason: collision with root package name */
    public float f3961s;

    /* renamed from: d  reason: collision with root package name */
    public final int f3947d = 1;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f3948e = true;

    /* renamed from: g  reason: collision with root package name */
    public final int f3950g = 3;

    /* renamed from: h  reason: collision with root package name */
    public final float f3951h = Float.NaN;

    /* renamed from: i  reason: collision with root package name */
    public final float f3952i = Float.NaN;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f3953j = true;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f3954k = true;

    /* renamed from: l  reason: collision with root package name */
    public final t1.c f3955l = new t1.c();

    /* renamed from: m  reason: collision with root package name */
    public final float f3956m = 17.0f;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f3957n = true;

    public g(String str, ArrayList arrayList) {
        this.f3944a = null;
        this.f3945b = null;
        this.f3946c = "DataSet";
        this.f3944a = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.f3945b = arrayList2;
        this.f3944a.add(Integer.valueOf(Color.rgb(140, 234, 255)));
        arrayList2.add(-16777216);
        this.f3946c = str;
        this.o = null;
        this.f3958p = -3.4028235E38f;
        this.f3959q = Float.MAX_VALUE;
        this.f3960r = -3.4028235E38f;
        this.f3961s = Float.MAX_VALUE;
        this.o = arrayList;
        if (arrayList == null) {
            this.o = new ArrayList();
        }
        a();
    }

    public final void a() {
        List<h> list = this.o;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f3958p = -3.4028235E38f;
        this.f3959q = Float.MAX_VALUE;
        this.f3960r = -3.4028235E38f;
        this.f3961s = Float.MAX_VALUE;
        for (h hVar : list) {
            b bVar = (b) this;
            c cVar = (c) hVar;
            if (cVar != null && !Float.isNaN(cVar.f3933b)) {
                float f5 = cVar.f3933b;
                if (f5 < bVar.f3959q) {
                    bVar.f3959q = f5;
                }
                if (f5 > bVar.f3958p) {
                    bVar.f3958p = f5;
                }
                float f6 = cVar.f3962d;
                if (f6 < bVar.f3961s) {
                    bVar.f3961s = f6;
                }
                if (f6 > bVar.f3960r) {
                    bVar.f3960r = f6;
                }
            }
        }
    }

    public final ArrayList b(float f5) {
        ArrayList arrayList = new ArrayList();
        List list = this.o;
        int size = list.size() - 1;
        int i5 = 0;
        while (true) {
            if (i5 > size) {
                break;
            }
            int i6 = (size + i5) / 2;
            int i7 = (f5 > ((h) list.get(i6)).f3962d ? 1 : (f5 == ((h) list.get(i6)).f3962d ? 0 : -1));
            if (i7 == 0) {
                while (i6 > 0) {
                    int i8 = i6 - 1;
                    if (((h) list.get(i8)).f3962d != f5) {
                        break;
                    }
                    i6 = i8;
                }
                int size2 = list.size();
                while (i6 < size2) {
                    h hVar = (h) list.get(i6);
                    if (hVar.f3962d != f5) {
                        break;
                    }
                    arrayList.add(hVar);
                    i6++;
                }
            } else if (i7 > 0) {
                i5 = i6 + 1;
            } else {
                size = i6 - 1;
            }
        }
        return arrayList;
    }

    public final int c() {
        return this.o.size();
    }

    public final int d(float f5, float f6, int i5) {
        h hVar;
        List list = this.o;
        if (list == null || list.isEmpty()) {
            return -1;
        }
        int size = list.size() - 1;
        int i6 = 0;
        while (i6 < size) {
            int i7 = (i6 + size) / 2;
            float f7 = ((h) list.get(i7)).f3962d - f5;
            int i8 = i7 + 1;
            float abs = Math.abs(f7);
            float abs2 = Math.abs(((h) list.get(i8)).f3962d - f5);
            if (abs2 >= abs) {
                if (abs >= abs2) {
                    double d5 = f7;
                    if (d5 < 0.0d) {
                        if (d5 < 0.0d) {
                        }
                    }
                }
                size = i7;
            }
            i6 = i8;
        }
        if (size != -1) {
            float f8 = ((h) list.get(size)).f3962d;
            if (i5 == 1) {
                if (f8 < f5 && size < list.size() - 1) {
                    size++;
                }
            } else if (i5 == 2 && f8 > f5 && size > 0) {
                size--;
            }
            if (Float.isNaN(f6)) {
                return size;
            }
            while (size > 0) {
                int i9 = size - 1;
                if (((h) list.get(i9)).f3962d != f8) {
                    break;
                }
                size = i9;
            }
            float a5 = ((h) list.get(size)).a();
            int i10 = size;
            loop2: while (true) {
                int i11 = i10;
                do {
                    i11++;
                    if (i11 >= list.size()) {
                        break loop2;
                    }
                    hVar = (h) list.get(i11);
                    if (hVar.f3962d != f8) {
                        break loop2;
                    }
                } while (Math.abs(hVar.a() - f6) >= Math.abs(a5 - f6));
                a5 = f6;
                i10 = i11;
            }
            return i10;
        }
        return size;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        StringBuilder sb = new StringBuilder("DataSet, label: ");
        String str = this.f3946c;
        if (str == null) {
            str = "";
        }
        sb.append(str);
        sb.append(", entries: ");
        List list = this.o;
        sb.append(list.size());
        sb.append("\n");
        stringBuffer2.append(sb.toString());
        stringBuffer.append(stringBuffer2.toString());
        for (int i5 = 0; i5 < list.size(); i5++) {
            stringBuffer.append(((h) list.get(i5)).toString() + " ");
        }
        return stringBuffer.toString();
    }
}

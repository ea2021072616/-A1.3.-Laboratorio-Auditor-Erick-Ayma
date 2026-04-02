package p;

import androidx.appcompat.widget.b0;
import com.google.android.gms.internal.play_billing.i0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e {
    public int A;
    public float B;
    public final int[] C;
    public float D;
    public boolean E;
    public boolean F;
    public int G;
    public int H;
    public final d I;
    public final d J;
    public final d K;
    public final d L;
    public final d M;
    public final d N;
    public final d O;
    public final d P;
    public final d[] Q;
    public final ArrayList R;
    public final boolean[] S;
    public e T;
    public int U;
    public int V;
    public float W;
    public int X;
    public int Y;
    public int Z;

    /* renamed from: a0  reason: collision with root package name */
    public int f4159a0;

    /* renamed from: b  reason: collision with root package name */
    public q.c f4160b;

    /* renamed from: b0  reason: collision with root package name */
    public int f4161b0;

    /* renamed from: c  reason: collision with root package name */
    public q.c f4162c;

    /* renamed from: c0  reason: collision with root package name */
    public int f4163c0;

    /* renamed from: d0  reason: collision with root package name */
    public float f4165d0;

    /* renamed from: e0  reason: collision with root package name */
    public float f4167e0;

    /* renamed from: f0  reason: collision with root package name */
    public Object f4169f0;

    /* renamed from: g0  reason: collision with root package name */
    public int f4171g0;

    /* renamed from: h0  reason: collision with root package name */
    public String f4173h0;

    /* renamed from: i0  reason: collision with root package name */
    public int f4175i0;

    /* renamed from: j  reason: collision with root package name */
    public String f4176j;

    /* renamed from: j0  reason: collision with root package name */
    public int f4177j0;

    /* renamed from: k  reason: collision with root package name */
    public boolean f4178k;

    /* renamed from: k0  reason: collision with root package name */
    public final float[] f4179k0;

    /* renamed from: l  reason: collision with root package name */
    public boolean f4180l;

    /* renamed from: l0  reason: collision with root package name */
    public final e[] f4181l0;

    /* renamed from: m  reason: collision with root package name */
    public boolean f4182m;

    /* renamed from: m0  reason: collision with root package name */
    public final e[] f4183m0;

    /* renamed from: n  reason: collision with root package name */
    public boolean f4184n;

    /* renamed from: n0  reason: collision with root package name */
    public int f4185n0;
    public int o;

    /* renamed from: o0  reason: collision with root package name */
    public int f4186o0;

    /* renamed from: p  reason: collision with root package name */
    public int f4187p;

    /* renamed from: p0  reason: collision with root package name */
    public final int[] f4188p0;

    /* renamed from: q  reason: collision with root package name */
    public int f4189q;

    /* renamed from: r  reason: collision with root package name */
    public int f4190r;

    /* renamed from: s  reason: collision with root package name */
    public int f4191s;

    /* renamed from: t  reason: collision with root package name */
    public final int[] f4192t;

    /* renamed from: u  reason: collision with root package name */
    public int f4193u;

    /* renamed from: v  reason: collision with root package name */
    public int f4194v;

    /* renamed from: w  reason: collision with root package name */
    public float f4195w;

    /* renamed from: x  reason: collision with root package name */
    public int f4196x;

    /* renamed from: y  reason: collision with root package name */
    public int f4197y;

    /* renamed from: z  reason: collision with root package name */
    public float f4198z;

    /* renamed from: a  reason: collision with root package name */
    public boolean f4158a = false;

    /* renamed from: d  reason: collision with root package name */
    public q.j f4164d = null;

    /* renamed from: e  reason: collision with root package name */
    public q.l f4166e = null;

    /* renamed from: f  reason: collision with root package name */
    public final boolean[] f4168f = {true, true};

    /* renamed from: g  reason: collision with root package name */
    public boolean f4170g = true;

    /* renamed from: h  reason: collision with root package name */
    public int f4172h = -1;

    /* renamed from: i  reason: collision with root package name */
    public int f4174i = -1;

    public e() {
        new HashMap();
        this.f4178k = false;
        this.f4180l = false;
        this.f4182m = false;
        this.f4184n = false;
        this.o = -1;
        this.f4187p = -1;
        this.f4189q = 0;
        this.f4190r = 0;
        this.f4191s = 0;
        this.f4192t = new int[2];
        this.f4193u = 0;
        this.f4194v = 0;
        this.f4195w = 1.0f;
        this.f4196x = 0;
        this.f4197y = 0;
        this.f4198z = 1.0f;
        this.A = -1;
        this.B = 1.0f;
        this.C = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.D = 0.0f;
        this.E = false;
        this.F = false;
        this.G = 0;
        this.H = 0;
        d dVar = new d(this, c.LEFT);
        this.I = dVar;
        d dVar2 = new d(this, c.TOP);
        this.J = dVar2;
        d dVar3 = new d(this, c.RIGHT);
        this.K = dVar3;
        d dVar4 = new d(this, c.BOTTOM);
        this.L = dVar4;
        d dVar5 = new d(this, c.BASELINE);
        this.M = dVar5;
        d dVar6 = new d(this, c.CENTER_X);
        this.N = dVar6;
        d dVar7 = new d(this, c.CENTER_Y);
        this.O = dVar7;
        d dVar8 = new d(this, c.CENTER);
        this.P = dVar8;
        this.Q = new d[]{dVar, dVar3, dVar2, dVar4, dVar5, dVar8};
        ArrayList arrayList = new ArrayList();
        this.R = arrayList;
        this.S = new boolean[2];
        this.f4188p0 = new int[]{1, 1};
        this.T = null;
        this.U = 0;
        this.V = 0;
        this.W = 0.0f;
        this.X = -1;
        this.Y = 0;
        this.Z = 0;
        this.f4159a0 = 0;
        this.f4165d0 = 0.5f;
        this.f4167e0 = 0.5f;
        this.f4171g0 = 0;
        this.f4173h0 = null;
        this.f4175i0 = 0;
        this.f4177j0 = 0;
        this.f4179k0 = new float[]{-1.0f, -1.0f};
        this.f4181l0 = new e[]{null, null};
        this.f4183m0 = new e[]{null, null};
        this.f4185n0 = -1;
        this.f4186o0 = -1;
        arrayList.add(dVar);
        arrayList.add(dVar2);
        arrayList.add(dVar3);
        arrayList.add(dVar4);
        arrayList.add(dVar6);
        arrayList.add(dVar7);
        arrayList.add(dVar8);
        arrayList.add(dVar5);
    }

    public static void H(int i5, int i6, String str, StringBuilder sb) {
        if (i5 == i6) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(i5);
        sb.append(",\n");
    }

    public static void I(StringBuilder sb, String str, float f5, float f6) {
        if (f5 == f6) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(f5);
        sb.append(",\n");
    }

    public static void p(StringBuilder sb, String str, int i5, int i6, int i7, int i8, int i9, float f5) {
        sb.append(str);
        sb.append(" :  {\n");
        H(i5, 0, "      size", sb);
        H(i6, 0, "      min", sb);
        H(i7, Integer.MAX_VALUE, "      max", sb);
        H(i8, 0, "      matchMin", sb);
        H(i9, 0, "      matchDef", sb);
        I(sb, "      matchPercent", f5, 1.0f);
        sb.append("    },\n");
    }

    public static void q(StringBuilder sb, String str, d dVar) {
        if (dVar.f4154f == null) {
            return;
        }
        sb.append("    ");
        sb.append(str);
        sb.append(" : [ '");
        sb.append(dVar.f4154f);
        sb.append("'");
        if (dVar.f4156h != Integer.MIN_VALUE || dVar.f4155g != 0) {
            sb.append(",");
            sb.append(dVar.f4155g);
            if (dVar.f4156h != Integer.MIN_VALUE) {
                sb.append(",");
                sb.append(dVar.f4156h);
                sb.append(",");
            }
        }
        sb.append(" ] ,\n");
    }

    public final boolean A() {
        return this.f4170g && this.f4171g0 != 8;
    }

    public boolean B() {
        return this.f4178k || (this.I.f4151c && this.K.f4151c);
    }

    public boolean C() {
        return this.f4180l || (this.J.f4151c && this.L.f4151c);
    }

    public void D() {
        this.I.j();
        this.J.j();
        this.K.j();
        this.L.j();
        this.M.j();
        this.N.j();
        this.O.j();
        this.P.j();
        this.T = null;
        this.D = 0.0f;
        this.U = 0;
        this.V = 0;
        this.W = 0.0f;
        this.X = -1;
        this.Y = 0;
        this.Z = 0;
        this.f4159a0 = 0;
        this.f4161b0 = 0;
        this.f4163c0 = 0;
        this.f4165d0 = 0.5f;
        this.f4167e0 = 0.5f;
        int[] iArr = this.f4188p0;
        iArr[0] = 1;
        iArr[1] = 1;
        this.f4169f0 = null;
        this.f4171g0 = 0;
        this.f4175i0 = 0;
        this.f4177j0 = 0;
        float[] fArr = this.f4179k0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.o = -1;
        this.f4187p = -1;
        int[] iArr2 = this.C;
        iArr2[0] = Integer.MAX_VALUE;
        iArr2[1] = Integer.MAX_VALUE;
        this.f4190r = 0;
        this.f4191s = 0;
        this.f4195w = 1.0f;
        this.f4198z = 1.0f;
        this.f4194v = Integer.MAX_VALUE;
        this.f4197y = Integer.MAX_VALUE;
        this.f4193u = 0;
        this.f4196x = 0;
        this.A = -1;
        this.B = 1.0f;
        boolean[] zArr = this.f4168f;
        zArr[0] = true;
        zArr[1] = true;
        this.F = false;
        boolean[] zArr2 = this.S;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f4170g = true;
        int[] iArr3 = this.f4192t;
        iArr3[0] = 0;
        iArr3[1] = 0;
        this.f4172h = -1;
        this.f4174i = -1;
    }

    public final void E() {
        e eVar = this.T;
        if (eVar != null && (eVar instanceof f)) {
            ((f) eVar).getClass();
        }
        ArrayList arrayList = this.R;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((d) arrayList.get(i5)).j();
        }
    }

    public final void F() {
        this.f4178k = false;
        this.f4180l = false;
        this.f4182m = false;
        this.f4184n = false;
        ArrayList arrayList = this.R;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            d dVar = (d) arrayList.get(i5);
            dVar.f4151c = false;
            dVar.f4150b = 0;
        }
    }

    public void G(g.f fVar) {
        this.I.k();
        this.J.k();
        this.K.k();
        this.L.k();
        this.M.k();
        this.P.k();
        this.N.k();
        this.O.k();
    }

    public final void J(int i5, int i6) {
        if (this.f4178k) {
            return;
        }
        this.I.l(i5);
        this.K.l(i6);
        this.Y = i5;
        this.U = i6 - i5;
        this.f4178k = true;
    }

    public final void K(int i5, int i6) {
        if (this.f4180l) {
            return;
        }
        this.J.l(i5);
        this.L.l(i6);
        this.Z = i5;
        this.V = i6 - i5;
        if (this.E) {
            this.M.l(i5 + this.f4159a0);
        }
        this.f4180l = true;
    }

    public final void L(int i5) {
        this.V = i5;
        int i6 = this.f4163c0;
        if (i5 < i6) {
            this.V = i6;
        }
    }

    public final void M(int i5) {
        this.f4188p0[0] = i5;
    }

    public final void N(int i5) {
        this.f4188p0[1] = i5;
    }

    public final void O(int i5) {
        this.U = i5;
        int i6 = this.f4161b0;
        if (i5 < i6) {
            this.U = i6;
        }
    }

    public void P(boolean z4, boolean z5) {
        int i5;
        int i6;
        q.j jVar = this.f4164d;
        boolean z6 = z4 & jVar.f4423g;
        q.l lVar = this.f4166e;
        boolean z7 = z5 & lVar.f4423g;
        int i7 = jVar.f4424h.f4391g;
        int i8 = lVar.f4424h.f4391g;
        int i9 = jVar.f4425i.f4391g;
        int i10 = lVar.f4425i.f4391g;
        int i11 = i10 - i8;
        if (i9 - i7 < 0 || i11 < 0 || i7 == Integer.MIN_VALUE || i7 == Integer.MAX_VALUE || i8 == Integer.MIN_VALUE || i8 == Integer.MAX_VALUE || i9 == Integer.MIN_VALUE || i9 == Integer.MAX_VALUE || i10 == Integer.MIN_VALUE || i10 == Integer.MAX_VALUE) {
            i9 = 0;
            i10 = 0;
            i7 = 0;
            i8 = 0;
        }
        int i12 = i9 - i7;
        int i13 = i10 - i8;
        if (z6) {
            this.Y = i7;
        }
        if (z7) {
            this.Z = i8;
        }
        if (this.f4171g0 == 8) {
            this.U = 0;
            this.V = 0;
            return;
        }
        int[] iArr = this.f4188p0;
        if (z6) {
            if (iArr[0] == 1 && i12 < (i6 = this.U)) {
                i12 = i6;
            }
            this.U = i12;
            int i14 = this.f4161b0;
            if (i12 < i14) {
                this.U = i14;
            }
        }
        if (z7) {
            if (iArr[1] == 1 && i13 < (i5 = this.V)) {
                i13 = i5;
            }
            this.V = i13;
            int i15 = this.f4163c0;
            if (i13 < i15) {
                this.V = i15;
            }
        }
    }

    public void Q(n.d dVar, boolean z4) {
        int i5;
        int i6;
        q.l lVar;
        q.j jVar;
        dVar.getClass();
        int n5 = n.d.n(this.I);
        int n6 = n.d.n(this.J);
        int n7 = n.d.n(this.K);
        int n8 = n.d.n(this.L);
        if (z4 && (jVar = this.f4164d) != null) {
            q.f fVar = jVar.f4424h;
            if (fVar.f4394j) {
                q.f fVar2 = jVar.f4425i;
                if (fVar2.f4394j) {
                    n5 = fVar.f4391g;
                    n7 = fVar2.f4391g;
                }
            }
        }
        if (z4 && (lVar = this.f4166e) != null) {
            q.f fVar3 = lVar.f4424h;
            if (fVar3.f4394j) {
                q.f fVar4 = lVar.f4425i;
                if (fVar4.f4394j) {
                    n6 = fVar3.f4391g;
                    n8 = fVar4.f4391g;
                }
            }
        }
        int i7 = n8 - n6;
        if (n7 - n5 < 0 || i7 < 0 || n5 == Integer.MIN_VALUE || n5 == Integer.MAX_VALUE || n6 == Integer.MIN_VALUE || n6 == Integer.MAX_VALUE || n7 == Integer.MIN_VALUE || n7 == Integer.MAX_VALUE || n8 == Integer.MIN_VALUE || n8 == Integer.MAX_VALUE) {
            n5 = 0;
            n6 = 0;
            n7 = 0;
            n8 = 0;
        }
        int i8 = n7 - n5;
        int i9 = n8 - n6;
        this.Y = n5;
        this.Z = n6;
        if (this.f4171g0 == 8) {
            this.U = 0;
            this.V = 0;
            return;
        }
        int[] iArr = this.f4188p0;
        int i10 = iArr[0];
        if (i10 == 1 && i8 < (i6 = this.U)) {
            i8 = i6;
        }
        if (iArr[1] == 1 && i9 < (i5 = this.V)) {
            i9 = i5;
        }
        this.U = i8;
        this.V = i9;
        int i11 = this.f4163c0;
        if (i9 < i11) {
            this.V = i11;
        }
        int i12 = this.f4161b0;
        if (i8 < i12) {
            this.U = i12;
        }
        int i13 = this.f4194v;
        if (i13 > 0 && i10 == 3) {
            this.U = Math.min(this.U, i13);
        }
        int i14 = this.f4197y;
        if (i14 > 0 && iArr[1] == 3) {
            this.V = Math.min(this.V, i14);
        }
        int i15 = this.U;
        if (i8 != i15) {
            this.f4172h = i15;
        }
        int i16 = this.V;
        if (i9 != i16) {
            this.f4174i = i16;
        }
    }

    public final void b(f fVar, n.d dVar, HashSet hashSet, int i5, boolean z4) {
        if (z4) {
            if (!hashSet.contains(this)) {
                return;
            }
            i0.h(fVar, dVar, this);
            hashSet.remove(this);
            c(dVar, fVar.W(64));
        }
        if (i5 == 0) {
            HashSet hashSet2 = this.I.f4149a;
            if (hashSet2 != null) {
                Iterator it = hashSet2.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).f4152d.b(fVar, dVar, hashSet, i5, true);
                }
            }
            HashSet hashSet3 = this.K.f4149a;
            if (hashSet3 != null) {
                Iterator it2 = hashSet3.iterator();
                while (it2.hasNext()) {
                    ((d) it2.next()).f4152d.b(fVar, dVar, hashSet, i5, true);
                }
                return;
            }
            return;
        }
        HashSet hashSet4 = this.J.f4149a;
        if (hashSet4 != null) {
            Iterator it3 = hashSet4.iterator();
            while (it3.hasNext()) {
                ((d) it3.next()).f4152d.b(fVar, dVar, hashSet, i5, true);
            }
        }
        HashSet hashSet5 = this.L.f4149a;
        if (hashSet5 != null) {
            Iterator it4 = hashSet5.iterator();
            while (it4.hasNext()) {
                ((d) it4.next()).f4152d.b(fVar, dVar, hashSet, i5, true);
            }
        }
        HashSet hashSet6 = this.M.f4149a;
        if (hashSet6 != null) {
            Iterator it5 = hashSet6.iterator();
            while (it5.hasNext()) {
                ((d) it5.next()).f4152d.b(fVar, dVar, hashSet, i5, true);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0457  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x04a1  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x04b2  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x04ca  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x04e7  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x04ea  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x0566  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x05c8  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x05dc  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x05de  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x05e1  */
    /* JADX WARN: Removed duplicated region for block: B:395:0x0663  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x0666  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x06ac  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x070b  */
    /* JADX WARN: Removed duplicated region for block: B:407:0x0715  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(n.d r62, boolean r63) {
        /*
            Method dump skipped, instructions count: 2001
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p.e.c(n.d, boolean):void");
    }

    public boolean d() {
        return this.f4171g0 != 8;
    }

    /* JADX WARN: Removed duplicated region for block: B:225:0x0373 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0425 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0490  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x04a3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:327:0x04cc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:365:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(n.d r29, boolean r30, boolean r31, boolean r32, boolean r33, n.i r34, n.i r35, int r36, boolean r37, p.d r38, p.d r39, int r40, int r41, int r42, int r43, float r44, boolean r45, boolean r46, boolean r47, boolean r48, boolean r49, int r50, int r51, int r52, int r53, float r54, boolean r55) {
        /*
            Method dump skipped, instructions count: 1327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p.e.e(n.d, boolean, boolean, boolean, boolean, n.i, n.i, int, boolean, p.d, p.d, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public final void f(c cVar, e eVar, c cVar2, int i5) {
        boolean z4;
        c cVar3 = c.CENTER;
        c cVar4 = c.CENTER_Y;
        c cVar5 = c.CENTER_X;
        c cVar6 = c.LEFT;
        c cVar7 = c.TOP;
        c cVar8 = c.RIGHT;
        c cVar9 = c.BOTTOM;
        if (cVar == cVar3) {
            if (cVar2 != cVar3) {
                if (cVar2 == cVar6 || cVar2 == cVar8) {
                    f(cVar6, eVar, cVar2, 0);
                    f(cVar8, eVar, cVar2, 0);
                    j(cVar3).a(eVar.j(cVar2), 0);
                    return;
                } else if (cVar2 == cVar7 || cVar2 == cVar9) {
                    f(cVar7, eVar, cVar2, 0);
                    f(cVar9, eVar, cVar2, 0);
                    j(cVar3).a(eVar.j(cVar2), 0);
                    return;
                } else {
                    return;
                }
            }
            d j5 = j(cVar6);
            d j6 = j(cVar8);
            d j7 = j(cVar7);
            d j8 = j(cVar9);
            boolean z5 = true;
            if ((j5 == null || !j5.h()) && (j6 == null || !j6.h())) {
                f(cVar6, eVar, cVar6, 0);
                f(cVar8, eVar, cVar8, 0);
                z4 = true;
            } else {
                z4 = false;
            }
            if ((j7 == null || !j7.h()) && (j8 == null || !j8.h())) {
                f(cVar7, eVar, cVar7, 0);
                f(cVar9, eVar, cVar9, 0);
            } else {
                z5 = false;
            }
            if (z4 && z5) {
                j(cVar3).a(eVar.j(cVar3), 0);
            } else if (z4) {
                j(cVar5).a(eVar.j(cVar5), 0);
            } else if (z5) {
                j(cVar4).a(eVar.j(cVar4), 0);
            }
        } else if (cVar == cVar5 && (cVar2 == cVar6 || cVar2 == cVar8)) {
            d j9 = j(cVar6);
            d j10 = eVar.j(cVar2);
            d j11 = j(cVar8);
            j9.a(j10, 0);
            j11.a(j10, 0);
            j(cVar5).a(j10, 0);
        } else if (cVar == cVar4 && (cVar2 == cVar7 || cVar2 == cVar9)) {
            d j12 = eVar.j(cVar2);
            j(cVar7).a(j12, 0);
            j(cVar9).a(j12, 0);
            j(cVar4).a(j12, 0);
        } else if (cVar == cVar5 && cVar2 == cVar5) {
            j(cVar6).a(eVar.j(cVar6), 0);
            j(cVar8).a(eVar.j(cVar8), 0);
            j(cVar5).a(eVar.j(cVar2), 0);
        } else if (cVar == cVar4 && cVar2 == cVar4) {
            j(cVar7).a(eVar.j(cVar7), 0);
            j(cVar9).a(eVar.j(cVar9), 0);
            j(cVar4).a(eVar.j(cVar2), 0);
        } else {
            d j13 = j(cVar);
            d j14 = eVar.j(cVar2);
            if (j13.i(j14)) {
                c cVar10 = c.BASELINE;
                if (cVar == cVar10) {
                    d j15 = j(cVar7);
                    d j16 = j(cVar9);
                    if (j15 != null) {
                        j15.j();
                    }
                    if (j16 != null) {
                        j16.j();
                    }
                } else if (cVar == cVar7 || cVar == cVar9) {
                    d j17 = j(cVar10);
                    if (j17 != null) {
                        j17.j();
                    }
                    d j18 = j(cVar3);
                    if (j18.f4154f != j14) {
                        j18.j();
                    }
                    d f5 = j(cVar).f();
                    d j19 = j(cVar4);
                    if (j19.h()) {
                        f5.j();
                        j19.j();
                    }
                } else if (cVar == cVar6 || cVar == cVar8) {
                    d j20 = j(cVar3);
                    if (j20.f4154f != j14) {
                        j20.j();
                    }
                    d f6 = j(cVar).f();
                    d j21 = j(cVar5);
                    if (j21.h()) {
                        f6.j();
                        j21.j();
                    }
                }
                j13.a(j14, i5);
            }
        }
    }

    public final void g(d dVar, d dVar2, int i5) {
        if (dVar.f4152d == this) {
            f(dVar.f4153e, dVar2.f4152d, dVar2.f4153e, i5);
        }
    }

    public final void h(n.d dVar) {
        dVar.k(this.I);
        dVar.k(this.J);
        dVar.k(this.K);
        dVar.k(this.L);
        if (this.f4159a0 > 0) {
            dVar.k(this.M);
        }
    }

    public final void i() {
        if (this.f4164d == null) {
            this.f4164d = new q.j(this);
        }
        if (this.f4166e == null) {
            this.f4166e = new q.l(this);
        }
    }

    public d j(c cVar) {
        switch (cVar.ordinal()) {
            case 0:
                return null;
            case 1:
                return this.I;
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                return this.J;
            case 3:
                return this.K;
            case 4:
                return this.L;
            case 5:
                return this.M;
            case 6:
                return this.P;
            case 7:
                return this.N;
            case 8:
                return this.O;
            default:
                throw new AssertionError(cVar.name());
        }
    }

    public final int k(int i5) {
        int[] iArr = this.f4188p0;
        if (i5 == 0) {
            return iArr[0];
        }
        if (i5 == 1) {
            return iArr[1];
        }
        return 0;
    }

    public final int l() {
        if (this.f4171g0 == 8) {
            return 0;
        }
        return this.V;
    }

    public final e m(int i5) {
        d dVar;
        d dVar2;
        if (i5 != 0) {
            if (i5 == 1 && (dVar2 = (dVar = this.L).f4154f) != null && dVar2.f4154f == dVar) {
                return dVar2.f4152d;
            }
            return null;
        }
        d dVar3 = this.K;
        d dVar4 = dVar3.f4154f;
        if (dVar4 == null || dVar4.f4154f != dVar3) {
            return null;
        }
        return dVar4.f4152d;
    }

    public final e n(int i5) {
        d dVar;
        d dVar2;
        if (i5 != 0) {
            if (i5 == 1 && (dVar2 = (dVar = this.J).f4154f) != null && dVar2.f4154f == dVar) {
                return dVar2.f4152d;
            }
            return null;
        }
        d dVar3 = this.I;
        d dVar4 = dVar3.f4154f;
        if (dVar4 == null || dVar4.f4154f != dVar3) {
            return null;
        }
        return dVar4.f4152d;
    }

    public void o(StringBuilder sb) {
        sb.append("  " + this.f4176j + ":{\n");
        StringBuilder sb2 = new StringBuilder("    actualWidth:");
        sb2.append(this.U);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("    actualHeight:" + this.V);
        sb.append("\n");
        sb.append("    actualLeft:" + this.Y);
        sb.append("\n");
        sb.append("    actualTop:" + this.Z);
        sb.append("\n");
        q(sb, "left", this.I);
        q(sb, "top", this.J);
        q(sb, "right", this.K);
        q(sb, "bottom", this.L);
        q(sb, "baseline", this.M);
        q(sb, "centerX", this.N);
        q(sb, "centerY", this.O);
        int i5 = this.U;
        int i6 = this.f4161b0;
        int[] iArr = this.C;
        int i7 = iArr[0];
        int i8 = this.f4193u;
        int i9 = this.f4190r;
        float f5 = this.f4195w;
        float[] fArr = this.f4179k0;
        float f6 = fArr[0];
        p(sb, "    width", i5, i6, i7, i8, i9, f5);
        int i10 = this.V;
        int i11 = this.f4163c0;
        int i12 = iArr[1];
        int i13 = this.f4196x;
        int i14 = this.f4191s;
        float f7 = this.f4198z;
        float f8 = fArr[1];
        p(sb, "    height", i10, i11, i12, i13, i14, f7);
        float f9 = this.W;
        int i15 = this.X;
        if (f9 != 0.0f) {
            sb.append("    dimensionRatio");
            sb.append(" :  [");
            sb.append(f9);
            sb.append(",");
            sb.append(i15);
            sb.append("");
            sb.append("],\n");
        }
        I(sb, "    horizontalBias", this.f4165d0, 0.5f);
        I(sb, "    verticalBias", this.f4167e0, 0.5f);
        H(this.f4175i0, 0, "    horizontalChainStyle", sb);
        H(this.f4177j0, 0, "    verticalChainStyle", sb);
        sb.append("  }");
    }

    public final int r() {
        if (this.f4171g0 == 8) {
            return 0;
        }
        return this.U;
    }

    public final int s() {
        e eVar = this.T;
        return (eVar == null || !(eVar instanceof f)) ? this.Y : ((f) eVar).f4205x0 + this.Y;
    }

    public final int t() {
        e eVar = this.T;
        return (eVar == null || !(eVar instanceof f)) ? this.Z : ((f) eVar).f4206y0 + this.Z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(this.f4173h0 != null ? b0.i(new StringBuilder("id: "), this.f4173h0, " ") : "");
        sb.append("(");
        sb.append(this.Y);
        sb.append(", ");
        sb.append(this.Z);
        sb.append(") - (");
        sb.append(this.U);
        sb.append(" x ");
        sb.append(this.V);
        sb.append(")");
        return sb.toString();
    }

    public final boolean u(int i5) {
        if (i5 == 0) {
            return (this.I.f4154f != null ? 1 : 0) + (this.K.f4154f != null ? 1 : 0) < 2;
        }
        return ((this.J.f4154f != null ? 1 : 0) + (this.L.f4154f != null ? 1 : 0)) + (this.M.f4154f != null ? 1 : 0) < 2;
    }

    public final boolean v(int i5, int i6) {
        d dVar;
        d dVar2;
        d dVar3;
        d dVar4;
        if (i5 == 0) {
            d dVar5 = this.I;
            d dVar6 = dVar5.f4154f;
            if (dVar6 != null && dVar6.f4151c && (dVar4 = (dVar3 = this.K).f4154f) != null && dVar4.f4151c) {
                return (dVar4.d() - dVar3.e()) - (dVar5.e() + dVar5.f4154f.d()) >= i6;
            }
        } else {
            d dVar7 = this.J;
            d dVar8 = dVar7.f4154f;
            if (dVar8 != null && dVar8.f4151c && (dVar2 = (dVar = this.L).f4154f) != null && dVar2.f4151c) {
                return (dVar2.d() - dVar.e()) - (dVar7.e() + dVar7.f4154f.d()) >= i6;
            }
        }
        return false;
    }

    public final void w(c cVar, e eVar, c cVar2, int i5, int i6) {
        j(cVar).b(eVar.j(cVar2), i5, i6, true);
    }

    public final boolean x(int i5) {
        d dVar;
        d dVar2;
        int i6 = i5 * 2;
        d[] dVarArr = this.Q;
        d dVar3 = dVarArr[i6];
        d dVar4 = dVar3.f4154f;
        return (dVar4 == null || dVar4.f4154f == dVar3 || (dVar2 = (dVar = dVarArr[i6 + 1]).f4154f) == null || dVar2.f4154f != dVar) ? false : true;
    }

    public final boolean y() {
        d dVar = this.I;
        d dVar2 = dVar.f4154f;
        if (dVar2 == null || dVar2.f4154f != dVar) {
            d dVar3 = this.K;
            d dVar4 = dVar3.f4154f;
            return dVar4 != null && dVar4.f4154f == dVar3;
        }
        return true;
    }

    public final boolean z() {
        d dVar = this.J;
        d dVar2 = dVar.f4154f;
        if (dVar2 == null || dVar2.f4154f != dVar) {
            d dVar3 = this.L;
            d dVar4 = dVar3.f4154f;
            return dVar4 != null && dVar4.f4154f == dVar3;
        }
        return true;
    }
}

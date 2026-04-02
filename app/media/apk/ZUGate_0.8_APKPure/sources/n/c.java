package n;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {

    /* renamed from: d  reason: collision with root package name */
    public b f4006d;

    /* renamed from: a  reason: collision with root package name */
    public i f4003a = null;

    /* renamed from: b  reason: collision with root package name */
    public float f4004b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f4005c = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public boolean f4007e = false;

    public c(g.f fVar) {
        this.f4006d = new a(this, fVar);
    }

    public final void a(d dVar, int i5) {
        this.f4006d.g(dVar.j(i5), 1.0f);
        this.f4006d.g(dVar.j(i5), -1.0f);
    }

    public final void b(i iVar, i iVar2, i iVar3, int i5) {
        boolean z4 = false;
        if (i5 != 0) {
            if (i5 < 0) {
                i5 *= -1;
                z4 = true;
            }
            this.f4004b = i5;
        }
        if (z4) {
            this.f4006d.g(iVar, 1.0f);
            this.f4006d.g(iVar2, -1.0f);
            this.f4006d.g(iVar3, -1.0f);
            return;
        }
        this.f4006d.g(iVar, -1.0f);
        this.f4006d.g(iVar2, 1.0f);
        this.f4006d.g(iVar3, 1.0f);
    }

    public final void c(i iVar, i iVar2, i iVar3, int i5) {
        boolean z4 = false;
        if (i5 != 0) {
            if (i5 < 0) {
                i5 *= -1;
                z4 = true;
            }
            this.f4004b = i5;
        }
        if (z4) {
            this.f4006d.g(iVar, 1.0f);
            this.f4006d.g(iVar2, -1.0f);
            this.f4006d.g(iVar3, 1.0f);
            return;
        }
        this.f4006d.g(iVar, -1.0f);
        this.f4006d.g(iVar2, 1.0f);
        this.f4006d.g(iVar3, -1.0f);
    }

    public i d(boolean[] zArr) {
        return f(zArr, null);
    }

    public boolean e() {
        return this.f4003a == null && this.f4004b == 0.0f && this.f4006d.k() == 0;
    }

    public final i f(boolean[] zArr, i iVar) {
        int i5;
        int k5 = this.f4006d.k();
        i iVar2 = null;
        float f5 = 0.0f;
        for (int i6 = 0; i6 < k5; i6++) {
            float a5 = this.f4006d.a(i6);
            if (a5 < 0.0f) {
                i f6 = this.f4006d.f(i6);
                if ((zArr == null || !zArr[f6.f4034c]) && f6 != iVar && (((i5 = f6.f4044m) == 3 || i5 == 4) && a5 < f5)) {
                    f5 = a5;
                    iVar2 = f6;
                }
            }
        }
        return iVar2;
    }

    public final void g(i iVar) {
        i iVar2 = this.f4003a;
        if (iVar2 != null) {
            this.f4006d.g(iVar2, -1.0f);
            this.f4003a.f4035d = -1;
            this.f4003a = null;
        }
        float i5 = this.f4006d.i(iVar, true) * (-1.0f);
        this.f4003a = iVar;
        if (i5 == 1.0f) {
            return;
        }
        this.f4004b /= i5;
        this.f4006d.h(i5);
    }

    public final void h(d dVar, i iVar, boolean z4) {
        if (iVar == null || !iVar.f4038g) {
            return;
        }
        float b5 = this.f4006d.b(iVar);
        this.f4004b = (iVar.f4037f * b5) + this.f4004b;
        this.f4006d.i(iVar, z4);
        if (z4) {
            iVar.b(this);
        }
        if (this.f4006d.k() == 0) {
            this.f4007e = true;
            dVar.f4010a = true;
        }
    }

    public void i(d dVar, c cVar, boolean z4) {
        float d5 = this.f4006d.d(cVar, z4);
        this.f4004b = (cVar.f4004b * d5) + this.f4004b;
        if (z4) {
            cVar.f4003a.b(this);
        }
        if (this.f4003a == null || this.f4006d.k() != 0) {
            return;
        }
        this.f4007e = true;
        dVar.f4010a = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r9 = this;
            n.i r0 = r9.f4003a
            if (r0 != 0) goto L7
            java.lang.String r0 = "0"
            goto L17
        L7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = ""
            r0.<init>(r1)
            n.i r1 = r9.f4003a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L17:
            java.lang.String r1 = " = "
            java.lang.String r0 = androidx.appcompat.widget.b0.h(r0, r1)
            float r1 = r9.f4004b
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L39
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            float r0 = r9.f4004b
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = r3
            goto L3a
        L39:
            r1 = r4
        L3a:
            n.b r5 = r9.f4006d
            int r5 = r5.k()
        L40:
            if (r4 >= r5) goto L9f
            n.b r6 = r9.f4006d
            n.i r6 = r6.f(r4)
            if (r6 != 0) goto L4b
            goto L9c
        L4b:
            n.b r7 = r9.f4006d
            float r7 = r7.a(r4)
            int r8 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r8 != 0) goto L56
            goto L9c
        L56:
            java.lang.String r6 = r6.toString()
            if (r1 != 0) goto L67
            int r1 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r1 >= 0) goto L79
            java.lang.String r1 = "- "
            java.lang.String r0 = androidx.appcompat.widget.b0.h(r0, r1)
            goto L76
        L67:
            if (r8 <= 0) goto L70
            java.lang.String r1 = " + "
            java.lang.String r0 = androidx.appcompat.widget.b0.h(r0, r1)
            goto L79
        L70:
            java.lang.String r1 = " - "
            java.lang.String r0 = androidx.appcompat.widget.b0.h(r0, r1)
        L76:
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r7 = r7 * r1
        L79:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L84
            java.lang.String r0 = androidx.appcompat.widget.b0.h(r0, r6)
            goto L9b
        L84:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        L9b:
            r1 = r3
        L9c:
            int r4 = r4 + 1
            goto L40
        L9f:
            if (r1 != 0) goto La7
            java.lang.String r1 = "0.0"
            java.lang.String r0 = androidx.appcompat.widget.b0.h(r0, r1)
        La7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: n.c.toString():java.lang.String");
    }
}

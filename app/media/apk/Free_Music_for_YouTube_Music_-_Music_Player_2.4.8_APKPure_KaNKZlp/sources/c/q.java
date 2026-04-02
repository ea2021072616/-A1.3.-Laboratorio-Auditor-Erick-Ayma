package c;

import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SegmentedByteString.java */
/* loaded from: classes.dex */
public final class q extends f {
    final transient byte[][] f;
    final transient int[] g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(c cVar, int i) {
        super(null);
        int i2 = 0;
        u.a(cVar.f285b, 0L, i);
        o oVar = cVar.f284a;
        int i3 = 0;
        int i4 = 0;
        while (i4 < i) {
            if (oVar.f313c == oVar.f312b) {
                throw new AssertionError("s.limit == s.pos");
            }
            i4 += oVar.f313c - oVar.f312b;
            i3++;
            oVar = oVar.f;
        }
        this.f = new byte[i3];
        this.g = new int[i3 * 2];
        o oVar2 = cVar.f284a;
        int i5 = 0;
        while (i2 < i) {
            this.f[i5] = oVar2.f311a;
            int i6 = (oVar2.f313c - oVar2.f312b) + i2;
            if (i6 > i) {
                i6 = i;
            }
            this.g[i5] = i6;
            this.g[this.f.length + i5] = oVar2.f312b;
            oVar2.d = true;
            i5++;
            oVar2 = oVar2.f;
            i2 = i6;
        }
    }

    @Override // c.f
    public String a() {
        return j().a();
    }

    @Override // c.f
    public String b() {
        return j().b();
    }

    @Override // c.f
    public String f() {
        return j().f();
    }

    @Override // c.f
    public f g() {
        return j().g();
    }

    @Override // c.f
    public f c() {
        return j().c();
    }

    @Override // c.f
    public f d() {
        return j().d();
    }

    @Override // c.f
    public f e() {
        return j().e();
    }

    @Override // c.f
    public f a(int i, int i2) {
        return j().a(i, i2);
    }

    @Override // c.f
    public byte a(int i) {
        u.a(this.g[this.f.length - 1], i, 1L);
        int b2 = b(i);
        return this.f[b2][(i - (b2 == 0 ? 0 : this.g[b2 - 1])) + this.g[this.f.length + b2]];
    }

    private int b(int i) {
        int binarySearch = Arrays.binarySearch(this.g, 0, this.f.length, i + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ (-1);
    }

    @Override // c.f
    public int h() {
        return this.g[this.f.length - 1];
    }

    @Override // c.f
    public byte[] i() {
        int i = 0;
        byte[] bArr = new byte[this.g[this.f.length - 1]];
        int length = this.f.length;
        int i2 = 0;
        while (i < length) {
            int i3 = this.g[length + i];
            int i4 = this.g[i];
            System.arraycopy(this.f[i], i3, bArr, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.f
    public void a(c cVar) {
        int i = 0;
        int length = this.f.length;
        int i2 = 0;
        while (i < length) {
            int i3 = this.g[length + i];
            int i4 = this.g[i];
            o oVar = new o(this.f[i], i3, (i3 + i4) - i2);
            if (cVar.f284a == null) {
                oVar.g = oVar;
                oVar.f = oVar;
                cVar.f284a = oVar;
            } else {
                cVar.f284a.g.a(oVar);
            }
            i++;
            i2 = i4;
        }
        cVar.f285b = i2 + cVar.f285b;
    }

    @Override // c.f
    public boolean a(int i, f fVar, int i2, int i3) {
        if (i < 0 || i > h() - i3) {
            return false;
        }
        int b2 = b(i);
        while (i3 > 0) {
            int i4 = b2 == 0 ? 0 : this.g[b2 - 1];
            int min = Math.min(i3, ((this.g[b2] - i4) + i4) - i);
            if (!fVar.a(i2, this.f[b2], (i - i4) + this.g[this.f.length + b2], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b2++;
        }
        return true;
    }

    @Override // c.f
    public boolean a(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > h() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int b2 = b(i);
        while (i3 > 0) {
            int i4 = b2 == 0 ? 0 : this.g[b2 - 1];
            int min = Math.min(i3, ((this.g[b2] - i4) + i4) - i);
            if (!u.a(this.f[b2], (i - i4) + this.g[this.f.length + b2], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b2++;
        }
        return true;
    }

    private f j() {
        return new f(i());
    }

    @Override // c.f
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof f) && ((f) obj).h() == h() && a(0, (f) obj, 0, h());
    }

    @Override // c.f
    public int hashCode() {
        int i = this.d;
        if (i == 0) {
            i = 1;
            int length = this.f.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                byte[] bArr = this.f[i2];
                int i4 = this.g[length + i2];
                int i5 = this.g[i2];
                int i6 = (i5 - i3) + i4;
                int i7 = i;
                for (int i8 = i4; i8 < i6; i8++) {
                    i7 = (i7 * 31) + bArr[i8];
                }
                i2++;
                i3 = i5;
                i = i7;
            }
            this.d = i;
        }
        return i;
    }

    @Override // c.f
    public String toString() {
        return j().toString();
    }

    private Object writeReplace() {
        return j();
    }
}

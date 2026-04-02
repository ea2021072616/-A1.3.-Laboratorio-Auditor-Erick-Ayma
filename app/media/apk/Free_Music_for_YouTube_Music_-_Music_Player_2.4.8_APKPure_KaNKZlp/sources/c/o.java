package c;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Segment.java */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    final byte[] f311a;

    /* renamed from: b  reason: collision with root package name */
    int f312b;

    /* renamed from: c  reason: collision with root package name */
    int f313c;
    boolean d;
    boolean e;
    o f;
    o g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o() {
        this.f311a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(o oVar) {
        this(oVar.f311a, oVar.f312b, oVar.f313c);
        oVar.d = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(byte[] bArr, int i, int i2) {
        this.f311a = bArr;
        this.f312b = i;
        this.f313c = i2;
        this.e = false;
        this.d = true;
    }

    public o a() {
        o oVar = this.f != this ? this.f : null;
        this.g.f = this.f;
        this.f.g = this.g;
        this.f = null;
        this.g = null;
        return oVar;
    }

    public o a(o oVar) {
        oVar.g = this;
        oVar.f = this.f;
        this.f.g = oVar;
        this.f = oVar;
        return oVar;
    }

    public o a(int i) {
        o a2;
        if (i <= 0 || i > this.f313c - this.f312b) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            a2 = new o(this);
        } else {
            a2 = p.a();
            System.arraycopy(this.f311a, this.f312b, a2.f311a, 0, i);
        }
        a2.f313c = a2.f312b + i;
        this.f312b += i;
        this.g.a(a2);
        return a2;
    }

    public void b() {
        if (this.g == this) {
            throw new IllegalStateException();
        }
        if (this.g.e) {
            int i = this.f313c - this.f312b;
            if (i <= (this.g.d ? 0 : this.g.f312b) + (8192 - this.g.f313c)) {
                a(this.g, i);
                a();
                p.a(this);
            }
        }
    }

    public void a(o oVar, int i) {
        if (!oVar.e) {
            throw new IllegalArgumentException();
        }
        if (oVar.f313c + i > 8192) {
            if (oVar.d) {
                throw new IllegalArgumentException();
            }
            if ((oVar.f313c + i) - oVar.f312b > 8192) {
                throw new IllegalArgumentException();
            }
            System.arraycopy(oVar.f311a, oVar.f312b, oVar.f311a, 0, oVar.f313c - oVar.f312b);
            oVar.f313c -= oVar.f312b;
            oVar.f312b = 0;
        }
        System.arraycopy(this.f311a, this.f312b, oVar.f311a, oVar.f313c, i);
        oVar.f313c += i;
        this.f312b += i;
    }
}

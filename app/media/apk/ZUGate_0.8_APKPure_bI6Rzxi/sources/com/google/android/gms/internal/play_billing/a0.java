package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public class a0 extends z {

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f1833d;

    public a0(byte[] bArr) {
        bArr.getClass();
        this.f1833d = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof z) && i() == ((z) obj).i()) {
            if (i() == 0) {
                return true;
            }
            if (obj instanceof a0) {
                a0 a0Var = (a0) obj;
                int i5 = this.f1995b;
                int i6 = a0Var.f1995b;
                if (i5 == 0 || i6 == 0 || i5 == i6) {
                    int i7 = i();
                    if (i7 > a0Var.i()) {
                        throw new IllegalArgumentException("Length too large: " + i7 + i());
                    } else if (i7 > a0Var.i()) {
                        throw new IllegalArgumentException("Ran off end of other: 0, " + i7 + ", " + a0Var.i());
                    } else {
                        a0Var.l();
                        int i8 = 0;
                        int i9 = 0;
                        while (i8 < i7) {
                            if (this.f1833d[i8] != a0Var.f1833d[i9]) {
                                return false;
                            }
                            i8++;
                            i9++;
                        }
                        return true;
                    }
                }
                return false;
            }
            return obj.equals(this);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.play_billing.z
    public byte g(int i5) {
        return this.f1833d[i5];
    }

    @Override // com.google.android.gms.internal.play_billing.z
    public byte h(int i5) {
        return this.f1833d[i5];
    }

    @Override // com.google.android.gms.internal.play_billing.z
    public int i() {
        return this.f1833d.length;
    }

    public void l() {
    }
}

package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public final class y extends a0 {

    /* renamed from: e  reason: collision with root package name */
    public final int f1991e;

    public y(byte[] bArr, int i5) {
        super(bArr);
        z.j(0, i5, bArr.length);
        this.f1991e = i5;
    }

    @Override // com.google.android.gms.internal.play_billing.a0, com.google.android.gms.internal.play_billing.z
    public final byte g(int i5) {
        int i6 = this.f1991e;
        if (((i6 - (i5 + 1)) | i5) < 0) {
            if (i5 < 0) {
                throw new ArrayIndexOutOfBoundsException(androidx.appcompat.widget.b0.f("Index < 0: ", i5));
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i5 + ", " + i6);
        }
        return this.f1833d[i5];
    }

    @Override // com.google.android.gms.internal.play_billing.a0, com.google.android.gms.internal.play_billing.z
    public final byte h(int i5) {
        return this.f1833d[i5];
    }

    @Override // com.google.android.gms.internal.play_billing.a0, com.google.android.gms.internal.play_billing.z
    public final int i() {
        return this.f1991e;
    }

    @Override // com.google.android.gms.internal.play_billing.a0
    public final void l() {
    }
}

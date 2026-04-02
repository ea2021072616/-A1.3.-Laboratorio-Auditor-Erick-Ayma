package i2;

import java.util.Arrays;
/* loaded from: classes.dex */
public final class m extends l {

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f3405b;

    public m(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.f3405b = bArr;
    }

    @Override // i2.l
    public final byte[] c() {
        return this.f3405b;
    }
}

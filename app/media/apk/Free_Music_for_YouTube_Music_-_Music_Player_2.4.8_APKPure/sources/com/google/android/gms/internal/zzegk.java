package com.google.android.gms.internal;
/* loaded from: classes2.dex */
public final class zzegk implements Cloneable {
    private static final zzegl zzncw = new zzegl();
    private int mSize;
    private boolean zzncx;
    private int[] zzncy;
    private zzegl[] zzncz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzegk() {
        this(10);
    }

    private zzegk(int i) {
        this.zzncx = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.zzncy = new int[idealIntArraySize];
        this.zzncz = new zzegl[idealIntArraySize];
        this.mSize = 0;
    }

    private static int idealIntArraySize(int i) {
        int i2 = i << 2;
        int i3 = 4;
        while (true) {
            if (i3 >= 32) {
                break;
            } else if (i2 <= (1 << i3) - 12) {
                i2 = (1 << i3) - 12;
                break;
            } else {
                i3++;
            }
        }
        return i2 / 4;
    }

    private final int zzhh(int i) {
        int i2 = 0;
        int i3 = this.mSize - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.zzncy[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ (-1);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i = this.mSize;
        zzegk zzegkVar = new zzegk(i);
        System.arraycopy(this.zzncy, 0, zzegkVar.zzncy, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            if (this.zzncz[i2] != null) {
                zzegkVar.zzncz[i2] = (zzegl) this.zzncz[i2].clone();
            }
        }
        zzegkVar.mSize = i;
        return zzegkVar;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzegk) {
            zzegk zzegkVar = (zzegk) obj;
            if (this.mSize != zzegkVar.mSize) {
                return false;
            }
            int[] iArr = this.zzncy;
            int[] iArr2 = zzegkVar.zzncy;
            int i = this.mSize;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                } else if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                zzegl[] zzeglVarArr = this.zzncz;
                zzegl[] zzeglVarArr2 = zzegkVar.zzncz;
                int i3 = this.mSize;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    } else if (!zzeglVarArr[i4].equals(zzeglVarArr2[i4])) {
                        z2 = false;
                        break;
                    } else {
                        i4++;
                    }
                }
                if (z2) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzncy[i2]) * 31) + this.zzncz[i2].hashCode();
        }
        return i;
    }

    public final boolean isEmpty() {
        return this.mSize == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int size() {
        return this.mSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(int i, zzegl zzeglVar) {
        int zzhh = zzhh(i);
        if (zzhh >= 0) {
            this.zzncz[zzhh] = zzeglVar;
            return;
        }
        int i2 = zzhh ^ (-1);
        if (i2 < this.mSize && this.zzncz[i2] == zzncw) {
            this.zzncy[i2] = i;
            this.zzncz[i2] = zzeglVar;
            return;
        }
        if (this.mSize >= this.zzncy.length) {
            int idealIntArraySize = idealIntArraySize(this.mSize + 1);
            int[] iArr = new int[idealIntArraySize];
            zzegl[] zzeglVarArr = new zzegl[idealIntArraySize];
            System.arraycopy(this.zzncy, 0, iArr, 0, this.zzncy.length);
            System.arraycopy(this.zzncz, 0, zzeglVarArr, 0, this.zzncz.length);
            this.zzncy = iArr;
            this.zzncz = zzeglVarArr;
        }
        if (this.mSize - i2 != 0) {
            System.arraycopy(this.zzncy, i2, this.zzncy, i2 + 1, this.mSize - i2);
            System.arraycopy(this.zzncz, i2, this.zzncz, i2 + 1, this.mSize - i2);
        }
        this.zzncy[i2] = i;
        this.zzncz[i2] = zzeglVar;
        this.mSize++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzegl zzhf(int i) {
        int zzhh = zzhh(i);
        if (zzhh < 0 || this.zzncz[zzhh] == zzncw) {
            return null;
        }
        return this.zzncz[zzhh];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzegl zzhg(int i) {
        return this.zzncz[i];
    }
}

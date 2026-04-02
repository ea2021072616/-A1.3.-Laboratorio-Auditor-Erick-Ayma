package com.google.android.gms.internal;

import java.util.Arrays;
/* loaded from: classes2.dex */
public final class zzefq {
    private static final zzefq zznai = new zzefq(0, new int[0], new Object[0], false);
    private int count;
    private boolean zzmxq;
    private int zzmys;
    private int[] zznaj;
    private Object[] zznak;

    private zzefq() {
        this(0, new int[8], new Object[8], true);
    }

    private zzefq(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzmys = -1;
        this.count = i;
        this.zznaj = iArr;
        this.zznak = objArr;
        this.zzmxq = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzefq zzb(zzefq zzefqVar, zzefq zzefqVar2) {
        int i = zzefqVar.count + zzefqVar2.count;
        int[] copyOf = Arrays.copyOf(zzefqVar.zznaj, i);
        System.arraycopy(zzefqVar2.zznaj, 0, copyOf, zzefqVar.count, zzefqVar2.count);
        Object[] copyOf2 = Arrays.copyOf(zzefqVar.zznak, i);
        System.arraycopy(zzefqVar2.zznak, 0, copyOf2, zzefqVar.count, zzefqVar2.count);
        return new zzefq(i, copyOf, copyOf2, true);
    }

    public static zzefq zzcdh() {
        return zznai;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof zzefq)) {
            zzefq zzefqVar = (zzefq) obj;
            if (this.count == zzefqVar.count) {
                int[] iArr = this.zznaj;
                int[] iArr2 = zzefqVar.zznaj;
                int i = this.count;
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
                    Object[] objArr = this.zznak;
                    Object[] objArr2 = zzefqVar.zznak;
                    int i3 = this.count;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= i3) {
                            z2 = true;
                            break;
                        } else if (!objArr[i4].equals(objArr2[i4])) {
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
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.count + 527) * 31) + Arrays.hashCode(this.zznaj)) * 31) + Arrays.deepHashCode(this.zznak);
    }

    public final void zzbhq() {
        this.zzmxq = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzd(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzefb.zzb(sb, i, String.valueOf(this.zznaj[i2] >>> 3), this.zznak[i2]);
        }
    }
}

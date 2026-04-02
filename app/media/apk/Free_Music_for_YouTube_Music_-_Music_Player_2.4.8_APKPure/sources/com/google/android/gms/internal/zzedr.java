package com.google.android.gms.internal;

import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class zzedr extends zzedq {
    protected final byte[] zzjao;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzedr(byte[] bArr) {
        this.zzjao = bArr;
    }

    @Override // com.google.android.gms.internal.zzedk
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzedk) && size() == ((zzedk) obj).size()) {
            if (size() == 0) {
                return true;
            }
            if (obj instanceof zzedr) {
                int zzcbn = zzcbn();
                int zzcbn2 = ((zzedr) obj).zzcbn();
                if (zzcbn == 0 || zzcbn2 == 0 || zzcbn == zzcbn2) {
                    return zza((zzedr) obj, 0, size());
                }
                return false;
            }
            return obj.equals(this);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.zzedk
    public int size() {
        return this.zzjao.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.zzedk
    public final void zza(zzedj zzedjVar) throws IOException {
        zzedjVar.zzb(this.zzjao, zzcbo(), size());
    }

    @Override // com.google.android.gms.internal.zzedk
    protected void zza(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzjao, 0, bArr, 0, i3);
    }

    @Override // com.google.android.gms.internal.zzedq
    final boolean zza(zzedk zzedkVar, int i, int i2) {
        if (i2 > zzedkVar.size()) {
            throw new IllegalArgumentException(new StringBuilder(40).append("Length too large: ").append(i2).append(size()).toString());
        } else if (i2 + 0 > zzedkVar.size()) {
            throw new IllegalArgumentException(new StringBuilder(59).append("Ran off end of other: 0").append(", ").append(i2).append(", ").append(zzedkVar.size()).toString());
        } else if (zzedkVar instanceof zzedr) {
            zzedr zzedrVar = (zzedr) zzedkVar;
            byte[] bArr = this.zzjao;
            byte[] bArr2 = zzedrVar.zzjao;
            int zzcbo = zzcbo() + i2;
            int zzcbo2 = zzcbo();
            int zzcbo3 = zzedrVar.zzcbo();
            while (zzcbo2 < zzcbo) {
                if (bArr[zzcbo2] != bArr2[zzcbo3]) {
                    return false;
                }
                zzcbo2++;
                zzcbo3++;
            }
            return true;
        } else {
            return zzedkVar.zzs(0, i2 + 0).equals(zzs(0, i2));
        }
    }

    @Override // com.google.android.gms.internal.zzedk
    public final zzedt zzcbm() {
        return zzedt.zzb(this.zzjao, zzcbo(), size(), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int zzcbo() {
        return 0;
    }

    @Override // com.google.android.gms.internal.zzedk
    protected final int zzf(int i, int i2, int i3) {
        return zzeen.zza(i, this.zzjao, zzcbo(), i3);
    }

    @Override // com.google.android.gms.internal.zzedk
    public byte zzgi(int i) {
        return this.zzjao[i];
    }

    @Override // com.google.android.gms.internal.zzedk
    public final zzedk zzs(int i, int i2) {
        int zzg = zzg(i, i2, size());
        return zzg == 0 ? zzedk.zzmxr : new zzedn(this.zzjao, zzcbo() + i, zzg);
    }
}

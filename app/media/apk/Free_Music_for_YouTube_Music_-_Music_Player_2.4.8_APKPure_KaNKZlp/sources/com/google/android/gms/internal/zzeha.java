package com.google.android.gms.internal;

import java.io.IOException;
/* loaded from: classes2.dex */
public final class zzeha extends zzegi<zzeha> {
    private static volatile zzeha[] zznes;
    public Integer zzixi = null;
    public String url = null;
    public zzegv zznet = null;
    private zzegx zzneu = null;
    private Integer zznev = null;
    private int[] zznew = zzegr.zzndi;
    private String zznex = null;
    public Integer zzney = null;
    public String[] zznez = zzegr.EMPTY_STRING_ARRAY;

    public zzeha() {
        this.zzncu = null;
        this.zzndd = -1;
    }

    public static zzeha[] zzceh() {
        if (zznes == null) {
            synchronized (zzegm.zzndc) {
                if (zznes == null) {
                    zznes = new zzeha[0];
                }
            }
        }
        return zznes;
    }

    @Override // com.google.android.gms.internal.zzego
    public final /* synthetic */ zzego zza(zzegf zzegfVar) throws IOException {
        while (true) {
            int zzcbr = zzegfVar.zzcbr();
            switch (zzcbr) {
                case 0:
                    break;
                case 8:
                    this.zzixi = Integer.valueOf(zzegfVar.zzcbs());
                    break;
                case 18:
                    this.url = zzegfVar.readString();
                    break;
                case 26:
                    if (this.zznet == null) {
                        this.zznet = new zzegv();
                    }
                    zzegfVar.zza(this.zznet);
                    break;
                case 34:
                    if (this.zzneu == null) {
                        this.zzneu = new zzegx();
                    }
                    zzegfVar.zza(this.zzneu);
                    break;
                case 40:
                    this.zznev = Integer.valueOf(zzegfVar.zzcbs());
                    break;
                case 48:
                    int zzb = zzegr.zzb(zzegfVar, 48);
                    int length = this.zznew == null ? 0 : this.zznew.length;
                    int[] iArr = new int[zzb + length];
                    if (length != 0) {
                        System.arraycopy(this.zznew, 0, iArr, 0, length);
                    }
                    while (length < iArr.length - 1) {
                        iArr[length] = zzegfVar.zzcbs();
                        zzegfVar.zzcbr();
                        length++;
                    }
                    iArr[length] = zzegfVar.zzcbs();
                    this.zznew = iArr;
                    break;
                case 50:
                    int zzgm = zzegfVar.zzgm(zzegfVar.zzcbz());
                    int position = zzegfVar.getPosition();
                    int i = 0;
                    while (zzegfVar.zzcdx() > 0) {
                        zzegfVar.zzcbs();
                        i++;
                    }
                    zzegfVar.zzha(position);
                    int length2 = this.zznew == null ? 0 : this.zznew.length;
                    int[] iArr2 = new int[i + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.zznew, 0, iArr2, 0, length2);
                    }
                    while (length2 < iArr2.length) {
                        iArr2[length2] = zzegfVar.zzcbs();
                        length2++;
                    }
                    this.zznew = iArr2;
                    zzegfVar.zzgn(zzgm);
                    break;
                case 58:
                    this.zznex = zzegfVar.readString();
                    break;
                case 64:
                    int position2 = zzegfVar.getPosition();
                    int zzcbs = zzegfVar.zzcbs();
                    switch (zzcbs) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                            this.zzney = Integer.valueOf(zzcbs);
                            continue;
                        default:
                            zzegfVar.zzha(position2);
                            zza(zzegfVar, zzcbr);
                            continue;
                    }
                case 74:
                    int zzb2 = zzegr.zzb(zzegfVar, 74);
                    int length3 = this.zznez == null ? 0 : this.zznez.length;
                    String[] strArr = new String[zzb2 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.zznez, 0, strArr, 0, length3);
                    }
                    while (length3 < strArr.length - 1) {
                        strArr[length3] = zzegfVar.readString();
                        zzegfVar.zzcbr();
                        length3++;
                    }
                    strArr[length3] = zzegfVar.readString();
                    this.zznez = strArr;
                    break;
                default:
                    if (!super.zza(zzegfVar, zzcbr)) {
                        break;
                    } else {
                        break;
                    }
            }
        }
        return this;
    }

    @Override // com.google.android.gms.internal.zzegi, com.google.android.gms.internal.zzego
    public final void zza(zzegg zzeggVar) throws IOException {
        zzeggVar.zzu(1, this.zzixi.intValue());
        if (this.url != null) {
            zzeggVar.zzl(2, this.url);
        }
        if (this.zznet != null) {
            zzeggVar.zza(3, this.zznet);
        }
        if (this.zzneu != null) {
            zzeggVar.zza(4, this.zzneu);
        }
        if (this.zznev != null) {
            zzeggVar.zzu(5, this.zznev.intValue());
        }
        if (this.zznew != null && this.zznew.length > 0) {
            for (int i = 0; i < this.zznew.length; i++) {
                zzeggVar.zzu(6, this.zznew[i]);
            }
        }
        if (this.zznex != null) {
            zzeggVar.zzl(7, this.zznex);
        }
        if (this.zzney != null) {
            zzeggVar.zzu(8, this.zzney.intValue());
        }
        if (this.zznez != null && this.zznez.length > 0) {
            for (int i2 = 0; i2 < this.zznez.length; i2++) {
                String str = this.zznez[i2];
                if (str != null) {
                    zzeggVar.zzl(9, str);
                }
            }
        }
        super.zza(zzeggVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzegi, com.google.android.gms.internal.zzego
    public final int zzn() {
        int zzn = super.zzn() + zzegg.zzv(1, this.zzixi.intValue());
        if (this.url != null) {
            zzn += zzegg.zzm(2, this.url);
        }
        if (this.zznet != null) {
            zzn += zzegg.zzb(3, this.zznet);
        }
        if (this.zzneu != null) {
            zzn += zzegg.zzb(4, this.zzneu);
        }
        if (this.zznev != null) {
            zzn += zzegg.zzv(5, this.zznev.intValue());
        }
        if (this.zznew != null && this.zznew.length > 0) {
            int i = 0;
            for (int i2 = 0; i2 < this.zznew.length; i2++) {
                i += zzegg.zzgs(this.zznew[i2]);
            }
            zzn = zzn + i + (this.zznew.length * 1);
        }
        if (this.zznex != null) {
            zzn += zzegg.zzm(7, this.zznex);
        }
        if (this.zzney != null) {
            zzn += zzegg.zzv(8, this.zzney.intValue());
        }
        if (this.zznez == null || this.zznez.length <= 0) {
            return zzn;
        }
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < this.zznez.length; i5++) {
            String str = this.zznez[i5];
            if (str != null) {
                i4++;
                i3 += zzegg.zzrc(str);
            }
        }
        return zzn + i3 + (i4 * 1);
    }
}

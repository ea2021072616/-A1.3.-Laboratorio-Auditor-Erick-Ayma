package com.google.android.gms.internal;

import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import java.io.IOException;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public final class zzegs extends zzegi<zzegs> {
    public Integer zzndp = null;
    private Integer zzndq = null;
    public String url = null;
    public String zzndr = null;
    private String zznds = null;
    public zzegt zzndt = null;
    public zzeha[] zzndu = zzeha.zzceh();
    public String zzndv = null;
    public zzegz zzndw = null;
    private Boolean zzndx = null;
    private String[] zzndy = zzegr.EMPTY_STRING_ARRAY;
    private String zzndz = null;
    private Boolean zznea = null;
    private Boolean zzneb = null;
    private byte[] zznec = null;
    public zzehb zzned = null;

    public zzegs() {
        this.zzncu = null;
        this.zzndd = -1;
    }

    @Override // com.google.android.gms.internal.zzego
    public final /* synthetic */ zzego zza(zzegf zzegfVar) throws IOException {
        while (true) {
            int zzcbr = zzegfVar.zzcbr();
            switch (zzcbr) {
                case 0:
                    break;
                case 10:
                    this.url = zzegfVar.readString();
                    break;
                case 18:
                    this.zzndr = zzegfVar.readString();
                    break;
                case 26:
                    this.zznds = zzegfVar.readString();
                    break;
                case 34:
                    int zzb = zzegr.zzb(zzegfVar, 34);
                    int length = this.zzndu == null ? 0 : this.zzndu.length;
                    zzeha[] zzehaVarArr = new zzeha[zzb + length];
                    if (length != 0) {
                        System.arraycopy(this.zzndu, 0, zzehaVarArr, 0, length);
                    }
                    while (length < zzehaVarArr.length - 1) {
                        zzehaVarArr[length] = new zzeha();
                        zzegfVar.zza(zzehaVarArr[length]);
                        zzegfVar.zzcbr();
                        length++;
                    }
                    zzehaVarArr[length] = new zzeha();
                    zzegfVar.zza(zzehaVarArr[length]);
                    this.zzndu = zzehaVarArr;
                    break;
                case 40:
                    this.zzndx = Boolean.valueOf(zzegfVar.zzcds());
                    break;
                case 50:
                    int zzb2 = zzegr.zzb(zzegfVar, 50);
                    int length2 = this.zzndy == null ? 0 : this.zzndy.length;
                    String[] strArr = new String[zzb2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.zzndy, 0, strArr, 0, length2);
                    }
                    while (length2 < strArr.length - 1) {
                        strArr[length2] = zzegfVar.readString();
                        zzegfVar.zzcbr();
                        length2++;
                    }
                    strArr[length2] = zzegfVar.readString();
                    this.zzndy = strArr;
                    break;
                case 58:
                    this.zzndz = zzegfVar.readString();
                    break;
                case 64:
                    this.zznea = Boolean.valueOf(zzegfVar.zzcds());
                    break;
                case 72:
                    this.zzneb = Boolean.valueOf(zzegfVar.zzcds());
                    break;
                case 80:
                    int position = zzegfVar.getPosition();
                    int zzcbs = zzegfVar.zzcbs();
                    switch (zzcbs) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                            this.zzndp = Integer.valueOf(zzcbs);
                            continue;
                        default:
                            zzegfVar.zzha(position);
                            zza(zzegfVar, zzcbr);
                            continue;
                    }
                case 88:
                    int position2 = zzegfVar.getPosition();
                    int zzcbs2 = zzegfVar.zzcbs();
                    switch (zzcbs2) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            this.zzndq = Integer.valueOf(zzcbs2);
                            continue;
                        default:
                            zzegfVar.zzha(position2);
                            zza(zzegfVar, zzcbr);
                            continue;
                    }
                case 98:
                    if (this.zzndt == null) {
                        this.zzndt = new zzegt();
                    }
                    zzegfVar.zza(this.zzndt);
                    break;
                case 106:
                    this.zzndv = zzegfVar.readString();
                    break;
                case 114:
                    if (this.zzndw == null) {
                        this.zzndw = new zzegz();
                    }
                    zzegfVar.zza(this.zzndw);
                    break;
                case IjkMediaMeta.FF_PROFILE_H264_HIGH_422 /* 122 */:
                    this.zznec = zzegfVar.readBytes();
                    break;
                case TsExtractor.TS_STREAM_TYPE_DTS /* 138 */:
                    if (this.zzned == null) {
                        this.zzned = new zzehb();
                    }
                    zzegfVar.zza(this.zzned);
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
        if (this.url != null) {
            zzeggVar.zzl(1, this.url);
        }
        if (this.zzndr != null) {
            zzeggVar.zzl(2, this.zzndr);
        }
        if (this.zznds != null) {
            zzeggVar.zzl(3, this.zznds);
        }
        if (this.zzndu != null && this.zzndu.length > 0) {
            for (int i = 0; i < this.zzndu.length; i++) {
                zzeha zzehaVar = this.zzndu[i];
                if (zzehaVar != null) {
                    zzeggVar.zza(4, zzehaVar);
                }
            }
        }
        if (this.zzndx != null) {
            zzeggVar.zzl(5, this.zzndx.booleanValue());
        }
        if (this.zzndy != null && this.zzndy.length > 0) {
            for (int i2 = 0; i2 < this.zzndy.length; i2++) {
                String str = this.zzndy[i2];
                if (str != null) {
                    zzeggVar.zzl(6, str);
                }
            }
        }
        if (this.zzndz != null) {
            zzeggVar.zzl(7, this.zzndz);
        }
        if (this.zznea != null) {
            zzeggVar.zzl(8, this.zznea.booleanValue());
        }
        if (this.zzneb != null) {
            zzeggVar.zzl(9, this.zzneb.booleanValue());
        }
        if (this.zzndp != null) {
            zzeggVar.zzu(10, this.zzndp.intValue());
        }
        if (this.zzndq != null) {
            zzeggVar.zzu(11, this.zzndq.intValue());
        }
        if (this.zzndt != null) {
            zzeggVar.zza(12, this.zzndt);
        }
        if (this.zzndv != null) {
            zzeggVar.zzl(13, this.zzndv);
        }
        if (this.zzndw != null) {
            zzeggVar.zza(14, this.zzndw);
        }
        if (this.zznec != null) {
            zzeggVar.zzc(15, this.zznec);
        }
        if (this.zzned != null) {
            zzeggVar.zza(17, this.zzned);
        }
        super.zza(zzeggVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzegi, com.google.android.gms.internal.zzego
    public final int zzn() {
        int zzn = super.zzn();
        if (this.url != null) {
            zzn += zzegg.zzm(1, this.url);
        }
        if (this.zzndr != null) {
            zzn += zzegg.zzm(2, this.zzndr);
        }
        if (this.zznds != null) {
            zzn += zzegg.zzm(3, this.zznds);
        }
        if (this.zzndu != null && this.zzndu.length > 0) {
            int i = zzn;
            for (int i2 = 0; i2 < this.zzndu.length; i2++) {
                zzeha zzehaVar = this.zzndu[i2];
                if (zzehaVar != null) {
                    i += zzegg.zzb(4, zzehaVar);
                }
            }
            zzn = i;
        }
        if (this.zzndx != null) {
            this.zzndx.booleanValue();
            zzn += zzegg.zzgr(5) + 1;
        }
        if (this.zzndy != null && this.zzndy.length > 0) {
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < this.zzndy.length; i5++) {
                String str = this.zzndy[i5];
                if (str != null) {
                    i4++;
                    i3 += zzegg.zzrc(str);
                }
            }
            zzn = zzn + i3 + (i4 * 1);
        }
        if (this.zzndz != null) {
            zzn += zzegg.zzm(7, this.zzndz);
        }
        if (this.zznea != null) {
            this.zznea.booleanValue();
            zzn += zzegg.zzgr(8) + 1;
        }
        if (this.zzneb != null) {
            this.zzneb.booleanValue();
            zzn += zzegg.zzgr(9) + 1;
        }
        if (this.zzndp != null) {
            zzn += zzegg.zzv(10, this.zzndp.intValue());
        }
        if (this.zzndq != null) {
            zzn += zzegg.zzv(11, this.zzndq.intValue());
        }
        if (this.zzndt != null) {
            zzn += zzegg.zzb(12, this.zzndt);
        }
        if (this.zzndv != null) {
            zzn += zzegg.zzm(13, this.zzndv);
        }
        if (this.zzndw != null) {
            zzn += zzegg.zzb(14, this.zzndw);
        }
        if (this.zznec != null) {
            zzn += zzegg.zzd(15, this.zznec);
        }
        return this.zzned != null ? zzn + zzegg.zzb(17, this.zzned) : zzn;
    }
}

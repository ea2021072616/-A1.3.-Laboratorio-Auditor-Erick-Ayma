package com.google.android.gms.internal;

import java.io.IOException;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public final class zzay extends zzegi<zzay> {
    private static volatile zzay[] zzfa;
    public Integer zzff;
    public Integer zzfj;
    public Long zzdk = null;
    public Long zzdl = null;
    public Long zzfb = null;
    public Long zzfc = null;
    public Long zzfd = null;
    public Long zzfe = null;
    public Long zzfg = null;
    public Long zzfh = null;
    public Long zzfi = null;
    public Long zzfk = null;
    public Long zzfl = null;
    public Long zzfm = null;
    public Long zzfn = null;
    public Long zzfo = null;
    public Long zzfp = null;
    public Long zzfq = null;
    public Long zzfr = null;
    public Long zzfs = null;
    public Long zzft = null;

    public zzay() {
        this.zzndd = -1;
    }

    public static zzay[] zzo() {
        if (zzfa == null) {
            synchronized (zzegm.zzndc) {
                if (zzfa == null) {
                    zzfa = new zzay[0];
                }
            }
        }
        return zzfa;
    }

    @Override // com.google.android.gms.internal.zzego
    public final /* synthetic */ zzego zza(zzegf zzegfVar) throws IOException {
        while (true) {
            int zzcbr = zzegfVar.zzcbr();
            switch (zzcbr) {
                case 0:
                    break;
                case 8:
                    this.zzdk = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 16:
                    this.zzdl = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 24:
                    this.zzfb = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 32:
                    this.zzfc = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 40:
                    this.zzfd = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 48:
                    this.zzfe = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 56:
                    int position = zzegfVar.getPosition();
                    int zzcbz = zzegfVar.zzcbz();
                    switch (zzcbz) {
                        case 0:
                        case 1:
                        case 2:
                        case 1000:
                            this.zzff = Integer.valueOf(zzcbz);
                            continue;
                        default:
                            zzegfVar.zzha(position);
                            zza(zzegfVar, zzcbr);
                            continue;
                    }
                case 64:
                    this.zzfg = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 72:
                    this.zzfh = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 80:
                    this.zzfi = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 88:
                    int position2 = zzegfVar.getPosition();
                    int zzcbz2 = zzegfVar.zzcbz();
                    switch (zzcbz2) {
                        case 0:
                        case 1:
                        case 2:
                        case 1000:
                            this.zzfj = Integer.valueOf(zzcbz2);
                            continue;
                        default:
                            zzegfVar.zzha(position2);
                            zza(zzegfVar, zzcbr);
                            continue;
                    }
                case 96:
                    this.zzfk = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 104:
                    this.zzfl = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 112:
                    this.zzfm = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 120:
                    this.zzfn = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 128:
                    this.zzfo = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 136:
                    this.zzfp = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case IjkMediaMeta.FF_PROFILE_H264_HIGH_444 /* 144 */:
                    this.zzfq = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 152:
                    this.zzfr = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 160:
                    this.zzfs = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 168:
                    this.zzft = Long.valueOf(zzegfVar.zzcdu());
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
        if (this.zzdk != null) {
            zzeggVar.zzb(1, this.zzdk.longValue());
        }
        if (this.zzdl != null) {
            zzeggVar.zzb(2, this.zzdl.longValue());
        }
        if (this.zzfb != null) {
            zzeggVar.zzb(3, this.zzfb.longValue());
        }
        if (this.zzfc != null) {
            zzeggVar.zzb(4, this.zzfc.longValue());
        }
        if (this.zzfd != null) {
            zzeggVar.zzb(5, this.zzfd.longValue());
        }
        if (this.zzfe != null) {
            zzeggVar.zzb(6, this.zzfe.longValue());
        }
        if (this.zzff != null) {
            zzeggVar.zzu(7, this.zzff.intValue());
        }
        if (this.zzfg != null) {
            zzeggVar.zzb(8, this.zzfg.longValue());
        }
        if (this.zzfh != null) {
            zzeggVar.zzb(9, this.zzfh.longValue());
        }
        if (this.zzfi != null) {
            zzeggVar.zzb(10, this.zzfi.longValue());
        }
        if (this.zzfj != null) {
            zzeggVar.zzu(11, this.zzfj.intValue());
        }
        if (this.zzfk != null) {
            zzeggVar.zzb(12, this.zzfk.longValue());
        }
        if (this.zzfl != null) {
            zzeggVar.zzb(13, this.zzfl.longValue());
        }
        if (this.zzfm != null) {
            zzeggVar.zzb(14, this.zzfm.longValue());
        }
        if (this.zzfn != null) {
            zzeggVar.zzb(15, this.zzfn.longValue());
        }
        if (this.zzfo != null) {
            zzeggVar.zzb(16, this.zzfo.longValue());
        }
        if (this.zzfp != null) {
            zzeggVar.zzb(17, this.zzfp.longValue());
        }
        if (this.zzfq != null) {
            zzeggVar.zzb(18, this.zzfq.longValue());
        }
        if (this.zzfr != null) {
            zzeggVar.zzb(19, this.zzfr.longValue());
        }
        if (this.zzfs != null) {
            zzeggVar.zzb(20, this.zzfs.longValue());
        }
        if (this.zzft != null) {
            zzeggVar.zzb(21, this.zzft.longValue());
        }
        super.zza(zzeggVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzegi, com.google.android.gms.internal.zzego
    public final int zzn() {
        int zzn = super.zzn();
        if (this.zzdk != null) {
            zzn += zzegg.zze(1, this.zzdk.longValue());
        }
        if (this.zzdl != null) {
            zzn += zzegg.zze(2, this.zzdl.longValue());
        }
        if (this.zzfb != null) {
            zzn += zzegg.zze(3, this.zzfb.longValue());
        }
        if (this.zzfc != null) {
            zzn += zzegg.zze(4, this.zzfc.longValue());
        }
        if (this.zzfd != null) {
            zzn += zzegg.zze(5, this.zzfd.longValue());
        }
        if (this.zzfe != null) {
            zzn += zzegg.zze(6, this.zzfe.longValue());
        }
        if (this.zzff != null) {
            zzn += zzegg.zzv(7, this.zzff.intValue());
        }
        if (this.zzfg != null) {
            zzn += zzegg.zze(8, this.zzfg.longValue());
        }
        if (this.zzfh != null) {
            zzn += zzegg.zze(9, this.zzfh.longValue());
        }
        if (this.zzfi != null) {
            zzn += zzegg.zze(10, this.zzfi.longValue());
        }
        if (this.zzfj != null) {
            zzn += zzegg.zzv(11, this.zzfj.intValue());
        }
        if (this.zzfk != null) {
            zzn += zzegg.zze(12, this.zzfk.longValue());
        }
        if (this.zzfl != null) {
            zzn += zzegg.zze(13, this.zzfl.longValue());
        }
        if (this.zzfm != null) {
            zzn += zzegg.zze(14, this.zzfm.longValue());
        }
        if (this.zzfn != null) {
            zzn += zzegg.zze(15, this.zzfn.longValue());
        }
        if (this.zzfo != null) {
            zzn += zzegg.zze(16, this.zzfo.longValue());
        }
        if (this.zzfp != null) {
            zzn += zzegg.zze(17, this.zzfp.longValue());
        }
        if (this.zzfq != null) {
            zzn += zzegg.zze(18, this.zzfq.longValue());
        }
        if (this.zzfr != null) {
            zzn += zzegg.zze(19, this.zzfr.longValue());
        }
        if (this.zzfs != null) {
            zzn += zzegg.zze(20, this.zzfs.longValue());
        }
        return this.zzft != null ? zzn + zzegg.zze(21, this.zzft.longValue()) : zzn;
    }
}

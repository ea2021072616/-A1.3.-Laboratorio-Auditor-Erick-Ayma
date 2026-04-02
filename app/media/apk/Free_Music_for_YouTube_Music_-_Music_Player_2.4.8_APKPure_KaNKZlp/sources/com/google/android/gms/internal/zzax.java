package com.google.android.gms.internal;

import com.facebook.internal.FacebookRequestErrorClassification;
import java.io.IOException;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public final class zzax extends zzegi<zzax> {
    public Integer zzeh;
    public Integer zzei;
    public Integer zzeo;
    public Integer zzev;
    public String zzcy = null;
    public String zzcp = null;
    public Long zzcz = null;
    private Long zzda = null;
    public Long zzdb = null;
    public Long zzdc = null;
    private Long zzdd = null;
    private Long zzde = null;
    private Long zzdf = null;
    private Long zzdg = null;
    private Long zzdh = null;
    public Long zzdi = null;
    private String zzdj = null;
    public Long zzdk = null;
    public Long zzdl = null;
    public Long zzdm = null;
    public Long zzdn = null;
    private Long zzdo = null;
    private Long zzdp = null;
    public Long zzdq = null;
    public Long zzdr = null;
    public Long zzds = null;
    public String zzct = null;
    public String zzdt = null;
    public Long zzdu = null;
    public Long zzdv = null;
    public Long zzdw = null;
    public String zzcv = null;
    public Long zzdx = null;
    public Long zzdy = null;
    public Long zzdz = null;
    private zzba zzea = null;
    public Long zzeb = null;
    public Long zzec = null;
    public Long zzed = null;
    public Long zzee = null;
    public Long zzef = null;
    public Long zzeg = null;
    public String zzcw = null;
    public String zzcx = null;
    public Long zzej = null;
    public Long zzek = null;
    private Long zzel = null;
    private Long zzem = null;
    private Long zzen = null;
    public zzay zzep = null;
    public zzay[] zzeq = zzay.zzo();
    public zzaz zzer = null;
    private Long zzes = null;
    private Long zzet = null;
    public String zzeu = null;
    public Boolean zzew = null;
    private String zzex = null;
    public Long zzey = null;
    public zzbd zzez = null;

    public zzax() {
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
                    this.zzcy = zzegfVar.readString();
                    break;
                case 18:
                    this.zzcp = zzegfVar.readString();
                    break;
                case 24:
                    this.zzcz = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 32:
                    this.zzda = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 40:
                    this.zzdb = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 48:
                    this.zzdc = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 56:
                    this.zzdd = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 64:
                    this.zzde = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 72:
                    this.zzdf = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 80:
                    this.zzdg = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 88:
                    this.zzdh = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 96:
                    this.zzdi = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 106:
                    this.zzdj = zzegfVar.readString();
                    break;
                case 112:
                    this.zzdk = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 120:
                    this.zzdl = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 128:
                    this.zzdm = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 136:
                    this.zzdn = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case IjkMediaMeta.FF_PROFILE_H264_HIGH_444 /* 144 */:
                    this.zzdo = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 152:
                    this.zzdp = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 160:
                    this.zzdq = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 168:
                    this.zzet = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 176:
                    this.zzdr = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 184:
                    this.zzds = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 194:
                    this.zzeu = zzegfVar.readString();
                    break;
                case 200:
                    this.zzey = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 208:
                    int position = zzegfVar.getPosition();
                    int zzcbz = zzegfVar.zzcbz();
                    switch (zzcbz) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            this.zzev = Integer.valueOf(zzcbz);
                            continue;
                        default:
                            zzegfVar.zzha(position);
                            zza(zzegfVar, zzcbr);
                            continue;
                    }
                case 218:
                    this.zzct = zzegfVar.readString();
                    break;
                case 224:
                    this.zzew = Boolean.valueOf(zzegfVar.zzcds());
                    break;
                case 234:
                    this.zzdt = zzegfVar.readString();
                    break;
                case 242:
                    this.zzex = zzegfVar.readString();
                    break;
                case 248:
                    this.zzdu = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 256:
                    this.zzdv = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 264:
                    this.zzdw = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 274:
                    this.zzcv = zzegfVar.readString();
                    break;
                case 280:
                    this.zzdx = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 288:
                    this.zzdy = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 296:
                    this.zzdz = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 306:
                    if (this.zzea == null) {
                        this.zzea = new zzba();
                    }
                    zzegfVar.zza(this.zzea);
                    break;
                case 312:
                    this.zzeb = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 320:
                    this.zzec = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 328:
                    this.zzed = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 336:
                    this.zzee = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 346:
                    int zzb = zzegr.zzb(zzegfVar, 346);
                    int length = this.zzeq == null ? 0 : this.zzeq.length;
                    zzay[] zzayVarArr = new zzay[zzb + length];
                    if (length != 0) {
                        System.arraycopy(this.zzeq, 0, zzayVarArr, 0, length);
                    }
                    while (length < zzayVarArr.length - 1) {
                        zzayVarArr[length] = new zzay();
                        zzegfVar.zza(zzayVarArr[length]);
                        zzegfVar.zzcbr();
                        length++;
                    }
                    zzayVarArr[length] = new zzay();
                    zzegfVar.zza(zzayVarArr[length]);
                    this.zzeq = zzayVarArr;
                    break;
                case 352:
                    this.zzef = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 360:
                    this.zzeg = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 370:
                    this.zzcw = zzegfVar.readString();
                    break;
                case 378:
                    this.zzcx = zzegfVar.readString();
                    break;
                case 384:
                    int position2 = zzegfVar.getPosition();
                    int zzcbz2 = zzegfVar.zzcbz();
                    switch (zzcbz2) {
                        case 0:
                        case 1:
                        case 2:
                        case 1000:
                            this.zzeh = Integer.valueOf(zzcbz2);
                            continue;
                        default:
                            zzegfVar.zzha(position2);
                            zza(zzegfVar, zzcbr);
                            continue;
                    }
                case 392:
                    int position3 = zzegfVar.getPosition();
                    int zzcbz3 = zzegfVar.zzcbz();
                    switch (zzcbz3) {
                        case 0:
                        case 1:
                        case 2:
                        case 1000:
                            this.zzei = Integer.valueOf(zzcbz3);
                            continue;
                        default:
                            zzegfVar.zzha(position3);
                            zza(zzegfVar, zzcbr);
                            continue;
                    }
                case 402:
                    if (this.zzep == null) {
                        this.zzep = new zzay();
                    }
                    zzegfVar.zza(this.zzep);
                    break;
                case 408:
                    this.zzej = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 416:
                    this.zzek = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 424:
                    this.zzel = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 432:
                    this.zzem = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 440:
                    this.zzen = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 448:
                    int position4 = zzegfVar.getPosition();
                    int zzcbz4 = zzegfVar.zzcbz();
                    switch (zzcbz4) {
                        case 0:
                        case 1:
                        case 2:
                        case 1000:
                            this.zzeo = Integer.valueOf(zzcbz4);
                            continue;
                        default:
                            zzegfVar.zzha(position4);
                            zza(zzegfVar, zzcbr);
                            continue;
                    }
                case FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED /* 458 */:
                    if (this.zzer == null) {
                        this.zzer = new zzaz();
                    }
                    zzegfVar.zza(this.zzer);
                    break;
                case 464:
                    this.zzes = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 1610:
                    if (this.zzez == null) {
                        this.zzez = new zzbd();
                    }
                    zzegfVar.zza(this.zzez);
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
        if (this.zzcy != null) {
            zzeggVar.zzl(1, this.zzcy);
        }
        if (this.zzcp != null) {
            zzeggVar.zzl(2, this.zzcp);
        }
        if (this.zzcz != null) {
            zzeggVar.zzb(3, this.zzcz.longValue());
        }
        if (this.zzda != null) {
            zzeggVar.zzb(4, this.zzda.longValue());
        }
        if (this.zzdb != null) {
            zzeggVar.zzb(5, this.zzdb.longValue());
        }
        if (this.zzdc != null) {
            zzeggVar.zzb(6, this.zzdc.longValue());
        }
        if (this.zzdd != null) {
            zzeggVar.zzb(7, this.zzdd.longValue());
        }
        if (this.zzde != null) {
            zzeggVar.zzb(8, this.zzde.longValue());
        }
        if (this.zzdf != null) {
            zzeggVar.zzb(9, this.zzdf.longValue());
        }
        if (this.zzdg != null) {
            zzeggVar.zzb(10, this.zzdg.longValue());
        }
        if (this.zzdh != null) {
            zzeggVar.zzb(11, this.zzdh.longValue());
        }
        if (this.zzdi != null) {
            zzeggVar.zzb(12, this.zzdi.longValue());
        }
        if (this.zzdj != null) {
            zzeggVar.zzl(13, this.zzdj);
        }
        if (this.zzdk != null) {
            zzeggVar.zzb(14, this.zzdk.longValue());
        }
        if (this.zzdl != null) {
            zzeggVar.zzb(15, this.zzdl.longValue());
        }
        if (this.zzdm != null) {
            zzeggVar.zzb(16, this.zzdm.longValue());
        }
        if (this.zzdn != null) {
            zzeggVar.zzb(17, this.zzdn.longValue());
        }
        if (this.zzdo != null) {
            zzeggVar.zzb(18, this.zzdo.longValue());
        }
        if (this.zzdp != null) {
            zzeggVar.zzb(19, this.zzdp.longValue());
        }
        if (this.zzdq != null) {
            zzeggVar.zzb(20, this.zzdq.longValue());
        }
        if (this.zzet != null) {
            zzeggVar.zzb(21, this.zzet.longValue());
        }
        if (this.zzdr != null) {
            zzeggVar.zzb(22, this.zzdr.longValue());
        }
        if (this.zzds != null) {
            zzeggVar.zzb(23, this.zzds.longValue());
        }
        if (this.zzeu != null) {
            zzeggVar.zzl(24, this.zzeu);
        }
        if (this.zzey != null) {
            zzeggVar.zzb(25, this.zzey.longValue());
        }
        if (this.zzev != null) {
            zzeggVar.zzu(26, this.zzev.intValue());
        }
        if (this.zzct != null) {
            zzeggVar.zzl(27, this.zzct);
        }
        if (this.zzew != null) {
            zzeggVar.zzl(28, this.zzew.booleanValue());
        }
        if (this.zzdt != null) {
            zzeggVar.zzl(29, this.zzdt);
        }
        if (this.zzex != null) {
            zzeggVar.zzl(30, this.zzex);
        }
        if (this.zzdu != null) {
            zzeggVar.zzb(31, this.zzdu.longValue());
        }
        if (this.zzdv != null) {
            zzeggVar.zzb(32, this.zzdv.longValue());
        }
        if (this.zzdw != null) {
            zzeggVar.zzb(33, this.zzdw.longValue());
        }
        if (this.zzcv != null) {
            zzeggVar.zzl(34, this.zzcv);
        }
        if (this.zzdx != null) {
            zzeggVar.zzb(35, this.zzdx.longValue());
        }
        if (this.zzdy != null) {
            zzeggVar.zzb(36, this.zzdy.longValue());
        }
        if (this.zzdz != null) {
            zzeggVar.zzb(37, this.zzdz.longValue());
        }
        if (this.zzea != null) {
            zzeggVar.zza(38, this.zzea);
        }
        if (this.zzeb != null) {
            zzeggVar.zzb(39, this.zzeb.longValue());
        }
        if (this.zzec != null) {
            zzeggVar.zzb(40, this.zzec.longValue());
        }
        if (this.zzed != null) {
            zzeggVar.zzb(41, this.zzed.longValue());
        }
        if (this.zzee != null) {
            zzeggVar.zzb(42, this.zzee.longValue());
        }
        if (this.zzeq != null && this.zzeq.length > 0) {
            for (int i = 0; i < this.zzeq.length; i++) {
                zzay zzayVar = this.zzeq[i];
                if (zzayVar != null) {
                    zzeggVar.zza(43, zzayVar);
                }
            }
        }
        if (this.zzef != null) {
            zzeggVar.zzb(44, this.zzef.longValue());
        }
        if (this.zzeg != null) {
            zzeggVar.zzb(45, this.zzeg.longValue());
        }
        if (this.zzcw != null) {
            zzeggVar.zzl(46, this.zzcw);
        }
        if (this.zzcx != null) {
            zzeggVar.zzl(47, this.zzcx);
        }
        if (this.zzeh != null) {
            zzeggVar.zzu(48, this.zzeh.intValue());
        }
        if (this.zzei != null) {
            zzeggVar.zzu(49, this.zzei.intValue());
        }
        if (this.zzep != null) {
            zzeggVar.zza(50, this.zzep);
        }
        if (this.zzej != null) {
            zzeggVar.zzb(51, this.zzej.longValue());
        }
        if (this.zzek != null) {
            zzeggVar.zzb(52, this.zzek.longValue());
        }
        if (this.zzel != null) {
            zzeggVar.zzb(53, this.zzel.longValue());
        }
        if (this.zzem != null) {
            zzeggVar.zzb(54, this.zzem.longValue());
        }
        if (this.zzen != null) {
            zzeggVar.zzb(55, this.zzen.longValue());
        }
        if (this.zzeo != null) {
            zzeggVar.zzu(56, this.zzeo.intValue());
        }
        if (this.zzer != null) {
            zzeggVar.zza(57, this.zzer);
        }
        if (this.zzes != null) {
            zzeggVar.zzb(58, this.zzes.longValue());
        }
        if (this.zzez != null) {
            zzeggVar.zza(201, this.zzez);
        }
        super.zza(zzeggVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzegi, com.google.android.gms.internal.zzego
    public final int zzn() {
        int zzn = super.zzn();
        if (this.zzcy != null) {
            zzn += zzegg.zzm(1, this.zzcy);
        }
        if (this.zzcp != null) {
            zzn += zzegg.zzm(2, this.zzcp);
        }
        if (this.zzcz != null) {
            zzn += zzegg.zze(3, this.zzcz.longValue());
        }
        if (this.zzda != null) {
            zzn += zzegg.zze(4, this.zzda.longValue());
        }
        if (this.zzdb != null) {
            zzn += zzegg.zze(5, this.zzdb.longValue());
        }
        if (this.zzdc != null) {
            zzn += zzegg.zze(6, this.zzdc.longValue());
        }
        if (this.zzdd != null) {
            zzn += zzegg.zze(7, this.zzdd.longValue());
        }
        if (this.zzde != null) {
            zzn += zzegg.zze(8, this.zzde.longValue());
        }
        if (this.zzdf != null) {
            zzn += zzegg.zze(9, this.zzdf.longValue());
        }
        if (this.zzdg != null) {
            zzn += zzegg.zze(10, this.zzdg.longValue());
        }
        if (this.zzdh != null) {
            zzn += zzegg.zze(11, this.zzdh.longValue());
        }
        if (this.zzdi != null) {
            zzn += zzegg.zze(12, this.zzdi.longValue());
        }
        if (this.zzdj != null) {
            zzn += zzegg.zzm(13, this.zzdj);
        }
        if (this.zzdk != null) {
            zzn += zzegg.zze(14, this.zzdk.longValue());
        }
        if (this.zzdl != null) {
            zzn += zzegg.zze(15, this.zzdl.longValue());
        }
        if (this.zzdm != null) {
            zzn += zzegg.zze(16, this.zzdm.longValue());
        }
        if (this.zzdn != null) {
            zzn += zzegg.zze(17, this.zzdn.longValue());
        }
        if (this.zzdo != null) {
            zzn += zzegg.zze(18, this.zzdo.longValue());
        }
        if (this.zzdp != null) {
            zzn += zzegg.zze(19, this.zzdp.longValue());
        }
        if (this.zzdq != null) {
            zzn += zzegg.zze(20, this.zzdq.longValue());
        }
        if (this.zzet != null) {
            zzn += zzegg.zze(21, this.zzet.longValue());
        }
        if (this.zzdr != null) {
            zzn += zzegg.zze(22, this.zzdr.longValue());
        }
        if (this.zzds != null) {
            zzn += zzegg.zze(23, this.zzds.longValue());
        }
        if (this.zzeu != null) {
            zzn += zzegg.zzm(24, this.zzeu);
        }
        if (this.zzey != null) {
            zzn += zzegg.zze(25, this.zzey.longValue());
        }
        if (this.zzev != null) {
            zzn += zzegg.zzv(26, this.zzev.intValue());
        }
        if (this.zzct != null) {
            zzn += zzegg.zzm(27, this.zzct);
        }
        if (this.zzew != null) {
            this.zzew.booleanValue();
            zzn += zzegg.zzgr(28) + 1;
        }
        if (this.zzdt != null) {
            zzn += zzegg.zzm(29, this.zzdt);
        }
        if (this.zzex != null) {
            zzn += zzegg.zzm(30, this.zzex);
        }
        if (this.zzdu != null) {
            zzn += zzegg.zze(31, this.zzdu.longValue());
        }
        if (this.zzdv != null) {
            zzn += zzegg.zze(32, this.zzdv.longValue());
        }
        if (this.zzdw != null) {
            zzn += zzegg.zze(33, this.zzdw.longValue());
        }
        if (this.zzcv != null) {
            zzn += zzegg.zzm(34, this.zzcv);
        }
        if (this.zzdx != null) {
            zzn += zzegg.zze(35, this.zzdx.longValue());
        }
        if (this.zzdy != null) {
            zzn += zzegg.zze(36, this.zzdy.longValue());
        }
        if (this.zzdz != null) {
            zzn += zzegg.zze(37, this.zzdz.longValue());
        }
        if (this.zzea != null) {
            zzn += zzegg.zzb(38, this.zzea);
        }
        if (this.zzeb != null) {
            zzn += zzegg.zze(39, this.zzeb.longValue());
        }
        if (this.zzec != null) {
            zzn += zzegg.zze(40, this.zzec.longValue());
        }
        if (this.zzed != null) {
            zzn += zzegg.zze(41, this.zzed.longValue());
        }
        if (this.zzee != null) {
            zzn += zzegg.zze(42, this.zzee.longValue());
        }
        if (this.zzeq != null && this.zzeq.length > 0) {
            int i = zzn;
            for (int i2 = 0; i2 < this.zzeq.length; i2++) {
                zzay zzayVar = this.zzeq[i2];
                if (zzayVar != null) {
                    i += zzegg.zzb(43, zzayVar);
                }
            }
            zzn = i;
        }
        if (this.zzef != null) {
            zzn += zzegg.zze(44, this.zzef.longValue());
        }
        if (this.zzeg != null) {
            zzn += zzegg.zze(45, this.zzeg.longValue());
        }
        if (this.zzcw != null) {
            zzn += zzegg.zzm(46, this.zzcw);
        }
        if (this.zzcx != null) {
            zzn += zzegg.zzm(47, this.zzcx);
        }
        if (this.zzeh != null) {
            zzn += zzegg.zzv(48, this.zzeh.intValue());
        }
        if (this.zzei != null) {
            zzn += zzegg.zzv(49, this.zzei.intValue());
        }
        if (this.zzep != null) {
            zzn += zzegg.zzb(50, this.zzep);
        }
        if (this.zzej != null) {
            zzn += zzegg.zze(51, this.zzej.longValue());
        }
        if (this.zzek != null) {
            zzn += zzegg.zze(52, this.zzek.longValue());
        }
        if (this.zzel != null) {
            zzn += zzegg.zze(53, this.zzel.longValue());
        }
        if (this.zzem != null) {
            zzn += zzegg.zze(54, this.zzem.longValue());
        }
        if (this.zzen != null) {
            zzn += zzegg.zze(55, this.zzen.longValue());
        }
        if (this.zzeo != null) {
            zzn += zzegg.zzv(56, this.zzeo.intValue());
        }
        if (this.zzer != null) {
            zzn += zzegg.zzb(57, this.zzer);
        }
        if (this.zzes != null) {
            zzn += zzegg.zze(58, this.zzes.longValue());
        }
        return this.zzez != null ? zzn + zzegg.zzb(201, this.zzez) : zzn;
    }
}

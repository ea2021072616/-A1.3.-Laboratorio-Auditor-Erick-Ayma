package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdgq;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class zzdgc {

    /* loaded from: classes2.dex */
    public static final class zza extends zzeed<zza, C0081zza> implements zzefa {
        private static volatile zzefc<zza> zzkxq;
        private static final zza zzkzg;
        private zzdgq.zzb zzkzf;

        /* renamed from: com.google.android.gms.internal.zzdgc$zza$zza  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0081zza extends zzeee<zza, C0081zza> implements zzefa {
            private C0081zza() {
                super(zza.zzkzg);
            }

            /* synthetic */ C0081zza(zzdgd zzdgdVar) {
                this();
            }
        }

        static {
            zza zzaVar = new zza();
            zzkzg = zzaVar;
            zzaVar.zza(zzeel.zzmzd, (Object) null, (Object) null);
            zzaVar.zzmyr.zzbhq();
        }

        private zza() {
        }

        public static zza zzbks() {
            return zzkzg;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.android.gms.internal.zzeed
        public final Object zza(int i, Object obj, Object obj2) {
            zzdgq.zzb.zza zzaVar;
            switch (zzdgd.zzkxl[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return zzkzg;
                case 3:
                    return null;
                case 4:
                    return new C0081zza(null);
                case 5:
                    this.zzkzf = (zzdgq.zzb) ((zzeem) obj).zza(this.zzkzf, ((zza) obj2).zzkzf);
                    return this;
                case 6:
                    zzedt zzedtVar = (zzedt) obj;
                    zzedz zzedzVar = (zzedz) obj2;
                    boolean z = false;
                    while (!z) {
                        try {
                            int zzcbr = zzedtVar.zzcbr();
                            switch (zzcbr) {
                                case 0:
                                    z = true;
                                    break;
                                case 18:
                                    if (this.zzkzf != null) {
                                        zzdgq.zzb zzbVar = this.zzkzf;
                                        zzeee zzeeeVar = (zzeee) zzbVar.zza(zzeel.zzmzf, (Object) null, (Object) null);
                                        zzeeeVar.zza((zzeee) zzbVar);
                                        zzaVar = (zzdgq.zzb.zza) zzeeeVar;
                                    } else {
                                        zzaVar = null;
                                    }
                                    this.zzkzf = (zzdgq.zzb) zzedtVar.zza(zzdgq.zzb.zzbmk(), zzedzVar);
                                    if (zzaVar == null) {
                                        break;
                                    } else {
                                        zzaVar.zza((zzdgq.zzb.zza) this.zzkzf);
                                        this.zzkzf = (zzdgq.zzb) zzaVar.zzccq();
                                        break;
                                    }
                                default:
                                    if (!zzedtVar.zzgl(zzcbr)) {
                                        z = true;
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        } catch (zzeer e) {
                            throw new RuntimeException(e.zze(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new zzeer(e2.getMessage()).zze(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (zzkxq == null) {
                        synchronized (zza.class) {
                            if (zzkxq == null) {
                                zzkxq = new zzeef(zzkzg);
                            }
                        }
                    }
                    return zzkxq;
                default:
                    throw new UnsupportedOperationException();
            }
            return zzkzg;
        }

        @Override // com.google.android.gms.internal.zzeey
        public final void zza(zzedw zzedwVar) throws IOException {
            if (this.zzkzf != null) {
                zzedwVar.zza(2, this.zzkzf == null ? zzdgq.zzb.zzbmk() : this.zzkzf);
            }
        }

        @Override // com.google.android.gms.internal.zzeey
        public final int zzbjo() {
            int i = this.zzmys;
            if (i == -1) {
                i = 0;
                if (this.zzkzf != null) {
                    i = zzedw.zzb(2, this.zzkzf == null ? zzdgq.zzb.zzbmk() : this.zzkzf) + 0;
                }
                this.zzmys = i;
            }
            return i;
        }

        public final zzdgq.zzb zzbkr() {
            return this.zzkzf == null ? zzdgq.zzb.zzbmk() : this.zzkzf;
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzb extends zzeed<zzb, zza> implements zzefa {
        private static volatile zzefc<zzb> zzkxq;
        private static final zzb zzkzk;
        private zzd zzkzh;
        private zza zzkzi;
        private int zzkzj;

        /* loaded from: classes2.dex */
        public static final class zza extends zzeee<zzb, zza> implements zzefa {
            private zza() {
                super(zzb.zzkzk);
            }

            /* synthetic */ zza(zzdgd zzdgdVar) {
                this();
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzkzk = zzbVar;
            zzbVar.zza(zzeel.zzmzd, (Object) null, (Object) null);
            zzbVar.zzmyr.zzbhq();
        }

        private zzb() {
        }

        public static zzb zzbkx() {
            return zzkzk;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.android.gms.internal.zzeed
        public final Object zza(int i, Object obj, Object obj2) {
            zza.C0081zza c0081zza;
            zzd.zza zzaVar;
            switch (zzdgd.zzkxl[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return zzkzk;
                case 3:
                    return null;
                case 4:
                    return new zza(null);
                case 5:
                    zzeem zzeemVar = (zzeem) obj;
                    zzb zzbVar = (zzb) obj2;
                    this.zzkzh = (zzd) zzeemVar.zza(this.zzkzh, zzbVar.zzkzh);
                    this.zzkzi = (zza) zzeemVar.zza(this.zzkzi, zzbVar.zzkzi);
                    this.zzkzj = zzeemVar.zza(this.zzkzj != 0, this.zzkzj, zzbVar.zzkzj != 0, zzbVar.zzkzj);
                    return this;
                case 6:
                    zzedt zzedtVar = (zzedt) obj;
                    zzedz zzedzVar = (zzedz) obj2;
                    boolean z = false;
                    while (!z) {
                        try {
                            int zzcbr = zzedtVar.zzcbr();
                            switch (zzcbr) {
                                case 0:
                                    z = true;
                                    break;
                                case 10:
                                    if (this.zzkzh != null) {
                                        zzd zzdVar = this.zzkzh;
                                        zzeee zzeeeVar = (zzeee) zzdVar.zza(zzeel.zzmzf, (Object) null, (Object) null);
                                        zzeeeVar.zza((zzeee) zzdVar);
                                        zzaVar = (zzd.zza) zzeeeVar;
                                    } else {
                                        zzaVar = null;
                                    }
                                    this.zzkzh = (zzd) zzedtVar.zza(zzd.zzblg(), zzedzVar);
                                    if (zzaVar == null) {
                                        break;
                                    } else {
                                        zzaVar.zza((zzd.zza) this.zzkzh);
                                        this.zzkzh = (zzd) zzaVar.zzccq();
                                        break;
                                    }
                                case 18:
                                    if (this.zzkzi != null) {
                                        zza zzaVar2 = this.zzkzi;
                                        zzeee zzeeeVar2 = (zzeee) zzaVar2.zza(zzeel.zzmzf, (Object) null, (Object) null);
                                        zzeeeVar2.zza((zzeee) zzaVar2);
                                        c0081zza = (zza.C0081zza) zzeeeVar2;
                                    } else {
                                        c0081zza = null;
                                    }
                                    this.zzkzi = (zza) zzedtVar.zza(zza.zzbks(), zzedzVar);
                                    if (c0081zza == null) {
                                        break;
                                    } else {
                                        c0081zza.zza((zza.C0081zza) this.zzkzi);
                                        this.zzkzi = (zza) c0081zza.zzccq();
                                        break;
                                    }
                                case 24:
                                    this.zzkzj = zzedtVar.zzcbv();
                                    break;
                                default:
                                    if (!zzedtVar.zzgl(zzcbr)) {
                                        z = true;
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        } catch (zzeer e) {
                            throw new RuntimeException(e.zze(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new zzeer(e2.getMessage()).zze(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (zzkxq == null) {
                        synchronized (zzb.class) {
                            if (zzkxq == null) {
                                zzkxq = new zzeef(zzkzk);
                            }
                        }
                    }
                    return zzkxq;
                default:
                    throw new UnsupportedOperationException();
            }
            return zzkzk;
        }

        @Override // com.google.android.gms.internal.zzeey
        public final void zza(zzedw zzedwVar) throws IOException {
            if (this.zzkzh != null) {
                zzedwVar.zza(1, this.zzkzh == null ? zzd.zzblg() : this.zzkzh);
            }
            if (this.zzkzi != null) {
                zzedwVar.zza(2, this.zzkzi == null ? zza.zzbks() : this.zzkzi);
            }
            if (this.zzkzj != zzdfu.UNKNOWN_FORMAT.zzbkq()) {
                zzedwVar.zzu(3, this.zzkzj);
            }
        }

        @Override // com.google.android.gms.internal.zzeey
        public final int zzbjo() {
            int i = this.zzmys;
            if (i == -1) {
                i = 0;
                if (this.zzkzh != null) {
                    i = zzedw.zzb(1, this.zzkzh == null ? zzd.zzblg() : this.zzkzh) + 0;
                }
                if (this.zzkzi != null) {
                    i += zzedw.zzb(2, this.zzkzi == null ? zza.zzbks() : this.zzkzi);
                }
                if (this.zzkzj != zzdfu.UNKNOWN_FORMAT.zzbkq()) {
                    i += zzedw.zzw(3, this.zzkzj);
                }
                this.zzmys = i;
            }
            return i;
        }

        public final zzd zzbku() {
            return this.zzkzh == null ? zzd.zzblg() : this.zzkzh;
        }

        public final zza zzbkv() {
            return this.zzkzi == null ? zza.zzbks() : this.zzkzi;
        }

        public final zzdfu zzbkw() {
            zzdfu zzfb = zzdfu.zzfb(this.zzkzj);
            return zzfb == null ? zzdfu.UNRECOGNIZED : zzfb;
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzc extends zzeed<zzc, zza> implements zzefa {
        private static volatile zzefc<zzc> zzkxq;
        private static final zzc zzkzo;
        private int zzkxm;
        private zzb zzkzl;
        private zzedk zzkzm = zzedk.zzmxr;
        private zzedk zzkzn = zzedk.zzmxr;

        /* loaded from: classes2.dex */
        public static final class zza extends zzeee<zzc, zza> implements zzefa {
            private zza() {
                super(zzc.zzkzo);
            }

            /* synthetic */ zza(zzdgd zzdgdVar) {
                this();
            }
        }

        static {
            zzc zzcVar = new zzc();
            zzkzo = zzcVar;
            zzcVar.zza(zzeel.zzmzd, (Object) null, (Object) null);
            zzcVar.zzmyr.zzbhq();
        }

        private zzc() {
        }

        public static zzc zzm(zzedk zzedkVar) throws zzeer {
            return (zzc) zzeed.zza(zzkzo, zzedkVar);
        }

        public final int getVersion() {
            return this.zzkxm;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.android.gms.internal.zzeed
        public final Object zza(int i, Object obj, Object obj2) {
            zzb.zza zzaVar;
            switch (zzdgd.zzkxl[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return zzkzo;
                case 3:
                    return null;
                case 4:
                    return new zza(null);
                case 5:
                    zzeem zzeemVar = (zzeem) obj;
                    zzc zzcVar = (zzc) obj2;
                    this.zzkxm = zzeemVar.zza(this.zzkxm != 0, this.zzkxm, zzcVar.zzkxm != 0, zzcVar.zzkxm);
                    this.zzkzl = (zzb) zzeemVar.zza(this.zzkzl, zzcVar.zzkzl);
                    this.zzkzm = zzeemVar.zza(this.zzkzm != zzedk.zzmxr, this.zzkzm, zzcVar.zzkzm != zzedk.zzmxr, zzcVar.zzkzm);
                    this.zzkzn = zzeemVar.zza(this.zzkzn != zzedk.zzmxr, this.zzkzn, zzcVar.zzkzn != zzedk.zzmxr, zzcVar.zzkzn);
                    return this;
                case 6:
                    zzedt zzedtVar = (zzedt) obj;
                    zzedz zzedzVar = (zzedz) obj2;
                    boolean z = false;
                    while (!z) {
                        try {
                            int zzcbr = zzedtVar.zzcbr();
                            switch (zzcbr) {
                                case 0:
                                    z = true;
                                    break;
                                case 8:
                                    this.zzkxm = zzedtVar.zzcbs();
                                    break;
                                case 18:
                                    if (this.zzkzl != null) {
                                        zzb zzbVar = this.zzkzl;
                                        zzeee zzeeeVar = (zzeee) zzbVar.zza(zzeel.zzmzf, (Object) null, (Object) null);
                                        zzeeeVar.zza((zzeee) zzbVar);
                                        zzaVar = (zzb.zza) zzeeeVar;
                                    } else {
                                        zzaVar = null;
                                    }
                                    this.zzkzl = (zzb) zzedtVar.zza(zzb.zzbkx(), zzedzVar);
                                    if (zzaVar == null) {
                                        break;
                                    } else {
                                        zzaVar.zza((zzb.zza) this.zzkzl);
                                        this.zzkzl = (zzb) zzaVar.zzccq();
                                        break;
                                    }
                                case 26:
                                    this.zzkzm = zzedtVar.zzcbu();
                                    break;
                                case 34:
                                    this.zzkzn = zzedtVar.zzcbu();
                                    break;
                                default:
                                    if (!zzedtVar.zzgl(zzcbr)) {
                                        z = true;
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        } catch (zzeer e) {
                            throw new RuntimeException(e.zze(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new zzeer(e2.getMessage()).zze(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (zzkxq == null) {
                        synchronized (zzc.class) {
                            if (zzkxq == null) {
                                zzkxq = new zzeef(zzkzo);
                            }
                        }
                    }
                    return zzkxq;
                default:
                    throw new UnsupportedOperationException();
            }
            return zzkzo;
        }

        @Override // com.google.android.gms.internal.zzeey
        public final void zza(zzedw zzedwVar) throws IOException {
            if (this.zzkxm != 0) {
                zzedwVar.zzu(1, this.zzkxm);
            }
            if (this.zzkzl != null) {
                zzedwVar.zza(2, this.zzkzl == null ? zzb.zzbkx() : this.zzkzl);
            }
            if (!this.zzkzm.isEmpty()) {
                zzedwVar.zza(3, this.zzkzm);
            }
            if (this.zzkzn.isEmpty()) {
                return;
            }
            zzedwVar.zza(4, this.zzkzn);
        }

        @Override // com.google.android.gms.internal.zzeey
        public final int zzbjo() {
            int i = this.zzmys;
            if (i == -1) {
                i = this.zzkxm != 0 ? zzedw.zzv(1, this.zzkxm) + 0 : 0;
                if (this.zzkzl != null) {
                    i += zzedw.zzb(2, this.zzkzl == null ? zzb.zzbkx() : this.zzkzl);
                }
                if (!this.zzkzm.isEmpty()) {
                    i += zzedw.zzb(3, this.zzkzm);
                }
                if (!this.zzkzn.isEmpty()) {
                    i += zzedw.zzb(4, this.zzkzn);
                }
                this.zzmys = i;
            }
            return i;
        }

        public final zzb zzbkz() {
            return this.zzkzl == null ? zzb.zzbkx() : this.zzkzl;
        }

        public final zzedk zzbla() {
            return this.zzkzm;
        }

        public final zzedk zzblb() {
            return this.zzkzn;
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzd extends zzeed<zzd, zza> implements zzefa {
        private static volatile zzefc<zzd> zzkxq;
        private static final zzd zzkzs;
        private int zzkzp;
        private int zzkzq;
        private zzedk zzkzr = zzedk.zzmxr;

        /* loaded from: classes2.dex */
        public static final class zza extends zzeee<zzd, zza> implements zzefa {
            private zza() {
                super(zzd.zzkzs);
            }

            /* synthetic */ zza(zzdgd zzdgdVar) {
                this();
            }
        }

        static {
            zzd zzdVar = new zzd();
            zzkzs = zzdVar;
            zzdVar.zza(zzeel.zzmzd, (Object) null, (Object) null);
            zzdVar.zzmyr.zzbhq();
        }

        private zzd() {
        }

        public static zzd zzblg() {
            return zzkzs;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.android.gms.internal.zzeed
        public final Object zza(int i, Object obj, Object obj2) {
            boolean z = false;
            switch (zzdgd.zzkxl[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return zzkzs;
                case 3:
                    return null;
                case 4:
                    return new zza(null);
                case 5:
                    zzeem zzeemVar = (zzeem) obj;
                    zzd zzdVar = (zzd) obj2;
                    this.zzkzp = zzeemVar.zza(this.zzkzp != 0, this.zzkzp, zzdVar.zzkzp != 0, zzdVar.zzkzp);
                    this.zzkzq = zzeemVar.zza(this.zzkzq != 0, this.zzkzq, zzdVar.zzkzq != 0, zzdVar.zzkzq);
                    this.zzkzr = zzeemVar.zza(this.zzkzr != zzedk.zzmxr, this.zzkzr, zzdVar.zzkzr != zzedk.zzmxr, zzdVar.zzkzr);
                    return this;
                case 6:
                    zzedt zzedtVar = (zzedt) obj;
                    while (!z) {
                        try {
                            int zzcbr = zzedtVar.zzcbr();
                            switch (zzcbr) {
                                case 0:
                                    z = true;
                                    break;
                                case 8:
                                    this.zzkzp = zzedtVar.zzcbv();
                                    break;
                                case 16:
                                    this.zzkzq = zzedtVar.zzcbv();
                                    break;
                                case 90:
                                    this.zzkzr = zzedtVar.zzcbu();
                                    break;
                                default:
                                    if (!zzedtVar.zzgl(zzcbr)) {
                                        z = true;
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        } catch (zzeer e) {
                            throw new RuntimeException(e.zze(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new zzeer(e2.getMessage()).zze(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (zzkxq == null) {
                        synchronized (zzd.class) {
                            if (zzkxq == null) {
                                zzkxq = new zzeef(zzkzs);
                            }
                        }
                    }
                    return zzkxq;
                default:
                    throw new UnsupportedOperationException();
            }
            return zzkzs;
        }

        @Override // com.google.android.gms.internal.zzeey
        public final void zza(zzedw zzedwVar) throws IOException {
            if (this.zzkzp != zzdfw.UNKNOWN_CURVE.zzbkq()) {
                zzedwVar.zzu(1, this.zzkzp);
            }
            if (this.zzkzq != zzdfy.UNKNOWN_HASH.zzbkq()) {
                zzedwVar.zzu(2, this.zzkzq);
            }
            if (this.zzkzr.isEmpty()) {
                return;
            }
            zzedwVar.zza(11, this.zzkzr);
        }

        @Override // com.google.android.gms.internal.zzeey
        public final int zzbjo() {
            int i = this.zzmys;
            if (i == -1) {
                i = this.zzkzp != zzdfw.UNKNOWN_CURVE.zzbkq() ? zzedw.zzw(1, this.zzkzp) + 0 : 0;
                if (this.zzkzq != zzdfy.UNKNOWN_HASH.zzbkq()) {
                    i += zzedw.zzw(2, this.zzkzq);
                }
                if (!this.zzkzr.isEmpty()) {
                    i += zzedw.zzb(11, this.zzkzr);
                }
                this.zzmys = i;
            }
            return i;
        }

        public final zzdfw zzbld() {
            zzdfw zzfc = zzdfw.zzfc(this.zzkzp);
            return zzfc == null ? zzdfw.UNRECOGNIZED : zzfc;
        }

        public final zzdfy zzble() {
            zzdfy zzfd = zzdfy.zzfd(this.zzkzq);
            return zzfd == null ? zzdfy.UNRECOGNIZED : zzfd;
        }

        public final zzedk zzblf() {
            return this.zzkzr;
        }
    }
}

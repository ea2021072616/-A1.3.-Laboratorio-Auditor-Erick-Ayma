package com.google.android.gms.internal;

import java.io.IOException;
/* loaded from: classes2.dex */
public final class zzdge {

    /* loaded from: classes2.dex */
    public static final class zza extends zzeed<zza, C0082zza> implements zzefa {
        private static volatile zzefc<zza> zzkxq;
        private static final zza zzkzu;
        private int zzkxm;
        private zzedk zzkxv = zzedk.zzmxr;
        private zzc zzkzt;

        /* renamed from: com.google.android.gms.internal.zzdge$zza$zza  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0082zza extends zzeee<zza, C0082zza> implements zzefa {
            private C0082zza() {
                super(zza.zzkzu);
            }

            /* synthetic */ C0082zza(zzdgf zzdgfVar) {
                this();
            }

            public final C0082zza zzb(zzc zzcVar) {
                zzccp();
                ((zza) this.zzmyu).zza(zzcVar);
                return this;
            }

            public final C0082zza zzfe(int i) {
                zzccp();
                ((zza) this.zzmyu).setVersion(0);
                return this;
            }

            public final C0082zza zzo(zzedk zzedkVar) {
                zzccp();
                ((zza) this.zzmyu).zzc(zzedkVar);
                return this;
            }
        }

        static {
            zza zzaVar = new zza();
            zzkzu = zzaVar;
            zzaVar.zza(zzeel.zzmzd, (Object) null, (Object) null);
            zzaVar.zzmyr.zzbhq();
        }

        private zza() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setVersion(int i) {
            this.zzkxm = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzc zzcVar) {
            if (zzcVar == null) {
                throw new NullPointerException();
            }
            this.zzkzt = zzcVar;
        }

        public static C0082zza zzblj() {
            zza zzaVar = zzkzu;
            zzeee zzeeeVar = (zzeee) zzaVar.zza(zzeel.zzmzf, (Object) null, (Object) null);
            zzeeeVar.zza((zzeee) zzaVar);
            return (C0082zza) zzeeeVar;
        }

        public static zza zzblk() {
            return zzkzu;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(zzedk zzedkVar) {
            if (zzedkVar == null) {
                throw new NullPointerException();
            }
            this.zzkxv = zzedkVar;
        }

        public static zza zzn(zzedk zzedkVar) throws zzeer {
            return (zza) zzeed.zza(zzkzu, zzedkVar);
        }

        public final int getVersion() {
            return this.zzkxm;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.android.gms.internal.zzeed
        public final Object zza(int i, Object obj, Object obj2) {
            zzc.zza zzaVar;
            switch (zzdgf.zzkxl[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return zzkzu;
                case 3:
                    return null;
                case 4:
                    return new C0082zza(null);
                case 5:
                    zzeem zzeemVar = (zzeem) obj;
                    zza zzaVar2 = (zza) obj2;
                    this.zzkxm = zzeemVar.zza(this.zzkxm != 0, this.zzkxm, zzaVar2.zzkxm != 0, zzaVar2.zzkxm);
                    this.zzkzt = (zzc) zzeemVar.zza(this.zzkzt, zzaVar2.zzkzt);
                    this.zzkxv = zzeemVar.zza(this.zzkxv != zzedk.zzmxr, this.zzkxv, zzaVar2.zzkxv != zzedk.zzmxr, zzaVar2.zzkxv);
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
                                    if (this.zzkzt != null) {
                                        zzc zzcVar = this.zzkzt;
                                        zzeee zzeeeVar = (zzeee) zzcVar.zza(zzeel.zzmzf, (Object) null, (Object) null);
                                        zzeeeVar.zza((zzeee) zzcVar);
                                        zzaVar = (zzc.zza) zzeeeVar;
                                    } else {
                                        zzaVar = null;
                                    }
                                    this.zzkzt = (zzc) zzedtVar.zza(zzc.zzblq(), zzedzVar);
                                    if (zzaVar == null) {
                                        break;
                                    } else {
                                        zzaVar.zza((zzc.zza) this.zzkzt);
                                        this.zzkzt = (zzc) zzaVar.zzccq();
                                        break;
                                    }
                                case 26:
                                    this.zzkxv = zzedtVar.zzcbu();
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
                        synchronized (zza.class) {
                            if (zzkxq == null) {
                                zzkxq = new zzeef(zzkzu);
                            }
                        }
                    }
                    return zzkxq;
                default:
                    throw new UnsupportedOperationException();
            }
            return zzkzu;
        }

        @Override // com.google.android.gms.internal.zzeey
        public final void zza(zzedw zzedwVar) throws IOException {
            if (this.zzkxm != 0) {
                zzedwVar.zzu(1, this.zzkxm);
            }
            if (this.zzkzt != null) {
                zzedwVar.zza(2, this.zzkzt == null ? zzc.zzblq() : this.zzkzt);
            }
            if (this.zzkxv.isEmpty()) {
                return;
            }
            zzedwVar.zza(3, this.zzkxv);
        }

        @Override // com.google.android.gms.internal.zzeey
        public final int zzbjo() {
            int i = this.zzmys;
            if (i == -1) {
                i = this.zzkxm != 0 ? zzedw.zzv(1, this.zzkxm) + 0 : 0;
                if (this.zzkzt != null) {
                    i += zzedw.zzb(2, this.zzkzt == null ? zzc.zzblq() : this.zzkzt);
                }
                if (!this.zzkxv.isEmpty()) {
                    i += zzedw.zzb(3, this.zzkxv);
                }
                this.zzmys = i;
            }
            return i;
        }

        public final zzedk zzbjv() {
            return this.zzkxv;
        }

        public final zzc zzbli() {
            return this.zzkzt == null ? zzc.zzblq() : this.zzkzt;
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzb extends zzeed<zzb, zza> implements zzefa {
        private static volatile zzefc<zzb> zzkxq;
        private static final zzb zzkzv;
        private int zzkxx;
        private zzc zzkzt;

        /* loaded from: classes2.dex */
        public static final class zza extends zzeee<zzb, zza> implements zzefa {
            private zza() {
                super(zzb.zzkzv);
            }

            /* synthetic */ zza(zzdgf zzdgfVar) {
                this();
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzkzv = zzbVar;
            zzbVar.zza(zzeel.zzmzd, (Object) null, (Object) null);
            zzbVar.zzmyr.zzbhq();
        }

        private zzb() {
        }

        public static zzb zzblm() {
            return zzkzv;
        }

        public static zzb zzp(zzedk zzedkVar) throws zzeer {
            return (zzb) zzeed.zza(zzkzv, zzedkVar);
        }

        public final int getKeySize() {
            return this.zzkxx;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.android.gms.internal.zzeed
        public final Object zza(int i, Object obj, Object obj2) {
            zzc.zza zzaVar;
            switch (zzdgf.zzkxl[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return zzkzv;
                case 3:
                    return null;
                case 4:
                    return new zza(null);
                case 5:
                    zzeem zzeemVar = (zzeem) obj;
                    zzb zzbVar = (zzb) obj2;
                    this.zzkzt = (zzc) zzeemVar.zza(this.zzkzt, zzbVar.zzkzt);
                    this.zzkxx = zzeemVar.zza(this.zzkxx != 0, this.zzkxx, zzbVar.zzkxx != 0, zzbVar.zzkxx);
                    return this;
                case 6:
                    zzedt zzedtVar = (zzedt) obj;
                    zzedz zzedzVar = (zzedz) obj2;
                    boolean z = false;
                    while (!z) {
                        try {
                            try {
                                int zzcbr = zzedtVar.zzcbr();
                                switch (zzcbr) {
                                    case 0:
                                        z = true;
                                        break;
                                    case 10:
                                        if (this.zzkzt != null) {
                                            zzc zzcVar = this.zzkzt;
                                            zzeee zzeeeVar = (zzeee) zzcVar.zza(zzeel.zzmzf, (Object) null, (Object) null);
                                            zzeeeVar.zza((zzeee) zzcVar);
                                            zzaVar = (zzc.zza) zzeeeVar;
                                        } else {
                                            zzaVar = null;
                                        }
                                        this.zzkzt = (zzc) zzedtVar.zza(zzc.zzblq(), zzedzVar);
                                        if (zzaVar == null) {
                                            break;
                                        } else {
                                            zzaVar.zza((zzc.zza) this.zzkzt);
                                            this.zzkzt = (zzc) zzaVar.zzccq();
                                            break;
                                        }
                                    case 16:
                                        this.zzkxx = zzedtVar.zzcbs();
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
                            }
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
                                zzkxq = new zzeef(zzkzv);
                            }
                        }
                    }
                    return zzkxq;
                default:
                    throw new UnsupportedOperationException();
            }
            return zzkzv;
        }

        @Override // com.google.android.gms.internal.zzeey
        public final void zza(zzedw zzedwVar) throws IOException {
            if (this.zzkzt != null) {
                zzedwVar.zza(1, this.zzkzt == null ? zzc.zzblq() : this.zzkzt);
            }
            if (this.zzkxx != 0) {
                zzedwVar.zzu(2, this.zzkxx);
            }
        }

        @Override // com.google.android.gms.internal.zzeey
        public final int zzbjo() {
            int i = this.zzmys;
            if (i == -1) {
                i = 0;
                if (this.zzkzt != null) {
                    i = zzedw.zzb(1, this.zzkzt == null ? zzc.zzblq() : this.zzkzt) + 0;
                }
                if (this.zzkxx != 0) {
                    i += zzedw.zzv(2, this.zzkxx);
                }
                this.zzmys = i;
            }
            return i;
        }

        public final zzc zzbli() {
            return this.zzkzt == null ? zzc.zzblq() : this.zzkzt;
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzc extends zzeed<zzc, zza> implements zzefa {
        private static volatile zzefc<zzc> zzkxq;
        private static final zzc zzkzy;
        private int zzkzw;
        private int zzkzx;

        /* loaded from: classes2.dex */
        public static final class zza extends zzeee<zzc, zza> implements zzefa {
            private zza() {
                super(zzc.zzkzy);
            }

            /* synthetic */ zza(zzdgf zzdgfVar) {
                this();
            }
        }

        static {
            zzc zzcVar = new zzc();
            zzkzy = zzcVar;
            zzcVar.zza(zzeel.zzmzd, (Object) null, (Object) null);
            zzcVar.zzmyr.zzbhq();
        }

        private zzc() {
        }

        public static zzc zzblq() {
            return zzkzy;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.android.gms.internal.zzeed
        public final Object zza(int i, Object obj, Object obj2) {
            boolean z = false;
            switch (zzdgf.zzkxl[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return zzkzy;
                case 3:
                    return null;
                case 4:
                    return new zza(null);
                case 5:
                    zzeem zzeemVar = (zzeem) obj;
                    zzc zzcVar = (zzc) obj2;
                    this.zzkzw = zzeemVar.zza(this.zzkzw != 0, this.zzkzw, zzcVar.zzkzw != 0, zzcVar.zzkzw);
                    this.zzkzx = zzeemVar.zza(this.zzkzx != 0, this.zzkzx, zzcVar.zzkzx != 0, zzcVar.zzkzx);
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
                                    this.zzkzw = zzedtVar.zzcbv();
                                    break;
                                case 16:
                                    this.zzkzx = zzedtVar.zzcbs();
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
                                zzkxq = new zzeef(zzkzy);
                            }
                        }
                    }
                    return zzkxq;
                default:
                    throw new UnsupportedOperationException();
            }
            return zzkzy;
        }

        @Override // com.google.android.gms.internal.zzeey
        public final void zza(zzedw zzedwVar) throws IOException {
            if (this.zzkzw != zzdfy.UNKNOWN_HASH.zzbkq()) {
                zzedwVar.zzu(1, this.zzkzw);
            }
            if (this.zzkzx != 0) {
                zzedwVar.zzu(2, this.zzkzx);
            }
        }

        @Override // com.google.android.gms.internal.zzeey
        public final int zzbjo() {
            int i = this.zzmys;
            if (i == -1) {
                i = this.zzkzw != zzdfy.UNKNOWN_HASH.zzbkq() ? zzedw.zzw(1, this.zzkzw) + 0 : 0;
                if (this.zzkzx != 0) {
                    i += zzedw.zzv(2, this.zzkzx);
                }
                this.zzmys = i;
            }
            return i;
        }

        public final zzdfy zzblo() {
            zzdfy zzfd = zzdfy.zzfd(this.zzkzw);
            return zzfd == null ? zzdfy.UNRECOGNIZED : zzfd;
        }

        public final int zzblp() {
            return this.zzkzx;
        }
    }
}

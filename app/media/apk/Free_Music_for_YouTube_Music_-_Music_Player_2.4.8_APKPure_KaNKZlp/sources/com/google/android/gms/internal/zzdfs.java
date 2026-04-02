package com.google.android.gms.internal;

import java.io.IOException;
/* loaded from: classes2.dex */
public final class zzdfs {

    /* loaded from: classes2.dex */
    public static final class zza extends zzeed<zza, C0080zza> implements zzefa {
        private static volatile zzefc<zza> zzkxq;
        private static final zza zzkyg;
        private int zzkxm;
        private zzedk zzkxv = zzedk.zzmxr;
        private zzc zzkyf;

        /* renamed from: com.google.android.gms.internal.zzdfs$zza$zza  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0080zza extends zzeee<zza, C0080zza> implements zzefa {
            private C0080zza() {
                super(zza.zzkyg);
            }

            /* synthetic */ C0080zza(zzdft zzdftVar) {
                this();
            }

            public final C0080zza zzb(zzc zzcVar) {
                zzccp();
                ((zza) this.zzmyu).zza(zzcVar);
                return this;
            }

            public final C0080zza zzfa(int i) {
                zzccp();
                ((zza) this.zzmyu).setVersion(0);
                return this;
            }

            public final C0080zza zzk(zzedk zzedkVar) {
                zzccp();
                ((zza) this.zzmyu).zzc(zzedkVar);
                return this;
            }
        }

        static {
            zza zzaVar = new zza();
            zzkyg = zzaVar;
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
            this.zzkyf = zzcVar;
        }

        public static C0080zza zzbkk() {
            zza zzaVar = zzkyg;
            zzeee zzeeeVar = (zzeee) zzaVar.zza(zzeel.zzmzf, (Object) null, (Object) null);
            zzeeeVar.zza((zzeee) zzaVar);
            return (C0080zza) zzeeeVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(zzedk zzedkVar) {
            if (zzedkVar == null) {
                throw new NullPointerException();
            }
            this.zzkxv = zzedkVar;
        }

        public static zza zzj(zzedk zzedkVar) throws zzeer {
            return (zza) zzeed.zza(zzkyg, zzedkVar);
        }

        public final int getVersion() {
            return this.zzkxm;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.android.gms.internal.zzeed
        public final Object zza(int i, Object obj, Object obj2) {
            zzc.zza zzaVar;
            switch (zzdft.zzkxl[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return zzkyg;
                case 3:
                    return null;
                case 4:
                    return new C0080zza(null);
                case 5:
                    zzeem zzeemVar = (zzeem) obj;
                    zza zzaVar2 = (zza) obj2;
                    this.zzkxm = zzeemVar.zza(this.zzkxm != 0, this.zzkxm, zzaVar2.zzkxm != 0, zzaVar2.zzkxm);
                    this.zzkyf = (zzc) zzeemVar.zza(this.zzkyf, zzaVar2.zzkyf);
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
                                    if (this.zzkyf != null) {
                                        zzc zzcVar = this.zzkyf;
                                        zzeee zzeeeVar = (zzeee) zzcVar.zza(zzeel.zzmzf, (Object) null, (Object) null);
                                        zzeeeVar.zza((zzeee) zzcVar);
                                        zzaVar = (zzc.zza) zzeeeVar;
                                    } else {
                                        zzaVar = null;
                                    }
                                    this.zzkyf = (zzc) zzedtVar.zza(zzc.zzbko(), zzedzVar);
                                    if (zzaVar == null) {
                                        break;
                                    } else {
                                        zzaVar.zza((zzc.zza) this.zzkyf);
                                        this.zzkyf = (zzc) zzaVar.zzccq();
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
                                zzkxq = new zzeef(zzkyg);
                            }
                        }
                    }
                    return zzkxq;
                default:
                    throw new UnsupportedOperationException();
            }
            return zzkyg;
        }

        @Override // com.google.android.gms.internal.zzeey
        public final void zza(zzedw zzedwVar) throws IOException {
            if (this.zzkxm != 0) {
                zzedwVar.zzu(1, this.zzkxm);
            }
            if (this.zzkyf != null) {
                zzedwVar.zza(2, this.zzkyf == null ? zzc.zzbko() : this.zzkyf);
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
                if (this.zzkyf != null) {
                    i += zzedw.zzb(2, this.zzkyf == null ? zzc.zzbko() : this.zzkyf);
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
    }

    /* loaded from: classes2.dex */
    public static final class zzb extends zzeed<zzb, zza> implements zzefa {
        private static volatile zzefc<zzb> zzkxq;
        private static final zzb zzkyh;
        private int zzkxx;
        private zzc zzkyf;

        /* loaded from: classes2.dex */
        public static final class zza extends zzeee<zzb, zza> implements zzefa {
            private zza() {
                super(zzb.zzkyh);
            }

            /* synthetic */ zza(zzdft zzdftVar) {
                this();
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzkyh = zzbVar;
            zzbVar.zza(zzeel.zzmzd, (Object) null, (Object) null);
            zzbVar.zzmyr.zzbhq();
        }

        private zzb() {
        }

        public static zzb zzl(zzedk zzedkVar) throws zzeer {
            return (zzb) zzeed.zza(zzkyh, zzedkVar);
        }

        public final int getKeySize() {
            return this.zzkxx;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.android.gms.internal.zzeed
        public final Object zza(int i, Object obj, Object obj2) {
            zzc.zza zzaVar;
            switch (zzdft.zzkxl[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return zzkyh;
                case 3:
                    return null;
                case 4:
                    return new zza(null);
                case 5:
                    zzeem zzeemVar = (zzeem) obj;
                    zzb zzbVar = (zzb) obj2;
                    this.zzkyf = (zzc) zzeemVar.zza(this.zzkyf, zzbVar.zzkyf);
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
                                        if (this.zzkyf != null) {
                                            zzc zzcVar = this.zzkyf;
                                            zzeee zzeeeVar = (zzeee) zzcVar.zza(zzeel.zzmzf, (Object) null, (Object) null);
                                            zzeeeVar.zza((zzeee) zzcVar);
                                            zzaVar = (zzc.zza) zzeeeVar;
                                        } else {
                                            zzaVar = null;
                                        }
                                        this.zzkyf = (zzc) zzedtVar.zza(zzc.zzbko(), zzedzVar);
                                        if (zzaVar == null) {
                                            break;
                                        } else {
                                            zzaVar.zza((zzc.zza) this.zzkyf);
                                            this.zzkyf = (zzc) zzaVar.zzccq();
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
                                zzkxq = new zzeef(zzkyh);
                            }
                        }
                    }
                    return zzkxq;
                default:
                    throw new UnsupportedOperationException();
            }
            return zzkyh;
        }

        @Override // com.google.android.gms.internal.zzeey
        public final void zza(zzedw zzedwVar) throws IOException {
            if (this.zzkyf != null) {
                zzedwVar.zza(1, this.zzkyf == null ? zzc.zzbko() : this.zzkyf);
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
                if (this.zzkyf != null) {
                    i = zzedw.zzb(1, this.zzkyf == null ? zzc.zzbko() : this.zzkyf) + 0;
                }
                if (this.zzkxx != 0) {
                    i += zzedw.zzv(2, this.zzkxx);
                }
                this.zzmys = i;
            }
            return i;
        }

        public final zzc zzbkm() {
            return this.zzkyf == null ? zzc.zzbko() : this.zzkyf;
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzc extends zzeed<zzc, zza> implements zzefa {
        private static volatile zzefc<zzc> zzkxq;
        private static final zzc zzkyi;

        /* loaded from: classes2.dex */
        public static final class zza extends zzeee<zzc, zza> implements zzefa {
            private zza() {
                super(zzc.zzkyi);
            }

            /* synthetic */ zza(zzdft zzdftVar) {
                this();
            }
        }

        static {
            zzc zzcVar = new zzc();
            zzkyi = zzcVar;
            zzcVar.zza(zzeel.zzmzd, (Object) null, (Object) null);
            zzcVar.zzmyr.zzbhq();
        }

        private zzc() {
        }

        public static zzc zzbko() {
            return zzkyi;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.android.gms.internal.zzeed
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzdft.zzkxl[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return zzkyi;
                case 3:
                    return null;
                case 4:
                    return new zza(null);
                case 5:
                    return this;
                case 6:
                    zzedt zzedtVar = (zzedt) obj;
                    boolean z = false;
                    while (!z) {
                        try {
                            try {
                                int zzcbr = zzedtVar.zzcbr();
                                switch (zzcbr) {
                                    case 0:
                                        z = true;
                                        break;
                                    default:
                                        if (!zzedtVar.zzgl(zzcbr)) {
                                            z = true;
                                            break;
                                        } else {
                                            break;
                                        }
                                }
                            } catch (IOException e) {
                                throw new RuntimeException(new zzeer(e.getMessage()).zze(this));
                            }
                        } catch (zzeer e2) {
                            throw new RuntimeException(e2.zze(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (zzkxq == null) {
                        synchronized (zzc.class) {
                            if (zzkxq == null) {
                                zzkxq = new zzeef(zzkyi);
                            }
                        }
                    }
                    return zzkxq;
                default:
                    throw new UnsupportedOperationException();
            }
            return zzkyi;
        }

        @Override // com.google.android.gms.internal.zzeey
        public final void zza(zzedw zzedwVar) throws IOException {
        }

        @Override // com.google.android.gms.internal.zzeey
        public final int zzbjo() {
            int i = this.zzmys;
            if (i != -1) {
                return i;
            }
            this.zzmys = 0;
            return 0;
        }
    }
}

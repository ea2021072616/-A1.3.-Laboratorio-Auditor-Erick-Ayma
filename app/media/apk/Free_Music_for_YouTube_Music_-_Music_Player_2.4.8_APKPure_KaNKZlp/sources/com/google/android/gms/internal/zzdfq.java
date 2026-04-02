package com.google.android.gms.internal;

import java.io.IOException;
/* loaded from: classes2.dex */
public final class zzdfq {

    /* loaded from: classes2.dex */
    public static final class zza extends zzeed<zza, C0079zza> implements zzefa {
        private static volatile zzefc<zza> zzkxq;
        private static final zza zzkyc;
        private int zzkxm;
        private zzedk zzkxv = zzedk.zzmxr;
        private zzc zzkyb;

        /* renamed from: com.google.android.gms.internal.zzdfq$zza$zza  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0079zza extends zzeee<zza, C0079zza> implements zzefa {
            private C0079zza() {
                super(zza.zzkyc);
            }

            /* synthetic */ C0079zza(zzdfr zzdfrVar) {
                this();
            }

            public final C0079zza zzb(zzc zzcVar) {
                zzccp();
                ((zza) this.zzmyu).zza(zzcVar);
                return this;
            }

            public final C0079zza zzez(int i) {
                zzccp();
                ((zza) this.zzmyu).setVersion(0);
                return this;
            }

            public final C0079zza zzh(zzedk zzedkVar) {
                zzccp();
                ((zza) this.zzmyu).zzc(zzedkVar);
                return this;
            }
        }

        static {
            zza zzaVar = new zza();
            zzkyc = zzaVar;
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
            this.zzkyb = zzcVar;
        }

        public static C0079zza zzbkf() {
            zza zzaVar = zzkyc;
            zzeee zzeeeVar = (zzeee) zzaVar.zza(zzeel.zzmzf, (Object) null, (Object) null);
            zzeeeVar.zza((zzeee) zzaVar);
            return (C0079zza) zzeeeVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(zzedk zzedkVar) {
            if (zzedkVar == null) {
                throw new NullPointerException();
            }
            this.zzkxv = zzedkVar;
        }

        public static zza zzg(zzedk zzedkVar) throws zzeer {
            return (zza) zzeed.zza(zzkyc, zzedkVar);
        }

        public final int getVersion() {
            return this.zzkxm;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.android.gms.internal.zzeed
        public final Object zza(int i, Object obj, Object obj2) {
            zzc.zza zzaVar;
            switch (zzdfr.zzkxl[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return zzkyc;
                case 3:
                    return null;
                case 4:
                    return new C0079zza(null);
                case 5:
                    zzeem zzeemVar = (zzeem) obj;
                    zza zzaVar2 = (zza) obj2;
                    this.zzkxm = zzeemVar.zza(this.zzkxm != 0, this.zzkxm, zzaVar2.zzkxm != 0, zzaVar2.zzkxm);
                    this.zzkyb = (zzc) zzeemVar.zza(this.zzkyb, zzaVar2.zzkyb);
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
                                    if (this.zzkyb != null) {
                                        zzc zzcVar = this.zzkyb;
                                        zzeee zzeeeVar = (zzeee) zzcVar.zza(zzeel.zzmzf, (Object) null, (Object) null);
                                        zzeeeVar.zza((zzeee) zzcVar);
                                        zzaVar = (zzc.zza) zzeeeVar;
                                    } else {
                                        zzaVar = null;
                                    }
                                    this.zzkyb = (zzc) zzedtVar.zza(zzc.zzbki(), zzedzVar);
                                    if (zzaVar == null) {
                                        break;
                                    } else {
                                        zzaVar.zza((zzc.zza) this.zzkyb);
                                        this.zzkyb = (zzc) zzaVar.zzccq();
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
                                zzkxq = new zzeef(zzkyc);
                            }
                        }
                    }
                    return zzkxq;
                default:
                    throw new UnsupportedOperationException();
            }
            return zzkyc;
        }

        @Override // com.google.android.gms.internal.zzeey
        public final void zza(zzedw zzedwVar) throws IOException {
            if (this.zzkxm != 0) {
                zzedwVar.zzu(1, this.zzkxm);
            }
            if (this.zzkyb != null) {
                zzedwVar.zza(2, this.zzkyb == null ? zzc.zzbki() : this.zzkyb);
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
                if (this.zzkyb != null) {
                    i += zzedw.zzb(2, this.zzkyb == null ? zzc.zzbki() : this.zzkyb);
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

        public final zzc zzbke() {
            return this.zzkyb == null ? zzc.zzbki() : this.zzkyb;
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzb extends zzeed<zzb, zza> implements zzefa {
        private static volatile zzefc<zzb> zzkxq;
        private static final zzb zzkyd;
        private int zzkxx;
        private zzc zzkyb;

        /* loaded from: classes2.dex */
        public static final class zza extends zzeee<zzb, zza> implements zzefa {
            private zza() {
                super(zzb.zzkyd);
            }

            /* synthetic */ zza(zzdfr zzdfrVar) {
                this();
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzkyd = zzbVar;
            zzbVar.zza(zzeel.zzmzd, (Object) null, (Object) null);
            zzbVar.zzmyr.zzbhq();
        }

        private zzb() {
        }

        public static zzb zzi(zzedk zzedkVar) throws zzeer {
            return (zzb) zzeed.zza(zzkyd, zzedkVar);
        }

        public final int getKeySize() {
            return this.zzkxx;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.android.gms.internal.zzeed
        public final Object zza(int i, Object obj, Object obj2) {
            zzc.zza zzaVar;
            switch (zzdfr.zzkxl[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return zzkyd;
                case 3:
                    return null;
                case 4:
                    return new zza(null);
                case 5:
                    zzeem zzeemVar = (zzeem) obj;
                    zzb zzbVar = (zzb) obj2;
                    this.zzkyb = (zzc) zzeemVar.zza(this.zzkyb, zzbVar.zzkyb);
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
                                        if (this.zzkyb != null) {
                                            zzc zzcVar = this.zzkyb;
                                            zzeee zzeeeVar = (zzeee) zzcVar.zza(zzeel.zzmzf, (Object) null, (Object) null);
                                            zzeeeVar.zza((zzeee) zzcVar);
                                            zzaVar = (zzc.zza) zzeeeVar;
                                        } else {
                                            zzaVar = null;
                                        }
                                        this.zzkyb = (zzc) zzedtVar.zza(zzc.zzbki(), zzedzVar);
                                        if (zzaVar == null) {
                                            break;
                                        } else {
                                            zzaVar.zza((zzc.zza) this.zzkyb);
                                            this.zzkyb = (zzc) zzaVar.zzccq();
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
                                zzkxq = new zzeef(zzkyd);
                            }
                        }
                    }
                    return zzkxq;
                default:
                    throw new UnsupportedOperationException();
            }
            return zzkyd;
        }

        @Override // com.google.android.gms.internal.zzeey
        public final void zza(zzedw zzedwVar) throws IOException {
            if (this.zzkyb != null) {
                zzedwVar.zza(1, this.zzkyb == null ? zzc.zzbki() : this.zzkyb);
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
                if (this.zzkyb != null) {
                    i = zzedw.zzb(1, this.zzkyb == null ? zzc.zzbki() : this.zzkyb) + 0;
                }
                if (this.zzkxx != 0) {
                    i += zzedw.zzv(2, this.zzkxx);
                }
                this.zzmys = i;
            }
            return i;
        }

        public final zzc zzbke() {
            return this.zzkyb == null ? zzc.zzbki() : this.zzkyb;
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzc extends zzeed<zzc, zza> implements zzefa {
        private static volatile zzefc<zzc> zzkxq;
        private static final zzc zzkye;
        private int zzkxz;

        /* loaded from: classes2.dex */
        public static final class zza extends zzeee<zzc, zza> implements zzefa {
            private zza() {
                super(zzc.zzkye);
            }

            /* synthetic */ zza(zzdfr zzdfrVar) {
                this();
            }
        }

        static {
            zzc zzcVar = new zzc();
            zzkye = zzcVar;
            zzcVar.zza(zzeel.zzmzd, (Object) null, (Object) null);
            zzcVar.zzmyr.zzbhq();
        }

        private zzc() {
        }

        public static zzc zzbki() {
            return zzkye;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.android.gms.internal.zzeed
        public final Object zza(int i, Object obj, Object obj2) {
            boolean z = false;
            switch (zzdfr.zzkxl[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return zzkye;
                case 3:
                    return null;
                case 4:
                    return new zza(null);
                case 5:
                    zzc zzcVar = (zzc) obj2;
                    this.zzkxz = ((zzeem) obj).zza(this.zzkxz != 0, this.zzkxz, zzcVar.zzkxz != 0, zzcVar.zzkxz);
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
                                    this.zzkxz = zzedtVar.zzcbs();
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
                                zzkxq = new zzeef(zzkye);
                            }
                        }
                    }
                    return zzkxq;
                default:
                    throw new UnsupportedOperationException();
            }
            return zzkye;
        }

        @Override // com.google.android.gms.internal.zzeey
        public final void zza(zzedw zzedwVar) throws IOException {
            if (this.zzkxz != 0) {
                zzedwVar.zzu(1, this.zzkxz);
            }
        }

        @Override // com.google.android.gms.internal.zzeey
        public final int zzbjo() {
            int i = this.zzmys;
            if (i == -1) {
                i = this.zzkxz != 0 ? zzedw.zzv(1, this.zzkxz) + 0 : 0;
                this.zzmys = i;
            }
            return i;
        }

        public final int zzbkb() {
            return this.zzkxz;
        }
    }
}

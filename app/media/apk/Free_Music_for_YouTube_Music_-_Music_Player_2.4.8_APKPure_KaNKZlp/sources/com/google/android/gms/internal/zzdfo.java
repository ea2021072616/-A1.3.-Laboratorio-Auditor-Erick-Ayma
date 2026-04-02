package com.google.android.gms.internal;

import java.io.IOException;
/* loaded from: classes2.dex */
public final class zzdfo {

    /* loaded from: classes2.dex */
    public static final class zza extends zzeed<zza, C0078zza> implements zzefa {
        private static volatile zzefc<zza> zzkxq;
        private static final zza zzkxw;
        private int zzkxm;
        private zzc zzkxu;
        private zzedk zzkxv = zzedk.zzmxr;

        /* renamed from: com.google.android.gms.internal.zzdfo$zza$zza  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0078zza extends zzeee<zza, C0078zza> implements zzefa {
            private C0078zza() {
                super(zza.zzkxw);
            }

            /* synthetic */ C0078zza(zzdfp zzdfpVar) {
                this();
            }

            public final C0078zza zzb(zzc zzcVar) {
                zzccp();
                ((zza) this.zzmyu).zza(zzcVar);
                return this;
            }

            public final C0078zza zze(zzedk zzedkVar) {
                zzccp();
                ((zza) this.zzmyu).zzc(zzedkVar);
                return this;
            }

            public final C0078zza zzey(int i) {
                zzccp();
                ((zza) this.zzmyu).setVersion(0);
                return this;
            }
        }

        static {
            zza zzaVar = new zza();
            zzkxw = zzaVar;
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
            this.zzkxu = zzcVar;
        }

        public static C0078zza zzbjw() {
            zza zzaVar = zzkxw;
            zzeee zzeeeVar = (zzeee) zzaVar.zza(zzeel.zzmzf, (Object) null, (Object) null);
            zzeeeVar.zza((zzeee) zzaVar);
            return (C0078zza) zzeeeVar;
        }

        public static zza zzbjx() {
            return zzkxw;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(zzedk zzedkVar) {
            if (zzedkVar == null) {
                throw new NullPointerException();
            }
            this.zzkxv = zzedkVar;
        }

        public static zza zzd(zzedk zzedkVar) throws zzeer {
            return (zza) zzeed.zza(zzkxw, zzedkVar);
        }

        public final int getVersion() {
            return this.zzkxm;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.android.gms.internal.zzeed
        public final Object zza(int i, Object obj, Object obj2) {
            zzc.zza zzaVar;
            switch (zzdfp.zzkxl[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return zzkxw;
                case 3:
                    return null;
                case 4:
                    return new C0078zza(null);
                case 5:
                    zzeem zzeemVar = (zzeem) obj;
                    zza zzaVar2 = (zza) obj2;
                    this.zzkxm = zzeemVar.zza(this.zzkxm != 0, this.zzkxm, zzaVar2.zzkxm != 0, zzaVar2.zzkxm);
                    this.zzkxu = (zzc) zzeemVar.zza(this.zzkxu, zzaVar2.zzkxu);
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
                                    if (this.zzkxu != null) {
                                        zzc zzcVar = this.zzkxu;
                                        zzeee zzeeeVar = (zzeee) zzcVar.zza(zzeel.zzmzf, (Object) null, (Object) null);
                                        zzeeeVar.zza((zzeee) zzcVar);
                                        zzaVar = (zzc.zza) zzeeeVar;
                                    } else {
                                        zzaVar = null;
                                    }
                                    this.zzkxu = (zzc) zzedtVar.zza(zzc.zzbkc(), zzedzVar);
                                    if (zzaVar == null) {
                                        break;
                                    } else {
                                        zzaVar.zza((zzc.zza) this.zzkxu);
                                        this.zzkxu = (zzc) zzaVar.zzccq();
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
                                zzkxq = new zzeef(zzkxw);
                            }
                        }
                    }
                    return zzkxq;
                default:
                    throw new UnsupportedOperationException();
            }
            return zzkxw;
        }

        @Override // com.google.android.gms.internal.zzeey
        public final void zza(zzedw zzedwVar) throws IOException {
            if (this.zzkxm != 0) {
                zzedwVar.zzu(1, this.zzkxm);
            }
            if (this.zzkxu != null) {
                zzedwVar.zza(2, this.zzkxu == null ? zzc.zzbkc() : this.zzkxu);
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
                if (this.zzkxu != null) {
                    i += zzedw.zzb(2, this.zzkxu == null ? zzc.zzbkc() : this.zzkxu);
                }
                if (!this.zzkxv.isEmpty()) {
                    i += zzedw.zzb(3, this.zzkxv);
                }
                this.zzmys = i;
            }
            return i;
        }

        public final zzc zzbju() {
            return this.zzkxu == null ? zzc.zzbkc() : this.zzkxu;
        }

        public final zzedk zzbjv() {
            return this.zzkxv;
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzb extends zzeed<zzb, zza> implements zzefa {
        private static volatile zzefc<zzb> zzkxq;
        private static final zzb zzkxy;
        private zzc zzkxu;
        private int zzkxx;

        /* loaded from: classes2.dex */
        public static final class zza extends zzeee<zzb, zza> implements zzefa {
            private zza() {
                super(zzb.zzkxy);
            }

            /* synthetic */ zza(zzdfp zzdfpVar) {
                this();
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzkxy = zzbVar;
            zzbVar.zza(zzeel.zzmzd, (Object) null, (Object) null);
            zzbVar.zzmyr.zzbhq();
        }

        private zzb() {
        }

        public static zzb zzbjz() {
            return zzkxy;
        }

        public static zzb zzf(zzedk zzedkVar) throws zzeer {
            return (zzb) zzeed.zza(zzkxy, zzedkVar);
        }

        public final int getKeySize() {
            return this.zzkxx;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.android.gms.internal.zzeed
        public final Object zza(int i, Object obj, Object obj2) {
            zzc.zza zzaVar;
            switch (zzdfp.zzkxl[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return zzkxy;
                case 3:
                    return null;
                case 4:
                    return new zza(null);
                case 5:
                    zzeem zzeemVar = (zzeem) obj;
                    zzb zzbVar = (zzb) obj2;
                    this.zzkxu = (zzc) zzeemVar.zza(this.zzkxu, zzbVar.zzkxu);
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
                                        if (this.zzkxu != null) {
                                            zzc zzcVar = this.zzkxu;
                                            zzeee zzeeeVar = (zzeee) zzcVar.zza(zzeel.zzmzf, (Object) null, (Object) null);
                                            zzeeeVar.zza((zzeee) zzcVar);
                                            zzaVar = (zzc.zza) zzeeeVar;
                                        } else {
                                            zzaVar = null;
                                        }
                                        this.zzkxu = (zzc) zzedtVar.zza(zzc.zzbkc(), zzedzVar);
                                        if (zzaVar == null) {
                                            break;
                                        } else {
                                            zzaVar.zza((zzc.zza) this.zzkxu);
                                            this.zzkxu = (zzc) zzaVar.zzccq();
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
                                zzkxq = new zzeef(zzkxy);
                            }
                        }
                    }
                    return zzkxq;
                default:
                    throw new UnsupportedOperationException();
            }
            return zzkxy;
        }

        @Override // com.google.android.gms.internal.zzeey
        public final void zza(zzedw zzedwVar) throws IOException {
            if (this.zzkxu != null) {
                zzedwVar.zza(1, this.zzkxu == null ? zzc.zzbkc() : this.zzkxu);
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
                if (this.zzkxu != null) {
                    i = zzedw.zzb(1, this.zzkxu == null ? zzc.zzbkc() : this.zzkxu) + 0;
                }
                if (this.zzkxx != 0) {
                    i += zzedw.zzv(2, this.zzkxx);
                }
                this.zzmys = i;
            }
            return i;
        }

        public final zzc zzbju() {
            return this.zzkxu == null ? zzc.zzbkc() : this.zzkxu;
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzc extends zzeed<zzc, zza> implements zzefa {
        private static volatile zzefc<zzc> zzkxq;
        private static final zzc zzkya;
        private int zzkxz;

        /* loaded from: classes2.dex */
        public static final class zza extends zzeee<zzc, zza> implements zzefa {
            private zza() {
                super(zzc.zzkya);
            }

            /* synthetic */ zza(zzdfp zzdfpVar) {
                this();
            }
        }

        static {
            zzc zzcVar = new zzc();
            zzkya = zzcVar;
            zzcVar.zza(zzeel.zzmzd, (Object) null, (Object) null);
            zzcVar.zzmyr.zzbhq();
        }

        private zzc() {
        }

        public static zzc zzbkc() {
            return zzkya;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.android.gms.internal.zzeed
        public final Object zza(int i, Object obj, Object obj2) {
            boolean z = false;
            switch (zzdfp.zzkxl[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return zzkya;
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
                                zzkxq = new zzeef(zzkya);
                            }
                        }
                    }
                    return zzkxq;
                default:
                    throw new UnsupportedOperationException();
            }
            return zzkya;
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

package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdgq;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class zzdgj {

    /* loaded from: classes2.dex */
    public static final class zza extends zzeed<zza, C0083zza> implements zzefa {
        private static volatile zzefc<zza> zzkxq;
        private static final zza zzlac;
        private int zzkxm;
        private zzc zzlab;

        /* renamed from: com.google.android.gms.internal.zzdgj$zza$zza  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0083zza extends zzeee<zza, C0083zza> implements zzefa {
            private C0083zza() {
                super(zza.zzlac);
            }

            /* synthetic */ C0083zza(zzdgk zzdgkVar) {
                this();
            }

            public final C0083zza zzb(zzc zzcVar) {
                zzccp();
                ((zza) this.zzmyu).zza(zzcVar);
                return this;
            }

            public final C0083zza zzff(int i) {
                zzccp();
                ((zza) this.zzmyu).setVersion(0);
                return this;
            }
        }

        static {
            zza zzaVar = new zza();
            zzlac = zzaVar;
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
            this.zzlab = zzcVar;
        }

        public static C0083zza zzblu() {
            zza zzaVar = zzlac;
            zzeee zzeeeVar = (zzeee) zzaVar.zza(zzeel.zzmzf, (Object) null, (Object) null);
            zzeeeVar.zza((zzeee) zzaVar);
            return (C0083zza) zzeeeVar;
        }

        public static zza zzt(zzedk zzedkVar) throws zzeer {
            return (zza) zzeed.zza(zzlac, zzedkVar);
        }

        public final int getVersion() {
            return this.zzkxm;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.android.gms.internal.zzeed
        public final Object zza(int i, Object obj, Object obj2) {
            zzc.zza zzaVar;
            switch (zzdgk.zzkxl[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return zzlac;
                case 3:
                    return null;
                case 4:
                    return new C0083zza(null);
                case 5:
                    zzeem zzeemVar = (zzeem) obj;
                    zza zzaVar2 = (zza) obj2;
                    this.zzkxm = zzeemVar.zza(this.zzkxm != 0, this.zzkxm, zzaVar2.zzkxm != 0, zzaVar2.zzkxm);
                    this.zzlab = (zzc) zzeemVar.zza(this.zzlab, zzaVar2.zzlab);
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
                                    if (this.zzlab != null) {
                                        zzc zzcVar = this.zzlab;
                                        zzeee zzeeeVar = (zzeee) zzcVar.zza(zzeel.zzmzf, (Object) null, (Object) null);
                                        zzeeeVar.zza((zzeee) zzcVar);
                                        zzaVar = (zzc.zza) zzeeeVar;
                                    } else {
                                        zzaVar = null;
                                    }
                                    this.zzlab = (zzc) zzedtVar.zza(zzc.zzblz(), zzedzVar);
                                    if (zzaVar == null) {
                                        break;
                                    } else {
                                        zzaVar.zza((zzc.zza) this.zzlab);
                                        this.zzlab = (zzc) zzaVar.zzccq();
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
                                zzkxq = new zzeef(zzlac);
                            }
                        }
                    }
                    return zzkxq;
                default:
                    throw new UnsupportedOperationException();
            }
            return zzlac;
        }

        @Override // com.google.android.gms.internal.zzeey
        public final void zza(zzedw zzedwVar) throws IOException {
            if (this.zzkxm != 0) {
                zzedwVar.zzu(1, this.zzkxm);
            }
            if (this.zzlab != null) {
                zzedwVar.zza(2, this.zzlab == null ? zzc.zzblz() : this.zzlab);
            }
        }

        @Override // com.google.android.gms.internal.zzeey
        public final int zzbjo() {
            int i = this.zzmys;
            if (i == -1) {
                i = this.zzkxm != 0 ? zzedw.zzv(1, this.zzkxm) + 0 : 0;
                if (this.zzlab != null) {
                    i += zzedw.zzb(2, this.zzlab == null ? zzc.zzblz() : this.zzlab);
                }
                this.zzmys = i;
            }
            return i;
        }

        public final zzc zzblt() {
            return this.zzlab == null ? zzc.zzblz() : this.zzlab;
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzb extends zzeed<zzb, zza> implements zzefa {
        private static volatile zzefc<zzb> zzkxq;
        private static final zzb zzlad;
        private zzc zzlab;

        /* loaded from: classes2.dex */
        public static final class zza extends zzeee<zzb, zza> implements zzefa {
            private zza() {
                super(zzb.zzlad);
            }

            /* synthetic */ zza(zzdgk zzdgkVar) {
                this();
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzlad = zzbVar;
            zzbVar.zza(zzeel.zzmzd, (Object) null, (Object) null);
            zzbVar.zzmyr.zzbhq();
        }

        private zzb() {
        }

        public static zzb zzu(zzedk zzedkVar) throws zzeer {
            return (zzb) zzeed.zza(zzlad, zzedkVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.android.gms.internal.zzeed
        public final Object zza(int i, Object obj, Object obj2) {
            zzc.zza zzaVar;
            switch (zzdgk.zzkxl[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return zzlad;
                case 3:
                    return null;
                case 4:
                    return new zza(null);
                case 5:
                    this.zzlab = (zzc) ((zzeem) obj).zza(this.zzlab, ((zzb) obj2).zzlab);
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
                                    if (this.zzlab != null) {
                                        zzc zzcVar = this.zzlab;
                                        zzeee zzeeeVar = (zzeee) zzcVar.zza(zzeel.zzmzf, (Object) null, (Object) null);
                                        zzeeeVar.zza((zzeee) zzcVar);
                                        zzaVar = (zzc.zza) zzeeeVar;
                                    } else {
                                        zzaVar = null;
                                    }
                                    this.zzlab = (zzc) zzedtVar.zza(zzc.zzblz(), zzedzVar);
                                    if (zzaVar == null) {
                                        break;
                                    } else {
                                        zzaVar.zza((zzc.zza) this.zzlab);
                                        this.zzlab = (zzc) zzaVar.zzccq();
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
                        synchronized (zzb.class) {
                            if (zzkxq == null) {
                                zzkxq = new zzeef(zzlad);
                            }
                        }
                    }
                    return zzkxq;
                default:
                    throw new UnsupportedOperationException();
            }
            return zzlad;
        }

        @Override // com.google.android.gms.internal.zzeey
        public final void zza(zzedw zzedwVar) throws IOException {
            if (this.zzlab != null) {
                zzedwVar.zza(1, this.zzlab == null ? zzc.zzblz() : this.zzlab);
            }
        }

        @Override // com.google.android.gms.internal.zzeey
        public final int zzbjo() {
            int i = this.zzmys;
            if (i == -1) {
                i = 0;
                if (this.zzlab != null) {
                    i = zzedw.zzb(1, this.zzlab == null ? zzc.zzblz() : this.zzlab) + 0;
                }
                this.zzmys = i;
            }
            return i;
        }

        public final zzc zzblt() {
            return this.zzlab == null ? zzc.zzblz() : this.zzlab;
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzc extends zzeed<zzc, zza> implements zzefa {
        private static volatile zzefc<zzc> zzkxq;
        private static final zzc zzlag;
        private zzdgq.zza zzlae;
        private zzdgq.zzb zzlaf;

        /* loaded from: classes2.dex */
        public static final class zza extends zzeee<zzc, zza> implements zzefa {
            private zza() {
                super(zzc.zzlag);
            }

            /* synthetic */ zza(zzdgk zzdgkVar) {
                this();
            }
        }

        static {
            zzc zzcVar = new zzc();
            zzlag = zzcVar;
            zzcVar.zza(zzeel.zzmzd, (Object) null, (Object) null);
            zzcVar.zzmyr.zzbhq();
        }

        private zzc() {
        }

        public static zzc zzblz() {
            return zzlag;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.android.gms.internal.zzeed
        public final Object zza(int i, Object obj, Object obj2) {
            zzdgq.zzb.zza zzaVar;
            zzdgq.zza.C0084zza c0084zza;
            switch (zzdgk.zzkxl[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return zzlag;
                case 3:
                    return null;
                case 4:
                    return new zza(null);
                case 5:
                    zzeem zzeemVar = (zzeem) obj;
                    zzc zzcVar = (zzc) obj2;
                    this.zzlae = (zzdgq.zza) zzeemVar.zza(this.zzlae, zzcVar.zzlae);
                    this.zzlaf = (zzdgq.zzb) zzeemVar.zza(this.zzlaf, zzcVar.zzlaf);
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
                                    if (this.zzlae != null) {
                                        zzdgq.zza zzaVar2 = this.zzlae;
                                        zzeee zzeeeVar = (zzeee) zzaVar2.zza(zzeel.zzmzf, (Object) null, (Object) null);
                                        zzeeeVar.zza((zzeee) zzaVar2);
                                        c0084zza = (zzdgq.zza.C0084zza) zzeeeVar;
                                    } else {
                                        c0084zza = null;
                                    }
                                    this.zzlae = (zzdgq.zza) zzedtVar.zza(zzdgq.zza.zzbmi(), zzedzVar);
                                    if (c0084zza == null) {
                                        break;
                                    } else {
                                        c0084zza.zza((zzdgq.zza.C0084zza) this.zzlae);
                                        this.zzlae = (zzdgq.zza) c0084zza.zzccq();
                                        break;
                                    }
                                case 18:
                                    if (this.zzlaf != null) {
                                        zzdgq.zzb zzbVar = this.zzlaf;
                                        zzeee zzeeeVar2 = (zzeee) zzbVar.zza(zzeel.zzmzf, (Object) null, (Object) null);
                                        zzeeeVar2.zza((zzeee) zzbVar);
                                        zzaVar = (zzdgq.zzb.zza) zzeeeVar2;
                                    } else {
                                        zzaVar = null;
                                    }
                                    this.zzlaf = (zzdgq.zzb) zzedtVar.zza(zzdgq.zzb.zzbmk(), zzedzVar);
                                    if (zzaVar == null) {
                                        break;
                                    } else {
                                        zzaVar.zza((zzdgq.zzb.zza) this.zzlaf);
                                        this.zzlaf = (zzdgq.zzb) zzaVar.zzccq();
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
                        synchronized (zzc.class) {
                            if (zzkxq == null) {
                                zzkxq = new zzeef(zzlag);
                            }
                        }
                    }
                    return zzkxq;
                default:
                    throw new UnsupportedOperationException();
            }
            return zzlag;
        }

        @Override // com.google.android.gms.internal.zzeey
        public final void zza(zzedw zzedwVar) throws IOException {
            if (this.zzlae != null) {
                zzedwVar.zza(1, this.zzlae == null ? zzdgq.zza.zzbmi() : this.zzlae);
            }
            if (this.zzlaf != null) {
                zzedwVar.zza(2, this.zzlaf == null ? zzdgq.zzb.zzbmk() : this.zzlaf);
            }
        }

        @Override // com.google.android.gms.internal.zzeey
        public final int zzbjo() {
            int i = this.zzmys;
            if (i == -1) {
                i = 0;
                if (this.zzlae != null) {
                    i = zzedw.zzb(1, this.zzlae == null ? zzdgq.zza.zzbmi() : this.zzlae) + 0;
                }
                if (this.zzlaf != null) {
                    i += zzedw.zzb(2, this.zzlaf == null ? zzdgq.zzb.zzbmk() : this.zzlaf);
                }
                this.zzmys = i;
            }
            return i;
        }

        public final zzdgq.zza zzblx() {
            return this.zzlae == null ? zzdgq.zza.zzbmi() : this.zzlae;
        }

        public final zzdgq.zzb zzbly() {
            return this.zzlaf == null ? zzdgq.zzb.zzbmk() : this.zzlaf;
        }
    }
}

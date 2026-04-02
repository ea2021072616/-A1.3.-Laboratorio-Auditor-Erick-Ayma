package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdfo;
import com.google.android.gms.internal.zzdge;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class zzdfm {

    /* loaded from: classes2.dex */
    public static final class zza extends zzeed<zza, C0077zza> implements zzefa {
        private static final zza zzkxp;
        private static volatile zzefc<zza> zzkxq;
        private int zzkxm;
        private zzdfo.zza zzkxn;
        private zzdge.zza zzkxo;

        /* renamed from: com.google.android.gms.internal.zzdfm$zza$zza  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0077zza extends zzeee<zza, C0077zza> implements zzefa {
            private C0077zza() {
                super(zza.zzkxp);
            }

            /* synthetic */ C0077zza(zzdfn zzdfnVar) {
                this();
            }

            public final C0077zza zzb(zzdfo.zza zzaVar) {
                zzccp();
                ((zza) this.zzmyu).zza(zzaVar);
                return this;
            }

            public final C0077zza zzb(zzdge.zza zzaVar) {
                zzccp();
                ((zza) this.zzmyu).zza(zzaVar);
                return this;
            }

            public final C0077zza zzex(int i) {
                zzccp();
                ((zza) this.zzmyu).setVersion(i);
                return this;
            }
        }

        static {
            zza zzaVar = new zza();
            zzkxp = zzaVar;
            zzaVar.zza(zzeel.zzmzd, (Object) null, (Object) null);
            zzaVar.zzmyr.zzbhq();
        }

        private zza() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setVersion(int i) {
            this.zzkxm = i;
        }

        public static zza zza(zzedk zzedkVar) throws zzeer {
            return (zza) zzeed.zza(zzkxp, zzedkVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzdfo.zza zzaVar) {
            if (zzaVar == null) {
                throw new NullPointerException();
            }
            this.zzkxn = zzaVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzdge.zza zzaVar) {
            if (zzaVar == null) {
                throw new NullPointerException();
            }
            this.zzkxo = zzaVar;
        }

        public static C0077zza zzbjp() {
            zza zzaVar = zzkxp;
            zzeee zzeeeVar = (zzeee) zzaVar.zza(zzeel.zzmzf, (Object) null, (Object) null);
            zzeeeVar.zza((zzeee) zzaVar);
            return (C0077zza) zzeeeVar;
        }

        public final int getVersion() {
            return this.zzkxm;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.android.gms.internal.zzeed
        public final Object zza(int i, Object obj, Object obj2) {
            zzdge.zza.C0082zza c0082zza;
            zzdfo.zza.C0078zza c0078zza;
            switch (zzdfn.zzkxl[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return zzkxp;
                case 3:
                    return null;
                case 4:
                    return new C0077zza(null);
                case 5:
                    zzeem zzeemVar = (zzeem) obj;
                    zza zzaVar = (zza) obj2;
                    this.zzkxm = zzeemVar.zza(this.zzkxm != 0, this.zzkxm, zzaVar.zzkxm != 0, zzaVar.zzkxm);
                    this.zzkxn = (zzdfo.zza) zzeemVar.zza(this.zzkxn, zzaVar.zzkxn);
                    this.zzkxo = (zzdge.zza) zzeemVar.zza(this.zzkxo, zzaVar.zzkxo);
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
                                    if (this.zzkxn != null) {
                                        zzdfo.zza zzaVar2 = this.zzkxn;
                                        zzeee zzeeeVar = (zzeee) zzaVar2.zza(zzeel.zzmzf, (Object) null, (Object) null);
                                        zzeeeVar.zza((zzeee) zzaVar2);
                                        c0078zza = (zzdfo.zza.C0078zza) zzeeeVar;
                                    } else {
                                        c0078zza = null;
                                    }
                                    this.zzkxn = (zzdfo.zza) zzedtVar.zza(zzdfo.zza.zzbjx(), zzedzVar);
                                    if (c0078zza == null) {
                                        break;
                                    } else {
                                        c0078zza.zza((zzdfo.zza.C0078zza) this.zzkxn);
                                        this.zzkxn = (zzdfo.zza) c0078zza.zzccq();
                                        break;
                                    }
                                case 26:
                                    if (this.zzkxo != null) {
                                        zzdge.zza zzaVar3 = this.zzkxo;
                                        zzeee zzeeeVar2 = (zzeee) zzaVar3.zza(zzeel.zzmzf, (Object) null, (Object) null);
                                        zzeeeVar2.zza((zzeee) zzaVar3);
                                        c0082zza = (zzdge.zza.C0082zza) zzeeeVar2;
                                    } else {
                                        c0082zza = null;
                                    }
                                    this.zzkxo = (zzdge.zza) zzedtVar.zza(zzdge.zza.zzblk(), zzedzVar);
                                    if (c0082zza == null) {
                                        break;
                                    } else {
                                        c0082zza.zza((zzdge.zza.C0082zza) this.zzkxo);
                                        this.zzkxo = (zzdge.zza) c0082zza.zzccq();
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
                                zzkxq = new zzeef(zzkxp);
                            }
                        }
                    }
                    return zzkxq;
                default:
                    throw new UnsupportedOperationException();
            }
            return zzkxp;
        }

        @Override // com.google.android.gms.internal.zzeey
        public final void zza(zzedw zzedwVar) throws IOException {
            if (this.zzkxm != 0) {
                zzedwVar.zzu(1, this.zzkxm);
            }
            if (this.zzkxn != null) {
                zzedwVar.zza(2, this.zzkxn == null ? zzdfo.zza.zzbjx() : this.zzkxn);
            }
            if (this.zzkxo != null) {
                zzedwVar.zza(3, this.zzkxo == null ? zzdge.zza.zzblk() : this.zzkxo);
            }
        }

        public final zzdfo.zza zzbjm() {
            return this.zzkxn == null ? zzdfo.zza.zzbjx() : this.zzkxn;
        }

        public final zzdge.zza zzbjn() {
            return this.zzkxo == null ? zzdge.zza.zzblk() : this.zzkxo;
        }

        @Override // com.google.android.gms.internal.zzeey
        public final int zzbjo() {
            int i = this.zzmys;
            if (i == -1) {
                i = this.zzkxm != 0 ? zzedw.zzv(1, this.zzkxm) + 0 : 0;
                if (this.zzkxn != null) {
                    i += zzedw.zzb(2, this.zzkxn == null ? zzdfo.zza.zzbjx() : this.zzkxn);
                }
                if (this.zzkxo != null) {
                    i += zzedw.zzb(3, this.zzkxo == null ? zzdge.zza.zzblk() : this.zzkxo);
                }
                this.zzmys = i;
            }
            return i;
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzb extends zzeed<zzb, zza> implements zzefa {
        private static volatile zzefc<zzb> zzkxq;
        private static final zzb zzkxt;
        private zzdfo.zzb zzkxr;
        private zzdge.zzb zzkxs;

        /* loaded from: classes2.dex */
        public static final class zza extends zzeee<zzb, zza> implements zzefa {
            private zza() {
                super(zzb.zzkxt);
            }

            /* synthetic */ zza(zzdfn zzdfnVar) {
                this();
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzkxt = zzbVar;
            zzbVar.zza(zzeel.zzmzd, (Object) null, (Object) null);
            zzbVar.zzmyr.zzbhq();
        }

        private zzb() {
        }

        public static zzb zzb(zzedk zzedkVar) throws zzeer {
            return (zzb) zzeed.zza(zzkxt, zzedkVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.android.gms.internal.zzeed
        public final Object zza(int i, Object obj, Object obj2) {
            zzdge.zzb.zza zzaVar;
            zzdfo.zzb.zza zzaVar2;
            switch (zzdfn.zzkxl[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return zzkxt;
                case 3:
                    return null;
                case 4:
                    return new zza(null);
                case 5:
                    zzeem zzeemVar = (zzeem) obj;
                    zzb zzbVar = (zzb) obj2;
                    this.zzkxr = (zzdfo.zzb) zzeemVar.zza(this.zzkxr, zzbVar.zzkxr);
                    this.zzkxs = (zzdge.zzb) zzeemVar.zza(this.zzkxs, zzbVar.zzkxs);
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
                                    if (this.zzkxr != null) {
                                        zzdfo.zzb zzbVar2 = this.zzkxr;
                                        zzeee zzeeeVar = (zzeee) zzbVar2.zza(zzeel.zzmzf, (Object) null, (Object) null);
                                        zzeeeVar.zza((zzeee) zzbVar2);
                                        zzaVar2 = (zzdfo.zzb.zza) zzeeeVar;
                                    } else {
                                        zzaVar2 = null;
                                    }
                                    this.zzkxr = (zzdfo.zzb) zzedtVar.zza(zzdfo.zzb.zzbjz(), zzedzVar);
                                    if (zzaVar2 == null) {
                                        break;
                                    } else {
                                        zzaVar2.zza((zzdfo.zzb.zza) this.zzkxr);
                                        this.zzkxr = (zzdfo.zzb) zzaVar2.zzccq();
                                        break;
                                    }
                                case 18:
                                    if (this.zzkxs != null) {
                                        zzdge.zzb zzbVar3 = this.zzkxs;
                                        zzeee zzeeeVar2 = (zzeee) zzbVar3.zza(zzeel.zzmzf, (Object) null, (Object) null);
                                        zzeeeVar2.zza((zzeee) zzbVar3);
                                        zzaVar = (zzdge.zzb.zza) zzeeeVar2;
                                    } else {
                                        zzaVar = null;
                                    }
                                    this.zzkxs = (zzdge.zzb) zzedtVar.zza(zzdge.zzb.zzblm(), zzedzVar);
                                    if (zzaVar == null) {
                                        break;
                                    } else {
                                        zzaVar.zza((zzdge.zzb.zza) this.zzkxs);
                                        this.zzkxs = (zzdge.zzb) zzaVar.zzccq();
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
                                zzkxq = new zzeef(zzkxt);
                            }
                        }
                    }
                    return zzkxq;
                default:
                    throw new UnsupportedOperationException();
            }
            return zzkxt;
        }

        @Override // com.google.android.gms.internal.zzeey
        public final void zza(zzedw zzedwVar) throws IOException {
            if (this.zzkxr != null) {
                zzedwVar.zza(1, this.zzkxr == null ? zzdfo.zzb.zzbjz() : this.zzkxr);
            }
            if (this.zzkxs != null) {
                zzedwVar.zza(2, this.zzkxs == null ? zzdge.zzb.zzblm() : this.zzkxs);
            }
        }

        @Override // com.google.android.gms.internal.zzeey
        public final int zzbjo() {
            int i = this.zzmys;
            if (i == -1) {
                i = 0;
                if (this.zzkxr != null) {
                    i = zzedw.zzb(1, this.zzkxr == null ? zzdfo.zzb.zzbjz() : this.zzkxr) + 0;
                }
                if (this.zzkxs != null) {
                    i += zzedw.zzb(2, this.zzkxs == null ? zzdge.zzb.zzblm() : this.zzkxs);
                }
                this.zzmys = i;
            }
            return i;
        }

        public final zzdfo.zzb zzbjr() {
            return this.zzkxr == null ? zzdfo.zzb.zzbjz() : this.zzkxr;
        }

        public final zzdge.zzb zzbjs() {
            return this.zzkxs == null ? zzdge.zzb.zzblm() : this.zzkxs;
        }
    }
}

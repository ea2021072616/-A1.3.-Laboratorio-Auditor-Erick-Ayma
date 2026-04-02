package com.google.android.gms.internal;

import java.io.IOException;
import java.util.List;
/* loaded from: classes2.dex */
public final class zzdgq {

    /* loaded from: classes2.dex */
    public static final class zza extends zzeed<zza, C0084zza> implements zzefa {
        private static volatile zzefc<zza> zzkxq;
        private static final zza zzlar;
        private String zzlao = "";
        private zzedk zzlap = zzedk.zzmxr;
        private int zzlaq;

        /* renamed from: com.google.android.gms.internal.zzdgq$zza$zza  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0084zza extends zzeee<zza, C0084zza> implements zzefa {
            private C0084zza() {
                super(zza.zzlar);
            }

            /* synthetic */ C0084zza(zzdgr zzdgrVar) {
                this();
            }

            public final C0084zza zzb(zzb zzbVar) {
                zzccp();
                ((zza) this.zzmyu).zza(zzbVar);
                return this;
            }

            public final C0084zza zznw(String str) {
                zzccp();
                ((zza) this.zzmyu).zznv(str);
                return this;
            }

            public final C0084zza zzw(zzedk zzedkVar) {
                zzccp();
                ((zza) this.zzmyu).zzv(zzedkVar);
                return this;
            }
        }

        /* loaded from: classes2.dex */
        public enum zzb implements zzeeo {
            UNKNOWN_KEYMATERIAL(0),
            SYMMETRIC(1),
            ASYMMETRIC_PRIVATE(2),
            ASYMMETRIC_PUBLIC(3),
            REMOTE(4),
            UNRECOGNIZED(-1);
            
            private static final zzeep<zzb> zzkyn = new zzdgs();
            private final int value;

            zzb(int i) {
                this.value = i;
            }

            public static zzb zzfg(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN_KEYMATERIAL;
                    case 1:
                        return SYMMETRIC;
                    case 2:
                        return ASYMMETRIC_PRIVATE;
                    case 3:
                        return ASYMMETRIC_PUBLIC;
                    case 4:
                        return REMOTE;
                    default:
                        return null;
                }
            }

            public final int zzbkq() {
                if (this == UNRECOGNIZED) {
                    throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
                }
                return this.value;
            }
        }

        static {
            zza zzaVar = new zza();
            zzlar = zzaVar;
            zzaVar.zza(zzeel.zzmzd, (Object) null, (Object) null);
            zzaVar.zzmyr.zzbhq();
        }

        private zza() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzb zzbVar) {
            if (zzbVar == null) {
                throw new NullPointerException();
            }
            this.zzlaq = zzbVar.zzbkq();
        }

        public static C0084zza zzbmh() {
            zza zzaVar = zzlar;
            zzeee zzeeeVar = (zzeee) zzaVar.zza(zzeel.zzmzf, (Object) null, (Object) null);
            zzeeeVar.zza((zzeee) zzaVar);
            return (C0084zza) zzeeeVar;
        }

        public static zza zzbmi() {
            return zzlar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zznv(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzlao = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzv(zzedk zzedkVar) {
            if (zzedkVar == null) {
                throw new NullPointerException();
            }
            this.zzlap = zzedkVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.android.gms.internal.zzeed
        public final Object zza(int i, Object obj, Object obj2) {
            boolean z = false;
            switch (zzdgr.zzkxl[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return zzlar;
                case 3:
                    return null;
                case 4:
                    return new C0084zza(null);
                case 5:
                    zzeem zzeemVar = (zzeem) obj;
                    zza zzaVar = (zza) obj2;
                    this.zzlao = zzeemVar.zza(!this.zzlao.isEmpty(), this.zzlao, !zzaVar.zzlao.isEmpty(), zzaVar.zzlao);
                    this.zzlap = zzeemVar.zza(this.zzlap != zzedk.zzmxr, this.zzlap, zzaVar.zzlap != zzedk.zzmxr, zzaVar.zzlap);
                    this.zzlaq = zzeemVar.zza(this.zzlaq != 0, this.zzlaq, zzaVar.zzlaq != 0, zzaVar.zzlaq);
                    return this;
                case 6:
                    zzedt zzedtVar = (zzedt) obj;
                    while (!z) {
                        try {
                            try {
                                int zzcbr = zzedtVar.zzcbr();
                                switch (zzcbr) {
                                    case 0:
                                        z = true;
                                        break;
                                    case 10:
                                        this.zzlao = zzedtVar.zzcbt();
                                        break;
                                    case 18:
                                        this.zzlap = zzedtVar.zzcbu();
                                        break;
                                    case 24:
                                        this.zzlaq = zzedtVar.zzcbv();
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
                        synchronized (zza.class) {
                            if (zzkxq == null) {
                                zzkxq = new zzeef(zzlar);
                            }
                        }
                    }
                    return zzkxq;
                default:
                    throw new UnsupportedOperationException();
            }
            return zzlar;
        }

        @Override // com.google.android.gms.internal.zzeey
        public final void zza(zzedw zzedwVar) throws IOException {
            if (!this.zzlao.isEmpty()) {
                zzedwVar.zzl(1, this.zzlao);
            }
            if (!this.zzlap.isEmpty()) {
                zzedwVar.zza(2, this.zzlap);
            }
            if (this.zzlaq != zzb.UNKNOWN_KEYMATERIAL.zzbkq()) {
                zzedwVar.zzu(3, this.zzlaq);
            }
        }

        @Override // com.google.android.gms.internal.zzeey
        public final int zzbjo() {
            int i = this.zzmys;
            if (i == -1) {
                i = this.zzlao.isEmpty() ? 0 : zzedw.zzm(1, this.zzlao) + 0;
                if (!this.zzlap.isEmpty()) {
                    i += zzedw.zzb(2, this.zzlap);
                }
                if (this.zzlaq != zzb.UNKNOWN_KEYMATERIAL.zzbkq()) {
                    i += zzedw.zzw(3, this.zzlaq);
                }
                this.zzmys = i;
            }
            return i;
        }

        public final String zzbme() {
            return this.zzlao;
        }

        public final zzedk zzbmf() {
            return this.zzlap;
        }

        public final zzb zzbmg() {
            zzb zzfg = zzb.zzfg(this.zzlaq);
            return zzfg == null ? zzb.UNRECOGNIZED : zzfg;
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzb extends zzeed<zzb, zza> implements zzefa {
        private static volatile zzefc<zzb> zzkxq;
        private static final zzb zzlbf;
        private String zzlao = "";
        private zzedk zzlap = zzedk.zzmxr;

        /* loaded from: classes2.dex */
        public static final class zza extends zzeee<zzb, zza> implements zzefa {
            private zza() {
                super(zzb.zzlbf);
            }

            /* synthetic */ zza(zzdgr zzdgrVar) {
                this();
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzlbf = zzbVar;
            zzbVar.zza(zzeel.zzmzd, (Object) null, (Object) null);
            zzbVar.zzmyr.zzbhq();
        }

        private zzb() {
        }

        public static zzb zzbmk() {
            return zzlbf;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.android.gms.internal.zzeed
        public final Object zza(int i, Object obj, Object obj2) {
            boolean z = false;
            switch (zzdgr.zzkxl[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return zzlbf;
                case 3:
                    return null;
                case 4:
                    return new zza(null);
                case 5:
                    zzeem zzeemVar = (zzeem) obj;
                    zzb zzbVar = (zzb) obj2;
                    this.zzlao = zzeemVar.zza(!this.zzlao.isEmpty(), this.zzlao, !zzbVar.zzlao.isEmpty(), zzbVar.zzlao);
                    this.zzlap = zzeemVar.zza(this.zzlap != zzedk.zzmxr, this.zzlap, zzbVar.zzlap != zzedk.zzmxr, zzbVar.zzlap);
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
                                case 10:
                                    this.zzlao = zzedtVar.zzcbt();
                                    break;
                                case 18:
                                    this.zzlap = zzedtVar.zzcbu();
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
                                zzkxq = new zzeef(zzlbf);
                            }
                        }
                    }
                    return zzkxq;
                default:
                    throw new UnsupportedOperationException();
            }
            return zzlbf;
        }

        @Override // com.google.android.gms.internal.zzeey
        public final void zza(zzedw zzedwVar) throws IOException {
            if (!this.zzlao.isEmpty()) {
                zzedwVar.zzl(1, this.zzlao);
            }
            if (this.zzlap.isEmpty()) {
                return;
            }
            zzedwVar.zza(2, this.zzlap);
        }

        @Override // com.google.android.gms.internal.zzeey
        public final int zzbjo() {
            int i = this.zzmys;
            if (i == -1) {
                i = this.zzlao.isEmpty() ? 0 : zzedw.zzm(1, this.zzlao) + 0;
                if (!this.zzlap.isEmpty()) {
                    i += zzedw.zzb(2, this.zzlap);
                }
                this.zzmys = i;
            }
            return i;
        }

        public final String zzbme() {
            return this.zzlao;
        }

        public final zzedk zzbmf() {
            return this.zzlap;
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzc extends zzeed<zzc, zza> implements zzefa {
        private static volatile zzefc<zzc> zzkxq;
        private static final zzc zzlbj;
        private int zzlbg;
        private int zzlbh;
        private zzeeq<zzb> zzlbi = zzccm();

        /* loaded from: classes2.dex */
        public static final class zza extends zzeee<zzc, zza> implements zzefa {
            private zza() {
                super(zzc.zzlbj);
            }

            /* synthetic */ zza(zzdgr zzdgrVar) {
                this();
            }
        }

        /* loaded from: classes2.dex */
        public static final class zzb extends zzeed<zzb, zza> implements zzefa {
            private static volatile zzefc<zzb> zzkxq;
            private static final zzb zzlbo;
            private zza zzlbk;
            private int zzlbl;
            private int zzlbm;
            private int zzlbn;

            /* loaded from: classes2.dex */
            public static final class zza extends zzeee<zzb, zza> implements zzefa {
                private zza() {
                    super(zzb.zzlbo);
                }

                /* synthetic */ zza(zzdgr zzdgrVar) {
                    this();
                }
            }

            static {
                zzb zzbVar = new zzb();
                zzlbo = zzbVar;
                zzbVar.zza(zzeel.zzmzd, (Object) null, (Object) null);
                zzbVar.zzmyr.zzbhq();
            }

            private zzb() {
            }

            public static zzb zzbmv() {
                return zzlbo;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.google.android.gms.internal.zzeed
            public final Object zza(int i, Object obj, Object obj2) {
                zza.C0084zza c0084zza;
                switch (zzdgr.zzkxl[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return zzlbo;
                    case 3:
                        return null;
                    case 4:
                        return new zza(null);
                    case 5:
                        zzeem zzeemVar = (zzeem) obj;
                        zzb zzbVar = (zzb) obj2;
                        this.zzlbk = (zza) zzeemVar.zza(this.zzlbk, zzbVar.zzlbk);
                        this.zzlbl = zzeemVar.zza(this.zzlbl != 0, this.zzlbl, zzbVar.zzlbl != 0, zzbVar.zzlbl);
                        this.zzlbm = zzeemVar.zza(this.zzlbm != 0, this.zzlbm, zzbVar.zzlbm != 0, zzbVar.zzlbm);
                        this.zzlbn = zzeemVar.zza(this.zzlbn != 0, this.zzlbn, zzbVar.zzlbn != 0, zzbVar.zzlbn);
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
                                            if (this.zzlbk != null) {
                                                zza zzaVar = this.zzlbk;
                                                zzeee zzeeeVar = (zzeee) zzaVar.zza(zzeel.zzmzf, (Object) null, (Object) null);
                                                zzeeeVar.zza((zzeee) zzaVar);
                                                c0084zza = (zza.C0084zza) zzeeeVar;
                                            } else {
                                                c0084zza = null;
                                            }
                                            this.zzlbk = (zza) zzedtVar.zza(zza.zzbmi(), zzedzVar);
                                            if (c0084zza == null) {
                                                break;
                                            } else {
                                                c0084zza.zza((zza.C0084zza) this.zzlbk);
                                                this.zzlbk = (zza) c0084zza.zzccq();
                                                break;
                                            }
                                        case 16:
                                            this.zzlbl = zzedtVar.zzcbv();
                                            break;
                                        case 24:
                                            this.zzlbm = zzedtVar.zzcbs();
                                            break;
                                        case 32:
                                            this.zzlbn = zzedtVar.zzcbv();
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
                                    zzkxq = new zzeef(zzlbo);
                                }
                            }
                        }
                        return zzkxq;
                    default:
                        throw new UnsupportedOperationException();
                }
                return zzlbo;
            }

            @Override // com.google.android.gms.internal.zzeey
            public final void zza(zzedw zzedwVar) throws IOException {
                if (this.zzlbk != null) {
                    zzedwVar.zza(1, this.zzlbk == null ? zza.zzbmi() : this.zzlbk);
                }
                if (this.zzlbl != zzdgt.UNKNOWN_STATUS.zzbkq()) {
                    zzedwVar.zzu(2, this.zzlbl);
                }
                if (this.zzlbm != 0) {
                    zzedwVar.zzu(3, this.zzlbm);
                }
                if (this.zzlbn != zzdgv.UNKNOWN_PREFIX.zzbkq()) {
                    zzedwVar.zzu(4, this.zzlbn);
                }
            }

            @Override // com.google.android.gms.internal.zzeey
            public final int zzbjo() {
                int i = this.zzmys;
                if (i == -1) {
                    i = 0;
                    if (this.zzlbk != null) {
                        i = zzedw.zzb(1, this.zzlbk == null ? zza.zzbmi() : this.zzlbk) + 0;
                    }
                    if (this.zzlbl != zzdgt.UNKNOWN_STATUS.zzbkq()) {
                        i += zzedw.zzw(2, this.zzlbl);
                    }
                    if (this.zzlbm != 0) {
                        i += zzedw.zzv(3, this.zzlbm);
                    }
                    if (this.zzlbn != zzdgv.UNKNOWN_PREFIX.zzbkq()) {
                        i += zzedw.zzw(4, this.zzlbn);
                    }
                    this.zzmys = i;
                }
                return i;
            }

            public final boolean zzbmq() {
                return this.zzlbk != null;
            }

            public final zza zzbmr() {
                return this.zzlbk == null ? zza.zzbmi() : this.zzlbk;
            }

            public final zzdgt zzbms() {
                zzdgt zzfh = zzdgt.zzfh(this.zzlbl);
                return zzfh == null ? zzdgt.UNRECOGNIZED : zzfh;
            }

            public final int zzbmt() {
                return this.zzlbm;
            }

            public final zzdgv zzbmu() {
                zzdgv zzfm = zzdgv.zzfm(this.zzlbn);
                return zzfm == null ? zzdgv.UNRECOGNIZED : zzfm;
            }
        }

        static {
            zzc zzcVar = new zzc();
            zzlbj = zzcVar;
            zzcVar.zza(zzeel.zzmzd, (Object) null, (Object) null);
            zzcVar.zzmyr.zzbhq();
        }

        private zzc() {
        }

        public static zzc zzaf(byte[] bArr) throws zzeer {
            return (zzc) zzeed.zza(zzlbj, bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.android.gms.internal.zzeed
        public final Object zza(int i, Object obj, Object obj2) {
            boolean z = false;
            switch (zzdgr.zzkxl[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return zzlbj;
                case 3:
                    this.zzlbi.zzbhq();
                    return null;
                case 4:
                    return new zza(null);
                case 5:
                    zzeem zzeemVar = (zzeem) obj;
                    zzc zzcVar = (zzc) obj2;
                    this.zzlbh = zzeemVar.zza(this.zzlbh != 0, this.zzlbh, zzcVar.zzlbh != 0, zzcVar.zzlbh);
                    this.zzlbi = zzeemVar.zza(this.zzlbi, zzcVar.zzlbi);
                    if (zzeemVar == zzeek.zzmyz) {
                        this.zzlbg |= zzcVar.zzlbg;
                        return this;
                    }
                    return this;
                case 6:
                    zzedt zzedtVar = (zzedt) obj;
                    zzedz zzedzVar = (zzedz) obj2;
                    while (!z) {
                        try {
                            try {
                                int zzcbr = zzedtVar.zzcbr();
                                switch (zzcbr) {
                                    case 0:
                                        z = true;
                                        break;
                                    case 8:
                                        this.zzlbh = zzedtVar.zzcbs();
                                        break;
                                    case 18:
                                        if (!this.zzlbi.zzcbk()) {
                                            zzeeq<zzb> zzeeqVar = this.zzlbi;
                                            int size = zzeeqVar.size();
                                            this.zzlbi = zzeeqVar.zzgu(size == 0 ? 10 : size << 1);
                                        }
                                        this.zzlbi.add((zzb) zzedtVar.zza(zzb.zzbmv(), zzedzVar));
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
                        synchronized (zzc.class) {
                            if (zzkxq == null) {
                                zzkxq = new zzeef(zzlbj);
                            }
                        }
                    }
                    return zzkxq;
                default:
                    throw new UnsupportedOperationException();
            }
            return zzlbj;
        }

        @Override // com.google.android.gms.internal.zzeey
        public final void zza(zzedw zzedwVar) throws IOException {
            if (this.zzlbh != 0) {
                zzedwVar.zzu(1, this.zzlbh);
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.zzlbi.size()) {
                    return;
                }
                zzedwVar.zza(2, this.zzlbi.get(i2));
                i = i2 + 1;
            }
        }

        @Override // com.google.android.gms.internal.zzeey
        public final int zzbjo() {
            int i = 0;
            int i2 = this.zzmys;
            if (i2 == -1) {
                int zzv = this.zzlbh != 0 ? zzedw.zzv(1, this.zzlbh) + 0 : 0;
                while (true) {
                    i2 = zzv;
                    if (i >= this.zzlbi.size()) {
                        break;
                    }
                    zzv = zzedw.zzb(2, this.zzlbi.get(i)) + i2;
                    i++;
                }
                this.zzmys = i2;
            }
            return i2;
        }

        public final int zzbmm() {
            return this.zzlbh;
        }

        public final List<zzb> zzbmn() {
            return this.zzlbi;
        }

        public final int zzbmo() {
            return this.zzlbi.size();
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzd extends zzeed<zzd, zza> implements zzefa {
        private static volatile zzefc<zzd> zzkxq;
        private static final zzd zzlbq;
        private int zzlbg;
        private int zzlbh;
        private zzeeq<zzb> zzlbp = zzccm();

        /* loaded from: classes2.dex */
        public static final class zza extends zzeee<zzd, zza> implements zzefa {
            private zza() {
                super(zzd.zzlbq);
            }

            /* synthetic */ zza(zzdgr zzdgrVar) {
                this();
            }

            public final zza zzb(zzb zzbVar) {
                zzccp();
                ((zzd) this.zzmyu).zza(zzbVar);
                return this;
            }

            public final zza zzfj(int i) {
                zzccp();
                ((zzd) this.zzmyu).zzfi(i);
                return this;
            }
        }

        /* loaded from: classes2.dex */
        public static final class zzb extends zzeed<zzb, zza> implements zzefa {
            private static volatile zzefc<zzb> zzkxq;
            private static final zzb zzlbr;
            private String zzlao = "";
            private int zzlbl;
            private int zzlbm;
            private int zzlbn;

            /* loaded from: classes2.dex */
            public static final class zza extends zzeee<zzb, zza> implements zzefa {
                private zza() {
                    super(zzb.zzlbr);
                }

                /* synthetic */ zza(zzdgr zzdgrVar) {
                    this();
                }

                public final zza zzb(zzdgt zzdgtVar) {
                    zzccp();
                    ((zzb) this.zzmyu).zza(zzdgtVar);
                    return this;
                }

                public final zza zzb(zzdgv zzdgvVar) {
                    zzccp();
                    ((zzb) this.zzmyu).zza(zzdgvVar);
                    return this;
                }

                public final zza zzfl(int i) {
                    zzccp();
                    ((zzb) this.zzmyu).zzfk(i);
                    return this;
                }

                public final zza zznx(String str) {
                    zzccp();
                    ((zzb) this.zzmyu).zznv(str);
                    return this;
                }
            }

            static {
                zzb zzbVar = new zzb();
                zzlbr = zzbVar;
                zzbVar.zza(zzeel.zzmzd, (Object) null, (Object) null);
                zzbVar.zzmyr.zzbhq();
            }

            private zzb() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zza(zzdgt zzdgtVar) {
                if (zzdgtVar == null) {
                    throw new NullPointerException();
                }
                this.zzlbl = zzdgtVar.zzbkq();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zza(zzdgv zzdgvVar) {
                if (zzdgvVar == null) {
                    throw new NullPointerException();
                }
                this.zzlbn = zzdgvVar.zzbkq();
            }

            public static zza zzbmz() {
                zzb zzbVar = zzlbr;
                zzeee zzeeeVar = (zzeee) zzbVar.zza(zzeel.zzmzf, (Object) null, (Object) null);
                zzeeeVar.zza((zzeee) zzbVar);
                return (zza) zzeeeVar;
            }

            public static zzb zzbna() {
                return zzlbr;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzfk(int i) {
                this.zzlbm = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zznv(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.zzlao = str;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.google.android.gms.internal.zzeed
            public final Object zza(int i, Object obj, Object obj2) {
                boolean z = false;
                switch (zzdgr.zzkxl[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return zzlbr;
                    case 3:
                        return null;
                    case 4:
                        return new zza(null);
                    case 5:
                        zzeem zzeemVar = (zzeem) obj;
                        zzb zzbVar = (zzb) obj2;
                        this.zzlao = zzeemVar.zza(!this.zzlao.isEmpty(), this.zzlao, !zzbVar.zzlao.isEmpty(), zzbVar.zzlao);
                        this.zzlbl = zzeemVar.zza(this.zzlbl != 0, this.zzlbl, zzbVar.zzlbl != 0, zzbVar.zzlbl);
                        this.zzlbm = zzeemVar.zza(this.zzlbm != 0, this.zzlbm, zzbVar.zzlbm != 0, zzbVar.zzlbm);
                        this.zzlbn = zzeemVar.zza(this.zzlbn != 0, this.zzlbn, zzbVar.zzlbn != 0, zzbVar.zzlbn);
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
                                    case 10:
                                        this.zzlao = zzedtVar.zzcbt();
                                        break;
                                    case 16:
                                        this.zzlbl = zzedtVar.zzcbv();
                                        break;
                                    case 24:
                                        this.zzlbm = zzedtVar.zzcbs();
                                        break;
                                    case 32:
                                        this.zzlbn = zzedtVar.zzcbv();
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
                                    zzkxq = new zzeef(zzlbr);
                                }
                            }
                        }
                        return zzkxq;
                    default:
                        throw new UnsupportedOperationException();
                }
                return zzlbr;
            }

            @Override // com.google.android.gms.internal.zzeey
            public final void zza(zzedw zzedwVar) throws IOException {
                if (!this.zzlao.isEmpty()) {
                    zzedwVar.zzl(1, this.zzlao);
                }
                if (this.zzlbl != zzdgt.UNKNOWN_STATUS.zzbkq()) {
                    zzedwVar.zzu(2, this.zzlbl);
                }
                if (this.zzlbm != 0) {
                    zzedwVar.zzu(3, this.zzlbm);
                }
                if (this.zzlbn != zzdgv.UNKNOWN_PREFIX.zzbkq()) {
                    zzedwVar.zzu(4, this.zzlbn);
                }
            }

            @Override // com.google.android.gms.internal.zzeey
            public final int zzbjo() {
                int i = this.zzmys;
                if (i == -1) {
                    i = this.zzlao.isEmpty() ? 0 : zzedw.zzm(1, this.zzlao) + 0;
                    if (this.zzlbl != zzdgt.UNKNOWN_STATUS.zzbkq()) {
                        i += zzedw.zzw(2, this.zzlbl);
                    }
                    if (this.zzlbm != 0) {
                        i += zzedw.zzv(3, this.zzlbm);
                    }
                    if (this.zzlbn != zzdgv.UNKNOWN_PREFIX.zzbkq()) {
                        i += zzedw.zzw(4, this.zzlbn);
                    }
                    this.zzmys = i;
                }
                return i;
            }
        }

        static {
            zzd zzdVar = new zzd();
            zzlbq = zzdVar;
            zzdVar.zza(zzeel.zzmzd, (Object) null, (Object) null);
            zzdVar.zzmyr.zzbhq();
        }

        private zzd() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzb zzbVar) {
            if (zzbVar == null) {
                throw new NullPointerException();
            }
            if (!this.zzlbp.zzcbk()) {
                zzeeq<zzb> zzeeqVar = this.zzlbp;
                int size = zzeeqVar.size();
                this.zzlbp = zzeeqVar.zzgu(size == 0 ? 10 : size << 1);
            }
            this.zzlbp.add(zzbVar);
        }

        public static zza zzbmx() {
            zzd zzdVar = zzlbq;
            zzeee zzeeeVar = (zzeee) zzdVar.zza(zzeel.zzmzf, (Object) null, (Object) null);
            zzeeeVar.zza((zzeee) zzdVar);
            return (zza) zzeeeVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzfi(int i) {
            this.zzlbh = i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.android.gms.internal.zzeed
        public final Object zza(int i, Object obj, Object obj2) {
            boolean z = false;
            switch (zzdgr.zzkxl[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return zzlbq;
                case 3:
                    this.zzlbp.zzbhq();
                    return null;
                case 4:
                    return new zza(null);
                case 5:
                    zzeem zzeemVar = (zzeem) obj;
                    zzd zzdVar = (zzd) obj2;
                    this.zzlbh = zzeemVar.zza(this.zzlbh != 0, this.zzlbh, zzdVar.zzlbh != 0, zzdVar.zzlbh);
                    this.zzlbp = zzeemVar.zza(this.zzlbp, zzdVar.zzlbp);
                    if (zzeemVar == zzeek.zzmyz) {
                        this.zzlbg |= zzdVar.zzlbg;
                        return this;
                    }
                    return this;
                case 6:
                    zzedt zzedtVar = (zzedt) obj;
                    zzedz zzedzVar = (zzedz) obj2;
                    while (!z) {
                        try {
                            try {
                                int zzcbr = zzedtVar.zzcbr();
                                switch (zzcbr) {
                                    case 0:
                                        z = true;
                                        break;
                                    case 8:
                                        this.zzlbh = zzedtVar.zzcbs();
                                        break;
                                    case 18:
                                        if (!this.zzlbp.zzcbk()) {
                                            zzeeq<zzb> zzeeqVar = this.zzlbp;
                                            int size = zzeeqVar.size();
                                            this.zzlbp = zzeeqVar.zzgu(size == 0 ? 10 : size << 1);
                                        }
                                        this.zzlbp.add((zzb) zzedtVar.zza(zzb.zzbna(), zzedzVar));
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
                        synchronized (zzd.class) {
                            if (zzkxq == null) {
                                zzkxq = new zzeef(zzlbq);
                            }
                        }
                    }
                    return zzkxq;
                default:
                    throw new UnsupportedOperationException();
            }
            return zzlbq;
        }

        @Override // com.google.android.gms.internal.zzeey
        public final void zza(zzedw zzedwVar) throws IOException {
            if (this.zzlbh != 0) {
                zzedwVar.zzu(1, this.zzlbh);
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.zzlbp.size()) {
                    return;
                }
                zzedwVar.zza(2, this.zzlbp.get(i2));
                i = i2 + 1;
            }
        }

        @Override // com.google.android.gms.internal.zzeey
        public final int zzbjo() {
            int i = 0;
            int i2 = this.zzmys;
            if (i2 == -1) {
                int zzv = this.zzlbh != 0 ? zzedw.zzv(1, this.zzlbh) + 0 : 0;
                while (true) {
                    i2 = zzv;
                    if (i >= this.zzlbp.size()) {
                        break;
                    }
                    zzv = zzedw.zzb(2, this.zzlbp.get(i)) + i2;
                    i++;
                }
                this.zzmys = i2;
            }
            return i2;
        }
    }
}

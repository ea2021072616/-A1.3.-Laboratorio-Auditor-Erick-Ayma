package com.google.android.gms.ads.internal;

import android.os.Build;
import com.google.android.gms.internal.zzacj;
import com.google.android.gms.internal.zzaez;
import com.google.android.gms.internal.zzafn;
import com.google.android.gms.internal.zzahf;
import com.google.android.gms.internal.zzahk;
import com.google.android.gms.internal.zzahp;
import com.google.android.gms.internal.zzahq;
import com.google.android.gms.internal.zzahr;
import com.google.android.gms.internal.zzahs;
import com.google.android.gms.internal.zzaht;
import com.google.android.gms.internal.zzahu;
import com.google.android.gms.internal.zzaic;
import com.google.android.gms.internal.zzaiu;
import com.google.android.gms.internal.zzaiv;
import com.google.android.gms.internal.zzajy;
import com.google.android.gms.internal.zzakf;
import com.google.android.gms.internal.zzaku;
import com.google.android.gms.internal.zzgz;
import com.google.android.gms.internal.zzhv;
import com.google.android.gms.internal.zzhw;
import com.google.android.gms.internal.zzik;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzmr;
import com.google.android.gms.internal.zzms;
import com.google.android.gms.internal.zzmz;
import com.google.android.gms.internal.zzsk;
import com.google.android.gms.internal.zztv;
import com.google.android.gms.internal.zzud;
import com.google.android.gms.internal.zzut;
import com.google.android.gms.internal.zzyc;
import com.google.android.gms.internal.zzzt;
import com.google.android.gms.internal.zzzu;
@zzzt
/* loaded from: classes.dex */
public final class zzbv {
    private static final Object zzaqm = new Object();
    private static zzbv zzarz;
    private final com.google.android.gms.ads.internal.overlay.zza zzasa = new com.google.android.gms.ads.internal.overlay.zza();
    private final zzzu zzasb = new zzzu();
    private final com.google.android.gms.ads.internal.overlay.zzu zzasc = new com.google.android.gms.ads.internal.overlay.zzu();
    private final zzyc zzasd = new zzyc();
    private final zzahf zzase = new zzahf();
    private final zzaku zzasf = new zzaku();
    private final zzahk zzasg;
    private final zzgz zzash;
    private final zzafn zzasi;
    private final zzhv zzasj;
    private final zzhw zzask;
    private final com.google.android.gms.common.util.zzd zzasl;
    private final zzac zzasm;
    private final zzmz zzasn;
    private final zzaic zzaso;
    private final zzacj zzasp;
    private final zzmq zzasq;
    private final zzmr zzasr;
    private final zzms zzass;
    private final zzajy zzast;
    private final zztv zzasu;
    private final zzud zzasv;
    private final zzaiu zzasw;
    private final com.google.android.gms.ads.internal.overlay.zzah zzasx;
    private final com.google.android.gms.ads.internal.overlay.zzai zzasy;
    private final zzut zzasz;
    private final zzaiv zzata;
    private final zzbb zzatb;
    private final zzik zzatc;
    private final zzaez zzatd;
    private final zzsk zzate;
    private final zzakf zzatf;

    static {
        zzbv zzbvVar = new zzbv();
        synchronized (zzaqm) {
            zzarz = zzbvVar;
        }
    }

    protected zzbv() {
        int i = Build.VERSION.SDK_INT;
        this.zzasg = i >= 21 ? new zzahu() : i >= 19 ? new zzaht() : i >= 18 ? new zzahr() : i >= 17 ? new zzahq() : i >= 16 ? new zzahs() : new zzahp();
        this.zzash = new zzgz();
        this.zzasi = new zzafn(this.zzase);
        this.zzasj = new zzhv();
        this.zzask = new zzhw();
        this.zzasl = com.google.android.gms.common.util.zzh.zzalc();
        this.zzasm = new zzac();
        this.zzasn = new zzmz();
        this.zzaso = new zzaic();
        this.zzasp = new zzacj();
        this.zzasq = new zzmq();
        this.zzasr = new zzmr();
        this.zzass = new zzms();
        this.zzast = new zzajy();
        this.zzasu = new zztv();
        this.zzasv = new zzud();
        this.zzasw = new zzaiu();
        this.zzasx = new com.google.android.gms.ads.internal.overlay.zzah();
        this.zzasy = new com.google.android.gms.ads.internal.overlay.zzai();
        this.zzasz = new zzut();
        this.zzata = new zzaiv();
        this.zzatb = new zzbb();
        this.zzatc = new zzik();
        this.zzatd = new zzaez();
        this.zzate = new zzsk();
        this.zzatf = new zzakf();
    }

    private static zzbv zzdv() {
        zzbv zzbvVar;
        synchronized (zzaqm) {
            zzbvVar = zzarz;
        }
        return zzbvVar;
    }

    public static zzzu zzdw() {
        return zzdv().zzasb;
    }

    public static com.google.android.gms.ads.internal.overlay.zza zzdx() {
        return zzdv().zzasa;
    }

    public static com.google.android.gms.ads.internal.overlay.zzu zzdy() {
        return zzdv().zzasc;
    }

    public static zzyc zzdz() {
        return zzdv().zzasd;
    }

    public static zzahf zzea() {
        return zzdv().zzase;
    }

    public static zzaku zzeb() {
        return zzdv().zzasf;
    }

    public static zzahk zzec() {
        return zzdv().zzasg;
    }

    public static zzgz zzed() {
        return zzdv().zzash;
    }

    public static zzafn zzee() {
        return zzdv().zzasi;
    }

    public static zzhw zzef() {
        return zzdv().zzask;
    }

    public static com.google.android.gms.common.util.zzd zzeg() {
        return zzdv().zzasl;
    }

    public static zzac zzeh() {
        return zzdv().zzasm;
    }

    public static zzmz zzei() {
        return zzdv().zzasn;
    }

    public static zzaic zzej() {
        return zzdv().zzaso;
    }

    public static zzacj zzek() {
        return zzdv().zzasp;
    }

    public static zzmr zzel() {
        return zzdv().zzasr;
    }

    public static zzmq zzem() {
        return zzdv().zzasq;
    }

    public static zzms zzen() {
        return zzdv().zzass;
    }

    public static zzajy zzeo() {
        return zzdv().zzast;
    }

    public static zztv zzep() {
        return zzdv().zzasu;
    }

    public static zzud zzeq() {
        return zzdv().zzasv;
    }

    public static zzaiu zzer() {
        return zzdv().zzasw;
    }

    public static com.google.android.gms.ads.internal.overlay.zzah zzes() {
        return zzdv().zzasx;
    }

    public static com.google.android.gms.ads.internal.overlay.zzai zzet() {
        return zzdv().zzasy;
    }

    public static zzut zzeu() {
        return zzdv().zzasz;
    }

    public static zzbb zzev() {
        return zzdv().zzatb;
    }

    public static zzaiv zzew() {
        return zzdv().zzata;
    }

    public static zzsk zzex() {
        return zzdv().zzate;
    }

    public static zzakf zzey() {
        return zzdv().zzatf;
    }

    public static zzaez zzez() {
        return zzdv().zzatd;
    }
}

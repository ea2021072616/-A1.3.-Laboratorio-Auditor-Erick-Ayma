package com.google.android.gms.ads.internal;

import android.content.Context;
import android.graphics.Rect;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.internal.zzadj;
import com.google.android.gms.internal.zzafi;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzafk;
import com.google.android.gms.internal.zzaft;
import com.google.android.gms.internal.zzafv;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzahv;
import com.google.android.gms.internal.zzaix;
import com.google.android.gms.internal.zzaje;
import com.google.android.gms.internal.zzajk;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzjb;
import com.google.android.gms.internal.zzjo;
import com.google.android.gms.internal.zzjr;
import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzkk;
import com.google.android.gms.internal.zzkq;
import com.google.android.gms.internal.zzle;
import com.google.android.gms.internal.zzmd;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zznn;
import com.google.android.gms.internal.zzot;
import com.google.android.gms.internal.zzpx;
import com.google.android.gms.internal.zzqa;
import com.google.android.gms.internal.zzqd;
import com.google.android.gms.internal.zzqg;
import com.google.android.gms.internal.zzqj;
import com.google.android.gms.internal.zzzt;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
@zzzt
/* loaded from: classes.dex */
public final class zzbw implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    public final Context zzaie;
    boolean zzapy;
    final String zzatg;
    public String zzath;
    final zzcv zzati;
    public final zzajk zzatj;
    @Nullable
    zzbx zzatk;
    @Nullable
    public zzafv zzatl;
    @Nullable
    public zzahv zzatm;
    public zzjb zzatn;
    @Nullable
    public zzafi zzato;
    public zzafj zzatp;
    @Nullable
    public zzafk zzatq;
    @Nullable
    zzjr zzatr;
    @Nullable
    zzju zzats;
    @Nullable
    zzkk zzatt;
    @Nullable
    zzkq zzatu;
    @Nullable
    zzpx zzatv;
    @Nullable
    zzqa zzatw;
    SimpleArrayMap<String, zzqd> zzatx;
    SimpleArrayMap<String, zzqg> zzaty;
    zzot zzatz;
    @Nullable
    zzmd zzaua;
    @Nullable
    zzle zzaub;
    @Nullable
    zzqj zzauc;
    @Nullable
    List<Integer> zzaud;
    @Nullable
    zznn zzaue;
    @Nullable
    zzadj zzauf;
    @Nullable
    List<String> zzaug;
    @Nullable
    public zzaft zzauh;
    @Nullable
    View zzaui;
    public int zzauj;
    private HashSet<zzafk> zzauk;
    private int zzaul;
    private int zzaum;
    private zzaix zzaun;
    private boolean zzauo;
    private boolean zzaup;
    private boolean zzauq;

    public zzbw(Context context, zzjb zzjbVar, String str, zzajk zzajkVar) {
        this(context, zzjbVar, str, zzajkVar, null);
    }

    private zzbw(Context context, zzjb zzjbVar, String str, zzajk zzajkVar, zzcv zzcvVar) {
        this.zzauh = null;
        this.zzaui = null;
        this.zzauj = 0;
        this.zzapy = false;
        this.zzauk = null;
        this.zzaul = -1;
        this.zzaum = -1;
        this.zzauo = true;
        this.zzaup = true;
        this.zzauq = false;
        zzmu.initialize(context);
        if (zzbv.zzee().zzpt() != null) {
            List<String> zzim = zzmu.zzim();
            if (zzajkVar.zzdel != 0) {
                zzim.add(Integer.toString(zzajkVar.zzdel));
            }
            zzbv.zzee().zzpt().zzf(zzim);
        }
        this.zzatg = UUID.randomUUID().toString();
        if (zzjbVar.zzbcr || zzjbVar.zzbct) {
            this.zzatk = null;
        } else {
            this.zzatk = new zzbx(context, str, zzajkVar.zzcp, this, this);
            this.zzatk.setMinimumWidth(zzjbVar.widthPixels);
            this.zzatk.setMinimumHeight(zzjbVar.heightPixels);
            this.zzatk.setVisibility(4);
        }
        this.zzatn = zzjbVar;
        this.zzath = str;
        this.zzaie = context;
        this.zzatj = zzajkVar;
        this.zzati = new zzcv(new zzah(this));
        this.zzaun = new zzaix(200L);
        this.zzaty = new SimpleArrayMap<>();
    }

    private final void zze(boolean z) {
        View findViewById;
        if (this.zzatk == null || this.zzato == null || this.zzato.zzcgz == null || this.zzato.zzcgz.zzsb() == null) {
            return;
        }
        if (!z || this.zzaun.tryAcquire()) {
            if (this.zzato.zzcgz.zzsb().zzfo()) {
                int[] iArr = new int[2];
                this.zzatk.getLocationOnScreen(iArr);
                zzjo.zzhu();
                int zzd = zzaje.zzd(this.zzaie, iArr[0]);
                zzjo.zzhu();
                int zzd2 = zzaje.zzd(this.zzaie, iArr[1]);
                if (zzd != this.zzaul || zzd2 != this.zzaum) {
                    this.zzaul = zzd;
                    this.zzaum = zzd2;
                    this.zzato.zzcgz.zzsb().zza(this.zzaul, this.zzaum, z ? false : true);
                }
            }
            if (this.zzatk == null || (findViewById = this.zzatk.getRootView().findViewById(16908290)) == null) {
                return;
            }
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            this.zzatk.getGlobalVisibleRect(rect);
            findViewById.getGlobalVisibleRect(rect2);
            if (rect.top != rect2.top) {
                this.zzauo = false;
            }
            if (rect.bottom != rect2.bottom) {
                this.zzaup = false;
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        zze(false);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        zze(true);
        this.zzauq = true;
    }

    public final void zza(HashSet<zzafk> hashSet) {
        this.zzauk = hashSet;
    }

    public final void zzf(boolean z) {
        if (this.zzauj == 0 && this.zzato != null && this.zzato.zzcgz != null) {
            this.zzato.zzcgz.stopLoading();
        }
        if (this.zzatl != null) {
            this.zzatl.cancel();
        }
        if (this.zzatm != null) {
            this.zzatm.cancel();
        }
        if (z) {
            this.zzato = null;
        }
    }

    public final HashSet<zzafk> zzfa() {
        return this.zzauk;
    }

    public final void zzfb() {
        if (this.zzato == null || this.zzato.zzcgz == null) {
            return;
        }
        this.zzato.zzcgz.destroy();
    }

    public final void zzfc() {
        if (this.zzato == null || this.zzato.zzccb == null) {
            return;
        }
        try {
            this.zzato.zzccb.destroy();
        } catch (RemoteException e) {
            zzafx.zzcs("Could not destroy mediation adapter.");
        }
    }

    public final boolean zzfd() {
        return this.zzauj == 0;
    }

    public final boolean zzfe() {
        return this.zzauj == 1;
    }

    public final String zzff() {
        return (this.zzauo && this.zzaup) ? "" : this.zzauo ? this.zzauq ? "top-scrollable" : "top-locked" : this.zzaup ? this.zzauq ? "bottom-scrollable" : "bottom-locked" : "";
    }
}

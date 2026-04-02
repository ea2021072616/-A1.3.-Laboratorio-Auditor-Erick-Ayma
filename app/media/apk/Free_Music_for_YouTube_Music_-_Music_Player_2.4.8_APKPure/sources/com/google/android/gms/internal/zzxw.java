package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.internal.zzbp;
import java.util.concurrent.atomic.AtomicBoolean;
@zzzt
/* loaded from: classes.dex */
public abstract class zzxw implements zzahv<Void>, zzakp {
    protected final Context mContext;
    protected final zzakk zzbvz;
    private zzyd zzcki;
    private zzafj zzckj;
    protected zzaao zzckk;
    private Runnable zzckl;
    private Object zzckm = new Object();
    private AtomicBoolean zzckn = new AtomicBoolean(true);

    /* JADX INFO: Access modifiers changed from: protected */
    public zzxw(Context context, zzafj zzafjVar, zzakk zzakkVar, zzyd zzydVar) {
        this.mContext = context;
        this.zzckj = zzafjVar;
        this.zzckk = this.zzckj.zzcyp;
        this.zzbvz = zzakkVar;
        this.zzcki = zzydVar;
    }

    @Override // com.google.android.gms.internal.zzahv
    public void cancel() {
        if (this.zzckn.getAndSet(false)) {
            this.zzbvz.stopLoading();
            com.google.android.gms.ads.internal.zzbv.zzec();
            zzahk.zzk(this.zzbvz);
            zzw(-1);
            zzahf.zzdbo.removeCallbacks(this.zzckl);
        }
    }

    @Override // com.google.android.gms.internal.zzakp
    public final void zza(zzakk zzakkVar, boolean z) {
        zzafx.zzcb("WebView finished loading.");
        if (this.zzckn.getAndSet(false)) {
            zzw(z ? -2 : 0);
            zzahf.zzdbo.removeCallbacks(this.zzckl);
        }
    }

    protected abstract void zznr();

    @Override // com.google.android.gms.internal.zzahv
    public final /* synthetic */ Void zzns() {
        zzbp.zzfx("Webview render task needs to be called on UI thread.");
        this.zzckl = new zzxx(this);
        zzahf.zzdbo.postDelayed(this.zzckl, ((Long) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbln)).longValue());
        zznr();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzw(int i) {
        if (i != -2) {
            this.zzckk = new zzaao(i, this.zzckk.zzcba);
        }
        this.zzbvz.zzrw();
        zzyd zzydVar = this.zzcki;
        zzaak zzaakVar = this.zzckj.zzcrj;
        zzydVar.zzb(new zzafi(zzaakVar.zzcnw, this.zzbvz, this.zzckk.zzcau, i, this.zzckk.zzcav, this.zzckk.zzcpq, this.zzckk.orientation, this.zzckk.zzcba, zzaakVar.zzcnz, this.zzckk.zzcpo, null, null, null, null, null, this.zzckk.zzcpp, this.zzckj.zzatn, this.zzckk.zzcpn, this.zzckj.zzcyi, this.zzckk.zzcps, this.zzckk.zzcpt, this.zzckj.zzcyc, null, this.zzckk.zzcqd, this.zzckk.zzcqe, this.zzckk.zzcqf, this.zzckk.zzcqg, this.zzckk.zzcqh, null, this.zzckk.zzcax, this.zzckk.zzcqk, this.zzckj.zzcyo));
    }
}

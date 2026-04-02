package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbo;
import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzakv implements Callable<zzakk> {
    private /* synthetic */ Context zzaok;
    private /* synthetic */ zzjb zzbde;
    private /* synthetic */ zzajk zzbyh;
    private /* synthetic */ com.google.android.gms.ads.internal.zzv zzbyj;
    private /* synthetic */ zzcv zzbyy;
    private /* synthetic */ boolean zzdgl;
    private /* synthetic */ boolean zzdgm;
    private /* synthetic */ zznh zzdgn;
    private /* synthetic */ zzbo zzdgo;
    private /* synthetic */ zzil zzdgp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzakv(zzaku zzakuVar, Context context, zzjb zzjbVar, boolean z, boolean z2, zzcv zzcvVar, zzajk zzajkVar, zznh zznhVar, zzbo zzboVar, com.google.android.gms.ads.internal.zzv zzvVar, zzil zzilVar) {
        this.zzaok = context;
        this.zzbde = zzjbVar;
        this.zzdgl = z;
        this.zzdgm = z2;
        this.zzbyy = zzcvVar;
        this.zzbyh = zzajkVar;
        this.zzdgn = zznhVar;
        this.zzdgo = zzboVar;
        this.zzbyj = zzvVar;
        this.zzdgp = zzilVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzakk call() throws Exception {
        zzakx zzakxVar = new zzakx(zzaky.zzb(this.zzaok, this.zzbde, this.zzdgl, this.zzdgm, this.zzbyy, this.zzbyh, this.zzdgn, this.zzdgo, this.zzbyj, this.zzdgp));
        zzakxVar.setWebViewClient(com.google.android.gms.ads.internal.zzbv.zzec().zzb(zzakxVar, this.zzdgm));
        zzakxVar.setWebChromeClient(com.google.android.gms.ads.internal.zzbv.zzec().zzm(zzakxVar));
        return zzakxVar;
    }
}

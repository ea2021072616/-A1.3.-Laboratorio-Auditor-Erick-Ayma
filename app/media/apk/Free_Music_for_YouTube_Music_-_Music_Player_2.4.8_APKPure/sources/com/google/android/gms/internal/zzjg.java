package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.internal.zzjf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzjg extends zzjf.zza<zzkf> {
    private /* synthetic */ String zzaoi;
    private /* synthetic */ Context zzaok;
    private /* synthetic */ zzjb zzbde;
    private /* synthetic */ zzva zzbdf;
    private /* synthetic */ zzjf zzbdg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzjg(zzjf zzjfVar, Context context, zzjb zzjbVar, String str, zzva zzvaVar) {
        super();
        this.zzbdg = zzjfVar;
        this.zzaok = context;
        this.zzbde = zzjbVar;
        this.zzaoi = str;
        this.zzbdf = zzvaVar;
    }

    @Override // com.google.android.gms.internal.zzjf.zza
    public final /* synthetic */ zzkf zza(zzkn zzknVar) throws RemoteException {
        return zzknVar.createBannerAdManager(com.google.android.gms.dynamic.zzn.zzw(this.zzaok), this.zzbde, this.zzaoi, this.zzbdf, 11200000);
    }

    @Override // com.google.android.gms.internal.zzjf.zza
    public final /* synthetic */ zzkf zzhq() throws RemoteException {
        zziw zziwVar;
        zziwVar = this.zzbdg.zzbcy;
        zzkf zza = zziwVar.zza(this.zzaok, this.zzbde, this.zzaoi, this.zzbdf, 1);
        if (zza != null) {
            return zza;
        }
        zzjf zzjfVar = this.zzbdg;
        zzjf.zzb(this.zzaok, "banner");
        return new zzlt();
    }
}

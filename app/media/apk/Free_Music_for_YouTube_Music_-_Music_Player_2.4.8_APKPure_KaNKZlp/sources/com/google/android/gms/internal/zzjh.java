package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.internal.zzjf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzjh extends zzjf.zza<zzkf> {
    private /* synthetic */ String zzaoi;
    private /* synthetic */ Context zzaok;
    private /* synthetic */ zzjb zzbde;
    private /* synthetic */ zzjf zzbdg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzjh(zzjf zzjfVar, Context context, zzjb zzjbVar, String str) {
        super();
        this.zzbdg = zzjfVar;
        this.zzaok = context;
        this.zzbde = zzjbVar;
        this.zzaoi = str;
    }

    @Override // com.google.android.gms.internal.zzjf.zza
    public final /* synthetic */ zzkf zza(zzkn zzknVar) throws RemoteException {
        return zzknVar.createSearchAdManager(com.google.android.gms.dynamic.zzn.zzw(this.zzaok), this.zzbde, this.zzaoi, 11200000);
    }

    @Override // com.google.android.gms.internal.zzjf.zza
    public final /* synthetic */ zzkf zzhq() throws RemoteException {
        zziw zziwVar;
        zziwVar = this.zzbdg.zzbcy;
        zzkf zza = zziwVar.zza(this.zzaok, this.zzbde, this.zzaoi, null, 3);
        if (zza != null) {
            return zza;
        }
        zzjf zzjfVar = this.zzbdg;
        zzjf.zzb(this.zzaok, "search");
        return new zzlt();
    }
}

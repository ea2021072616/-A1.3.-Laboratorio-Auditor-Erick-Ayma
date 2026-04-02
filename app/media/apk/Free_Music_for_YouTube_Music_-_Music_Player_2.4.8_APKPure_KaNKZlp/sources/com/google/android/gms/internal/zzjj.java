package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.internal.zzjf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzjj extends zzjf.zza<zzka> {
    private /* synthetic */ String zzaoi;
    private /* synthetic */ Context zzaok;
    private /* synthetic */ zzva zzbdf;
    private /* synthetic */ zzjf zzbdg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzjj(zzjf zzjfVar, Context context, String str, zzva zzvaVar) {
        super();
        this.zzbdg = zzjfVar;
        this.zzaok = context;
        this.zzaoi = str;
        this.zzbdf = zzvaVar;
    }

    @Override // com.google.android.gms.internal.zzjf.zza
    public final /* synthetic */ zzka zza(zzkn zzknVar) throws RemoteException {
        return zzknVar.createAdLoaderBuilder(com.google.android.gms.dynamic.zzn.zzw(this.zzaok), this.zzaoi, this.zzbdf, 11200000);
    }

    @Override // com.google.android.gms.internal.zzjf.zza
    public final /* synthetic */ zzka zzhq() throws RemoteException {
        zziv zzivVar;
        zzivVar = this.zzbdg.zzbcz;
        zzka zza = zzivVar.zza(this.zzaok, this.zzaoi, this.zzbdf);
        if (zza != null) {
            return zza;
        }
        zzjf zzjfVar = this.zzbdg;
        zzjf.zzb(this.zzaok, "native_ad");
        return new zzlp();
    }
}

package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.internal.zzjf;
/* loaded from: classes2.dex */
final class zzjm extends zzjf.zza<zzade> {
    private /* synthetic */ Context zzaok;
    private /* synthetic */ zzva zzbdf;
    private /* synthetic */ zzjf zzbdg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzjm(zzjf zzjfVar, Context context, zzva zzvaVar) {
        super();
        this.zzbdg = zzjfVar;
        this.zzaok = context;
        this.zzbdf = zzvaVar;
    }

    @Override // com.google.android.gms.internal.zzjf.zza
    public final /* synthetic */ zzade zza(zzkn zzknVar) throws RemoteException {
        return zzknVar.createRewardedVideoAd(com.google.android.gms.dynamic.zzn.zzw(this.zzaok), this.zzbdf, 11200000);
    }

    @Override // com.google.android.gms.internal.zzjf.zza
    public final /* synthetic */ zzade zzhq() throws RemoteException {
        zzadn zzadnVar;
        zzadnVar = this.zzbdg.zzbdc;
        zzade zza = zzadnVar.zza(this.zzaok, this.zzbdf);
        if (zza != null) {
            return zza;
        }
        zzjf zzjfVar = this.zzbdg;
        zzjf.zzb(this.zzaok, "rewarded_video");
        return new zzlx();
    }
}

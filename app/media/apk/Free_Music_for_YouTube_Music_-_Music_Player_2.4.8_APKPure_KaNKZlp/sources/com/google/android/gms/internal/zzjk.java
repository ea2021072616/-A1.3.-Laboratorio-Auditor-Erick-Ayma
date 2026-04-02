package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.internal.zzjf;
/* loaded from: classes2.dex */
final class zzjk extends zzjf.zza<zzkt> {
    private /* synthetic */ Context zzaok;
    private /* synthetic */ zzjf zzbdg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzjk(zzjf zzjfVar, Context context) {
        super();
        this.zzbdg = zzjfVar;
        this.zzaok = context;
    }

    @Override // com.google.android.gms.internal.zzjf.zza
    public final /* synthetic */ zzkt zza(zzkn zzknVar) throws RemoteException {
        return zzknVar.getMobileAdsSettingsManagerWithClientJarVersion(com.google.android.gms.dynamic.zzn.zzw(this.zzaok), 11200000);
    }

    @Override // com.google.android.gms.internal.zzjf.zza
    public final /* synthetic */ zzkt zzhq() throws RemoteException {
        zzlo zzloVar;
        zzloVar = this.zzbdg.zzbda;
        zzkt zzj = zzloVar.zzj(this.zzaok);
        if (zzj != null) {
            return zzj;
        }
        zzjf zzjfVar = this.zzbdg;
        zzjf.zzb(this.zzaok, "mobile_ads_settings");
        return new zzlv();
    }
}

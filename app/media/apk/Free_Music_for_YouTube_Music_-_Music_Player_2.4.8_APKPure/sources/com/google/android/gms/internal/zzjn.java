package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.internal.zzjf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzjn extends zzjf.zza<zzxg> {
    private /* synthetic */ Activity val$activity;
    private /* synthetic */ zzjf zzbdg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzjn(zzjf zzjfVar, Activity activity) {
        super();
        this.zzbdg = zzjfVar;
        this.val$activity = activity;
    }

    @Override // com.google.android.gms.internal.zzjf.zza
    public final /* synthetic */ zzxg zza(zzkn zzknVar) throws RemoteException {
        return zzknVar.createAdOverlay(com.google.android.gms.dynamic.zzn.zzw(this.val$activity));
    }

    @Override // com.google.android.gms.internal.zzjf.zza
    public final /* synthetic */ zzxg zzhq() throws RemoteException {
        zzxf zzxfVar;
        zzxfVar = this.zzbdg.zzbdd;
        zzxg zze = zzxfVar.zze(this.val$activity);
        if (zze != null) {
            return zze;
        }
        zzjf zzjfVar = this.zzbdg;
        zzjf.zzb(this.val$activity, "ad_overlay");
        return null;
    }
}

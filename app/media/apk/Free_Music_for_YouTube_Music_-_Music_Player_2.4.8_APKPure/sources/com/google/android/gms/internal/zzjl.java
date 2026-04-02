package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.internal.zzjf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzjl extends zzjf.zza<zzpg> {
    private /* synthetic */ Context zzaok;
    private /* synthetic */ zzjf zzbdg;
    private /* synthetic */ FrameLayout zzbdh;
    private /* synthetic */ FrameLayout zzbdi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzjl(zzjf zzjfVar, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
        super();
        this.zzbdg = zzjfVar;
        this.zzbdh = frameLayout;
        this.zzbdi = frameLayout2;
        this.zzaok = context;
    }

    @Override // com.google.android.gms.internal.zzjf.zza
    public final /* synthetic */ zzpg zza(zzkn zzknVar) throws RemoteException {
        return zzknVar.createNativeAdViewDelegate(com.google.android.gms.dynamic.zzn.zzw(this.zzbdh), com.google.android.gms.dynamic.zzn.zzw(this.zzbdi));
    }

    @Override // com.google.android.gms.internal.zzjf.zza
    public final /* synthetic */ zzpg zzhq() throws RemoteException {
        zzqm zzqmVar;
        zzqmVar = this.zzbdg.zzbdb;
        zzpg zzb = zzqmVar.zzb(this.zzaok, this.zzbdh, this.zzbdi);
        if (zzb != null) {
            return zzb;
        }
        zzjf zzjfVar = this.zzbdg;
        zzjf.zzb(this.zzaok, "native_ad_view_delegate");
        return new zzlw();
    }
}

package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
@zzzt
/* loaded from: classes.dex */
public final class zziw extends com.google.android.gms.dynamic.zzp<zzki> {
    public zziw() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public final zzkf zza(Context context, zzjb zzjbVar, String str, zzva zzvaVar, int i) {
        zzkf zzkhVar;
        try {
            IBinder zza = zzcv(context).zza(com.google.android.gms.dynamic.zzn.zzw(context), zzjbVar, str, zzvaVar, 11200000, i);
            if (zza == null) {
                zzkhVar = null;
            } else {
                IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
                zzkhVar = queryLocalInterface instanceof zzkf ? (zzkf) queryLocalInterface : new zzkh(zza);
            }
            return zzkhVar;
        } catch (RemoteException | com.google.android.gms.dynamic.zzq e) {
            zzaji.zza("Could not create remote AdManager.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.dynamic.zzp
    protected final /* synthetic */ zzki zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        return queryLocalInterface instanceof zzki ? (zzki) queryLocalInterface : new zzkj(iBinder);
    }
}

package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.widget.FrameLayout;
@zzzt
/* loaded from: classes.dex */
public final class zzqm extends com.google.android.gms.dynamic.zzp<zzpj> {
    public zzqm() {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    public final zzpg zzb(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        zzpg zzpiVar;
        try {
            IBinder zza = zzcv(context).zza(com.google.android.gms.dynamic.zzn.zzw(context), com.google.android.gms.dynamic.zzn.zzw(frameLayout), com.google.android.gms.dynamic.zzn.zzw(frameLayout2), 11200000);
            if (zza == null) {
                zzpiVar = null;
            } else {
                IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
                zzpiVar = queryLocalInterface instanceof zzpg ? (zzpg) queryLocalInterface : new zzpi(zza);
            }
            return zzpiVar;
        } catch (RemoteException | com.google.android.gms.dynamic.zzq e) {
            zzaji.zzc("Could not create remote NativeAdViewDelegate.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.dynamic.zzp
    protected final /* synthetic */ zzpj zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
        return queryLocalInterface instanceof zzpj ? (zzpj) queryLocalInterface : new zzpk(iBinder);
    }
}

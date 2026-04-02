package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
@zzzt
/* loaded from: classes.dex */
public final class zzxf extends com.google.android.gms.dynamic.zzp<zzxj> {
    public zzxf() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.zzp
    protected final /* synthetic */ zzxj zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        return queryLocalInterface instanceof zzxj ? (zzxj) queryLocalInterface : new zzxk(iBinder);
    }

    public final zzxg zze(Activity activity) {
        zzxg zzxiVar;
        try {
            IBinder zzp = zzcv(activity).zzp(com.google.android.gms.dynamic.zzn.zzw(activity));
            if (zzp == null) {
                zzxiVar = null;
            } else {
                IInterface queryLocalInterface = zzp.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
                zzxiVar = queryLocalInterface instanceof zzxg ? (zzxg) queryLocalInterface : new zzxi(zzp);
            }
            return zzxiVar;
        } catch (RemoteException e) {
            zzaji.zzc("Could not create remote AdOverlay.", e);
            return null;
        } catch (com.google.android.gms.dynamic.zzq e2) {
            zzaji.zzc("Could not create remote AdOverlay.", e2);
            return null;
        }
    }
}

package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
@zzzt
/* loaded from: classes.dex */
public final class zzey extends com.google.android.gms.dynamic.zzp<zzfc> {
    private static final zzey zzall = new zzey();

    private zzey() {
        super("com.google.android.gms.ads.adshield.AdShieldCreatorImpl");
    }

    public static zzez zzb(String str, Context context, boolean z) {
        zzez zzc;
        return (com.google.android.gms.common.zze.zzaew().isGooglePlayServicesAvailable(context) != 0 || (zzc = zzall.zzc(str, context, false)) == null) ? new zzex(str, context, false) : zzc;
    }

    private final zzez zzc(String str, Context context, boolean z) {
        IObjectWrapper zzw = com.google.android.gms.dynamic.zzn.zzw(context);
        try {
            IBinder zza = z ? zzcv(context).zza(str, zzw) : zzcv(context).zzb(str, zzw);
            if (zza == null) {
                return null;
            }
            IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
            return queryLocalInterface instanceof zzez ? (zzez) queryLocalInterface : new zzfb(zza);
        } catch (RemoteException | com.google.android.gms.dynamic.zzq e) {
            return null;
        }
    }

    @Override // com.google.android.gms.dynamic.zzp
    protected final /* synthetic */ zzfc zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.adshield.internal.IAdShieldCreator");
        return queryLocalInterface instanceof zzfc ? (zzfc) queryLocalInterface : new zzfd(iBinder);
    }
}

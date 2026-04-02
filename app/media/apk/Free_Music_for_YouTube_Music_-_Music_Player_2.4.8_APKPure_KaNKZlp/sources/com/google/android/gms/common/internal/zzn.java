package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.support.annotation.BinderThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
/* loaded from: classes.dex */
public final class zzn extends zze {
    private /* synthetic */ zzd zzftf;
    private IBinder zzftj;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @BinderThread
    public zzn(zzd zzdVar, int i, IBinder iBinder, Bundle bundle) {
        super(zzdVar, i, bundle);
        this.zzftf = zzdVar;
        this.zzftj = iBinder;
    }

    @Override // com.google.android.gms.common.internal.zze
    protected final boolean zzajn() {
        boolean zza;
        zzf zzfVar;
        zzf zzfVar2;
        boolean zza2;
        try {
            String interfaceDescriptor = this.zzftj.getInterfaceDescriptor();
            if (!this.zzftf.zzhd().equals(interfaceDescriptor)) {
                String zzhd = this.zzftf.zzhd();
                Log.e("GmsClient", new StringBuilder(String.valueOf(zzhd).length() + 34 + String.valueOf(interfaceDescriptor).length()).append("service descriptor mismatch: ").append(zzhd).append(" vs. ").append(interfaceDescriptor).toString());
                return false;
            }
            IInterface zze = this.zzftf.zze(this.zzftj);
            if (zze != null) {
                zza = this.zzftf.zza(2, 4, (int) zze);
                if (!zza) {
                    zza2 = this.zzftf.zza(3, 4, (int) zze);
                    if (!zza2) {
                        return false;
                    }
                }
                this.zzftf.zzfta = null;
                Bundle zzaeg = this.zzftf.zzaeg();
                zzfVar = this.zzftf.zzfsw;
                if (zzfVar != null) {
                    zzfVar2 = this.zzftf.zzfsw;
                    zzfVar2.onConnected(zzaeg);
                }
                return true;
            }
            return false;
        } catch (RemoteException e) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }

    @Override // com.google.android.gms.common.internal.zze
    protected final void zzj(ConnectionResult connectionResult) {
        zzg zzgVar;
        zzg zzgVar2;
        zzgVar = this.zzftf.zzfsx;
        if (zzgVar != null) {
            zzgVar2 = this.zzftf.zzfsx;
            zzgVar2.onConnectionFailed(connectionResult);
        }
        this.zzftf.onConnectionFailed(connectionResult);
    }
}

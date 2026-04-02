package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzh extends Handler {
    private /* synthetic */ zzd zzftf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzh(zzd zzdVar, Looper looper) {
        super(looper);
        this.zzftf = zzdVar;
    }

    private static void zza(Message message) {
        ((zzi) message.obj).unregister();
    }

    private static boolean zzb(Message message) {
        return message.what == 2 || message.what == 1 || message.what == 7;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        zzf zzfVar;
        zzf zzfVar2;
        ConnectionResult connectionResult;
        boolean zzajm;
        ConnectionResult connectionResult2;
        boolean z;
        if (this.zzftf.zzftc.get() != message.arg1) {
            if (zzb(message)) {
                zza(message);
            }
        } else if ((message.what == 1 || message.what == 7 || message.what == 4 || message.what == 5) && !this.zzftf.isConnecting()) {
            zza(message);
        } else if (message.what == 4) {
            this.zzftf.zzfta = new ConnectionResult(message.arg2);
            zzajm = this.zzftf.zzajm();
            if (zzajm) {
                z = this.zzftf.zzftb;
                if (!z) {
                    this.zzftf.zza(3, (int) null);
                    return;
                }
            }
            connectionResult2 = this.zzftf.zzfta;
            ConnectionResult connectionResult3 = connectionResult2 != null ? this.zzftf.zzfta : new ConnectionResult(8);
            this.zzftf.zzfsr.zzf(connectionResult3);
            this.zzftf.onConnectionFailed(connectionResult3);
        } else if (message.what == 5) {
            connectionResult = this.zzftf.zzfta;
            ConnectionResult connectionResult4 = connectionResult != null ? this.zzftf.zzfta : new ConnectionResult(8);
            this.zzftf.zzfsr.zzf(connectionResult4);
            this.zzftf.onConnectionFailed(connectionResult4);
        } else if (message.what == 3) {
            ConnectionResult connectionResult5 = new ConnectionResult(message.arg2, message.obj instanceof PendingIntent ? (PendingIntent) message.obj : null);
            this.zzftf.zzfsr.zzf(connectionResult5);
            this.zzftf.onConnectionFailed(connectionResult5);
        } else if (message.what == 6) {
            this.zzftf.zza(5, (int) null);
            zzfVar = this.zzftf.zzfsw;
            if (zzfVar != null) {
                zzfVar2 = this.zzftf.zzfsw;
                zzfVar2.onConnectionSuspended(message.arg2);
            }
            this.zzftf.onConnectionSuspended(message.arg2);
            this.zzftf.zza(5, 1, (int) null);
        } else if (message.what == 2 && !this.zzftf.isConnected()) {
            zza(message);
        } else if (zzb(message)) {
            ((zzi) message.obj).zzajo();
        } else {
            Log.wtf("GmsClient", new StringBuilder(45).append("Don't know how to handle message: ").append(message.what).toString(), new Exception());
        }
    }
}

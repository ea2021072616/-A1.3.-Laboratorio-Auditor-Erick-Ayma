package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes.dex */
public final class zzl implements ServiceConnection {
    private /* synthetic */ zzd zzftf;
    private final int zzfti;

    public zzl(zzd zzdVar, int i) {
        this.zzftf = zzdVar;
        this.zzfti = i;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Object obj;
        zzax zzayVar;
        if (iBinder == null) {
            this.zzftf.zzcc(16);
            return;
        }
        obj = this.zzftf.zzfsp;
        synchronized (obj) {
            zzd zzdVar = this.zzftf;
            if (iBinder == null) {
                zzayVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                zzayVar = (queryLocalInterface == null || !(queryLocalInterface instanceof zzax)) ? new zzay(iBinder) : (zzax) queryLocalInterface;
            }
            zzdVar.zzfsq = zzayVar;
        }
        this.zzftf.zza(0, (Bundle) null, this.zzfti);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Object obj;
        obj = this.zzftf.zzfsp;
        synchronized (obj) {
            this.zzftf.zzfsq = null;
        }
        this.zzftf.mHandler.sendMessage(this.zzftf.mHandler.obtainMessage(6, this.zzfti, 1));
    }
}

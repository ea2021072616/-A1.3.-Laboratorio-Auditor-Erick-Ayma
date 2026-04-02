package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.exoplayer2.ExoPlayerFactory;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzah extends zzaf implements Handler.Callback {
    private final Context mApplicationContext;
    private final Handler mHandler;
    private final HashMap<zzag, zzai> zzfus = new HashMap<>();
    private final com.google.android.gms.common.stats.zza zzfut = com.google.android.gms.common.stats.zza.zzaky();
    private final long zzfuu = ExoPlayerFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS;
    private final long zzfuv = 300000;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzah(Context context) {
        this.mApplicationContext = context.getApplicationContext();
        this.mHandler = new Handler(context.getMainLooper(), this);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                synchronized (this.zzfus) {
                    zzag zzagVar = (zzag) message.obj;
                    zzai zzaiVar = this.zzfus.get(zzagVar);
                    if (zzaiVar != null && zzaiVar.zzaki()) {
                        if (zzaiVar.isBound()) {
                            zzaiVar.zzgc("GmsClientSupervisor");
                        }
                        this.zzfus.remove(zzagVar);
                    }
                }
                return true;
            case 1:
                synchronized (this.zzfus) {
                    zzag zzagVar2 = (zzag) message.obj;
                    zzai zzaiVar2 = this.zzfus.get(zzagVar2);
                    if (zzaiVar2 != null && zzaiVar2.getState() == 3) {
                        String valueOf = String.valueOf(zzagVar2);
                        Log.wtf("GmsClientSupervisor", new StringBuilder(String.valueOf(valueOf).length() + 47).append("Timeout waiting for ServiceConnection callback ").append(valueOf).toString(), new Exception());
                        ComponentName componentName = zzaiVar2.getComponentName();
                        if (componentName == null) {
                            componentName = zzagVar2.getComponentName();
                        }
                        zzaiVar2.onServiceDisconnected(componentName == null ? new ComponentName(zzagVar2.getPackage(), "unknown") : componentName);
                    }
                }
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzaf
    public final boolean zza(zzag zzagVar, ServiceConnection serviceConnection, String str) {
        boolean isBound;
        zzbp.zzb(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zzfus) {
            zzai zzaiVar = this.zzfus.get(zzagVar);
            if (zzaiVar != null) {
                this.mHandler.removeMessages(0, zzagVar);
                if (!zzaiVar.zza(serviceConnection)) {
                    zzaiVar.zza(serviceConnection, str);
                    switch (zzaiVar.getState()) {
                        case 1:
                            serviceConnection.onServiceConnected(zzaiVar.getComponentName(), zzaiVar.getBinder());
                            break;
                        case 2:
                            zzaiVar.zzgb(str);
                            break;
                    }
                } else {
                    String valueOf = String.valueOf(zzagVar);
                    throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 81).append("Trying to bind a GmsServiceConnection that was already connected before.  config=").append(valueOf).toString());
                }
            } else {
                zzaiVar = new zzai(this, zzagVar);
                zzaiVar.zza(serviceConnection, str);
                zzaiVar.zzgb(str);
                this.zzfus.put(zzagVar, zzaiVar);
            }
            isBound = zzaiVar.isBound();
        }
        return isBound;
    }

    @Override // com.google.android.gms.common.internal.zzaf
    protected final void zzb(zzag zzagVar, ServiceConnection serviceConnection, String str) {
        zzbp.zzb(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zzfus) {
            zzai zzaiVar = this.zzfus.get(zzagVar);
            if (zzaiVar == null) {
                String valueOf = String.valueOf(zzagVar);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 50).append("Nonexistent connection status for service config: ").append(valueOf).toString());
            } else if (!zzaiVar.zza(serviceConnection)) {
                String valueOf2 = String.valueOf(zzagVar);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf2).length() + 76).append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=").append(valueOf2).toString());
            } else {
                zzaiVar.zzb(serviceConnection, str);
                if (zzaiVar.zzaki()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, zzagVar), this.zzfuu);
                }
            }
        }
    }
}

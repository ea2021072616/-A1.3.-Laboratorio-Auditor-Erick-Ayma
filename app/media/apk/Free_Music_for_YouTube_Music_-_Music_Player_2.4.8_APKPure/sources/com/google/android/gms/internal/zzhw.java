package com.google.android.gms.internal;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
@zzzt
/* loaded from: classes.dex */
public final class zzhw {
    @Nullable
    private Context mContext;
    @Nullable
    private zzid zzbag;
    @Nullable
    private zzih zzbah;
    private final Runnable zzbaf = new zzhx(this);
    private final Object mLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    public final void connect() {
        synchronized (this.mLock) {
            if (this.mContext == null || this.zzbag != null) {
                return;
            }
            this.zzbag = new zzid(this.mContext, com.google.android.gms.ads.internal.zzbv.zzer().zzrj(), new zzhz(this), new zzia(this));
            this.zzbag.zzajf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disconnect() {
        synchronized (this.mLock) {
            if (this.zzbag == null) {
                return;
            }
            if (this.zzbag.isConnected() || this.zzbag.isConnecting()) {
                this.zzbag.disconnect();
            }
            this.zzbag = null;
            this.zzbah = null;
            Binder.flushPendingCommands();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzid zza(zzhw zzhwVar, zzid zzidVar) {
        zzhwVar.zzbag = null;
        return null;
    }

    public final void initialize(Context context) {
        if (context == null) {
            return;
        }
        synchronized (this.mLock) {
            if (this.mContext != null) {
                return;
            }
            this.mContext = context.getApplicationContext();
            if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbom)).booleanValue()) {
                connect();
            } else {
                if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbol)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzbv.zzed().zza(new zzhy(this));
                }
            }
        }
    }

    public final zzib zza(zzie zzieVar) {
        zzib zzibVar;
        synchronized (this.mLock) {
            if (this.zzbah == null) {
                zzibVar = new zzib();
            } else {
                try {
                    zzibVar = this.zzbah.zza(zzieVar);
                } catch (RemoteException e) {
                    zzafx.zzb("Unable to call into cache service.", e);
                    zzibVar = new zzib();
                }
            }
        }
        return zzibVar;
    }

    public final void zzgy() {
        if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbon)).booleanValue()) {
            synchronized (this.mLock) {
                connect();
                com.google.android.gms.ads.internal.zzbv.zzea();
                zzahf.zzdbo.removeCallbacks(this.zzbaf);
                com.google.android.gms.ads.internal.zzbv.zzea();
                zzahf.zzdbo.postDelayed(this.zzbaf, ((Long) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzboo)).longValue());
            }
        }
    }
}

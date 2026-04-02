package com.google.android.gms.internal;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.support.annotation.NonNull;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.ConnectionResult;
@zzzt
/* loaded from: classes.dex */
public final class zzaai extends zzaae implements com.google.android.gms.common.internal.zzf, com.google.android.gms.common.internal.zzg {
    private Context mContext;
    private final Object mLock;
    private zzajk zzapc;
    private zzajz<zzaak> zzcnp;
    private final zzaac zzcnq;
    private zzaaj zzcnt;

    public zzaai(Context context, zzajk zzajkVar, zzajz<zzaak> zzajzVar, zzaac zzaacVar) {
        super(zzajzVar, zzaacVar);
        this.mLock = new Object();
        this.mContext = context;
        this.zzapc = zzajkVar;
        this.zzcnp = zzajzVar;
        this.zzcnq = zzaacVar;
        this.zzcnt = new zzaaj(context, ((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbhl)).booleanValue() ? com.google.android.gms.ads.internal.zzbv.zzer().zzrj() : context.getMainLooper(), this, this, this.zzapc.zzdem);
        this.zzcnt.zzajf();
    }

    @Override // com.google.android.gms.common.internal.zzf
    public final void onConnected(Bundle bundle) {
        zzns();
    }

    @Override // com.google.android.gms.common.internal.zzg
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zzafx.zzcb("Cannot connect to remote service, fallback to local instance.");
        new zzaah(this.mContext, this.zzcnp, this.zzcnq).zzns();
        Bundle bundle = new Bundle();
        bundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "gms_connection_failed_fallback_to_local");
        com.google.android.gms.ads.internal.zzbv.zzea().zzb(this.mContext, this.zzapc.zzcp, "gmob-apps", bundle, true);
    }

    @Override // com.google.android.gms.common.internal.zzf
    public final void onConnectionSuspended(int i) {
        zzafx.zzcb("Disconnected from remote ad request service.");
    }

    @Override // com.google.android.gms.internal.zzaae
    public final void zzod() {
        synchronized (this.mLock) {
            if (this.zzcnt.isConnected() || this.zzcnt.isConnecting()) {
                this.zzcnt.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }

    @Override // com.google.android.gms.internal.zzaae
    public final zzaas zzoe() {
        zzaas zzaasVar;
        synchronized (this.mLock) {
            try {
                zzaasVar = this.zzcnt.zzof();
            } catch (DeadObjectException | IllegalStateException e) {
                zzaasVar = null;
            }
        }
        return zzaasVar;
    }
}

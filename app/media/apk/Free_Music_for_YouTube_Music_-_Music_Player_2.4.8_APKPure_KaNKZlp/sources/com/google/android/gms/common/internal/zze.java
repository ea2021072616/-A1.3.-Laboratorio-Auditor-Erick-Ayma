package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import android.support.annotation.BinderThread;
import com.google.android.gms.common.ConnectionResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class zze extends zzi<Boolean> {
    private int statusCode;
    private Bundle zzfte;
    private /* synthetic */ zzd zzftf;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @BinderThread
    public zze(zzd zzdVar, int i, Bundle bundle) {
        super(zzdVar, true);
        this.zzftf = zzdVar;
        this.statusCode = i;
        this.zzfte = bundle;
    }

    protected abstract boolean zzajn();

    protected abstract void zzj(ConnectionResult connectionResult);

    @Override // com.google.android.gms.common.internal.zzi
    protected final /* synthetic */ void zzs(Boolean bool) {
        if (bool == null) {
            this.zzftf.zza(1, (int) null);
            return;
        }
        switch (this.statusCode) {
            case 0:
                if (zzajn()) {
                    return;
                }
                this.zzftf.zza(1, (int) null);
                zzj(new ConnectionResult(8, null));
                return;
            case 10:
                this.zzftf.zza(1, (int) null);
                throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
            default:
                this.zzftf.zza(1, (int) null);
                zzj(new ConnectionResult(this.statusCode, this.zzfte != null ? (PendingIntent) this.zzfte.getParcelable("pendingIntent") : null));
                return;
        }
    }
}

package com.google.android.gms.internal;

import android.os.ConditionVariable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzcp implements Runnable {
    private /* synthetic */ zzco zzagp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcp(zzco zzcoVar) {
        this.zzagp = zzcoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConditionVariable conditionVariable;
        zzdc zzdcVar;
        ConditionVariable conditionVariable2;
        if (this.zzagp.zzagn != null) {
            return;
        }
        conditionVariable = zzco.zzagl;
        synchronized (conditionVariable) {
            if (this.zzagp.zzagn == null) {
                boolean booleanValue = ((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzblo)).booleanValue();
                if (booleanValue) {
                    try {
                        zzdcVar = this.zzagp.zzagk;
                        zzco.zzagm = new zzio(zzdcVar.zzaie, "ADSHIELD", null);
                    } catch (Throwable th) {
                        booleanValue = false;
                    }
                }
                this.zzagp.zzagn = Boolean.valueOf(booleanValue);
                conditionVariable2 = zzco.zzagl;
                conditionVariable2.open();
            }
        }
    }
}

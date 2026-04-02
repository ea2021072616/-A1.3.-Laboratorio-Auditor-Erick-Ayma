package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzia implements com.google.android.gms.common.internal.zzg {
    private /* synthetic */ zzhw zzbai;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzia(zzhw zzhwVar) {
        this.zzbai = zzhwVar;
    }

    @Override // com.google.android.gms.common.internal.zzg
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Object obj;
        zzid zzidVar;
        Object obj2;
        obj = this.zzbai.mLock;
        synchronized (obj) {
            this.zzbai.zzbah = null;
            zzidVar = this.zzbai.zzbag;
            if (zzidVar != null) {
                zzhw.zza(this.zzbai, (zzid) null);
            }
            obj2 = this.zzbai.mLock;
            obj2.notifyAll();
        }
    }
}

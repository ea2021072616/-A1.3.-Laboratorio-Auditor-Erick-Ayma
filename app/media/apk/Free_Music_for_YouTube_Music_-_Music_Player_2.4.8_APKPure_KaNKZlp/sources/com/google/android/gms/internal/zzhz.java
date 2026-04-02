package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.support.annotation.Nullable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzhz implements com.google.android.gms.common.internal.zzf {
    private /* synthetic */ zzhw zzbai;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhz(zzhw zzhwVar) {
        this.zzbai = zzhwVar;
    }

    @Override // com.google.android.gms.common.internal.zzf
    public final void onConnected(@Nullable Bundle bundle) {
        Object obj;
        Object obj2;
        zzid zzidVar;
        zzid zzidVar2;
        obj = this.zzbai.mLock;
        synchronized (obj) {
            try {
                zzidVar = this.zzbai.zzbag;
                if (zzidVar != null) {
                    zzhw zzhwVar = this.zzbai;
                    zzidVar2 = this.zzbai.zzbag;
                    zzhwVar.zzbah = zzidVar2.zzhe();
                }
            } catch (DeadObjectException e) {
                zzafx.zzb("Unable to obtain a cache service instance.", e);
                this.zzbai.disconnect();
            }
            obj2 = this.zzbai.mLock;
            obj2.notifyAll();
        }
    }

    @Override // com.google.android.gms.common.internal.zzf
    public final void onConnectionSuspended(int i) {
        Object obj;
        Object obj2;
        obj = this.zzbai.mLock;
        synchronized (obj) {
            this.zzbai.zzbah = null;
            obj2 = this.zzbai.mLock;
            obj2.notifyAll();
        }
    }
}

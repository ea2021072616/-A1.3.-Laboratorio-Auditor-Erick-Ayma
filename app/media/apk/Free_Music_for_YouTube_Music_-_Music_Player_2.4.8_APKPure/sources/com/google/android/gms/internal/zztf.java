package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes2.dex */
final class zztf implements zztr {
    private /* synthetic */ zznk zzbwx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zztf(zzte zzteVar, zznk zznkVar) {
        this.zzbwx = zznkVar;
    }

    @Override // com.google.android.gms.internal.zztr
    public final void zzb(zzts zztsVar) throws RemoteException {
        if (zztsVar.zzbxc != null) {
            zztsVar.zzbxc.zza(this.zzbwx);
        }
    }
}

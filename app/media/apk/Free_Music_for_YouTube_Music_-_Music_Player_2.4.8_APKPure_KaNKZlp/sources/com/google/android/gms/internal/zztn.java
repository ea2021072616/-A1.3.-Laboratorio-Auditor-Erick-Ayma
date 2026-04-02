package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes2.dex */
final class zztn implements zztr {
    private /* synthetic */ zzadb zzbwy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zztn(zzti zztiVar, zzadb zzadbVar) {
        this.zzbwy = zzadbVar;
    }

    @Override // com.google.android.gms.internal.zztr
    public final void zzb(zzts zztsVar) throws RemoteException {
        if (zztsVar.zzbxe != null) {
            zztsVar.zzbxe.zza(this.zzbwy);
        }
    }
}

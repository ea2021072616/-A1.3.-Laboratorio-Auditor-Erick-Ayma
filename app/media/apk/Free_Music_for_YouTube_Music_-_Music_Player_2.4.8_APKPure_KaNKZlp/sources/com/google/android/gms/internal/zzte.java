package com.google.android.gms.internal;

import android.os.RemoteException;
import java.util.List;
/* loaded from: classes2.dex */
final class zzte extends zzno {
    private /* synthetic */ zzst zzbwu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzte(zzst zzstVar) {
        this.zzbwu = zzstVar;
    }

    @Override // com.google.android.gms.internal.zznn
    public final void zza(zznk zznkVar) throws RemoteException {
        List list;
        list = this.zzbwu.zzaom;
        list.add(new zztf(this, zznkVar));
    }
}

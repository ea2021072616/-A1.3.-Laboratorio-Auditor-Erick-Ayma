package com.google.android.gms.internal;

import android.os.RemoteException;
import java.util.List;
/* loaded from: classes2.dex */
final class zztc extends zzkl {
    private /* synthetic */ zzst zzbwu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zztc(zzst zzstVar) {
        this.zzbwu = zzstVar;
    }

    @Override // com.google.android.gms.internal.zzkk
    public final void onAppEvent(String str, String str2) throws RemoteException {
        List list;
        list = this.zzbwu.zzaom;
        list.add(new zztd(this, str, str2));
    }
}

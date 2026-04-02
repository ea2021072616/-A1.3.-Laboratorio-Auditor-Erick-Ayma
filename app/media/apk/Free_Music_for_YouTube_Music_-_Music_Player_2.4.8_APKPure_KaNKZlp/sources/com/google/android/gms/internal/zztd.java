package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes2.dex */
final class zztd implements zztr {
    private /* synthetic */ String val$name;
    private /* synthetic */ String zzbww;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zztd(zztc zztcVar, String str, String str2) {
        this.val$name = str;
        this.zzbww = str2;
    }

    @Override // com.google.android.gms.internal.zztr
    public final void zzb(zzts zztsVar) throws RemoteException {
        if (zztsVar.zzbxb != null) {
            zztsVar.zzbxb.onAppEvent(this.val$name, this.zzbww);
        }
    }
}

package com.google.android.gms.internal;

import android.os.RemoteException;
import java.util.List;
/* loaded from: classes2.dex */
final class zztg extends zzjs {
    private /* synthetic */ zzst zzbwu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zztg(zzst zzstVar) {
        this.zzbwu = zzstVar;
    }

    @Override // com.google.android.gms.internal.zzjr
    public final void onAdClicked() throws RemoteException {
        List list;
        list = this.zzbwu.zzaom;
        list.add(new zzth(this));
    }
}

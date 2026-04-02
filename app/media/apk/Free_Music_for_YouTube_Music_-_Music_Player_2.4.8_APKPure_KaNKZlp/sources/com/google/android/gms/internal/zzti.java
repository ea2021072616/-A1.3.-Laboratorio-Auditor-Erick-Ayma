package com.google.android.gms.internal;

import android.os.RemoteException;
import java.util.List;
/* loaded from: classes2.dex */
final class zzti extends zzadk {
    private /* synthetic */ zzst zzbwu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzti(zzst zzstVar) {
        this.zzbwu = zzstVar;
    }

    @Override // com.google.android.gms.internal.zzadj
    public final void onRewardedVideoAdClosed() throws RemoteException {
        List list;
        list = this.zzbwu.zzaom;
        list.add(new zztm(this));
    }

    @Override // com.google.android.gms.internal.zzadj
    public final void onRewardedVideoAdFailedToLoad(int i) throws RemoteException {
        List list;
        list = this.zzbwu.zzaom;
        list.add(new zztp(this, i));
    }

    @Override // com.google.android.gms.internal.zzadj
    public final void onRewardedVideoAdLeftApplication() throws RemoteException {
        List list;
        list = this.zzbwu.zzaom;
        list.add(new zzto(this));
    }

    @Override // com.google.android.gms.internal.zzadj
    public final void onRewardedVideoAdLoaded() throws RemoteException {
        List list;
        list = this.zzbwu.zzaom;
        list.add(new zztj(this));
    }

    @Override // com.google.android.gms.internal.zzadj
    public final void onRewardedVideoAdOpened() throws RemoteException {
        List list;
        list = this.zzbwu.zzaom;
        list.add(new zztk(this));
    }

    @Override // com.google.android.gms.internal.zzadj
    public final void onRewardedVideoStarted() throws RemoteException {
        List list;
        list = this.zzbwu.zzaom;
        list.add(new zztl(this));
    }

    @Override // com.google.android.gms.internal.zzadj
    public final void zza(zzadb zzadbVar) throws RemoteException {
        List list;
        list = this.zzbwu.zzaom;
        list.add(new zztn(this, zzadbVar));
    }
}

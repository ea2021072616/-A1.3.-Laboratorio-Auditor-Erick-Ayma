package com.google.android.gms.internal;

import android.os.RemoteException;
import java.util.List;
/* loaded from: classes2.dex */
final class zzsu extends zzjv {
    private /* synthetic */ zzst zzbwu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsu(zzst zzstVar) {
        this.zzbwu = zzstVar;
    }

    @Override // com.google.android.gms.internal.zzju
    public final void onAdClicked() throws RemoteException {
        List list;
        list = this.zzbwu.zzaom;
        list.add(new zztb(this));
    }

    @Override // com.google.android.gms.internal.zzju
    public final void onAdClosed() throws RemoteException {
        List list;
        list = this.zzbwu.zzaom;
        list.add(new zzsv(this));
    }

    @Override // com.google.android.gms.internal.zzju
    public final void onAdFailedToLoad(int i) throws RemoteException {
        List list;
        list = this.zzbwu.zzaom;
        list.add(new zzsw(this, i));
        zzafx.v("Pooled interstitial failed to load.");
    }

    @Override // com.google.android.gms.internal.zzju
    public final void onAdImpression() throws RemoteException {
        List list;
        list = this.zzbwu.zzaom;
        list.add(new zzta(this));
    }

    @Override // com.google.android.gms.internal.zzju
    public final void onAdLeftApplication() throws RemoteException {
        List list;
        list = this.zzbwu.zzaom;
        list.add(new zzsx(this));
    }

    @Override // com.google.android.gms.internal.zzju
    public final void onAdLoaded() throws RemoteException {
        List list;
        list = this.zzbwu.zzaom;
        list.add(new zzsy(this));
        zzafx.v("Pooled interstitial loaded.");
    }

    @Override // com.google.android.gms.internal.zzju
    public final void onAdOpened() throws RemoteException {
        List list;
        list = this.zzbwu.zzaom;
        list.add(new zzsz(this));
    }
}

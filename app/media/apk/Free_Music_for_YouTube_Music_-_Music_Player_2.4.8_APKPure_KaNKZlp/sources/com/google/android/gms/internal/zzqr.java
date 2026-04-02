package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes2.dex */
public final class zzqr extends zzqk {
    private final OnPublisherAdViewLoadedListener zzbuh;

    public zzqr(OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener) {
        this.zzbuh = onPublisherAdViewLoadedListener;
    }

    @Override // com.google.android.gms.internal.zzqj
    public final void zza(zzkf zzkfVar, IObjectWrapper iObjectWrapper) {
        if (zzkfVar == null || iObjectWrapper == null) {
            return;
        }
        PublisherAdView publisherAdView = new PublisherAdView((Context) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper));
        try {
            if (zzkfVar.zzbx() instanceof zziu) {
                zziu zziuVar = (zziu) zzkfVar.zzbx();
                publisherAdView.setAdListener(zziuVar != null ? zziuVar.getAdListener() : null);
            }
        } catch (RemoteException e) {
            zzaji.zzc("Failed to get ad listener.", e);
        }
        try {
            if (zzkfVar.zzbw() instanceof zzjd) {
                zzjd zzjdVar = (zzjd) zzkfVar.zzbw();
                publisherAdView.setAppEventListener(zzjdVar != null ? zzjdVar.getAppEventListener() : null);
            }
        } catch (RemoteException e2) {
            zzaji.zzc("Failed to get app event listener.", e2);
        }
        zzaje.zzdee.post(new zzqs(this, publisherAdView, zzkfVar));
    }
}

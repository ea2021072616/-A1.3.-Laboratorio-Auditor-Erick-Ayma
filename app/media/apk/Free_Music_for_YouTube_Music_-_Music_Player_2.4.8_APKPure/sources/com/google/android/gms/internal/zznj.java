package com.google.android.gms.internal;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.doubleclick.CustomRenderedAd;
@zzzt
/* loaded from: classes.dex */
public final class zznj implements CustomRenderedAd {
    private final zznk zzbqv;

    public zznj(zznk zznkVar) {
        this.zzbqv = zznkVar;
    }

    @Override // com.google.android.gms.ads.doubleclick.CustomRenderedAd
    public final String getBaseUrl() {
        try {
            return this.zzbqv.zziz();
        } catch (RemoteException e) {
            zzaji.zzc("Could not delegate getBaseURL to CustomRenderedAd", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.doubleclick.CustomRenderedAd
    public final String getContent() {
        try {
            return this.zzbqv.getContent();
        } catch (RemoteException e) {
            zzaji.zzc("Could not delegate getContent to CustomRenderedAd", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.doubleclick.CustomRenderedAd
    public final void onAdRendered(View view) {
        try {
            this.zzbqv.zzi(view != null ? com.google.android.gms.dynamic.zzn.zzw(view) : null);
        } catch (RemoteException e) {
            zzaji.zzc("Could not delegate onAdRendered to CustomRenderedAd", e);
        }
    }

    @Override // com.google.android.gms.ads.doubleclick.CustomRenderedAd
    public final void recordClick() {
        try {
            this.zzbqv.recordClick();
        } catch (RemoteException e) {
            zzaji.zzc("Could not delegate recordClick to CustomRenderedAd", e);
        }
    }

    @Override // com.google.android.gms.ads.doubleclick.CustomRenderedAd
    public final void recordImpression() {
        try {
            this.zzbqv.recordImpression();
        } catch (RemoteException e) {
            zzaji.zzc("Could not delegate recordImpression to CustomRenderedAd", e);
        }
    }
}

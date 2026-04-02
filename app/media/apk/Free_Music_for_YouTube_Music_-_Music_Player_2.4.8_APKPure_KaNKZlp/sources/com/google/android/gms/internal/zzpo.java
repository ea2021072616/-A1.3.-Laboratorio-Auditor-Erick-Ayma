package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;
@zzzt
/* loaded from: classes.dex */
public final class zzpo extends NativeAppInstallAd {
    private final zzpl zzbtv;
    private final zzpf zzbtx;
    private final NativeAd.AdChoicesInfo zzbty;
    private final List<NativeAd.Image> zzbtw = new ArrayList();
    private final VideoController zzbeb = new VideoController();

    public zzpo(zzpl zzplVar) {
        zzpf zzpfVar;
        zzpe zzpeVar;
        IBinder iBinder;
        zzpb zzpbVar = null;
        this.zzbtv = zzplVar;
        try {
            List images = this.zzbtv.getImages();
            if (images != null) {
                for (Object obj : images) {
                    if (!(obj instanceof IBinder) || (iBinder = (IBinder) obj) == null) {
                        zzpeVar = null;
                    } else {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                        zzpeVar = queryLocalInterface instanceof zzpc ? (zzpc) queryLocalInterface : new zzpe(iBinder);
                    }
                    if (zzpeVar != null) {
                        this.zzbtw.add(new zzpf(zzpeVar));
                    }
                }
            }
        } catch (RemoteException e) {
            zzaji.zzb("Failed to get image.", e);
        }
        try {
            zzpc zzji = this.zzbtv.zzji();
            zzpfVar = zzji != null ? new zzpf(zzji) : null;
        } catch (RemoteException e2) {
            zzaji.zzb("Failed to get image.", e2);
            zzpfVar = null;
        }
        this.zzbtx = zzpfVar;
        try {
            if (this.zzbtv.zzjn() != null) {
                zzpbVar = new zzpb(this.zzbtv.zzjn());
            }
        } catch (RemoteException e3) {
            zzaji.zzb("Failed to get attribution info.", e3);
        }
        this.zzbty = zzpbVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.formats.NativeAd
    /* renamed from: zzjj */
    public final IObjectWrapper zzbf() {
        try {
            return this.zzbtv.zzjj();
        } catch (RemoteException e) {
            zzaji.zzb("Failed to retrieve native ad engine.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final void destroy() {
        try {
            this.zzbtv.destroy();
        } catch (RemoteException e) {
            zzaji.zzb("Failed to destroy", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zzbty;
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getBody() {
        try {
            return this.zzbtv.getBody();
        } catch (RemoteException e) {
            zzaji.zzb("Failed to get body.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getCallToAction() {
        try {
            return this.zzbtv.getCallToAction();
        } catch (RemoteException e) {
            zzaji.zzb("Failed to get call to action.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final Bundle getExtras() {
        try {
            return this.zzbtv.getExtras();
        } catch (RemoteException e) {
            zzaji.zzb("Failed to get extras", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getHeadline() {
        try {
            return this.zzbtv.getHeadline();
        } catch (RemoteException e) {
            zzaji.zzb("Failed to get headline.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final NativeAd.Image getIcon() {
        return this.zzbtx;
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final List<NativeAd.Image> getImages() {
        return this.zzbtw;
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getPrice() {
        try {
            return this.zzbtv.getPrice();
        } catch (RemoteException e) {
            zzaji.zzb("Failed to get price.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final Double getStarRating() {
        try {
            double starRating = this.zzbtv.getStarRating();
            if (starRating == -1.0d) {
                return null;
            }
            return Double.valueOf(starRating);
        } catch (RemoteException e) {
            zzaji.zzb("Failed to get star rating.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getStore() {
        try {
            return this.zzbtv.getStore();
        } catch (RemoteException e) {
            zzaji.zzb("Failed to get store", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final VideoController getVideoController() {
        try {
            if (this.zzbtv.getVideoController() != null) {
                this.zzbeb.zza(this.zzbtv.getVideoController());
            }
        } catch (RemoteException e) {
            zzaji.zzb("Exception occurred while getting video controller", e);
        }
        return this.zzbeb;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final void performClick(Bundle bundle) {
        try {
            this.zzbtv.performClick(bundle);
        } catch (RemoteException e) {
            zzaji.zzb("Failed to perform click.", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zzbtv.recordImpression(bundle);
        } catch (RemoteException e) {
            zzaji.zzb("Failed to record impression.", e);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zzbtv.reportTouchEvent(bundle);
        } catch (RemoteException e) {
            zzaji.zzb("Failed to report touch event.", e);
        }
    }
}

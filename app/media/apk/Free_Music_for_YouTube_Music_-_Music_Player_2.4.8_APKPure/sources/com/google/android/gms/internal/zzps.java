package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;
@zzzt
/* loaded from: classes.dex */
public final class zzps extends NativeContentAd {
    private final NativeAd.AdChoicesInfo zzbty;
    private final zzpp zzbtz;
    private final zzpf zzbua;
    private final List<NativeAd.Image> zzbtw = new ArrayList();
    private final VideoController zzbeb = new VideoController();

    public zzps(zzpp zzppVar) {
        zzpf zzpfVar;
        zzpe zzpeVar;
        IBinder iBinder;
        zzpb zzpbVar = null;
        this.zzbtz = zzppVar;
        try {
            List images = this.zzbtz.getImages();
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
            zzpc zzjo = this.zzbtz.zzjo();
            zzpfVar = zzjo != null ? new zzpf(zzjo) : null;
        } catch (RemoteException e2) {
            zzaji.zzb("Failed to get image.", e2);
            zzpfVar = null;
        }
        this.zzbua = zzpfVar;
        try {
            if (this.zzbtz.zzjn() != null) {
                zzpbVar = new zzpb(this.zzbtz.zzjn());
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
            return this.zzbtz.zzjj();
        } catch (RemoteException e) {
            zzaji.zzb("Failed to retrieve native ad engine.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final void destroy() {
        try {
            this.zzbtz.destroy();
        } catch (RemoteException e) {
            zzaji.zzb("Failed to destroy", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zzbty;
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final CharSequence getAdvertiser() {
        try {
            return this.zzbtz.getAdvertiser();
        } catch (RemoteException e) {
            zzaji.zzb("Failed to get attribution.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final CharSequence getBody() {
        try {
            return this.zzbtz.getBody();
        } catch (RemoteException e) {
            zzaji.zzb("Failed to get body.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final CharSequence getCallToAction() {
        try {
            return this.zzbtz.getCallToAction();
        } catch (RemoteException e) {
            zzaji.zzb("Failed to get call to action.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final Bundle getExtras() {
        try {
            return this.zzbtz.getExtras();
        } catch (RemoteException e) {
            zzaji.zzc("Failed to get extras", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final CharSequence getHeadline() {
        try {
            return this.zzbtz.getHeadline();
        } catch (RemoteException e) {
            zzaji.zzb("Failed to get headline.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final List<NativeAd.Image> getImages() {
        return this.zzbtw;
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final NativeAd.Image getLogo() {
        return this.zzbua;
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final VideoController getVideoController() {
        try {
            if (this.zzbtz.getVideoController() != null) {
                this.zzbeb.zza(this.zzbtz.getVideoController());
            }
        } catch (RemoteException e) {
            zzaji.zzb("Exception occurred while getting video controller", e);
        }
        return this.zzbeb;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final void performClick(Bundle bundle) {
        try {
            this.zzbtz.performClick(bundle);
        } catch (RemoteException e) {
            zzaji.zzb("Failed to perform click.", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zzbtz.recordImpression(bundle);
        } catch (RemoteException e) {
            zzaji.zzb("Failed to record impression.", e);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zzbtz.reportTouchEvent(bundle);
        } catch (RemoteException e) {
            zzaji.zzb("Failed to report touch event.", e);
        }
    }
}

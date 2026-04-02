package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import java.util.List;
@zzzt
/* loaded from: classes.dex */
public final class zzpw implements NativeCustomTemplateAd {
    private final VideoController zzbeb = new VideoController();
    private final zzpt zzbub;
    private final MediaView zzbuc;

    public zzpw(zzpt zzptVar) {
        Context context;
        MediaView mediaView = null;
        this.zzbub = zzptVar;
        try {
            context = (Context) com.google.android.gms.dynamic.zzn.zzab(zzptVar.zzjp());
        } catch (RemoteException | NullPointerException e) {
            zzaji.zzb("Unable to inflate MediaView.", e);
            context = null;
        }
        if (context != null) {
            MediaView mediaView2 = new MediaView(context);
            try {
                mediaView = this.zzbub.zzj(com.google.android.gms.dynamic.zzn.zzw(mediaView2)) ? mediaView2 : null;
            } catch (RemoteException e2) {
                zzaji.zzb("Unable to render video in MediaView.", e2);
            }
        }
        this.zzbuc = mediaView;
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final void destroy() {
        try {
            this.zzbub.destroy();
        } catch (RemoteException e) {
            zzaji.zzb("Failed to destroy ad.", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final List<String> getAvailableAssetNames() {
        try {
            return this.zzbub.getAvailableAssetNames();
        } catch (RemoteException e) {
            zzaji.zzb("Failed to get available asset names.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final String getCustomTemplateId() {
        try {
            return this.zzbub.getCustomTemplateId();
        } catch (RemoteException e) {
            zzaji.zzb("Failed to get custom template id.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final NativeAd.Image getImage(String str) {
        try {
            zzpc zzap = this.zzbub.zzap(str);
            if (zzap != null) {
                return new zzpf(zzap);
            }
        } catch (RemoteException e) {
            zzaji.zzb("Failed to get image.", e);
        }
        return null;
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final CharSequence getText(String str) {
        try {
            return this.zzbub.zzao(str);
        } catch (RemoteException e) {
            zzaji.zzb("Failed to get string.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final VideoController getVideoController() {
        try {
            zzky videoController = this.zzbub.getVideoController();
            if (videoController != null) {
                this.zzbeb.zza(videoController);
            }
        } catch (RemoteException e) {
            zzaji.zzb("Exception occurred while getting video controller", e);
        }
        return this.zzbeb;
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final MediaView getVideoMediaView() {
        return this.zzbuc;
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final void performClick(String str) {
        try {
            this.zzbub.performClick(str);
        } catch (RemoteException e) {
            zzaji.zzb("Failed to perform click.", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final void recordImpression() {
        try {
            this.zzbub.recordImpression();
        } catch (RemoteException e) {
            zzaji.zzb("Failed to record impression.", e);
        }
    }

    public final zzpt zzjz() {
        return this.zzbub;
    }
}

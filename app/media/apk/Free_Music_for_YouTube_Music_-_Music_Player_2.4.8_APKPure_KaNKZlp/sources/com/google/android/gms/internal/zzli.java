package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzjf;
import java.util.concurrent.atomic.AtomicBoolean;
@zzzt
/* loaded from: classes.dex */
public final class zzli {
    private final zzja zzakp;
    private VideoOptions zzalq;
    private boolean zzalt;
    private AppEventListener zzalv;
    private String zzapb;
    private zzis zzbbj;
    private AdListener zzbbk;
    private AdSize[] zzbcw;
    private final zzuz zzbdz;
    private final AtomicBoolean zzbea;
    private final VideoController zzbeb;
    private zzjq zzbec;
    private Correlator zzbed;
    private zzkf zzbee;
    private OnCustomRenderedAdLoadedListener zzbef;
    private ViewGroup zzbeg;
    private int zzbeh;

    public zzli(ViewGroup viewGroup) {
        this(viewGroup, null, false, zzja.zzbcp, 0);
    }

    public zzli(ViewGroup viewGroup, int i) {
        this(viewGroup, null, false, zzja.zzbcp, i);
    }

    public zzli(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, zzja.zzbcp, 0);
    }

    public zzli(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, int i) {
        this(viewGroup, attributeSet, false, zzja.zzbcp, i);
    }

    private zzli(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzja zzjaVar, int i) {
        this(viewGroup, attributeSet, z, zzjaVar, null, i);
    }

    private zzli(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzja zzjaVar, zzkf zzkfVar, int i) {
        this.zzbdz = new zzuz();
        this.zzbeb = new VideoController();
        this.zzbec = new zzlj(this);
        this.zzbeg = viewGroup;
        this.zzakp = zzjaVar;
        this.zzbee = null;
        this.zzbea = new AtomicBoolean(false);
        this.zzbeh = i;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzje zzjeVar = new zzje(context, attributeSet);
                this.zzbcw = zzjeVar.zzh(z);
                this.zzapb = zzjeVar.getAdUnitId();
                if (viewGroup.isInEditMode()) {
                    zzaje zzhu = zzjo.zzhu();
                    AdSize adSize = this.zzbcw[0];
                    int i2 = this.zzbeh;
                    zzjb zzjbVar = new zzjb(context, adSize);
                    zzjbVar.zzbcv = zzq(i2);
                    zzhu.zza(viewGroup, zzjbVar, "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                zzjo.zzhu().zza(viewGroup, new zzjb(context, AdSize.BANNER), e.getMessage(), e.getMessage());
            }
        }
    }

    private static zzjb zza(Context context, AdSize[] adSizeArr, int i) {
        zzjb zzjbVar = new zzjb(context, adSizeArr);
        zzjbVar.zzbcv = zzq(i);
        return zzjbVar;
    }

    private static boolean zzq(int i) {
        return i == 1;
    }

    public final void destroy() {
        try {
            if (this.zzbee != null) {
                this.zzbee.destroy();
            }
        } catch (RemoteException e) {
            zzaji.zzc("Failed to destroy AdView.", e);
        }
    }

    public final AdListener getAdListener() {
        return this.zzbbk;
    }

    public final AdSize getAdSize() {
        zzjb zzbl;
        try {
            if (this.zzbee != null && (zzbl = this.zzbee.zzbl()) != null) {
                return zzbl.zzhn();
            }
        } catch (RemoteException e) {
            zzaji.zzc("Failed to get the current AdSize.", e);
        }
        if (this.zzbcw != null) {
            return this.zzbcw[0];
        }
        return null;
    }

    public final AdSize[] getAdSizes() {
        return this.zzbcw;
    }

    public final String getAdUnitId() {
        if (this.zzapb == null && this.zzbee != null) {
            try {
                this.zzapb = this.zzbee.getAdUnitId();
            } catch (RemoteException e) {
                zzaji.zzc("Failed to get ad unit id.", e);
            }
        }
        return this.zzapb;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzalv;
    }

    public final String getMediationAdapterClassName() {
        try {
            if (this.zzbee != null) {
                return this.zzbee.zzch();
            }
        } catch (RemoteException e) {
            zzaji.zzc("Failed to get the mediation adapter class name.", e);
        }
        return null;
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzbef;
    }

    public final VideoController getVideoController() {
        return this.zzbeb;
    }

    public final VideoOptions getVideoOptions() {
        return this.zzalq;
    }

    public final boolean isLoading() {
        try {
            if (this.zzbee != null) {
                return this.zzbee.isLoading();
            }
        } catch (RemoteException e) {
            zzaji.zzc("Failed to check if ad is loading.", e);
        }
        return false;
    }

    public final void pause() {
        try {
            if (this.zzbee != null) {
                this.zzbee.pause();
            }
        } catch (RemoteException e) {
            zzaji.zzc("Failed to call pause.", e);
        }
    }

    public final void recordManualImpression() {
        if (this.zzbea.getAndSet(true)) {
            return;
        }
        try {
            if (this.zzbee != null) {
                this.zzbee.zzbn();
            }
        } catch (RemoteException e) {
            zzaji.zzc("Failed to record impression.", e);
        }
    }

    public final void resume() {
        try {
            if (this.zzbee != null) {
                this.zzbee.resume();
            }
        } catch (RemoteException e) {
            zzaji.zzc("Failed to call resume.", e);
        }
    }

    public final void setAdListener(AdListener adListener) {
        this.zzbbk = adListener;
        this.zzbec.zza(adListener);
    }

    public final void setAdSizes(AdSize... adSizeArr) {
        if (this.zzbcw != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        zza(adSizeArr);
    }

    public final void setAdUnitId(String str) {
        if (this.zzapb != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.zzapb = str;
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzalv = appEventListener;
            if (this.zzbee != null) {
                this.zzbee.zza(appEventListener != null ? new zzjd(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzaji.zzc("Failed to set the AppEventListener.", e);
        }
    }

    public final void setCorrelator(Correlator correlator) {
        this.zzbed = correlator;
        try {
            if (this.zzbee != null) {
                this.zzbee.zza(this.zzbed == null ? null : this.zzbed.zzba());
            }
        } catch (RemoteException e) {
            zzaji.zzc("Failed to set correlator.", e);
        }
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.zzalt = z;
        try {
            if (this.zzbee != null) {
                this.zzbee.setManualImpressionsEnabled(this.zzalt);
            }
        } catch (RemoteException e) {
            zzaji.zzc("Failed to set manual impressions.", e);
        }
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzbef = onCustomRenderedAdLoadedListener;
        try {
            if (this.zzbee != null) {
                this.zzbee.zza(onCustomRenderedAdLoadedListener != null ? new zznq(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e) {
            zzaji.zzc("Failed to set the onCustomRenderedAdLoadedListener.", e);
        }
    }

    public final void setVideoOptions(VideoOptions videoOptions) {
        this.zzalq = videoOptions;
        try {
            if (this.zzbee != null) {
                this.zzbee.zza(videoOptions == null ? null : new zzmd(videoOptions));
            }
        } catch (RemoteException e) {
            zzaji.zzc("Failed to set video options.", e);
        }
    }

    public final void zza(zzis zzisVar) {
        try {
            this.zzbbj = zzisVar;
            if (this.zzbee != null) {
                this.zzbee.zza(zzisVar != null ? new zzit(zzisVar) : null);
            }
        } catch (RemoteException e) {
            zzaji.zzc("Failed to set the AdClickListener.", e);
        }
    }

    public final void zza(zzlg zzlgVar) {
        try {
            if (this.zzbee == null) {
                if ((this.zzbcw == null || this.zzapb == null) && this.zzbee == null) {
                    throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
                }
                Context context = this.zzbeg.getContext();
                zzjb zza = zza(context, this.zzbcw, this.zzbeh);
                this.zzbee = "search_v2".equals(zza.zzbcq) ? (zzkf) zzjf.zza(context, false, (zzjf.zza<Object>) new zzjh(zzjo.zzhv(), context, zza, this.zzapb)) : (zzkf) zzjf.zza(context, false, (zzjf.zza<Object>) new zzjg(zzjo.zzhv(), context, zza, this.zzapb, this.zzbdz));
                this.zzbee.zza(new zziu(this.zzbec));
                if (this.zzbbj != null) {
                    this.zzbee.zza(new zzit(this.zzbbj));
                }
                if (this.zzalv != null) {
                    this.zzbee.zza(new zzjd(this.zzalv));
                }
                if (this.zzbef != null) {
                    this.zzbee.zza(new zznq(this.zzbef));
                }
                if (this.zzbed != null) {
                    this.zzbee.zza(this.zzbed.zzba());
                }
                if (this.zzalq != null) {
                    this.zzbee.zza(new zzmd(this.zzalq));
                }
                this.zzbee.setManualImpressionsEnabled(this.zzalt);
                try {
                    IObjectWrapper zzbk = this.zzbee.zzbk();
                    if (zzbk != null) {
                        this.zzbeg.addView((View) com.google.android.gms.dynamic.zzn.zzab(zzbk));
                    }
                } catch (RemoteException e) {
                    zzaji.zzc("Failed to get an ad frame.", e);
                }
            }
            if (this.zzbee.zzb(zzja.zza(this.zzbeg.getContext(), zzlgVar))) {
                this.zzbdz.zzh(zzlgVar.zzib());
            }
        } catch (RemoteException e2) {
            zzaji.zzc("Failed to load ad.", e2);
        }
    }

    public final void zza(AdSize... adSizeArr) {
        this.zzbcw = adSizeArr;
        try {
            if (this.zzbee != null) {
                this.zzbee.zza(zza(this.zzbeg.getContext(), this.zzbcw, this.zzbeh));
            }
        } catch (RemoteException e) {
            zzaji.zzc("Failed to set the ad size.", e);
        }
        this.zzbeg.requestLayout();
    }

    public final boolean zza(zzkf zzkfVar) {
        if (zzkfVar == null) {
            return false;
        }
        try {
            IObjectWrapper zzbk = zzkfVar.zzbk();
            if (zzbk != null && ((View) com.google.android.gms.dynamic.zzn.zzab(zzbk)).getParent() == null) {
                this.zzbeg.addView((View) com.google.android.gms.dynamic.zzn.zzab(zzbk));
                this.zzbee = zzkfVar;
                return true;
            }
            return false;
        } catch (RemoteException e) {
            zzaji.zzc("Failed to get an ad frame.", e);
            return false;
        }
    }

    public final zzky zzbc() {
        if (this.zzbee == null) {
            return null;
        }
        try {
            return this.zzbee.getVideoController();
        } catch (RemoteException e) {
            zzaji.zzc("Failed to retrieve VideoController.", e);
            return null;
        }
    }
}

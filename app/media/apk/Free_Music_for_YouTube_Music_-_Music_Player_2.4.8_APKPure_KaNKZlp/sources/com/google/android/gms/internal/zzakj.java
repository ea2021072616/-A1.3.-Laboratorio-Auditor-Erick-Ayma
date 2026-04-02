package com.google.android.gms.internal;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.zzbp;
@zzzt
/* loaded from: classes.dex */
public final class zzakj {
    private final Context mContext;
    private final zzakk zzbvz;
    private com.google.android.gms.ads.internal.overlay.zzaa zzckd;
    private final ViewGroup zzdfm;

    public zzakj(Context context, ViewGroup viewGroup, zzakk zzakkVar) {
        this(context, viewGroup, zzakkVar, null);
    }

    private zzakj(Context context, ViewGroup viewGroup, zzakk zzakkVar, com.google.android.gms.ads.internal.overlay.zzaa zzaaVar) {
        this.mContext = context;
        this.zzdfm = viewGroup;
        this.zzbvz = zzakkVar;
        this.zzckd = null;
    }

    public final void onDestroy() {
        zzbp.zzfx("onDestroy must be called from the UI thread.");
        if (this.zzckd != null) {
            this.zzckd.destroy();
            this.zzdfm.removeView(this.zzckd);
            this.zzckd = null;
        }
    }

    public final void onPause() {
        zzbp.zzfx("onPause must be called from the UI thread.");
        if (this.zzckd != null) {
            this.zzckd.pause();
        }
    }

    public final void zza(int i, int i2, int i3, int i4, int i5, boolean z, com.google.android.gms.ads.internal.overlay.zzaq zzaqVar) {
        if (this.zzckd != null) {
            return;
        }
        zzna.zza(this.zzbvz.zzsl().zzit(), this.zzbvz.zzsk(), "vpr2");
        this.zzckd = new com.google.android.gms.ads.internal.overlay.zzaa(this.mContext, this.zzbvz, i5, z, this.zzbvz.zzsl().zzit(), zzaqVar);
        this.zzdfm.addView(this.zzckd, 0, new ViewGroup.LayoutParams(-1, -1));
        this.zzckd.zzd(i, i2, i3, i4);
        this.zzbvz.zzsb().zzaf(false);
    }

    public final void zze(int i, int i2, int i3, int i4) {
        zzbp.zzfx("The underlay may only be modified from the UI thread.");
        if (this.zzckd != null) {
            this.zzckd.zzd(i, i2, i3, i4);
        }
    }

    public final com.google.android.gms.ads.internal.overlay.zzaa zzru() {
        zzbp.zzfx("getAdVideoUnderlay must be called from the UI thread.");
        return this.zzckd;
    }
}

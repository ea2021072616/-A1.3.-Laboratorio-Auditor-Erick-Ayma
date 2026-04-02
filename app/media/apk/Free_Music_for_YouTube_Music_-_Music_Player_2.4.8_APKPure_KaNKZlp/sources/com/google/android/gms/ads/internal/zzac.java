package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.gms.internal.zzafm;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzahf;
import com.google.android.gms.internal.zzajk;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzzt;
@zzzt
/* loaded from: classes.dex */
public final class zzac {
    private Context mContext;
    private final Object mLock = new Object();
    private long zzaoc = 0;

    public final void zza(Context context, zzajk zzajkVar, String str, @Nullable Runnable runnable) {
        zza(context, zzajkVar, true, null, str, null, runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(Context context, zzajk zzajkVar, boolean z, @Nullable zzafm zzafmVar, String str, @Nullable String str2, @Nullable Runnable runnable) {
        boolean z2;
        if (zzbv.zzeg().elapsedRealtime() - this.zzaoc < ExoPlayerFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS) {
            zzafx.zzcs("Not retrying to fetch app settings");
            return;
        }
        this.zzaoc = zzbv.zzeg().elapsedRealtime();
        if (zzafmVar == null) {
            z2 = true;
        } else {
            z2 = (((zzbv.zzeg().currentTimeMillis() - zzafmVar.zzpl()) > ((Long) zzbv.zzen().zzd(zzmu.zzbns)).longValue() ? 1 : ((zzbv.zzeg().currentTimeMillis() - zzafmVar.zzpl()) == ((Long) zzbv.zzen().zzd(zzmu.zzbns)).longValue() ? 0 : -1)) > 0) || !zzafmVar.zzpm();
        }
        if (z2) {
            if (context == null) {
                zzafx.zzcs("Context not provided to fetch application settings");
            } else if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                zzafx.zzcs("App settings could not be fetched. Required parameters missing");
            } else {
                this.mContext = context;
                zzahf.zzdbo.post(new zzae(this, zzbv.zzea().zze(context, zzajkVar), new zzad(this, runnable), str, str2, z, context));
            }
        }
    }
}

package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.graphics.Bitmap;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.internal.zzafv;
import com.google.android.gms.internal.zzahf;
import com.google.android.gms.internal.zzahk;
import com.google.android.gms.internal.zzzt;
@zzzt
/* loaded from: classes.dex */
final class zzs extends zzafv {
    final /* synthetic */ zzm zzcgr;

    private zzs(zzm zzmVar) {
        this.zzcgr = zzmVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzs(zzm zzmVar, zzn zznVar) {
        this(zzmVar);
    }

    @Override // com.google.android.gms.internal.zzafv
    public final void onStop() {
    }

    @Override // com.google.android.gms.internal.zzafv
    public final void zzdc() {
        Activity activity;
        Bitmap zza = zzbv.zzew().zza(Integer.valueOf(this.zzcgr.zzcfz.zzchh.zzaqd));
        if (zza != null) {
            zzahk zzec = zzbv.zzec();
            activity = this.zzcgr.mActivity;
            zzahf.zzdbo.post(new zzt(this, zzec.zza(activity, zza, this.zzcgr.zzcfz.zzchh.zzaqb, this.zzcgr.zzcfz.zzchh.zzaqc)));
        }
    }
}

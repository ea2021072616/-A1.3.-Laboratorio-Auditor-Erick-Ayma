package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;
@zzzt
/* loaded from: classes.dex */
public final class zzmw {
    private Context mContext;
    private String zzaux;
    private boolean zzbpw = ((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbhr)).booleanValue();
    private String zzbpx = (String) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbhs);
    private Map<String, String> zzbpy = new LinkedHashMap();

    public zzmw(Context context, String str) {
        this.mContext = null;
        this.zzaux = null;
        this.mContext = context;
        this.zzaux = str;
        this.zzbpy.put("s", "gmob_sdk");
        this.zzbpy.put("v", "3");
        this.zzbpy.put("os", Build.VERSION.RELEASE);
        this.zzbpy.put(ServerProtocol.DIALOG_PARAM_SDK_VERSION, Build.VERSION.SDK);
        Map<String, String> map = this.zzbpy;
        com.google.android.gms.ads.internal.zzbv.zzea();
        map.put("device", zzahf.zzqv());
        this.zzbpy.put("app", context.getApplicationContext() != null ? context.getApplicationContext().getPackageName() : context.getPackageName());
        Map<String, String> map2 = this.zzbpy;
        com.google.android.gms.ads.internal.zzbv.zzea();
        map2.put("is_lite_sdk", zzahf.zzar(context) ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        Future<zzach> zzp = com.google.android.gms.ads.internal.zzbv.zzek().zzp(this.mContext);
        try {
            zzp.get();
            this.zzbpy.put("network_coarse", Integer.toString(zzp.get().zzcur));
            this.zzbpy.put("network_fine", Integer.toString(zzp.get().zzcus));
        } catch (Exception e) {
            com.google.android.gms.ads.internal.zzbv.zzee().zza(e, "CsiConfiguration.CsiConfiguration");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Context getContext() {
        return this.mContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzfl() {
        return this.zzaux;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzin() {
        return this.zzbpw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzio() {
        return this.zzbpx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<String, String> zzip() {
        return this.zzbpy;
    }
}

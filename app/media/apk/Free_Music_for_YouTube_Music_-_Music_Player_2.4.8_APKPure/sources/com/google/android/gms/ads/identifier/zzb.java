package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.zzo;
import java.util.HashMap;
/* loaded from: classes.dex */
public class zzb {
    private static zzb zzamj;
    private final Context zzaie;

    private zzb(Context context) {
        this.zzaie = context;
    }

    private final void zza(final AdvertisingIdClient.Info info, final boolean z) {
        if (Math.random() > new zzd(this.zzaie).getFloat("gads:ad_id_use_shared_preference:ping_ratio", 0.0f)) {
            return;
        }
        new Thread(new Runnable(info, z) { // from class: com.google.android.gms.ads.identifier.zzc
            private final AdvertisingIdClient.Info zzamk;
            private final boolean zzaml;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzamk = info;
                this.zzaml = z;
            }

            @Override // java.lang.Runnable
            public final void run() {
                AdvertisingIdClient.Info info2 = this.zzamk;
                boolean z2 = this.zzaml;
                HashMap hashMap = new HashMap();
                hashMap.put("ad_id_size", Integer.toString(info2 == null ? -1 : info2.getId().length()));
                hashMap.put("hasGmscore", z2 ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
                hashMap.put("tag", "AdvertisingIdLightClient");
                new zze().zzb(hashMap);
            }
        }).start();
    }

    public static zzb zze(Context context) {
        zzb zzbVar;
        synchronized (zzb.class) {
            if (zzamj == null) {
                zzamj = new zzb(context);
            }
            zzbVar = zzamj;
        }
        return zzbVar;
    }

    public final AdvertisingIdClient.Info getInfo() {
        AdvertisingIdClient.Info info = null;
        Context remoteContext = zzo.getRemoteContext(this.zzaie);
        if (remoteContext == null) {
            zza(null, false);
        } else {
            SharedPreferences sharedPreferences = remoteContext.getSharedPreferences("adid_settings", 0);
            if (sharedPreferences == null) {
                zza(null, false);
            } else {
                if (sharedPreferences.contains("adid_key") && sharedPreferences.contains("enable_limit_ad_tracking")) {
                    info = new AdvertisingIdClient.Info(sharedPreferences.getString("adid_key", ""), sharedPreferences.getBoolean("enable_limit_ad_tracking", false));
                }
                zza(info, true);
            }
        }
        return info;
    }
}

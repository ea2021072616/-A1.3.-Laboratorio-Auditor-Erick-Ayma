package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzabf extends zzafv {
    private final Context mContext;
    private final Object zzckm;
    private final zzzv zzcnj;
    private final zzaal zzcnk;
    private zzio zzcnl;
    private com.google.android.gms.ads.internal.js.zzy zzcrb;
    private static long zzcqw = TimeUnit.SECONDS.toMillis(10);
    private static final Object zzaqm = new Object();
    private static boolean zzcqx = false;
    private static com.google.android.gms.ads.internal.js.zzl zzcle = null;
    private static zzro zzcqy = null;
    private static zzrx zzcqz = null;
    private static zzrn zzcra = null;

    public zzabf(Context context, zzaal zzaalVar, zzzv zzzvVar, zzio zzioVar) {
        super(true);
        this.zzckm = new Object();
        this.zzcnj = zzzvVar;
        this.mContext = context;
        this.zzcnk = zzaalVar;
        this.zzcnl = zzioVar;
        synchronized (zzaqm) {
            if (!zzcqx) {
                zzcqz = new zzrx();
                zzcqy = new zzro(context.getApplicationContext(), zzaalVar.zzatj);
                zzcra = new zzabn();
                zzcle = new com.google.android.gms.ads.internal.js.zzl(this.mContext.getApplicationContext(), this.zzcnk.zzatj, (String) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbfv), new zzabm(), new zzabl());
                zzcqx = true;
            }
        }
    }

    private final JSONObject zza(zzaak zzaakVar, String str) {
        zzach zzachVar;
        AdvertisingIdClient.Info info;
        Bundle bundle = zzaakVar.zzcnw.extras.getBundle("sdk_less_server_data");
        if (bundle == null) {
            return null;
        }
        try {
            zzachVar = com.google.android.gms.ads.internal.zzbv.zzek().zzp(this.mContext).get();
        } catch (Exception e) {
            zzafx.zzc("Error grabbing device info: ", e);
            zzachVar = null;
        }
        Context context = this.mContext;
        zzabq zzabqVar = new zzabq();
        zzabqVar.zzcrj = zzaakVar;
        zzabqVar.zzcrk = zzachVar;
        JSONObject zza = zzabz.zza(context, zzabqVar);
        if (zza != null) {
            try {
                info = AdvertisingIdClient.getAdvertisingIdInfo(this.mContext);
            } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e2) {
                zzafx.zzc("Cannot get advertising id info", e2);
                info = null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("request_id", str);
            hashMap.put("request_param", zza);
            hashMap.put(ShareConstants.WEB_DIALOG_PARAM_DATA, bundle);
            if (info != null) {
                hashMap.put("adid", info.getId());
                hashMap.put("lat", Integer.valueOf(info.isLimitAdTrackingEnabled() ? 1 : 0));
            }
            try {
                return com.google.android.gms.ads.internal.zzbv.zzea().zzk(hashMap);
            } catch (JSONException e3) {
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void zza(com.google.android.gms.ads.internal.js.zza zzaVar) {
        zzaVar.zza("/loadAd", zzcqz);
        zzaVar.zza("/fetchHttpRequest", zzcqy);
        zzaVar.zza("/invalidRequest", zzcra);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void zzb(com.google.android.gms.ads.internal.js.zza zzaVar) {
        zzaVar.zzb("/loadAd", zzcqz);
        zzaVar.zzb("/fetchHttpRequest", zzcqy);
        zzaVar.zzb("/invalidRequest", zzcra);
    }

    private final zzaao zzc(zzaak zzaakVar) {
        com.google.android.gms.ads.internal.zzbv.zzea();
        String zzqt = zzahf.zzqt();
        JSONObject zza = zza(zzaakVar, zzqt);
        if (zza == null) {
            return new zzaao(0);
        }
        long elapsedRealtime = com.google.android.gms.ads.internal.zzbv.zzeg().elapsedRealtime();
        Future<JSONObject> zzas = zzcqz.zzas(zzqt);
        zzaje.zzdee.post(new zzabh(this, zza, zzqt));
        try {
            JSONObject jSONObject = zzas.get(zzcqw - (com.google.android.gms.ads.internal.zzbv.zzeg().elapsedRealtime() - elapsedRealtime), TimeUnit.MILLISECONDS);
            if (jSONObject == null) {
                return new zzaao(-1);
            }
            zzaao zza2 = zzabz.zza(this.mContext, zzaakVar, jSONObject.toString());
            return (zza2.errorCode == -3 || !TextUtils.isEmpty(zza2.body)) ? zza2 : new zzaao(3);
        } catch (InterruptedException e) {
            return new zzaao(-1);
        } catch (CancellationException e2) {
            return new zzaao(-1);
        } catch (ExecutionException e3) {
            return new zzaao(0);
        } catch (TimeoutException e4) {
            return new zzaao(2);
        }
    }

    @Override // com.google.android.gms.internal.zzafv
    public final void onStop() {
        synchronized (this.zzckm) {
            zzaje.zzdee.post(new zzabk(this));
        }
    }

    @Override // com.google.android.gms.internal.zzafv
    public final void zzdc() {
        zzafx.zzcb("SdkLessAdLoaderBackgroundTask started.");
        String zzz = com.google.android.gms.ads.internal.zzbv.zzez().zzz(this.mContext);
        zzaak zzaakVar = new zzaak(this.zzcnk, -1L, com.google.android.gms.ads.internal.zzbv.zzez().zzx(this.mContext), com.google.android.gms.ads.internal.zzbv.zzez().zzy(this.mContext), zzz);
        com.google.android.gms.ads.internal.zzbv.zzez().zzh(this.mContext, zzz);
        zzaao zzc = zzc(zzaakVar);
        zzaje.zzdee.post(new zzabg(this, new zzafj(zzaakVar, zzc, (zzul) null, (zzjb) null, zzc.errorCode, com.google.android.gms.ads.internal.zzbv.zzeg().elapsedRealtime(), zzc.zzcps, (JSONObject) null, this.zzcnl)));
    }
}

package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import b.a.a.a.a.b.a;
import com.facebook.appevents.AppEventsConstants;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzaic {
    private final Object mLock = new Object();
    private String zzdch = "";
    private String zzdci = "";
    private boolean zzdcj = false;
    private String zzdck = "";

    private final void zza(Context context, String str, boolean z, boolean z2) {
        if (context instanceof Activity) {
            zzahf.zzdbo.post(new zzaid(this, context, str, z, z2));
        } else {
            zzafx.zzcr("Can not create dialog without Activity Context");
        }
    }

    private final String zzaw(Context context) {
        String str;
        synchronized (this.mLock) {
            if (TextUtils.isEmpty(this.zzdch)) {
                com.google.android.gms.ads.internal.zzbv.zzea();
                this.zzdch = zzahf.zzt(context, "debug_signals_id.txt");
                if (TextUtils.isEmpty(this.zzdch)) {
                    com.google.android.gms.ads.internal.zzbv.zzea();
                    this.zzdch = zzahf.zzqt();
                    com.google.android.gms.ads.internal.zzbv.zzea();
                    zzahf.zze(context, "debug_signals_id.txt", this.zzdch);
                }
            }
            str = this.zzdch;
        }
        return str;
    }

    private final Uri zzb(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("linkedDeviceId", zzaw(context));
        buildUpon.appendQueryParameter("adSlotPath", str2);
        buildUpon.appendQueryParameter("afmaVersion", str3);
        return buildUpon.build();
    }

    private final boolean zzh(Context context, String str, String str2) {
        String zzj = zzj(context, zzb(context, (String) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzboz), str, str2).toString(), str2);
        if (TextUtils.isEmpty(zzj)) {
            zzafx.zzcb("Not linked for in app preview.");
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(zzj.trim());
            String optString = jSONObject.optString("gct");
            this.zzdck = jSONObject.optString("status");
            synchronized (this.mLock) {
                this.zzdci = optString;
            }
            return true;
        } catch (JSONException e) {
            zzafx.zzc("Fail to get in app preview response json.", e);
            return false;
        }
    }

    private final boolean zzi(Context context, String str, String str2) {
        String zzj = zzj(context, zzb(context, (String) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbpa), str, str2).toString(), str2);
        if (TextUtils.isEmpty(zzj)) {
            zzafx.zzcb("Not linked for debug signals.");
            return false;
        }
        try {
            boolean equals = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(new JSONObject(zzj.trim()).optString("debug_mode"));
            synchronized (this.mLock) {
                this.zzdcj = equals;
            }
            return equals;
        } catch (JSONException e) {
            zzafx.zzc("Fail to get debug mode response json.", e);
            return false;
        }
    }

    private static String zzj(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(a.HEADER_USER_AGENT, com.google.android.gms.ads.internal.zzbv.zzea().zzs(context, str2));
        zzajr<String> zzb = new zzaik(context).zzb(str, hashMap);
        try {
            return zzb.get(((Integer) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbpc)).intValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            String valueOf = String.valueOf(str);
            zzafx.zzb(valueOf.length() != 0 ? "Interrupted while retriving a response from: ".concat(valueOf) : new String("Interrupted while retriving a response from: "), e);
            zzb.cancel(true);
            return null;
        } catch (TimeoutException e2) {
            String valueOf2 = String.valueOf(str);
            zzafx.zzb(valueOf2.length() != 0 ? "Timeout while retriving a response from: ".concat(valueOf2) : new String("Timeout while retriving a response from: "), e2);
            zzb.cancel(true);
            return null;
        } catch (Exception e3) {
            String valueOf3 = String.valueOf(str);
            zzafx.zzb(valueOf3.length() != 0 ? "Error retriving a response from: ".concat(valueOf3) : new String("Error retriving a response from: "), e3);
            return null;
        }
    }

    private final void zzk(Context context, String str, String str2) {
        com.google.android.gms.ads.internal.zzbv.zzea();
        zzahf.zza(context, zzb(context, (String) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzboy), str, str2));
    }

    public final void zza(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = zzb(context, (String) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbpb), str3, str).buildUpon();
        buildUpon.appendQueryParameter("debugData", str2);
        com.google.android.gms.ads.internal.zzbv.zzea();
        zzahf.zzd(context, str, buildUpon.build().toString());
    }

    public final void zzf(Context context, String str, String str2) {
        if (!zzh(context, str, str2)) {
            zza(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
        } else if ("2".equals(this.zzdck)) {
            zzafx.zzcb("Creative is not pushed for this device.");
            zza(context, "There was no creative pushed from DFP to the device.", false, false);
        } else if (AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(this.zzdck)) {
            zzafx.zzcb("The app is not linked for creative preview.");
            zzk(context, str, str2);
        } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(this.zzdck)) {
            zzafx.zzcb("Device is linked for in app preview.");
            zza(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    public final void zzg(Context context, String str, String str2) {
        if (!zzi(context, str, str2)) {
            zzk(context, str, str2);
            return;
        }
        zzafx.zzcb("Device is linked for debug signals.");
        zza(context, "The device is successfully linked for troubleshooting.", false, true);
    }

    public final String zzrg() {
        String str;
        synchronized (this.mLock) {
            str = this.zzdci;
        }
        return str;
    }

    public final boolean zzrh() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdcj;
        }
        return z;
    }
}

package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.ads.AdActivity;
@zzzt
/* loaded from: classes.dex */
public final class zzafr {
    private String mSessionId;
    private long zzdaj = -1;
    private long zzdak = -1;
    private int zzdal = -1;
    int zzczy = -1;
    private long zzdam = 0;
    private final Object mLock = new Object();
    private int zzdan = 0;
    private int zzdao = 0;

    public zzafr(String str) {
        this.mSessionId = str;
    }

    private static boolean zzae(Context context) {
        int identifier = context.getResources().getIdentifier("Theme.Translucent", "style", "android");
        if (identifier == 0) {
            zzafx.zzcr("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                return true;
            }
            zzafx.zzcr("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            zzafx.zzcs("Fail to fetch AdActivity theme");
            zzafx.zzcr("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }

    public final void zzb(zzix zzixVar, long j) {
        synchronized (this.mLock) {
            long zzqa = com.google.android.gms.ads.internal.zzbv.zzee().zzqa();
            long currentTimeMillis = com.google.android.gms.ads.internal.zzbv.zzeg().currentTimeMillis();
            if (this.zzdak == -1) {
                if (currentTimeMillis - zzqa > ((Long) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbjn)).longValue()) {
                    this.zzczy = -1;
                } else {
                    this.zzczy = com.google.android.gms.ads.internal.zzbv.zzee().zzqd();
                }
                this.zzdak = j;
                this.zzdaj = this.zzdak;
            } else {
                this.zzdaj = j;
            }
            if (zzixVar == null || zzixVar.extras == null || zzixVar.extras.getInt("gw", 2) != 1) {
                this.zzdal++;
                this.zzczy++;
                if (this.zzczy == 0) {
                    this.zzdam = 0L;
                    com.google.android.gms.ads.internal.zzbv.zzee().zzk(currentTimeMillis);
                } else {
                    this.zzdam = currentTimeMillis - com.google.android.gms.ads.internal.zzbv.zzee().zzqb();
                }
            }
        }
    }

    public final Bundle zzo(Context context, String str) {
        Bundle bundle;
        synchronized (this.mLock) {
            bundle = new Bundle();
            bundle.putString("session_id", this.mSessionId);
            bundle.putLong("basets", this.zzdak);
            bundle.putLong("currts", this.zzdaj);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.zzdal);
            bundle.putInt("preqs_in_session", this.zzczy);
            bundle.putLong("time_in_session", this.zzdam);
            bundle.putInt("pclick", this.zzdan);
            bundle.putInt("pimp", this.zzdao);
            bundle.putBoolean("support_transparent_background", zzae(context));
        }
        return bundle;
    }

    public final void zzpf() {
        synchronized (this.mLock) {
            this.zzdao++;
        }
    }

    public final void zzpg() {
        synchronized (this.mLock) {
            this.zzdan++;
        }
    }
}

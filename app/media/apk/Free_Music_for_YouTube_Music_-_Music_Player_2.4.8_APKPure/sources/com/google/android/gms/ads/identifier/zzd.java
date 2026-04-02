package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.common.zzo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzd {
    private SharedPreferences zzamm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzd(Context context) {
        try {
            Context remoteContext = zzo.getRemoteContext(context);
            this.zzamm = remoteContext == null ? null : remoteContext.getSharedPreferences("google_ads_flags", 0);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while getting SharedPreferences ", th);
            this.zzamm = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean getBoolean(String str, boolean z) {
        try {
            if (this.zzamm == null) {
                return false;
            }
            return this.zzamm.getBoolean(str, false);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float getFloat(String str, float f) {
        try {
            if (this.zzamm == null) {
                return 0.0f;
            }
            return this.zzamm.getFloat(str, 0.0f);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return 0.0f;
        }
    }
}

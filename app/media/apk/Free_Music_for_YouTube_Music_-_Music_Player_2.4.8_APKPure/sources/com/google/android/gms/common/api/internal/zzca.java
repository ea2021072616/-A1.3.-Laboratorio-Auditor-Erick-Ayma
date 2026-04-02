package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.R;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbe;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.internal.zzbz;
@Deprecated
/* loaded from: classes.dex */
public final class zzca {
    private static final Object zzaqm = new Object();
    private static zzca zzfod;
    private final String mAppId;
    private final Status zzfoe;
    private final boolean zzfof;
    private final boolean zzfog;

    private zzca(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue));
        if (identifier != 0) {
            boolean z = resources.getInteger(identifier) != 0;
            this.zzfog = z ? false : true;
            r0 = z;
        } else {
            this.zzfog = false;
        }
        this.zzfof = r0;
        String zzcg = zzbe.zzcg(context);
        zzcg = zzcg == null ? new zzbz(context).getString("google_app_id") : zzcg;
        if (TextUtils.isEmpty(zzcg)) {
            this.zzfoe = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.mAppId = null;
            return;
        }
        this.mAppId = zzcg;
        this.zzfoe = Status.zzfhp;
    }

    public static String zzaid() {
        return zzfs("getGoogleAppId").mAppId;
    }

    public static boolean zzaie() {
        return zzfs("isMeasurementExplicitlyDisabled").zzfog;
    }

    public static Status zzcc(Context context) {
        Status status;
        zzbp.zzb(context, "Context must not be null.");
        synchronized (zzaqm) {
            if (zzfod == null) {
                zzfod = new zzca(context);
            }
            status = zzfod.zzfoe;
        }
        return status;
    }

    private static zzca zzfs(String str) {
        zzca zzcaVar;
        synchronized (zzaqm) {
            if (zzfod == null) {
                throw new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 34).append("Initialize must be called before ").append(str).append(".").toString());
            }
            zzcaVar = zzfod;
        }
        return zzcaVar;
    }
}

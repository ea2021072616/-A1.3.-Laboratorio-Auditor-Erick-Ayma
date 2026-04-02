package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.customtabs.CustomTabsSession;
import java.util.List;
@zzzt
/* loaded from: classes.dex */
public final class zznr implements zzehp {
    @Nullable
    private CustomTabsSession zzbqw;
    @Nullable
    private CustomTabsClient zzbqx;
    @Nullable
    private CustomTabsServiceConnection zzbqy;
    @Nullable
    private zzns zzbqz;

    public static boolean zzk(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        if (queryIntentActivities == null || resolveActivity == null) {
            return false;
        }
        for (int i = 0; i < queryIntentActivities.size(); i++) {
            if (resolveActivity.activityInfo.name.equals(queryIntentActivities.get(i).activityInfo.name)) {
                return resolveActivity.activityInfo.packageName.equals(zzehn.zzex(context));
            }
        }
        return false;
    }

    public final boolean mayLaunchUrl(Uri uri, Bundle bundle, List<Bundle> list) {
        if (this.zzbqx == null) {
            return false;
        }
        if (this.zzbqx == null) {
            this.zzbqw = null;
        } else if (this.zzbqw == null) {
            this.zzbqw = this.zzbqx.newSession(null);
        }
        CustomTabsSession customTabsSession = this.zzbqw;
        if (customTabsSession != null) {
            return customTabsSession.mayLaunchUrl(uri, null, null);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.zzehp
    public final void zza(CustomTabsClient customTabsClient) {
        this.zzbqx = customTabsClient;
        this.zzbqx.warmup(0L);
        if (this.zzbqz != null) {
            this.zzbqz.zzjb();
        }
    }

    public final void zza(zzns zznsVar) {
        this.zzbqz = zznsVar;
    }

    public final void zzc(Activity activity) {
        if (this.zzbqy == null) {
            return;
        }
        activity.unbindService(this.zzbqy);
        this.zzbqx = null;
        this.zzbqw = null;
        this.zzbqy = null;
    }

    public final void zzd(Activity activity) {
        String zzex;
        if (this.zzbqx == null && (zzex = zzehn.zzex(activity)) != null) {
            this.zzbqy = new zzeho(this);
            CustomTabsClient.bindCustomTabsService(activity, zzex, this.zzbqy);
        }
    }

    @Override // com.google.android.gms.internal.zzehp
    public final void zzja() {
        this.zzbqx = null;
        this.zzbqw = null;
    }
}

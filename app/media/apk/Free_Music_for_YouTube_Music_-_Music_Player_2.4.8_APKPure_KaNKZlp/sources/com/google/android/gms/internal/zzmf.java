package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.internal.zzbp;
@zzzt
/* loaded from: classes.dex */
public final class zzmf {
    private final Context mContext;

    public zzmf(Context context) {
        zzbp.zzb(context, "Context can not be null");
        this.mContext = context;
    }

    private final boolean zza(Intent intent) {
        zzbp.zzb(intent, "Intent can not be null");
        return !this.mContext.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }

    public final boolean zzig() {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        return zza(intent);
    }

    public final boolean zzih() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        return zza(intent);
    }

    public final boolean zzii() {
        return ((Boolean) zzaiz.zza(new zzmg())).booleanValue() && zzbdp.zzcs(this.mContext).checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    @TargetApi(14)
    public final boolean zzij() {
        return zza(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event"));
    }
}

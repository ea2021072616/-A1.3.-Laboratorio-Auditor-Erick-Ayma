package com.google.android.gms.internal;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
final class zzre implements zzrn {
    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        com.google.android.gms.ads.internal.zzbv.zzea();
        DisplayMetrics zza = zzahf.zza((WindowManager) zzakkVar.getContext().getSystemService("window"));
        int i = zza.widthPixels;
        int i2 = zza.heightPixels;
        int[] iArr = new int[2];
        HashMap hashMap = new HashMap();
        ((View) zzakkVar).getLocationInWindow(iArr);
        hashMap.put("xInPixels", Integer.valueOf(iArr[0]));
        hashMap.put("yInPixels", Integer.valueOf(iArr[1]));
        hashMap.put("windowWidthInPixels", Integer.valueOf(i));
        hashMap.put("windowHeightInPixels", Integer.valueOf(i2));
        zzakkVar.zza("locationReady", hashMap);
        zzafx.zzcs("GET LOCATION COMPILED");
    }
}

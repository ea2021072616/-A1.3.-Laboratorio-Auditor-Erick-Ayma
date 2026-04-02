package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
/* loaded from: classes.dex */
public final class zzi {
    private static Boolean zzfym;
    private static Boolean zzfyn;
    private static Boolean zzfyo;
    private static Boolean zzfyp;
    private static Boolean zzfyq;

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0038, code lost:
        if (com.google.android.gms.common.util.zzi.zzfyn.booleanValue() != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean zza(android.content.res.Resources r5) {
        /*
            r4 = 3
            r1 = 1
            r2 = 0
            if (r5 != 0) goto L6
        L5:
            return r2
        L6:
            java.lang.Boolean r0 = com.google.android.gms.common.util.zzi.zzfym
            if (r0 != 0) goto L41
            android.content.res.Configuration r0 = r5.getConfiguration()
            int r0 = r0.screenLayout
            r0 = r0 & 15
            if (r0 <= r4) goto L48
            r0 = r1
        L15:
            if (r0 != 0) goto L3a
            java.lang.Boolean r0 = com.google.android.gms.common.util.zzi.zzfyn
            if (r0 != 0) goto L32
            android.content.res.Configuration r0 = r5.getConfiguration()
            int r3 = r0.screenLayout
            r3 = r3 & 15
            if (r3 > r4) goto L4a
            int r0 = r0.smallestScreenWidthDp
            r3 = 600(0x258, float:8.41E-43)
            if (r0 < r3) goto L4a
            r0 = r1
        L2c:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            com.google.android.gms.common.util.zzi.zzfyn = r0
        L32:
            java.lang.Boolean r0 = com.google.android.gms.common.util.zzi.zzfyn
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L3b
        L3a:
            r2 = r1
        L3b:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
            com.google.android.gms.common.util.zzi.zzfym = r0
        L41:
            java.lang.Boolean r0 = com.google.android.gms.common.util.zzi.zzfym
            boolean r2 = r0.booleanValue()
            goto L5
        L48:
            r0 = r2
            goto L15
        L4a:
            r0 = r2
            goto L2c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.zzi.zza(android.content.res.Resources):boolean");
    }

    @TargetApi(20)
    public static boolean zzcj(Context context) {
        if (zzfyo == null) {
            zzfyo = Boolean.valueOf(zzp.zzali() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return zzfyo.booleanValue();
    }

    @TargetApi(24)
    public static boolean zzck(Context context) {
        return (!zzp.isAtLeastN() || zzcl(context)) && zzcj(context);
    }

    @TargetApi(21)
    public static boolean zzcl(Context context) {
        if (zzfyp == null) {
            zzfyp = Boolean.valueOf(zzp.zzalj() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return zzfyp.booleanValue();
    }

    public static boolean zzcm(Context context) {
        if (zzfyq == null) {
            zzfyq = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return zzfyq.booleanValue();
    }
}

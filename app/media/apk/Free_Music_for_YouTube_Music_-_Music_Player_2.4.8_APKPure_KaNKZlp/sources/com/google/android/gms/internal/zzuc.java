package com.google.android.gms.internal;

import android.support.v7.widget.ActivityChooserView;
@zzzt
/* loaded from: classes.dex */
final class zzuc {
    private static final zztz zzbyc = zztz.zzkp();
    private static final float zzbyd = ((Float) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbkm)).floatValue();
    private static final long zzbye = ((Long) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbkk)).longValue();
    private static final float zzbyf = ((Float) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbkn)).floatValue();
    private static final long zzbyg = ((Long) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbkl)).longValue();

    private static int zzb(long j, int i) {
        return (int) ((j >>> ((i % 16) * 4)) & 15);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzkz() {
        int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int zzkw = zzbyc.zzkw();
        int zzkx = zzbyc.zzkx();
        int zzku = zzbyc.zzku() + zzbyc.zzkv();
        if (zzkx <= ((zzkw >= 16 || zzbyg == 0) ? zzbyf != 0.0f ? ((int) (zzbyf * zzkw)) + 1 : Integer.MAX_VALUE : zzb(zzbyg, zzkw))) {
            if (zzkw < 16 && zzbye != 0) {
                i = zzb(zzbye, zzkw);
            } else if (zzbyd != 0.0f) {
                i = (int) (zzbyd * zzkw);
            }
            if (zzku <= i) {
                return true;
            }
        }
        return false;
    }
}

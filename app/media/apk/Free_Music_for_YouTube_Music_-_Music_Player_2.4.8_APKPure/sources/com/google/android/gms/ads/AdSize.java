package com.google.android.gms.ads;

import android.content.Context;
import android.support.v7.widget.helper.ItemTouchHelper;
import com.google.android.gms.internal.zzaje;
import com.google.android.gms.internal.zzjb;
import com.google.android.gms.internal.zzjo;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
/* loaded from: classes.dex */
public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final int FULL_WIDTH = -1;
    private final int zzakv;
    private final int zzakw;
    private final String zzakx;
    public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
    public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
    public static final AdSize LARGE_BANNER = new AdSize(320, 100, "320x100_as");
    public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
    public static final AdSize MEDIUM_RECTANGLE = new AdSize(IjkMediaCodecInfo.RANK_SECURE, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, "300x250_as");
    public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, IjkMediaCodecInfo.RANK_LAST_CHANCE, "160x600_as");
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");
    public static final AdSize FLUID = new AdSize(-3, -4, "fluid");
    public static final AdSize zzaku = new AdSize(50, 50, "50x50_mb");
    public static final AdSize SEARCH = new AdSize(-3, 0, "search_v2");

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AdSize(int r6, int r7) {
        /*
            r5 = this;
            r0 = -1
            if (r6 != r0) goto L48
            java.lang.String r0 = "FULL"
            r1 = r0
        L6:
            r0 = -2
            if (r7 != r0) goto L4e
            java.lang.String r0 = "AUTO"
        Lb:
            java.lang.String r2 = "_as"
            java.lang.String r3 = java.lang.String.valueOf(r1)
            int r3 = r3.length()
            int r3 = r3 + 1
            java.lang.String r4 = java.lang.String.valueOf(r0)
            int r4 = r4.length()
            int r3 = r3 + r4
            java.lang.String r4 = java.lang.String.valueOf(r2)
            int r4 = r4.length()
            int r3 = r3 + r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.StringBuilder r1 = r4.append(r1)
            java.lang.String r3 = "x"
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            r5.<init>(r6, r7, r0)
            return
        L48:
            java.lang.String r0 = java.lang.String.valueOf(r6)
            r1 = r0
            goto L6
        L4e:
            java.lang.String r0 = java.lang.String.valueOf(r7)
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.AdSize.<init>(int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdSize(int i, int i2, String str) {
        if (i < 0 && i != -1 && i != -3) {
            throw new IllegalArgumentException(new StringBuilder(37).append("Invalid width for AdSize: ").append(i).toString());
        }
        if (i2 < 0 && i2 != -2 && i2 != -4) {
            throw new IllegalArgumentException(new StringBuilder(38).append("Invalid height for AdSize: ").append(i2).toString());
        }
        this.zzakv = i;
        this.zzakw = i2;
        this.zzakx = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AdSize) {
            AdSize adSize = (AdSize) obj;
            return this.zzakv == adSize.zzakv && this.zzakw == adSize.zzakw && this.zzakx.equals(adSize.zzakx);
        }
        return false;
    }

    public final int getHeight() {
        return this.zzakw;
    }

    public final int getHeightInPixels(Context context) {
        switch (this.zzakw) {
            case -4:
            case -3:
                return -1;
            case -2:
                return zzjb.zzc(context.getResources().getDisplayMetrics());
            default:
                zzjo.zzhu();
                return zzaje.zzc(context, this.zzakw);
        }
    }

    public final int getWidth() {
        return this.zzakv;
    }

    public final int getWidthInPixels(Context context) {
        switch (this.zzakv) {
            case -4:
            case -3:
                return -1;
            case -2:
            default:
                zzjo.zzhu();
                return zzaje.zzc(context, this.zzakv);
            case -1:
                return zzjb.zzb(context.getResources().getDisplayMetrics());
        }
    }

    public final int hashCode() {
        return this.zzakx.hashCode();
    }

    public final boolean isAutoHeight() {
        return this.zzakw == -2;
    }

    public final boolean isFluid() {
        return this.zzakv == -3 && this.zzakw == -4;
    }

    public final boolean isFullWidth() {
        return this.zzakv == -1;
    }

    public final String toString() {
        return this.zzakx;
    }
}

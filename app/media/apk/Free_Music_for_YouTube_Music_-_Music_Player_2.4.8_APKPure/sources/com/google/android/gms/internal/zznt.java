package com.google.android.gms.internal;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;
@zzzt
/* loaded from: classes.dex */
public final class zznt extends zzoz {
    private static final int zzbra = Color.rgb(12, 174, 206);
    private static final int zzbrb;
    private static int zzbrc;
    private static int zzbrd;
    private final int mTextColor;
    private final String zzbre;
    private final List<zznv> zzbrf = new ArrayList();
    private final List<zzpc> zzbrg = new ArrayList();
    private final int zzbrh;
    private final int zzbri;
    private final int zzbrj;
    private final int zzbrk;
    private final boolean zzbrl;

    static {
        int rgb = Color.rgb(204, 204, 204);
        zzbrb = rgb;
        zzbrc = rgb;
        zzbrd = zzbra;
    }

    public zznt(String str, List<zznv> list, Integer num, Integer num2, Integer num3, int i, int i2, boolean z) {
        this.zzbre = str;
        if (list != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= list.size()) {
                    break;
                }
                zznv zznvVar = list.get(i4);
                this.zzbrf.add(zznvVar);
                this.zzbrg.add(zznvVar);
                i3 = i4 + 1;
            }
        }
        this.zzbrh = num != null ? num.intValue() : zzbrc;
        this.mTextColor = num2 != null ? num2.intValue() : zzbrd;
        this.zzbri = num3 != null ? num3.intValue() : 12;
        this.zzbrj = i;
        this.zzbrk = i2;
        this.zzbrl = z;
    }

    public final int getBackgroundColor() {
        return this.zzbrh;
    }

    @Override // com.google.android.gms.internal.zzoy
    public final String getText() {
        return this.zzbre;
    }

    public final int getTextColor() {
        return this.mTextColor;
    }

    public final int getTextSize() {
        return this.zzbri;
    }

    @Override // com.google.android.gms.internal.zzoy
    public final List<zzpc> zzjc() {
        return this.zzbrg;
    }

    public final List<zznv> zzjd() {
        return this.zzbrf;
    }

    public final int zzje() {
        return this.zzbrj;
    }

    public final int zzjf() {
        return this.zzbrk;
    }

    public final boolean zzjg() {
        return this.zzbrl;
    }
}

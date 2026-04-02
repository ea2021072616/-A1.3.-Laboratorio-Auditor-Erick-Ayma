package com.google.android.gms.internal;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
@zzzt
/* loaded from: classes.dex */
public final class zzaiv {
    private Map<Integer, Bitmap> zzddo = new ConcurrentHashMap();
    private AtomicInteger zzddp = new AtomicInteger(0);

    public final Bitmap zza(Integer num) {
        return this.zzddo.get(num);
    }

    public final int zzb(Bitmap bitmap) {
        if (bitmap == null) {
            zzafx.zzcb("Bitmap is null. Skipping putting into the Memory Map.");
            return -1;
        }
        int andIncrement = this.zzddp.getAndIncrement();
        this.zzddo.put(Integer.valueOf(andIncrement), bitmap);
        return andIncrement;
    }

    public final void zzb(Integer num) {
        this.zzddo.remove(num);
    }
}

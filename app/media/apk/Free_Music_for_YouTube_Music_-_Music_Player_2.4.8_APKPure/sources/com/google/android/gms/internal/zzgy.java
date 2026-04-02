package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
@zzzt
/* loaded from: classes.dex */
public final class zzgy {
    private int zzayb;
    private final Object mLock = new Object();
    private List<zzgx> zzayc = new LinkedList();

    public final boolean zza(zzgx zzgxVar) {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzayc.contains(zzgxVar);
        }
        return z;
    }

    public final boolean zzb(zzgx zzgxVar) {
        synchronized (this.mLock) {
            Iterator<zzgx> it = this.zzayc.iterator();
            while (it.hasNext()) {
                zzgx next = it.next();
                if (!((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbia)).booleanValue() || com.google.android.gms.ads.internal.zzbv.zzee().zzpp()) {
                    if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbic)).booleanValue() && !com.google.android.gms.ads.internal.zzbv.zzee().zzpq() && zzgxVar != next && next.zzgg().equals(zzgxVar.zzgg())) {
                        it.remove();
                        return true;
                    }
                } else if (zzgxVar != next && next.zzge().equals(zzgxVar.zzge())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    public final void zzc(zzgx zzgxVar) {
        synchronized (this.mLock) {
            if (this.zzayc.size() >= 10) {
                zzafx.zzcb(new StringBuilder(41).append("Queue is full, current size = ").append(this.zzayc.size()).toString());
                this.zzayc.remove(0);
            }
            int i = this.zzayb;
            this.zzayb = i + 1;
            zzgxVar.zzm(i);
            this.zzayc.add(zzgxVar);
        }
    }

    @Nullable
    public final zzgx zzgm() {
        int i;
        zzgx zzgxVar;
        int i2;
        zzgx zzgxVar2 = null;
        int i3 = 0;
        synchronized (this.mLock) {
            if (this.zzayc.size() == 0) {
                zzafx.zzcb("Queue empty");
                return null;
            } else if (this.zzayc.size() < 2) {
                zzgx zzgxVar3 = this.zzayc.get(0);
                zzgxVar3.zzgh();
                return zzgxVar3;
            } else {
                int i4 = Integer.MIN_VALUE;
                int i5 = 0;
                for (zzgx zzgxVar4 : this.zzayc) {
                    int score = zzgxVar4.getScore();
                    if (score > i4) {
                        i2 = score;
                        zzgxVar = zzgxVar4;
                        i = i5;
                    } else {
                        i = i3;
                        zzgxVar = zzgxVar2;
                        i2 = i4;
                    }
                    i5++;
                    i4 = i2;
                    zzgxVar2 = zzgxVar;
                    i3 = i;
                }
                this.zzayc.remove(i3);
                return zzgxVar2;
            }
        }
    }
}

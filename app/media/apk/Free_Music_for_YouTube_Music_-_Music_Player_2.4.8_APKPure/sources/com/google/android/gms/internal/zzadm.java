package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;
@zzzt
/* loaded from: classes.dex */
public final class zzadm implements RewardItem {
    private final zzadb zzcvw;

    public zzadm(zzadb zzadbVar) {
        this.zzcvw = zzadbVar;
    }

    @Override // com.google.android.gms.ads.reward.RewardItem
    public final int getAmount() {
        if (this.zzcvw == null) {
            return 0;
        }
        try {
            return this.zzcvw.getAmount();
        } catch (RemoteException e) {
            zzaji.zzc("Could not forward getAmount to RewardItem", e);
            return 0;
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardItem
    public final String getType() {
        if (this.zzcvw == null) {
            return null;
        }
        try {
            return this.zzcvw.getType();
        } catch (RemoteException e) {
            zzaji.zzc("Could not forward getType to RewardItem", e);
            return null;
        }
    }
}

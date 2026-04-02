package com.google.android.gms.internal;

import java.util.HashMap;
/* loaded from: classes2.dex */
public final class zzdi extends zzbs<Integer, Long> {
    public Long zzaji;
    public Long zzfv;
    public Long zzfw;

    public zzdi() {
    }

    public zzdi(String str) {
        zzi(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzbs
    public final void zzi(String str) {
        HashMap zzj = zzj(str);
        if (zzj != null) {
            this.zzaji = (Long) zzj.get(0);
            this.zzfv = (Long) zzj.get(1);
            this.zzfw = (Long) zzj.get(2);
        }
    }

    @Override // com.google.android.gms.internal.zzbs
    protected final HashMap<Integer, Long> zzv() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zzaji);
        hashMap.put(1, this.zzfv);
        hashMap.put(2, this.zzfw);
        return hashMap;
    }
}

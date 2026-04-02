package com.google.android.gms.internal;

import java.util.HashMap;
/* loaded from: classes2.dex */
public final class zzdb extends zzbs<Integer, Long> {
    public Long zzaic;
    public Long zzaid;

    public zzdb() {
    }

    public zzdb(String str) {
        zzi(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzbs
    public final void zzi(String str) {
        HashMap zzj = zzj(str);
        if (zzj != null) {
            this.zzaic = (Long) zzj.get(0);
            this.zzaid = (Long) zzj.get(1);
        }
    }

    @Override // com.google.android.gms.internal.zzbs
    protected final HashMap<Integer, Long> zzv() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zzaic);
        hashMap.put(1, this.zzaid);
        return hashMap;
    }
}

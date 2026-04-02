package com.google.android.gms.internal;

import java.util.HashMap;
/* loaded from: classes2.dex */
public final class zzda extends zzbs<Integer, Object> {
    public Long zzahz;
    public Boolean zzaia;
    public Boolean zzaib;

    public zzda() {
    }

    public zzda(String str) {
        zzi(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzbs
    public final void zzi(String str) {
        HashMap zzj = zzj(str);
        if (zzj != null) {
            this.zzahz = (Long) zzj.get(0);
            this.zzaia = (Boolean) zzj.get(1);
            this.zzaib = (Boolean) zzj.get(2);
        }
    }

    @Override // com.google.android.gms.internal.zzbs
    protected final HashMap<Integer, Object> zzv() {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(0, this.zzahz);
        hashMap.put(1, this.zzaia);
        hashMap.put(2, this.zzaib);
        return hashMap;
    }
}

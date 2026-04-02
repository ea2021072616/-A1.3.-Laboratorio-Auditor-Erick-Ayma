package com.google.android.gms.internal;

import java.util.HashMap;
/* loaded from: classes2.dex */
public final class zzbu extends zzbs<Integer, Object> {
    public String zzct;
    public String zzcv;
    public String zzcw;
    public String zzcx;
    public long zzyo;

    public zzbu() {
        this.zzct = "E";
        this.zzyo = -1L;
        this.zzcv = "E";
        this.zzcw = "E";
        this.zzcx = "E";
    }

    public zzbu(String str) {
        this();
        zzi(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzbs
    public final void zzi(String str) {
        HashMap zzj = zzj(str);
        if (zzj != null) {
            this.zzct = zzj.get(0) == null ? "E" : (String) zzj.get(0);
            this.zzyo = zzj.get(1) == null ? -1L : ((Long) zzj.get(1)).longValue();
            this.zzcv = zzj.get(2) == null ? "E" : (String) zzj.get(2);
            this.zzcw = zzj.get(3) == null ? "E" : (String) zzj.get(3);
            this.zzcx = zzj.get(4) == null ? "E" : (String) zzj.get(4);
        }
    }

    @Override // com.google.android.gms.internal.zzbs
    protected final HashMap<Integer, Object> zzv() {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(0, this.zzct);
        hashMap.put(4, this.zzcx);
        hashMap.put(3, this.zzcw);
        hashMap.put(2, this.zzcv);
        hashMap.put(1, Long.valueOf(this.zzyo));
        return hashMap;
    }
}

package com.google.android.gms.internal;

import java.util.HashMap;
/* loaded from: classes2.dex */
public final class zzdg extends zzbs<Integer, Long> {
    public Long zzaiy;
    public Long zzaiz;
    public Long zzaja;
    public Long zzajb;
    public Long zzajc;
    public Long zzajd;
    public Long zzaje;
    public Long zzajf;
    public Long zzajg;
    public Long zzfb;
    public Long zzfd;
    public Long zzfh;
    public Long zzfi;

    public zzdg() {
    }

    public zzdg(String str) {
        zzi(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzbs
    public final void zzi(String str) {
        HashMap zzj = zzj(str);
        if (zzj != null) {
            this.zzaiy = (Long) zzj.get(0);
            this.zzaiz = (Long) zzj.get(1);
            this.zzaja = (Long) zzj.get(2);
            this.zzfd = (Long) zzj.get(3);
            this.zzfb = (Long) zzj.get(4);
            this.zzajb = (Long) zzj.get(5);
            this.zzajc = (Long) zzj.get(6);
            this.zzajd = (Long) zzj.get(7);
            this.zzfi = (Long) zzj.get(8);
            this.zzfh = (Long) zzj.get(9);
            this.zzaje = (Long) zzj.get(10);
            this.zzajf = (Long) zzj.get(11);
            this.zzajg = (Long) zzj.get(12);
        }
    }

    @Override // com.google.android.gms.internal.zzbs
    protected final HashMap<Integer, Long> zzv() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zzaiy);
        hashMap.put(1, this.zzaiz);
        hashMap.put(2, this.zzaja);
        hashMap.put(3, this.zzfd);
        hashMap.put(4, this.zzfb);
        hashMap.put(5, this.zzajb);
        hashMap.put(6, this.zzajc);
        hashMap.put(7, this.zzajd);
        hashMap.put(8, this.zzfi);
        hashMap.put(9, this.zzfh);
        hashMap.put(10, this.zzaje);
        hashMap.put(11, this.zzajf);
        hashMap.put(12, this.zzajg);
        return hashMap;
    }
}

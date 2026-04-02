package com.google.android.gms.internal;

import java.io.IOException;
/* loaded from: classes2.dex */
public abstract class zzego {
    protected volatile int zzndd = -1;

    public static final <T extends zzego> T zza(T t, byte[] bArr) throws zzegn {
        return (T) zza(t, bArr, 0, bArr.length);
    }

    private static <T extends zzego> T zza(T t, byte[] bArr, int i, int i2) throws zzegn {
        try {
            zzegf zzh = zzegf.zzh(bArr, 0, i2);
            t.zza(zzh);
            zzh.zzgk(0);
            return t;
        } catch (zzegn e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e2);
        }
    }

    public static final byte[] zzc(zzego zzegoVar) {
        byte[] bArr = new byte[zzegoVar.zzbjo()];
        try {
            zzegg zzi = zzegg.zzi(bArr, 0, bArr.length);
            zzegoVar.zza(zzi);
            zzi.zzccd();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public String toString() {
        return zzegp.zzd(this);
    }

    public abstract zzego zza(zzegf zzegfVar) throws IOException;

    public void zza(zzegg zzeggVar) throws IOException {
    }

    public final int zzbjo() {
        int zzn = zzn();
        this.zzndd = zzn;
        return zzn;
    }

    @Override // 
    /* renamed from: zzcdz */
    public zzego clone() throws CloneNotSupportedException {
        return (zzego) super.clone();
    }

    public final int zzcef() {
        if (this.zzndd < 0) {
            zzbjo();
        }
        return this.zzndd;
    }

    protected int zzn() {
        return 0;
    }
}

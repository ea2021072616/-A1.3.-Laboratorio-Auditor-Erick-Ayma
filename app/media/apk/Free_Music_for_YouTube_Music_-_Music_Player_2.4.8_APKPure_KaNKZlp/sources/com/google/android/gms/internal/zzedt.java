package com.google.android.gms.internal;

import android.support.v7.widget.ActivityChooserView;
import java.io.IOException;
/* loaded from: classes2.dex */
public abstract class zzedt {
    int zzmxy;
    int zzmxz;
    private int zzmya;

    private zzedt() {
        this.zzmxz = 100;
        this.zzmya = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }

    public static zzedt zzas(byte[] bArr) {
        return zzb(bArr, 0, bArr.length, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzedt zzb(byte[] bArr, int i, int i2, boolean z) {
        zzedv zzedvVar = new zzedv(bArr, i, i2, z);
        try {
            zzedvVar.zzgm(i2);
            return zzedvVar;
        } catch (zzeer e) {
            throw new IllegalArgumentException(e);
        }
    }

    public abstract <T extends zzeed<T, ?>> T zza(T t, zzedz zzedzVar) throws IOException;

    public abstract int zzcbr() throws IOException;

    public abstract int zzcbs() throws IOException;

    public abstract String zzcbt() throws IOException;

    public abstract zzedk zzcbu() throws IOException;

    public abstract int zzcbv() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long zzcbw() throws IOException;

    public abstract boolean zzcbx() throws IOException;

    public abstract int zzcby();

    public abstract void zzgk(int i) throws zzeer;

    public abstract boolean zzgl(int i) throws IOException;

    public abstract int zzgm(int i) throws zzeer;

    public abstract void zzgn(int i);

    public abstract void zzgo(int i) throws IOException;
}

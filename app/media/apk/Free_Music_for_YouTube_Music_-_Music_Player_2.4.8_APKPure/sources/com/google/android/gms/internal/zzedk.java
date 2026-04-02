package com.google.android.gms.internal;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class zzedk implements Serializable, Iterable<Byte> {
    public static final zzedk zzmxr = new zzedr(zzeen.EMPTY_BYTE_ARRAY);
    private static final zzedo zzmxs;
    private int zzmxt = 0;

    static {
        boolean z = true;
        try {
            Class.forName("android.content.Context");
        } catch (ClassNotFoundException e) {
            z = false;
        }
        zzmxs = z ? new zzeds(null) : new zzedm(null);
    }

    public static zzedk zzaq(byte[] bArr) {
        return zzc(bArr, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzedk zzar(byte[] bArr) {
        return new zzedr(bArr);
    }

    public static zzedk zzc(byte[] bArr, int i, int i2) {
        return new zzedr(zzmxs.zzd(bArr, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) < 0) {
            if (i < 0) {
                throw new IndexOutOfBoundsException(new StringBuilder(32).append("Beginning index: ").append(i).append(" < 0").toString());
            }
            if (i2 < i) {
                throw new IndexOutOfBoundsException(new StringBuilder(66).append("Beginning index larger than ending index: ").append(i).append(", ").append(i2).toString());
            }
            throw new IndexOutOfBoundsException(new StringBuilder(37).append("End index: ").append(i2).append(" >= ").append(i3).toString());
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzedp zzgj(int i) {
        return new zzedp(i, null);
    }

    public static zzedk zzra(String str) {
        return new zzedr(str.getBytes(zzeen.UTF_8));
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zzmxt;
        if (i == 0) {
            int size = size();
            i = zzf(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.zzmxt = i;
        }
        return i;
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new zzedl(this);
    }

    public abstract int size();

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return zzeen.EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[size];
        zza(bArr, 0, 0, size);
        return bArr;
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zza(zzedj zzedjVar) throws IOException;

    protected abstract void zza(byte[] bArr, int i, int i2, int i3);

    public abstract zzedt zzcbm();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int zzcbn() {
        return this.zzmxt;
    }

    protected abstract int zzf(int i, int i2, int i3);

    public abstract byte zzgi(int i);

    public abstract zzedk zzs(int i, int i2);
}

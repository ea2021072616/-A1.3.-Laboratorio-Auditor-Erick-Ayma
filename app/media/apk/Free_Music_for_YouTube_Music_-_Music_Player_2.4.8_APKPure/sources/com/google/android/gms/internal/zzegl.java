package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzegl implements Cloneable {
    private Object value;
    private zzegj<?, ?> zznda;
    private List<zzegq> zzndb = new ArrayList();

    private final byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzn()];
        zza(zzegg.zzav(bArr));
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzcea */
    public zzegl clone() {
        int i = 0;
        zzegl zzeglVar = new zzegl();
        try {
            zzeglVar.zznda = this.zznda;
            if (this.zzndb == null) {
                zzeglVar.zzndb = null;
            } else {
                zzeglVar.zzndb.addAll(this.zzndb);
            }
            if (this.value != null) {
                if (this.value instanceof zzego) {
                    zzeglVar.value = (zzego) ((zzego) this.value).clone();
                } else if (this.value instanceof byte[]) {
                    zzeglVar.value = ((byte[]) this.value).clone();
                } else if (this.value instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.value;
                    byte[][] bArr2 = new byte[bArr.length];
                    zzeglVar.value = bArr2;
                    for (int i2 = 0; i2 < bArr.length; i2++) {
                        bArr2[i2] = (byte[]) bArr[i2].clone();
                    }
                } else if (this.value instanceof boolean[]) {
                    zzeglVar.value = ((boolean[]) this.value).clone();
                } else if (this.value instanceof int[]) {
                    zzeglVar.value = ((int[]) this.value).clone();
                } else if (this.value instanceof long[]) {
                    zzeglVar.value = ((long[]) this.value).clone();
                } else if (this.value instanceof float[]) {
                    zzeglVar.value = ((float[]) this.value).clone();
                } else if (this.value instanceof double[]) {
                    zzeglVar.value = ((double[]) this.value).clone();
                } else if (this.value instanceof zzego[]) {
                    zzego[] zzegoVarArr = (zzego[]) this.value;
                    zzego[] zzegoVarArr2 = new zzego[zzegoVarArr.length];
                    zzeglVar.value = zzegoVarArr2;
                    while (true) {
                        int i3 = i;
                        if (i3 >= zzegoVarArr.length) {
                            break;
                        }
                        zzegoVarArr2[i3] = (zzego) zzegoVarArr[i3].clone();
                        i = i3 + 1;
                    }
                }
            }
            return zzeglVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzegl) {
            zzegl zzeglVar = (zzegl) obj;
            if (this.value != null && zzeglVar.value != null) {
                if (this.zznda == zzeglVar.zznda) {
                    return !this.zznda.zzmhh.isArray() ? this.value.equals(zzeglVar.value) : this.value instanceof byte[] ? Arrays.equals((byte[]) this.value, (byte[]) zzeglVar.value) : this.value instanceof int[] ? Arrays.equals((int[]) this.value, (int[]) zzeglVar.value) : this.value instanceof long[] ? Arrays.equals((long[]) this.value, (long[]) zzeglVar.value) : this.value instanceof float[] ? Arrays.equals((float[]) this.value, (float[]) zzeglVar.value) : this.value instanceof double[] ? Arrays.equals((double[]) this.value, (double[]) zzeglVar.value) : this.value instanceof boolean[] ? Arrays.equals((boolean[]) this.value, (boolean[]) zzeglVar.value) : Arrays.deepEquals((Object[]) this.value, (Object[]) zzeglVar.value);
                }
                return false;
            } else if (this.zzndb == null || zzeglVar.zzndb == null) {
                try {
                    return Arrays.equals(toByteArray(), zzeglVar.toByteArray());
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }
            } else {
                return this.zzndb.equals(zzeglVar.zzndb);
            }
        }
        return false;
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzegg zzeggVar) throws IOException {
        if (this.value == null) {
            for (zzegq zzegqVar : this.zzndb) {
                zzeggVar.zzhc(zzegqVar.tag);
                zzeggVar.zzax(zzegqVar.zzjao);
            }
            return;
        }
        zzegj<?, ?> zzegjVar = this.zznda;
        Object obj = this.value;
        if (!zzegjVar.zzncv) {
            zzegjVar.zza(obj, zzeggVar);
            return;
        }
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                zzegjVar.zza(obj2, zzeggVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzegq zzegqVar) {
        this.zzndb.add(zzegqVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T zzb(zzegj<?, T> zzegjVar) {
        if (this.value == null) {
            this.zznda = zzegjVar;
            this.value = zzegjVar.zzav(this.zzndb);
            this.zzndb = null;
        } else if (!this.zznda.equals(zzegjVar)) {
            throw new IllegalStateException("Tried to getExtension with a different Extension.");
        }
        return (T) this.value;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzn() {
        int i = 0;
        if (this.value != null) {
            zzegj<?, ?> zzegjVar = this.zznda;
            Object obj = this.value;
            if (zzegjVar.zzncv) {
                int length = Array.getLength(obj);
                for (int i2 = 0; i2 < length; i2++) {
                    if (Array.get(obj, i2) != null) {
                        i += zzegjVar.zzbx(Array.get(obj, i2));
                    }
                }
                return i;
            }
            return zzegjVar.zzbx(obj);
        }
        Iterator<zzegq> it = this.zzndb.iterator();
        while (true) {
            int i3 = i;
            if (!it.hasNext()) {
                return i3;
            }
            zzegq next = it.next();
            i = next.zzjao.length + zzegg.zzhd(next.tag) + 0 + i3;
        }
    }
}

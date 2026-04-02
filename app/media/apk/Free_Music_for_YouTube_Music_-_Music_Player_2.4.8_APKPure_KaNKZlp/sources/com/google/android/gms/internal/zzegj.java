package com.google.android.gms.internal;

import com.google.android.gms.internal.zzegi;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class zzegj<M extends zzegi<M>, T> {
    public final int tag;
    private int type;
    protected final Class<T> zzmhh;
    private zzeed<?, ?> zzmyt;
    protected final boolean zzncv;

    private zzegj(int i, Class<T> cls, int i2, boolean z) {
        this(11, cls, null, i2, false);
    }

    private zzegj(int i, Class<T> cls, zzeed<?, ?> zzeedVar, int i2, boolean z) {
        this.type = i;
        this.zzmhh = cls;
        this.tag = i2;
        this.zzncv = false;
        this.zzmyt = null;
    }

    public static <M extends zzegi<M>, T extends zzego> zzegj<M, T> zza(int i, Class<T> cls, long j) {
        return new zzegj<>(11, cls, (int) j, false);
    }

    private final Object zzb(zzegf zzegfVar) {
        Class<?> componentType = this.zzncv ? this.zzmhh.getComponentType() : this.zzmhh;
        try {
            switch (this.type) {
                case 10:
                    zzego zzegoVar = (zzego) componentType.newInstance();
                    zzegfVar.zza(zzegoVar, this.tag >>> 3);
                    return zzegoVar;
                case 11:
                    zzego zzegoVar2 = (zzego) componentType.newInstance();
                    zzegfVar.zza(zzegoVar2);
                    return zzegoVar2;
                default:
                    throw new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.type).toString());
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Error reading extension field", e);
        } catch (IllegalAccessException e2) {
            String valueOf = String.valueOf(componentType);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 33).append("Error creating instance of class ").append(valueOf).toString(), e2);
        } catch (InstantiationException e3) {
            String valueOf2 = String.valueOf(componentType);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf2).length() + 33).append("Error creating instance of class ").append(valueOf2).toString(), e3);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzegj) {
            zzegj zzegjVar = (zzegj) obj;
            return this.type == zzegjVar.type && this.zzmhh == zzegjVar.zzmhh && this.tag == zzegjVar.tag && this.zzncv == zzegjVar.zzncv;
        }
        return false;
    }

    public final int hashCode() {
        return (this.zzncv ? 1 : 0) + ((((((this.type + 1147) * 31) + this.zzmhh.hashCode()) * 31) + this.tag) * 31);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(Object obj, zzegg zzeggVar) {
        try {
            zzeggVar.zzhc(this.tag);
            switch (this.type) {
                case 10:
                    ((zzego) obj).zza(zzeggVar);
                    zzeggVar.zzt(this.tag >>> 3, 4);
                    return;
                case 11:
                    zzeggVar.zzb((zzego) obj);
                    return;
                default:
                    throw new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.type).toString());
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final T zzav(List<zzegq> list) {
        if (list == null) {
            return null;
        }
        if (!this.zzncv) {
            if (list.isEmpty()) {
                return null;
            }
            return this.zzmhh.cast(zzb(zzegf.zzau(list.get(list.size() - 1).zzjao)));
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            zzegq zzegqVar = list.get(i);
            if (zzegqVar.zzjao.length != 0) {
                arrayList.add(zzb(zzegf.zzau(zzegqVar.zzjao)));
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        T cast = this.zzmhh.cast(Array.newInstance(this.zzmhh.getComponentType(), size));
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(cast, i2, arrayList.get(i2));
        }
        return cast;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int zzbx(Object obj) {
        int i = this.tag >>> 3;
        switch (this.type) {
            case 10:
                return (zzegg.zzgr(i) << 1) + ((zzego) obj).zzbjo();
            case 11:
                return zzegg.zzb(i, (zzego) obj);
            default:
                throw new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.type).toString());
        }
    }
}

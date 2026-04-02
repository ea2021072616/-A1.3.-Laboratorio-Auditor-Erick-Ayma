package com.google.android.gms.internal;

import com.google.android.gms.internal.zzeed;
import com.google.android.gms.internal.zzeee;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public abstract class zzeed<MessageType extends zzeed<MessageType, BuilderType>, BuilderType extends zzeee<MessageType, BuilderType>> extends zzedf<MessageType, BuilderType> {
    protected zzefq zzmyr = zzefq.zzcdh();
    protected int zzmys = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzeed<T, ?>> T zza(T t, zzedk zzedkVar) throws zzeer {
        T t2 = (T) zza(t, zzedkVar, zzedz.zzcci());
        if (t2 != null) {
            if (!(t2.zza(zzeel.zzmza, Boolean.TRUE, null) != null)) {
                throw new zzefp(t2).zzcdg().zze(t2);
            }
        }
        if (t2 != null) {
            if (!(t2.zza(zzeel.zzmza, Boolean.TRUE, null) != null)) {
                throw new zzefp(t2).zzcdg().zze(t2);
            }
        }
        return t2;
    }

    private static <T extends zzeed<T, ?>> T zza(T t, zzedk zzedkVar, zzedz zzedzVar) throws zzeer {
        try {
            zzedt zzcbm = zzedkVar.zzcbm();
            T t2 = (T) zza(t, zzcbm, zzedzVar);
            try {
                zzcbm.zzgk(0);
                return t2;
            } catch (zzeer e) {
                throw e.zze(t2);
            }
        } catch (zzeer e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends zzeed<T, ?>> T zza(T t, zzedt zzedtVar, zzedz zzedzVar) throws zzeer {
        T t2 = (T) t.zza(zzeel.zzmze, null, null);
        try {
            t2.zza(zzeel.zzmzc, zzedtVar, zzedzVar);
            t2.zza(zzeel.zzmzd, null, null);
            t2.zzmyr.zzbhq();
            return t2;
        } catch (RuntimeException e) {
            if (e.getCause() instanceof zzeer) {
                throw ((zzeer) e.getCause());
            }
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzeed<T, ?>> T zza(T t, byte[] bArr) throws zzeer {
        T t2 = (T) zza(t, bArr, zzedz.zzcci());
        if (t2 != null) {
            if (!(t2.zza(zzeel.zzmza, Boolean.TRUE, null) != null)) {
                throw new zzefp(t2).zzcdg().zze(t2);
            }
        }
        return t2;
    }

    private static <T extends zzeed<T, ?>> T zza(T t, byte[] bArr, zzedz zzedzVar) throws zzeer {
        try {
            zzedt zzas = zzedt.zzas(bArr);
            T t2 = (T) zza(t, zzas, zzedzVar);
            try {
                zzas.zzgk(0);
                return t2;
            } catch (zzeer e) {
                throw e.zze(t2);
            }
        } catch (zzeer e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> zzeeq<E> zzccm() {
        return zzefd.zzccy();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (((zzeed) zza(zzeel.zzmzg, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            try {
                zzeeg zzeegVar = zzeeg.zzmyw;
                zzeed zzeedVar = (zzeed) obj;
                zza(zzeel.zzmzb, zzeegVar, zzeedVar);
                this.zzmyr = zzeegVar.zza(this.zzmyr, zzeedVar.zzmyr);
                return true;
            } catch (zzeeh e) {
                return false;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.zzmxn != 0) {
            return this.zzmxn;
        }
        zzeej zzeejVar = new zzeej();
        zza(zzeel.zzmzb, zzeejVar, this);
        this.zzmyr = zzeejVar.zza(this.zzmyr, this.zzmyr);
        this.zzmxn = zzeejVar.hashCode;
        return this.zzmxn;
    }

    public String toString() {
        return zzefb.zza(this, super.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.zzeey
    public final /* synthetic */ zzeez zzccn() {
        zzeee zzeeeVar = (zzeee) zza(zzeel.zzmzf, (Object) null, (Object) null);
        zzeeeVar.zza((zzeee) this);
        return zzeeeVar;
    }

    @Override // com.google.android.gms.internal.zzefa
    public final /* synthetic */ zzeey zzcco() {
        return (zzeed) zza(zzeel.zzmzg, (Object) null, (Object) null);
    }
}

package com.google.android.gms.internal;

import com.google.android.gms.internal.zzeec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
final class zzeea<FieldDescriptorType extends zzeec<FieldDescriptorType>> {
    private static final zzeea zzmyo = new zzeea(true);
    private boolean zzkeu;
    private boolean zzmyn = false;
    private final zzefe<FieldDescriptorType, Object> zzmym = zzefe.zzgv(16);

    private zzeea() {
    }

    private zzeea(boolean z) {
        if (this.zzkeu) {
            return;
        }
        this.zzmym.zzbhq();
        this.zzkeu = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    private void zza(FieldDescriptorType fielddescriptortype, Object obj) {
        ArrayList arrayList;
        if (!fielddescriptortype.zzccl()) {
            zza(fielddescriptortype.zzcck(), obj);
            arrayList = obj;
        } else if (!(obj instanceof List)) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        } else {
            arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(fielddescriptortype.zzcck(), obj2);
            }
        }
        if (arrayList instanceof zzeet) {
            this.zzmyn = true;
        }
        ((zzefe<FieldDescriptorType, Object>) this.zzmym).zza((zzefe) fielddescriptortype, (FieldDescriptorType) arrayList);
    }

    private static void zza(zzefz zzefzVar, Object obj) {
        boolean z = false;
        zzeen.zzu(obj);
        switch (zzeeb.zzmyp[zzefzVar.zzcdq().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                break;
            case 2:
                z = obj instanceof Long;
                break;
            case 3:
                z = obj instanceof Float;
                break;
            case 4:
                z = obj instanceof Double;
                break;
            case 5:
                z = obj instanceof Boolean;
                break;
            case 6:
                z = obj instanceof String;
                break;
            case 7:
                if ((obj instanceof zzedk) || (obj instanceof byte[])) {
                    z = true;
                    break;
                }
                break;
            case 8:
                if ((obj instanceof Integer) || (obj instanceof zzeeo)) {
                    z = true;
                    break;
                }
                break;
            case 9:
                if ((obj instanceof zzeey) || (obj instanceof zzeet)) {
                    z = true;
                    break;
                }
                break;
        }
        if (!z) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public static <T extends zzeec<T>> zzeea<T> zzccj() {
        return new zzeea<>();
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzeea zzeeaVar = new zzeea();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.zzmym.zzccz()) {
                break;
            }
            Map.Entry<FieldDescriptorType, Object> zzgw = this.zzmym.zzgw(i2);
            zzeeaVar.zza((zzeea) zzgw.getKey(), zzgw.getValue());
            i = i2 + 1;
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.zzmym.zzcda()) {
            zzeeaVar.zza((zzeea) entry.getKey(), entry.getValue());
        }
        zzeeaVar.zzmyn = this.zzmyn;
        return zzeeaVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzeea) {
            return this.zzmym.equals(((zzeea) obj).zzmym);
        }
        return false;
    }

    public final int hashCode() {
        return this.zzmym.hashCode();
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        return this.zzmyn ? new zzeew(this.zzmym.entrySet().iterator()) : this.zzmym.entrySet().iterator();
    }
}

package com.google.android.gms.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
/* loaded from: classes2.dex */
public final class zzcu extends zzct {
    private zzcu(Context context, String str, boolean z) {
        super(context, str, z);
    }

    public static zzcu zza(String str, Context context, boolean z) {
        zza(context, z);
        return new zzcu(context, str, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzct
    public final List<Callable<Void>> zzb(zzdc zzdcVar, zzax zzaxVar, zzau zzauVar) {
        if (zzdcVar.zzad() == null || !this.zzahl) {
            return super.zzb(zzdcVar, zzaxVar, zzauVar);
        }
        int zzz = zzdcVar.zzz();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.zzb(zzdcVar, zzaxVar, zzauVar));
        arrayList.add(new zzdq(zzdcVar, "o7w7nD7659+FI5Gilkma9hcgrpF/prpHxl2mnzxedqbbyjgIpTwyk4wm6GfrdKne", "jmFYtmBsx6R0EkdxirPelCZXWeKwTC3D/yN9KFqdR9U=", zzaxVar, zzz, 24));
        return arrayList;
    }
}

package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
@zzzt
/* loaded from: classes.dex */
public final class zzng {
    @Nullable
    private final zznh zzamn;
    private final Map<String, zznf> zzbqm = new HashMap();

    public zzng(@Nullable zznh zznhVar) {
        this.zzamn = zznhVar;
    }

    public final void zza(String str, zznf zznfVar) {
        this.zzbqm.put(str, zznfVar);
    }

    public final void zza(String str, String str2, long j) {
        zznh zznhVar = this.zzamn;
        zznf zznfVar = this.zzbqm.get(str2);
        String[] strArr = {str};
        if (zznhVar != null && zznfVar != null) {
            zznhVar.zza(zznfVar, j, strArr);
        }
        Map<String, zznf> map = this.zzbqm;
        zznh zznhVar2 = this.zzamn;
        map.put(str, zznhVar2 == null ? null : zznhVar2.zzc(j));
    }

    @Nullable
    public final zznh zzit() {
        return this.zzamn;
    }
}

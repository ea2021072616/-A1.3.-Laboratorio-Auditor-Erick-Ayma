package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
/* loaded from: classes.dex */
final class zzb implements DynamiteModule.zzd {
    @Override // com.google.android.gms.dynamite.DynamiteModule.zzd
    public final zzj zza(Context context, String str, zzi zziVar) throws DynamiteModule.zzc {
        zzj zzjVar = new zzj();
        zzjVar.zzgpq = zziVar.zzb(context, str, true);
        if (zzjVar.zzgpq != 0) {
            zzjVar.zzgpr = 1;
        } else {
            zzjVar.zzgpp = zziVar.zzae(context, str);
            if (zzjVar.zzgpp != 0) {
                zzjVar.zzgpr = -1;
            }
        }
        return zzjVar;
    }
}

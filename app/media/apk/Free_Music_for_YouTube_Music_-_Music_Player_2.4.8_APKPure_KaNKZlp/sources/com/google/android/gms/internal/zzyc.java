package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
@zzzt
/* loaded from: classes.dex */
public final class zzyc {
    public static zzahv zza(Context context, com.google.android.gms.ads.internal.zza zzaVar, zzafj zzafjVar, zzcv zzcvVar, @Nullable zzakk zzakkVar, zzva zzvaVar, zzyd zzydVar, zznh zznhVar) {
        zzahv zzykVar;
        zzaao zzaaoVar = zzafjVar.zzcyp;
        if (zzaaoVar.zzcpo) {
            zzykVar = new zzyi(context, zzafjVar, zzvaVar, zzydVar, zznhVar, zzakkVar);
        } else if (zzaaoVar.zzbct || (zzaVar instanceof com.google.android.gms.ads.internal.zzbc)) {
            zzykVar = (zzaaoVar.zzbct && (zzaVar instanceof com.google.android.gms.ads.internal.zzbc)) ? new zzyk(context, (com.google.android.gms.ads.internal.zzbc) zzaVar, zzafjVar, zzcvVar, zzydVar, zznhVar) : new zzyf(zzafjVar, zzydVar);
        } else {
            zzykVar = (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbin)).booleanValue() && com.google.android.gms.common.util.zzp.zzalh() && !com.google.android.gms.common.util.zzp.zzalj() && zzakkVar != null && zzakkVar.zzbl().zzbcr) ? new zzyh(context, zzafjVar, zzakkVar, zzydVar) : new zzye(context, zzafjVar, zzakkVar, zzydVar);
        }
        String valueOf = String.valueOf(zzykVar.getClass().getName());
        zzafx.zzcb(valueOf.length() != 0 ? "AdRenderer: ".concat(valueOf) : new String("AdRenderer: "));
        zzykVar.zzns();
        return zzykVar;
    }
}

package com.google.android.gms.internal;

import android.content.Context;
import java.util.Map;
import org.json.JSONException;
/* loaded from: classes.dex */
final class zzacn implements zzrn {
    private /* synthetic */ Context zzaok;
    private /* synthetic */ com.google.android.gms.ads.internal.js.zzy zzcvi;
    private /* synthetic */ zzacm zzcvj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzacn(zzacm zzacmVar, Context context, com.google.android.gms.ads.internal.js.zzy zzyVar) {
        this.zzcvj = zzacmVar;
        this.zzaok = context;
        this.zzcvi = zzyVar;
    }

    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        try {
            zzmu.zza(this.zzaok, 1, com.google.android.gms.ads.internal.zzbv.zzea().zzk(map));
            this.zzcvj.zzoq();
        } catch (JSONException e) {
            zzafx.zzb("Unable to save SDK Core Constants.", e);
        } finally {
            zzakkVar.zzsb().zzb("/loadSdkConstants", this);
            this.zzcvi.release();
        }
    }
}

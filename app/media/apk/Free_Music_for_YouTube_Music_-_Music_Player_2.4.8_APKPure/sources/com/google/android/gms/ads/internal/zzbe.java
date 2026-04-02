package com.google.android.gms.ads.internal;

import android.os.Bundle;
import com.google.android.gms.internal.zzaak;
import com.google.android.gms.internal.zzaal;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzajn;
import com.google.android.gms.internal.zzix;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zzog;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
final class zzbe implements Callable<zzog> {
    private /* synthetic */ zzafj zzamz;
    private /* synthetic */ zzbc zzara;
    private /* synthetic */ int zzarb;
    private /* synthetic */ JSONArray zzarc;
    private /* synthetic */ int zzard;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbe(zzbc zzbcVar, int i, JSONArray jSONArray, int i2, zzafj zzafjVar) {
        this.zzara = zzbcVar;
        this.zzarb = i;
        this.zzarc = jSONArray;
        this.zzard = i2;
        this.zzamz = zzafjVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzog call() throws Exception {
        if (this.zzarb >= this.zzarc.length()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(this.zzarc.get(this.zzarb));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ads", jSONArray);
        zzbc zzbcVar = new zzbc(this.zzara.zzams.zzaie, this.zzara.zzamv, this.zzara.zzams.zzatn, this.zzara.zzams.zzath, this.zzara.zzana, this.zzara.zzams.zzatj, true);
        zzbc zzbcVar2 = this.zzara;
        zzbc.zza(this.zzara.zzams, zzbcVar.zzams);
        zzbcVar.zzdh();
        zzbcVar.zza(this.zzara.zzamo);
        zznh zznhVar = zzbcVar.zzamn;
        int i = this.zzarb;
        zznhVar.zzh("num_ads_requested", String.valueOf(this.zzard));
        zznhVar.zzh("ad_index", String.valueOf(i));
        zzaak zzaakVar = this.zzamz.zzcrj;
        String jSONObject2 = jSONObject.toString();
        Bundle bundle = zzaakVar.zzcnw.extras != null ? new Bundle(zzaakVar.zzcnw.extras) : new Bundle();
        bundle.putString("_ad", jSONObject2);
        zzbcVar.zza(new zzaal(zzaakVar.zzcnv, new zzix(zzaakVar.zzcnw.versionCode, zzaakVar.zzcnw.zzbbl, bundle, zzaakVar.zzcnw.zzbbm, zzaakVar.zzcnw.zzbbn, zzaakVar.zzcnw.zzbbo, zzaakVar.zzcnw.zzbbp, zzaakVar.zzcnw.zzbbq, zzaakVar.zzcnw.zzbbr, zzaakVar.zzcnw.zzbbs, zzaakVar.zzcnw.zzbbt, zzaakVar.zzcnw.zzbbu, zzaakVar.zzcnw.zzbbv, zzaakVar.zzcnw.zzbbw, zzaakVar.zzcnw.zzbbx, zzaakVar.zzcnw.zzbby, zzaakVar.zzcnw.zzbbz, zzaakVar.zzcnw.zzbca), zzaakVar.zzatn, zzaakVar.zzath, zzaakVar.applicationInfo, zzaakVar.zzcnx, zzaakVar.zzcnz, zzaakVar.zzcoa, zzaakVar.zzatj, zzaakVar.zzcob, zzaakVar.zzaug, zzaakVar.zzcol, zzaakVar.zzcod, zzaakVar.zzcoe, zzaakVar.zzcof, zzaakVar.zzcog, zzaakVar.zzaxh, zzaakVar.zzcoh, zzaakVar.zzcoi, zzaakVar.zzcoj, zzaakVar.zzcok, zzaakVar.zzatg, zzaakVar.zzatz, zzaakVar.zzcon, zzaakVar.zzcoo, zzaakVar.zzcou, zzaakVar.zzcop, zzaakVar.zzcoq, zzaakVar.zzcor, zzaakVar.zzcos, zzajn.zzg(zzaakVar.zzcot), zzaakVar.zzcov, zzaakVar.zzcay, zzaakVar.zzcow, zzaakVar.zzcox, zzaakVar.zzcoy, zzaakVar.zzaub, zzaakVar.zzcoz, zzaakVar.zzcpa, zzaakVar.zzcpe, zzajn.zzg(zzaakVar.zzcny), zzaakVar.zzaud, zzaakVar.zzcpf, zzaakVar.zzcpg, 1, zzaakVar.zzcpi, zzaakVar.zzcpj), zzbcVar.zzamn);
        return zzbcVar.zzdj().get();
    }
}

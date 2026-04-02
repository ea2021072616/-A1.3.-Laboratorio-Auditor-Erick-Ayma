package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzzm implements zzzb<zzny> {
    private final boolean zzcnb;
    private final boolean zzcnc;

    public zzzm(boolean z, boolean z2) {
        this.zzcnb = z;
        this.zzcnc = z2;
    }

    @Override // com.google.android.gms.internal.zzzb
    public final /* synthetic */ zzny zza(zzys zzysVar, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        View view;
        List<zzajr<zznv>> zza = zzysVar.zza(jSONObject, "images", false, this.zzcnb, this.zzcnc);
        zzajr<zznv> zza2 = zzysVar.zza(jSONObject, "secondary_image", false, this.zzcnb);
        zzajr<zznt> zzd = zzysVar.zzd(jSONObject);
        zzajr<zzakk> zzc = zzysVar.zzc(jSONObject, "video");
        ArrayList arrayList = new ArrayList();
        for (zzajr<zznv> zzajrVar : zza) {
            arrayList.add(zzajrVar.get());
        }
        zzakk zzb = zzys.zzb(zzc);
        String string = jSONObject.getString("headline");
        String string2 = jSONObject.getString(TtmlNode.TAG_BODY);
        zznv zznvVar = zza2.get();
        String string3 = jSONObject.getString("call_to_action");
        String string4 = jSONObject.getString("advertiser");
        zznt zzntVar = zzd.get();
        Bundle bundle = new Bundle();
        zzalc zzsm = zzb != null ? zzb.zzsm() : null;
        if (zzb == null) {
            view = null;
        } else if (zzb == null) {
            throw null;
        } else {
            view = (View) zzb;
        }
        return new zzny(string, arrayList, string2, zznvVar, string3, string4, zzntVar, bundle, zzsm, view);
    }
}

package com.google.android.gms.internal;

import android.support.v4.util.SimpleArrayMap;
import android.view.View;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzzn implements zzzb<zzoa> {
    private final boolean zzcnb;

    public zzzn(boolean z) {
        this.zzcnb = z;
    }

    private static <K, V> SimpleArrayMap<K, V> zza(SimpleArrayMap<K, Future<V>> simpleArrayMap) throws InterruptedException, ExecutionException {
        SimpleArrayMap<K, V> simpleArrayMap2 = new SimpleArrayMap<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= simpleArrayMap.size()) {
                return simpleArrayMap2;
            }
            simpleArrayMap2.put(simpleArrayMap.keyAt(i2), simpleArrayMap.valueAt(i2).get());
            i = i2 + 1;
        }
    }

    @Override // com.google.android.gms.internal.zzzb
    public final /* synthetic */ zzoa zza(zzys zzysVar, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        View view;
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
        SimpleArrayMap simpleArrayMap2 = new SimpleArrayMap();
        zzajr<zznt> zzd = zzysVar.zzd(jSONObject);
        zzajr<zzakk> zzc = zzysVar.zzc(jSONObject, "video");
        JSONArray jSONArray = jSONObject.getJSONArray("custom_assets");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String string = jSONObject2.getString("type");
            if ("string".equals(string)) {
                simpleArrayMap2.put(jSONObject2.getString("name"), jSONObject2.getString("string_value"));
            } else if (MessengerShareContentUtility.MEDIA_IMAGE.equals(string)) {
                simpleArrayMap.put(jSONObject2.getString("name"), zzysVar.zza(jSONObject2, "image_value", this.zzcnb));
            } else {
                String valueOf = String.valueOf(string);
                zzafx.zzcs(valueOf.length() != 0 ? "Unknown custom asset type: ".concat(valueOf) : new String("Unknown custom asset type: "));
            }
        }
        zzakk zzb = zzys.zzb(zzc);
        String string2 = jSONObject.getString("custom_template_id");
        SimpleArrayMap zza = zza(simpleArrayMap);
        zznt zzntVar = zzd.get();
        zzalc zzsm = zzb != null ? zzb.zzsm() : null;
        if (zzb == null) {
            view = null;
        } else if (zzb == null) {
            throw null;
        } else {
            view = (View) zzb;
        }
        return new zzoa(string2, zza, simpleArrayMap2, zzntVar, zzsm, view);
    }
}

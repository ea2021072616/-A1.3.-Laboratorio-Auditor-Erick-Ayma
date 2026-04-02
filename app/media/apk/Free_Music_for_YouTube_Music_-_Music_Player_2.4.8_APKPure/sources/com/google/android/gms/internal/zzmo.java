package com.google.android.gms.internal;

import android.content.SharedPreferences;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzmo extends zzmk<Float> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmo(int i, String str, Float f) {
        super(i, str, f, null);
    }

    @Override // com.google.android.gms.internal.zzmk
    public final /* synthetic */ Float zza(SharedPreferences sharedPreferences) {
        return Float.valueOf(sharedPreferences.getFloat(getKey(), zzik().floatValue()));
    }

    @Override // com.google.android.gms.internal.zzmk
    public final /* synthetic */ void zza(SharedPreferences.Editor editor, Float f) {
        editor.putFloat(getKey(), f.floatValue());
    }

    @Override // com.google.android.gms.internal.zzmk
    public final /* synthetic */ Float zzb(JSONObject jSONObject) {
        return Float.valueOf((float) jSONObject.optDouble(getKey(), zzik().floatValue()));
    }
}

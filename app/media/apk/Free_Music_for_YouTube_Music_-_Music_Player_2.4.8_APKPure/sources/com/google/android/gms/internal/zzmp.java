package com.google.android.gms.internal;

import android.content.SharedPreferences;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzmp extends zzmk<String> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmp(int i, String str, String str2) {
        super(i, str, str2, null);
    }

    @Override // com.google.android.gms.internal.zzmk
    public final /* synthetic */ String zza(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(getKey(), zzik());
    }

    @Override // com.google.android.gms.internal.zzmk
    public final /* synthetic */ void zza(SharedPreferences.Editor editor, String str) {
        editor.putString(getKey(), str);
    }

    @Override // com.google.android.gms.internal.zzmk
    public final /* synthetic */ String zzb(JSONObject jSONObject) {
        return jSONObject.optString(getKey(), zzik());
    }
}

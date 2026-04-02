package com.google.android.gms.internal;

import android.content.SharedPreferences;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzml extends zzmk<Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzml(int i, String str, Boolean bool) {
        super(i, str, bool, null);
    }

    @Override // com.google.android.gms.internal.zzmk
    public final /* synthetic */ Boolean zza(SharedPreferences sharedPreferences) {
        return Boolean.valueOf(sharedPreferences.getBoolean(getKey(), zzik().booleanValue()));
    }

    @Override // com.google.android.gms.internal.zzmk
    public final /* synthetic */ void zza(SharedPreferences.Editor editor, Boolean bool) {
        editor.putBoolean(getKey(), bool.booleanValue());
    }

    @Override // com.google.android.gms.internal.zzmk
    public final /* synthetic */ Boolean zzb(JSONObject jSONObject) {
        return Boolean.valueOf(jSONObject.optBoolean(getKey(), zzik().booleanValue()));
    }
}

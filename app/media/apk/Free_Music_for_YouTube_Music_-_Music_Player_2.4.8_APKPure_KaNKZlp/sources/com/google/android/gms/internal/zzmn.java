package com.google.android.gms.internal;

import android.content.SharedPreferences;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzmn extends zzmk<Long> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmn(int i, String str, Long l) {
        super(i, str, l, null);
    }

    @Override // com.google.android.gms.internal.zzmk
    public final /* synthetic */ Long zza(SharedPreferences sharedPreferences) {
        return Long.valueOf(sharedPreferences.getLong(getKey(), zzik().longValue()));
    }

    @Override // com.google.android.gms.internal.zzmk
    public final /* synthetic */ void zza(SharedPreferences.Editor editor, Long l) {
        editor.putLong(getKey(), l.longValue());
    }

    @Override // com.google.android.gms.internal.zzmk
    public final /* synthetic */ Long zzb(JSONObject jSONObject) {
        return Long.valueOf(jSONObject.optLong(getKey(), zzik().longValue()));
    }
}

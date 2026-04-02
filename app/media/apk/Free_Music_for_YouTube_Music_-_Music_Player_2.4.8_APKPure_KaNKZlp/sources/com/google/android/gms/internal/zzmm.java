package com.google.android.gms.internal;

import android.content.SharedPreferences;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzmm extends zzmk<Integer> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmm(int i, String str, Integer num) {
        super(i, str, num, null);
    }

    @Override // com.google.android.gms.internal.zzmk
    public final /* synthetic */ Integer zza(SharedPreferences sharedPreferences) {
        return Integer.valueOf(sharedPreferences.getInt(getKey(), zzik().intValue()));
    }

    @Override // com.google.android.gms.internal.zzmk
    public final /* synthetic */ void zza(SharedPreferences.Editor editor, Integer num) {
        editor.putInt(getKey(), num.intValue());
    }

    @Override // com.google.android.gms.internal.zzmk
    public final /* synthetic */ Integer zzb(JSONObject jSONObject) {
        return Integer.valueOf(jSONObject.optInt(getKey(), zzik().intValue()));
    }
}

package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzsc implements zzrn {
    private final Object mLock = new Object();
    private final Map<String, zzsd> zzbwa = new HashMap();

    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        String str = map.get("id");
        String str2 = map.get("fail");
        map.get("fail_reason");
        String str3 = map.get("result");
        synchronized (this.mLock) {
            if (this.zzbwa.remove(str) == null) {
                String valueOf = String.valueOf(str);
                zzafx.zzcs(valueOf.length() != 0 ? "Received result for unexpected method invocation: ".concat(valueOf) : new String("Received result for unexpected method invocation: "));
            } else if (TextUtils.isEmpty(str2)) {
                if (str3 == null) {
                    return;
                }
                try {
                    new JSONObject(str3);
                } catch (JSONException e) {
                    e.getMessage();
                }
            }
        }
    }
}

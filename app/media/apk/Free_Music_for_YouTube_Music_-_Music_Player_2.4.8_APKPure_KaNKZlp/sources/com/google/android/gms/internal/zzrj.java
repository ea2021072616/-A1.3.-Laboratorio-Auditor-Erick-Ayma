package com.google.android.gms.internal;

import com.facebook.appevents.AppEventsConstants;
import java.util.Map;
/* loaded from: classes2.dex */
final class zzrj implements zzrn {
    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        zzakkVar.zzac(AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("custom_close")));
    }
}

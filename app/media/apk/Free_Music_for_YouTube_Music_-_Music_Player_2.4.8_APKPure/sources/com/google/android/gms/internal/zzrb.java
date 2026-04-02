package com.google.android.gms.internal;

import com.facebook.internal.NativeProtocol;
import java.util.Map;
/* loaded from: classes2.dex */
final class zzrb implements zzrn {
    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        String str = map.get(NativeProtocol.WEB_DIALOG_ACTION);
        if ("pause".equals(str)) {
            zzakkVar.zzci();
        } else if ("resume".equals(str)) {
            zzakkVar.zzcj();
        }
    }
}

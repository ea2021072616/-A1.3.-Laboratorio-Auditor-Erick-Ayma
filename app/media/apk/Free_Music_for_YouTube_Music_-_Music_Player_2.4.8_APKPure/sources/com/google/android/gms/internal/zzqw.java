package com.google.android.gms.internal;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import java.util.Map;
@zzzt
/* loaded from: classes.dex */
public final class zzqw implements zzrn {
    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        String str = map.get(NativeProtocol.WEB_DIALOG_ACTION);
        if ("tick".equals(str)) {
            String str2 = map.get("label");
            String str3 = map.get("start_label");
            String str4 = map.get("timestamp");
            if (TextUtils.isEmpty(str2)) {
                zzafx.zzcs("No label given for CSI tick.");
            } else if (TextUtils.isEmpty(str4)) {
                zzafx.zzcs("No timestamp given for CSI tick.");
            } else {
                try {
                    long parseLong = (Long.parseLong(str4) - com.google.android.gms.ads.internal.zzbv.zzeg().currentTimeMillis()) + com.google.android.gms.ads.internal.zzbv.zzeg().elapsedRealtime();
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "native:view_load";
                    }
                    zzakkVar.zzsl().zza(str2, str3, parseLong);
                } catch (NumberFormatException e) {
                    zzafx.zzc("Malformed timestamp for CSI tick.", e);
                }
            }
        } else if ("experiment".equals(str)) {
            String str5 = map.get("value");
            if (TextUtils.isEmpty(str5)) {
                zzafx.zzcs("No value given for CSI experiment.");
                return;
            }
            zznh zzit = zzakkVar.zzsl().zzit();
            if (zzit == null) {
                zzafx.zzcs("No ticker for WebView, dropping experiment ID.");
            } else {
                zzit.zzh("e", str5);
            }
        } else if ("extra".equals(str)) {
            String str6 = map.get("name");
            String str7 = map.get("value");
            if (TextUtils.isEmpty(str7)) {
                zzafx.zzcs("No value given for CSI extra.");
            } else if (TextUtils.isEmpty(str6)) {
                zzafx.zzcs("No name given for CSI extra.");
            } else {
                zznh zzit2 = zzakkVar.zzsl().zzit();
                if (zzit2 == null) {
                    zzafx.zzcs("No ticker for WebView, dropping extra parameter.");
                } else {
                    zzit2.zzh(str6, str7);
                }
            }
        }
    }
}

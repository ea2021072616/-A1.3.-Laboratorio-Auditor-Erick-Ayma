package com.google.android.gms.internal;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import java.util.Map;
@zzzt
/* loaded from: classes.dex */
public final class zzse implements zzrn {
    private final zzsf zzbwb;

    public zzse(zzsf zzsfVar) {
        this.zzbwb = zzsfVar;
    }

    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        zzaek zzaekVar;
        int parseInt;
        String str;
        String str2 = map.get(NativeProtocol.WEB_DIALOG_ACTION);
        if (!"grant".equals(str2)) {
            if ("video_start".equals(str2)) {
                this.zzbwb.zzdb();
                return;
            }
            return;
        }
        try {
            parseInt = Integer.parseInt(map.get("amount"));
            str = map.get("type");
        } catch (NumberFormatException e) {
            zzafx.zzc("Unable to parse reward amount.", e);
        }
        if (!TextUtils.isEmpty(str)) {
            zzaekVar = new zzaek(str, parseInt);
            this.zzbwb.zzb(zzaekVar);
        }
        zzaekVar = null;
        this.zzbwb.zzb(zzaekVar);
    }
}

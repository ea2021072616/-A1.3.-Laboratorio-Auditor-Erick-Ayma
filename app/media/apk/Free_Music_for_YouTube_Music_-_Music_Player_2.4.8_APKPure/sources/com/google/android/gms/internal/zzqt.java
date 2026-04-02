package com.google.android.gms.internal;

import java.util.Map;
@zzzt
/* loaded from: classes.dex */
public final class zzqt implements zzrn {
    private final zzqu zzbul;

    public zzqt(zzqu zzquVar) {
        this.zzbul = zzquVar;
    }

    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        String str = map.get("name");
        if (str == null) {
            zzafx.zzcs("App event with no name parameter.");
        } else {
            this.zzbul.onAppEvent(str, map.get("info"));
        }
    }
}

package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.Map;
/* loaded from: classes.dex */
final class zzakz implements zzrn {
    private /* synthetic */ zzaky zzdhr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzakz(zzaky zzakyVar) {
        this.zzdhr = zzakyVar;
    }

    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        Object obj;
        int i;
        if (map != null) {
            String str = map.get("height");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                int parseInt = Integer.parseInt(str);
                obj = this.zzdhr.mLock;
                synchronized (obj) {
                    i = this.zzdhr.zzdhi;
                    if (i != parseInt) {
                        this.zzdhr.zzdhi = parseInt;
                        this.zzdhr.requestLayout();
                    }
                }
            } catch (Exception e) {
                zzafx.zzc("Exception occurred while getting webview content height", e);
            }
        }
    }
}

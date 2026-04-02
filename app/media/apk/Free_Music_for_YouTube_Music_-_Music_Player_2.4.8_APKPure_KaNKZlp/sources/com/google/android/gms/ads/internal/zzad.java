package com.google.android.gms.ads.internal;

import android.content.Context;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.internal.zzafn;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzakk;
import com.google.android.gms.internal.zzrn;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzad implements zzrn {
    private /* synthetic */ Runnable zzaod;
    private /* synthetic */ zzac zzaoe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzad(zzac zzacVar, Runnable runnable) {
        this.zzaoe = zzacVar;
        this.zzaod = runnable;
    }

    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        Object obj;
        Context context;
        zzakkVar.zzb("/appSettingsFetched", this);
        obj = this.zzaoe.mLock;
        synchronized (obj) {
            if (map != null) {
                if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(map.get("isSuccessful"))) {
                    zzafn zzee = zzbv.zzee();
                    context = this.zzaoe.mContext;
                    zzee.zzn(context, map.get("appSettingsJson"));
                    try {
                        if (this.zzaod != null) {
                            this.zzaod.run();
                        }
                    } catch (Exception e) {
                        zzbv.zzee().zza(e, "ConfigLoader.maybeFetchNewAppSettings");
                        zzafx.zzc("ConfigLoader post task failed.", e);
                    }
                }
            }
        }
    }
}

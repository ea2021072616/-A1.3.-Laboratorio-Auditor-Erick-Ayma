package com.google.android.gms.internal;

import java.util.List;
/* loaded from: classes2.dex */
final class zzhb implements Runnable {
    private /* synthetic */ zzha zzaym;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhb(zzha zzhaVar) {
        this.zzaym = zzhaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        boolean z;
        boolean z2;
        List<zzhc> list;
        obj = this.zzaym.mLock;
        synchronized (obj) {
            z = this.zzaym.zzayg;
            if (z) {
                z2 = this.zzaym.zzayh;
                if (z2) {
                    zzha.zza(this.zzaym, false);
                    zzafx.zzcb("App went background");
                    list = this.zzaym.zzayi;
                    for (zzhc zzhcVar : list) {
                        try {
                            zzhcVar.zzg(false);
                        } catch (Exception e) {
                            zzafx.zzb("OnForegroundStateChangedListener threw exception.", e);
                        }
                    }
                }
            }
            zzafx.zzcb("App is still foreground");
        }
    }
}

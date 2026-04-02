package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzacy;
import com.google.android.gms.internal.zzaef;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzuk;
import com.google.android.gms.internal.zzul;
import com.google.android.gms.internal.zzvd;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
final class zzba implements Runnable {
    private /* synthetic */ zzaz zzaqu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzba(zzaz zzazVar) {
        this.zzaqu = zzazVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        context = this.zzaqu.zzaqt.mContext;
        Runnable runnable = this.zzaqu.zzaqs;
        com.google.android.gms.common.internal.zzbp.zzfx("Adapters must be initialized on the main thread.");
        Map<String, zzul> zzpo = zzbv.zzee().zzqh().zzpo();
        if (zzpo == null || zzpo.isEmpty()) {
            return;
        }
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable th) {
                zzafx.zzc("Could not initialize rewarded ads.", th);
                return;
            }
        }
        zzacy zzor = zzacy.zzor();
        if (zzor != null) {
            Collection<zzul> values = zzpo.values();
            HashMap hashMap = new HashMap();
            IObjectWrapper zzw = com.google.android.gms.dynamic.zzn.zzw(context);
            for (zzul zzulVar : values) {
                for (zzuk zzukVar : zzulVar.zzcas) {
                    String str = zzukVar.zzcaj;
                    for (String str2 : zzukVar.zzcac) {
                        if (!hashMap.containsKey(str2)) {
                            hashMap.put(str2, new ArrayList());
                        }
                        if (str != null) {
                            ((Collection) hashMap.get(str2)).add(str);
                        }
                    }
                }
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                String str3 = (String) entry.getKey();
                try {
                    zzaef zzbu = zzor.zzbu(str3);
                    if (zzbu != null) {
                        zzvd zzoz = zzbu.zzoz();
                        if (!zzoz.isInitialized() && zzoz.zzlw()) {
                            zzoz.zza(zzw, zzbu.zzpa(), (List) entry.getValue());
                            String valueOf = String.valueOf(str3);
                            zzafx.zzcb(valueOf.length() != 0 ? "Initialized rewarded video mediation adapter ".concat(valueOf) : new String("Initialized rewarded video mediation adapter "));
                        }
                    }
                } catch (Throwable th2) {
                    zzafx.zzc(new StringBuilder(String.valueOf(str3).length() + 56).append("Failed to initialize rewarded video mediation adapter \"").append(str3).append("\"").toString(), th2);
                }
            }
        }
    }
}

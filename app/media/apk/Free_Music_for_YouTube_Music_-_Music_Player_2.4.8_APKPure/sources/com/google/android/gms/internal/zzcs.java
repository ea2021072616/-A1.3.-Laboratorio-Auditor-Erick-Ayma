package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
/* loaded from: classes2.dex */
public class zzcs extends zzct {
    private static final String TAG = zzcs.class.getSimpleName();
    private AdvertisingIdClient.Info zzahj;

    private zzcs(Context context) {
        super(context, "");
    }

    public static String zza(String str, String str2) {
        return zzbv.zza(str, str2, true);
    }

    public static zzcs zzb(Context context) {
        zza(context, true);
        return new zzcs(context);
    }

    @Override // com.google.android.gms.internal.zzct, com.google.android.gms.internal.zzcr
    protected final zzax zza(Context context, View view) {
        return null;
    }

    public final void zza(AdvertisingIdClient.Info info) {
        this.zzahj = info;
    }

    @Override // com.google.android.gms.internal.zzct
    protected final void zza(zzdc zzdcVar, zzax zzaxVar, zzau zzauVar) {
        if (!zzdcVar.zzaip) {
            zza(zzb(zzdcVar, zzaxVar, zzauVar));
        } else if (this.zzahj != null) {
            String id = this.zzahj.getId();
            if (!TextUtils.isEmpty(id)) {
                zzaxVar.zzeu = zzdh.zzn(id);
                zzaxVar.zzev = 5;
                zzaxVar.zzew = Boolean.valueOf(this.zzahj.isLimitAdTrackingEnabled());
            }
            this.zzahj = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzct
    public final List<Callable<Void>> zzb(zzdc zzdcVar, zzax zzaxVar, zzau zzauVar) {
        ArrayList arrayList = new ArrayList();
        if (zzdcVar.zzad() == null) {
            return arrayList;
        }
        arrayList.add(new zzdq(zzdcVar, "o7w7nD7659+FI5Gilkma9hcgrpF/prpHxl2mnzxedqbbyjgIpTwyk4wm6GfrdKne", "jmFYtmBsx6R0EkdxirPelCZXWeKwTC3D/yN9KFqdR9U=", zzaxVar, zzdcVar.zzz(), 24));
        return arrayList;
    }
}

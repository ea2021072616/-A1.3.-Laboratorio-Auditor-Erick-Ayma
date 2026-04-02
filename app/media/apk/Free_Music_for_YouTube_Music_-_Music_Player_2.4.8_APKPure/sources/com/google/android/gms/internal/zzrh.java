package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import java.util.Map;
/* loaded from: classes2.dex */
final class zzrh implements zzrn {
    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        Uri uri;
        String str = map.get("u");
        if (str == null) {
            zzafx.zzcs("URL missing from click GMSG.");
            return;
        }
        Uri parse = Uri.parse(str);
        try {
            zzcv zzsd = zzakkVar.zzsd();
            if (zzsd == null || !zzsd.zzc(parse)) {
                uri = parse;
            } else {
                Context context = zzakkVar.getContext();
                if (zzakkVar == null) {
                    throw null;
                }
                uri = zzsd.zza(parse, context, (View) zzakkVar);
            }
            parse = uri;
        } catch (zzcw e) {
            String valueOf = String.valueOf(str);
            zzafx.zzcs(valueOf.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf) : new String("Unable to append parameter to URL: "));
        }
        if ((((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbja)).booleanValue() && com.google.android.gms.ads.internal.zzbv.zzez().zzr(zzakkVar.getContext())) && TextUtils.isEmpty(parse.getQueryParameter("fbs_aeid"))) {
            String zzz = com.google.android.gms.ads.internal.zzbv.zzez().zzz(zzakkVar.getContext());
            com.google.android.gms.ads.internal.zzbv.zzea();
            parse = zzahf.zzb(parse.toString(), "fbs_aeid", zzz);
            com.google.android.gms.ads.internal.zzbv.zzez().zzf(zzakkVar.getContext(), zzz);
        }
        new zzaiw(zzakkVar.getContext(), zzakkVar.zzse().zzcp, parse.toString()).zzqq();
    }
}

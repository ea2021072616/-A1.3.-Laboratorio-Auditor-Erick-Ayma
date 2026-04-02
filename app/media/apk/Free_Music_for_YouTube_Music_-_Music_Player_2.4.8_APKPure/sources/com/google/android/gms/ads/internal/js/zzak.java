package com.google.android.gms.ads.internal.js;

import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzzt;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzak implements zzaj {
    private final zzai zzbzu;
    private final HashSet<AbstractMap.SimpleEntry<String, zzrn>> zzbzv = new HashSet<>();

    public zzak(zzai zzaiVar) {
        this.zzbzu = zzaiVar;
    }

    @Override // com.google.android.gms.ads.internal.js.zzai
    public final void zza(String str, zzrn zzrnVar) {
        this.zzbzu.zza(str, zzrnVar);
        this.zzbzv.add(new AbstractMap.SimpleEntry<>(str, zzrnVar));
    }

    @Override // com.google.android.gms.ads.internal.js.zzai
    public final void zza(String str, JSONObject jSONObject) {
        this.zzbzu.zza(str, jSONObject);
    }

    @Override // com.google.android.gms.ads.internal.js.zzai
    public final void zzb(String str, zzrn zzrnVar) {
        this.zzbzu.zzb(str, zzrnVar);
        this.zzbzv.remove(new AbstractMap.SimpleEntry(str, zzrnVar));
    }

    @Override // com.google.android.gms.ads.internal.js.zzai
    public final void zzb(String str, JSONObject jSONObject) {
        this.zzbzu.zzb(str, jSONObject);
    }

    @Override // com.google.android.gms.ads.internal.js.zzai
    public final void zzi(String str, String str2) {
        this.zzbzu.zzi(str, str2);
    }

    @Override // com.google.android.gms.ads.internal.js.zzaj
    public final void zzlg() {
        Iterator<AbstractMap.SimpleEntry<String, zzrn>> it = this.zzbzv.iterator();
        while (it.hasNext()) {
            AbstractMap.SimpleEntry<String, zzrn> next = it.next();
            String valueOf = String.valueOf(next.getValue().toString());
            zzafx.v(valueOf.length() != 0 ? "Unregistering eventhandler: ".concat(valueOf) : new String("Unregistering eventhandler: "));
            this.zzbzu.zzb(next.getKey(), next.getValue());
        }
        this.zzbzv.clear();
    }
}

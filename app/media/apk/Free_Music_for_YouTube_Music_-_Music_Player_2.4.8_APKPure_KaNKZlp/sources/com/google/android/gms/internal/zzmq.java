package com.google.android.gms.internal;

import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzmq {
    private final Collection<zzmk> zzbfn = new ArrayList();
    private final Collection<zzmk<String>> zzbfo = new ArrayList();
    private final Collection<zzmk<String>> zzbfp = new ArrayList();

    public final void zza(SharedPreferences.Editor editor, int i, JSONObject jSONObject) {
        for (zzmk zzmkVar : this.zzbfn) {
            if (zzmkVar.getSource() == 1) {
                zzmkVar.zza(editor, (SharedPreferences.Editor) zzmkVar.zzb(jSONObject));
            }
        }
    }

    public final void zza(zzmk zzmkVar) {
        this.zzbfn.add(zzmkVar);
    }

    public final void zzb(zzmk<String> zzmkVar) {
        this.zzbfo.add(zzmkVar);
    }

    public final void zzc(zzmk<String> zzmkVar) {
        this.zzbfp.add(zzmkVar);
    }

    public final List<String> zzil() {
        ArrayList arrayList = new ArrayList();
        for (zzmk<String> zzmkVar : this.zzbfo) {
            String str = (String) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmkVar);
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public final List<String> zzim() {
        List<String> zzil = zzil();
        for (zzmk<String> zzmkVar : this.zzbfp) {
            String str = (String) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmkVar);
            if (str != null) {
                zzil.add(str);
            }
        }
        return zzil;
    }
}

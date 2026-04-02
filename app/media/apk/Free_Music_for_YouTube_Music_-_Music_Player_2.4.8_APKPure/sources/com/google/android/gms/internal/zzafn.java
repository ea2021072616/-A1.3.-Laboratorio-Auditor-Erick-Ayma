package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.security.NetworkSecurityPolicy;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzafn implements zzagy, zzhc {
    private Context mContext;
    private zzfl zzamu;
    private zzajk zzapc;
    private String zzbwh;
    private String zzczp;
    private String zzczq;
    private final Object mLock = new Object();
    private BigInteger zzczi = BigInteger.ONE;
    private final HashSet<zzafk> zzczj = new HashSet<>();
    private final HashMap<String, zzaft> zzczk = new HashMap<>();
    private boolean zzczl = false;
    private boolean zzctf = true;
    private int zzczm = 0;
    private boolean zzaqo = false;
    private zzmx zzczn = null;
    private boolean zzctg = true;
    private boolean zzcth = true;
    private zzhd zzczo = null;
    private zzgy zzayo = null;
    private Boolean zzczr = null;
    private boolean zzczs = false;
    private boolean zzczt = false;
    private boolean zzcto = false;
    private String zzczu = "";
    private long zzczv = 0;
    private long zzczw = 0;
    private long zzczx = 0;
    private int zzczy = -1;
    private JSONObject zzczz = new JSONObject();
    private int zzdaa = 0;
    private final AtomicInteger zzdab = new AtomicInteger(0);
    private final zzafp zzdac = new zzafp();
    private final String mSessionId = zzahf.zzqu();
    private final zzafr zzczh = new zzafr(this.mSessionId);

    public zzafn(zzahf zzahfVar) {
    }

    private final Future zzac(int i) {
        Future zzb;
        synchronized (this.mLock) {
            this.zzczy = i;
            zzb = zzafz.zzb(this.mContext, i);
        }
        return zzb;
    }

    private final Future zzj(long j) {
        Future zza;
        synchronized (this.mLock) {
            this.zzczw = j;
            zza = zzafz.zza(this.mContext, j);
        }
        return zza;
    }

    public final Resources getResources() {
        if (this.zzapc.zzden) {
            return this.mContext.getResources();
        }
        try {
            DynamiteModule zza = DynamiteModule.zza(this.mContext, DynamiteModule.zzgpf, ModuleDescriptor.MODULE_ID);
            if (zza != null) {
                return zza.zzaof().getResources();
            }
            return null;
        } catch (DynamiteModule.zzc e) {
            zzafx.zzc("Cannot load resource from dynamite apk or local jar", e);
            return null;
        }
    }

    public final String getSessionId() {
        return this.mSessionId;
    }

    public final Bundle zza(Context context, zzafs zzafsVar, String str) {
        Bundle bundle;
        synchronized (this.mLock) {
            bundle = new Bundle();
            bundle.putBundle("app", this.zzczh.zzo(context, str));
            Bundle bundle2 = new Bundle();
            for (String str2 : this.zzczk.keySet()) {
                bundle2.putBundle(str2, this.zzczk.get(str2).toBundle());
            }
            bundle.putBundle("slots", bundle2);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Iterator<zzafk> it = this.zzczj.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toBundle());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            zzafsVar.zza(this.zzczj);
            this.zzczj.clear();
        }
        return bundle;
    }

    public final void zza(zzafk zzafkVar) {
        synchronized (this.mLock) {
            this.zzczj.add(zzafkVar);
        }
    }

    public final void zza(Boolean bool) {
        synchronized (this.mLock) {
            this.zzczr = bool;
        }
    }

    public final void zza(String str, zzaft zzaftVar) {
        synchronized (this.mLock) {
            this.zzczk.put(str, zzaftVar);
        }
    }

    public final void zza(Throwable th, String str) {
        zzzo.zzc(this.mContext, this.zzapc).zza(th, str);
    }

    public final void zzaa(boolean z) {
        this.zzdac.zzaa(z);
    }

    public final Future zzab(int i) {
        Future zza;
        synchronized (this.mLock) {
            this.zzdaa = i;
            zza = zzafz.zza(this.mContext, i);
        }
        return zza;
    }

    public final zzhd zzad(Context context) {
        if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbhu)).booleanValue()) {
            if (!((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbic)).booleanValue()) {
                if (!((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbia)).booleanValue()) {
                    return null;
                }
            }
            if (zzpp() && zzpq()) {
                return null;
            }
            synchronized (this.mLock) {
                if (Looper.getMainLooper() == null || context == null) {
                    return null;
                }
                if (this.zzayo == null) {
                    this.zzayo = new zzgy();
                }
                if (this.zzczo == null) {
                    this.zzczo = new zzhd(this.zzayo, zzzo.zzc(this.mContext, this.zzapc));
                }
                this.zzczo.zzgn();
                return this.zzczo;
            }
        }
        return null;
    }

    public final Future zzb(Context context, String str, String str2, boolean z) {
        Future zzr;
        int i = 0;
        synchronized (this.mLock) {
            JSONArray optJSONArray = this.zzczz.optJSONArray(str);
            JSONArray jSONArray = optJSONArray == null ? new JSONArray() : optJSONArray;
            int length = jSONArray.length();
            while (true) {
                if (i >= jSONArray.length()) {
                    i = length;
                    break;
                }
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject == null || !str2.equals(optJSONObject.optString("template_id"))) {
                    i++;
                } else if (z && optJSONObject.optBoolean("uses_media_view", false) == z) {
                    zzr = null;
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("template_id", str2);
                jSONObject.put("uses_media_view", z);
                jSONObject.put("timestamp_ms", com.google.android.gms.ads.internal.zzbv.zzeg().currentTimeMillis());
                jSONArray.put(i, jSONObject);
                this.zzczz.put(str, jSONArray);
            } catch (JSONException e) {
                zzafx.zzc("Could not update native advanced settings", e);
            }
            zzr = zzafz.zzr(this.mContext, this.zzczz.toString());
        }
        return zzr;
    }

    @Override // com.google.android.gms.internal.zzagy
    public final void zzb(Bundle bundle) {
        synchronized (this.mLock) {
            this.zzctf = bundle.getBoolean("use_https", this.zzctf);
            this.zzczm = bundle.getInt("webview_cache_version", this.zzczm);
            if (bundle.containsKey("content_url_opted_out")) {
                zzy(bundle.getBoolean("content_url_opted_out"));
            }
            if (bundle.containsKey("content_url_hashes")) {
                this.zzczp = bundle.getString("content_url_hashes");
            }
            this.zzcto = bundle.getBoolean("auto_collect_location", this.zzcto);
            if (bundle.containsKey("content_vertical_opted_out")) {
                zzz(bundle.getBoolean("content_vertical_opted_out"));
            }
            if (bundle.containsKey("content_vertical_hashes")) {
                this.zzczq = bundle.getString("content_vertical_hashes");
            }
            if (bundle.containsKey("native_advanced_settings")) {
                try {
                    this.zzczz = new JSONObject(bundle.getString("native_advanced_settings"));
                } catch (JSONException e) {
                    zzafx.zzc("Could not convert native advanced settings to json object", e);
                }
            }
            if (bundle.containsKey("version_code")) {
                this.zzdaa = bundle.getInt("version_code");
            }
            this.zzczu = bundle.containsKey("app_settings_json") ? bundle.getString("app_settings_json") : this.zzczu;
            this.zzczv = bundle.getLong("app_settings_last_update_ms", this.zzczv);
            this.zzczw = bundle.getLong("app_last_background_time_ms", this.zzczw);
            this.zzczy = bundle.getInt("request_in_session_count", this.zzczy);
            this.zzczx = bundle.getLong("first_ad_req_time_ms", this.zzczx);
        }
    }

    public final void zzb(HashSet<zzafk> hashSet) {
        synchronized (this.mLock) {
            this.zzczj.addAll(hashSet);
        }
    }

    public final Future zzce(String str) {
        Future zzp;
        synchronized (this.mLock) {
            if (str != null) {
                if (!str.equals(this.zzczp)) {
                    this.zzczp = str;
                    zzp = zzafz.zzp(this.mContext, str);
                }
            }
            zzp = null;
        }
        return zzp;
    }

    public final Future zzcf(String str) {
        Future zzq;
        synchronized (this.mLock) {
            if (str != null) {
                if (!str.equals(this.zzczq)) {
                    this.zzczq = str;
                    zzq = zzafz.zzq(this.mContext, str);
                }
            }
            zzq = null;
        }
        return zzq;
    }

    @TargetApi(23)
    public final void zzd(Context context, zzajk zzajkVar) {
        synchronized (this.mLock) {
            if (!this.zzaqo) {
                this.mContext = context.getApplicationContext();
                this.zzapc = zzajkVar;
                com.google.android.gms.ads.internal.zzbv.zzed().zza(this);
                zzafz.zza(context, this);
                zzafz.zzb(context, this);
                zzafz.zzh(context, this);
                zzafz.zzf(context, this);
                zzafz.zzc(context, this);
                zzafz.zzd(context, this);
                zzafz.zze(context, this);
                zzafz.zzg(context, this);
                zzafz.zzi(context, this);
                zzafz.zzj(context, this);
                zzafz.zzk(context, this);
                zzzo.zzc(this.mContext, this.zzapc);
                this.zzbwh = com.google.android.gms.ads.internal.zzbv.zzea().zzs(context, zzajkVar.zzcp);
                if (Build.VERSION.SDK_INT >= 23 && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
                    this.zzczt = true;
                }
                this.zzamu = new zzfl(context.getApplicationContext(), this.zzapc, com.google.android.gms.ads.internal.zzbv.zzea().zze(context, zzajkVar));
                zzmw zzmwVar = new zzmw(this.mContext, this.zzapc.zzcp);
                try {
                    com.google.android.gms.ads.internal.zzbv.zzei();
                    this.zzczn = zzmz.zza(zzmwVar);
                } catch (IllegalArgumentException e) {
                    zzafx.zzc("Cannot initialize CSI reporter.", e);
                }
                this.zzaqo = true;
            }
        }
    }

    public final Future zze(Context context, boolean z) {
        Future future;
        synchronized (this.mLock) {
            if (z != this.zzctf) {
                this.zzctf = z;
                future = zzafz.zze(context, z);
            } else {
                future = null;
            }
        }
        return future;
    }

    public final Future zzf(Context context, boolean z) {
        Future future;
        synchronized (this.mLock) {
            if (z != this.zzcto) {
                this.zzcto = z;
                future = zzafz.zzh(context, z);
            } else {
                future = null;
            }
        }
        return future;
    }

    @Override // com.google.android.gms.internal.zzhc
    public final void zzg(boolean z) {
        long currentTimeMillis = com.google.android.gms.ads.internal.zzbv.zzeg().currentTimeMillis();
        if (!z) {
            zzj(currentTimeMillis);
            zzac(this.zzczh.zzczy);
            return;
        }
        if (currentTimeMillis - this.zzczw > ((Long) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbjn)).longValue()) {
            this.zzczh.zzczy = -1;
            return;
        }
        this.zzczh.zzczy = this.zzczy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Future zzk(long j) {
        Future zzb;
        synchronized (this.mLock) {
            this.zzczx = j;
            zzb = zzafz.zzb(this.mContext, j);
        }
        return zzb;
    }

    public final Future zzn(Context context, String str) {
        Future zza;
        this.zzczv = com.google.android.gms.ads.internal.zzbv.zzeg().currentTimeMillis();
        synchronized (this.mLock) {
            if (str != null) {
                if (!str.equals(this.zzczu)) {
                    this.zzczu = str;
                    zza = zzafz.zza(context, str, this.zzczv);
                }
            }
            zza = null;
        }
        return zza;
    }

    public final boolean zzpp() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzctg;
        }
        return z;
    }

    public final boolean zzpq() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzcth;
        }
        return z;
    }

    public final String zzpr() {
        String bigInteger;
        synchronized (this.mLock) {
            bigInteger = this.zzczi.toString();
            this.zzczi = this.zzczi.add(BigInteger.ONE);
        }
        return bigInteger;
    }

    public final zzafr zzps() {
        zzafr zzafrVar;
        synchronized (this.mLock) {
            zzafrVar = this.zzczh;
        }
        return zzafrVar;
    }

    public final zzmx zzpt() {
        zzmx zzmxVar;
        synchronized (this.mLock) {
            zzmxVar = this.zzczn;
        }
        return zzmxVar;
    }

    public final boolean zzpu() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzctf || this.zzczt;
        }
        return z;
    }

    public final String zzpv() {
        String str;
        synchronized (this.mLock) {
            str = this.zzbwh;
        }
        return str;
    }

    public final String zzpw() {
        String str;
        synchronized (this.mLock) {
            str = this.zzczp;
        }
        return str;
    }

    public final String zzpx() {
        String str;
        synchronized (this.mLock) {
            str = this.zzczq;
        }
        return str;
    }

    public final Boolean zzpy() {
        Boolean bool;
        synchronized (this.mLock) {
            bool = this.zzczr;
        }
        return bool;
    }

    public final boolean zzpz() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzcto;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zzqa() {
        long j;
        synchronized (this.mLock) {
            j = this.zzczw;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zzqb() {
        long j;
        synchronized (this.mLock) {
            j = this.zzczx;
        }
        return j;
    }

    public final int zzqc() {
        int i;
        synchronized (this.mLock) {
            i = this.zzdaa;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzqd() {
        int i;
        synchronized (this.mLock) {
            i = this.zzczy;
        }
        return i;
    }

    public final boolean zzqe() {
        return this.zzdac.zzqe();
    }

    public final boolean zzqf() {
        return this.zzdac.zzqf();
    }

    public final void zzqg() {
        this.zzdac.zzqg();
    }

    public final zzafm zzqh() {
        zzafm zzafmVar;
        synchronized (this.mLock) {
            zzafmVar = new zzafm(this.zzczu, this.zzczv);
        }
        return zzafmVar;
    }

    public final JSONObject zzqi() {
        JSONObject jSONObject;
        synchronized (this.mLock) {
            jSONObject = this.zzczz;
        }
        return jSONObject;
    }

    public final Future zzqj() {
        Future zzaf;
        synchronized (this.mLock) {
            zzaf = zzafz.zzaf(this.mContext);
        }
        return zzaf;
    }

    public final zzfl zzqk() {
        return this.zzamu;
    }

    public final void zzql() {
        this.zzdab.incrementAndGet();
    }

    public final void zzqm() {
        this.zzdab.decrementAndGet();
    }

    public final int zzqn() {
        return this.zzdab.get();
    }

    public final void zzy(boolean z) {
        synchronized (this.mLock) {
            if (this.zzctg != z) {
                zzafz.zzg(this.mContext, z);
            }
            this.zzctg = z;
            zzhd zzad = zzad(this.mContext);
            if (zzad != null && !zzad.isAlive()) {
                zzafx.zzcr("start fetching content...");
                zzad.zzgn();
            }
        }
    }

    public final void zzz(boolean z) {
        synchronized (this.mLock) {
            if (this.zzcth != z) {
                zzafz.zzg(this.mContext, z);
            }
            zzafz.zzg(this.mContext, z);
            this.zzcth = z;
            zzhd zzad = zzad(this.mContext);
            if (zzad != null && !zzad.isAlive()) {
                zzafx.zzcr("start fetching content...");
                zzad.zzgn();
            }
        }
    }
}

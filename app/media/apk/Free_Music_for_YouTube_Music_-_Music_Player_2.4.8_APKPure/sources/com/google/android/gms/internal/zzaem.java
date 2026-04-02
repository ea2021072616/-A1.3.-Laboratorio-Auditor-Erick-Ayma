package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.view.View;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.zzbp;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzaem implements zzaev {
    private final Context mContext;
    private final zzaes zzctt;
    private final zzegs zzcwx;
    private final LinkedHashMap<String, zzeha> zzcwy;
    private final zzaex zzcwz;
    @VisibleForTesting
    boolean zzcxa;
    private final Object mLock = new Object();
    private HashSet<String> zzcxb = new HashSet<>();
    private boolean zzcxc = false;
    private boolean zzcxd = false;
    private boolean zzcxe = false;

    public zzaem(Context context, zzajk zzajkVar, zzaao zzaaoVar, zzaex zzaexVar) {
        zzbp.zzb(zzaaoVar.zzcqj, "SafeBrowsing config is not present.");
        this.mContext = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzcwy = new LinkedHashMap<>();
        this.zzcwz = zzaexVar;
        this.zzctt = zzaaoVar.zzcqj;
        for (String str : this.zzctt.zzcxm) {
            this.zzcxb.add(str.toLowerCase(Locale.ENGLISH));
        }
        this.zzcxb.remove("cookie".toLowerCase(Locale.ENGLISH));
        zzegs zzegsVar = new zzegs();
        zzegsVar.zzndp = 8;
        zzegsVar.url = zzaaoVar.zzchb;
        zzegsVar.zzndr = zzaaoVar.zzchb;
        zzegsVar.zzndt = new zzegt();
        zzegsVar.zzndt.zzcxi = this.zzctt.zzcxi;
        zzehb zzehbVar = new zzehb();
        zzehbVar.zznfa = zzajkVar.zzcp;
        zzehbVar.zznfc = Boolean.valueOf(zzbdp.zzcs(this.mContext).zzalq());
        com.google.android.gms.common.zze.zzaew();
        long zzbx = com.google.android.gms.common.zze.zzbx(this.mContext);
        if (zzbx > 0) {
            zzehbVar.zznfb = Long.valueOf(zzbx);
        }
        zzegsVar.zzned = zzehbVar;
        this.zzcwx = zzegsVar;
    }

    @Nullable
    private final zzeha zzca(String str) {
        zzeha zzehaVar;
        synchronized (this.mLock) {
            zzehaVar = this.zzcwy.get(str);
        }
        return zzehaVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void send() {
        zzeha[] zzehaVarArr;
        boolean z = true;
        if ((!this.zzcxa || !this.zzctt.zzcxo) && ((!this.zzcxe || !this.zzctt.zzcxn) && (this.zzcxa || !this.zzctt.zzcxl))) {
            z = false;
        }
        if (z) {
            synchronized (this.mLock) {
                this.zzcwx.zzndu = new zzeha[this.zzcwy.size()];
                this.zzcwy.values().toArray(this.zzcwx.zzndu);
                if (zzaeu.isEnabled()) {
                    String str = this.zzcwx.url;
                    String str2 = this.zzcwx.zzndv;
                    StringBuilder sb = new StringBuilder(new StringBuilder(String.valueOf(str).length() + 53 + String.valueOf(str2).length()).append("Sending SB report\n  url: ").append(str).append("\n  clickUrl: ").append(str2).append("\n  resources: \n").toString());
                    for (zzeha zzehaVar : this.zzcwx.zzndu) {
                        sb.append("    [");
                        sb.append(zzehaVar.zznez.length);
                        sb.append("] ");
                        sb.append(zzehaVar.url);
                    }
                    zzaeu.zzcb(sb.toString());
                }
                zzajr<String> zza = new zzaik(this.mContext).zza(1, this.zzctt.zzcxj, null, zzego.zzc(this.zzcwx));
                if (zzaeu.isEnabled()) {
                    zza.zza(new zzaep(this), zzagz.zzdbh);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.zzaev
    public final void zza(String str, Map<String, String> map, int i) {
        synchronized (this.mLock) {
            if (i == 3) {
                this.zzcxe = true;
            }
            if (this.zzcwy.containsKey(str)) {
                if (i == 3) {
                    this.zzcwy.get(str).zzney = Integer.valueOf(i);
                }
                return;
            }
            zzeha zzehaVar = new zzeha();
            zzehaVar.zzney = Integer.valueOf(i);
            zzehaVar.zzixi = Integer.valueOf(this.zzcwy.size());
            zzehaVar.url = str;
            zzehaVar.zznet = new zzegv();
            if (this.zzcxb.size() > 0 && map != null) {
                LinkedList linkedList = new LinkedList();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    try {
                        String key = entry.getKey() != null ? entry.getKey() : "";
                        String value = entry.getValue() != null ? entry.getValue() : "";
                        if (this.zzcxb.contains(key.toLowerCase(Locale.ENGLISH))) {
                            zzegu zzeguVar = new zzegu();
                            zzeguVar.zznef = key.getBytes(C.UTF8_NAME);
                            zzeguVar.zzmpq = value.getBytes(C.UTF8_NAME);
                            linkedList.add(zzeguVar);
                        }
                    } catch (UnsupportedEncodingException e) {
                        zzaeu.zzcb("Cannot convert string to bytes, skip header.");
                    }
                }
                zzegu[] zzeguVarArr = new zzegu[linkedList.size()];
                linkedList.toArray(zzeguVarArr);
                zzehaVar.zznet.zzneh = zzeguVarArr;
            }
            this.zzcwy.put(str, zzehaVar);
        }
    }

    @Override // com.google.android.gms.internal.zzaev
    public final void zzbz(String str) {
        synchronized (this.mLock) {
            this.zzcwx.zzndv = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zzj(@Nullable Map<String, String> map) throws JSONException {
        if (map == null) {
            return;
        }
        for (String str : map.keySet()) {
            JSONArray optJSONArray = new JSONObject(map.get(str)).optJSONArray("matches");
            if (optJSONArray != null) {
                synchronized (this.mLock) {
                    int length = optJSONArray.length();
                    zzeha zzca = zzca(str);
                    if (zzca == null) {
                        String valueOf = String.valueOf(str);
                        zzaeu.zzcb(valueOf.length() != 0 ? "Cannot find the corresponding resource object for ".concat(valueOf) : new String("Cannot find the corresponding resource object for "));
                    } else {
                        zzca.zznez = new String[length];
                        for (int i = 0; i < length; i++) {
                            zzca.zznez[i] = optJSONArray.getJSONObject(i).getString("threat_type");
                        }
                        this.zzcxa = (length > 0) | this.zzcxa;
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.zzaev
    public final void zzk(View view) {
        if (this.zzctt.zzcxk && !this.zzcxd) {
            com.google.android.gms.ads.internal.zzbv.zzea();
            Bitmap zzm = zzahf.zzm(view);
            if (zzm == null) {
                zzaeu.zzcb("Failed to capture the webview bitmap.");
                return;
            }
            this.zzcxd = true;
            zzahf.zzb(new zzaen(this, zzm));
        }
    }

    @Override // com.google.android.gms.internal.zzaev
    public final zzaes zzpb() {
        return this.zzctt;
    }

    @Override // com.google.android.gms.internal.zzaev
    public final boolean zzpc() {
        return com.google.android.gms.common.util.zzp.zzalh() && this.zzctt.zzcxk && !this.zzcxd;
    }

    @Override // com.google.android.gms.internal.zzaev
    public final void zzpd() {
        this.zzcxc = true;
    }

    @Override // com.google.android.gms.internal.zzaev
    public final void zzpe() {
        synchronized (this.mLock) {
            zzajr<Map<String, String>> zza = this.zzcwz.zza(this.mContext, this.zzcwy.keySet());
            zza.zza(new zzaeo(this, zza), zzagz.zzdbh);
        }
    }
}

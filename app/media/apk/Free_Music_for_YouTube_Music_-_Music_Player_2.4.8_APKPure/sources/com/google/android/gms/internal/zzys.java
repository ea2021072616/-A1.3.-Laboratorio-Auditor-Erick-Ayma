package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzys implements Callable<zzafi> {
    private static long zzclc = TimeUnit.SECONDS.toMillis(60);
    private final Context mContext;
    private int mErrorCode;
    private final Object mLock = new Object();
    private final zznh zzamn;
    private zzym zzaqz;
    private final zzcv zzbsr;
    private final zzafj zzckj;
    private final zzaik zzclo;
    private final com.google.android.gms.ads.internal.zzbc zzclp;
    private boolean zzclq;
    private List<String> zzclr;
    private JSONObject zzcls;
    private String zzclt;
    private boolean zzclu;

    public zzys(Context context, com.google.android.gms.ads.internal.zzbc zzbcVar, zzaik zzaikVar, zzcv zzcvVar, zzafj zzafjVar, zznh zznhVar) {
        this.mContext = context;
        this.zzclp = zzbcVar;
        this.zzclo = zzaikVar;
        this.zzckj = zzafjVar;
        this.zzbsr = zzcvVar;
        this.zzamn = zznhVar;
        if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbmv)).booleanValue()) {
            this.zzaqz = zzbcVar.zzdi();
        }
        if (this.zzaqz == null) {
            this.zzaqz = new zzym(context, zzafjVar, zzbcVar, zzcvVar);
            this.zzaqz.zznv();
            this.zzclu = true;
        }
        this.zzclq = false;
        this.mErrorCode = -2;
        this.zzclr = null;
        this.zzclt = null;
    }

    private final zzafi zza(zzog zzogVar) {
        int i;
        synchronized (this.mLock) {
            i = this.mErrorCode;
            if (zzogVar == null && this.mErrorCode == -2) {
                i = 0;
            }
        }
        return new zzafi(this.zzckj.zzcrj.zzcnw, null, this.zzckj.zzcyp.zzcau, i, this.zzckj.zzcyp.zzcav, this.zzclr, this.zzckj.zzcyp.orientation, this.zzckj.zzcyp.zzcba, this.zzckj.zzcrj.zzcnz, false, null, null, null, null, null, 0L, this.zzckj.zzatn, this.zzckj.zzcyp.zzcpn, this.zzckj.zzcyi, this.zzckj.zzcyj, this.zzckj.zzcyp.zzcpt, this.zzcls, i != -2 ? null : zzogVar, null, null, null, this.zzckj.zzcyp.zzcqg, this.zzckj.zzcyp.zzcqh, null, this.zzckj.zzcyp.zzcax, this.zzclt, this.zzckj.zzcyo);
    }

    private final zzajr<zznv> zza(JSONObject jSONObject, boolean z, boolean z2) throws JSONException {
        String string = z ? jSONObject.getString("url") : jSONObject.optString("url");
        double optDouble = jSONObject.optDouble("scale", 1.0d);
        boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        if (!TextUtils.isEmpty(string)) {
            return z2 ? zzajn.zzg(new zznv(null, Uri.parse(string), optDouble)) : this.zzclo.zza(string, new zzyz(this, z, optDouble, optBoolean, string));
        }
        zzd(0, z);
        return zzajn.zzg(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzakk zzb(zzajr<zzakk> zzajrVar) {
        try {
            return zzajrVar.get(((Integer) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbna)).intValue(), TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            zzafx.zzc("InterruptedException occurred while waiting for video to load", e);
            Thread.currentThread().interrupt();
            return null;
        } catch (CancellationException e2) {
            e = e2;
            zzafx.zzc("Exception occurred while waiting for video to load", e);
            return null;
        } catch (ExecutionException e3) {
            e = e3;
            zzafx.zzc("Exception occurred while waiting for video to load", e);
            return null;
        } catch (TimeoutException e4) {
            e = e4;
            zzafx.zzc("Exception occurred while waiting for video to load", e);
            return null;
        }
    }

    private static Integer zzb(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzc(zzpt zzptVar, String str) {
        try {
            zzqd zzr = this.zzclp.zzr(zzptVar.getCustomTemplateId());
            if (zzr != null) {
                zzr.zzb(zzptVar, str);
            }
        } catch (RemoteException e) {
            zzafx.zzc(new StringBuilder(String.valueOf(str).length() + 40).append("Failed to call onCustomClick for asset ").append(str).append(".").toString(), e);
        }
    }

    private static String[] zzd(JSONObject jSONObject, String str) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        String[] strArr = new String[optJSONArray.length()];
        for (int i = 0; i < optJSONArray.length(); i++) {
            strArr[i] = optJSONArray.getString(i);
        }
        return strArr;
    }

    private static <V> zzajr<List<V>> zzk(List<zzajr<V>> list) {
        zzajx zzajxVar = new zzajx();
        int size = list.size();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (zzajr<V> zzajrVar : list) {
            zzajrVar.zza(new zzza(atomicInteger, size, zzajxVar, list), zzagz.zzdbh);
        }
        return zzajxVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <V> List<V> zzl(List<zzajr<V>> list) throws ExecutionException, InterruptedException {
        ArrayList arrayList = new ArrayList();
        for (zzajr<V> zzajrVar : list) {
            V v = zzajrVar.get();
            if (v != null) {
                arrayList.add(v);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0113  */
    @Override // java.util.concurrent.Callable
    /* renamed from: zznz */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.zzafi call() {
        /*
            Method dump skipped, instructions count: 381
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzys.call():com.google.android.gms.internal.zzafi");
    }

    public final zzajr<zznv> zza(JSONObject jSONObject, String str, boolean z, boolean z2) throws JSONException {
        JSONObject jSONObject2 = z ? jSONObject.getJSONObject(str) : jSONObject.optJSONObject(str);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return zza(jSONObject2, z, z2);
    }

    public final List<zzajr<zznv>> zza(JSONObject jSONObject, String str, boolean z, boolean z2, boolean z3) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        ArrayList arrayList = new ArrayList();
        if (optJSONArray == null || optJSONArray.length() == 0) {
            zzd(0, false);
            return arrayList;
        }
        int length = z3 ? optJSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            arrayList.add(zza(jSONObject2, false, z2));
        }
        return arrayList;
    }

    public final Future<zznv> zza(JSONObject jSONObject, String str, boolean z) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        boolean optBoolean = jSONObject2.optBoolean("require", true);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return zza(jSONObject2, optBoolean, z);
    }

    public final zzajr<zzakk> zzc(JSONObject jSONObject, String str) throws JSONException {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return zzajn.zzg(null);
        }
        if (TextUtils.isEmpty(optJSONObject.optString("vast_xml"))) {
            zzafx.zzcs("Required field 'vast_xml' is missing");
            return zzajn.zzg(null);
        }
        zzzd zzzdVar = new zzzd(this.mContext, this.zzbsr, this.zzckj, this.zzamn, this.zzclp);
        zzajx zzajxVar = new zzajx();
        com.google.android.gms.ads.internal.zzbv.zzea();
        zzahf.runOnUiThread(new zzze(zzzdVar, optJSONObject, zzajxVar));
        return zzajxVar;
    }

    public final zzajr<zznt> zzd(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject = jSONObject.optJSONObject("attribution");
        if (optJSONObject == null) {
            return zzajn.zzg(null);
        }
        String optString = optJSONObject.optString(MimeTypes.BASE_TYPE_TEXT);
        int optInt = optJSONObject.optInt("text_size", -1);
        Integer zzb = zzb(optJSONObject, "text_color");
        Integer zzb2 = zzb(optJSONObject, "bg_color");
        int optInt2 = optJSONObject.optInt("animation_ms", 1000);
        int optInt3 = optJSONObject.optInt("presentation_ms", 4000);
        int i = (this.zzckj.zzcrj.zzatz == null || this.zzckj.zzcrj.zzatz.versionCode < 2) ? 1 : this.zzckj.zzcrj.zzatz.zzbtf;
        boolean optBoolean = optJSONObject.optBoolean("allow_pub_rendering");
        List<zzajr<zznv>> arrayList = new ArrayList<>();
        if (optJSONObject.optJSONArray("images") != null) {
            arrayList = zza(optJSONObject, "images", false, false, true);
        } else {
            arrayList.add(zza(optJSONObject, MessengerShareContentUtility.MEDIA_IMAGE, false, false));
        }
        return zzajn.zza(zzk(arrayList), new zzyy(this, optString, zzb2, zzb, optInt, optInt3, optInt2, i, optBoolean), zzagz.zzdbh);
    }

    public final void zzd(int i, boolean z) {
        if (z) {
            zzy(i);
        }
    }

    public final boolean zzoa() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzclq;
        }
        return z;
    }

    public final void zzy(int i) {
        synchronized (this.mLock) {
            this.zzclq = true;
            this.mErrorCode = i;
        }
    }
}

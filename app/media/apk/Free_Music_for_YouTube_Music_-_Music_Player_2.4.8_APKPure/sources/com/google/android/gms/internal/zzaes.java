package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzaes extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Parcelable.Creator<zzaes> CREATOR = new zzaet();
    public final String zzcxi;
    public final String zzcxj;
    public final boolean zzcxk;
    public final boolean zzcxl;
    public final List<String> zzcxm;
    public final boolean zzcxn;
    public final boolean zzcxo;

    public zzaes(String str, String str2, boolean z, boolean z2, List<String> list, boolean z3, boolean z4) {
        this.zzcxi = str;
        this.zzcxj = str2;
        this.zzcxk = z;
        this.zzcxl = z2;
        this.zzcxm = list;
        this.zzcxn = z3;
        this.zzcxo = z4;
    }

    @Nullable
    public static zzaes zzf(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("click_string", "");
        String optString2 = jSONObject.optString("report_url", "");
        boolean optBoolean = jSONObject.optBoolean("rendered_ad_enabled", false);
        boolean optBoolean2 = jSONObject.optBoolean("non_malicious_reporting_enabled", false);
        JSONArray optJSONArray = jSONObject.optJSONArray("allowed_headers");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            String optString3 = optJSONArray.optString(i);
            if (!TextUtils.isEmpty(optString3)) {
                arrayList.add(optString3.toLowerCase(Locale.ENGLISH));
            }
        }
        return new zzaes(optString, optString2, optBoolean, optBoolean2, arrayList, jSONObject.optBoolean("protection_enabled", false), jSONObject.optBoolean("malicious_reporting_enabled", false));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = com.google.android.gms.common.internal.safeparcel.zzd.zze(parcel);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 2, this.zzcxi, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 3, this.zzcxj, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 4, this.zzcxk);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 5, this.zzcxl);
        com.google.android.gms.common.internal.safeparcel.zzd.zzb(parcel, 6, this.zzcxm, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 7, this.zzcxn);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 8, this.zzcxo);
        com.google.android.gms.common.internal.safeparcel.zzd.zzai(parcel, zze);
    }
}

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzaaq extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Parcelable.Creator<zzaaq> CREATOR = new zzaar();
    public final boolean zzcqn;
    @Nullable
    public final List<String> zzcqo;

    public zzaaq() {
        this(false, Collections.emptyList());
    }

    public zzaaq(boolean z, List<String> list) {
        this.zzcqn = z;
        this.zzcqo = list;
    }

    @Nullable
    public static zzaaq zze(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new zzaaq();
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("reporting_urls");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    arrayList.add(optJSONArray.getString(i));
                } catch (JSONException e) {
                    zzafx.zzc("Error grabbing url from json.", e);
                }
            }
        }
        return new zzaaq(jSONObject.optBoolean("enable_protection"), arrayList);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = com.google.android.gms.common.internal.safeparcel.zzd.zze(parcel);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 2, this.zzcqn);
        com.google.android.gms.common.internal.safeparcel.zzd.zzb(parcel, 3, this.zzcqo, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzai(parcel, zze);
    }
}

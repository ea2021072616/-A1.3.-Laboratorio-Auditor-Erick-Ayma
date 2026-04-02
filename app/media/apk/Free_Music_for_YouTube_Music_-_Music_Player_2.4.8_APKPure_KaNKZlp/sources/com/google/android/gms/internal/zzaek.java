package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.common.internal.zzbf;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
@zzzt
/* loaded from: classes.dex */
public final class zzaek extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Parcelable.Creator<zzaek> CREATOR = new zzael();
    public final String type;
    public final int zzcww;

    public zzaek(RewardItem rewardItem) {
        this(rewardItem.getType(), rewardItem.getAmount());
    }

    public zzaek(String str, int i) {
        this.type = str;
        this.zzcww = i;
    }

    @Nullable
    public static zzaek zza(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        return new zzaek(jSONArray.getJSONObject(0).optString("rb_type"), jSONArray.getJSONObject(0).optInt("rb_amount"));
    }

    @Nullable
    public static zzaek zzby(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return zza(new JSONArray(str));
        } catch (JSONException e) {
            return null;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzaek)) {
            return false;
        }
        zzaek zzaekVar = (zzaek) obj;
        return zzbf.equal(this.type, zzaekVar.type) && zzbf.equal(Integer.valueOf(this.zzcww), Integer.valueOf(zzaekVar.zzcww));
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.type, Integer.valueOf(this.zzcww)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = com.google.android.gms.common.internal.safeparcel.zzd.zze(parcel);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 2, this.type, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 3, this.zzcww);
        com.google.android.gms.common.internal.safeparcel.zzd.zzai(parcel, zze);
    }
}

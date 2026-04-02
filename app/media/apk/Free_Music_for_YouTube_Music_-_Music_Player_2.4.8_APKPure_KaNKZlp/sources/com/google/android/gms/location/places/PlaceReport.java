package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;
import com.google.android.gms.common.internal.zzbf;
import com.google.android.gms.common.internal.zzbh;
import com.google.android.gms.common.internal.zzbp;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class PlaceReport extends zza implements ReflectedParcelable {
    public static final Parcelable.Creator<PlaceReport> CREATOR = new zzl();
    private final String mTag;
    private final String zzdmj;
    private int zzdxt;
    private final String zzibd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlaceReport(int i, String str, String str2, String str3) {
        this.zzdxt = i;
        this.zzibd = str;
        this.mTag = str2;
        this.zzdmj = str3;
    }

    public static PlaceReport create(String str, String str2) {
        boolean z = false;
        zzbp.zzu(str);
        zzbp.zzgf(str2);
        zzbp.zzgf("unknown");
        char c2 = 65535;
        switch ("unknown".hashCode()) {
            case -1436706272:
                if ("unknown".equals("inferredGeofencing")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1194968642:
                if ("unknown".equals("userReported")) {
                    c2 = 1;
                    break;
                }
                break;
            case -284840886:
                if ("unknown".equals("unknown")) {
                    c2 = 0;
                    break;
                }
                break;
            case -262743844:
                if ("unknown".equals("inferredReverseGeocoding")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1164924125:
                if ("unknown".equals("inferredSnappedToRoad")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1287171955:
                if ("unknown".equals("inferredRadioSignals")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                z = true;
                break;
        }
        zzbp.zzb(z, "Invalid source");
        return new PlaceReport(1, str, str2, "unknown");
    }

    public boolean equals(Object obj) {
        if (obj instanceof PlaceReport) {
            PlaceReport placeReport = (PlaceReport) obj;
            return zzbf.equal(this.zzibd, placeReport.zzibd) && zzbf.equal(this.mTag, placeReport.mTag) && zzbf.equal(this.zzdmj, placeReport.zzdmj);
        }
        return false;
    }

    public String getPlaceId() {
        return this.zzibd;
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzibd, this.mTag, this.zzdmj});
    }

    public String toString() {
        zzbh zzt = zzbf.zzt(this);
        zzt.zzg("placeId", this.zzibd);
        zzt.zzg("tag", this.mTag);
        if (!"unknown".equals(this.zzdmj)) {
            zzt.zzg(ShareConstants.FEED_SOURCE_PARAM, this.zzdmj);
        }
        return zzt.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzd.zze(parcel);
        zzd.zzc(parcel, 1, this.zzdxt);
        zzd.zza(parcel, 2, getPlaceId(), false);
        zzd.zza(parcel, 3, getTag(), false);
        zzd.zza(parcel, 4, this.zzdmj, false);
        zzd.zzai(parcel, zze);
    }
}

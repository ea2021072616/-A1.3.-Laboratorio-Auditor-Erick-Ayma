package com.google.android.gms.internal;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.HashSet;
@zzzt
/* loaded from: classes.dex */
public final class zzwl {
    public static int zza(AdRequest.ErrorCode errorCode) {
        switch (zzwm.zzcdh[errorCode.ordinal()]) {
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            default:
                return 0;
        }
    }

    public static AdSize zzb(zzjb zzjbVar) {
        AdSize[] adSizeArr = {AdSize.SMART_BANNER, AdSize.BANNER, AdSize.IAB_MRECT, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_WIDE_SKYSCRAPER};
        for (int i = 0; i < 6; i++) {
            if (adSizeArr[i].getWidth() == zzjbVar.width && adSizeArr[i].getHeight() == zzjbVar.height) {
                return adSizeArr[i];
            }
        }
        return new AdSize(com.google.android.gms.ads.zzb.zza(zzjbVar.width, zzjbVar.height, zzjbVar.zzbcq));
    }

    public static MediationAdRequest zzn(zzix zzixVar) {
        AdRequest.Gender gender;
        HashSet hashSet = zzixVar.zzbbn != null ? new HashSet(zzixVar.zzbbn) : null;
        Date date = new Date(zzixVar.zzbbl);
        switch (zzixVar.zzbbm) {
            case 1:
                gender = AdRequest.Gender.MALE;
                break;
            case 2:
                gender = AdRequest.Gender.FEMALE;
                break;
            default:
                gender = AdRequest.Gender.UNKNOWN;
                break;
        }
        return new MediationAdRequest(date, gender, hashSet, zzixVar.zzbbo, zzixVar.zzbbt);
    }
}

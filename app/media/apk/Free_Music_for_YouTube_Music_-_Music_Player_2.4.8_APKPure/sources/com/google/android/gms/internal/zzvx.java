package com.google.android.gms.internal;

import android.location.Location;
import android.support.annotation.Nullable;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
@zzzt
/* loaded from: classes.dex */
public final class zzvx implements NativeMediationAdRequest {
    private final zzot zzaoy;
    private final int zzbcc;
    private final boolean zzbco;
    private final int zzcct;
    private final Date zzha;
    private final Set<String> zzhc;
    private final boolean zzhd;
    private final Location zzhe;
    private final List<String> zzaoz = new ArrayList();
    private final Map<String, Boolean> zzcdb = new HashMap();

    public zzvx(@Nullable Date date, int i, @Nullable Set<String> set, @Nullable Location location, boolean z, int i2, zzot zzotVar, List<String> list, boolean z2) {
        this.zzha = date;
        this.zzbcc = i;
        this.zzhc = set;
        this.zzhe = location;
        this.zzhd = z;
        this.zzcct = i2;
        this.zzaoy = zzotVar;
        this.zzbco = z2;
        if (list != null) {
            for (String str : list) {
                if (str.startsWith("custom:")) {
                    String[] split = str.split(":", 3);
                    if (split.length == 3) {
                        if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(split[2])) {
                            this.zzcdb.put(split[1], true);
                        } else if ("false".equals(split[2])) {
                            this.zzcdb.put(split[1], false);
                        }
                    }
                } else {
                    this.zzaoz.add(str);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Date getBirthday() {
        return this.zzha;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final int getGender() {
        return this.zzbcc;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Set<String> getKeywords() {
        return this.zzhc;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Location getLocation() {
        return this.zzhe;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final NativeAdOptions getNativeAdOptions() {
        if (this.zzaoy == null) {
            return null;
        }
        NativeAdOptions.Builder requestMultipleImages = new NativeAdOptions.Builder().setReturnUrlsForImageAssets(this.zzaoy.zzbtc).setImageOrientation(this.zzaoy.zzbtd).setRequestMultipleImages(this.zzaoy.zzbte);
        if (this.zzaoy.versionCode >= 2) {
            requestMultipleImages.setAdChoicesPlacement(this.zzaoy.zzbtf);
        }
        if (this.zzaoy.versionCode >= 3 && this.zzaoy.zzbtg != null) {
            requestMultipleImages.setVideoOptions(new VideoOptions(this.zzaoy.zzbtg));
        }
        return requestMultipleImages.build();
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isAppInstallAdRequested() {
        return this.zzaoz != null && this.zzaoz.contains("2");
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isContentAdRequested() {
        return this.zzaoz != null && this.zzaoz.contains(AppEventsConstants.EVENT_PARAM_VALUE_YES);
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final boolean isDesignedForFamilies() {
        return this.zzbco;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final boolean isTesting() {
        return this.zzhd;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final int taggedForChildDirectedTreatment() {
        return this.zzcct;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean zzmc() {
        return this.zzaoz != null && this.zzaoz.contains("3");
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final Map<String, Boolean> zzmd() {
        return this.zzcdb;
    }
}

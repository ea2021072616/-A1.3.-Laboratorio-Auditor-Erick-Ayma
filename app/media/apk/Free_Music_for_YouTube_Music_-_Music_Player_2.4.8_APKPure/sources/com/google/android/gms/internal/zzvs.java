package com.google.android.gms.internal;

import android.location.Location;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;
@zzzt
/* loaded from: classes.dex */
public final class zzvs implements MediationAdRequest {
    private final int zzbcc;
    private final boolean zzbco;
    private final int zzcct;
    private final Date zzha;
    private final Set<String> zzhc;
    private final boolean zzhd;
    private final Location zzhe;

    public zzvs(@Nullable Date date, int i, @Nullable Set<String> set, @Nullable Location location, boolean z, int i2, boolean z2) {
        this.zzha = date;
        this.zzbcc = i;
        this.zzhc = set;
        this.zzhe = location;
        this.zzhd = z;
        this.zzcct = i2;
        this.zzbco = z2;
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
}

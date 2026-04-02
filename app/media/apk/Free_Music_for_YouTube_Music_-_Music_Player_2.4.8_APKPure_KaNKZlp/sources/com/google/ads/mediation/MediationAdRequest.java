package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
@Deprecated
/* loaded from: classes.dex */
public class MediationAdRequest {
    private final Date zzha;
    private final AdRequest.Gender zzhb;
    private final Set<String> zzhc;
    private final boolean zzhd;
    private final Location zzhe;

    public MediationAdRequest(Date date, AdRequest.Gender gender, Set<String> set, boolean z, Location location) {
        this.zzha = date;
        this.zzhb = gender;
        this.zzhc = set;
        this.zzhd = z;
        this.zzhe = location;
    }

    public Integer getAgeInYears() {
        if (this.zzha != null) {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar.setTime(this.zzha);
            Integer valueOf = Integer.valueOf(calendar2.get(1) - calendar.get(1));
            return (calendar2.get(2) < calendar.get(2) || (calendar2.get(2) == calendar.get(2) && calendar2.get(5) < calendar.get(5))) ? Integer.valueOf(valueOf.intValue() - 1) : valueOf;
        }
        return null;
    }

    public Date getBirthday() {
        return this.zzha;
    }

    public AdRequest.Gender getGender() {
        return this.zzhb;
    }

    public Set<String> getKeywords() {
        return this.zzhc;
    }

    public Location getLocation() {
        return this.zzhe;
    }

    public boolean isTesting() {
        return this.zzhd;
    }
}

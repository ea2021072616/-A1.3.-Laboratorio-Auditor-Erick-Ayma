package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
@zzzt
/* loaded from: classes.dex */
public final class zzja {
    public static final zzja zzbcp = new zzja();

    protected zzja() {
    }

    public static zzix zza(Context context, zzlg zzlgVar) {
        Date birthday = zzlgVar.getBirthday();
        long time = birthday != null ? birthday.getTime() : -1L;
        String contentUrl = zzlgVar.getContentUrl();
        int gender = zzlgVar.getGender();
        Set<String> keywords = zzlgVar.getKeywords();
        List unmodifiableList = !keywords.isEmpty() ? Collections.unmodifiableList(new ArrayList(keywords)) : null;
        boolean isTestDevice = zzlgVar.isTestDevice(context);
        int zzid = zzlgVar.zzid();
        Location location = zzlgVar.getLocation();
        Bundle networkExtrasBundle = zzlgVar.getNetworkExtrasBundle(AdMobAdapter.class);
        boolean manualImpressionsEnabled = zzlgVar.getManualImpressionsEnabled();
        String publisherProvidedId = zzlgVar.getPublisherProvidedId();
        SearchAdRequest zzia = zzlgVar.zzia();
        zzlz zzlzVar = zzia != null ? new zzlz(zzia) : null;
        String str = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            zzjo.zzhu();
            str = zzaje.zza(Thread.currentThread().getStackTrace(), packageName);
        }
        return new zzix(7, time, networkExtrasBundle, gender, unmodifiableList, isTestDevice, zzid, manualImpressionsEnabled, publisherProvidedId, zzlzVar, location, contentUrl, zzlgVar.zzic(), zzlgVar.getCustomTargeting(), Collections.unmodifiableList(new ArrayList(zzlgVar.zzie())), zzlgVar.zzhz(), str, zzlgVar.isDesignedForFamilies());
    }
}

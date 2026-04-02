package com.google.android.gms.ads.internal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.facebook.applinks.AppLinkData;
import com.facebook.places.model.PlaceFields;
import com.google.android.gms.internal.zzix;
import com.google.android.gms.internal.zzjb;
import com.google.android.gms.internal.zzzt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;
@zzzt
/* loaded from: classes.dex */
public final class zzp {
    private static String bundleToString(@Nullable Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        while (it.hasNext()) {
            Object obj = bundle.get((String) it.next());
            sb.append(obj == null ? "null" : obj instanceof Bundle ? bundleToString((Bundle) obj) : obj.toString());
        }
        return sb.toString();
    }

    public static Object[] zza(String str, zzix zzixVar, String str2, int i, @Nullable zzjb zzjbVar) {
        HashSet hashSet = new HashSet(Arrays.asList(str.split(",")));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(str2);
        if (hashSet.contains("formatString")) {
            arrayList.add(null);
        }
        if (hashSet.contains("networkType")) {
            arrayList.add(Integer.valueOf(i));
        }
        if (hashSet.contains("birthday")) {
            arrayList.add(Long.valueOf(zzixVar.zzbbl));
        }
        if (hashSet.contains(AppLinkData.ARGUMENTS_EXTRAS_KEY)) {
            arrayList.add(bundleToString(zzixVar.extras));
        }
        if (hashSet.contains("gender")) {
            arrayList.add(Integer.valueOf(zzixVar.zzbbm));
        }
        if (hashSet.contains("keywords")) {
            if (zzixVar.zzbbn != null) {
                arrayList.add(zzixVar.zzbbn.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("isTestDevice")) {
            arrayList.add(Boolean.valueOf(zzixVar.zzbbo));
        }
        if (hashSet.contains("tagForChildDirectedTreatment")) {
            arrayList.add(Integer.valueOf(zzixVar.zzbbp));
        }
        if (hashSet.contains("manualImpressionsEnabled")) {
            arrayList.add(Boolean.valueOf(zzixVar.zzbbq));
        }
        if (hashSet.contains("publisherProvidedId")) {
            arrayList.add(zzixVar.zzbbr);
        }
        if (hashSet.contains(PlaceFields.LOCATION)) {
            if (zzixVar.zzbbt != null) {
                arrayList.add(zzixVar.zzbbt.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("contentUrl")) {
            arrayList.add(zzixVar.zzbbu);
        }
        if (hashSet.contains("networkExtras")) {
            arrayList.add(bundleToString(zzixVar.zzbbv));
        }
        if (hashSet.contains("customTargeting")) {
            arrayList.add(bundleToString(zzixVar.zzbbw));
        }
        if (hashSet.contains("categoryExclusions")) {
            if (zzixVar.zzbbx != null) {
                arrayList.add(zzixVar.zzbbx.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("requestAgent")) {
            arrayList.add(zzixVar.zzbby);
        }
        if (hashSet.contains("requestPackage")) {
            arrayList.add(zzixVar.zzbbz);
        }
        if (hashSet.contains("isDesignedForFamilies")) {
            arrayList.add(Boolean.valueOf(zzixVar.zzbca));
        }
        return arrayList.toArray();
    }
}

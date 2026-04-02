package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.facebook.appevents.AppEventsConstants;
import java.util.List;
@zzzt
/* loaded from: classes.dex */
public final class zzie extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Parcelable.Creator<zzie> CREATOR = new zzif();
    @Nullable
    public final String url;
    private long zzbak;
    private String zzbal;
    private String zzbam;
    private String zzban;
    private Bundle zzbao;
    private boolean zzbap;
    private long zzbaq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzie(@Nullable String str, long j, String str2, String str3, String str4, Bundle bundle, boolean z, long j2) {
        this.url = str;
        this.zzbak = j;
        this.zzbal = str2 == null ? "" : str2;
        this.zzbam = str3 == null ? "" : str3;
        this.zzban = str4 == null ? "" : str4;
        this.zzbao = bundle == null ? new Bundle() : bundle;
        this.zzbap = z;
        this.zzbaq = j2;
    }

    @Nullable
    public static zzie zzaa(String str) {
        return zze(Uri.parse(str));
    }

    @Nullable
    public static zzie zze(Uri uri) {
        try {
            if ("gcache".equals(uri.getScheme())) {
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments.size() != 2) {
                    zzafx.zzcs(new StringBuilder(62).append("Expected 2 path parts for namespace and id, found :").append(pathSegments.size()).toString());
                    return null;
                }
                String str = pathSegments.get(0);
                String str2 = pathSegments.get(1);
                String host = uri.getHost();
                String queryParameter = uri.getQueryParameter("url");
                boolean equals = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(uri.getQueryParameter("read_only"));
                String queryParameter2 = uri.getQueryParameter("expiration");
                long parseLong = queryParameter2 != null ? Long.parseLong(queryParameter2) : 0L;
                Bundle bundle = new Bundle();
                for (String str3 : com.google.android.gms.ads.internal.zzbv.zzec().zzh(uri)) {
                    if (str3.startsWith("tag.")) {
                        bundle.putString(str3.substring(4), uri.getQueryParameter(str3));
                    }
                }
                return new zzie(queryParameter, parseLong, host, str, str2, bundle, equals, 0L);
            }
            return null;
        } catch (NullPointerException | NumberFormatException e) {
            zzafx.zzc("Unable to parse Uri into cache offering.", e);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = com.google.android.gms.common.internal.safeparcel.zzd.zze(parcel);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 2, this.url, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 3, this.zzbak);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 4, this.zzbal, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 5, this.zzbam, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 6, this.zzban, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 7, this.zzbao, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 8, this.zzbap);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 9, this.zzbaq);
        com.google.android.gms.common.internal.safeparcel.zzd.zzai(parcel, zze);
    }
}

package com.facebook.ads.internal.server;

import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import java.util.Locale;
/* loaded from: classes.dex */
public enum AdPlacementType {
    UNKNOWN("unknown"),
    BANNER("banner"),
    INTERSTITIAL("interstitial"),
    NATIVE(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE),
    INSTREAM("instream"),
    REWARDED_VIDEO("rewarded_video");
    

    /* renamed from: a  reason: collision with root package name */
    private String f1453a;

    AdPlacementType(String str) {
        this.f1453a = str;
    }

    public static AdPlacementType fromString(String str) {
        if (TextUtils.isEmpty(str)) {
            return UNKNOWN;
        }
        try {
            return valueOf(str.toUpperCase(Locale.US));
        } catch (Exception e) {
            return UNKNOWN;
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f1453a;
    }
}

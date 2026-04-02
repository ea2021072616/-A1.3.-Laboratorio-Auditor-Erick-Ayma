package com.facebook.ads.internal;

import com.facebook.ads.AdError;
/* loaded from: classes.dex */
public enum AdErrorType {
    UNKNOWN_ERROR(-1, "unknown error", false),
    NETWORK_ERROR(1000, "Network Error", true),
    NO_FILL(1001, "No Fill", true),
    LOAD_TOO_FREQUENTLY(1002, "Ad was re-loaded too frequently", true),
    DISABLED_APP(1005, "App is disabled from making ad requests", true),
    SERVER_ERROR(2000, "Server Error", true),
    INTERNAL_ERROR(AdError.INTERNAL_ERROR_CODE, "Internal Error", true),
    START_BEFORE_INIT(2004, "initAd must be called before startAd", true),
    AD_REQUEST_FAILED(1111, "Facebook Ads SDK request for ads failed", false),
    AD_REQUEST_TIMEOUT(1112, "Facebook Ads SDK request for ads timed out", false),
    PARSER_FAILURE(1201, "Failed to parse Facebook Ads SDK delivery response", false),
    UNKNOWN_RESPONSE(1202, "Unknown Facebook Ads SDK delivery response type", false),
    ERROR_MESSAGE(1203, "Facebook Ads SDK delivery response Error message", true),
    NO_AD_PLACEMENT(1302, "Facebook Ads SDK returned no ad placements", false);
    

    /* renamed from: a  reason: collision with root package name */
    private final int f1110a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1111b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f1112c;

    AdErrorType(int i, String str, boolean z) {
        this.f1110a = i;
        this.f1111b = str;
        this.f1112c = z;
    }

    public static AdErrorType adErrorTypeFromCode(int i) {
        return adErrorTypeFromCode(i, UNKNOWN_ERROR);
    }

    public static AdErrorType adErrorTypeFromCode(int i, AdErrorType adErrorType) {
        AdErrorType[] values;
        for (AdErrorType adErrorType2 : values()) {
            if (adErrorType2.getErrorCode() == i) {
                return adErrorType2;
            }
        }
        return adErrorType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.f1112c;
    }

    public AdError getAdError(String str) {
        return new b(this, str).b();
    }

    public b getAdErrorWrapper(String str) {
        return new b(this, str);
    }

    public String getDefaultErrorMessage() {
        return this.f1111b;
    }

    public int getErrorCode() {
        return this.f1110a;
    }
}

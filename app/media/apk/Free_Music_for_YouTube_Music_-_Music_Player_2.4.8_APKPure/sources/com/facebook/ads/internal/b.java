package com.facebook.ads.internal;

import android.text.TextUtils;
import com.facebook.ads.AdError;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final AdErrorType f1237a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1238b;

    public b(int i, String str) {
        this(AdErrorType.adErrorTypeFromCode(i), str);
    }

    public b(AdErrorType adErrorType, String str) {
        str = TextUtils.isEmpty(str) ? adErrorType.getDefaultErrorMessage() : str;
        this.f1237a = adErrorType;
        this.f1238b = str;
    }

    public AdErrorType a() {
        return this.f1237a;
    }

    public AdError b() {
        return this.f1237a.a() ? new AdError(this.f1237a.getErrorCode(), this.f1238b) : new AdError(AdErrorType.UNKNOWN_ERROR.getErrorCode(), AdErrorType.UNKNOWN_ERROR.getDefaultErrorMessage());
    }
}

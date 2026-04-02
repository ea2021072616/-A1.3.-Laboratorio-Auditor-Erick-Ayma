package com.google.android.gms.internal;

import com.google.ads.AdRequest;
/* loaded from: classes2.dex */
final /* synthetic */ class zzwm {
    private static /* synthetic */ int[] zzcdg;
    static final /* synthetic */ int[] zzcdh = new int[AdRequest.ErrorCode.values().length];

    static {
        try {
            zzcdh[AdRequest.ErrorCode.INTERNAL_ERROR.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            zzcdh[AdRequest.ErrorCode.INVALID_REQUEST.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            zzcdh[AdRequest.ErrorCode.NETWORK_ERROR.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            zzcdh[AdRequest.ErrorCode.NO_FILL.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        zzcdg = new int[AdRequest.Gender.values().length];
        try {
            zzcdg[AdRequest.Gender.FEMALE.ordinal()] = 1;
        } catch (NoSuchFieldError e5) {
        }
        try {
            zzcdg[AdRequest.Gender.MALE.ordinal()] = 2;
        } catch (NoSuchFieldError e6) {
        }
        try {
            zzcdg[AdRequest.Gender.UNKNOWN.ordinal()] = 3;
        } catch (NoSuchFieldError e7) {
        }
    }
}

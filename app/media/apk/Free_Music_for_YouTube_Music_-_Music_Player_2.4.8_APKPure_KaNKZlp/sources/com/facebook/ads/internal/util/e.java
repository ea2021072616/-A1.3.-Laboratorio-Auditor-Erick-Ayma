package com.facebook.ads.internal.util;

import android.text.TextUtils;
import java.util.Locale;
/* loaded from: classes.dex */
public enum e {
    NONE,
    INSTALLED,
    NOT_INSTALLED;

    public static e a(String str) {
        if (TextUtils.isEmpty(str)) {
            return NONE;
        }
        try {
            return valueOf(str.toUpperCase(Locale.US));
        } catch (IllegalArgumentException e) {
            return NONE;
        }
    }
}

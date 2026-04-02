package com.github.appintro.internal;

import android.content.Context;
import android.graphics.Typeface;
import e4.e;
import j4.c;
import j4.i;
import java.util.HashMap;
import y.n;
/* loaded from: classes.dex */
public final class CustomFontCache {
    public static final CustomFontCache INSTANCE = new CustomFontCache();
    private static final String TAG;
    private static final HashMap<String, Typeface> cache;

    static {
        LogHelper logHelper = LogHelper.INSTANCE;
        i.f3523a.getClass();
        TAG = logHelper.makeLogTag(new c(CustomFontCache.class));
        cache = new HashMap<>();
    }

    private CustomFontCache() {
    }

    public final void getFont(Context context, String str, n nVar) {
        e.f(context, "ctx");
        e.f(nVar, "fontCallback");
        if (str == null || str.length() == 0) {
            LogHelper.w$default(TAG, "Empty typeface path provided!", null, 4, null);
            return;
        }
        HashMap<String, Typeface> hashMap = cache;
        Typeface typeface = hashMap.get(str);
        if (typeface != null) {
            nVar.onFontRetrieved(typeface);
            return;
        }
        Typeface createFromAsset = Typeface.createFromAsset(context.getAssets(), str);
        e.e(createFromAsset, "newTypeface");
        hashMap.put(str, createFromAsset);
        nVar.onFontRetrieved(createFromAsset);
    }
}

package com.github.appintro.internal;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import e4.e;
/* loaded from: classes.dex */
public final class LayoutUtil {
    public static final LayoutUtil INSTANCE = new LayoutUtil();

    private LayoutUtil() {
    }

    public static final boolean isRtl(Context context) {
        e.f(context, "ctx");
        Resources resources = context.getResources();
        e.e(resources, "ctx.resources");
        Configuration configuration = resources.getConfiguration();
        e.e(configuration, "ctx.resources.configuration");
        return configuration.getLayoutDirection() == 1;
    }
}

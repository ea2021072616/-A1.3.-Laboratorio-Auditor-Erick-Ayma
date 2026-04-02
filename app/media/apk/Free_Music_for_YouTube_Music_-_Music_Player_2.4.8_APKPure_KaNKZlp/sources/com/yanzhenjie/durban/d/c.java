package com.yanzhenjie.durban.d;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import java.util.Locale;
/* compiled from: DurbanUtils.java */
/* loaded from: classes2.dex */
public class c {
    public static Context a(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        if (Build.VERSION.SDK_INT >= 24) {
            configuration.setLocale(locale);
            return context.createConfigurationContext(configuration);
        }
        configuration.locale = locale;
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return context;
    }
}

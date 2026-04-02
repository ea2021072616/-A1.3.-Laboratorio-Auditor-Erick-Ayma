package com.fotoable.youtube.music.quicktools.a;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.appevents.AppEventsConstants;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* compiled from: DeviceUtil.java */
/* loaded from: classes.dex */
public class a {
    public static boolean a(Context context) {
        boolean z;
        Exception exc;
        boolean z2;
        try {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            z2 = identifier > 0 ? resources.getBoolean(identifier) : false;
        } catch (Exception e) {
            z = false;
            exc = e;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod("get", String.class).invoke(cls, "qemu.hw.mainkeys");
            if (AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(str)) {
                return false;
            }
            if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str)) {
                return true;
            }
            return z2;
        } catch (Exception e2) {
            exc = e2;
            z = z2;
            ThrowableExtension.printStackTrace(exc);
            return z;
        }
    }
}

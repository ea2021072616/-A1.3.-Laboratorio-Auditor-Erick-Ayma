package com.facebook.ads.internal.util;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.util.Log;
import android.view.Window;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class al {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1509a = al.class.getSimpleName();

    private al() {
    }

    public static Map<String, String> a(Context context) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("kgr", String.valueOf(b(context)));
            if (context == null || !(context instanceof Activity)) {
                Log.v(f1509a, "Invalid Activity context in window interactive check, assuming interactive.");
            } else {
                Window window = ((Activity) context).getWindow();
                if (window != null) {
                    int i = window.getAttributes().flags;
                    hashMap.put("wt", Integer.toString(window.getAttributes().type));
                    hashMap.put("wfdkg", (4194304 & i) > 0 ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    hashMap.put("wfswl", (524288 & i) > 0 ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
                } else {
                    Log.v(f1509a, "Invalid window in window interactive check, assuming interactive.");
                }
            }
        } catch (Exception e) {
            Log.e(f1509a, "Exception in window info check", e);
            n.a(e, context);
        }
        return hashMap;
    }

    public static boolean a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            Log.v(f1509a, "Invalid Window info in window interactive check, assuming not obstructed by Keyguard.");
            return false;
        }
        String str = map.get("wfdkg");
        String str2 = map.get("wfswl");
        if (str == null || !str.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
            if (str2 == null || !str2.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
                String str3 = map.get("kgr");
                return str3 != null && str3.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            }
            return false;
        }
        return false;
    }

    public static boolean b(Context context) {
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
        return keyguardManager != null && keyguardManager.inKeyguardRestrictedInputMode();
    }

    public static boolean b(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            Log.v(f1509a, "Invalid Window info in window interactive check, assuming is not a Lockscreen.");
            return false;
        }
        String str = map.get("wfdkg");
        String str2 = map.get("wfswl");
        String str3 = map.get("kgr");
        return str != null && str.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES) && str2 != null && str2.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES) && str3 != null && str3.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
    }

    public static boolean c(Context context) {
        return !a(a(context));
    }
}

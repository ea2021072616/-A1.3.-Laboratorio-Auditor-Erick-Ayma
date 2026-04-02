package com.google.android.gms.internal.play_billing;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.android.billingclient.api.Purchase;
import org.json.JSONException;
/* loaded from: classes.dex */
public abstract class s {

    /* renamed from: a  reason: collision with root package name */
    public static final int f1952a = Runtime.getRuntime().availableProcessors();

    public static int a(String str, Bundle bundle) {
        if (bundle == null) {
            e(str, "Unexpected null bundle received!");
            return 6;
        }
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            d(str, "getResponseCodeFromBundle() got null response code, assuming OK");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            e(str, "Unexpected type for bundle response code: ".concat(obj.getClass().getName()));
            return 6;
        }
    }

    public static h1.g b(Intent intent, String str) {
        if (intent != null) {
            h1.g b5 = h1.g.b();
            b5.f3283b = a(str, intent.getExtras());
            b5.f3284c = c(str, intent.getExtras());
            return b5.a();
        }
        e("BillingHelper", "Got null intent!");
        h1.g b6 = h1.g.b();
        b6.f3283b = 6;
        b6.f3284c = "An internal error occurred.";
        return b6.a();
    }

    public static String c(String str, Bundle bundle) {
        if (bundle == null) {
            e(str, "Unexpected null bundle received!");
            return "";
        }
        Object obj = bundle.get("DEBUG_MESSAGE");
        if (obj == null) {
            d(str, "getDebugMessageFromBundle() got null response code, assuming OK");
            return "";
        } else if (obj instanceof String) {
            return (String) obj;
        } else {
            e(str, "Unexpected type for debug message: ".concat(obj.getClass().getName()));
            return "";
        }
    }

    public static void d(String str, String str2) {
        if (Log.isLoggable(str, 2)) {
            if (str2.isEmpty()) {
                Log.v(str, str2);
                return;
            }
            int i5 = 40000;
            while (!str2.isEmpty() && i5 > 0) {
                int min = Math.min(str2.length(), Math.min(4000, i5));
                Log.v(str, str2.substring(0, min));
                str2 = str2.substring(min);
                i5 -= min;
            }
        }
    }

    public static void e(String str, String str2) {
        if (Log.isLoggable(str, 5)) {
            Log.w(str, str2);
        }
    }

    public static void f(String str, String str2, Throwable th) {
        if (Log.isLoggable(str, 5)) {
            Log.w(str, str2, th);
        }
    }

    public static Purchase g(String str, String str2) {
        if (str == null || str2 == null) {
            d("BillingHelper", "Received a null purchase data.");
            return null;
        }
        try {
            return new Purchase(str, str2);
        } catch (JSONException e5) {
            e("BillingHelper", "Got JSONException while parsing purchase data: ".concat(e5.toString()));
            return null;
        }
    }
}

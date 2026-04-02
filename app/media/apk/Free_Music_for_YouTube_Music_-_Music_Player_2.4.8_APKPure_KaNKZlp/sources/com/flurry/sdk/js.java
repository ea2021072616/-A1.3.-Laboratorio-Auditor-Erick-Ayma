package com.flurry.sdk;

import android.telephony.TelephonyManager;
import com.facebook.places.model.PlaceFields;
/* loaded from: classes.dex */
public class js {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2004a = js.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static js f2005b;

    private js() {
    }

    public static synchronized js a() {
        js jsVar;
        synchronized (js.class) {
            if (f2005b == null) {
                f2005b = new js();
            }
            jsVar = f2005b;
        }
        return jsVar;
    }

    public static String b() {
        TelephonyManager telephonyManager = (TelephonyManager) jy.a().f2022a.getSystemService(PlaceFields.PHONE);
        if (telephonyManager == null) {
            return null;
        }
        return telephonyManager.getNetworkOperatorName();
    }

    public static String c() {
        TelephonyManager telephonyManager = (TelephonyManager) jy.a().f2022a.getSystemService(PlaceFields.PHONE);
        if (telephonyManager == null) {
            return null;
        }
        return telephonyManager.getNetworkOperator();
    }
}

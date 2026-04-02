package b.a.a.a.a.b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
/* compiled from: ApiKey.java */
/* loaded from: classes.dex */
public class g {
    public String a(Context context) {
        String b2 = b(context);
        if (TextUtils.isEmpty(b2)) {
            b2 = c(context);
        }
        if (TextUtils.isEmpty(b2)) {
            d(context);
        }
        return b2;
    }

    protected String b(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null) {
                return null;
            }
            String string = bundle.getString("io.fabric.ApiKey");
            if (string == null) {
                b.a.a.a.c.h().a("Fabric", "Falling back to Crashlytics key lookup from Manifest");
                return bundle.getString("com.crashlytics.ApiKey");
            }
            return string;
        } catch (Exception e) {
            b.a.a.a.c.h().a("Fabric", "Caught non-fatal exception while retrieving apiKey: " + e);
            return null;
        }
    }

    protected String c(Context context) {
        int a2 = i.a(context, "io.fabric.ApiKey", "string");
        if (a2 == 0) {
            b.a.a.a.c.h().a("Fabric", "Falling back to Crashlytics key lookup from Strings");
            a2 = i.a(context, "com.crashlytics.ApiKey", "string");
        }
        if (a2 == 0) {
            return null;
        }
        return context.getResources().getString(a2);
    }

    protected void d(Context context) {
        if (b.a.a.a.c.i() || i.i(context)) {
            throw new IllegalArgumentException(a());
        }
        b.a.a.a.c.h().e("Fabric", a());
    }

    protected String a() {
        return "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>";
    }
}

package com.facebook.ads.internal.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class f {

    /* loaded from: classes.dex */
    public interface a {
        String B();

        e D();

        Collection<String> E();
    }

    public static Collection<String> a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        HashSet hashSet = new HashSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            hashSet.add(jSONArray.optString(i));
        }
        return hashSet;
    }

    public static boolean a(Context context, a aVar) {
        Collection<String> E;
        boolean z;
        e D = aVar.D();
        if (D == null || D == e.NONE || (E = aVar.E()) == null || E.isEmpty()) {
            return false;
        }
        Iterator<String> it = E.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (a(context, it.next())) {
                z = true;
                break;
            }
        }
        if (z == (D == e.INSTALLED)) {
            String B = aVar.B();
            if (TextUtils.isEmpty(B)) {
                return true;
            }
            com.facebook.ads.internal.g.g.a(context).f(B, null);
            return true;
        }
        return false;
    }

    public static boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        } catch (RuntimeException e2) {
            return false;
        }
    }
}

package com.facebook.ads.internal.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1139a = b.class.getSimpleName();

    public static a a(Context context, String str, Uri uri, Map<String, String> map) {
        String authority = uri.getAuthority();
        String queryParameter = uri.getQueryParameter("video_url");
        if (!TextUtils.isEmpty(uri.getQueryParameter(ShareConstants.WEB_DIALOG_PARAM_DATA))) {
            try {
                JSONObject jSONObject = new JSONObject(uri.getQueryParameter(ShareConstants.WEB_DIALOG_PARAM_DATA));
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    map.put(next, jSONObject.getString(next));
                }
            } catch (JSONException e) {
                Log.w(f1139a, "Unable to parse json data in AdActionFactory.", e);
            }
        }
        char c2 = 65535;
        switch (authority.hashCode()) {
            case -1458789996:
                if (authority.equals("passthrough")) {
                    c2 = 2;
                    break;
                }
                break;
            case 109770977:
                if (authority.equals("store")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1546100943:
                if (authority.equals("open_link")) {
                    c2 = 1;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                if (queryParameter != null) {
                    return null;
                }
                return new c(context, str, uri, map);
            case 1:
                return new d(context, str, uri, map);
            case 2:
                return new e(context, str, uri, map);
            default:
                return new f(context, str, uri);
        }
    }

    public static boolean a(String str) {
        return "store".equalsIgnoreCase(str) || "open_link".equalsIgnoreCase(str);
    }
}

package com.facebook.ads.internal.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.internal.util.b;
import com.facebook.ads.internal.util.g;
import com.facebook.ads.internal.util.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1140a = c.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final Context f1141b;

    /* renamed from: c  reason: collision with root package name */
    private final String f1142c;
    private final Uri d;
    private final Map<String, String> e;

    public c(Context context, String str, Uri uri, Map<String, String> map) {
        this.f1141b = context;
        this.f1142c = str;
        this.d = uri;
        this.e = map;
    }

    private Intent a(i iVar) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        if (!TextUtils.isEmpty(iVar.a()) && !TextUtils.isEmpty(iVar.b())) {
            intent.setComponent(new ComponentName(iVar.a(), iVar.b()));
        }
        if (!TextUtils.isEmpty(iVar.c())) {
            intent.setData(Uri.parse(iVar.c()));
        }
        return intent;
    }

    private Intent b(i iVar) {
        if (!TextUtils.isEmpty(iVar.a()) && com.facebook.ads.internal.util.f.a(this.f1141b, iVar.a())) {
            String c2 = iVar.c();
            if (TextUtils.isEmpty(c2) || !(c2.startsWith("tel:") || c2.startsWith("telprompt:"))) {
                PackageManager packageManager = this.f1141b.getPackageManager();
                if (TextUtils.isEmpty(iVar.b()) && TextUtils.isEmpty(c2)) {
                    return packageManager.getLaunchIntentForPackage(iVar.a());
                }
                Intent a2 = a(iVar);
                List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(a2, 65536);
                if (a2.getComponent() == null) {
                    Iterator<ResolveInfo> it = queryIntentActivities.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ResolveInfo next = it.next();
                        if (next.activityInfo.packageName.equals(iVar.a())) {
                            a2.setComponent(new ComponentName(next.activityInfo.packageName, next.activityInfo.name));
                            break;
                        }
                    }
                }
                if (queryIntentActivities.isEmpty() || a2.getComponent() == null) {
                    return null;
                }
                return a2;
            }
            return new Intent("android.intent.action.CALL", Uri.parse(c2));
        }
        return null;
    }

    private List<i> f() {
        String queryParameter = this.d.getQueryParameter("appsite_data");
        if (TextUtils.isEmpty(queryParameter) || "[]".equals(queryParameter)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray optJSONArray = new JSONObject(queryParameter).optJSONArray("android");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    i a2 = i.a(optJSONArray.optJSONObject(i));
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
                return arrayList;
            }
            return arrayList;
        } catch (JSONException e) {
            Log.w(f1140a, "Error parsing appsite_data", e);
            return arrayList;
        }
    }

    @Override // com.facebook.ads.internal.a.a
    public b.a a() {
        return b.a.OPEN_STORE;
    }

    @Override // com.facebook.ads.internal.a.a
    public void b() {
        a(this.f1141b, this.f1142c, this.e);
        List<Intent> d = d();
        if (d != null) {
            for (Intent intent : d) {
                try {
                    this.f1141b.startActivity(intent);
                    return;
                } catch (Exception e) {
                    Log.d(f1140a, "Failed to open app intent, falling back", e);
                }
            }
        }
        e();
    }

    protected Uri c() {
        String queryParameter = this.d.getQueryParameter("store_url");
        return !TextUtils.isEmpty(queryParameter) ? Uri.parse(queryParameter) : Uri.parse(String.format("market://details?id=%s", this.d.getQueryParameter("store_id")));
    }

    protected List<Intent> d() {
        List<i> f = f();
        ArrayList arrayList = new ArrayList();
        if (f != null) {
            for (i iVar : f) {
                Intent b2 = b(iVar);
                if (b2 != null) {
                    arrayList.add(b2);
                }
            }
        }
        return arrayList;
    }

    public void e() {
        try {
            g.a(this.f1141b, c(), this.f1142c);
        } catch (Exception e) {
            Log.d(f1140a, "Failed to open market url: " + this.d.toString(), e);
            String queryParameter = this.d.getQueryParameter("store_url_web_fallback");
            if (queryParameter == null || queryParameter.length() <= 0) {
                return;
            }
            try {
                g.a(this.f1141b, Uri.parse(queryParameter), this.f1142c);
            } catch (Exception e2) {
                Log.d(f1140a, "Failed to open fallback url: " + queryParameter, e2);
            }
        }
    }
}

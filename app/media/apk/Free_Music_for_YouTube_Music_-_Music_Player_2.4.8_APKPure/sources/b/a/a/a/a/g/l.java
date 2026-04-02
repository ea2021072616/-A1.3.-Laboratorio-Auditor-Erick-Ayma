package b.a.a.a.a.g;

import com.facebook.share.internal.ShareConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultSettingsSpiCall.java */
/* loaded from: classes.dex */
public class l extends b.a.a.a.a.b.a implements x {
    public l(b.a.a.a.i iVar, String str, String str2, b.a.a.a.a.e.e eVar) {
        this(iVar, str, str2, eVar, b.a.a.a.a.e.c.GET);
    }

    l(b.a.a.a.i iVar, String str, String str2, b.a.a.a.a.e.e eVar, b.a.a.a.a.e.c cVar) {
        super(iVar, str, str2, eVar, cVar);
    }

    @Override // b.a.a.a.a.g.x
    public JSONObject a(w wVar) {
        b.a.a.a.a.e.d dVar = null;
        try {
            Map<String, String> b2 = b(wVar);
            dVar = a(getHttpRequest(b2), wVar);
            b.a.a.a.c.h().a("Fabric", "Requesting settings from " + getUrl());
            b.a.a.a.c.h().a("Fabric", "Settings query params were: " + b2);
            return a(dVar);
        } finally {
            if (dVar != null) {
                b.a.a.a.c.h().a("Fabric", "Settings request ID: " + dVar.b(b.a.a.a.a.b.a.HEADER_REQUEST_ID));
            }
        }
    }

    JSONObject a(b.a.a.a.a.e.d dVar) {
        int b2 = dVar.b();
        b.a.a.a.c.h().a("Fabric", "Settings result was: " + b2);
        if (a(b2)) {
            return a(dVar.e());
        }
        b.a.a.a.c.h().e("Fabric", "Failed to retrieve settings from " + getUrl());
        return null;
    }

    boolean a(int i) {
        return i == 200 || i == 201 || i == 202 || i == 203;
    }

    private JSONObject a(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e) {
            b.a.a.a.c.h().a("Fabric", "Failed to parse settings JSON from " + getUrl(), e);
            b.a.a.a.c.h().a("Fabric", "Settings response " + str);
            return null;
        }
    }

    private Map<String, String> b(w wVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("build_version", wVar.j);
        hashMap.put("display_version", wVar.i);
        hashMap.put(ShareConstants.FEED_SOURCE_PARAM, Integer.toString(wVar.k));
        if (wVar.l != null) {
            hashMap.put("icon_hash", wVar.l);
        }
        String str = wVar.h;
        if (!b.a.a.a.a.b.i.c(str)) {
            hashMap.put("instance", str);
        }
        return hashMap;
    }

    private b.a.a.a.a.e.d a(b.a.a.a.a.e.d dVar, w wVar) {
        a(dVar, b.a.a.a.a.b.a.HEADER_API_KEY, wVar.f253a);
        a(dVar, b.a.a.a.a.b.a.HEADER_CLIENT_TYPE, "android");
        a(dVar, b.a.a.a.a.b.a.HEADER_CLIENT_VERSION, this.kit.getVersion());
        a(dVar, b.a.a.a.a.b.a.HEADER_ACCEPT, b.a.a.a.a.b.a.ACCEPT_JSON_VALUE);
        a(dVar, "X-CRASHLYTICS-DEVICE-MODEL", wVar.f254b);
        a(dVar, "X-CRASHLYTICS-OS-BUILD-VERSION", wVar.f255c);
        a(dVar, "X-CRASHLYTICS-OS-DISPLAY-VERSION", wVar.d);
        a(dVar, "X-CRASHLYTICS-ADVERTISING-TOKEN", wVar.e);
        a(dVar, "X-CRASHLYTICS-INSTALLATION-ID", wVar.f);
        a(dVar, "X-CRASHLYTICS-ANDROID-ID", wVar.g);
        return dVar;
    }

    private void a(b.a.a.a.a.e.d dVar, String str, String str2) {
        if (str2 != null) {
            dVar.a(str, str2);
        }
    }
}

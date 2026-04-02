package com.facebook.ads.internal.f;

import android.content.Context;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.internal.server.AdPlacementType;
import com.facebook.ads.internal.util.al;
import com.facebook.ads.internal.util.o;
import com.facebook.ads.internal.util.s;
import com.facebook.ads.internal.util.w;
import com.facebook.appevents.AppEventsConstants;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class f {
    private static final ExecutorService g = Executors.newSingleThreadExecutor();
    private static String h = null;
    private static o.a i = o.a();

    /* renamed from: a  reason: collision with root package name */
    protected String f1333a;

    /* renamed from: b  reason: collision with root package name */
    protected AdPlacementType f1334b;

    /* renamed from: c  reason: collision with root package name */
    protected c f1335c;
    public Context d;
    public com.facebook.ads.internal.e e;
    public boolean f;
    private com.facebook.ads.internal.c j;
    private int k;
    private AdSize l;

    public f(Context context, String str, AdSize adSize, com.facebook.ads.internal.e eVar, com.facebook.ads.internal.c cVar, int i2, boolean z) {
        this.f1333a = str;
        this.l = adSize;
        this.e = eVar;
        this.f1335c = c.a(eVar);
        this.j = cVar;
        this.k = i2;
        this.f = z;
        a(context);
    }

    private void a(final Context context) {
        this.d = context;
        g.a();
        i.a(context);
        g();
        g.submit(new Runnable() { // from class: com.facebook.ads.internal.f.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (f.h == null) {
                    String unused = f.h = s.a(context, context.getPackageName());
                }
            }
        });
    }

    private void a(Map<String, String> map, String str, String str2) {
        map.put(str, str2);
    }

    private static Map<String, String> b(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("SDK", "android");
        hashMap.put("SDK_VERSION", "4.23.0");
        hashMap.put("LOCALE", Locale.getDefault().toString());
        float f = context.getResources().getDisplayMetrics().density;
        int i2 = context.getResources().getDisplayMetrics().widthPixels;
        int i3 = context.getResources().getDisplayMetrics().heightPixels;
        hashMap.put("DENSITY", String.valueOf(f));
        hashMap.put("SCREEN_WIDTH", String.valueOf((int) (i2 / f)));
        hashMap.put("SCREEN_HEIGHT", String.valueOf((int) (i3 / f)));
        hashMap.put("IDFA", i.o);
        hashMap.put("IDFA_FLAG", i.p ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES);
        hashMap.put("ATTRIBUTION_ID", i.n);
        hashMap.put("ID_SOURCE", i.q);
        hashMap.put("OS", "Android");
        hashMap.put("OSVERS", i.f1345a);
        hashMap.put("BUNDLE", i.d);
        hashMap.put("APPNAME", i.e);
        hashMap.put("APPVERS", i.f);
        hashMap.put("APPBUILD", String.valueOf(i.g));
        hashMap.put("CARRIER", i.i);
        hashMap.put("MAKE", i.f1346b);
        hashMap.put("MODEL", i.f1347c);
        hashMap.put("ROOTED", String.valueOf(i.d));
        hashMap.put("COPPA", String.valueOf(AdSettings.isChildDirected()));
        hashMap.put("INSTALLER", i.h);
        hashMap.put("SDK_CAPABILITY", com.facebook.ads.internal.d.b());
        hashMap.put("NETWORK_TYPE", String.valueOf(w.c(context).g));
        hashMap.put("REQUEST_TIME", com.facebook.ads.internal.util.g.a(System.currentTimeMillis()));
        hashMap.put("SESSION_TIME", com.facebook.ads.internal.util.g.a(g.b()));
        hashMap.put("SESSION_ID", g.c());
        return hashMap;
    }

    private void g() {
        if (this.f1335c == null) {
            this.f1335c = c.UNKNOWN;
        }
        switch (this.f1335c) {
            case INTERSTITIAL:
                this.f1334b = AdPlacementType.INTERSTITIAL;
                return;
            case BANNER:
                this.f1334b = AdPlacementType.BANNER;
                return;
            case NATIVE:
                this.f1334b = AdPlacementType.NATIVE;
                return;
            case REWARDED_VIDEO:
                this.f1334b = AdPlacementType.REWARDED_VIDEO;
                return;
            default:
                this.f1334b = AdPlacementType.UNKNOWN;
                return;
        }
    }

    public String a() {
        return this.f1333a;
    }

    public c b() {
        return this.f1335c;
    }

    public AdSize c() {
        return this.l;
    }

    public int d() {
        return this.k;
    }

    public Map<String, String> e() {
        HashMap hashMap = new HashMap();
        a(hashMap, "PLACEMENT_ID", this.f1333a);
        if (this.f1334b != AdPlacementType.UNKNOWN) {
            a(hashMap, "PLACEMENT_TYPE", this.f1334b.toString().toLowerCase());
        }
        for (Map.Entry<String, String> entry : b(this.d).entrySet()) {
            a(hashMap, entry.getKey(), entry.getValue());
        }
        if (this.l != null) {
            a(hashMap, "WIDTH", String.valueOf(this.l.getWidth()));
            a(hashMap, "HEIGHT", String.valueOf(this.l.getHeight()));
        }
        a(hashMap, "ADAPTERS", com.facebook.ads.internal.adapters.d.a(this.f1334b));
        if (this.e != null) {
            a(hashMap, "TEMPLATE_ID", String.valueOf(this.e.a()));
        }
        if (this.j != null) {
            a(hashMap, "REQUEST_TYPE", String.valueOf(this.j.a()));
        }
        if (this.f) {
            a(hashMap, "TEST_MODE", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
        if (AdSettings.getTestAdType() != AdSettings.TestAdType.DEFAULT) {
            a(hashMap, "DEMO_AD_ID", AdSettings.getTestAdType().getAdTypeString());
        }
        if (this.k != 0) {
            a(hashMap, "NUM_ADS_REQUESTED", String.valueOf(this.k));
        }
        String mediationService = AdSettings.getMediationService();
        if (mediationService != null) {
            a(hashMap, "MEDIATION_SERVICE", mediationService);
        }
        a(hashMap, "CLIENT_EVENTS", com.facebook.ads.internal.util.c.a());
        if (h != null) {
            a(hashMap, "AFP", h);
        }
        a(hashMap, "UNITY", String.valueOf(com.facebook.ads.internal.util.g.a(this.d)));
        a(hashMap, "KG_RESTRICTED", String.valueOf(al.b(this.d)));
        return hashMap;
    }
}

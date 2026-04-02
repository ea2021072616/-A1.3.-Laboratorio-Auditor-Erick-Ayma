package com.facebook.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.ads.NativeAdView;
import com.facebook.ads.internal.DisplayAdController;
import com.facebook.ads.internal.adapters.AdAdapter;
import com.facebook.ads.internal.adapters.u;
import com.facebook.ads.internal.adapters.v;
import com.facebook.ads.internal.adapters.w;
import com.facebook.ads.internal.f.e;
import com.facebook.ads.internal.h;
import com.facebook.ads.internal.j.a;
import com.facebook.ads.internal.server.AdPlacementType;
import com.facebook.ads.internal.util.af;
import com.facebook.ads.internal.util.ai;
import com.facebook.ads.internal.util.b;
import com.facebook.ads.internal.util.g;
import com.facebook.ads.internal.util.p;
import com.facebook.ads.internal.view.n;
import com.facebook.ads.internal.view.s;
import com.facebook.ads.internal.view.t;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.WeakHashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class NativeAd implements Ad {

    /* renamed from: b  reason: collision with root package name */
    private static final com.facebook.ads.internal.c f1062b = com.facebook.ads.internal.c.ADS;

    /* renamed from: c  reason: collision with root package name */
    private static final String f1063c = NativeAd.class.getSimpleName();
    private static WeakHashMap<View, WeakReference<NativeAd>> d = new WeakHashMap<>();
    private String A;
    private boolean B;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    protected v f1064a;
    private final Context e;
    private final String f;
    private final String g;
    private final com.facebook.ads.internal.c.b h;
    private AdListener i;
    private DisplayAdController j;
    private volatile boolean k;
    private e l;
    private View m;
    private final List<View> n;
    private View.OnTouchListener o;
    private com.facebook.ads.internal.j.a p;
    private final af q;
    @Nullable
    private u r;
    private a s;
    private b t;
    private t u;
    private NativeAdView.Type v;
    private boolean w;
    private MediaView x;
    @Deprecated
    private boolean y;
    private long z;

    /* loaded from: classes.dex */
    public static class Image {

        /* renamed from: a  reason: collision with root package name */
        private final String f1074a;

        /* renamed from: b  reason: collision with root package name */
        private final int f1075b;

        /* renamed from: c  reason: collision with root package name */
        private final int f1076c;

        public Image(String str, int i, int i2) {
            this.f1074a = str;
            this.f1075b = i;
            this.f1076c = i2;
        }

        public static Image fromJSONObject(JSONObject jSONObject) {
            String optString;
            if (jSONObject == null || (optString = jSONObject.optString("url")) == null) {
                return null;
            }
            return new Image(optString, jSONObject.optInt("width", 0), jSONObject.optInt("height", 0));
        }

        public int getHeight() {
            return this.f1076c;
        }

        public String getUrl() {
            return this.f1074a;
        }

        public int getWidth() {
            return this.f1075b;
        }
    }

    /* loaded from: classes.dex */
    public enum MediaCacheFlag {
        NONE(0),
        ICON(1),
        IMAGE(2),
        VIDEO(3);
        
        public static final EnumSet<MediaCacheFlag> ALL = EnumSet.allOf(MediaCacheFlag.class);

        /* renamed from: a  reason: collision with root package name */
        private final long f1078a;

        MediaCacheFlag(long j) {
            this.f1078a = j;
        }

        public long getCacheFlagValue() {
            return this.f1078a;
        }
    }

    /* loaded from: classes.dex */
    public static class Rating {

        /* renamed from: a  reason: collision with root package name */
        private final double f1079a;

        /* renamed from: b  reason: collision with root package name */
        private final double f1080b;

        public Rating(double d, double d2) {
            this.f1079a = d;
            this.f1080b = d2;
        }

        public static Rating fromJSONObject(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            double optDouble = jSONObject.optDouble("value", 0.0d);
            double optDouble2 = jSONObject.optDouble("scale", 0.0d);
            if (optDouble == 0.0d || optDouble2 == 0.0d) {
                return null;
            }
            return new Rating(optDouble, optDouble2);
        }

        public double getScale() {
            return this.f1080b;
        }

        public double getValue() {
            return this.f1079a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener, View.OnTouchListener {
        private a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!NativeAd.this.q.d()) {
                Log.e("FBAudienceNetworkLog", "No touch data recorded, please ensure touch events reach the ad View by returning false if you intercept the event.");
            }
            int k = h.k(NativeAd.this.e);
            if (k >= 0 && NativeAd.this.q.c() < k) {
                if (NativeAd.this.q.b()) {
                    Log.e("FBAudienceNetworkLog", "Clicks happened too fast.");
                } else {
                    Log.e("FBAudienceNetworkLog", "Ad cannot be clicked before it is viewed.");
                }
            } else if (!(view instanceof AdChoicesView) && NativeAd.this.q.a(h.l(NativeAd.this.e))) {
                Log.e("FBAudienceNetworkLog", "Clicks are too close to the border of the view.");
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put("touch", g.a(NativeAd.this.q.e()));
                if (NativeAd.this.v != null) {
                    hashMap.put("nti", String.valueOf(NativeAd.this.v.getValue()));
                }
                if (NativeAd.this.w) {
                    hashMap.put("nhs", String.valueOf(NativeAd.this.w));
                }
                NativeAd.this.p.a(hashMap);
                NativeAd.this.f1064a.b(hashMap);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            NativeAd.this.q.a(motionEvent, NativeAd.this.m, view);
            return NativeAd.this.o != null && NativeAd.this.o.onTouch(view, motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BroadcastReceiver {

        /* renamed from: b  reason: collision with root package name */
        private boolean f1083b;

        private b() {
        }

        public void a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.facebook.ads.native.impression:" + NativeAd.this.g);
            intentFilter.addAction("com.facebook.ads.native.click:" + NativeAd.this.g);
            LocalBroadcastManager.getInstance(NativeAd.this.e).registerReceiver(this, intentFilter);
            this.f1083b = true;
        }

        public void b() {
            if (this.f1083b) {
                try {
                    LocalBroadcastManager.getInstance(NativeAd.this.e).unregisterReceiver(this);
                } catch (Exception e) {
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str = intent.getAction().split(":")[0];
            if ("com.facebook.ads.native.impression".equals(str) && NativeAd.this.r != null) {
                NativeAd.this.r.a();
            } else if (!"com.facebook.ads.native.click".equals(str) || NativeAd.this.f1064a == null) {
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put("mil", String.valueOf(true));
                NativeAd.this.f1064a.b(hashMap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends com.facebook.ads.internal.adapters.b {
        private c() {
        }

        @Override // com.facebook.ads.internal.adapters.b
        public boolean a() {
            return false;
        }

        @Override // com.facebook.ads.internal.adapters.b
        public void d() {
            if (NativeAd.this.i != null) {
                NativeAd.this.i.onLoggingImpression(NativeAd.this);
            }
        }

        @Override // com.facebook.ads.internal.adapters.b
        public void e() {
        }
    }

    public NativeAd(Context context, v vVar, e eVar) {
        this(context, null);
        this.l = eVar;
        this.k = true;
        this.f1064a = vVar;
    }

    public NativeAd(Context context, String str) {
        this.g = UUID.randomUUID().toString();
        this.n = new ArrayList();
        this.q = new af();
        this.B = false;
        this.e = context;
        this.f = str;
        this.h = new com.facebook.ads.internal.c.b(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NativeAd(NativeAd nativeAd) {
        this(nativeAd.e, null);
        this.l = nativeAd.l;
        this.k = true;
        this.f1064a = nativeAd.f1064a;
    }

    private void a(View view) {
        this.n.add(view);
        view.setOnClickListener(this.s);
        view.setOnTouchListener(this.s);
    }

    private void a(List<View> list, View view) {
        if ((view instanceof n) || (view instanceof AdChoicesView) || (view instanceof com.facebook.ads.internal.view.hscroll.b)) {
            return;
        }
        list.add(view);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(list, viewGroup.getChildAt(i));
            }
        }
    }

    public static void downloadAndDisplayImage(Image image, ImageView imageView) {
        if (image == null || imageView == null) {
            return;
        }
        new p(imageView).a(image.getUrl());
    }

    private int getMinViewabilityPercentage() {
        if (this.l != null) {
            return this.l.e();
        }
        if (this.j == null || this.j.a() == null) {
            return 1;
        }
        return this.j.a().e();
    }

    private int i() {
        if (this.l != null) {
            return this.l.f();
        }
        if (this.j == null || this.j.a() == null) {
            return 0;
        }
        return this.j.a().f();
    }

    private int j() {
        if (this.l != null) {
            return this.l.g();
        }
        if (this.f1064a != null) {
            return this.f1064a.i();
        }
        if (this.j == null || this.j.a() == null) {
            return 0;
        }
        return this.j.a().g();
    }

    private int k() {
        if (this.l != null) {
            return this.l.h();
        }
        if (this.f1064a != null) {
            return this.f1064a.j();
        }
        if (this.j == null || this.j.a() == null) {
            return 1000;
        }
        return this.j.a().h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l() {
        return f() == ai.UNKNOWN ? this.y : f() == ai.ON;
    }

    private void logExternalClick(String str) {
        if (this.f1064a == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("eil", String.valueOf(true));
        hashMap.put("eil_source", str);
        this.f1064a.b(hashMap);
    }

    private void logExternalImpression() {
        if (this.r == null) {
            return;
        }
        this.r.a();
    }

    private void m() {
        for (View view : this.n) {
            view.setOnClickListener(null);
            view.setOnTouchListener(null);
        }
        this.n.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.f1064a == null || !this.f1064a.c()) {
            return;
        }
        this.t = new b();
        this.t.a();
        this.r = new u(this.e, new com.facebook.ads.internal.adapters.b() { // from class: com.facebook.ads.NativeAd.4
            @Override // com.facebook.ads.internal.adapters.b
            public boolean a() {
                return true;
            }
        }, this.p, this.f1064a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.B) {
            this.r = new u(this.e, new c() { // from class: com.facebook.ads.NativeAd.5
                @Override // com.facebook.ads.internal.adapters.b
                public boolean b() {
                    return true;
                }

                @Override // com.facebook.ads.internal.adapters.b
                public String c() {
                    return NativeAd.this.A;
                }
            }, this.p, this.f1064a);
        }
    }

    private void registerExternalLogReceiver(String str) {
        this.B = true;
        this.A = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v a() {
        return this.f1064a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(MediaView mediaView) {
        this.x = mediaView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(NativeAdView.Type type) {
        this.v = type;
    }

    protected void a(w wVar) {
        this.f1064a.a(wVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.w = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        if (isAdLoaded()) {
            return this.f1064a.v();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        if (!isAdLoaded() || TextUtils.isEmpty(this.f1064a.w())) {
            return null;
        }
        return this.h.c(this.f1064a.w());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        if (isAdLoaded()) {
            return this.f1064a.x();
        }
        return null;
    }

    @Override // com.facebook.ads.Ad
    public void destroy() {
        if (this.t != null) {
            this.t.b();
            this.t = null;
        }
        if (this.j != null) {
            this.j.d();
            this.j = null;
        }
        if (this.x != null) {
            this.x.destroy();
            this.x = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String e() {
        if (isAdLoaded()) {
            return this.f1064a.z();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai f() {
        return !isAdLoaded() ? ai.UNKNOWN : this.f1064a.y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<NativeAd> g() {
        if (isAdLoaded()) {
            return this.f1064a.A();
        }
        return null;
    }

    public String getAdBody() {
        if (isAdLoaded()) {
            return this.f1064a.p();
        }
        return null;
    }

    public String getAdCallToAction() {
        if (isAdLoaded()) {
            return this.f1064a.q();
        }
        return null;
    }

    public Image getAdChoicesIcon() {
        if (isAdLoaded()) {
            return this.f1064a.t();
        }
        return null;
    }

    public String getAdChoicesLinkUrl() {
        if (isAdLoaded()) {
            return this.f1064a.u();
        }
        return null;
    }

    public Image getAdCoverImage() {
        if (isAdLoaded()) {
            return this.f1064a.l();
        }
        return null;
    }

    public Image getAdIcon() {
        if (isAdLoaded()) {
            return this.f1064a.k();
        }
        return null;
    }

    @Nullable
    public AdNetwork getAdNetwork() {
        if (!isAdLoaded() || this.f1064a == null) {
            return null;
        }
        return this.f1064a.C();
    }

    public String getAdSocialContext() {
        if (isAdLoaded()) {
            return this.f1064a.r();
        }
        return null;
    }

    @Deprecated
    public Rating getAdStarRating() {
        if (isAdLoaded()) {
            return this.f1064a.s();
        }
        return null;
    }

    public String getAdSubtitle() {
        if (isAdLoaded()) {
            return this.f1064a.o();
        }
        return null;
    }

    public String getAdTitle() {
        if (isAdLoaded()) {
            return this.f1064a.n();
        }
        return null;
    }

    public NativeAdViewAttributes getAdViewAttributes() {
        if (isAdLoaded()) {
            return this.f1064a.m();
        }
        return null;
    }

    public String getId() {
        if (isAdLoaded()) {
            return this.g;
        }
        return null;
    }

    @Override // com.facebook.ads.Ad
    public String getPlacementId() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String h() {
        if (isAdLoaded()) {
            return this.f1064a.B();
        }
        return null;
    }

    public boolean isAdLoaded() {
        return this.f1064a != null && this.f1064a.b();
    }

    public boolean isNativeConfigEnabled() {
        return isAdLoaded() && this.f1064a.f();
    }

    @Override // com.facebook.ads.Ad
    public void loadAd() {
        loadAd(EnumSet.of(MediaCacheFlag.NONE));
    }

    public void loadAd(final EnumSet<MediaCacheFlag> enumSet) {
        if (this.k) {
            throw new IllegalStateException("loadAd cannot be called more than once");
        }
        this.z = System.currentTimeMillis();
        this.k = true;
        this.j = new DisplayAdController(this.e, this.f, com.facebook.ads.internal.e.NATIVE_UNKNOWN, AdPlacementType.NATIVE, null, f1062b, 1, true);
        this.j.a(new com.facebook.ads.internal.a() { // from class: com.facebook.ads.NativeAd.1
            @Override // com.facebook.ads.internal.a
            public void a() {
                if (NativeAd.this.i != null) {
                    NativeAd.this.i.onAdClicked(NativeAd.this);
                }
            }

            @Override // com.facebook.ads.internal.a
            public void a(AdAdapter adAdapter) {
                if (NativeAd.this.j != null) {
                    NativeAd.this.j.c();
                }
            }

            @Override // com.facebook.ads.internal.a
            public void a(final v vVar) {
                com.facebook.ads.internal.util.c.a(com.facebook.ads.internal.util.b.a(b.EnumC0041b.LOADING_AD, AdPlacementType.NATIVE, System.currentTimeMillis() - NativeAd.this.z, null));
                if (vVar == null) {
                    return;
                }
                if (enumSet.contains(MediaCacheFlag.ICON) && vVar.k() != null) {
                    NativeAd.this.h.a(vVar.k().getUrl());
                }
                if (enumSet.contains(MediaCacheFlag.IMAGE)) {
                    if (vVar.l() != null) {
                        NativeAd.this.h.a(vVar.l().getUrl());
                    }
                    if (vVar.A() != null) {
                        for (NativeAd nativeAd : vVar.A()) {
                            if (nativeAd.getAdCoverImage() != null) {
                                NativeAd.this.h.a(nativeAd.getAdCoverImage().getUrl());
                            }
                        }
                    }
                }
                if (enumSet.contains(MediaCacheFlag.VIDEO) && !TextUtils.isEmpty(vVar.w())) {
                    NativeAd.this.h.b(vVar.w());
                }
                NativeAd.this.h.a(new com.facebook.ads.internal.c.a() { // from class: com.facebook.ads.NativeAd.1.1
                    @Override // com.facebook.ads.internal.c.a
                    public void a() {
                        NativeAd.this.f1064a = vVar;
                        NativeAd.this.n();
                        NativeAd.this.o();
                        if (NativeAd.this.i != null) {
                            NativeAd.this.i.onAdLoaded(NativeAd.this);
                        }
                    }
                });
                if (NativeAd.this.i == null || vVar.A() == null) {
                    return;
                }
                w wVar = new w() { // from class: com.facebook.ads.NativeAd.1.2
                    @Override // com.facebook.ads.internal.adapters.w
                    public void a(v vVar2) {
                    }

                    @Override // com.facebook.ads.internal.adapters.w
                    public void a(v vVar2, AdError adError) {
                    }

                    @Override // com.facebook.ads.internal.adapters.w
                    public void b(v vVar2) {
                    }

                    @Override // com.facebook.ads.internal.adapters.w
                    public void c(v vVar2) {
                        if (NativeAd.this.i != null) {
                            NativeAd.this.i.onAdClicked(NativeAd.this);
                        }
                    }
                };
                for (NativeAd nativeAd2 : vVar.A()) {
                    nativeAd2.a(wVar);
                }
            }

            @Override // com.facebook.ads.internal.a
            public void a(com.facebook.ads.internal.b bVar) {
                if (NativeAd.this.i != null) {
                    NativeAd.this.i.onError(NativeAd.this, bVar.b());
                }
            }

            @Override // com.facebook.ads.internal.a
            public void b() {
                throw new IllegalStateException("Native ads manager their own impressions.");
            }
        });
        this.j.b();
    }

    public void registerViewForInteraction(View view) {
        ArrayList arrayList = new ArrayList();
        a(arrayList, view);
        registerViewForInteraction(view, arrayList);
    }

    public void registerViewForInteraction(View view, List<View> list) {
        if (view == null) {
            throw new IllegalArgumentException("Must provide a View");
        }
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("Invalid set of clickable views");
        }
        if (!isAdLoaded()) {
            Log.e(f1063c, "Ad not loaded");
            return;
        }
        if (this.m != null) {
            Log.w(f1063c, "Native Ad was already registered with a View. Auto unregistering and proceeding.");
            unregisterView();
        }
        if (d.containsKey(view)) {
            Log.w(f1063c, "View already registered with a NativeAd. Auto unregistering and proceeding.");
            d.get(view).get().unregisterView();
        }
        this.s = new a();
        this.m = view;
        if (view instanceof ViewGroup) {
            this.u = new t(view.getContext(), new s() { // from class: com.facebook.ads.NativeAd.2
                @Override // com.facebook.ads.internal.view.s
                public void a(int i) {
                    if (NativeAd.this.f1064a != null) {
                        NativeAd.this.f1064a.a(i);
                    }
                }
            });
            ((ViewGroup) view).addView(this.u);
        }
        for (View view2 : list) {
            a(view2);
        }
        this.f1064a.a(view, list);
        this.p = new com.facebook.ads.internal.j.a(this.m, getMinViewabilityPercentage(), i(), true, new a.AbstractC0038a() { // from class: com.facebook.ads.NativeAd.3
            @Override // com.facebook.ads.internal.j.a.AbstractC0038a
            public void a() {
                NativeAd.this.q.a();
                NativeAd.this.p.b();
                if (NativeAd.this.r == null) {
                    if (NativeAd.this.p != null) {
                        NativeAd.this.p.b();
                        NativeAd.this.p = null;
                        return;
                    }
                    return;
                }
                NativeAd.this.r.a(NativeAd.this.m);
                NativeAd.this.r.a(NativeAd.this.v);
                NativeAd.this.r.a(NativeAd.this.w);
                NativeAd.this.r.b(NativeAd.this.x != null);
                NativeAd.this.r.c(NativeAd.this.l());
                NativeAd.this.r.a();
            }
        });
        this.p.a(j());
        this.p.b(k());
        this.p.a();
        this.r = new u(this.e, new c(), this.p, this.f1064a);
        this.r.a(list);
        d.put(view, new WeakReference<>(this));
    }

    public void setAdListener(AdListener adListener) {
        this.i = adListener;
    }

    @Deprecated
    public void setMediaViewAutoplay(boolean z) {
        this.y = z;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.o = onTouchListener;
    }

    public void unregisterView() {
        if (this.m == null) {
            return;
        }
        if (!d.containsKey(this.m) || d.get(this.m).get() != this) {
            throw new IllegalStateException("View not registered with this NativeAd");
        }
        if ((this.m instanceof ViewGroup) && this.u != null) {
            ((ViewGroup) this.m).removeView(this.u);
            this.u = null;
        }
        if (this.f1064a != null) {
            this.f1064a.a();
        }
        d.remove(this.m);
        m();
        this.m = null;
        if (this.p != null) {
            this.p.b();
            this.p = null;
        }
        this.r = null;
    }
}

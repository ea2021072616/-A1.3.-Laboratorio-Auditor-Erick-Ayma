package com.facebook.ads.internal.util;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.facebook.ads.internal.b.c;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.NativeProtocol;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class ah implements ad<Bundle> {

    /* renamed from: a  reason: collision with root package name */
    private final String f1499a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1500b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f1501c;
    private final com.facebook.ads.internal.g.f d;
    private final a e;
    private final com.facebook.ads.internal.b.a f;
    private int g;
    private int h;
    private final aa i;

    /* loaded from: classes.dex */
    public interface a {
        boolean a();

        boolean b();

        boolean c();

        int getCurrentPosition();

        boolean getGlobalVisibleRect(Rect rect);

        long getInitialBufferTime();

        int getMeasuredHeight();

        int getMeasuredWidth();

        float getVolume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public enum b {
        PLAY(0),
        SKIP(1),
        TIME(2),
        MRC(3),
        PAUSE(4),
        RESUME(5),
        MUTE(6),
        UNMUTE(7),
        VIEWABLE_IMPRESSION(10);
        
        public final int j;

        b(int i) {
            this.j = i;
        }
    }

    public ah(Context context, com.facebook.ads.internal.g.f fVar, a aVar, String str) {
        this(context, fVar, aVar, str, null);
    }

    public ah(Context context, final com.facebook.ads.internal.g.f fVar, a aVar, final String str, @Nullable Bundle bundle) {
        this.f1500b = true;
        this.g = 0;
        this.h = 0;
        this.f1501c = context;
        this.d = fVar;
        this.e = aVar;
        this.f1499a = str;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.facebook.ads.internal.b.b(0.5d, -1.0d, 2.0d, true) { // from class: com.facebook.ads.internal.util.ah.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.ads.internal.b.b
            public void a(boolean z, boolean z2, com.facebook.ads.internal.b.c cVar) {
                fVar.c(str, ah.this.a(b.MRC));
            }
        });
        arrayList.add(new com.facebook.ads.internal.b.b(1.0E-7d, -1.0d, 0.001d, false) { // from class: com.facebook.ads.internal.util.ah.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.ads.internal.b.b
            public void a(boolean z, boolean z2, com.facebook.ads.internal.b.c cVar) {
                fVar.c(str, ah.this.a(b.VIEWABLE_IMPRESSION));
            }
        });
        if (bundle != null) {
            this.f = new com.facebook.ads.internal.b.a(context, (View) aVar, arrayList, bundle.getBundle("adQualityManager"));
            this.g = bundle.getInt("lastProgressTimeMS");
            this.h = bundle.getInt("lastBoundaryTimeMS");
        } else {
            this.f = new com.facebook.ads.internal.b.a(context, (View) aVar, arrayList);
        }
        this.i = new aa(new Handler(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> a(b bVar) {
        return a(bVar, this.e.getCurrentPosition());
    }

    private Map<String, String> a(b bVar, int i) {
        Map<String, String> c2 = c(i);
        c2.put(NativeProtocol.WEB_DIALOG_ACTION, String.valueOf(bVar.j));
        return c2;
    }

    private void a(int i, boolean z) {
        if (i <= 0.0d || i < this.g) {
            return;
        }
        if (i > this.g) {
            this.f.a((i - this.g) / 1000.0f, d());
            this.g = i;
            if (i - this.h >= 5000) {
                this.d.c(this.f1499a, a(b.TIME, i));
                this.h = this.g;
                this.f.a();
                return;
            }
        }
        if (z) {
            this.d.c(this.f1499a, a(b.TIME, i));
        }
    }

    private void a(Map<String, String> map) {
        map.put("exoplayer", String.valueOf(this.e.b()));
        map.put("prep", Long.toString(this.e.getInitialBufferTime()));
    }

    private void a(Map<String, String> map, int i) {
        map.put("ptime", String.valueOf(this.h / 1000.0f));
        map.put("time", String.valueOf(i / 1000.0f));
    }

    private void b(Map<String, String> map) {
        com.facebook.ads.internal.b.c b2 = this.f.b();
        c.a b3 = b2.b();
        map.put("vwa", String.valueOf(b3.c()));
        map.put("vwm", String.valueOf(b3.b()));
        map.put("vwmax", String.valueOf(b3.d()));
        map.put("vtime_ms", String.valueOf(b3.f() * 1000.0d));
        map.put("mcvt_ms", String.valueOf(b3.g() * 1000.0d));
        c.a c2 = b2.c();
        map.put("vla", String.valueOf(c2.c()));
        map.put("vlm", String.valueOf(c2.b()));
        map.put("vlmax", String.valueOf(c2.d()));
        map.put("atime_ms", String.valueOf(c2.f() * 1000.0d));
        map.put("mcat_ms", String.valueOf(c2.g() * 1000.0d));
    }

    private Map<String, String> c(int i) {
        HashMap hashMap = new HashMap();
        aj.a(hashMap, this.e.a(), !this.e.c());
        a(hashMap);
        b(hashMap);
        a(hashMap, i);
        c(hashMap);
        return hashMap;
    }

    private void c(Map<String, String> map) {
        Rect rect = new Rect();
        this.e.getGlobalVisibleRect(rect);
        map.put("pt", String.valueOf(rect.top));
        map.put("pl", String.valueOf(rect.left));
        map.put(UserDataStore.PHONE, String.valueOf(this.e.getMeasuredHeight()));
        map.put("pw", String.valueOf(this.e.getMeasuredWidth()));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.f1501c.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        map.put("vph", String.valueOf(displayMetrics.heightPixels));
        map.put("vpw", String.valueOf(displayMetrics.widthPixels));
    }

    public void a(int i) {
        a(i, false);
    }

    public void a(int i, int i2) {
        a(i, true);
        this.h = i2;
        this.g = i2;
        this.f.a();
    }

    public void b() {
        this.f1501c.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.i);
    }

    public void b(int i) {
        a(i, true);
        this.h = 0;
        this.g = 0;
        this.f.a();
    }

    public void c() {
        this.f1501c.getContentResolver().unregisterContentObserver(this.i);
    }

    protected float d() {
        return aj.a(this.f1501c) * this.e.getVolume();
    }

    public void e() {
        if (d() < 0.05d) {
            if (this.f1500b) {
                f();
                this.f1500b = false;
            }
        } else if (this.f1500b) {
        } else {
            g();
            this.f1500b = true;
        }
    }

    public void f() {
        this.d.c(this.f1499a, a(b.MUTE));
    }

    public void g() {
        this.d.c(this.f1499a, a(b.UNMUTE));
    }

    @Override // com.facebook.ads.internal.util.ad
    public Bundle getSaveInstanceState() {
        a(k(), k());
        Bundle bundle = new Bundle();
        bundle.putInt("lastProgressTimeMS", this.g);
        bundle.putInt("lastBoundaryTimeMS", this.h);
        bundle.putBundle("adQualityManager", this.f.getSaveInstanceState());
        return bundle;
    }

    public void h() {
        this.d.c(this.f1499a, a(b.SKIP));
    }

    public void i() {
        this.d.c(this.f1499a, a(b.PAUSE));
    }

    public void j() {
        this.d.c(this.f1499a, a(b.RESUME));
    }

    public int k() {
        return this.g;
    }
}

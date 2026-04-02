package b.a.a.a.a.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
/* compiled from: IdManager.java */
/* loaded from: classes.dex */
public class o {
    private static final Pattern d = Pattern.compile("[^\\p{Alnum}]");
    private static final String e = Pattern.quote("/");

    /* renamed from: a  reason: collision with root package name */
    c f115a;

    /* renamed from: b  reason: collision with root package name */
    b f116b;

    /* renamed from: c  reason: collision with root package name */
    boolean f117c;
    private final ReentrantLock f = new ReentrantLock();
    private final p g;
    private final boolean h;
    private final boolean i;
    private final Context j;
    private final String k;
    private final String l;
    private final Collection<b.a.a.a.i> m;

    /* compiled from: IdManager.java */
    /* loaded from: classes.dex */
    public enum a {
        WIFI_MAC_ADDRESS(1),
        BLUETOOTH_MAC_ADDRESS(2),
        FONT_TOKEN(53),
        ANDROID_ID(100),
        ANDROID_DEVICE_ID(101),
        ANDROID_SERIAL(102),
        ANDROID_ADVERTISING_ID(103);
        
        public final int h;

        a(int i2) {
            this.h = i2;
        }
    }

    public o(Context context, String str, String str2, Collection<b.a.a.a.i> collection) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        if (collection == null) {
            throw new IllegalArgumentException("kits must not be null");
        }
        this.j = context;
        this.k = str;
        this.l = str2;
        this.m = collection;
        this.g = new p();
        this.f115a = new c(context);
        this.h = i.a(context, "com.crashlytics.CollectDeviceIdentifiers", true);
        if (!this.h) {
            b.a.a.a.c.h().a("Fabric", "Device ID collection disabled for " + context.getPackageName());
        }
        this.i = i.a(context, "com.crashlytics.CollectUserIdentifiers", true);
        if (!this.i) {
            b.a.a.a.c.h().a("Fabric", "User information collection disabled for " + context.getPackageName());
        }
    }

    public boolean a() {
        return this.i;
    }

    private String a(String str) {
        if (str == null) {
            return null;
        }
        return d.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    public String b() {
        String str = this.l;
        if (str == null) {
            SharedPreferences a2 = i.a(this.j);
            String string = a2.getString("crashlytics.installation.id", null);
            if (string == null) {
                return a(a2);
            }
            return string;
        }
        return str;
    }

    public String c() {
        return this.k;
    }

    public String d() {
        return e() + "/" + f();
    }

    public String e() {
        return b(Build.VERSION.RELEASE);
    }

    public String f() {
        return b(Build.VERSION.INCREMENTAL);
    }

    public String g() {
        return String.format(Locale.US, "%s/%s", b(Build.MANUFACTURER), b(Build.MODEL));
    }

    private String b(String str) {
        return str.replaceAll(e, "");
    }

    public String h() {
        if (!this.h) {
            return "";
        }
        String n = n();
        if (n == null) {
            SharedPreferences a2 = i.a(this.j);
            String string = a2.getString("crashlytics.installation.id", null);
            if (string == null) {
                return a(a2);
            }
            return string;
        }
        return n;
    }

    private String a(SharedPreferences sharedPreferences) {
        this.f.lock();
        try {
            String string = sharedPreferences.getString("crashlytics.installation.id", null);
            if (string == null) {
                string = a(UUID.randomUUID().toString());
                sharedPreferences.edit().putString("crashlytics.installation.id", string).commit();
            }
            return string;
        } finally {
            this.f.unlock();
        }
    }

    public Map<a, String> i() {
        HashMap hashMap = new HashMap();
        for (b.a.a.a.i iVar : this.m) {
            if (iVar instanceof m) {
                for (Map.Entry<a, String> entry : ((m) iVar).getDeviceIdentifiers().entrySet()) {
                    a(hashMap, entry.getKey(), entry.getValue());
                }
            }
        }
        a(hashMap, a.ANDROID_ID, n());
        a(hashMap, a.ANDROID_ADVERTISING_ID, m());
        return Collections.unmodifiableMap(hashMap);
    }

    public String j() {
        return this.g.a(this.j);
    }

    synchronized b k() {
        if (!this.f117c) {
            this.f116b = this.f115a.a();
            this.f117c = true;
        }
        return this.f116b;
    }

    public Boolean l() {
        b k;
        if (!this.h || (k = k()) == null) {
            return null;
        }
        return Boolean.valueOf(k.f87b);
    }

    public String m() {
        b k;
        if (!this.h || (k = k()) == null) {
            return null;
        }
        return k.f86a;
    }

    private void a(Map<a, String> map, a aVar, String str) {
        if (str != null) {
            map.put(aVar, str);
        }
    }

    public String n() {
        if (!this.h) {
            return null;
        }
        String string = Settings.Secure.getString(this.j.getContentResolver(), "android_id");
        if ("9774d56d682e549c".equals(string)) {
            return null;
        }
        return a(string);
    }
}

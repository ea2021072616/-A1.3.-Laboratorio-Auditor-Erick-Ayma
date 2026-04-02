package com.flurry.sdk;

import android.provider.Settings;
import android.text.TextUtils;
import com.flurry.sdk.ll;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class jl {

    /* renamed from: b  reason: collision with root package name */
    private static final String f1978b = jl.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private static jl f1979c;

    /* renamed from: a  reason: collision with root package name */
    public final Map<jt, byte[]> f1980a;
    private final Set<String> d;
    private a e;
    private jv f;
    private String g;
    private final kh<ll> h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum a {
        NONE,
        ADVERTISING,
        DEVICE,
        REPORTED_IDS,
        FINISHED
    }

    private jl() {
        HashSet hashSet = new HashSet();
        hashSet.add("null");
        hashSet.add("9774d56d682e549c");
        hashSet.add("dead00beef");
        this.d = Collections.unmodifiableSet(hashSet);
        this.f1980a = new HashMap();
        this.e = a.NONE;
        this.h = new kh<ll>() { // from class: com.flurry.sdk.jl.1
            @Override // com.flurry.sdk.kh
            public final /* synthetic */ void a(ll llVar) {
                switch (AnonymousClass4.f1985a[llVar.f2154c - 1]) {
                    case 1:
                        if (!jl.this.b()) {
                            return;
                        }
                        jy.a().b(new ma() { // from class: com.flurry.sdk.jl.1.1
                            @Override // com.flurry.sdk.ma
                            public final void a() {
                                jl.this.d();
                            }
                        });
                        return;
                    default:
                        return;
                }
            }
        };
        ki.a().a("com.flurry.android.sdk.FlurrySessionEvent", this.h);
        jy.a().b(new ma() { // from class: com.flurry.sdk.jl.2
            @Override // com.flurry.sdk.ma
            public final void a() {
                jl.b(jl.this);
            }
        });
    }

    public static synchronized jl a() {
        jl jlVar;
        synchronized (jl.class) {
            if (f1979c == null) {
                f1979c = new jl();
            }
            jlVar = f1979c;
        }
        return jlVar;
    }

    public final boolean b() {
        return a.FINISHED.equals(this.e);
    }

    public final boolean c() {
        return this.f == null || !this.f.f2013b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.jl$4  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1985a;

        static {
            try {
                f1986b[a.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1986b[a.ADVERTISING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1986b[a.DEVICE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1986b[a.REPORTED_IDS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            f1985a = new int[ll.a.a().length];
            try {
                f1985a[ll.a.f2155a - 1] = 1;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        ly.b();
        this.f = e();
        if (b()) {
            h();
            ki.a().a(new jn());
        }
    }

    private static jv e() {
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(jy.a().f2022a);
            return new jv(advertisingIdInfo.getId(), advertisingIdInfo.isLimitAdTrackingEnabled());
        } catch (Exception e) {
            km.b(f1978b, "GOOGLE PLAY SERVICES ERROR: " + e.getMessage());
            km.b(f1978b, "There is a problem with the Google Play Services library, which is required for Android Advertising ID support. The Google Play Services library should be integrated in any app shipping in the Play Store that uses analytics or advertising.");
            return null;
        } catch (NoClassDefFoundError e2) {
            km.b(f1978b, "There is a problem with the Google Play Services library, which is required for Android Advertising ID support. The Google Play Services library should be integrated in any app shipping in the Play Store that uses analytics or advertising.");
            return null;
        }
    }

    private static void a(String str, File file) {
        DataOutputStream dataOutputStream;
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(1);
                dataOutputStream.writeUTF(str);
            } catch (Throwable th) {
                th = th;
                try {
                    km.a(6, f1978b, "Error when saving deviceId", th);
                } finally {
                    ly.a(dataOutputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            dataOutputStream = null;
        }
    }

    private static String f() {
        DataInputStream dataInputStream;
        File fileStreamPath = jy.a().f2022a.getFileStreamPath(".flurryb.");
        if (fileStreamPath != null && fileStreamPath.exists()) {
            try {
                dataInputStream = new DataInputStream(new FileInputStream(fileStreamPath));
            } catch (Throwable th) {
                th = th;
                dataInputStream = null;
            }
            try {
                r0 = 1 == dataInputStream.readInt() ? dataInputStream.readUTF() : null;
            } catch (Throwable th2) {
                th = th2;
                try {
                    km.a(6, f1978b, "Error when loading deviceId", th);
                    return r0;
                } finally {
                    ly.a((Closeable) dataInputStream);
                }
            }
        }
        return r0;
    }

    private String g() {
        String[] list;
        DataInputStream dataInputStream;
        String str = null;
        File filesDir = jy.a().f2022a.getFilesDir();
        if (filesDir != null && (list = filesDir.list(new FilenameFilter() { // from class: com.flurry.sdk.jl.3
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str2) {
                return str2.startsWith(".flurryagent.");
            }
        })) != null && list.length != 0) {
            File fileStreamPath = jy.a().f2022a.getFileStreamPath(list[0]);
            if (fileStreamPath != null && fileStreamPath.exists()) {
                try {
                    dataInputStream = new DataInputStream(new FileInputStream(fileStreamPath));
                    try {
                        if (46586 == dataInputStream.readUnsignedShort() && 2 == dataInputStream.readUnsignedShort()) {
                            dataInputStream.readUTF();
                            str = dataInputStream.readUTF();
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            km.a(6, f1978b, "Error when loading deviceId", th);
                            return str;
                        } finally {
                            ly.a((Closeable) dataInputStream);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    dataInputStream = null;
                }
            }
        }
        return str;
    }

    private void h() {
        String str;
        if (this.f == null) {
            str = null;
        } else {
            str = this.f.f2012a;
        }
        if (str != null) {
            km.a(3, f1978b, "Fetched advertising id");
            this.f1980a.put(jt.AndroidAdvertisingId, ly.d(str));
        }
        String str2 = this.g;
        if (str2 != null) {
            km.a(3, f1978b, "Fetched device id");
            this.f1980a.put(jt.DeviceId, ly.d(str2));
        }
    }

    static /* synthetic */ void b(jl jlVar) {
        String str;
        while (!a.FINISHED.equals(jlVar.e)) {
            switch (jlVar.e) {
                case NONE:
                    jlVar.e = a.ADVERTISING;
                    break;
                case ADVERTISING:
                    jlVar.e = a.DEVICE;
                    break;
                case DEVICE:
                    jlVar.e = a.REPORTED_IDS;
                    break;
                case REPORTED_IDS:
                    jlVar.e = a.FINISHED;
                    break;
            }
            try {
            } catch (Exception e) {
                km.a(4, f1978b, "Exception during id fetch:" + jlVar.e + ", " + e);
            }
            switch (jlVar.e) {
                case ADVERTISING:
                    jlVar.d();
                    continue;
                case DEVICE:
                    ly.b();
                    String string = Settings.Secure.getString(jy.a().f2022a.getContentResolver(), "android_id");
                    if (!((TextUtils.isEmpty(string) || jlVar.d.contains(string.toLowerCase(Locale.US))) ? false : true)) {
                        str = null;
                    } else {
                        str = "AND" + string;
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = f();
                        if (TextUtils.isEmpty(str)) {
                            str = jlVar.g();
                            if (TextUtils.isEmpty(str)) {
                                str = "ID" + Long.toString(Double.doubleToLongBits(Math.random()) + ((System.nanoTime() + (ly.i(lv.a(jy.a().f2022a)) * 37)) * 37), 16);
                            }
                            if (!TextUtils.isEmpty(str)) {
                                File fileStreamPath = jy.a().f2022a.getFileStreamPath(".flurryb.");
                                if (lx.a(fileStreamPath)) {
                                    a(str, fileStreamPath);
                                }
                            }
                        }
                    }
                    jlVar.g = str;
                    continue;
                    break;
                case REPORTED_IDS:
                    jlVar.h();
                    continue;
                default:
                    continue;
            }
            km.a(4, f1978b, "Exception during id fetch:" + jlVar.e + ", " + e);
        }
        ki.a().a(new jm());
    }
}

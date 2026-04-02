package com.fotoable.youtube.music.quicktools.settings;

import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.hardware.camera2.CameraManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.places.model.PlaceFields;
import com.fotoable.free.music.R;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.lang.reflect.Method;
import java.util.List;
/* compiled from: PhoneSettingsManager.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3132a = a.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static String f3133b = "WRITE_SETTINGS permission not granted!";

    /* renamed from: c  reason: collision with root package name */
    private static String f3134c = "CAMERA permission not granted!";
    private static String d = "The flash is not supported!";
    private static String e = "Calculator is not found!";
    private static String f = "Open calculator failed!";
    private InterfaceC0062a g;
    private WifiManager h;
    private LocationManager i;
    private ConnectivityManager j;
    private AudioManager k;
    private BluetoothAdapter l;
    private ContentResolver m;
    private CameraManager o;
    private boolean n = false;
    private boolean p = false;

    /* compiled from: PhoneSettingsManager.java */
    /* renamed from: com.fotoable.youtube.music.quicktools.settings.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0062a {
        void a(String str);
    }

    public a(InterfaceC0062a interfaceC0062a) {
        this.g = interfaceC0062a;
    }

    public void a(Context context) {
        f3133b = context.getResources().getString(R.string.msg_not_granted_write_settings);
        f3134c = context.getResources().getString(R.string.msg_not_granted_camera);
        d = context.getResources().getString(R.string.msg_no_flash_light);
        e = context.getResources().getString(R.string.msg_no_calculator);
        f = context.getResources().getString(R.string.msg_calculator_open_failed);
    }

    private WifiManager v(Context context) {
        if (this.h == null) {
            this.h = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        }
        return this.h;
    }

    private LocationManager w(Context context) {
        if (this.i == null) {
            this.i = (LocationManager) context.getApplicationContext().getSystemService(PlaceFields.LOCATION);
        }
        return this.i;
    }

    private ConnectivityManager x(Context context) {
        if (this.j == null) {
            this.j = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        }
        return this.j;
    }

    private AudioManager y(Context context) {
        if (this.k == null) {
            this.k = (AudioManager) context.getApplicationContext().getSystemService("audio");
        }
        return this.k;
    }

    private BluetoothAdapter e() {
        if (this.l == null) {
            this.l = BluetoothAdapter.getDefaultAdapter();
        }
        return this.l;
    }

    private ContentResolver z(Context context) {
        if (this.m == null) {
            this.m = context.getApplicationContext().getContentResolver();
        }
        return this.m;
    }

    private void a(String str) {
        if (this.g != null) {
            this.g.a(str);
        }
    }

    public boolean b(Context context) {
        boolean z = false;
        try {
            this.h = v(context);
            if (this.h.isWifiEnabled()) {
                z = this.h.setWifiEnabled(false);
            } else {
                z = this.h.setWifiEnabled(true);
            }
        } catch (Exception e2) {
            ThrowableExtension.printStackTrace(e2);
            Log.e(f3132a, "WIFI unavailable!");
        }
        return z;
    }

    public boolean c(Context context) {
        try {
            this.h = v(context);
            return this.h.isWifiEnabled();
        } catch (Exception e2) {
            ThrowableExtension.printStackTrace(e2);
            Log.e(f3132a, "WIFI unavailable!");
            return false;
        }
    }

    public void d(Context context) {
        try {
            Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e2) {
            ThrowableExtension.printStackTrace(e2);
        }
    }

    public boolean e(Context context) {
        try {
            this.i = w(context);
            return this.i.isProviderEnabled("gps");
        } catch (Exception e2) {
            ThrowableExtension.printStackTrace(e2);
            Log.e(f3132a, "GPS unavailable!");
            return false;
        }
    }

    public void f(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                Intent intent = new Intent("android.settings.DATA_ROAMING_SETTINGS");
                intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$DataUsageSummaryActivity"));
                intent.addFlags(268435456);
                context.startActivity(intent);
            } else {
                this.j = x(context);
                boolean g = g(context);
                Method method = this.j.getClass().getMethod("setMobileDataEnabled", Boolean.TYPE);
                method.setAccessible(true);
                ConnectivityManager connectivityManager = this.j;
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(g ? false : true);
                method.invoke(connectivityManager, objArr);
            }
        } catch (Exception e2) {
            ThrowableExtension.printStackTrace(e2);
            Log.e(f3132a, "Mobile Data unavailable!");
        }
    }

    public boolean g(Context context) {
        try {
            this.j = x(context);
            return ((Boolean) this.j.getClass().getMethod("getMobileDataEnabled", new Class[0]).invoke(this.j, new Object[0])).booleanValue();
        } catch (Exception e2) {
            ThrowableExtension.printStackTrace(e2);
            Log.e(f3132a, "Mobile Data unavailable!");
            return false;
        }
    }

    public void h(Context context) {
        try {
            this.k = y(context);
            switch (i(context)) {
                case 0:
                    this.k.setRingerMode(1);
                    break;
                case 1:
                    this.k.setRingerMode(2);
                    break;
                case 2:
                    this.k.setRingerMode(0);
                    break;
            }
        } catch (Exception e2) {
            ThrowableExtension.printStackTrace(e2);
            Log.e(f3132a, "Sound Mode unavailable!");
        }
    }

    public int i(Context context) {
        try {
            this.k = y(context);
            return this.k.getRingerMode();
        } catch (Exception e2) {
            ThrowableExtension.printStackTrace(e2);
            Log.e(f3132a, "Sound Mode unavailable!");
            return 0;
        }
    }

    private boolean A(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
    }

    public void j(Context context) {
        try {
            if (!A(context)) {
                a(d);
            } else if (Build.VERSION.SDK_INT >= 23) {
                this.o = B(context);
                this.o.setTorchMode(AppEventsConstants.EVENT_PARAM_VALUE_NO, !this.n);
                this.n = this.n ? false : true;
            } else if (Build.VERSION.SDK_INT >= 21) {
                if (!this.p) {
                    k(context);
                }
                this.n = this.n ? false : true;
                a(this.n);
            }
        } catch (Exception e2) {
            a();
            ThrowableExtension.printStackTrace(e2);
            Log.e(f3132a, "Flash Light unavailable!");
            a(f3134c);
        }
    }

    private CameraManager B(Context context) {
        if (this.o == null && Build.VERSION.SDK_INT >= 21) {
            this.o = (CameraManager) context.getApplicationContext().getSystemService("camera");
        }
        return this.o;
    }

    @RequiresApi(api = 21)
    public void k(Context context) throws Exception {
        if (ActivityCompat.checkSelfPermission(context, "android.permission.CAMERA") != 0) {
            a(f3134c);
            return;
        }
        a(d);
        this.p = true;
    }

    @RequiresApi(api = 21)
    public void a(boolean z) {
        if (!z) {
            try {
                a();
            } catch (Exception e2) {
                ThrowableExtension.printStackTrace(e2);
            }
        }
    }

    public boolean l(Context context) {
        try {
            if (A(context) && Build.VERSION.SDK_INT >= 21) {
                return this.n;
            }
            return false;
        } catch (Exception e2) {
            a();
            ThrowableExtension.printStackTrace(e2);
            Log.e(f3132a, "Flash Light unavailable!");
            return false;
        }
    }

    public void a() {
        if (Build.VERSION.SDK_INT < 23) {
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    this.p = false;
                    this.n = false;
                    return;
                }
                return;
            } catch (Exception e2) {
                ThrowableExtension.printStackTrace(e2);
                return;
            }
        }
        this.n = false;
    }

    public void b() {
        try {
            this.l = e();
            if (c()) {
                this.l.disable();
            } else {
                this.l.enable();
            }
        } catch (Exception e2) {
            ThrowableExtension.printStackTrace(e2);
            Log.e(f3132a, "Bluetooth unavailable!");
        }
    }

    public boolean c() {
        try {
            this.l = e();
            return 12 == this.l.getState();
        } catch (Exception e2) {
            ThrowableExtension.printStackTrace(e2);
            Log.e(f3132a, "Bluetooth unavailable!");
            return false;
        }
    }

    public void m(Context context) {
        try {
            boolean a2 = a(context, "com.android.calculator2");
            if (!a2) {
                a2 = a(context, "com.sec.android.app.popupcalculator");
            }
            if (!a2) {
                PackageInfo a3 = a(context, "Calculator", "calculator");
                if (a3 != null) {
                    context.startActivity(context.getPackageManager().getLaunchIntentForPackage(a3.packageName));
                } else {
                    a(e);
                }
            }
        } catch (Exception e2) {
            ThrowableExtension.printStackTrace(e2);
            a(f);
        }
    }

    private boolean a(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                launchIntentForPackage.setFlags(268435456);
                context.startActivity(launchIntentForPackage);
                return true;
            }
            return false;
        } catch (Exception e2) {
            ThrowableExtension.printStackTrace(e2);
            return false;
        }
    }

    private PackageInfo a(Context context, String str, String str2) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        for (int i = 0; i < installedPackages.size(); i++) {
            Log.e(f3132a, "==本机应用===" + installedPackages.get(i).packageName);
        }
        for (int i2 = 0; i2 < installedPackages.size(); i2++) {
            PackageInfo packageInfo = installedPackages.get(i2);
            if (packageInfo.packageName.contains("android") && (packageInfo.packageName.contains(str) || packageInfo.packageName.contains(str2))) {
                return packageInfo;
            }
        }
        return null;
    }

    public void a(Context context, int i) {
        try {
            this.m = z(context);
            if (Build.VERSION.SDK_INT >= 23 && !Settings.System.canWrite(context)) {
                Log.e(f3132a, f3133b);
            } else {
                Uri uriFor = Settings.System.getUriFor("screen_brightness");
                Settings.System.putInt(this.m, "screen_brightness", i);
                this.m.notifyChange(uriFor, null);
            }
        } catch (Exception e2) {
            ThrowableExtension.printStackTrace(e2);
            Log.e(f3132a, "Screen Brightness unavailable!");
        }
    }

    public int n(Context context) {
        try {
            this.m = z(context);
            return Settings.System.getInt(this.m, "screen_brightness");
        } catch (Exception e2) {
            ThrowableExtension.printStackTrace(e2);
            Log.e(f3132a, "Screen Brightness unavailable!");
            return 0;
        }
    }

    public int d() {
        return 255;
    }

    public int o(Context context) {
        try {
            this.m = z(context);
            return Settings.System.getInt(this.m, "screen_brightness_mode");
        } catch (Exception e2) {
            ThrowableExtension.printStackTrace(e2);
            Log.e(f3132a, "Screen Brightness unavailable!");
            return 0;
        }
    }

    public void b(Context context, int i) {
        try {
            this.m = z(context);
            Settings.System.putInt(this.m, "screen_brightness_mode", i);
        } catch (Exception e2) {
            ThrowableExtension.printStackTrace(e2);
            Log.e(f3132a, "Screen Brightness unavailable!");
        }
    }

    public boolean p(Context context) {
        try {
            this.m = z(context);
            return o(context) == 1;
        } catch (Exception e2) {
            ThrowableExtension.printStackTrace(e2);
            Log.e(f3132a, "Screen Brightness unavailable!");
            return false;
        }
    }

    public void q(Context context) {
        try {
            this.m = z(context);
            Settings.System.putInt(this.m, "screen_brightness_mode", 0);
        } catch (Exception e2) {
            ThrowableExtension.printStackTrace(e2);
            Log.e(f3132a, "Screen Brightness unavailable!");
        }
    }

    public void c(Context context, int i) {
        try {
            this.k = y(context);
            this.k.setStreamVolume(3, i, 0);
        } catch (Exception e2) {
            ThrowableExtension.printStackTrace(e2);
            Log.e(f3132a, "Sound Volume unavailable!");
        }
    }

    public int r(Context context) {
        try {
            this.k = y(context);
            return this.k.getStreamVolume(3);
        } catch (Exception e2) {
            ThrowableExtension.printStackTrace(e2);
            Log.e(f3132a, "Sound Volume unavailable!");
            return 0;
        }
    }

    public int s(Context context) {
        try {
            this.k = y(context);
            return this.k.getStreamMaxVolume(3);
        } catch (Exception e2) {
            ThrowableExtension.printStackTrace(e2);
            Log.e(f3132a, "Sound Volume unavailable!");
            return 0;
        }
    }

    public void t(Context context) {
        try {
            this.k = y(context);
            this.k.adjustStreamVolume(3, -1, 1);
        } catch (Exception e2) {
            ThrowableExtension.printStackTrace(e2);
            Log.e(f3132a, "Sound Volume unavailable!");
        }
    }

    public void u(Context context) {
        try {
            this.k = y(context);
            this.k.adjustStreamVolume(3, 1, 1);
        } catch (Exception e2) {
            ThrowableExtension.printStackTrace(e2);
            Log.e(f3132a, "Sound Volume unavailable!");
        }
    }
}

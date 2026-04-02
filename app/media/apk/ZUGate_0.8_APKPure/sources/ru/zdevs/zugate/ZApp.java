package ru.zdevs.zugate;

import android.app.Application;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import b4.j;
import d.n0;
import d.y;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import y.m;
/* loaded from: classes.dex */
public class ZApp extends Application {

    /* renamed from: h  reason: collision with root package name */
    public static ZApp f4571h;

    /* renamed from: i  reason: collision with root package name */
    public static Toast f4572i;

    /* renamed from: g  reason: collision with root package name */
    public Handler f4573g;

    public static ContentResolver a() {
        ZApp zApp = f4571h;
        if (zApp == null) {
            return null;
        }
        return zApp.getContentResolver();
    }

    public static String b(int i5, Object... objArr) {
        return f4571h.getResources().getString(i5, objArr);
    }

    public static void c(int i5, Object... objArr) {
        String b5 = b(i5, objArr);
        ZApp zApp = f4571h;
        Handler handler = zApp == null ? null : zApp.f4573g;
        if (handler == null) {
            return;
        }
        handler.post(new m(0, 2, b5));
    }

    @Override // android.app.Application
    public final void onCreate() {
        f4571h = this;
        this.f4573g = new Handler(Looper.getMainLooper());
        super.onCreate();
        if (y.f2483h != -1) {
            y.f2483h = -1;
            synchronized (y.f2489n) {
                Iterator it = y.f2488m.iterator();
                while (it.hasNext()) {
                    y yVar = (y) ((WeakReference) it.next()).get();
                    if (yVar != null) {
                        ((n0) yVar).p(true, true);
                    }
                }
            }
        }
        boolean r5 = j.r(this, "usb_startup", true);
        ZApp zApp = f4571h;
        PackageManager packageManager = zApp.getPackageManager();
        if (packageManager == null) {
            return;
        }
        packageManager.setComponentEnabledSetting(new ComponentName(zApp, MainActivityUSB.class), r5 ? 1 : 2, 1);
    }

    @Override // android.app.Application
    public final void onTerminate() {
        super.onTerminate();
        Toast toast = f4572i;
        if (toast != null) {
            toast.cancel();
            f4572i = null;
        }
        f4571h = null;
    }
}

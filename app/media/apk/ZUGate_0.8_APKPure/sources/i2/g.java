package i2;

import android.content.Context;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f3394a = new AtomicBoolean();

    /* renamed from: b  reason: collision with root package name */
    public static final AtomicBoolean f3395b = new AtomicBoolean();

    public static boolean a(Context context) {
        try {
            for (PackageInstaller.SessionInfo sessionInfo : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                if ("com.google.android.gms".equals(sessionInfo.getAppPackageName())) {
                    return true;
                }
            }
            return context.getPackageManager().getApplicationInfo("com.google.android.gms", 8192).enabled;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return false;
        }
    }
}

package androidx.biometric;

import android.content.pm.PackageManager;
/* loaded from: classes.dex */
public abstract class g0 {
    public static boolean a(PackageManager packageManager) {
        return packageManager.hasSystemFeature("android.hardware.fingerprint");
    }
}

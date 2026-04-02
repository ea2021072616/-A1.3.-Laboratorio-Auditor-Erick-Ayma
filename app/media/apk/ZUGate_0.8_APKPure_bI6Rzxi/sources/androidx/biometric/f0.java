package androidx.biometric;

import android.app.KeyguardManager;
import android.content.Context;
/* loaded from: classes.dex */
public abstract class f0 {
    public static KeyguardManager a(Context context) {
        return (KeyguardManager) context.getSystemService(KeyguardManager.class);
    }

    public static boolean b(KeyguardManager keyguardManager) {
        return keyguardManager.isDeviceSecure();
    }
}

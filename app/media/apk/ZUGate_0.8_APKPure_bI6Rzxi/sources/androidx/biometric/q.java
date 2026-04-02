package androidx.biometric;

import android.hardware.biometrics.BiometricManager;
/* loaded from: classes.dex */
public abstract class q {
    public static int a(BiometricManager biometricManager, int i5) {
        return biometricManager.canAuthenticate(i5);
    }
}

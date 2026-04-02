package androidx.biometric;

import android.hardware.biometrics.BiometricPrompt;
/* loaded from: classes.dex */
public abstract class l {
    public static void a(BiometricPrompt.Builder builder, int i5) {
        builder.setAllowedAuthenticators(i5);
    }
}

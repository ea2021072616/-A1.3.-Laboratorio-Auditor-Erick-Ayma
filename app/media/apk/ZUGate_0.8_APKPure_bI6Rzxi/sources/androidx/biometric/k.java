package androidx.biometric;

import android.hardware.biometrics.BiometricPrompt;
/* loaded from: classes.dex */
public abstract class k {
    public static void a(BiometricPrompt.Builder builder, boolean z4) {
        builder.setConfirmationRequired(z4);
    }

    public static void b(BiometricPrompt.Builder builder, boolean z4) {
        builder.setDeviceCredentialAllowed(z4);
    }
}

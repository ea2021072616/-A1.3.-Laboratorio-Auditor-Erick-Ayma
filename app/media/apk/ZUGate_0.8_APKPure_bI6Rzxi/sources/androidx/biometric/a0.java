package androidx.biometric;

import android.hardware.biometrics.BiometricPrompt;
import android.security.identity.IdentityCredential;
/* loaded from: classes.dex */
public abstract class a0 {
    public static BiometricPrompt.CryptoObject a(IdentityCredential identityCredential) {
        return new BiometricPrompt.CryptoObject(identityCredential);
    }

    public static IdentityCredential b(BiometricPrompt.CryptoObject cryptoObject) {
        return cryptoObject.getIdentityCredential();
    }
}

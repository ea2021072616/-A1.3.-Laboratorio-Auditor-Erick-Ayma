package androidx.biometric;

import android.hardware.biometrics.BiometricPrompt;
import android.hardware.biometrics.BiometricPrompt$AuthenticationCallback;
import android.os.Build;
import android.security.identity.IdentityCredential;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;
/* loaded from: classes.dex */
public final class a extends BiometricPrompt$AuthenticationCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f608a;

    public a(d dVar) {
        this.f608a = dVar;
    }

    public void onAuthenticationError(int i5, CharSequence charSequence) {
        this.f608a.a(i5, charSequence);
    }

    public void onAuthenticationFailed() {
        this.f608a.b();
    }

    public void onAuthenticationHelp(int i5, CharSequence charSequence) {
    }

    public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult authenticationResult) {
        BiometricPrompt.CryptoObject cryptoObject;
        IdentityCredential b5;
        g.f fVar = null;
        if (authenticationResult != null && (cryptoObject = authenticationResult.getCryptoObject()) != null) {
            Cipher d5 = z.d(cryptoObject);
            if (d5 != null) {
                fVar = new g.f(d5);
            } else {
                Signature f5 = z.f(cryptoObject);
                if (f5 != null) {
                    fVar = new g.f(f5);
                } else {
                    Mac e5 = z.e(cryptoObject);
                    if (e5 != null) {
                        fVar = new g.f(e5);
                    } else if (Build.VERSION.SDK_INT >= 30 && (b5 = a0.b(cryptoObject)) != null) {
                        fVar = new g.f(b5);
                    }
                }
            }
        }
        int i5 = Build.VERSION.SDK_INT;
        int i6 = -1;
        if (i5 >= 30) {
            if (authenticationResult != null) {
                i6 = c.a(authenticationResult);
            }
        } else if (i5 != 29) {
            i6 = 2;
        }
        this.f608a.c(new s(fVar, i6));
    }
}

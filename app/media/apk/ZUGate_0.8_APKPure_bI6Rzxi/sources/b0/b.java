package b0;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import android.os.Handler;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;
/* loaded from: classes.dex */
public abstract class b {
    public static void a(Object obj, Object obj2, CancellationSignal cancellationSignal, int i5, Object obj3, Handler handler) {
        ((FingerprintManager) obj).authenticate((FingerprintManager.CryptoObject) obj2, cancellationSignal, i5, (FingerprintManager.AuthenticationCallback) obj3, handler);
    }

    public static FingerprintManager.CryptoObject b(Object obj) {
        return ((FingerprintManager.AuthenticationResult) obj).getCryptoObject();
    }

    public static FingerprintManager c(Context context) {
        if (context.getPackageManager().hasSystemFeature("android.hardware.fingerprint")) {
            return (FingerprintManager) context.getSystemService(FingerprintManager.class);
        }
        return null;
    }

    public static boolean d(Object obj) {
        return ((FingerprintManager) obj).hasEnrolledFingerprints();
    }

    public static boolean e(Object obj) {
        return ((FingerprintManager) obj).isHardwareDetected();
    }

    public static c f(Object obj) {
        FingerprintManager.CryptoObject cryptoObject = (FingerprintManager.CryptoObject) obj;
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new c(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new c(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() != null) {
            return new c(cryptoObject.getMac());
        }
        return null;
    }

    public static FingerprintManager.CryptoObject g(c cVar) {
        if (cVar == null) {
            return null;
        }
        Cipher cipher = cVar.f1607b;
        if (cipher != null) {
            return new FingerprintManager.CryptoObject(cipher);
        }
        Signature signature = cVar.f1606a;
        if (signature != null) {
            return new FingerprintManager.CryptoObject(signature);
        }
        Mac mac = cVar.f1608c;
        if (mac != null) {
            return new FingerprintManager.CryptoObject(mac);
        }
        return null;
    }
}

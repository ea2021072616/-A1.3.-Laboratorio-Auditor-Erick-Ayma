package b0;

import android.hardware.fingerprint.FingerprintManager;
import androidx.biometric.d;
import androidx.biometric.r;
import androidx.biometric.s;
import androidx.biometric.v;
import androidx.biometric.x;
import androidx.lifecycle.a0;
import d.u0;
import g.f;
import java.lang.ref.WeakReference;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;
/* loaded from: classes.dex */
public final class a extends FingerprintManager.AuthenticationCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ u0 f1605a;

    public a(u0 u0Var) {
        this.f1605a = u0Var;
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public final void onAuthenticationError(int i5, CharSequence charSequence) {
        ((d) ((r) this.f1605a.f2463h).f633c).a(i5, charSequence);
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public final void onAuthenticationFailed() {
        ((d) ((r) this.f1605a.f2463h).f633c).b();
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public final void onAuthenticationHelp(int i5, CharSequence charSequence) {
        WeakReference weakReference = ((v) ((d) ((r) this.f1605a.f2463h).f633c)).f643a;
        if (weakReference.get() != null) {
            x xVar = (x) weakReference.get();
            if (xVar.f660s == null) {
                xVar.f660s = new a0();
            }
            x.i(xVar.f660s, charSequence);
        }
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public final void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
        f fVar;
        c f5 = b.f(b.b(authenticationResult));
        u0 u0Var = this.f1605a;
        u0Var.getClass();
        if (f5 != null) {
            Cipher cipher = f5.f1607b;
            if (cipher != null) {
                fVar = new f(cipher);
            } else {
                Signature signature = f5.f1606a;
                if (signature != null) {
                    fVar = new f(signature);
                } else {
                    Mac mac = f5.f1608c;
                    if (mac != null) {
                        fVar = new f(mac);
                    }
                }
            }
            ((d) ((r) u0Var.f2463h).f633c).c(new s(fVar, 2));
        }
        fVar = null;
        ((d) ((r) u0Var.f2463h).f633c).c(new s(fVar, 2));
    }
}

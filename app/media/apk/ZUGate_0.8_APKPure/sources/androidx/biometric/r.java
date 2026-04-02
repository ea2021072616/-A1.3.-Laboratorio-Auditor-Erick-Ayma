package androidx.biometric;

import android.app.KeyguardManager;
import android.content.Context;
import android.hardware.biometrics.BiometricManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.util.Log;
import d.u0;
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    public Object f631a;

    /* renamed from: b  reason: collision with root package name */
    public Object f632b;

    /* renamed from: c  reason: collision with root package name */
    public Object f633c;

    public r() {
        this.f631a = new u0(9, this);
    }

    public final int a() {
        int i5 = Build.VERSION.SDK_INT;
        int i6 = 1;
        if (i5 >= 30) {
            BiometricManager biometricManager = (BiometricManager) this.f632b;
            if (biometricManager == null) {
                Log.e("BiometricManager", "Failure in canAuthenticate(). BiometricManager was null.");
                return 1;
            }
            return q.a(biometricManager, 255);
        } else if (m0.a.r(255)) {
            int i7 = 0;
            if (f0.a(((i2.h) this.f631a).f3397a) != null) {
                if (m0.a.q(255)) {
                    KeyguardManager a5 = f0.a(((i2.h) this.f631a).f3397a);
                    if (!(a5 == null ? false : f0.b(a5))) {
                        return 11;
                    }
                } else if (i5 == 29) {
                    BiometricManager biometricManager2 = (BiometricManager) this.f632b;
                    if (biometricManager2 == null) {
                        Log.e("BiometricManager", "Failure in canAuthenticate(). BiometricManager was null.");
                    } else {
                        i6 = p.a(biometricManager2);
                    }
                    return i6;
                } else if (i5 != 28) {
                    return b();
                } else {
                    Context context = ((i2.h) this.f631a).f3397a;
                    if (context == null || context.getPackageManager() == null || !g0.a(context.getPackageManager())) {
                        i6 = 0;
                    }
                    if (i6 != 0) {
                        KeyguardManager a6 = f0.a(((i2.h) this.f631a).f3397a);
                        if (!(a6 == null ? false : f0.b(a6))) {
                            return b();
                        }
                        if (b() != 0) {
                            i7 = -1;
                        }
                    }
                }
                return i7;
            }
            return 12;
        } else {
            return -2;
        }
    }

    public final int b() {
        i2.h hVar = (i2.h) this.f633c;
        boolean z4 = true;
        if (hVar == null) {
            Log.e("BiometricManager", "Failure in canAuthenticate(). FingerprintManager was null.");
            return 1;
        }
        FingerprintManager c5 = b0.b.c(hVar.f3397a);
        if (c5 != null && b0.b.e(c5)) {
            FingerprintManager c6 = b0.b.c(((i2.h) this.f633c).f3397a);
            if (c6 == null || !b0.b.d(c6)) {
                z4 = false;
            }
            return !z4 ? 11 : 0;
        }
        return 12;
    }

    public r(v vVar) {
        this.f633c = vVar;
    }

    public r(i2.h hVar) {
        this.f631a = hVar;
        int i5 = Build.VERSION.SDK_INT;
        this.f632b = i5 >= 29 ? p.b(hVar.f3397a) : null;
        this.f633c = i5 <= 29 ? new i2.h(hVar.f3397a) : null;
    }
}

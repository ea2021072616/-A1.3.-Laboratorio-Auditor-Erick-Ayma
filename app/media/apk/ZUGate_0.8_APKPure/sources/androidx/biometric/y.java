package androidx.biometric;

import android.os.CancellationSignal;
/* loaded from: classes.dex */
public abstract class y {
    public static void a(CancellationSignal cancellationSignal) {
        cancellationSignal.cancel();
    }

    public static CancellationSignal b() {
        return new CancellationSignal();
    }
}

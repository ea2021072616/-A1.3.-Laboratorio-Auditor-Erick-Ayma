package androidx.biometric;

import android.app.KeyguardManager;
import android.content.Intent;
/* loaded from: classes.dex */
public abstract class i {
    public static Intent a(KeyguardManager keyguardManager, CharSequence charSequence, CharSequence charSequence2) {
        return keyguardManager.createConfirmDeviceCredentialIntent(charSequence, charSequence2);
    }
}

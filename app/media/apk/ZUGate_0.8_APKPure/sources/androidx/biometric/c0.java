package androidx.biometric;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public abstract class c0 {
    public static void a(Drawable drawable) {
        if (drawable instanceof AnimatedVectorDrawable) {
            ((AnimatedVectorDrawable) drawable).start();
        }
    }
}

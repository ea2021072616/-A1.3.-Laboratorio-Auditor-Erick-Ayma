package w;

import android.app.Notification;
/* loaded from: classes.dex */
public abstract class b0 {
    public static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z4) {
        return builder.setAuthenticationRequired(z4);
    }

    public static Notification.Builder b(Notification.Builder builder, int i5) {
        return builder.setForegroundServiceBehavior(i5);
    }
}

package w;

import android.app.Notification;
import android.widget.RemoteViews;
/* loaded from: classes.dex */
public abstract class x {
    public static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z4) {
        return builder.setAllowGeneratedReplies(z4);
    }

    public static Notification.Builder b(Notification.Builder builder, RemoteViews remoteViews) {
        return builder.setCustomBigContentView(remoteViews);
    }

    public static Notification.Builder c(Notification.Builder builder, RemoteViews remoteViews) {
        return builder.setCustomContentView(remoteViews);
    }

    public static Notification.Builder d(Notification.Builder builder, RemoteViews remoteViews) {
        return builder.setCustomHeadsUpContentView(remoteViews);
    }

    public static Notification.Builder e(Notification.Builder builder, CharSequence[] charSequenceArr) {
        return builder.setRemoteInputHistory(charSequenceArr);
    }
}

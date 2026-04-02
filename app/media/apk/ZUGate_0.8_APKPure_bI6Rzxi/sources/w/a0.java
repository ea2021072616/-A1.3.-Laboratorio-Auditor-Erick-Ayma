package w;

import android.app.Notification;
import android.content.LocusId;
/* loaded from: classes.dex */
public abstract class a0 {
    public static Notification.Builder a(Notification.Builder builder, boolean z4) {
        return builder.setAllowSystemGeneratedContextualActions(z4);
    }

    public static Notification.Builder b(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
        return builder.setBubbleMetadata(bubbleMetadata);
    }

    public static Notification.Action.Builder c(Notification.Action.Builder builder, boolean z4) {
        return builder.setContextual(z4);
    }

    public static Notification.Builder d(Notification.Builder builder, Object obj) {
        return builder.setLocusId((LocusId) obj);
    }
}

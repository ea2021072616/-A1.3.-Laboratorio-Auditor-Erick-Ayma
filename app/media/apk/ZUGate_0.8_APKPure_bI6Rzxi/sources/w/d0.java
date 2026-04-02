package w;

import android.app.NotificationManager;
import androidx.activity.ComponentActivity;
import java.util.HashSet;
/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: a  reason: collision with root package name */
    public final NotificationManager f5247a;

    static {
        new HashSet();
    }

    public d0(ComponentActivity componentActivity) {
        this.f5247a = (NotificationManager) componentActivity.getSystemService("notification");
    }
}

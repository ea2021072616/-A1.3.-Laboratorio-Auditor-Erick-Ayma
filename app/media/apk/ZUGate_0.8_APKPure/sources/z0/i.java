package z0;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public abstract class i {
    public static Handler a(Looper looper) {
        Handler createAsync;
        createAsync = Handler.createAsync(looper);
        return createAsync;
    }
}

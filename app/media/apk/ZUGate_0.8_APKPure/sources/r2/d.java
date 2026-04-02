package r2;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class d extends Handler {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Looper looper, int i5) {
        super(looper);
        if (i5 == 1) {
            super(looper);
            Looper.getMainLooper();
        } else if (i5 != 2) {
            Looper.getMainLooper();
        } else {
            super(looper);
            Looper.getMainLooper();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Looper looper, Handler.Callback callback, int i5) {
        super(looper, callback);
        if (i5 != 1) {
            Looper.getMainLooper();
            return;
        }
        super(looper, callback);
        Looper.getMainLooper();
    }
}

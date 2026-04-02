package androidx.emoji2.text;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public abstract class c {
    public static Handler a(Looper looper) {
        Handler createAsync;
        createAsync = Handler.createAsync(looper);
        return createAsync;
    }
}

package y;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import d.v;
/* loaded from: classes.dex */
public abstract class n {
    public static Handler getHandler(Handler handler) {
        return handler == null ? new Handler(Looper.getMainLooper()) : handler;
    }

    public final void callbackFailAsync(int i5, Handler handler) {
        getHandler(handler).post(new m(i5, 0, this));
    }

    public final void callbackSuccessAsync(Typeface typeface, Handler handler) {
        getHandler(handler).post(new v(this, 1, typeface));
    }

    public abstract void onFontRetrievalFailed(int i5);

    public abstract void onFontRetrieved(Typeface typeface);
}

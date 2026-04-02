package i2;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public final class j extends r2.d {

    /* renamed from: a  reason: collision with root package name */
    public final Context f3401a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f3402b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(d dVar, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper(), 0);
        this.f3402b = dVar;
        this.f3401a = context.getApplicationContext();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i5 = message.what;
        boolean z4 = true;
        if (i5 != 1) {
            Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + i5);
            return;
        }
        d dVar = this.f3402b;
        Context context = this.f3401a;
        int c5 = dVar.c(context);
        AtomicBoolean atomicBoolean = g.f3394a;
        if (c5 != 1 && c5 != 2 && c5 != 3 && c5 != 9) {
            z4 = false;
        }
        if (z4) {
            Intent a5 = dVar.a(c5, context, "n");
            dVar.g(context, c5, a5 == null ? null : PendingIntent.getActivity(context, 0, a5, 201326592));
        }
    }
}

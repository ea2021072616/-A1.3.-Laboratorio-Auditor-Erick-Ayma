package x4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public final class i extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Object obj = j.f5528b;
        synchronized (obj) {
            obj.notifyAll();
        }
    }
}

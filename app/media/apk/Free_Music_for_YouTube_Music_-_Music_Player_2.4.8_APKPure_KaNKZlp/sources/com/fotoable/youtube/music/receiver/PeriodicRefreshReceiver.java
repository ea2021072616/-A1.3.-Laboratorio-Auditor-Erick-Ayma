package com.fotoable.youtube.music.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.fotoable.youtube.music.util.h;
import com.fotoable.youtube.music.util.w;
/* loaded from: classes.dex */
public class PeriodicRefreshReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action;
        if (w.a(context) && intent != null && (action = intent.getAction()) != null) {
            char c2 = 65535;
            switch (action.hashCode()) {
                case -101796298:
                    if (action.equals("com.fotoable.free.music.receiver.action.widget.PERIODIC_ALARM")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    h.a("亲，快点更新数据了......");
                    return;
                default:
                    return;
            }
        }
    }

    public static void a(Context context) {
    }

    public static void b(Context context) {
    }
}

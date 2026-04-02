package com.fotoable.youtube.music.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.fotoable.youtube.music.service.NotificationService;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* loaded from: classes.dex */
public class AlarmReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context != null) {
            try {
                Intent intent2 = new Intent();
                intent2.setClass(context, NotificationService.class);
                intent2.addFlags(268435456);
                context.startService(intent2);
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
        }
    }
}

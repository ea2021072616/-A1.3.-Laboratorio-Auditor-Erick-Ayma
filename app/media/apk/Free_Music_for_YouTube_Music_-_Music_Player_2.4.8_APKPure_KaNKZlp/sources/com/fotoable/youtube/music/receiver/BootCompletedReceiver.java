package com.fotoable.youtube.music.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.fotoable.youtube.music.a;
import com.fotoable.youtube.music.quicktools.service.QuickToolsService;
import com.fotoable.youtube.music.service.NotificationService;
/* loaded from: classes.dex */
public class BootCompletedReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            if (("android.intent.action.BOOT_COMPLETED".equals(intent.getAction()) || TextUtils.equals("android.intent.action.TIME_TICK", intent.getAction())) && a.o()) {
                QuickToolsService.a(context, "action_show_quick");
            }
            if (context != null) {
                Intent intent2 = new Intent();
                intent2.setClass(context, NotificationService.class);
                intent2.addFlags(268435456);
                context.startService(intent2);
            }
        }
    }
}

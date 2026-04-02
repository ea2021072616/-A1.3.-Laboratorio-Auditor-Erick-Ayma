package com.fotoable.youtube.music.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.fotoable.youtube.music.util.b;
/* loaded from: classes.dex */
public class MusicNotifiCancelReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction().equals("removenotification")) {
            b.b("清除本地音乐新增提醒");
            com.fotoable.youtube.music.newplayer.b.a();
        }
    }
}

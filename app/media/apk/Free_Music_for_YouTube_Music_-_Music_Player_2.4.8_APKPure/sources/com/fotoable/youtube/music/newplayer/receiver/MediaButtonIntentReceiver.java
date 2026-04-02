package com.fotoable.youtube.music.newplayer.receiver;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.fotoable.youtube.music.newplayer.f;
/* loaded from: classes.dex */
public class MediaButtonIntentReceiver extends WakefulBroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action) && "android.intent.action.MEDIA_BUTTON".equals(action)) {
                KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
                int keyCode = keyEvent.getKeyCode();
                if (1 == keyEvent.getAction()) {
                    if (87 == keyCode) {
                        f.a().e(false);
                    } else if (88 == keyCode) {
                        f.a().d(false);
                    } else if (126 == keyCode) {
                        f.a().b(false);
                    } else if (127 == keyCode) {
                        f.a().c(false);
                    } else {
                        if (85 == keyCode || 86 == keyCode) {
                        }
                    }
                }
            }
        }
    }
}

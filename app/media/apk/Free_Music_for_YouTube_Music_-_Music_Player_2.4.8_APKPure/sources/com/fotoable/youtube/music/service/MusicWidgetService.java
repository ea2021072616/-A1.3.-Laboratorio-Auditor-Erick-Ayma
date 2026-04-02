package com.fotoable.youtube.music.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import com.fotoable.youtube.music.newplayer.model.PlayerInfo;
import com.fotoable.youtube.music.receiver.PeriodicRefreshReceiver;
import com.fotoable.youtube.music.ui.widget.Actions;
import com.fotoable.youtube.music.util.x;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* loaded from: classes.dex */
public class MusicWidgetService extends Service {
    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        PeriodicRefreshReceiver.a(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null || intent.getAction() == null) {
            PeriodicRefreshReceiver.a(this);
            return super.onStartCommand(intent, 1, i2);
        }
        a(intent);
        return super.onStartCommand(intent, 1, i2);
    }

    private void a(Intent intent) {
        try {
            String action = intent.getAction();
            if (action != null) {
                char c2 = 65535;
                switch (action.hashCode()) {
                    case -57421692:
                        if (action.equals("action_syn_music_data")) {
                            c2 = 0;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        PlayerInfo playerInfo = null;
                        if (intent.hasExtra("music")) {
                            playerInfo = (PlayerInfo) intent.getParcelableExtra("music");
                        }
                        Intent intent2 = new Intent();
                        intent2.setAction(Actions.ACTION_UPDATE_DATA_STATE);
                        intent2.putExtra("music", playerInfo);
                        sendBroadcast(intent2);
                        return;
                    default:
                        return;
                }
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (x.a()) {
            PeriodicRefreshReceiver.a(this);
        } else {
            PeriodicRefreshReceiver.b(this);
        }
        super.onDestroy();
    }

    public static void a(Context context) {
        try {
            context.stopService(new Intent(context, MusicWidgetService.class));
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }
}

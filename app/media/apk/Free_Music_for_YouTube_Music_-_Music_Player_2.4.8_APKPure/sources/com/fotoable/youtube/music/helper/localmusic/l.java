package com.fotoable.youtube.music.helper.localmusic;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.service.MainService;
import java.util.concurrent.TimeUnit;
/* compiled from: MusicNotifyResetManager.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static final long f2751a = TimeUnit.HOURS.toMillis(1);

    public static void a() {
        b();
        if (Build.VERSION.SDK_INT >= 21) {
            MusicNotifyResetService.a();
        } else {
            c();
        }
    }

    private static void c() {
        AlarmManager alarmManager = (AlarmManager) MusicApplication.c().getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent service = PendingIntent.getService(MusicApplication.c().getApplicationContext(), 0, new Intent(MusicApplication.c().getApplicationContext(), MainService.class).setAction("action_reset_music_update_notification"), 134217728);
        alarmManager.cancel(service);
        alarmManager.setRepeating(2, SystemClock.elapsedRealtime() + f2751a, f2751a, service);
    }

    public static void b() {
        if (Build.VERSION.SDK_INT >= 21) {
            MusicNotifyResetService.b();
        } else {
            d();
        }
    }

    private static void d() {
        ((AlarmManager) MusicApplication.c().getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(PendingIntent.getService(MusicApplication.c().getApplicationContext(), 0, new Intent(MusicApplication.c().getApplicationContext(), MainService.class).setAction("action_reset_music_update_notification"), 134217728));
    }
}

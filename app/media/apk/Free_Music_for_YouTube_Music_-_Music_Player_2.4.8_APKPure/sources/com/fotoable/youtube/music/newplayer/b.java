package com.fotoable.youtube.music.newplayer;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.RemoteViews;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.receiver.MusicNotifiCancelReceiver;
import com.fotoable.youtube.music.ui.activity.MainActivity;
/* compiled from: MusicUpdateNotification.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static int f2848a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static int f2849b = 0;

    public static void a(Context context, int i) {
        if (context != null || i >= 0) {
            com.fotoable.youtube.music.util.b.b("本地音乐新增提醒次数");
            f2848a += i;
            f2849b += i;
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), (int) R.layout.local_music_update);
            builder.setCustomContentView(remoteViews);
            builder.setPriority(1);
            builder.setAutoCancel(true);
            remoteViews.setTextViewText(R.id.tv_title, context.getString(R.string.new_music_added, Integer.valueOf(f2848a)));
            Intent intent = new Intent(context, MainActivity.class);
            intent.putExtra(ShareConstants.FEED_SOURCE_PARAM, "music_update_widget");
            builder.setContentIntent(PendingIntent.getActivity(context, 0, intent.addFlags(872415232), 134217728));
            Intent intent2 = new Intent(context, MusicNotifiCancelReceiver.class);
            intent2.setAction("removenotification");
            builder.setDeleteIntent(PendingIntent.getBroadcast(context, 0, intent2, 1073741824));
            builder.setSmallIcon(R.mipmap.notification_logo);
            Notification build = builder.build();
            if (f2849b == 1) {
                build.defaults = 1;
            }
            NotificationManagerCompat.from(context).notify(1, build);
        }
    }

    public static void a() {
        f2848a = 0;
    }

    public static void b() {
        f2849b = 0;
    }
}

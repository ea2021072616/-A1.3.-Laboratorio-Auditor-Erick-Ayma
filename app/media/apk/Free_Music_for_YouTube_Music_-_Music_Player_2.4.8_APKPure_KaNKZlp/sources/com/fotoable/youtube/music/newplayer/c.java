package com.fotoable.youtube.music.newplayer;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.RemoteViews;
import com.bumptech.glide.i;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import com.fotoable.youtube.music.newplayer.model.PlayerInfo;
import com.fotoable.youtube.music.newplayer.service.PlayerService;
import com.fotoable.youtube.music.ui.activity.MainActivity;
import com.fotoable.youtube.music.util.h;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* compiled from: NotificationHelper.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final c f2882a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static final String f2883b = c.class.getSimpleName();
    private PlayerInfo d;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2884c = false;
    private Notification e = null;

    public static c a() {
        return f2882a;
    }

    private c() {
    }

    public void a(boolean z) {
        this.f2884c = z;
    }

    public void a(Context context, PlayerInfo playerInfo) {
        this.d = playerInfo;
        if (!this.f2884c) {
            b(context, playerInfo);
        }
    }

    public void a(Context context) {
        try {
            this.e = null;
            NotificationManagerCompat.from(context).cancel(101);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    private void b(Context context, PlayerInfo playerInfo) {
        if (context != null) {
            try {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
                builder.setPriority(0);
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra(ShareConstants.FEED_SOURCE_PARAM, "notification");
                intent.addFlags(872415232);
                builder.setContentIntent(PendingIntent.getActivity(context, 101, intent, 134217728));
                builder.setAutoCancel(false);
                builder.setSmallIcon(R.mipmap.notification_logo);
                if (Build.VERSION.SDK_INT < 16) {
                    a(builder, context, playerInfo);
                } else {
                    b(builder, context, playerInfo);
                }
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
        }
    }

    private void a(NotificationCompat.Builder builder, final Context context, final PlayerInfo playerInfo) {
        final RemoteViews remoteViews = new RemoteViews(context.getPackageName(), (int) R.layout.view_notification);
        this.e = null;
        if (playerInfo != null) {
            remoteViews.setTextViewText(R.id.video_title, playerInfo.getMusicName());
            if (playerInfo.isRadioPlayer()) {
                remoteViews.setViewVisibility(R.id.video_time, 8);
                remoteViews.setViewVisibility(R.id.video_play_back, 8);
                remoteViews.setViewVisibility(R.id.video_play_next, 8);
            } else {
                remoteViews.setViewVisibility(R.id.video_time, 0);
                remoteViews.setViewVisibility(R.id.video_play_back, 0);
                remoteViews.setViewVisibility(R.id.video_play_next, 0);
                remoteViews.setTextViewText(R.id.video_time, playerInfo.getDuration());
            }
            if (playerInfo.isRadioPlayer()) {
                remoteViews.setImageViewResource(R.id.video_cover2, R.mipmap.icon_playlist_default);
            } else {
                remoteViews.setImageViewResource(R.id.video_cover, R.mipmap.icon_playlist_default);
            }
            i.c(context).a(playerInfo.getCoverImg()).l().i().a((com.bumptech.glide.a<String, Bitmap>) new com.bumptech.glide.g.b.g<Bitmap>() { // from class: com.fotoable.youtube.music.newplayer.c.1
                @Override // com.bumptech.glide.g.b.j
                /* renamed from: a */
                public void onResourceReady(Bitmap bitmap, com.bumptech.glide.g.a.c<? super Bitmap> cVar) {
                    if (playerInfo.isRadioPlayer()) {
                        remoteViews.setViewVisibility(R.id.video_cover, 8);
                        remoteViews.setViewVisibility(R.id.video_cover2, 0);
                        remoteViews.setImageViewBitmap(R.id.video_cover2, bitmap);
                    } else {
                        remoteViews.setImageViewBitmap(R.id.video_cover, bitmap);
                        remoteViews.setViewVisibility(R.id.video_cover, 0);
                        remoteViews.setViewVisibility(R.id.video_cover2, 8);
                    }
                    if (c.this.e != null) {
                        NotificationManagerCompat.from(context).notify(101, c.this.e);
                    }
                }
            });
        } else {
            remoteViews.setTextViewText(R.id.video_title, context.getResources().getString(R.string.app_name));
            remoteViews.setTextViewText(R.id.video_time, "");
            remoteViews.setViewVisibility(R.id.video_time, 8);
            remoteViews.setImageViewResource(R.id.video_cover, R.mipmap.icon_playlist_default);
        }
        Intent intent = new Intent(context, PlayerService.class);
        intent.setAction("com.fotoable.youtube.music.video_play_back");
        remoteViews.setOnClickPendingIntent(R.id.video_play_back, PendingIntent.getService(context, 1, intent, 134217728));
        if (playerInfo != null && playerInfo.isPlaying()) {
            Intent intent2 = new Intent(context, PlayerService.class);
            intent2.setAction("com.fotoable.youtube.music.video_stop");
            remoteViews.setOnClickPendingIntent(R.id.video_play_state, PendingIntent.getService(context, 2, intent2, 134217728));
            remoteViews.setImageViewResource(R.id.video_play_state, R.mipmap.notifi_icon_stop);
        } else {
            Intent intent3 = new Intent(context, PlayerService.class);
            intent3.setAction("com.fotoable.youtube.music.video_play");
            remoteViews.setOnClickPendingIntent(R.id.video_play_state, PendingIntent.getService(context, 3, intent3, 134217728));
            remoteViews.setImageViewResource(R.id.video_play_state, R.mipmap.notifi_icon_play);
        }
        Intent intent4 = new Intent(context, PlayerService.class);
        intent4.setAction("com.fotoable.youtube.music.video_play_next");
        remoteViews.setOnClickPendingIntent(R.id.video_play_next, PendingIntent.getService(context, 4, intent4, 134217728));
        Intent intent5 = new Intent(context, PlayerService.class);
        intent5.setAction("com.fotoable.youtube.music.close");
        remoteViews.setOnClickPendingIntent(R.id.video_close, PendingIntent.getService(context, 5, intent5, 134217728));
        builder.setCustomContentView(remoteViews);
        this.e = builder.build();
        this.e.flags = 32;
        NotificationManagerCompat.from(context).notify(101, this.e);
    }

    private void b(NotificationCompat.Builder builder, final Context context, final PlayerInfo playerInfo) {
        final RemoteViews remoteViews = new RemoteViews(context.getPackageName(), (int) R.layout.view_notification);
        final RemoteViews remoteViews2 = new RemoteViews(context.getPackageName(), (int) R.layout.view_notification);
        this.e = null;
        if (playerInfo != null) {
            remoteViews.setTextViewText(R.id.video_title, playerInfo.getMusicName());
            remoteViews2.setTextViewText(R.id.video_title, playerInfo.getMusicName());
            if (playerInfo.isRadioPlayer()) {
                remoteViews.setViewVisibility(R.id.video_time, 8);
                remoteViews2.setViewVisibility(R.id.video_time, 8);
                remoteViews.setViewVisibility(R.id.video_play_back, 8);
                remoteViews2.setViewVisibility(R.id.video_play_back, 8);
                remoteViews.setViewVisibility(R.id.video_play_next, 8);
                remoteViews2.setViewVisibility(R.id.video_play_next, 8);
            } else {
                remoteViews.setTextViewText(R.id.video_time, playerInfo.getDuration());
                remoteViews2.setTextViewText(R.id.video_time, playerInfo.getDuration());
                remoteViews.setViewVisibility(R.id.video_time, 0);
                remoteViews2.setViewVisibility(R.id.video_time, 0);
                remoteViews.setViewVisibility(R.id.video_play_back, 0);
                remoteViews2.setViewVisibility(R.id.video_play_back, 0);
                remoteViews.setViewVisibility(R.id.video_play_next, 0);
                remoteViews2.setViewVisibility(R.id.video_play_next, 0);
            }
            if (playerInfo.isRadioPlayer()) {
                remoteViews.setImageViewResource(R.id.video_cover2, R.mipmap.icon_playlist_default);
                remoteViews2.setImageViewResource(R.id.video_cover2, R.mipmap.icon_playlist_default);
            } else {
                remoteViews.setImageViewResource(R.id.video_cover, R.mipmap.icon_playlist_default);
                remoteViews2.setImageViewResource(R.id.video_cover, R.mipmap.icon_playlist_default);
            }
            i.c(context).a(playerInfo.getCoverImg()).l().i().a((com.bumptech.glide.a<String, Bitmap>) new com.bumptech.glide.g.b.g<Bitmap>() { // from class: com.fotoable.youtube.music.newplayer.c.2
                @Override // com.bumptech.glide.g.b.j
                /* renamed from: a */
                public void onResourceReady(Bitmap bitmap, com.bumptech.glide.g.a.c<? super Bitmap> cVar) {
                    if (playerInfo.isRadioPlayer()) {
                        remoteViews.setViewVisibility(R.id.video_cover, 8);
                        remoteViews2.setViewVisibility(R.id.video_cover, 8);
                        remoteViews.setViewVisibility(R.id.video_cover2, 0);
                        remoteViews2.setViewVisibility(R.id.video_cover2, 0);
                        remoteViews.setImageViewBitmap(R.id.video_cover2, bitmap);
                        remoteViews2.setImageViewBitmap(R.id.video_cover2, bitmap);
                    } else {
                        remoteViews.setImageViewBitmap(R.id.video_cover, bitmap);
                        remoteViews2.setImageViewBitmap(R.id.video_cover, bitmap);
                        remoteViews.setViewVisibility(R.id.video_cover, 0);
                        remoteViews2.setViewVisibility(R.id.video_cover, 0);
                        remoteViews.setViewVisibility(R.id.video_cover2, 8);
                        remoteViews2.setViewVisibility(R.id.video_cover2, 8);
                    }
                    if (c.this.e != null) {
                        try {
                            NotificationManagerCompat.from(context).notify(101, c.this.e);
                        } catch (Exception e) {
                            ThrowableExtension.printStackTrace(e);
                        }
                    }
                }
            });
        } else {
            remoteViews.setTextViewText(R.id.video_title, context.getResources().getString(R.string.app_name));
            remoteViews2.setTextViewText(R.id.video_title, context.getResources().getString(R.string.app_name));
            remoteViews.setViewVisibility(R.id.video_time, 8);
            remoteViews2.setViewVisibility(R.id.video_time, 8);
            remoteViews.setImageViewResource(R.id.video_play_state, R.mipmap.notifi_icon_play);
            remoteViews2.setImageViewResource(R.id.video_play_state, R.mipmap.notifi_icon_play);
        }
        Intent intent = new Intent(context, PlayerService.class);
        intent.setAction("com.fotoable.youtube.music.video_play_back");
        PendingIntent service = PendingIntent.getService(context, 1, intent, 134217728);
        remoteViews.setOnClickPendingIntent(R.id.video_play_back, service);
        remoteViews2.setOnClickPendingIntent(R.id.video_play_back, service);
        if (playerInfo != null && playerInfo.isPlaying()) {
            Intent intent2 = new Intent(context, PlayerService.class);
            intent2.setAction("com.fotoable.youtube.music.video_stop");
            PendingIntent service2 = PendingIntent.getService(context, 2, intent2, 134217728);
            remoteViews.setOnClickPendingIntent(R.id.video_play_state, service2);
            remoteViews2.setOnClickPendingIntent(R.id.video_play_state, service2);
            remoteViews.setImageViewResource(R.id.video_play_state, R.mipmap.notifi_icon_stop);
            remoteViews2.setImageViewResource(R.id.video_play_state, R.mipmap.notifi_icon_stop);
        } else {
            Intent intent3 = new Intent(context, PlayerService.class);
            intent3.setAction("com.fotoable.youtube.music.video_play");
            PendingIntent service3 = PendingIntent.getService(context, 3, intent3, 134217728);
            remoteViews.setOnClickPendingIntent(R.id.video_play_state, service3);
            remoteViews2.setOnClickPendingIntent(R.id.video_play_state, service3);
            remoteViews.setImageViewResource(R.id.video_play_state, R.mipmap.notifi_icon_play);
            remoteViews2.setImageViewResource(R.id.video_play_state, R.mipmap.notifi_icon_play);
        }
        Intent intent4 = new Intent(context, PlayerService.class);
        intent4.setAction("com.fotoable.youtube.music.video_play_next");
        PendingIntent service4 = PendingIntent.getService(context, 4, intent4, 134217728);
        remoteViews.setOnClickPendingIntent(R.id.video_play_next, service4);
        remoteViews2.setOnClickPendingIntent(R.id.video_play_next, service4);
        Intent intent5 = new Intent(context, PlayerService.class);
        intent5.setAction("com.fotoable.youtube.music.close");
        PendingIntent service5 = PendingIntent.getService(context, 5, intent5, 134217728);
        remoteViews.setOnClickPendingIntent(R.id.video_close, service5);
        remoteViews2.setOnClickPendingIntent(R.id.video_close, service5);
        builder.setCustomContentView(remoteViews);
        builder.setCustomBigContentView(remoteViews2);
        this.e = builder.build();
        this.e.flags = 32;
        NotificationManagerCompat.from(context).notify(101, this.e);
    }

    public void a(Context context, PlayMusicModel playMusicModel) {
        h.a(f2883b, "警告通知");
        try {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
            builder.setPriority(0);
            Intent intent = new Intent();
            intent.setAction("com.fotoable.youtube.music.vertical_screen");
            builder.setContentIntent(PendingIntent.getBroadcast(context, 101, intent, 134217728));
            builder.setAutoCancel(false);
            builder.setSmallIcon(R.mipmap.notification_logo);
            if (Build.VERSION.SDK_INT < 16) {
                a(builder, context, playMusicModel);
            } else {
                b(builder, context, playMusicModel);
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    private void a(NotificationCompat.Builder builder, final Context context, PlayMusicModel playMusicModel) {
        final RemoteViews remoteViews = new RemoteViews(context.getPackageName(), (int) R.layout.view_notification_youtube_warn);
        this.e = null;
        if (this.d != null) {
            i.c(context).a(this.d.getCoverImg()).l().i().a((com.bumptech.glide.a<String, Bitmap>) new com.bumptech.glide.g.b.g<Bitmap>() { // from class: com.fotoable.youtube.music.newplayer.c.3
                @Override // com.bumptech.glide.g.b.j
                /* renamed from: a */
                public void onResourceReady(Bitmap bitmap, com.bumptech.glide.g.a.c<? super Bitmap> cVar) {
                    remoteViews.setImageViewBitmap(R.id.video_cover, bitmap);
                    if (c.this.e != null) {
                        NotificationManagerCompat.from(context).notify(101, c.this.e);
                    }
                }
            });
        }
        Intent intent = new Intent();
        intent.setAction("com.fotoable.youtube.music.close");
        remoteViews.setOnClickPendingIntent(R.id.video_close, PendingIntent.getBroadcast(context, 5, intent, 134217728));
        builder.setCustomContentView(remoteViews);
        this.e = builder.build();
        this.e.defaults = 4;
        this.e.flags = 32;
        NotificationManagerCompat.from(context).notify(101, this.e);
    }

    private void b(NotificationCompat.Builder builder, final Context context, PlayMusicModel playMusicModel) {
        final RemoteViews remoteViews = new RemoteViews(context.getPackageName(), (int) R.layout.view_notification_youtube_warn);
        final RemoteViews remoteViews2 = new RemoteViews(context.getPackageName(), (int) R.layout.view_notification_youtube_warn);
        this.e = null;
        if (this.d != null) {
            i.c(context).a(this.d.getCoverImg()).l().i().a((com.bumptech.glide.a<String, Bitmap>) new com.bumptech.glide.g.b.g<Bitmap>() { // from class: com.fotoable.youtube.music.newplayer.c.4
                @Override // com.bumptech.glide.g.b.j
                /* renamed from: a */
                public void onResourceReady(Bitmap bitmap, com.bumptech.glide.g.a.c<? super Bitmap> cVar) {
                    remoteViews.setImageViewBitmap(R.id.video_cover, bitmap);
                    remoteViews2.setImageViewBitmap(R.id.video_cover, bitmap);
                    if (c.this.e != null) {
                        NotificationManagerCompat.from(context).notify(101, c.this.e);
                    }
                }
            });
        }
        Intent intent = new Intent();
        intent.setAction("com.fotoable.youtube.music.close");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 5, intent, 134217728);
        remoteViews.setOnClickPendingIntent(R.id.video_close, broadcast);
        remoteViews2.setOnClickPendingIntent(R.id.video_close, broadcast);
        builder.setCustomContentView(remoteViews);
        builder.setCustomBigContentView(remoteViews2);
        this.e = builder.build();
        this.e.defaults = 4;
        this.e.flags = 32;
        NotificationManagerCompat.from(context).notify(101, this.e);
    }
}

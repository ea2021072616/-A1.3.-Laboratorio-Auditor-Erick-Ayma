package com.fotoable.youtube.music.ui.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.bumptech.glide.a;
import com.bumptech.glide.g.a.c;
import com.bumptech.glide.g.b.g;
import com.bumptech.glide.i;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.newplayer.model.PlayerInfo;
import com.fotoable.youtube.music.newplayer.service.PlayerService;
import com.fotoable.youtube.music.receiver.PeriodicRefreshReceiver;
import com.fotoable.youtube.music.service.MusicWidgetService;
import com.fotoable.youtube.music.ui.activity.MainActivity;
import com.fotoable.youtube.music.util.b;
import com.fotoable.youtube.music.util.x;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* loaded from: classes.dex */
public class MusicWidgetSmall extends AppWidgetProvider {
    private static final String TAG = MusicWidgetSmall.class.getSimpleName();
    private PlayerInfo playerInfo;

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            if (AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, MusicWidgetSmall.class)).length != 0 && intent != null) {
                String action = intent.getAction();
                if (!TextUtils.isEmpty(action)) {
                    char c2 = 65535;
                    switch (action.hashCode()) {
                        case -2008227701:
                            if (action.equals(Actions.ACTION_UPDATE_DATA_STATE)) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case -1814736331:
                            if (action.equals(Actions.ACTION_TO_PLAYER_V)) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case -1580608543:
                            if (action.equals(Actions.ACTION_PLAY_MUSIC)) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 1141841417:
                            if (action.equals(Actions.ACTION_TO_SEARCH_PAGE)) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case 1668040949:
                            if (action.equals(Actions.ACTION_PAUSE_MUSIC)) {
                                c2 = 3;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            if (intent.hasExtra("music")) {
                                this.playerInfo = (PlayerInfo) intent.getParcelableExtra("music");
                            }
                            updateWidget(context);
                            return;
                        case 1:
                            Intent intent2 = new Intent(context, PlayerService.class);
                            intent2.setAction("action_change_player_size");
                            intent2.putExtra(ShareConstants.FEED_SOURCE_PARAM, "widget");
                            context.startService(intent2);
                            b.b("Widget桌面小部件上操作", "点击操作", "视频封面");
                            return;
                        case 2:
                            Intent intent3 = new Intent(context, PlayerService.class);
                            intent3.setAction("action_change_play_state");
                            intent3.putExtra("isPlaying", true);
                            intent3.putExtra(ShareConstants.FEED_SOURCE_PARAM, "widget");
                            context.startService(intent3);
                            b.b("Widget桌面小部件上操作", "点击操作", "播放");
                            return;
                        case 3:
                            Intent intent4 = new Intent(context, PlayerService.class);
                            intent4.setAction("action_change_play_state");
                            intent4.putExtra(ShareConstants.FEED_SOURCE_PARAM, "widget");
                            intent4.putExtra("isPlaying", false);
                            context.startService(intent4);
                            b.b("Widget桌面小部件上操作", "点击操作", "暂停");
                            return;
                        case 4:
                            Intent intent5 = new Intent(context, MainActivity.class);
                            intent5.addFlags(268435456);
                            intent5.putExtra("toPage", "search");
                            intent5.putExtra(ShareConstants.FEED_SOURCE_PARAM, "widget");
                            context.startActivity(intent5);
                            b.b("Widget桌面小部件上操作", "点击操作", "搜索");
                            return;
                        default:
                            super.onReceive(context, intent);
                            return;
                    }
                }
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onEnabled(Context context) {
        super.onEnabled(context);
        PeriodicRefreshReceiver.a(context);
        b.b("Widget桌面小部件", "使用情况", "添加小部件");
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        super.onUpdate(context, appWidgetManager, iArr);
        PeriodicRefreshReceiver.a(context);
        updateWidget(context);
    }

    private void updateWidget(final Context context) {
        final RemoteViews remoteViews = new RemoteViews(context.getPackageName(), (int) R.layout.widget_music_4_x_2);
        setupCallback(context, remoteViews);
        final ComponentName componentName = new ComponentName(context, MusicWidgetSmall.class);
        if (this.playerInfo != null) {
            i.c(context).a(this.playerInfo.getCoverImg()).l().i().d((int) R.mipmap.widget_default_cover).c((int) R.mipmap.widget_default_cover).a((a<String, Bitmap>) new g<Bitmap>() { // from class: com.fotoable.youtube.music.ui.widget.MusicWidgetSmall.1
                @Override // com.bumptech.glide.g.b.j
                public /* bridge */ /* synthetic */ void onResourceReady(Object obj, c cVar) {
                    onResourceReady((Bitmap) obj, (c<? super Bitmap>) cVar);
                }

                public void onResourceReady(Bitmap bitmap, c<? super Bitmap> cVar) {
                    remoteViews.setImageViewBitmap(R.id.coverIv, bitmap);
                    MusicWidgetSmall.this.notifyWidgetUpdate(context, remoteViews, componentName, -1);
                }
            });
            remoteViews.setTextViewText(R.id.music_name, this.playerInfo.getMusicName());
            remoteViews.setTextViewText(R.id.video_time, this.playerInfo.getDuration());
            if (this.playerInfo.isPlaying()) {
                remoteViews.setImageViewResource(R.id.video_play_state, R.drawable.quicktool_btn_pause_click_style);
            } else {
                remoteViews.setImageViewResource(R.id.video_play_state, R.drawable.quicktool_btn_play_click_style);
            }
            remoteViews.setProgressBar(R.id.widget_ProgressBar, (int) this.playerInfo.getTotalTime(), (int) this.playerInfo.getCurrentTime(), false);
        } else {
            remoteViews.setProgressBar(R.id.widget_ProgressBar, 0, 0, false);
            remoteViews.setImageViewResource(R.id.coverIv, R.mipmap.widget_default_cover);
            remoteViews.setTextViewText(R.id.music_name, context.getString(R.string.welcome_to_freemusic_tube_enjoy_your_music));
            remoteViews.setTextViewText(R.id.video_time, "00:00");
            remoteViews.setImageViewResource(R.id.video_play_state, R.drawable.quicktool_btn_play_click_style);
        }
        try {
            AppWidgetManager.getInstance(context).updateAppWidget(componentName, remoteViews);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    private void setupCallback(Context context, RemoteViews remoteViews) {
        Intent intent = new Intent();
        intent.setAction(Actions.ACTION_TO_PLAYER_V);
        remoteViews.setOnClickPendingIntent(R.id.coverIv, PendingIntent.getBroadcast(context, InputDeviceCompat.SOURCE_KEYBOARD, intent, 134217728));
        Intent intent2 = new Intent();
        intent2.setAction(Actions.ACTION_TO_SEARCH_PAGE);
        remoteViews.setOnClickPendingIntent(R.id.video_search, PendingIntent.getBroadcast(context, 258, intent2, 134217728));
        Intent intent3 = new Intent();
        if (this.playerInfo != null && this.playerInfo.isPlaying()) {
            intent3.setAction(Actions.ACTION_PAUSE_MUSIC);
        } else {
            intent3.setAction(Actions.ACTION_PLAY_MUSIC);
        }
        remoteViews.setOnClickPendingIntent(R.id.video_play_state, PendingIntent.getBroadcast(context, 259, intent3, 134217728));
        Intent intent4 = new Intent(context, MainActivity.class);
        intent4.addFlags(268435456);
        intent4.addFlags(32768);
        intent4.putExtra(ShareConstants.FEED_SOURCE_PARAM, "widget");
        remoteViews.setOnClickPendingIntent(R.id.view_widget_root_small, PendingIntent.getActivity(context, 0, intent4, 134217728));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyWidgetUpdate(Context context, RemoteViews remoteViews, ComponentName componentName, int i) {
        try {
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            if (i == -1) {
                appWidgetManager.updateAppWidget(componentName, remoteViews);
            } else {
                appWidgetManager.updateAppWidget(i, remoteViews);
            }
        } catch (Exception e) {
            System.gc();
            PeriodicRefreshReceiver.a(context);
        } catch (OutOfMemoryError e2) {
            System.gc();
            PeriodicRefreshReceiver.a(context);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDeleted(Context context, int[] iArr) {
        super.onDeleted(context, iArr);
        if (!x.a()) {
            MusicWidgetService.a(context);
            PeriodicRefreshReceiver.b(context);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDisabled(Context context) {
        super.onDisabled(context);
        x.a(false);
        if (!x.a()) {
            MusicWidgetService.a(context);
            PeriodicRefreshReceiver.b(context);
        }
        b.b("Widget桌面小部件", "使用情况", "移除小部件");
    }
}

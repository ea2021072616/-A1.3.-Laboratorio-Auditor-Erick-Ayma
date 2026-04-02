package com.fotoable.youtube.music.service;

import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.base.BaseService;
import com.fotoable.youtube.music.bean.LocalRecentlyModel;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import com.fotoable.youtube.music.bean.RecentlyWatchBean;
import com.fotoable.youtube.music.helper.localmusic.d;
import com.fotoable.youtube.music.newplayer.b;
import com.fotoable.youtube.music.newplayer.model.LocalMusicModel;
import com.fotoable.youtube.music.newplayer.model.PlayerInfo;
import com.fotoable.youtube.music.ui.activity.MainActivity;
import com.fotoable.youtube.music.util.h;
import com.fotoable.youtube.music.util.l;
import com.fotoable.youtube.music.util.s;
import com.fotoable.youtube.music.util.v;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import javax.inject.Inject;
import rx.schedulers.Schedulers;
/* loaded from: classes.dex */
public class MainService extends BaseService {

    /* renamed from: b  reason: collision with root package name */
    private static final String f3156b = MainService.class.getSimpleName();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    com.fotoable.youtube.music.db.a f3157a;

    /* renamed from: c  reason: collision with root package name */
    private Handler f3158c;
    private a d;

    @Override // com.fotoable.youtube.music.base.BaseService
    protected void d() {
        b().a(this);
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.fotoable.youtube.music.base.BaseService, android.app.Service
    public void onCreate() {
        super.onCreate();
        g();
    }

    @Override // com.fotoable.youtube.music.base.BaseService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            a(intent);
        } catch (ActivityNotFoundException e) {
            ThrowableExtension.printStackTrace(e);
        } catch (OutOfMemoryError e2) {
            ThrowableExtension.printStackTrace(e2);
        }
        return super.onStartCommand(intent, i, i2);
    }

    private void g() {
        this.f3158c = new Handler();
        this.d = new a(this.f3158c);
        h();
        try {
            getContentResolver().registerContentObserver(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, true, this.d);
            getContentResolver().registerContentObserver(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, true, this.d);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends ContentObserver implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private Handler f3163b;

        public a(Handler handler) {
            super(handler);
            this.f3163b = handler;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            h.a(MainService.f3156b, "onChange:" + z);
            this.f3163b.removeCallbacks(this);
            this.f3163b.postDelayed(this, 500L);
        }

        @Override // java.lang.Runnable
        public void run() {
            h.a(MainService.f3156b, "calling refresh!");
            MainService.this.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (l.a().a("android.permission.READ_EXTERNAL_STORAGE") && com.fotoable.youtube.music.a.y()) {
            a(d.a(1).a(s.a()).b(new rx.l<Integer>() { // from class: com.fotoable.youtube.music.service.MainService.1
                @Override // rx.g
                public void onCompleted() {
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(Integer num) {
                    int intValue;
                    if (num != null) {
                        int a2 = v.a((Context) MusicApplication.c(), "LAST_LOCAL_MUSIC_SIZE", -1);
                        if (a2 != -1 && (intValue = num.intValue() - a2) > 0) {
                            b.a(MainService.this, intValue);
                            com.fotoable.youtube.music.helper.localmusic.l.a();
                        }
                        v.b((Context) MusicApplication.c(), "LAST_LOCAL_MUSIC_SIZE", num.intValue());
                    }
                }
            }));
        } else {
            com.fotoable.youtube.music.helper.localmusic.l.b();
        }
    }

    private void i() {
        if (this.d != null) {
            try {
                getContentResolver().unregisterContentObserver(this.d);
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
        }
    }

    public static void a(Context context, String str, String... strArr) {
        try {
            Intent intent = new Intent(context, MainService.class);
            intent.setAction(str);
            if (strArr != null) {
                for (int i = 0; i < strArr.length / 2; i++) {
                    try {
                        int i2 = i * 2;
                        intent.putExtra(strArr[i2], strArr[i2 + 1]);
                    } catch (Exception e) {
                        ThrowableExtension.printStackTrace(e);
                    }
                }
            }
            context.startService(intent);
        } catch (Exception e2) {
            ThrowableExtension.printStackTrace(e2);
        }
    }

    public static void a(Context context, String str, String str2, int i, String str3, int i2) {
        try {
            Intent intent = new Intent(context, MainService.class);
            intent.setAction(str);
            intent.putExtra(str2, i);
            intent.putExtra(str3, i2);
            context.startService(intent);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public static void a(Context context, String str, String str2, Parcelable parcelable, String str3, int i) {
        try {
            Intent intent = new Intent(context, MainService.class);
            intent.setAction(str);
            intent.putExtra(str2, parcelable);
            intent.putExtra(str3, i);
            context.startService(intent);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, boolean z) {
        try {
            Intent intent = new Intent(context, MainService.class);
            intent.setAction(str);
            intent.putExtra(str2, str3);
            intent.putExtra(str4, z);
            context.startService(intent);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public static void a(Context context, String str, String str2, int i) {
        try {
            Intent intent = new Intent(context, MainService.class);
            intent.setAction(str);
            intent.putExtra(str2, i);
            context.startService(intent);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public static void a(Context context, String str, String str2, Parcelable parcelable) {
        try {
            Intent intent = new Intent(context, MainService.class);
            intent.setAction(str);
            intent.putExtra(str2, parcelable);
            context.startService(intent);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, int i, String str5, int i2) {
        try {
            Intent intent = new Intent(context, MainService.class);
            intent.setAction(str);
            intent.putExtra(str2, str3);
            intent.putExtra(str4, i);
            intent.putExtra(str5, i2);
            context.startService(intent);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void a(Intent intent) {
        char c2;
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                switch (action.hashCode()) {
                    case -2137068214:
                        if (action.equals("syn_music_fav")) {
                            c2 = '\r';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1769905999:
                        if (action.equals("syn_youtube_got_it")) {
                            c2 = '\f';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1748084651:
                        if (action.equals("syn_player_info")) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1566348053:
                        if (action.equals("action_pop_up_close")) {
                            c2 = '\n';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1352666059:
                        if (action.equals("syn_player_loop_model")) {
                            c2 = 6;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1289057608:
                        if (action.equals("open_player_page")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -939780245:
                        if (action.equals("action_syn_small_player_red")) {
                            c2 = 11;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -899037672:
                        if (action.equals("action_update_player_page_cover")) {
                            c2 = 18;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -803512226:
                        if (action.equals("full_screen_portrait")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -678869142:
                        if (action.equals("find_mp3")) {
                            c2 = '\b';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -504325460:
                        if (action.equals("open_app")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -22449861:
                        if (action.equals("syn_local_play_recent")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 183651628:
                        if (action.equals("save_data")) {
                            c2 = 15;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 441192025:
                        if (action.equals("find_lyric")) {
                            c2 = 7;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 540615921:
                        if (action.equals("action_syn_youtube_warn_switch")) {
                            c2 = 19;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1482901058:
                        if (action.equals("syn_load_date_state")) {
                            c2 = 14;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1522181839:
                        if (action.equals("syn_play_recent")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1889496311:
                        if (action.equals("action_pop_up_open")) {
                            c2 = '\t';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1912648925:
                        if (action.equals("action_syn_sleep_timer")) {
                            c2 = 16;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2124200590:
                        if (action.equals("action_reset_music_update_notification")) {
                            c2 = 17;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                switch (c2) {
                    case 0:
                        PlayMusicModel playMusicModel = (PlayMusicModel) intent.getParcelableExtra("model");
                        h.b(f3156b, "youtube model:" + playMusicModel);
                        a(playMusicModel);
                        return;
                    case 1:
                        LocalMusicModel localMusicModel = (LocalMusicModel) intent.getParcelableExtra("model");
                        h.a(f3156b, "local model:" + localMusicModel);
                        a(localMusicModel);
                        return;
                    case 2:
                        h.a(f3156b, "主进程收到退出全屏的广播");
                        com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(8003));
                        return;
                    case 3:
                        String str = "";
                        if (intent.hasExtra(ShareConstants.FEED_SOURCE_PARAM)) {
                            str = intent.getStringExtra(ShareConstants.FEED_SOURCE_PARAM);
                        }
                        if (MusicApplication.c().f() != null) {
                            Intent intent2 = new Intent();
                            intent2.setClassName(getPackageName(), MusicApplication.c().f().getCanonicalName());
                            h.a("MusicApplication++", "" + MusicApplication.c().f().getCanonicalName());
                            intent2.addFlags(268435456);
                            intent2.putExtra(ShareConstants.FEED_SOURCE_PARAM, str);
                            try {
                                PendingIntent.getActivity(this, 809810, intent2, 134217728).send();
                                return;
                            } catch (PendingIntent.CanceledException e) {
                                ThrowableExtension.printStackTrace(e);
                                return;
                            }
                        }
                        Intent intent3 = new Intent(this, MainActivity.class);
                        intent3.addFlags(268435456);
                        intent3.addFlags(32768);
                        intent3.putExtra(ShareConstants.FEED_SOURCE_PARAM, str);
                        startActivity(intent3);
                        return;
                    case 4:
                        String str2 = "";
                        if (intent.hasExtra(ShareConstants.FEED_SOURCE_PARAM)) {
                            str2 = intent.getStringExtra(ShareConstants.FEED_SOURCE_PARAM);
                        }
                        if (MusicApplication.c().f() != null) {
                            if (!MusicApplication.c().d()) {
                                Intent intent4 = new Intent();
                                intent4.setClassName(getPackageName(), MusicApplication.c().f().getCanonicalName());
                                h.a("MusicApplication++", "" + MusicApplication.c().f().getCanonicalName());
                                intent4.addFlags(268435456);
                                intent4.putExtra("open_page", "player");
                                intent4.putExtra(ShareConstants.FEED_SOURCE_PARAM, str2);
                                try {
                                    PendingIntent.getActivity(this, 809809, intent4, 134217728).send();
                                    return;
                                } catch (PendingIntent.CanceledException e2) {
                                    ThrowableExtension.printStackTrace(e2);
                                    return;
                                }
                            }
                            return;
                        }
                        Intent intent5 = new Intent(this, MainActivity.class);
                        intent5.addFlags(268435456);
                        intent5.addFlags(32768);
                        intent5.putExtra(ShareConstants.FEED_SOURCE_PARAM, str2);
                        startActivity(intent5);
                        return;
                    case 5:
                        PlayerInfo playerInfo = (PlayerInfo) intent.getParcelableExtra("music");
                        if (playerInfo != null) {
                            com.fotoable.youtube.music.newplayer.d.a().a(playerInfo);
                            com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2005, playerInfo));
                            return;
                        }
                        return;
                    case 6:
                        int intExtra = intent.getIntExtra("model", 0);
                        com.fotoable.youtube.music.a.b(intExtra);
                        com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2007, intExtra));
                        return;
                    case 7:
                        com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2008));
                        return;
                    case '\b':
                        com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2009));
                        return;
                    case '\t':
                        com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(PointerIconCompat.TYPE_ALL_SCROLL));
                        return;
                    case '\n':
                        com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW));
                        return;
                    case 11:
                        com.fotoable.youtube.music.a.g(false);
                        return;
                    case '\f':
                        com.fotoable.youtube.music.a.k(false);
                        return;
                    case '\r':
                        com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2011, intent.getStringExtra("videoId"), intent.getBooleanExtra("isFav", false)));
                        return;
                    case 14:
                        int intExtra2 = intent.getIntExtra(ServerProtocol.DIALOG_PARAM_STATE, -1);
                        PlayerInfo playerInfo2 = (PlayerInfo) intent.getParcelableExtra("model");
                        com.fotoable.youtube.music.newplayer.d.a().a(playerInfo2);
                        com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2010, playerInfo2, intExtra2));
                        return;
                    case 15:
                        int intExtra3 = intent.getIntExtra("last_open_player_type", -1);
                        if (intent.hasExtra("player_service_play_list")) {
                            String stringExtra = intent.getStringExtra("player_service_play_list");
                            if (!TextUtils.isEmpty(stringExtra)) {
                                int intExtra4 = intent.getIntExtra("player_play_list_position", -1);
                                if (!TextUtils.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES, stringExtra)) {
                                    v.b(this, "player_service_play_list", stringExtra);
                                }
                                v.b((Context) this, "player_play_list_position", intExtra4);
                            } else {
                                v.b(this, "player_service_play_list", (String) null);
                                v.b((Context) this, "player_play_list_position", -1);
                            }
                        } else {
                            v.b((Context) this, "last_open_player_type", intExtra3);
                            h.a(f3156b, "last_open_player_type:" + intExtra3);
                        }
                        h.b(f3156b, "主进程保存数据,");
                        return;
                    case 16:
                        int intExtra5 = intent.getIntExtra("time", 0);
                        com.fotoable.youtube.music.newplayer.d.a().a(intExtra5);
                        com.fotoable.youtube.music.newplayer.d.a().b(intent.getIntExtra("type", -1));
                        com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(8004, intExtra5));
                        return;
                    case 17:
                        try {
                            b.b();
                            return;
                        } catch (Exception e3) {
                            ThrowableExtension.printStackTrace(e3);
                            return;
                        }
                    case 18:
                        com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(8005));
                        return;
                    case 19:
                        if (intent.hasExtra(ServerProtocol.DIALOG_PARAM_STATE)) {
                            com.fotoable.youtube.music.a.n(intent.getBooleanExtra(ServerProtocol.DIALOG_PARAM_STATE, false));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private void a(LocalMusicModel localMusicModel) {
        if (localMusicModel != null && this.f3157a != null) {
            try {
                LocalRecentlyModel localRecentlyModel = new LocalRecentlyModel();
                localRecentlyModel.setSongId(Long.valueOf(localMusicModel.getSongId()));
                localRecentlyModel.setModifyTime(Long.valueOf(System.currentTimeMillis()));
                a(this.f3157a.a(localRecentlyModel).a(s.a()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.service.MainService.2
                    @Override // rx.g
                    public void onCompleted() {
                    }

                    @Override // rx.g
                    public void onError(Throwable th) {
                        ThrowableExtension.printStackTrace(th);
                    }

                    @Override // rx.g
                    /* renamed from: a */
                    public void onNext(Boolean bool) {
                        Log.d(MainService.f3156b, "添加本地音乐播放记录");
                    }
                }));
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
        }
    }

    private void a(PlayMusicModel playMusicModel) {
        if (playMusicModel != null && this.f3157a != null) {
            try {
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a((int) PointerIconCompat.TYPE_NO_DROP, playMusicModel.getVideoId()));
                RecentlyWatchBean recentlyWatchBean = new RecentlyWatchBean();
                recentlyWatchBean.setTitle(playMusicModel.getTitle());
                recentlyWatchBean.setDesc(playMusicModel.getDescription());
                recentlyWatchBean.setImgUrl(playMusicModel.getCoverImg());
                recentlyWatchBean.setVideoid(playMusicModel.getVideoId());
                recentlyWatchBean.setDuration(playMusicModel.getDuration());
                recentlyWatchBean.setIsFav(playMusicModel.isFav() ? 1 : 0);
                recentlyWatchBean.setArtists(playMusicModel.getArtists());
                this.f3157a.a(recentlyWatchBean);
                a(this.f3157a.a(recentlyWatchBean).b(Schedulers.io()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.service.MainService.3
                    @Override // rx.g
                    public void onCompleted() {
                    }

                    @Override // rx.g
                    public void onError(Throwable th) {
                        ThrowableExtension.printStackTrace(th);
                        h.a(MainService.f3156b, "添加播放记录失败");
                    }

                    @Override // rx.g
                    /* renamed from: a */
                    public void onNext(Boolean bool) {
                        h.a(MainService.f3156b, "添加播放记录成功");
                    }
                }));
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
        }
    }

    @Override // com.fotoable.youtube.music.base.BaseService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        try {
            e();
            i();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }
}

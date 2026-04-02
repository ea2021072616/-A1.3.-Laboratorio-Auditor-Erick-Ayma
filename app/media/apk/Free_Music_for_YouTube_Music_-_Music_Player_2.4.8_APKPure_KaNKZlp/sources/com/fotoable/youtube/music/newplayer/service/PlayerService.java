package com.fotoable.youtube.music.newplayer.service;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.youtube.music.base.BaseService;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import com.fotoable.youtube.music.c;
import com.fotoable.youtube.music.newplayer.model.LocalMusicModel;
import com.fotoable.youtube.music.newplayer.model.RadioModel;
import com.fotoable.youtube.music.newplayer.receiver.SystemReceiver;
import com.fotoable.youtube.music.newplayer.service.PlayerService;
import com.fotoable.youtube.music.service.MainService;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class PlayerService extends BaseService {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3083a = PlayerService.class.getSimpleName();
    private SystemReceiver d;
    private rx.m g;

    /* renamed from: b  reason: collision with root package name */
    private final IBinder f3084b = new a(this);

    /* renamed from: c  reason: collision with root package name */
    private Handler f3085c = new Handler();
    private long e = 0;
    private int f = -1;

    @Override // com.fotoable.youtube.music.base.BaseService
    protected void d() {
    }

    @Override // com.fotoable.youtube.music.base.BaseService, android.app.Service
    public void onCreate() {
        super.onCreate();
        com.fotoable.youtube.music.newplayer.f.a().a(this, this.f3085c);
        i();
        h();
        com.fotoable.youtube.music.util.h.a(f3083a, "onCreate");
        com.fotoable.youtube.music.newplayer.g.a().a(this);
        f();
    }

    public void f() {
        a(com.fotoable.youtube.music.e.b.a().a(com.fotoable.youtube.music.e.a.class).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<com.fotoable.youtube.music.e.a>() { // from class: com.fotoable.youtube.music.newplayer.service.PlayerService.1
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                if (th != null) {
                    ThrowableExtension.printStackTrace(th);
                    com.fotoable.youtube.music.util.h.a(PlayerService.f3083a, "" + th.toString());
                }
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(com.fotoable.youtube.music.e.a aVar) {
                PlayerService.this.a(aVar);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.fotoable.youtube.music.e.a aVar) {
        if (aVar != null) {
            switch (aVar.f2726a) {
                case 8001:
                    if (aVar.f2727b != null && (aVar.f2727b instanceof PlayMusicModel)) {
                        Intent intent = new Intent(this, MainService.class);
                        intent.setAction("syn_play_recent");
                        intent.putExtra("model", (PlayMusicModel) aVar.f2727b);
                        startService(intent);
                        return;
                    }
                    return;
                case 8002:
                    if (aVar.f2727b != null && (aVar.f2727b instanceof LocalMusicModel)) {
                        Intent intent2 = new Intent(this, MainService.class);
                        intent2.setAction("syn_local_play_recent");
                        intent2.putExtra("model", (LocalMusicModel) aVar.f2727b);
                        startService(intent2);
                        return;
                    }
                    return;
                case 8003:
                    com.fotoable.youtube.music.util.h.a(f3083a, "播放进程收到退出全屏的广播");
                    Intent intent3 = new Intent(this, MainService.class);
                    intent3.setAction("full_screen_portrait");
                    startService(intent3);
                    return;
                default:
                    return;
            }
        }
    }

    private void h() {
        a(rx.f.a(1000L, (long) ExoPlayerFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS, TimeUnit.MILLISECONDS).b(new rx.l<Long>() { // from class: com.fotoable.youtube.music.newplayer.service.PlayerService.2
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(Long l) {
                com.fotoable.youtube.music.newplayer.f.a().c(PlayerService.this);
            }
        }));
    }

    public static void a(Context context, String str, String... strArr) {
        try {
            Intent intent = new Intent(context, PlayerService.class);
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

    @Override // com.fotoable.youtube.music.base.BaseService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        com.fotoable.youtube.music.util.h.a(f3083a, "onStartCommand");
        a(intent);
        return super.onStartCommand(intent, 1, i2);
    }

    private void a(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                com.fotoable.youtube.music.util.h.a(f3083a, "action:" + action);
                char c2 = 65535;
                switch (action.hashCode()) {
                    case -1350953492:
                        if (action.equals("action_change_play_state")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -531846559:
                        if (action.equals("action_change_player_position")) {
                            c2 = '\t';
                            break;
                        }
                        break;
                    case -522012792:
                        if (action.equals("action_prepare_player_html")) {
                            c2 = 7;
                            break;
                        }
                        break;
                    case 353458551:
                        if (action.equals("com.fotoable.youtube.music.video_play_back")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 353820547:
                        if (action.equals("com.fotoable.youtube.music.video_play_next")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 461314479:
                        if (action.equals("com.fotoable.youtube.music.video_play")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 461411965:
                        if (action.equals("com.fotoable.youtube.music.video_stop")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 876995169:
                        if (action.equals("com.fotoable.youtube.music.close")) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case 1898744578:
                        if (action.equals("action_music_locker_state_change")) {
                            c2 = '\b';
                            break;
                        }
                        break;
                    case 2052672825:
                        if (action.equals("action_change_player_size")) {
                            c2 = 0;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        String str = "";
                        if (intent.hasExtra(ShareConstants.FEED_SOURCE_PARAM)) {
                            str = intent.getStringExtra(ShareConstants.FEED_SOURCE_PARAM);
                        }
                        com.fotoable.youtube.music.newplayer.f.a().a(this, str);
                        return;
                    case 1:
                        if (com.fotoable.youtube.music.newplayer.f.a().c() == 770 && !com.fotoable.youtube.music.newplayer.f.a().d()) {
                            com.fotoable.youtube.music.util.h.a(f3083a, "加载数据完成自动播放...2");
                            com.fotoable.youtube.music.newplayer.f.a().x();
                            return;
                        } else if (com.fotoable.youtube.music.newplayer.f.a().c() != 771 && !com.fotoable.youtube.music.newplayer.f.a().d()) {
                            String str2 = "";
                            if (intent.hasExtra(ShareConstants.FEED_SOURCE_PARAM)) {
                                str2 = intent.getStringExtra(ShareConstants.FEED_SOURCE_PARAM);
                            }
                            com.fotoable.youtube.music.newplayer.f.a().a(this, str2);
                            return;
                        } else {
                            boolean booleanExtra = intent.getBooleanExtra("isPlaying", false);
                            if (booleanExtra) {
                                com.fotoable.youtube.music.newplayer.f.a().b(false);
                            } else {
                                com.fotoable.youtube.music.newplayer.f.a().c(false);
                            }
                            com.fotoable.youtube.music.util.h.a(f3083a, "ACTION_CHANGE_PLAY_STATE:::::" + booleanExtra);
                            return;
                        }
                    case 2:
                        if (com.fotoable.youtube.music.newplayer.f.a().c() == 770 && !com.fotoable.youtube.music.newplayer.f.a().d()) {
                            com.fotoable.youtube.music.util.h.a(f3083a, "加载数据完成自动播放...3");
                            com.fotoable.youtube.music.newplayer.f.a().x();
                        } else if (com.fotoable.youtube.music.newplayer.f.a().c() != 771 && !com.fotoable.youtube.music.newplayer.f.a().d()) {
                            com.fotoable.youtube.music.newplayer.f.a().a(this, "notification");
                            return;
                        }
                        com.fotoable.youtube.music.newplayer.f.a().c(false);
                        return;
                    case 3:
                        if (com.fotoable.youtube.music.newplayer.f.a().c() == 770 && !com.fotoable.youtube.music.newplayer.f.a().d()) {
                            com.fotoable.youtube.music.util.h.a(f3083a, "加载数据完成自动播放...4");
                            com.fotoable.youtube.music.newplayer.f.a().x();
                        } else if (com.fotoable.youtube.music.newplayer.f.a().c() != 771 && !com.fotoable.youtube.music.newplayer.f.a().d()) {
                            com.fotoable.youtube.music.newplayer.f.a().a(this, "notification");
                            return;
                        }
                        com.fotoable.youtube.music.newplayer.f.a().b(false);
                        return;
                    case 4:
                        if (com.fotoable.youtube.music.newplayer.f.a().c() == 770 && !com.fotoable.youtube.music.newplayer.f.a().d()) {
                            com.fotoable.youtube.music.util.h.a(f3083a, "加载数据完成自动播放据...5");
                            com.fotoable.youtube.music.newplayer.f.a().x();
                        } else if (com.fotoable.youtube.music.newplayer.f.a().c() != 771 && !com.fotoable.youtube.music.newplayer.f.a().d()) {
                            com.fotoable.youtube.music.newplayer.f.a().a(this, "notification");
                            return;
                        }
                        com.fotoable.youtube.music.newplayer.f.a().d(false);
                        return;
                    case 5:
                        if (com.fotoable.youtube.music.newplayer.f.a().c() == 770 && !com.fotoable.youtube.music.newplayer.f.a().d()) {
                            com.fotoable.youtube.music.util.h.a(f3083a, "加载数据完成自动播放...6");
                            com.fotoable.youtube.music.newplayer.f.a().x();
                        } else if (com.fotoable.youtube.music.newplayer.f.a().c() != 771 && !com.fotoable.youtube.music.newplayer.f.a().d()) {
                            com.fotoable.youtube.music.newplayer.f.a().a(this, "notification");
                            return;
                        }
                        com.fotoable.youtube.music.newplayer.f.a().e(false);
                        return;
                    case 6:
                        com.fotoable.youtube.music.newplayer.c.a().a(true);
                        com.fotoable.youtube.music.newplayer.f.a().w();
                        com.fotoable.youtube.music.newplayer.c.a().a(this);
                        return;
                    case 7:
                        try {
                            com.fotoable.youtube.music.newplayer.d.c.a().b(this);
                            return;
                        } catch (Exception e) {
                            ThrowableExtension.printStackTrace(e);
                            com.fotoable.youtube.music.util.b.a(e);
                            return;
                        }
                    case '\b':
                        com.fotoable.youtube.music.a.h(intent.getBooleanExtra(ServerProtocol.DIALOG_PARAM_STATE, true));
                        return;
                    case '\t':
                        com.fotoable.youtube.music.newplayer.f.a().e(intent.getIntExtra("position", 0));
                        return;
                    default:
                        return;
                }
            }
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return this.f3084b;
    }

    private void i() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        this.d = new SystemReceiver();
        registerReceiver(this.d, intentFilter);
        com.fotoable.youtube.music.util.h.a(f3083a, "注册锁屏状态&按键广播");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        k();
        com.fotoable.youtube.music.newplayer.f.a().a(false);
        this.g = rx.f.a(1000L, 1000L, TimeUnit.MILLISECONDS).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Long>() { // from class: com.fotoable.youtube.music.newplayer.service.PlayerService.3
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(Long l) {
                PlayerService.this.e--;
                if (PlayerService.this.e >= 0) {
                    MainService.a(PlayerService.this, "action_syn_sleep_timer", "time", (int) PlayerService.this.e, "type", PlayerService.this.f);
                    return;
                }
                if (com.fotoable.youtube.music.newplayer.f.a().g()) {
                    com.fotoable.youtube.music.newplayer.f.a().a(true);
                    com.fotoable.youtube.music.newplayer.f.a().r();
                    com.fotoable.youtube.music.newplayer.f.a().a(false);
                } else {
                    com.fotoable.youtube.music.newplayer.f.a().a(true);
                    if (!com.fotoable.youtube.music.a.j()) {
                        com.fotoable.youtube.music.newplayer.f.a().r();
                        com.fotoable.youtube.music.newplayer.f.a().a(PlayerService.this);
                        com.fotoable.youtube.music.newplayer.f.a().a(false);
                    }
                }
                PlayerService.this.k();
                MainService.a(PlayerService.this, "action_syn_sleep_timer", "time", 0, "type", PlayerService.this.f);
            }
        });
        a(this.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.g != null && !this.g.isUnsubscribed()) {
            this.g.unsubscribe();
        }
        MainService.a(this, "action_syn_sleep_timer", "time", 0, "type", this.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends c.a {

        /* renamed from: b  reason: collision with root package name */
        private final WeakReference<PlayerService> f3090b;

        public a(PlayerService playerService) {
            this.f3090b = new WeakReference<>(playerService);
        }

        @Override // com.fotoable.youtube.music.c
        public void a(final List<PlayMusicModel> list, final int i) throws RemoteException {
            PlayerService.this.f3085c.post(new Runnable() { // from class: com.fotoable.youtube.music.newplayer.service.PlayerService.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.fotoable.youtube.music.newplayer.f.a().a(list, i);
                }
            });
        }

        @Override // com.fotoable.youtube.music.c
        public void a(final PlayMusicModel playMusicModel) throws RemoteException {
            PlayerService.this.f3085c.post(new Runnable() { // from class: com.fotoable.youtube.music.newplayer.service.PlayerService.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.fotoable.youtube.music.newplayer.f.a().a(playMusicModel);
                }
            });
        }

        @Override // com.fotoable.youtube.music.c
        public void a(final List<PlayMusicModel> list) throws RemoteException {
            PlayerService.this.f3085c.post(new Runnable() { // from class: com.fotoable.youtube.music.newplayer.service.PlayerService.a.3
                @Override // java.lang.Runnable
                public void run() {
                    com.fotoable.youtube.music.newplayer.f.a().a(list);
                }
            });
        }

        @Override // com.fotoable.youtube.music.c
        public void b(final PlayMusicModel playMusicModel) throws RemoteException {
            PlayerService.this.f3085c.post(new Runnable() { // from class: com.fotoable.youtube.music.newplayer.service.PlayerService.a.4
                @Override // java.lang.Runnable
                public void run() {
                    com.fotoable.youtube.music.newplayer.f.a().b(playMusicModel);
                }
            });
        }

        @Override // com.fotoable.youtube.music.c
        public List<PlayMusicModel> a() throws RemoteException {
            return com.fotoable.youtube.music.newplayer.f.a().i();
        }

        @Override // com.fotoable.youtube.music.c
        public List<PlayMusicModel> b() throws RemoteException {
            return com.fotoable.youtube.music.newplayer.f.a().j();
        }

        @Override // com.fotoable.youtube.music.c
        public void a(final String str, final boolean z) throws RemoteException {
            PlayerService.this.f3085c.post(new Runnable(str, z) { // from class: com.fotoable.youtube.music.newplayer.service.a

                /* renamed from: a  reason: collision with root package name */
                private final String f3100a;

                /* renamed from: b  reason: collision with root package name */
                private final boolean f3101b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f3100a = str;
                    this.f3101b = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.fotoable.youtube.music.newplayer.f.a().a(this.f3100a, this.f3101b);
                }
            });
        }

        @Override // com.fotoable.youtube.music.c
        public void a(final int i) throws RemoteException {
            PlayerService.this.f3085c.post(new Runnable(i) { // from class: com.fotoable.youtube.music.newplayer.service.b

                /* renamed from: a  reason: collision with root package name */
                private final int f3102a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f3102a = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.fotoable.youtube.music.newplayer.f.a().b(this.f3102a);
                }
            });
        }

        @Override // com.fotoable.youtube.music.c
        public void b(final List<LocalMusicModel> list, final int i) throws RemoteException {
            PlayerService.this.f3085c.post(new Runnable(list, i) { // from class: com.fotoable.youtube.music.newplayer.service.l

                /* renamed from: a  reason: collision with root package name */
                private final List f3113a;

                /* renamed from: b  reason: collision with root package name */
                private final int f3114b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f3113a = list;
                    this.f3114b = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.fotoable.youtube.music.newplayer.f.a().b(this.f3113a, this.f3114b);
                }
            });
        }

        @Override // com.fotoable.youtube.music.c
        public void a(final LocalMusicModel localMusicModel) throws RemoteException {
            PlayerService.this.f3085c.post(new Runnable(localMusicModel) { // from class: com.fotoable.youtube.music.newplayer.service.m

                /* renamed from: a  reason: collision with root package name */
                private final LocalMusicModel f3115a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f3115a = localMusicModel;
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.fotoable.youtube.music.newplayer.f.a().a(this.f3115a);
                }
            });
        }

        @Override // com.fotoable.youtube.music.c
        public void b(final List<LocalMusicModel> list) throws RemoteException {
            PlayerService.this.f3085c.post(new Runnable(list) { // from class: com.fotoable.youtube.music.newplayer.service.n

                /* renamed from: a  reason: collision with root package name */
                private final List f3116a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f3116a = list;
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.fotoable.youtube.music.newplayer.f.a().b(this.f3116a);
                }
            });
        }

        @Override // com.fotoable.youtube.music.c
        public void b(final LocalMusicModel localMusicModel) throws RemoteException {
            PlayerService.this.f3085c.post(new Runnable(localMusicModel) { // from class: com.fotoable.youtube.music.newplayer.service.o

                /* renamed from: a  reason: collision with root package name */
                private final LocalMusicModel f3117a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f3117a = localMusicModel;
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.fotoable.youtube.music.newplayer.f.a().b(this.f3117a);
                }
            });
        }

        @Override // com.fotoable.youtube.music.c
        public List<LocalMusicModel> c() throws RemoteException {
            return com.fotoable.youtube.music.newplayer.f.a().k();
        }

        @Override // com.fotoable.youtube.music.c
        public List<LocalMusicModel> d() throws RemoteException {
            return com.fotoable.youtube.music.newplayer.f.a().l();
        }

        @Override // com.fotoable.youtube.music.c
        public void a(final long j) throws RemoteException {
            PlayerService.this.f3085c.post(new Runnable(j) { // from class: com.fotoable.youtube.music.newplayer.service.p

                /* renamed from: a  reason: collision with root package name */
                private final long f3118a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f3118a = j;
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.fotoable.youtube.music.newplayer.f.a().a(this.f3118a);
                }
            });
        }

        @Override // com.fotoable.youtube.music.c
        public void b(final int i) throws RemoteException {
            PlayerService.this.f3085c.post(new Runnable(i) { // from class: com.fotoable.youtube.music.newplayer.service.q

                /* renamed from: a  reason: collision with root package name */
                private final int f3119a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f3119a = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.fotoable.youtube.music.newplayer.f.a().c(this.f3119a);
                }
            });
        }

        @Override // com.fotoable.youtube.music.c
        public void a(final int i, final boolean z) throws RemoteException {
            PlayerService.this.f3085c.post(new Runnable(i, z) { // from class: com.fotoable.youtube.music.newplayer.service.r

                /* renamed from: a  reason: collision with root package name */
                private final int f3120a;

                /* renamed from: b  reason: collision with root package name */
                private final boolean f3121b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f3120a = i;
                    this.f3121b = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.fotoable.youtube.music.newplayer.f.a().a(this.f3120a, this.f3121b);
                }
            });
        }

        @Override // com.fotoable.youtube.music.c
        public void a(final RadioModel radioModel) throws RemoteException {
            PlayerService.this.f3085c.post(new Runnable(radioModel) { // from class: com.fotoable.youtube.music.newplayer.service.s

                /* renamed from: a  reason: collision with root package name */
                private final RadioModel f3122a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f3122a = radioModel;
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.fotoable.youtube.music.newplayer.f.a().a(this.f3122a);
                }
            });
        }

        @Override // com.fotoable.youtube.music.c
        public RadioModel e() throws RemoteException {
            return com.fotoable.youtube.music.newplayer.f.a().m();
        }

        @Override // com.fotoable.youtube.music.c
        public int f() throws RemoteException {
            return com.fotoable.youtube.music.newplayer.f.a().n();
        }

        @Override // com.fotoable.youtube.music.c
        public PlayMusicModel g() throws RemoteException {
            return com.fotoable.youtube.music.newplayer.f.a().o();
        }

        @Override // com.fotoable.youtube.music.c
        public LocalMusicModel h() throws RemoteException {
            return com.fotoable.youtube.music.newplayer.f.a().p();
        }

        @Override // com.fotoable.youtube.music.c
        public RadioModel i() throws RemoteException {
            return com.fotoable.youtube.music.newplayer.f.a().q();
        }

        @Override // com.fotoable.youtube.music.c
        public void j() throws RemoteException {
            PlayerService.this.f3085c.post(c.f3103a);
        }

        @Override // com.fotoable.youtube.music.c
        public void k() throws RemoteException {
            PlayerService.this.f3085c.post(d.f3104a);
        }

        @Override // com.fotoable.youtube.music.c
        public void l() throws RemoteException {
            PlayerService.this.f3085c.post(e.f3105a);
        }

        @Override // com.fotoable.youtube.music.c
        public void m() throws RemoteException {
            PlayerService.this.f3085c.post(f.f3106a);
        }

        @Override // com.fotoable.youtube.music.c
        public void c(final int i) throws RemoteException {
            PlayerService.this.f3085c.post(new Runnable(i) { // from class: com.fotoable.youtube.music.newplayer.service.g

                /* renamed from: a  reason: collision with root package name */
                private final int f3107a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f3107a = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.fotoable.youtube.music.newplayer.f.a().f(this.f3107a);
                }
            });
        }

        @Override // com.fotoable.youtube.music.c
        public void d(final int i) throws RemoteException {
            PlayerService.this.f3085c.post(new Runnable(this, i) { // from class: com.fotoable.youtube.music.newplayer.service.h

                /* renamed from: a  reason: collision with root package name */
                private final PlayerService.a f3108a;

                /* renamed from: b  reason: collision with root package name */
                private final int f3109b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f3108a = this;
                    this.f3109b = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f3108a.h(this.f3109b);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final /* synthetic */ void h(int i) {
            com.fotoable.youtube.music.a.b(i);
            com.fotoable.youtube.music.newplayer.f.a().g(i);
            MainService.a(PlayerService.this, "action_update_player_page_cover", new String[0]);
        }

        @Override // com.fotoable.youtube.music.c
        public void n() throws RemoteException {
            PlayerService.this.f3085c.post(i.f3110a);
        }

        @Override // com.fotoable.youtube.music.c
        public void e(final int i) throws RemoteException {
            PlayerService.this.f3085c.post(new Runnable(i) { // from class: com.fotoable.youtube.music.newplayer.service.j

                /* renamed from: a  reason: collision with root package name */
                private final int f3111a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f3111a = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.fotoable.youtube.music.newplayer.f.a().d(this.f3111a);
                }
            });
        }

        @Override // com.fotoable.youtube.music.c
        public void a(boolean z) throws RemoteException {
            com.fotoable.youtube.music.a.i(z);
        }

        @Override // com.fotoable.youtube.music.c
        public void f(int i) throws RemoteException {
        }

        @Override // com.fotoable.youtube.music.c
        public void o() throws RemoteException {
            PlayerService.this.f3085c.post(k.f3112a);
        }

        @Override // com.fotoable.youtube.music.c
        public void b(boolean z) throws RemoteException {
            com.fotoable.youtube.music.newplayer.f.a().f(z);
        }

        @Override // com.fotoable.youtube.music.c
        public void c(boolean z) throws RemoteException {
            com.fotoable.youtube.music.a.q(z);
        }

        @Override // com.fotoable.youtube.music.c
        public void a(int i, long j) throws RemoteException {
            PlayerService.this.e = j;
            PlayerService.this.f = i;
            if (PlayerService.this.e <= 0) {
                PlayerService.this.k();
                MainService.a(PlayerService.this, "action_syn_sleep_timer", "time", 0, "type", PlayerService.this.f);
                return;
            }
            PlayerService.this.j();
        }

        @Override // com.fotoable.youtube.music.c
        public void d(boolean z) throws RemoteException {
            com.fotoable.youtube.music.a.c(z);
        }

        @Override // com.fotoable.youtube.music.c
        public void e(boolean z) throws RemoteException {
            com.fotoable.youtube.music.newplayer.f.a().g(z);
        }

        @Override // com.fotoable.youtube.music.c
        public void f(boolean z) throws RemoteException {
            com.fotoable.youtube.music.a.b(z);
        }
    }

    @Override // com.fotoable.youtube.music.base.BaseService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        try {
            com.fotoable.youtube.music.newplayer.f.a().u();
            if (this.d != null) {
                unregisterReceiver(this.d);
                this.d = null;
            }
            com.fotoable.youtube.music.newplayer.g.a().b();
            com.fotoable.youtube.music.util.h.a(f3083a, "******播放服务被销毁******");
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }
}

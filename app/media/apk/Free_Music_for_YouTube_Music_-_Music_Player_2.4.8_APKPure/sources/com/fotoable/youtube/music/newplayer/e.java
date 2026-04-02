package com.fotoable.youtube.music.newplayer;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.view.InputDeviceCompat;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import com.fotoable.youtube.music.c;
import com.fotoable.youtube.music.newplayer.model.LocalMusicModel;
import com.fotoable.youtube.music.newplayer.model.RadioModel;
import com.fotoable.youtube.music.newplayer.service.PlayerService;
import com.fotoable.youtube.music.util.h;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;
/* compiled from: PlayerFeatureHelper.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2938a = e.class.getSimpleName();
    private static final e h = new e();
    private com.fotoable.youtube.music.c d;
    private Context e;

    /* renamed from: b  reason: collision with root package name */
    private int f2939b = InputDeviceCompat.SOURCE_KEYBOARD;

    /* renamed from: c  reason: collision with root package name */
    private int f2940c = InputDeviceCompat.SOURCE_DPAD;
    private boolean f = false;
    private ServiceConnection i = new ServiceConnection() { // from class: com.fotoable.youtube.music.newplayer.e.12
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            e.this.f2939b = 259;
            e.this.d = c.a.a(iBinder);
            h.a(e.f2938a, "连接播放器," + e.this.d);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            e.this.f2939b = InputDeviceCompat.SOURCE_KEYBOARD;
            e.this.d = null;
            h.a(e.f2938a, "断开播放器");
        }
    };
    private boolean j = false;
    private PriorityBlockingQueue<a> g = new PriorityBlockingQueue<>();

    public static e a() {
        return h;
    }

    private e() {
        k();
    }

    private synchronized void k() {
        if (this.f2940c == 513) {
            this.f2940c = 514;
            new Thread(new Runnable() { // from class: com.fotoable.youtube.music.newplayer.e.1
                @Override // java.lang.Runnable
                public void run() {
                    a aVar;
                    e.this.f2940c = 515;
                    while (!e.this.f) {
                        try {
                            aVar = (a) e.this.g.take();
                        } catch (InterruptedException e) {
                            ThrowableExtension.printStackTrace(e);
                        } catch (Exception e2) {
                            ThrowableExtension.printStackTrace(e2);
                        }
                        if (aVar == null && e.this.f) {
                            h.a(e.f2938a, "任务为空或队列销毁");
                            break;
                        } else {
                            aVar.a();
                            h.a(e.f2938a, "执行");
                        }
                    }
                    e.this.f2940c = InputDeviceCompat.SOURCE_DPAD;
                }
            }).start();
        }
    }

    private synchronized void l() {
        if (this.g == null) {
            this.g = new PriorityBlockingQueue<>();
        }
        m();
        k();
    }

    public synchronized void a(Context context) {
        this.e = context;
        m();
        this.j = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
        if (r4.e == null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized void m() {
        /*
            r4 = this;
            r1 = 257(0x101, float:3.6E-43)
            monitor-enter(r4)
            android.content.Context r0 = r4.e     // Catch: java.lang.Throwable -> L41
            if (r0 != 0) goto L13
            com.fotoable.youtube.music.MusicApplication r0 = com.fotoable.youtube.music.MusicApplication.c()     // Catch: java.lang.Throwable -> L41
            r4.e = r0     // Catch: java.lang.Throwable -> L41
            android.content.Context r0 = r4.e     // Catch: java.lang.Throwable -> L41
            if (r0 != 0) goto L13
        L11:
            monitor-exit(r4)
            return
        L13:
            com.fotoable.youtube.music.c r0 = r4.d     // Catch: java.lang.Throwable -> L41
            if (r0 == 0) goto L1b
            int r0 = r4.f2939b     // Catch: java.lang.Throwable -> L41
            if (r0 != r1) goto L11
        L1b:
            r0 = 258(0x102, float:3.62E-43)
            r4.f2939b = r0     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L41
            android.content.Intent r0 = new android.content.Intent     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L41
            android.content.Context r1 = r4.e     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L41
            java.lang.Class<com.fotoable.youtube.music.newplayer.service.PlayerService> r2 = com.fotoable.youtube.music.newplayer.service.PlayerService.class
            r0.<init>(r1, r2)     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L41
            android.content.Context r1 = r4.e     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L41
            android.content.ServiceConnection r2 = r4.i     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L41
            r3 = 1
            r1.bindService(r0, r2, r3)     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L41
            java.lang.String r0 = com.fotoable.youtube.music.newplayer.e.f2938a     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L41
            java.lang.String r1 = "qxs:Application启动连接PlayerService"
            com.fotoable.youtube.music.util.h.a(r0, r1)     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L41
            goto L11
        L38:
            r0 = move-exception
            com.google.devtools.build.android.desugar.runtime.ThrowableExtension.printStackTrace(r0)     // Catch: java.lang.Throwable -> L41
            r0 = 257(0x101, float:3.6E-43)
            r4.f2939b = r0     // Catch: java.lang.Throwable -> L41
            goto L11
        L41:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fotoable.youtube.music.newplayer.e.m():void");
    }

    public void a(final List<PlayMusicModel> list, final int i) {
        if (list != null && list.size() != 0) {
            l();
            this.g.offer(new a() { // from class: com.fotoable.youtube.music.newplayer.e.23
                @Override // com.fotoable.youtube.music.newplayer.a
                public void a() {
                    if (e.this.d != null) {
                        try {
                            h.a(e.f2938a, "执行跨进程任务playNowYoutube");
                            e.this.d.a(list, i);
                            return;
                        } catch (DeadObjectException e) {
                            ThrowableExtension.printStackTrace(e);
                            e.this.f2939b = InputDeviceCompat.SOURCE_KEYBOARD;
                            return;
                        } catch (RemoteException e2) {
                            ThrowableExtension.printStackTrace(e2);
                            return;
                        }
                    }
                    h.a(e.f2938a, "playerService is null");
                }
            });
        }
    }

    public void a(final PlayMusicModel playMusicModel) {
        if (playMusicModel != null) {
            l();
            this.g.offer(new a() { // from class: com.fotoable.youtube.music.newplayer.e.27
                @Override // com.fotoable.youtube.music.newplayer.a
                public void a() {
                    if (e.this.d != null) {
                        try {
                            h.a(e.f2938a, "执行跨进程任务playNextYoutube");
                            e.this.d.a(playMusicModel);
                            return;
                        } catch (DeadObjectException e) {
                            ThrowableExtension.printStackTrace(e);
                            e.this.f2939b = InputDeviceCompat.SOURCE_KEYBOARD;
                            return;
                        } catch (RemoteException e2) {
                            ThrowableExtension.printStackTrace(e2);
                            return;
                        }
                    }
                    h.a(e.f2938a, "playerService is null");
                }
            });
        }
    }

    public void a(final List<PlayMusicModel> list) {
        if (list != null && list.size() != 0) {
            l();
            this.g.offer(new a() { // from class: com.fotoable.youtube.music.newplayer.e.28
                @Override // com.fotoable.youtube.music.newplayer.a
                public void a() {
                    if (e.this.d != null) {
                        try {
                            h.a(e.f2938a, "执行跨进程任务playAllYoutube");
                            e.this.d.a(list);
                            return;
                        } catch (DeadObjectException e) {
                            ThrowableExtension.printStackTrace(e);
                            e.this.f2939b = InputDeviceCompat.SOURCE_KEYBOARD;
                            return;
                        } catch (RemoteException e2) {
                            ThrowableExtension.printStackTrace(e2);
                            return;
                        }
                    }
                    h.a(e.f2938a, "playerService is null");
                }
            });
        }
    }

    public void b(final PlayMusicModel playMusicModel) {
        if (playMusicModel != null) {
            l();
            this.g.offer(new a() { // from class: com.fotoable.youtube.music.newplayer.e.29
                @Override // com.fotoable.youtube.music.newplayer.a
                public void a() {
                    if (e.this.d != null) {
                        try {
                            h.a(e.f2938a, "执行跨进程任务addToPlayQueueYoutube");
                            e.this.d.b(playMusicModel);
                            return;
                        } catch (DeadObjectException e) {
                            ThrowableExtension.printStackTrace(e);
                            e.this.f2939b = InputDeviceCompat.SOURCE_KEYBOARD;
                            return;
                        } catch (RemoteException e2) {
                            ThrowableExtension.printStackTrace(e2);
                            return;
                        }
                    }
                    h.a(e.f2938a, "playerService is null");
                }
            });
        }
    }

    public List<PlayMusicModel> b() {
        h.a(f2938a, "执行跨进程任务getYoutubeAll");
        if (this.d == null) {
            return null;
        }
        try {
            return this.d.a();
        } catch (RemoteException e) {
            ThrowableExtension.printStackTrace(e);
            return null;
        }
    }

    public void a(final String str, final boolean z) {
        l();
        this.g.offer(new a() { // from class: com.fotoable.youtube.music.newplayer.e.30
            @Override // com.fotoable.youtube.music.newplayer.a
            public void a() {
                if (e.this.d != null) {
                    try {
                        h.a(e.f2938a, "执行跨进程任务changeFavState");
                        e.this.d.a(str, z);
                        return;
                    } catch (DeadObjectException e) {
                        ThrowableExtension.printStackTrace(e);
                        e.this.f2939b = InputDeviceCompat.SOURCE_KEYBOARD;
                        return;
                    } catch (RemoteException e2) {
                        ThrowableExtension.printStackTrace(e2);
                        return;
                    }
                }
                h.a(e.f2938a, "playerService is null");
            }
        });
    }

    public void a(final int i) {
        l();
        this.g.offer(new a() { // from class: com.fotoable.youtube.music.newplayer.e.31
            @Override // com.fotoable.youtube.music.newplayer.a
            public void a() {
                if (e.this.d != null) {
                    try {
                        h.a(e.f2938a, "执行跨进程任务changePlayerVisiable:" + i);
                        e.this.d.a(i);
                        return;
                    } catch (DeadObjectException e) {
                        ThrowableExtension.printStackTrace(e);
                        e.this.f2939b = InputDeviceCompat.SOURCE_KEYBOARD;
                        return;
                    } catch (RemoteException e2) {
                        ThrowableExtension.printStackTrace(e2);
                        return;
                    }
                }
                h.a(e.f2938a, "playerService is null");
            }
        });
    }

    public void b(final List<LocalMusicModel> list, final int i) {
        if (list != null && list.size() != 0) {
            l();
            this.g.offer(new a() { // from class: com.fotoable.youtube.music.newplayer.e.32
                @Override // com.fotoable.youtube.music.newplayer.a
                public void a() {
                    if (e.this.d != null) {
                        try {
                            h.a(e.f2938a, "执行跨进程任务playNowLocalMusic");
                            e.this.d.b(list, i);
                            return;
                        } catch (DeadObjectException e) {
                            ThrowableExtension.printStackTrace(e);
                            e.this.f2939b = InputDeviceCompat.SOURCE_KEYBOARD;
                            return;
                        } catch (RemoteException e2) {
                            ThrowableExtension.printStackTrace(e2);
                            return;
                        }
                    }
                    h.a(e.f2938a, "playerService is null");
                }
            });
        }
    }

    public void a(final LocalMusicModel localMusicModel) {
        if (localMusicModel != null) {
            l();
            this.g.offer(new a() { // from class: com.fotoable.youtube.music.newplayer.e.2
                @Override // com.fotoable.youtube.music.newplayer.a
                public void a() {
                    if (e.this.d != null) {
                        try {
                            h.a(e.f2938a, "执行跨进程任务playNextLocalMusic");
                            e.this.d.a(localMusicModel);
                            return;
                        } catch (DeadObjectException e) {
                            ThrowableExtension.printStackTrace(e);
                            e.this.f2939b = InputDeviceCompat.SOURCE_KEYBOARD;
                            return;
                        } catch (RemoteException e2) {
                            ThrowableExtension.printStackTrace(e2);
                            return;
                        }
                    }
                    h.a(e.f2938a, "playerService is null");
                }
            });
        }
    }

    public void b(final List<LocalMusicModel> list) {
        if (list != null && list.size() != 0) {
            l();
            this.g.offer(new a() { // from class: com.fotoable.youtube.music.newplayer.e.3
                @Override // com.fotoable.youtube.music.newplayer.a
                public void a() {
                    if (e.this.d != null) {
                        try {
                            h.a(e.f2938a, "执行跨进程任务playAllLocalMusic");
                            e.this.d.b(list);
                            return;
                        } catch (DeadObjectException e) {
                            ThrowableExtension.printStackTrace(e);
                            e.this.f2939b = InputDeviceCompat.SOURCE_KEYBOARD;
                            return;
                        } catch (RemoteException e2) {
                            ThrowableExtension.printStackTrace(e2);
                            return;
                        }
                    }
                    h.a(e.f2938a, "playerService is null");
                }
            });
        }
    }

    public void b(final LocalMusicModel localMusicModel) {
        if (localMusicModel != null) {
            l();
            this.g.offer(new a() { // from class: com.fotoable.youtube.music.newplayer.e.4
                @Override // com.fotoable.youtube.music.newplayer.a
                public void a() {
                    if (e.this.d != null) {
                        try {
                            h.a(e.f2938a, "执行跨进程任务addToPlayQueueLocalMusic");
                            e.this.d.b(localMusicModel);
                            return;
                        } catch (DeadObjectException e) {
                            ThrowableExtension.printStackTrace(e);
                            e.this.f2939b = InputDeviceCompat.SOURCE_KEYBOARD;
                            return;
                        } catch (RemoteException e2) {
                            ThrowableExtension.printStackTrace(e2);
                            return;
                        }
                    }
                    h.a(e.f2938a, "playerService is null");
                }
            });
        }
    }

    public List<LocalMusicModel> c() {
        h.a(f2938a, "执行跨进程任务getLocalMusicAll");
        if (this.d == null) {
            return null;
        }
        try {
            return this.d.c();
        } catch (RemoteException e) {
            ThrowableExtension.printStackTrace(e);
            return null;
        }
    }

    public void a(final long j) {
        l();
        this.g.offer(new a() { // from class: com.fotoable.youtube.music.newplayer.e.5
            @Override // com.fotoable.youtube.music.newplayer.a
            public void a() {
                if (e.this.d != null) {
                    try {
                        h.a(e.f2938a, "执行跨进程任务deleteLocal");
                        e.this.d.a(j);
                        return;
                    } catch (DeadObjectException e) {
                        ThrowableExtension.printStackTrace(e);
                        e.this.f2939b = InputDeviceCompat.SOURCE_KEYBOARD;
                        return;
                    } catch (RemoteException e2) {
                        ThrowableExtension.printStackTrace(e2);
                        return;
                    }
                }
                h.a(e.f2938a, "playerService is null");
            }
        });
    }

    public void b(final int i) {
        l();
        this.g.offer(new a() { // from class: com.fotoable.youtube.music.newplayer.e.6
            @Override // com.fotoable.youtube.music.newplayer.a
            public void a() {
                if (e.this.d != null) {
                    try {
                        h.a(e.f2938a, "执行跨进程任务delete");
                        e.this.d.b(i);
                        return;
                    } catch (DeadObjectException e) {
                        ThrowableExtension.printStackTrace(e);
                        e.this.f2939b = InputDeviceCompat.SOURCE_KEYBOARD;
                        return;
                    } catch (RemoteException e2) {
                        ThrowableExtension.printStackTrace(e2);
                        return;
                    }
                }
                h.a(e.f2938a, "playerService is null");
            }
        });
    }

    public void a(final int i, final boolean z) {
        l();
        this.g.offer(new a() { // from class: com.fotoable.youtube.music.newplayer.e.7
            @Override // com.fotoable.youtube.music.newplayer.a
            public void a() {
                if (e.this.d != null) {
                    try {
                        h.a(e.f2938a, "执行跨进程任务clickPlay");
                        e.this.d.a(i, z);
                        return;
                    } catch (DeadObjectException e) {
                        ThrowableExtension.printStackTrace(e);
                        e.this.f2939b = InputDeviceCompat.SOURCE_KEYBOARD;
                        return;
                    } catch (RemoteException e2) {
                        ThrowableExtension.printStackTrace(e2);
                        return;
                    }
                }
                h.a(e.f2938a, "playerService is null");
            }
        });
    }

    public void a(final RadioModel radioModel) {
        if (radioModel != null) {
            l();
            this.g.offer(new a() { // from class: com.fotoable.youtube.music.newplayer.e.8
                @Override // com.fotoable.youtube.music.newplayer.a
                public void a() {
                    if (e.this.d != null) {
                        try {
                            h.a(e.f2938a, "执行跨进程任务playRadio");
                            e.this.d.a(radioModel);
                            return;
                        } catch (DeadObjectException e) {
                            ThrowableExtension.printStackTrace(e);
                            e.this.f2939b = InputDeviceCompat.SOURCE_KEYBOARD;
                            return;
                        } catch (RemoteException e2) {
                            ThrowableExtension.printStackTrace(e2);
                            return;
                        }
                    }
                    h.a(e.f2938a, "playerService is null");
                }
            });
        }
    }

    public int d() {
        if (this.d == null) {
            return 0;
        }
        try {
            return this.d.f();
        } catch (RemoteException e) {
            ThrowableExtension.printStackTrace(e);
            return 0;
        }
    }

    public PlayMusicModel e() {
        if (this.d == null) {
            return null;
        }
        try {
            return this.d.g();
        } catch (RemoteException e) {
            ThrowableExtension.printStackTrace(e);
            return null;
        }
    }

    public LocalMusicModel f() {
        if (this.d == null) {
            return null;
        }
        try {
            return this.d.h();
        } catch (RemoteException e) {
            ThrowableExtension.printStackTrace(e);
            return null;
        }
    }

    public RadioModel g() {
        if (this.d == null) {
            return null;
        }
        try {
            return this.d.i();
        } catch (RemoteException e) {
            ThrowableExtension.printStackTrace(e);
            return null;
        }
    }

    public void a(boolean z) {
        l();
        this.g.offer(new a() { // from class: com.fotoable.youtube.music.newplayer.e.9
            @Override // com.fotoable.youtube.music.newplayer.a
            public void a() {
                if (e.this.d != null) {
                    try {
                        h.a(e.f2938a, "执行跨进程任务play");
                        e.this.d.j();
                        return;
                    } catch (DeadObjectException e) {
                        ThrowableExtension.printStackTrace(e);
                        e.this.f2939b = InputDeviceCompat.SOURCE_KEYBOARD;
                        return;
                    } catch (RemoteException e2) {
                        ThrowableExtension.printStackTrace(e2);
                        return;
                    }
                }
                h.a(e.f2938a, "playerService is null");
            }
        });
    }

    public void b(boolean z) {
        l();
        this.g.offer(new a() { // from class: com.fotoable.youtube.music.newplayer.e.10
            @Override // com.fotoable.youtube.music.newplayer.a
            public void a() {
                if (e.this.d != null) {
                    try {
                        h.a(e.f2938a, "执行跨进程任务pause");
                        e.this.d.k();
                        return;
                    } catch (DeadObjectException e) {
                        ThrowableExtension.printStackTrace(e);
                        e.this.f2939b = InputDeviceCompat.SOURCE_KEYBOARD;
                        return;
                    } catch (RemoteException e2) {
                        ThrowableExtension.printStackTrace(e2);
                        return;
                    }
                }
                h.a(e.f2938a, "playerService is null");
            }
        });
    }

    public void c(boolean z) {
        l();
        this.g.offer(new a() { // from class: com.fotoable.youtube.music.newplayer.e.11
            @Override // com.fotoable.youtube.music.newplayer.a
            public void a() {
                if (e.this.d != null) {
                    try {
                        h.a(e.f2938a, "执行跨进程任务previous");
                        e.this.d.l();
                        return;
                    } catch (DeadObjectException e) {
                        ThrowableExtension.printStackTrace(e);
                        e.this.f2939b = InputDeviceCompat.SOURCE_KEYBOARD;
                        return;
                    } catch (RemoteException e2) {
                        ThrowableExtension.printStackTrace(e2);
                        return;
                    }
                }
                h.a(e.f2938a, "playerService is null");
            }
        });
    }

    public void d(boolean z) {
        l();
        this.g.offer(new a() { // from class: com.fotoable.youtube.music.newplayer.e.13
            @Override // com.fotoable.youtube.music.newplayer.a
            public void a() {
                if (e.this.d != null) {
                    try {
                        h.a(e.f2938a, "执行跨进程任务next");
                        e.this.d.m();
                        return;
                    } catch (DeadObjectException e) {
                        ThrowableExtension.printStackTrace(e);
                        e.this.f2939b = InputDeviceCompat.SOURCE_KEYBOARD;
                        return;
                    } catch (RemoteException e2) {
                        ThrowableExtension.printStackTrace(e2);
                        return;
                    }
                }
                h.a(e.f2938a, "playerService is null");
            }
        });
    }

    public void h() {
        l();
        this.g.offer(new a() { // from class: com.fotoable.youtube.music.newplayer.e.14
            @Override // com.fotoable.youtube.music.newplayer.a
            public void a() {
                if (e.this.d != null) {
                    try {
                        h.a(e.f2938a, "执行跨进程任务clearAll");
                        e.this.d.n();
                        return;
                    } catch (DeadObjectException e) {
                        ThrowableExtension.printStackTrace(e);
                        e.this.f2939b = InputDeviceCompat.SOURCE_KEYBOARD;
                        return;
                    } catch (RemoteException e2) {
                        ThrowableExtension.printStackTrace(e2);
                        return;
                    }
                }
                h.a(e.f2938a, "playerService is null");
            }
        });
    }

    public void c(final int i) {
        l();
        this.g.offer(new a() { // from class: com.fotoable.youtube.music.newplayer.e.15
            @Override // com.fotoable.youtube.music.newplayer.a
            public void a() {
                if (e.this.d != null) {
                    try {
                        h.a(e.f2938a, "执行跨进程任务fullScreen");
                        e.this.d.e(i);
                        return;
                    } catch (DeadObjectException e) {
                        ThrowableExtension.printStackTrace(e);
                        e.this.f2939b = InputDeviceCompat.SOURCE_KEYBOARD;
                        return;
                    } catch (RemoteException e2) {
                        ThrowableExtension.printStackTrace(e2);
                        return;
                    }
                }
                h.a(e.f2938a, "playerService is null");
            }
        });
    }

    public void a(Context context, int i) {
        if (context != null) {
            try {
                Intent intent = new Intent(context, PlayerService.class);
                intent.setAction("action_change_player_position");
                intent.putExtra("position", i);
                context.startService(intent);
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
        }
    }

    public void d(final int i) {
        l();
        this.g.offer(new a() { // from class: com.fotoable.youtube.music.newplayer.e.16
            @Override // com.fotoable.youtube.music.newplayer.a
            public void a() {
                if (e.this.d != null) {
                    try {
                        h.a(e.f2938a, "执行跨进程任务changePlayerPosition:" + i);
                        e.this.d.f(i);
                        return;
                    } catch (DeadObjectException e) {
                        ThrowableExtension.printStackTrace(e);
                        e.this.f2939b = InputDeviceCompat.SOURCE_KEYBOARD;
                        return;
                    } catch (RemoteException e2) {
                        ThrowableExtension.printStackTrace(e2);
                        return;
                    }
                }
                h.a(e.f2938a, "playerService is null");
            }
        });
    }

    public void e(final int i) {
        l();
        this.g.offer(new a() { // from class: com.fotoable.youtube.music.newplayer.e.17
            @Override // com.fotoable.youtube.music.newplayer.a
            public void a() {
                if (e.this.d != null) {
                    try {
                        h.a(e.f2938a, "执行跨进程任务seekTo");
                        e.this.d.c(i);
                        return;
                    } catch (DeadObjectException e) {
                        ThrowableExtension.printStackTrace(e);
                        e.this.f2939b = InputDeviceCompat.SOURCE_KEYBOARD;
                        return;
                    } catch (RemoteException e2) {
                        ThrowableExtension.printStackTrace(e2);
                        return;
                    }
                }
                h.a(e.f2938a, "playerService is null");
            }
        });
    }

    public void f(final int i) {
        l();
        this.g.offer(new a() { // from class: com.fotoable.youtube.music.newplayer.e.18
            @Override // com.fotoable.youtube.music.newplayer.a
            public void a() {
                if (e.this.d != null) {
                    try {
                        h.a(e.f2938a, "执行跨进程任务changeLoopModel");
                        e.this.d.d(i);
                        return;
                    } catch (DeadObjectException e) {
                        ThrowableExtension.printStackTrace(e);
                        e.this.f2939b = InputDeviceCompat.SOURCE_KEYBOARD;
                        return;
                    } catch (RemoteException e2) {
                        ThrowableExtension.printStackTrace(e2);
                        return;
                    }
                }
                h.a(e.f2938a, "playerService is null");
            }
        });
    }

    public void i() {
        l();
        this.g.offer(new a() { // from class: com.fotoable.youtube.music.newplayer.e.19
            @Override // com.fotoable.youtube.music.newplayer.a
            public void a() {
                if (e.this.d != null) {
                    try {
                        h.a(e.f2938a, "执行跨进程任务requestPlayerState");
                        e.this.d.o();
                        return;
                    } catch (DeadObjectException e) {
                        ThrowableExtension.printStackTrace(e);
                        e.this.f2939b = InputDeviceCompat.SOURCE_KEYBOARD;
                        return;
                    } catch (RemoteException e2) {
                        ThrowableExtension.printStackTrace(e2);
                        return;
                    }
                }
                h.a(e.f2938a, "playerService is null");
            }
        });
    }

    public void e(final boolean z) {
        l();
        this.g.offer(new a() { // from class: com.fotoable.youtube.music.newplayer.e.20
            @Override // com.fotoable.youtube.music.newplayer.a
            public void a() {
                if (e.this.d != null) {
                    try {
                        h.a(e.f2938a, "执行跨进程任务setIsInMainPage:" + z);
                        e.this.d.b(z);
                        return;
                    } catch (DeadObjectException e) {
                        ThrowableExtension.printStackTrace(e);
                        e.this.f2939b = InputDeviceCompat.SOURCE_KEYBOARD;
                        return;
                    } catch (RemoteException e2) {
                        ThrowableExtension.printStackTrace(e2);
                        return;
                    }
                }
                h.a(e.f2938a, "playerService is null");
            }
        });
    }

    public void f(final boolean z) {
        l();
        this.g.offer(new a() { // from class: com.fotoable.youtube.music.newplayer.e.21
            @Override // com.fotoable.youtube.music.newplayer.a
            public void a() {
                if (e.this.d != null) {
                    try {
                        h.a(e.f2938a, "执行跨进程任务changeAutoPlayState");
                        e.this.d.c(z);
                        return;
                    } catch (DeadObjectException e) {
                        ThrowableExtension.printStackTrace(e);
                        e.this.f2939b = InputDeviceCompat.SOURCE_KEYBOARD;
                        return;
                    } catch (RemoteException e2) {
                        ThrowableExtension.printStackTrace(e2);
                        return;
                    }
                }
                h.a(e.f2938a, "playerService is null");
            }
        });
    }

    public void a(final int i, final long j) {
        l();
        this.g.offer(new a() { // from class: com.fotoable.youtube.music.newplayer.e.22
            @Override // com.fotoable.youtube.music.newplayer.a
            public void a() {
                if (e.this.d != null) {
                    try {
                        h.a(e.f2938a, "执行跨进程任务requestSleepTimer");
                        e.this.d.a(i, j);
                        return;
                    } catch (DeadObjectException e) {
                        ThrowableExtension.printStackTrace(e);
                        e.this.f2939b = InputDeviceCompat.SOURCE_KEYBOARD;
                        return;
                    } catch (RemoteException e2) {
                        ThrowableExtension.printStackTrace(e2);
                        return;
                    }
                }
                h.a(e.f2938a, "playerService is null");
            }
        });
    }

    public void g(final boolean z) {
        l();
        this.g.offer(new a() { // from class: com.fotoable.youtube.music.newplayer.e.24
            @Override // com.fotoable.youtube.music.newplayer.a
            public void a() {
                if (e.this.d != null) {
                    try {
                        h.a(e.f2938a, "执行跨进程任务changeTimerEndState");
                        e.this.d.d(z);
                        return;
                    } catch (DeadObjectException e) {
                        ThrowableExtension.printStackTrace(e);
                        e.this.f2939b = InputDeviceCompat.SOURCE_KEYBOARD;
                        return;
                    } catch (RemoteException e2) {
                        ThrowableExtension.printStackTrace(e2);
                        return;
                    }
                }
                h.a(e.f2938a, "playerService is null");
            }
        });
    }

    public void h(final boolean z) {
        l();
        this.g.offer(new a() { // from class: com.fotoable.youtube.music.newplayer.e.25
            @Override // com.fotoable.youtube.music.newplayer.a
            public void a() {
                if (e.this.d != null) {
                    try {
                        h.a(e.f2938a, "执行跨进程任务setInPlayPage");
                        e.this.d.e(z);
                        return;
                    } catch (DeadObjectException e) {
                        ThrowableExtension.printStackTrace(e);
                        e.this.f2939b = InputDeviceCompat.SOURCE_KEYBOARD;
                        return;
                    } catch (RemoteException e2) {
                        ThrowableExtension.printStackTrace(e2);
                        return;
                    }
                }
                h.a(e.f2938a, "playerService is null");
            }
        });
    }

    public void i(final boolean z) {
        l();
        this.g.offer(new a() { // from class: com.fotoable.youtube.music.newplayer.e.26
            @Override // com.fotoable.youtube.music.newplayer.a
            public void a() {
                if (e.this.d != null) {
                    try {
                        h.a(e.f2938a, "执行跨进程任务enableCharingLocker");
                        e.this.d.f(z);
                        return;
                    } catch (DeadObjectException e) {
                        ThrowableExtension.printStackTrace(e);
                        e.this.f2939b = InputDeviceCompat.SOURCE_KEYBOARD;
                        return;
                    } catch (RemoteException e2) {
                        ThrowableExtension.printStackTrace(e2);
                        return;
                    }
                }
                h.a(e.f2938a, "playerService is null");
            }
        });
    }
}

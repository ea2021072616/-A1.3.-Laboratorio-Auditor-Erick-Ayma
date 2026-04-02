package com.fotoable.youtube.music.newplayer;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Handler;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import com.fotoable.youtube.music.newplayer.model.LocalMusicModel;
import com.fotoable.youtube.music.newplayer.model.PlayerInfo;
import com.fotoable.youtube.music.newplayer.model.RadioModel;
import com.fotoable.youtube.music.service.MainService;
import com.fotoable.youtube.music.util.h;
import com.fotoable.youtube.music.util.v;
import java.util.List;
/* compiled from: PlayerManager.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3002a = f.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static final f f3003b = new f();
    private Context d;
    private Handler e;
    private KeyguardManager i;
    private boolean l;
    private int m;

    /* renamed from: c  reason: collision with root package name */
    private int f3004c = 1;
    private int f = 769;
    private boolean g = false;
    private boolean h = false;
    private boolean j = false;
    private boolean k = true;

    public static f a() {
        return f3003b;
    }

    private f() {
    }

    public void a(Context context, Handler handler) {
        this.d = context;
        this.e = handler;
        com.fotoable.youtube.music.newplayer.b.f.a().a(context);
        com.fotoable.youtube.music.newplayer.d.c.a().a(context);
        com.fotoable.youtube.music.newplayer.d.a.a().a(context, handler);
        com.fotoable.youtube.music.newplayer.d.b.a().a(context, handler);
        D();
    }

    public void a(int i) {
        a(i, (PlayerInfo) null);
    }

    public void a(int i, PlayerInfo playerInfo) {
        this.f = i;
        if (this.f == 770) {
            h.a(f3002a, "正在加载数据......");
        } else if (this.f == 771) {
            h.a(f3002a, "加载数据......成功");
            if (this.j) {
                b(false);
            }
        } else if (this.f == 772) {
            h.a(f3002a, "加载数据......失败");
        }
        if (playerInfo != null) {
            MainService.a(this.d, "syn_load_date_state", "model", playerInfo, ServerProtocol.DIALOG_PARAM_STATE, i);
        }
    }

    public void a(boolean z) {
        this.g = z;
    }

    public boolean b() {
        return this.g;
    }

    public int c() {
        return this.f;
    }

    public boolean d() {
        return this.h;
    }

    private void D() {
        this.f3004c = v.a(this.d, "last_open_player_type", -1);
        if (this.f3004c == 2) {
            a(770);
            com.fotoable.youtube.music.newplayer.b.f.a().b(this.d);
            h.a(f3002a, "开始加载缓存数据1");
        } else if (this.f3004c == 3) {
            a(770);
            com.fotoable.youtube.music.newplayer.b.b.a().a(this.d);
            h.a(f3002a, "开始加载缓存数据2");
        } else if (this.f3004c == 4) {
            a(770);
            com.fotoable.youtube.music.newplayer.b.d.a().a(this.d);
            h.a(f3002a, "开始加载缓存数据3");
        } else {
            h.a(f3002a, "加载缓存数据无数据4，" + this.f3004c);
            a(772);
        }
    }

    private boolean d(Context context) {
        if (context == null) {
            return false;
        }
        if (this.i == null) {
            this.i = (KeyguardManager) context.getSystemService("keyguard");
        }
        boolean inKeyguardRestrictedInputMode = this.i.inKeyguardRestrictedInputMode();
        if (inKeyguardRestrictedInputMode) {
            c.a().a(context, com.fotoable.youtube.music.newplayer.b.f.a().e());
            return inKeyguardRestrictedInputMode;
        }
        return inKeyguardRestrictedInputMode;
    }

    public void a(List<PlayMusicModel> list, int i) {
        E();
        i(2);
        com.fotoable.youtube.music.newplayer.b.f.a().a(list, i);
        com.fotoable.youtube.music.newplayer.d.c.a().a(this.d, true);
    }

    public void a(PlayMusicModel playMusicModel) {
        E();
        i(2);
        com.fotoable.youtube.music.newplayer.b.f.a().a(playMusicModel);
        com.fotoable.youtube.music.newplayer.d.c.a().a(this.d, true);
    }

    public void a(List<PlayMusicModel> list) {
        E();
        i(2);
        com.fotoable.youtube.music.newplayer.b.f.a().a(list);
        com.fotoable.youtube.music.newplayer.d.c.a().a(this.d, true);
    }

    public void b(PlayMusicModel playMusicModel) {
        E();
        i(2);
        com.fotoable.youtube.music.newplayer.b.f.a().b(playMusicModel);
        com.fotoable.youtube.music.newplayer.d.c.a().a(this.d, true);
    }

    public boolean e() {
        return this.f3004c == 2;
    }

    public boolean f() {
        return this.f3004c == 3;
    }

    public boolean g() {
        return this.f3004c == 4;
    }

    private synchronized void i(int i) {
        if (this.f3004c != i) {
            if (this.f3004c == 3) {
                com.fotoable.youtube.music.newplayer.d.a.a().b(false);
            } else if (this.f3004c == 4) {
                com.fotoable.youtube.music.newplayer.d.b.a().b(false);
            } else if (this.f3004c == 2) {
                com.fotoable.youtube.music.newplayer.d.c.a().b(false);
                this.e.post(new Runnable() { // from class: com.fotoable.youtube.music.newplayer.f.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.fotoable.youtube.music.newplayer.d.c.a().d(f.this.d);
                    }
                });
            }
        }
        this.f3004c = i;
        MainService.a(this.d, "save_data", "", "", "player_play_list_position", -1, "last_open_player_type", this.f3004c);
        this.h = true;
        v.b(this.d, "last_open_player_type", this.f3004c);
    }

    public void h() {
        this.f3004c = -1;
    }

    public List<PlayMusicModel> i() {
        return com.fotoable.youtube.music.newplayer.b.f.a().b();
    }

    public List<PlayMusicModel> j() {
        return com.fotoable.youtube.music.newplayer.b.f.a().c();
    }

    public void a(String str, boolean z) {
        if (this.f3004c == 2) {
            com.fotoable.youtube.music.newplayer.b.f.a().a(str, z);
        }
    }

    public void b(int i) {
        if (this.f3004c == 2) {
            com.fotoable.youtube.music.newplayer.d.c.a().d(i);
        }
    }

    public void b(List<LocalMusicModel> list, int i) {
        E();
        i(3);
        com.fotoable.youtube.music.newplayer.b.b.a().a(list, i);
    }

    public void a(LocalMusicModel localMusicModel) {
        E();
        i(3);
        com.fotoable.youtube.music.newplayer.b.b.a().a(localMusicModel);
    }

    public void b(List<LocalMusicModel> list) {
        E();
        i(3);
        com.fotoable.youtube.music.newplayer.b.b.a().a(list);
    }

    public void b(LocalMusicModel localMusicModel) {
        E();
        i(3);
        com.fotoable.youtube.music.newplayer.b.b.a().b(localMusicModel);
    }

    public List<LocalMusicModel> k() {
        return com.fotoable.youtube.music.newplayer.b.b.a().c();
    }

    public List<LocalMusicModel> l() {
        return com.fotoable.youtube.music.newplayer.b.b.a().d();
    }

    public void a(long j) {
        E();
        com.fotoable.youtube.music.newplayer.b.b.a().a(j);
    }

    public void c(int i) {
        E();
        if (this.f3004c == 2) {
            com.fotoable.youtube.music.newplayer.b.f.a().a(i);
        } else if (this.f3004c == 3) {
            com.fotoable.youtube.music.newplayer.b.b.a().a(i);
        } else if (this.f3004c == 4) {
            com.fotoable.youtube.music.newplayer.b.d.a().a(i);
        }
    }

    public void a(int i, boolean z) {
        E();
        if (this.f3004c == 2) {
            com.fotoable.youtube.music.newplayer.b.f.a().b(i);
            if (z()) {
                com.fotoable.youtube.music.newplayer.d.c.a().a(this.d, false);
            } else {
                com.fotoable.youtube.music.newplayer.d.c.a().a(this.d, false, z);
            }
        } else if (this.f3004c == 3) {
            com.fotoable.youtube.music.newplayer.b.b.a().b(i);
        } else if (this.f3004c == 4) {
            com.fotoable.youtube.music.newplayer.b.d.a().b(i);
        }
        this.h = true;
    }

    public void a(RadioModel radioModel) {
        E();
        i(4);
        com.fotoable.youtube.music.newplayer.b.d.a().a(radioModel);
    }

    public RadioModel m() {
        return com.fotoable.youtube.music.newplayer.b.d.a().c();
    }

    public int n() {
        return this.f3004c;
    }

    public PlayMusicModel o() {
        return com.fotoable.youtube.music.newplayer.b.f.a().e();
    }

    public LocalMusicModel p() {
        return com.fotoable.youtube.music.newplayer.b.b.a().e();
    }

    public RadioModel q() {
        return com.fotoable.youtube.music.newplayer.b.d.a().c();
    }

    public void b(boolean z) {
        E();
        if (this.f3004c == 2) {
            if (!d(this.d)) {
                com.fotoable.youtube.music.newplayer.d.c.a().a(z);
                com.fotoable.youtube.music.newplayer.d.c.a().a(this.d, false);
                this.h = true;
            }
        } else if (this.f3004c == 3) {
            com.fotoable.youtube.music.newplayer.d.a.a().a(z);
            this.h = true;
        } else if (this.f3004c == 4) {
            com.fotoable.youtube.music.newplayer.d.b.a().a(z);
            this.h = true;
        }
    }

    public void c(boolean z) {
        E();
        if (this.f3004c == 2) {
            if (!d(this.d)) {
                com.fotoable.youtube.music.newplayer.d.c.a().b(z);
                com.fotoable.youtube.music.newplayer.d.c.a().a(this.d, false);
            }
        } else if (this.f3004c == 3) {
            com.fotoable.youtube.music.newplayer.d.a.a().b(z);
        } else if (this.f3004c == 4) {
            com.fotoable.youtube.music.newplayer.d.b.a().b(z);
        }
    }

    public void r() {
        E();
        if (this.f3004c == 2) {
            com.fotoable.youtube.music.newplayer.d.c.a().b(false);
            com.fotoable.youtube.music.newplayer.d.c.a().a(this.d, false);
        } else if (this.f3004c == 3) {
            com.fotoable.youtube.music.newplayer.d.a.a().b(false);
        } else if (this.f3004c == 4) {
            com.fotoable.youtube.music.newplayer.d.b.a().b(false);
        }
    }

    public void d(boolean z) {
        PlayMusicModel a2;
        E();
        if (this.f3004c == 2) {
            if (!d(this.d) && (a2 = com.fotoable.youtube.music.newplayer.b.f.a().a(true)) != null) {
                com.fotoable.youtube.music.newplayer.d.c.a().a(a2, z);
                com.fotoable.youtube.music.newplayer.d.c.a().a(this.d, false);
                this.h = true;
            }
        } else if (this.f3004c == 3) {
            LocalMusicModel a3 = com.fotoable.youtube.music.newplayer.b.b.a().a(true);
            if (a3 != null) {
                com.fotoable.youtube.music.newplayer.d.a.a().a(a3, z);
                this.h = true;
            }
        } else {
            if (this.f3004c == 4) {
            }
        }
    }

    public void e(boolean z) {
        PlayMusicModel b2;
        E();
        if (this.f3004c == 2) {
            if (!d(this.d) && (b2 = com.fotoable.youtube.music.newplayer.b.f.a().b(true)) != null) {
                com.fotoable.youtube.music.newplayer.d.c.a().a(b2, z);
                com.fotoable.youtube.music.newplayer.d.c.a().a(this.d, false);
                this.h = true;
            }
        } else if (this.f3004c == 3) {
            LocalMusicModel b3 = com.fotoable.youtube.music.newplayer.b.b.a().b(true);
            if (b3 != null) {
                com.fotoable.youtube.music.newplayer.d.a.a().a(b3, z);
                this.h = true;
            }
        } else {
            if (this.f3004c == 4) {
            }
        }
    }

    public void s() {
        E();
        if (this.f3004c == 2) {
            com.fotoable.youtube.music.newplayer.b.f.a().f();
            com.fotoable.youtube.music.newplayer.d.c.a().b(false);
            com.fotoable.youtube.music.newplayer.d.c.a().e(this.d);
            i(-1);
        } else if (this.f3004c == 3) {
            com.fotoable.youtube.music.newplayer.b.b.a().f();
            i(-1);
        } else if (this.f3004c == 4) {
            com.fotoable.youtube.music.newplayer.b.d.a().d();
            i(-1);
        }
        v.b(this.d, "player_service_play_list", (String) null);
        v.b(this.d, "player_play_list_position", -1);
    }

    public void d(int i) {
        E();
        if (this.f3004c == 2) {
            com.fotoable.youtube.music.newplayer.d.c.a().c(i);
        }
    }

    public void e(int i) {
        this.m = i;
        if (this.f3004c == 2) {
            com.fotoable.youtube.music.newplayer.d.c.a().b(i);
        }
        if (i == 2404) {
            h.a(f3002a, "移动到屏幕外");
        } else if (i == 2401) {
            h.a(f3002a, "移动到左下角");
        } else if (i == 2402) {
            h.a(f3002a, "移动到播放页位置");
        } else if (i == 2403) {
            h.a(f3002a, "移动到省电模式之前的位置");
        }
    }

    public void f(int i) {
        if (this.f3004c == 2) {
            com.fotoable.youtube.music.newplayer.d.c.a().a(i);
            this.h = true;
        } else if (this.f3004c == 3) {
            com.fotoable.youtube.music.newplayer.d.a.a().a(i);
            this.h = true;
        } else if (this.f3004c == 4) {
            com.fotoable.youtube.music.newplayer.d.b.a().a(i);
            this.h = true;
        }
    }

    public void g(int i) {
        if (this.f3004c == 2) {
            com.fotoable.youtube.music.newplayer.b.f.a().c(i);
        } else if (this.f3004c == 3) {
            com.fotoable.youtube.music.newplayer.b.b.a().c(i);
        } else if (this.f3004c == 4) {
            com.fotoable.youtube.music.newplayer.b.d.a().c(i);
        }
    }

    private void E() {
        c.a().a(false);
    }

    public void t() {
        if (this.f3004c == 2) {
            com.fotoable.youtube.music.newplayer.d.c.a().b();
        } else if (this.f3004c == 3) {
            com.fotoable.youtube.music.newplayer.d.a.a().d();
        } else if (this.f3004c == 4) {
            com.fotoable.youtube.music.newplayer.d.b.a().d();
        }
    }

    public void u() {
    }

    public void a(Context context) {
        if (this.f3004c == 2) {
            com.fotoable.youtube.music.newplayer.d.c.a().d(context);
            com.fotoable.youtube.music.newplayer.d.c.a().j(context);
        }
    }

    public void b(Context context) {
        if (this.f3004c == 2) {
            com.fotoable.youtube.music.newplayer.d.c.a().f(context);
            com.fotoable.youtube.music.newplayer.d.c.a().d(context);
        }
    }

    public void v() {
        E();
        if (this.f3004c == 2) {
            com.fotoable.youtube.music.newplayer.d.c.a().g();
        }
    }

    public void a(Context context, String str) {
        MainService.a(context, "open_player_page", ShareConstants.FEED_SOURCE_PARAM, str);
    }

    public void c(Context context) {
        v.b(context, "last_open_player_type", this.f3004c);
        if (this.f3004c == 2) {
            com.fotoable.youtube.music.newplayer.b.f.a().c(context);
        } else if (this.f3004c == 3) {
            com.fotoable.youtube.music.newplayer.b.b.a().b(context);
        } else if (this.f3004c == 4) {
            com.fotoable.youtube.music.newplayer.b.d.a().b(context);
        }
    }

    public void w() {
        if (this.f3004c == 2) {
            com.fotoable.youtube.music.newplayer.d.c.a().e(this.d);
            com.fotoable.youtube.music.newplayer.d.c.a().n(this.d);
        } else if (this.f3004c == 3) {
            com.fotoable.youtube.music.newplayer.d.a.a().b();
        } else if (this.f3004c == 4) {
            com.fotoable.youtube.music.newplayer.d.b.a().b();
        }
    }

    public void x() {
        this.j = true;
    }

    public void y() {
        if (e()) {
            com.fotoable.youtube.music.newplayer.d.c.a().o(this.d);
        }
    }

    public void f(boolean z) {
        this.k = z;
    }

    public void g(boolean z) {
        this.l = z;
        if (this.l) {
            h.a(f3002a, "在播放界面");
        } else {
            h.a(f3002a, "不在播放界面");
        }
    }

    public boolean z() {
        return this.l;
    }

    public boolean A() {
        if (this.f3004c == 2) {
            return com.fotoable.youtube.music.newplayer.d.c.a().i();
        }
        if (this.f3004c == 3) {
            return com.fotoable.youtube.music.newplayer.d.a.a().c();
        }
        if (this.f3004c == 4) {
            return com.fotoable.youtube.music.newplayer.d.b.a().c();
        }
        return false;
    }

    public boolean B() {
        if (this.f3004c == 2) {
            return false;
        }
        if (this.f3004c == 3) {
            return com.fotoable.youtube.music.newplayer.d.a.a().c();
        }
        if (this.f3004c == 4) {
            return com.fotoable.youtube.music.newplayer.d.b.a().c();
        }
        return false;
    }

    public int C() {
        return this.m;
    }

    public void h(int i) {
        this.m = i;
    }
}

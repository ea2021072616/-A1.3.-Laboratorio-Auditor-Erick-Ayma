package com.fotoable.youtube.music.newplayer.b;

import android.content.Context;
import android.text.TextUtils;
import com.fotoable.youtube.music.newplayer.model.PlayerInfo;
import com.fotoable.youtube.music.newplayer.model.RadioModel;
import com.fotoable.youtube.music.service.MainService;
import com.fotoable.youtube.music.util.h;
import com.fotoable.youtube.music.util.s;
import com.fotoable.youtube.music.util.v;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import rx.f;
import rx.l;
/* compiled from: RadioData.java */
/* loaded from: classes.dex */
public class d extends a<RadioModel> {
    private static final String e = d.class.getSimpleName();
    private static final d j = new d();
    public Integer d;
    private int f;
    private int k;
    private RadioModel l;

    /* renamed from: b  reason: collision with root package name */
    public List<RadioModel> f2863b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public Map<Integer, RadioModel> f2864c = new HashMap();
    private boolean g = false;
    private boolean h = false;
    private Random i = new Random();

    public static d a() {
        return j;
    }

    private d() {
        b();
    }

    public void b() {
        this.f2863b = new ArrayList();
        this.f2864c = new HashMap();
        this.d = -1;
        this.f = -1;
    }

    public void a(final Context context) {
        a(rx.f.a(new f.a(context) { // from class: com.fotoable.youtube.music.newplayer.b.e

            /* renamed from: a  reason: collision with root package name */
            private final Context f2870a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2870a = context;
            }

            @Override // rx.c.b
            public void call(Object obj) {
                d.a(this.f2870a, (l) obj);
            }
        }).a(s.a()).b(new l<RadioModel>() { // from class: com.fotoable.youtube.music.newplayer.b.d.1

            /* renamed from: b  reason: collision with root package name */
            private long f2866b;

            @Override // rx.l
            public void onStart() {
                super.onStart();
                this.f2866b = System.currentTimeMillis();
            }

            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
                h.a(d.e, "读取缓存播放队列失败");
                com.fotoable.youtube.music.newplayer.f.a().a(772);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(RadioModel radioModel) {
                h.a(d.e, "读取缓存播放队列成功," + (radioModel != null ? radioModel.toString() + "" : "null"));
                if (radioModel != null) {
                    d.this.l = radioModel;
                    com.fotoable.youtube.music.newplayer.d.b.a().a(d.this.l);
                    PlayerInfo playerInfo = new PlayerInfo();
                    playerInfo.covert(d.this.l);
                    com.fotoable.youtube.music.newplayer.f.a().a(771, playerInfo);
                } else {
                    com.fotoable.youtube.music.newplayer.f.a().a(772);
                }
                h.a(d.e, "读取缓存使用时间：" + (System.currentTimeMillis() - this.f2866b));
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(Context context, l lVar) {
        String a2 = v.a(context, "player_service_play_list", (String) null);
        if (!TextUtils.isEmpty(a2)) {
            RadioModel radioModel = (RadioModel) new Gson().fromJson(a2, (Class<Object>) RadioModel.class);
            if (lVar != null && !lVar.isUnsubscribed()) {
                if (radioModel != null) {
                    lVar.onNext(radioModel);
                    lVar.onCompleted();
                    return;
                }
                lVar.onError(new NullPointerException("没有缓存数据"));
            }
        } else if (lVar != null && !lVar.isUnsubscribed()) {
            lVar.onError(new NullPointerException("没有缓存数据"));
        }
    }

    public void b(final Context context) {
        if (this.g) {
            this.g = false;
            a(rx.f.a((f.a) new f.a<Boolean>() { // from class: com.fotoable.youtube.music.newplayer.b.d.3
                @Override // rx.c.b
                /* renamed from: a */
                public void call(l<? super Boolean> lVar) {
                    String json = new Gson().toJson(d.this.l);
                    if (!TextUtils.isEmpty(json)) {
                        v.b(context, "player_play_list_position", d.this.f);
                        v.b(context, "player_service_play_list", json);
                        MainService.a(context, "save_data", "player_service_play_list", json, "player_play_list_position", d.this.f, "last_open_player_type", v.a(context, "last_open_player_type", -1));
                    } else {
                        v.b(context, "player_play_list_position", -1);
                        v.b(context, "player_service_play_list", (String) null);
                        MainService.a(context, "save_data", "player_service_play_list", "", "player_play_list_position", -1, "last_open_player_type", v.a(context, "last_open_player_type", -1));
                    }
                    h.a(d.e, "last_open_player_type" + v.a(context, "last_open_player_type", -1));
                    if (lVar != null && !lVar.isUnsubscribed()) {
                        lVar.onNext(true);
                        lVar.onCompleted();
                    }
                }
            }).a(s.a()).b(new l<Boolean>() { // from class: com.fotoable.youtube.music.newplayer.b.d.2
                @Override // rx.g
                public void onCompleted() {
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                    h.a(d.e, "保存数据失败");
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(Boolean bool) {
                    h.a(d.e, "保存数据成功");
                }
            }));
        } else if (this.h) {
            this.h = false;
        }
    }

    public RadioModel c() {
        return this.l;
    }

    public RadioModel a(boolean z) {
        RadioModel radioModel = null;
        if (this.f2863b.size() != 0) {
            if (com.fotoable.youtube.music.a.w() == 0 || (z && (com.fotoable.youtube.music.a.w() == 0 || com.fotoable.youtube.music.a.w() == 1))) {
                if (this.f + 1 < this.f2863b.size()) {
                    this.f++;
                } else {
                    this.f = 0;
                }
                radioModel = this.f2863b.get(this.f);
            } else if (com.fotoable.youtube.music.a.w() == 1) {
                if (this.f >= 0 && this.f < this.f2863b.size()) {
                    radioModel = this.f2863b.get(this.f);
                }
                if (radioModel == null && this.f2863b.size() > 0) {
                    radioModel = this.f2863b.get(0);
                    this.f = 0;
                }
            } else if ((com.fotoable.youtube.music.a.w() == 2 || (z && com.fotoable.youtube.music.a.w() == 2)) && this.f2863b.size() > 0) {
                this.f = this.i.nextInt(this.f2863b.size());
                radioModel = this.f2863b.get(this.f);
            }
            if (radioModel != null) {
                this.d = Integer.valueOf(radioModel.getId());
            } else {
                this.d = -1;
                this.f = -1;
            }
            this.h = true;
        }
        return radioModel;
    }

    public void a(int i) {
        if (i >= 0 && i < this.f2863b.size()) {
            RadioModel remove = this.f2863b.remove(i);
            if (remove != null) {
                this.f2864c.remove(Integer.valueOf(remove.getId()));
                this.g = true;
            }
            h.a(e, "删除本地播放列表：" + i + "    " + this.f);
            if (i < this.f) {
                this.f--;
            } else if (i == this.f) {
                this.f--;
                RadioModel a2 = a(true);
                if (a2 != null) {
                    com.fotoable.youtube.music.newplayer.d.b.a().a(a2, false);
                }
            }
        }
    }

    public void b(int i) {
        if (i >= 0 && i < this.f2863b.size()) {
            RadioModel radioModel = this.f2863b.get(i);
            if (radioModel != null) {
                this.f = i;
                this.d = Integer.valueOf(radioModel.getId());
                com.fotoable.youtube.music.newplayer.d.b.a().a(radioModel, false);
            }
            this.h = true;
        }
    }

    public void c(int i) {
        this.k = i;
    }

    public void d() {
        b();
        com.fotoable.youtube.music.newplayer.d.b.a().b(false);
        com.fotoable.youtube.music.newplayer.d.b.a().a((RadioModel) null);
        this.l = null;
        this.g = true;
    }

    public void a(RadioModel radioModel) {
        this.l = radioModel;
        com.fotoable.youtube.music.newplayer.d.b.a().a(radioModel, true);
        this.g = true;
    }
}

package com.fotoable.youtube.music.newplayer.b;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.fotoable.youtube.music.newplayer.model.LocalMusicModel;
import com.fotoable.youtube.music.newplayer.model.PlayerInfo;
import com.fotoable.youtube.music.service.MainService;
import com.fotoable.youtube.music.util.h;
import com.fotoable.youtube.music.util.s;
import com.fotoable.youtube.music.util.v;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import rx.f;
import rx.l;
/* compiled from: LocalMusicData.java */
/* loaded from: classes.dex */
public class b extends a<LocalMusicModel> {

    /* renamed from: b  reason: collision with root package name */
    private static final String f2852b = b.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private static final b f2853c = new b();
    private Long d;
    private int e;
    private List<Long> f;
    private List<Long> g;
    private Map<Long, LocalMusicModel> h;
    private Random i = new Random();
    private boolean j = false;
    private boolean k = false;
    private int l;

    public static b a() {
        return f2853c;
    }

    private b() {
        b();
    }

    public void b() {
        if (this.f == null) {
            this.f = new ArrayList();
        } else {
            this.f.clear();
        }
        if (this.g == null) {
            this.g = new ArrayList();
        } else {
            this.g.clear();
        }
        if (this.h == null) {
            this.h = new HashMap();
        } else {
            this.h.clear();
        }
        this.d = -1L;
        this.e = -1;
    }

    private void a(LocalMusicModel localMusicModel, String str) {
        if (localMusicModel != null) {
            com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(8002, localMusicModel));
            h.a(f2852b, "记录ID:" + localMusicModel.getSongId() + ",method：" + str);
            com.fotoable.youtube.music.util.b.b("播放器-播放本地音乐次数");
        }
    }

    public void a(List<LocalMusicModel> list, int i) {
        LocalMusicModel localMusicModel;
        if (list != null && list.size() != 0) {
            b();
            for (int i2 = 0; i2 < list.size(); i2++) {
                LocalMusicModel localMusicModel2 = list.get(i2);
                if (localMusicModel2 != null) {
                    this.f.add(Long.valueOf(localMusicModel2.getSongId()));
                    this.g.add(Long.valueOf(localMusicModel2.getSongId()));
                    this.h.put(Long.valueOf(localMusicModel2.getSongId()), localMusicModel2);
                } else if (i2 < i) {
                    i--;
                }
            }
            if (com.fotoable.youtube.music.a.w() == 2) {
                Collections.shuffle(this.g);
            }
            if (i >= 0 && i < this.f.size()) {
                Long l = this.f.get(i);
                LocalMusicModel localMusicModel3 = this.h.get(l);
                if (localMusicModel3 != null) {
                    this.e = this.g.indexOf(l);
                }
                localMusicModel = localMusicModel3;
            } else {
                localMusicModel = null;
            }
            if (localMusicModel == null && this.g.size() > 0) {
                localMusicModel = this.h.get(this.g.get(0));
                if (localMusicModel != null) {
                    this.e = 0;
                }
            }
            if (localMusicModel != null) {
                this.d = Long.valueOf(localMusicModel.getSongId());
                com.fotoable.youtube.music.newplayer.d.a.a().a(localMusicModel, true);
                a(localMusicModel, "playNow");
            }
            this.j = true;
        }
    }

    public void a(LocalMusicModel localMusicModel) {
        if (localMusicModel != null) {
            if (this.d != null && this.g.size() > 0) {
                this.e = 0;
                this.d = this.g.get(0);
            }
            if (this.h.get(Long.valueOf(localMusicModel.getSongId())) != null) {
                if (localMusicModel.getSongId() != this.g.get(this.g.indexOf(this.d) + 1).longValue()) {
                    this.f.remove(Long.valueOf(localMusicModel.getSongId()));
                    this.g.remove(Long.valueOf(localMusicModel.getSongId()));
                    int indexOf = this.g.indexOf(Long.valueOf(localMusicModel.getSongId()));
                    if (indexOf != -1 && indexOf + 1 < this.g.size()) {
                        this.g.add(indexOf + 1, Long.valueOf(localMusicModel.getSongId()));
                    } else {
                        this.g.add(Long.valueOf(localMusicModel.getSongId()));
                    }
                    this.e = this.g.indexOf(this.d);
                    int indexOf2 = this.f.indexOf(Long.valueOf(localMusicModel.getSongId()));
                    if (indexOf2 != -1 && indexOf2 + 1 < this.f.size()) {
                        this.f.add(indexOf2 + 1, Long.valueOf(localMusicModel.getSongId()));
                    } else {
                        this.f.add(Long.valueOf(localMusicModel.getSongId()));
                    }
                    this.j = true;
                    this.k = true;
                } else {
                    h.a(f2852b, "PlayNext:下一首已经是要播放的歌曲了");
                }
                com.fotoable.youtube.music.newplayer.d.c.a().a(false);
                return;
            }
            this.h.put(Long.valueOf(localMusicModel.getSongId()), localMusicModel);
            int indexOf3 = this.g.indexOf(this.d);
            if (indexOf3 != -1 && indexOf3 + 1 < this.g.size()) {
                this.g.add(indexOf3 + 1, Long.valueOf(localMusicModel.getSongId()));
            } else {
                this.g.add(Long.valueOf(localMusicModel.getSongId()));
            }
            this.e = this.g.indexOf(this.d);
            int indexOf4 = this.f.indexOf(this.d);
            if (indexOf4 != -1 && indexOf4 + 1 < this.f.size()) {
                this.f.add(indexOf4 + 1, Long.valueOf(localMusicModel.getSongId()));
            } else {
                this.f.add(Long.valueOf(localMusicModel.getSongId()));
            }
            if (this.g.size() == 1) {
                this.e = 0;
                this.d = Long.valueOf(localMusicModel.getSongId());
                a(localMusicModel, "playNext");
                com.fotoable.youtube.music.newplayer.d.a.a().a(localMusicModel, false);
            }
            this.j = true;
            this.k = true;
        }
    }

    public void a(List<LocalMusicModel> list) {
        if (list != null && list.size() != 0) {
            b();
            for (int i = 0; i < list.size(); i++) {
                LocalMusicModel localMusicModel = list.get(i);
                if (localMusicModel != null) {
                    this.f.add(Long.valueOf(localMusicModel.getSongId()));
                    this.g.add(Long.valueOf(localMusicModel.getSongId()));
                    this.h.put(Long.valueOf(localMusicModel.getSongId()), localMusicModel);
                }
            }
            if (this.g.size() != 0) {
                if (com.fotoable.youtube.music.a.w() == 2) {
                    Collections.shuffle(this.g);
                }
                this.e = 0;
                LocalMusicModel localMusicModel2 = this.h.get(this.g.get(this.e));
                if (localMusicModel2 != null) {
                    this.d = Long.valueOf(localMusicModel2.getSongId());
                    a(localMusicModel2, "playAll");
                    com.fotoable.youtube.music.newplayer.d.a.a().a(localMusicModel2, true);
                }
                this.j = true;
                this.k = true;
            }
        }
    }

    public void b(LocalMusicModel localMusicModel) {
        if (localMusicModel != null) {
            if (this.h.get(Long.valueOf(localMusicModel.getSongId())) == null) {
                this.f.add(Long.valueOf(localMusicModel.getSongId()));
                this.g.add(Long.valueOf(localMusicModel.getSongId()));
                this.h.put(Long.valueOf(localMusicModel.getSongId()), localMusicModel);
                if (this.g.size() == 1) {
                    this.e = 0;
                    this.d = Long.valueOf(localMusicModel.getSongId());
                    a(localMusicModel, "addToPlayQueue");
                    com.fotoable.youtube.music.newplayer.d.a.a().a(localMusicModel, false);
                }
                this.j = true;
                return;
            }
            h.a(f2852b, "addToPlayQueue此歌曲已经存在播放列表中");
        }
    }

    public List<LocalMusicModel> c() {
        return b(this.f);
    }

    public List<LocalMusicModel> d() {
        return b(this.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<LocalMusicModel> b(List<Long> list) {
        LocalMusicModel localMusicModel;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                Long l = list.get(i2);
                if (l != null && (localMusicModel = this.h.get(l)) != null) {
                    arrayList.add(localMusicModel);
                }
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }

    public void a(final Context context) {
        a(rx.f.a(new f.a(this, context) { // from class: com.fotoable.youtube.music.newplayer.b.c

            /* renamed from: a  reason: collision with root package name */
            private final b f2861a;

            /* renamed from: b  reason: collision with root package name */
            private final Context f2862b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2861a = this;
                this.f2862b = context;
            }

            @Override // rx.c.b
            public void call(Object obj) {
                this.f2861a.a(this.f2862b, (l) obj);
            }
        }).a(s.a()).b(new l<List<LocalMusicModel>>() { // from class: com.fotoable.youtube.music.newplayer.b.b.1

            /* renamed from: c  reason: collision with root package name */
            private long f2856c;

            @Override // rx.l
            public void onStart() {
                super.onStart();
                this.f2856c = System.currentTimeMillis();
            }

            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
                h.a(b.f2852b, "读取缓存播放队列失败");
                com.fotoable.youtube.music.newplayer.f.a().a(772);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(List<LocalMusicModel> list) {
                LocalMusicModel localMusicModel;
                int i = 0;
                h.a(b.f2852b, "读取缓存播放队列成功," + (list != null ? list.size() + "" : "null"));
                if (list != null) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        LocalMusicModel localMusicModel2 = list.get(i2);
                        if (localMusicModel2 != null && localMusicModel2.getSongId() != -1) {
                            h.a(b.f2852b, i2 + "   " + localMusicModel2.toString());
                            b.this.f.add(Long.valueOf(localMusicModel2.getSongId()));
                            b.this.g.add(Long.valueOf(localMusicModel2.getSongId()));
                            b.this.h.put(Long.valueOf(localMusicModel2.getSongId()), localMusicModel2);
                        }
                    }
                    if (com.fotoable.youtube.music.a.w() == 2 && b.this.g.size() > 0) {
                        Collections.shuffle(b.this.g);
                    }
                    int a2 = v.a(context, "player_play_list_position", 0);
                    if (a2 >= 0 && a2 < b.this.f.size()) {
                        i = a2;
                    }
                    if (b.this.f.size() > 0) {
                        Long l = (Long) b.this.f.get(i);
                        localMusicModel = l != null ? (LocalMusicModel) b.this.h.get(l) : null;
                    } else {
                        localMusicModel = null;
                    }
                    if (localMusicModel != null && localMusicModel.getSongId() != -1) {
                        b.this.d = Long.valueOf(localMusicModel.getSongId());
                        b.this.e = b.this.g.indexOf(b.this.d);
                        h.a(b.f2852b, "" + localMusicModel.toString());
                        com.fotoable.youtube.music.newplayer.d.a.a().a(localMusicModel);
                        PlayerInfo playerInfo = new PlayerInfo();
                        playerInfo.covert(localMusicModel);
                        com.fotoable.youtube.music.newplayer.f.a().a(771, playerInfo);
                    } else {
                        com.fotoable.youtube.music.newplayer.f.a().a(772);
                    }
                } else {
                    com.fotoable.youtube.music.newplayer.f.a().a(772);
                }
                h.a(b.f2852b, "读取缓存使用时间：" + (System.currentTimeMillis() - this.f2856c));
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(Context context, l lVar) {
        String a2 = v.a(context, "player_service_play_list", (String) null);
        if (!TextUtils.isEmpty(a2)) {
            Gson gson = new Gson();
            h.a(f2852b, "data:" + a2);
            List list = (List) gson.fromJson(a2, new TypeToken<List<LocalMusicModel>>() { // from class: com.fotoable.youtube.music.newplayer.b.b.2
            }.getType());
            if (lVar != null && !lVar.isUnsubscribed()) {
                if (list != null) {
                    lVar.onNext(list);
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
        if (this.j) {
            this.j = false;
            this.k = false;
            a(rx.f.a((f.a) new f.a<Boolean>() { // from class: com.fotoable.youtube.music.newplayer.b.b.4
                @Override // rx.c.b
                /* renamed from: a */
                public void call(l<? super Boolean> lVar) {
                    String json = new Gson().toJson(b.this.b(b.this.f));
                    if (!TextUtils.isEmpty(json)) {
                        v.b(context, "player_play_list_position", b.this.f.indexOf(b.this.d));
                        v.b(context, "player_service_play_list", json);
                        MainService.a(context, "save_data", "player_service_play_list", json, "player_play_list_position", b.this.e, "last_open_player_type", v.a(context, "last_open_player_type", -1));
                    } else {
                        v.b(context, "player_play_list_position", -1);
                        v.b(context, "player_service_play_list", (String) null);
                        MainService.a(context, "save_data", "player_service_play_list", "", "player_play_list_position", -1, "last_open_player_type", v.a(context, "last_open_player_type", -1));
                    }
                    h.a(b.f2852b, "last_open_player_type：" + v.a(context, "last_open_player_type", -1));
                    if (lVar != null && !lVar.isUnsubscribed()) {
                        lVar.onNext(true);
                        lVar.onCompleted();
                    }
                }
            }).a(s.a()).b(new l<Boolean>() { // from class: com.fotoable.youtube.music.newplayer.b.b.3
                @Override // rx.g
                public void onCompleted() {
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                    h.a(b.f2852b, "保存数据失败");
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(Boolean bool) {
                    h.a(b.f2852b, "保存数据成功");
                }
            }));
        } else if (this.k) {
            this.k = false;
            MainService.a(context, "save_data", "player_service_play_list", AppEventsConstants.EVENT_PARAM_VALUE_YES, "player_play_list_position", this.f.indexOf(this.d), "last_open_player_type", v.a(context, "last_open_player_type", -1));
        }
    }

    public LocalMusicModel e() {
        return this.h.get(this.d);
    }

    private void i() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.g.size(); i++) {
            sb.append(this.g.get(i) + ",  ");
        }
        h.a(f2852b, "LOG:" + sb.toString());
        h.a(f2852b, "LOG2:" + this.d + "    " + this.e);
    }

    public LocalMusicModel a(boolean z) {
        LocalMusicModel localMusicModel;
        if (this.f.size() == 0) {
            return null;
        }
        i();
        if ((z && com.fotoable.youtube.music.a.w() == 1) || com.fotoable.youtube.music.a.w() == 0) {
            if (this.e - 1 >= this.g.size()) {
                this.e = 1;
            }
            if (this.e < 1) {
                this.e = this.g.size();
            }
            if (this.g.size() == 0) {
                return null;
            }
            List<Long> list = this.g;
            int i = this.e - 1;
            this.e = i;
            Long l = list.get(i);
            if (l != null) {
                localMusicModel = this.h.get(l);
            }
            localMusicModel = null;
        } else if (com.fotoable.youtube.music.a.w() == 1) {
            if (this.e < 0) {
                this.e = 0;
            }
            if (this.g.size() > this.e) {
                List<Long> list2 = this.g;
                int i2 = this.e - 1;
                this.e = i2;
                Long l2 = list2.get(i2);
                if (l2 != null) {
                    localMusicModel = this.h.get(l2);
                }
            }
            localMusicModel = null;
        } else {
            if (com.fotoable.youtube.music.a.w() == 2 && this.g.size() > 0) {
                if (this.e - 1 >= this.g.size()) {
                    this.e = 1;
                }
                if (this.e < 1) {
                    this.e = this.g.size();
                }
                if (this.g.size() == 0) {
                    return null;
                }
                List<Long> list3 = this.g;
                int i3 = this.e - 1;
                this.e = i3;
                Long l3 = list3.get(i3);
                if (l3 != null) {
                    localMusicModel = this.h.get(l3);
                }
            }
            localMusicModel = null;
        }
        if (localMusicModel != null) {
            this.d = Long.valueOf(localMusicModel.getSongId());
            a(localMusicModel, "previous");
        } else {
            this.d = null;
        }
        i();
        this.k = true;
        return localMusicModel;
    }

    public LocalMusicModel b(boolean z) {
        LocalMusicModel localMusicModel;
        if (this.g.size() == 0) {
            return null;
        }
        i();
        if (com.fotoable.youtube.music.a.w() == 0 || (z && com.fotoable.youtube.music.a.w() == 1)) {
            if (this.e + 1 >= this.g.size()) {
                this.e = -1;
            }
            if (this.g.size() == 0) {
                return null;
            }
            this.e++;
            Long l = this.g.get(this.e);
            if (l != null) {
                localMusicModel = this.h.get(l);
            }
            localMusicModel = null;
        } else if (com.fotoable.youtube.music.a.w() == 1) {
            if (this.g.size() > 0 && this.g.size() > this.e) {
                if (this.e < 0) {
                    this.e = 0;
                }
                if (this.g.size() == 0) {
                    return null;
                }
                Long l2 = this.g.get(this.e);
                if (l2 != null) {
                    localMusicModel = this.h.get(l2);
                }
                localMusicModel = null;
            } else {
                if (this.g.size() > 0) {
                    this.e = 0;
                    Long l3 = this.g.get(this.e);
                    if (l3 != null) {
                        localMusicModel = this.h.get(l3);
                    }
                }
                localMusicModel = null;
            }
        } else {
            if (com.fotoable.youtube.music.a.w() == 2 && this.g.size() > 0) {
                if (this.e + 1 >= this.g.size()) {
                    this.e = -1;
                }
                if (this.g.size() == 0) {
                    return null;
                }
                this.e++;
                Long l4 = this.g.get(this.e);
                if (l4 != null) {
                    localMusicModel = this.h.get(l4);
                }
            }
            localMusicModel = null;
        }
        if (localMusicModel != null) {
            this.d = Long.valueOf(localMusicModel.getSongId());
            a(localMusicModel, "next");
        } else {
            this.e = -1;
            this.d = null;
        }
        i();
        this.k = true;
        return localMusicModel;
    }

    public void a(int i) {
        if (i >= 0 && i < this.f.size()) {
            Long remove = this.f.remove(i);
            if (remove != null) {
                this.h.remove(remove);
            }
            int indexOf = this.g.indexOf(remove);
            if (indexOf != -1) {
                this.g.remove(remove);
                if (indexOf < this.e) {
                    this.e--;
                } else if (indexOf == this.e) {
                    this.e--;
                    LocalMusicModel b2 = b(true);
                    h.a(f2852b, "Next :delete");
                    if (b2 != null) {
                        this.d = Long.valueOf(b2.getSongId());
                        a(b2, "delete");
                        com.fotoable.youtube.music.newplayer.d.a.a().a(b2, false);
                    }
                }
            }
            this.j = true;
        }
    }

    public void b(int i) {
        Long l;
        LocalMusicModel localMusicModel;
        if (i < 0 || i >= this.f.size() || (l = this.f.get(i)) == null || (localMusicModel = this.h.get(l)) == null) {
            return;
        }
        if (this.d == null || this.d.longValue() != localMusicModel.getSongId()) {
            this.e = this.g.indexOf(l);
            this.d = Long.valueOf(localMusicModel.getSongId());
            com.fotoable.youtube.music.newplayer.d.a.a().a(localMusicModel, false);
            a(localMusicModel, "clickPlay");
            this.k = true;
        }
    }

    public void c(int i) {
        this.l = i;
        if (i == 2) {
            this.g.clear();
            this.g.addAll(this.f);
            Collections.shuffle(this.g);
            if (this.e >= 0 && this.e < this.g.size()) {
                this.e = this.g.indexOf(this.d);
                return;
            }
            return;
        }
        this.g.clear();
        this.g.addAll(this.f);
        if (this.e >= 0 && this.e < this.g.size()) {
            this.e = this.g.indexOf(this.d);
        }
    }

    public void f() {
        b();
        com.fotoable.youtube.music.newplayer.d.a.a().b(false);
        com.fotoable.youtube.music.newplayer.d.a.a().a((LocalMusicModel) null);
        this.j = true;
    }

    public void a(long j) {
        int indexOf;
        this.j = true;
        if (this.h.get(Long.valueOf(j)) == null) {
            indexOf = -1;
        } else {
            indexOf = this.g.indexOf(Long.valueOf(j));
            this.f.remove(Long.valueOf(j));
            this.g.remove(Long.valueOf(j));
        }
        if (indexOf != -1) {
            if (indexOf < this.e) {
                this.e--;
            } else if (indexOf == this.e) {
                this.e--;
                LocalMusicModel b2 = b(true);
                h.a(f2852b, "Next :deleteLocal 1");
                if (b2 != null) {
                    com.fotoable.youtube.music.newplayer.d.a.a().a(b2, false);
                } else {
                    com.fotoable.youtube.music.newplayer.f.a().h();
                }
            }
        }
        h.a(f2852b, "删除本地播放列表：" + indexOf + "    " + this.e);
    }

    public int g() {
        return this.e;
    }
}

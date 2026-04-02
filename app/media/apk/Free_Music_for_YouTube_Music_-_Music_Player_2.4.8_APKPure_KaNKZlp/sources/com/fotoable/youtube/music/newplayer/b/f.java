package com.fotoable.youtube.music.newplayer.b;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.fotoable.youtube.music.bean.PlayMusicModel;
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
/* compiled from: YoutubeData.java */
/* loaded from: classes.dex */
public class f extends a<PlayMusicModel> {
    private static final String f = f.class.getSimpleName();
    private static final f k = new f();

    /* renamed from: b  reason: collision with root package name */
    public List<String> f2871b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f2872c;
    public Map<String, PlayMusicModel> d;
    public String e;
    private int g;
    private boolean h = false;
    private boolean i = false;
    private Random j = new Random();
    private Context l;

    public static f a() {
        return k;
    }

    private f() {
        h();
    }

    public void a(Context context) {
        this.l = context;
    }

    private void h() {
        if (this.f2871b == null) {
            this.f2871b = new ArrayList();
        } else {
            this.f2871b.clear();
        }
        if (this.f2872c == null) {
            this.f2872c = new ArrayList();
        } else {
            this.f2872c.clear();
        }
        if (this.d == null) {
            this.d = new HashMap();
        } else {
            this.d.clear();
        }
        this.e = null;
        this.g = -1;
    }

    public void a(List<PlayMusicModel> list, int i) {
        PlayMusicModel playMusicModel;
        if (list != null && list.size() != 0) {
            h();
            for (int i2 = 0; i2 < list.size(); i2++) {
                PlayMusicModel playMusicModel2 = list.get(i2);
                if (playMusicModel2 != null) {
                    this.f2871b.add(playMusicModel2.getVideoId());
                    this.f2872c.add(playMusicModel2.getVideoId());
                    this.d.put(playMusicModel2.getVideoId(), playMusicModel2);
                } else if (i2 < i) {
                    i--;
                }
            }
            if (com.fotoable.youtube.music.a.w() == 2) {
                Collections.shuffle(this.f2872c);
            }
            if (i >= 0 && i < this.f2871b.size()) {
                String str = this.f2871b.get(i);
                PlayMusicModel playMusicModel3 = this.d.get(str);
                if (playMusicModel3 != null) {
                    this.g = this.f2872c.indexOf(str);
                }
                playMusicModel = playMusicModel3;
            } else {
                playMusicModel = null;
            }
            if (playMusicModel == null && this.f2872c.size() > 0) {
                playMusicModel = this.d.get(this.f2872c.get(0));
                if (playMusicModel != null) {
                    this.g = 0;
                }
            }
            if (playMusicModel != null) {
                this.e = playMusicModel.getVideoId();
                com.fotoable.youtube.music.newplayer.d.c.a().a(playMusicModel, true);
                c(playMusicModel);
            }
            this.h = true;
        }
    }

    public void a(PlayMusicModel playMusicModel) {
        if (playMusicModel != null) {
            if (TextUtils.isEmpty(this.e) && this.f2872c.size() > 0) {
                this.g = 0;
                this.e = this.f2872c.get(0);
            }
            if (this.d.get(playMusicModel.getVideoId()) != null) {
                int indexOf = this.f2872c.indexOf(this.e);
                if (indexOf + 1 < this.f2872c.size() && !TextUtils.equals(playMusicModel.getVideoId(), this.f2872c.get(indexOf + 1))) {
                    this.f2871b.remove(playMusicModel.getVideoId());
                    this.f2872c.remove(playMusicModel.getVideoId());
                    int indexOf2 = this.f2872c.indexOf(playMusicModel.getVideoId());
                    if (indexOf2 != -1 && indexOf2 + 1 < this.f2872c.size()) {
                        this.f2872c.add(indexOf2 + 1, playMusicModel.getVideoId());
                    } else {
                        this.f2872c.add(playMusicModel.getVideoId());
                    }
                    this.g = this.f2872c.indexOf(this.e);
                    int indexOf3 = this.f2871b.indexOf(playMusicModel.getVideoId());
                    if (indexOf3 != -1 && indexOf3 + 1 < this.f2871b.size()) {
                        this.f2871b.add(indexOf3 + 1, playMusicModel.getVideoId());
                    } else {
                        this.f2871b.add(playMusicModel.getVideoId());
                    }
                    this.h = true;
                    this.i = true;
                } else {
                    h.a(f, "PlayNext:下一首已经是要播放的歌曲了");
                }
                com.fotoable.youtube.music.newplayer.d.c.a().a(false);
                return;
            }
            this.d.put(playMusicModel.getVideoId(), playMusicModel);
            int indexOf4 = this.f2872c.indexOf(this.e);
            if (indexOf4 != -1 && indexOf4 + 1 < this.f2872c.size()) {
                this.f2872c.add(indexOf4 + 1, playMusicModel.getVideoId());
            } else {
                this.f2872c.add(playMusicModel.getVideoId());
            }
            this.g = this.f2872c.indexOf(this.e);
            int indexOf5 = this.f2871b.indexOf(this.e);
            if (indexOf5 != -1 && indexOf5 + 1 < this.f2871b.size()) {
                this.f2871b.add(indexOf5 + 1, playMusicModel.getVideoId());
            } else {
                this.f2871b.add(playMusicModel.getVideoId());
            }
            if (this.f2872c.size() == 1) {
                this.g = 0;
                this.e = playMusicModel.getVideoId();
                c(playMusicModel);
                com.fotoable.youtube.music.newplayer.d.c.a().a(playMusicModel, false);
            }
            this.h = true;
            this.i = true;
        }
    }

    public void a(List<PlayMusicModel> list) {
        if (list != null && list.size() != 0) {
            h();
            for (int i = 0; i < list.size(); i++) {
                PlayMusicModel playMusicModel = list.get(i);
                if (playMusicModel != null) {
                    this.f2871b.add(playMusicModel.getVideoId());
                    this.f2872c.add(playMusicModel.getVideoId());
                    this.d.put(playMusicModel.getVideoId(), playMusicModel);
                }
            }
            if (this.f2872c.size() != 0) {
                if (com.fotoable.youtube.music.a.w() == 2) {
                    Collections.shuffle(this.f2872c);
                }
                this.g = 0;
                PlayMusicModel playMusicModel2 = this.d.get(this.f2872c.get(this.g));
                if (playMusicModel2 != null) {
                    this.e = playMusicModel2.getVideoId();
                    c(playMusicModel2);
                    com.fotoable.youtube.music.newplayer.d.c.a().a(playMusicModel2, true);
                }
                this.h = true;
                this.i = true;
            }
        }
    }

    public void b(PlayMusicModel playMusicModel) {
        if (playMusicModel != null) {
            if (this.d.get(playMusicModel.getVideoId()) == null) {
                this.f2871b.add(playMusicModel.getVideoId());
                this.f2872c.add(playMusicModel.getVideoId());
                this.d.put(playMusicModel.getVideoId(), playMusicModel);
                if (this.f2872c.size() == 1) {
                    this.g = 0;
                    this.e = playMusicModel.getVideoId();
                    c(playMusicModel);
                    com.fotoable.youtube.music.newplayer.d.c.a().a(playMusicModel, false);
                }
                this.h = true;
                return;
            }
            h.a(f, "addToPlayQueue此歌曲已经存在播放列表中");
        }
    }

    public List<PlayMusicModel> b() {
        return b(this.f2871b);
    }

    public List<PlayMusicModel> c() {
        return b(this.f2872c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<PlayMusicModel> b(List<String> list) {
        PlayMusicModel playMusicModel;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                String str = list.get(i2);
                if (!TextUtils.isEmpty(str) && (playMusicModel = this.d.get(str)) != null) {
                    arrayList.add(playMusicModel);
                }
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }

    public int d() {
        return this.g;
    }

    public void b(final Context context) {
        a(rx.f.a((f.a) new f.a<List<PlayMusicModel>>() { // from class: com.fotoable.youtube.music.newplayer.b.f.2
            @Override // rx.c.b
            /* renamed from: a */
            public void call(l<? super List<PlayMusicModel>> lVar) {
                String a2 = v.a(context, "player_service_play_list", (String) null);
                if (!TextUtils.isEmpty(a2)) {
                    List list = (List) new Gson().fromJson(a2, new TypeToken<List<PlayMusicModel>>() { // from class: com.fotoable.youtube.music.newplayer.b.f.2.1
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
        }).a(s.a()).b(new l<List<PlayMusicModel>>() { // from class: com.fotoable.youtube.music.newplayer.b.f.1

            /* renamed from: c  reason: collision with root package name */
            private long f2875c;

            @Override // rx.l
            public void onStart() {
                super.onStart();
                this.f2875c = System.currentTimeMillis();
            }

            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
                h.a(f.f, "读取缓存播放队列失败");
                com.fotoable.youtube.music.newplayer.f.a().a(772);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(List<PlayMusicModel> list) {
                PlayMusicModel playMusicModel;
                int i = 0;
                h.a(f.f, new StringBuilder().append("读取缓存播放队列成功,").append(list).toString() != null ? list.size() + "" : "null");
                if (list != null) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        PlayMusicModel playMusicModel2 = list.get(i2);
                        if (playMusicModel2 != null) {
                            f.this.f2871b.add(playMusicModel2.getVideoId());
                            f.this.f2872c.add(playMusicModel2.getVideoId());
                            f.this.d.put(playMusicModel2.getVideoId(), playMusicModel2);
                        }
                    }
                    if (com.fotoable.youtube.music.a.w() == 2 && f.this.f2872c.size() > 0) {
                        Collections.shuffle(f.this.f2872c);
                    }
                    int a2 = v.a(context, "player_play_list_position", 0);
                    if (a2 >= 0 && a2 < f.this.f2871b.size()) {
                        i = a2;
                    }
                    if (f.this.f2871b.size() > 0) {
                        String str = f.this.f2871b.get(i);
                        playMusicModel = !TextUtils.isEmpty(str) ? f.this.d.get(str) : null;
                    } else {
                        playMusicModel = null;
                    }
                    if (playMusicModel != null) {
                        f.this.e = playMusicModel.getVideoId();
                        f.this.g = f.this.f2872c.indexOf(f.this.e);
                        com.fotoable.youtube.music.newplayer.d.c.a().a(playMusicModel);
                        PlayerInfo playerInfo = new PlayerInfo();
                        playerInfo.covert(playMusicModel);
                        com.fotoable.youtube.music.newplayer.f.a().a(771, playerInfo);
                    } else {
                        com.fotoable.youtube.music.newplayer.f.a().a(772);
                    }
                } else {
                    com.fotoable.youtube.music.newplayer.f.a().a(772);
                }
                h.a(f.f, "读取缓存使用时间：" + (System.currentTimeMillis() - this.f2875c));
            }
        }));
    }

    public void c(final Context context) {
        if (this.h) {
            this.h = false;
            this.i = false;
            a(rx.f.a((f.a) new f.a<Boolean>() { // from class: com.fotoable.youtube.music.newplayer.b.f.4
                @Override // rx.c.b
                /* renamed from: a */
                public void call(l<? super Boolean> lVar) {
                    String json = new Gson().toJson(f.this.b(f.this.f2871b));
                    if (!TextUtils.isEmpty(json)) {
                        v.b(context, "player_play_list_position", f.this.f2871b.indexOf(f.this.e));
                        v.b(context, "player_service_play_list", json);
                        MainService.a(context, "save_data", "player_service_play_list", json, "player_play_list_position", f.this.g, "last_open_player_type", v.a(context, "last_open_player_type", -1));
                    } else {
                        v.b(context, "player_play_list_position", -1);
                        v.b(context, "player_service_play_list", (String) null);
                        MainService.a(context, "save_data", "player_service_play_list", "", "player_play_list_position", -1, "last_open_player_type", v.a(context, "last_open_player_type", -1));
                    }
                    if (lVar != null && !lVar.isUnsubscribed()) {
                        lVar.onNext(true);
                        lVar.onCompleted();
                    }
                }
            }).a(s.a()).b(new l<Boolean>() { // from class: com.fotoable.youtube.music.newplayer.b.f.3
                @Override // rx.g
                public void onCompleted() {
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                    h.a(f.f, "保存数据失败");
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(Boolean bool) {
                    h.a(f.f, "保存数据成功");
                }
            }));
        } else if (this.i) {
            this.i = false;
            MainService.a(context, "save_data", "player_service_play_list", AppEventsConstants.EVENT_PARAM_VALUE_YES, "player_play_list_position", this.f2871b.indexOf(this.e), "last_open_player_type", v.a(context, "last_open_player_type", -1));
        }
    }

    public PlayMusicModel e() {
        PlayMusicModel playMusicModel = this.d.get(this.e);
        if (playMusicModel == null) {
            if (this.g < 0 || this.g >= this.f2871b.size()) {
                this.g = 0;
            }
            if (!TextUtils.isEmpty(this.e)) {
                return this.d.get(this.e);
            }
            if (this.f2872c.size() > 0) {
                this.g = 0;
                String str = this.f2872c.get(this.g);
                if (!TextUtils.isEmpty(str)) {
                    return this.d.get(str);
                }
                return playMusicModel;
            }
            return playMusicModel;
        }
        return playMusicModel;
    }

    public PlayMusicModel a(boolean z) {
        PlayMusicModel playMusicModel;
        if ((z && com.fotoable.youtube.music.a.w() == 1) || com.fotoable.youtube.music.a.w() == 0) {
            if (this.g - 1 >= this.f2872c.size()) {
                this.g = 1;
            }
            if (this.g < 1) {
                this.g = this.f2872c.size();
            }
            if (this.f2872c.size() == 0) {
                return null;
            }
            List<String> list = this.f2872c;
            int i = this.g - 1;
            this.g = i;
            String str = list.get(i);
            if (!TextUtils.isEmpty(str)) {
                playMusicModel = this.d.get(str);
            }
            playMusicModel = null;
        } else if (com.fotoable.youtube.music.a.w() == 1) {
            if (this.g < 0) {
                this.g = 0;
            }
            if (this.f2872c.size() > this.g) {
                List<String> list2 = this.f2872c;
                int i2 = this.g - 1;
                this.g = i2;
                String str2 = list2.get(i2);
                if (!TextUtils.isEmpty(str2)) {
                    playMusicModel = this.d.get(str2);
                }
            }
            playMusicModel = null;
        } else {
            if (com.fotoable.youtube.music.a.w() == 2 && this.f2872c.size() > 0) {
                if (this.g - 1 >= this.f2872c.size()) {
                    this.g = 1;
                }
                if (this.g < 1) {
                    this.g = this.f2872c.size();
                }
                if (this.f2872c.size() == 0) {
                    return null;
                }
                List<String> list3 = this.f2872c;
                int i3 = this.g - 1;
                this.g = i3;
                String str3 = list3.get(i3);
                if (!TextUtils.isEmpty(str3)) {
                    playMusicModel = this.d.get(str3);
                }
            }
            playMusicModel = null;
        }
        if (playMusicModel != null) {
            this.e = playMusicModel.getVideoId();
            c(playMusicModel);
        } else {
            this.e = null;
        }
        this.i = true;
        return playMusicModel;
    }

    public PlayMusicModel b(boolean z) {
        PlayMusicModel playMusicModel;
        if (com.fotoable.youtube.music.a.w() == 0 || (z && com.fotoable.youtube.music.a.w() == 1)) {
            if (this.g + 1 >= this.f2872c.size()) {
                this.g = -1;
            }
            if (this.f2872c.size() == 0) {
                return null;
            }
            this.g++;
            String str = this.f2872c.get(this.g);
            if (!TextUtils.isEmpty(str)) {
                playMusicModel = this.d.get(str);
            }
            playMusicModel = null;
        } else if (com.fotoable.youtube.music.a.w() == 1) {
            if (this.f2872c.size() > 0 && this.f2872c.size() > this.g) {
                if (this.g < 0) {
                    this.g = 0;
                }
                if (this.f2871b.size() == 0) {
                    return null;
                }
                String str2 = this.f2872c.get(this.g);
                if (!TextUtils.isEmpty(str2)) {
                    playMusicModel = this.d.get(str2);
                }
                playMusicModel = null;
            } else {
                if (this.f2872c.size() > 0) {
                    this.g = 0;
                    String str3 = this.f2872c.get(this.g);
                    if (!TextUtils.isEmpty(str3)) {
                        playMusicModel = this.d.get(str3);
                    }
                }
                playMusicModel = null;
            }
        } else {
            if (com.fotoable.youtube.music.a.w() == 2 && this.f2872c.size() > 0) {
                if (this.g + 1 >= this.f2872c.size()) {
                    this.g = -1;
                }
                if (this.f2872c.size() == 0) {
                    return null;
                }
                this.g++;
                String str4 = this.f2872c.get(this.g);
                if (!TextUtils.isEmpty(str4)) {
                    playMusicModel = this.d.get(str4);
                }
            }
            playMusicModel = null;
        }
        if (playMusicModel != null) {
            this.e = playMusicModel.getVideoId();
            c(playMusicModel);
        } else {
            this.g = -1;
            this.e = null;
        }
        this.i = true;
        return playMusicModel;
    }

    public void a(int i) {
        if (i >= 0 && i < this.f2871b.size()) {
            String remove = this.f2871b.remove(i);
            if (remove != null) {
                this.d.remove(remove);
            }
            int indexOf = this.f2872c.indexOf(remove);
            if (indexOf != -1) {
                this.f2872c.remove(remove);
                if (indexOf < this.g) {
                    this.g--;
                } else if (indexOf == this.g) {
                    this.g--;
                    PlayMusicModel b2 = b(true);
                    if (b2 != null) {
                        this.e = b2.getVideoId();
                        c(b2);
                        com.fotoable.youtube.music.newplayer.d.c.a().a(b2, false);
                    }
                }
            }
            this.h = true;
        }
    }

    public void b(int i) {
        PlayMusicModel playMusicModel;
        if (i >= 0 && i < this.f2871b.size()) {
            String str = this.f2871b.get(i);
            if (!TextUtils.isEmpty(str) && (playMusicModel = this.d.get(str)) != null && !TextUtils.equals(this.e, playMusicModel.getVideoId())) {
                this.g = this.f2872c.indexOf(str);
                this.e = playMusicModel.getVideoId();
                com.fotoable.youtube.music.newplayer.d.c.a().a(playMusicModel, false);
                c(playMusicModel);
                this.i = true;
            }
        }
    }

    public void c(int i) {
        if (i == 2) {
            this.f2872c.clear();
            this.f2872c.addAll(this.f2871b);
            Collections.shuffle(this.f2872c);
            if (this.g >= 0 && this.g < this.f2872c.size()) {
                this.g = this.f2872c.indexOf(this.e);
                return;
            }
            return;
        }
        this.f2872c.clear();
        this.f2872c.addAll(this.f2871b);
        if (this.g >= 0 && this.g < this.f2872c.size()) {
            this.g = this.f2872c.indexOf(this.e);
        }
    }

    public void f() {
        this.f2871b.clear();
        this.d.clear();
        this.e = null;
        this.g = 0;
        this.h = true;
        com.fotoable.youtube.music.newplayer.d.c.a().a((PlayMusicModel) null);
    }

    private void c(PlayMusicModel playMusicModel) {
        if (playMusicModel != null) {
            com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(8001, playMusicModel));
            com.fotoable.youtube.music.util.b.b("播放器-尝试播放Youtube次数", "VideoId", "" + playMusicModel.getVideoId());
        }
    }

    public void a(String str, boolean z) {
        PlayMusicModel playMusicModel = this.d.get(str);
        if (playMusicModel != null) {
            playMusicModel.setIsFav(z);
        }
    }
}

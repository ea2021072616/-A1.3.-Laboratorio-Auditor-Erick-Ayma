package com.fotoable.youtube.music.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.a;
import com.fotoable.youtube.music.e.b;
import com.fotoable.youtube.music.util.h;
import com.fotoable.youtube.music.util.v;
/* loaded from: classes.dex */
public class MusicReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3154a = MusicReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && !TextUtils.isEmpty(intent.getAction())) {
            h.a(f3154a, "Action:" + intent.getAction());
            String action = intent.getAction();
            char c2 = 65535;
            switch (action.hashCode()) {
                case -2077273043:
                    if (action.equals("action_change_find_lyric_state_tip")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case -1566348053:
                    if (action.equals("action_pop_up_close")) {
                        c2 = '\r';
                        break;
                    }
                    break;
                case -1475724995:
                    if (action.equals("action_syn_player_tip")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case -939780245:
                    if (action.equals("action_syn_small_player_red")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -618816130:
                    if (action.equals("action_change_find_mp3_state_tip")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 238152341:
                    if (action.equals("action_open_app")) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case 888877019:
                    if (action.equals("action_syn_saver_power")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1020436826:
                    if (action.equals("action_syn_youtube_got_it")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 1284474721:
                    if (action.equals("action_syn_power_tip")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1308903891:
                    if (action.equals("action_syn_music_fav_state")) {
                        c2 = 14;
                        break;
                    }
                    break;
                case 1533911246:
                    if (action.equals("action_syn_loop_model")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1544557347:
                    if (action.equals("action_syn_ad")) {
                        c2 = '\n';
                        break;
                    }
                    break;
                case 1725626979:
                    if (action.equals("action_save_data")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 1889496311:
                    if (action.equals("action_pop_up_open")) {
                        c2 = '\f';
                        break;
                    }
                    break;
                case 1934984997:
                    if (action.equals("action_syn_music")) {
                        c2 = 11;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a.b(intent.getIntExtra("currentLoopModel", 0));
                    return;
                case 1:
                    a.l(false);
                    return;
                case 2:
                    a.g(false);
                    return;
                case 3:
                    a.l(false);
                    return;
                case 4:
                    a.k(false);
                    return;
                case 5:
                    String stringExtra = intent.getStringExtra("local_music_play_list");
                    String stringExtra2 = intent.getStringExtra("local_music_play_current_videoid");
                    int intExtra = intent.getIntExtra("local_music_play_current_position", 0);
                    v.b(MusicApplication.c(), "local_music_play_list", stringExtra);
                    v.b(MusicApplication.c(), "local_music_play_current_videoid", stringExtra2);
                    v.b((Context) MusicApplication.c(), "local_music_play_current_position", intExtra);
                    h.a(f3154a, "主进程保存数据");
                    return;
                case 6:
                    v.b(context, "Go_To_Browser_For_MP3_Tip", true);
                    return;
                case 7:
                    v.b(context, "Go_To_Browser_For_Lyric_Tip", true);
                    return;
                case '\b':
                    a.m(false);
                    return;
                case '\t':
                    h.a(f3154a, "结束时间：" + System.currentTimeMillis());
                    return;
                case '\n':
                    b.a().a(new com.fotoable.youtube.music.e.a(1044));
                    return;
                case 11:
                    h.a(f3154a, "跨进程数据来了,id:" + intent.getStringExtra("videoId"));
                    b.a().a(new com.fotoable.youtube.music.e.a((int) PointerIconCompat.TYPE_NO_DROP, intent.getStringExtra("videoId")));
                    return;
                case '\f':
                    b.a().a(new com.fotoable.youtube.music.e.a(PointerIconCompat.TYPE_ALL_SCROLL));
                    return;
                case '\r':
                    b.a().a(new com.fotoable.youtube.music.e.a(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW));
                    return;
                case 14:
                    b.a().a(new com.fotoable.youtube.music.e.a(1031, intent.getStringExtra("videoId"), intent.getBooleanExtra("isFav", false)));
                    return;
                default:
                    return;
            }
        }
    }
}

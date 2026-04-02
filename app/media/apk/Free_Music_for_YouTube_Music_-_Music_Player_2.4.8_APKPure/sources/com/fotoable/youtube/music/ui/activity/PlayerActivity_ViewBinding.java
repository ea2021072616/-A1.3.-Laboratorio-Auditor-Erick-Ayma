package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.MarqueeTextView;
import com.fotoable.youtube.music.ui.view.SeekBarProgress;
/* loaded from: classes.dex */
public class PlayerActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private PlayerActivity f3696a;

    /* renamed from: b  reason: collision with root package name */
    private View f3697b;

    /* renamed from: c  reason: collision with root package name */
    private View f3698c;
    private View d;
    private View e;
    private View f;
    private View g;
    private View h;
    private View i;
    private View j;
    private View k;
    private View l;

    @UiThread
    public PlayerActivity_ViewBinding(final PlayerActivity playerActivity, View view) {
        this.f3696a = playerActivity;
        playerActivity.blur_bg = (ImageView) Utils.findRequiredViewAsType(view, R.id.blur_bg, "field 'blur_bg'", ImageView.class);
        playerActivity.music_name = (MarqueeTextView) Utils.findRequiredViewAsType(view, R.id.music_name, "field 'music_name'", MarqueeTextView.class);
        playerActivity.artists_name = (TextView) Utils.findRequiredViewAsType(view, R.id.artists_name, "field 'artists_name'", TextView.class);
        playerActivity.origin_cover = (ImageView) Utils.findRequiredViewAsType(view, R.id.origin_cover, "field 'origin_cover'", ImageView.class);
        playerActivity.video_play_current_time = (TextView) Utils.findRequiredViewAsType(view, R.id.video_play_current_time, "field 'video_play_current_time'", TextView.class);
        playerActivity.video_seek_bar = (SeekBarProgress) Utils.findRequiredViewAsType(view, R.id.video_seek_bar, "field 'video_seek_bar'", SeekBarProgress.class);
        playerActivity.video_play_total_time = (TextView) Utils.findRequiredViewAsType(view, R.id.video_play_total_time, "field 'video_play_total_time'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.loop_model, "field 'loop_model' and method 'onClick'");
        playerActivity.loop_model = (ImageView) Utils.castView(findRequiredView, R.id.loop_model, "field 'loop_model'", ImageView.class);
        this.f3697b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.PlayerActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                playerActivity.onClick(view2);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.play_back, "field 'play_back' and method 'onClick'");
        playerActivity.play_back = (ImageView) Utils.castView(findRequiredView2, R.id.play_back, "field 'play_back'", ImageView.class);
        this.f3698c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.PlayerActivity_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                playerActivity.onClick(view2);
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.play_next, "field 'play_next' and method 'onClick'");
        playerActivity.play_next = (ImageView) Utils.castView(findRequiredView3, R.id.play_next, "field 'play_next'", ImageView.class);
        this.d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.PlayerActivity_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                playerActivity.onClick(view2);
            }
        });
        View findRequiredView4 = Utils.findRequiredView(view, R.id.video_play_list, "field 'video_play_list' and method 'onClick'");
        playerActivity.video_play_list = (ImageView) Utils.castView(findRequiredView4, R.id.video_play_list, "field 'video_play_list'", ImageView.class);
        this.e = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.PlayerActivity_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                playerActivity.onClick(view2);
            }
        });
        View findRequiredView5 = Utils.findRequiredView(view, R.id.change_play_state, "field 'change_play_state' and method 'onClick'");
        playerActivity.change_play_state = (ImageView) Utils.castView(findRequiredView5, R.id.change_play_state, "field 'change_play_state'", ImageView.class);
        this.f = findRequiredView5;
        findRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.PlayerActivity_ViewBinding.7
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                playerActivity.onClick(view2);
            }
        });
        playerActivity.change_play_loading = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.change_play_loading, "field 'change_play_loading'", RelativeLayout.class);
        playerActivity.play_loading = (ImageView) Utils.findRequiredViewAsType(view, R.id.play_loading, "field 'play_loading'", ImageView.class);
        playerActivity.go_youtube_panel = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.go_youtube_panel, "field 'go_youtube_panel'", LinearLayout.class);
        View findRequiredView6 = Utils.findRequiredView(view, R.id.full_screen, "field 'full_screen' and method 'onClick'");
        playerActivity.full_screen = (ImageView) Utils.castView(findRequiredView6, R.id.full_screen, "field 'full_screen'", ImageView.class);
        this.g = findRequiredView6;
        findRequiredView6.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.PlayerActivity_ViewBinding.8
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                playerActivity.onClick(view2);
            }
        });
        View findRequiredView7 = Utils.findRequiredView(view, R.id.video_favorite_state, "field 'video_favorite_state' and method 'onClick'");
        playerActivity.video_favorite_state = (ImageView) Utils.castView(findRequiredView7, R.id.video_favorite_state, "field 'video_favorite_state'", ImageView.class);
        this.h = findRequiredView7;
        findRequiredView7.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.PlayerActivity_ViewBinding.9
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                playerActivity.onClick(view2);
            }
        });
        playerActivity.view_pager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.view_pager, "field 'view_pager'", ViewPager.class);
        playerActivity.origin_cover_panel = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.origin_cover_panel, "field 'origin_cover_panel'", RelativeLayout.class);
        playerActivity.radio_cover_panel = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.radio_cover_panel, "field 'radio_cover_panel'", RelativeLayout.class);
        playerActivity.cover_panel = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.cover_panel, "field 'cover_panel'", RelativeLayout.class);
        playerActivity.radio_cover_img = (ImageView) Utils.findRequiredViewAsType(view, R.id.radio_cover_img, "field 'radio_cover_img'", ImageView.class);
        playerActivity.comment_count = (TextView) Utils.findRequiredViewAsType(view, R.id.comment_count, "field 'comment_count'", TextView.class);
        View findRequiredView8 = Utils.findRequiredView(view, R.id.video_comment, "field 'video_comment' and method 'onClick'");
        playerActivity.video_comment = (RelativeLayout) Utils.castView(findRequiredView8, R.id.video_comment, "field 'video_comment'", RelativeLayout.class);
        this.i = findRequiredView8;
        findRequiredView8.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.PlayerActivity_ViewBinding.10
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                playerActivity.onClick(view2);
            }
        });
        playerActivity.video_favorite_state1 = (ImageView) Utils.findRequiredViewAsType(view, R.id.video_favorite_state1, "field 'video_favorite_state1'", ImageView.class);
        playerActivity.dialog_comment_tips_img = (ImageView) Utils.findRequiredViewAsType(view, R.id.dialog_comment_tips_img, "field 'dialog_comment_tips_img'", ImageView.class);
        View findRequiredView9 = Utils.findRequiredView(view, R.id.back_view, "method 'onClick'");
        this.j = findRequiredView9;
        findRequiredView9.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.PlayerActivity_ViewBinding.11
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                playerActivity.onClick(view2);
            }
        });
        View findRequiredView10 = Utils.findRequiredView(view, R.id.youtube_player, "method 'onClick'");
        this.k = findRequiredView10;
        findRequiredView10.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.PlayerActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                playerActivity.onClick(view2);
            }
        });
        View findRequiredView11 = Utils.findRequiredView(view, R.id.video_more_op, "method 'onClick'");
        this.l = findRequiredView11;
        findRequiredView11.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.PlayerActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                playerActivity.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PlayerActivity playerActivity = this.f3696a;
        if (playerActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3696a = null;
        playerActivity.blur_bg = null;
        playerActivity.music_name = null;
        playerActivity.artists_name = null;
        playerActivity.origin_cover = null;
        playerActivity.video_play_current_time = null;
        playerActivity.video_seek_bar = null;
        playerActivity.video_play_total_time = null;
        playerActivity.loop_model = null;
        playerActivity.play_back = null;
        playerActivity.play_next = null;
        playerActivity.video_play_list = null;
        playerActivity.change_play_state = null;
        playerActivity.change_play_loading = null;
        playerActivity.play_loading = null;
        playerActivity.go_youtube_panel = null;
        playerActivity.full_screen = null;
        playerActivity.video_favorite_state = null;
        playerActivity.view_pager = null;
        playerActivity.origin_cover_panel = null;
        playerActivity.radio_cover_panel = null;
        playerActivity.cover_panel = null;
        playerActivity.radio_cover_img = null;
        playerActivity.comment_count = null;
        playerActivity.video_comment = null;
        playerActivity.video_favorite_state1 = null;
        playerActivity.dialog_comment_tips_img = null;
        this.f3697b.setOnClickListener(null);
        this.f3697b = null;
        this.f3698c.setOnClickListener(null);
        this.f3698c = null;
        this.d.setOnClickListener(null);
        this.d = null;
        this.e.setOnClickListener(null);
        this.e = null;
        this.f.setOnClickListener(null);
        this.f = null;
        this.g.setOnClickListener(null);
        this.g = null;
        this.h.setOnClickListener(null);
        this.h = null;
        this.i.setOnClickListener(null);
        this.i = null;
        this.j.setOnClickListener(null);
        this.j = null;
        this.k.setOnClickListener(null);
        this.k = null;
        this.l.setOnClickListener(null);
        this.l = null;
    }
}

package com.fotoable.youtube.music.ui.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class MusicMenuDialog_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private MusicMenuDialog f4211a;

    /* renamed from: b  reason: collision with root package name */
    private View f4212b;

    /* renamed from: c  reason: collision with root package name */
    private View f4213c;
    private View d;
    private View e;
    private View f;
    private View g;
    private View h;
    private View i;
    private View j;
    private View k;
    private View l;
    private View m;
    private View n;
    private View o;
    private View p;

    @UiThread
    public MusicMenuDialog_ViewBinding(final MusicMenuDialog musicMenuDialog, View view) {
        this.f4211a = musicMenuDialog;
        musicMenuDialog.txtArtists = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_artists, "field 'txtArtists'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.lin_artist, "field 'linArtist' and method 'onClick'");
        musicMenuDialog.linArtist = (LinearLayout) Utils.castView(findRequiredView, R.id.lin_artist, "field 'linArtist'", LinearLayout.class);
        this.f4212b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.MusicMenuDialog_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                musicMenuDialog.onClick(view2);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.lin_delete, "field 'linDelete' and method 'onClick'");
        musicMenuDialog.linDelete = (LinearLayout) Utils.castView(findRequiredView2, R.id.lin_delete, "field 'linDelete'", LinearLayout.class);
        this.f4213c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.MusicMenuDialog_ViewBinding.8
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                musicMenuDialog.onClick(view2);
            }
        });
        musicMenuDialog.addPlaylistTipsImageView = (ImageView) Utils.findRequiredViewAsType(view, R.id.dialog_add_playlist_tips_img, "field 'addPlaylistTipsImageView'", ImageView.class);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.lin_admin_delete, "field 'adminDeleteView' and method 'onClick'");
        musicMenuDialog.adminDeleteView = (LinearLayout) Utils.castView(findRequiredView3, R.id.lin_admin_delete, "field 'adminDeleteView'", LinearLayout.class);
        this.d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.MusicMenuDialog_ViewBinding.9
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                musicMenuDialog.onClick(view2);
            }
        });
        View findRequiredView4 = Utils.findRequiredView(view, R.id.play_now, "field 'play_now' and method 'onClick'");
        musicMenuDialog.play_now = (LinearLayout) Utils.castView(findRequiredView4, R.id.play_now, "field 'play_now'", LinearLayout.class);
        this.e = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.MusicMenuDialog_ViewBinding.10
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                musicMenuDialog.onClick(view2);
            }
        });
        View findRequiredView5 = Utils.findRequiredView(view, R.id.play_next, "field 'play_next' and method 'onClick'");
        musicMenuDialog.play_next = (LinearLayout) Utils.castView(findRequiredView5, R.id.play_next, "field 'play_next'", LinearLayout.class);
        this.f = findRequiredView5;
        findRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.MusicMenuDialog_ViewBinding.11
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                musicMenuDialog.onClick(view2);
            }
        });
        View findRequiredView6 = Utils.findRequiredView(view, R.id.add_to_queue, "field 'add_to_queue' and method 'onClick'");
        musicMenuDialog.add_to_queue = (LinearLayout) Utils.castView(findRequiredView6, R.id.add_to_queue, "field 'add_to_queue'", LinearLayout.class);
        this.g = findRequiredView6;
        findRequiredView6.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.MusicMenuDialog_ViewBinding.12
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                musicMenuDialog.onClick(view2);
            }
        });
        View findRequiredView7 = Utils.findRequiredView(view, R.id.ll_sleep_time, "field 'll_sleep_time' and method 'onClick'");
        musicMenuDialog.ll_sleep_time = (LinearLayout) Utils.castView(findRequiredView7, R.id.ll_sleep_time, "field 'll_sleep_time'", LinearLayout.class);
        this.h = findRequiredView7;
        findRequiredView7.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.MusicMenuDialog_ViewBinding.13
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                musicMenuDialog.onClick(view2);
            }
        });
        musicMenuDialog.sleep_timer_real_time = (TextView) Utils.findRequiredViewAsType(view, R.id.sleep_timer_real_time, "field 'sleep_timer_real_time'", TextView.class);
        musicMenuDialog.btn_favorite = (CheckBox) Utils.findRequiredViewAsType(view, R.id.btn_favorite, "field 'btn_favorite'", CheckBox.class);
        musicMenuDialog.favorite_label = (TextView) Utils.findRequiredViewAsType(view, R.id.favorite_label, "field 'favorite_label'", TextView.class);
        View findRequiredView8 = Utils.findRequiredView(view, R.id.lin_comment, "field 'lin_comment' and method 'onClick'");
        musicMenuDialog.lin_comment = (RelativeLayout) Utils.castView(findRequiredView8, R.id.lin_comment, "field 'lin_comment'", RelativeLayout.class);
        this.i = findRequiredView8;
        findRequiredView8.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.MusicMenuDialog_ViewBinding.14
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                musicMenuDialog.onClick(view2);
            }
        });
        musicMenuDialog.dialog_comment_tips_img = (ImageView) Utils.findRequiredViewAsType(view, R.id.dialog_comment_tips_img, "field 'dialog_comment_tips_img'", ImageView.class);
        musicMenuDialog.comment_count = (TextView) Utils.findRequiredViewAsType(view, R.id.comment_count, "field 'comment_count'", TextView.class);
        musicMenuDialog.dialog_post_tips_img = (ImageView) Utils.findRequiredViewAsType(view, R.id.dialog_post_tips_img, "field 'dialog_post_tips_img'", ImageView.class);
        View findRequiredView9 = Utils.findRequiredView(view, R.id.lin_find_mp3, "method 'onClick'");
        this.j = findRequiredView9;
        findRequiredView9.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.MusicMenuDialog_ViewBinding.15
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                musicMenuDialog.onClick(view2);
            }
        });
        View findRequiredView10 = Utils.findRequiredView(view, R.id.lin_copy_url, "method 'onClick'");
        this.k = findRequiredView10;
        findRequiredView10.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.MusicMenuDialog_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                musicMenuDialog.onClick(view2);
            }
        });
        View findRequiredView11 = Utils.findRequiredView(view, R.id.lin_share, "method 'onClick'");
        this.l = findRequiredView11;
        findRequiredView11.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.MusicMenuDialog_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                musicMenuDialog.onClick(view2);
            }
        });
        View findRequiredView12 = Utils.findRequiredView(view, R.id.lin_find_lyric, "method 'onClick'");
        this.m = findRequiredView12;
        findRequiredView12.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.MusicMenuDialog_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                musicMenuDialog.onClick(view2);
            }
        });
        View findRequiredView13 = Utils.findRequiredView(view, R.id.add_to_playlist, "method 'onClick'");
        this.n = findRequiredView13;
        findRequiredView13.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.MusicMenuDialog_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                musicMenuDialog.onClick(view2);
            }
        });
        View findRequiredView14 = Utils.findRequiredView(view, R.id.ll_favorite, "method 'onClick'");
        this.o = findRequiredView14;
        findRequiredView14.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.MusicMenuDialog_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                musicMenuDialog.onClick(view2);
            }
        });
        View findRequiredView15 = Utils.findRequiredView(view, R.id.lin_share_to_community, "method 'onClick'");
        this.p = findRequiredView15;
        findRequiredView15.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.MusicMenuDialog_ViewBinding.7
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                musicMenuDialog.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MusicMenuDialog musicMenuDialog = this.f4211a;
        if (musicMenuDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4211a = null;
        musicMenuDialog.txtArtists = null;
        musicMenuDialog.linArtist = null;
        musicMenuDialog.linDelete = null;
        musicMenuDialog.addPlaylistTipsImageView = null;
        musicMenuDialog.adminDeleteView = null;
        musicMenuDialog.play_now = null;
        musicMenuDialog.play_next = null;
        musicMenuDialog.add_to_queue = null;
        musicMenuDialog.ll_sleep_time = null;
        musicMenuDialog.sleep_timer_real_time = null;
        musicMenuDialog.btn_favorite = null;
        musicMenuDialog.favorite_label = null;
        musicMenuDialog.lin_comment = null;
        musicMenuDialog.dialog_comment_tips_img = null;
        musicMenuDialog.comment_count = null;
        musicMenuDialog.dialog_post_tips_img = null;
        this.f4212b.setOnClickListener(null);
        this.f4212b = null;
        this.f4213c.setOnClickListener(null);
        this.f4213c = null;
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
        this.m.setOnClickListener(null);
        this.m = null;
        this.n.setOnClickListener(null);
        this.n = null;
        this.o.setOnClickListener(null);
        this.o = null;
        this.p.setOnClickListener(null);
        this.p = null;
    }
}

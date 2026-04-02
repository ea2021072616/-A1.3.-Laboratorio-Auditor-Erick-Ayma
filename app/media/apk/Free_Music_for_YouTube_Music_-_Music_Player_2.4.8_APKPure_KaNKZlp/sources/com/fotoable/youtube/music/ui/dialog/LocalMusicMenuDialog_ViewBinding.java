package com.fotoable.youtube.music.ui.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class LocalMusicMenuDialog_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private LocalMusicMenuDialog f4155a;

    /* renamed from: b  reason: collision with root package name */
    private View f4156b;

    /* renamed from: c  reason: collision with root package name */
    private View f4157c;
    private View d;
    private View e;
    private View f;
    private View g;
    private View h;
    private View i;
    private View j;
    private View k;

    @UiThread
    public LocalMusicMenuDialog_ViewBinding(final LocalMusicMenuDialog localMusicMenuDialog, View view) {
        this.f4155a = localMusicMenuDialog;
        localMusicMenuDialog.txtArtists = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_artists, "field 'txtArtists'", TextView.class);
        localMusicMenuDialog.tvAlbum = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_album, "field 'tvAlbum'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.lin_artist, "field 'linArtist' and method 'onClick'");
        localMusicMenuDialog.linArtist = (LinearLayout) Utils.castView(findRequiredView, R.id.lin_artist, "field 'linArtist'", LinearLayout.class);
        this.f4156b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.LocalMusicMenuDialog_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                localMusicMenuDialog.onClick(view2);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.lin_album, "field 'llAlbum' and method 'onClick'");
        localMusicMenuDialog.llAlbum = (LinearLayout) Utils.castView(findRequiredView2, R.id.lin_album, "field 'llAlbum'", LinearLayout.class);
        this.f4157c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.LocalMusicMenuDialog_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                localMusicMenuDialog.onClick(view2);
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.lin_delete, "field 'linDelete' and method 'onClick'");
        localMusicMenuDialog.linDelete = (LinearLayout) Utils.castView(findRequiredView3, R.id.lin_delete, "field 'linDelete'", LinearLayout.class);
        this.d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.LocalMusicMenuDialog_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                localMusicMenuDialog.onClick(view2);
            }
        });
        View findRequiredView4 = Utils.findRequiredView(view, R.id.btn_favorite, "field 'ckFavorite' and method 'onClick'");
        localMusicMenuDialog.ckFavorite = (CheckBox) Utils.castView(findRequiredView4, R.id.btn_favorite, "field 'ckFavorite'", CheckBox.class);
        this.e = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.LocalMusicMenuDialog_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                localMusicMenuDialog.onClick(view2);
            }
        });
        View findRequiredView5 = Utils.findRequiredView(view, R.id.ll_ring, "field 'llRing' and method 'onClick'");
        localMusicMenuDialog.llRing = (LinearLayout) Utils.castView(findRequiredView5, R.id.ll_ring, "field 'llRing'", LinearLayout.class);
        this.f = findRequiredView5;
        findRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.LocalMusicMenuDialog_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                localMusicMenuDialog.onClick(view2);
            }
        });
        View findRequiredView6 = Utils.findRequiredView(view, R.id.ll_favorite, "field 'llFavorite' and method 'onClick'");
        localMusicMenuDialog.llFavorite = (LinearLayout) Utils.castView(findRequiredView6, R.id.ll_favorite, "field 'llFavorite'", LinearLayout.class);
        this.g = findRequiredView6;
        findRequiredView6.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.LocalMusicMenuDialog_ViewBinding.7
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                localMusicMenuDialog.onClick(view2);
            }
        });
        View findRequiredView7 = Utils.findRequiredView(view, R.id.ll_sleep_timer, "field 'll_sleep_timer' and method 'onClick'");
        localMusicMenuDialog.ll_sleep_timer = (LinearLayout) Utils.castView(findRequiredView7, R.id.ll_sleep_timer, "field 'll_sleep_timer'", LinearLayout.class);
        this.h = findRequiredView7;
        findRequiredView7.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.LocalMusicMenuDialog_ViewBinding.8
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                localMusicMenuDialog.onClick(view2);
            }
        });
        localMusicMenuDialog.sleep_timer_real_time = (TextView) Utils.findRequiredViewAsType(view, R.id.sleep_timer_real_time, "field 'sleep_timer_real_time'", TextView.class);
        localMusicMenuDialog.favorite_label = (TextView) Utils.findRequiredViewAsType(view, R.id.favorite_label, "field 'favorite_label'", TextView.class);
        View findRequiredView8 = Utils.findRequiredView(view, R.id.lin_find_lyric, "method 'onClick'");
        this.i = findRequiredView8;
        findRequiredView8.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.LocalMusicMenuDialog_ViewBinding.9
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                localMusicMenuDialog.onClick(view2);
            }
        });
        View findRequiredView9 = Utils.findRequiredView(view, R.id.ll_share, "method 'onClick'");
        this.j = findRequiredView9;
        findRequiredView9.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.LocalMusicMenuDialog_ViewBinding.10
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                localMusicMenuDialog.onClick(view2);
            }
        });
        View findRequiredView10 = Utils.findRequiredView(view, R.id.add_to_playlist, "method 'onClick'");
        this.k = findRequiredView10;
        findRequiredView10.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.LocalMusicMenuDialog_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                localMusicMenuDialog.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LocalMusicMenuDialog localMusicMenuDialog = this.f4155a;
        if (localMusicMenuDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4155a = null;
        localMusicMenuDialog.txtArtists = null;
        localMusicMenuDialog.tvAlbum = null;
        localMusicMenuDialog.linArtist = null;
        localMusicMenuDialog.llAlbum = null;
        localMusicMenuDialog.linDelete = null;
        localMusicMenuDialog.ckFavorite = null;
        localMusicMenuDialog.llRing = null;
        localMusicMenuDialog.llFavorite = null;
        localMusicMenuDialog.ll_sleep_timer = null;
        localMusicMenuDialog.sleep_timer_real_time = null;
        localMusicMenuDialog.favorite_label = null;
        this.f4156b.setOnClickListener(null);
        this.f4156b = null;
        this.f4157c.setOnClickListener(null);
        this.f4157c = null;
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
    }
}

package com.fotoable.youtube.music.ui.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class MyRecentyWatchMenuDialog_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private MyRecentyWatchMenuDialog f4258a;

    /* renamed from: b  reason: collision with root package name */
    private View f4259b;

    /* renamed from: c  reason: collision with root package name */
    private View f4260c;
    private View d;
    private View e;
    private View f;
    private View g;
    private View h;
    private View i;
    private View j;

    @UiThread
    public MyRecentyWatchMenuDialog_ViewBinding(final MyRecentyWatchMenuDialog myRecentyWatchMenuDialog, View view) {
        this.f4258a = myRecentyWatchMenuDialog;
        myRecentyWatchMenuDialog.txtArtists = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_artists, "field 'txtArtists'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.lin_artist, "field 'linArtist' and method 'onClick'");
        myRecentyWatchMenuDialog.linArtist = (LinearLayout) Utils.castView(findRequiredView, R.id.lin_artist, "field 'linArtist'", LinearLayout.class);
        this.f4259b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.MyRecentyWatchMenuDialog_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                myRecentyWatchMenuDialog.onClick(view2);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.lin_add, "method 'onClick'");
        this.f4260c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.MyRecentyWatchMenuDialog_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                myRecentyWatchMenuDialog.onClick(view2);
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.lin_play_now, "method 'onClick'");
        this.d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.MyRecentyWatchMenuDialog_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                myRecentyWatchMenuDialog.onClick(view2);
            }
        });
        View findRequiredView4 = Utils.findRequiredView(view, R.id.lin_play_next, "method 'onClick'");
        this.e = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.MyRecentyWatchMenuDialog_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                myRecentyWatchMenuDialog.onClick(view2);
            }
        });
        View findRequiredView5 = Utils.findRequiredView(view, R.id.lin_delete, "method 'onClick'");
        this.f = findRequiredView5;
        findRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.MyRecentyWatchMenuDialog_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                myRecentyWatchMenuDialog.onClick(view2);
            }
        });
        View findRequiredView6 = Utils.findRequiredView(view, R.id.lin_find_mp3, "method 'onClick'");
        this.g = findRequiredView6;
        findRequiredView6.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.MyRecentyWatchMenuDialog_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                myRecentyWatchMenuDialog.onClick(view2);
            }
        });
        View findRequiredView7 = Utils.findRequiredView(view, R.id.lin_copy_url, "method 'onClick'");
        this.h = findRequiredView7;
        findRequiredView7.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.MyRecentyWatchMenuDialog_ViewBinding.7
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                myRecentyWatchMenuDialog.onClick(view2);
            }
        });
        View findRequiredView8 = Utils.findRequiredView(view, R.id.lin_share, "method 'onClick'");
        this.i = findRequiredView8;
        findRequiredView8.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.MyRecentyWatchMenuDialog_ViewBinding.8
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                myRecentyWatchMenuDialog.onClick(view2);
            }
        });
        View findRequiredView9 = Utils.findRequiredView(view, R.id.lin_find_lyric, "method 'onClick'");
        this.j = findRequiredView9;
        findRequiredView9.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.MyRecentyWatchMenuDialog_ViewBinding.9
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                myRecentyWatchMenuDialog.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MyRecentyWatchMenuDialog myRecentyWatchMenuDialog = this.f4258a;
        if (myRecentyWatchMenuDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4258a = null;
        myRecentyWatchMenuDialog.txtArtists = null;
        myRecentyWatchMenuDialog.linArtist = null;
        this.f4259b.setOnClickListener(null);
        this.f4259b = null;
        this.f4260c.setOnClickListener(null);
        this.f4260c = null;
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
    }
}

package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class MyPlaylistActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private MyPlaylistActivity f3578a;

    /* renamed from: b  reason: collision with root package name */
    private View f3579b;

    /* renamed from: c  reason: collision with root package name */
    private View f3580c;

    @UiThread
    public MyPlaylistActivity_ViewBinding(final MyPlaylistActivity myPlaylistActivity, View view) {
        this.f3578a = myPlaylistActivity;
        myPlaylistActivity.imgTop = (ImageView) Utils.findRequiredViewAsType(view, R.id.img_top, "field 'imgTop'", ImageView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.img_back, "field 'imgBack' and method 'onViewClicked'");
        myPlaylistActivity.imgBack = (ImageView) Utils.castView(findRequiredView, R.id.img_back, "field 'imgBack'", ImageView.class);
        this.f3579b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MyPlaylistActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                myPlaylistActivity.onViewClicked(view2);
            }
        });
        myPlaylistActivity.relToolbar = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rel_toolbar, "field 'relToolbar'", RelativeLayout.class);
        myPlaylistActivity.mListView = (ListView) Utils.findRequiredViewAsType(view, R.id.my_playlist_listView, "field 'mListView'", ListView.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.img_add_playlist, "method 'onViewClicked'");
        this.f3580c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MyPlaylistActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                myPlaylistActivity.onViewClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MyPlaylistActivity myPlaylistActivity = this.f3578a;
        if (myPlaylistActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3578a = null;
        myPlaylistActivity.imgTop = null;
        myPlaylistActivity.imgBack = null;
        myPlaylistActivity.relToolbar = null;
        myPlaylistActivity.mListView = null;
        this.f3579b.setOnClickListener(null);
        this.f3579b = null;
        this.f3580c.setOnClickListener(null);
        this.f3580c = null;
    }
}

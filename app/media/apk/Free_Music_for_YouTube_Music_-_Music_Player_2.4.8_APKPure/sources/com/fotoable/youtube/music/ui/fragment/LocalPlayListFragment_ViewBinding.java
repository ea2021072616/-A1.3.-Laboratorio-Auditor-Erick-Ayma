package com.fotoable.youtube.music.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class LocalPlayListFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private LocalPlayListFragment f4641a;

    /* renamed from: b  reason: collision with root package name */
    private View f4642b;

    @UiThread
    public LocalPlayListFragment_ViewBinding(final LocalPlayListFragment localPlayListFragment, View view) {
        this.f4641a = localPlayListFragment;
        localPlayListFragment.refresh_layout = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refresh_layout, "field 'refresh_layout'", SwipeRefreshLayout.class);
        localPlayListFragment.playlist_recycle_view = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.playlist_recycle_view, "field 'playlist_recycle_view'", RecyclerView.class);
        localPlayListFragment.local_total_play_list_count = (TextView) Utils.findRequiredViewAsType(view, R.id.local_total_play_list_count, "field 'local_total_play_list_count'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.create_play_list_iv, "method 'onClick'");
        this.f4642b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.fragment.LocalPlayListFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                localPlayListFragment.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LocalPlayListFragment localPlayListFragment = this.f4641a;
        if (localPlayListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4641a = null;
        localPlayListFragment.refresh_layout = null;
        localPlayListFragment.playlist_recycle_view = null;
        localPlayListFragment.local_total_play_list_count = null;
        this.f4642b.setOnClickListener(null);
        this.f4642b = null;
    }
}

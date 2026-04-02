package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class LocalPlayListDetailActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private LocalPlayListDetailActivity f3449a;

    /* renamed from: b  reason: collision with root package name */
    private View f3450b;

    @UiThread
    public LocalPlayListDetailActivity_ViewBinding(final LocalPlayListDetailActivity localPlayListDetailActivity, View view) {
        this.f3449a = localPlayListDetailActivity;
        localPlayListDetailActivity.refresh_layout = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refresh_layout, "field 'refresh_layout'", SwipeRefreshLayout.class);
        localPlayListDetailActivity.recycle_view = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_view, "field 'recycle_view'", RecyclerView.class);
        localPlayListDetailActivity.titleView = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'titleView'", TextView.class);
        localPlayListDetailActivity.rl_no_data = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_nodata, "field 'rl_no_data'", RelativeLayout.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.back_view, "method 'onClick'");
        this.f3450b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.LocalPlayListDetailActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                localPlayListDetailActivity.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LocalPlayListDetailActivity localPlayListDetailActivity = this.f3449a;
        if (localPlayListDetailActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3449a = null;
        localPlayListDetailActivity.refresh_layout = null;
        localPlayListDetailActivity.recycle_view = null;
        localPlayListDetailActivity.titleView = null;
        localPlayListDetailActivity.rl_no_data = null;
        this.f3450b.setOnClickListener(null);
        this.f3450b = null;
    }
}

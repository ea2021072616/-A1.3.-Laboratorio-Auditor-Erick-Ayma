package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class MyRecentlyWatchedActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private MyRecentlyWatchedActivity f3612a;

    /* renamed from: b  reason: collision with root package name */
    private View f3613b;

    /* renamed from: c  reason: collision with root package name */
    private View f3614c;

    @UiThread
    public MyRecentlyWatchedActivity_ViewBinding(final MyRecentlyWatchedActivity myRecentlyWatchedActivity, View view) {
        this.f3612a = myRecentlyWatchedActivity;
        myRecentlyWatchedActivity.recycleView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_pop, "field 'recycleView'", RecyclerView.class);
        myRecentlyWatchedActivity.refreshLayout = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refreshLayout, "field 'refreshLayout'", SwipeRefreshLayout.class);
        myRecentlyWatchedActivity.relNoData = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rel_no_data, "field 'relNoData'", RelativeLayout.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.iv_menu, "field 'iv_menu' and method 'onViewClicked'");
        myRecentlyWatchedActivity.iv_menu = (ImageView) Utils.castView(findRequiredView, R.id.iv_menu, "field 'iv_menu'", ImageView.class);
        this.f3613b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MyRecentlyWatchedActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                myRecentlyWatchedActivity.onViewClicked(view2);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.img_back, "method 'onViewClicked'");
        this.f3614c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MyRecentlyWatchedActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                myRecentlyWatchedActivity.onViewClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MyRecentlyWatchedActivity myRecentlyWatchedActivity = this.f3612a;
        if (myRecentlyWatchedActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3612a = null;
        myRecentlyWatchedActivity.recycleView = null;
        myRecentlyWatchedActivity.refreshLayout = null;
        myRecentlyWatchedActivity.relNoData = null;
        myRecentlyWatchedActivity.iv_menu = null;
        this.f3613b.setOnClickListener(null);
        this.f3613b = null;
        this.f3614c.setOnClickListener(null);
        this.f3614c = null;
    }
}

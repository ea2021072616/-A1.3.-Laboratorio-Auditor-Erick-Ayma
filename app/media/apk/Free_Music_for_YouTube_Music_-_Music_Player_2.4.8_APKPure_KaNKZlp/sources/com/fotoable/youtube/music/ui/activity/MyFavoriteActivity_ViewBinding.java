package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class MyFavoriteActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private MyFavoriteActivity f3571a;

    /* renamed from: b  reason: collision with root package name */
    private View f3572b;

    @UiThread
    public MyFavoriteActivity_ViewBinding(final MyFavoriteActivity myFavoriteActivity, View view) {
        this.f3571a = myFavoriteActivity;
        myFavoriteActivity.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_pop, "field 'recyclerView'", RecyclerView.class);
        myFavoriteActivity.refreshLayout = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refreshLayout, "field 'refreshLayout'", SwipeRefreshLayout.class);
        myFavoriteActivity.relNoData = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rel_no_data, "field 'relNoData'", RelativeLayout.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.img_back, "method 'onViewClicked'");
        this.f3572b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MyFavoriteActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                myFavoriteActivity.onViewClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MyFavoriteActivity myFavoriteActivity = this.f3571a;
        if (myFavoriteActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3571a = null;
        myFavoriteActivity.recyclerView = null;
        myFavoriteActivity.refreshLayout = null;
        myFavoriteActivity.relNoData = null;
        this.f3572b.setOnClickListener(null);
        this.f3572b = null;
    }
}

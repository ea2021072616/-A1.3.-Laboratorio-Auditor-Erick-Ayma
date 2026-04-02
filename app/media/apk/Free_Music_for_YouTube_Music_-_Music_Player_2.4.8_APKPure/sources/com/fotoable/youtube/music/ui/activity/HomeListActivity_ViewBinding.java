package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aspsine.irecyclerview.IRecyclerView;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.ISwipeRefreshLayout;
/* loaded from: classes.dex */
public class HomeListActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private HomeListActivity f3373a;

    /* renamed from: b  reason: collision with root package name */
    private View f3374b;

    @UiThread
    public HomeListActivity_ViewBinding(final HomeListActivity homeListActivity, View view) {
        this.f3373a = homeListActivity;
        View findRequiredView = Utils.findRequiredView(view, R.id.img_back, "field 'imgBack' and method 'onViewClicked'");
        homeListActivity.imgBack = (ImageView) Utils.castView(findRequiredView, R.id.img_back, "field 'imgBack'", ImageView.class);
        this.f3374b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.HomeListActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                homeListActivity.onViewClicked();
            }
        });
        homeListActivity.recycleView = (IRecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_view, "field 'recycleView'", IRecyclerView.class);
        homeListActivity.refreshLayout = (ISwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refreshLayout, "field 'refreshLayout'", ISwipeRefreshLayout.class);
        homeListActivity.titleTextView = (TextView) Utils.findRequiredViewAsType(view, R.id.title_tx, "field 'titleTextView'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        HomeListActivity homeListActivity = this.f3373a;
        if (homeListActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3373a = null;
        homeListActivity.imgBack = null;
        homeListActivity.recycleView = null;
        homeListActivity.refreshLayout = null;
        homeListActivity.titleTextView = null;
        this.f3374b.setOnClickListener(null);
        this.f3374b = null;
    }
}

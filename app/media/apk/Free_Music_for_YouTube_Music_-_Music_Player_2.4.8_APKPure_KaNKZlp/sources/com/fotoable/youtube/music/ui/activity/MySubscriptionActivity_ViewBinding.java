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
public class MySubscriptionActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private MySubscriptionActivity f3623a;

    /* renamed from: b  reason: collision with root package name */
    private View f3624b;

    @UiThread
    public MySubscriptionActivity_ViewBinding(final MySubscriptionActivity mySubscriptionActivity, View view) {
        this.f3623a = mySubscriptionActivity;
        mySubscriptionActivity.recycleview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_pop, "field 'recycleview'", RecyclerView.class);
        mySubscriptionActivity.refreshLayout = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refreshLayout, "field 'refreshLayout'", SwipeRefreshLayout.class);
        mySubscriptionActivity.relNoData = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rel_no_data, "field 'relNoData'", RelativeLayout.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.img_back, "method 'onViewClicked'");
        this.f3624b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MySubscriptionActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mySubscriptionActivity.onViewClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MySubscriptionActivity mySubscriptionActivity = this.f3623a;
        if (mySubscriptionActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3623a = null;
        mySubscriptionActivity.recycleview = null;
        mySubscriptionActivity.refreshLayout = null;
        mySubscriptionActivity.relNoData = null;
        this.f3624b.setOnClickListener(null);
        this.f3624b = null;
    }
}

package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class CountryActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private CountryActivity f3287a;

    /* renamed from: b  reason: collision with root package name */
    private View f3288b;

    @UiThread
    public CountryActivity_ViewBinding(final CountryActivity countryActivity, View view) {
        this.f3287a = countryActivity;
        View findRequiredView = Utils.findRequiredView(view, R.id.back_view, "field 'backView' and method 'onViewClicked'");
        countryActivity.backView = (ImageView) Utils.castView(findRequiredView, R.id.back_view, "field 'backView'", ImageView.class);
        this.f3288b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.CountryActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                countryActivity.onViewClicked();
            }
        });
        countryActivity.recycleView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_view, "field 'recycleView'", RecyclerView.class);
        countryActivity.refreshLayout = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refreshLayout, "field 'refreshLayout'", SwipeRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CountryActivity countryActivity = this.f3287a;
        if (countryActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3287a = null;
        countryActivity.backView = null;
        countryActivity.recycleView = null;
        countryActivity.refreshLayout = null;
        this.f3288b.setOnClickListener(null);
        this.f3288b = null;
    }
}

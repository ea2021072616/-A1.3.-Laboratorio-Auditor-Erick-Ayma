package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.flyco.tablayout.SlidingTabLayout;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.LaToTextView;
/* loaded from: classes.dex */
public class GenresDetailActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private GenresDetailActivity f3339a;

    /* renamed from: b  reason: collision with root package name */
    private View f3340b;

    @UiThread
    public GenresDetailActivity_ViewBinding(final GenresDetailActivity genresDetailActivity, View view) {
        this.f3339a = genresDetailActivity;
        genresDetailActivity.searchTabLayout = (SlidingTabLayout) Utils.findRequiredViewAsType(view, R.id.search_tab_layout, "field 'searchTabLayout'", SlidingTabLayout.class);
        genresDetailActivity.searchViewPager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.search_view_pager, "field 'searchViewPager'", ViewPager.class);
        genresDetailActivity.txtTitle = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.txt_title, "field 'txtTitle'", LaToTextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.back_view, "method 'onViewClicked'");
        this.f3340b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.GenresDetailActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                genresDetailActivity.onViewClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        GenresDetailActivity genresDetailActivity = this.f3339a;
        if (genresDetailActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3339a = null;
        genresDetailActivity.searchTabLayout = null;
        genresDetailActivity.searchViewPager = null;
        genresDetailActivity.txtTitle = null;
        this.f3340b.setOnClickListener(null);
        this.f3340b = null;
    }
}

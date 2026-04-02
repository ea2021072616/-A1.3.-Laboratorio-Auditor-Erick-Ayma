package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.flyco.tablayout.SlidingTabLayout;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class SearchActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private SearchActivity f3771a;

    /* renamed from: b  reason: collision with root package name */
    private View f3772b;

    /* renamed from: c  reason: collision with root package name */
    private View f3773c;

    @UiThread
    public SearchActivity_ViewBinding(final SearchActivity searchActivity, View view) {
        this.f3771a = searchActivity;
        searchActivity.searchEdit = (EditText) Utils.findRequiredViewAsType(view, R.id.search_edit, "field 'searchEdit'", EditText.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.search_cancel_tx, "field 'searchCancelTx' and method 'onViewClicked'");
        searchActivity.searchCancelTx = (TextView) Utils.castView(findRequiredView, R.id.search_cancel_tx, "field 'searchCancelTx'", TextView.class);
        this.f3772b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.SearchActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                searchActivity.onViewClicked(view2);
            }
        });
        searchActivity.searchHistoryListView = (ListView) Utils.findRequiredViewAsType(view, R.id.search_history_list_view, "field 'searchHistoryListView'", ListView.class);
        searchActivity.searchTabLayout = (SlidingTabLayout) Utils.findRequiredViewAsType(view, R.id.search_tab_layout, "field 'searchTabLayout'", SlidingTabLayout.class);
        searchActivity.searchViewPager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.search_view_pager, "field 'searchViewPager'", ViewPager.class);
        searchActivity.searchResultView = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.search_result_view, "field 'searchResultView'", LinearLayout.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.search_delete_img, "field 'searchDeleteImg' and method 'onViewClicked'");
        searchActivity.searchDeleteImg = (ImageView) Utils.castView(findRequiredView2, R.id.search_delete_img, "field 'searchDeleteImg'", ImageView.class);
        this.f3773c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.SearchActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                searchActivity.onViewClicked(view2);
            }
        });
        searchActivity.shadowView = Utils.findRequiredView(view, R.id.search_history_title_shadow_view, "field 'shadowView'");
        searchActivity.mSuggestListView = (ListView) Utils.findRequiredViewAsType(view, R.id.search_suggest_list_view, "field 'mSuggestListView'", ListView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SearchActivity searchActivity = this.f3771a;
        if (searchActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3771a = null;
        searchActivity.searchEdit = null;
        searchActivity.searchCancelTx = null;
        searchActivity.searchHistoryListView = null;
        searchActivity.searchTabLayout = null;
        searchActivity.searchViewPager = null;
        searchActivity.searchResultView = null;
        searchActivity.searchDeleteImg = null;
        searchActivity.shadowView = null;
        searchActivity.mSuggestListView = null;
        this.f3772b.setOnClickListener(null);
        this.f3772b = null;
        this.f3773c.setOnClickListener(null);
        this.f3773c = null;
    }
}

package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aspsine.irecyclerview.IRecyclerView;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class CommunityPostDetailActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private CommunityPostDetailActivity f3264a;

    /* renamed from: b  reason: collision with root package name */
    private View f3265b;

    /* renamed from: c  reason: collision with root package name */
    private View f3266c;

    @UiThread
    public CommunityPostDetailActivity_ViewBinding(final CommunityPostDetailActivity communityPostDetailActivity, View view) {
        this.f3264a = communityPostDetailActivity;
        communityPostDetailActivity.recycle_view = (IRecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_view, "field 'recycle_view'", IRecyclerView.class);
        communityPostDetailActivity.comment_content_et = (EditText) Utils.findRequiredViewAsType(view, R.id.comment_content_et, "field 'comment_content_et'", EditText.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.send_comment, "field 'send_comment' and method 'onClick'");
        communityPostDetailActivity.send_comment = (TextView) Utils.castView(findRequiredView, R.id.send_comment, "field 'send_comment'", TextView.class);
        this.f3265b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.CommunityPostDetailActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                communityPostDetailActivity.onClick(view2);
            }
        });
        communityPostDetailActivity.refreshLayout = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refreshLayout, "field 'refreshLayout'", SwipeRefreshLayout.class);
        communityPostDetailActivity.comment_content_et_hint = (TextView) Utils.findRequiredViewAsType(view, R.id.comment_content_et_hint, "field 'comment_content_et_hint'", TextView.class);
        communityPostDetailActivity.comment_content_et_hint_panel = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.comment_content_et_hint_panel, "field 'comment_content_et_hint_panel'", LinearLayout.class);
        communityPostDetailActivity.tv_toolbar_title = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_toolbar_title, "field 'tv_toolbar_title'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.back_view, "method 'onClick'");
        this.f3266c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.CommunityPostDetailActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                communityPostDetailActivity.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CommunityPostDetailActivity communityPostDetailActivity = this.f3264a;
        if (communityPostDetailActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3264a = null;
        communityPostDetailActivity.recycle_view = null;
        communityPostDetailActivity.comment_content_et = null;
        communityPostDetailActivity.send_comment = null;
        communityPostDetailActivity.refreshLayout = null;
        communityPostDetailActivity.comment_content_et_hint = null;
        communityPostDetailActivity.comment_content_et_hint_panel = null;
        communityPostDetailActivity.tv_toolbar_title = null;
        this.f3265b.setOnClickListener(null);
        this.f3265b = null;
        this.f3266c.setOnClickListener(null);
        this.f3266c = null;
    }
}

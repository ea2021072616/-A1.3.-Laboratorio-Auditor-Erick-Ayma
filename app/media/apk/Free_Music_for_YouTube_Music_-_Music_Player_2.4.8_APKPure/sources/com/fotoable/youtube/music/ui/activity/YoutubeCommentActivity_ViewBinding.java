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
public class YoutubeCommentActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private YoutubeCommentActivity f3898a;

    /* renamed from: b  reason: collision with root package name */
    private View f3899b;

    /* renamed from: c  reason: collision with root package name */
    private View f3900c;

    @UiThread
    public YoutubeCommentActivity_ViewBinding(final YoutubeCommentActivity youtubeCommentActivity, View view) {
        this.f3898a = youtubeCommentActivity;
        youtubeCommentActivity.recycle_view = (IRecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_view, "field 'recycle_view'", IRecyclerView.class);
        youtubeCommentActivity.comment_content_et = (EditText) Utils.findRequiredViewAsType(view, R.id.comment_content_et, "field 'comment_content_et'", EditText.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.send_comment, "field 'send_comment' and method 'onClick'");
        youtubeCommentActivity.send_comment = (TextView) Utils.castView(findRequiredView, R.id.send_comment, "field 'send_comment'", TextView.class);
        this.f3899b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.YoutubeCommentActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                youtubeCommentActivity.onClick(view2);
            }
        });
        youtubeCommentActivity.refreshLayout = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refreshLayout, "field 'refreshLayout'", SwipeRefreshLayout.class);
        youtubeCommentActivity.comment_content_et_hint = (TextView) Utils.findRequiredViewAsType(view, R.id.comment_content_et_hint, "field 'comment_content_et_hint'", TextView.class);
        youtubeCommentActivity.comment_content_et_hint_panel = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.comment_content_et_hint_panel, "field 'comment_content_et_hint_panel'", LinearLayout.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.back_view, "method 'onClick'");
        this.f3900c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.YoutubeCommentActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                youtubeCommentActivity.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        YoutubeCommentActivity youtubeCommentActivity = this.f3898a;
        if (youtubeCommentActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3898a = null;
        youtubeCommentActivity.recycle_view = null;
        youtubeCommentActivity.comment_content_et = null;
        youtubeCommentActivity.send_comment = null;
        youtubeCommentActivity.refreshLayout = null;
        youtubeCommentActivity.comment_content_et_hint = null;
        youtubeCommentActivity.comment_content_et_hint_panel = null;
        this.f3899b.setOnClickListener(null);
        this.f3899b = null;
        this.f3900c.setOnClickListener(null);
        this.f3900c = null;
    }
}

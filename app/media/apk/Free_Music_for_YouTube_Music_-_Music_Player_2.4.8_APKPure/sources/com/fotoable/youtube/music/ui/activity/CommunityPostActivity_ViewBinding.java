package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.LaToTextView;
/* loaded from: classes.dex */
public class CommunityPostActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private CommunityPostActivity f3219a;

    /* renamed from: b  reason: collision with root package name */
    private View f3220b;

    /* renamed from: c  reason: collision with root package name */
    private View f3221c;
    private View d;
    private View e;

    @UiThread
    public CommunityPostActivity_ViewBinding(final CommunityPostActivity communityPostActivity, View view) {
        this.f3219a = communityPostActivity;
        communityPostActivity.tvPostType = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.tv_post_type, "field 'tvPostType'", LaToTextView.class);
        communityPostActivity.etPostContent = (EditText) Utils.findRequiredViewAsType(view, R.id.et_post_content, "field 'etPostContent'", EditText.class);
        communityPostActivity.rvPostImage = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_post_image, "field 'rvPostImage'", RecyclerView.class);
        communityPostActivity.ivPostVideoCover = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_post_video_cover, "field 'ivPostVideoCover'", ImageView.class);
        communityPostActivity.tvPostVideoTime = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.tv_post_video_time, "field 'tvPostVideoTime'", LaToTextView.class);
        communityPostActivity.tvPostVideoTitle = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.tv_post_video_title, "field 'tvPostVideoTitle'", LaToTextView.class);
        communityPostActivity.tvPostVideoArtists = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.tv_post_video_artists, "field 'tvPostVideoArtists'", LaToTextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.ll_post_video, "field 'llPostVideo' and method 'onViewClicked'");
        communityPostActivity.llPostVideo = (RelativeLayout) Utils.castView(findRequiredView, R.id.ll_post_video, "field 'llPostVideo'", RelativeLayout.class);
        this.f3220b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.CommunityPostActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                communityPostActivity.onViewClicked(view2);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.rl_post_type_panel, "field 'rl_post_type_panel' and method 'onViewClicked'");
        communityPostActivity.rl_post_type_panel = (RelativeLayout) Utils.castView(findRequiredView2, R.id.rl_post_type_panel, "field 'rl_post_type_panel'", RelativeLayout.class);
        this.f3221c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.CommunityPostActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                communityPostActivity.onViewClicked(view2);
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.back_view, "method 'onViewClicked'");
        this.d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.CommunityPostActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                communityPostActivity.onViewClicked(view2);
            }
        });
        View findRequiredView4 = Utils.findRequiredView(view, R.id.tv_post_send, "method 'onViewClicked'");
        this.e = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.CommunityPostActivity_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                communityPostActivity.onViewClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CommunityPostActivity communityPostActivity = this.f3219a;
        if (communityPostActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3219a = null;
        communityPostActivity.tvPostType = null;
        communityPostActivity.etPostContent = null;
        communityPostActivity.rvPostImage = null;
        communityPostActivity.ivPostVideoCover = null;
        communityPostActivity.tvPostVideoTime = null;
        communityPostActivity.tvPostVideoTitle = null;
        communityPostActivity.tvPostVideoArtists = null;
        communityPostActivity.llPostVideo = null;
        communityPostActivity.rl_post_type_panel = null;
        this.f3220b.setOnClickListener(null);
        this.f3220b = null;
        this.f3221c.setOnClickListener(null);
        this.f3221c = null;
        this.d.setOnClickListener(null);
        this.d = null;
        this.e.setOnClickListener(null);
        this.e = null;
    }
}

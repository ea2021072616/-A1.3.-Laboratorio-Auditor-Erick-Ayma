package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
import com.yanzhenjie.album.widget.photoview.FixViewPager;
/* loaded from: classes.dex */
public class CommunityPostImagePreviewActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private CommunityPostImagePreviewActivity f3278a;

    /* renamed from: b  reason: collision with root package name */
    private View f3279b;

    @UiThread
    public CommunityPostImagePreviewActivity_ViewBinding(final CommunityPostImagePreviewActivity communityPostImagePreviewActivity, View view) {
        this.f3278a = communityPostImagePreviewActivity;
        communityPostImagePreviewActivity.vpPostImagePreview = (FixViewPager) Utils.findRequiredViewAsType(view, R.id.vp_post_image_preview, "field 'vpPostImagePreview'", FixViewPager.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.tv_save_image, "field 'tvSaveImage' and method 'onViewClick'");
        communityPostImagePreviewActivity.tvSaveImage = (TextView) Utils.castView(findRequiredView, R.id.tv_save_image, "field 'tvSaveImage'", TextView.class);
        this.f3279b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.CommunityPostImagePreviewActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                communityPostImagePreviewActivity.onViewClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CommunityPostImagePreviewActivity communityPostImagePreviewActivity = this.f3278a;
        if (communityPostImagePreviewActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3278a = null;
        communityPostImagePreviewActivity.vpPostImagePreview = null;
        communityPostImagePreviewActivity.tvSaveImage = null;
        this.f3279b.setOnClickListener(null);
        this.f3279b = null;
    }
}

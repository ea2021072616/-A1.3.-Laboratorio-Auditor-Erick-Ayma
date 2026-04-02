package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class YoutubeGuideTipActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private YoutubeGuideTipActivity f3907a;

    /* renamed from: b  reason: collision with root package name */
    private View f3908b;

    @UiThread
    public YoutubeGuideTipActivity_ViewBinding(final YoutubeGuideTipActivity youtubeGuideTipActivity, View view) {
        this.f3907a = youtubeGuideTipActivity;
        youtubeGuideTipActivity.max_view = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.max_view, "field 'max_view'", RelativeLayout.class);
        youtubeGuideTipActivity.content_panel = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.content_panel, "field 'content_panel'", LinearLayout.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.ok_ltv, "method 'onClick'");
        this.f3908b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.YoutubeGuideTipActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                youtubeGuideTipActivity.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        YoutubeGuideTipActivity youtubeGuideTipActivity = this.f3907a;
        if (youtubeGuideTipActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3907a = null;
        youtubeGuideTipActivity.max_view = null;
        youtubeGuideTipActivity.content_panel = null;
        this.f3908b.setOnClickListener(null);
        this.f3908b = null;
    }
}

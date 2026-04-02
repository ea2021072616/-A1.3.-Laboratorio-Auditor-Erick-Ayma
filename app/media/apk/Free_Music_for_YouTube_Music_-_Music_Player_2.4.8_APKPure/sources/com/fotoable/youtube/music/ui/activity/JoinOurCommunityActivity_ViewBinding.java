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
public class JoinOurCommunityActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private JoinOurCommunityActivity f3377a;

    /* renamed from: b  reason: collision with root package name */
    private View f3378b;

    /* renamed from: c  reason: collision with root package name */
    private View f3379c;

    @UiThread
    public JoinOurCommunityActivity_ViewBinding(final JoinOurCommunityActivity joinOurCommunityActivity, View view) {
        this.f3377a = joinOurCommunityActivity;
        joinOurCommunityActivity.top_panel = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.top_panel, "field 'top_panel'", RelativeLayout.class);
        joinOurCommunityActivity.title_panel = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.title_panel, "field 'title_panel'", LinearLayout.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.back_view, "method 'onClick'");
        this.f3378b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.JoinOurCommunityActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                joinOurCommunityActivity.onClick(view2);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.bt_join_us, "method 'onClick'");
        this.f3379c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.JoinOurCommunityActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                joinOurCommunityActivity.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        JoinOurCommunityActivity joinOurCommunityActivity = this.f3377a;
        if (joinOurCommunityActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3377a = null;
        joinOurCommunityActivity.top_panel = null;
        joinOurCommunityActivity.title_panel = null;
        this.f3378b.setOnClickListener(null);
        this.f3378b = null;
        this.f3379c.setOnClickListener(null);
        this.f3379c = null;
    }
}

package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.LaToTextView;
/* loaded from: classes.dex */
public class AboutActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private AboutActivity f3166a;

    /* renamed from: b  reason: collision with root package name */
    private View f3167b;

    /* renamed from: c  reason: collision with root package name */
    private View f3168c;
    private View d;

    @UiThread
    public AboutActivity_ViewBinding(final AboutActivity aboutActivity, View view) {
        this.f3166a = aboutActivity;
        View findRequiredView = Utils.findRequiredView(view, R.id.back_view, "field 'backView' and method 'onViewClicked'");
        aboutActivity.backView = (ImageView) Utils.castView(findRequiredView, R.id.back_view, "field 'backView'", ImageView.class);
        this.f3167b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.AboutActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                aboutActivity.onViewClicked(view2);
            }
        });
        aboutActivity.appVersionTx = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.app_version_tx, "field 'appVersionTx'", LaToTextView.class);
        aboutActivity.iconJoinOurCommunity = (ImageView) Utils.findRequiredViewAsType(view, R.id.icon_join_our_community, "field 'iconJoinOurCommunity'", ImageView.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.rl_join_our_community, "field 'rlJoinOurCommunity' and method 'onViewClicked'");
        aboutActivity.rlJoinOurCommunity = (RelativeLayout) Utils.castView(findRequiredView2, R.id.rl_join_our_community, "field 'rlJoinOurCommunity'", RelativeLayout.class);
        this.f3168c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.AboutActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                aboutActivity.onViewClicked(view2);
            }
        });
        aboutActivity.iconPolicy = (ImageView) Utils.findRequiredViewAsType(view, R.id.icon_policy, "field 'iconPolicy'", ImageView.class);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.rl_privacy_policy, "field 'rlPrivacyPolicy' and method 'onViewClicked'");
        aboutActivity.rlPrivacyPolicy = (RelativeLayout) Utils.castView(findRequiredView3, R.id.rl_privacy_policy, "field 'rlPrivacyPolicy'", RelativeLayout.class);
        this.d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.AboutActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                aboutActivity.onViewClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AboutActivity aboutActivity = this.f3166a;
        if (aboutActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3166a = null;
        aboutActivity.backView = null;
        aboutActivity.appVersionTx = null;
        aboutActivity.iconJoinOurCommunity = null;
        aboutActivity.rlJoinOurCommunity = null;
        aboutActivity.iconPolicy = null;
        aboutActivity.rlPrivacyPolicy = null;
        this.f3167b.setOnClickListener(null);
        this.f3167b = null;
        this.f3168c.setOnClickListener(null);
        this.f3168c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }
}

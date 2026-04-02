package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class UserInfoActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private UserInfoActivity f3867a;

    /* renamed from: b  reason: collision with root package name */
    private View f3868b;

    /* renamed from: c  reason: collision with root package name */
    private View f3869c;
    private View d;

    @UiThread
    public UserInfoActivity_ViewBinding(final UserInfoActivity userInfoActivity, View view) {
        this.f3867a = userInfoActivity;
        userInfoActivity.user_avatar = (ImageView) Utils.findRequiredViewAsType(view, R.id.user_avatar, "field 'user_avatar'", ImageView.class);
        userInfoActivity.user_nick = (TextView) Utils.findRequiredViewAsType(view, R.id.user_name, "field 'user_nick'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.back_view, "method 'onClick'");
        this.f3868b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.UserInfoActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                userInfoActivity.onClick(view2);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.user_avatar_panel, "method 'onClick'");
        this.f3869c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.UserInfoActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                userInfoActivity.onClick(view2);
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.user_name_panel, "method 'onClick'");
        this.d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.UserInfoActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                userInfoActivity.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        UserInfoActivity userInfoActivity = this.f3867a;
        if (userInfoActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3867a = null;
        userInfoActivity.user_avatar = null;
        userInfoActivity.user_nick = null;
        this.f3868b.setOnClickListener(null);
        this.f3868b = null;
        this.f3869c.setOnClickListener(null);
        this.f3869c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }
}

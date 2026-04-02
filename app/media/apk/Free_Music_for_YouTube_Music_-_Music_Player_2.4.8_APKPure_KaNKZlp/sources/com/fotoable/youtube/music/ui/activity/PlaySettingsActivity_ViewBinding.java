package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class PlaySettingsActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private PlaySettingsActivity f3658a;

    /* renamed from: b  reason: collision with root package name */
    private View f3659b;

    /* renamed from: c  reason: collision with root package name */
    private View f3660c;
    private View d;
    private View e;
    private View f;
    private View g;

    @UiThread
    public PlaySettingsActivity_ViewBinding(final PlaySettingsActivity playSettingsActivity, View view) {
        this.f3658a = playSettingsActivity;
        View findRequiredView = Utils.findRequiredView(view, R.id.back_view, "field 'backView' and method 'onViewClicked'");
        playSettingsActivity.backView = (ImageView) Utils.castView(findRequiredView, R.id.back_view, "field 'backView'", ImageView.class);
        this.f3659b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.PlaySettingsActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                playSettingsActivity.onViewClicked(view2);
            }
        });
        playSettingsActivity.ckAutoRotate = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ck_auto_rotate, "field 'ckAutoRotate'", CheckBox.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.rl_auto_rotate_screen, "field 'rlAutoRotateScreen' and method 'onViewClicked'");
        playSettingsActivity.rlAutoRotateScreen = (RelativeLayout) Utils.castView(findRequiredView2, R.id.rl_auto_rotate_screen, "field 'rlAutoRotateScreen'", RelativeLayout.class);
        this.f3660c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.PlaySettingsActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                playSettingsActivity.onViewClicked(view2);
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.rl_pop_up_size, "field 'rlPopUpSize' and method 'onViewClicked'");
        playSettingsActivity.rlPopUpSize = (RelativeLayout) Utils.castView(findRequiredView3, R.id.rl_pop_up_size, "field 'rlPopUpSize'", RelativeLayout.class);
        this.d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.PlaySettingsActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                playSettingsActivity.onViewClicked(view2);
            }
        });
        playSettingsActivity.ckAutoPlay = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ck_auto_play, "field 'ckAutoPlay'", CheckBox.class);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.rl_auto_play, "field 'rlAutoPlay' and method 'onViewClicked'");
        playSettingsActivity.rlAutoPlay = (RelativeLayout) Utils.castView(findRequiredView4, R.id.rl_auto_play, "field 'rlAutoPlay'", RelativeLayout.class);
        this.e = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.PlaySettingsActivity_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                playSettingsActivity.onViewClicked(view2);
            }
        });
        playSettingsActivity.ckActionBar = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ck_action_bar, "field 'ckActionBar'", CheckBox.class);
        View findRequiredView5 = Utils.findRequiredView(view, R.id.rl_action_bar, "field 'rlActionBar' and method 'onViewClicked'");
        playSettingsActivity.rlActionBar = (RelativeLayout) Utils.castView(findRequiredView5, R.id.rl_action_bar, "field 'rlActionBar'", RelativeLayout.class);
        this.f = findRequiredView5;
        findRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.PlaySettingsActivity_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                playSettingsActivity.onViewClicked(view2);
            }
        });
        playSettingsActivity.ckWifiOnly = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ck_wifi_only, "field 'ckWifiOnly'", CheckBox.class);
        View findRequiredView6 = Utils.findRequiredView(view, R.id.rl_wifi_only, "field 'rlWifiOnly' and method 'onViewClicked'");
        playSettingsActivity.rlWifiOnly = (RelativeLayout) Utils.castView(findRequiredView6, R.id.rl_wifi_only, "field 'rlWifiOnly'", RelativeLayout.class);
        this.g = findRequiredView6;
        findRequiredView6.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.PlaySettingsActivity_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                playSettingsActivity.onViewClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PlaySettingsActivity playSettingsActivity = this.f3658a;
        if (playSettingsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3658a = null;
        playSettingsActivity.backView = null;
        playSettingsActivity.ckAutoRotate = null;
        playSettingsActivity.rlAutoRotateScreen = null;
        playSettingsActivity.rlPopUpSize = null;
        playSettingsActivity.ckAutoPlay = null;
        playSettingsActivity.rlAutoPlay = null;
        playSettingsActivity.ckActionBar = null;
        playSettingsActivity.rlActionBar = null;
        playSettingsActivity.ckWifiOnly = null;
        playSettingsActivity.rlWifiOnly = null;
        this.f3659b.setOnClickListener(null);
        this.f3659b = null;
        this.f3660c.setOnClickListener(null);
        this.f3660c = null;
        this.d.setOnClickListener(null);
        this.d = null;
        this.e.setOnClickListener(null);
        this.e = null;
        this.f.setOnClickListener(null);
        this.f = null;
        this.g.setOnClickListener(null);
        this.g = null;
    }
}

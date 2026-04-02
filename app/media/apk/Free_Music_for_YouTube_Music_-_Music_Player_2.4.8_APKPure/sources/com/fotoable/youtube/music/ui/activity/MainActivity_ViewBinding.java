package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.LaToTextView;
/* loaded from: classes.dex */
public class MainActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private MainActivity f3487a;

    /* renamed from: b  reason: collision with root package name */
    private View f3488b;

    /* renamed from: c  reason: collision with root package name */
    private View f3489c;
    private View d;
    private View e;
    private View f;
    private View g;
    private View h;
    private View i;
    private View j;
    private View k;
    private View l;
    private View m;
    private View n;
    private View o;

    @UiThread
    public MainActivity_ViewBinding(final MainActivity mainActivity, View view) {
        this.f3487a = mainActivity;
        mainActivity.mainRadioGroup = (RadioGroup) Utils.findRequiredViewAsType(view, R.id.main_radio_group, "field 'mainRadioGroup'", RadioGroup.class);
        mainActivity.viewPager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.view_pager, "field 'viewPager'", ViewPager.class);
        mainActivity.homeRb = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_home, "field 'homeRb'", RadioButton.class);
        mainActivity.myMusicRb = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_my_music, "field 'myMusicRb'", RadioButton.class);
        mainActivity.communityRb = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_community, "field 'communityRb'", RadioButton.class);
        mainActivity.mDrawerLayout = (DrawerLayout) Utils.findRequiredViewAsType(view, R.id.main_drawer, "field 'mDrawerLayout'", DrawerLayout.class);
        mainActivity.sleep_timer_real_time = (TextView) Utils.findRequiredViewAsType(view, R.id.sleep_timer_real_time, "field 'sleep_timer_real_time'", TextView.class);
        mainActivity.user_avatar = (ImageView) Utils.findRequiredViewAsType(view, R.id.user_avatar, "field 'user_avatar'", ImageView.class);
        mainActivity.user_nick = (TextView) Utils.findRequiredViewAsType(view, R.id.user_nick, "field 'user_nick'", TextView.class);
        mainActivity.iv_vip_mark_icon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_vip_mark_icon, "field 'iv_vip_mark_icon'", ImageView.class);
        mainActivity.iv_music_recognition_lock = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_music_recognition_lock, "field 'iv_music_recognition_lock'", ImageView.class);
        mainActivity.slideMenuView = Utils.findRequiredView(view, R.id.slide_menu_view, "field 'slideMenuView'");
        mainActivity.priceTextView = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.ad_price_tx, "field 'priceTextView'", LaToTextView.class);
        mainActivity.iv_pur_success = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_pur_success, "field 'iv_pur_success'", ImageView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.remove_ad_view, "field 'adView' and method 'onViewClicked'");
        mainActivity.adView = findRequiredView;
        this.f3488b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MainActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mainActivity.onViewClicked(view2);
            }
        });
        mainActivity.pushCheckbox = (CheckBox) Utils.findRequiredViewAsType(view, R.id.push_checkbox, "field 'pushCheckbox'", CheckBox.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.main_menu_img, "method 'onViewClicked'");
        this.f3489c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MainActivity_ViewBinding.7
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mainActivity.onViewClicked(view2);
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.main_search_img, "method 'onViewClicked'");
        this.d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MainActivity_ViewBinding.8
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mainActivity.onViewClicked(view2);
            }
        });
        View findRequiredView4 = Utils.findRequiredView(view, R.id.bottom_player_panel, "method 'onViewClicked'");
        this.e = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MainActivity_ViewBinding.9
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mainActivity.onViewClicked(view2);
            }
        });
        View findRequiredView5 = Utils.findRequiredView(view, R.id.play_state, "method 'onViewClicked'");
        this.f = findRequiredView5;
        findRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MainActivity_ViewBinding.10
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mainActivity.onViewClicked(view2);
            }
        });
        View findRequiredView6 = Utils.findRequiredView(view, R.id.music_recognition_view, "method 'onViewClicked'");
        this.g = findRequiredView6;
        findRequiredView6.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MainActivity_ViewBinding.11
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mainActivity.onViewClicked(view2);
            }
        });
        View findRequiredView7 = Utils.findRequiredView(view, R.id.push_switch_view, "method 'onViewClicked'");
        this.h = findRequiredView7;
        findRequiredView7.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MainActivity_ViewBinding.12
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mainActivity.onViewClicked(view2);
            }
        });
        View findRequiredView8 = Utils.findRequiredView(view, R.id.rate_us_view, "method 'onViewClicked'");
        this.i = findRequiredView8;
        findRequiredView8.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MainActivity_ViewBinding.13
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mainActivity.onViewClicked(view2);
            }
        });
        View findRequiredView9 = Utils.findRequiredView(view, R.id.about_us_view, "method 'onViewClicked'");
        this.j = findRequiredView9;
        findRequiredView9.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MainActivity_ViewBinding.14
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mainActivity.onViewClicked(view2);
            }
        });
        View findRequiredView10 = Utils.findRequiredView(view, R.id.share_app_view, "method 'onViewClicked'");
        this.k = findRequiredView10;
        findRequiredView10.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MainActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mainActivity.onViewClicked(view2);
            }
        });
        View findRequiredView11 = Utils.findRequiredView(view, R.id.set_view, "method 'onViewClicked'");
        this.l = findRequiredView11;
        findRequiredView11.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MainActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mainActivity.onViewClicked(view2);
            }
        });
        View findRequiredView12 = Utils.findRequiredView(view, R.id.sleep_timer, "method 'onViewClicked'");
        this.m = findRequiredView12;
        findRequiredView12.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MainActivity_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mainActivity.onViewClicked(view2);
            }
        });
        View findRequiredView13 = Utils.findRequiredView(view, R.id.play_list, "method 'onViewClicked'");
        this.n = findRequiredView13;
        findRequiredView13.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MainActivity_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mainActivity.onViewClicked(view2);
            }
        });
        View findRequiredView14 = Utils.findRequiredView(view, R.id.user_panel, "method 'onViewClicked'");
        this.o = findRequiredView14;
        findRequiredView14.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MainActivity_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mainActivity.onViewClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MainActivity mainActivity = this.f3487a;
        if (mainActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3487a = null;
        mainActivity.mainRadioGroup = null;
        mainActivity.viewPager = null;
        mainActivity.homeRb = null;
        mainActivity.myMusicRb = null;
        mainActivity.communityRb = null;
        mainActivity.mDrawerLayout = null;
        mainActivity.sleep_timer_real_time = null;
        mainActivity.user_avatar = null;
        mainActivity.user_nick = null;
        mainActivity.iv_vip_mark_icon = null;
        mainActivity.iv_music_recognition_lock = null;
        mainActivity.slideMenuView = null;
        mainActivity.priceTextView = null;
        mainActivity.iv_pur_success = null;
        mainActivity.adView = null;
        mainActivity.pushCheckbox = null;
        this.f3488b.setOnClickListener(null);
        this.f3488b = null;
        this.f3489c.setOnClickListener(null);
        this.f3489c = null;
        this.d.setOnClickListener(null);
        this.d = null;
        this.e.setOnClickListener(null);
        this.e = null;
        this.f.setOnClickListener(null);
        this.f = null;
        this.g.setOnClickListener(null);
        this.g = null;
        this.h.setOnClickListener(null);
        this.h = null;
        this.i.setOnClickListener(null);
        this.i = null;
        this.j.setOnClickListener(null);
        this.j = null;
        this.k.setOnClickListener(null);
        this.k = null;
        this.l.setOnClickListener(null);
        this.l = null;
        this.m.setOnClickListener(null);
        this.m = null;
        this.n.setOnClickListener(null);
        this.n = null;
        this.o.setOnClickListener(null);
        this.o = null;
    }
}

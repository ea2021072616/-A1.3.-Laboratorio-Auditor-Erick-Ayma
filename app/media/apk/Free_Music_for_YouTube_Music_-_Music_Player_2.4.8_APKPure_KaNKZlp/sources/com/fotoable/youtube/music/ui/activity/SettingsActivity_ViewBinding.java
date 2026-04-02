package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.LaToTextView;
/* loaded from: classes.dex */
public class SettingsActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private SettingsActivity f3797a;

    /* renamed from: b  reason: collision with root package name */
    private View f3798b;

    /* renamed from: c  reason: collision with root package name */
    private View f3799c;
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
    private View p;
    private View q;
    private View r;

    @UiThread
    public SettingsActivity_ViewBinding(final SettingsActivity settingsActivity, View view) {
        this.f3797a = settingsActivity;
        settingsActivity.cache_size = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.cache_size, "field 'cache_size'", LaToTextView.class);
        settingsActivity.ckToolbar = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ck_toolbar, "field 'ckToolbar'", CheckBox.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.rl_toolbar, "field 'rl_toolbar' and method 'onClick'");
        settingsActivity.rl_toolbar = (RelativeLayout) Utils.castView(findRequiredView, R.id.rl_toolbar, "field 'rl_toolbar'", RelativeLayout.class);
        this.f3798b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.SettingsActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingsActivity.onClick(view2);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.rl_set_country_code, "field 'mCountryCodeView' and method 'onClick'");
        settingsActivity.mCountryCodeView = (RelativeLayout) Utils.castView(findRequiredView2, R.id.rl_set_country_code, "field 'mCountryCodeView'", RelativeLayout.class);
        this.f3799c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.SettingsActivity_ViewBinding.10
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingsActivity.onClick(view2);
            }
        });
        settingsActivity.ckMusicReminder = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ck_music_reminder, "field 'ckMusicReminder'", CheckBox.class);
        settingsActivity.ckDownloadArtists = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ck_download_artists, "field 'ckDownloadArtists'", CheckBox.class);
        settingsActivity.ckAutoPlay = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ck_auto_play, "field 'ckAutoPlay'", CheckBox.class);
        settingsActivity.ckWifiOnly = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ck_wifi_only, "field 'ckWifiOnly'", CheckBox.class);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.tool_switch_view, "field 'tool_switch_view' and method 'onClick'");
        settingsActivity.tool_switch_view = (RelativeLayout) Utils.castView(findRequiredView3, R.id.tool_switch_view, "field 'tool_switch_view'", RelativeLayout.class);
        this.d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.SettingsActivity_ViewBinding.11
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingsActivity.onClick(view2);
            }
        });
        settingsActivity.toolCheckbox = (CheckBox) Utils.findRequiredViewAsType(view, R.id.tool_checkbox, "field 'toolCheckbox'", CheckBox.class);
        settingsActivity.music_locker_checkbox = (CheckBox) Utils.findRequiredViewAsType(view, R.id.music_locker_checkbox, "field 'music_locker_checkbox'", CheckBox.class);
        settingsActivity.char_checkbox = (CheckBox) Utils.findRequiredViewAsType(view, R.id.char_checkbox, "field 'char_checkbox'", CheckBox.class);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.back_view, "method 'onClick'");
        this.e = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.SettingsActivity_ViewBinding.12
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingsActivity.onClick(view2);
            }
        });
        View findRequiredView5 = Utils.findRequiredView(view, R.id.rl_rate_us, "method 'onClick'");
        this.f = findRequiredView5;
        findRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.SettingsActivity_ViewBinding.13
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingsActivity.onClick(view2);
            }
        });
        View findRequiredView6 = Utils.findRequiredView(view, R.id.rl_privacy_policy, "method 'onClick'");
        this.g = findRequiredView6;
        findRequiredView6.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.SettingsActivity_ViewBinding.14
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingsActivity.onClick(view2);
            }
        });
        View findRequiredView7 = Utils.findRequiredView(view, R.id.rl_clear_cache, "method 'onClick'");
        this.h = findRequiredView7;
        findRequiredView7.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.SettingsActivity_ViewBinding.15
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingsActivity.onClick(view2);
            }
        });
        View findRequiredView8 = Utils.findRequiredView(view, R.id.rl_share_app, "method 'onClick'");
        this.i = findRequiredView8;
        findRequiredView8.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.SettingsActivity_ViewBinding.16
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingsActivity.onClick(view2);
            }
        });
        View findRequiredView9 = Utils.findRequiredView(view, R.id.rl_join_our_community, "method 'onClick'");
        this.j = findRequiredView9;
        findRequiredView9.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.SettingsActivity_ViewBinding.17
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingsActivity.onClick(view2);
            }
        });
        View findRequiredView10 = Utils.findRequiredView(view, R.id.rl_auto_play, "method 'onClick'");
        this.k = findRequiredView10;
        findRequiredView10.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.SettingsActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingsActivity.onClick(view2);
            }
        });
        View findRequiredView11 = Utils.findRequiredView(view, R.id.rl_wifi_only, "method 'onClick'");
        this.l = findRequiredView11;
        findRequiredView11.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.SettingsActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingsActivity.onClick(view2);
            }
        });
        View findRequiredView12 = Utils.findRequiredView(view, R.id.rl_music_reminder, "method 'onClick'");
        this.m = findRequiredView12;
        findRequiredView12.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.SettingsActivity_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingsActivity.onClick(view2);
            }
        });
        View findRequiredView13 = Utils.findRequiredView(view, R.id.rl_download_artists, "method 'onClick'");
        this.n = findRequiredView13;
        findRequiredView13.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.SettingsActivity_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingsActivity.onClick(view2);
            }
        });
        View findRequiredView14 = Utils.findRequiredView(view, R.id.rl_reload_music, "method 'onClick'");
        this.o = findRequiredView14;
        findRequiredView14.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.SettingsActivity_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingsActivity.onClick(view2);
            }
        });
        View findRequiredView15 = Utils.findRequiredView(view, R.id.iv_reload_music, "method 'onClick'");
        this.p = findRequiredView15;
        findRequiredView15.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.SettingsActivity_ViewBinding.7
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingsActivity.onClick(view2);
            }
        });
        View findRequiredView16 = Utils.findRequiredView(view, R.id.music_locker_panel, "method 'onClick'");
        this.q = findRequiredView16;
        findRequiredView16.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.SettingsActivity_ViewBinding.8
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingsActivity.onClick(view2);
            }
        });
        View findRequiredView17 = Utils.findRequiredView(view, R.id.char_switch_view, "method 'onClick'");
        this.r = findRequiredView17;
        findRequiredView17.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.SettingsActivity_ViewBinding.9
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingsActivity.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SettingsActivity settingsActivity = this.f3797a;
        if (settingsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3797a = null;
        settingsActivity.cache_size = null;
        settingsActivity.ckToolbar = null;
        settingsActivity.rl_toolbar = null;
        settingsActivity.mCountryCodeView = null;
        settingsActivity.ckMusicReminder = null;
        settingsActivity.ckDownloadArtists = null;
        settingsActivity.ckAutoPlay = null;
        settingsActivity.ckWifiOnly = null;
        settingsActivity.tool_switch_view = null;
        settingsActivity.toolCheckbox = null;
        settingsActivity.music_locker_checkbox = null;
        settingsActivity.char_checkbox = null;
        this.f3798b.setOnClickListener(null);
        this.f3798b = null;
        this.f3799c.setOnClickListener(null);
        this.f3799c = null;
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
        this.p.setOnClickListener(null);
        this.p = null;
        this.q.setOnClickListener(null);
        this.q = null;
        this.r.setOnClickListener(null);
        this.r = null;
    }
}

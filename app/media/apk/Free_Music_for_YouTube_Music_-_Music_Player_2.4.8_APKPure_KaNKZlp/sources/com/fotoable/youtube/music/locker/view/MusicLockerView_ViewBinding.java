package com.fotoable.youtube.music.locker.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.locker.view.shimmer.ShimmerFrameLayout;
import com.fotoable.youtube.music.ui.view.MarqueeTextView;
/* loaded from: classes.dex */
public class MusicLockerView_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private MusicLockerView f2791a;

    /* renamed from: b  reason: collision with root package name */
    private View f2792b;

    /* renamed from: c  reason: collision with root package name */
    private View f2793c;
    private View d;
    private View e;
    private View f;
    private View g;

    @UiThread
    public MusicLockerView_ViewBinding(final MusicLockerView musicLockerView, View view) {
        this.f2791a = musicLockerView;
        musicLockerView.root_view = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.root_view, "field 'root_view'", RelativeLayout.class);
        musicLockerView.wallpaper_blur = (ImageView) Utils.findRequiredViewAsType(view, R.id.wallpaper_blur, "field 'wallpaper_blur'", ImageView.class);
        musicLockerView.music_title = (TextView) Utils.findRequiredViewAsType(view, R.id.music_title, "field 'music_title'", TextView.class);
        musicLockerView.music_artists = (TextView) Utils.findRequiredViewAsType(view, R.id.music_artists, "field 'music_artists'", TextView.class);
        musicLockerView.radio_cover_panel = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.radio_cover_panel, "field 'radio_cover_panel'", RelativeLayout.class);
        musicLockerView.radio_cover_img = (ImageView) Utils.findRequiredViewAsType(view, R.id.radio_cover_img, "field 'radio_cover_img'", ImageView.class);
        musicLockerView.music_cover_panel = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.music_cover_panel, "field 'music_cover_panel'", RelativeLayout.class);
        musicLockerView.player_cover = (ImageView) Utils.findRequiredViewAsType(view, R.id.player_cover, "field 'player_cover'", ImageView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.player_previous, "field 'player_previous'");
        musicLockerView.player_previous = (ImageView) Utils.castView(findRequiredView, R.id.player_previous, "field 'player_previous'", ImageView.class);
        this.f2792b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.locker.view.MusicLockerView_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                musicLockerView.onPlayerPreviousClick(view2);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.player_state, "field 'player_state'");
        musicLockerView.player_state = (ImageView) Utils.castView(findRequiredView2, R.id.player_state, "field 'player_state'", ImageView.class);
        this.f2793c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.locker.view.MusicLockerView_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                musicLockerView.onPlayerStateClick(view2);
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.player_next, "field 'player_next'");
        musicLockerView.player_next = (ImageView) Utils.castView(findRequiredView3, R.id.player_next, "field 'player_next'", ImageView.class);
        this.d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.locker.view.MusicLockerView_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                musicLockerView.onPlayerNextClick(view2);
            }
        });
        View findRequiredView4 = Utils.findRequiredView(view, R.id.player_fav, "field 'player_fav'");
        musicLockerView.player_fav = (ImageView) Utils.castView(findRequiredView4, R.id.player_fav, "field 'player_fav'", ImageView.class);
        this.e = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.locker.view.MusicLockerView_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                musicLockerView.onPlayerFavClick(view2);
            }
        });
        musicLockerView.locker_bottom_bar_panel_bg = (ImageView) Utils.findRequiredViewAsType(view, R.id.locker_bottom_bar_panel_bg, "field 'locker_bottom_bar_panel_bg'", ImageView.class);
        musicLockerView.locker_time = (TextView) Utils.findRequiredViewAsType(view, R.id.locker_time, "field 'locker_time'", TextView.class);
        musicLockerView.locker_month = (TextView) Utils.findRequiredViewAsType(view, R.id.locker_month, "field 'locker_month'", TextView.class);
        musicLockerView.locker_days = (TextView) Utils.findRequiredViewAsType(view, R.id.locker_days, "field 'locker_days'", TextView.class);
        musicLockerView.slide_img = (ImageView) Utils.findRequiredViewAsType(view, R.id.slide_img, "field 'slide_img'", ImageView.class);
        musicLockerView.slide_to_unlock_tv = (MarqueeTextView) Utils.findRequiredViewAsType(view, R.id.slide_to_unlock_tv, "field 'slide_to_unlock_tv'", MarqueeTextView.class);
        musicLockerView.shimmer_view_container = (ShimmerFrameLayout) Utils.findRequiredViewAsType(view, R.id.shimmer_view_container, "field 'shimmer_view_container'", ShimmerFrameLayout.class);
        musicLockerView.music_info_panel = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.music_info_panel, "field 'music_info_panel'", LinearLayout.class);
        musicLockerView.batteryView = (BatteryView01) Utils.findRequiredViewAsType(view, R.id.battery_view, "field 'batteryView'", BatteryView01.class);
        musicLockerView.battery_lock_panel = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.battery_lock_panel, "field 'battery_lock_panel'", LinearLayout.class);
        View findViewById = view.findViewById(R.id.locker_logo);
        if (findViewById != null) {
            this.f = findViewById;
            findViewById.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.locker.view.MusicLockerView_ViewBinding.5
                @Override // butterknife.internal.DebouncingOnClickListener
                public void doClick(View view2) {
                    musicLockerView.onLockerLogoClick(view2);
                }
            });
        }
        View findViewById2 = view.findViewById(R.id.menu_more);
        if (findViewById2 != null) {
            this.g = findViewById2;
            findViewById2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.locker.view.MusicLockerView_ViewBinding.6
                @Override // butterknife.internal.DebouncingOnClickListener
                public void doClick(View view2) {
                    musicLockerView.onClick(view2);
                }
            });
        }
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MusicLockerView musicLockerView = this.f2791a;
        if (musicLockerView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f2791a = null;
        musicLockerView.root_view = null;
        musicLockerView.wallpaper_blur = null;
        musicLockerView.music_title = null;
        musicLockerView.music_artists = null;
        musicLockerView.radio_cover_panel = null;
        musicLockerView.radio_cover_img = null;
        musicLockerView.music_cover_panel = null;
        musicLockerView.player_cover = null;
        musicLockerView.player_previous = null;
        musicLockerView.player_state = null;
        musicLockerView.player_next = null;
        musicLockerView.player_fav = null;
        musicLockerView.locker_bottom_bar_panel_bg = null;
        musicLockerView.locker_time = null;
        musicLockerView.locker_month = null;
        musicLockerView.locker_days = null;
        musicLockerView.slide_img = null;
        musicLockerView.slide_to_unlock_tv = null;
        musicLockerView.shimmer_view_container = null;
        musicLockerView.music_info_panel = null;
        musicLockerView.batteryView = null;
        musicLockerView.battery_lock_panel = null;
        this.f2792b.setOnClickListener(null);
        this.f2792b = null;
        this.f2793c.setOnClickListener(null);
        this.f2793c = null;
        this.d.setOnClickListener(null);
        this.d = null;
        this.e.setOnClickListener(null);
        this.e = null;
        if (this.f != null) {
            this.f.setOnClickListener(null);
            this.f = null;
        }
        if (this.g != null) {
            this.g.setOnClickListener(null);
            this.g = null;
        }
    }
}

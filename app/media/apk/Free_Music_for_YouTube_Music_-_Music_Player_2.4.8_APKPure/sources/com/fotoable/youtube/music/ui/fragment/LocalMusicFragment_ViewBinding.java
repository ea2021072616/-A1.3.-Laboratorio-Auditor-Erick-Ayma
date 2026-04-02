package com.fotoable.youtube.music.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.flyco.tablayout.SlidingTabLayout;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class LocalMusicFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private LocalMusicFragment f4634a;

    /* renamed from: b  reason: collision with root package name */
    private View f4635b;

    @UiThread
    public LocalMusicFragment_ViewBinding(final LocalMusicFragment localMusicFragment, View view) {
        this.f4634a = localMusicFragment;
        localMusicFragment.viewPager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.view_pager, "field 'viewPager'", ViewPager.class);
        localMusicFragment.tabLayout = (SlidingTabLayout) Utils.findRequiredViewAsType(view, R.id.tab_layout, "field 'tabLayout'", SlidingTabLayout.class);
        localMusicFragment.no_permission_panel = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.no_permission_panel, "field 'no_permission_panel'", RelativeLayout.class);
        localMusicFragment.no_permission_content = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.no_permission_content, "field 'no_permission_content'", LinearLayout.class);
        View findViewById = view.findViewById(R.id.open_permission_bt);
        if (findViewById != null) {
            this.f4635b = findViewById;
            findViewById.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.fragment.LocalMusicFragment_ViewBinding.1
                @Override // butterknife.internal.DebouncingOnClickListener
                public void doClick(View view2) {
                    localMusicFragment.onClick(view2);
                }
            });
        }
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LocalMusicFragment localMusicFragment = this.f4634a;
        if (localMusicFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4634a = null;
        localMusicFragment.viewPager = null;
        localMusicFragment.tabLayout = null;
        localMusicFragment.no_permission_panel = null;
        localMusicFragment.no_permission_content = null;
        if (this.f4635b != null) {
            this.f4635b.setOnClickListener(null);
            this.f4635b = null;
        }
    }
}

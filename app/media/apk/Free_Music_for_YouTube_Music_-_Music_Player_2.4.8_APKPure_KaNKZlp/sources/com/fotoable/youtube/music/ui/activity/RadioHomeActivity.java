package com.fotoable.youtube.music.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.OnClick;
import com.flyco.tablayout.SlidingTabLayout;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.ui.adapter.RadioFragmentPagerAdapter;
/* loaded from: classes.dex */
public class RadioHomeActivity extends BaseActivity {
    @BindView(R.id.back_view)
    ImageView backView;
    @BindView(R.id.radio_tab_layout)
    SlidingTabLayout radioTabLayout;
    @BindView(R.id.radio_view_pager)
    ViewPager radioViewPager;

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return true;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.activity_radio_home;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        d();
        r();
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
        i().a(this);
    }

    @OnClick({R.id.back_view})
    public void onViewClicked() {
        finish();
    }

    private void r() {
        this.radioViewPager.setAdapter(new RadioFragmentPagerAdapter(getSupportFragmentManager(), this));
        this.radioTabLayout.setViewPager(this.radioViewPager);
        this.radioViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.fotoable.youtube.music.ui.activity.RadioHomeActivity.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                switch (i) {
                    case 0:
                        com.fotoable.youtube.music.util.b.b("电台-我的收藏-展示");
                        return;
                    case 1:
                        com.fotoable.youtube.music.util.b.b("电台-历史记录-展示");
                        return;
                    default:
                        return;
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
    }
}

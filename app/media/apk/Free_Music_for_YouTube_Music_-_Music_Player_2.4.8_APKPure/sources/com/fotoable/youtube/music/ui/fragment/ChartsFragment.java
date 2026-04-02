package com.fotoable.youtube.music.ui.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.BindView;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.adapter.ChartsAdapter;
import com.fotoable.youtube.music.ui.view.SimpleViewPagerIndicator;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ChartsFragment extends com.fotoable.youtube.music.base.i {

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<com.fotoable.youtube.music.base.i> f4495b;
    @BindView(R.id.shadow_view)
    View shadow_view;
    @BindView(R.id.tab_layout)
    SimpleViewPagerIndicator simpleViewPagerIndicator;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    @Override // com.fotoable.youtube.music.base.i
    public int a() {
        return R.layout.fragment_charts;
    }

    @Override // com.fotoable.youtube.music.base.i
    public void a(View view, @Nullable Bundle bundle) {
        i();
        if (Build.VERSION.SDK_INT < 21) {
            this.shadow_view.setVisibility(0);
        }
    }

    private void i() {
        this.f4495b = new ArrayList<>();
        this.f4495b.add(new GlobalMusicFragment());
        this.f4495b.add(new ClassifiedMusicFragment());
        this.viewpager.setAdapter(new ChartsAdapter(getChildFragmentManager(), this.f4495b, getActivity()));
        this.viewpager.setOffscreenPageLimit(1);
        String[] strArr = {getString(R.string.global_music_list), getString(R.string.classified_music_list)};
        this.simpleViewPagerIndicator.setColorIndicatorColor(getResources().getColor(R.color.charts_tip_indicator));
        this.simpleViewPagerIndicator.setColorTextNormal(getResources().getColor(R.color.charts_tip_normal));
        this.simpleViewPagerIndicator.setColorTextSelect(getResources().getColor(R.color.charts_tip_select));
        this.simpleViewPagerIndicator.setSIZE_TEXT(14);
        this.simpleViewPagerIndicator.setTitles(strArr);
        this.simpleViewPagerIndicator.setViewPager(this.viewpager);
        this.simpleViewPagerIndicator.setVisibility(0);
        this.viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.fotoable.youtube.music.ui.fragment.ChartsFragment.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ChartsFragment.this.simpleViewPagerIndicator.scroll(i, f);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                ChartsFragment.this.simpleViewPagerIndicator.onPageSelected(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
    }

    @Override // com.fotoable.youtube.music.base.i
    public void g() {
        e().a(this);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }
}

package com.fotoable.youtube.music.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.activity.SearchActivity;
import com.fotoable.youtube.music.ui.adapter.DiscoverAdapter;
import com.fotoable.youtube.music.ui.view.SimpleViewPagerIndicator;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class DiscoverFragment extends com.fotoable.youtube.music.base.i {
    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;

    /* renamed from: b  reason: collision with root package name */
    private AssetManager f4530b;

    /* renamed from: c  reason: collision with root package name */
    private List<com.fotoable.youtube.music.base.i> f4531c;
    @BindView(R.id.recognition_tips_view)
    View mTipsView;
    @BindView(R.id.recognition_img)
    ImageView recognitionImg;
    @BindView(R.id.tab_layout)
    SimpleViewPagerIndicator tab_layout;
    @BindView(R.id.text_title)
    TextView textTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @Override // com.fotoable.youtube.music.base.i
    public int a() {
        return R.layout.fragment_discover;
    }

    @Override // com.fotoable.youtube.music.base.i
    public void a(View view, @Nullable Bundle bundle) {
        i();
        h();
        k();
        l();
        j();
    }

    private void i() {
        this.f4531c = new ArrayList();
        this.f4531c.add(new ArtistsFragment());
        this.f4531c.add(new GenresFragment());
        this.viewPager.setAdapter(new DiscoverAdapter(getChildFragmentManager(), this.f4531c, getActivity()));
        this.viewPager.setOffscreenPageLimit(2);
        String[] strArr = {getString(R.string.artists), getString(R.string.genres)};
        this.tab_layout.setColorIndicatorColor(getResources().getColor(R.color.themes_tip_indicator));
        this.tab_layout.setColorTextNormal(getResources().getColor(R.color.themes_tip_normal));
        this.tab_layout.setColorTextSelect(getResources().getColor(R.color.themes_tip_select));
        this.tab_layout.setSIZE_TEXT(16);
        this.tab_layout.setTitles(strArr);
        this.tab_layout.setViewPager(this.viewPager);
        this.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.fotoable.youtube.music.ui.fragment.DiscoverFragment.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                DiscoverFragment.this.tab_layout.scroll(i, f);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                DiscoverFragment.this.tab_layout.onPageSelected(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
    }

    private void j() {
        final int i = -com.fotoable.youtube.music.util.w.a(getContext(), 40.0f);
        this.appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener(this, i) { // from class: com.fotoable.youtube.music.ui.fragment.i

            /* renamed from: a  reason: collision with root package name */
            private final DiscoverFragment f4827a;

            /* renamed from: b  reason: collision with root package name */
            private final int f4828b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4827a = this;
                this.f4828b = i;
            }

            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
                this.f4827a.a(this.f4828b, appBarLayout, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(int i, AppBarLayout appBarLayout, int i2) {
        this.toolbar.setAlpha(1.0f - (((i2 * 1.0f) / i) * 1.0f));
    }

    @Override // com.fotoable.youtube.music.base.i
    public void g() {
        e().a(this);
    }

    @Override // com.fotoable.youtube.music.base.i, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    private void k() {
        int a2 = com.fotoable.youtube.music.util.v.a((Context) getActivity(), "IS_OPEN_RECOGNIZE", 0);
        if (a2 > 0) {
            this.recognitionImg.setVisibility(0);
            if (com.fotoable.youtube.music.util.v.a((Context) getActivity(), "FIRST_USER_RECOGNIZE", false)) {
                this.mTipsView.setVisibility(0);
            }
        } else {
            this.recognitionImg.setVisibility(8);
        }
        com.fotoable.youtube.music.util.h.a("recognize" + a2);
    }

    @Override // com.fotoable.youtube.music.base.i
    public void h() {
        a(com.fotoable.youtube.music.e.b.a().a(com.fotoable.youtube.music.e.a.class, new rx.c.b<com.fotoable.youtube.music.e.a>() { // from class: com.fotoable.youtube.music.ui.fragment.DiscoverFragment.2
            @Override // rx.c.b
            /* renamed from: a */
            public void call(com.fotoable.youtube.music.e.a aVar) {
                switch (aVar.f2726a) {
                    case 1036:
                    default:
                        return;
                    case 1035:
                        if (DiscoverFragment.this.viewPager != null) {
                            return;
                        }
                        break;
                    case 1037:
                        break;
                }
                if (DiscoverFragment.this.viewPager != null) {
                    DiscoverFragment.this.viewPager.setCurrentItem(1, false);
                }
            }
        }));
    }

    @OnClick({R.id.recognition_img, R.id.search_img})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.search_img /* 2131821161 */:
                com.fotoable.youtube.music.util.b.b("Search-Click");
                startActivity(new Intent(getActivity(), SearchActivity.class));
                return;
            case R.id.recognition_img /* 2131821162 */:
            default:
                return;
        }
    }

    private void l() {
        try {
            this.f4530b = getContext().getAssets();
            this.textTitle.setTypeface(Typeface.createFromAsset(this.f4530b, "fonts/Lato-Bold.ttf"));
        } catch (Throwable th) {
            ThrowableExtension.printStackTrace(th);
        }
    }
}

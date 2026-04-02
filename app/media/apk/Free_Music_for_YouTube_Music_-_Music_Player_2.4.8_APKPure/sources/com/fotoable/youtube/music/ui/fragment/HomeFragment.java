package com.fotoable.youtube.music.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.BindView;
import com.flyco.tablayout.SlidingTabLayout;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.ui.adapter.HomeAdapter;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class HomeFragment extends com.fotoable.youtube.music.base.i {

    /* renamed from: c  reason: collision with root package name */
    private static final String f4585c = HomeFragment.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    rx.g.b f4586b;
    private List<com.fotoable.youtube.music.base.i> e;
    @BindView(R.id.tab_layout)
    SlidingTabLayout tab_layout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    private int[] d = {R.string.top_100, R.string.featured, R.string.playlists, R.string.radio, R.string.my};
    private boolean f = false;

    @Override // com.fotoable.youtube.music.base.i
    public int a() {
        return R.layout.fragment_home;
    }

    @Override // com.fotoable.youtube.music.base.i
    public void a(View view, @Nullable Bundle bundle) {
        com.fotoable.youtube.music.util.b.b("在线音乐-展示");
        j();
        k();
        i();
        h();
    }

    private void i() {
    }

    @Override // com.fotoable.youtube.music.base.i
    public void g() {
    }

    private void j() {
    }

    private void k() {
        int i = 0;
        this.e = new ArrayList();
        this.e.add(new Top100Fragment());
        this.e.add(new FeaturedFragment());
        if (com.fotoable.youtube.music.util.v.a((Context) MusicApplication.c(), "country_code_is_local", true)) {
            com.fotoable.youtube.music.util.b.a("Dev_接口使用的国家码类型", "国家码类型", "本地");
        } else {
            com.fotoable.youtube.music.util.b.a("Dev_接口使用的国家码类型", "国家码类型", "在线");
        }
        if (com.fotoable.youtube.music.a.a()) {
            this.e.add(new CategoryPlaylistFragment());
            this.f = true;
        } else {
            this.e.add(new PlayListFragment());
            this.f = false;
        }
        this.e.add(new RadioFragment());
        this.e.add(new MyMusicFragment());
        this.viewPager.setAdapter(new HomeAdapter(getChildFragmentManager(), this.e, this.d, getActivity()));
        this.viewPager.setOffscreenPageLimit(4);
        this.tab_layout.setViewPager(this.viewPager);
        int a2 = com.fotoable.youtube.music.util.v.a(getContext(), com.fotoable.youtube.music.b.h, 0);
        if (a2 >= 4) {
            com.fotoable.youtube.music.util.v.b(getContext(), com.fotoable.youtube.music.b.h, 0);
        } else {
            i = a2;
        }
        this.viewPager.setCurrentItem(i);
        this.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.fotoable.youtube.music.ui.fragment.HomeFragment.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                switch (i2) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    default:
                        com.fotoable.youtube.music.util.v.b(HomeFragment.this.getContext(), com.fotoable.youtube.music.b.h, i2);
                        return;
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }
        });
    }

    @Override // com.fotoable.youtube.music.base.i
    public void h() {
        a(com.fotoable.youtube.music.e.b.a().a(com.fotoable.youtube.music.e.a.class).a(rx.a.b.a.a()).a(new rx.c.b(this) { // from class: com.fotoable.youtube.music.ui.fragment.m

            /* renamed from: a  reason: collision with root package name */
            private final HomeFragment f4836a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4836a = this;
            }

            @Override // rx.c.b
            public void call(Object obj) {
                this.f4836a.a(obj);
            }
        }, new rx.c.b<Throwable>() { // from class: com.fotoable.youtube.music.ui.fragment.HomeFragment.2
            @Override // rx.c.b
            /* renamed from: a */
            public void call(Throwable th) {
                ThrowableExtension.printStackTrace(th);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(Object obj) {
        switch (((com.fotoable.youtube.music.e.a) obj).f2726a) {
            case PointerIconCompat.TYPE_ALIAS /* 1010 */:
                com.fotoable.youtube.music.util.h.a(f4585c, "乔晓松EVENT_CODE_GO_VIEWPAGER_TWO_PLAY");
                this.viewPager.setCurrentItem(1, false);
                return;
            case PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW /* 1016 */:
                if (this.viewPager != null) {
                    com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a((int) PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, this.viewPager.getCurrentItem()));
                    return;
                }
                return;
            case 1036:
                if (this.viewPager != null) {
                    this.viewPager.setCurrentItem(2, false);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.i
    public void a(rx.m mVar) {
        if (this.f4586b == null) {
            this.f4586b = new rx.g.b();
        }
        this.f4586b.a(mVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.i
    public void l_() {
        if (this.f4586b != null) {
            this.f4586b.unsubscribe();
            this.f4586b = null;
        }
    }
}

package com.fotoable.youtube.music.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.OnClick;
import com.facebook.login.widget.ToolTipPopup;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.CarouselBean;
import com.fotoable.youtube.music.bean.EditorChoiceBean;
import com.fotoable.youtube.music.bean.FavBean;
import com.fotoable.youtube.music.bean.FeaturedPlaylistBean;
import com.fotoable.youtube.music.bean.GlobalRankBean;
import com.fotoable.youtube.music.bean.HomeListNewBean;
import com.fotoable.youtube.music.bean.MyHttpResponse;
import com.fotoable.youtube.music.ui.activity.ArtistsActivity;
import com.fotoable.youtube.music.ui.activity.ChartsActivity;
import com.fotoable.youtube.music.ui.activity.GenresActivity;
import com.fotoable.youtube.music.ui.adapter.CarouselPagerAdapter;
import com.fotoable.youtube.music.ui.adapter.FeaturedAdapter;
import com.fotoable.youtube.music.ui.adapter.FeaturedAdapterComponent;
import com.fotoable.youtube.music.ui.adapter.HomeListAdapter;
import com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog;
import com.fotoable.youtube.music.ui.view.FixedSpeedScroller;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import rx.f;
/* loaded from: classes.dex */
public class FeaturedFragment extends com.fotoable.youtube.music.base.i {

    /* renamed from: b  reason: collision with root package name */
    public static final String f4541b = FeaturedFragment.class.getSimpleName();
    @BindView(R.id.featured_artists_view)
    LinearLayout artistsView;
    @Inject

    /* renamed from: c  reason: collision with root package name */
    com.fotoable.youtube.music.b.c f4542c;
    @BindView(R.id.carousel_pager)
    ViewPager carouselPager;
    @BindView(R.id.carousel_pager_panel)
    RelativeLayout carouselPagerPanel;
    @BindView(R.id.carousel_point_ll)
    LinearLayout carouselPointLayout;
    @BindView(R.id.featured_charts_view)
    View chartsView;
    @Inject
    com.fotoable.youtube.music.db.a d;
    private Context f;
    private List<CarouselBean> g;
    @BindView(R.id.featured_genres_view)
    LinearLayout genresView;
    private ImageView[] h;
    private int i;
    private rx.m k;
    private FeaturedAdapter l;
    @BindView(R.id.ll_error)
    LinearLayout llError;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.tv_error)
    LaToTextView tvError;
    private int e = 8;
    private boolean j = false;
    private HomeListAdapter.OnAdminDeleteLister m = new HomeListAdapter.OnAdminDeleteLister() { // from class: com.fotoable.youtube.music.ui.fragment.FeaturedFragment.4
        @Override // com.fotoable.youtube.music.ui.adapter.HomeListAdapter.OnAdminDeleteLister
        public void onDelete(final HomeListNewBean homeListNewBean, final int i) {
            SimpleMusicDialog.a(FeaturedFragment.this.getFragmentManager(), new SimpleMusicDialog.a() { // from class: com.fotoable.youtube.music.ui.fragment.FeaturedFragment.4.1
                @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
                public void a() {
                }

                @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
                public void b() {
                }

                @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
                public void c() {
                    FeaturedFragment.this.a(homeListNewBean, i);
                }
            }, R.string.sure_delete, R.string.cancel, R.string.ok);
        }
    };
    private ViewPager.OnPageChangeListener n = new ViewPager.OnPageChangeListener() { // from class: com.fotoable.youtube.music.ui.fragment.FeaturedFragment.5
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            FeaturedFragment.this.b(i % FeaturedFragment.this.g.size());
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FeaturedFragment.this.p();
                    return;
                case 1:
                    FeaturedFragment.this.o();
                    return;
                default:
                    return;
            }
        }
    };
    private View.OnClickListener o = new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.fragment.FeaturedFragment.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.featured_charts_view /* 2131821189 */:
                    FeaturedFragment.this.startActivity(new Intent(FeaturedFragment.this.getActivity(), ChartsActivity.class));
                    com.fotoable.youtube.music.util.b.b("QuickNav-charts");
                    return;
                case R.id.featured_artists_view /* 2131821190 */:
                    FeaturedFragment.this.startActivity(new Intent(FeaturedFragment.this.getActivity(), ArtistsActivity.class));
                    com.fotoable.youtube.music.util.b.b("QuickNav-Artists");
                    return;
                case R.id.featured_genres_view /* 2131821191 */:
                    FeaturedFragment.this.startActivity(new Intent(FeaturedFragment.this.getActivity(), GenresActivity.class));
                    com.fotoable.youtube.music.util.b.b("QuickNav-Genres");
                    return;
                default:
                    return;
            }
        }
    };

    @Override // com.fotoable.youtube.music.base.i
    public int a() {
        return R.layout.fragment_featured;
    }

    @Override // com.fotoable.youtube.music.base.i
    public void a(View view, @Nullable Bundle bundle) {
        h();
        w();
        m();
        j();
        l();
        k();
        i();
        com.fotoable.youtube.music.util.b.b("在线音乐-推荐页展示");
        com.fotoable.youtube.music.util.b.a("在线音乐-推荐页展示");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        n();
        q();
        r();
        s();
        t();
        u();
    }

    private void j() {
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.fotoable.youtube.music.ui.fragment.FeaturedFragment.1
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                FeaturedFragment.this.i();
            }
        });
        this.refreshLayout.setColorSchemeResources(17170459, 17170452, 17170456, 17170454);
    }

    private void k() {
    }

    private void l() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            FixedSpeedScroller fixedSpeedScroller = new FixedSpeedScroller(this.carouselPager.getContext(), new AccelerateInterpolator());
            declaredField.set(this.carouselPager, fixedSpeedScroller);
            fixedSpeedScroller.setmDuration(500);
        } catch (Exception e) {
        }
        ViewGroup.LayoutParams layoutParams = this.carouselPagerPanel.getLayoutParams();
        layoutParams.height = (int) (com.fotoable.youtube.music.util.w.b(getActivity()) * 0.4167d);
        this.carouselPagerPanel.setLayoutParams(layoutParams);
        x();
    }

    private void m() {
        this.recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.l = new FeaturedAdapter(getActivity(), new FeaturedAdapterComponent());
        this.recyclerview.setNestedScrollingEnabled(false);
        this.recyclerview.setAdapter(this.l);
    }

    private void n() {
        a(this.f4542c.j().a(com.fotoable.youtube.music.util.s.a()).a((f.c<? super R, ? extends R>) com.fotoable.youtube.music.util.s.b()).a((rx.g) new rx.g<ArrayList<CarouselBean>>() { // from class: com.fotoable.youtube.music.ui.fragment.FeaturedFragment.7
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(ArrayList<CarouselBean> arrayList) {
                if (arrayList != null && arrayList.size() > 0) {
                    FeaturedFragment.this.a(arrayList);
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<CarouselBean> list) {
        this.g = list;
        com.fotoable.youtube.music.util.h.a(f4541b, list.size() + "");
        if (list != null && list.size() > 0) {
            this.carouselPager.setAdapter(new CarouselPagerAdapter(getActivity(), list));
            a(list.size());
            this.carouselPager.setCurrentItem(list.size() * 10, false);
            if (this.j) {
                p();
            }
        }
    }

    @Override // com.fotoable.youtube.music.base.i
    public void a(boolean z) {
        super.a(z);
        this.j = z;
        if (z) {
            if (this.carouselPager != null && this.carouselPager.getChildCount() > 0) {
                p();
                return;
            }
            return;
        }
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.k != null && !this.k.isUnsubscribed()) {
            this.k.unsubscribe();
            this.k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        o();
        this.k = rx.f.a((long) ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME, (long) ExoPlayerFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS, TimeUnit.MILLISECONDS).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Long>() { // from class: com.fotoable.youtube.music.ui.fragment.FeaturedFragment.8
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(Long l) {
                if (FeaturedFragment.this.carouselPager != null) {
                    int currentItem = FeaturedFragment.this.carouselPager.getCurrentItem();
                    if (FeaturedFragment.this.carouselPager.getChildCount() > 0) {
                        if (currentItem + 1 < Integer.MAX_VALUE) {
                            FeaturedFragment.this.carouselPager.setCurrentItem(currentItem + 1, true);
                        } else {
                            FeaturedFragment.this.carouselPager.setCurrentItem(100, true);
                        }
                    }
                }
            }
        });
    }

    private void a(int i) {
        this.h = new ImageView[i];
        if (this.carouselPointLayout.getChildCount() > 0) {
            this.carouselPointLayout.removeAllViews();
        }
        for (int i2 = 0; i2 < i; i2++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(R.drawable.dot_selector);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.fotoable.youtube.music.util.w.a(getActivity(), 6.0f), com.fotoable.youtube.music.util.w.a(getActivity(), 6.0f));
            layoutParams.setMargins(com.fotoable.youtube.music.util.w.a(getActivity(), 6.0f), 0, 0, 0);
            imageView.setLayoutParams(layoutParams);
            this.carouselPointLayout.addView(imageView);
            this.h[i2] = imageView;
            this.h[i2].setEnabled(false);
            this.h[i2].setTag(Integer.valueOf(i2));
        }
        this.i = 0;
        this.h[this.i].setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        if (this.h != null && i >= 0 && i <= this.g.size() - 1 && this.i != i) {
            this.h[i].setEnabled(true);
            this.h[this.i].setEnabled(false);
            this.i = i;
        }
    }

    private void q() {
        a(this.f4542c.a(Locale.US.getCountry()).a(com.fotoable.youtube.music.util.s.a()).a((f.c<? super R, ? extends R>) com.fotoable.youtube.music.util.s.b()).b(new rx.l<List<EditorChoiceBean>>() { // from class: com.fotoable.youtube.music.ui.fragment.FeaturedFragment.9
            @Override // rx.g
            public void onCompleted() {
                FeaturedFragment.this.refreshLayout.setRefreshing(false);
            }

            @Override // rx.g
            public void onError(Throwable th) {
                FeaturedFragment.this.refreshLayout.setRefreshing(false);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(List<EditorChoiceBean> list) {
                FeaturedFragment.this.refreshLayout.setRefreshing(false);
                if (list != null && list.size() > 0) {
                    FeaturedFragment.this.l.setEditorChoice(list);
                }
            }
        }));
    }

    private void r() {
        a(this.f4542c.n().a(com.fotoable.youtube.music.util.s.a()).a((f.c<? super R, ? extends R>) com.fotoable.youtube.music.util.s.b()).b(new rx.l<List<FeaturedPlaylistBean>>() { // from class: com.fotoable.youtube.music.ui.fragment.FeaturedFragment.10
            @Override // rx.g
            public void onCompleted() {
                FeaturedFragment.this.refreshLayout.setRefreshing(false);
            }

            @Override // rx.g
            public void onError(Throwable th) {
                FeaturedFragment.this.refreshLayout.setRefreshing(false);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(List<FeaturedPlaylistBean> list) {
                FeaturedFragment.this.refreshLayout.setRefreshing(false);
                if (list != null && list.size() > 0) {
                    FeaturedFragment.this.l.setFeaturedPlaylist(list);
                }
            }
        }));
    }

    private void s() {
        a(this.f4542c.a(this.e, "").a(com.fotoable.youtube.music.util.s.a()).a((f.c<? super R, ? extends R>) com.fotoable.youtube.music.util.s.b()).b(v()).a((rx.g) new rx.g<ArrayList<HomeListNewBean>>() { // from class: com.fotoable.youtube.music.ui.fragment.FeaturedFragment.11
            @Override // rx.g
            public void onCompleted() {
                FeaturedFragment.this.refreshLayout.setRefreshing(false);
            }

            @Override // rx.g
            public void onError(Throwable th) {
                FeaturedFragment.this.refreshLayout.setRefreshing(false);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(ArrayList<HomeListNewBean> arrayList) {
                if (arrayList != null && arrayList.size() > 0) {
                    FeaturedFragment.this.l.setHitSingles(arrayList);
                }
            }
        }));
    }

    private void t() {
        a(this.f4542c.b(this.e, "").a(com.fotoable.youtube.music.util.s.a()).a((f.c<? super R, ? extends R>) com.fotoable.youtube.music.util.s.b()).b(v()).a((rx.g) new rx.g<ArrayList<HomeListNewBean>>() { // from class: com.fotoable.youtube.music.ui.fragment.FeaturedFragment.12
            @Override // rx.g
            public void onCompleted() {
                FeaturedFragment.this.refreshLayout.setRefreshing(false);
            }

            @Override // rx.g
            public void onError(Throwable th) {
                FeaturedFragment.this.refreshLayout.setRefreshing(false);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(ArrayList<HomeListNewBean> arrayList) {
                if (arrayList != null && arrayList.size() > 0) {
                    FeaturedFragment.this.refreshLayout.setRefreshing(false);
                    FeaturedFragment.this.l.setFreshSongs(arrayList);
                }
            }
        }));
    }

    private void u() {
        a(this.f4542c.d().a(com.fotoable.youtube.music.util.s.a()).a((f.c<? super R, ? extends R>) com.fotoable.youtube.music.util.s.b()).b(new rx.l<ArrayList<GlobalRankBean>>() { // from class: com.fotoable.youtube.music.ui.fragment.FeaturedFragment.13
            @Override // rx.g
            public void onCompleted() {
                FeaturedFragment.this.refreshLayout.setRefreshing(false);
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
                FeaturedFragment.this.refreshLayout.setRefreshing(false);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(ArrayList<GlobalRankBean> arrayList) {
                FeaturedFragment.this.refreshLayout.setRefreshing(false);
                if (arrayList != null && arrayList.size() > 0) {
                    FeaturedFragment.this.l.setHotCharts(arrayList);
                }
            }
        }));
    }

    @NonNull
    private rx.c.e<ArrayList<HomeListNewBean>, rx.f<ArrayList<HomeListNewBean>>> v() {
        return new rx.c.e<ArrayList<HomeListNewBean>, rx.f<ArrayList<HomeListNewBean>>>() { // from class: com.fotoable.youtube.music.ui.fragment.FeaturedFragment.14
            @Override // rx.c.e
            public rx.f<ArrayList<HomeListNewBean>> a(final ArrayList<HomeListNewBean> arrayList) {
                return rx.f.a((f.a) new f.a<ArrayList<HomeListNewBean>>() { // from class: com.fotoable.youtube.music.ui.fragment.FeaturedFragment.14.1
                    @Override // rx.c.b
                    /* renamed from: a */
                    public void call(rx.l<? super ArrayList<HomeListNewBean>> lVar) {
                        Map<String, Integer> c2 = FeaturedFragment.this.d.c(FeaturedFragment.this.a((ArrayList<HomeListNewBean>) arrayList));
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            HomeListNewBean homeListNewBean = (HomeListNewBean) it.next();
                            if (c2.containsKey(homeListNewBean.getVideoid())) {
                                homeListNewBean.setIsFav(c2.get(homeListNewBean.getVideoid()).intValue());
                            }
                        }
                        if (lVar != null && !lVar.isUnsubscribed()) {
                            lVar.onNext(arrayList);
                            lVar.onCompleted();
                        }
                    }
                });
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> a(ArrayList<HomeListNewBean> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                arrayList2.add(arrayList.get(i2).getVideoid());
                i = i2 + 1;
            } else {
                return arrayList2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HomeListNewBean homeListNewBean, final int i) {
        a(this.f4542c.a(homeListNewBean.getVideoid(), i + 1).a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<MyHttpResponse>() { // from class: com.fotoable.youtube.music.ui.fragment.FeaturedFragment.2
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                com.fotoable.youtube.music.util.h.a(FeaturedFragment.f4541b, th.getMessage());
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(MyHttpResponse myHttpResponse) {
                if (myHttpResponse.isSuccess()) {
                    if (i == 0) {
                    }
                    com.fotoable.youtube.music.util.h.a(FeaturedFragment.f4541b, "删除成功");
                }
            }
        }));
    }

    @Override // com.fotoable.youtube.music.base.i
    public void g() {
        e().a(this);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.f = context;
    }

    private void w() {
        this.f = getContext();
    }

    private void x() {
        this.carouselPager.addOnPageChangeListener(this.n);
        this.chartsView.setOnClickListener(this.o);
        this.artistsView.setOnClickListener(this.o);
        this.genresView.setOnClickListener(this.o);
    }

    @Override // com.fotoable.youtube.music.base.i
    public void h() {
        a(com.fotoable.youtube.music.e.b.a().a(com.fotoable.youtube.music.e.a.class, new rx.c.b<com.fotoable.youtube.music.e.a>() { // from class: com.fotoable.youtube.music.ui.fragment.FeaturedFragment.3
            @Override // rx.c.b
            /* renamed from: a */
            public void call(com.fotoable.youtube.music.e.a aVar) {
                switch (aVar.f2726a) {
                    case PointerIconCompat.TYPE_HELP /* 1003 */:
                        com.fotoable.youtube.music.util.h.a(FeaturedFragment.f4541b, "===添加收藏==");
                        FeaturedFragment.this.a(FeaturedFragment.this.d.a((FavBean) aVar.f2727b).a(com.fotoable.youtube.music.util.s.a()).b(new rx.c.b<Boolean>() { // from class: com.fotoable.youtube.music.ui.fragment.FeaturedFragment.3.1
                            @Override // rx.c.b
                            /* renamed from: a */
                            public void call(Boolean bool) {
                            }
                        }));
                        return;
                    case PointerIconCompat.TYPE_WAIT /* 1004 */:
                        com.fotoable.youtube.music.util.h.a(FeaturedFragment.f4541b, "===取消收藏==");
                        FeaturedFragment.this.a(FeaturedFragment.this.d.b((FavBean) aVar.f2727b).a(com.fotoable.youtube.music.util.s.a()).b(new rx.c.b<Boolean>() { // from class: com.fotoable.youtube.music.ui.fragment.FeaturedFragment.3.2
                            @Override // rx.c.b
                            /* renamed from: a */
                            public void call(Boolean bool) {
                            }
                        }));
                        return;
                    case PointerIconCompat.TYPE_NO_DROP /* 1012 */:
                        String str = (String) aVar.f2727b;
                        return;
                    case PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW /* 1014 */:
                    default:
                        return;
                }
            }
        }));
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        try {
            l_();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @OnClick({R.id.ll_error})
    public void onClick() {
        this.refreshLayout.setRefreshing(true);
    }

    @OnClick({R.id.ll_error})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_error /* 2131820763 */:
                this.refreshLayout.setRefreshing(true);
                return;
            default:
                return;
        }
    }
}

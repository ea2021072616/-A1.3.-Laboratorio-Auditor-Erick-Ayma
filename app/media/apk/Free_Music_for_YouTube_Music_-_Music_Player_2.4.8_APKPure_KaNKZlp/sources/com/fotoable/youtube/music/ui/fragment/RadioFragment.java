package com.fotoable.youtube.music.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.OnClick;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.RadioBean;
import com.fotoable.youtube.music.bean.RadioCountryBean;
import com.fotoable.youtube.music.ui.activity.RadioListActivity;
import com.fotoable.youtube.music.ui.adapter.GridSpacingItemDecoration;
import com.fotoable.youtube.music.ui.adapter.HotCountryAdapter;
import com.fotoable.youtube.music.ui.adapter.HotRadioAdapter;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import java.util.List;
import javax.inject.Inject;
import rx.f;
/* loaded from: classes.dex */
public class RadioFragment extends com.fotoable.youtube.music.base.i {

    /* renamed from: c  reason: collision with root package name */
    private static final String f4697c = RadioFragment.class.getSimpleName();
    @BindView(R.id.all_radio_view)
    RelativeLayout allRadioView;
    @Inject

    /* renamed from: b  reason: collision with root package name */
    com.fotoable.youtube.music.b.c f4698b;
    private HotRadioAdapter d;
    private HotCountryAdapter e;
    private boolean f;
    private boolean g;
    @BindView(R.id.hot_country_recyclerView)
    RecyclerView hotCountryRecyclerView;
    @BindView(R.id.hot_radio_recyclerView)
    RecyclerView hotRadioRecyclerView;
    @BindView(R.id.hot_radio_view_all_tx)
    LaToTextView hotRadioViewAllTx;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.root_view)
    View rootView;

    @Override // com.fotoable.youtube.music.base.i
    public int a() {
        return R.layout.fragment_radio;
    }

    @Override // com.fotoable.youtube.music.base.i
    public void a(View view, @Nullable Bundle bundle) {
        com.fotoable.youtube.music.util.b.b("在线音乐-电台-展示");
        com.fotoable.youtube.music.util.b.a("在线音乐-电台-展示");
        j();
        k();
        this.refreshLayout.setRefreshing(true);
        l();
        m();
    }

    @Override // com.fotoable.youtube.music.base.i
    public void g() {
        e().a(this);
    }

    @OnClick({R.id.hot_radio_view_all_tx, R.id.all_radio_view, R.id.hot_radio_view_all})
    public void onViewClicked(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.hot_radio_view_all /* 2131821178 */:
            case R.id.hot_radio_view_all_tx /* 2131821179 */:
                intent.setClass(getActivity(), RadioListActivity.class);
                intent.putExtra("extra_type_key", 1);
                startActivity(intent);
                com.fotoable.youtube.music.util.b.b("电台-热门电台-更多");
                com.fotoable.youtube.music.util.b.a("电台-热门电台-更多");
                return;
            case R.id.hot_radio_recyclerView /* 2131821180 */:
            case R.id.hot_country_recyclerView /* 2131821181 */:
            default:
                return;
            case R.id.all_radio_view /* 2131821182 */:
                intent.setClass(getActivity(), RadioListActivity.class);
                intent.putExtra("extra_type_key", 0);
                startActivity(intent);
                com.fotoable.youtube.music.util.b.b("电台-所有电台-按钮");
                com.fotoable.youtube.music.util.b.a("电台-所有电台-按钮");
                return;
        }
    }

    private void j() {
        this.refreshLayout.setColorSchemeResources(17170459, 17170452, 17170456, 17170454);
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.fotoable.youtube.music.ui.fragment.RadioFragment.1
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                RadioFragment.this.g = false;
                RadioFragment.this.f = false;
                RadioFragment.this.l();
                RadioFragment.this.m();
            }
        });
    }

    private void k() {
        this.hotRadioRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        this.hotRadioRecyclerView.setNestedScrollingEnabled(false);
        this.d = new HotRadioAdapter(getActivity());
        this.hotRadioRecyclerView.setAdapter(this.d);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 4);
        GridSpacingItemDecoration gridSpacingItemDecoration = new GridSpacingItemDecoration(4, com.fotoable.youtube.music.util.w.a(getActivity(), 42.0f), false);
        this.hotCountryRecyclerView.setLayoutManager(gridLayoutManager);
        this.hotCountryRecyclerView.addItemDecoration(gridSpacingItemDecoration);
        this.hotCountryRecyclerView.setNestedScrollingEnabled(false);
        this.e = new HotCountryAdapter(getActivity());
        this.hotCountryRecyclerView.setAdapter(this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        a(this.f4698b.a(0, 12).a(com.fotoable.youtube.music.util.s.a()).a((f.c<? super R, ? extends R>) com.fotoable.youtube.music.util.s.b()).a((rx.g) new rx.g<List<RadioBean>>() { // from class: com.fotoable.youtube.music.ui.fragment.RadioFragment.2
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(List<RadioBean> list) {
                if (list != null) {
                    RadioFragment.this.d.refresh(list);
                    com.fotoable.youtube.music.util.h.a(RadioFragment.f4697c, list.size() + "");
                }
                RadioFragment.this.f = true;
                if (RadioFragment.this.g) {
                    RadioFragment.this.refreshLayout.setRefreshing(false);
                    RadioFragment.this.rootView.setVisibility(0);
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        a(this.f4698b.l().a(com.fotoable.youtube.music.util.s.a()).a((f.c<? super R, ? extends R>) com.fotoable.youtube.music.util.s.b()).a((rx.g) new rx.g<List<RadioCountryBean>>() { // from class: com.fotoable.youtube.music.ui.fragment.RadioFragment.3
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(List<RadioCountryBean> list) {
                if (list != null) {
                    RadioFragment.this.e.refresh(list);
                    com.fotoable.youtube.music.util.h.a(RadioFragment.f4697c, "热门国家数目:" + list.size());
                }
                RadioFragment.this.g = true;
                if (RadioFragment.this.f) {
                    RadioFragment.this.refreshLayout.setRefreshing(false);
                    RadioFragment.this.rootView.setVisibility(0);
                }
            }
        }));
    }
}

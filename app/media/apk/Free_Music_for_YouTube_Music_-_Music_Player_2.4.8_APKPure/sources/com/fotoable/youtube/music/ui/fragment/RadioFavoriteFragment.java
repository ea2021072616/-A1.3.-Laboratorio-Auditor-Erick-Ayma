package com.fotoable.youtube.music.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.OnClick;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.RadioBean;
import com.fotoable.youtube.music.ui.activity.RadioActivity;
import com.fotoable.youtube.music.ui.adapter.MyRadioAdapter;
import java.util.List;
import javax.inject.Inject;
/* loaded from: classes.dex */
public class RadioFavoriteFragment extends com.fotoable.youtube.music.base.i {
    @Inject

    /* renamed from: b  reason: collision with root package name */
    com.fotoable.youtube.music.db.a f4686b;

    /* renamed from: c  reason: collision with root package name */
    private MyRadioAdapter f4687c;
    @BindView(R.id.no_data_view)
    LinearLayout noDataView;
    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.show_online_data_view)
    RelativeLayout showOnlineDataView;

    public static RadioFavoriteFragment i() {
        return new RadioFavoriteFragment();
    }

    @Override // com.fotoable.youtube.music.base.i
    public int a() {
        return R.layout.fragment_radio_favorites;
    }

    @Override // com.fotoable.youtube.music.base.i
    public void a(View view, @Nullable Bundle bundle) {
        k();
        j();
        l();
        h();
    }

    @Override // com.fotoable.youtube.music.base.i
    public void g() {
        e().a(this);
    }

    private void j() {
        this.recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f4687c = new MyRadioAdapter(getActivity());
        this.recycleView.setAdapter(this.f4687c);
        this.f4687c.setDeleteListener(new MyRadioAdapter.DeleteListener() { // from class: com.fotoable.youtube.music.ui.fragment.RadioFavoriteFragment.1
            @Override // com.fotoable.youtube.music.ui.adapter.MyRadioAdapter.DeleteListener
            public void delete(RadioBean radioBean) {
                RadioFavoriteFragment.this.a(radioBean);
            }
        });
    }

    private void k() {
        this.refreshLayout.setColorSchemeResources(17170459, 17170452, 17170456, 17170454);
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.fotoable.youtube.music.ui.fragment.RadioFavoriteFragment.2
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                RadioFavoriteFragment.this.l();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        a(this.f4686b.j().a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<List<RadioBean>>() { // from class: com.fotoable.youtube.music.ui.fragment.RadioFavoriteFragment.3
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(List<RadioBean> list) {
                if (list != null && list.size() > 0) {
                    RadioFavoriteFragment.this.f4687c.refresh(list);
                    RadioFavoriteFragment.this.noDataView.setVisibility(8);
                    RadioFavoriteFragment.this.showOnlineDataView.setVisibility(8);
                } else {
                    RadioFavoriteFragment.this.noDataView.setVisibility(0);
                    RadioFavoriteFragment.this.showOnlineDataView.setVisibility(0);
                }
                RadioFavoriteFragment.this.refreshLayout.setRefreshing(false);
            }
        }));
    }

    @Override // com.fotoable.youtube.music.base.i
    public void h() {
        a(com.fotoable.youtube.music.e.b.a().a(com.fotoable.youtube.music.e.a.class, new rx.c.b<com.fotoable.youtube.music.e.a>() { // from class: com.fotoable.youtube.music.ui.fragment.RadioFavoriteFragment.4
            @Override // rx.c.b
            /* renamed from: a */
            public void call(com.fotoable.youtube.music.e.a aVar) {
                switch (aVar.f2726a) {
                    case 1045:
                        RadioFavoriteFragment.this.l();
                        return;
                    default:
                        return;
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RadioBean radioBean) {
        a(this.f4686b.b(radioBean).a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<Boolean>() { // from class: com.fotoable.youtube.music.ui.fragment.RadioFavoriteFragment.5
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(Boolean bool) {
            }
        }));
    }

    @OnClick({R.id.show_online_data_view})
    public void onViewClicked() {
        startActivity(new Intent(getActivity(), RadioActivity.class));
    }
}

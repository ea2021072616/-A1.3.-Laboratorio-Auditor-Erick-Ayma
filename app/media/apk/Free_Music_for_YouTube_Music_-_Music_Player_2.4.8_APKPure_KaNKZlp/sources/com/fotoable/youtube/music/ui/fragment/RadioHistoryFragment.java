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
/* loaded from: classes.dex */
public class RadioHistoryFragment extends com.fotoable.youtube.music.base.i {

    /* renamed from: b  reason: collision with root package name */
    private MyRadioAdapter f4711b;
    @BindView(R.id.no_data_view)
    LinearLayout noDataView;
    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.show_online_data_view)
    RelativeLayout showOnlineDataView;

    public static RadioHistoryFragment i() {
        return new RadioHistoryFragment();
    }

    @Override // com.fotoable.youtube.music.base.i
    public int a() {
        return R.layout.fragment_radio_favorites;
    }

    @Override // com.fotoable.youtube.music.base.i
    public void a(View view, @Nullable Bundle bundle) {
        j();
        k();
        l();
        h();
    }

    @Override // com.fotoable.youtube.music.base.i
    public void g() {
        e().a(this);
    }

    private void j() {
        this.refreshLayout.setColorSchemeResources(17170459, 17170452, 17170456, 17170454);
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.fotoable.youtube.music.ui.fragment.RadioHistoryFragment.1
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                RadioHistoryFragment.this.l();
            }
        });
    }

    private void k() {
        this.recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f4711b = new MyRadioAdapter(getActivity());
        this.recycleView.setAdapter(this.f4711b);
        this.f4711b.setDeleteListener(new MyRadioAdapter.DeleteListener() { // from class: com.fotoable.youtube.music.ui.fragment.RadioHistoryFragment.2
            @Override // com.fotoable.youtube.music.ui.adapter.MyRadioAdapter.DeleteListener
            public void delete(RadioBean radioBean) {
                com.fotoable.youtube.music.util.o.a().b(radioBean);
            }
        });
    }

    @Override // com.fotoable.youtube.music.base.i
    public void h() {
        a(com.fotoable.youtube.music.e.b.a().a(com.fotoable.youtube.music.e.a.class, new rx.c.b<com.fotoable.youtube.music.e.a>() { // from class: com.fotoable.youtube.music.ui.fragment.RadioHistoryFragment.3
            @Override // rx.c.b
            /* renamed from: a */
            public void call(com.fotoable.youtube.music.e.a aVar) {
                switch (aVar.f2726a) {
                    case 1045:
                        RadioHistoryFragment.this.l();
                        return;
                    default:
                        return;
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        List<RadioBean> b2 = com.fotoable.youtube.music.util.o.a().b();
        if (b2.size() > 0) {
            this.f4711b.refresh(b2);
            this.noDataView.setVisibility(8);
            this.showOnlineDataView.setVisibility(8);
        } else {
            this.noDataView.setVisibility(0);
            this.showOnlineDataView.setVisibility(0);
        }
        this.refreshLayout.setRefreshing(false);
    }

    @OnClick({R.id.show_online_data_view})
    public void onViewClicked() {
        startActivity(new Intent(getActivity(), RadioActivity.class));
    }
}

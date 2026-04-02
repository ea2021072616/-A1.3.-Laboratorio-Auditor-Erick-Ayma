package com.fotoable.youtube.music.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.OnClick;
import com.facebook.appevents.UserDataStore;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.bean.RadioCountryBean;
import com.fotoable.youtube.music.d.a.e;
import com.fotoable.youtube.music.ui.adapter.CountryAdapter;
import java.util.List;
import javax.inject.Inject;
/* loaded from: classes.dex */
public class CountryActivity extends BaseActivity implements e.a {

    /* renamed from: b  reason: collision with root package name */
    private static final String f3282b = CountryActivity.class.getSimpleName();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    com.fotoable.youtube.music.b.c f3283a;
    @BindView(R.id.back_view)
    ImageView backView;

    /* renamed from: c  reason: collision with root package name */
    private com.fotoable.youtube.music.d.o f3284c;
    private CountryAdapter d;
    private CountryAdapter.CountrySelectListener e = new CountryAdapter.CountrySelectListener() { // from class: com.fotoable.youtube.music.ui.activity.CountryActivity.2
        @Override // com.fotoable.youtube.music.ui.adapter.CountryAdapter.CountrySelectListener
        public void selectCountry(RadioCountryBean radioCountryBean) {
            Intent intent = new Intent();
            intent.putExtra(UserDataStore.COUNTRY, radioCountryBean);
            CountryActivity.this.setResult(-1, intent);
            CountryActivity.this.finish();
        }
    };
    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return true;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.activity_country;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        d();
        this.f3284c = new com.fotoable.youtube.music.d.o(this, this.f3283a);
        r();
        s();
        this.refreshLayout.setRefreshing(true);
        this.f3284c.a();
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
        i().a(this);
    }

    @Override // com.fotoable.youtube.music.d.a.e.a
    public void a(List<RadioCountryBean> list) {
        com.fotoable.youtube.music.util.h.a(f3282b, list.size() + "");
        this.d.refresh(list);
        this.refreshLayout.setRefreshing(false);
    }

    private void r() {
        this.recycleView.setLayoutManager(new LinearLayoutManager(this));
        this.d = new CountryAdapter(this);
        this.recycleView.setAdapter(this.d);
        this.d.setListener(this.e);
    }

    private void s() {
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.fotoable.youtube.music.ui.activity.CountryActivity.1
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                CountryActivity.this.f3284c.a();
            }
        });
        this.refreshLayout.setColorSchemeResources(17170459, 17170452, 17170456, 17170454);
    }

    @OnClick({R.id.back_view})
    public void onViewClicked() {
        finish();
    }
}

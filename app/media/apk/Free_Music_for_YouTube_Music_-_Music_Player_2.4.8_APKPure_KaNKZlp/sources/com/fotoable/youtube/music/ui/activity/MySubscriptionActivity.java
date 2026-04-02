package com.fotoable.youtube.music.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.OnClick;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.bean.SubBean;
import com.fotoable.youtube.music.d.a.m;
import com.fotoable.youtube.music.ui.adapter.MySubscriptionAdapter;
import java.util.List;
import javax.inject.Inject;
/* loaded from: classes.dex */
public class MySubscriptionActivity extends BaseActivity implements m.a {
    @Inject

    /* renamed from: a  reason: collision with root package name */
    com.fotoable.youtube.music.db.a f3619a;

    /* renamed from: b  reason: collision with root package name */
    MySubscriptionAdapter f3620b;
    @Inject

    /* renamed from: c  reason: collision with root package name */
    com.fotoable.youtube.music.d.al f3621c;
    @BindView(R.id.recycle_pop)
    RecyclerView recycleview;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.rel_no_data)
    RelativeLayout relNoData;

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return true;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.activity_my_subscription;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        d();
        r();
        s();
        this.f3621c.a();
    }

    private void r() {
        this.f3620b = new MySubscriptionAdapter(this);
        this.recycleview.setHasFixedSize(true);
        this.recycleview.setLayoutManager(new LinearLayoutManager(this));
        this.recycleview.setAdapter(this.f3620b);
        this.recycleview.setItemAnimator(new DefaultItemAnimator());
    }

    private void s() {
        this.refreshLayout.setRefreshing(true);
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.fotoable.youtube.music.ui.activity.MySubscriptionActivity.1
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                MySubscriptionActivity.this.f3621c.a();
            }
        });
        this.refreshLayout.setColorSchemeResources(17170459, 17170452, 17170456, 17170454);
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
        super.i().a(this);
        this.f3621c.a((m.a) this);
    }

    @OnClick({R.id.img_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back /* 2131820756 */:
                onBackPressed();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        j();
        if (this.f3621c != null) {
            this.f3621c.b();
        }
    }

    @Override // com.fotoable.youtube.music.d.a.m.a
    public void a(List<SubBean> list) {
        if (list == null || list.size() == 0) {
            this.f3620b.cleanDatas();
            this.relNoData.setVisibility(0);
            return;
        }
        if (list.size() == 0) {
            this.relNoData.setVisibility(0);
        } else {
            this.relNoData.setVisibility(8);
        }
        this.f3620b.setAddDatas(list);
    }

    @Override // com.fotoable.youtube.music.d.a.m.a
    public void b(boolean z) {
        if (this.f3620b != null && this.relNoData != null) {
            if (this.f3620b.getItemCount() == 0) {
                this.relNoData.setVisibility(0);
            } else {
                this.relNoData.setVisibility(8);
            }
        }
    }

    @Override // com.fotoable.youtube.music.d.a.m.a
    public void a(boolean z) {
        this.refreshLayout.setRefreshing(z);
    }
}

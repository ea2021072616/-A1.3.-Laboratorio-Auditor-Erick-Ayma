package com.fotoable.youtube.music.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.OnLoadMoreListener;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.bean.HomeListNewBean;
import com.fotoable.youtube.music.bean.MyHttpResponse;
import com.fotoable.youtube.music.d.a.i;
import com.fotoable.youtube.music.ui.adapter.HomeListAdapter;
import com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog;
import com.fotoable.youtube.music.ui.view.ISwipeRefreshLayout;
import com.fotoable.youtube.music.ui.view.LoadMoreFooterView;
import java.util.List;
import javax.inject.Inject;
/* loaded from: classes.dex */
public class HomeListActivity extends BaseActivity implements i.a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3363a = HomeListActivity.class.getSimpleName();
    @Inject

    /* renamed from: b  reason: collision with root package name */
    com.fotoable.youtube.music.db.a f3364b;
    @Inject

    /* renamed from: c  reason: collision with root package name */
    com.fotoable.youtube.music.b.c f3365c;
    private HomeListAdapter d;
    private LoadMoreFooterView e;
    private boolean f;
    private boolean g;
    private com.fotoable.youtube.music.d.z h;
    @BindView(R.id.img_back)
    ImageView imgBack;
    private String j;
    @BindView(R.id.recycle_view)
    IRecyclerView recycleView;
    @BindView(R.id.refreshLayout)
    ISwipeRefreshLayout refreshLayout;
    @BindView(R.id.title_tx)
    TextView titleTextView;
    private int i = -1;
    private OnLoadMoreListener k = new OnLoadMoreListener() { // from class: com.fotoable.youtube.music.ui.activity.HomeListActivity.2
        @Override // com.aspsine.irecyclerview.OnLoadMoreListener
        public void onLoadMore() {
            if (HomeListActivity.this.g) {
                if (!HomeListActivity.this.f) {
                    HomeListActivity.this.f = true;
                    HomeListActivity.this.e.setStatus(LoadMoreFooterView.Status.LOADING);
                    if (HomeListActivity.this.i == 1) {
                        HomeListActivity.this.h.b(HomeListActivity.this.j);
                        return;
                    } else {
                        HomeListActivity.this.h.a(HomeListActivity.this.j);
                        return;
                    }
                }
                return;
            }
            HomeListActivity.this.e.setStatus(LoadMoreFooterView.Status.THE_END);
        }
    };
    private HomeListAdapter.OnAdminDeleteLister l = new HomeListAdapter.OnAdminDeleteLister() { // from class: com.fotoable.youtube.music.ui.activity.HomeListActivity.3
        @Override // com.fotoable.youtube.music.ui.adapter.HomeListAdapter.OnAdminDeleteLister
        public void onDelete(final HomeListNewBean homeListNewBean, final int i) {
            SimpleMusicDialog.a(HomeListActivity.this.getSupportFragmentManager(), new SimpleMusicDialog.a() { // from class: com.fotoable.youtube.music.ui.activity.HomeListActivity.3.1
                @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
                public void a() {
                }

                @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
                public void b() {
                }

                @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
                public void c() {
                    HomeListActivity.this.a(homeListNewBean, i);
                }
            }, R.string.sure_delete, R.string.cancel, R.string.ok);
        }
    };

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.activity_home_list;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        this.h = new com.fotoable.youtube.music.d.z(this.f3365c, this, this.f3364b);
        d();
        s();
        t();
        u();
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
        i().a(this);
    }

    private void s() {
        this.i = getIntent().getIntExtra("EXTRA_TYPE_KEY", -1);
        if (this.i < 0) {
            finish();
        }
        if (this.i == 0) {
            this.titleTextView.setText(R.string.hit_singles);
            this.h.a(this.j);
        } else {
            this.titleTextView.setText(R.string.fresh_songs);
            this.h.b(this.j);
        }
        this.f = true;
    }

    private void t() {
        this.recycleView.setLayoutManager(new LinearLayoutManager(this));
        this.d = new HomeListAdapter(this, getSupportFragmentManager(), this.f3364b);
        this.d.setOnAdminDeleteLister(this.l);
        this.d.setType(this.i);
        this.recycleView.setIAdapter(this.d);
        this.recycleView.setOnLoadMoreListener(this.k);
        this.e = (LoadMoreFooterView) this.recycleView.getLoadMoreFooterView();
    }

    private void u() {
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(this) { // from class: com.fotoable.youtube.music.ui.activity.ac

            /* renamed from: a  reason: collision with root package name */
            private final HomeListActivity f3918a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f3918a = this;
            }

            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                this.f3918a.r();
            }
        });
        this.refreshLayout.setColorSchemeResources(17170459, 17170452, 17170456, 17170454);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void r() {
        this.j = "";
        if (this.i == 1) {
            this.h.b(this.j);
        } else {
            this.h.a(this.j);
        }
        this.f = true;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return true;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(com.fotoable.youtube.music.e.a aVar) {
        super.a(aVar);
        switch (aVar.f2726a) {
            case PointerIconCompat.TYPE_NO_DROP /* 1012 */:
                if (this.d != null) {
                    this.d.setIsPlayingID((String) aVar.f2727b);
                    return;
                }
                return;
            case PointerIconCompat.TYPE_ALL_SCROLL /* 1013 */:
            default:
                return;
            case PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW /* 1014 */:
                if (this.d != null) {
                    this.d.setIsPlayingID("");
                    return;
                }
                return;
        }
    }

    @Override // com.fotoable.youtube.music.d.a.i.a
    public void a(List<HomeListNewBean> list, boolean z) {
        if (list != null && list.size() > 0) {
            this.g = true;
            if (z) {
                this.d.setAllAddData(list);
            } else {
                this.d.setAddData(list);
            }
            this.j = list.get(list.size() - 1).getPageToken();
        } else {
            this.g = false;
        }
        this.f = false;
        this.refreshLayout.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final HomeListNewBean homeListNewBean, int i) {
        a(this.f3365c.a(homeListNewBean.getVideoid(), i + 1).a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<MyHttpResponse>() { // from class: com.fotoable.youtube.music.ui.activity.HomeListActivity.1
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                com.fotoable.youtube.music.util.h.a(HomeListActivity.f3363a, th.getMessage());
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(MyHttpResponse myHttpResponse) {
                if (myHttpResponse.isSuccess()) {
                    HomeListActivity.this.d.delete(homeListNewBean);
                    com.fotoable.youtube.music.util.h.a(HomeListActivity.f3363a, "删除成功");
                }
            }
        }));
    }

    @OnClick({R.id.img_back})
    public void onViewClicked() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.h.a();
    }
}

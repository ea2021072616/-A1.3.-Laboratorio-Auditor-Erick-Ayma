package com.fotoable.youtube.music.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.OnClick;
import com.facebook.ads.AdError;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.bean.RecentlyWatchBean;
import com.fotoable.youtube.music.d.a.l;
import com.fotoable.youtube.music.ui.adapter.RecentlyAdapter;
import com.fotoable.youtube.music.ui.dialog.h;
import java.util.List;
import javax.inject.Inject;
/* loaded from: classes.dex */
public class MyRecentlyWatchedActivity extends BaseActivity implements l.a {
    @Inject

    /* renamed from: a  reason: collision with root package name */
    com.fotoable.youtube.music.db.a f3605a;

    /* renamed from: b  reason: collision with root package name */
    RecentlyAdapter f3606b;

    /* renamed from: c  reason: collision with root package name */
    com.fotoable.youtube.music.ui.dialog.h f3607c;
    @Inject
    com.fotoable.youtube.music.d.ag d;
    @BindView(R.id.iv_menu)
    ImageView iv_menu;
    @BindView(R.id.recycle_pop)
    RecyclerView recycleView;
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
        return R.layout.activity_my_recently;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        d();
        r();
        s();
        this.d.a();
    }

    private void r() {
        this.f3606b = new RecentlyAdapter(this, getSupportFragmentManager());
        this.f3606b.setIsPlayingID(com.fotoable.youtube.music.newplayer.e.a().e() == null ? "" : com.fotoable.youtube.music.newplayer.e.a().e().getVideoId());
        this.recycleView.setHasFixedSize(true);
        this.recycleView.setLayoutManager(new LinearLayoutManager(this));
        this.recycleView.setAdapter(this.f3606b);
        this.recycleView.setItemAnimator(new DefaultItemAnimator());
        this.f3606b.setOnItemClickListener(new RecentlyAdapter.OnItemClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MyRecentlyWatchedActivity.1
            @Override // com.fotoable.youtube.music.ui.adapter.RecentlyAdapter.OnItemClickListener
            public void onPlayNow(RecentlyWatchBean recentlyWatchBean) {
                int indexOf = MyRecentlyWatchedActivity.this.f3606b.getRecentlyWatchBeen().indexOf(recentlyWatchBean);
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a((int) AdError.INTERNAL_ERROR_CODE, com.fotoable.youtube.music.newplayer.a.b.c(MyRecentlyWatchedActivity.this.f3606b.getRecentlyWatchBeen()), indexOf));
            }

            @Override // com.fotoable.youtube.music.ui.adapter.RecentlyAdapter.OnItemClickListener
            public void onPlayNext(RecentlyWatchBean recentlyWatchBean) {
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2002, com.fotoable.youtube.music.newplayer.a.b.a(recentlyWatchBean)));
            }

            @Override // com.fotoable.youtube.music.ui.adapter.RecentlyAdapter.OnItemClickListener
            public void onAddToPlayQueue(RecentlyWatchBean recentlyWatchBean) {
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2003, com.fotoable.youtube.music.newplayer.a.b.a(recentlyWatchBean)));
            }
        });
    }

    @Override // com.fotoable.youtube.music.d.a.l.a
    public void a(List<RecentlyWatchBean> list) {
        if (list == null || list.size() == 0) {
            this.refreshLayout.setRefreshing(false);
            this.relNoData.setVisibility(0);
            this.iv_menu.setVisibility(8);
            this.f3606b.clearDatas();
            return;
        }
        if (list.size() == 0) {
            this.relNoData.setVisibility(0);
            this.iv_menu.setVisibility(8);
            this.f3606b.setHeadViewVisable(false);
        } else {
            this.relNoData.setVisibility(8);
            this.iv_menu.setVisibility(0);
            this.f3606b.setHeadViewVisable(true);
        }
        this.f3606b.setAddDatas(list);
    }

    @Override // com.fotoable.youtube.music.d.a.l.a
    public boolean a(String str) {
        return this.f3606b.setIsPlayingID(str);
    }

    @Override // com.fotoable.youtube.music.d.a.l.a
    public void a(Boolean bool) {
        if (this.f3606b != null) {
            if ((this.f3606b.getHeaderView() == null && this.f3606b.getItemCount() == 0) || (this.f3606b.getHeaderView() != null && this.f3606b.getItemCount() == 1)) {
                this.relNoData.setVisibility(0);
                this.iv_menu.setVisibility(8);
                this.f3606b.setHeadViewVisable(false);
                return;
            }
            this.relNoData.setVisibility(8);
            this.iv_menu.setVisibility(0);
            this.f3606b.setHeadViewVisable(true);
        }
    }

    @Override // com.fotoable.youtube.music.d.a.l.a
    public void j_() {
        if (this.f3606b != null) {
            this.f3606b.clearDatas();
            this.relNoData.setVisibility(0);
            this.iv_menu.setVisibility(8);
        }
    }

    @Override // com.fotoable.youtube.music.d.a.l.a
    public void a(boolean z) {
        this.refreshLayout.setRefreshing(z);
    }

    @Override // com.fotoable.youtube.music.d.a.l.a
    public void a(String str, boolean z) {
        if (this.f3606b != null) {
            this.f3606b.changeFavState(str, z);
        }
    }

    private void s() {
        this.refreshLayout.setRefreshing(true);
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.fotoable.youtube.music.ui.activity.MyRecentlyWatchedActivity.2
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                MyRecentlyWatchedActivity.this.d.a();
            }
        });
        this.refreshLayout.setColorSchemeResources(17170459, 17170452, 17170456, 17170454);
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
        super.i().a(this);
        this.d.a((l.a) this);
    }

    @OnClick({R.id.img_back, R.id.iv_menu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back /* 2131820756 */:
                onBackPressed();
                return;
            case R.id.iv_menu /* 2131820838 */:
                t();
                return;
            default:
                return;
        }
    }

    private void t() {
        this.f3607c = new h.a(this).b(148).c(310).a(true).d(com.fotoable.youtube.music.R.style.Theme_Light_Dialog).a(R.layout.dialog_delete).a(R.id.txt_cancel, new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MyRecentlyWatchedActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MyRecentlyWatchedActivity.this.f3607c.cancel();
            }
        }).a(R.id.txt_ok, new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MyRecentlyWatchedActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MyRecentlyWatchedActivity.this.f3607c.cancel();
                MyRecentlyWatchedActivity.this.d.b();
            }
        }).a();
        this.f3607c.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.d != null) {
            this.d.c();
        }
        com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(PointerIconCompat.TYPE_COPY));
    }
}

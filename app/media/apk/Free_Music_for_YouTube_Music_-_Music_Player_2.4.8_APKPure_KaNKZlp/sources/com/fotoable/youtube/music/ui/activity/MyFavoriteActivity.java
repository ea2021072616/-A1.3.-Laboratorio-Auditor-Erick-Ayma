package com.fotoable.youtube.music.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.facebook.ads.AdError;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.bean.FavBean;
import com.fotoable.youtube.music.d.a.k;
import com.fotoable.youtube.music.ui.adapter.MyFavoriteAdapter;
import com.fotoable.youtube.music.ui.dialog.h;
import java.util.List;
import javax.inject.Inject;
/* loaded from: classes.dex */
public class MyFavoriteActivity extends BaseActivity implements k.a {
    @Inject

    /* renamed from: a  reason: collision with root package name */
    com.fotoable.youtube.music.db.a f3564a;

    /* renamed from: b  reason: collision with root package name */
    TextView f3565b;

    /* renamed from: c  reason: collision with root package name */
    MyFavoriteAdapter f3566c;
    com.fotoable.youtube.music.ui.dialog.h d;
    int e;
    @Inject
    com.fotoable.youtube.music.d.ad f;
    @BindView(R.id.recycle_pop)
    RecyclerView recyclerView;
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
        return R.layout.activity_my_favorite;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        d();
        r();
        s();
        this.f.a();
    }

    private void r() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.include_my_favority_recycleview_head, (ViewGroup) null);
        this.f3566c = new MyFavoriteAdapter(this, getSupportFragmentManager());
        this.f3566c.setHeaderView(inflate);
        this.f3566c.setIsPlayingID(com.fotoable.youtube.music.newplayer.e.a().e() == null ? "" : com.fotoable.youtube.music.newplayer.e.a().e().getVideoId());
        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView.setAdapter(this.f3566c);
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.f3566c.setOnItemClickListener(new MyFavoriteAdapter.OnItemClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MyFavoriteActivity.1
            @Override // com.fotoable.youtube.music.ui.adapter.MyFavoriteAdapter.OnItemClickListener
            public void onPlayNow(FavBean favBean) {
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a((int) AdError.INTERNAL_ERROR_CODE, com.fotoable.youtube.music.newplayer.a.b.a(MyFavoriteActivity.this.f3566c.getFavBeanArrayList()), MyFavoriteActivity.this.f3566c.getFavBeanArrayList().indexOf(favBean)));
            }

            @Override // com.fotoable.youtube.music.ui.adapter.MyFavoriteAdapter.OnItemClickListener
            public void onPlayNext(FavBean favBean) {
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2002, com.fotoable.youtube.music.newplayer.a.b.a(favBean)));
            }

            @Override // com.fotoable.youtube.music.ui.adapter.MyFavoriteAdapter.OnItemClickListener
            public void onAddToPlayQueue(FavBean favBean) {
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2003, com.fotoable.youtube.music.newplayer.a.b.a(favBean)));
            }
        });
        if (inflate != null) {
            TextView textView = (TextView) inflate.findViewById(R.id.txt_clear);
            if (textView != null) {
                textView.setOnClickListener(new View.OnClickListener(this) { // from class: com.fotoable.youtube.music.ui.activity.ap

                    /* renamed from: a  reason: collision with root package name */
                    private final MyFavoriteActivity f3940a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f3940a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        this.f3940a.j(view);
                    }
                });
            }
            RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.rel_play_all);
            if (relativeLayout != null) {
                relativeLayout.setOnClickListener(new View.OnClickListener(this) { // from class: com.fotoable.youtube.music.ui.activity.aq

                    /* renamed from: a  reason: collision with root package name */
                    private final MyFavoriteActivity f3941a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f3941a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        this.f3941a.i(view);
                    }
                });
            }
            this.f3565b = (TextView) inflate.findViewById(R.id.txt_songs);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void j(View view) {
        t();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void i(View view) {
        com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2004, com.fotoable.youtube.music.newplayer.a.b.a(this.f3566c.getFavBeanArrayList())));
    }

    private void s() {
        this.refreshLayout.setRefreshing(true);
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.fotoable.youtube.music.ui.activity.MyFavoriteActivity.2
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                MyFavoriteActivity.this.f.a();
            }
        });
        this.refreshLayout.setColorSchemeResources(17170459, 17170452, 17170456, 17170454);
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
        super.i().a(this);
        this.f.a((k.a) this);
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

    private void t() {
        this.d = new h.a(this).b(148).c(310).a(true).d(com.fotoable.youtube.music.R.style.Theme_Light_Dialog).a(R.layout.dialog_delete).a(R.id.txt_cancel, new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MyFavoriteActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MyFavoriteActivity.this.d.cancel();
            }
        }).a(R.id.txt_ok, new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MyFavoriteActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MyFavoriteActivity.this.d.cancel();
                MyFavoriteActivity.this.f.b();
            }
        }).a();
        this.d.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f.c();
        j();
        com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(PointerIconCompat.TYPE_COPY));
    }

    @Override // com.fotoable.youtube.music.d.a.k.a
    public void a(List<FavBean> list) {
        if (list == null || list.size() == 0) {
            this.f3566c.cleanDatas();
            this.relNoData.setVisibility(0);
            return;
        }
        if (list.size() == 0) {
            this.relNoData.setVisibility(0);
            this.f3566c.setHeadViewVisable(false);
        } else {
            this.relNoData.setVisibility(8);
            this.f3566c.setHeadViewVisable(true);
        }
        this.f3566c.setAddDatas(list);
        this.e = list.size();
        this.f3565b.setText("(" + this.e + " " + getResources().getString(R.string.songs) + ")");
    }

    @Override // com.fotoable.youtube.music.d.a.k.a
    public void a(Boolean bool) {
        this.e--;
        this.f3565b.setText("(" + this.e + " " + getResources().getString(R.string.songs) + ")");
        if ((this.f3566c.getHeaderView() == null && this.f3566c.getItemCount() == 0) || (this.f3566c.getHeaderView() != null && this.f3566c.getItemCount() == 1)) {
            this.relNoData.setVisibility(0);
            this.f3566c.setHeadViewVisable(false);
            return;
        }
        this.relNoData.setVisibility(8);
        this.f3566c.setHeadViewVisable(true);
    }

    @Override // com.fotoable.youtube.music.d.a.k.a
    public void a(String str) {
        if (this.f3566c != null) {
            this.f3566c.delFavoriteWatch(str);
        }
    }

    @Override // com.fotoable.youtube.music.d.a.k.a
    public void b(String str) {
        this.f3566c.setIsPlayingID(str);
    }

    @Override // com.fotoable.youtube.music.d.a.k.a
    public void a(boolean z) {
        this.refreshLayout.setRefreshing(z);
    }

    @Override // com.fotoable.youtube.music.d.a.k.a
    public void i_() {
        this.e = 0;
        this.f3566c.cleanDatas();
        this.f3565b.setText("(" + this.e + " " + getResources().getString(R.string.songs) + ")");
        this.relNoData.setVisibility(0);
    }
}

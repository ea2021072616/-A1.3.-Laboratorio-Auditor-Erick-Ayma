package com.fotoable.youtube.music.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.LocalPlayListMusicModel;
import com.fotoable.youtube.music.bean.LocalPlayListParentBean;
import com.fotoable.youtube.music.ui.adapter.LocalPlayListAdapter;
import com.fotoable.youtube.music.ui.dialog.LocalPlayListEditDialog;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import javax.inject.Inject;
import rx.f;
/* loaded from: classes.dex */
public class LocalPlayListFragment extends com.fotoable.youtube.music.base.i {

    /* renamed from: c  reason: collision with root package name */
    private static final String f4638c = LocalPlayListFragment.class.getSimpleName();
    @Inject

    /* renamed from: b  reason: collision with root package name */
    com.fotoable.youtube.music.db.a f4639b;
    private LocalPlayListAdapter d;
    @BindView(R.id.local_total_play_list_count)
    TextView local_total_play_list_count;
    @BindView(R.id.playlist_recycle_view)
    RecyclerView playlist_recycle_view;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refresh_layout;

    @Override // com.fotoable.youtube.music.base.i
    public int a() {
        return R.layout.fragment_local_play_list;
    }

    @Override // com.fotoable.youtube.music.base.i
    public void a(View view, @Nullable Bundle bundle) {
        h();
        this.playlist_recycle_view.setLayoutManager(new LinearLayoutManager(getContext()));
        i();
        this.refresh_layout.setColorSchemeResources(17170459, 17170452, 17170456, 17170454);
        this.refresh_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(this) { // from class: com.fotoable.youtube.music.ui.fragment.ai

            /* renamed from: a  reason: collision with root package name */
            private final LocalPlayListFragment f4773a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4773a = this;
            }

            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                this.f4773a.i();
            }
        });
        com.fotoable.youtube.music.util.b.b("本地音乐--歌单页面展示次数");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.create_play_list_iv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.create_play_list_iv /* 2131821167 */:
                com.fotoable.youtube.music.newplayer.e.a().a(0);
                LocalPlayListEditDialog.a(getChildFragmentManager(), (LocalPlayListMusicModel) null);
                return;
            default:
                return;
        }
    }

    @Override // com.fotoable.youtube.music.base.i
    public void g() {
        e().a(this);
    }

    @Override // com.fotoable.youtube.music.base.i
    public void a(com.fotoable.youtube.music.e.a aVar) {
        super.a(aVar);
        switch (aVar.f2726a) {
            case 1048:
            case 2015:
            case 3009:
            case 3010:
                i();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void i() {
        this.refresh_layout.setRefreshing(true);
        a(rx.f.a(new f.a(this) { // from class: com.fotoable.youtube.music.ui.fragment.aj

            /* renamed from: a  reason: collision with root package name */
            private final LocalPlayListFragment f4774a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4774a = this;
            }

            @Override // rx.c.b
            public void call(Object obj) {
                this.f4774a.a((rx.l) obj);
            }
        }).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<LocalPlayListParentBean>() { // from class: com.fotoable.youtube.music.ui.fragment.LocalPlayListFragment.1
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
                LocalPlayListFragment.this.refresh_layout.setRefreshing(false);
                com.fotoable.youtube.music.util.b.a(th);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(LocalPlayListParentBean localPlayListParentBean) {
                if (localPlayListParentBean != null) {
                    int size = localPlayListParentBean.getLocalPlayListBeanList() != null ? localPlayListParentBean.getLocalPlayListBeanList().size() + 0 : 0;
                    if (localPlayListParentBean.getLocalPlayListModelList() != null) {
                        size += localPlayListParentBean.getLocalPlayListModelList().size();
                    }
                    LocalPlayListFragment.this.local_total_play_list_count.setText("(" + size + ")");
                } else {
                    LocalPlayListFragment.this.local_total_play_list_count.setText("(0)");
                }
                if (LocalPlayListFragment.this.d == null) {
                    LocalPlayListFragment.this.d = new LocalPlayListAdapter(LocalPlayListFragment.this.getContext(), localPlayListParentBean);
                    LocalPlayListFragment.this.playlist_recycle_view.setAdapter(LocalPlayListFragment.this.d);
                } else {
                    LocalPlayListFragment.this.d.notifyData(localPlayListParentBean);
                }
                LocalPlayListFragment.this.refresh_layout.setRefreshing(false);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(rx.l lVar) {
        long currentTimeMillis = System.currentTimeMillis();
        LocalPlayListParentBean localPlayListParentBean = new LocalPlayListParentBean();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f4639b.k());
        arrayList.add(this.f4639b.l());
        arrayList.add(this.f4639b.m());
        arrayList.add(this.f4639b.r());
        localPlayListParentBean.setLocalPlayListBeanList(arrayList);
        localPlayListParentBean.setLocalPlayListModelList(this.f4639b.p());
        if (lVar != null && !lVar.isUnsubscribed()) {
            lVar.onNext(localPlayListParentBean);
            lVar.onCompleted();
        }
        com.fotoable.youtube.music.util.h.b(f4638c, "耗时：" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
    }
}

package com.fotoable.youtube.music.ui.fragment;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Optional;
import com.andexert.expandablelayout.library.ExpandableLayout;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.PlayListModel;
import com.fotoable.youtube.music.bean.RadioBean;
import com.fotoable.youtube.music.bean.SubBean;
import com.fotoable.youtube.music.ui.activity.MyRecentlyWatchedActivity;
import com.fotoable.youtube.music.ui.activity.RadioHomeActivity;
import com.fotoable.youtube.music.ui.adapter.CreatedPlayListAdapter;
import com.fotoable.youtube.music.ui.adapter.MySubscriptionAdapter;
import com.fotoable.youtube.music.ui.dialog.PlayListEditDialog;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
/* loaded from: classes.dex */
public class MyMusicFragment extends com.fotoable.youtube.music.base.i {
    @Inject

    /* renamed from: b  reason: collision with root package name */
    com.fotoable.youtube.music.db.a f4658b;

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f4659c;
    @BindView(R.id.collected_playlist_size)
    LaToTextView collectedSize;
    @BindView(R.id.created_playlist_size)
    LaToTextView createdSize;
    private RecyclerView d;
    private CreatedPlayListAdapter e;
    @BindView(R.id.expand_collected)
    ExpandableLayout expandCollected;
    @BindView(R.id.expand_created)
    ExpandableLayout expandCreated;
    private MySubscriptionAdapter f;
    private ImageView g;
    private ImageView h;
    private ObjectAnimator i;
    private ObjectAnimator j;
    @BindView(R.id.radio_size)
    LaToTextView radioSizeTextView;
    @BindView(R.id.recently_size)
    LaToTextView recentlySize;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;

    @Override // com.fotoable.youtube.music.base.i
    public int a() {
        return R.layout.fragment_my_music;
    }

    @Override // com.fotoable.youtube.music.base.i
    public void a(View view, @Nullable Bundle bundle) {
        i();
        j();
        h();
        k();
        com.fotoable.youtube.music.util.b.b("在线音乐-我的-展示");
        com.fotoable.youtube.music.util.b.a("在线音乐-我的-展示");
    }

    private void i() {
        if (this.expandCreated != null) {
            RelativeLayout headerRelativeLayout = this.expandCreated.getHeaderRelativeLayout();
            this.f4659c = (RecyclerView) this.expandCreated.getContentRelativeLayout().findViewById(R.id.recycler_created);
            this.f4659c.setLayoutManager(new LinearLayoutManager(getContext()));
            this.f4659c.setNestedScrollingEnabled(false);
            this.f4659c.setHasFixedSize(true);
            this.g = (ImageView) headerRelativeLayout.findViewById(R.id.iv_chevron);
            ((ImageView) headerRelativeLayout.findViewById(R.id.iv_create)).setOnClickListener(new View.OnClickListener(this) { // from class: com.fotoable.youtube.music.ui.fragment.ar

                /* renamed from: a  reason: collision with root package name */
                private final MyMusicFragment f4784a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f4784a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f4784a.a(view);
                }
            });
        }
        if (this.expandCollected != null) {
            RelativeLayout headerRelativeLayout2 = this.expandCollected.getHeaderRelativeLayout();
            this.d = (RecyclerView) this.expandCollected.getContentRelativeLayout().findViewById(R.id.recycler_created);
            this.d.setLayoutManager(new LinearLayoutManager(getContext()));
            this.d.setHasFixedSize(true);
            this.d.setItemAnimator(new DefaultItemAnimator());
            this.d.setNestedScrollingEnabled(false);
            this.f = new MySubscriptionAdapter(getContext());
            this.d.setAdapter(this.f);
            this.h = (ImageView) headerRelativeLayout2.findViewById(R.id.iv_chevron1);
        }
        if (this.g != null) {
            this.i = ObjectAnimator.ofFloat(this.g, "rotation", 0.0f, 90.0f);
            this.i.setInterpolator(new AccelerateDecelerateInterpolator());
            this.i.setDuration(150L);
            if (this.i.isRunning()) {
                this.i.cancel();
            }
            this.i.start();
        }
        if (this.h != null) {
            this.j = ObjectAnimator.ofFloat(this.h, "rotation", 0.0f, 90.0f);
            this.j.setInterpolator(new AccelerateDecelerateInterpolator());
            this.j.setDuration(150L);
            if (this.j.isRunning()) {
                this.j.cancel();
            }
            this.j.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(View view) {
        com.fotoable.youtube.music.newplayer.e.a().a(0);
        PlayListEditDialog.a(getFragmentManager(), null);
        com.fotoable.youtube.music.util.b.b("我的-创建歌单次数");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        l();
        m();
        n();
        o();
    }

    private void k() {
        this.refreshLayout.setColorSchemeResources(17170459, 17170452, 17170456, 17170454);
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.fotoable.youtube.music.ui.fragment.MyMusicFragment.1
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                MyMusicFragment.this.j();
            }
        });
    }

    private void l() {
        if (this.f4658b != null && this.expandCreated != null) {
            a(this.f4658b.h().a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<List<PlayListModel>>() { // from class: com.fotoable.youtube.music.ui.fragment.MyMusicFragment.2
                @Override // rx.g
                public void onCompleted() {
                }

                @Override // rx.g
                public void onError(Throwable th) {
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(List<PlayListModel> list) {
                    if (list != null) {
                        MyMusicFragment.this.expandCreated.b();
                        MyMusicFragment.this.createdSize.setText(MyMusicFragment.this.getString(R.string.local_music_size, Integer.valueOf(list.size() + 1)));
                        MyMusicFragment.this.e = new CreatedPlayListAdapter(MyMusicFragment.this.getActivity(), list, MyMusicFragment.this.f4658b);
                        if (MyMusicFragment.this.f4659c != null) {
                            MyMusicFragment.this.f4659c.setAdapter(MyMusicFragment.this.e);
                        }
                        com.fotoable.youtube.music.util.b.b("我的-创建歌单列表-展示次数");
                        return;
                    }
                    MyMusicFragment.this.expandCreated.c();
                }
            }));
        }
    }

    private void m() {
        if (this.f4658b != null && this.radioSizeTextView != null) {
            a(this.f4658b.j().a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<List<RadioBean>>() { // from class: com.fotoable.youtube.music.ui.fragment.MyMusicFragment.3
                @Override // rx.g
                public void onCompleted() {
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    MyMusicFragment.this.radioSizeTextView.setVisibility(8);
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(List<RadioBean> list) {
                    if (list != null && list.size() > 0) {
                        MyMusicFragment.this.radioSizeTextView.setVisibility(0);
                        LaToTextView laToTextView = MyMusicFragment.this.radioSizeTextView;
                        MyMusicFragment myMusicFragment = MyMusicFragment.this;
                        Object[] objArr = new Object[1];
                        objArr[0] = Integer.valueOf(list.size() < 99 ? list.size() : 99);
                        laToTextView.setText(myMusicFragment.getString(R.string.local_music_size, objArr));
                        return;
                    }
                    MyMusicFragment.this.radioSizeTextView.setVisibility(8);
                }
            }));
        }
    }

    private void n() {
        if (this.f4658b != null && this.expandCollected != null && this.f != null) {
            a(this.f4658b.a().a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<List<SubBean>>() { // from class: com.fotoable.youtube.music.ui.fragment.MyMusicFragment.4
                @Override // rx.g
                public void onCompleted() {
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                    MyMusicFragment.this.collectedSize.setVisibility(8);
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(List<SubBean> list) {
                    if (list != null && list.size() > 0) {
                        Collections.reverse(list);
                        MyMusicFragment.this.expandCollected.setVisibility(0);
                        MyMusicFragment.this.expandCollected.b();
                        MyMusicFragment.this.collectedSize.setVisibility(0);
                        MyMusicFragment.this.collectedSize.setText(MyMusicFragment.this.getString(R.string.local_music_size, Integer.valueOf(list.size())));
                        MyMusicFragment.this.f.setAddDatas(list);
                        com.fotoable.youtube.music.util.b.b("我的-收藏歌单列表-展示次数");
                        return;
                    }
                    MyMusicFragment.this.expandCollected.setVisibility(8);
                    MyMusicFragment.this.collectedSize.setVisibility(8);
                    MyMusicFragment.this.expandCollected.c();
                    MyMusicFragment.this.j.reverse();
                    MyMusicFragment.this.f.cleanDatas();
                }
            }));
        }
    }

    private void o() {
        if (this.f4658b != null && this.recentlySize != null) {
            a(this.f4658b.g().a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Long>() { // from class: com.fotoable.youtube.music.ui.fragment.MyMusicFragment.5
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
                    MyMusicFragment.this.recentlySize.setVisibility(l.longValue() > 0 ? 0 : 8);
                    LaToTextView laToTextView = MyMusicFragment.this.recentlySize;
                    MyMusicFragment myMusicFragment = MyMusicFragment.this;
                    Object[] objArr = new Object[1];
                    objArr[0] = Integer.valueOf(l.intValue() >= 99 ? 99 : l.intValue());
                    laToTextView.setText(myMusicFragment.getString(R.string.local_music_size, objArr));
                    MyMusicFragment.this.refreshLayout.setRefreshing(false);
                }
            }));
        }
    }

    @Override // com.fotoable.youtube.music.base.i
    public void h() {
        a(com.fotoable.youtube.music.e.b.a().a(com.fotoable.youtube.music.e.a.class, new rx.c.b(this) { // from class: com.fotoable.youtube.music.ui.fragment.as

            /* renamed from: a  reason: collision with root package name */
            private final MyMusicFragment f4785a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4785a = this;
            }

            @Override // rx.c.b
            public void call(Object obj) {
                this.f4785a.b((com.fotoable.youtube.music.e.a) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b(com.fotoable.youtube.music.e.a aVar) {
        switch (aVar.f2726a) {
            case 1039:
                PlayListModel b2 = this.f4658b.b((Long) aVar.f2727b);
                if (this.e != null) {
                    if (b2 != null) {
                        this.e.add(b2);
                    }
                    this.createdSize.setText(getString(R.string.local_music_size, Integer.valueOf(this.e.getItemCount())));
                    return;
                }
                return;
            case 1040:
                Long l = (Long) aVar.f2727b;
                String str = aVar.f2728c;
                if (this.e != null) {
                    this.e.updateName(l, str);
                    return;
                }
                return;
            case 1041:
                Long l2 = (Long) aVar.f2727b;
                if (this.e != null) {
                    this.e.updateCount(l2);
                    this.createdSize.setText(getString(R.string.local_music_size, Integer.valueOf(this.e.getItemCount())));
                    return;
                }
                return;
            case 1042:
                Long l3 = (Long) aVar.f2727b;
                if (this.e != null) {
                    this.e.delete(l3);
                    this.createdSize.setText(getString(R.string.local_music_size, Integer.valueOf(this.e.getItemCount())));
                    return;
                }
                return;
            case 1044:
                n();
                return;
            case 1045:
                m();
                return;
            case 1046:
                o();
                return;
            case 1047:
                if (this.e != null) {
                    this.e.notifyDataSetChanged();
                    return;
                }
                return;
            case 2010:
                n();
                return;
            default:
                return;
        }
    }

    @Override // com.fotoable.youtube.music.base.i
    public void g() {
        e().a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.ll_recently, R.id.rl_create, R.id.rl_collected, R.id.ll_radio})
    @Optional
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_radio /* 2131821169 */:
                com.fotoable.youtube.music.util.b.b("我的-我的电台-点击次数");
                startActivity(new Intent(getContext(), RadioHomeActivity.class));
                return;
            case R.id.ll_recently /* 2131821172 */:
                com.fotoable.youtube.music.util.b.b("我的-最近观看-点击次数");
                startActivity(new Intent(getContext(), MyRecentlyWatchedActivity.class));
                return;
            case R.id.rl_collected /* 2131821295 */:
                com.fotoable.youtube.music.util.b.b("我的-收藏歌单列表-点击次数");
                if (this.expandCollected != null && this.j != null) {
                    if (this.expandCollected.a().booleanValue()) {
                        this.expandCollected.c();
                        this.j.reverse();
                        return;
                    }
                    this.expandCollected.b();
                    this.j.start();
                    com.fotoable.youtube.music.util.b.b("我的-收藏歌单列表-展示次数");
                    return;
                }
                return;
            case R.id.rl_create /* 2131821299 */:
                com.fotoable.youtube.music.util.b.b("我的-创建歌单列表-点击次数");
                if (this.expandCreated != null && this.i != null) {
                    if (this.expandCreated.a().booleanValue()) {
                        this.expandCreated.c();
                        this.i.reverse();
                        return;
                    }
                    this.expandCreated.b();
                    this.e.notifyDataSetChanged();
                    this.i.start();
                    com.fotoable.youtube.music.util.b.b("我的-创建歌单列表-展示次数");
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.fotoable.youtube.music.base.i, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.e != null) {
            this.e.onDestroy();
        }
        if (this.i != null) {
            this.i.cancel();
            this.i = null;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }
}

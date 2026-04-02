package com.fotoable.youtube.music.ui.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.aspsine.irecyclerview.IRecyclerView;
import com.facebook.ads.AdError;
import com.foto.indexlib.IndexBar.widget.NewIndexBar;
import com.foto.indexlib.a.b;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.bean.LocalAlbumBean;
import com.fotoable.youtube.music.bean.LocalSongBean;
import com.fotoable.youtube.music.ui.adapter.LocalSongAdapter;
import com.fotoable.youtube.music.ui.fragment.LocalSongsFragment;
import com.fotoable.youtube.music.ui.view.ISwipeRefreshLayout;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.fotoable.youtube.music.ui.view.LoadMoreFooterView;
import com.fotoable.youtube.music.util.l;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
/* loaded from: classes.dex */
public class LocalSongsFragment extends com.fotoable.youtube.music.base.i {

    /* renamed from: c  reason: collision with root package name */
    private static final String f4645c = LocalSongsFragment.class.getSimpleName();
    @Inject

    /* renamed from: b  reason: collision with root package name */
    com.fotoable.youtube.music.db.a f4646b;
    private String e;
    private LoadMoreFooterView f;
    private LocalSongAdapter g;
    private ValueAnimator h;
    @BindView(R.id.indexBar)
    NewIndexBar indexBar;
    private com.foto.indexlib.a.b k;
    @BindView(R.id.ll_error)
    LinearLayout llError;
    @BindView(R.id.recycle_view)
    IRecyclerView recycleView;
    @BindView(R.id.refreshLayout)
    ISwipeRefreshLayout refreshLayout;
    @BindView(R.id.rl_nodata)
    RelativeLayout rlNoDataRl;
    @BindView(R.id.tv_again)
    LaToTextView tvAgain;
    @BindView(R.id.tv_error)
    LaToTextView tvError;
    @BindView(R.id.tvSideBarHint)
    TextView tvSideBarHint;
    @BindView(R.id.view_bg)
    View viewBg;
    private String[] d = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private Handler i = new AnonymousClass1();
    private ArrayList<LocalAlbumBean> j = new ArrayList<>();
    private boolean l = false;

    @Override // com.fotoable.youtube.music.base.i
    public int a() {
        return R.layout.fragment_local;
    }

    /* renamed from: com.fotoable.youtube.music.ui.fragment.LocalSongsFragment$1  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends Handler {
        AnonymousClass1() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1005:
                    if (!LocalSongsFragment.this.d() && LocalSongsFragment.this.p() && LocalSongsFragment.this.indexBar.getVisibility() != 8) {
                        LocalSongsFragment.this.h = ValueAnimator.ofFloat(1.0f, 0.0f);
                        LocalSongsFragment.this.h.setDuration(400L);
                        LocalSongsFragment.this.h.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.fotoable.youtube.music.ui.fragment.ap

                            /* renamed from: a  reason: collision with root package name */
                            private final LocalSongsFragment.AnonymousClass1 f4781a;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.f4781a = this;
                            }

                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                this.f4781a.a(valueAnimator);
                            }
                        });
                        LocalSongsFragment.this.h.addListener(new AnimatorListenerAdapter() { // from class: com.fotoable.youtube.music.ui.fragment.LocalSongsFragment.1.1
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                super.onAnimationEnd(animator);
                                if (!LocalSongsFragment.this.d()) {
                                    LocalSongsFragment.this.indexBar.setVisibility(4);
                                    LocalSongsFragment.this.viewBg.setVisibility(8);
                                }
                            }
                        });
                        LocalSongsFragment.this.h.start();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final /* synthetic */ void a(ValueAnimator valueAnimator) {
            if (!LocalSongsFragment.this.d()) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LocalSongsFragment.this.indexBar.setAlpha(floatValue);
                LocalSongsFragment.this.viewBg.setAlpha(floatValue);
            }
        }
    }

    @Override // com.fotoable.youtube.music.base.i
    public void a(View view, @Nullable Bundle bundle) {
        setHasOptionsMenu(true);
        l();
        k();
        q();
        com.fotoable.youtube.music.util.b.b("本地音乐--单曲页面展示次数");
    }

    private void l() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        IRecyclerView iRecyclerView = this.recycleView;
        com.foto.indexlib.a.b bVar = new com.foto.indexlib.a.b(getContext(), this.j);
        this.k = bVar;
        iRecyclerView.addItemDecoration(bVar);
        this.recycleView.setLayoutManager(linearLayoutManager);
        this.recycleView.setItemAnimator(new DefaultItemAnimator());
        this.g = new LocalSongAdapter(getContext(), getFragmentManager());
        this.g.setShowShuffle(true);
        this.recycleView.setIAdapter(this.g);
        this.f = (LoadMoreFooterView) this.recycleView.getLoadMoreFooterView();
        this.f.setVisibility(8);
        this.refreshLayout.setColorSchemeResources(17170459, 17170452, 17170456, 17170454);
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(this) { // from class: com.fotoable.youtube.music.ui.fragment.al

            /* renamed from: a  reason: collision with root package name */
            private final LocalSongsFragment f4777a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4777a = this;
            }

            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                this.f4777a.k();
            }
        });
        this.tvAgain.setOnClickListener(am.f4778a);
        this.k.a(2);
        this.indexBar.a(this.tvSideBarHint).a(true).a(1).a(linearLayoutManager);
        n();
        this.recycleView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.fotoable.youtube.music.ui.fragment.LocalSongsFragment.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (!TextUtils.equals(LocalSongsFragment.this.e, "title_key")) {
                    LocalSongsFragment.this.a((List<LocalSongBean>) null);
                } else if (LocalSongsFragment.this.p() && i == 0) {
                    LocalSongsFragment.this.i.removeMessages(1005);
                    LocalSongsFragment.this.i.sendEmptyMessageDelayed(1005, 2000L);
                }
            }
        });
        this.recycleView.setOnTouchListener(new View.OnTouchListener() { // from class: com.fotoable.youtube.music.ui.fragment.LocalSongsFragment.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    if (motionEvent.getAction() == 2) {
                        LocalSongsFragment.this.i.removeMessages(1005);
                        LocalSongsFragment.this.m();
                        return false;
                    } else if (motionEvent.getAction() == 1) {
                        LocalSongsFragment.this.i.sendEmptyMessageDelayed(1005, 2000L);
                        return false;
                    } else {
                        return false;
                    }
                }
                return false;
            }
        });
        this.indexBar.setOnTouchListener(new View.OnTouchListener() { // from class: com.fotoable.youtube.music.ui.fragment.LocalSongsFragment.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        LocalSongsFragment.this.l = true;
                        LocalSongsFragment.this.i.removeMessages(1005);
                        LocalSongsFragment.this.m();
                        break;
                    case 1:
                        LocalSongsFragment.this.l = false;
                        LocalSongsFragment.this.i.removeMessages(1005);
                        LocalSongsFragment.this.i.sendEmptyMessageDelayed(1005, 2000L);
                        break;
                }
                return false;
            }
        });
        this.k.a(new b.a() { // from class: com.fotoable.youtube.music.ui.fragment.LocalSongsFragment.5
            @Override // com.foto.indexlib.a.b.a
            public void a(String str) {
                if (LocalSongsFragment.this.indexBar != null && !LocalSongsFragment.this.l) {
                    LocalSongsFragment.this.indexBar.setCurrentIndex(str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(View view) {
        com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(AdError.MEDIATION_ERROR_CODE));
        com.fotoable.youtube.music.util.b.b("单曲页面--扫描本地歌曲");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.h != null) {
            this.h.cancel();
            this.h = null;
        }
        if (p() && this.indexBar.getVisibility() != 0) {
            this.indexBar.setVisibility(0);
            this.viewBg.setVisibility(0);
        }
        this.indexBar.setAlpha(1.0f);
        this.viewBg.setAlpha(1.0f);
    }

    private void n() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void k() {
        if (com.fotoable.youtube.music.util.l.a().a("android.permission.READ_EXTERNAL_STORAGE")) {
            r();
            a(com.fotoable.youtube.music.helper.localmusic.d.b(1).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<List<LocalSongBean>>() { // from class: com.fotoable.youtube.music.ui.fragment.LocalSongsFragment.6
                @Override // rx.g
                public void onCompleted() {
                    LocalSongsFragment.this.s();
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                    LocalSongsFragment.this.s();
                    LocalSongsFragment.this.t();
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(List<LocalSongBean> list) {
                    String str = null;
                    if (!LocalSongsFragment.this.d()) {
                        LocalSongsFragment.this.s();
                        LocalSongsFragment.this.e = com.fotoable.youtube.music.util.v.a(MusicApplication.c(), "song_sort_order", "title_key");
                        if (list == null || list.size() <= 0) {
                            if (LocalSongsFragment.this.g != null) {
                                LocalSongsFragment.this.g.setData(null);
                            }
                            LocalSongsFragment.this.a((List<LocalSongBean>) null);
                            com.fotoable.youtube.music.util.b.b("单曲页面--未扫描到扫描本地歌曲");
                            if (LocalSongsFragment.this.rlNoDataRl != null) {
                                LocalSongsFragment.this.rlNoDataRl.setVisibility(0);
                            }
                        } else {
                            if (!LocalSongsFragment.this.e.equals("title_key")) {
                                LocalSongsFragment.this.a((List<LocalSongBean>) null);
                            } else {
                                Collections.sort(list, new com.fotoable.youtube.music.helper.localmusic.k());
                                LocalSongsFragment.this.a(list);
                            }
                            if (LocalSongsFragment.this.g != null) {
                                LocalSongsFragment.this.g.setData(list);
                            }
                        }
                        if (list != null) {
                            int size = list.size();
                            if (size >= 0 && size <= 5) {
                                str = "0 - 5";
                            } else if (size >= 6 && size <= 10) {
                                str = "6 - 10";
                            } else if (size >= 11 && size <= 15) {
                                str = "11 - 15";
                            } else if (size >= 16 && size <= 20) {
                                str = "16 - 20";
                            } else if (size >= 21 && size <= 30) {
                                str = "21 - 30";
                            } else if (size >= 31 && size <= 40) {
                                str = "31 - 40";
                            } else if (size >= 41 && size <= 50) {
                                str = "41 - 50";
                            } else if (size >= 51 && size <= 100) {
                                str = "51 - 100";
                            } else if (size > 100) {
                                str = "100以上";
                            }
                            com.fotoable.youtube.music.util.b.b("本地-歌曲数量", "数量区间", "" + str);
                        }
                    }
                }
            }));
            return;
        }
        com.fotoable.youtube.music.util.l.a().a(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 0, new l.a() { // from class: com.fotoable.youtube.music.ui.fragment.LocalSongsFragment.7
            @Override // com.fotoable.youtube.music.util.l.a
            public void a() {
                LocalSongsFragment.this.k();
            }

            @Override // com.fotoable.youtube.music.util.l.a
            public void b() {
            }

            @Override // com.fotoable.youtube.music.util.l.a
            public void c() {
            }

            @Override // com.fotoable.youtube.music.util.l.a
            public void d() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p() {
        if (this.recycleView == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.recycleView.getChildCount(); i2++) {
            i += this.recycleView.getChildAt(i2).getMeasuredHeight();
        }
        return i > this.recycleView.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<LocalSongBean> list) {
        if (list != null) {
            if (this.indexBar != null) {
                NewIndexBar newIndexBar = this.indexBar;
                NewIndexBar.f2203a = this.d;
                this.indexBar.a(true);
                this.indexBar.setVisibility(4);
                this.viewBg.setVisibility(8);
            }
            ViewGroup.LayoutParams layoutParams = this.indexBar.getLayoutParams();
            layoutParams.height = -1;
            this.indexBar.setLayoutParams(layoutParams);
            this.k.a(list);
            for (LocalSongBean localSongBean : list) {
                localSongBean.setBaseIndexTag(localSongBean.sort);
            }
            this.indexBar.a(list).invalidate();
            layoutParams.height = this.indexBar.getMeasureHeight();
            this.indexBar.setLayoutParams(layoutParams);
            com.fotoable.youtube.music.util.h.a(f4645c, "xs: onMea设置的高度：" + layoutParams.height);
            ViewGroup.LayoutParams layoutParams2 = this.viewBg.getLayoutParams();
            layoutParams2.height = this.indexBar.getMeasureHeight();
            this.viewBg.setLayoutParams(layoutParams2);
            return;
        }
        this.k.a(this.j);
        if (this.indexBar != null) {
            this.indexBar.setVisibility(4);
        }
        if (this.viewBg != null) {
            this.viewBg.setVisibility(8);
        }
    }

    private void q() {
        a(com.fotoable.youtube.music.e.b.a().a(com.fotoable.youtube.music.e.a.class, new rx.c.b<com.fotoable.youtube.music.e.a>() { // from class: com.fotoable.youtube.music.ui.fragment.LocalSongsFragment.8
            @Override // rx.c.b
            /* renamed from: a */
            public void call(com.fotoable.youtube.music.e.a aVar) {
                switch (aVar.f2726a) {
                    case 3003:
                        com.fotoable.youtube.music.util.b.b("单曲页面--按时间排序");
                        if (aVar.d == 0) {
                            com.fotoable.youtube.music.util.v.b(MusicApplication.c(), "song_sort_order", "date_added DESC");
                            LocalSongsFragment.this.k();
                            return;
                        }
                        return;
                    case 3004:
                        com.fotoable.youtube.music.util.b.b("单曲页面--按歌名排序");
                        if (aVar.d == 0) {
                            com.fotoable.youtube.music.util.v.b(MusicApplication.c().getApplicationContext(), "song_sort_order", "title_key");
                            LocalSongsFragment.this.k();
                            return;
                        }
                        return;
                    case 3005:
                        if (aVar.d == 0) {
                            com.fotoable.youtube.music.util.v.b(MusicApplication.c().getApplicationContext(), "song_sort_order", "album");
                            LocalSongsFragment.this.k();
                            return;
                        }
                        return;
                    case 3006:
                        if (aVar.d == 0) {
                            com.fotoable.youtube.music.util.v.b(MusicApplication.c().getApplicationContext(), "song_sort_order", "artist");
                            LocalSongsFragment.this.k();
                            return;
                        }
                        return;
                    case 3010:
                        LocalSongsFragment.this.k();
                        return;
                    case 30011:
                        com.fotoable.youtube.music.util.v.b(MusicApplication.c().getApplicationContext(), "song_sort_order", "SONG_RECENT_PLAY");
                        LocalSongsFragment.this.k();
                        return;
                    default:
                        return;
                }
            }
        }));
    }

    private void r() {
        if (this.rlNoDataRl != null) {
            this.rlNoDataRl.setVisibility(8);
        }
        b(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        b(false);
    }

    private void b(boolean z) {
        if (this.refreshLayout != null && !d()) {
            if (z) {
                this.refreshLayout.post(new Runnable(this) { // from class: com.fotoable.youtube.music.ui.fragment.an

                    /* renamed from: a  reason: collision with root package name */
                    private final LocalSongsFragment f4779a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f4779a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.f4779a.j();
                    }
                });
            } else {
                new Handler().postDelayed(new Runnable(this) { // from class: com.fotoable.youtube.music.ui.fragment.ao

                    /* renamed from: a  reason: collision with root package name */
                    private final LocalSongsFragment f4780a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f4780a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.f4780a.i();
                    }
                }, 1000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void j() {
        if (!d()) {
            this.refreshLayout.setRefreshing(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void i() {
        if (this.refreshLayout != null) {
            this.refreshLayout.setRefreshing(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        this.llError.setVisibility(0);
        this.llError.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.fragment.LocalSongsFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LocalSongsFragment.this.k();
            }
        });
    }

    @Override // com.fotoable.youtube.music.base.i
    public void g() {
        e().a(this);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        try {
            this.i.removeMessages(1005);
            if (this.h != null && this.h.isRunning()) {
                try {
                    this.h.cancel();
                    this.h = null;
                } catch (Exception e) {
                    ThrowableExtension.printStackTrace(e);
                }
            }
            if (this.g != null) {
                this.g.destroy();
            }
        } catch (Exception e2) {
            ThrowableExtension.printStackTrace(e2);
        }
        super.onDestroy();
    }
}

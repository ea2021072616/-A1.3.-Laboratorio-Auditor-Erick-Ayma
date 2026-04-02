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
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.fotoable.youtube.music.ui.adapter.AlbumItemOffsetDecoration;
import com.fotoable.youtube.music.ui.adapter.holder.LocalAlbumAdapter;
import com.fotoable.youtube.music.ui.view.ISwipeRefreshLayout;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.fotoable.youtube.music.ui.view.LoadMoreFooterView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import rx.f;
/* loaded from: classes.dex */
public class LocalAlbumFragment extends com.fotoable.youtube.music.base.i {

    /* renamed from: b  reason: collision with root package name */
    private static final String f4590b = LocalAlbumFragment.class.getSimpleName();
    private LocalAlbumAdapter d;
    private String e;
    private LoadMoreFooterView f;
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

    /* renamed from: c  reason: collision with root package name */
    private String[] f4591c = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private List<LocalAlbumBean> g = new ArrayList();
    private Handler i = new Handler() { // from class: com.fotoable.youtube.music.ui.fragment.LocalAlbumFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1005:
                    if (!LocalAlbumFragment.this.d() && LocalAlbumFragment.this.indexBar.getVisibility() != 8) {
                        LocalAlbumFragment.this.h = ValueAnimator.ofFloat(1.0f, 0.0f);
                        LocalAlbumFragment.this.h.setDuration(400L);
                        LocalAlbumFragment.this.h.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.fotoable.youtube.music.ui.fragment.LocalAlbumFragment.1.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                if (!LocalAlbumFragment.this.d()) {
                                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                    LocalAlbumFragment.this.indexBar.setAlpha(floatValue);
                                    LocalAlbumFragment.this.viewBg.setAlpha(floatValue);
                                }
                            }
                        });
                        LocalAlbumFragment.this.h.addListener(new AnimatorListenerAdapter() { // from class: com.fotoable.youtube.music.ui.fragment.LocalAlbumFragment.1.2
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                super.onAnimationEnd(animator);
                                if (!LocalAlbumFragment.this.d()) {
                                    if (LocalAlbumFragment.this.indexBar != null) {
                                        LocalAlbumFragment.this.indexBar.setVisibility(4);
                                    }
                                    if (LocalAlbumFragment.this.viewBg != null) {
                                        LocalAlbumFragment.this.viewBg.setVisibility(8);
                                    }
                                }
                            }
                        });
                        LocalAlbumFragment.this.h.start();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private ArrayList<LocalAlbumBean> j = new ArrayList<>();
    private boolean l = false;

    @Override // com.fotoable.youtube.music.base.i
    public int a() {
        return R.layout.fragment_local;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Override // com.fotoable.youtube.music.base.i
    public void a(View view, @Nullable Bundle bundle) {
        setHasOptionsMenu(true);
        l();
        k();
        p();
        com.fotoable.youtube.music.util.b.b("本地音乐--专辑页面展示次数");
    }

    private void l() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        this.recycleView.setLayoutManager(gridLayoutManager);
        AlbumItemOffsetDecoration albumItemOffsetDecoration = new AlbumItemOffsetDecoration(com.fotoable.youtube.music.util.w.a(getActivity(), 16.0f), com.fotoable.youtube.music.util.w.a(getActivity(), 10.0f));
        IRecyclerView iRecyclerView = this.recycleView;
        com.foto.indexlib.a.b bVar = new com.foto.indexlib.a.b(getContext(), this.j);
        this.k = bVar;
        iRecyclerView.addItemDecoration(bVar);
        this.recycleView.addItemDecoration(albumItemOffsetDecoration);
        this.recycleView.setItemAnimator(new DefaultItemAnimator());
        this.d = new LocalAlbumAdapter(getContext());
        this.recycleView.setIAdapter(this.d);
        this.f = (LoadMoreFooterView) this.recycleView.getLoadMoreFooterView();
        this.f.setVisibility(8);
        this.refreshLayout.setColorSchemeResources(17170459, 17170452, 17170456, 17170454);
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(this) { // from class: com.fotoable.youtube.music.ui.fragment.n

            /* renamed from: a  reason: collision with root package name */
            private final LocalAlbumFragment f4837a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4837a = this;
            }

            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                this.f4837a.k();
            }
        });
        this.tvAgain.setOnClickListener(o.f4838a);
        this.k.a(2);
        this.indexBar.a(this.tvSideBarHint).a(true).a(2).a(gridLayoutManager);
        this.k.a(new b.a() { // from class: com.fotoable.youtube.music.ui.fragment.LocalAlbumFragment.2
            @Override // com.foto.indexlib.a.b.a
            public void a(String str) {
                if (LocalAlbumFragment.this.indexBar != null && !LocalAlbumFragment.this.l) {
                    LocalAlbumFragment.this.indexBar.setCurrentIndex(str);
                }
            }
        });
        this.indexBar.setOnTouchListener(new View.OnTouchListener() { // from class: com.fotoable.youtube.music.ui.fragment.LocalAlbumFragment.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        LocalAlbumFragment.this.l = true;
                        LocalAlbumFragment.this.i.removeMessages(1005);
                        LocalAlbumFragment.this.m();
                        break;
                    case 1:
                        LocalAlbumFragment.this.l = false;
                        LocalAlbumFragment.this.i.removeMessages(1005);
                        LocalAlbumFragment.this.i.sendEmptyMessageDelayed(1005, 2000L);
                        break;
                }
                return false;
            }
        });
        this.recycleView.setOnTouchListener(new View.OnTouchListener() { // from class: com.fotoable.youtube.music.ui.fragment.LocalAlbumFragment.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    if (motionEvent.getAction() == 2) {
                        LocalAlbumFragment.this.i.removeMessages(1005);
                        LocalAlbumFragment.this.m();
                        return false;
                    } else if (motionEvent.getAction() == 1) {
                        LocalAlbumFragment.this.i.sendEmptyMessageDelayed(1005, 2000L);
                        return false;
                    } else {
                        return false;
                    }
                }
                return false;
            }
        });
        this.recycleView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.fotoable.youtube.music.ui.fragment.LocalAlbumFragment.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (LocalAlbumFragment.this.o() && i == 0) {
                    LocalAlbumFragment.this.i.removeMessages(1005);
                    LocalAlbumFragment.this.i.sendEmptyMessageDelayed(1005, 2000L);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(View view) {
        com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(AdError.MEDIATION_ERROR_CODE));
        com.fotoable.youtube.music.util.b.b("专辑页面--扫描本地歌曲");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.h != null) {
            this.h.cancel();
            this.h = null;
        }
        if (o() && this.indexBar.getVisibility() != 0) {
            this.indexBar.setVisibility(0);
            this.viewBg.setVisibility(0);
        }
        this.indexBar.setAlpha(1.0f);
        this.viewBg.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void k() {
        if (com.fotoable.youtube.music.util.l.a().a("android.permission.READ_EXTERNAL_STORAGE")) {
            q();
            a(com.fotoable.youtube.music.helper.localmusic.d.c().c(new rx.c.e<List<LocalAlbumBean>, List<LocalAlbumBean>>() { // from class: com.fotoable.youtube.music.ui.fragment.LocalAlbumFragment.7
                @Override // rx.c.e
                public List<LocalAlbumBean> a(List<LocalAlbumBean> list) {
                    if (list != null) {
                        ArrayList arrayList = new ArrayList();
                        HashMap hashMap = new HashMap();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= list.size()) {
                                break;
                            }
                            LocalAlbumBean localAlbumBean = list.get(i2);
                            if (localAlbumBean != null && hashMap.get(localAlbumBean.getAlbum_name() + localAlbumBean.getAlbum_artist()) == null) {
                                hashMap.put(localAlbumBean.getAlbum_name() + localAlbumBean.getAlbum_artist(), true);
                                arrayList.add(localAlbumBean);
                            }
                            i = i2 + 1;
                        }
                        hashMap.clear();
                        if (list != null) {
                            list.clear();
                        }
                        return arrayList;
                    }
                    return list;
                }
            }).a((f.c<? super R, ? extends R>) com.fotoable.youtube.music.util.s.a()).b(new rx.l<List<LocalAlbumBean>>() { // from class: com.fotoable.youtube.music.ui.fragment.LocalAlbumFragment.6
                @Override // rx.g
                public void onCompleted() {
                    LocalAlbumFragment.this.r();
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                    LocalAlbumFragment.this.r();
                    LocalAlbumFragment.this.s();
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(List<LocalAlbumBean> list) {
                    if (!LocalAlbumFragment.this.d()) {
                        LocalAlbumFragment.this.r();
                        LocalAlbumFragment.this.e = com.fotoable.youtube.music.util.v.a(MusicApplication.c(), "album_sort_order", "album_key");
                        if (list == null || list.size() <= 0) {
                            if (LocalAlbumFragment.this.d != null) {
                                LocalAlbumFragment.this.d.setData(null);
                            }
                            com.fotoable.youtube.music.util.b.b("专辑页面--未扫描到扫描本地专辑");
                            if (LocalAlbumFragment.this.rlNoDataRl != null) {
                                LocalAlbumFragment.this.rlNoDataRl.setVisibility(0);
                            }
                            LocalAlbumFragment.this.a((List<LocalAlbumBean>) null);
                            return;
                        }
                        if (!LocalAlbumFragment.this.e.equals("album_key")) {
                            LocalAlbumFragment.this.a((List<LocalAlbumBean>) null);
                        } else {
                            Collections.sort(list, new com.fotoable.youtube.music.helper.localmusic.a());
                            LocalAlbumFragment.this.a(list);
                        }
                        if (LocalAlbumFragment.this.d != null) {
                            LocalAlbumFragment.this.d.setData(list);
                        }
                    }
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o() {
        if (this.recycleView == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < ((int) Math.ceil(this.recycleView.getChildCount() / 2.0d)); i2++) {
            i += this.recycleView.getChildAt(i2).getMeasuredHeight();
        }
        return i > this.recycleView.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<LocalAlbumBean> list) {
        if (list != null) {
            if (this.indexBar != null) {
                NewIndexBar newIndexBar = this.indexBar;
                NewIndexBar.f2203a = this.f4591c;
                this.indexBar.a(true);
            }
            this.k.a(list);
            for (LocalAlbumBean localAlbumBean : list) {
                localAlbumBean.setBaseIndexTag(localAlbumBean.album_sort);
            }
            this.indexBar.setVisibility(4);
            this.viewBg.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.indexBar.getLayoutParams();
            layoutParams.height = -1;
            this.indexBar.setLayoutParams(layoutParams);
            this.indexBar.a(list).invalidate();
            layoutParams.height = this.indexBar.getMeasureHeight();
            this.indexBar.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.viewBg.getLayoutParams();
            layoutParams2.height = this.indexBar.getMeasureHeight();
            this.viewBg.setLayoutParams(layoutParams2);
            return;
        }
        this.k.a(this.j);
        if (this.indexBar != null) {
            this.indexBar.setVisibility(4);
            this.viewBg.setVisibility(8);
        }
    }

    private void p() {
        a(com.fotoable.youtube.music.e.b.a().a(com.fotoable.youtube.music.e.a.class, new rx.c.b<com.fotoable.youtube.music.e.a>() { // from class: com.fotoable.youtube.music.ui.fragment.LocalAlbumFragment.8
            @Override // rx.c.b
            /* renamed from: a */
            public void call(com.fotoable.youtube.music.e.a aVar) {
                switch (aVar.f2726a) {
                    case 3005:
                        com.fotoable.youtube.music.util.b.b("专辑页面--按专辑名排序");
                        if (aVar.d == 2) {
                            com.fotoable.youtube.music.util.v.b(MusicApplication.c().getApplicationContext(), "album_sort_order", "album_key");
                            LocalAlbumFragment.this.k();
                            return;
                        }
                        return;
                    case 3006:
                    case 3008:
                    case 3009:
                    default:
                        return;
                    case 3007:
                        com.fotoable.youtube.music.util.b.b("专辑页面--按歌曲数量排序");
                        if (aVar.d == 2) {
                            com.fotoable.youtube.music.util.v.b(MusicApplication.c().getApplicationContext(), "album_sort_order", "numsongs DESC");
                            LocalAlbumFragment.this.k();
                            return;
                        }
                        return;
                    case 3010:
                        LocalAlbumFragment.this.k();
                        return;
                }
            }
        }));
    }

    private void q() {
        if (this.rlNoDataRl != null) {
            this.rlNoDataRl.setVisibility(8);
        }
        b(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        b(false);
    }

    private void b(boolean z) {
        if (this.refreshLayout != null && !d()) {
            if (z) {
                this.refreshLayout.post(new Runnable(this) { // from class: com.fotoable.youtube.music.ui.fragment.p

                    /* renamed from: a  reason: collision with root package name */
                    private final LocalAlbumFragment f4839a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f4839a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.f4839a.j();
                    }
                });
            } else {
                new Handler().postDelayed(new Runnable(this) { // from class: com.fotoable.youtube.music.ui.fragment.q

                    /* renamed from: a  reason: collision with root package name */
                    private final LocalAlbumFragment f4840a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f4840a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.f4840a.i();
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
    public void s() {
        this.llError.setVisibility(0);
        this.llError.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.fragment.LocalAlbumFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LocalAlbumFragment.this.k();
            }
        });
    }

    @Override // com.fotoable.youtube.music.base.i
    public void g() {
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.d != null) {
            this.d.destroy();
        }
        this.i.removeMessages(1005);
        if (this.h != null && this.h.isRunning()) {
            try {
                this.h.cancel();
                this.h = null;
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
        }
        super.onDestroy();
    }
}

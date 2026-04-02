package com.fotoable.youtube.music.ui.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
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
import com.fotoable.youtube.music.bean.ArtistsCoverModel;
import com.fotoable.youtube.music.bean.LocalAlbumBean;
import com.fotoable.youtube.music.bean.LocalArtistsBean;
import com.fotoable.youtube.music.ui.adapter.LocalArtistsAdapter;
import com.fotoable.youtube.music.ui.view.ISwipeRefreshLayout;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.fotoable.youtube.music.ui.view.LoadMoreFooterView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import rx.f;
/* loaded from: classes.dex */
public class LocalArtistsFragment extends com.fotoable.youtube.music.base.i {
    private static final String d = LocalArtistsFragment.class.getSimpleName();
    @Inject

    /* renamed from: b  reason: collision with root package name */
    com.fotoable.youtube.music.db.a f4604b;
    private LocalArtistsAdapter e;
    private String f;
    private LoadMoreFooterView g;
    private ValueAnimator i;
    @BindView(R.id.indexBar)
    NewIndexBar indexBar;
    private com.foto.indexlib.a.b l;
    @BindView(R.id.ll_error)
    LinearLayout llError;
    private HashMap<Long, String> n;
    @BindView(R.id.recycle_view)
    IRecyclerView recycleView;
    @BindView(R.id.refreshLayout)
    ISwipeRefreshLayout refreshLayout;
    @BindView(R.id.rl_nodata)
    RelativeLayout rlNodata;
    @BindView(R.id.tv_again)
    LaToTextView tvAgain;
    @BindView(R.id.tv_error)
    LaToTextView tvError;
    @BindView(R.id.tvSideBarHint)
    TextView tvSideBarHint;
    @BindView(R.id.view_bg)
    View viewBg;

    /* renamed from: c  reason: collision with root package name */
    private String[] f4605c = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};
    private List<LocalArtistsBean> h = new ArrayList();
    private Handler j = new Handler() { // from class: com.fotoable.youtube.music.ui.fragment.LocalArtistsFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1005:
                    if (!LocalArtistsFragment.this.d() && LocalArtistsFragment.this.m() && LocalArtistsFragment.this.indexBar.getVisibility() != 8) {
                        LocalArtistsFragment.this.i = ValueAnimator.ofFloat(1.0f, 0.0f);
                        LocalArtistsFragment.this.i.setDuration(400L);
                        LocalArtistsFragment.this.i.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.fotoable.youtube.music.ui.fragment.LocalArtistsFragment.1.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                if (!LocalArtistsFragment.this.d()) {
                                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                    LocalArtistsFragment.this.indexBar.setAlpha(floatValue);
                                    LocalArtistsFragment.this.viewBg.setAlpha(floatValue);
                                }
                            }
                        });
                        LocalArtistsFragment.this.i.addListener(new AnimatorListenerAdapter() { // from class: com.fotoable.youtube.music.ui.fragment.LocalArtistsFragment.1.2
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                super.onAnimationEnd(animator);
                                if (!LocalArtistsFragment.this.d()) {
                                    LocalArtistsFragment.this.indexBar.setVisibility(4);
                                    LocalArtistsFragment.this.viewBg.setVisibility(8);
                                }
                            }
                        });
                        LocalArtistsFragment.this.i.start();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private ArrayList<LocalAlbumBean> k = new ArrayList<>();
    private boolean m = false;

    @Override // com.fotoable.youtube.music.base.i
    public int a() {
        return R.layout.fragment_local;
    }

    @Override // com.fotoable.youtube.music.base.i
    public void a(View view, @Nullable Bundle bundle) {
        this.n = new HashMap<>();
        setHasOptionsMenu(true);
        n();
        k();
        q();
        com.fotoable.youtube.music.util.b.b("本地音乐--歌手页面展示次数");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m() {
        if (this.recycleView == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.recycleView.getChildCount(); i2++) {
            i += this.recycleView.getChildAt(i2).getMeasuredHeight();
        }
        return i > this.recycleView.getHeight();
    }

    private void n() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        IRecyclerView iRecyclerView = this.recycleView;
        com.foto.indexlib.a.b bVar = new com.foto.indexlib.a.b(getContext(), this.k);
        this.l = bVar;
        iRecyclerView.addItemDecoration(bVar);
        this.recycleView.setLayoutManager(linearLayoutManager);
        this.e = new LocalArtistsAdapter(getContext());
        this.recycleView.setIAdapter(this.e);
        this.recycleView.setHasFixedSize(true);
        ((SimpleItemAnimator) this.recycleView.getItemAnimator()).setSupportsChangeAnimations(false);
        this.g = (LoadMoreFooterView) this.recycleView.getLoadMoreFooterView();
        this.g.setVisibility(8);
        this.refreshLayout.setColorSchemeResources(17170459, 17170452, 17170456, 17170454);
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(this) { // from class: com.fotoable.youtube.music.ui.fragment.r

            /* renamed from: a  reason: collision with root package name */
            private final LocalArtistsFragment f4841a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4841a = this;
            }

            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                this.f4841a.k();
            }
        });
        this.tvAgain.setOnClickListener(s.f4842a);
        this.l.a(2);
        this.indexBar.a(this.tvSideBarHint).a(true).a(2).a(linearLayoutManager);
        this.l.a(new b.a() { // from class: com.fotoable.youtube.music.ui.fragment.LocalArtistsFragment.3
            @Override // com.foto.indexlib.a.b.a
            public void a(String str) {
                if (LocalArtistsFragment.this.indexBar != null && !LocalArtistsFragment.this.m) {
                    LocalArtistsFragment.this.indexBar.setCurrentIndex(str);
                }
            }
        });
        this.recycleView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.fotoable.youtube.music.ui.fragment.LocalArtistsFragment.4
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                if (!LocalArtistsFragment.this.m() || !LocalArtistsFragment.this.m) {
                }
            }
        });
        this.recycleView.setOnTouchListener(new View.OnTouchListener() { // from class: com.fotoable.youtube.music.ui.fragment.LocalArtistsFragment.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    if (motionEvent.getAction() == 2) {
                        LocalArtistsFragment.this.j.removeMessages(1005);
                        LocalArtistsFragment.this.o();
                        return false;
                    } else if (motionEvent.getAction() == 1) {
                        LocalArtistsFragment.this.j.sendEmptyMessageDelayed(1005, 2000L);
                        return false;
                    } else {
                        return false;
                    }
                }
                return false;
            }
        });
        this.recycleView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.fotoable.youtube.music.ui.fragment.LocalArtistsFragment.6
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (LocalArtistsFragment.this.m() && i == 0) {
                    LocalArtistsFragment.this.j.removeMessages(1005);
                    LocalArtistsFragment.this.j.sendEmptyMessageDelayed(1005, 2000L);
                }
            }
        });
        this.indexBar.setOnTouchListener(new View.OnTouchListener() { // from class: com.fotoable.youtube.music.ui.fragment.LocalArtistsFragment.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        LocalArtistsFragment.this.m = true;
                        LocalArtistsFragment.this.j.removeMessages(1005);
                        LocalArtistsFragment.this.o();
                        break;
                    case 1:
                        LocalArtistsFragment.this.m = false;
                        LocalArtistsFragment.this.j.removeMessages(1005);
                        LocalArtistsFragment.this.j.sendEmptyMessageDelayed(1005, 2000L);
                        break;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void b(View view) {
        com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(AdError.MEDIATION_ERROR_CODE));
        com.fotoable.youtube.music.util.b.b("歌手页面--扫描本地歌曲");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.i != null) {
            this.i.cancel();
            this.i = null;
        }
        if (m() && this.indexBar.getVisibility() != 0) {
            this.indexBar.setVisibility(0);
            this.viewBg.setVisibility(0);
        }
        this.indexBar.setAlpha(1.0f);
        this.viewBg.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void k() {
        if (com.fotoable.youtube.music.util.l.a().a("android.permission.READ_EXTERNAL_STORAGE")) {
            r();
            a(com.fotoable.youtube.music.helper.localmusic.d.b().b(new rx.c.e<List<LocalArtistsBean>, rx.f<List<LocalArtistsBean>>>() { // from class: com.fotoable.youtube.music.ui.fragment.LocalArtistsFragment.9
                @Override // rx.c.e
                public rx.f<List<LocalArtistsBean>> a(List<LocalArtistsBean> list) {
                    LocalArtistsBean localArtistsBean;
                    HashMap hashMap = null;
                    ArrayList arrayList = new ArrayList(list);
                    int i = 0;
                    ArrayList arrayList2 = null;
                    while (i < arrayList.size()) {
                        LocalArtistsBean localArtistsBean2 = (LocalArtistsBean) arrayList.get(i);
                        if (localArtistsBean2 != null && TextUtils.isEmpty(localArtistsBean2.artists_art) && !TextUtils.isEmpty(localArtistsBean2.artist_name)) {
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList();
                            }
                            HashMap hashMap2 = hashMap == null ? new HashMap() : hashMap;
                            arrayList2.add(localArtistsBean2.artist_name);
                            hashMap2.put(localArtistsBean2.artist_name, localArtistsBean2);
                            hashMap = hashMap2;
                        }
                        i++;
                        arrayList2 = arrayList2;
                    }
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        List<ArtistsCoverModel> d2 = LocalArtistsFragment.this.f4604b.d(arrayList2);
                        if (d2 != null && d2.size() > 0) {
                            for (int i2 = 0; i2 < d2.size(); i2++) {
                                ArtistsCoverModel artistsCoverModel = d2.get(i2);
                                if (artistsCoverModel != null && !TextUtils.isEmpty(artistsCoverModel.getArtistsName()) && !TextUtils.isEmpty(artistsCoverModel.getCoverImg()) && (localArtistsBean = (LocalArtistsBean) hashMap.get(artistsCoverModel.getArtistsName())) != null) {
                                    localArtistsBean.artists_art = artistsCoverModel.getCoverImg();
                                }
                            }
                            com.fotoable.youtube.music.util.h.a(LocalArtistsFragment.d, "歌手头像使用数据库缓存个数：" + d2.size());
                            d2.clear();
                        }
                        arrayList2.clear();
                        hashMap.clear();
                    }
                    return rx.f.a(arrayList);
                }
            }).a((f.c<? super R, ? extends R>) com.fotoable.youtube.music.util.s.a()).b(new rx.l<List<LocalArtistsBean>>() { // from class: com.fotoable.youtube.music.ui.fragment.LocalArtistsFragment.8
                @Override // rx.g
                public void onCompleted() {
                    LocalArtistsFragment.this.s();
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                    LocalArtistsFragment.this.s();
                    LocalArtistsFragment.this.t();
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(List<LocalArtistsBean> list) {
                    int i = 0;
                    if (!LocalArtistsFragment.this.d()) {
                        LocalArtistsFragment.this.s();
                        LocalArtistsFragment.this.f = "artist_key";
                        if (list == null || list.size() <= 0) {
                            if (LocalArtistsFragment.this.e != null) {
                                LocalArtistsFragment.this.e.setData(null);
                            }
                            LocalArtistsFragment.this.a((List<LocalArtistsBean>) null);
                            com.fotoable.youtube.music.util.b.b("歌手页面--未扫描到扫描本地歌手");
                            if (LocalArtistsFragment.this.rlNodata != null) {
                                LocalArtistsFragment.this.rlNodata.setVisibility(0);
                                return;
                            }
                            return;
                        }
                        if (!LocalArtistsFragment.this.f.equals("artist_key")) {
                            if (LocalArtistsFragment.this.f.equals("number_of_tracks DESC")) {
                                Collections.sort(list, new com.fotoable.youtube.music.helper.localmusic.c());
                            }
                            LocalArtistsFragment.this.a((List<LocalArtistsBean>) null);
                            com.fotoable.youtube.music.util.h.a(LocalArtistsFragment.d, "ARTIST_NUMBER_OF_SONGS:" + LocalArtistsFragment.this.f);
                        } else {
                            Collections.sort(list, new com.fotoable.youtube.music.helper.localmusic.b());
                            LocalArtistsFragment.this.a(list);
                            com.fotoable.youtube.music.util.h.a(LocalArtistsFragment.d, "ARTIST_A_Z");
                        }
                        if (LocalArtistsFragment.this.e != null) {
                            ArrayList arrayList = new ArrayList();
                            HashMap hashMap = new HashMap();
                            while (true) {
                                int i2 = i;
                                if (i2 >= list.size()) {
                                    LocalArtistsFragment.this.a(arrayList);
                                    hashMap.clear();
                                    LocalArtistsFragment.this.e.setData(arrayList);
                                    return;
                                }
                                if (hashMap.get(list.get(i2).artist_name) == null) {
                                    hashMap.put(list.get(i2).artist_name, true);
                                    arrayList.add(list.get(i2));
                                    if (TextUtils.isEmpty(list.get(i2).artists_art)) {
                                        String str = (String) LocalArtistsFragment.this.n.get(Long.valueOf(list.get(i2).artist_id));
                                        if (!TextUtils.isEmpty(str)) {
                                            list.get(i2).artists_art = str;
                                        } else if (!com.fotoable.youtube.music.a.z()) {
                                            LocalArtistsFragment.this.a(list.get(i2).artist_id, list.get(i2).artist_name);
                                        } else if (com.fotoable.youtube.music.util.w.g(MusicApplication.c())) {
                                            LocalArtistsFragment.this.a(list.get(i2).artist_id, list.get(i2).artist_name);
                                        }
                                    }
                                }
                                i = i2 + 1;
                            }
                        }
                    }
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<LocalArtistsBean> list) {
        if (list != null) {
            if (this.indexBar != null) {
                NewIndexBar newIndexBar = this.indexBar;
                NewIndexBar.f2203a = this.f4605c;
                this.indexBar.a(true);
                this.indexBar.setVisibility(4);
                this.viewBg.setVisibility(8);
            }
            this.l.a(list);
            for (LocalArtistsBean localArtistsBean : list) {
                localArtistsBean.setBaseIndexTag(localArtistsBean.artist_sort);
            }
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
        this.l.a((List<? extends com.foto.indexlib.a.a>) null);
        if (this.indexBar != null) {
            this.indexBar.setVisibility(4);
            this.viewBg.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final String str) {
        if (this.n == null) {
            this.n = new HashMap<>();
        }
        com.fotoable.youtube.music.b.c.a.a().a(new com.fotoable.youtube.music.b.c.b.b(str), new com.fotoable.youtube.music.b.c.a.a() { // from class: com.fotoable.youtube.music.ui.fragment.LocalArtistsFragment.10
            @Override // com.fotoable.youtube.music.b.c.a.a
            public void a(com.fotoable.youtube.music.b.c.b.d dVar) {
                String str2;
                if (!LocalArtistsFragment.this.d() && dVar != null && dVar.f2299a != null && LocalArtistsFragment.this.e != null && dVar.f2299a.size() > 0) {
                    if (dVar.f2299a.size() >= 3) {
                        str2 = dVar.f2299a.get(2).f2298a;
                    } else {
                        str2 = dVar.f2299a.get(dVar.f2299a.size() - 1).f2298a;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        LocalArtistsFragment.this.e.notifyCover(j, str2);
                        LocalArtistsFragment.this.n.put(Long.valueOf(j), str2);
                        LocalArtistsFragment.this.a(str, str2);
                    }
                }
            }

            @Override // com.fotoable.youtube.music.b.c.a.a
            public void a() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, String str2) {
        if (this.f4604b != null) {
            ArtistsCoverModel artistsCoverModel = new ArtistsCoverModel();
            artistsCoverModel.setArtistsName(str);
            artistsCoverModel.setCoverImg(str2);
            artistsCoverModel.setModifyTime(Long.valueOf(System.currentTimeMillis()));
            a(this.f4604b.a(artistsCoverModel).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.ui.fragment.LocalArtistsFragment.2
                @Override // rx.g
                public void onCompleted() {
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(Boolean bool) {
                    com.fotoable.youtube.music.util.h.a(LocalArtistsFragment.d, "添加歌手封面成功," + str);
                }
            }));
        }
    }

    private void q() {
        a(com.fotoable.youtube.music.e.b.a().a(com.fotoable.youtube.music.e.a.class, new rx.c.b(this) { // from class: com.fotoable.youtube.music.ui.fragment.t

            /* renamed from: a  reason: collision with root package name */
            private final LocalArtistsFragment f4843a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4843a = this;
            }

            @Override // rx.c.b
            public void call(Object obj) {
                this.f4843a.b((com.fotoable.youtube.music.e.a) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b(com.fotoable.youtube.music.e.a aVar) {
        switch (aVar.f2726a) {
            case 3006:
                com.fotoable.youtube.music.util.b.b("歌手页面--按歌手名排序");
                if (aVar.d == 1) {
                    com.fotoable.youtube.music.util.v.b(MusicApplication.c().getApplicationContext(), "artists_sort_order", "artist_key");
                    k();
                    return;
                }
                return;
            case 3007:
                com.fotoable.youtube.music.util.b.b("歌手页面--按歌曲数量排序");
                if (aVar.d == 1) {
                    com.fotoable.youtube.music.util.v.b(MusicApplication.c().getApplicationContext(), "artists_sort_order", "number_of_tracks DESC");
                    k();
                    return;
                }
                return;
            case 3008:
            case 3009:
            default:
                return;
            case 3010:
                k();
                return;
        }
    }

    private void r() {
        if (this.rlNodata != null) {
            this.rlNodata.setVisibility(8);
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
                this.refreshLayout.post(new Runnable(this) { // from class: com.fotoable.youtube.music.ui.fragment.u

                    /* renamed from: a  reason: collision with root package name */
                    private final LocalArtistsFragment f4844a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f4844a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.f4844a.j();
                    }
                });
            } else {
                new Handler().postDelayed(new Runnable(this) { // from class: com.fotoable.youtube.music.ui.fragment.v

                    /* renamed from: a  reason: collision with root package name */
                    private final LocalArtistsFragment f4845a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f4845a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.f4845a.i();
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
        if (!d() && this.refreshLayout != null) {
            this.refreshLayout.setRefreshing(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.llError != null) {
            this.llError.setVisibility(0);
            this.llError.setOnClickListener(new View.OnClickListener(this) { // from class: com.fotoable.youtube.music.ui.fragment.w

                /* renamed from: a  reason: collision with root package name */
                private final LocalArtistsFragment f4846a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f4846a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f4846a.a(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(View view) {
        k();
    }

    @Override // com.fotoable.youtube.music.base.i
    public void g() {
        e().a(this);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        try {
            this.j.removeMessages(1005);
            if (this.i != null && this.i.isRunning()) {
                try {
                    this.i.cancel();
                    this.i = null;
                } catch (Exception e) {
                    ThrowableExtension.printStackTrace(e);
                }
            }
            if (this.e != null) {
                this.e.destroy();
            }
        } catch (Exception e2) {
            ThrowableExtension.printStackTrace(e2);
        }
        super.onDestroy();
    }
}

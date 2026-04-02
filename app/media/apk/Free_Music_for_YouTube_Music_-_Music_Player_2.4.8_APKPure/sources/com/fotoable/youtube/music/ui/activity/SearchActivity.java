package com.fotoable.youtube.music.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.flyco.tablayout.SlidingTabLayout;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.bean.HotKeyBean;
import com.fotoable.youtube.music.d.a.p;
import com.fotoable.youtube.music.ui.adapter.SearchFragmentPagerAdapter;
import com.fotoable.youtube.music.ui.adapter.SearchHistoryAdapter;
import com.fotoable.youtube.music.ui.adapter.SuggestAdapter;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
/* loaded from: classes.dex */
public class SearchActivity extends BaseActivity implements p.a {

    /* renamed from: a  reason: collision with root package name */
    com.fotoable.youtube.music.d.ar f3760a;
    @Inject

    /* renamed from: b  reason: collision with root package name */
    com.fotoable.youtube.music.b.c f3761b;
    @Inject

    /* renamed from: c  reason: collision with root package name */
    com.fotoable.youtube.music.b.a f3762c;
    @Inject
    com.fotoable.youtube.music.b.e d;
    private TagFlowLayout e;
    private TextView f;
    private View g;
    private View h;
    private View i;
    private SuggestAdapter j;
    private TagAdapter<HotKeyBean> k;
    private SearchHistoryAdapter l;
    private boolean m;
    @BindView(R.id.search_suggest_list_view)
    ListView mSuggestListView;
    private boolean n = false;
    private View.OnClickListener o = new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.SearchActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.search_artists_view /* 2131821213 */:
                    SearchActivity.this.startActivity(new Intent(SearchActivity.this, ArtistsActivity.class));
                    com.fotoable.youtube.music.util.b.b("QuickNav-Charts");
                    return;
                case R.id.search_genres_view /* 2131821214 */:
                    SearchActivity.this.startActivity(new Intent(SearchActivity.this, ChartsActivity.class));
                    com.fotoable.youtube.music.util.b.b("QuickNav-Genres");
                    return;
                default:
                    return;
            }
        }
    };
    private TextView.OnEditorActionListener p = new TextView.OnEditorActionListener() { // from class: com.fotoable.youtube.music.ui.activity.SearchActivity.5
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == 3) {
                SearchActivity.this.b(SearchActivity.this.searchEdit.getText().toString());
                return false;
            }
            return false;
        }
    };
    private TextWatcher q = new TextWatcher() { // from class: com.fotoable.youtube.music.ui.activity.SearchActivity.6
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    SearchActivity.this.searchDeleteImg.setVisibility(8);
                    SearchActivity.this.mSuggestListView.setVisibility(8);
                    if (SearchActivity.this.searchHistoryListView.getVisibility() == 8) {
                        SearchActivity.this.searchHistoryListView.setVisibility(0);
                        SearchActivity.this.shadowView.setVisibility(0);
                    }
                } else {
                    SearchActivity.this.searchDeleteImg.setVisibility(0);
                    if (SearchActivity.this.m) {
                        SearchActivity.this.m = false;
                    } else {
                        SearchActivity.this.f3760a.c(editable.toString());
                    }
                }
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
        }
    };
    @BindView(R.id.search_cancel_tx)
    TextView searchCancelTx;
    @BindView(R.id.search_delete_img)
    ImageView searchDeleteImg;
    @BindView(R.id.search_edit)
    EditText searchEdit;
    @BindView(R.id.search_history_list_view)
    ListView searchHistoryListView;
    @BindView(R.id.search_result_view)
    LinearLayout searchResultView;
    @BindView(R.id.search_tab_layout)
    SlidingTabLayout searchTabLayout;
    @BindView(R.id.search_view_pager)
    ViewPager searchViewPager;
    @BindView(R.id.search_history_title_shadow_view)
    View shadowView;

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return false;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.activity_search;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        if (getIntent() != null && getIntent().hasExtra("isSelectedMusic")) {
            this.n = getIntent().getBooleanExtra("isSelectedMusic", false);
        }
        d();
        s();
        u();
        t();
        v();
        com.fotoable.youtube.music.util.h.a(this.d.toString());
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
        i().a(this);
    }

    private void s() {
        this.f3760a = new com.fotoable.youtube.music.d.ar(this, this.f3761b, this.f3762c);
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void c() {
        com.fotoable.youtube.music.newplayer.e.a().a(this, 2404);
    }

    private void t() {
        this.searchEdit.setOnEditorActionListener(this.p);
        this.searchEdit.addTextChangedListener(this.q);
    }

    private void u() {
        if (this.n) {
            this.searchTabLayout.setVisibility(8);
        }
        SearchFragmentPagerAdapter searchFragmentPagerAdapter = new SearchFragmentPagerAdapter(getSupportFragmentManager(), this);
        searchFragmentPagerAdapter.setSelectedMusic(this.n);
        this.searchViewPager.setAdapter(searchFragmentPagerAdapter);
        this.searchTabLayout.setViewPager(this.searchViewPager);
    }

    private void v() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.include_search_header, (ViewGroup) null);
        this.g = LayoutInflater.from(this).inflate(R.layout.include_search_footer, (ViewGroup) null);
        this.e = (TagFlowLayout) inflate.findViewById(R.id.search_header_flow_layout);
        this.f = (TextView) inflate.findViewById(R.id.search_header_history_tx);
        this.h = inflate.findViewById(R.id.search_artists_view);
        this.i = inflate.findViewById(R.id.search_genres_view);
        this.i.setOnClickListener(this.o);
        this.h.setOnClickListener(this.o);
        this.l = new SearchHistoryAdapter(this);
        this.searchHistoryListView.addHeaderView(inflate);
        this.searchHistoryListView.addFooterView(this.g);
        this.searchHistoryListView.setAdapter((ListAdapter) this.l);
        this.f3760a.a();
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.SearchActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchActivity.this.r();
                SearchActivity.this.g.setVisibility(8);
                SearchActivity.this.f.setVisibility(8);
            }
        });
    }

    @Override // com.fotoable.youtube.music.d.a.p.a
    public void a(List<HotKeyBean> list) {
        this.k = new TagAdapter<HotKeyBean>(list) { // from class: com.fotoable.youtube.music.ui.activity.SearchActivity.2
            @Override // com.zhy.view.flowlayout.TagAdapter
            /* renamed from: a */
            public View getView(FlowLayout flowLayout, int i, final HotKeyBean hotKeyBean) {
                TextView textView = (TextView) LayoutInflater.from(SearchActivity.this).inflate(R.layout.tag_layout, (ViewGroup) SearchActivity.this.e, false);
                textView.setText(hotKeyBean.getKeyword());
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.SearchActivity.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SearchActivity.this.b(hotKeyBean.getKeyword());
                    }
                });
                return textView;
            }
        };
        this.e.setAdapter(this.k);
        this.k.setSelectedList(0);
        w();
    }

    @Override // com.fotoable.youtube.music.d.a.p.a
    public void b(List<String> list) {
        if (this.mSuggestListView.getVisibility() == 8) {
            this.mSuggestListView.setVisibility(0);
        }
        if (this.j == null) {
            this.j = new SuggestAdapter(this, list);
            this.mSuggestListView.setAdapter((ListAdapter) this.j);
            return;
        }
        this.j.refresh(list);
    }

    private void w() {
        List<String> b2 = this.f3760a.b();
        if (b2 == null || b2.size() == 0) {
            this.f.setVisibility(8);
        } else {
            this.f.setVisibility(0);
            this.g.setVisibility(0);
        }
        this.l.refresh(b2);
    }

    public boolean a(String str) {
        if (this.l.getCount() == 0) {
            this.f.setVisibility(8);
            this.g.setVisibility(8);
        }
        return this.f3760a.b(str);
    }

    public boolean r() {
        this.l.clearAll();
        this.f3760a.c();
        return true;
    }

    public void b(String str) {
        com.fotoable.youtube.music.util.b.b("Search-Done");
        this.mSuggestListView.setVisibility(8);
        this.m = true;
        hideSoft(this.searchEdit);
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.equals(str, this.searchEdit.getText().toString())) {
                this.searchEdit.setText(str);
                this.searchEdit.setSelection(str.length());
            }
            this.f3760a.a(str);
            com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(100, str));
            a(rx.f.b(50L, TimeUnit.MILLISECONDS).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Long>() { // from class: com.fotoable.youtube.music.ui.activity.SearchActivity.3
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
                    if (SearchActivity.this.searchHistoryListView.getVisibility() == 0) {
                        SearchActivity.this.searchHistoryListView.setVisibility(8);
                        SearchActivity.this.shadowView.setVisibility(8);
                    }
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f3760a.d();
        com.fotoable.youtube.music.util.b.b("Search-Cancel");
    }

    @OnClick({R.id.search_cancel_tx, R.id.search_delete_img})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.search_delete_img /* 2131820903 */:
                this.searchEdit.setText("");
                return;
            case R.id.search_cancel_tx /* 2131820904 */:
                finish();
                return;
            default:
                return;
        }
    }
}

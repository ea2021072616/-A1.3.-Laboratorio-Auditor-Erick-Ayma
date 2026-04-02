package com.fotoable.youtube.music.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.OnClick;
import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.OnLoadMoreListener;
import com.facebook.appevents.UserDataStore;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.bean.Meta;
import com.fotoable.youtube.music.bean.RadioBean;
import com.fotoable.youtube.music.bean.RadioCountryBean;
import com.fotoable.youtube.music.d.a.n;
import com.fotoable.youtube.music.ui.adapter.RadioAdapter;
import com.fotoable.youtube.music.ui.view.ISwipeRefreshLayout;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.fotoable.youtube.music.ui.view.LoadMoreFooterView;
import java.util.List;
import javax.inject.Inject;
/* loaded from: classes.dex */
public class RadioListActivity extends BaseActivity implements n.a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3749a = RadioListActivity.class.getSimpleName();
    @Inject

    /* renamed from: b  reason: collision with root package name */
    com.fotoable.youtube.music.b.c f3750b;
    @BindView(R.id.country_img)
    ImageView countryImg;
    @BindView(R.id.country_name_tx)
    LaToTextView countryNameTx;
    @BindView(R.id.country_select_view)
    LinearLayout countrySelectView;
    private com.fotoable.youtube.music.d.ao d;
    private int e;
    private String g;
    private LoadMoreFooterView h;
    private boolean i;
    @BindView(R.id.img_back)
    ImageView imgBack;
    private boolean j;
    private RadioAdapter k;
    @BindView(R.id.recycle_view)
    IRecyclerView recycleView;
    @BindView(R.id.refreshLayout)
    ISwipeRefreshLayout refreshLayout;
    @BindView(R.id.title_tx)
    LaToTextView titleTx;

    /* renamed from: c  reason: collision with root package name */
    private int f3751c = -1;
    private int f = 20;
    private OnLoadMoreListener l = new OnLoadMoreListener() { // from class: com.fotoable.youtube.music.ui.activity.RadioListActivity.1
        @Override // com.aspsine.irecyclerview.OnLoadMoreListener
        public void onLoadMore() {
            if (RadioListActivity.this.j) {
                if (!RadioListActivity.this.i) {
                    RadioListActivity.this.i = true;
                    RadioListActivity.this.h.setStatus(LoadMoreFooterView.Status.LOADING);
                    if (RadioListActivity.this.f3751c == 0) {
                        RadioListActivity.this.d.a(RadioListActivity.this.e, RadioListActivity.this.f, RadioListActivity.this.g);
                        return;
                    } else {
                        RadioListActivity.this.d.a(RadioListActivity.this.e, RadioListActivity.this.f);
                        return;
                    }
                }
                return;
            }
            RadioListActivity.this.h.setStatus(LoadMoreFooterView.Status.THE_END);
        }
    };

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return true;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.activity_radio_list;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        this.d = new com.fotoable.youtube.music.d.ao(this.f3750b, this);
        this.g = com.fotoable.youtube.music.util.v.a(MusicApplication.c(), "country_code", "GB");
        u();
        t();
        s();
        d();
        com.fotoable.youtube.music.util.b.b("电台-全部电台页面展示");
        com.fotoable.youtube.music.util.b.a("电台-全部电台页面展示");
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
        i().a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.d.a();
    }

    private void s() {
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        this.f3751c = intent.getIntExtra("extra_type_key", -1);
        if (this.f3751c < 0) {
            finish();
            return;
        }
        String stringExtra = intent.getStringExtra("extra_country_code_key");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.g = stringExtra;
        }
        if (this.f3751c == 0) {
            this.titleTx.setText(R.string.all_radios);
            this.d.a(this.e, this.f, this.g);
            this.countrySelectView.setVisibility(0);
        }
        if (this.f3751c == 1) {
            this.titleTx.setText(R.string.hot_radios);
            this.d.a(this.e, this.f);
            this.countrySelectView.setVisibility(8);
        }
    }

    private void t() {
        this.recycleView.setLayoutManager(new LinearLayoutManager(this));
        this.k = new RadioAdapter(this, getSupportFragmentManager());
        this.recycleView.setIAdapter(this.k);
        this.recycleView.setOnLoadMoreListener(this.l);
        this.h = (LoadMoreFooterView) this.recycleView.getLoadMoreFooterView();
    }

    private void u() {
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(this) { // from class: com.fotoable.youtube.music.ui.activity.bd

            /* renamed from: a  reason: collision with root package name */
            private final RadioListActivity f3970a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f3970a = this;
            }

            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                this.f3970a.r();
            }
        });
        this.refreshLayout.setColorSchemeResources(17170459, 17170452, 17170456, 17170454);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void r() {
        this.e = 0;
        if (this.f3751c == 0) {
            this.d.a(this.e, this.f, this.g);
        } else {
            this.d.a(this.e, this.f);
        }
        this.i = true;
    }

    @Override // com.fotoable.youtube.music.d.a.n.a
    public void a(List<RadioBean> list, boolean z) {
        if (list != null && list.size() > 0) {
            this.j = true;
            if (z) {
                this.k.refresh(list);
            } else {
                this.k.addData(list);
            }
            this.e += this.f;
        } else {
            this.j = false;
            this.h.setStatus(LoadMoreFooterView.Status.THE_END);
        }
        this.i = false;
        this.refreshLayout.setRefreshing(false);
    }

    @Override // com.fotoable.youtube.music.d.a.n.a
    public void a(Meta meta) {
        com.bumptech.glide.i.a((FragmentActivity) this).a(meta.getFlagUrl()).d((int) R.mipmap.icon_country_default).a(this.countryImg);
        this.g = meta.getCountryCode();
        this.countryNameTx.setText(meta.getCountry());
    }

    @OnClick({R.id.img_back, R.id.country_select_view})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back /* 2131820756 */:
                finish();
                return;
            case R.id.country_select_view /* 2131820896 */:
                startActivityForResult(new Intent(this, CountryActivity.class), 100);
                com.fotoable.youtube.music.util.b.b("电台-国家选择-按钮");
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.fotoable.youtube.music.util.h.a(f3749a, "====" + i);
        if (i2 == -1 && i == 100) {
            RadioCountryBean radioCountryBean = (RadioCountryBean) intent.getSerializableExtra(UserDataStore.COUNTRY);
            com.bumptech.glide.i.a((FragmentActivity) this).a(radioCountryBean.getFlagUrl()).d((int) R.mipmap.icon_country_default).a(this.countryImg);
            this.g = radioCountryBean.getCountryCode();
            this.countryNameTx.setText(radioCountryBean.getCountry());
            this.k.clearData();
            this.h.setStatus(LoadMoreFooterView.Status.LOADING);
            this.e = 0;
            this.i = false;
            if (this.f3751c == 0) {
                this.d.a(this.e, this.f, this.g);
            } else {
                this.d.a(this.e, this.f);
            }
        }
    }
}

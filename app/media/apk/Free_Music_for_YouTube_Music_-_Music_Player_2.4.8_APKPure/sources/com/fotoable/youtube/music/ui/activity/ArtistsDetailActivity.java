package com.fotoable.youtube.music.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.facebook.share.internal.ShareConstants;
import com.flyco.tablayout.SlidingTabLayout;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.ui.adapter.ArtistDetailFragmentPagerAdapter;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.fotoable.youtube.music.ui.view.RoundImageView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class ArtistsDetailActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private String f3184a;
    @BindView(R.id.app_barLayout)
    AppBarLayout appBarLayout;

    /* renamed from: b  reason: collision with root package name */
    private String f3185b;

    /* renamed from: c  reason: collision with root package name */
    private String f3186c;
    private int d;
    @BindView(R.id.empty_bottom_bar)
    View empty_bottom_bar;
    @BindView(R.id.iv_LoadingPic)
    RoundImageView imgIcon;
    @BindView(R.id.img_mask)
    ImageView imgMask;
    @BindView(R.id.main_backdrop)
    ImageView mainBg;
    @BindView(R.id.rl_details)
    RelativeLayout rlDetails;
    @BindView(R.id.search_tab_layout)
    SlidingTabLayout searchTabLayout;
    @BindView(R.id.search_view_pager)
    ViewPager searchViewPager;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.txt_desc)
    LaToTextView txtDesc;
    @BindView(R.id.txt_title)
    LaToTextView txtTitle;

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return true;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.activity_artists_detail;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        d();
        r();
        s();
        t();
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(int i) {
        super.a(i);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.empty_bottom_bar.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-1, i);
        } else {
            layoutParams.height = i;
        }
        this.empty_bottom_bar.setLayoutParams(layoutParams);
    }

    private void r() {
        this.searchViewPager.setAdapter(new ArtistDetailFragmentPagerAdapter(getSupportFragmentManager(), this, 2));
        this.searchTabLayout.setViewPager(this.searchViewPager);
    }

    private void s() {
        final int i = -com.fotoable.youtube.music.util.w.a(this, 80.0f);
        this.appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener(this, i) { // from class: com.fotoable.youtube.music.ui.activity.a

            /* renamed from: a  reason: collision with root package name */
            private final ArtistsDetailActivity f3911a;

            /* renamed from: b  reason: collision with root package name */
            private final int f3912b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f3911a = this;
                this.f3912b = i;
            }

            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
                this.f3911a.a(this.f3912b, appBarLayout, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(int i, AppBarLayout appBarLayout, int i2) {
        float f = ((i2 * 1.0f) / i) * 1.0f;
        if (!p()) {
            this.rlDetails.setAlpha(1.0f - f);
            this.tvTitle.setAlpha(f);
        }
    }

    private void t() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f3184a = extras.getString("ImgURL");
            this.f3185b = extras.getString(ShareConstants.TITLE);
            this.f3186c = extras.getString("DESC");
            this.d = extras.getInt("ARTISTID");
            com.fotoable.youtube.music.helper.d.a(this, this.f3184a, this.imgIcon);
            com.fotoable.youtube.music.helper.d.b(this, this.f3184a, this.mainBg);
            this.txtTitle.setText(TextUtils.isEmpty(this.f3185b) ? "" : this.f3185b);
            this.tvTitle.setText(TextUtils.isEmpty(this.f3185b) ? "" : this.f3185b);
            this.txtDesc.setText(TextUtils.isEmpty(this.f3186c) ? "" : this.f3186c);
            if (TextUtils.isEmpty(this.f3184a)) {
                this.imgMask.setVisibility(8);
            } else {
                this.imgMask.setVisibility(0);
            }
            a(rx.f.b(500L, TimeUnit.MILLISECONDS).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Long>() { // from class: com.fotoable.youtube.music.ui.activity.ArtistsDetailActivity.1
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
                    com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(100, ArtistsDetailActivity.this.f3185b));
                }
            }));
        }
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
        i().a(this);
    }

    @OnClick({R.id.img_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back /* 2131820756 */:
                finish();
                return;
            default:
                return;
        }
    }
}

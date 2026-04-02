package com.fotoable.youtube.music.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import butterknife.BindView;
import butterknife.OnClick;
import com.facebook.share.internal.ShareConstants;
import com.flyco.tablayout.SlidingTabLayout;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.ui.adapter.ArtistDetailFragmentPagerAdapter;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class GenresDetailActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private String f3335a;

    /* renamed from: b  reason: collision with root package name */
    private String f3336b;

    /* renamed from: c  reason: collision with root package name */
    private String f3337c;
    @BindView(R.id.search_tab_layout)
    SlidingTabLayout searchTabLayout;
    @BindView(R.id.search_view_pager)
    ViewPager searchViewPager;
    @BindView(R.id.txt_title)
    LaToTextView txtTitle;

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return true;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.activity_genres_detail;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        d();
        r();
        s();
    }

    private void r() {
        this.searchViewPager.setAdapter(new ArtistDetailFragmentPagerAdapter(getSupportFragmentManager(), this, 3));
        this.searchTabLayout.setViewPager(this.searchViewPager);
    }

    private void s() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f3335a = extras.getString("SeachKey");
            this.f3336b = extras.getString(ShareConstants.TITLE);
            this.f3337c = extras.getString("genres");
            this.txtTitle.setText(TextUtils.isEmpty(this.f3336b) ? "" : this.f3336b);
            a(rx.f.b(500L, TimeUnit.MILLISECONDS).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Long>() { // from class: com.fotoable.youtube.music.ui.activity.GenresDetailActivity.1
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
                    com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(100, GenresDetailActivity.this.f3335a, GenresDetailActivity.this.f3337c));
                }
            }));
        }
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
        i().a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @OnClick({R.id.back_view})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_view /* 2131820733 */:
                finish();
                return;
            default:
                return;
        }
    }
}

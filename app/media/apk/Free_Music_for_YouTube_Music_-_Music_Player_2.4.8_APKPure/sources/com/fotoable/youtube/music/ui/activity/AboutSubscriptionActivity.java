package com.fotoable.youtube.music.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.OnClick;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.base.BaseActivity;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* loaded from: classes.dex */
public class AboutSubscriptionActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private WebView f3175a;
    @BindView(R.id.rl_container)
    RelativeLayout rl_container;

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return false;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.activity_about_subscription;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        this.f3175a = new WebView(MusicApplication.c());
        r();
        this.rl_container.addView(this.f3175a, new RelativeLayout.LayoutParams(-1, -1));
        this.f3175a.loadUrl("file:///android_asset/subscription/ballSubscription.html");
        com.fotoable.youtube.music.util.b.b("关于订阅界面-展示次数");
    }

    private void r() {
        try {
            if (this.f3175a != null && !this.f3175a.isInEditMode()) {
                if (Build.VERSION.SDK_INT >= 19) {
                    this.f3175a.setLayerType(2, null);
                } else {
                    this.f3175a.setLayerType(1, null);
                }
                WebSettings settings = this.f3175a.getSettings();
                settings.setJavaScriptEnabled(true);
                settings.setJavaScriptCanOpenWindowsAutomatically(true);
                settings.setDomStorageEnabled(true);
                settings.setAppCacheEnabled(true);
                settings.setAppCachePath(getDir("cache", 0).getPath());
                settings.setCacheMode(-1);
                settings.setAppCacheMaxSize(10485760L);
                settings.setAllowFileAccess(true);
                settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
                settings.setDatabaseEnabled(true);
                String path = getDir("database", 0).getPath();
                settings.setDatabasePath(path);
                settings.setGeolocationEnabled(true);
                settings.setGeolocationDatabasePath(path);
                settings.setBuiltInZoomControls(false);
                settings.setSupportZoom(false);
                settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
                settings.setUseWideViewPort(true);
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.iv_close})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_close /* 2131820744 */:
                finish();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        try {
            if (this.f3175a != null) {
                this.f3175a.onResume();
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        try {
            if (this.f3175a != null) {
                this.f3175a.onPause();
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.f3175a != null) {
                this.rl_container.removeView(this.f3175a);
                this.rl_container.removeAllViews();
                this.f3175a.destroy();
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }
}

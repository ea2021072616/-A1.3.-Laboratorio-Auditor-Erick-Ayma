package com.fotoable.youtube.music.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.service.NotificationService;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
/* loaded from: classes.dex */
public class SplashActivity extends BaseActivity {

    /* renamed from: b  reason: collision with root package name */
    private static final String f3834b = SplashActivity.class.getSimpleName();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    com.fotoable.youtube.music.b.c f3835a;

    /* renamed from: c  reason: collision with root package name */
    private rx.m f3836c;
    private String d;

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return false;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.activity_splash;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        try {
            if (getIntent() != null) {
                Intent intent = getIntent();
                if (intent.hasExtra(ShareConstants.FEED_SOURCE_PARAM)) {
                    this.d = intent.getStringExtra(ShareConstants.FEED_SOURCE_PARAM);
                }
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
        r();
        com.fotoable.youtube.music.util.b.b("Dev_闪屏开始");
        if (TextUtils.isEmpty(com.fotoable.youtube.music.util.v.a(MusicApplication.c(), "country_code", (String) null))) {
            com.fotoable.youtube.music.util.v.b(MusicApplication.c(), "country_code", Locale.getDefault().getCountry());
            com.fotoable.youtube.music.util.v.b((Context) MusicApplication.c(), "country_code_is_local", true);
            com.fotoable.youtube.music.util.h.a(f3834b, "使用本地国际码初始化");
        }
        this.f3835a.f();
        this.f3835a.q();
        this.f3836c = rx.f.b(1L, TimeUnit.SECONDS).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Long>() { // from class: com.fotoable.youtube.music.ui.activity.SplashActivity.1
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                if (th != null) {
                    ThrowableExtension.printStackTrace(th);
                }
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(Long l) {
                Intent intent2 = new Intent(SplashActivity.this, MainActivity.class);
                if (!TextUtils.isEmpty(SplashActivity.this.d)) {
                    intent2.putExtra(ShareConstants.FEED_SOURCE_PARAM, "" + SplashActivity.this.d);
                } else {
                    intent2.putExtra(ShareConstants.FEED_SOURCE_PARAM, "splash");
                }
                SplashActivity.this.startActivity(intent2);
                SplashActivity.this.finish();
                SplashActivity.this.overridePendingTransition(R.anim.alpha_in, R.anim.alpha_out);
                com.fotoable.youtube.music.util.b.b("Dev_闪屏跳转到主界面");
            }
        });
        a(this.f3836c);
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void b() {
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        com.fotoable.youtube.music.util.b.b("Dev_闪屏点击返回键退出");
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
        i().a(this);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        com.fotoable.youtube.music.util.b.b("Dev_闪屏结束");
    }

    private void r() {
        try {
            Intent intent = new Intent(this, NotificationService.class);
            intent.setAction("action_open_app");
            startService(intent);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }
}

package com.fotoable.youtube.music.ui.activity;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.OnClick;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.CustomEvent;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.bean.MyHttpResponse;
import com.fotoable.youtube.music.bean.Radio1Bean;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import rx.f;
/* loaded from: classes.dex */
public class Radio1Activity extends BaseActivity {

    /* renamed from: b  reason: collision with root package name */
    private static final String f3721b = Radio1Activity.class.getSimpleName();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    com.fotoable.youtube.music.b.c f3722a;
    @BindView(R.id.back_view)
    ImageView backView;

    /* renamed from: c  reason: collision with root package name */
    private long f3723c;
    private WebViewClient d = new WebViewClient() { // from class: com.fotoable.youtube.music.ui.activity.Radio1Activity.4
        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            Radio1Activity.this.loadView.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            com.fotoable.youtube.music.util.h.a(Radio1Activity.f3721b, "页面加载完成");
            Radio1Activity.this.a(rx.f.b(200L, TimeUnit.MILLISECONDS).a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<Long>() { // from class: com.fotoable.youtube.music.ui.activity.Radio1Activity.4.1
                @Override // rx.g
                public void onCompleted() {
                }

                @Override // rx.g
                public void onError(Throwable th) {
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(Long l) {
                    Radio1Activity.this.u();
                }
            }));
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return false;
        }
    };
    @BindView(R.id.loading_view)
    View loadView;
    @BindView(R.id.webView)
    WebView webView;

    static /* synthetic */ long b(Radio1Activity radio1Activity) {
        long j = radio1Activity.f3723c;
        radio1Activity.f3723c = 1 + j;
        return j;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return true;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.activity1_radio;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        s();
        t();
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
        i().a(this);
    }

    private void s() {
        WebSettings settings = this.webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(2);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        if (Build.VERSION.SDK_INT >= 17) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        this.webView.setWebViewClient(this.d);
        this.webView.setWebChromeClient(new WebChromeClient());
    }

    private void t() {
        final String a2 = com.fotoable.youtube.music.util.v.a(MusicApplication.c(), "country_code", "GB");
        this.f3722a.k().a(com.fotoable.youtube.music.util.s.a()).b(new rx.c.e<MyHttpResponse<List<Radio1Bean>>, rx.f<String>>() { // from class: com.fotoable.youtube.music.ui.activity.Radio1Activity.2
            @Override // rx.c.e
            public rx.f<String> a(final MyHttpResponse<List<Radio1Bean>> myHttpResponse) {
                return rx.f.a((f.a) new f.a<String>() { // from class: com.fotoable.youtube.music.ui.activity.Radio1Activity.2.1
                    @Override // rx.c.b
                    /* renamed from: a */
                    public void call(rx.l<? super String> lVar) {
                        String str = "http://www.internetradiouk.com/";
                        if (myHttpResponse != null) {
                            for (Radio1Bean radio1Bean : (List) myHttpResponse.getData()) {
                                str = (!TextUtils.equals(a2, radio1Bean.getCountryCode()) || lVar == null || lVar.isUnsubscribed()) ? str : radio1Bean.getUrl();
                            }
                            lVar.onNext(str);
                            com.fotoable.youtube.music.util.h.a(Radio1Activity.f3721b, "countryCode:" + a2 + "    url:" + str);
                            lVar.onCompleted();
                        }
                    }
                });
            }
        }).a((rx.g) new rx.g<String>() { // from class: com.fotoable.youtube.music.ui.activity.Radio1Activity.1
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(String str) {
                Radio1Activity.this.webView.loadUrl(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.webView.evaluateJavascript("document.getElementsByTagName(\"strong\")[0].style.color=\"#35515d\";", null);
            this.webView.evaluateJavascript("document.getElementsByTagName(\"span\")[0].style.color=\"#35515d\";", null);
            this.webView.evaluateJavascript("document.querySelector('div.ad.margin').style.display=\"none\";", null);
            this.webView.evaluateJavascript("document.querySelector('div.right').style.display=\"none\";", null);
            this.webView.evaluateJavascript("document.getElementsByTagName('body')[0].style.background=\"#f7f7f7\";", null);
            this.webView.evaluateJavascript("var ampAdList = document.querySelectorAll(\"amp-ad\");\nfor(var i=0;i<ampAdList.length;i++){\n  var amp = ampAdList[i];\n  amp.style.display=\"none\";\n\n}", null);
            this.webView.evaluateJavascript("var ampAdList = document.querySelectorAll(\"amp-user-notification\");\nfor(var i=0;i<ampAdList.length;i++){\n  var amp = ampAdList[i];\n  amp.style.display=\"none\";\n\n}", null);
        } else {
            this.webView.loadUrl("javascript:document.getElementsByTagName(\"strong\")[0].style.color=\"#35515d\";document.getElementsByTagName(\"span\")[0].style.color=\"#35515d\";document.querySelector('div.right').style.display=\"none\";document.querySelector('div.ad.margin').style.display=\"none\";document.getElementsByTagName('body')[0].style.background=\"#f7f7f7\";");
            this.webView.loadUrl("javascript:var ampAdList = document.querySelectorAll(\"amp-user-notification\");\nfor(var i=0;i<ampAdList.length;i++){\n  var amp = ampAdList[i];\n  amp.style.display=\"none\";\n\n}");
            this.webView.loadUrl("javascript:var ampAdList = document.querySelectorAll(\"amp-ad\");\nfor(var i=0;i<ampAdList.length;i++){\n  var amp = ampAdList[i];\n  amp.style.display=\"none\";\n\n}");
        }
        a(rx.f.b(1500L, TimeUnit.MILLISECONDS).a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<Long>() { // from class: com.fotoable.youtube.music.ui.activity.Radio1Activity.3
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(Long l) {
                Radio1Activity.this.loadView.setVisibility(8);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        com.fotoable.youtube.music.util.h.a(f3721b, "页面加载开始");
        a(rx.f.a(1L, TimeUnit.SECONDS).a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<Long>() { // from class: com.fotoable.youtube.music.ui.activity.Radio1Activity.5
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(Long l) {
                Radio1Activity.b(Radio1Activity.this);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        try {
            this.webView.destroy();
            this.webView = null;
            if (b.a.a.a.c.j()) {
                String country = Locale.getDefault().getCountry();
                CustomEvent customEvent = new CustomEvent("Dev_radio");
                customEvent.putCustomAttribute("time", this.f3723c + "秒");
                customEvent.putCustomAttribute("countryCode", country);
                Answers.getInstance().logCustom(customEvent);
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
        super.onDestroy();
    }

    @OnClick({R.id.back_view, R.id.refresh_img})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_view /* 2131820733 */:
                finish();
                return;
            case R.id.refresh_img /* 2131820734 */:
                t();
                return;
            default:
                return;
        }
    }
}

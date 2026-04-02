package com.facebook.ads.internal.view;

import android.content.Context;
import android.net.http.SslError;
import android.util.Log;
import android.view.MotionEvent;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.internal.j.a;
import com.facebook.ads.internal.util.af;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c extends com.facebook.ads.internal.view.b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1604a = c.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final b f1605b;

    /* renamed from: c  reason: collision with root package name */
    private af f1606c;
    private com.facebook.ads.internal.j.a d;

    /* loaded from: classes.dex */
    public class a {

        /* renamed from: b  reason: collision with root package name */
        private final String f1612b = a.class.getSimpleName();

        public a() {
        }

        @JavascriptInterface
        public void alert(String str) {
            Log.e(this.f1612b, str);
        }

        @JavascriptInterface
        public String getAnalogInfo() {
            return com.facebook.ads.internal.util.g.a(com.facebook.ads.internal.util.a.a());
        }

        @JavascriptInterface
        public void onPageInitialized() {
            if (c.this.c()) {
                return;
            }
            c.this.f1605b.a();
            if (c.this.d != null) {
                c.this.d.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();

        void a(int i);

        void a(String str, Map<String, String> map);

        void b();
    }

    public c(Context context, final b bVar, int i) {
        super(context);
        this.f1605b = bVar;
        getSettings().setSupportZoom(false);
        addJavascriptInterface(new a(), "AdControl");
        this.f1606c = new af();
        this.d = new com.facebook.ads.internal.j.a(this, i, new a.AbstractC0038a() { // from class: com.facebook.ads.internal.view.c.1
            @Override // com.facebook.ads.internal.j.a.AbstractC0038a
            public void a() {
                c.this.f1606c.a();
                bVar.b();
            }
        });
    }

    @Override // com.facebook.ads.internal.view.b
    protected WebChromeClient a() {
        return new WebChromeClient() { // from class: com.facebook.ads.internal.view.c.2
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                return true;
            }
        };
    }

    public void a(int i, int i2) {
        this.d.a(i);
        this.d.b(i2);
    }

    @Override // com.facebook.ads.internal.view.b
    protected WebViewClient b() {
        return new WebViewClient() { // from class: com.facebook.ads.internal.view.c.3
            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                sslErrorHandler.cancel();
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                HashMap hashMap = new HashMap();
                c.this.d.a(hashMap);
                hashMap.put("touch", com.facebook.ads.internal.util.g.a(c.this.getTouchData()));
                c.this.f1605b.a(str, hashMap);
                return true;
            }
        };
    }

    @Override // com.facebook.ads.internal.view.b, android.webkit.WebView
    public void destroy() {
        if (this.d != null) {
            this.d.b();
            this.d = null;
        }
        com.facebook.ads.internal.util.h.a(this);
        super.destroy();
    }

    public Map<String, String> getTouchData() {
        return this.f1606c.e();
    }

    public com.facebook.ads.internal.j.a getViewabilityChecker() {
        return this.d;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f1606c.a(motionEvent, this, this);
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.f1605b != null) {
            this.f1605b.a(i);
        }
        if (this.d != null) {
            if (i == 0) {
                this.d.a();
            } else if (i == 8) {
                this.d.b();
            }
        }
    }
}

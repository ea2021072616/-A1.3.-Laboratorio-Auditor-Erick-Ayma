package ru.zdevs.zugate.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import com.github.appintro.AppIntroBaseFragmentKt;
import com.github.appintro.R;
import d.b;
import d.q;
/* loaded from: classes.dex */
public class WebViewActivity extends q {
    @Override // androidx.fragment.app.d0, androidx.activity.ComponentActivity, w.o, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_web_view);
        b supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.m(true);
        }
        setTitle(getIntent().getStringExtra(AppIntroBaseFragmentKt.ARG_TITLE));
        WebView webView = (WebView) findViewById(R.id.wv);
        webView.loadUrl(getIntent().getStringExtra("url"));
        if (getIntent().getBooleanExtra("nwrap", false)) {
            webView.getSettings().setUseWideViewPort(true);
        }
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        return false;
    }
}

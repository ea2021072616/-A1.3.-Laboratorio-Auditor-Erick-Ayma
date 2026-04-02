package com.fotoable.youtube.music.ui.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.http.SslError;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.AudienceNetworkActivity;
import com.fotoable.youtube.music.a;
import com.fotoable.youtube.music.util.b;
import com.fotoable.youtube.music.util.h;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class YoutubePlayerView extends WebView {
    private static final int HTML_LOADING_FINISH = 3;
    private static final int HTML_LOADING_LOADING = 2;
    private static final int HTML_LOADING_NONE = 1;
    private static final String TAG = YoutubePlayerView.class.getSimpleName();
    private int height;
    private int htmlLoadingState;
    private boolean isDestroy;
    private boolean isHd;
    private OnPlayerListener onPlayerListener;
    private String videoId;
    private int width;

    /* loaded from: classes.dex */
    public interface OnPlayerListener {
        void isPreKitKat(boolean z);

        void onCurrentTimeChanged(long j, long j2);

        void onLoadFailed();

        void onPlayerError(int i);

        void onPlayerReady();

        void onPlayerStateChanged(int i);

        void onVideoTotalTime(long j);
    }

    public YoutubePlayerView(Context context) {
        super(context);
        this.htmlLoadingState = 1;
        this.isHd = false;
        this.isDestroy = false;
    }

    public YoutubePlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.htmlLoadingState = 1;
        this.isHd = false;
        this.isDestroy = false;
    }

    public void setAutoPlayerHeight(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        getLayoutParams().height = (int) (displayMetrics.widthPixels * 0.5625d);
    }

    public void setPlaySize(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    @SuppressLint({"JavascriptInterface"})
    public void initialize(String str) {
        if (!isInEditMode()) {
            this.videoId = str;
            WebSettings settings = getSettings();
            try {
                if (Build.VERSION.SDK_INT >= 17) {
                    settings.setMediaPlaybackRequiresUserGesture(false);
                }
                settings.setDomStorageEnabled(true);
                settings.setJavaScriptEnabled(true);
                settings.setUseWideViewPort(true);
                settings.setLoadWithOverviewMode(true);
                settings.setSupportZoom(false);
                settings.setBuiltInZoomControls(false);
                settings.setDisplayZoomControls(false);
                settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
                settings.setCacheMode(-1);
                settings.setAppCachePath(getContext().getCacheDir().getAbsolutePath() + "/" + getContext().getPackageName());
                settings.setDatabasePath(getContext().getCacheDir().getAbsolutePath() + "/" + getContext().getPackageName());
                settings.setDatabaseEnabled(true);
                settings.setAppCacheEnabled(true);
                settings.setPluginState(WebSettings.PluginState.ON);
                if (Build.VERSION.SDK_INT >= 21) {
                    settings.setMixedContentMode(0);
                }
                settings.setAllowContentAccess(true);
                settings.setAllowFileAccess(true);
                setLongClickable(true);
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
            try {
                setLayerType(2, null);
            } catch (Exception e2) {
                ThrowableExtension.printStackTrace(e2);
            }
            addJavascriptInterface(new PlayerJavaInterface(), "PlayerJavaInterface");
            setOnLongClickListener(new View.OnLongClickListener() { // from class: com.fotoable.youtube.music.ui.view.YoutubePlayerView.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return true;
                }
            });
            setWebViewClient(new WebViewClient() { // from class: com.fotoable.youtube.music.ui.view.YoutubePlayerView.2
                private boolean isReceivedError = false;
                private long startTime;

                @Override // android.webkit.WebViewClient
                public void onLoadResource(WebView webView, String str2) {
                    super.onLoadResource(webView, str2);
                }

                @Override // android.webkit.WebViewClient
                public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                    super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                    h.a(YoutubePlayerView.TAG, "onReceivedHttpError");
                }

                @Override // android.webkit.WebViewClient
                public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                    super.onReceivedSslError(webView, sslErrorHandler, sslError);
                    h.a(YoutubePlayerView.TAG, "onReceivedSslError");
                }

                @Override // android.webkit.WebViewClient
                public void onReceivedError(WebView webView, int i, String str2, String str3) {
                    super.onReceivedError(webView, i, str2, str3);
                    h.a("WebPlayer", "onReceivedError1,url:" + str3);
                    this.isReceivedError = true;
                }

                @Override // android.webkit.WebViewClient
                public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                    super.onReceivedError(webView, webResourceRequest, webResourceError);
                    if (Build.VERSION.SDK_INT >= 21) {
                        h.a("WebPlayer", "onReceivedError2,url:" + webResourceRequest.getUrl().toString() + "," + webResourceError.toString());
                    }
                    this.isReceivedError = true;
                }

                @Override // android.webkit.WebViewClient
                public void onPageStarted(WebView webView, String str2, Bitmap bitmap) {
                    super.onPageStarted(webView, str2, bitmap);
                    h.a("WebPlayer", "onPageStarted");
                    this.startTime = System.currentTimeMillis();
                }

                @Override // android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str2) {
                    h.a("WebPlayer", "网页加载结束isReceivedError:" + this.isReceivedError + ",time:" + (System.currentTimeMillis() - this.startTime) + "ms");
                    if (this.isReceivedError && YoutubePlayerView.this.onPlayerListener != null) {
                        this.isReceivedError = false;
                        YoutubePlayerView.this.post(new Runnable() { // from class: com.fotoable.youtube.music.ui.view.YoutubePlayerView.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (YoutubePlayerView.this.onPlayerListener != null) {
                                    YoutubePlayerView.this.onPlayerListener.onLoadFailed();
                                }
                            }
                        });
                    }
                    YoutubePlayerView.this.htmlLoadingState = 3;
                }
            });
            setWebChromeClient(new WebChromeClient() { // from class: com.fotoable.youtube.music.ui.view.YoutubePlayerView.3
                @Override // android.webkit.WebChromeClient
                public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                    h.a("WebPlayer", "onConsoleMessage:" + consoleMessage.message());
                    return super.onConsoleMessage(consoleMessage);
                }

                @Override // android.webkit.WebChromeClient
                public Bitmap getDefaultVideoPoster() {
                    Bitmap defaultVideoPoster;
                    try {
                        h.a(YoutubePlayerView.TAG, "getDefaultVideoPoster...");
                        if (YoutubePlayerView.this.width > 0 && YoutubePlayerView.this.height > 0) {
                            Bitmap createBitmap = Bitmap.createBitmap(YoutubePlayerView.this.width, YoutubePlayerView.this.height, Bitmap.Config.RGB_565);
                            Canvas canvas = new Canvas(createBitmap);
                            Paint paint = new Paint();
                            paint.setColor(ViewCompat.MEASURED_STATE_MASK);
                            canvas.drawRect(0.0f, 0.0f, YoutubePlayerView.this.width, YoutubePlayerView.this.height, paint);
                            defaultVideoPoster = createBitmap;
                        } else {
                            defaultVideoPoster = super.getDefaultVideoPoster();
                        }
                        return defaultVideoPoster;
                    } catch (Exception e3) {
                        ThrowableExtension.printStackTrace(e3);
                        return super.getDefaultVideoPoster();
                    }
                }
            });
            ytLoad();
        }
    }

    public void ytLoad() {
        if (this.htmlLoadingState == 2) {
            h.a(TAG, "正在加载播放界面，无需再次加载...");
            return;
        }
        this.htmlLoadingState = 2;
        h.a(TAG, "ytLoad 重新加载网页");
        loadDataWithBaseURL("https://cdn-freemusic.fotoable.net/", getVideoHTML(this.videoId), AudienceNetworkActivity.WEBVIEW_MIME_TYPE, AudienceNetworkActivity.WEBVIEW_ENCODING, null);
    }

    private String getVideoHTML(String str) {
        try {
            InputStream open = getResources().getAssets().open("stream_html.data");
            if (open != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open, AudienceNetworkActivity.WEBVIEW_ENCODING));
                StringBuilder sb = new StringBuilder("");
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine + "\n");
                    } else {
                        open.close();
                        return sb.toString();
                    }
                }
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
        return "";
    }

    public void onCueVideo(final String str) {
        this.videoId = str;
        Log.d(TAG, "onCueVideo : " + str);
        post(new Runnable() { // from class: com.fotoable.youtube.music.ui.view.YoutubePlayerView.4
            @Override // java.lang.Runnable
            public void run() {
                if (YoutubePlayerView.this.isDestroy) {
                    h.a(YoutubePlayerView.TAG, "播放器销毁咯onCueVideo");
                    return;
                }
                YoutubePlayerView.this.loadUrl("javascript:stopVideo()");
                YoutubePlayerView.this.loadUrl("javascript:loadVideo('" + str + "')");
                YoutubePlayerView.this.loadUrl("javascript:playVideo()");
            }
        });
    }

    public boolean isHd() {
        return this.isHd;
    }

    public void setQuality(int i, boolean z) {
        this.isHd = z;
        Log.d(TAG, "setQuality : " + i + "  " + z);
        loadUrl("javascript:setQuality(" + i + "," + z + ")");
    }

    public void play() {
        Log.d(TAG, "play");
        post(new Runnable() { // from class: com.fotoable.youtube.music.ui.view.YoutubePlayerView.5
            @Override // java.lang.Runnable
            public void run() {
                YoutubePlayerView.this.loadUrl("javascript:playVideo()");
            }
        });
    }

    public void seekTo(final long j) {
        Log.d(TAG, "play");
        post(new Runnable() { // from class: com.fotoable.youtube.music.ui.view.YoutubePlayerView.6
            @Override // java.lang.Runnable
            public void run() {
                YoutubePlayerView.this.loadUrl("javascript:onSeekTo(" + j + ")");
            }
        });
    }

    public void stop() {
        Log.d(TAG, "stop");
        if (!this.isDestroy) {
            post(new Runnable() { // from class: com.fotoable.youtube.music.ui.view.YoutubePlayerView.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (!YoutubePlayerView.this.isDestroy) {
                            YoutubePlayerView.this.loadUrl("javascript:releasePlayer()");
                        }
                    } catch (Exception e) {
                        ThrowableExtension.printStackTrace(e);
                    }
                }
            });
        }
    }

    public void pause() {
        post(new Runnable() { // from class: com.fotoable.youtube.music.ui.view.YoutubePlayerView.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    YoutubePlayerView.this.loadUrl("javascript:pauseVideo()");
                } catch (Exception e) {
                    ThrowableExtension.printStackTrace(e);
                }
            }
        });
    }

    public void setOnPlayerListener(OnPlayerListener onPlayerListener) {
        this.onPlayerListener = onPlayerListener;
    }

    public String getVideoId() {
        return this.videoId;
    }

    /* loaded from: classes.dex */
    class PlayerJavaInterface {
        PlayerJavaInterface() {
        }

        @JavascriptInterface
        public void onPlayerError(final int i) {
            h.a(YoutubePlayerView.TAG, "onPlayerError");
            if (!TextUtils.isEmpty(YoutubePlayerView.this.videoId)) {
                h.a(YoutubePlayerView.TAG, "id长度：" + YoutubePlayerView.this.videoId.length());
                b.b("Dev_播放失败", "失败原因", "onPlayerError:" + i);
                b.b("Dev_播放失败详细信息", "详细信息", "Error:" + i + ",视频ID:" + YoutubePlayerView.this.videoId + ",国家码:" + a.b());
                b.b("Dev_Youtube播放失败(按国家)", "错误码" + i + "(国家)", "" + a.b());
            }
            if (YoutubePlayerView.this.onPlayerListener != null) {
                YoutubePlayerView.this.post(new Runnable() { // from class: com.fotoable.youtube.music.ui.view.YoutubePlayerView.PlayerJavaInterface.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (YoutubePlayerView.this.onPlayerListener != null) {
                                if (!TextUtils.isEmpty(YoutubePlayerView.this.videoId)) {
                                    YoutubePlayerView.this.onPlayerListener.onPlayerError(i);
                                } else {
                                    YoutubePlayerView.this.onPlayerListener.onPlayerReady();
                                }
                            }
                        } catch (Exception e) {
                            ThrowableExtension.printStackTrace(e);
                        }
                    }
                });
            }
        }

        @JavascriptInterface
        public boolean isPreKitKat() {
            h.a(YoutubePlayerView.TAG, "isPreKitKat");
            final boolean z = Build.VERSION.SDK_INT < 19;
            if (YoutubePlayerView.this.onPlayerListener != null) {
                YoutubePlayerView.this.post(new Runnable() { // from class: com.fotoable.youtube.music.ui.view.YoutubePlayerView.PlayerJavaInterface.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (YoutubePlayerView.this.onPlayerListener != null) {
                                YoutubePlayerView.this.onPlayerListener.isPreKitKat(z);
                            }
                        } catch (Exception e) {
                            ThrowableExtension.printStackTrace(e);
                        }
                    }
                });
            }
            return z;
        }

        @JavascriptInterface
        public void onVideoTotalTime(final long j) {
            h.a(YoutubePlayerView.TAG, "onVideoTotalTime:" + j);
            if (YoutubePlayerView.this.onPlayerListener != null) {
                YoutubePlayerView.this.post(new Runnable() { // from class: com.fotoable.youtube.music.ui.view.YoutubePlayerView.PlayerJavaInterface.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (YoutubePlayerView.this.onPlayerListener != null) {
                                YoutubePlayerView.this.onPlayerListener.onVideoTotalTime(j);
                            }
                        } catch (Exception e) {
                            ThrowableExtension.printStackTrace(e);
                        }
                    }
                });
            }
        }

        @JavascriptInterface
        public void onCurrentTimeChanged(final long j, final long j2) {
            if (j % 10 == 1) {
                h.a(YoutubePlayerView.TAG, "onCurrentTimeChanged:" + j + "  " + j2);
            }
            if (YoutubePlayerView.this.onPlayerListener != null) {
                YoutubePlayerView.this.post(new Runnable() { // from class: com.fotoable.youtube.music.ui.view.YoutubePlayerView.PlayerJavaInterface.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (YoutubePlayerView.this.onPlayerListener != null) {
                                YoutubePlayerView.this.onPlayerListener.onCurrentTimeChanged(j, j2);
                            }
                        } catch (Exception e) {
                            ThrowableExtension.printStackTrace(e);
                        }
                    }
                });
            }
        }

        @JavascriptInterface
        public void onPlayerReady() {
            h.a(YoutubePlayerView.TAG, "onPlayerReady");
            if (YoutubePlayerView.this.onPlayerListener != null) {
                YoutubePlayerView.this.post(new Runnable() { // from class: com.fotoable.youtube.music.ui.view.YoutubePlayerView.PlayerJavaInterface.5
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (YoutubePlayerView.this.onPlayerListener != null) {
                                YoutubePlayerView.this.onPlayerListener.onPlayerReady();
                            }
                        } catch (Exception e) {
                            ThrowableExtension.printStackTrace(e);
                        }
                    }
                });
            }
        }

        @JavascriptInterface
        public void onPlayerStateChanged(final int i) {
            if (YoutubePlayerView.this.onPlayerListener != null) {
                YoutubePlayerView.this.post(new Runnable() { // from class: com.fotoable.youtube.music.ui.view.YoutubePlayerView.PlayerJavaInterface.6
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (YoutubePlayerView.this.onPlayerListener != null) {
                                YoutubePlayerView.this.onPlayerListener.onPlayerStateChanged(i);
                            }
                        } catch (Exception e) {
                            ThrowableExtension.printStackTrace(e);
                        }
                    }
                });
            }
        }
    }

    public void onDestroy() {
        stop();
        post(new Runnable() { // from class: com.fotoable.youtube.music.ui.view.YoutubePlayerView.9
            @Override // java.lang.Runnable
            public void run() {
                YoutubePlayerView.this.removeJavascriptInterface("PlayerJavaInterface");
            }
        });
    }

    @Override // android.webkit.WebView
    public void destroy() {
        post(new Runnable() { // from class: com.fotoable.youtube.music.ui.view.YoutubePlayerView.10
            @Override // java.lang.Runnable
            public void run() {
                YoutubePlayerView.super.destroy();
            }
        });
        this.isDestroy = true;
    }
}

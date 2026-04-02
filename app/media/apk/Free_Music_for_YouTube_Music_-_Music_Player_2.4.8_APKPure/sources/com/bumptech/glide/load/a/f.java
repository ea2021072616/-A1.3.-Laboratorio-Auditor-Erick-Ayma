package com.bumptech.glide.load.a;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.k;
import com.google.android.exoplayer2.DefaultLoadControl;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
/* compiled from: HttpUrlFetcher.java */
/* loaded from: classes.dex */
public class f implements c<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private static final b f764a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.c.d f765b;

    /* renamed from: c  reason: collision with root package name */
    private final b f766c;
    private HttpURLConnection d;
    private InputStream e;
    private volatile boolean f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpUrlFetcher.java */
    /* loaded from: classes.dex */
    public interface b {
        HttpURLConnection a(URL url) throws IOException;
    }

    public f(com.bumptech.glide.load.c.d dVar) {
        this(dVar, f764a);
    }

    f(com.bumptech.glide.load.c.d dVar, b bVar) {
        this.f765b = dVar;
        this.f766c = bVar;
    }

    @Override // com.bumptech.glide.load.a.c
    /* renamed from: b */
    public InputStream a(k kVar) throws Exception {
        return a(this.f765b.a(), 0, null, this.f765b.b());
    }

    private InputStream a(URL url, int i, URL url2, Map<String, String> map) throws IOException {
        if (i >= 5) {
            throw new IOException("Too many (> 5) redirects!");
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new IOException("In re-direct loop");
                }
            } catch (URISyntaxException e) {
            }
        }
        this.d = this.f766c.a(url);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.d.addRequestProperty(entry.getKey(), entry.getValue());
        }
        this.d.setConnectTimeout(DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS);
        this.d.setReadTimeout(DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS);
        this.d.setUseCaches(false);
        this.d.setDoInput(true);
        this.d.connect();
        if (this.f) {
            return null;
        }
        int responseCode = this.d.getResponseCode();
        if (responseCode / 100 == 2) {
            return a(this.d);
        }
        if (responseCode / 100 == 3) {
            String headerField = this.d.getHeaderField("Location");
            if (TextUtils.isEmpty(headerField)) {
                throw new IOException("Received empty or null redirect url");
            }
            return a(new URL(url, headerField), i + 1, url, map);
        } else if (responseCode == -1) {
            throw new IOException("Unable to retrieve response code from HttpUrlConnection.");
        } else {
            throw new IOException("Request failed " + responseCode + ": " + this.d.getResponseMessage());
        }
    }

    private InputStream a(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.e = com.bumptech.glide.i.b.a(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            this.e = httpURLConnection.getInputStream();
        }
        return this.e;
    }

    @Override // com.bumptech.glide.load.a.c
    public void a() {
        if (this.e != null) {
            try {
                this.e.close();
            } catch (IOException e) {
            }
        }
        if (this.d != null) {
            this.d.disconnect();
        }
    }

    @Override // com.bumptech.glide.load.a.c
    public String b() {
        return this.f765b.c();
    }

    @Override // com.bumptech.glide.load.a.c
    public void c() {
        this.f = true;
    }

    /* compiled from: HttpUrlFetcher.java */
    /* loaded from: classes.dex */
    private static class a implements b {
        private a() {
        }

        @Override // com.bumptech.glide.load.a.f.b
        public HttpURLConnection a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }
}

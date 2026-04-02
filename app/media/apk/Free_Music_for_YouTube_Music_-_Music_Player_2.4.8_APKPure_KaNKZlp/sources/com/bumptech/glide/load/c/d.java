package com.bumptech.glide.load.c;

import android.net.Uri;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
/* compiled from: GlideUrl.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final URL f870a;

    /* renamed from: b  reason: collision with root package name */
    private final e f871b;

    /* renamed from: c  reason: collision with root package name */
    private final String f872c;
    private String d;
    private URL e;

    public d(URL url) {
        this(url, e.f874b);
    }

    public d(String str) {
        this(str, e.f874b);
    }

    public d(URL url, e eVar) {
        if (url == null) {
            throw new IllegalArgumentException("URL must not be null!");
        }
        if (eVar == null) {
            throw new IllegalArgumentException("Headers must not be null");
        }
        this.f870a = url;
        this.f872c = null;
        this.f871b = eVar;
    }

    public d(String str, e eVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("String url must not be empty or null: " + str);
        }
        if (eVar == null) {
            throw new IllegalArgumentException("Headers must not be null");
        }
        this.f872c = str;
        this.f870a = null;
        this.f871b = eVar;
    }

    public URL a() throws MalformedURLException {
        return d();
    }

    private URL d() throws MalformedURLException {
        if (this.e == null) {
            this.e = new URL(e());
        }
        return this.e;
    }

    private String e() {
        if (TextUtils.isEmpty(this.d)) {
            String str = this.f872c;
            if (TextUtils.isEmpty(str)) {
                str = this.f870a.toString();
            }
            this.d = Uri.encode(str, "@#&=*+-_.,:!?()/~'%");
        }
        return this.d;
    }

    public Map<String, String> b() {
        return this.f871b.a();
    }

    public String c() {
        return this.f872c != null ? this.f872c : this.f870a.toString();
    }

    public String toString() {
        return c() + '\n' + this.f871b.toString();
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            return c().equals(dVar.c()) && this.f871b.equals(dVar.f871b);
        }
        return false;
    }

    public int hashCode() {
        return (c().hashCode() * 31) + this.f871b.hashCode();
    }
}

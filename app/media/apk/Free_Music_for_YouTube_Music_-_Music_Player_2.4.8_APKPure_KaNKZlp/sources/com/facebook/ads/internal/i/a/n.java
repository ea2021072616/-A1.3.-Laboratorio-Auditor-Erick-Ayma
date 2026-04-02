package com.facebook.ads.internal.i.a;

import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private int f1395a;

    /* renamed from: b  reason: collision with root package name */
    private String f1396b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, List<String>> f1397c;
    private byte[] d;

    public n(HttpURLConnection httpURLConnection, byte[] bArr) {
        try {
            this.f1395a = httpURLConnection.getResponseCode();
            this.f1396b = httpURLConnection.getURL().toString();
        } catch (IOException e) {
            ThrowableExtension.printStackTrace(e);
        }
        this.f1397c = httpURLConnection.getHeaderFields();
        this.d = bArr;
    }

    public int a() {
        return this.f1395a;
    }

    public String b() {
        return this.f1396b;
    }

    public Map<String, List<String>> c() {
        return this.f1397c;
    }

    public byte[] d() {
        return this.d;
    }

    public String e() {
        if (this.d != null) {
            return new String(this.d);
        }
        return null;
    }
}

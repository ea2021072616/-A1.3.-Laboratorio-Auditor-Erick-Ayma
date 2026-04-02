package com.facebook.ads.internal.util;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class x extends AsyncTask<String, Void, y> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1571a = x.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static final Set<String> f1572b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    private Map<String, String> f1573c;
    private Map<String, String> d;
    private com.facebook.ads.internal.i.a.n e;
    private a f;

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void a(y yVar);
    }

    static {
        f1572b.add("#");
        f1572b.add("null");
    }

    public x() {
        this(null, null);
    }

    public x(Map<String, String> map) {
        this(map, null);
    }

    public x(Map<String, String> map, Map<String, String> map2) {
        this.f1573c = map != null ? new HashMap(map) : null;
        this.d = map2 != null ? new HashMap(map2) : null;
    }

    private String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return str;
        }
        return str + (str.contains("?") ? "&" : "?") + str2 + "=" + URLEncoder.encode(str3);
    }

    private boolean a(String str) {
        com.facebook.ads.internal.i.a.a b2 = w.b();
        try {
            if (this.d == null || this.d.size() == 0) {
                this.e = b2.a(str, (com.facebook.ads.internal.i.a.p) null);
            } else {
                com.facebook.ads.internal.i.a.p pVar = new com.facebook.ads.internal.i.a.p();
                pVar.a((Map<? extends String, ? extends String>) this.d);
                this.e = b2.b(str, pVar);
            }
            if (this.e != null) {
                return this.e.a() == 200;
            }
            return false;
        } catch (Exception e) {
            Log.e(f1571a, "Error opening url: " + str, e);
            return false;
        }
    }

    private String b(String str) {
        try {
            return a(str, "analog", g.a(com.facebook.ads.internal.util.a.a()));
        } catch (Exception e) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public y doInBackground(String... strArr) {
        String str;
        String str2 = strArr[0];
        if (TextUtils.isEmpty(str2) || f1572b.contains(str2)) {
            return null;
        }
        String b2 = b(str2);
        if (this.f1573c != null && !this.f1573c.isEmpty()) {
            Iterator<Map.Entry<String, String>> it = this.f1573c.entrySet().iterator();
            while (true) {
                str = b2;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, String> next = it.next();
                b2 = a(str, next.getKey(), next.getValue());
            }
            b2 = str;
        }
        int i = 1;
        while (true) {
            int i2 = i + 1;
            if (i > 2) {
                return null;
            }
            if (a(b2)) {
                return new y(this.e);
            }
            i = i2;
        }
    }

    public void a(a aVar) {
        this.f = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(y yVar) {
        if (this.f != null) {
            this.f.a(yVar);
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        if (this.f != null) {
            this.f.a();
        }
    }
}

package com.facebook.ads.internal.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.ads.internal.g.g;
import com.facebook.ads.internal.g.h;
import com.facebook.ads.internal.util.b;
import java.util.Map;
/* loaded from: classes.dex */
public class e extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1146a = e.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final Context f1147b;

    /* renamed from: c  reason: collision with root package name */
    private final String f1148c;
    private final Uri d;
    private final Map<String, String> e;

    public e(Context context, String str, Uri uri, Map<String, String> map) {
        this.f1147b = context;
        this.f1148c = str;
        this.d = uri;
        this.e = map;
    }

    @Override // com.facebook.ads.internal.a.a
    public b.a a() {
        return null;
    }

    @Override // com.facebook.ads.internal.a.a
    public void b() {
        g a2 = g.a(this.f1147b);
        h hVar = h.IMMEDIATE;
        String queryParameter = this.d.getQueryParameter("priority");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                hVar = h.values()[Integer.valueOf(queryParameter).intValue()];
            } catch (Exception e) {
            }
        }
        a2.a(this.f1148c, this.e, this.d.getQueryParameter("type"), hVar);
    }
}

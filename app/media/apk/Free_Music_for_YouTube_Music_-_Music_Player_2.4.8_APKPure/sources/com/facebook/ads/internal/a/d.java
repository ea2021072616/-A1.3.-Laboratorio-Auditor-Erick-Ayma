package com.facebook.ads.internal.a;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.ads.internal.util.b;
import com.facebook.ads.internal.util.g;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1143a = d.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final Context f1144b;

    /* renamed from: c  reason: collision with root package name */
    private final String f1145c;
    private final Uri d;
    private final Map<String, String> e;

    public d(Context context, String str, Uri uri, Map<String, String> map) {
        this.f1144b = context;
        this.f1145c = str;
        this.d = uri;
        this.e = map;
    }

    @Override // com.facebook.ads.internal.a.a
    public b.a a() {
        return b.a.OPEN_LINK;
    }

    @Override // com.facebook.ads.internal.a.a
    public void b() {
        a(this.f1144b, this.f1145c, this.e);
        try {
            g.a(this.f1144b, Uri.parse(this.d.getQueryParameter("link")), this.f1145c);
        } catch (Exception e) {
            Log.d(f1143a, "Failed to open link url: " + this.d.toString(), e);
        }
    }
}

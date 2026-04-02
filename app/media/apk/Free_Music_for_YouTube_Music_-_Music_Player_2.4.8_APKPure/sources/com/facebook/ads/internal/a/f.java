package com.facebook.ads.internal.a;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.ads.internal.util.b;
import com.facebook.ads.internal.util.g;
/* loaded from: classes.dex */
public class f extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1149a = f.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final Context f1150b;

    /* renamed from: c  reason: collision with root package name */
    private final String f1151c;
    private final Uri d;

    public f(Context context, String str, Uri uri) {
        this.f1150b = context;
        this.f1151c = str;
        this.d = uri;
    }

    @Override // com.facebook.ads.internal.a.a
    public b.a a() {
        return b.a.OPEN_LINK;
    }

    @Override // com.facebook.ads.internal.a.a
    public void b() {
        try {
            Log.w("REDIRECTACTION: ", this.d.toString());
            g.a(this.f1150b, this.d, this.f1151c);
        } catch (Exception e) {
            Log.d(f1149a, "Failed to open link url: " + this.d.toString(), e);
        }
    }
}

package h0;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;
/* loaded from: classes.dex */
public final class c implements d {

    /* renamed from: g  reason: collision with root package name */
    public final ContentInfo.Builder f3109g;

    public c(ClipData clipData, int i5) {
        this.f3109g = b3.a.f(clipData, i5);
    }

    @Override // h0.d
    public final g a() {
        ContentInfo build;
        build = this.f3109g.build();
        return new g(new d.u0(build));
    }

    @Override // h0.d
    public final void b(Bundle bundle) {
        this.f3109g.setExtras(bundle);
    }

    @Override // h0.d
    public final void c(Uri uri) {
        this.f3109g.setLinkUri(uri);
    }

    @Override // h0.d
    public final void d(int i5) {
        this.f3109g.setFlags(i5);
    }
}

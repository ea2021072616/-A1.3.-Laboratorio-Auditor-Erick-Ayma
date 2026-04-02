package com.fotoable.youtube.music.helper;

import android.content.Context;
import com.acrcloud.rec.b.b;
import com.fotoable.youtube.music.util.h;
import java.io.File;
/* compiled from: ACRCloudHelper.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private com.acrcloud.rec.b.a f2733a;

    /* renamed from: b  reason: collision with root package name */
    private com.acrcloud.rec.b.b f2734b;

    /* renamed from: c  reason: collision with root package name */
    private Context f2735c;
    private File d;

    public a(Context context) {
        this.f2735c = context;
    }

    public com.acrcloud.rec.b.a a() {
        if (this.f2733a == null) {
            this.f2733a = new com.acrcloud.rec.b.a();
            this.d = new File(this.f2735c.getCacheDir(), "ACRCloud");
        }
        return this.f2733a;
    }

    public com.acrcloud.rec.b.b b() {
        if (this.f2734b == null) {
            this.f2734b = new com.acrcloud.rec.b.b();
            this.f2734b.j = this.f2735c;
            this.f2734b.f337c = "identify-ap-southeast-1.acrcloud.com";
            this.f2734b.d = this.d.getPath();
            this.f2734b.e = "ca742d61ec62d9051947c76031e6bfaf";
            this.f2734b.f = "eC0HAKDNuxIEjidpKSu8XVL6JLbYNuAPYktOOZUC";
            this.f2734b.g = b.a.PROTOCOL_HTTP;
            this.f2734b.f335a = b.EnumC0014b.REC_MODE_REMOTE;
            h.a(this.f2734b.d);
        }
        return this.f2734b;
    }
}

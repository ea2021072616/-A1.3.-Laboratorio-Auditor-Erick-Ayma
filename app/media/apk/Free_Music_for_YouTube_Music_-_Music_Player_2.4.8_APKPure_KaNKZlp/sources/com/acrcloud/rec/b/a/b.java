package com.acrcloud.rec.b.a;

import com.acrcloud.rec.b.b.g;
import com.acrcloud.rec.b.b.h;
import com.acrcloud.rec.b.b.i;
import com.acrcloud.rec.engine.ACRCloudRecognizeEngine;
import com.facebook.ads.AdError;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.File;
import java.util.Map;
/* compiled from: ACRCloudRecognizerLocalImpl.java */
/* loaded from: classes.dex */
public class b implements d {
    private static int e = 10000;

    /* renamed from: b  reason: collision with root package name */
    private com.acrcloud.rec.b.b f330b;
    private String f;

    /* renamed from: a  reason: collision with root package name */
    private ACRCloudRecognizeEngine f329a = null;

    /* renamed from: c  reason: collision with root package name */
    private int f331c = 1000;
    private int d = 2000;

    public b(com.acrcloud.rec.b.b bVar, String str) {
        this.f330b = null;
        this.f = "";
        this.f330b = bVar;
        this.f = str;
    }

    @Override // com.acrcloud.rec.b.a.d
    public void a() throws com.acrcloud.rec.b.b.a {
        try {
            new g(this.f330b).execute(this.f);
        } catch (Exception e2) {
            ThrowableExtension.printStackTrace(e2);
        }
        if (this.f329a == null) {
            File file = new File(this.f330b.d + "/afp.iv");
            File file2 = new File(this.f330b.d + "/afp.df");
            File file3 = new File(this.f330b.d + "/afp.op");
            if (!file.canRead()) {
                throw new com.acrcloud.rec.b.b.a(AdError.INTERNAL_ERROR_CODE, "Offline DB file (afp.iv) are unreadable!");
            }
            if (!file2.canRead()) {
                throw new com.acrcloud.rec.b.b.a(AdError.INTERNAL_ERROR_CODE, "Offline DB file (afp.df) are unreadable!");
            }
            if (!file3.canRead()) {
                throw new com.acrcloud.rec.b.b.a(AdError.INTERNAL_ERROR_CODE, "Offline DB file (afp.op) are unreadable!");
            }
            this.f329a = new ACRCloudRecognizeEngine();
            if (!this.f329a.a(this.f330b.d)) {
                this.f329a = null;
                throw new com.acrcloud.rec.b.b.a(AdError.INTERNAL_ERROR_CODE, "Offline DB files are illegal");
            }
        }
    }

    @Override // com.acrcloud.rec.b.a.d
    public i a(Map<String, String> map) {
        i iVar = new i();
        if (this.f329a != null) {
            iVar.c(this.d);
        } else {
            iVar.a(2003);
            iVar.a(com.acrcloud.rec.b.b.a.a(2003));
        }
        return iVar;
    }

    private i a(byte[] bArr, int i, Map<String, Object> map, boolean z) {
        com.acrcloud.rec.engine.a[] b2;
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            b2 = this.f329a.a(bArr, i);
        } else {
            b2 = this.f329a.b(bArr, i);
        }
        i iVar = new i();
        if (map != null) {
            int intValue = ((Integer) map.get("fp_time")).intValue();
            iVar.c(this.f331c + intValue);
            if (intValue + this.f331c > e) {
                iVar.c(0);
            }
        }
        if (b2 == null) {
            iVar.a(1001);
            iVar.a(com.acrcloud.rec.b.b.a.a(1001));
        } else {
            iVar.c(0);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        h.b("ACRCloudRecognizerLocalImpl", "offsetCorrValue=" + currentTimeMillis2);
        iVar.a(currentTimeMillis2);
        iVar.a(b2);
        return iVar;
    }

    @Override // com.acrcloud.rec.b.a.d
    public i a(byte[] bArr, int i, Map<String, Object> map, Map<String, String> map2, int i2) {
        if (bArr == null || i == 0 || this.f329a == null) {
            return null;
        }
        return a(bArr, i, map, true);
    }

    @Override // com.acrcloud.rec.b.a.d
    public void b() {
        if (this.f329a != null) {
            this.f329a.a();
            this.f329a = null;
        }
    }
}

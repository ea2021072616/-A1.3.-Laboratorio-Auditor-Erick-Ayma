package com.facebook.ads.internal.i.b;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final File f1406a;

    /* renamed from: b  reason: collision with root package name */
    public final com.facebook.ads.internal.i.b.a.c f1407b;

    /* renamed from: c  reason: collision with root package name */
    public final com.facebook.ads.internal.i.b.a.a f1408c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(File file, com.facebook.ads.internal.i.b.a.c cVar, com.facebook.ads.internal.i.b.a.a aVar) {
        this.f1406a = file;
        this.f1407b = cVar;
        this.f1408c = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File a(String str) {
        return new File(this.f1406a, this.f1407b.a(str));
    }
}

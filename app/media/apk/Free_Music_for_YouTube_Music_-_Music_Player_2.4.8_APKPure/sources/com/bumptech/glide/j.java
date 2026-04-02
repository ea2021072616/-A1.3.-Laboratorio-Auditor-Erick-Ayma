package com.bumptech.glide;

import android.content.Context;
import android.os.Build;
import com.bumptech.glide.load.b.b.a;
import java.util.concurrent.ExecutorService;
/* compiled from: GlideBuilder.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private final Context f737a;

    /* renamed from: b  reason: collision with root package name */
    private com.bumptech.glide.load.b.c f738b;

    /* renamed from: c  reason: collision with root package name */
    private com.bumptech.glide.load.b.a.c f739c;
    private com.bumptech.glide.load.b.b.h d;
    private ExecutorService e;
    private ExecutorService f;
    private com.bumptech.glide.load.a g;
    private a.InterfaceC0026a h;

    public j(Context context) {
        this.f737a = context.getApplicationContext();
    }

    public j a(com.bumptech.glide.load.a aVar) {
        this.g = aVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i a() {
        if (this.e == null) {
            this.e = new com.bumptech.glide.load.b.c.a(Math.max(1, Runtime.getRuntime().availableProcessors()));
        }
        if (this.f == null) {
            this.f = new com.bumptech.glide.load.b.c.a(1);
        }
        com.bumptech.glide.load.b.b.i iVar = new com.bumptech.glide.load.b.b.i(this.f737a);
        if (this.f739c == null) {
            if (Build.VERSION.SDK_INT >= 11) {
                this.f739c = new com.bumptech.glide.load.b.a.f(iVar.b());
            } else {
                this.f739c = new com.bumptech.glide.load.b.a.d();
            }
        }
        if (this.d == null) {
            this.d = new com.bumptech.glide.load.b.b.g(iVar.a());
        }
        if (this.h == null) {
            this.h = new com.bumptech.glide.load.b.b.f(this.f737a);
        }
        if (this.f738b == null) {
            this.f738b = new com.bumptech.glide.load.b.c(this.d, this.h, this.f, this.e);
        }
        if (this.g == null) {
            this.g = com.bumptech.glide.load.a.d;
        }
        return new i(this.f738b, this.d, this.f739c, this.f737a, this.g);
    }
}

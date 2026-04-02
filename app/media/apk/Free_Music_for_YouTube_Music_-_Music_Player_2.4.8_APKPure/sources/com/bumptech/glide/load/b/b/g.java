package com.bumptech.glide.load.b.b;

import android.annotation.SuppressLint;
import com.bumptech.glide.load.b.b.h;
import com.bumptech.glide.load.b.k;
/* compiled from: LruResourceCache.java */
/* loaded from: classes.dex */
public class g extends com.bumptech.glide.i.e<com.bumptech.glide.load.c, k<?>> implements h {

    /* renamed from: a  reason: collision with root package name */
    private h.a f812a;

    @Override // com.bumptech.glide.load.b.b.h
    public /* synthetic */ k a(com.bumptech.glide.load.c cVar) {
        return (k) super.c(cVar);
    }

    @Override // com.bumptech.glide.load.b.b.h
    public /* bridge */ /* synthetic */ k b(com.bumptech.glide.load.c cVar, k kVar) {
        return (k) super.b((g) cVar, (com.bumptech.glide.load.c) kVar);
    }

    public g(int i) {
        super(i);
    }

    @Override // com.bumptech.glide.load.b.b.h
    public void a(h.a aVar) {
        this.f812a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.i.e
    public void a(com.bumptech.glide.load.c cVar, k<?> kVar) {
        if (this.f812a != null) {
            this.f812a.b(kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.i.e
    public int a(k<?> kVar) {
        return kVar.c();
    }

    @Override // com.bumptech.glide.load.b.b.h
    @SuppressLint({"InlinedApi"})
    public void a(int i) {
        if (i >= 60) {
            a();
        } else if (i >= 40) {
            b(b() / 2);
        }
    }
}

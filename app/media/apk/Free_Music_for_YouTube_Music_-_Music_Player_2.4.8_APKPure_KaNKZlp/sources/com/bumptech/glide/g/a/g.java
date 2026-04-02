package com.bumptech.glide.g.a;

import com.bumptech.glide.g.a.f;
/* compiled from: ViewAnimationFactory.java */
/* loaded from: classes.dex */
public class g<R> implements d<R> {

    /* renamed from: a  reason: collision with root package name */
    private final f.a f694a;

    /* renamed from: b  reason: collision with root package name */
    private c<R> f695b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f.a aVar) {
        this.f694a = aVar;
    }

    @Override // com.bumptech.glide.g.a.d
    public c<R> a(boolean z, boolean z2) {
        if (z || !z2) {
            return e.b();
        }
        if (this.f695b == null) {
            this.f695b = new f(this.f694a);
        }
        return this.f695b;
    }
}

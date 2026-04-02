package com.bumptech.glide.g.b;

import android.graphics.drawable.Drawable;
/* compiled from: BaseTarget.java */
/* loaded from: classes.dex */
public abstract class a<Z> implements j<Z> {
    private com.bumptech.glide.g.b request;

    @Override // com.bumptech.glide.g.b.j
    public void setRequest(com.bumptech.glide.g.b bVar) {
        this.request = bVar;
    }

    @Override // com.bumptech.glide.g.b.j
    public com.bumptech.glide.g.b getRequest() {
        return this.request;
    }

    @Override // com.bumptech.glide.g.b.j
    public void onLoadCleared(Drawable drawable) {
    }

    @Override // com.bumptech.glide.g.b.j
    public void onLoadStarted(Drawable drawable) {
    }

    @Override // com.bumptech.glide.g.b.j
    public void onLoadFailed(Exception exc, Drawable drawable) {
    }

    @Override // com.bumptech.glide.d.h
    public void onStart() {
    }

    @Override // com.bumptech.glide.d.h
    public void onStop() {
    }

    @Override // com.bumptech.glide.d.h
    public void onDestroy() {
    }
}

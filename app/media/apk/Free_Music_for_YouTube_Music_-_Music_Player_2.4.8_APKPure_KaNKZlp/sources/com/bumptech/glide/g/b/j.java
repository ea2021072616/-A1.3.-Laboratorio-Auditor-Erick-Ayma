package com.bumptech.glide.g.b;

import android.graphics.drawable.Drawable;
/* compiled from: Target.java */
/* loaded from: classes.dex */
public interface j<R> extends com.bumptech.glide.d.h {
    com.bumptech.glide.g.b getRequest();

    void getSize(h hVar);

    void onLoadCleared(Drawable drawable);

    void onLoadFailed(Exception exc, Drawable drawable);

    void onLoadStarted(Drawable drawable);

    void onResourceReady(R r, com.bumptech.glide.g.a.c<? super R> cVar);

    void setRequest(com.bumptech.glide.g.b bVar);
}

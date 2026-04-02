package com.bumptech.glide.load.resource.a;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.b.k;
/* compiled from: DrawableResource.java */
/* loaded from: classes.dex */
public abstract class a<T extends Drawable> implements k<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final T f903a;

    public a(T t) {
        if (t == null) {
            throw new NullPointerException("Drawable must not be null!");
        }
        this.f903a = t;
    }

    @Override // com.bumptech.glide.load.b.k
    /* renamed from: a */
    public final T b() {
        return (T) this.f903a.getConstantState().newDrawable();
    }
}

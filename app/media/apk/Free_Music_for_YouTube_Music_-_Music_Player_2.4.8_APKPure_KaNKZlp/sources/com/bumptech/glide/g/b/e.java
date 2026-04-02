package com.bumptech.glide.g.b;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.g.a.c;
/* compiled from: ImageViewTarget.java */
/* loaded from: classes.dex */
public abstract class e<Z> extends k<ImageView, Z> implements c.a {
    protected abstract void a(Z z);

    public e(ImageView imageView) {
        super(imageView);
    }

    @Override // com.bumptech.glide.g.a.c.a
    public Drawable b() {
        return ((ImageView) this.f705a).getDrawable();
    }

    @Override // com.bumptech.glide.g.a.c.a
    public void a(Drawable drawable) {
        ((ImageView) this.f705a).setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.g.b.a, com.bumptech.glide.g.b.j
    public void onLoadStarted(Drawable drawable) {
        ((ImageView) this.f705a).setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.g.b.a, com.bumptech.glide.g.b.j
    public void onLoadFailed(Exception exc, Drawable drawable) {
        ((ImageView) this.f705a).setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.g.b.a, com.bumptech.glide.g.b.j
    public void onLoadCleared(Drawable drawable) {
        ((ImageView) this.f705a).setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.g.b.j
    public void onResourceReady(Z z, com.bumptech.glide.g.a.c<? super Z> cVar) {
        if (cVar == null || !cVar.a(z, this)) {
            a((e<Z>) z);
        }
    }
}

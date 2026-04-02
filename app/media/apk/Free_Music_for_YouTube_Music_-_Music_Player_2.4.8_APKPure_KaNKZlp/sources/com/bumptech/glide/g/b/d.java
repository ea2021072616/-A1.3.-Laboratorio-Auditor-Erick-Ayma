package com.bumptech.glide.g.b;

import android.widget.ImageView;
/* compiled from: GlideDrawableImageViewTarget.java */
/* loaded from: classes.dex */
public class d extends e<com.bumptech.glide.load.resource.a.b> {

    /* renamed from: b  reason: collision with root package name */
    private int f696b;

    /* renamed from: c  reason: collision with root package name */
    private com.bumptech.glide.load.resource.a.b f697c;

    public d(ImageView imageView) {
        this(imageView, -1);
    }

    public d(ImageView imageView, int i) {
        super(imageView);
        this.f696b = i;
    }

    @Override // com.bumptech.glide.g.b.e, com.bumptech.glide.g.b.j
    /* renamed from: a */
    public void onResourceReady(com.bumptech.glide.load.resource.a.b bVar, com.bumptech.glide.g.a.c<? super com.bumptech.glide.load.resource.a.b> cVar) {
        if (!bVar.a()) {
            float width = ((ImageView) this.f705a).getWidth() / ((ImageView) this.f705a).getHeight();
            float intrinsicWidth = bVar.getIntrinsicWidth() / bVar.getIntrinsicHeight();
            if (Math.abs(width - 1.0f) <= 0.05f && Math.abs(intrinsicWidth - 1.0f) <= 0.05f) {
                bVar = new i(bVar, ((ImageView) this.f705a).getWidth());
            }
        }
        super.onResourceReady(bVar, cVar);
        this.f697c = bVar;
        bVar.a(this.f696b);
        bVar.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.g.b.e
    public void a(com.bumptech.glide.load.resource.a.b bVar) {
        ((ImageView) this.f705a).setImageDrawable(bVar);
    }

    @Override // com.bumptech.glide.g.b.a, com.bumptech.glide.d.h
    public void onStart() {
        if (this.f697c != null) {
            this.f697c.start();
        }
    }

    @Override // com.bumptech.glide.g.b.a, com.bumptech.glide.d.h
    public void onStop() {
        if (this.f697c != null) {
            this.f697c.stop();
        }
    }
}

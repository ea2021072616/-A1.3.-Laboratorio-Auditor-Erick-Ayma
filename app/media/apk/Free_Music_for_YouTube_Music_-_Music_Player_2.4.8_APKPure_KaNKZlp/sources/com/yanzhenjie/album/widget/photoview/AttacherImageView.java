package com.yanzhenjie.album.widget.photoview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
/* loaded from: classes2.dex */
public class AttacherImageView extends AppCompatImageView {
    private PhotoViewAttacher mAttacher;

    public AttacherImageView(Context context) {
        super(context);
    }

    public AttacherImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AttacherImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setAttacher(PhotoViewAttacher photoViewAttacher) {
        this.mAttacher = photoViewAttacher;
    }

    @Override // android.support.v7.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.mAttacher != null) {
            this.mAttacher.update();
        }
    }
}

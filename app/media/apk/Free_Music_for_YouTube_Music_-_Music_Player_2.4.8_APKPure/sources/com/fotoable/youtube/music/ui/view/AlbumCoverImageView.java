package com.fotoable.youtube.music.ui.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlbumCoverImageView extends ImageView {
    public AlbumCoverImageView(Context context) {
        super(context);
    }

    public AlbumCoverImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AlbumCoverImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }
}

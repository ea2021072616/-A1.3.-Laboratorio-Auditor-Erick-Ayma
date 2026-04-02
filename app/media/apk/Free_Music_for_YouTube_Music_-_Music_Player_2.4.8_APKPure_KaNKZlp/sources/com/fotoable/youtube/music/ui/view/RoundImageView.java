package com.fotoable.youtube.music.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.fotoable.youtube.music.R;
/* loaded from: classes.dex */
public class RoundImageView extends AbsRoundImageView {
    private float leftBottomRadius;
    private float leftTopRadius;
    private float rightBottomRadius;
    private float rightTopRadius;

    public RoundImageView(Context context) {
        this(context, null, 0);
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initAttrs(attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.ui.view.AbsRoundImageView
    public void initAttrs(AttributeSet attributeSet) {
        super.initAttrs(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.RoundImageView);
            this.leftTopRadius = obtainStyledAttributes.getDimension(0, 0.0f);
            this.rightTopRadius = obtainStyledAttributes.getDimension(1, 0.0f);
            this.rightBottomRadius = obtainStyledAttributes.getDimension(2, 0.0f);
            this.leftBottomRadius = obtainStyledAttributes.getDimension(3, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // com.fotoable.youtube.music.ui.view.AbsRoundImageView
    protected void initRoundPath() {
        this.roundPath.reset();
        int width = getWidth();
        int height = getHeight();
        this.leftTopRadius = Math.min(this.leftTopRadius, Math.min(width, height) * 0.5f);
        this.rightTopRadius = Math.min(this.rightTopRadius, Math.min(width, height) * 0.5f);
        this.rightBottomRadius = Math.min(this.rightBottomRadius, Math.min(width, height) * 0.5f);
        this.leftBottomRadius = Math.min(this.leftBottomRadius, Math.min(width, height) * 0.5f);
        this.roundPath.addRoundRect(new RectF(0.0f, 0.0f, width, height), new float[]{this.leftTopRadius, this.leftTopRadius, this.rightTopRadius, this.rightTopRadius, this.rightBottomRadius, this.rightBottomRadius, this.leftBottomRadius, this.leftBottomRadius}, Path.Direction.CW);
    }

    @Override // com.fotoable.youtube.music.ui.view.AbsRoundImageView
    protected void initBorderPath() {
        this.borderPath.reset();
        float f = this.borderWidth * 0.35f;
        int width = getWidth();
        int height = getHeight();
        this.leftTopRadius = Math.min(this.leftTopRadius, Math.min(width, height) * 0.5f);
        this.rightTopRadius = Math.min(this.rightTopRadius, Math.min(width, height) * 0.5f);
        this.rightBottomRadius = Math.min(this.rightBottomRadius, Math.min(width, height) * 0.5f);
        this.leftBottomRadius = Math.min(this.leftBottomRadius, Math.min(width, height) * 0.5f);
        this.borderPath.addRoundRect(new RectF(f, f, width - f, height - f), new float[]{this.leftTopRadius, this.leftTopRadius, this.rightTopRadius, this.rightTopRadius, this.rightBottomRadius, this.rightBottomRadius, this.leftBottomRadius, this.leftBottomRadius}, Path.Direction.CW);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }
}

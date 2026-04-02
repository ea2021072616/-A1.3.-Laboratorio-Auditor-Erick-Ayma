package com.yanzhenjie.durban.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.yanzhenjie.durban.R;
import com.yanzhenjie.durban.a.c;
import com.yanzhenjie.durban.a.d;
/* loaded from: classes2.dex */
public class CropView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private GestureCropImageView f5177a;

    /* renamed from: b  reason: collision with root package name */
    private final OverlayView f5178b;

    public CropView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CropView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.durban_crop_view, (ViewGroup) this, true);
        this.f5177a = (GestureCropImageView) findViewById(R.id.image_view_crop);
        this.f5178b = (OverlayView) findViewById(R.id.view_overlay);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.durban_CropView);
        this.f5178b.a(obtainStyledAttributes);
        this.f5177a.a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        a();
    }

    private void a() {
        this.f5177a.setCropBoundsChangeListener(new c() { // from class: com.yanzhenjie.durban.view.CropView.1
            @Override // com.yanzhenjie.durban.a.c
            public void a(float f) {
                CropView.this.f5178b.setTargetAspectRatio(f);
            }
        });
        this.f5178b.setOverlayViewChangeListener(new d() { // from class: com.yanzhenjie.durban.view.CropView.2
            @Override // com.yanzhenjie.durban.a.d
            public void a(RectF rectF) {
                CropView.this.f5177a.setCropRect(rectF);
            }
        });
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @NonNull
    public GestureCropImageView getCropImageView() {
        return this.f5177a;
    }

    @NonNull
    public OverlayView getOverlayView() {
        return this.f5178b;
    }
}

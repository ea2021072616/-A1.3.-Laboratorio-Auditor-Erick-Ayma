package com.yanzhenjie.durban.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.yanzhenjie.durban.d.i;
/* loaded from: classes2.dex */
public class GestureCropImageView extends CropImageView {
    private ScaleGestureDetector i;
    private i j;
    private GestureDetector k;
    private float l;
    private float m;
    private boolean n;
    private boolean o;
    private int p;

    public GestureCropImageView(Context context) {
        super(context);
        this.n = true;
        this.o = true;
        this.p = 5;
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = true;
        this.o = true;
        this.p = 5;
    }

    public void setScaleEnabled(boolean z) {
        this.o = z;
    }

    public void setRotateEnabled(boolean z) {
        this.n = z;
    }

    public void setDoubleTapScaleSteps(int i) {
        this.p = i;
    }

    public int getDoubleTapScaleSteps() {
        return this.p;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 0) {
            a();
        }
        if (motionEvent.getPointerCount() > 1) {
            this.l = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
            this.m = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
        }
        this.k.onTouchEvent(motionEvent);
        if (this.o) {
            this.i.onTouchEvent(motionEvent);
        }
        if (this.n) {
            this.j.a(motionEvent);
        }
        if ((motionEvent.getAction() & 255) == 1) {
            b();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yanzhenjie.durban.view.TransformImageView
    public void e() {
        super.e();
        f();
    }

    protected float getDoubleTapTargetScale() {
        return getCurrentScale() * ((float) Math.pow(getMaxScale() / getMinScale(), 1.0f / this.p));
    }

    private void f() {
        this.k = new GestureDetector(getContext(), new a(), null, true);
        this.i = new ScaleGestureDetector(getContext(), new c());
        this.j = new i(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private c() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            GestureCropImageView.this.c(scaleGestureDetector.getScaleFactor(), GestureCropImageView.this.l, GestureCropImageView.this.m);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            GestureCropImageView.this.a(GestureCropImageView.this.getDoubleTapTargetScale(), motionEvent.getX(), motionEvent.getY(), 200L);
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            GestureCropImageView.this.a(-f, -f2);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends i.b {
        private b() {
        }

        @Override // com.yanzhenjie.durban.d.i.b, com.yanzhenjie.durban.d.i.a
        public boolean a(i iVar) {
            GestureCropImageView.this.d(iVar.a(), GestureCropImageView.this.l, GestureCropImageView.this.m);
            return true;
        }
    }
}

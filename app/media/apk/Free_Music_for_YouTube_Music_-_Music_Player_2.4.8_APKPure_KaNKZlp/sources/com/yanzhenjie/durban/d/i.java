package com.yanzhenjie.durban.d;

import android.support.annotation.NonNull;
import android.view.MotionEvent;
/* compiled from: RotationGestureDetector.java */
/* loaded from: classes2.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private float f5159a;

    /* renamed from: b  reason: collision with root package name */
    private float f5160b;

    /* renamed from: c  reason: collision with root package name */
    private float f5161c;
    private float d;
    private int e = -1;
    private int f = -1;
    private float g;
    private boolean h;
    private a i;

    /* compiled from: RotationGestureDetector.java */
    /* loaded from: classes2.dex */
    public interface a {
        boolean a(i iVar);
    }

    public i(a aVar) {
        this.i = aVar;
    }

    public float a() {
        return this.g;
    }

    public boolean a(@NonNull MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.f5161c = motionEvent.getX();
                this.d = motionEvent.getY();
                this.e = motionEvent.findPointerIndex(motionEvent.getPointerId(0));
                this.g = 0.0f;
                this.h = true;
                break;
            case 1:
                this.e = -1;
                break;
            case 2:
                if (this.e != -1 && this.f != -1 && motionEvent.getPointerCount() > this.f) {
                    float x = motionEvent.getX(this.e);
                    float y = motionEvent.getY(this.e);
                    float x2 = motionEvent.getX(this.f);
                    float y2 = motionEvent.getY(this.f);
                    if (this.h) {
                        this.g = 0.0f;
                        this.h = false;
                    } else {
                        a(this.f5159a, this.f5160b, this.f5161c, this.d, x2, y2, x, y);
                    }
                    if (this.i != null) {
                        this.i.a(this);
                    }
                    this.f5159a = x2;
                    this.f5160b = y2;
                    this.f5161c = x;
                    this.d = y;
                    break;
                }
                break;
            case 5:
                this.f5159a = motionEvent.getX();
                this.f5160b = motionEvent.getY();
                this.f = motionEvent.findPointerIndex(motionEvent.getPointerId(motionEvent.getActionIndex()));
                this.g = 0.0f;
                this.h = true;
                break;
            case 6:
                this.f = -1;
                break;
        }
        return true;
    }

    private float a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        return a((float) Math.toDegrees((float) Math.atan2(f2 - f4, f - f3)), (float) Math.toDegrees((float) Math.atan2(f6 - f8, f5 - f7)));
    }

    private float a(float f, float f2) {
        this.g = (f2 % 360.0f) - (f % 360.0f);
        if (this.g < -180.0f) {
            this.g += 360.0f;
        } else if (this.g > 180.0f) {
            this.g -= 360.0f;
        }
        return this.g;
    }

    /* compiled from: RotationGestureDetector.java */
    /* loaded from: classes2.dex */
    public static class b implements a {
        @Override // com.yanzhenjie.durban.d.i.a
        public boolean a(i iVar) {
            return false;
        }
    }
}

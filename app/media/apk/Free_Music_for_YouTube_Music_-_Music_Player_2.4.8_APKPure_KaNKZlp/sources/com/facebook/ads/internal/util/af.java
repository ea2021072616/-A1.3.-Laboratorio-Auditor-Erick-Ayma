package com.facebook.ads.internal.util;

import android.graphics.Rect;
import android.view.InputDevice;
import android.view.MotionEvent;
import android.view.View;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class af {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1496a = af.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private boolean f1497b;

    /* renamed from: c  reason: collision with root package name */
    private int f1498c = -1;
    private int d = -1;
    private int e = -1;
    private int f = -1;
    private long g = -1;
    private int h = -1;
    private long i = -1;
    private long j = -1;
    private int k = -1;
    private int l = -1;
    private int m = -1;
    private int n = -1;
    private float o = -1.0f;
    private float p = -1.0f;
    private float q = -1.0f;

    public void a() {
        this.g = System.currentTimeMillis();
    }

    public void a(MotionEvent motionEvent, View view, View view2) {
        if (!this.f1497b) {
            this.f1497b = true;
            InputDevice device = motionEvent.getDevice();
            if (device != null) {
                InputDevice.MotionRange motionRange = device.getMotionRange(0);
                InputDevice.MotionRange motionRange2 = device.getMotionRange(1);
                if (motionRange != null && motionRange2 != null) {
                    this.q = Math.min(motionRange.getRange(), motionRange2.getRange());
                }
            }
            if (this.q <= 0.0f) {
                this.q = Math.min(view.getMeasuredWidth(), view.getMeasuredHeight());
            }
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        view2.getLocationInWindow(iArr2);
        switch (motionEvent.getAction()) {
            case 0:
                this.f1498c = iArr[0];
                this.d = iArr[1];
                this.e = view.getWidth();
                this.f = view.getHeight();
                this.h = 1;
                this.i = System.currentTimeMillis();
                this.k = (((int) (motionEvent.getX() + 0.5f)) + iArr2[0]) - iArr[0];
                this.l = (iArr2[1] + ((int) (motionEvent.getY() + 0.5f))) - iArr[1];
                this.o = motionEvent.getPressure();
                this.p = motionEvent.getSize();
                return;
            case 1:
            case 3:
                this.j = System.currentTimeMillis();
                this.m = (((int) (motionEvent.getX() + 0.5f)) + iArr2[0]) - iArr[0];
                this.n = (iArr2[1] + ((int) (motionEvent.getY() + 0.5f))) - iArr[1];
                return;
            case 2:
                this.o -= this.o / this.h;
                this.o += motionEvent.getPressure() / this.h;
                this.p -= this.p / this.h;
                this.p += motionEvent.getSize() / this.h;
                this.h++;
                return;
            default:
                return;
        }
    }

    public boolean a(int i) {
        if (!d() || this.m == -1 || this.n == -1 || this.e == -1 || this.f == -1) {
            return false;
        }
        int i2 = (this.f * i) / 100;
        int i3 = (this.e * i) / 100;
        return !new Rect(i3, i2, this.e - i3, this.f - i2).contains(this.m, this.n);
    }

    public boolean b() {
        return this.g != -1;
    }

    public long c() {
        if (b()) {
            return System.currentTimeMillis() - this.g;
        }
        return -1L;
    }

    public boolean d() {
        return this.f1497b;
    }

    public Map<String, String> e() {
        if (this.f1497b) {
            String valueOf = String.valueOf((this.p * this.q) / 2.0f);
            long j = (this.g <= 0 || this.j <= this.g) ? -1L : this.j - this.g;
            HashMap hashMap = new HashMap();
            hashMap.put("adPositionX", String.valueOf(this.f1498c));
            hashMap.put("adPositionY", String.valueOf(this.d));
            hashMap.put("width", String.valueOf(this.e));
            hashMap.put("height", String.valueOf(this.f));
            hashMap.put("clickDelayTime", String.valueOf(j));
            hashMap.put("startTime", String.valueOf(this.i));
            hashMap.put("endTime", String.valueOf(this.j));
            hashMap.put("startX", String.valueOf(this.k));
            hashMap.put("startY", String.valueOf(this.l));
            hashMap.put("clickX", String.valueOf(this.m));
            hashMap.put("clickY", String.valueOf(this.n));
            hashMap.put("endX", String.valueOf(this.m));
            hashMap.put("endY", String.valueOf(this.n));
            hashMap.put("force", String.valueOf(this.o));
            hashMap.put("radiusX", valueOf);
            hashMap.put("radiusY", valueOf);
            return hashMap;
        }
        return null;
    }
}

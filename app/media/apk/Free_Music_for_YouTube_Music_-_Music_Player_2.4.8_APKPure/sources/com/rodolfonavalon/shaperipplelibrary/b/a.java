package com.rodolfonavalon.shaperipplelibrary.b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
/* compiled from: BaseShape.java */
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected int f5120a;

    /* renamed from: b  reason: collision with root package name */
    protected int f5121b;

    public abstract void a(Context context, Paint paint);

    public abstract void a(Canvas canvas, int i, int i2, float f, int i3, int i4, Paint paint);

    public void a(int i) {
        this.f5120a = i;
    }

    public void b(int i) {
        this.f5121b = i;
    }
}

package o3;

import android.graphics.Paint;
import android.graphics.Path;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: i  reason: collision with root package name */
    public static final int[] f4104i = new int[3];

    /* renamed from: j  reason: collision with root package name */
    public static final float[] f4105j = {0.0f, 0.5f, 1.0f};

    /* renamed from: k  reason: collision with root package name */
    public static final int[] f4106k = new int[4];

    /* renamed from: l  reason: collision with root package name */
    public static final float[] f4107l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: a  reason: collision with root package name */
    public final Paint f4108a;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f4109b;

    /* renamed from: c  reason: collision with root package name */
    public final Paint f4110c;

    /* renamed from: d  reason: collision with root package name */
    public int f4111d;

    /* renamed from: e  reason: collision with root package name */
    public int f4112e;

    /* renamed from: f  reason: collision with root package name */
    public int f4113f;

    /* renamed from: g  reason: collision with root package name */
    public final Path f4114g = new Path();

    /* renamed from: h  reason: collision with root package name */
    public final Paint f4115h;

    public a() {
        Paint paint = new Paint();
        this.f4115h = paint;
        this.f4108a = new Paint();
        a(-16777216);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.f4109b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f4110c = new Paint(paint2);
    }

    public final void a(int i5) {
        this.f4111d = z.a.c(i5, 68);
        this.f4112e = z.a.c(i5, 20);
        this.f4113f = z.a.c(i5, 0);
        this.f4108a.setColor(this.f4111d);
    }
}

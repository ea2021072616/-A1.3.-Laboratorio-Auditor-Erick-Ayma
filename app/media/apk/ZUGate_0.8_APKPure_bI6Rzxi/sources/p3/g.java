package p3;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import java.util.BitSet;
import java.util.Objects;
/* loaded from: classes.dex */
public class g extends Drawable implements u {
    public static final Paint C;
    public final RectF A;
    public final boolean B;

    /* renamed from: g  reason: collision with root package name */
    public f f4294g;

    /* renamed from: h  reason: collision with root package name */
    public final s[] f4295h;

    /* renamed from: i  reason: collision with root package name */
    public final s[] f4296i;

    /* renamed from: j  reason: collision with root package name */
    public final BitSet f4297j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f4298k;

    /* renamed from: l  reason: collision with root package name */
    public final Matrix f4299l;

    /* renamed from: m  reason: collision with root package name */
    public final Path f4300m;

    /* renamed from: n  reason: collision with root package name */
    public final Path f4301n;
    public final RectF o;

    /* renamed from: p  reason: collision with root package name */
    public final RectF f4302p;

    /* renamed from: q  reason: collision with root package name */
    public final Region f4303q;

    /* renamed from: r  reason: collision with root package name */
    public final Region f4304r;

    /* renamed from: s  reason: collision with root package name */
    public j f4305s;

    /* renamed from: t  reason: collision with root package name */
    public final Paint f4306t;

    /* renamed from: u  reason: collision with root package name */
    public final Paint f4307u;

    /* renamed from: v  reason: collision with root package name */
    public final o3.a f4308v;

    /* renamed from: w  reason: collision with root package name */
    public final n2.b f4309w;

    /* renamed from: x  reason: collision with root package name */
    public final l f4310x;

    /* renamed from: y  reason: collision with root package name */
    public PorterDuffColorFilter f4311y;

    /* renamed from: z  reason: collision with root package name */
    public PorterDuffColorFilter f4312z;

    static {
        Paint paint = new Paint(1);
        C = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public g() {
        this(new j());
    }

    public final void a(RectF rectF, Path path) {
        l lVar = this.f4310x;
        f fVar = this.f4294g;
        lVar.a(fVar.f4274a, fVar.f4283j, rectF, this.f4309w, path);
        if (this.f4294g.f4282i != 1.0f) {
            Matrix matrix = this.f4299l;
            matrix.reset();
            float f5 = this.f4294g.f4282i;
            matrix.setScale(f5, f5, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(matrix);
        }
        path.computeBounds(this.A, true);
    }

    public final PorterDuffColorFilter b(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z4) {
        int color;
        int c5;
        if (colorStateList == null || mode == null) {
            return (!z4 || (c5 = c((color = paint.getColor()))) == color) ? null : new PorterDuffColorFilter(c5, PorterDuff.Mode.SRC_IN);
        }
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z4) {
            colorForState = c(colorForState);
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    public final int c(int i5) {
        int i6;
        f fVar = this.f4294g;
        float f5 = fVar.f4287n + fVar.o + fVar.f4286m;
        i3.a aVar = fVar.f4275b;
        if (aVar == null || !aVar.f3413a) {
            return i5;
        }
        if (z.a.c(i5, 255) == aVar.f3416d) {
            float f6 = aVar.f3417e;
            float min = (f6 <= 0.0f || f5 <= 0.0f) ? 0.0f : Math.min(((((float) Math.log1p(f5 / f6)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
            int alpha = Color.alpha(i5);
            int B = e4.e.B(z.a.c(i5, 255), min, aVar.f3414b);
            if (min > 0.0f && (i6 = aVar.f3415c) != 0) {
                B = z.a.b(z.a.c(i6, i3.a.f3412f), B);
            }
            return z.a.c(B, alpha);
        }
        return i5;
    }

    public final void d(Canvas canvas) {
        if (this.f4297j.cardinality() > 0) {
            Log.w("g", "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        int i5 = this.f4294g.f4290r;
        Path path = this.f4300m;
        o3.a aVar = this.f4308v;
        if (i5 != 0) {
            canvas.drawPath(path, aVar.f4108a);
        }
        for (int i6 = 0; i6 < 4; i6++) {
            s sVar = this.f4295h[i6];
            int i7 = this.f4294g.f4289q;
            Matrix matrix = s.f4355b;
            sVar.a(matrix, aVar, i7, canvas);
            this.f4296i[i6].a(matrix, aVar, this.f4294g.f4289q, canvas);
        }
        if (this.B) {
            f fVar = this.f4294g;
            int sin = (int) (Math.sin(Math.toRadians(fVar.f4291s)) * fVar.f4290r);
            f fVar2 = this.f4294g;
            int cos = (int) (Math.cos(Math.toRadians(fVar2.f4291s)) * fVar2.f4290r);
            canvas.translate(-sin, -cos);
            canvas.drawPath(path, C);
            canvas.translate(sin, cos);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0128, code lost:
        if (((r0.f4274a.d(g()) || r3.isConvex() || android.os.Build.VERSION.SDK_INT >= 29) ? false : true) != false) goto L53;
     */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0214  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(android.graphics.Canvas r22) {
        /*
            Method dump skipped, instructions count: 550
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p3.g.draw(android.graphics.Canvas):void");
    }

    public final void e(Canvas canvas, Paint paint, Path path, j jVar, RectF rectF) {
        if (!jVar.d(rectF)) {
            canvas.drawPath(path, paint);
            return;
        }
        float a5 = jVar.f4319f.a(rectF) * this.f4294g.f4283j;
        canvas.drawRoundRect(rectF, a5, a5, paint);
    }

    public void f(Canvas canvas) {
        Paint paint = this.f4307u;
        Path path = this.f4301n;
        j jVar = this.f4305s;
        RectF rectF = this.f4302p;
        rectF.set(g());
        Paint.Style style = this.f4294g.f4293u;
        float strokeWidth = (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && (paint.getStrokeWidth() > 0.0f ? 1 : (paint.getStrokeWidth() == 0.0f ? 0 : -1)) > 0 ? paint.getStrokeWidth() / 2.0f : 0.0f;
        rectF.inset(strokeWidth, strokeWidth);
        e(canvas, paint, path, jVar, rectF);
    }

    public final RectF g() {
        RectF rectF = this.o;
        rectF.set(getBounds());
        return rectF;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f4294g.f4285l;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f4294g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        f fVar = this.f4294g;
        if (fVar.f4288p == 2) {
            return;
        }
        if (fVar.f4274a.d(g())) {
            outline.setRoundRect(getBounds(), this.f4294g.f4274a.f4318e.a(g()) * this.f4294g.f4283j);
            return;
        }
        RectF g5 = g();
        Path path = this.f4300m;
        a(g5, path);
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 30) {
            h3.b.a(outline, path);
        } else if (i5 >= 29) {
            try {
                h3.a.a(outline, path);
            } catch (IllegalArgumentException unused) {
            }
        } else if (path.isConvex()) {
            h3.a.a(outline, path);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        Rect rect2 = this.f4294g.f4281h;
        if (rect2 != null) {
            rect.set(rect2);
            return true;
        }
        return super.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        Rect bounds = getBounds();
        Region region = this.f4303q;
        region.set(bounds);
        RectF g5 = g();
        Path path = this.f4300m;
        a(g5, path);
        Region region2 = this.f4304r;
        region2.setPath(path, region);
        region.op(region2, Region.Op.DIFFERENCE);
        return region;
    }

    public final void h(Context context) {
        this.f4294g.f4275b = new i3.a(context);
        m();
    }

    public final void i(float f5) {
        f fVar = this.f4294g;
        if (fVar.f4287n != f5) {
            fVar.f4287n = f5;
            m();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        this.f4298k = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f4294g.f4279f) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f4294g.f4278e) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f4294g.f4277d) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f4294g.f4276c) != null && colorStateList4.isStateful())));
    }

    public final void j(ColorStateList colorStateList) {
        f fVar = this.f4294g;
        if (fVar.f4276c != colorStateList) {
            fVar.f4276c = colorStateList;
            onStateChange(getState());
        }
    }

    public final boolean k(int[] iArr) {
        boolean z4;
        Paint paint;
        int color;
        int colorForState;
        Paint paint2;
        int color2;
        int colorForState2;
        if (this.f4294g.f4276c == null || color2 == (colorForState2 = this.f4294g.f4276c.getColorForState(iArr, (color2 = (paint2 = this.f4306t).getColor())))) {
            z4 = false;
        } else {
            paint2.setColor(colorForState2);
            z4 = true;
        }
        if (this.f4294g.f4277d == null || color == (colorForState = this.f4294g.f4277d.getColorForState(iArr, (color = (paint = this.f4307u).getColor())))) {
            return z4;
        }
        paint.setColor(colorForState);
        return true;
    }

    public final boolean l() {
        PorterDuffColorFilter porterDuffColorFilter = this.f4311y;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f4312z;
        f fVar = this.f4294g;
        this.f4311y = b(fVar.f4279f, fVar.f4280g, this.f4306t, true);
        f fVar2 = this.f4294g;
        this.f4312z = b(fVar2.f4278e, fVar2.f4280g, this.f4307u, false);
        f fVar3 = this.f4294g;
        if (fVar3.f4292t) {
            this.f4308v.a(fVar3.f4279f.getColorForState(getState(), 0));
        }
        return (Objects.equals(porterDuffColorFilter, this.f4311y) && Objects.equals(porterDuffColorFilter2, this.f4312z)) ? false : true;
    }

    public final void m() {
        f fVar = this.f4294g;
        float f5 = fVar.f4287n + fVar.o;
        fVar.f4289q = (int) Math.ceil(0.75f * f5);
        this.f4294g.f4290r = (int) Math.ceil(f5 * 0.25f);
        l();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f4294g = new f(this.f4294g);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.f4298k = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z4 = k(iArr) || l();
        if (z4) {
            invalidateSelf();
        }
        return z4;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i5) {
        f fVar = this.f4294g;
        if (fVar.f4285l != i5) {
            fVar.f4285l = i5;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f4294g.getClass();
        super.invalidateSelf();
    }

    @Override // p3.u
    public final void setShapeAppearanceModel(j jVar) {
        this.f4294g.f4274a = jVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i5) {
        setTintList(ColorStateList.valueOf(i5));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f4294g.f4279f = colorStateList;
        l();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        f fVar = this.f4294g;
        if (fVar.f4280g != mode) {
            fVar.f4280g = mode;
            l();
            super.invalidateSelf();
        }
    }

    public g(Context context, AttributeSet attributeSet, int i5, int i6) {
        this(j.b(context, attributeSet, i5, i6).a());
    }

    public g(j jVar) {
        this(new f(jVar));
    }

    public g(f fVar) {
        l lVar;
        this.f4295h = new s[4];
        this.f4296i = new s[4];
        this.f4297j = new BitSet(8);
        this.f4299l = new Matrix();
        this.f4300m = new Path();
        this.f4301n = new Path();
        this.o = new RectF();
        this.f4302p = new RectF();
        this.f4303q = new Region();
        this.f4304r = new Region();
        Paint paint = new Paint(1);
        this.f4306t = paint;
        Paint paint2 = new Paint(1);
        this.f4307u = paint2;
        this.f4308v = new o3.a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            lVar = k.f4326a;
        } else {
            lVar = new l();
        }
        this.f4310x = lVar;
        this.A = new RectF();
        this.B = true;
        this.f4294g = fVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        l();
        k(getState());
        this.f4309w = new n2.b(this);
    }
}

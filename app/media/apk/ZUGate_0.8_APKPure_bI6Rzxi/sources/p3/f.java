package p3;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class f extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    public j f4274a;

    /* renamed from: b  reason: collision with root package name */
    public i3.a f4275b;

    /* renamed from: c  reason: collision with root package name */
    public ColorStateList f4276c;

    /* renamed from: d  reason: collision with root package name */
    public ColorStateList f4277d;

    /* renamed from: e  reason: collision with root package name */
    public final ColorStateList f4278e;

    /* renamed from: f  reason: collision with root package name */
    public ColorStateList f4279f;

    /* renamed from: g  reason: collision with root package name */
    public PorterDuff.Mode f4280g;

    /* renamed from: h  reason: collision with root package name */
    public Rect f4281h;

    /* renamed from: i  reason: collision with root package name */
    public final float f4282i;

    /* renamed from: j  reason: collision with root package name */
    public float f4283j;

    /* renamed from: k  reason: collision with root package name */
    public float f4284k;

    /* renamed from: l  reason: collision with root package name */
    public int f4285l;

    /* renamed from: m  reason: collision with root package name */
    public float f4286m;

    /* renamed from: n  reason: collision with root package name */
    public float f4287n;
    public final float o;

    /* renamed from: p  reason: collision with root package name */
    public final int f4288p;

    /* renamed from: q  reason: collision with root package name */
    public int f4289q;

    /* renamed from: r  reason: collision with root package name */
    public int f4290r;

    /* renamed from: s  reason: collision with root package name */
    public final int f4291s;

    /* renamed from: t  reason: collision with root package name */
    public final boolean f4292t;

    /* renamed from: u  reason: collision with root package name */
    public final Paint.Style f4293u;

    public f(j jVar) {
        this.f4276c = null;
        this.f4277d = null;
        this.f4278e = null;
        this.f4279f = null;
        this.f4280g = PorterDuff.Mode.SRC_IN;
        this.f4281h = null;
        this.f4282i = 1.0f;
        this.f4283j = 1.0f;
        this.f4285l = 255;
        this.f4286m = 0.0f;
        this.f4287n = 0.0f;
        this.o = 0.0f;
        this.f4288p = 0;
        this.f4289q = 0;
        this.f4290r = 0;
        this.f4291s = 0;
        this.f4292t = false;
        this.f4293u = Paint.Style.FILL_AND_STROKE;
        this.f4274a = jVar;
        this.f4275b = null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        g gVar = new g(this);
        gVar.f4298k = true;
        return gVar;
    }

    public f(f fVar) {
        this.f4276c = null;
        this.f4277d = null;
        this.f4278e = null;
        this.f4279f = null;
        this.f4280g = PorterDuff.Mode.SRC_IN;
        this.f4281h = null;
        this.f4282i = 1.0f;
        this.f4283j = 1.0f;
        this.f4285l = 255;
        this.f4286m = 0.0f;
        this.f4287n = 0.0f;
        this.o = 0.0f;
        this.f4288p = 0;
        this.f4289q = 0;
        this.f4290r = 0;
        this.f4291s = 0;
        this.f4292t = false;
        this.f4293u = Paint.Style.FILL_AND_STROKE;
        this.f4274a = fVar.f4274a;
        this.f4275b = fVar.f4275b;
        this.f4284k = fVar.f4284k;
        this.f4276c = fVar.f4276c;
        this.f4277d = fVar.f4277d;
        this.f4280g = fVar.f4280g;
        this.f4279f = fVar.f4279f;
        this.f4285l = fVar.f4285l;
        this.f4282i = fVar.f4282i;
        this.f4290r = fVar.f4290r;
        this.f4288p = fVar.f4288p;
        this.f4292t = fVar.f4292t;
        this.f4283j = fVar.f4283j;
        this.f4286m = fVar.f4286m;
        this.f4287n = fVar.f4287n;
        this.o = fVar.o;
        this.f4289q = fVar.f4289q;
        this.f4291s = fVar.f4291s;
        this.f4278e = fVar.f4278e;
        this.f4293u = fVar.f4293u;
        if (fVar.f4281h != null) {
            this.f4281h = new Rect(fVar.f4281h);
        }
    }
}

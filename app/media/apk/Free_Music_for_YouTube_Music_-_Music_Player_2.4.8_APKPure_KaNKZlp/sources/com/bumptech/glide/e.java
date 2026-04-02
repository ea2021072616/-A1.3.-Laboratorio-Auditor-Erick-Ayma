package com.bumptech.glide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.d.m;
/* compiled from: GenericRequestBuilder.java */
/* loaded from: classes.dex */
public class e<ModelType, DataType, ResourceType, TranscodeType> implements Cloneable {
    private boolean A;
    private Drawable B;
    private int C;

    /* renamed from: a  reason: collision with root package name */
    protected final Class<ModelType> f665a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f666b;

    /* renamed from: c  reason: collision with root package name */
    protected final i f667c;
    protected final Class<TranscodeType> d;
    protected final m e;
    protected final com.bumptech.glide.d.g f;
    private com.bumptech.glide.f.a<ModelType, DataType, ResourceType, TranscodeType> g;
    private ModelType h;
    private com.bumptech.glide.load.c i;
    private boolean j;
    private int k;
    private int l;
    private com.bumptech.glide.g.d<? super ModelType, TranscodeType> m;
    private Float n;
    private e<?, ?, ?, TranscodeType> o;
    private Float p;
    private Drawable q;
    private Drawable r;
    private k s;
    private boolean t;
    private com.bumptech.glide.g.a.d<TranscodeType> u;
    private int v;
    private int w;
    private com.bumptech.glide.load.b.b x;
    private com.bumptech.glide.load.g<ResourceType> y;
    private boolean z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(com.bumptech.glide.f.f<ModelType, DataType, ResourceType, TranscodeType> fVar, Class<TranscodeType> cls, e<ModelType, ?, ?, ?> eVar) {
        this(eVar.f666b, eVar.f665a, fVar, cls, eVar.f667c, eVar.e, eVar.f);
        this.h = eVar.h;
        this.j = eVar.j;
        this.i = eVar.i;
        this.x = eVar.x;
        this.t = eVar.t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context, Class<ModelType> cls, com.bumptech.glide.f.f<ModelType, DataType, ResourceType, TranscodeType> fVar, Class<TranscodeType> cls2, i iVar, m mVar, com.bumptech.glide.d.g gVar) {
        this.i = com.bumptech.glide.h.b.a();
        this.p = Float.valueOf(1.0f);
        this.s = null;
        this.t = true;
        this.u = com.bumptech.glide.g.a.e.a();
        this.v = -1;
        this.w = -1;
        this.x = com.bumptech.glide.load.b.b.RESULT;
        this.y = com.bumptech.glide.load.resource.d.a();
        this.f666b = context;
        this.f665a = cls;
        this.d = cls2;
        this.f667c = iVar;
        this.e = mVar;
        this.f = gVar;
        this.g = fVar != null ? new com.bumptech.glide.f.a<>(fVar) : null;
        if (context == null) {
            throw new NullPointerException("Context can't be null");
        }
        if (cls != null && fVar == null) {
            throw new NullPointerException("LoadProvider must not be null");
        }
    }

    public e<ModelType, DataType, ResourceType, TranscodeType> b(com.bumptech.glide.load.e<DataType, ResourceType> eVar) {
        if (this.g != null) {
            this.g.a(eVar);
        }
        return this;
    }

    public e<ModelType, DataType, ResourceType, TranscodeType> b(com.bumptech.glide.load.b<DataType> bVar) {
        if (this.g != null) {
            this.g.a(bVar);
        }
        return this;
    }

    public e<ModelType, DataType, ResourceType, TranscodeType> b(com.bumptech.glide.load.b.b bVar) {
        this.x = bVar;
        return this;
    }

    public e<ModelType, DataType, ResourceType, TranscodeType> b(com.bumptech.glide.load.g<ResourceType>... gVarArr) {
        this.z = true;
        if (gVarArr.length == 1) {
            this.y = gVarArr[0];
        } else {
            this.y = new com.bumptech.glide.load.d(gVarArr);
        }
        return this;
    }

    public e<ModelType, DataType, ResourceType, TranscodeType> j() {
        return b((com.bumptech.glide.load.g[]) new com.bumptech.glide.load.g[]{com.bumptech.glide.load.resource.d.a()});
    }

    public e<ModelType, DataType, ResourceType, TranscodeType> i() {
        return a(com.bumptech.glide.g.a.e.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e<ModelType, DataType, ResourceType, TranscodeType> a(com.bumptech.glide.g.a.d<TranscodeType> dVar) {
        if (dVar == null) {
            throw new NullPointerException("Animation factory must not be null!");
        }
        this.u = dVar;
        return this;
    }

    public e<ModelType, DataType, ResourceType, TranscodeType> d(int i) {
        this.k = i;
        return this;
    }

    public e<ModelType, DataType, ResourceType, TranscodeType> b(Drawable drawable) {
        this.q = drawable;
        return this;
    }

    public e<ModelType, DataType, ResourceType, TranscodeType> c(int i) {
        this.l = i;
        return this;
    }

    public e<ModelType, DataType, ResourceType, TranscodeType> b(boolean z) {
        this.t = !z;
        return this;
    }

    public e<ModelType, DataType, ResourceType, TranscodeType> b(int i, int i2) {
        if (!com.bumptech.glide.i.h.a(i, i2)) {
            throw new IllegalArgumentException("Width and height must be Target#SIZE_ORIGINAL or > 0");
        }
        this.w = i;
        this.v = i2;
        return this;
    }

    public e<ModelType, DataType, ResourceType, TranscodeType> b(com.bumptech.glide.load.c cVar) {
        if (cVar == null) {
            throw new NullPointerException("Signature must not be null");
        }
        this.i = cVar;
        return this;
    }

    public e<ModelType, DataType, ResourceType, TranscodeType> b(ModelType modeltype) {
        this.h = modeltype;
        this.j = true;
        return this;
    }

    @Override // 
    /* renamed from: h */
    public e<ModelType, DataType, ResourceType, TranscodeType> clone() {
        try {
            e<ModelType, DataType, ResourceType, TranscodeType> eVar = (e) super.clone();
            eVar.g = this.g != null ? this.g.clone() : null;
            return eVar;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public <Y extends com.bumptech.glide.g.b.j<TranscodeType>> Y a(Y y) {
        com.bumptech.glide.i.h.a();
        if (y == null) {
            throw new IllegalArgumentException("You must pass in a non null Target");
        }
        if (!this.j) {
            throw new IllegalArgumentException("You must first set a model (try #load())");
        }
        com.bumptech.glide.g.b request = y.getRequest();
        if (request != null) {
            request.d();
            this.e.b(request);
            request.a();
        }
        com.bumptech.glide.g.b b2 = b((com.bumptech.glide.g.b.j) y);
        y.setRequest(b2);
        this.f.a(y);
        this.e.a(b2);
        return y;
    }

    public com.bumptech.glide.g.b.j<TranscodeType> a(ImageView imageView) {
        com.bumptech.glide.i.h.a();
        if (imageView == null) {
            throw new IllegalArgumentException("You must pass in a non null View");
        }
        if (!this.z && imageView.getScaleType() != null) {
            switch (AnonymousClass1.f668a[imageView.getScaleType().ordinal()]) {
                case 1:
                    g();
                    break;
                case 2:
                case 3:
                case 4:
                    f();
                    break;
            }
        }
        return a((e<ModelType, DataType, ResourceType, TranscodeType>) this.f667c.a(imageView, this.d));
    }

    /* compiled from: GenericRequestBuilder.java */
    /* renamed from: com.bumptech.glide.e$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f668a = new int[ImageView.ScaleType.values().length];

        static {
            try {
                f668a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f668a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f668a[ImageView.ScaleType.FIT_START.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f668a[ImageView.ScaleType.FIT_END.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    void g() {
    }

    void f() {
    }

    private k a() {
        if (this.s == k.LOW) {
            return k.NORMAL;
        }
        if (this.s == k.NORMAL) {
            return k.HIGH;
        }
        return k.IMMEDIATE;
    }

    private com.bumptech.glide.g.b b(com.bumptech.glide.g.b.j<TranscodeType> jVar) {
        if (this.s == null) {
            this.s = k.NORMAL;
        }
        return a(jVar, null);
    }

    private com.bumptech.glide.g.b a(com.bumptech.glide.g.b.j<TranscodeType> jVar, com.bumptech.glide.g.f fVar) {
        if (this.o != null) {
            if (this.A) {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
            if (this.o.u.equals(com.bumptech.glide.g.a.e.a())) {
                this.o.u = this.u;
            }
            if (this.o.s == null) {
                this.o.s = a();
            }
            if (com.bumptech.glide.i.h.a(this.w, this.v) && !com.bumptech.glide.i.h.a(this.o.w, this.o.v)) {
                this.o.b(this.w, this.v);
            }
            com.bumptech.glide.g.f fVar2 = new com.bumptech.glide.g.f(fVar);
            com.bumptech.glide.g.b a2 = a(jVar, this.p.floatValue(), this.s, fVar2);
            this.A = true;
            com.bumptech.glide.g.b a3 = this.o.a(jVar, fVar2);
            this.A = false;
            fVar2.a(a2, a3);
            return fVar2;
        } else if (this.n != null) {
            com.bumptech.glide.g.f fVar3 = new com.bumptech.glide.g.f(fVar);
            fVar3.a(a(jVar, this.p.floatValue(), this.s, fVar3), a(jVar, this.n.floatValue(), a(), fVar3));
            return fVar3;
        } else {
            return a(jVar, this.p.floatValue(), this.s, fVar);
        }
    }

    private com.bumptech.glide.g.b a(com.bumptech.glide.g.b.j<TranscodeType> jVar, float f, k kVar, com.bumptech.glide.g.c cVar) {
        return com.bumptech.glide.g.a.a(this.g, this.h, this.i, this.f666b, kVar, jVar, f, this.q, this.k, this.r, this.l, this.B, this.C, this.m, cVar, this.f667c.b(), this.y, this.d, this.t, this.u, this.w, this.v, this.x);
    }
}

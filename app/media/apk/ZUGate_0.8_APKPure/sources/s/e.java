package s;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public final class e extends ViewGroup.MarginLayoutParams {
    public int A;
    public int B;
    public final int C;
    public final int D;
    public float E;
    public float F;
    public String G;
    public float H;
    public float I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public float R;
    public float S;
    public int T;
    public int U;
    public int V;
    public boolean W;
    public boolean X;
    public String Y;
    public int Z;

    /* renamed from: a  reason: collision with root package name */
    public int f4652a;

    /* renamed from: a0  reason: collision with root package name */
    public boolean f4653a0;

    /* renamed from: b  reason: collision with root package name */
    public int f4654b;

    /* renamed from: b0  reason: collision with root package name */
    public boolean f4655b0;

    /* renamed from: c  reason: collision with root package name */
    public float f4656c;

    /* renamed from: c0  reason: collision with root package name */
    public boolean f4657c0;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f4658d;

    /* renamed from: d0  reason: collision with root package name */
    public boolean f4659d0;

    /* renamed from: e  reason: collision with root package name */
    public int f4660e;

    /* renamed from: e0  reason: collision with root package name */
    public boolean f4661e0;

    /* renamed from: f  reason: collision with root package name */
    public int f4662f;

    /* renamed from: f0  reason: collision with root package name */
    public int f4663f0;

    /* renamed from: g  reason: collision with root package name */
    public int f4664g;

    /* renamed from: g0  reason: collision with root package name */
    public int f4665g0;

    /* renamed from: h  reason: collision with root package name */
    public int f4666h;

    /* renamed from: h0  reason: collision with root package name */
    public int f4667h0;

    /* renamed from: i  reason: collision with root package name */
    public int f4668i;

    /* renamed from: i0  reason: collision with root package name */
    public int f4669i0;

    /* renamed from: j  reason: collision with root package name */
    public int f4670j;

    /* renamed from: j0  reason: collision with root package name */
    public int f4671j0;

    /* renamed from: k  reason: collision with root package name */
    public int f4672k;

    /* renamed from: k0  reason: collision with root package name */
    public int f4673k0;

    /* renamed from: l  reason: collision with root package name */
    public int f4674l;

    /* renamed from: l0  reason: collision with root package name */
    public float f4675l0;

    /* renamed from: m  reason: collision with root package name */
    public int f4676m;

    /* renamed from: m0  reason: collision with root package name */
    public int f4677m0;

    /* renamed from: n  reason: collision with root package name */
    public int f4678n;

    /* renamed from: n0  reason: collision with root package name */
    public int f4679n0;
    public int o;

    /* renamed from: o0  reason: collision with root package name */
    public float f4680o0;

    /* renamed from: p  reason: collision with root package name */
    public int f4681p;

    /* renamed from: p0  reason: collision with root package name */
    public p.e f4682p0;

    /* renamed from: q  reason: collision with root package name */
    public int f4683q;

    /* renamed from: r  reason: collision with root package name */
    public float f4684r;

    /* renamed from: s  reason: collision with root package name */
    public int f4685s;

    /* renamed from: t  reason: collision with root package name */
    public int f4686t;

    /* renamed from: u  reason: collision with root package name */
    public int f4687u;

    /* renamed from: v  reason: collision with root package name */
    public int f4688v;

    /* renamed from: w  reason: collision with root package name */
    public final int f4689w;

    /* renamed from: x  reason: collision with root package name */
    public int f4690x;

    /* renamed from: y  reason: collision with root package name */
    public final int f4691y;

    /* renamed from: z  reason: collision with root package name */
    public int f4692z;

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4652a = -1;
        this.f4654b = -1;
        this.f4656c = -1.0f;
        this.f4658d = true;
        this.f4660e = -1;
        this.f4662f = -1;
        this.f4664g = -1;
        this.f4666h = -1;
        this.f4668i = -1;
        this.f4670j = -1;
        this.f4672k = -1;
        this.f4674l = -1;
        this.f4676m = -1;
        this.f4678n = -1;
        this.o = -1;
        this.f4681p = -1;
        this.f4683q = 0;
        this.f4684r = 0.0f;
        this.f4685s = -1;
        this.f4686t = -1;
        this.f4687u = -1;
        this.f4688v = -1;
        this.f4689w = Integer.MIN_VALUE;
        this.f4690x = Integer.MIN_VALUE;
        this.f4691y = Integer.MIN_VALUE;
        this.f4692z = Integer.MIN_VALUE;
        this.A = Integer.MIN_VALUE;
        this.B = Integer.MIN_VALUE;
        this.C = Integer.MIN_VALUE;
        this.D = 0;
        this.E = 0.5f;
        this.F = 0.5f;
        this.G = null;
        this.H = -1.0f;
        this.I = -1.0f;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 1.0f;
        this.S = 1.0f;
        this.T = -1;
        this.U = -1;
        this.V = -1;
        this.W = false;
        this.X = false;
        this.Y = null;
        this.Z = 0;
        this.f4653a0 = true;
        this.f4655b0 = true;
        this.f4657c0 = false;
        this.f4659d0 = false;
        this.f4661e0 = false;
        this.f4663f0 = -1;
        this.f4665g0 = -1;
        this.f4667h0 = -1;
        this.f4669i0 = -1;
        this.f4671j0 = Integer.MIN_VALUE;
        this.f4673k0 = Integer.MIN_VALUE;
        this.f4675l0 = 0.5f;
        this.f4682p0 = new p.e();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, q.f4794b);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i5 = 0; i5 < indexCount; i5++) {
            int index = obtainStyledAttributes.getIndex(i5);
            int i6 = d.f4651a.get(index);
            switch (i6) {
                case 1:
                    this.V = obtainStyledAttributes.getInt(index, this.V);
                    break;
                case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                    int resourceId = obtainStyledAttributes.getResourceId(index, this.f4681p);
                    this.f4681p = resourceId;
                    if (resourceId == -1) {
                        this.f4681p = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    this.f4683q = obtainStyledAttributes.getDimensionPixelSize(index, this.f4683q);
                    break;
                case 4:
                    float f5 = obtainStyledAttributes.getFloat(index, this.f4684r) % 360.0f;
                    this.f4684r = f5;
                    if (f5 < 0.0f) {
                        this.f4684r = (360.0f - f5) % 360.0f;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    this.f4652a = obtainStyledAttributes.getDimensionPixelOffset(index, this.f4652a);
                    break;
                case 6:
                    this.f4654b = obtainStyledAttributes.getDimensionPixelOffset(index, this.f4654b);
                    break;
                case 7:
                    this.f4656c = obtainStyledAttributes.getFloat(index, this.f4656c);
                    break;
                case 8:
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, this.f4660e);
                    this.f4660e = resourceId2;
                    if (resourceId2 == -1) {
                        this.f4660e = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    int resourceId3 = obtainStyledAttributes.getResourceId(index, this.f4662f);
                    this.f4662f = resourceId3;
                    if (resourceId3 == -1) {
                        this.f4662f = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 10:
                    int resourceId4 = obtainStyledAttributes.getResourceId(index, this.f4664g);
                    this.f4664g = resourceId4;
                    if (resourceId4 == -1) {
                        this.f4664g = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    int resourceId5 = obtainStyledAttributes.getResourceId(index, this.f4666h);
                    this.f4666h = resourceId5;
                    if (resourceId5 == -1) {
                        this.f4666h = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    int resourceId6 = obtainStyledAttributes.getResourceId(index, this.f4668i);
                    this.f4668i = resourceId6;
                    if (resourceId6 == -1) {
                        this.f4668i = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    int resourceId7 = obtainStyledAttributes.getResourceId(index, this.f4670j);
                    this.f4670j = resourceId7;
                    if (resourceId7 == -1) {
                        this.f4670j = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    int resourceId8 = obtainStyledAttributes.getResourceId(index, this.f4672k);
                    this.f4672k = resourceId8;
                    if (resourceId8 == -1) {
                        this.f4672k = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    int resourceId9 = obtainStyledAttributes.getResourceId(index, this.f4674l);
                    this.f4674l = resourceId9;
                    if (resourceId9 == -1) {
                        this.f4674l = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    int resourceId10 = obtainStyledAttributes.getResourceId(index, this.f4676m);
                    this.f4676m = resourceId10;
                    if (resourceId10 == -1) {
                        this.f4676m = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    int resourceId11 = obtainStyledAttributes.getResourceId(index, this.f4685s);
                    this.f4685s = resourceId11;
                    if (resourceId11 == -1) {
                        this.f4685s = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 18:
                    int resourceId12 = obtainStyledAttributes.getResourceId(index, this.f4686t);
                    this.f4686t = resourceId12;
                    if (resourceId12 == -1) {
                        this.f4686t = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 19:
                    int resourceId13 = obtainStyledAttributes.getResourceId(index, this.f4687u);
                    this.f4687u = resourceId13;
                    if (resourceId13 == -1) {
                        this.f4687u = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 20:
                    int resourceId14 = obtainStyledAttributes.getResourceId(index, this.f4688v);
                    this.f4688v = resourceId14;
                    if (resourceId14 == -1) {
                        this.f4688v = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 21:
                    this.f4689w = obtainStyledAttributes.getDimensionPixelSize(index, this.f4689w);
                    break;
                case 22:
                    this.f4690x = obtainStyledAttributes.getDimensionPixelSize(index, this.f4690x);
                    break;
                case 23:
                    this.f4691y = obtainStyledAttributes.getDimensionPixelSize(index, this.f4691y);
                    break;
                case 24:
                    this.f4692z = obtainStyledAttributes.getDimensionPixelSize(index, this.f4692z);
                    break;
                case 25:
                    this.A = obtainStyledAttributes.getDimensionPixelSize(index, this.A);
                    break;
                case 26:
                    this.B = obtainStyledAttributes.getDimensionPixelSize(index, this.B);
                    break;
                case 27:
                    this.W = obtainStyledAttributes.getBoolean(index, this.W);
                    break;
                case 28:
                    this.X = obtainStyledAttributes.getBoolean(index, this.X);
                    break;
                case 29:
                    this.E = obtainStyledAttributes.getFloat(index, this.E);
                    break;
                case 30:
                    this.F = obtainStyledAttributes.getFloat(index, this.F);
                    break;
                case 31:
                    int i7 = obtainStyledAttributes.getInt(index, 0);
                    this.L = i7;
                    if (i7 == 1) {
                        Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                        break;
                    } else {
                        break;
                    }
                case 32:
                    int i8 = obtainStyledAttributes.getInt(index, 0);
                    this.M = i8;
                    if (i8 == 1) {
                        Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                        break;
                    } else {
                        break;
                    }
                case 33:
                    try {
                        this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                        break;
                    } catch (Exception unused) {
                        if (obtainStyledAttributes.getInt(index, this.N) == -2) {
                            this.N = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 34:
                    try {
                        this.P = obtainStyledAttributes.getDimensionPixelSize(index, this.P);
                        break;
                    } catch (Exception unused2) {
                        if (obtainStyledAttributes.getInt(index, this.P) == -2) {
                            this.P = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 35:
                    this.R = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.R));
                    this.L = 2;
                    break;
                case 36:
                    try {
                        this.O = obtainStyledAttributes.getDimensionPixelSize(index, this.O);
                        break;
                    } catch (Exception unused3) {
                        if (obtainStyledAttributes.getInt(index, this.O) == -2) {
                            this.O = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 37:
                    try {
                        this.Q = obtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                        break;
                    } catch (Exception unused4) {
                        if (obtainStyledAttributes.getInt(index, this.Q) == -2) {
                            this.Q = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 38:
                    this.S = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.S));
                    this.M = 2;
                    break;
                default:
                    switch (i6) {
                        case 44:
                            n.h(this, obtainStyledAttributes.getString(index));
                            continue;
                        case 45:
                            this.H = obtainStyledAttributes.getFloat(index, this.H);
                            continue;
                        case 46:
                            this.I = obtainStyledAttributes.getFloat(index, this.I);
                            continue;
                        case 47:
                            this.J = obtainStyledAttributes.getInt(index, 0);
                            continue;
                        case 48:
                            this.K = obtainStyledAttributes.getInt(index, 0);
                            continue;
                        case 49:
                            this.T = obtainStyledAttributes.getDimensionPixelOffset(index, this.T);
                            continue;
                        case 50:
                            this.U = obtainStyledAttributes.getDimensionPixelOffset(index, this.U);
                            continue;
                        case 51:
                            this.Y = obtainStyledAttributes.getString(index);
                            continue;
                        case 52:
                            int resourceId15 = obtainStyledAttributes.getResourceId(index, this.f4678n);
                            this.f4678n = resourceId15;
                            if (resourceId15 == -1) {
                                this.f4678n = obtainStyledAttributes.getInt(index, -1);
                                break;
                            } else {
                                continue;
                            }
                        case 53:
                            int resourceId16 = obtainStyledAttributes.getResourceId(index, this.o);
                            this.o = resourceId16;
                            if (resourceId16 == -1) {
                                this.o = obtainStyledAttributes.getInt(index, -1);
                                break;
                            } else {
                                continue;
                            }
                        case 54:
                            this.D = obtainStyledAttributes.getDimensionPixelSize(index, this.D);
                            continue;
                        case 55:
                            this.C = obtainStyledAttributes.getDimensionPixelSize(index, this.C);
                            continue;
                        default:
                            switch (i6) {
                                case 64:
                                    n.g(this, obtainStyledAttributes, index, 0);
                                    continue;
                                    continue;
                                case 65:
                                    n.g(this, obtainStyledAttributes, index, 1);
                                    continue;
                                case 66:
                                    this.Z = obtainStyledAttributes.getInt(index, this.Z);
                                    continue;
                                case 67:
                                    this.f4658d = obtainStyledAttributes.getBoolean(index, this.f4658d);
                                    continue;
                            }
                    }
            }
        }
        obtainStyledAttributes.recycle();
        a();
    }

    public final void a() {
        this.f4659d0 = false;
        this.f4653a0 = true;
        this.f4655b0 = true;
        int i5 = ((ViewGroup.MarginLayoutParams) this).width;
        if (i5 == -2 && this.W) {
            this.f4653a0 = false;
            if (this.L == 0) {
                this.L = 1;
            }
        }
        int i6 = ((ViewGroup.MarginLayoutParams) this).height;
        if (i6 == -2 && this.X) {
            this.f4655b0 = false;
            if (this.M == 0) {
                this.M = 1;
            }
        }
        if (i5 == 0 || i5 == -1) {
            this.f4653a0 = false;
            if (i5 == 0 && this.L == 1) {
                ((ViewGroup.MarginLayoutParams) this).width = -2;
                this.W = true;
            }
        }
        if (i6 == 0 || i6 == -1) {
            this.f4655b0 = false;
            if (i6 == 0 && this.M == 1) {
                ((ViewGroup.MarginLayoutParams) this).height = -2;
                this.X = true;
            }
        }
        if (this.f4656c == -1.0f && this.f4652a == -1 && this.f4654b == -1) {
            return;
        }
        this.f4659d0 = true;
        this.f4653a0 = true;
        this.f4655b0 = true;
        if (!(this.f4682p0 instanceof p.i)) {
            this.f4682p0 = new p.i();
        }
        ((p.i) this.f4682p0).S(this.V);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0082  */
    @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void resolveLayoutDirection(int r11) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s.e.resolveLayoutDirection(int):void");
    }

    public e() {
        super(-2, -2);
        this.f4652a = -1;
        this.f4654b = -1;
        this.f4656c = -1.0f;
        this.f4658d = true;
        this.f4660e = -1;
        this.f4662f = -1;
        this.f4664g = -1;
        this.f4666h = -1;
        this.f4668i = -1;
        this.f4670j = -1;
        this.f4672k = -1;
        this.f4674l = -1;
        this.f4676m = -1;
        this.f4678n = -1;
        this.o = -1;
        this.f4681p = -1;
        this.f4683q = 0;
        this.f4684r = 0.0f;
        this.f4685s = -1;
        this.f4686t = -1;
        this.f4687u = -1;
        this.f4688v = -1;
        this.f4689w = Integer.MIN_VALUE;
        this.f4690x = Integer.MIN_VALUE;
        this.f4691y = Integer.MIN_VALUE;
        this.f4692z = Integer.MIN_VALUE;
        this.A = Integer.MIN_VALUE;
        this.B = Integer.MIN_VALUE;
        this.C = Integer.MIN_VALUE;
        this.D = 0;
        this.E = 0.5f;
        this.F = 0.5f;
        this.G = null;
        this.H = -1.0f;
        this.I = -1.0f;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 1.0f;
        this.S = 1.0f;
        this.T = -1;
        this.U = -1;
        this.V = -1;
        this.W = false;
        this.X = false;
        this.Y = null;
        this.Z = 0;
        this.f4653a0 = true;
        this.f4655b0 = true;
        this.f4657c0 = false;
        this.f4659d0 = false;
        this.f4661e0 = false;
        this.f4663f0 = -1;
        this.f4665g0 = -1;
        this.f4667h0 = -1;
        this.f4669i0 = -1;
        this.f4671j0 = Integer.MIN_VALUE;
        this.f4673k0 = Integer.MIN_VALUE;
        this.f4675l0 = 0.5f;
        this.f4682p0 = new p.e();
    }

    public e(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f4652a = -1;
        this.f4654b = -1;
        this.f4656c = -1.0f;
        this.f4658d = true;
        this.f4660e = -1;
        this.f4662f = -1;
        this.f4664g = -1;
        this.f4666h = -1;
        this.f4668i = -1;
        this.f4670j = -1;
        this.f4672k = -1;
        this.f4674l = -1;
        this.f4676m = -1;
        this.f4678n = -1;
        this.o = -1;
        this.f4681p = -1;
        this.f4683q = 0;
        this.f4684r = 0.0f;
        this.f4685s = -1;
        this.f4686t = -1;
        this.f4687u = -1;
        this.f4688v = -1;
        this.f4689w = Integer.MIN_VALUE;
        this.f4690x = Integer.MIN_VALUE;
        this.f4691y = Integer.MIN_VALUE;
        this.f4692z = Integer.MIN_VALUE;
        this.A = Integer.MIN_VALUE;
        this.B = Integer.MIN_VALUE;
        this.C = Integer.MIN_VALUE;
        this.D = 0;
        this.E = 0.5f;
        this.F = 0.5f;
        this.G = null;
        this.H = -1.0f;
        this.I = -1.0f;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 1.0f;
        this.S = 1.0f;
        this.T = -1;
        this.U = -1;
        this.V = -1;
        this.W = false;
        this.X = false;
        this.Y = null;
        this.Z = 0;
        this.f4653a0 = true;
        this.f4655b0 = true;
        this.f4657c0 = false;
        this.f4659d0 = false;
        this.f4661e0 = false;
        this.f4663f0 = -1;
        this.f4665g0 = -1;
        this.f4667h0 = -1;
        this.f4669i0 = -1;
        this.f4671j0 = Integer.MIN_VALUE;
        this.f4673k0 = Integer.MIN_VALUE;
        this.f4675l0 = 0.5f;
        this.f4682p0 = new p.e();
    }
}

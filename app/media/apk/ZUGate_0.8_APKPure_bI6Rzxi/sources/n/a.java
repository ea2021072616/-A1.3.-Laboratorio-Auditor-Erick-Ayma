package n;

import androidx.appcompat.widget.b0;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class a implements b {

    /* renamed from: b  reason: collision with root package name */
    public final c f3994b;

    /* renamed from: c  reason: collision with root package name */
    public final g.f f3995c;

    /* renamed from: a  reason: collision with root package name */
    public int f3993a = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f3996d = 8;

    /* renamed from: e  reason: collision with root package name */
    public int[] f3997e = new int[8];

    /* renamed from: f  reason: collision with root package name */
    public int[] f3998f = new int[8];

    /* renamed from: g  reason: collision with root package name */
    public float[] f3999g = new float[8];

    /* renamed from: h  reason: collision with root package name */
    public int f4000h = -1;

    /* renamed from: i  reason: collision with root package name */
    public int f4001i = -1;

    /* renamed from: j  reason: collision with root package name */
    public boolean f4002j = false;

    public a(c cVar, g.f fVar) {
        this.f3994b = cVar;
        this.f3995c = fVar;
    }

    @Override // n.b
    public final float a(int i5) {
        int i6 = this.f4000h;
        for (int i7 = 0; i6 != -1 && i7 < this.f3993a; i7++) {
            if (i7 == i5) {
                return this.f3999g[i6];
            }
            i6 = this.f3998f[i6];
        }
        return 0.0f;
    }

    @Override // n.b
    public final float b(i iVar) {
        int i5 = this.f4000h;
        for (int i6 = 0; i5 != -1 && i6 < this.f3993a; i6++) {
            if (this.f3997e[i5] == iVar.f4034c) {
                return this.f3999g[i5];
            }
            i5 = this.f3998f[i5];
        }
        return 0.0f;
    }

    @Override // n.b
    public final void c(i iVar, float f5, boolean z4) {
        if (f5 <= -0.001f || f5 >= 0.001f) {
            int i5 = this.f4000h;
            c cVar = this.f3994b;
            if (i5 == -1) {
                this.f4000h = 0;
                this.f3999g[0] = f5;
                this.f3997e[0] = iVar.f4034c;
                this.f3998f[0] = -1;
                iVar.f4043l++;
                iVar.a(cVar);
                this.f3993a++;
                if (this.f4002j) {
                    return;
                }
                int i6 = this.f4001i + 1;
                this.f4001i = i6;
                int[] iArr = this.f3997e;
                if (i6 >= iArr.length) {
                    this.f4002j = true;
                    this.f4001i = iArr.length - 1;
                    return;
                }
                return;
            }
            int i7 = -1;
            for (int i8 = 0; i5 != -1 && i8 < this.f3993a; i8++) {
                int i9 = this.f3997e[i5];
                int i10 = iVar.f4034c;
                if (i9 == i10) {
                    float[] fArr = this.f3999g;
                    float f6 = fArr[i5] + f5;
                    if (f6 > -0.001f && f6 < 0.001f) {
                        f6 = 0.0f;
                    }
                    fArr[i5] = f6;
                    if (f6 == 0.0f) {
                        if (i5 == this.f4000h) {
                            this.f4000h = this.f3998f[i5];
                        } else {
                            int[] iArr2 = this.f3998f;
                            iArr2[i7] = iArr2[i5];
                        }
                        if (z4) {
                            iVar.b(cVar);
                        }
                        if (this.f4002j) {
                            this.f4001i = i5;
                        }
                        iVar.f4043l--;
                        this.f3993a--;
                        return;
                    }
                    return;
                }
                if (i9 < i10) {
                    i7 = i5;
                }
                i5 = this.f3998f[i5];
            }
            int i11 = this.f4001i;
            int i12 = i11 + 1;
            if (this.f4002j) {
                int[] iArr3 = this.f3997e;
                if (iArr3[i11] != -1) {
                    i11 = iArr3.length;
                }
            } else {
                i11 = i12;
            }
            int[] iArr4 = this.f3997e;
            if (i11 >= iArr4.length && this.f3993a < iArr4.length) {
                int i13 = 0;
                while (true) {
                    int[] iArr5 = this.f3997e;
                    if (i13 >= iArr5.length) {
                        break;
                    } else if (iArr5[i13] == -1) {
                        i11 = i13;
                        break;
                    } else {
                        i13++;
                    }
                }
            }
            int[] iArr6 = this.f3997e;
            if (i11 >= iArr6.length) {
                i11 = iArr6.length;
                int i14 = this.f3996d * 2;
                this.f3996d = i14;
                this.f4002j = false;
                this.f4001i = i11 - 1;
                this.f3999g = Arrays.copyOf(this.f3999g, i14);
                this.f3997e = Arrays.copyOf(this.f3997e, this.f3996d);
                this.f3998f = Arrays.copyOf(this.f3998f, this.f3996d);
            }
            this.f3997e[i11] = iVar.f4034c;
            this.f3999g[i11] = f5;
            if (i7 != -1) {
                int[] iArr7 = this.f3998f;
                iArr7[i11] = iArr7[i7];
                iArr7[i7] = i11;
            } else {
                this.f3998f[i11] = this.f4000h;
                this.f4000h = i11;
            }
            iVar.f4043l++;
            iVar.a(cVar);
            this.f3993a++;
            if (!this.f4002j) {
                this.f4001i++;
            }
            int i15 = this.f4001i;
            int[] iArr8 = this.f3997e;
            if (i15 >= iArr8.length) {
                this.f4002j = true;
                this.f4001i = iArr8.length - 1;
            }
        }
    }

    @Override // n.b
    public final void clear() {
        int i5 = this.f4000h;
        for (int i6 = 0; i5 != -1 && i6 < this.f3993a; i6++) {
            i iVar = ((i[]) this.f3995c.f2880d)[this.f3997e[i5]];
            if (iVar != null) {
                iVar.b(this.f3994b);
            }
            i5 = this.f3998f[i5];
        }
        this.f4000h = -1;
        this.f4001i = -1;
        this.f4002j = false;
        this.f3993a = 0;
    }

    @Override // n.b
    public final float d(c cVar, boolean z4) {
        float b5 = b(cVar.f4003a);
        i(cVar.f4003a, z4);
        b bVar = cVar.f4006d;
        int k5 = bVar.k();
        for (int i5 = 0; i5 < k5; i5++) {
            i f5 = bVar.f(i5);
            c(f5, bVar.b(f5) * b5, z4);
        }
        return b5;
    }

    @Override // n.b
    public final boolean e(i iVar) {
        int i5 = this.f4000h;
        if (i5 == -1) {
            return false;
        }
        for (int i6 = 0; i5 != -1 && i6 < this.f3993a; i6++) {
            if (this.f3997e[i5] == iVar.f4034c) {
                return true;
            }
            i5 = this.f3998f[i5];
        }
        return false;
    }

    @Override // n.b
    public final i f(int i5) {
        int i6 = this.f4000h;
        for (int i7 = 0; i6 != -1 && i7 < this.f3993a; i7++) {
            if (i7 == i5) {
                return ((i[]) this.f3995c.f2880d)[this.f3997e[i6]];
            }
            i6 = this.f3998f[i6];
        }
        return null;
    }

    @Override // n.b
    public final void g(i iVar, float f5) {
        if (f5 == 0.0f) {
            i(iVar, true);
            return;
        }
        int i5 = this.f4000h;
        c cVar = this.f3994b;
        if (i5 == -1) {
            this.f4000h = 0;
            this.f3999g[0] = f5;
            this.f3997e[0] = iVar.f4034c;
            this.f3998f[0] = -1;
            iVar.f4043l++;
            iVar.a(cVar);
            this.f3993a++;
            if (this.f4002j) {
                return;
            }
            int i6 = this.f4001i + 1;
            this.f4001i = i6;
            int[] iArr = this.f3997e;
            if (i6 >= iArr.length) {
                this.f4002j = true;
                this.f4001i = iArr.length - 1;
                return;
            }
            return;
        }
        int i7 = -1;
        for (int i8 = 0; i5 != -1 && i8 < this.f3993a; i8++) {
            int i9 = this.f3997e[i5];
            int i10 = iVar.f4034c;
            if (i9 == i10) {
                this.f3999g[i5] = f5;
                return;
            }
            if (i9 < i10) {
                i7 = i5;
            }
            i5 = this.f3998f[i5];
        }
        int i11 = this.f4001i;
        int i12 = i11 + 1;
        if (this.f4002j) {
            int[] iArr2 = this.f3997e;
            if (iArr2[i11] != -1) {
                i11 = iArr2.length;
            }
        } else {
            i11 = i12;
        }
        int[] iArr3 = this.f3997e;
        if (i11 >= iArr3.length && this.f3993a < iArr3.length) {
            int i13 = 0;
            while (true) {
                int[] iArr4 = this.f3997e;
                if (i13 >= iArr4.length) {
                    break;
                } else if (iArr4[i13] == -1) {
                    i11 = i13;
                    break;
                } else {
                    i13++;
                }
            }
        }
        int[] iArr5 = this.f3997e;
        if (i11 >= iArr5.length) {
            i11 = iArr5.length;
            int i14 = this.f3996d * 2;
            this.f3996d = i14;
            this.f4002j = false;
            this.f4001i = i11 - 1;
            this.f3999g = Arrays.copyOf(this.f3999g, i14);
            this.f3997e = Arrays.copyOf(this.f3997e, this.f3996d);
            this.f3998f = Arrays.copyOf(this.f3998f, this.f3996d);
        }
        this.f3997e[i11] = iVar.f4034c;
        this.f3999g[i11] = f5;
        if (i7 != -1) {
            int[] iArr6 = this.f3998f;
            iArr6[i11] = iArr6[i7];
            iArr6[i7] = i11;
        } else {
            this.f3998f[i11] = this.f4000h;
            this.f4000h = i11;
        }
        iVar.f4043l++;
        iVar.a(cVar);
        int i15 = this.f3993a + 1;
        this.f3993a = i15;
        if (!this.f4002j) {
            this.f4001i++;
        }
        int[] iArr7 = this.f3997e;
        if (i15 >= iArr7.length) {
            this.f4002j = true;
        }
        if (this.f4001i >= iArr7.length) {
            this.f4002j = true;
            this.f4001i = iArr7.length - 1;
        }
    }

    @Override // n.b
    public final void h(float f5) {
        int i5 = this.f4000h;
        for (int i6 = 0; i5 != -1 && i6 < this.f3993a; i6++) {
            float[] fArr = this.f3999g;
            fArr[i5] = fArr[i5] / f5;
            i5 = this.f3998f[i5];
        }
    }

    @Override // n.b
    public final float i(i iVar, boolean z4) {
        int i5 = this.f4000h;
        if (i5 == -1) {
            return 0.0f;
        }
        int i6 = 0;
        int i7 = -1;
        while (i5 != -1 && i6 < this.f3993a) {
            if (this.f3997e[i5] == iVar.f4034c) {
                if (i5 == this.f4000h) {
                    this.f4000h = this.f3998f[i5];
                } else {
                    int[] iArr = this.f3998f;
                    iArr[i7] = iArr[i5];
                }
                if (z4) {
                    iVar.b(this.f3994b);
                }
                iVar.f4043l--;
                this.f3993a--;
                this.f3997e[i5] = -1;
                if (this.f4002j) {
                    this.f4001i = i5;
                }
                return this.f3999g[i5];
            }
            i6++;
            i7 = i5;
            i5 = this.f3998f[i5];
        }
        return 0.0f;
    }

    @Override // n.b
    public final void j() {
        int i5 = this.f4000h;
        for (int i6 = 0; i5 != -1 && i6 < this.f3993a; i6++) {
            float[] fArr = this.f3999g;
            fArr[i5] = fArr[i5] * (-1.0f);
            i5 = this.f3998f[i5];
        }
    }

    @Override // n.b
    public final int k() {
        return this.f3993a;
    }

    public final String toString() {
        int i5 = this.f4000h;
        String str = "";
        for (int i6 = 0; i5 != -1 && i6 < this.f3993a; i6++) {
            str = (b0.h(str, " -> ") + this.f3999g[i5] + " : ") + ((i[]) this.f3995c.f2880d)[this.f3997e[i5]];
            i5 = this.f3998f[i5];
        }
        return str;
    }
}

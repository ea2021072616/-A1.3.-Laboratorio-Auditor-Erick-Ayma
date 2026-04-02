package l2;

import androidx.lifecycle.r0;
import androidx.lifecycle.t0;
import com.google.android.gms.internal.play_billing.h2;
import com.google.android.gms.internal.play_billing.q0;
/* loaded from: classes.dex */
public class i implements t0, c4.e, q0, f0.f {

    /* renamed from: g  reason: collision with root package name */
    public static i f3853g;

    /* renamed from: k  reason: collision with root package name */
    public static i f3857k;

    /* renamed from: h  reason: collision with root package name */
    public static final i f3854h = new i();

    /* renamed from: i  reason: collision with root package name */
    public static final i f3855i = new i();

    /* renamed from: j  reason: collision with root package name */
    public static final i f3856j = new i();

    /* renamed from: l  reason: collision with root package name */
    public static final /* synthetic */ i f3858l = new i();

    /* renamed from: m  reason: collision with root package name */
    public static final i f3859m = new i();

    public i() {
    }

    public static synchronized i d() {
        i iVar;
        synchronized (i.class) {
            if (f3853g == null) {
                f3853g = new i();
            }
            iVar = f3853g;
        }
        return iVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean e(byte[] bArr, int i5, int i6) {
        int i7;
        while (i5 < i6 && bArr[i5] >= 0) {
            i5++;
        }
        if (i5 < i6) {
            while (i5 < i6) {
                int i8 = i5 + 1;
                i7 = bArr[i5];
                if (i7 < 0) {
                    if (i7 >= -32) {
                        if (i7 >= -16) {
                            if (i8 < i6 - 2) {
                                int i9 = i8 + 1;
                                int i10 = bArr[i8];
                                if (i10 <= -65) {
                                    if ((((i10 + 112) + (i7 << 28)) >> 30) == 0) {
                                        int i11 = i9 + 1;
                                        if (bArr[i9] <= -65) {
                                            i8 = i11 + 1;
                                            if (bArr[i11] > -65) {
                                            }
                                        }
                                    }
                                }
                                i7 = -1;
                                break;
                            }
                            i7 = h2.a(bArr, i8, i6);
                            break;
                        } else if (i8 < i6 - 1) {
                            int i12 = i8 + 1;
                            char c5 = bArr[i8];
                            if (c5 <= -65 && ((i7 != -32 || c5 >= -96) && (i7 != -19 || c5 < -96))) {
                                i5 = i12 + 1;
                                if (bArr[i12] > -65) {
                                }
                            }
                            i7 = -1;
                            break;
                        } else {
                            i7 = h2.a(bArr, i8, i6);
                            break;
                        }
                    } else if (i8 >= i6) {
                        break;
                    } else {
                        if (i7 >= -62) {
                            i5 = i8 + 1;
                            if (bArr[i8] > -65) {
                            }
                        }
                        i7 = -1;
                        break;
                    }
                }
                i5 = i8;
            }
        }
        i7 = 0;
        return i7 == 0;
    }

    @Override // androidx.lifecycle.t0
    public r0 a(Class cls) {
        try {
            Object newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            e4.e.e(newInstance, "{\n                modelC…wInstance()\n            }");
            return (r0) newInstance;
        } catch (IllegalAccessException e5) {
            throw new RuntimeException("Cannot create an instance of " + cls, e5);
        } catch (InstantiationException e6) {
            throw new RuntimeException("Cannot create an instance of " + cls, e6);
        } catch (NoSuchMethodException e7) {
            throw new RuntimeException("Cannot create an instance of " + cls, e7);
        }
    }

    @Override // f0.f
    public int b(CharSequence charSequence, int i5) {
        int i6 = i5 + 0;
        int i7 = 2;
        for (int i8 = 0; i8 < i6 && i7 == 2; i8++) {
            byte directionality = Character.getDirectionality(charSequence.charAt(i8));
            f0.h hVar = f0.i.f2739a;
            if (directionality != 0) {
                if (directionality != 1 && directionality != 2) {
                    switch (directionality) {
                        case 14:
                        case 15:
                            break;
                        case 16:
                        case 17:
                            break;
                        default:
                            i7 = 2;
                            break;
                    }
                }
                i7 = 0;
            }
            i7 = 1;
        }
        return i7;
    }

    public /* synthetic */ i(Object obj) {
    }
}

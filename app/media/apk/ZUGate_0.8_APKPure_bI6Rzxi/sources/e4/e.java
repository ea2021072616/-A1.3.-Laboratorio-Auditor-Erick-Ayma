package e4;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.usb.UsbManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.ParcelFileDescriptor;
import android.os.storage.StorageManager;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import androidx.appcompat.widget.b0;
import androidx.appcompat.widget.l1;
import com.google.android.gms.internal.play_billing.z;
import e1.d0;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import p.i;
import q.m;
import ru.zdevs.zugate.ZApp;
import t4.r;
import w4.g;
import w4.j;
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f2707b = true;

    /* renamed from: c  reason: collision with root package name */
    public static Field f2708c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f2709d;

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ int f2711f = 0;

    /* renamed from: a  reason: collision with root package name */
    public static final z0.d f2706a = new z0.d(14, null);

    /* renamed from: e  reason: collision with root package name */
    public static final z0.d f2710e = new z0.d(16, null);

    /* renamed from: g  reason: collision with root package name */
    public static final q.b f2712g = new q.b();

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f2713h = {"ru", "uk"};

    /* renamed from: i  reason: collision with root package name */
    public static final j[] f2714i = {new j(1507, 1794, 256), new j(1507, 1865, 1024), new j(1659, 9479, 256), new j(1659, 9478, 8192), new j(1659, 13575, 256), new j(1423, 25479, 7168), new j(1423, 37729, 2048), new j(1423, -1, 5120), new j(4101, 45331, 5120), new j(5421, 13673, 2048), new j(5421, 1383, 2048), new j(5421, 9016, 4096), new j(1921, 21889, 5120), new j(2385, 5675, 512), new j(2385, 5734, 12288), new j(2352, 25925, 12288), new j(5117, -1, 4096), new j(4184, 1857, 1024), new j(4184, 1862, 1024), new j(4184, 1864, 1024), new j(4184, 1866, 1024), new j(4184, 1868, 1024), new j(4184, 1870, 1024), new j(4184, 1958, 1024), new j(4184, 1960, 1024), new j(4184, 1962, 1024), new j(4184, 1964, 1024), new j(4184, 1966, 1024), new j(4184, 1802, 1024), new j(4184, 1818, 1024), new j(4184, 1840, 1024), new j(4184, 1842, 1024), new j(4184, 1856, 1024), new j(4184, 1858, 1024), new j(4184, 1872, 1024), new j(4184, 1874, 1024), new j(4184, 1952, 1024), new j(4184, 1954, 1024), new j(4184, 1859, 1024)};

    /* renamed from: j  reason: collision with root package name */
    public static final float[][] f2715j = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};

    /* renamed from: k  reason: collision with root package name */
    public static final float[][] f2716k = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};

    /* renamed from: l  reason: collision with root package name */
    public static final float[] f2717l = {95.047f, 100.0f, 108.883f};

    /* renamed from: m  reason: collision with root package name */
    public static final float[][] f2718m = {new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};

    /* renamed from: n  reason: collision with root package name */
    public static final byte[] f2719n = {112, 114, 111, 0};
    public static final byte[] o = {112, 114, 109, 0};

    public static boolean A(int i5) {
        boolean z4;
        if (i5 != 0) {
            ThreadLocal threadLocal = z.a.f5747a;
            double[] dArr = (double[]) threadLocal.get();
            if (dArr == null) {
                dArr = new double[3];
                threadLocal.set(dArr);
            }
            int red = Color.red(i5);
            int green = Color.green(i5);
            int blue = Color.blue(i5);
            if (dArr.length != 3) {
                throw new IllegalArgumentException("outXyz must have a length of 3.");
            }
            double d5 = red / 255.0d;
            double pow = d5 < 0.04045d ? d5 / 12.92d : Math.pow((d5 + 0.055d) / 1.055d, 2.4d);
            double d6 = green / 255.0d;
            double pow2 = d6 < 0.04045d ? d6 / 12.92d : Math.pow((d6 + 0.055d) / 1.055d, 2.4d);
            double d7 = blue / 255.0d;
            double pow3 = d7 < 0.04045d ? d7 / 12.92d : Math.pow((d7 + 0.055d) / 1.055d, 2.4d);
            z4 = false;
            dArr[0] = ((0.1805d * pow3) + (0.3576d * pow2) + (0.4124d * pow)) * 100.0d;
            double d8 = ((0.0722d * pow3) + (0.7152d * pow2) + (0.2126d * pow)) * 100.0d;
            dArr[1] = d8;
            dArr[2] = ((pow3 * 0.9505d) + (pow2 * 0.1192d) + (pow * 0.0193d)) * 100.0d;
            if (d8 / 100.0d > 0.5d) {
                return true;
            }
        } else {
            z4 = false;
        }
        return z4;
    }

    public static int B(int i5, float f5, int i6) {
        return z.a.b(z.a.c(i6, Math.round(Color.alpha(i6) * f5)), i5);
    }

    public static float C(int i5) {
        float f5 = i5 / 255.0f;
        return (f5 <= 0.04045f ? f5 / 12.92f : (float) Math.pow((f5 + 0.055f) / 1.055f, 2.4000000953674316d)) * 100.0f;
    }

    public static Typeface D(Configuration configuration, Typeface typeface) {
        int i5;
        int i6;
        int weight;
        int i7;
        Typeface create;
        if (Build.VERSION.SDK_INT >= 31) {
            i5 = configuration.fontWeightAdjustment;
            if (i5 != Integer.MAX_VALUE) {
                i6 = configuration.fontWeightAdjustment;
                if (i6 == 0 || typeface == null) {
                    return null;
                }
                weight = typeface.getWeight();
                i7 = configuration.fontWeightAdjustment;
                create = Typeface.create(typeface, m0.a.a(i7 + weight, 1, 1000), typeface.isItalic());
                return create;
            }
            return null;
        }
        return null;
    }

    public static int E(int i5, int i6, int i7) {
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 == 4) {
                    return i6 + i7;
                }
                throw new IllegalStateException(b0.f("Unexpected flag: ", i5));
            }
            return i6;
        }
        throw new IllegalStateException("HOT methods are not stored in the bitmap");
    }

    public static void F(AnimatorSet animatorSet, ArrayList arrayList) {
        int size = arrayList.size();
        long j5 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            Animator animator = (Animator) arrayList.get(i5);
            j5 = Math.max(j5, animator.getDuration() + animator.getStartDelay());
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 0);
        ofInt.setDuration(j5);
        arrayList.add(0, ofInt);
        animatorSet.playTogether(arrayList);
    }

    public static int[] G(ByteArrayInputStream byteArrayInputStream, int i5) {
        int[] iArr = new int[i5];
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            i6 += b4.j.P(byteArrayInputStream);
            iArr[i7] = i6;
        }
        return iArr;
    }

    public static z0.c[] H(FileInputStream fileInputStream, byte[] bArr, byte[] bArr2, z0.c[] cVarArr) {
        byte[] bArr3 = p2.a.f4263s;
        if (!Arrays.equals(bArr, bArr3)) {
            if (Arrays.equals(bArr, p2.a.f4264t)) {
                int P = b4.j.P(fileInputStream);
                byte[] N = b4.j.N(fileInputStream, (int) b4.j.O(fileInputStream, 4), (int) b4.j.O(fileInputStream, 4));
                if (fileInputStream.read() <= 0) {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(N);
                    try {
                        z0.c[] J = J(byteArrayInputStream, bArr2, P, cVarArr);
                        byteArrayInputStream.close();
                        return J;
                    } catch (Throwable th) {
                        try {
                            byteArrayInputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                throw new IllegalStateException("Content found after the end of file");
            }
            throw new IllegalStateException("Unsupported meta version");
        } else if (Arrays.equals(p2.a.f4259n, bArr2)) {
            throw new IllegalStateException("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
        } else {
            if (Arrays.equals(bArr, bArr3)) {
                int O = (int) b4.j.O(fileInputStream, 1);
                byte[] N2 = b4.j.N(fileInputStream, (int) b4.j.O(fileInputStream, 4), (int) b4.j.O(fileInputStream, 4));
                if (fileInputStream.read() <= 0) {
                    ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(N2);
                    try {
                        z0.c[] I = I(byteArrayInputStream2, O, cVarArr);
                        byteArrayInputStream2.close();
                        return I;
                    } catch (Throwable th3) {
                        try {
                            byteArrayInputStream2.close();
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                        throw th3;
                    }
                }
                throw new IllegalStateException("Content found after the end of file");
            }
            throw new IllegalStateException("Unsupported meta version");
        }
    }

    public static z0.c[] I(ByteArrayInputStream byteArrayInputStream, int i5, z0.c[] cVarArr) {
        if (byteArrayInputStream.available() == 0) {
            return new z0.c[0];
        }
        if (i5 == cVarArr.length) {
            String[] strArr = new String[i5];
            int[] iArr = new int[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                int P = b4.j.P(byteArrayInputStream);
                iArr[i6] = b4.j.P(byteArrayInputStream);
                strArr[i6] = new String(b4.j.M(byteArrayInputStream, P), StandardCharsets.UTF_8);
            }
            for (int i7 = 0; i7 < i5; i7++) {
                z0.c cVar = cVarArr[i7];
                if (!cVar.f5783b.equals(strArr[i7])) {
                    throw new IllegalStateException("Order of dexfiles in metadata did not match baseline");
                }
                int i8 = iArr[i7];
                cVar.f5786e = i8;
                cVar.f5789h = G(byteArrayInputStream, i8);
            }
            return cVarArr;
        }
        throw new IllegalStateException("Mismatched number of dex files found in metadata");
    }

    public static z0.c[] J(ByteArrayInputStream byteArrayInputStream, byte[] bArr, int i5, z0.c[] cVarArr) {
        z0.c cVar;
        if (byteArrayInputStream.available() == 0) {
            return new z0.c[0];
        }
        if (i5 == cVarArr.length) {
            for (int i6 = 0; i6 < i5; i6++) {
                b4.j.P(byteArrayInputStream);
                String str = new String(b4.j.M(byteArrayInputStream, b4.j.P(byteArrayInputStream)), StandardCharsets.UTF_8);
                long O = b4.j.O(byteArrayInputStream, 4);
                int P = b4.j.P(byteArrayInputStream);
                if (cVarArr.length > 0) {
                    int indexOf = str.indexOf("!");
                    if (indexOf < 0) {
                        indexOf = str.indexOf(":");
                    }
                    String substring = indexOf > 0 ? str.substring(indexOf + 1) : str;
                    for (int i7 = 0; i7 < cVarArr.length; i7++) {
                        if (cVarArr[i7].f5783b.equals(substring)) {
                            cVar = cVarArr[i7];
                            break;
                        }
                    }
                }
                cVar = null;
                if (cVar == null) {
                    throw new IllegalStateException("Missing profile key: ".concat(str));
                }
                cVar.f5785d = O;
                int[] G = G(byteArrayInputStream, P);
                if (Arrays.equals(bArr, p2.a.f4262r)) {
                    cVar.f5786e = P;
                    cVar.f5789h = G;
                }
            }
            return cVarArr;
        }
        throw new IllegalStateException("Mismatched number of dex files found in metadata");
    }

    public static z0.c[] K(FileInputStream fileInputStream, byte[] bArr, String str) {
        if (Arrays.equals(bArr, p2.a.o)) {
            int O = (int) b4.j.O(fileInputStream, 1);
            byte[] N = b4.j.N(fileInputStream, (int) b4.j.O(fileInputStream, 4), (int) b4.j.O(fileInputStream, 4));
            if (fileInputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(N);
                try {
                    z0.c[] L = L(byteArrayInputStream, str, O);
                    byteArrayInputStream.close();
                    return L;
                } catch (Throwable th) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            throw new IllegalStateException("Content found after the end of file");
        }
        throw new IllegalStateException("Unsupported version");
    }

    public static z0.c[] L(ByteArrayInputStream byteArrayInputStream, String str, int i5) {
        TreeMap treeMap;
        if (byteArrayInputStream.available() == 0) {
            return new z0.c[0];
        }
        z0.c[] cVarArr = new z0.c[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            int P = b4.j.P(byteArrayInputStream);
            int P2 = b4.j.P(byteArrayInputStream);
            cVarArr[i6] = new z0.c(str, new String(b4.j.M(byteArrayInputStream, P), StandardCharsets.UTF_8), b4.j.O(byteArrayInputStream, 4), P2, (int) b4.j.O(byteArrayInputStream, 4), (int) b4.j.O(byteArrayInputStream, 4), new int[P2], new TreeMap());
        }
        for (int i7 = 0; i7 < i5; i7++) {
            z0.c cVar = cVarArr[i7];
            int available = byteArrayInputStream.available() - cVar.f5787f;
            int i8 = 0;
            while (true) {
                int available2 = byteArrayInputStream.available();
                treeMap = cVar.f5790i;
                if (available2 <= available) {
                    break;
                }
                i8 += b4.j.P(byteArrayInputStream);
                treeMap.put(Integer.valueOf(i8), 1);
                for (int P3 = b4.j.P(byteArrayInputStream); P3 > 0; P3--) {
                    b4.j.P(byteArrayInputStream);
                    int O = (int) b4.j.O(byteArrayInputStream, 1);
                    if (O != 6 && O != 7) {
                        while (O > 0) {
                            b4.j.O(byteArrayInputStream, 1);
                            for (int O2 = (int) b4.j.O(byteArrayInputStream, 1); O2 > 0; O2--) {
                                b4.j.P(byteArrayInputStream);
                            }
                            O--;
                        }
                    }
                }
            }
            if (byteArrayInputStream.available() != available) {
                throw new IllegalStateException("Read too much data during profile line parse");
            }
            cVar.f5789h = G(byteArrayInputStream, cVar.f5786e);
            int i9 = cVar.f5788g;
            BitSet valueOf = BitSet.valueOf(b4.j.M(byteArrayInputStream, ((((i9 * 2) + 8) - 1) & (-8)) / 8));
            for (int i10 = 0; i10 < i9; i10++) {
                int i11 = valueOf.get(E(2, i10, i9)) ? 2 : 0;
                if (valueOf.get(E(4, i10, i9))) {
                    i11 |= 4;
                }
                if (i11 != 0) {
                    Integer num = (Integer) treeMap.get(Integer.valueOf(i10));
                    if (num == null) {
                        num = 0;
                    }
                    treeMap.put(Integer.valueOf(i10), Integer.valueOf(i11 | num.intValue()));
                }
            }
        }
        return cVarArr;
    }

    public static String M(String str) {
        int length = str.length();
        if (length > 1) {
            int i5 = length - 1;
            return str.charAt(i5) == '/' ? str.substring(0, i5) : str;
        }
        return str;
    }

    public static TypedValue N(Context context, int i5) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i5, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean O(Context context, int i5, boolean z4) {
        TypedValue N = N(context, i5);
        return (N == null || N.type != 18) ? z4 : N.data != 0;
    }

    public static TypedValue P(int i5, Context context, String str) {
        TypedValue N = N(context, i5);
        if (N != null) {
            return N;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i5)));
    }

    public static void Q(String str, RuntimeException runtimeException) {
        StackTraceElement[] stackTrace = runtimeException.getStackTrace();
        int length = stackTrace.length;
        int i5 = -1;
        for (int i6 = 0; i6 < length; i6++) {
            if (str.equals(stackTrace[i6].getClassName())) {
                i5 = i6;
            }
        }
        runtimeException.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i5 + 1, length));
    }

    public static void R(EditorInfo editorInfo, CharSequence charSequence, int i5, int i6) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", charSequence != null ? new SpannableStringBuilder(charSequence) : null);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", i5);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", i6);
    }

    public static void U(int i5, p.e eVar, m mVar, boolean z4) {
        float f5 = eVar.f4165d0;
        p.d dVar = eVar.I;
        int d5 = dVar.f4154f.d();
        p.d dVar2 = eVar.K;
        int d6 = dVar2.f4154f.d();
        int e5 = dVar.e() + d5;
        int e6 = d6 - dVar2.e();
        if (d5 == d6) {
            f5 = 0.5f;
        } else {
            d5 = e5;
            d6 = e6;
        }
        int r5 = eVar.r();
        int i6 = (d6 - d5) - r5;
        if (d5 > d6) {
            i6 = (d5 - d6) - r5;
        }
        int i7 = ((int) (i6 > 0 ? (f5 * i6) + 0.5f : f5 * i6)) + d5;
        int i8 = i7 + r5;
        if (d5 > d6) {
            i8 = i7 - r5;
        }
        eVar.J(i7, i8);
        y(i5 + 1, eVar, mVar, z4);
    }

    public static void V(int i5, p.e eVar, m mVar, p.e eVar2, boolean z4) {
        float f5 = eVar2.f4165d0;
        p.d dVar = eVar2.I;
        int e5 = dVar.e() + dVar.f4154f.d();
        p.d dVar2 = eVar2.K;
        int d5 = dVar2.f4154f.d() - dVar2.e();
        if (d5 >= e5) {
            int r5 = eVar2.r();
            if (eVar2.f4171g0 != 8) {
                int i6 = eVar2.f4190r;
                if (i6 == 2) {
                    r5 = (int) (eVar2.f4165d0 * 0.5f * (eVar instanceof p.f ? eVar.r() : eVar.T.r()));
                } else if (i6 == 0) {
                    r5 = d5 - e5;
                }
                r5 = Math.max(eVar2.f4193u, r5);
                int i7 = eVar2.f4194v;
                if (i7 > 0) {
                    r5 = Math.min(i7, r5);
                }
            }
            int i8 = e5 + ((int) ((f5 * ((d5 - e5) - r5)) + 0.5f));
            eVar2.J(i8, r5 + i8);
            y(i5 + 1, eVar2, mVar, z4);
        }
    }

    public static void W(int i5, p.e eVar, m mVar) {
        float f5 = eVar.f4167e0;
        p.d dVar = eVar.J;
        int d5 = dVar.f4154f.d();
        p.d dVar2 = eVar.L;
        int d6 = dVar2.f4154f.d();
        int e5 = dVar.e() + d5;
        int e6 = d6 - dVar2.e();
        if (d5 == d6) {
            f5 = 0.5f;
        } else {
            d5 = e5;
            d6 = e6;
        }
        int l5 = eVar.l();
        int i6 = (d6 - d5) - l5;
        if (d5 > d6) {
            i6 = (d5 - d6) - l5;
        }
        int i7 = (int) (i6 > 0 ? (f5 * i6) + 0.5f : f5 * i6);
        int i8 = d5 + i7;
        int i9 = i8 + l5;
        if (d5 > d6) {
            i8 = d5 - i7;
            i9 = i8 - l5;
        }
        eVar.K(i8, i9);
        d0(i5 + 1, eVar, mVar);
    }

    public static void X(int i5, p.e eVar, m mVar, p.e eVar2) {
        float f5 = eVar2.f4167e0;
        p.d dVar = eVar2.J;
        int e5 = dVar.e() + dVar.f4154f.d();
        p.d dVar2 = eVar2.L;
        int d5 = dVar2.f4154f.d() - dVar2.e();
        if (d5 >= e5) {
            int l5 = eVar2.l();
            if (eVar2.f4171g0 != 8) {
                int i6 = eVar2.f4191s;
                if (i6 == 2) {
                    l5 = (int) (f5 * 0.5f * (eVar instanceof p.f ? eVar.l() : eVar.T.l()));
                } else if (i6 == 0) {
                    l5 = d5 - e5;
                }
                l5 = Math.max(eVar2.f4196x, l5);
                int i7 = eVar2.f4197y;
                if (i7 > 0) {
                    l5 = Math.min(i7, l5);
                }
            }
            int i8 = e5 + ((int) ((f5 * ((d5 - e5) - l5)) + 0.5f));
            eVar2.K(i8, l5 + i8);
            d0(i5 + 1, eVar2, mVar);
        }
    }

    public static final void Y(Object obj) {
        if (obj instanceof a4.b) {
            throw ((a4.b) obj).f30b;
        }
    }

    public static String Z(Throwable th, Intent intent) {
        if (th instanceof ActivityNotFoundException) {
            String action = intent.getAction();
            if ("android.intent.action.OPEN_DOCUMENT_TREE".equals(action) || "android.intent.action.OPEN_DOCUMENT".equals(action)) {
                return "Failed to call " + action.substring(22) + ". The Files (documnetui) application may be frozen.";
            }
        }
        return "Failed to start activity: " + th.getMessage();
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void a0(String str) {
        a4.d dVar = new a4.d("lateinit property " + str + " has not been initialized");
        Q(e.class.getName(), dVar);
        throw dVar;
    }

    public static boolean b(p.e eVar) {
        int[] iArr = eVar.f4188p0;
        int i5 = iArr[0];
        int i6 = iArr[1];
        p.e eVar2 = eVar.T;
        p.f fVar = eVar2 != null ? (p.f) eVar2 : null;
        if (fVar != null) {
            int i7 = fVar.f4188p0[0];
        }
        if (fVar != null) {
            int i8 = fVar.f4188p0[1];
        }
        boolean z4 = i5 == 1 || eVar.B() || i5 == 2 || (i5 == 3 && eVar.f4190r == 0 && eVar.W == 0.0f && eVar.u(0)) || (i5 == 3 && eVar.f4190r == 1 && eVar.v(0, eVar.r()));
        boolean z5 = i6 == 1 || eVar.C() || i6 == 2 || (i6 == 3 && eVar.f4191s == 0 && eVar.W == 0.0f && eVar.u(1)) || (i6 == 3 && eVar.f4191s == 1 && eVar.v(1, eVar.l()));
        if (eVar.W <= 0.0f || !(z4 || z5)) {
            return z4 && z5;
        }
        return true;
    }

    public static int b0(Context context, int i5) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(16973825, new int[]{i5});
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public static void c(Object obj) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException();
        Q(e.class.getName(), nullPointerException);
        throw nullPointerException;
    }

    public static boolean c0(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr, z0.c[] cVarArr) {
        ArrayList arrayList;
        int length;
        byte[] bArr2 = p2.a.f4259n;
        int i5 = 0;
        if (!Arrays.equals(bArr, bArr2)) {
            byte[] bArr3 = p2.a.o;
            if (Arrays.equals(bArr, bArr3)) {
                byte[] g5 = g(cVarArr, bArr3);
                b4.j.m0(byteArrayOutputStream, cVarArr.length, 1);
                b4.j.m0(byteArrayOutputStream, g5.length, 4);
                byte[] j5 = b4.j.j(g5);
                b4.j.m0(byteArrayOutputStream, j5.length, 4);
                byteArrayOutputStream.write(j5);
                return true;
            }
            byte[] bArr4 = p2.a.f4261q;
            if (Arrays.equals(bArr, bArr4)) {
                b4.j.m0(byteArrayOutputStream, cVarArr.length, 1);
                for (z0.c cVar : cVarArr) {
                    String j6 = j(cVar.f5782a, cVar.f5783b, bArr4);
                    b4.j.n0(byteArrayOutputStream, j6.getBytes(StandardCharsets.UTF_8).length);
                    b4.j.n0(byteArrayOutputStream, cVar.f5789h.length);
                    b4.j.m0(byteArrayOutputStream, cVar.f5790i.size() * 4, 4);
                    b4.j.m0(byteArrayOutputStream, cVar.f5784c, 4);
                    byteArrayOutputStream.write(j6.getBytes(StandardCharsets.UTF_8));
                    for (Integer num : cVar.f5790i.keySet()) {
                        b4.j.n0(byteArrayOutputStream, num.intValue());
                        b4.j.n0(byteArrayOutputStream, 0);
                    }
                    for (int i6 : cVar.f5789h) {
                        b4.j.n0(byteArrayOutputStream, i6);
                    }
                }
                return true;
            }
            byte[] bArr5 = p2.a.f4260p;
            if (Arrays.equals(bArr, bArr5)) {
                byte[] g6 = g(cVarArr, bArr5);
                b4.j.m0(byteArrayOutputStream, cVarArr.length, 1);
                b4.j.m0(byteArrayOutputStream, g6.length, 4);
                byte[] j7 = b4.j.j(g6);
                b4.j.m0(byteArrayOutputStream, j7.length, 4);
                byteArrayOutputStream.write(j7);
                return true;
            }
            byte[] bArr6 = p2.a.f4262r;
            if (Arrays.equals(bArr, bArr6)) {
                b4.j.n0(byteArrayOutputStream, cVarArr.length);
                for (z0.c cVar2 : cVarArr) {
                    String j8 = j(cVar2.f5782a, cVar2.f5783b, bArr6);
                    b4.j.n0(byteArrayOutputStream, j8.getBytes(StandardCharsets.UTF_8).length);
                    TreeMap treeMap = cVar2.f5790i;
                    b4.j.n0(byteArrayOutputStream, treeMap.size());
                    b4.j.n0(byteArrayOutputStream, cVar2.f5789h.length);
                    b4.j.m0(byteArrayOutputStream, cVar2.f5784c, 4);
                    byteArrayOutputStream.write(j8.getBytes(StandardCharsets.UTF_8));
                    for (Integer num2 : treeMap.keySet()) {
                        b4.j.n0(byteArrayOutputStream, num2.intValue());
                    }
                    for (int i7 : cVar2.f5789h) {
                        b4.j.n0(byteArrayOutputStream, i7);
                    }
                }
                return true;
            }
            return false;
        }
        ArrayList arrayList2 = new ArrayList(3);
        ArrayList arrayList3 = new ArrayList(3);
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        try {
            b4.j.n0(byteArrayOutputStream2, cVarArr.length);
            int i8 = 2;
            int i9 = 2;
            for (z0.c cVar3 : cVarArr) {
                b4.j.m0(byteArrayOutputStream2, cVar3.f5784c, 4);
                b4.j.m0(byteArrayOutputStream2, cVar3.f5785d, 4);
                b4.j.m0(byteArrayOutputStream2, cVar3.f5788g, 4);
                String j9 = j(cVar3.f5782a, cVar3.f5783b, bArr2);
                int length2 = j9.getBytes(StandardCharsets.UTF_8).length;
                b4.j.n0(byteArrayOutputStream2, length2);
                i9 = i9 + 4 + 4 + 4 + 2 + (length2 * 1);
                byteArrayOutputStream2.write(j9.getBytes(StandardCharsets.UTF_8));
            }
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            if (i9 != byteArray.length) {
                throw new IllegalStateException("Expected size " + i9 + ", does not match actual size " + byteArray.length);
            }
            z0.m mVar = new z0.m(1, byteArray, false);
            byteArrayOutputStream2.close();
            arrayList2.add(mVar);
            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
            int i10 = 0;
            for (int i11 = 0; i11 < cVarArr.length; i11++) {
                try {
                    z0.c cVar4 = cVarArr[i11];
                    b4.j.n0(byteArrayOutputStream3, i11);
                    b4.j.n0(byteArrayOutputStream3, cVar4.f5786e);
                    i10 = i10 + 2 + 2 + (cVar4.f5786e * 2);
                    e0(byteArrayOutputStream3, cVar4);
                } finally {
                }
            }
            byte[] byteArray2 = byteArrayOutputStream3.toByteArray();
            if (i10 != byteArray2.length) {
                throw new IllegalStateException("Expected size " + i10 + ", does not match actual size " + byteArray2.length);
            }
            z0.m mVar2 = new z0.m(3, byteArray2, true);
            byteArrayOutputStream3.close();
            arrayList2.add(mVar2);
            byteArrayOutputStream3 = new ByteArrayOutputStream();
            int i12 = 0;
            int i13 = 0;
            while (i12 < cVarArr.length) {
                try {
                    z0.c cVar5 = cVarArr[i12];
                    int i14 = i5;
                    for (Map.Entry entry : cVar5.f5790i.entrySet()) {
                        i14 |= ((Integer) entry.getValue()).intValue();
                    }
                    ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                    g0(byteArrayOutputStream4, cVar5);
                    byte[] byteArray3 = byteArrayOutputStream4.toByteArray();
                    byteArrayOutputStream4.close();
                    ByteArrayOutputStream byteArrayOutputStream5 = new ByteArrayOutputStream();
                    h0(byteArrayOutputStream5, cVar5);
                    byte[] byteArray4 = byteArrayOutputStream5.toByteArray();
                    byteArrayOutputStream5.close();
                    b4.j.n0(byteArrayOutputStream3, i12);
                    int length3 = byteArray3.length + i8 + byteArray4.length;
                    int i15 = i13 + 2 + 4;
                    ArrayList arrayList4 = arrayList3;
                    b4.j.m0(byteArrayOutputStream3, length3, 4);
                    b4.j.n0(byteArrayOutputStream3, i14);
                    byteArrayOutputStream3.write(byteArray3);
                    byteArrayOutputStream3.write(byteArray4);
                    i13 = i15 + length3;
                    i12++;
                    arrayList3 = arrayList4;
                    i5 = 0;
                    i8 = 2;
                } finally {
                }
            }
            ArrayList arrayList5 = arrayList3;
            byte[] byteArray5 = byteArrayOutputStream3.toByteArray();
            if (i13 != byteArray5.length) {
                throw new IllegalStateException("Expected size " + i13 + ", does not match actual size " + byteArray5.length);
            }
            z0.m mVar3 = new z0.m(4, byteArray5, true);
            byteArrayOutputStream3.close();
            arrayList2.add(mVar3);
            long j10 = 4;
            long size = j10 + j10 + 4 + (arrayList2.size() * 16);
            b4.j.m0(byteArrayOutputStream, arrayList2.size(), 4);
            int i16 = 0;
            while (i16 < arrayList2.size()) {
                z0.m mVar4 = (z0.m) arrayList2.get(i16);
                b4.j.m0(byteArrayOutputStream, b0.d(mVar4.f5802a), 4);
                b4.j.m0(byteArrayOutputStream, size, 4);
                boolean z4 = mVar4.f5804c;
                byte[] bArr7 = mVar4.f5803b;
                if (z4) {
                    byte[] j11 = b4.j.j(bArr7);
                    arrayList = arrayList5;
                    arrayList.add(j11);
                    b4.j.m0(byteArrayOutputStream, j11.length, 4);
                    b4.j.m0(byteArrayOutputStream, bArr7.length, 4);
                    length = j11.length;
                } else {
                    arrayList = arrayList5;
                    arrayList.add(bArr7);
                    b4.j.m0(byteArrayOutputStream, bArr7.length, 4);
                    b4.j.m0(byteArrayOutputStream, 0L, 4);
                    length = bArr7.length;
                }
                size += length;
                i16++;
                arrayList5 = arrayList;
            }
            ArrayList arrayList6 = arrayList5;
            for (int i17 = 0; i17 < arrayList6.size(); i17++) {
                byteArrayOutputStream.write((byte[]) arrayList6.get(i17));
            }
            return true;
        } finally {
            try {
                byteArrayOutputStream2.close();
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
    }

    public static void d(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(str);
        Q(e.class.getName(), nullPointerException);
        throw nullPointerException;
    }

    public static void d0(int i5, p.e eVar, m mVar) {
        p.d dVar;
        p.d dVar2;
        p.d dVar3;
        p.d dVar4;
        p.d dVar5;
        if (eVar.f4184n) {
            return;
        }
        if (!(eVar instanceof p.f) && eVar.A() && b(eVar)) {
            p.f.V(eVar, mVar, new q.b());
        }
        p.d j5 = eVar.j(p.c.TOP);
        p.d j6 = eVar.j(p.c.BOTTOM);
        int d5 = j5.d();
        int d6 = j6.d();
        HashSet hashSet = j5.f4149a;
        if (hashSet != null && j5.f4151c) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                p.d dVar6 = (p.d) it.next();
                p.e eVar2 = dVar6.f4152d;
                int i6 = i5 + 1;
                boolean b5 = b(eVar2);
                if (eVar2.A() && b5) {
                    p.f.V(eVar2, mVar, new q.b());
                }
                p.d dVar7 = eVar2.J;
                p.d dVar8 = eVar2.L;
                boolean z4 = (dVar6 == dVar7 && (dVar5 = dVar8.f4154f) != null && dVar5.f4151c) || (dVar6 == dVar8 && (dVar4 = dVar7.f4154f) != null && dVar4.f4151c);
                int i7 = eVar2.f4188p0[1];
                if (i7 != 3 || b5) {
                    if (!eVar2.A()) {
                        if (dVar6 == dVar7 && dVar8.f4154f == null) {
                            int e5 = dVar7.e() + d5;
                            eVar2.K(e5, eVar2.l() + e5);
                            d0(i6, eVar2, mVar);
                        } else if (dVar6 == dVar8 && dVar7.f4154f == null) {
                            int e6 = d5 - dVar8.e();
                            eVar2.K(e6 - eVar2.l(), e6);
                            d0(i6, eVar2, mVar);
                        } else if (z4 && !eVar2.z()) {
                            W(i6, eVar2, mVar);
                        }
                    }
                } else if (i7 == 3 && eVar2.f4197y >= 0 && eVar2.f4196x >= 0 && (eVar2.f4171g0 == 8 || (eVar2.f4191s == 0 && eVar2.W == 0.0f))) {
                    if (!eVar2.z() && !eVar2.F && z4 && !eVar2.z()) {
                        X(i6, eVar, mVar, eVar2);
                    }
                }
            }
        }
        if (eVar instanceof i) {
            return;
        }
        HashSet hashSet2 = j6.f4149a;
        if (hashSet2 != null && j6.f4151c) {
            Iterator it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                p.d dVar9 = (p.d) it2.next();
                p.e eVar3 = dVar9.f4152d;
                int i8 = i5 + 1;
                boolean b6 = b(eVar3);
                if (eVar3.A() && b6) {
                    p.f.V(eVar3, mVar, new q.b());
                }
                p.d dVar10 = eVar3.J;
                p.d dVar11 = eVar3.L;
                boolean z5 = (dVar9 == dVar10 && (dVar3 = dVar11.f4154f) != null && dVar3.f4151c) || (dVar9 == dVar11 && (dVar2 = dVar10.f4154f) != null && dVar2.f4151c);
                int i9 = eVar3.f4188p0[1];
                if (i9 != 3 || b6) {
                    if (!eVar3.A()) {
                        if (dVar9 == dVar10 && dVar11.f4154f == null) {
                            int e7 = dVar10.e() + d6;
                            eVar3.K(e7, eVar3.l() + e7);
                            d0(i8, eVar3, mVar);
                        } else if (dVar9 == dVar11 && dVar10.f4154f == null) {
                            int e8 = d6 - dVar11.e();
                            eVar3.K(e8 - eVar3.l(), e8);
                            d0(i8, eVar3, mVar);
                        } else if (z5 && !eVar3.z()) {
                            W(i8, eVar3, mVar);
                        }
                    }
                } else if (i9 == 3 && eVar3.f4197y >= 0 && eVar3.f4196x >= 0) {
                    if (eVar3.f4171g0 != 8) {
                        if (eVar3.f4191s == 0) {
                            if (eVar3.W == 0.0f) {
                            }
                        }
                    }
                    if (!eVar3.z() && !eVar3.F && z5 && !eVar3.z()) {
                        X(i8, eVar, mVar, eVar3);
                    }
                }
            }
        }
        p.d j7 = eVar.j(p.c.BASELINE);
        if (j7.f4149a != null && j7.f4151c) {
            int d7 = j7.d();
            Iterator it3 = j7.f4149a.iterator();
            while (it3.hasNext()) {
                p.d dVar12 = (p.d) it3.next();
                p.e eVar4 = dVar12.f4152d;
                int i10 = i5 + 1;
                boolean b7 = b(eVar4);
                if (eVar4.A() && b7) {
                    p.f.V(eVar4, mVar, new q.b());
                }
                if (eVar4.f4188p0[1] != 3 || b7) {
                    if (!eVar4.A() && dVar12 == (dVar = eVar4.M)) {
                        int e9 = dVar12.e() + d7;
                        if (eVar4.E) {
                            int i11 = e9 - eVar4.f4159a0;
                            int i12 = eVar4.V + i11;
                            eVar4.Z = i11;
                            eVar4.J.l(i11);
                            eVar4.L.l(i12);
                            dVar.l(e9);
                            eVar4.f4180l = true;
                        }
                        d0(i10, eVar4, mVar);
                    }
                }
            }
        }
        eVar.f4184n = true;
    }

    public static void e(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(str.concat(" must not be null"));
        Q(e.class.getName(), nullPointerException);
        throw nullPointerException;
    }

    public static void e0(ByteArrayOutputStream byteArrayOutputStream, z0.c cVar) {
        int i5 = 0;
        for (int i6 : cVar.f5789h) {
            Integer valueOf = Integer.valueOf(i6);
            b4.j.n0(byteArrayOutputStream, valueOf.intValue() - i5);
            i5 = valueOf.intValue();
        }
    }

    public static void f(Object obj, String str) {
        if (obj == null) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String name = e.class.getName();
            int i5 = 0;
            while (!stackTrace[i5].getClassName().equals(name)) {
                i5++;
            }
            while (stackTrace[i5].getClassName().equals(name)) {
                i5++;
            }
            StackTraceElement stackTraceElement = stackTrace[i5];
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            NullPointerException nullPointerException = new NullPointerException("Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str);
            Q(e.class.getName(), nullPointerException);
            throw nullPointerException;
        }
    }

    public static void f0(ByteArrayOutputStream byteArrayOutputStream, z0.c cVar, String str) {
        b4.j.n0(byteArrayOutputStream, str.getBytes(StandardCharsets.UTF_8).length);
        b4.j.n0(byteArrayOutputStream, cVar.f5786e);
        b4.j.m0(byteArrayOutputStream, cVar.f5787f, 4);
        b4.j.m0(byteArrayOutputStream, cVar.f5784c, 4);
        b4.j.m0(byteArrayOutputStream, cVar.f5788g, 4);
        byteArrayOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
    }

    public static byte[] g(z0.c[] cVarArr, byte[] bArr) {
        int i5 = 0;
        int i6 = 0;
        for (z0.c cVar : cVarArr) {
            i6 += (((((cVar.f5788g * 2) + 8) - 1) & (-8)) / 8) + (cVar.f5786e * 2) + j(cVar.f5782a, cVar.f5783b, bArr).getBytes(StandardCharsets.UTF_8).length + 16 + cVar.f5787f;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i6);
        if (Arrays.equals(bArr, p2.a.f4260p)) {
            int length = cVarArr.length;
            while (i5 < length) {
                z0.c cVar2 = cVarArr[i5];
                f0(byteArrayOutputStream, cVar2, j(cVar2.f5782a, cVar2.f5783b, bArr));
                h0(byteArrayOutputStream, cVar2);
                e0(byteArrayOutputStream, cVar2);
                g0(byteArrayOutputStream, cVar2);
                i5++;
            }
        } else {
            for (z0.c cVar3 : cVarArr) {
                f0(byteArrayOutputStream, cVar3, j(cVar3.f5782a, cVar3.f5783b, bArr));
            }
            int length2 = cVarArr.length;
            while (i5 < length2) {
                z0.c cVar4 = cVarArr[i5];
                h0(byteArrayOutputStream, cVar4);
                e0(byteArrayOutputStream, cVar4);
                g0(byteArrayOutputStream, cVar4);
                i5++;
            }
        }
        if (byteArrayOutputStream.size() == i6) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new IllegalStateException("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + i6);
    }

    public static void g0(ByteArrayOutputStream byteArrayOutputStream, z0.c cVar) {
        byte[] bArr = new byte[((((cVar.f5788g * 2) + 8) - 1) & (-8)) / 8];
        for (Map.Entry entry : cVar.f5790i.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            int i5 = intValue2 & 2;
            int i6 = cVar.f5788g;
            if (i5 != 0) {
                int E = E(2, intValue, i6);
                int i7 = E / 8;
                bArr[i7] = (byte) ((1 << (E % 8)) | bArr[i7]);
            }
            if ((intValue2 & 4) != 0) {
                int E2 = E(4, intValue, i6);
                int i8 = E2 / 8;
                bArr[i8] = (byte) ((1 << (E2 % 8)) | bArr[i8]);
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static final a4.b h(Throwable th) {
        f(th, "exception");
        return new a4.b(th);
    }

    public static void h0(ByteArrayOutputStream byteArrayOutputStream, z0.c cVar) {
        int i5 = 0;
        for (Map.Entry entry : cVar.f5790i.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                b4.j.n0(byteArrayOutputStream, intValue - i5);
                b4.j.n0(byteArrayOutputStream, 0);
                i5 = intValue;
            }
        }
    }

    public static final boolean i(char c5, char c6, boolean z4) {
        if (c5 == c6) {
            return true;
        }
        if (z4) {
            char upperCase = Character.toUpperCase(c5);
            char upperCase2 = Character.toUpperCase(c6);
            return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
        }
        return false;
    }

    public static float i0() {
        return ((float) Math.pow((50.0f + 16.0d) / 116.0d, 3.0d)) * 100.0f;
    }

    public static String j(String str, String str2, byte[] bArr) {
        byte[] bArr2 = p2.a.f4262r;
        boolean equals = Arrays.equals(bArr, bArr2);
        byte[] bArr3 = p2.a.f4261q;
        String str3 = "!";
        String str4 = (equals || Arrays.equals(bArr, bArr3)) ? ":" : "!";
        if (str.length() <= 0) {
            if ("!".equals(str4)) {
                return str2.replace(":", "!");
            }
            if (":".equals(str4)) {
                str2 = str2.replace("!", ":");
            }
            return str2;
        } else if (str2.equals("classes.dex")) {
            return str;
        } else {
            if (str2.contains("!") || str2.contains(":")) {
                if ("!".equals(str4)) {
                    return str2.replace(":", "!");
                }
                if (":".equals(str4)) {
                    str2 = str2.replace("!", ":");
                }
                return str2;
            } else if (str2.endsWith(".apk")) {
                return str2;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                return b0.i(sb, (Arrays.equals(bArr, bArr2) || Arrays.equals(bArr, bArr3)) ? ":" : ":", str2);
            }
        }
    }

    public static String j0(z zVar) {
        StringBuilder sb = new StringBuilder(zVar.i());
        for (int i5 = 0; i5 < zVar.i(); i5++) {
            byte g5 = zVar.g(i5);
            if (g5 == 34) {
                sb.append("\\\"");
            } else if (g5 == 39) {
                sb.append("\\'");
            } else if (g5 != 92) {
                switch (g5) {
                    case 7:
                        sb.append("\\a");
                        continue;
                    case 8:
                        sb.append("\\b");
                        continue;
                    case 9:
                        sb.append("\\t");
                        continue;
                    case 10:
                        sb.append("\\n");
                        continue;
                    case 11:
                        sb.append("\\v");
                        continue;
                    case 12:
                        sb.append("\\f");
                        continue;
                    case 13:
                        sb.append("\\r");
                        continue;
                    default:
                        if (g5 < 32 || g5 > 126) {
                            sb.append('\\');
                            sb.append((char) (((g5 >>> 6) & 3) + 48));
                            sb.append((char) (((g5 >>> 3) & 7) + 48));
                            sb.append((char) ((g5 & 7) + 48));
                            break;
                        } else {
                            sb.append((char) g5);
                            continue;
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static int k(Context context, int i5, int i6) {
        Integer num;
        TypedValue N = N(context, i5);
        if (N != null) {
            int i7 = N.resourceId;
            num = Integer.valueOf(i7 != 0 ? x.b.a(context, i7) : N.data);
        } else {
            num = null;
        }
        return num != null ? num.intValue() : i6;
    }

    public static int l(View view, int i5) {
        Context context = view.getContext();
        TypedValue P = P(i5, view.getContext(), view.getClass().getCanonicalName());
        int i6 = P.resourceId;
        return i6 != 0 ? x.b.a(context, i6) : P.data;
    }

    public static int m(Context context, int i5) {
        try {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{i5});
            int color = obtainStyledAttributes.getColor(0, 0);
            obtainStyledAttributes.recycle();
            return color;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static ColorStateList n(Drawable drawable) {
        ColorStateList colorStateList;
        if (drawable instanceof ColorDrawable) {
            return ColorStateList.valueOf(((ColorDrawable) drawable).getColor());
        }
        if (Build.VERSION.SDK_INT < 29 || !l1.s(drawable)) {
            return null;
        }
        colorStateList = l1.e(drawable).getColorStateList();
        return colorStateList;
    }

    public static String o(String str) {
        int lastIndexOf = str.lastIndexOf(47, str.length() - 2);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    public static String p(String str) {
        int lastIndexOf = str.lastIndexOf(47, str.length() - 2);
        return lastIndexOf < 1 ? "" : str.substring(0, lastIndexOf);
    }

    public static final Class q(n4.b bVar) {
        f(bVar, "<this>");
        Class a5 = ((j4.b) bVar).a();
        if (a5.isPrimitive()) {
            String name = a5.getName();
            switch (name.hashCode()) {
                case -1325958191:
                    return !name.equals("double") ? a5 : Double.class;
                case 104431:
                    return !name.equals("int") ? a5 : Integer.class;
                case 3039496:
                    return !name.equals("byte") ? a5 : Byte.class;
                case 3052374:
                    return !name.equals("char") ? a5 : Character.class;
                case 3327612:
                    return !name.equals("long") ? a5 : Long.class;
                case 3625364:
                    return !name.equals("void") ? a5 : Void.class;
                case 64711720:
                    return !name.equals("boolean") ? a5 : Boolean.class;
                case 97526364:
                    return !name.equals("float") ? a5 : Float.class;
                case 109413500:
                    return !name.equals("short") ? a5 : Short.class;
                default:
                    return a5;
            }
        }
        return a5;
    }

    public static final int r(List list) {
        f(list, "<this>");
        return list.size() - 1;
    }

    public static ParcelFileDescriptor s(Context context, r rVar, g gVar, int i5, boolean z4) {
        Handler handler;
        rVar.f5093i = 0;
        int i6 = i5 & 805306368;
        if (i6 == 536870912) {
            try {
                ParcelFileDescriptor[] createReliablePipe = ParcelFileDescriptor.createReliablePipe();
                new x4.e(gVar, rVar, createReliablePipe[0]).start();
                return createReliablePipe[1];
            } catch (IOException unused) {
            }
        }
        x4.d dVar = new x4.d(rVar, gVar);
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        if (z4) {
            ZApp zApp = ZApp.f4571h;
            handler = zApp == null ? null : zApp.f4573g;
        } else {
            HandlerThread handlerThread = new HandlerThread("ParcelFileDescriptorUtil");
            dVar.f5518d = handlerThread;
            handlerThread.start();
            handler = new Handler(dVar.f5518d.getLooper());
        }
        return storageManager.openProxyFileDescriptor(i6, dVar, handler);
    }

    public static int t(String str) {
        int parseInt = Integer.parseInt(str.substring(9, 10), 16);
        if (parseInt == 15) {
            return -1;
        }
        return parseInt;
    }

    public static String u(String str, String str2) {
        boolean z4;
        if (str.isEmpty()) {
            z4 = false;
        } else {
            z4 = str.endsWith("/");
            if (z4 != str2.startsWith("/")) {
                return str.concat(str2);
            }
        }
        if (z4) {
            return str + str2.substring(1);
        }
        return str + "/" + str2;
    }

    public static String v(long j5, int i5) {
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(j5);
        if (i5 < 0) {
            i5 = 15;
        }
        objArr[1] = Integer.valueOf(i5);
        return String.format("%08X:%X", objArr);
    }

    public static UsbManager x() {
        ZApp zApp = ZApp.f4571h;
        if (zApp == null) {
            return null;
        }
        return (UsbManager) zApp.getSystemService("usb");
    }

    public static void y(int i5, p.e eVar, m mVar, boolean z4) {
        p.d dVar;
        p.d dVar2;
        Iterator it;
        boolean z5;
        p.d dVar3;
        p.d dVar4;
        if (eVar.f4182m) {
            return;
        }
        if (!(eVar instanceof p.f) && eVar.A() && b(eVar)) {
            p.f.V(eVar, mVar, new q.b());
        }
        p.d j5 = eVar.j(p.c.LEFT);
        p.d j6 = eVar.j(p.c.RIGHT);
        int d5 = j5.d();
        int d6 = j6.d();
        HashSet hashSet = j5.f4149a;
        if (hashSet != null && j5.f4151c) {
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                p.d dVar5 = (p.d) it2.next();
                p.e eVar2 = dVar5.f4152d;
                int i6 = i5 + 1;
                boolean b5 = b(eVar2);
                if (eVar2.A() && b5) {
                    p.f.V(eVar2, mVar, new q.b());
                }
                p.d dVar6 = eVar2.I;
                p.d dVar7 = eVar2.K;
                if ((dVar5 == dVar6 && (dVar4 = dVar7.f4154f) != null && dVar4.f4151c) || (dVar5 == dVar7 && (dVar3 = dVar6.f4154f) != null && dVar3.f4151c)) {
                    it = it2;
                    z5 = true;
                } else {
                    it = it2;
                    z5 = false;
                }
                int i7 = eVar2.f4188p0[0];
                if (i7 != 3 || b5) {
                    if (!eVar2.A()) {
                        if (dVar5 == dVar6 && dVar7.f4154f == null) {
                            int e5 = dVar6.e() + d5;
                            eVar2.J(e5, eVar2.r() + e5);
                            y(i6, eVar2, mVar, z4);
                        } else if (dVar5 == dVar7 && dVar6.f4154f == null) {
                            int e6 = d5 - dVar7.e();
                            eVar2.J(e6 - eVar2.r(), e6);
                            y(i6, eVar2, mVar, z4);
                        } else if (z5 && !eVar2.y()) {
                            U(i6, eVar2, mVar, z4);
                        }
                    }
                } else if (i7 == 3 && eVar2.f4194v >= 0 && eVar2.f4193u >= 0 && ((eVar2.f4171g0 == 8 || (eVar2.f4190r == 0 && eVar2.W == 0.0f)) && !eVar2.y() && !eVar2.F && z5 && !eVar2.y())) {
                    V(i6, eVar, mVar, eVar2, z4);
                }
                it2 = it;
            }
        }
        if (eVar instanceof i) {
            return;
        }
        HashSet hashSet2 = j6.f4149a;
        if (hashSet2 != null && j6.f4151c) {
            Iterator it3 = hashSet2.iterator();
            while (it3.hasNext()) {
                p.d dVar8 = (p.d) it3.next();
                p.e eVar3 = dVar8.f4152d;
                int i8 = i5 + 1;
                boolean b6 = b(eVar3);
                if (eVar3.A() && b6) {
                    p.f.V(eVar3, mVar, new q.b());
                }
                p.d dVar9 = eVar3.I;
                p.d dVar10 = eVar3.K;
                boolean z6 = (dVar8 == dVar9 && (dVar2 = dVar10.f4154f) != null && dVar2.f4151c) || (dVar8 == dVar10 && (dVar = dVar9.f4154f) != null && dVar.f4151c);
                int i9 = eVar3.f4188p0[0];
                if (i9 != 3 || b6) {
                    if (!eVar3.A()) {
                        if (dVar8 == dVar9 && dVar10.f4154f == null) {
                            int e7 = dVar9.e() + d6;
                            eVar3.J(e7, eVar3.r() + e7);
                            y(i8, eVar3, mVar, z4);
                        } else if (dVar8 == dVar10 && dVar9.f4154f == null) {
                            int e8 = d6 - dVar10.e();
                            eVar3.J(e8 - eVar3.r(), e8);
                            y(i8, eVar3, mVar, z4);
                        } else if (z6 && !eVar3.y()) {
                            U(i8, eVar3, mVar, z4);
                        }
                    }
                } else if (i9 == 3 && eVar3.f4194v >= 0 && eVar3.f4193u >= 0) {
                    if (eVar3.f4171g0 != 8) {
                        if (eVar3.f4190r == 0) {
                            if (eVar3.W == 0.0f) {
                            }
                        }
                    }
                    if (!eVar3.y() && !eVar3.F && z6 && !eVar3.y()) {
                        V(i8, eVar, mVar, eVar3, z4);
                    }
                }
            }
        }
        eVar.f4182m = true;
    }

    public static int z(float f5) {
        if (f5 < 1.0f) {
            return -16777216;
        }
        if (f5 > 99.0f) {
            return -1;
        }
        float f6 = (f5 + 16.0f) / 116.0f;
        float f7 = (f5 > 8.0f ? 1 : (f5 == 8.0f ? 0 : -1)) > 0 ? f6 * f6 * f6 : f5 / 903.2963f;
        float f8 = f6 * f6 * f6;
        boolean z4 = f8 > 0.008856452f;
        float f9 = z4 ? f8 : ((f6 * 116.0f) - 16.0f) / 903.2963f;
        if (!z4) {
            f8 = ((f6 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = f2717l;
        return z.a.a(f9 * fArr[0], f7 * fArr[1], f8 * fArr[2]);
    }

    public void S(View view, float f5) {
        if (f2707b) {
            try {
                d0.b(view, f5);
                return;
            } catch (NoSuchMethodError unused) {
                f2707b = false;
            }
        }
        view.setAlpha(f5);
    }

    public void T(View view, int i5) {
        if (!f2709d) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f2708c = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsApi19", "fetchViewFlagsField: ");
            }
            f2709d = true;
        }
        Field field = f2708c;
        if (field != null) {
            try {
                f2708c.setInt(view, i5 | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public float w(View view) {
        if (f2707b) {
            try {
                return d0.a(view);
            } catch (NoSuchMethodError unused) {
                f2707b = false;
            }
        }
        return view.getAlpha();
    }
}

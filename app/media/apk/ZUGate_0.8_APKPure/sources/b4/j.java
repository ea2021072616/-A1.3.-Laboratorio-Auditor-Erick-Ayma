package b4;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Trace;
import android.preference.PreferenceManager;
import android.system.OsConstants;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.widget.b0;
import androidx.lifecycle.SavedStateHandleAttacher;
import androidx.lifecycle.n;
import androidx.lifecycle.n0;
import androidx.lifecycle.o0;
import androidx.lifecycle.t;
import androidx.lifecycle.w0;
import com.github.appintro.R;
import com.google.android.gms.internal.play_billing.i0;
import com.google.android.gms.internal.play_billing.l0;
import com.google.android.gms.internal.play_billing.l1;
import com.google.android.gms.internal.play_billing.m0;
import com.google.android.gms.internal.play_billing.r0;
import com.google.android.gms.internal.play_billing.t1;
import com.google.android.gms.internal.play_billing.u0;
import com.google.android.gms.internal.play_billing.v;
import com.google.android.gms.internal.play_billing.w1;
import com.google.android.gms.internal.play_billing.z;
import h0.g1;
import h0.m1;
import i4.l;
import i4.p;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import n0.m;
import n0.o;
import n0.q;
import ru.zdevs.zugate.ZApp;
/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: l  reason: collision with root package name */
    public static long f1673l;

    /* renamed from: m  reason: collision with root package name */
    public static Method f1674m;

    /* renamed from: r  reason: collision with root package name */
    public static Boolean f1678r;

    /* renamed from: s  reason: collision with root package name */
    public static Boolean f1679s;

    /* renamed from: t  reason: collision with root package name */
    public static Boolean f1680t;

    /* renamed from: u  reason: collision with root package name */
    public static Boolean f1681u;

    /* renamed from: w  reason: collision with root package name */
    public static String f1683w;

    /* renamed from: a  reason: collision with root package name */
    public static final l2.i f1662a = new l2.i();

    /* renamed from: b  reason: collision with root package name */
    public static final l2.i f1663b = new l2.i();

    /* renamed from: c  reason: collision with root package name */
    public static final l2.i f1664c = new l2.i();

    /* renamed from: d  reason: collision with root package name */
    public static final z0.d f1665d = new z0.d(12, null);

    /* renamed from: e  reason: collision with root package name */
    public static final e0.b f1666e = new e0.b();

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f1667f = {16842755, 16843041, 16843093, 16843097, 16843551, 16843754, 16843771, 16843778, 16843779};

    /* renamed from: g  reason: collision with root package name */
    public static final int[] f1668g = {16842755, 16843189, 16843190, 16843556, 16843557, 16843558, 16843866, 16843867};

    /* renamed from: h  reason: collision with root package name */
    public static final int[] f1669h = {16842755, 16843780, 16843781, 16843782, 16843783, 16843784, 16843785, 16843786, 16843787, 16843788, 16843789, 16843979, 16843980, 16844062};

    /* renamed from: i  reason: collision with root package name */
    public static final int[] f1670i = {16842755, 16843781, 16844062};

    /* renamed from: j  reason: collision with root package name */
    public static final int[] f1671j = {16843161};

    /* renamed from: k  reason: collision with root package name */
    public static final int[] f1672k = {16842755, 16843213};

    /* renamed from: n  reason: collision with root package name */
    public static final int[] f1675n = {R.attr.colorPrimary};
    public static final int[] o = {R.attr.colorPrimaryVariant};

    /* renamed from: p  reason: collision with root package name */
    public static final int[] f1676p = new int[0];

    /* renamed from: q  reason: collision with root package name */
    public static final Object[] f1677q = new Object[0];

    /* renamed from: v  reason: collision with root package name */
    public static final z0.d f1682v = new z0.d(11, null);

    public static int A0(int i5, byte[] bArr, int i6, int i7, w1 w1Var, v vVar) {
        if ((i5 >>> 3) != 0) {
            int i8 = i5 & 7;
            if (i8 == 0) {
                int E0 = E0(bArr, i6, vVar);
                w1Var.c(i5, Long.valueOf(vVar.f1966b));
                return E0;
            } else if (i8 == 1) {
                w1Var.c(i5, Long.valueOf(H0(bArr, i6)));
                return i6 + 8;
            } else if (i8 == 2) {
                int B0 = B0(bArr, i6, vVar);
                int i9 = vVar.f1965a;
                if (i9 >= 0) {
                    if (i9 <= bArr.length - B0) {
                        if (i9 == 0) {
                            w1Var.c(i5, z.f1994c);
                        } else {
                            w1Var.c(i5, z.k(bArr, B0, i9));
                        }
                        return B0 + i9;
                    }
                    throw u0.d();
                }
                throw u0.b();
            } else if (i8 != 3) {
                if (i8 == 5) {
                    w1Var.c(i5, Integer.valueOf(r0(bArr, i6)));
                    return i6 + 4;
                }
                throw new u0("Protocol message contained an invalid tag (zero).");
            } else {
                int i10 = (i5 & (-8)) | 4;
                w1 b5 = w1.b();
                int i11 = 0;
                while (true) {
                    if (i6 >= i7) {
                        break;
                    }
                    int B02 = B0(bArr, i6, vVar);
                    int i12 = vVar.f1965a;
                    if (i12 == i10) {
                        i11 = i12;
                        i6 = B02;
                        break;
                    }
                    i11 = i12;
                    i6 = A0(i12, bArr, B02, i7, b5, vVar);
                }
                if (i6 > i7 || i11 != i10) {
                    throw u0.c();
                }
                w1Var.c(i5, b5);
                return i6;
            }
        }
        throw new u0("Protocol message contained an invalid tag (zero).");
    }

    public static boolean B() {
        boolean isEnabled;
        try {
            if (f1674m == null) {
                isEnabled = Trace.isEnabled();
                return isEnabled;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        try {
            if (f1674m == null) {
                f1673l = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f1674m = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f1674m.invoke(null, Long.valueOf(f1673l))).booleanValue();
        } catch (Exception e5) {
            if (!(e5 instanceof InvocationTargetException)) {
                Log.v("Trace", "Unable to call isTagEnabled via reflection", e5);
                return false;
            }
            Throwable cause = e5.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
    }

    public static int B0(byte[] bArr, int i5, v vVar) {
        int i6 = i5 + 1;
        byte b5 = bArr[i5];
        if (b5 >= 0) {
            vVar.f1965a = b5;
            return i6;
        }
        return C0(b5, bArr, i6, vVar);
    }

    public static boolean C(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f1678r == null) {
            f1678r = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        f1678r.booleanValue();
        if (f1679s == null) {
            f1679s = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        if (f1679s.booleanValue()) {
            if (Build.VERSION.SDK_INT >= 30) {
                return true;
            }
        }
        return false;
    }

    public static int C0(int i5, byte[] bArr, int i6, v vVar) {
        byte b5 = bArr[i6];
        int i7 = i6 + 1;
        int i8 = i5 & 127;
        if (b5 >= 0) {
            vVar.f1965a = i8 | (b5 << 7);
            return i7;
        }
        int i9 = i8 | ((b5 & Byte.MAX_VALUE) << 7);
        int i10 = i7 + 1;
        byte b6 = bArr[i7];
        if (b6 >= 0) {
            vVar.f1965a = i9 | (b6 << 14);
            return i10;
        }
        int i11 = i9 | ((b6 & Byte.MAX_VALUE) << 14);
        int i12 = i10 + 1;
        byte b7 = bArr[i10];
        if (b7 >= 0) {
            vVar.f1965a = i11 | (b7 << 21);
            return i12;
        }
        int i13 = i11 | ((b7 & Byte.MAX_VALUE) << 21);
        int i14 = i12 + 1;
        byte b8 = bArr[i12];
        if (b8 >= 0) {
            vVar.f1965a = i13 | (b8 << 28);
            return i14;
        }
        int i15 = i13 | ((b8 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i16 = i14 + 1;
            if (bArr[i14] >= 0) {
                vVar.f1965a = i15;
                return i16;
            }
            i14 = i16;
        }
    }

    public static TypedArray D(Context context, AttributeSet attributeSet, int[] iArr, int i5, int i6, int... iArr2) {
        e(context, attributeSet, i5, i6);
        f(context, attributeSet, iArr, i5, i6, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i5, i6);
    }

    public static int D0(int i5, byte[] bArr, int i6, int i7, r0 r0Var, v vVar) {
        m0 m0Var = (m0) r0Var;
        int B0 = B0(bArr, i6, vVar);
        m0Var.h(vVar.f1965a);
        while (B0 < i7) {
            int B02 = B0(bArr, B0, vVar);
            if (i5 != vVar.f1965a) {
                break;
            }
            B0 = B0(bArr, B02, vVar);
            m0Var.h(vVar.f1965a);
        }
        return B0;
    }

    public static int E0(byte[] bArr, int i5, v vVar) {
        long j5 = bArr[i5];
        int i6 = i5 + 1;
        if (j5 >= 0) {
            vVar.f1966b = j5;
            return i6;
        }
        int i7 = i6 + 1;
        byte b5 = bArr[i6];
        long j6 = (j5 & 127) | ((b5 & Byte.MAX_VALUE) << 7);
        int i8 = 7;
        while (b5 < 0) {
            int i9 = i7 + 1;
            byte b6 = bArr[i7];
            i8 += 7;
            j6 |= (b6 & Byte.MAX_VALUE) << i8;
            i7 = i9;
            b5 = b6;
        }
        vVar.f1966b = j6;
        return i7;
    }

    public static int F0(Object obj, t1 t1Var, byte[] bArr, int i5, int i6, int i7, v vVar) {
        int u3 = ((l1) t1Var).u(obj, bArr, i5, i6, i7, vVar);
        vVar.f1967c = obj;
        return u3;
    }

    public static int G0(Object obj, t1 t1Var, byte[] bArr, int i5, int i6, v vVar) {
        int i7 = i5 + 1;
        int i8 = bArr[i5];
        if (i8 < 0) {
            i7 = C0(i8, bArr, i7, vVar);
            i8 = vVar.f1965a;
        }
        int i9 = i7;
        if (i8 < 0 || i8 > i6 - i9) {
            throw u0.d();
        }
        int i10 = i8 + i9;
        t1Var.d(obj, bArr, i9, i10, vVar);
        vVar.f1967c = obj;
        return i10;
    }

    public static long H0(byte[] bArr, int i5) {
        return (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16) | ((bArr[i5 + 3] & 255) << 24) | ((bArr[i5 + 4] & 255) << 32) | ((bArr[i5 + 5] & 255) << 40) | ((bArr[i5 + 6] & 255) << 48) | ((bArr[i5 + 7] & 255) << 56);
    }

    public static int K(int i5) {
        int i6 = i5 & 805306368;
        int i7 = i6 == 805306368 ? OsConstants.O_RDWR : i6 == 536870912 ? OsConstants.O_WRONLY : OsConstants.O_RDONLY;
        if ((134217728 & i5) != 0) {
            i7 |= OsConstants.O_CREAT;
        }
        if ((67108864 & i5) != 0) {
            i7 |= OsConstants.O_TRUNC;
        }
        return (i5 & 33554432) != 0 ? i7 | OsConstants.O_APPEND : i7;
    }

    public static String L(int i5) {
        String str = (OsConstants.O_ACCMODE & i5) == OsConstants.O_RDWR ? "rw" : (OsConstants.O_ACCMODE & i5) == OsConstants.O_WRONLY ? "w" : "r";
        int i6 = OsConstants.O_APPEND;
        if ((i5 & i6) == i6) {
            str = str.concat("a");
        }
        int i7 = OsConstants.O_TRUNC;
        return (i5 & i7) == i7 ? b0.h(str, "t") : str;
    }

    public static byte[] M(InputStream inputStream, int i5) {
        byte[] bArr = new byte[i5];
        int i6 = 0;
        while (i6 < i5) {
            int read = inputStream.read(bArr, i6, i5 - i6);
            if (read < 0) {
                throw new IllegalStateException(b0.f("Not enough bytes to read: ", i5));
            }
            i6 += read;
        }
        return bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x005b, code lost:
        if (r0.finished() == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0060, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0068, code lost:
        throw new java.lang.IllegalStateException("Inflater did not finish");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] N(java.io.FileInputStream r8, int r9, int r10) {
        /*
            java.util.zip.Inflater r0 = new java.util.zip.Inflater
            r0.<init>()
            byte[] r1 = new byte[r10]     // Catch: java.lang.Throwable -> L88
            r2 = 2048(0x800, float:2.87E-42)
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L88
            r3 = 0
            r4 = r3
            r5 = r4
        Le:
            boolean r6 = r0.finished()     // Catch: java.lang.Throwable -> L88
            if (r6 != 0) goto L55
            boolean r6 = r0.needsDictionary()     // Catch: java.lang.Throwable -> L88
            if (r6 != 0) goto L55
            if (r4 >= r9) goto L55
            int r6 = r8.read(r2)     // Catch: java.lang.Throwable -> L88
            if (r6 < 0) goto L39
            r0.setInput(r2, r3, r6)     // Catch: java.lang.Throwable -> L88
            int r7 = r10 - r5
            int r7 = r0.inflate(r1, r5, r7)     // Catch: java.util.zip.DataFormatException -> L2e java.lang.Throwable -> L88
            int r5 = r5 + r7
            int r4 = r4 + r6
            goto Le
        L2e:
            r8 = move-exception
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Throwable -> L88
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L88
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L88
            throw r9     // Catch: java.lang.Throwable -> L88
        L39:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L88
            r8.<init>()     // Catch: java.lang.Throwable -> L88
            java.lang.String r10 = "Invalid zip data. Stream ended after $totalBytesRead bytes. Expected "
            r8.append(r10)     // Catch: java.lang.Throwable -> L88
            r8.append(r9)     // Catch: java.lang.Throwable -> L88
            java.lang.String r9 = " bytes"
            r8.append(r9)     // Catch: java.lang.Throwable -> L88
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L88
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L88
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L88
            throw r9     // Catch: java.lang.Throwable -> L88
        L55:
            if (r4 != r9) goto L69
            boolean r8 = r0.finished()     // Catch: java.lang.Throwable -> L88
            if (r8 == 0) goto L61
            r0.end()
            return r1
        L61:
            java.lang.String r8 = "Inflater did not finish"
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L88
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L88
            throw r9     // Catch: java.lang.Throwable -> L88
        L69:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L88
            r8.<init>()     // Catch: java.lang.Throwable -> L88
            java.lang.String r10 = "Didn't read enough bytes during decompression. expected="
            r8.append(r10)     // Catch: java.lang.Throwable -> L88
            r8.append(r9)     // Catch: java.lang.Throwable -> L88
            java.lang.String r9 = " actual="
            r8.append(r9)     // Catch: java.lang.Throwable -> L88
            r8.append(r4)     // Catch: java.lang.Throwable -> L88
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L88
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L88
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L88
            throw r9     // Catch: java.lang.Throwable -> L88
        L88:
            r8 = move-exception
            r0.end()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.j.N(java.io.FileInputStream, int, int):byte[]");
    }

    public static long O(InputStream inputStream, int i5) {
        byte[] M = M(inputStream, i5);
        long j5 = 0;
        for (int i6 = 0; i6 < i5; i6++) {
            j5 += (M[i6] & 255) << (i6 * 8);
        }
        return j5;
    }

    public static int P(InputStream inputStream) {
        return (int) O(inputStream, 2);
    }

    public static void Q(long j5) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(ZApp.f4571h).edit();
        edit.remove("pwd_" + j5).apply();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00ac A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void R(long r13, y4.j r15) {
        /*
            int r0 = r15.f5740b
            if (r0 == 0) goto La9
            r1 = 9
            if (r0 > r1) goto La9
            if (r0 >= 0) goto Lc
            goto La9
        Lc:
            java.lang.String r0 = r15.a()
            int r1 = r15.f5744f
            if (r1 != 0) goto L2c
            int r1 = r15.f5745g
            r2 = 3
            if (r1 >= r2) goto L2c
            java.security.SecureRandom r1 = new java.security.SecureRandom
            r1.<init>()
            int r3 = r1.nextInt(r2)
            r15.f5744f = r3
            r3 = 7
            int r1 = r1.nextInt(r3)
            int r1 = r1 + r2
            r15.f5745g = r1
        L2c:
            d.e r1 = new d.e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "zugPwd"
            r2.<init>(r3)
            int r4 = r15.f5744f
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            java.lang.String r4 = r15.f5746h
            r1.<init>(r2, r4)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            int r5 = r15.f5745g
            java.lang.String r5 = d.e.h(r5)
            r2.append(r5)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.String r11 = r1.g(r0)
            if (r11 != 0) goto L5f
            goto La9
        L5f:
            java.util.Locale r0 = java.util.Locale.ENGLISH
            int r1 = r15.f5741c
            int r1 = r1 / 10
            java.lang.Integer r5 = java.lang.Integer.valueOf(r1)
            int r1 = r15.f5741c
            int r1 = r1 % 10
            java.lang.Integer r6 = java.lang.Integer.valueOf(r1)
            int r1 = r15.f5742d
            int r1 = r1 % 10
            java.lang.Integer r7 = java.lang.Integer.valueOf(r1)
            int r1 = r15.f5740b
            int r1 = r1 % 10
            java.lang.Integer r8 = java.lang.Integer.valueOf(r1)
            int r1 = r15.f5745g
            int r1 = r1 % 10
            java.lang.Integer r9 = java.lang.Integer.valueOf(r1)
            int r15 = r15.f5744f
            int r15 = r15 % 10
            java.lang.Integer r10 = java.lang.Integer.valueOf(r15)
            java.lang.Long r12 = java.lang.Long.valueOf(r13)
            java.lang.Object[] r15 = new java.lang.Object[]{r5, r6, r7, r8, r9, r10, r11, r12}
            java.lang.String r1 = "@1%d%d%d%d%d%d%sZ%d"
            java.lang.String r15 = java.lang.String.format(r0, r1, r15)
            d.e r0 = new d.e
            r0.<init>(r3, r4)
            java.lang.String r15 = r0.g(r15)
            goto Laa
        La9:
            r15 = 0
        Laa:
            if (r15 != 0) goto Lad
            return
        Lad:
            ru.zdevs.zugate.ZApp r0 = ru.zdevs.zugate.ZApp.f4571h
            android.content.SharedPreferences r0 = android.preference.PreferenceManager.getDefaultSharedPreferences(r0)
            android.content.SharedPreferences$Editor r0 = r0.edit()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "pwd_"
            r1.<init>(r2)
            r1.append(r13)
            java.lang.String r13 = r1.toString()
            android.content.SharedPreferences$Editor r13 = r0.putString(r13, r15)
            r13.apply()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.j.R(long, y4.j):void");
    }

    public static final void S(View view, t tVar) {
        e4.e.f(view, "<this>");
        view.setTag(R.id.view_tree_lifecycle_owner, tVar);
    }

    public static final void T(View view, b1.f fVar) {
        e4.e.f(view, "<this>");
        view.setTag(R.id.view_tree_saved_state_registry_owner, fVar);
    }

    public static void U(Context context, String str, boolean z4) {
        if (context == null) {
            context = ZApp.f4571h;
        } else {
            ZApp zApp = ZApp.f4571h;
        }
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(str, z4).apply();
    }

    public static void V(Context context, String str) {
        Context context2;
        if (context == null) {
            context2 = ZApp.f4571h;
        } else {
            ZApp zApp = ZApp.f4571h;
            context2 = context;
        }
        PreferenceManager.getDefaultSharedPreferences(context2).edit().putString("dnt", new d.e("zugOpt", u(context)).g(str)).apply();
    }

    public static void W(Window window, boolean z4) {
        if (Build.VERSION.SDK_INT >= 30) {
            m1.a(window, z4);
            return;
        }
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        decorView.setSystemUiVisibility(z4 ? systemUiVisibility & (-1793) : systemUiVisibility | 1792);
    }

    public static void X(TextView textView, int i5) {
        p2.a.i(i5);
        if (Build.VERSION.SDK_INT >= 28) {
            o.d(textView, i5);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i6 = textView.getIncludeFontPadding() ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i5 > Math.abs(i6)) {
            textView.setPadding(textView.getPaddingLeft(), i5 + i6, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void Y(TextView textView, int i5) {
        p2.a.i(i5);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i6 = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i5 > Math.abs(i6)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i5 - i6);
        }
    }

    public static void Z(TextView textView, int i5) {
        p2.a.i(i5);
        int fontMetricsInt = textView.getPaint().getFontMetricsInt(null);
        if (i5 != fontMetricsInt) {
            textView.setLineSpacing(i5 - fontMetricsInt, 1.0f);
        }
    }

    public static void a(p pVar) {
        if (pVar != null) {
            if ((pVar instanceof j4.e ? ((j4.e) pVar).b() : pVar instanceof i4.a ? 0 : pVar instanceof l ? 1 : 2) == 2) {
                return;
            }
            ClassCastException classCastException = new ClassCastException(pVar.getClass().getName().concat(" cannot be cast to kotlin.jvm.functions.Function2"));
            e4.e.Q(j.class.getName(), classCastException);
            throw classCastException;
        }
    }

    public static void a0(TextView textView, int i5, float f5) {
        if (Build.VERSION.SDK_INT >= 34) {
            n0.p.a(textView, i5, f5);
        } else {
            Z(textView, Math.round(TypedValue.applyDimension(i5, f5, textView.getResources().getDisplayMetrics())));
        }
    }

    public static int b(int i5, int i6, int[] iArr) {
        int i7 = i5 - 1;
        int i8 = 0;
        while (i8 <= i7) {
            int i9 = (i8 + i7) >>> 1;
            int i10 = iArr[i9];
            if (i10 < i6) {
                i8 = i9 + 1;
            } else if (i10 <= i6) {
                return i9;
            } else {
                i7 = i9 - 1;
            }
        }
        return ~i8;
    }

    public static String[] b0(String str, String str2) {
        int length = str2.length();
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        while (true) {
            int indexOf = str.indexOf(str2, i5);
            if (indexOf <= -1) {
                break;
            }
            if (i5 != indexOf) {
                arrayList.add(str.substring(i5, indexOf));
            } else {
                arrayList.add(null);
            }
            i5 = indexOf + length;
        }
        if (i5 < str.length()) {
            arrayList.add(str.substring(i5));
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static int c(long[] jArr, int i5, long j5) {
        int i6 = i5 - 1;
        int i7 = 0;
        while (i7 <= i6) {
            int i8 = (i7 + i6) >>> 1;
            int i9 = (jArr[i8] > j5 ? 1 : (jArr[i8] == j5 ? 0 : -1));
            if (i9 < 0) {
                i7 = i8 + 1;
            } else if (i9 <= 0) {
                return i8;
            } else {
                i6 = i8 - 1;
            }
        }
        return ~i7;
    }

    public static int c0(String str) {
        if (str != null) {
            r1 = str.indexOf(114) != -1 ? 268435456 : 0;
            if (str.indexOf(119) != -1) {
                r1 |= 671088640;
            }
            if (str.indexOf(116) != -1) {
                r1 |= 67108864;
            }
            if (str.indexOf(97) != -1) {
                r1 |= 33554432;
            }
        }
        if (r1 == 0) {
            return 268435456;
        }
        return r1;
    }

    public static final void d(View view) {
        e4.e.f(view, "<this>");
        g1 g1Var = new g1(view, null);
        o4.a aVar = new o4.a();
        aVar.f4119e = k(aVar, aVar, g1Var);
        while (aVar.hasNext()) {
            View view2 = (View) aVar.next();
            o0.a aVar2 = (o0.a) view2.getTag(R.id.pooling_container_listener_holder_tag);
            if (aVar2 == null) {
                aVar2 = new o0.a();
                view2.setTag(R.id.pooling_container_listener_holder_tag, aVar2);
            }
            ArrayList arrayList = aVar2.f4091a;
            int r5 = e4.e.r(arrayList);
            if (-1 < r5) {
                b0.n(arrayList.get(r5));
                throw null;
            }
        }
    }

    public static void e(Context context, AttributeSet attributeSet, int i5, int i6) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w2.a.B, i5, i6);
        boolean z4 = obtainStyledAttributes.getBoolean(1, false);
        obtainStyledAttributes.recycle();
        if (z4) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(R.attr.isMaterialTheme, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                g(context, o, "Theme.MaterialComponents");
            }
        }
        g(context, f1675n, "Theme.AppCompat");
    }

    public static ActionMode.Callback e0(ActionMode.Callback callback) {
        return callback instanceof q ? ((q) callback).f4072a : callback;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:
        if (r0.getResourceId(0, -1) != (-1)) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void f(android.content.Context r4, android.util.AttributeSet r5, int[] r6, int r7, int r8, int... r9) {
        /*
            int[] r0 = w2.a.B
            android.content.res.TypedArray r0 = r4.obtainStyledAttributes(r5, r0, r7, r8)
            r1 = 2
            r2 = 0
            boolean r1 = r0.getBoolean(r1, r2)
            if (r1 != 0) goto L12
            r0.recycle()
            return
        L12:
            int r1 = r9.length
            r3 = -1
            if (r1 != 0) goto L1d
            int r4 = r0.getResourceId(r2, r3)
            if (r4 == r3) goto L38
            goto L37
        L1d:
            android.content.res.TypedArray r4 = r4.obtainStyledAttributes(r5, r6, r7, r8)
            int r5 = r9.length
            r6 = r2
        L23:
            if (r6 >= r5) goto L34
            r7 = r9[r6]
            int r7 = r4.getResourceId(r7, r3)
            if (r7 != r3) goto L31
            r4.recycle()
            goto L38
        L31:
            int r6 = r6 + 1
            goto L23
        L34:
            r4.recycle()
        L37:
            r2 = 1
        L38:
            r0.recycle()
            if (r2 == 0) goto L3e
            return
        L3e:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant)."
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.j.f(android.content.Context, android.util.AttributeSet, int[], int, int, int[]):void");
    }

    public static ActionMode.Callback f0(ActionMode.Callback callback, TextView textView) {
        return (Build.VERSION.SDK_INT > 27 || (callback instanceof q) || callback == null) ? callback : new q(callback, textView);
    }

    public static void g(Context context, int[] iArr, String str) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        boolean z4 = false;
        int i5 = 0;
        while (true) {
            if (i5 >= iArr.length) {
                obtainStyledAttributes.recycle();
                z4 = true;
                break;
            } else if (!obtainStyledAttributes.hasValue(i5)) {
                obtainStyledAttributes.recycle();
                break;
            } else {
                i5++;
            }
        }
        if (z4) {
            return;
        }
        throw new IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or a descendant).");
    }

    public static void g0(Parcel parcel, int i5, boolean z4) {
        parcel.writeInt(i5 | 262144);
        parcel.writeInt(z4 ? 1 : 0);
    }

    public static void h0(Parcel parcel, int i5, int i6) {
        parcel.writeInt(i5 | 262144);
        parcel.writeInt(i6);
    }

    public static void i0(Parcel parcel, int i5, Parcelable parcelable, int i6) {
        if (parcelable == null) {
            return;
        }
        int o02 = o0(parcel, i5);
        parcelable.writeToParcel(parcel, i6);
        t0(parcel, o02);
    }

    public static byte[] j(byte[] bArr) {
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            deflaterOutputStream.write(bArr);
            deflaterOutputStream.close();
            deflater.end();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            deflater.end();
            throw th;
        }
    }

    public static void j0(Parcel parcel, int i5, String str) {
        if (str == null) {
            return;
        }
        int o02 = o0(parcel, i5);
        parcel.writeString(str);
        t0(parcel, o02);
    }

    public static final c4.b k(Object obj, c4.b bVar, p pVar) {
        e4.e.f(pVar, "<this>");
        e4.e.f(bVar, "completion");
        if (pVar instanceof e4.a) {
            return ((e4.a) pVar).e(obj, bVar);
        }
        c4.f a5 = bVar.a();
        return a5 == c4.g.f1790b ? new d4.b(obj, bVar, pVar) : new d4.c(bVar, a5, pVar, obj);
    }

    public static void k0(Parcel parcel, int i5, Parcelable[] parcelableArr, int i6) {
        if (parcelableArr == null) {
            return;
        }
        int o02 = o0(parcel, i5);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                w0(parcel, parcelable, i6);
            }
        }
        t0(parcel, o02);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0068, code lost:
        if (r5.isEmpty() == true) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.lifecycle.m0 l(w0.e r7) {
        /*
            l2.i r0 = b4.j.f1662a
            java.util.LinkedHashMap r7 = r7.f5293a
            java.lang.Object r0 = r7.get(r0)
            b1.f r0 = (b1.f) r0
            if (r0 == 0) goto L92
            l2.i r1 = b4.j.f1663b
            java.lang.Object r1 = r7.get(r1)
            androidx.lifecycle.w0 r1 = (androidx.lifecycle.w0) r1
            if (r1 == 0) goto L8a
            l2.i r2 = b4.j.f1664c
            java.lang.Object r2 = r7.get(r2)
            android.os.Bundle r2 = (android.os.Bundle) r2
            l2.i r3 = l2.i.f3856j
            java.lang.Object r7 = r7.get(r3)
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L82
            b1.d r0 = r0.getSavedStateRegistry()
            b1.c r0 = r0.b()
            boolean r3 = r0 instanceof androidx.lifecycle.n0
            r4 = 0
            if (r3 == 0) goto L38
            androidx.lifecycle.n0 r0 = (androidx.lifecycle.n0) r0
            goto L39
        L38:
            r0 = r4
        L39:
            if (r0 == 0) goto L7a
            androidx.lifecycle.o0 r1 = w(r1)
            java.util.LinkedHashMap r3 = r1.f1134d
            java.lang.Object r3 = r3.get(r7)
            androidx.lifecycle.m0 r3 = (androidx.lifecycle.m0) r3
            if (r3 != 0) goto L79
            java.lang.Class[] r3 = androidx.lifecycle.m0.f1118f
            r0.b()
            android.os.Bundle r3 = r0.f1132c
            if (r3 == 0) goto L57
            android.os.Bundle r3 = r3.getBundle(r7)
            goto L58
        L57:
            r3 = r4
        L58:
            android.os.Bundle r5 = r0.f1132c
            if (r5 == 0) goto L5f
            r5.remove(r7)
        L5f:
            android.os.Bundle r5 = r0.f1132c
            if (r5 == 0) goto L6b
            boolean r5 = r5.isEmpty()
            r6 = 1
            if (r5 != r6) goto L6b
            goto L6c
        L6b:
            r6 = 0
        L6c:
            if (r6 == 0) goto L70
            r0.f1132c = r4
        L70:
            androidx.lifecycle.m0 r3 = p3.e.d(r3, r2)
            java.util.LinkedHashMap r0 = r1.f1134d
            r0.put(r7, r3)
        L79:
            return r3
        L7a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call"
            r7.<init>(r0)
            throw r7
        L82:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "CreationExtras must have a value by `VIEW_MODEL_KEY`"
            r7.<init>(r0)
            throw r7
        L8a:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`"
            r7.<init>(r0)
            throw r7
        L92:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.j.l(w0.e):androidx.lifecycle.m0");
    }

    public static void l0(Parcel parcel, int i5, List list) {
        if (list == null) {
            return;
        }
        int o02 = o0(parcel, i5);
        int size = list.size();
        parcel.writeInt(size);
        for (int i6 = 0; i6 < size; i6++) {
            Parcelable parcelable = (Parcelable) list.get(i6);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                w0(parcel, parcelable, 0);
            }
        }
        t0(parcel, o02);
    }

    public static void m(String str, String str2, Object obj) {
        String x5 = x(str);
        if (Log.isLoggable(x5, 3)) {
            Log.d(x5, String.format(str2, obj));
        }
    }

    public static void m0(ByteArrayOutputStream byteArrayOutputStream, long j5, int i5) {
        byte[] bArr = new byte[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            bArr[i6] = (byte) ((j5 >> (i6 * 8)) & 255);
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void n(String str, String str2, Exception exc) {
        String x5 = x(str);
        if (Log.isLoggable(x5, 6)) {
            Log.e(x5, str2, exc);
        }
    }

    public static void n0(ByteArrayOutputStream byteArrayOutputStream, int i5) {
        m0(byteArrayOutputStream, i5, 2);
    }

    public static final void o(b1.f fVar) {
        e4.e.f(fVar, "<this>");
        n nVar = ((androidx.lifecycle.v) fVar.getLifecycle()).f1151c;
        if (!(nVar == n.INITIALIZED || nVar == n.CREATED)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (fVar.getSavedStateRegistry().b() == null) {
            n0 n0Var = new n0(fVar.getSavedStateRegistry(), (w0) fVar);
            fVar.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider", n0Var);
            fVar.getLifecycle().a(new SavedStateHandleAttacher(n0Var));
        }
    }

    public static int o0(Parcel parcel, int i5) {
        parcel.writeInt(i5 | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static boolean p(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int p0(byte[] bArr, int i5, v vVar) {
        int B0 = B0(bArr, i5, vVar);
        int i6 = vVar.f1965a;
        if (i6 >= 0) {
            if (i6 <= bArr.length - B0) {
                if (i6 == 0) {
                    vVar.f1967c = z.f1994c;
                    return B0;
                }
                vVar.f1967c = z.k(bArr, B0, i6);
                return B0 + i6;
            }
            throw u0.d();
        }
        throw u0.b();
    }

    public static int q(String str, String[] strArr) {
        for (int i5 = 0; i5 < strArr.length; i5++) {
            if (strArr[i5].equals(str)) {
                return i5;
            }
        }
        return -1;
    }

    public static void q0(int i5, int i6) {
        String W;
        if (i5 < 0 || i5 >= i6) {
            if (i5 < 0) {
                W = i0.W("%s (%s) must not be negative", "index", Integer.valueOf(i5));
            } else if (i6 < 0) {
                throw new IllegalArgumentException(b0.f("negative size: ", i6));
            } else {
                W = i0.W("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i5), Integer.valueOf(i6));
            }
            throw new IndexOutOfBoundsException(W);
        }
    }

    public static boolean r(Context context, String str, boolean z4) {
        if (context == null) {
            context = ZApp.f4571h;
        } else {
            ZApp zApp = ZApp.f4571h;
        }
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, z4);
    }

    public static int r0(byte[] bArr, int i5) {
        int i6 = (bArr[i5 + 1] & 255) << 8;
        return ((bArr[i5 + 3] & 255) << 24) | i6 | (bArr[i5] & 255) | ((bArr[i5 + 2] & 255) << 16);
    }

    public static String s(Context context) {
        Context context2;
        if (context == null) {
            context2 = ZApp.f4571h;
        } else {
            ZApp zApp = ZApp.f4571h;
            context2 = context;
        }
        String string = PreferenceManager.getDefaultSharedPreferences(context2).getString("dnt", null);
        if (string == null) {
            return null;
        }
        return new d.e("zugOpt", u(context)).d(string);
    }

    public static void s0(int i5, int i6) {
        if (i5 < 0 || i5 > i6) {
            throw new IndexOutOfBoundsException(y0(i5, i6, "index"));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0097 A[LOOP:1: B:14:0x0054->B:29:0x0097, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0131 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x009b A[EDGE_INSN: B:99:0x009b->B:31:0x009b ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static d.m t(android.content.Context r20, androidx.appcompat.widget.s r21) {
        /*
            Method dump skipped, instructions count: 525
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.j.t(android.content.Context, androidx.appcompat.widget.s):d.m");
    }

    public static void t0(Parcel parcel, int i5) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i5 - 4);
        parcel.writeInt(dataPosition - i5);
        parcel.setDataPosition(dataPosition);
    }

    public static String u(Context context) {
        String str = f1683w;
        if (str != null) {
            return str;
        }
        if (context == null) {
            context = ZApp.f4571h;
        } else {
            ZApp zApp = ZApp.f4571h;
        }
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString("iv", "AndroidFixIV");
        f1683w = string;
        return string;
    }

    public static int u0(t1 t1Var, byte[] bArr, int i5, int i6, int i7, v vVar) {
        l0 a5 = t1Var.a();
        int F0 = F0(a5, t1Var, bArr, i5, i6, i7, vVar);
        t1Var.b(a5);
        vVar.f1967c = a5;
        return F0;
    }

    public static y4.j v(long j5) {
        int i5;
        int i6;
        int i7;
        ZApp zApp = ZApp.f4571h;
        String string = PreferenceManager.getDefaultSharedPreferences(zApp).getString("pwd_" + j5, null);
        if (string == null) {
            return null;
        }
        String u3 = u(zApp);
        String d5 = new d.e("zugPwd", u3).d(string);
        if (d5 == null) {
            return null;
        }
        String str = "Z" + j5;
        if (!d5.endsWith(str) || d5.length() <= str.length() + 3) {
            return null;
        }
        byte[] bytes = d5.getBytes();
        int i8 = 0;
        if (bytes[0] == 64) {
            byte b5 = bytes[1];
            i6 = bytes[4] - 48;
            i5 = (bytes[3] - 48) + ((bytes[2] - 48) * 10);
            i8 = 5;
        } else {
            i5 = 0;
            i6 = 0;
        }
        int i9 = bytes[i8] - 48;
        if ((i9 == 1 || i9 == 2) && d5.getBytes()[i8 + 1] - 48 >= 3) {
            return new y4.j(i9, d5.substring(i8 + 3, d5.length() - str.length()), d5.getBytes()[i8 + 2] - 48, i7, u3, i5, i6);
        }
        return null;
    }

    public static void v0(int i5, int i6, int i7) {
        if (i5 < 0 || i6 < i5 || i6 > i7) {
            throw new IndexOutOfBoundsException((i5 < 0 || i5 > i7) ? y0(i5, i7, "start index") : (i6 < 0 || i6 > i7) ? y0(i6, i7, "end index") : i0.W("end index (%s) must not be less than start index (%s)", Integer.valueOf(i6), Integer.valueOf(i5)));
        }
    }

    public static final o0 w(w0 w0Var) {
        e4.e.f(w0Var, "<this>");
        ArrayList arrayList = new ArrayList();
        j4.i.f3523a.getClass();
        Class a5 = new j4.c(o0.class).a();
        e4.e.d(a5, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        arrayList.add(new w0.f(a5));
        w0.f[] fVarArr = (w0.f[]) arrayList.toArray(new w0.f[0]);
        return (o0) new d.e(w0Var, new w0.c((w0.f[]) Arrays.copyOf(fVarArr, fVarArr.length))).k(o0.class, "androidx.lifecycle.internal.SavedStateHandlesVM");
    }

    public static void w0(Parcel parcel, Parcelable parcelable, int i5) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i5);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    public static String x(String str) {
        return "TRuntime.".concat(str);
    }

    public static int x0(t1 t1Var, int i5, byte[] bArr, int i6, int i7, r0 r0Var, v vVar) {
        l0 a5 = t1Var.a();
        int G0 = G0(a5, t1Var, bArr, i6, i7, vVar);
        t1Var.b(a5);
        vVar.f1967c = a5;
        r0Var.add(a5);
        while (G0 < i7) {
            int B0 = B0(bArr, G0, vVar);
            if (i5 != vVar.f1965a) {
                break;
            }
            l0 a6 = t1Var.a();
            int G02 = G0(a6, t1Var, bArr, B0, i7, vVar);
            t1Var.b(a6);
            vVar.f1967c = a6;
            r0Var.add(a6);
            G0 = G02;
        }
        return G0;
    }

    public static f0.d y(TextView textView) {
        TextDirectionHeuristic textDirectionHeuristic;
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 28) {
            return new f0.d(o.c(textView));
        }
        TextPaint textPaint = new TextPaint(textView.getPaint());
        TextDirectionHeuristic textDirectionHeuristic2 = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        int a5 = m.a(textView);
        int d5 = m.d(textView);
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            textDirectionHeuristic = TextDirectionHeuristics.LTR;
        } else {
            if (i5 < 28 || (textView.getInputType() & 15) != 3) {
                boolean z4 = textView.getLayoutDirection() == 1;
                switch (textView.getTextDirection()) {
                    case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                        textDirectionHeuristic = TextDirectionHeuristics.ANYRTL_LTR;
                        break;
                    case 3:
                        textDirectionHeuristic = TextDirectionHeuristics.LTR;
                        break;
                    case 4:
                        textDirectionHeuristic = TextDirectionHeuristics.RTL;
                        break;
                    case 5:
                        textDirectionHeuristic = TextDirectionHeuristics.LOCALE;
                        break;
                    case 6:
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                        break;
                    case 7:
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                        break;
                    default:
                        if (!z4) {
                            textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                            break;
                        } else {
                            textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                            break;
                        }
                }
            } else {
                byte directionality = Character.getDirectionality(o.b(n0.n.a(textView.getTextLocale()))[0].codePointAt(0));
                textDirectionHeuristic = (directionality == 1 || directionality == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
            }
        }
        return new f0.d(textPaint, textDirectionHeuristic, a5, d5);
    }

    public static String y0(int i5, int i6, String str) {
        if (i5 < 0) {
            return i0.W("%s (%s) must not be negative", str, Integer.valueOf(i5));
        }
        if (i6 >= 0) {
            return i0.W("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i5), Integer.valueOf(i6));
        }
        throw new IllegalArgumentException(b0.f("negative size: ", i6));
    }

    public static int z0(byte[] bArr, int i5, r0 r0Var, v vVar) {
        m0 m0Var = (m0) r0Var;
        int B0 = B0(bArr, i5, vVar);
        int i6 = vVar.f1965a + B0;
        while (B0 < i6) {
            B0 = B0(bArr, B0, vVar);
            m0Var.h(vVar.f1965a);
        }
        if (B0 == i6) {
            return B0;
        }
        throw u0.d();
    }

    public int A() {
        return 0;
    }

    public abstract void E(Throwable th);

    public abstract void F(g.f fVar);

    public void G(View view, int i5) {
    }

    public abstract void H(int i5);

    public abstract void I(View view, int i5, int i6);

    public abstract void J(View view, float f5, float f6);

    public abstract boolean d0(View view, int i5);

    public abstract int h(View view, int i5);

    public abstract int i(View view, int i5);

    public int z(View view) {
        return 0;
    }
}

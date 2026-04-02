package com.google.android.gms.internal.play_billing;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.storage.StorageManager;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EdgeEffect;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.zdevs.zugate.USBGateProvider;
/* loaded from: classes.dex */
public abstract class i0 implements h0.l1 {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f1885b = true;

    /* renamed from: f  reason: collision with root package name */
    public static final i2.c f1889f;

    /* renamed from: g  reason: collision with root package name */
    public static final i2.c[] f1890g;

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f1891h;

    /* renamed from: i  reason: collision with root package name */
    public static final String[] f1892i;

    /* renamed from: j  reason: collision with root package name */
    public static final p3.e f1893j;

    /* renamed from: k  reason: collision with root package name */
    public static final z0.d f1894k;

    /* renamed from: a  reason: collision with root package name */
    public static final z0.d f1884a = new z0.d(13, null);

    /* renamed from: c  reason: collision with root package name */
    public static final z0.d f1886c = new z0.d(15, null);

    /* renamed from: d  reason: collision with root package name */
    public static final u.g f1887d = new u.g(4);

    /* renamed from: e  reason: collision with root package name */
    public static final boolean[] f1888e = new boolean[3];

    static {
        i2.c cVar = new i2.c();
        f1889f = cVar;
        f1890g = new i2.c[]{cVar};
        f1891h = new String[]{"document_id", "_display_name", "mime_type", "_size", "last_modified"};
        f1892i = new String[]{"_display_name", "_size"};
        f1893j = new p3.e(29);
        f1894k = new z0.d(0, null);
    }

    public /* synthetic */ i0(int i5) {
    }

    public static Set A() {
        try {
            Object invoke = Class.forName("android.text.EmojiConsistency").getMethod("getEmojiConsistencySet", new Class[0]).invoke(null, new Object[0]);
            if (invoke == null) {
                return Collections.emptySet();
            }
            Set<Object> set = (Set) invoke;
            for (Object obj : set) {
                if (!(obj instanceof int[])) {
                    return Collections.emptySet();
                }
            }
            return set;
        } catch (Throwable unused) {
            return Collections.emptySet();
        }
    }

    public static Cursor B(ContentResolver contentResolver, Uri uri, String str) {
        try {
            boolean equals = "ru.zdevs.zugate.usbgate".equals(uri.getAuthority());
            String[] strArr = f1891h;
            if (equals) {
                USBGateProvider uSBGateProvider = USBGateProvider.f4563k;
                if (uSBGateProvider != null) {
                    return uSBGateProvider.queryChildDocuments(z(uri, str), strArr, "");
                }
                throw new Exception("USBGateProvider not loaded!");
            }
            return contentResolver.query(F(uri, str, true), strArr, null, null, null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String C(ContentResolver contentResolver, Uri uri) {
        if (DocumentsContract.isTreeUri(uri)) {
            uri = DocumentsContract.buildDocumentUriUsingTree(uri, DocumentsContract.getTreeDocumentId(uri));
        }
        try {
            Cursor query = contentResolver.query(uri, f1892i, null, null, null);
            if (query != null && query.moveToFirst()) {
                String string = query.getString(0);
                query.close();
                return string;
            } else if (query != null) {
                query.close();
                return null;
            } else {
                return null;
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public static long D(ContentResolver contentResolver, Uri uri) {
        if (DocumentsContract.isTreeUri(uri)) {
            uri = DocumentsContract.buildDocumentUriUsingTree(uri, DocumentsContract.getTreeDocumentId(uri));
        }
        try {
            Cursor query = contentResolver.query(uri, f1892i, null, null, null);
            if (query != null && query.moveToFirst()) {
                long j5 = query.getLong(1);
                query.close();
                return j5;
            } else if (query != null) {
                query.close();
                return 0L;
            } else {
                return 0L;
            }
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static ArrayList E(Toolbar toolbar, CharSequence charSequence) {
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < toolbar.getChildCount(); i5++) {
            View childAt = toolbar.getChildAt(i5);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (TextUtils.equals(textView.getText(), charSequence)) {
                    arrayList.add(textView);
                }
            }
        }
        return arrayList;
    }

    public static Uri F(Uri uri, String str, boolean z4) {
        String str2;
        if ("/".equals(str)) {
            str = "";
        } else if (str.length() > 0 && str.charAt(0) != '/') {
            str = "/".concat(str);
        }
        if (DocumentsContract.isTreeUri(uri)) {
            str2 = DocumentsContract.getTreeDocumentId(uri) + str;
        } else {
            str2 = DocumentsContract.getDocumentId(uri) + str;
        }
        return z4 ? DocumentsContract.buildChildDocumentsUriUsingTree(uri, str2) : DocumentsContract.buildDocumentUriUsingTree(uri, str2);
    }

    public static int G(int i5) {
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 != 4) {
                    if (i5 != 8) {
                        if (i5 != 16) {
                            if (i5 != 32) {
                                if (i5 != 64) {
                                    if (i5 != 128) {
                                        if (i5 == 256) {
                                            return 8;
                                        }
                                        throw new IllegalArgumentException(androidx.appcompat.widget.b0.f("type needs to be >= FIRST and <= LAST, type=", i5));
                                    }
                                    return 7;
                                }
                                return 6;
                            }
                            return 5;
                        }
                        return 4;
                    }
                    return 3;
                }
                return 2;
            }
            return 1;
        }
        return 0;
    }

    public static String H(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str2.length() + str.length());
        for (int i5 = 0; i5 < str.length(); i5++) {
            sb.append(str.charAt(i5));
            if (str2.length() > i5) {
                sb.append(str2.charAt(i5));
            }
        }
        return sb.toString();
    }

    public static void I(PackageInfo packageInfo, File file) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            dataOutputStream.writeLong(packageInfo.lastUpdateTime);
            dataOutputStream.close();
        } catch (IOException unused) {
        }
    }

    public static float J(EdgeEffect edgeEffect, float f5, float f6) {
        if (Build.VERSION.SDK_INT >= 31) {
            return n0.e.c(edgeEffect, f5, f6);
        }
        n0.d.a(edgeEffect, f5, f6);
        return f5;
    }

    public static r0.b M(MappedByteBuffer mappedByteBuffer) {
        long j5;
        ByteBuffer duplicate = mappedByteBuffer.duplicate();
        d.u0 u0Var = new d.u0(duplicate);
        u0Var.C(4);
        int i5 = ((ByteBuffer) u0Var.f2463h).getShort() & 65535;
        if (i5 <= 100) {
            u0Var.C(6);
            int i6 = 0;
            while (true) {
                if (i6 >= i5) {
                    j5 = -1;
                    break;
                }
                int i7 = ((ByteBuffer) u0Var.f2463h).getInt();
                u0Var.C(4);
                j5 = u0Var.B();
                u0Var.C(4);
                if (1835365473 == i7) {
                    break;
                }
                i6++;
            }
            if (j5 != -1) {
                u0Var.C((int) (j5 - ((ByteBuffer) u0Var.f2463h).position()));
                u0Var.C(12);
                long B = u0Var.B();
                for (int i8 = 0; i8 < B; i8++) {
                    int i9 = ((ByteBuffer) u0Var.f2463h).getInt();
                    long B2 = u0Var.B();
                    u0Var.B();
                    if (1164798569 == i9 || 1701669481 == i9) {
                        duplicate.position((int) (B2 + j5));
                        r0.b bVar = new r0.b();
                        duplicate.order(ByteOrder.LITTLE_ENDIAN);
                        bVar.b(duplicate.position() + duplicate.getInt(duplicate.position()), duplicate);
                        return bVar;
                    }
                }
            }
            throw new IOException("Cannot read metadata.");
        }
        throw new IOException("Cannot read metadata.");
    }

    public static boolean N(Parcel parcel, int i5) {
        b0(parcel, i5, 4);
        return parcel.readInt() != 0;
    }

    public static int O(Parcel parcel, int i5) {
        b0(parcel, i5, 4);
        return parcel.readInt();
    }

    public static int P(Parcel parcel, int i5) {
        return (i5 & (-65536)) != -65536 ? (char) (i5 >> 16) : parcel.readInt();
    }

    public static boolean Q(ContentResolver contentResolver, Uri uri, String str, String str2, String str3) {
        try {
            String u3 = e4.e.u(str, str2);
            if (!"ru.zdevs.zugate.usbgate".equals(uri.getAuthority())) {
                return DocumentsContract.renameDocument(contentResolver, F(uri, u3, false), str3) != null;
            }
            USBGateProvider uSBGateProvider = USBGateProvider.f4563k;
            if (uSBGateProvider != null) {
                return uSBGateProvider.renameDocument(z(uri, u3), str3) != null;
            }
            throw new Exception("USBGateProvider not loaded!");
        } catch (FileNotFoundException unused) {
            return true;
        } catch (Exception unused2) {
            return false;
        }
    }

    public static void R(Parcel parcel, int i5) {
        parcel.setDataPosition(parcel.dataPosition() + P(parcel, i5));
    }

    public static void S(ViewGroup viewGroup, boolean z4) {
        if (Build.VERSION.SDK_INT >= 29) {
            e1.b0.b(viewGroup, z4);
        } else if (f1885b) {
            try {
                e1.b0.b(viewGroup, z4);
            } catch (NoSuchMethodError unused) {
                f1885b = false;
            }
        }
    }

    public static int T(Parcel parcel) {
        int readInt = parcel.readInt();
        int P = P(parcel, readInt);
        char c5 = (char) readInt;
        int dataPosition = parcel.dataPosition();
        if (c5 == 20293) {
            int i5 = P + dataPosition;
            if (i5 < dataPosition || i5 > parcel.dataSize()) {
                throw new androidx.fragment.app.y("Size read is invalid start=" + dataPosition + " end=" + i5, parcel);
            }
            return i5;
        }
        throw new androidx.fragment.app.y("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(readInt))), parcel);
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x029a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0117 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0179 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:268:0x01db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0169  */
    /* JADX WARN: Type inference failed for: r1v2, types: [z0.c[], byte[]] */
    /* JADX WARN: Type inference failed for: r2v15, types: [z0.c[], byte[]] */
    /* JADX WARN: Type inference failed for: r5v2, types: [z0.e] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void U(android.content.Context r16, i.a r17, z0.e r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 716
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.i0.U(android.content.Context, i.a, z0.e, boolean):void");
    }

    public static int V(int i5) {
        return (int) (Integer.rotateLeft((int) (i5 * (-862048943)), 15) * 461845907);
    }

    public static String W(String str, Object... objArr) {
        int length;
        int length2;
        int indexOf;
        String str2;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            length = objArr.length;
            if (i6 >= length) {
                break;
            }
            Object obj = objArr[i6];
            if (obj == null) {
                str2 = "null";
            } else {
                try {
                    str2 = obj.toString();
                } catch (Exception e5) {
                    String str3 = obj.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(obj));
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(str3), (Throwable) e5);
                    str2 = "<" + str3 + " threw " + e5.getClass().getName() + ">";
                }
            }
            objArr[i6] = str2;
            i6++;
        }
        StringBuilder sb = new StringBuilder(str.length() + (length * 16));
        int i7 = 0;
        while (true) {
            length2 = objArr.length;
            if (i5 >= length2 || (indexOf = str.indexOf("%s", i7)) == -1) {
                break;
            }
            sb.append((CharSequence) str, i7, indexOf);
            sb.append(objArr[i5]);
            i7 = indexOf + 2;
            i5++;
        }
        sb.append((CharSequence) str, i7, str.length());
        if (i5 < length2) {
            sb.append(" [");
            sb.append(objArr[i5]);
            for (int i8 = i5 + 1; i8 < objArr.length; i8++) {
                sb.append(", ");
                sb.append(objArr[i8]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static /* bridge */ /* synthetic */ void X(byte b5, byte b6, byte b7, byte b8, char[] cArr, int i5) {
        if (!f0(b6)) {
            if ((((b6 + 112) + (b5 << 28)) >> 30) == 0 && !f0(b7) && !f0(b8)) {
                int i6 = ((b5 & 7) << 18) | ((b6 & 63) << 12) | ((b7 & 63) << 6) | (b8 & 63);
                cArr[i5] = (char) ((i6 >>> 10) + 55232);
                cArr[i5 + 1] = (char) ((i6 & 1023) + 56320);
                return;
            }
        }
        throw u0.a();
    }

    public static int Y(int i5) {
        return (i5 >>> 1) ^ (-(i5 & 1));
    }

    public static e0 Z() {
        String str;
        ClassLoader classLoader = i0.class.getClassLoader();
        if (e0.class.equals(e0.class)) {
            str = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";
        } else if (!e0.class.getPackage().equals(i0.class.getPackage())) {
            throw new IllegalArgumentException(e0.class.getName());
        } else {
            str = String.format("%s.BlazeGenerated%sLoader", e0.class.getPackage().getName(), e0.class.getSimpleName());
        }
        try {
            try {
                try {
                    try {
                        androidx.appcompat.widget.b0.n(Class.forName(str, true, classLoader).getConstructor(new Class[0]).newInstance(new Object[0]));
                        throw null;
                    } catch (InstantiationException e5) {
                        throw new IllegalStateException(e5);
                    }
                } catch (IllegalAccessException e6) {
                    throw new IllegalStateException(e6);
                }
            } catch (NoSuchMethodException e7) {
                throw new IllegalStateException(e7);
            } catch (InvocationTargetException e8) {
                throw new IllegalStateException(e8);
            }
        } catch (ClassNotFoundException unused) {
            Iterator it = ServiceLoader.load(i0.class, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                try {
                    androidx.appcompat.widget.b0.n(it.next());
                    throw null;
                } catch (ServiceConfigurationError e9) {
                    Logger.getLogger(b0.class.getName()).logp(Level.SEVERE, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", "Unable to load ".concat(e0.class.getSimpleName()), (Throwable) e9);
                }
            }
            if (arrayList.size() == 1) {
                return (e0) arrayList.get(0);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (e0) e0.class.getMethod("combine", Collection.class).invoke(null, arrayList);
            } catch (IllegalAccessException e10) {
                throw new IllegalStateException(e10);
            } catch (NoSuchMethodException e11) {
                throw new IllegalStateException(e11);
            } catch (InvocationTargetException e12) {
                throw new IllegalStateException(e12);
            }
        }
    }

    public static /* bridge */ /* synthetic */ void a0(byte b5, byte b6, byte b7, char[] cArr, int i5) {
        if (!f0(b6)) {
            if (b5 == -32) {
                if (b6 >= -96) {
                    b5 = -32;
                }
            }
            if (b5 == -19) {
                if (b6 < -96) {
                    b5 = -19;
                }
            }
            if (!f0(b7)) {
                cArr[i5] = (char) (((b5 & 15) << 12) | ((b6 & 63) << 6) | (b7 & 63));
                return;
            }
        }
        throw u0.a();
    }

    public static void b0(Parcel parcel, int i5, int i6) {
        int P = P(parcel, i5);
        if (P == i6) {
            return;
        }
        String hexString = Integer.toHexString(P);
        StringBuilder sb = new StringBuilder("Expected size ");
        sb.append(i6);
        sb.append(" got ");
        sb.append(P);
        sb.append(" (0x");
        throw new androidx.fragment.app.y(androidx.appcompat.widget.b0.i(sb, hexString, ")"), parcel);
    }

    public static long c0(long j5) {
        return (j5 >>> 1) ^ (-(1 & j5));
    }

    public static /* bridge */ /* synthetic */ void d0(byte b5, byte b6, char[] cArr, int i5) {
        if (b5 < -62 || f0(b6)) {
            throw u0.a();
        }
        cArr[i5] = (char) (((b5 & 31) << 6) | (b6 & 63));
    }

    public static /* bridge */ /* synthetic */ boolean e0(byte b5) {
        return b5 >= 0;
    }

    public static boolean f0(byte b5) {
        return b5 > -65;
    }

    public static void g(r2.d dVar) {
        Looper myLooper = Looper.myLooper();
        if (myLooper != dVar.getLooper()) {
            String name = myLooper != null ? myLooper.getThread().getName() : "null current looper";
            String name2 = dVar.getLooper().getThread().getName();
            throw new IllegalStateException("Must be called on " + name2 + " thread, but got " + name + ".");
        }
    }

    public static void h(p.f fVar, n.d dVar, p.e eVar) {
        eVar.o = -1;
        eVar.f4187p = -1;
        int i5 = fVar.f4188p0[0];
        int[] iArr = eVar.f4188p0;
        if (i5 != 2 && iArr[0] == 4) {
            p.d dVar2 = eVar.I;
            int i6 = dVar2.f4155g;
            int r5 = fVar.r();
            p.d dVar3 = eVar.K;
            int i7 = r5 - dVar3.f4155g;
            dVar2.f4157i = dVar.k(dVar2);
            dVar3.f4157i = dVar.k(dVar3);
            dVar.d(dVar2.f4157i, i6);
            dVar.d(dVar3.f4157i, i7);
            eVar.o = 2;
            eVar.Y = i6;
            int i8 = i7 - i6;
            eVar.U = i8;
            int i9 = eVar.f4161b0;
            if (i8 < i9) {
                eVar.U = i9;
            }
        }
        if (fVar.f4188p0[1] == 2 || iArr[1] != 4) {
            return;
        }
        p.d dVar4 = eVar.J;
        int i10 = dVar4.f4155g;
        int l5 = fVar.l();
        p.d dVar5 = eVar.L;
        int i11 = l5 - dVar5.f4155g;
        dVar4.f4157i = dVar.k(dVar4);
        dVar5.f4157i = dVar.k(dVar5);
        dVar.d(dVar4.f4157i, i10);
        dVar.d(dVar5.f4157i, i11);
        if (eVar.f4159a0 > 0 || eVar.f4171g0 == 8) {
            p.d dVar6 = eVar.M;
            n.i k5 = dVar.k(dVar6);
            dVar6.f4157i = k5;
            dVar.d(k5, eVar.f4159a0 + i10);
        }
        eVar.f4187p = 2;
        eVar.Z = i10;
        int i12 = i11 - i10;
        eVar.V = i12;
        int i13 = eVar.f4163c0;
        if (i12 < i13) {
            eVar.V = i13;
        }
    }

    public static void i(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static void j(Object obj) {
        if (obj == null) {
            throw new NullPointerException("null reference");
        }
    }

    public static int k(androidx.recyclerview.widget.e1 e1Var, androidx.recyclerview.widget.d0 d0Var, View view, View view2, androidx.recyclerview.widget.r0 r0Var, boolean z4) {
        if (r0Var.v() == 0 || e1Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (z4) {
            return Math.min(d0Var.i(), d0Var.b(view2) - d0Var.d(view));
        }
        return Math.abs(androidx.recyclerview.widget.r0.H(view) - androidx.recyclerview.widget.r0.H(view2)) + 1;
    }

    public static int l(androidx.recyclerview.widget.e1 e1Var, androidx.recyclerview.widget.d0 d0Var, View view, View view2, androidx.recyclerview.widget.r0 r0Var, boolean z4, boolean z5) {
        if (r0Var.v() == 0 || e1Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z5 ? Math.max(0, (e1Var.b() - Math.max(androidx.recyclerview.widget.r0.H(view), androidx.recyclerview.widget.r0.H(view2))) - 1) : Math.max(0, Math.min(androidx.recyclerview.widget.r0.H(view), androidx.recyclerview.widget.r0.H(view2)));
        if (z4) {
            return Math.round((max * (Math.abs(d0Var.b(view2) - d0Var.d(view)) / (Math.abs(androidx.recyclerview.widget.r0.H(view) - androidx.recyclerview.widget.r0.H(view2)) + 1))) + (d0Var.h() - d0Var.d(view)));
        }
        return max;
    }

    public static int m(androidx.recyclerview.widget.e1 e1Var, androidx.recyclerview.widget.d0 d0Var, View view, View view2, androidx.recyclerview.widget.r0 r0Var, boolean z4) {
        if (r0Var.v() == 0 || e1Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (z4) {
            return (int) (((d0Var.b(view2) - d0Var.d(view)) / (Math.abs(androidx.recyclerview.widget.r0.H(view) - androidx.recyclerview.widget.r0.H(view2)) + 1)) * e1Var.b());
        }
        return e1Var.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x004b A[EDGE_INSN: B:36:0x004b->B:20:0x004b ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.emoji2.text.n n(android.content.Context r8) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 < r1) goto Lc
            androidx.emoji2.text.e r0 = new androidx.emoji2.text.e
            r0.<init>()
            goto L11
        Lc:
            androidx.emoji2.text.d r0 = new androidx.emoji2.text.d
            r0.<init>()
        L11:
            android.content.pm.PackageManager r1 = r8.getPackageManager()
            java.lang.String r2 = "Package manager required to locate emoji font provider"
            p2.a.j(r1, r2)
            android.content.Intent r2 = new android.content.Intent
            java.lang.String r3 = "androidx.content.action.LOAD_EMOJI_FONT"
            r2.<init>(r3)
            r3 = 0
            java.util.List r2 = r1.queryIntentContentProviders(r2, r3)
            java.util.Iterator r2 = r2.iterator()
        L2a:
            boolean r4 = r2.hasNext()
            r5 = 0
            if (r4 == 0) goto L4a
            java.lang.Object r4 = r2.next()
            android.content.pm.ResolveInfo r4 = (android.content.pm.ResolveInfo) r4
            android.content.pm.ProviderInfo r4 = r4.providerInfo
            if (r4 == 0) goto L46
            android.content.pm.ApplicationInfo r6 = r4.applicationInfo
            if (r6 == 0) goto L46
            int r6 = r6.flags
            r7 = 1
            r6 = r6 & r7
            if (r6 != r7) goto L46
            goto L47
        L46:
            r7 = r3
        L47:
            if (r7 == 0) goto L2a
            goto L4b
        L4a:
            r4 = r5
        L4b:
            if (r4 != 0) goto L4e
            goto L7c
        L4e:
            java.lang.String r2 = r4.authority     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L76
            java.lang.String r4 = r4.packageName     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L76
            android.content.pm.Signature[] r0 = r0.j(r1, r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L76
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L76
            r1.<init>()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L76
            int r6 = r0.length     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L76
        L5c:
            if (r3 >= r6) goto L6a
            r7 = r0[r3]     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L76
            byte[] r7 = r7.toByteArray()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L76
            r1.add(r7)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L76
            int r3 = r3 + 1
            goto L5c
        L6a:
            java.util.List r0 = java.util.Collections.singletonList(r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L76
            androidx.appcompat.widget.s r1 = new androidx.appcompat.widget.s     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L76
            java.lang.String r3 = "emojicompat-emoji-font"
            r1.<init>(r2, r4, r3, r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L76
            goto L7d
        L76:
            r0 = move-exception
            java.lang.String r1 = "emoji2.text.DefaultEmojiConfig"
            android.util.Log.wtf(r1, r0)
        L7c:
            r1 = r5
        L7d:
            if (r1 != 0) goto L80
            goto L85
        L80:
            androidx.emoji2.text.n r5 = new androidx.emoji2.text.n
            r5.<init>(r8, r1)
        L85:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.i0.n(android.content.Context):androidx.emoji2.text.n");
    }

    public static boolean o(ContentResolver contentResolver, Uri uri, String str, String str2, boolean z4) {
        try {
            String str3 = "vnd.android.document/directory";
            if (!"ru.zdevs.zugate.usbgate".equals(uri.getAuthority())) {
                Uri F = F(uri, str, false);
                if (!z4) {
                    str3 = "";
                }
                return DocumentsContract.createDocument(contentResolver, F, str3, str2) != null;
            }
            USBGateProvider uSBGateProvider = USBGateProvider.f4563k;
            if (uSBGateProvider != null) {
                String z5 = z(uri, str);
                if (!z4) {
                    str3 = "";
                }
                return uSBGateProvider.createDocument(z5, str3, str2) != null;
            }
            throw new Exception("USBGateProvider not loaded!");
        } catch (Exception unused) {
            return false;
        }
    }

    public static Parcelable p(Parcel parcel, int i5, Parcelable.Creator creator) {
        int P = P(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (P == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + P);
        return parcelable;
    }

    public static String q(Parcel parcel, int i5) {
        int P = P(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (P == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + P);
        return readString;
    }

    public static Object[] r(Parcel parcel, int i5, Parcelable.Creator creator) {
        int P = P(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (P == 0) {
            return null;
        }
        Object[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + P);
        return createTypedArray;
    }

    public static final w0.b s(androidx.lifecycle.w0 w0Var) {
        e4.e.f(w0Var, "owner");
        return w0Var instanceof androidx.lifecycle.i ? ((androidx.lifecycle.i) w0Var).getDefaultViewModelCreationExtras() : w0.a.f5292b;
    }

    public static boolean t(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return false;
        }
        boolean z4 = true;
        for (File file2 : listFiles) {
            z4 = t(file2) && z4;
        }
        return z4;
    }

    public static Intent u(Context context, String str) {
        Intent createOpenDocumentTreeIntent;
        if (Build.VERSION.SDK_INT >= 29) {
            createOpenDocumentTreeIntent = ((StorageManager) context.getSystemService("storage")).getPrimaryStorageVolume().createOpenDocumentTreeIntent();
            createOpenDocumentTreeIntent.setAction(str);
            return createOpenDocumentTreeIntent;
        }
        Intent intent = new Intent(str);
        intent.putExtra("android.content.extra.SHOW_ADVANCED", true);
        intent.putExtra("android.provider.extra.SHOW_ADVANCED", true);
        return intent;
    }

    public static final boolean v(int i5, int i6) {
        return (i5 & i6) == i6;
    }

    public static void w(Parcel parcel, int i5) {
        if (parcel.dataPosition() != i5) {
            throw new androidx.fragment.app.y(androidx.appcompat.widget.b0.f("Overread allowed size end=", i5), parcel);
        }
    }

    public static float y(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return n0.e.b(edgeEffect);
        }
        return 0.0f;
    }

    public static String z(Uri uri, String str) {
        if ("/".equals(str)) {
            str = "";
        } else if (str.length() > 0 && str.charAt(0) != '/') {
            str = "/".concat(str);
        }
        if (DocumentsContract.isTreeUri(uri)) {
            return DocumentsContract.getTreeDocumentId(uri) + str;
        }
        return DocumentsContract.getDocumentId(uri) + str;
    }

    public abstract void K(m.f fVar, m.f fVar2);

    public abstract void L(m.f fVar, Thread thread);

    @Override // h0.l1
    public void b() {
    }

    @Override // h0.l1
    public void c() {
    }

    public abstract boolean d(m.g gVar, m.c cVar);

    public abstract boolean e(m.g gVar, Object obj, Object obj2);

    public abstract boolean f(m.g gVar, m.f fVar, m.f fVar2);

    public abstract void x(float f5, float f6, p3.t tVar);
}

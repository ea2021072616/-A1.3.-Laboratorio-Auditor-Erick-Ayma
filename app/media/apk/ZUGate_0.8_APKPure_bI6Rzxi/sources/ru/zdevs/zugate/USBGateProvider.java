package ru.zdevs.zugate;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.graphics.Point;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.provider.DocumentsProvider;
import android.system.OsConstants;
import b4.j;
import com.github.appintro.AppIntroBaseFragmentKt;
import com.github.appintro.R;
import e4.e;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import ru.zdevs.zugate.jni.IFS$FFile;
import ru.zdevs.zugate.jni.IFS$FStatFs;
import t4.q;
import t4.r;
import w4.g;
import w4.h;
import w4.i;
/* loaded from: classes.dex */
public class USBGateProvider extends DocumentsProvider {

    /* renamed from: i  reason: collision with root package name */
    public static final String[] f4561i = {"root_id", "summary", "flags", AppIntroBaseFragmentKt.ARG_TITLE, "document_id", "icon", "available_bytes"};

    /* renamed from: j  reason: collision with root package name */
    public static final String[] f4562j = {"document_id", "_display_name", "flags", "mime_type", "_size", "last_modified"};

    /* renamed from: k  reason: collision with root package name */
    public static USBGateProvider f4563k;

    /* renamed from: g  reason: collision with root package name */
    public ContentResolver f4564g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4565h;

    public static int a(i iVar, String str) {
        Iterator it = iVar.t(str).iterator();
        int i5 = 0;
        while (it.hasNext()) {
            IFS$FFile iFS$FFile = (IFS$FFile) it.next();
            String u3 = e.u(str, iFS$FFile.f4605a);
            if (iFS$FFile.a()) {
                i5 = a(iVar, u3);
                if (i5 != 0) {
                    break;
                }
            }
            i5 = iVar.i(u3);
            if (i5 != 0) {
                break;
            }
        }
        return i5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x006f, code lost:
        if (r0.startsWith("image/") != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(t4.q r5, java.lang.Object[] r6, java.lang.String r7, ru.zdevs.zugate.jni.IFS$FFile r8, boolean r9) {
        /*
            int r0 = r5.f5079a
            r1 = -1
            if (r0 == r1) goto L21
            int r2 = r8.f4609e
            r2 = r2 & 4
            if (r2 == 0) goto Le
            java.lang.String r7 = r8.f4606b
            goto L1f
        Le:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r7)
            java.lang.String r7 = r8.f4606b
            r2.append(r7)
            java.lang.String r7 = r2.toString()
        L1f:
            r6[r0] = r7
        L21:
            int r7 = r5.f5080b
            if (r7 == r1) goto L2d
            java.lang.String r0 = r8.f4605a
            if (r0 != 0) goto L2b
            java.lang.String r0 = "/"
        L2b:
            r6[r7] = r0
        L2d:
            int r7 = r5.f5081c
            if (r7 == r1) goto L72
            boolean r0 = r8.a()
            r2 = 1
            if (r0 == 0) goto L3b
            java.lang.String r0 = "vnd.android.document/directory"
            goto L67
        L3b:
            java.lang.String r0 = r8.f4605a
            if (r0 == 0) goto L62
            r3 = 46
            int r3 = r0.lastIndexOf(r3)
            if (r3 < 0) goto L53
            int r4 = r0.length()
            int r3 = r3 + r2
            if (r4 <= r3) goto L53
            java.lang.String r0 = r0.substring(r3)
            goto L55
        L53:
            java.lang.String r0 = ""
        L55:
            java.lang.String r0 = r0.toLowerCase()
            android.webkit.MimeTypeMap r3 = android.webkit.MimeTypeMap.getSingleton()
            java.lang.String r0 = r3.getMimeTypeFromExtension(r0)
            goto L63
        L62:
            r0 = 0
        L63:
            if (r0 != 0) goto L67
            java.lang.String r0 = "application/octet-stream"
        L67:
            r6[r7] = r0
            java.lang.String r7 = "image/"
            boolean r7 = r0.startsWith(r7)
            if (r7 == 0) goto L72
            goto L73
        L72:
            r2 = 0
        L73:
            int r7 = r5.f5082d
            if (r7 == r1) goto L89
            if (r9 == 0) goto L83
            r2 = r2 | 1350(0x546, float:1.892E-42)
            boolean r9 = r8.a()
            if (r9 == 0) goto L83
            r2 = r2 | 8
        L83:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r2)
            r6[r7] = r9
        L89:
            int r7 = r5.f5083e
            if (r7 == r1) goto L9e
            boolean r9 = r8.a()
            if (r9 == 0) goto L96
            r2 = 0
            goto L98
        L96:
            long r2 = r8.f4607c
        L98:
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            r6[r7] = r9
        L9e:
            int r5 = r5.f5084f
            if (r5 == r1) goto Lae
            int r7 = r8.f4608d
            long r7 = (long) r7
            r0 = 1000(0x3e8, double:4.94E-321)
            long r7 = r7 * r0
            java.lang.Long r7 = java.lang.Long.valueOf(r7)
            r6[r5] = r7
        Lae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.zdevs.zugate.USBGateProvider.b(t4.q, java.lang.Object[], java.lang.String, ru.zdevs.zugate.jni.IFS$FFile, boolean):void");
    }

    public static r c(String str, boolean z4) {
        USBGateService uSBGateService = USBGateService.f4566k;
        if (uSBGateService != null) {
            r i5 = uSBGateService.i(Long.parseLong(str.substring(0, 8), 16), e.t(str));
            if (i5 != null) {
                i iVar = i5.f5089e;
                if (iVar == null) {
                    throw new FileNotFoundException("FS mounted to " + i5.f5090f);
                } else if (z4 && iVar.C()) {
                    throw new FileNotFoundException("FS is read only");
                } else {
                    return i5;
                }
            }
            throw new FileNotFoundException("Storage not mounted");
        }
        throw new FileNotFoundException("Storage not mounted");
    }

    @Override // android.provider.DocumentsProvider
    public final String createDocument(String str, String str2, String str3) {
        r c5 = c(str, true);
        String substring = str.substring(10);
        h hVar = new h();
        boolean equals = "vnd.android.document/directory".equals(str2);
        i iVar = c5.f5089e;
        String v5 = equals ? iVar.v(substring, str3, hVar) : iVar.p(substring, str3);
        if (v5 != null) {
            d(4, str);
            return e.u(str.substring(0, 10), v5);
        }
        throw new FileNotFoundException("Operation error (" + hVar.f5427a + ")");
    }

    public final void d(int i5, String str) {
        this.f4564g.notifyChange(str == null ? DocumentsContract.buildRootsUri("ru.zdevs.zugate.usbgate") : DocumentsContract.buildDocumentUri("ru.zdevs.zugate.usbgate", e.M(str)), (ContentObserver) null, i5);
    }

    @Override // android.provider.DocumentsProvider
    public final void deleteDocument(String str) {
        r c5 = c(str, true);
        String M = e.M(str.substring(10));
        if (M.equals("/")) {
            throw new FileNotFoundException("Can't remove root");
        }
        i iVar = c5.f5089e;
        IFS$FFile d5 = iVar.d(M);
        if (d5 == null) {
            throw new FileNotFoundException("File not found");
        }
        int a5 = d5.a() ? a(iVar, M) : 0;
        if (a5 == 0) {
            a5 = iVar.i(M);
        }
        if (a5 == (-OsConstants.EBUSY)) {
            return;
        }
        if (a5 == 0) {
            d(16, e.u(str.substring(0, 10), e.p(M)));
            return;
        }
        throw new FileNotFoundException("Operation error (" + a5 + ")");
    }

    @Override // android.provider.DocumentsProvider
    public final void ejectRoot(String str) {
        USBGateService uSBGateService = USBGateService.f4566k;
        if (uSBGateService != null) {
            uSBGateService.q(Long.parseLong(str.substring(0, 8), 16), 32, e.t(str));
        }
        d(16, null);
    }

    @Override // android.provider.DocumentsProvider
    public final DocumentsContract.Path findDocumentPath(String str, String str2) {
        if (str == null) {
            String[] b02 = j.b0(str2, "/");
            if (b02.length >= 1) {
                ArrayList arrayList = new ArrayList(b02.length + 1);
                if (this.f4565h) {
                    arrayList.add("/");
                }
                StringBuilder sb = new StringBuilder();
                int i5 = 0;
                while (i5 < b02.length) {
                    if (sb.length() > 0) {
                        sb.append("/");
                    }
                    sb.append(b02[i5]);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(sb.toString());
                    sb2.append(i5 == 0 ? "/" : "");
                    arrayList.add(sb2.toString());
                    i5++;
                }
                return new DocumentsContract.Path((String) arrayList.get(0), arrayList);
            }
            throw new FileNotFoundException("");
        }
        throw new UnsupportedOperationException("findDocumentPath not supported.");
    }

    @Override // android.provider.DocumentsProvider
    public final boolean isChildDocument(String str, String str2) {
        return str2.startsWith(str);
    }

    @Override // android.provider.DocumentsProvider
    public final String moveDocument(String str, String str2, String str3) {
        r c5 = c(str, true);
        if (str.substring(0, 10).equals(str3.substring(0, 10))) {
            String M = e.M(str.substring(10));
            String M2 = e.M(str3.substring(10));
            h hVar = new h();
            String n5 = c5.f5089e.n(M, M2, hVar);
            if (n5 != null) {
                d(4, str2);
                d(4, str3);
                return e.u(str3, n5);
            }
            throw new FileNotFoundException("Operation error (" + hVar.f5427a + ")");
        }
        throw new FileNotFoundException("Moving between storage is not support)");
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        f4563k = this;
        this.f4564g = getContext().getContentResolver();
        this.f4565h = true;
        return true;
    }

    @Override // android.provider.DocumentsProvider
    public final ParcelFileDescriptor openDocument(String str, String str2, CancellationSignal cancellationSignal) {
        int c02;
        boolean z4;
        if ("r_t".equals(str2)) {
            c02 = 268435456;
            z4 = true;
        } else {
            c02 = j.c0(str2);
            z4 = false;
        }
        r c5 = c(str, (536870912 & c02) != 0);
        String substring = str.substring(10);
        g x5 = c5.f5089e.x(j.K(c02), substring);
        if (x5 != null) {
            try {
                return e.s(getContext(), c5, x5, c02, z4);
            } catch (IOException e5) {
                throw new FileNotFoundException(e5.getMessage());
            }
        }
        throw new FileNotFoundException("File not found: " + substring);
    }

    @Override // android.provider.DocumentsProvider
    public final AssetFileDescriptor openDocumentThumbnail(String str, Point point, CancellationSignal cancellationSignal) {
        return new AssetFileDescriptor(openDocument(str, "r_t", cancellationSignal), 0L, -1L, null);
    }

    @Override // android.provider.DocumentsProvider
    public final Cursor queryChildDocuments(String str, String[] strArr, String str2) {
        if (strArr == null) {
            strArr = f4562j;
        }
        if (!"/".equals(str)) {
            r c5 = c(str, false);
            MatrixCursor matrixCursor = new MatrixCursor(strArr);
            String M = e.M(str.substring(10));
            i iVar = c5.f5089e;
            boolean z4 = !iVar.C();
            int length = str.length();
            if (length <= 0 || str.charAt(length - 1) != '/') {
                str = str.concat("/");
            }
            q qVar = new q(matrixCursor);
            Object[] objArr = new Object[matrixCursor.getColumnCount()];
            Iterator it = iVar.t(M).iterator();
            while (it.hasNext()) {
                b(qVar, objArr, str, (IFS$FFile) it.next(), z4);
                matrixCursor.addRow(objArr);
            }
            matrixCursor.setNotificationUri(this.f4564g, DocumentsContract.buildDocumentUri("ru.zdevs.zugate.usbgate", e.M(str)));
            return matrixCursor;
        }
        MatrixCursor matrixCursor2 = new MatrixCursor(strArr);
        USBGateService uSBGateService = USBGateService.f4566k;
        if (uSBGateService == null) {
            return matrixCursor2;
        }
        ArrayList arrayList = new ArrayList(0);
        uSBGateService.d(arrayList);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            r rVar = (r) it2.next();
            MatrixCursor.RowBuilder newRow = matrixCursor2.newRow();
            newRow.add("document_id", e.v(rVar.f5086b, rVar.f5087c) + "/");
            newRow.add("_display_name", rVar.f5085a);
            newRow.add("mime_type", "vnd.android.document/directory");
            newRow.add("icon", Integer.valueOf(rVar.f5088d == 64 ? R.drawable.ic_disk_24 : R.drawable.ic_usb_24));
            newRow.add("flags", Integer.valueOf(!rVar.f5089e.C() ? 10 : 0));
        }
        return matrixCursor2;
    }

    @Override // android.provider.DocumentsProvider
    public final Cursor queryDocument(String str, String[] strArr) {
        int length;
        if (strArr == null) {
            strArr = f4562j;
        }
        if ("/".equals(str)) {
            MatrixCursor matrixCursor = new MatrixCursor(strArr);
            MatrixCursor.RowBuilder newRow = matrixCursor.newRow();
            newRow.add("document_id", "/");
            newRow.add("mime_type", "vnd.android.document/directory");
            newRow.add("flags", 0);
            return matrixCursor;
        }
        r c5 = c(str, false);
        String M = e.M(str.substring(10));
        i iVar = c5.f5089e;
        boolean z4 = !iVar.C();
        MatrixCursor matrixCursor2 = new MatrixCursor(strArr);
        IFS$FFile iFS$FFile = "/".equals(M) ? new IFS$FFile(null, null, 0L, 0, 1) : iVar.d(M);
        if (iFS$FFile != null) {
            String str2 = iFS$FFile.f4605a;
            if (str2 != null && str2.length() > 0 && ((length = (str = e.p(str)).length()) <= 0 || str.charAt(length - 1) != '/')) {
                str = str.concat("/");
            }
            q qVar = new q(matrixCursor2);
            Object[] objArr = new Object[matrixCursor2.getColumnCount()];
            b(qVar, objArr, str, iFS$FFile, z4);
            matrixCursor2.addRow(objArr);
            return matrixCursor2;
        }
        throw new FileNotFoundException("File not found");
    }

    @Override // android.provider.DocumentsProvider
    public final Cursor queryRoots(String[] strArr) {
        this.f4565h = j.r(getContext(), "group_storage", true);
        if (strArr == null) {
            strArr = f4561i;
        }
        MatrixCursor matrixCursor = new MatrixCursor(strArr);
        if (this.f4565h) {
            MatrixCursor.RowBuilder newRow = matrixCursor.newRow();
            newRow.add("root_id", "/");
            newRow.add("document_id", "/");
            newRow.add(AppIntroBaseFragmentKt.ARG_TITLE, getContext().getString(R.string.app_name));
            newRow.add("summary", getContext().getString(R.string.app_desc));
            newRow.add("flags", 19);
            newRow.add("icon", Integer.valueOf((int) R.mipmap.ic_launcher));
        } else {
            USBGateService uSBGateService = USBGateService.f4566k;
            if (uSBGateService == null) {
                return matrixCursor;
            }
            ArrayList arrayList = new ArrayList(0);
            uSBGateService.d(arrayList);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                r rVar = (r) it.next();
                if (rVar.f5089e != null) {
                    MatrixCursor.RowBuilder newRow2 = matrixCursor.newRow();
                    String v5 = e.v(rVar.f5086b, rVar.f5087c);
                    newRow2.add("root_id", v5);
                    newRow2.add("document_id", v5 + "/");
                    newRow2.add(AppIntroBaseFragmentKt.ARG_TITLE, rVar.f5085a);
                    i iVar = rVar.f5089e;
                    newRow2.add("flags", Integer.valueOf((iVar.C() ^ 1) | 2 | 16 | 32));
                    newRow2.add("icon", Integer.valueOf(rVar.f5088d == 64 ? R.drawable.ic_disk_24 : R.drawable.ic_usb_24));
                    IFS$FStatFs B = iVar.B();
                    if (B != null) {
                        newRow2.add("summary", B.f4610a);
                        newRow2.add("available_bytes", Long.valueOf(B.f4612c));
                    }
                }
            }
        }
        matrixCursor.setNotificationUri(this.f4564g, DocumentsContract.buildRootsUri("ru.zdevs.zugate.usbgate"));
        return matrixCursor;
    }

    @Override // android.provider.DocumentsProvider
    public final void removeDocument(String str, String str2) {
        deleteDocument(str);
    }

    @Override // android.provider.DocumentsProvider
    public final String renameDocument(String str, String str2) {
        r c5 = c(str, true);
        String substring = str.substring(10);
        String p5 = e.p(substring);
        h hVar = new h();
        String D = c5.f5089e.D(substring, p5, str2, hVar);
        if (D != null) {
            String u3 = e.u(str.substring(0, 10), p5);
            d(8, u3);
            return e.u(u3, D);
        }
        throw new FileNotFoundException("Operation error (" + hVar.f5427a + ")");
    }
}

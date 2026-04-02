package ru.zdevs.zugate.jni;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.system.OsConstants;
import android.util.Xml;
import androidx.annotation.Keep;
import b4.j;
import com.google.android.gms.internal.play_billing.i0;
import e4.e;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParser;
import ru.zdevs.zugate.USBGateProvider;
import ru.zdevs.zugate.ZApp;
import ru.zdevs.zugate.jni.BlockDevice;
import w4.g;
import w4.h;
import w4.i;
/* loaded from: classes.dex */
public class EncFS implements i {

    /* renamed from: b  reason: collision with root package name */
    public long f4596b;

    /* renamed from: c  reason: collision with root package name */
    public final Uri f4597c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4598d;

    /* renamed from: e  reason: collision with root package name */
    public final int f4599e;

    /* renamed from: f  reason: collision with root package name */
    public final int f4600f;

    /* renamed from: g  reason: collision with root package name */
    public final int f4601g;

    @Keep
    /* loaded from: classes.dex */
    public static class EncFSContext {
        public String cipherAlg;
        public String encodedKeyData;
        public String nameAlg;
        public String saltData;
        public int subVersion = 0;
        public int cipherVer = 0;
        public int nameVer = 0;
        public int keySize = 0;
        public int blockSize = 0;
        public int blockMACBytes = 0;
        public int blockMACRandBytes = 0;
        public int flags = 0;
        public int encodedKeySize = 0;
        public int saltLen = 0;
        public int kdfIterations = 0;
        public long desiredKDFDuration = 500;
    }

    static {
        System.loadLibrary("encfs-1.9.5");
    }

    public EncFS(long j5, Uri uri, int i5, int i6, int i7, int i8) {
        this.f4596b = j5;
        this.f4597c = uri;
        this.f4598d = i5;
        this.f4599e = i6;
        this.f4600f = i7;
        this.f4601g = i8;
    }

    public static EncFS L(Uri uri, String str, int i5) {
        InputStream inputStream;
        int i6;
        long j5;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int parseInt;
        int i19;
        ContentResolver a5 = ZApp.a();
        if (a5 == null) {
            return null;
        }
        if (str == null || str.isEmpty()) {
            throw new BlockDevice.BlockException(-103, "Password is empty");
        }
        try {
            if ("ru.zdevs.zugate.usbgate".equals(uri.getAuthority())) {
                USBGateProvider uSBGateProvider = USBGateProvider.f4563k;
                if (uSBGateProvider == null) {
                    throw new Exception("USBGateProvider not loaded!");
                }
                inputStream = new ParcelFileDescriptor.AutoCloseInputStream(uSBGateProvider.openDocument(i0.z(uri, ".encfs6.xml"), "r", null));
            } else {
                inputStream = a5.openInputStream(i0.F(uri, ".encfs6.xml", false));
            }
        } catch (Exception unused) {
            inputStream = null;
        }
        if (inputStream == null) {
            return null;
        }
        EncFSContext encFSContext = new EncFSContext();
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
            newPullParser.setInput(inputStream, null);
            int eventType = newPullParser.getEventType();
            String str2 = null;
            boolean z4 = false;
            while (true) {
                if (eventType == 1) {
                    break;
                }
                if (eventType == 2) {
                    str2 = newPullParser.getName();
                    if (str2.contains("cfg")) {
                        String attributeValue = newPullParser.getAttributeValue(null, "version");
                        if (attributeValue != null) {
                            try {
                                i19 = Integer.parseInt(attributeValue);
                            } catch (Exception unused2) {
                                i19 = 0;
                            }
                            encFSContext.subVersion = i19;
                        }
                    } else if ("cipherAlg".equalsIgnoreCase(str2)) {
                        z4 = true;
                    } else if ("nameAlg".equalsIgnoreCase(str2)) {
                        z4 = true;
                    }
                } else if (eventType == 3) {
                    str2 = null;
                } else {
                    if (eventType == 4) {
                        if ("version".equalsIgnoreCase(str2)) {
                            String text = newPullParser.getText();
                            int i20 = encFSContext.subVersion;
                            try {
                                parseInt = Integer.parseInt(text);
                            } catch (Exception unused3) {
                            }
                            encFSContext.subVersion = parseInt;
                        } else if (!"name".equalsIgnoreCase(str2)) {
                            if (!"major".equalsIgnoreCase(str2) && !"minor".equalsIgnoreCase(str2)) {
                                if ("keySize".equalsIgnoreCase(str2)) {
                                    try {
                                        i18 = Integer.parseInt(newPullParser.getText());
                                    } catch (Exception unused4) {
                                        i18 = 0;
                                    }
                                    encFSContext.keySize = i18;
                                } else if ("blockSize".equalsIgnoreCase(str2)) {
                                    try {
                                        i17 = Integer.parseInt(newPullParser.getText());
                                    } catch (Exception unused5) {
                                        i17 = 0;
                                    }
                                    encFSContext.blockSize = i17;
                                } else if ("plainData".equalsIgnoreCase(str2)) {
                                    int i21 = encFSContext.flags;
                                    try {
                                        i16 = Integer.parseInt(newPullParser.getText());
                                    } catch (Exception unused6) {
                                        i16 = 0;
                                    }
                                    encFSContext.flags = i21 | (i16 == 0 ? 0 : 1);
                                } else if ("uniqueIV".equalsIgnoreCase(str2)) {
                                    int i22 = encFSContext.flags;
                                    try {
                                        i15 = Integer.parseInt(newPullParser.getText());
                                    } catch (Exception unused7) {
                                        i15 = 0;
                                    }
                                    encFSContext.flags = i22 | (i15 == 0 ? 0 : 2);
                                } else if ("chainedNameIV".equalsIgnoreCase(str2)) {
                                    int i23 = encFSContext.flags;
                                    try {
                                        i14 = Integer.parseInt(newPullParser.getText());
                                    } catch (Exception unused8) {
                                        i14 = 0;
                                    }
                                    encFSContext.flags = i23 | (i14 == 0 ? 0 : 4);
                                } else if ("externalIVChaining".equalsIgnoreCase(str2)) {
                                    int i24 = encFSContext.flags;
                                    try {
                                        i13 = Integer.parseInt(newPullParser.getText());
                                    } catch (Exception unused9) {
                                        i13 = 0;
                                    }
                                    encFSContext.flags = i24 | (i13 != 0 ? 8 : 0);
                                } else if ("allowHoles".equalsIgnoreCase(str2)) {
                                    int i25 = encFSContext.flags;
                                    try {
                                        i12 = Integer.parseInt(newPullParser.getText());
                                    } catch (Exception unused10) {
                                        i12 = 0;
                                    }
                                    encFSContext.flags = i25 | (i12 == 0 ? 0 : 16);
                                } else if ("blockMACBytes".equalsIgnoreCase(str2)) {
                                    try {
                                        i11 = Integer.parseInt(newPullParser.getText());
                                    } catch (Exception unused11) {
                                        i11 = 0;
                                    }
                                    encFSContext.blockMACBytes = i11;
                                } else if ("blockMACRandBytes".equalsIgnoreCase(str2)) {
                                    try {
                                        i10 = Integer.parseInt(newPullParser.getText());
                                    } catch (Exception unused12) {
                                        i10 = 0;
                                    }
                                    encFSContext.blockMACRandBytes = i10;
                                } else if ("encodedKeySize".equalsIgnoreCase(str2)) {
                                    try {
                                        i9 = Integer.parseInt(newPullParser.getText());
                                    } catch (Exception unused13) {
                                        i9 = 0;
                                    }
                                    encFSContext.encodedKeySize = i9;
                                } else if ("encodedKeyData".equalsIgnoreCase(str2)) {
                                    encFSContext.encodedKeyData = newPullParser.getText();
                                } else if ("saltLen".equalsIgnoreCase(str2)) {
                                    try {
                                        i8 = Integer.parseInt(newPullParser.getText());
                                    } catch (Exception unused14) {
                                        i8 = 0;
                                    }
                                    encFSContext.saltLen = i8;
                                } else if ("saltData".equalsIgnoreCase(str2)) {
                                    encFSContext.saltData = newPullParser.getText();
                                } else if ("kdfIterations".equalsIgnoreCase(str2)) {
                                    try {
                                        i7 = Integer.parseInt(newPullParser.getText());
                                    } catch (Exception unused15) {
                                        i7 = 0;
                                    }
                                    encFSContext.kdfIterations = i7;
                                } else if ("desiredKDFDuration".equalsIgnoreCase(str2)) {
                                    try {
                                        j5 = Long.parseLong(newPullParser.getText());
                                    } catch (Exception unused16) {
                                        j5 = 0;
                                    }
                                    encFSContext.desiredKDFDuration = j5;
                                }
                            }
                            try {
                                i6 = Integer.parseInt(newPullParser.getText());
                            } catch (Exception unused17) {
                                i6 = 0;
                            }
                            if (!"major".equalsIgnoreCase(str2)) {
                                r14 = 0;
                            }
                            if (z4) {
                                encFSContext.cipherVer = (i6 << r14) | encFSContext.cipherVer;
                            } else if (z4) {
                                encFSContext.nameVer = (i6 << r14) | encFSContext.nameVer;
                            }
                        } else if (z4) {
                            encFSContext.cipherAlg = newPullParser.getText().toLowerCase(Locale.ROOT);
                        } else if (z4) {
                            String lowerCase = newPullParser.getText().toLowerCase(Locale.ROOT);
                            encFSContext.nameAlg = lowerCase;
                            if ("nameio/null".equals(lowerCase)) {
                                encFSContext.flags |= 65536;
                            }
                        }
                    }
                }
                eventType = newPullParser.next();
            }
            if (encFSContext.keySize == 0 || encFSContext.blockSize == 0 || (encFSContext.cipherAlg == null && encFSContext.nameAlg == null)) {
                throw new BlockDevice.BlockException(-104, "");
            }
            int i26 = encFSContext.subVersion;
            if (i26 == 26800) {
                encFSContext.subVersion = 20080816;
            } else if (i26 == 26797) {
                encFSContext.subVersion = 20080813;
            } else if (i26 != 20 && i26 < 20040813) {
                throw new BlockDevice.BlockException(-104, "version " + encFSContext.subVersion);
            }
            if (encFSContext.subVersion < 20080816) {
                encFSContext.kdfIterations = 16;
                encFSContext.desiredKDFDuration = 500L;
            }
            long cFsOpen = cFsOpen(encFSContext, str, i5);
            if (cFsOpen == 0) {
                return null;
            }
            return new EncFS(cFsOpen, uri, i5, encFSContext.flags, encFSContext.blockSize, encFSContext.blockMACBytes + encFSContext.blockMACRandBytes);
        } catch (Exception unused18) {
            throw new BlockDevice.BlockException(-104, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native int cClose(long j5, long j6);

    private static native int cFsClose(long j5);

    public static native int cFsInit(EncFSContext encFSContext, String str);

    private static native long cFsOpen(EncFSContext encFSContext, String str, int i5);

    private static native String cNameCode(long j5, String str, long j6, boolean z4);

    private static native long cNameIv(long j5, String str);

    private static native long cOpen(long j5, int i5, int i6);

    private static native String cPathCode(long j5, String str, boolean z4);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int cRead(long j5, byte[] bArr, int i5);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long cSeek(long j5, long j6, int i5);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int cWrite(long j5, byte[] bArr, int i5);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int cWriteFrom(long j5, int i5);

    @Override // w4.i
    public final IFS$FStatFs B() {
        return null;
    }

    @Override // w4.i
    public final boolean C() {
        return (this.f4598d & 1) == 1;
    }

    @Override // w4.i
    public final String D(String str, String str2, String str3, h hVar) {
        ContentResolver a5 = ZApp.a();
        if (K() || a5 == null) {
            hVar.f5427a = -OsConstants.EINVAL;
            return null;
        } else if (C()) {
            hVar.f5427a = -OsConstants.EROFS;
            return null;
        } else {
            int i5 = this.f4599e;
            if ((i5 & 8) == 8) {
                hVar.f5427a = -OsConstants.ENOTSUP;
                return null;
            }
            long cNameIv = cNameIv(this.f4596b, str2);
            String o = e.o(str);
            String cNameCode = cNameCode(this.f4596b, str3, cNameIv, true);
            if (cNameCode == null || !i0.Q(a5, this.f4597c, str2, o, cNameCode)) {
                hVar.f5427a = -1;
                return null;
            }
            String u3 = e.u(str2, cNameCode);
            if ((i5 & 4) == 0 || M(a5, str, u3)) {
                return u3;
            }
            hVar.f5427a = -1;
            return null;
        }
    }

    public final boolean K() {
        return this.f4596b == 0;
    }

    public final boolean M(ContentResolver contentResolver, String str, String str2) {
        Uri uri = this.f4597c;
        Cursor B = i0.B(contentResolver, uri, str2);
        if (B != null) {
            long cNameIv = cNameIv(this.f4596b, str);
            long cNameIv2 = cNameIv(this.f4596b, str);
            boolean z4 = true;
            while (true) {
                if (!B.moveToNext() || !z4) {
                    break;
                }
                String string = B.getString(1);
                String cNameCode = cNameCode(this.f4596b, cNameCode(this.f4596b, string, cNameIv, false), cNameIv2, true);
                boolean z5 = cNameCode != null && i0.Q(contentResolver, uri, str2, string, cNameCode);
                if (!z5) {
                    z4 = z5;
                    break;
                }
                z4 = "vnd.android.document/directory".equals(B.getString(2)) ? M(contentResolver, e.u(str, string), e.u(str2, cNameCode)) : z5;
            }
            B.close();
            return z4;
        }
        return true;
    }

    @Override // w4.i
    public final String c(String str) {
        if (K()) {
            return null;
        }
        return (this.f4599e & 65536) == 65536 ? str : cPathCode(this.f4596b, str, true);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        long j5 = this.f4596b;
        if (j5 != 0) {
            cFsClose(j5);
            this.f4596b = 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0057 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0058  */
    @Override // w4.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final ru.zdevs.zugate.jni.IFS$FFile d(java.lang.String r23) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            android.content.ContentResolver r2 = ru.zdevs.zugate.ZApp.a()
            boolean r3 = r22.K()
            r8 = 0
            if (r3 != 0) goto Lbb
            if (r2 != 0) goto L13
            goto Lbb
        L13:
            android.net.Uri r3 = r0.f4597c
            r9 = 0
            java.lang.String r4 = "ru.zdevs.zugate.usbgate"
            java.lang.String r5 = r3.getAuthority()     // Catch: java.lang.Exception -> L54
            boolean r4 = r4.equals(r5)     // Catch: java.lang.Exception -> L54
            java.lang.String[] r5 = com.google.android.gms.internal.play_billing.i0.f1891h
            if (r4 == 0) goto L39
            ru.zdevs.zugate.USBGateProvider r2 = ru.zdevs.zugate.USBGateProvider.f4563k     // Catch: java.lang.Exception -> L54
            if (r2 == 0) goto L31
            java.lang.String r3 = com.google.android.gms.internal.play_billing.i0.z(r3, r1)     // Catch: java.lang.Exception -> L54
            android.database.Cursor r2 = r2.queryDocument(r3, r5)     // Catch: java.lang.Exception -> L54
            goto L48
        L31:
            java.lang.Exception r2 = new java.lang.Exception     // Catch: java.lang.Exception -> L54
            java.lang.String r3 = "USBGateProvider not loaded!"
            r2.<init>(r3)     // Catch: java.lang.Exception -> L54
            throw r2     // Catch: java.lang.Exception -> L54
        L39:
            android.net.Uri r3 = com.google.android.gms.internal.play_billing.i0.F(r3, r1, r9)     // Catch: java.lang.Exception -> L54
            r6 = 0
            r7 = 0
            r10 = 0
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r10
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> L54
        L48:
            if (r2 != 0) goto L4b
            goto L54
        L4b:
            boolean r3 = r2.moveToFirst()     // Catch: java.lang.Exception -> L54
            if (r3 != 0) goto L55
            r2.close()     // Catch: java.lang.Exception -> L54
        L54:
            r2 = r8
        L55:
            if (r2 != 0) goto L58
            return r8
        L58:
            int r3 = r0.f4599e
            r4 = 3
            r3 = r3 & r4
            r5 = 2
            if (r3 != r5) goto L61
            r9 = 8
        L61:
            long r6 = r0.f4596b
            java.lang.String r1 = e4.e.p(r23)
            long r13 = cNameIv(r6, r1)
            r1 = 1
            java.lang.String r17 = r2.getString(r1)
            long r10 = r0.f4596b
            r15 = 0
            r12 = r17
            java.lang.String r16 = cNameCode(r10, r12, r13, r15)
            ru.zdevs.zugate.jni.IFS$FFile r1 = new ru.zdevs.zugate.jni.IFS$FFile
            long r3 = r2.getLong(r4)
            long r6 = (long) r9
            long r3 = r3 - r6
            r6 = 0
            int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r8 >= 0) goto L8a
            r18 = r6
            goto L9e
        L8a:
            int r6 = r0.f4601g
            if (r6 != 0) goto L8f
            goto L9c
        L8f:
            int r7 = r0.f4600f
            int r7 = r7 - r6
            long r7 = (long) r7
            long r9 = r3 + r7
            r11 = 1
            long r9 = r9 - r11
            long r9 = r9 / r7
            long r6 = (long) r6
            long r9 = r9 * r6
            long r3 = r3 - r9
        L9c:
            r18 = r3
        L9e:
            r3 = 4
            long r3 = r2.getLong(r3)
            r6 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 / r6
            int r3 = (int) r3
            java.lang.String r4 = r2.getString(r5)
            java.lang.String r5 = "vnd.android.document/directory"
            boolean r21 = r5.equals(r4)
            r15 = r1
            r20 = r3
            r15.<init>(r16, r17, r18, r20, r21)
            r2.close()
            return r1
        Lbb:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.zdevs.zugate.jni.EncFS.d(java.lang.String):ru.zdevs.zugate.jni.IFS$FFile");
    }

    @Override // w4.i
    public final String f() {
        return "EncFS";
    }

    public final void finalize() {
        if (K()) {
            return;
        }
        close();
    }

    @Override // w4.i
    public final int i(String str) {
        boolean z4;
        ContentResolver a5 = ZApp.a();
        if (K() || a5 == null || C()) {
            return -1;
        }
        Uri uri = this.f4597c;
        try {
            if ("ru.zdevs.zugate.usbgate".equals(uri.getAuthority())) {
                USBGateProvider uSBGateProvider = USBGateProvider.f4563k;
                if (uSBGateProvider == null) {
                    throw new Exception("USBGateProvider not loaded!");
                }
                uSBGateProvider.deleteDocument(i0.z(uri, str));
                z4 = true;
            } else {
                z4 = DocumentsContract.deleteDocument(a5, i0.F(uri, str, false));
            }
        } catch (Exception unused) {
            z4 = false;
        }
        return z4 ? 0 : -1;
    }

    @Override // w4.i
    public final long k(long j5, int i5) {
        return -1L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x007d, code lost:
        if (android.provider.DocumentsContract.moveDocument(r0, com.google.android.gms.internal.play_billing.i0.F(r3, r5, false), com.google.android.gms.internal.play_billing.i0.F(r3, r10, false), com.google.android.gms.internal.play_billing.i0.F(r3, r11, false)) != null) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0082  */
    @Override // w4.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String n(java.lang.String r10, java.lang.String r11, w4.h r12) {
        /*
            r9 = this;
            android.content.ContentResolver r0 = ru.zdevs.zugate.ZApp.a()
            boolean r1 = r9.K()
            r2 = 0
            if (r1 != 0) goto L8b
            if (r0 != 0) goto Lf
            goto L8b
        Lf:
            boolean r1 = r9.C()
            if (r1 == 0) goto L1b
            int r10 = android.system.OsConstants.EROFS
            int r10 = -r10
            r12.f5427a = r10
            return r2
        L1b:
            int r1 = r9.f4599e
            r3 = 8
            r1 = r1 & r3
            if (r1 != r3) goto L28
            int r10 = android.system.OsConstants.ENOTSUP
            int r10 = -r10
            r12.f5427a = r10
            return r2
        L28:
            java.lang.String r5 = e4.e.o(r10)
            long r3 = r9.f4596b
            long r6 = cNameIv(r3, r11)
            long r3 = r9.f4596b
            r8 = 0
            java.lang.String r1 = cNameCode(r3, r5, r6, r8)
            if (r1 == 0) goto L87
            android.net.Uri r3 = r9.f4597c
            r4 = 0
            java.lang.String r5 = e4.e.u(r10, r1)     // Catch: java.lang.Exception -> L80
            java.lang.String r6 = "ru.zdevs.zugate.usbgate"
            java.lang.String r7 = r3.getAuthority()     // Catch: java.lang.Exception -> L80
            boolean r6 = r6.equals(r7)     // Catch: java.lang.Exception -> L80
            if (r6 == 0) goto L6d
            ru.zdevs.zugate.USBGateProvider r0 = ru.zdevs.zugate.USBGateProvider.f4563k     // Catch: java.lang.Exception -> L80
            if (r0 == 0) goto L65
            java.lang.String r5 = com.google.android.gms.internal.play_billing.i0.z(r3, r5)     // Catch: java.lang.Exception -> L80
            java.lang.String r10 = com.google.android.gms.internal.play_billing.i0.z(r3, r10)     // Catch: java.lang.Exception -> L80
            java.lang.String r3 = com.google.android.gms.internal.play_billing.i0.z(r3, r11)     // Catch: java.lang.Exception -> L80
            java.lang.String r10 = r0.moveDocument(r5, r10, r3)     // Catch: java.lang.Exception -> L80
            if (r10 == 0) goto L80
            goto L7f
        L65:
            java.lang.Exception r10 = new java.lang.Exception     // Catch: java.lang.Exception -> L80
            java.lang.String r0 = "USBGateProvider not loaded!"
            r10.<init>(r0)     // Catch: java.lang.Exception -> L80
            throw r10     // Catch: java.lang.Exception -> L80
        L6d:
            android.net.Uri r5 = com.google.android.gms.internal.play_billing.i0.F(r3, r5, r4)     // Catch: java.lang.Exception -> L80
            android.net.Uri r10 = com.google.android.gms.internal.play_billing.i0.F(r3, r10, r4)     // Catch: java.lang.Exception -> L80
            android.net.Uri r3 = com.google.android.gms.internal.play_billing.i0.F(r3, r11, r4)     // Catch: java.lang.Exception -> L80
            android.net.Uri r10 = android.provider.DocumentsContract.moveDocument(r0, r5, r10, r3)     // Catch: java.lang.Exception -> L80
            if (r10 == 0) goto L80
        L7f:
            r4 = 1
        L80:
            if (r4 == 0) goto L87
            java.lang.String r10 = e4.e.u(r11, r1)
            return r10
        L87:
            r10 = -1
            r12.f5427a = r10
            return r2
        L8b:
            int r10 = android.system.OsConstants.EINVAL
            int r10 = -r10
            r12.f5427a = r10
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.zdevs.zugate.jni.EncFS.n(java.lang.String, java.lang.String, w4.h):java.lang.String");
    }

    @Override // w4.i
    public final String p(String str, String str2) {
        ContentResolver a5 = ZApp.a();
        if (K() || a5 == null || C()) {
            return null;
        }
        String cNameCode = cNameCode(this.f4596b, str2, cNameIv(this.f4596b, str), true);
        if (cNameCode == null || !i0.o(a5, this.f4597c, str, cNameCode, false)) {
            return null;
        }
        return e.u(str, cNameCode);
    }

    @Override // w4.i
    public final ArrayList t(String str) {
        long j5;
        ContentResolver a5 = ZApp.a();
        if (K() || a5 == null) {
            return new ArrayList(0);
        }
        Cursor B = i0.B(a5, this.f4597c, str);
        if (B == null) {
            return new ArrayList(0);
        }
        long cNameIv = cNameIv(this.f4596b, str);
        ArrayList arrayList = new ArrayList(B.getCount());
        int i5 = (this.f4599e & 3) == 2 ? 8 : 0;
        while (B.moveToNext()) {
            String string = B.getString(1);
            if (!".encfs6.xml".equals(string)) {
                String cNameCode = cNameCode(this.f4596b, string, cNameIv, false);
                String str2 = cNameCode == null ? string : cNameCode;
                long j6 = B.getLong(3) - i5;
                if (j6 < 0) {
                    j5 = 0;
                } else {
                    int i6 = this.f4601g;
                    if (i6 != 0) {
                        long j7 = this.f4600f - i6;
                        j6 -= (((j6 + j7) - 1) / j7) * i6;
                    }
                    j5 = j6;
                }
                arrayList.add(new IFS$FFile(str2, string, j5, (int) (B.getLong(4) / 1000), "vnd.android.document/directory".equals(B.getString(2)) ? 1 : 0));
            }
        }
        B.close();
        return arrayList;
    }

    @Override // w4.i
    public final String v(String str, String str2, h hVar) {
        ContentResolver a5 = ZApp.a();
        if (K() || a5 == null) {
            hVar.f5427a = -OsConstants.EINVAL;
            return null;
        } else if (C()) {
            hVar.f5427a = -OsConstants.EROFS;
            return null;
        } else {
            String cNameCode = cNameCode(this.f4596b, str2, cNameIv(this.f4596b, str), true);
            if (cNameCode == null || !i0.o(a5, this.f4597c, str, cNameCode, true)) {
                hVar.f5427a = -1;
                return null;
            }
            return e.u(str, cNameCode);
        }
    }

    @Override // w4.i
    public final g x(int i5, String str) {
        ParcelFileDescriptor parcelFileDescriptor;
        ContentResolver a5 = ZApp.a();
        if (K() || a5 == null) {
            return null;
        }
        int i6 = OsConstants.O_ACCMODE & i5;
        int i7 = OsConstants.O_WRONLY;
        if (i6 == i7) {
            i5 = (i5 & (~i7)) | OsConstants.O_RDWR;
        }
        Uri uri = this.f4597c;
        try {
            if ("ru.zdevs.zugate.usbgate".equals(uri.getAuthority())) {
                USBGateProvider uSBGateProvider = USBGateProvider.f4563k;
                if (uSBGateProvider == null) {
                    throw new Exception("USBGateProvider not loaded!");
                }
                parcelFileDescriptor = uSBGateProvider.openDocument(i0.z(uri, str), j.L(i5), null);
            } else {
                parcelFileDescriptor = a5.openFileDescriptor(i0.F(uri, str, false), j.L(i5));
            }
        } catch (Exception unused) {
            parcelFileDescriptor = null;
        }
        if (parcelFileDescriptor == null) {
            return null;
        }
        long cOpen = cOpen(this.f4596b, parcelFileDescriptor.detachFd(), i5);
        if (cOpen == 0) {
            return null;
        }
        return new w4.d(cOpen, this);
    }
}

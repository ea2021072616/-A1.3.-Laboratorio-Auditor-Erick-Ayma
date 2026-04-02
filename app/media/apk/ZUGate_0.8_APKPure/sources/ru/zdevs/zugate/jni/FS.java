package ru.zdevs.zugate.jni;

import android.system.OsConstants;
import e4.e;
import java.util.ArrayList;
import w4.g;
import w4.h;
import w4.i;
/* loaded from: classes.dex */
public class FS implements i {

    /* renamed from: b  reason: collision with root package name */
    public a f4602b;

    /* renamed from: c  reason: collision with root package name */
    public long f4603c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4604d;

    static {
        System.loadLibrary("fs-1.1");
    }

    public FS(long j5, a aVar, int i5) {
        this.f4603c = j5;
        this.f4602b = aVar;
        aVar.f4618d = true;
        this.f4604d = i5;
    }

    public static String K(int i5) {
        return i5 != 256 ? i5 != 512 ? i5 != 1024 ? i5 != 2048 ? i5 != 4096 ? "-" : "ISO / UDF" : "EXT2/3/4" : "NTFS" : "EXFAT" : "FAT";
    }

    public static FS M(d dVar, int i5) {
        int i6;
        if (dVar instanceof a) {
            a aVar = (a) dVar;
            long cFsOpen = cFsOpen(aVar.f4616b, i5);
            if (cFsOpen != 0) {
                if ((i5 & 1) == 0) {
                    IFS$FStatFs cStatFs = cStatFs(cFsOpen);
                    i6 = cStatFs != null ? cStatFs.f4613d : 0;
                } else {
                    i6 = 2;
                }
                return new FS(cFsOpen, aVar, i6);
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native int cClose(long j5, long j6);

    private static native int cFsClose(long j5);

    private static native long cFsOpen(long j5, int i5);

    private static native long cIoctl(long j5, int i5, long j6);

    private static native int cList(long j5, String str, ArrayList<IFS$FFile> arrayList);

    private static native int cMkDir(long j5, String str);

    private static native long[] cOpen(long j5, String str, int i5);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int cRead(long j5, byte[] bArr, int i5);

    private static native int cRemove(long j5, String str);

    private static native int cRename(long j5, String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long cSeek(long j5, long j6, int i5);

    private static native IFS$FFile cStat(long j5, String str);

    private static native IFS$FStatFs cStatFs(long j5);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int cWrite(long j5, byte[] bArr, int i5);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int cWriteFrom(long j5, int i5);

    @Override // w4.i
    public final IFS$FStatFs B() {
        if (L()) {
            return null;
        }
        return cStatFs(this.f4603c);
    }

    @Override // w4.i
    public final boolean C() {
        return (this.f4604d & 2) != 0;
    }

    @Override // w4.i
    public final String D(String str, String str2, String str3, h hVar) {
        if (L()) {
            hVar.f5427a = -OsConstants.EINVAL;
            return null;
        }
        String u3 = e.u(str2, str3);
        int cRename = cRename(this.f4603c, str, u3);
        hVar.f5427a = cRename;
        if (cRename == 0) {
            return u3;
        }
        return null;
    }

    public final boolean L() {
        return this.f4603c == 0;
    }

    @Override // w4.i
    public final String c(String str) {
        return str;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        long j5 = this.f4603c;
        if (j5 != 0) {
            this.f4603c = 0L;
            cFsClose(j5);
        }
        a aVar = this.f4602b;
        if (aVar != null) {
            aVar.close();
            this.f4602b = null;
        }
    }

    @Override // w4.i
    public final IFS$FFile d(String str) {
        IFS$FFile cStat;
        if (L() || (cStat = cStat(this.f4603c, str)) == null) {
            return null;
        }
        cStat.f4605a = e.o(str);
        if (cStat.f4606b.isEmpty()) {
            cStat.f4606b = cStat.f4605a;
        }
        return cStat;
    }

    @Override // w4.i
    public final String f() {
        return K((int) k(0L, 1));
    }

    public final void finalize() {
        if (L()) {
            return;
        }
        close();
    }

    @Override // w4.i
    public final int i(String str) {
        return L() ? -OsConstants.EINVAL : cRemove(this.f4603c, str);
    }

    @Override // w4.i
    public final long k(long j5, int i5) {
        if (L()) {
            return -1L;
        }
        return cIoctl(this.f4603c, i5, j5);
    }

    @Override // w4.i
    public final String n(String str, String str2, h hVar) {
        if (L()) {
            hVar.f5427a = -OsConstants.EINVAL;
            return null;
        }
        String u3 = e.u(str2, e.o(str));
        int cRename = cRename(this.f4603c, str, u3);
        hVar.f5427a = cRename;
        if (cRename == 0) {
            return u3;
        }
        return null;
    }

    @Override // w4.i
    public final String p(String str, String str2) {
        String u3 = e.u(str, str2);
        g x5 = x(OsConstants.O_CREAT | OsConstants.O_RDWR, u3);
        if (x5 != null) {
            ((w4.e) x5).close();
            return u3;
        }
        return null;
    }

    @Override // w4.i
    public final ArrayList t(String str) {
        ArrayList arrayList = new ArrayList();
        if (L()) {
            return arrayList;
        }
        cList(this.f4603c, str, arrayList);
        return arrayList;
    }

    @Override // w4.i
    public final String v(String str, String str2, h hVar) {
        if (L()) {
            hVar.f5427a = -OsConstants.EINVAL;
            return null;
        }
        String u3 = e.u(str, str2);
        int cMkDir = cMkDir(this.f4603c, u3);
        hVar.f5427a = cMkDir;
        if (cMkDir == 0) {
            return u3;
        }
        return null;
    }

    @Override // w4.i
    public final g x(int i5, String str) {
        long[] cOpen;
        if (!L() && (cOpen = cOpen(this.f4603c, str, i5)) != null) {
            long j5 = cOpen[0];
            if (j5 != 0) {
                return new w4.e(j5, cOpen[1], this);
            }
        }
        return null;
    }
}

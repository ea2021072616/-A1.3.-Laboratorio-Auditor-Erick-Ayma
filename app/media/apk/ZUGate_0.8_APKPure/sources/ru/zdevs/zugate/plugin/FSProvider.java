package ru.zdevs.zugate.plugin;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.system.OsConstants;
import androidx.appcompat.widget.b0;
import b4.j;
import com.github.appintro.R;
import e4.e;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import ru.zdevs.zugate.USBGateService;
import ru.zdevs.zugate.jni.IFS$FFile;
import ru.zdevs.zugate.jni.IFS$FStatFs;
import t4.r;
import w4.g;
import w4.h;
import w4.i;
/* loaded from: classes.dex */
public final class FSProvider extends ContentProvider {
    public static r a(String str) {
        USBGateService uSBGateService = USBGateService.f4566k;
        if (uSBGateService == null) {
            return null;
        }
        return uSBGateService.i(Long.parseLong(str.substring(0, 8), 16), e.t(str));
    }

    @Override // android.content.ContentProvider
    public final Bundle call(String str, String str2, Bundle bundle) {
        String sb;
        int i5;
        String callingPackage = getCallingPackage();
        int i6 = 0;
        if (("ru.zdevs.zarchiver.pro".equals(callingPackage) || "ru.zdevs.zarchiver".equals(callingPackage)) ? false : true) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        Uri uri = (Uri) bundle.getParcelable("_uri");
        Uri uri2 = (Uri) bundle.getParcelable("_uri_to");
        if ("flush".equals(str)) {
            bundle2.putInt("_ret", 0);
            return bundle2;
        }
        r a5 = a(bundle.getString("_account"));
        int i7 = -1;
        if (a5 == null) {
            bundle2.putInt("_ret", -1);
            return bundle2;
        }
        boolean equals = "move".equals(str);
        i iVar = a5.f5089e;
        if (equals) {
            String c5 = iVar.c(uri.getPath());
            String c6 = iVar.c(e.p(uri2.getPath()));
            if (c5 == null || c6 == null) {
                a5.f5093i = -1;
                i6 = i7;
            } else {
                h hVar = new h();
                iVar.n(c5, c6, hVar);
                i5 = hVar.f5427a;
                a5.f5093i = i5;
                i6 = i5;
            }
        } else {
            if ("copy".equals(str)) {
                a5.f5093i = 0;
            } else if ("remove".equals(str)) {
                if (iVar.c(uri.getPath()) != null) {
                    i5 = iVar.i(uri.getPath());
                    a5.f5093i = i5;
                    i6 = i5;
                } else {
                    a5.f5093i = -1;
                }
            } else if ("rename".equals(str)) {
                String path = uri.getPath();
                String c7 = iVar.c(e.p(path));
                String c8 = iVar.c(path);
                if (c8 == null || c7 == null) {
                    a5.f5093i = -1;
                } else {
                    h hVar2 = new h();
                    iVar.D(c8, c7, bundle.getString("_name"), hVar2);
                    i5 = hVar2.f5427a;
                    a5.f5093i = i5;
                    i6 = i5;
                }
            } else if ("mkdir".equals(str)) {
                String c9 = iVar.c(uri.getPath());
                if (c9 != null) {
                    h hVar3 = new h();
                    iVar.v(c9, bundle.getString("_name"), hVar3);
                    i5 = hVar3.f5427a;
                    a5.f5093i = i5;
                    i6 = i5;
                } else {
                    a5.f5093i = -1;
                }
            } else if ("disk".equals(str)) {
                IFS$FStatFs B = iVar.B();
                if (B != null) {
                    long j5 = B.f4611b;
                    long j6 = B.f4612c;
                    bundle2.putLong("_used", j5 - j6);
                    bundle2.putLong("_free", j6);
                    bundle2.putString("_fs_type", iVar.f());
                    i7 = 0;
                }
                a5.f5093i = 0;
            } else if ("error".equals(str) && a5.f5093i != 0) {
                Context context = getContext();
                int i8 = a5.f5093i;
                if (i8 == (-OsConstants.ENOSPC)) {
                    sb = context.getString(R.string.ENOSPC);
                } else if (i8 == (-OsConstants.ENOENT)) {
                    sb = context.getString(R.string.ENOENT);
                } else if (i8 == (-OsConstants.EEXIST)) {
                    sb = context.getString(R.string.EEXIST);
                } else if (i8 == (-OsConstants.EROFS)) {
                    sb = context.getString(R.string.EROFS);
                } else if (i8 == (-OsConstants.ENOTSUP)) {
                    sb = context.getString(R.string.ENOTSUP);
                } else {
                    int i9 = -i8;
                    String errnoName = OsConstants.errnoName(i9);
                    StringBuilder sb2 = new StringBuilder("Error ");
                    if (errnoName == null) {
                        errnoName = b0.f("", i9);
                    }
                    sb2.append(errnoName);
                    sb = sb2.toString();
                }
                bundle2.putString("_text", sb);
            }
            i6 = i7;
        }
        bundle2.putInt("_ret", i6);
        return bundle2;
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public final ParcelFileDescriptor openFile(Uri uri, String str) {
        if (str.endsWith("t")) {
            return null;
        }
        r a5 = a(uri.getFragment());
        if (a5 != null) {
            boolean z4 = str.indexOf(119) != -1;
            i iVar = a5.f5089e;
            if (z4 && iVar.C()) {
                throw new FileNotFoundException("FS is read only");
            }
            int c02 = j.c0(str);
            String c5 = iVar.c(uri.getPath());
            if (c5 == null) {
                throw new FileNotFoundException("File to encode path: " + uri.getPath());
            }
            g x5 = iVar.x(j.K(c02), c5);
            if (x5 != null) {
                try {
                    return e.s(getContext(), a5, x5, c02, false);
                } catch (IOException e5) {
                    throw new FileNotFoundException(e5.getMessage());
                }
            }
            throw new FileNotFoundException("File not found: " + uri.getPath());
        }
        throw new FileNotFoundException("Storage is not mounted");
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        String c5;
        IFS$FFile d5;
        String callingPackage = getCallingPackage();
        if ((("ru.zdevs.zarchiver.pro".equals(callingPackage) || "ru.zdevs.zarchiver".equals(callingPackage)) ? null : 1) != null) {
            return null;
        }
        if ("get=accounts".equals(str)) {
            USBGateService uSBGateService = USBGateService.f4566k;
            if (uSBGateService == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(0);
            uSBGateService.d(arrayList);
            MatrixCursor matrixCursor = new MatrixCursor(strArr, arrayList.size());
            int q5 = j.q("_name", strArr);
            int q6 = j.q("_id", strArr);
            int q7 = j.q("_flags", strArr);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                r rVar = (r) it.next();
                long j5 = rVar.f5086b;
                int i5 = rVar.f5087c;
                String v5 = e.v(j5, i5);
                Object[] objArr = new Object[strArr.length];
                if (q5 != -1) {
                    objArr[q5] = rVar.f5085a;
                }
                if (q6 != -1) {
                    objArr[q6] = v5;
                }
                if (q7 != -1) {
                    objArr[q7] = Integer.valueOf((rVar.f5089e.C() ? 256 : 0) | (i5 < 0 ? 2 : 1) | 512);
                }
                matrixCursor.addRow(objArr);
            }
            return matrixCursor;
        }
        r a5 = a(uri.getFragment());
        if (a5 == null) {
            return null;
        }
        String path = uri.getPath();
        int q8 = j.q("_name", strArr);
        int q9 = j.q("_size", strArr);
        int q10 = j.q("_dir", strArr);
        int q11 = j.q("_last_mod", strArr);
        boolean equals = "get=file".equals(str);
        i iVar = a5.f5089e;
        if (equals) {
            if ("/".equals(path)) {
                d5 = new IFS$FFile(null, null, 0L, 0, 1);
            } else {
                String c6 = iVar.c(path);
                if (c6 == null) {
                    return null;
                }
                d5 = iVar.d(c6);
            }
            if (d5 != null) {
                MatrixCursor matrixCursor2 = new MatrixCursor(strArr, 1);
                Object[] objArr2 = new Object[strArr.length];
                if (q8 != -1) {
                    objArr2[q8] = d5.f4605a;
                }
                if (q9 != -1) {
                    objArr2[q9] = Long.valueOf(d5.f4607c);
                }
                if (q11 != -1) {
                    objArr2[q11] = Long.valueOf(d5.f4608d * 1000);
                }
                if (q10 != -1) {
                    objArr2[q10] = Integer.valueOf(d5.a() ? 1 : 0);
                }
                matrixCursor2.addRow(objArr2);
                return matrixCursor2;
            }
            return null;
        } else if ("get=search".equals(str) || !"get=list".equals(str) || (c5 = iVar.c(path)) == null) {
            return null;
        } else {
            ArrayList t5 = iVar.t(c5);
            MatrixCursor matrixCursor3 = new MatrixCursor(strArr, t5.size());
            Iterator it2 = t5.iterator();
            while (it2.hasNext()) {
                IFS$FFile iFS$FFile = (IFS$FFile) it2.next();
                Object[] objArr3 = new Object[strArr.length];
                if (q8 != -1) {
                    objArr3[q8] = iFS$FFile.f4605a;
                }
                if (q9 != -1) {
                    objArr3[q9] = Long.valueOf(iFS$FFile.f4607c);
                }
                if (q11 != -1) {
                    objArr3[q11] = Long.valueOf(iFS$FFile.f4608d * 1000);
                }
                if (q10 != -1) {
                    objArr3[q10] = Integer.valueOf(iFS$FFile.a() ? 1 : 0);
                }
                matrixCursor3.addRow(objArr3);
            }
            return matrixCursor3;
        }
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}

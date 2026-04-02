package com.flurry.sdk;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import java.io.File;
import java.io.FileOutputStream;
/* loaded from: classes.dex */
public final class lx {

    /* renamed from: a  reason: collision with root package name */
    private static String f2185a = lx.class.getSimpleName();

    public static File a() {
        File file = null;
        Context context = jy.a().f2022a;
        if ("mounted".equals(Environment.getExternalStorageState()) && (Build.VERSION.SDK_INT >= 19 || context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)) {
            file = context.getExternalFilesDir(null);
        }
        if (file == null) {
            return context.getFilesDir();
        }
        return file;
    }

    public static File b() {
        Context context = jy.a().f2022a;
        File file = null;
        if ("mounted".equals(Environment.getExternalStorageState()) && (Build.VERSION.SDK_INT >= 19 || context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)) {
            file = context.getExternalCacheDir();
        }
        if (file == null) {
            return context.getCacheDir();
        }
        return file;
    }

    public static boolean a(File file) {
        if (file == null || file.getAbsoluteFile() == null) {
            return false;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            return true;
        }
        if (parentFile.mkdirs() || parentFile.isDirectory()) {
            return true;
        }
        km.a(6, f2185a, "Unable to create persistent dir: " + parentFile);
        return false;
    }

    public static boolean b(File file) {
        if (file != null && file.isDirectory()) {
            for (String str : file.list()) {
                if (!b(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String c(java.io.File r7) {
        /*
            r4 = 4
            r0 = 0
            if (r7 == 0) goto La
            boolean r1 = r7.exists()
            if (r1 != 0) goto L12
        La:
            java.lang.String r1 = com.flurry.sdk.lx.f2185a
            java.lang.String r2 = "Persistent file doesn't exist."
            com.flurry.sdk.km.a(r4, r1, r2)
        L11:
            return r0
        L12:
            java.lang.String r1 = com.flurry.sdk.lx.f2185a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Loading persistent data: "
            r2.<init>(r3)
            java.lang.String r3 = r7.getAbsolutePath()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.flurry.sdk.km.a(r4, r1, r2)
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L69
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L69
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L48
            r1.<init>()     // Catch: java.lang.Throwable -> L48
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L48
        L38:
            int r4 = r2.read(r3)     // Catch: java.lang.Throwable -> L48
            if (r4 <= 0) goto L5c
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Throwable -> L48
            r6 = 0
            r5.<init>(r3, r6, r4)     // Catch: java.lang.Throwable -> L48
            r1.append(r5)     // Catch: java.lang.Throwable -> L48
            goto L38
        L48:
            r1 = move-exception
        L49:
            r3 = 6
            java.lang.String r4 = com.flurry.sdk.lx.f2185a     // Catch: java.lang.Throwable -> L67
            java.lang.String r5 = "Error when loading persistent file"
            com.flurry.sdk.km.a(r3, r4, r5, r1)     // Catch: java.lang.Throwable -> L67
            com.flurry.sdk.ly.a(r2)
            r1 = r0
        L55:
            if (r1 == 0) goto L11
            java.lang.String r0 = r1.toString()
            goto L11
        L5c:
            com.flurry.sdk.ly.a(r2)
            goto L55
        L60:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L63:
            com.flurry.sdk.ly.a(r2)
            throw r0
        L67:
            r0 = move-exception
            goto L63
        L69:
            r1 = move-exception
            r2 = r0
            goto L49
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.lx.c(java.io.File):java.lang.String");
    }

    @Deprecated
    public static void a(File file, String str) {
        FileOutputStream fileOutputStream;
        if (file == null) {
            km.a(4, f2185a, "No persistent file specified.");
        } else if (str == null) {
            km.a(4, f2185a, "No data specified; deleting persistent file: " + file.getAbsolutePath());
            file.delete();
        } else {
            km.a(4, f2185a, "Writing persistent data: " + file.getAbsolutePath());
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
            try {
                fileOutputStream.write(str.getBytes());
            } catch (Throwable th2) {
                th = th2;
                try {
                    km.a(6, f2185a, "Error writing persistent file", th);
                } finally {
                    ly.a(fileOutputStream);
                }
            }
        }
    }
}

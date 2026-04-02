package com.crashlytics.android.beta;

import android.content.Context;
import android.content.pm.PackageManager;
import b.a.a.a.a.a.d;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes.dex */
public class DeviceTokenLoader implements d<String> {
    private static final String BETA_APP_PACKAGE_NAME = "io.crash.air";
    private static final String DIRFACTOR_DEVICE_TOKEN_PREFIX = "assets/com.crashlytics.android.beta/dirfactor-device-token=";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // b.a.a.a.a.a.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String load(android.content.Context r10) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 219
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.beta.DeviceTokenLoader.load(android.content.Context):java.lang.String");
    }

    ZipInputStream getZipInputStreamOfApkFrom(Context context, String str) throws PackageManager.NameNotFoundException, FileNotFoundException {
        return new ZipInputStream(new FileInputStream(context.getPackageManager().getApplicationInfo(str, 0).sourceDir));
    }

    String determineDeviceToken(ZipInputStream zipInputStream) throws IOException {
        ZipEntry nextEntry = zipInputStream.getNextEntry();
        if (nextEntry != null) {
            String name = nextEntry.getName();
            if (name.startsWith(DIRFACTOR_DEVICE_TOKEN_PREFIX)) {
                return name.substring(DIRFACTOR_DEVICE_TOKEN_PREFIX.length(), name.length() - 1);
            }
        }
        return "";
    }
}

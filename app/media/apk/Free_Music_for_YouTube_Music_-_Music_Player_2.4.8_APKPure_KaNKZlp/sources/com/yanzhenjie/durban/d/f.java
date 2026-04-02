package com.yanzhenjie.durban.d;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
/* compiled from: FileUtils.java */
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static Random f5153a = new Random();

    public static void a(String str) throws com.yanzhenjie.durban.b.a {
        File file = new File(str);
        try {
            if (file.isFile()) {
                file.delete();
            }
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e) {
            throw new com.yanzhenjie.durban.b.a("Directory creation failed.");
        }
    }

    public static String a(Bitmap.CompressFormat compressFormat) {
        return new SimpleDateFormat("yyyyMMdd_HHmmSSS", Locale.getDefault()).format(new Date(System.currentTimeMillis())) + f5153a.nextInt(9000) + "." + compressFormat;
    }

    public static void a(@NonNull String str, @NonNull String str2) throws com.yanzhenjie.durban.b.a {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            byte[] bArr = new byte[2048];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    return;
                }
            }
        } catch (IOException e) {
            throw new com.yanzhenjie.durban.b.a(e);
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }
}

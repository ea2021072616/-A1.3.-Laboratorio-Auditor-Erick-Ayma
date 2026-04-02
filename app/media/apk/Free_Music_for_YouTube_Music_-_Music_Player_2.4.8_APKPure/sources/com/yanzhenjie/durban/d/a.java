package com.yanzhenjie.durban.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.os.Build;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.WindowManager;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.FileInputStream;
import java.io.IOException;
/* compiled from: BitmapLoadUtils.java */
/* loaded from: classes2.dex */
public class a {
    public static Bitmap a(@NonNull Bitmap bitmap, @NonNull Matrix matrix) {
        try {
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError e) {
            return bitmap;
        }
    }

    public static int a(@NonNull BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            while (true) {
                if (i3 / i5 <= i2 && i4 / i5 <= i) {
                    break;
                }
                i5 *= 2;
            }
        }
        return i5;
    }

    public static int a(@NonNull String str) {
        int i;
        IOException e;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            i = new g(fileInputStream).a();
        } catch (IOException e2) {
            i = 0;
            e = e2;
        }
        try {
            fileInputStream.close();
        } catch (IOException e3) {
            e = e3;
            ThrowableExtension.printStackTrace(e);
            return i;
        }
        return i;
    }

    public static int a(int i) {
        switch (i) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public static int b(int i) {
        switch (i) {
            case 2:
            case 4:
            case 5:
            case 7:
                return -1;
            case 3:
            case 6:
            default:
                return 1;
        }
    }

    public static int a(@NonNull Context context) {
        int width;
        int height;
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 13) {
            defaultDisplay.getSize(point);
            width = point.x;
            height = point.y;
        } else {
            width = defaultDisplay.getWidth();
            height = defaultDisplay.getHeight();
        }
        int sqrt = (int) Math.sqrt(Math.pow(height, 2.0d) + Math.pow(width, 2.0d));
        int a2 = d.a();
        if (a2 > 0) {
            return Math.min(sqrt, a2);
        }
        return sqrt;
    }
}

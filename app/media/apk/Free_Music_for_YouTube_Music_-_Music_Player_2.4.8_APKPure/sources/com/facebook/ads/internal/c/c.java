package com.facebook.ads.internal.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.util.Log;
import com.facebook.ads.internal.i.a.p;
import com.facebook.ads.internal.util.w;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1267a = c.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static c f1268b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f1269c;

    private c(Context context) {
        this.f1269c = context;
    }

    public static c a(Context context) {
        if (f1268b == null) {
            Context applicationContext = context.getApplicationContext();
            synchronized (applicationContext) {
                if (f1268b == null) {
                    f1268b = new c(applicationContext);
                }
            }
        }
        return f1268b;
    }

    private static void a(@Nullable Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
        }
    }

    @Nullable
    private Bitmap b(String str) {
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(new FileInputStream(str.substring("file://".length())), null, null);
            a(str, decodeStream);
            return decodeStream;
        } catch (IOException e) {
            Log.e(f1267a, "Failed to copy local image into cache (url=" + str + ").", e);
            return null;
        }
    }

    @Nullable
    private Bitmap c(String str) {
        InputStream inputStream;
        Throwable th;
        Bitmap bitmap = null;
        if (str.startsWith("asset:///")) {
            try {
                inputStream = this.f1269c.getAssets().open(str.substring(9, str.length()));
                try {
                    bitmap = BitmapFactory.decodeStream(inputStream);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            ThrowableExtension.printStackTrace(e);
                        }
                    }
                } catch (IOException e2) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            ThrowableExtension.printStackTrace(e3);
                        }
                    }
                    return bitmap;
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e4) {
                            ThrowableExtension.printStackTrace(e4);
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                inputStream = null;
            } catch (Throwable th3) {
                inputStream = null;
                th = th3;
            }
        } else {
            byte[] d = w.a(this.f1269c).a(str, (p) null).d();
            bitmap = BitmapFactory.decodeByteArray(d, 0, d.length);
        }
        a(str, bitmap);
        return bitmap;
    }

    @Nullable
    public Bitmap a(String str) {
        File file = new File(this.f1269c.getCacheDir(), str.hashCode() + ".png");
        return !file.exists() ? str.startsWith("file://") ? b(str) : c(str) : BitmapFactory.decodeFile(file.getAbsolutePath());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15, types: [java.io.OutputStream, java.io.ByteArrayOutputStream, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.graphics.Bitmap] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x00a2 -> B:46:0x0044). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00b2 -> B:46:0x0044). Please submit an issue!!! */
    public void a(String str, Bitmap bitmap) {
        Closeable closeable;
        File file;
        FileOutputStream fileOutputStream = null;
        ?? r3 = ".png";
        File file2 = new File(this.f1269c.getCacheDir(), str.hashCode() + ".png");
        try {
            try {
                r3 = new ByteArrayOutputStream();
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, r3);
                    if (r3.size() >= 3145728) {
                        Log.d(f1267a, "Bitmap size exceeds max size for storage");
                        a((Closeable) r3);
                        a((Closeable) null);
                        r3 = r3;
                        file2 = file2;
                    } else {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                        try {
                            r3.writeTo(fileOutputStream2);
                            fileOutputStream2.flush();
                            a((Closeable) r3);
                            a(fileOutputStream2);
                            r3 = r3;
                            file2 = file2;
                        } catch (FileNotFoundException e) {
                            e = e;
                            fileOutputStream = fileOutputStream2;
                            closeable = r3;
                            file = file2;
                            try {
                                Log.e(f1267a, "Bad output destination (file=" + file.getAbsolutePath() + ").", e);
                                a(closeable);
                                a(fileOutputStream);
                            } catch (Throwable th) {
                                th = th;
                                r3 = closeable;
                                a((Closeable) r3);
                                a(fileOutputStream);
                                throw th;
                            }
                        } catch (IOException e2) {
                            e = e2;
                            fileOutputStream = fileOutputStream2;
                            String str2 = "Unable to write bitmap to file (url=" + str + ").";
                            Log.e(f1267a, str2, e);
                            a((Closeable) r3);
                            a(fileOutputStream);
                            r3 = r3;
                            file2 = str2;
                        } catch (OutOfMemoryError e3) {
                            e = e3;
                            fileOutputStream = fileOutputStream2;
                            ?? r4 = "Unable to write bitmap to output stream";
                            Log.e(f1267a, "Unable to write bitmap to output stream", e);
                            a((Closeable) r3);
                            a(fileOutputStream);
                            r3 = r3;
                            file2 = r4;
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream = fileOutputStream2;
                            a((Closeable) r3);
                            a(fileOutputStream);
                            throw th;
                        }
                    }
                } catch (FileNotFoundException e4) {
                    e = e4;
                    closeable = r3;
                    file = file2;
                } catch (IOException e5) {
                    e = e5;
                } catch (OutOfMemoryError e6) {
                    e = e6;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (FileNotFoundException e7) {
            e = e7;
            closeable = null;
            file = file2;
        } catch (IOException e8) {
            e = e8;
            r3 = 0;
        } catch (OutOfMemoryError e9) {
            e = e9;
            r3 = 0;
        } catch (Throwable th4) {
            th = th4;
            r3 = 0;
        }
    }
}

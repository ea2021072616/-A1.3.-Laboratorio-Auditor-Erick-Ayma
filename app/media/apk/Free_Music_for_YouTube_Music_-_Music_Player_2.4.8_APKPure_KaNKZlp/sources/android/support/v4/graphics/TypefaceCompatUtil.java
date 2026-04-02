package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.os.Process;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class TypefaceCompatUtil {
    private static final String CACHE_FILE_PREFIX = ".font";
    private static final String TAG = "TypefaceCompatUtil";

    private TypefaceCompatUtil() {
    }

    @Nullable
    public static File getTempFile(Context context) {
        String str = CACHE_FILE_PREFIX + Process.myPid() + "-" + Process.myTid() + "-";
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 100) {
                File file = new File(context.getCacheDir(), str + i2);
                if (!file.createNewFile()) {
                    i = i2 + 1;
                } else {
                    return file;
                }
            } else {
                return null;
            }
        }
    }

    @RequiresApi(19)
    @Nullable
    private static ByteBuffer mmap(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileChannel channel = fileInputStream.getChannel();
            MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
            if (fileInputStream != null) {
                if (0 != 0) {
                    fileInputStream.close();
                } else {
                    fileInputStream.close();
                }
            }
            return map;
        } catch (IOException e) {
            return null;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @android.support.annotation.RequiresApi(19)
    @android.support.annotation.Nullable
    public static java.nio.ByteBuffer mmap(android.content.Context r12, android.os.CancellationSignal r13, android.net.Uri r14) {
        /*
            r6 = 0
            android.content.ContentResolver r0 = r12.getContentResolver()
            java.lang.String r1 = "r"
            android.os.ParcelFileDescriptor r7 = r0.openFileDescriptor(r14, r1, r13)     // Catch: java.io.IOException -> L48
            r8 = 0
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L3a
            java.io.FileDescriptor r0 = r7.getFileDescriptor()     // Catch: java.lang.Throwable -> L3a
            r9.<init>(r0)     // Catch: java.lang.Throwable -> L3a
            r10 = 0
            java.nio.channels.FileChannel r0 = r9.getChannel()     // Catch: java.lang.Throwable -> L5b
            long r4 = r0.size()     // Catch: java.lang.Throwable -> L5b
            java.nio.channels.FileChannel$MapMode r1 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch: java.lang.Throwable -> L5b
            r2 = 0
            java.nio.MappedByteBuffer r0 = r0.map(r1, r2, r4)     // Catch: java.lang.Throwable -> L5b
            if (r9 == 0) goto L2d
            if (r6 == 0) goto L4b
            r9.close()     // Catch: java.lang.Throwable -> L35
        L2d:
            if (r7 == 0) goto L34
            if (r6 == 0) goto L57
            r7.close()     // Catch: java.lang.Throwable -> L52
        L34:
            return r0
        L35:
            r1 = move-exception
            com.google.devtools.build.android.desugar.runtime.ThrowableExtension.addSuppressed(r10, r1)     // Catch: java.lang.Throwable -> L3a
            goto L2d
        L3a:
            r0 = move-exception
            throw r0     // Catch: java.lang.Throwable -> L3c
        L3c:
            r1 = move-exception
            r11 = r1
            r1 = r0
            r0 = r11
        L40:
            if (r7 == 0) goto L47
            if (r1 == 0) goto L77
            r7.close()     // Catch: java.lang.Throwable -> L72
        L47:
            throw r0     // Catch: java.io.IOException -> L48
        L48:
            r0 = move-exception
            r0 = r6
            goto L34
        L4b:
            r9.close()     // Catch: java.lang.Throwable -> L3a
            goto L2d
        L4f:
            r0 = move-exception
            r1 = r6
            goto L40
        L52:
            r1 = move-exception
            com.google.devtools.build.android.desugar.runtime.ThrowableExtension.addSuppressed(r8, r1)     // Catch: java.io.IOException -> L48
            goto L34
        L57:
            r7.close()     // Catch: java.io.IOException -> L48
            goto L34
        L5b:
            r0 = move-exception
            throw r0     // Catch: java.lang.Throwable -> L5d
        L5d:
            r1 = move-exception
            r11 = r1
            r1 = r0
            r0 = r11
        L61:
            if (r9 == 0) goto L68
            if (r1 == 0) goto L6e
            r9.close()     // Catch: java.lang.Throwable -> L69
        L68:
            throw r0     // Catch: java.lang.Throwable -> L3a
        L69:
            r2 = move-exception
            com.google.devtools.build.android.desugar.runtime.ThrowableExtension.addSuppressed(r1, r2)     // Catch: java.lang.Throwable -> L3a
            goto L68
        L6e:
            r9.close()     // Catch: java.lang.Throwable -> L3a
            goto L68
        L72:
            r2 = move-exception
            com.google.devtools.build.android.desugar.runtime.ThrowableExtension.addSuppressed(r1, r2)     // Catch: java.io.IOException -> L48
            goto L47
        L77:
            r7.close()     // Catch: java.io.IOException -> L48
            goto L47
        L7b:
            r0 = move-exception
            r1 = r6
            goto L61
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatUtil.mmap(android.content.Context, android.os.CancellationSignal, android.net.Uri):java.nio.ByteBuffer");
    }

    @RequiresApi(19)
    @Nullable
    public static ByteBuffer copyToDirectBuffer(Context context, Resources resources, int i) {
        ByteBuffer byteBuffer = null;
        File tempFile = getTempFile(context);
        if (tempFile != null) {
            try {
                if (copyToFile(tempFile, resources, i)) {
                    byteBuffer = mmap(tempFile);
                }
            } finally {
                tempFile.delete();
            }
        }
        return byteBuffer;
    }

    public static boolean copyToFile(File file, InputStream inputStream) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file, false);
            try {
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            closeQuietly(fileOutputStream);
                            return true;
                        }
                    }
                } catch (IOException e) {
                    e = e;
                    Log.e(TAG, "Error copying resource contents to temp file: " + e.getMessage());
                    closeQuietly(fileOutputStream);
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            closeQuietly(fileOutputStream);
            throw th;
        }
    }

    public static boolean copyToFile(File file, Resources resources, int i) {
        InputStream inputStream = null;
        try {
            inputStream = resources.openRawResource(i);
            return copyToFile(file, inputStream);
        } finally {
            closeQuietly(inputStream);
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }
}

package com.yanzhenjie.album.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import com.yanzhenjie.album.util.AlbumUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes2.dex */
public class ThumbnailBuilder {
    private Context mContext;
    private File mFileCacheDir;

    public ThumbnailBuilder(Context context) {
        this.mContext = context;
        this.mFileCacheDir = createCacheDir(this.mContext);
    }

    @WorkerThread
    @Nullable
    public String createThumbnailForImage(String str) {
        FileOutputStream fileOutputStream = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!new File(str).exists()) {
            return str;
        }
        File randomCacheImagePath = randomCacheImagePath(this.mFileCacheDir, str);
        if (randomCacheImagePath.exists()) {
            return randomCacheImagePath.getAbsolutePath();
        }
        Bitmap readImageFromPath = DefaultAlbumLoader.readImageFromPath(str, 720, 1280);
        if (readImageFromPath == null) {
            return str;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 100;
        readImageFromPath.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        while (byteArrayOutputStream.toByteArray().length > 204800 && i > 0) {
            byteArrayOutputStream.reset();
            i -= 10;
            readImageFromPath.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        }
        try {
            byteArrayOutputStream.close();
        } catch (IOException e) {
        }
        try {
            randomCacheImagePath.createNewFile();
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(randomCacheImagePath);
                try {
                    fileOutputStream2.write(byteArrayOutputStream.toByteArray());
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.flush();
                        } catch (IOException e2) {
                        }
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e3) {
                        }
                    }
                    return randomCacheImagePath.getAbsolutePath();
                } catch (Exception e4) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                        } catch (IOException e5) {
                        }
                        try {
                            fileOutputStream.close();
                            return str;
                        } catch (IOException e6) {
                            return str;
                        }
                    }
                    return str;
                } catch (Throwable th) {
                    fileOutputStream = fileOutputStream2;
                    th = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                        } catch (IOException e7) {
                        }
                        try {
                            fileOutputStream.close();
                        } catch (IOException e8) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e9) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e10) {
            return str;
        }
    }

    @WorkerThread
    @Nullable
    public String createThumbnailForVideo(String str) {
        Bitmap bitmap;
        Throwable th;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File randomCacheImagePath = randomCacheImagePath(this.mFileCacheDir, str);
        if (randomCacheImagePath.exists()) {
            return randomCacheImagePath.getAbsolutePath();
        }
        try {
            randomCacheImagePath.createNewFile();
            try {
                bitmap = readVideoFrameFromPath(this.mContext, str);
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(randomCacheImagePath));
                    if (bitmap != null && !bitmap.isRecycled()) {
                        bitmap.recycle();
                    }
                    return randomCacheImagePath.getAbsolutePath();
                } catch (Exception e) {
                    if (bitmap == null || bitmap.isRecycled()) {
                        return null;
                    }
                    bitmap.recycle();
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (bitmap != null && !bitmap.isRecycled()) {
                        bitmap.recycle();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                bitmap = null;
            } catch (Throwable th3) {
                bitmap = null;
                th = th3;
            }
        } catch (Exception e3) {
            return null;
        }
    }

    private static File createCacheDir(Context context) {
        File file = new File(AlbumUtils.getAlbumRootPath(context), "AlbumCache");
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, ".nomedia");
        if (file2.exists() && file2.isDirectory()) {
            file2.delete();
        }
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                ThrowableExtension.printStackTrace(e);
            }
        }
        return file;
    }

    private static File randomCacheImagePath(File file, String str) {
        return new File(file, AlbumUtils.getMD5ForString(str) + ".jpg");
    }

    public static Bitmap readVideoFrameFromPath(Context context, String str) throws Exception {
        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 1);
        if (createVideoThumbnail == null) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(context, Uri.fromFile(new File(str)));
            return mediaMetadataRetriever.getFrameAtTime();
        }
        return createVideoThumbnail;
    }
}

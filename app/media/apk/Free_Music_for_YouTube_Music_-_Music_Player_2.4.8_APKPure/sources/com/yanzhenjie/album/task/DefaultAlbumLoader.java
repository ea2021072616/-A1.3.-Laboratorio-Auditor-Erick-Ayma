package com.yanzhenjie.album.task;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.LruCache;
import android.util.Log;
import android.widget.ImageView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.AlbumLoader;
import com.yanzhenjie.album.R;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class DefaultAlbumLoader implements AlbumLoader {
    private static Handler instanceHandler;
    private static DefaultAlbumLoader mInstance;
    private final ExecutorService mExecutorService = Executors.newFixedThreadPool(6);
    private final LruCache<String, Bitmap> mLruCache = new LruCache<String, Bitmap>((int) (Runtime.getRuntime().maxMemory() / 4)) { // from class: com.yanzhenjie.album.task.DefaultAlbumLoader.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v4.util.LruCache
        public int sizeOf(String str, Bitmap bitmap) {
            return bitmap.getRowBytes() * bitmap.getHeight();
        }
    };
    private static final String TAG = DefaultAlbumLoader.class.getSimpleName();
    private static Drawable sErrorDrawable = new ColorDrawable(Color.parseColor("#FF2B2B2B"));
    private static Drawable sPlaceHolderDrawable = new ColorDrawable(Color.parseColor("#FF2B2B2B"));

    static /* synthetic */ Handler access$300() {
        return getHandler();
    }

    public static DefaultAlbumLoader getInstance() {
        if (mInstance == null) {
            synchronized (DefaultAlbumLoader.class) {
                if (mInstance == null) {
                    mInstance = new DefaultAlbumLoader();
                }
            }
        }
        return mInstance;
    }

    private static Handler getHandler() {
        if (instanceHandler == null) {
            synchronized (DefaultAlbumLoader.class) {
                if (instanceHandler == null) {
                    instanceHandler = new Handler(Looper.getMainLooper());
                }
            }
        }
        return instanceHandler;
    }

    public static void setPlaceHolderDrawable(Drawable drawable) {
        if (drawable != null) {
            sPlaceHolderDrawable = drawable;
        }
    }

    public static void setErrorDrawable(Drawable drawable) {
        if (drawable != null) {
            sErrorDrawable = drawable;
        }
    }

    private DefaultAlbumLoader() {
    }

    @Override // com.yanzhenjie.album.AlbumLoader
    public void loadAlbumFile(ImageView imageView, AlbumFile albumFile, int i, int i2) {
        if (albumFile.getMediaType() == 1) {
            loadImage(imageView, albumFile.getPath(), i, i2);
        } else {
            loadVideo(imageView, albumFile.getPath(), i, i2);
        }
    }

    @Override // com.yanzhenjie.album.AlbumLoader
    public void loadImage(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(R.id.album_image_load_tag, str);
        Bitmap imageFromCache = getImageFromCache(str, i, i2);
        if (imageFromCache == null) {
            imageView.setImageDrawable(sPlaceHolderDrawable);
            this.mExecutorService.execute(new LoadImageTask(this, imageView, str, i, i2));
            return;
        }
        BitmapHolder bitmapHolder = new BitmapHolder();
        bitmapHolder.mImageView = imageView;
        bitmapHolder.mTargetPath = str;
        bitmapHolder.mBitmap = imageFromCache;
        getHandler().post(bitmapHolder);
    }

    public void loadVideo(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(R.id.album_image_load_tag, str);
        Bitmap imageFromCache = getImageFromCache(str, i, i2);
        if (imageFromCache == null) {
            imageView.setImageDrawable(sPlaceHolderDrawable);
            this.mExecutorService.execute(new LoadVideoTask(this, imageView, str, i, i2));
            return;
        }
        BitmapHolder bitmapHolder = new BitmapHolder();
        bitmapHolder.mImageView = imageView;
        bitmapHolder.mTargetPath = str;
        bitmapHolder.mBitmap = imageFromCache;
        getHandler().post(bitmapHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class LoadVideoTask implements Runnable {
        private String mFilePath;
        private ImageView mImageView;
        private DefaultAlbumLoader mLoader;
        private int mViewHeight;
        private int mViewWidth;

        LoadVideoTask(DefaultAlbumLoader defaultAlbumLoader, ImageView imageView, String str, int i, int i2) {
            this.mLoader = defaultAlbumLoader;
            this.mFilePath = str;
            this.mImageView = imageView;
            this.mViewWidth = i;
            this.mViewHeight = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap bitmap = null;
            try {
                bitmap = BitmapFactory.decodeFile(new ThumbnailBuilder(this.mImageView.getContext()).createThumbnailForVideo(this.mFilePath));
            } catch (Exception e) {
                Log.w(DefaultAlbumLoader.TAG, "Load thumbnail error, the path of file: " + this.mFilePath, e);
            }
            postResult(bitmap);
        }

        private void postResult(Bitmap bitmap) {
            this.mLoader.addImageToCache(this.mFilePath, this.mViewWidth, this.mViewHeight, bitmap);
            BitmapHolder bitmapHolder = new BitmapHolder();
            bitmapHolder.mBitmap = bitmap;
            bitmapHolder.mImageView = this.mImageView;
            bitmapHolder.mTargetPath = this.mFilePath;
            DefaultAlbumLoader.access$300().post(bitmapHolder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class LoadImageTask implements Runnable {
        private String mImagePath;
        private ImageView mImageView;
        private DefaultAlbumLoader mLoader;
        private int mViewHeight;
        private int mViewWidth;

        LoadImageTask(DefaultAlbumLoader defaultAlbumLoader, ImageView imageView, String str, int i, int i2) {
            this.mLoader = defaultAlbumLoader;
            this.mImagePath = str;
            this.mImageView = imageView;
            this.mViewWidth = i;
            this.mViewHeight = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            postResult(DefaultAlbumLoader.readImageFromPath(this.mImagePath, this.mViewWidth, this.mViewHeight));
        }

        private void postResult(Bitmap bitmap) {
            this.mLoader.addImageToCache(this.mImagePath, this.mViewWidth, this.mViewHeight, bitmap);
            BitmapHolder bitmapHolder = new BitmapHolder();
            bitmapHolder.mBitmap = bitmap;
            bitmapHolder.mImageView = this.mImageView;
            bitmapHolder.mTargetPath = this.mImagePath;
            DefaultAlbumLoader.access$300().post(bitmapHolder);
        }
    }

    public static Bitmap readImageFromPath(String str, int i, int i2) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        int readDegree;
        Bitmap bitmap;
        boolean z;
        File file = new File(str);
        if (file.exists()) {
            try {
                bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeStream(bufferedInputStream2, null, options);
                    bufferedInputStream2.close();
                    options.inSampleSize = calculateInSampleSize(options, i, i2);
                    options.inJustDecodeBounds = false;
                    boolean z2 = false;
                    bufferedInputStream = bufferedInputStream2;
                    Bitmap bitmap2 = null;
                    while (!z2) {
                        try {
                            BufferedInputStream bufferedInputStream3 = new BufferedInputStream(new FileInputStream(file));
                            try {
                                try {
                                    bitmap = BitmapFactory.decodeStream(bufferedInputStream3, null, options);
                                    z = true;
                                } catch (Exception e) {
                                    options.inSampleSize *= 2;
                                    boolean z3 = z2;
                                    bitmap = bitmap2;
                                    z = z3;
                                }
                                try {
                                    bufferedInputStream3.close();
                                    bufferedInputStream = bufferedInputStream3;
                                    Bitmap bitmap3 = bitmap;
                                    z2 = z;
                                    bitmap2 = bitmap3;
                                } catch (Exception e2) {
                                    bufferedInputStream2 = bufferedInputStream3;
                                    if (bufferedInputStream2 != null) {
                                        try {
                                            bufferedInputStream2.close();
                                        } catch (IOException e3) {
                                            ThrowableExtension.printStackTrace(e3);
                                        }
                                    }
                                    return null;
                                }
                            } catch (Throwable th) {
                                th = th;
                                bufferedInputStream = bufferedInputStream3;
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e4) {
                                        ThrowableExtension.printStackTrace(e4);
                                    }
                                }
                                throw th;
                            }
                        } catch (Exception e5) {
                            bufferedInputStream2 = bufferedInputStream;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    if ((str.endsWith(".jpg") || str.endsWith(".JPG") || str.endsWith(".jpeg") || str.endsWith(".JPEG")) && (readDegree = readDegree(str)) > 0) {
                        Matrix matrix = new Matrix();
                        matrix.setRotate(readDegree, bitmap2.getWidth() / 2, bitmap2.getHeight() / 2);
                        bitmap2 = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), bitmap2.getHeight(), matrix, true);
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                            return bitmap2;
                        } catch (IOException e6) {
                            ThrowableExtension.printStackTrace(e6);
                            return bitmap2;
                        }
                    }
                    return bitmap2;
                } catch (Exception e7) {
                } catch (Throwable th3) {
                    bufferedInputStream = bufferedInputStream2;
                    th = th3;
                }
            } catch (Exception e8) {
                bufferedInputStream2 = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = null;
            }
        }
        return null;
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
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

    public static int readDegree(String str) {
        try {
            switch (new ExifInterface(str).getAttributeInt("Orientation", 1)) {
                case 3:
                    return 180;
                case 4:
                case 5:
                case 7:
                default:
                    return 0;
                case 6:
                    return 90;
                case 8:
                    return 270;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    private Bitmap getImageFromCache(String str, int i, int i2) {
        Bitmap bitmap;
        synchronized (this.mLruCache) {
            bitmap = this.mLruCache.get(str + i + i2);
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addImageToCache(String str, int i, int i2, Bitmap bitmap) {
        if (getImageFromCache(str, i, i2) == null && bitmap != null) {
            synchronized (this.mLruCache) {
                this.mLruCache.put(str + i + i2, bitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class BitmapHolder implements Runnable {
        Bitmap mBitmap;
        ImageView mImageView;
        String mTargetPath;

        private BitmapHolder() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mTargetPath.equals(this.mImageView.getTag(R.id.album_image_load_tag))) {
                if (this.mBitmap == null) {
                    this.mImageView.setImageDrawable(DefaultAlbumLoader.sErrorDrawable);
                } else {
                    this.mImageView.setImageBitmap(this.mBitmap);
                }
            }
        }
    }
}

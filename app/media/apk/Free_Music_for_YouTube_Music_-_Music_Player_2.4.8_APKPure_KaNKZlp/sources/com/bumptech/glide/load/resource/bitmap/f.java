package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.util.EnumSet;
import java.util.Queue;
import java.util.Set;
/* compiled from: Downsampler.java */
/* loaded from: classes.dex */
public abstract class f implements a<InputStream> {
    private static final Set<ImageHeaderParser.ImageType> d = EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG);
    private static final Queue<BitmapFactory.Options> e = com.bumptech.glide.i.h.a(0);

    /* renamed from: a  reason: collision with root package name */
    public static final f f921a = new f() { // from class: com.bumptech.glide.load.resource.bitmap.f.1
        @Override // com.bumptech.glide.load.resource.bitmap.f
        protected int a(int i, int i2, int i3, int i4) {
            return Math.min(i2 / i4, i / i3);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.a
        public String a() {
            return "AT_LEAST.com.bumptech.glide.load.data.bitmap";
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static final f f922b = new f() { // from class: com.bumptech.glide.load.resource.bitmap.f.2
        @Override // com.bumptech.glide.load.resource.bitmap.f
        protected int a(int i, int i2, int i3, int i4) {
            int ceil = (int) Math.ceil(Math.max(i2 / i4, i / i3));
            int max = Math.max(1, Integer.highestOneBit(ceil));
            return max << (max >= ceil ? 0 : 1);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.a
        public String a() {
            return "AT_MOST.com.bumptech.glide.load.data.bitmap";
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public static final f f923c = new f() { // from class: com.bumptech.glide.load.resource.bitmap.f.3
        @Override // com.bumptech.glide.load.resource.bitmap.f
        protected int a(int i, int i2, int i3, int i4) {
            return 0;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.a
        public String a() {
            return "NONE.com.bumptech.glide.load.data.bitmap";
        }
    };

    protected abstract int a(int i, int i2, int i3, int i4);

    public Bitmap a(InputStream inputStream, com.bumptech.glide.load.b.a.c cVar, int i, int i2, com.bumptech.glide.load.a aVar) {
        int i3;
        com.bumptech.glide.i.a a2 = com.bumptech.glide.i.a.a();
        byte[] b2 = a2.b();
        byte[] b3 = a2.b();
        BitmapFactory.Options b4 = b();
        n nVar = new n(inputStream, b3);
        com.bumptech.glide.i.c a3 = com.bumptech.glide.i.c.a(nVar);
        com.bumptech.glide.i.f fVar = new com.bumptech.glide.i.f(a3);
        try {
            a3.mark(5242880);
            try {
                int c2 = new ImageHeaderParser(a3).c();
                try {
                    a3.reset();
                    i3 = c2;
                } catch (IOException e2) {
                    if (Log.isLoggable("Downsampler", 5)) {
                        Log.w("Downsampler", "Cannot reset the input stream", e2);
                    }
                    i3 = c2;
                }
            } catch (IOException e3) {
                if (Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", "Cannot determine the image orientation from header", e3);
                }
                try {
                    a3.reset();
                    i3 = 0;
                } catch (IOException e4) {
                    if (Log.isLoggable("Downsampler", 5)) {
                        Log.w("Downsampler", "Cannot reset the input stream", e4);
                    }
                    i3 = 0;
                }
            }
            b4.inTempStorage = b2;
            int[] a4 = a(fVar, nVar, b4);
            int i4 = a4[0];
            int i5 = a4[1];
            Bitmap a5 = a(fVar, nVar, b4, cVar, i4, i5, a(q.a(i3), i4, i5, i, i2), aVar);
            IOException a6 = a3.a();
            if (a6 != null) {
                throw new RuntimeException(a6);
            }
            Bitmap bitmap = null;
            if (a5 != null) {
                bitmap = q.a(a5, cVar, i3);
                if (!a5.equals(bitmap) && !cVar.a(a5)) {
                    a5.recycle();
                }
            }
            return bitmap;
        } finally {
            a2.a(b2);
            a2.a(b3);
            a3.b();
            a(b4);
        }
    }

    private int a(int i, int i2, int i3, int i4, int i5) {
        int a2;
        if (i5 == Integer.MIN_VALUE) {
            i5 = i3;
        }
        if (i4 == Integer.MIN_VALUE) {
            i4 = i2;
        }
        if (i == 90 || i == 270) {
            a2 = a(i3, i2, i4, i5);
        } else {
            a2 = a(i2, i3, i4, i5);
        }
        return Math.max(1, a2 == 0 ? 0 : Integer.highestOneBit(a2));
    }

    private Bitmap a(com.bumptech.glide.i.f fVar, n nVar, BitmapFactory.Options options, com.bumptech.glide.load.b.a.c cVar, int i, int i2, int i3, com.bumptech.glide.load.a aVar) {
        Bitmap.Config a2 = a(fVar, aVar);
        options.inSampleSize = i3;
        options.inPreferredConfig = a2;
        if ((options.inSampleSize == 1 || 19 <= Build.VERSION.SDK_INT) && a(fVar)) {
            a(options, cVar.b((int) Math.ceil(i / i3), (int) Math.ceil(i2 / i3), a2));
        }
        return b(fVar, nVar, options);
    }

    private static boolean a(InputStream inputStream) {
        if (19 <= Build.VERSION.SDK_INT) {
            return true;
        }
        inputStream.mark(1024);
        try {
            try {
                boolean contains = d.contains(new ImageHeaderParser(inputStream).b());
                try {
                    inputStream.reset();
                    return contains;
                } catch (IOException e2) {
                    if (Log.isLoggable("Downsampler", 5)) {
                        Log.w("Downsampler", "Cannot reset the input stream", e2);
                        return contains;
                    }
                    return contains;
                }
            } catch (IOException e3) {
                if (Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", "Cannot determine the image type from header", e3);
                }
                return false;
            }
        } finally {
            try {
                inputStream.reset();
            } catch (IOException e4) {
                if (Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", "Cannot reset the input stream", e4);
                }
            }
        }
    }

    private static Bitmap.Config a(InputStream inputStream, com.bumptech.glide.load.a aVar) {
        boolean z;
        if (aVar == com.bumptech.glide.load.a.ALWAYS_ARGB_8888 || aVar == com.bumptech.glide.load.a.PREFER_ARGB_8888 || Build.VERSION.SDK_INT == 16) {
            return Bitmap.Config.ARGB_8888;
        }
        inputStream.mark(1024);
        try {
            try {
                z = new ImageHeaderParser(inputStream).a();
            } catch (IOException e2) {
                if (Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", "Cannot determine whether the image has alpha or not from header for format " + aVar, e2);
                }
                try {
                    inputStream.reset();
                    z = false;
                } catch (IOException e3) {
                    if (Log.isLoggable("Downsampler", 5)) {
                        Log.w("Downsampler", "Cannot reset the input stream", e3);
                    }
                    z = false;
                }
            }
            return z ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        } finally {
            try {
                inputStream.reset();
            } catch (IOException e4) {
                if (Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", "Cannot reset the input stream", e4);
                }
            }
        }
    }

    public int[] a(com.bumptech.glide.i.f fVar, n nVar, BitmapFactory.Options options) {
        options.inJustDecodeBounds = true;
        b(fVar, nVar, options);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static Bitmap b(com.bumptech.glide.i.f fVar, n nVar, BitmapFactory.Options options) {
        if (options.inJustDecodeBounds) {
            fVar.mark(5242880);
        } else {
            nVar.a();
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(fVar, null, options);
        try {
            if (options.inJustDecodeBounds) {
                fVar.reset();
            }
        } catch (IOException e2) {
            if (Log.isLoggable("Downsampler", 6)) {
                Log.e("Downsampler", "Exception loading inDecodeBounds=" + options.inJustDecodeBounds + " sample=" + options.inSampleSize, e2);
            }
        }
        return decodeStream;
    }

    @TargetApi(11)
    private static void a(BitmapFactory.Options options, Bitmap bitmap) {
        if (11 <= Build.VERSION.SDK_INT) {
            options.inBitmap = bitmap;
        }
    }

    @TargetApi(11)
    private static synchronized BitmapFactory.Options b() {
        BitmapFactory.Options poll;
        synchronized (f.class) {
            synchronized (e) {
                poll = e.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                b(poll);
            }
        }
        return poll;
    }

    private static void a(BitmapFactory.Options options) {
        b(options);
        synchronized (e) {
            e.offer(options);
        }
    }

    @TargetApi(11)
    private static void b(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        if (11 <= Build.VERSION.SDK_INT) {
            options.inBitmap = null;
            options.inMutable = true;
        }
    }
}

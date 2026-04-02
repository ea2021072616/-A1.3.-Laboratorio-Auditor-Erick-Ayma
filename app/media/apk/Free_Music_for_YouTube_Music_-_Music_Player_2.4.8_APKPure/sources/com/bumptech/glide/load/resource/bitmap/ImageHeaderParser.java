package com.bumptech.glide.load.resource.bitmap;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes.dex */
public class ImageHeaderParser {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f911a;

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f912b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* renamed from: c  reason: collision with root package name */
    private final b f913c;

    /* loaded from: classes.dex */
    public enum ImageType {
        GIF(true),
        JPEG(false),
        PNG_A(true),
        PNG(false),
        UNKNOWN(false);
        

        /* renamed from: a  reason: collision with root package name */
        private final boolean f914a;

        ImageType(boolean z) {
            this.f914a = z;
        }

        public boolean hasAlpha() {
            return this.f914a;
        }
    }

    static {
        byte[] bArr = new byte[0];
        try {
            bArr = "Exif\u0000\u0000".getBytes(C.UTF8_NAME);
        } catch (UnsupportedEncodingException e) {
        }
        f911a = bArr;
    }

    public ImageHeaderParser(InputStream inputStream) {
        this.f913c = new b(inputStream);
    }

    public boolean a() throws IOException {
        return b().hasAlpha();
    }

    public ImageType b() throws IOException {
        int a2 = this.f913c.a();
        if (a2 == 65496) {
            return ImageType.JPEG;
        }
        int a3 = ((a2 << 16) & SupportMenu.CATEGORY_MASK) | (this.f913c.a() & SupportMenu.USER_MASK);
        if (a3 == -1991225785) {
            this.f913c.a(21L);
            return this.f913c.c() >= 3 ? ImageType.PNG_A : ImageType.PNG;
        } else if ((a3 >> 8) == 4671814) {
            return ImageType.GIF;
        } else {
            return ImageType.UNKNOWN;
        }
    }

    public int c() throws IOException {
        boolean z = false;
        if (a(this.f913c.a())) {
            byte[] d = d();
            boolean z2 = d != null && d.length > f911a.length;
            if (z2) {
                for (int i = 0; i < f911a.length; i++) {
                    if (d[i] != f911a[i]) {
                        break;
                    }
                }
            }
            z = z2;
            if (z) {
                return a(new a(d));
            }
            return -1;
        }
        return -1;
    }

    private byte[] d() throws IOException {
        short b2;
        short b3;
        int a2;
        long a3;
        do {
            if (this.f913c.b() != 255) {
                if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Unknown segmentId=" + ((int) b2));
                    return null;
                }
                return null;
            }
            b3 = this.f913c.b();
            if (b3 == 218) {
                return null;
            }
            if (b3 == 217) {
                if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Found MARKER_EOI in exif segment");
                    return null;
                }
                return null;
            }
            a2 = this.f913c.a() - 2;
            if (b3 != 225) {
                a3 = this.f913c.a(a2);
            } else {
                byte[] bArr = new byte[a2];
                int a4 = this.f913c.a(bArr);
                if (a4 != a2) {
                    if (Log.isLoggable("ImageHeaderParser", 3)) {
                        Log.d("ImageHeaderParser", "Unable to read segment data, type: " + ((int) b3) + ", length: " + a2 + ", actually read: " + a4);
                        return null;
                    }
                    return null;
                }
                return bArr;
            }
        } while (a3 == a2);
        if (Log.isLoggable("ImageHeaderParser", 3)) {
            Log.d("ImageHeaderParser", "Unable to skip enough data, type: " + ((int) b3) + ", wanted to skip: " + a2 + ", but actually skipped: " + a3);
            return null;
        }
        return null;
    }

    private static int a(a aVar) {
        ByteOrder byteOrder;
        int length = "Exif\u0000\u0000".length();
        short b2 = aVar.b(length);
        if (b2 == 19789) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else if (b2 == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Unknown endianness = " + ((int) b2));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        aVar.a(byteOrder);
        int a2 = length + aVar.a(length + 4);
        short b3 = aVar.b(a2);
        for (int i = 0; i < b3; i++) {
            int a3 = a(a2, i);
            short b4 = aVar.b(a3);
            if (b4 == 274) {
                short b5 = aVar.b(a3 + 2);
                if (b5 < 1 || b5 > 12) {
                    if (Log.isLoggable("ImageHeaderParser", 3)) {
                        Log.d("ImageHeaderParser", "Got invalid format code=" + ((int) b5));
                    }
                } else {
                    int a4 = aVar.a(a3 + 4);
                    if (a4 < 0) {
                        if (Log.isLoggable("ImageHeaderParser", 3)) {
                            Log.d("ImageHeaderParser", "Negative tiff component count");
                        }
                    } else {
                        if (Log.isLoggable("ImageHeaderParser", 3)) {
                            Log.d("ImageHeaderParser", "Got tagIndex=" + i + " tagType=" + ((int) b4) + " formatCode=" + ((int) b5) + " componentCount=" + a4);
                        }
                        int i2 = a4 + f912b[b5];
                        if (i2 > 4) {
                            if (Log.isLoggable("ImageHeaderParser", 3)) {
                                Log.d("ImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) b5));
                            }
                        } else {
                            int i3 = a3 + 8;
                            if (i3 < 0 || i3 > aVar.a()) {
                                if (Log.isLoggable("ImageHeaderParser", 3)) {
                                    Log.d("ImageHeaderParser", "Illegal tagValueOffset=" + i3 + " tagType=" + ((int) b4));
                                }
                            } else if (i2 < 0 || i3 + i2 > aVar.a()) {
                                if (Log.isLoggable("ImageHeaderParser", 3)) {
                                    Log.d("ImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) b4));
                                }
                            } else {
                                return aVar.b(i3);
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    private static int a(int i, int i2) {
        return i + 2 + (i2 * 12);
    }

    private static boolean a(int i) {
        return (i & 65496) == 65496 || i == 19789 || i == 18761;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f915a;

        public a(byte[] bArr) {
            this.f915a = ByteBuffer.wrap(bArr);
            this.f915a.order(ByteOrder.BIG_ENDIAN);
        }

        public void a(ByteOrder byteOrder) {
            this.f915a.order(byteOrder);
        }

        public int a() {
            return this.f915a.array().length;
        }

        public int a(int i) {
            return this.f915a.getInt(i);
        }

        public short b(int i) {
            return this.f915a.getShort(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final InputStream f916a;

        public b(InputStream inputStream) {
            this.f916a = inputStream;
        }

        public int a() throws IOException {
            return ((this.f916a.read() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (this.f916a.read() & 255);
        }

        public short b() throws IOException {
            return (short) (this.f916a.read() & 255);
        }

        public long a(long j) throws IOException {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.f916a.skip(j2);
                if (skip > 0) {
                    j2 -= skip;
                } else if (this.f916a.read() == -1) {
                    break;
                } else {
                    j2--;
                }
            }
            return j - j2;
        }

        public int a(byte[] bArr) throws IOException {
            int length = bArr.length;
            while (length > 0) {
                int read = this.f916a.read(bArr, bArr.length - length, length);
                if (read == -1) {
                    break;
                }
                length -= read;
            }
            return bArr.length - length;
        }

        public int c() throws IOException {
            return this.f916a.read();
        }
    }
}

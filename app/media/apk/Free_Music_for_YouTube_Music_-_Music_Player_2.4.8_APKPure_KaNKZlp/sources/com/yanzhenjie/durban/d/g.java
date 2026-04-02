package com.yanzhenjie.durban.d;

import android.media.ExifInterface;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
/* compiled from: ImageHeaderParser.java */
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f5154a = "Exif\u0000\u0000".getBytes(Charset.forName(C.UTF8_NAME));

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f5155b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* renamed from: c  reason: collision with root package name */
    private final b f5156c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ImageHeaderParser.java */
    /* loaded from: classes2.dex */
    public interface b {
        int a() throws IOException;

        int a(byte[] bArr, int i) throws IOException;

        long a(long j) throws IOException;

        short b() throws IOException;
    }

    public g(InputStream inputStream) {
        this.f5156c = new c(inputStream);
    }

    public int a() throws IOException {
        int a2 = this.f5156c.a();
        if (!a(a2)) {
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Parser doesn't handle magic number: " + a2);
                return -1;
            }
            return -1;
        }
        int b2 = b();
        if (b2 == -1) {
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                return -1;
            }
            return -1;
        }
        return a(new byte[b2], b2);
    }

    private int a(byte[] bArr, int i) throws IOException {
        int a2 = this.f5156c.a(bArr, i);
        if (a2 != i) {
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Unable to read exif segment data, length: " + i + ", actually read: " + a2);
                return -1;
            }
            return -1;
        } else if (b(bArr, i)) {
            return a(new a(bArr, i));
        } else {
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Missing jpeg exif preamble");
                return -1;
            }
            return -1;
        }
    }

    private boolean b(byte[] bArr, int i) {
        boolean z = bArr != null && i > f5154a.length;
        if (z) {
            for (int i2 = 0; i2 < f5154a.length; i2++) {
                if (bArr[i2] != f5154a[i2]) {
                    return false;
                }
            }
        }
        return z;
    }

    private int b() throws IOException {
        short b2;
        short b3;
        int a2;
        long a3;
        do {
            if (this.f5156c.b() != 255) {
                if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Unknown segmentId=" + ((int) b2));
                    return -1;
                }
                return -1;
            }
            b3 = this.f5156c.b();
            if (b3 == 218) {
                return -1;
            }
            if (b3 == 217) {
                if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Found MARKER_EOI in exif segment");
                    return -1;
                }
                return -1;
            }
            a2 = this.f5156c.a() - 2;
            if (b3 == 225) {
                return a2;
            }
            a3 = this.f5156c.a(a2);
        } while (a3 == a2);
        if (Log.isLoggable("ImageHeaderParser", 3)) {
            Log.d("ImageHeaderParser", "Unable to skip enough data, type: " + ((int) b3) + ", wanted to skip: " + a2 + ", but actually skipped: " + a3);
            return -1;
        }
        return -1;
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
                        Log.d("ImageHeaderParser", "Got invalid format code = " + ((int) b5));
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
                        int i2 = a4 + f5155b[b5];
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
    /* compiled from: ImageHeaderParser.java */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f5157a;

        public a(byte[] bArr, int i) {
            this.f5157a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        public void a(ByteOrder byteOrder) {
            this.f5157a.order(byteOrder);
        }

        public int a() {
            return this.f5157a.remaining();
        }

        public int a(int i) {
            return this.f5157a.getInt(i);
        }

        public short b(int i) {
            return this.f5157a.getShort(i);
        }
    }

    /* compiled from: ImageHeaderParser.java */
    /* loaded from: classes2.dex */
    private static class c implements b {

        /* renamed from: a  reason: collision with root package name */
        private final InputStream f5158a;

        public c(InputStream inputStream) {
            this.f5158a = inputStream;
        }

        @Override // com.yanzhenjie.durban.d.g.b
        public int a() throws IOException {
            return ((this.f5158a.read() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (this.f5158a.read() & 255);
        }

        @Override // com.yanzhenjie.durban.d.g.b
        public short b() throws IOException {
            return (short) (this.f5158a.read() & 255);
        }

        @Override // com.yanzhenjie.durban.d.g.b
        public long a(long j) throws IOException {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.f5158a.skip(j2);
                if (skip > 0) {
                    j2 -= skip;
                } else if (this.f5158a.read() == -1) {
                    break;
                } else {
                    j2--;
                }
            }
            return j - j2;
        }

        @Override // com.yanzhenjie.durban.d.g.b
        public int a(byte[] bArr, int i) throws IOException {
            int i2 = i;
            while (i2 > 0) {
                int read = this.f5158a.read(bArr, i - i2, i2);
                if (read == -1) {
                    break;
                }
                i2 -= read;
            }
            return i - i2;
        }
    }

    public static void a(ExifInterface exifInterface, int i, int i2, String str) {
        String[] strArr = {"FNumber", "DateTime", "DateTimeDigitized", "ExposureTime", "Flash", "FocalLength", "GPSAltitude", "GPSAltitudeRef", "GPSDateStamp", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "GPSProcessingMethod", "GPSTimeStamp", "ISOSpeedRatings", "Make", "Model", "SubSecTime", "SubSecTimeDigitized", "SubSecTimeOriginal", "WhiteBalance"};
        try {
            ExifInterface exifInterface2 = new ExifInterface(str);
            for (String str2 : strArr) {
                String attribute = exifInterface.getAttribute(str2);
                if (!TextUtils.isEmpty(attribute)) {
                    exifInterface2.setAttribute(str2, attribute);
                }
            }
            exifInterface2.setAttribute("ImageWidth", String.valueOf(i));
            exifInterface2.setAttribute("ImageLength", String.valueOf(i2));
            exifInterface2.setAttribute("Orientation", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            exifInterface2.saveAttributes();
        } catch (IOException e) {
            Log.d("ImageHeaderParser", e.getMessage());
        }
    }
}

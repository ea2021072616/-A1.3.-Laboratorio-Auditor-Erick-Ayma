package ru.zdevs.zugate.jni;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.system.Os;
import java.util.zip.CRC32;
import ru.zdevs.zugate.ZApp;
import w4.f;
/* loaded from: classes.dex */
public abstract class Image {
    public static long a(int i5, String str) {
        try {
            CRC32 crc32 = new CRC32();
            crc32.update(str.getBytes());
            if (i5 >= 0) {
                crc32.update(i5);
            }
            return crc32.getValue();
        } catch (SecurityException unused) {
            throw new UnsupportedOperationException();
        }
    }

    public static f b(Uri uri, int i5, boolean z4, StringBuilder sb) {
        int i6;
        ParcelFileDescriptor parcelFileDescriptor;
        String str;
        try {
            ContentResolver contentResolver = ZApp.f4571h.getContentResolver();
            if (!z4) {
                BlockDevice.init();
                try {
                    i6 = ZApp.f4571h.getContentResolver().openFileDescriptor(uri, "rw").detachFd();
                } catch (Exception unused) {
                    i6 = -1;
                }
                if (i6 == -1) {
                    try {
                        i6 = ZApp.f4571h.getContentResolver().openFileDescriptor(uri, "r").detachFd();
                    } catch (Exception unused2) {
                        i6 = -1;
                    }
                    if (i6 != -1 && (i5 & 1) == 0) {
                        i5 |= 1;
                    }
                }
                if (i6 == -1) {
                    return null;
                }
                long cOpen = cOpen(i6, i5);
                if (cOpen == 0) {
                    return null;
                }
                return new BlockDevice(cOpen, true);
            }
            try {
                parcelFileDescriptor = contentResolver.openFileDescriptor(uri, "r");
            } catch (Exception unused3) {
                parcelFileDescriptor = null;
            } catch (Throwable th) {
                th = th;
                parcelFileDescriptor = null;
            }
            if (parcelFileDescriptor != null) {
                try {
                    str = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
                    try {
                        parcelFileDescriptor.close();
                    } catch (Exception unused4) {
                    }
                } catch (Exception unused5) {
                    try {
                        parcelFileDescriptor.close();
                    } catch (Exception unused6) {
                    }
                    str = null;
                    return w4.c.j(str, i5, sb);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        parcelFileDescriptor.close();
                    } catch (Exception unused7) {
                    }
                    throw th;
                }
                return w4.c.j(str, i5, sb);
            }
            parcelFileDescriptor.close();
            str = null;
            return w4.c.j(str, i5, sb);
        } catch (Exception unused8) {
            return null;
        }
    }

    private static native long cOpen(int i5, int i6);
}

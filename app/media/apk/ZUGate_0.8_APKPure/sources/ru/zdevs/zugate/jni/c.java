package ru.zdevs.zugate.jni;

import android.content.ContentResolver;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.preference.PreferenceManager;
import androidx.appcompat.widget.b0;
import com.google.android.gms.internal.play_billing.i0;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.CRC32;
import ru.zdevs.zugate.USBGateProvider;
import ru.zdevs.zugate.ZApp;
import ru.zdevs.zugate.jni.EncFS;
import x4.j;
/* loaded from: classes.dex */
public abstract class c {
    public static void a(Uri uri, String str, EncFS.EncFSContext encFSContext) {
        ZApp zApp = ZApp.f4571h;
        if (zApp == null) {
            return;
        }
        EncFS.cFsInit(encFSContext, str);
        ContentResolver contentResolver = zApp.getContentResolver();
        i0.o(contentResolver, uri, "", ".encfs6.xml", false);
        OutputStream outputStream = null;
        try {
            if ("ru.zdevs.zugate.usbgate".equals(uri.getAuthority())) {
                USBGateProvider uSBGateProvider = USBGateProvider.f4563k;
                if (uSBGateProvider == null) {
                    throw new Exception("USBGateProvider not loaded!");
                }
                outputStream = new ParcelFileDescriptor.AutoCloseOutputStream(uSBGateProvider.openDocument(i0.z(uri, ".encfs6.xml"), "w", null));
            } else {
                outputStream = contentResolver.openOutputStream(i0.F(uri, ".encfs6.xml", false));
            }
        } catch (Exception unused) {
        }
        if (outputStream == null) {
            return;
        }
        try {
            try {
                PackageInfo packageInfo = zApp.getPackageManager().getPackageInfo(zApp.getPackageName(), 0);
                outputStream.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<!DOCTYPE boost_serialization>\n<boost_serialization signature=\"serialization::archive\" version=\"7\">\n<cfg class_id=\"0\" tracking_level=\"0\" version=\"20\">\n".getBytes(StandardCharsets.UTF_8));
                c(outputStream, "version", encFSContext.subVersion);
                d(outputStream, "creator", "ZUGate " + packageInfo.versionName);
                b(outputStream, "cipherAlg", " class_id=\"1\" tracking_level=\"0\" version=\"0\"", encFSContext.cipherAlg, encFSContext.cipherVer);
                b(outputStream, "nameAlg", "", encFSContext.nameAlg, encFSContext.nameVer);
                c(outputStream, "keySize", encFSContext.keySize);
                c(outputStream, "blockSize", encFSContext.blockSize);
                long j5 = 0;
                c(outputStream, "plainData", (encFSContext.flags & 1) == 0 ? 0L : 1L);
                c(outputStream, "uniqueIV", (encFSContext.flags & 2) == 0 ? 0L : 1L);
                c(outputStream, "chainedNameIV", (encFSContext.flags & 4) == 0 ? 0L : 1L);
                c(outputStream, "externalIVChaining", (encFSContext.flags & 8) == 0 ? 0L : 1L);
                c(outputStream, "blockMACBytes", encFSContext.blockMACBytes);
                c(outputStream, "blockMACRandBytes", encFSContext.blockMACRandBytes);
                if ((encFSContext.flags & 16) != 0) {
                    j5 = 1;
                }
                c(outputStream, "allowHoles", j5);
                c(outputStream, "encodedKeySize", encFSContext.encodedKeySize);
                d(outputStream, "encodedKeyData", encFSContext.encodedKeyData);
                c(outputStream, "saltLen", encFSContext.saltLen);
                d(outputStream, "saltData", encFSContext.saltData);
                c(outputStream, "kdfIterations", encFSContext.kdfIterations);
                c(outputStream, "desiredKDFDuration", encFSContext.desiredKDFDuration);
                outputStream.write("</cfg>\n</boost_serialization>".getBytes(StandardCharsets.UTF_8));
                try {
                    outputStream.close();
                } catch (Exception unused2) {
                }
                zApp.getContentResolver().takePersistableUriPermission(uri, 3);
                String uri2 = uri.toString();
                boolean z4 = j.f5527a;
                CRC32 crc32 = new CRC32();
                crc32.update(uri2.getBytes());
                long value = crc32.getValue();
                SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(ZApp.f4571h).edit();
                edit.putInt("fs_" + value, 40);
                edit.apply();
            } catch (Exception unused3) {
            }
        } catch (Exception unused4) {
            outputStream.close();
        } catch (Throwable th) {
            try {
                outputStream.close();
            } catch (Exception unused5) {
            }
            throw th;
        }
    }

    public static void b(OutputStream outputStream, String str, String str2, String str3, int i5) {
        outputStream.write(("<" + str + str2 + ">\n<name>" + str3 + "</name>\n<major>" + ((i5 >> 16) & 65535) + "</major>\n<minor>" + (i5 & 65535) + "</minor>\n</" + str + ">\n").getBytes(StandardCharsets.UTF_8));
    }

    public static void c(OutputStream outputStream, String str, long j5) {
        outputStream.write(("<" + str + ">" + j5 + "</" + str + ">\n").getBytes(StandardCharsets.UTF_8));
    }

    public static void d(OutputStream outputStream, String str, String str2) {
        StringBuilder sb = new StringBuilder("<");
        sb.append(str);
        sb.append(">");
        sb.append(str2);
        sb.append("</");
        outputStream.write(b0.i(sb, str, ">\n").getBytes(StandardCharsets.UTF_8));
    }
}

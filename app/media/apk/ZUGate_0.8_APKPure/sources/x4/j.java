package x4;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbInterface;
import java.util.zip.CRC32;
/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f5527a;

    /* renamed from: b  reason: collision with root package name */
    public static final Object f5528b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public static final i f5529c = new i();

    public static long a(CRC32 crc32, UsbDevice usbDevice) {
        crc32.reset();
        crc32.update(usbDevice.getProductId());
        crc32.update(usbDevice.getVendorId());
        crc32.update(usbDevice.getInterfaceCount());
        String productName = usbDevice.getProductName();
        if (productName != null) {
            crc32.update(productName.getBytes());
        }
        String manufacturerName = usbDevice.getManufacturerName();
        if (manufacturerName != null) {
            crc32.update(manufacturerName.getBytes());
        }
        return crc32.getValue();
    }

    public static UsbInterface b(UsbDevice usbDevice) {
        int interfaceCount = usbDevice.getInterfaceCount();
        for (int i5 = 0; i5 < interfaceCount; i5++) {
            UsbInterface usbInterface = usbDevice.getInterface(i5);
            if (usbInterface.getInterfaceClass() == 8 && usbInterface.getInterfaceSubclass() == 6 && usbInterface.getInterfaceProtocol() == 80) {
                return usbInterface;
            }
        }
        return null;
    }

    public static long c(int i5, int i6, int i7, String str, String str2, String str3, int i8) {
        CRC32 crc32 = new CRC32();
        crc32.update(i5);
        crc32.update(i6);
        crc32.update(i7);
        if (str != null) {
            crc32.update(str.getBytes());
        }
        if (str2 != null) {
            crc32.update(str2.getBytes());
        }
        if (str3 != null) {
            crc32.update(str3.getBytes());
        }
        crc32.update(i8);
        return crc32.getValue();
    }
}

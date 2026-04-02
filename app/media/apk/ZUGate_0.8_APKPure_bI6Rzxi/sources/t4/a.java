package t4;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import l2.c0;
import ru.zdevs.zugate.jni.Image;
/* loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new c0(14);

    /* renamed from: b  reason: collision with root package name */
    public final String f5028b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5029c;

    /* renamed from: d  reason: collision with root package name */
    public final int f5030d;

    /* renamed from: e  reason: collision with root package name */
    public int f5031e;

    /* renamed from: f  reason: collision with root package name */
    public final long f5032f;

    /* renamed from: g  reason: collision with root package name */
    public long f5033g;

    /* renamed from: h  reason: collision with root package name */
    public final int f5034h;

    /* renamed from: i  reason: collision with root package name */
    public final long f5035i;

    /* renamed from: j  reason: collision with root package name */
    public int f5036j;

    public a(String str, String str2, long j5) {
        if (str.trim().length() == 0) {
            this.f5028b = "USB Storage";
        } else {
            this.f5028b = str;
        }
        this.f5029c = str2;
        this.f5032f = j5;
        this.f5034h = -1;
        this.f5036j = 16;
        this.f5030d = 100;
        this.f5031e = 0;
        this.f5035i = 0L;
    }

    public final void a(int i5) {
        this.f5036j = i5 | this.f5036j;
    }

    public final long b() {
        int i5 = this.f5036j;
        int i6 = i5 & 4080;
        if (i6 == 256 || i6 == 128) {
            return this.f5032f;
        }
        if ((i5 & 4096) != 0) {
            return this.f5033g;
        }
        int i7 = i5 & 4;
        String str = this.f5029c;
        if (i7 != 0) {
            int i8 = this.f5034h;
            UsbManager x5 = e4.e.x();
            if (x5 == null) {
                throw new UnsupportedOperationException();
            }
            HashMap<String, UsbDevice> deviceList = x5.getDeviceList();
            if (deviceList == null || deviceList.isEmpty()) {
                throw new UnsupportedOperationException();
            }
            UsbDevice usbDevice = deviceList.get(str);
            if (usbDevice == null || !x5.hasPermission(usbDevice)) {
                throw new UnsupportedOperationException();
            }
            boolean z4 = x4.j.f5527a;
            try {
                this.f5033g = x4.j.c(usbDevice.getProductId(), usbDevice.getVendorId(), usbDevice.getInterfaceCount(), usbDevice.getProductName(), usbDevice.getManufacturerName(), usbDevice.getSerialNumber(), i8);
            } catch (SecurityException unused) {
                throw new UnsupportedOperationException();
            }
        } else {
            this.f5033g = Image.a(this.f5034h, str);
        }
        this.f5036j |= 4096;
        return this.f5033g;
    }

    public final Uri c() {
        int i5 = this.f5036j & 4080;
        if (i5 == 64 || i5 == 128 || i5 == 256) {
            return Uri.parse(this.f5029c);
        }
        return null;
    }

    public final boolean d() {
        return (this.f5036j & 8192) != 0;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeString(this.f5028b);
        parcel.writeString(this.f5029c);
        parcel.writeLong(this.f5032f);
        parcel.writeInt(this.f5034h);
        parcel.writeInt(this.f5036j);
        parcel.writeInt(this.f5030d);
        parcel.writeLong(this.f5035i);
    }

    public a(String str, String str2, long j5, int i5, int i6, int i7, long j6) {
        this.f5028b = str;
        this.f5029c = str2;
        this.f5032f = j5;
        this.f5034h = i5;
        this.f5036j = i7 | 33;
        this.f5030d = i6;
        this.f5031e = 0;
        this.f5035i = j6;
    }

    public a(String str, Uri uri, long j5, int i5, int i6, int i7, long j6) {
        this.f5028b = str;
        this.f5029c = uri.toString();
        this.f5032f = j5;
        this.f5034h = i5;
        this.f5036j = i7;
        this.f5030d = i6;
        this.f5031e = 0;
        this.f5035i = j6;
    }

    public a(Parcel parcel) {
        this.f5028b = parcel.readString();
        this.f5029c = parcel.readString();
        this.f5032f = parcel.readLong();
        this.f5034h = parcel.readInt();
        this.f5036j = parcel.readInt();
        this.f5030d = parcel.readInt();
        this.f5035i = parcel.readLong();
    }
}

package ru.zdevs.zugate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import java.util.zip.CRC32;
import x4.j;
/* loaded from: classes.dex */
public class USBGateReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        USBGateService uSBGateService;
        UsbDevice usbDevice = (UsbDevice) intent.getExtras().getParcelable("device");
        String action = intent.getAction();
        action.getClass();
        if ((action.equals("android.hardware.usb.action.USB_DEVICE_ATTACHED") || action.equals("android.hardware.usb.action.USB_DEVICE_DETACHED")) && (uSBGateService = USBGateService.f4566k) != null) {
            boolean z4 = j.f5527a;
            uSBGateService.q(j.a(new CRC32(), usbDevice), 16, -1);
        }
    }
}

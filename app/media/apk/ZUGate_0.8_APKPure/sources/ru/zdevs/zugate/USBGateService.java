package ru.zdevs.zugate;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.UriPermission;
import android.content.res.XmlResourceParser;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.drawable.Icon;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.provider.DocumentsContract;
import b4.j;
import com.github.appintro.R;
import com.google.android.gms.internal.play_billing.i0;
import e4.e;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.zip.CRC32;
import ru.zdevs.zugate.jni.BlockDevice;
import ru.zdevs.zugate.jni.EncFS;
import ru.zdevs.zugate.jni.FS;
import ru.zdevs.zugate.jni.Image;
import ru.zdevs.zugate.jni.b;
import ru.zdevs.zugate.jni.d;
import t4.a;
import t4.r;
import t4.s;
import v4.h;
import w4.c;
import w4.f;
import w4.i;
/* loaded from: classes.dex */
public class USBGateService extends Service {

    /* renamed from: k  reason: collision with root package name */
    public static USBGateService f4566k;

    /* renamed from: g  reason: collision with root package name */
    public NotificationManager f4567g;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList f4568h = new ArrayList(5);

    /* renamed from: i  reason: collision with root package name */
    public final HashMap f4569i = new HashMap();

    /* renamed from: j  reason: collision with root package name */
    public final s f4570j = new s(this);

    public static int b(Uri uri, int i5) {
        f b5 = Image.b(uri, 1, false, null);
        if (b5 != null) {
            int w5 = b5.w();
            if (i5 == 100 && w5 == 1) {
                d F = b5.F(0);
                if (F == null || F.q() == 100) {
                    w5 = -1;
                }
                if (F != null) {
                    try {
                        F.close();
                    } catch (Exception unused) {
                    }
                }
            }
            if (w5 < 1) {
                try {
                    b5.close();
                    return -105;
                } catch (Exception unused2) {
                    return -105;
                }
            }
            ZApp zApp = ZApp.f4571h;
            if (zApp != null) {
                zApp.getContentResolver().takePersistableUriPermission(uri, 3);
                SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(zApp).edit();
                edit.putInt("fs_" + Image.a(-1, uri.toString()), i5);
                edit.apply();
            }
            try {
                b5.close();
            } catch (Exception unused3) {
            }
            return 0;
        }
        return -1;
    }

    public static Intent h(r rVar) {
        String str;
        Uri buildDocumentUri;
        boolean z4 = true;
        if (rVar.f5090f != null) {
            StringBuilder sb = new StringBuilder("content://com.android.externalstorage.documents/document/");
            sb.append(Uri.encode("primary:" + str.substring(20)));
            buildDocumentUri = Uri.parse(sb.toString());
        } else {
            String[] strArr = USBGateProvider.f4561i;
            String v5 = e.v(rVar.f5086b, rVar.f5087c);
            buildDocumentUri = j.r(null, "group_storage", true) ? DocumentsContract.buildDocumentUri("ru.zdevs.zugate.usbgate", v5) : DocumentsContract.buildRootUri("ru.zdevs.zugate.usbgate", v5);
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(3);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.putExtra("android.content.extra.SHOW_ADVANCED", true);
        intent.putExtra("android.provider.extra.SHOW_ADVANCED", true);
        List<String> pathSegments = buildDocumentUri.getPathSegments();
        if (pathSegments.size() != 2 || !"root".equals(pathSegments.get(0))) {
            z4 = false;
        }
        intent.setDataAndType(buildDocumentUri, z4 ? "vnd.android.document/root" : "vnd.android.document/directory");
        return intent;
    }

    public final int a(Uri uri) {
        boolean z4;
        ContentResolver contentResolver = getContentResolver();
        Cursor B = i0.B(contentResolver, uri, "/");
        boolean z5 = true;
        if (B != null) {
            while (B.moveToNext()) {
                if (".encfs6.xml".equals(B.getString(1))) {
                    B.close();
                    z4 = true;
                    break;
                }
            }
            B.close();
        }
        z4 = false;
        if (z4) {
            contentResolver.takePersistableUriPermission(uri, 3);
            String uri2 = uri.toString();
            boolean z6 = x4.j.f5527a;
            CRC32 crc32 = new CRC32();
            crc32.update(uri2.getBytes());
            long value = crc32.getValue();
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(ZApp.f4571h).edit();
            edit.putInt("fs_" + value, 40);
            edit.apply();
        } else {
            z5 = false;
        }
        return z5 ? 0 : -1;
    }

    public final void c(a aVar, i iVar, String str, boolean z4) {
        synchronized (this.f4568h) {
            int size = this.f4568h.size() + 1;
            Iterator it = this.f4568h.iterator();
            while (it.hasNext()) {
                r rVar = (r) it.next();
                int i5 = rVar.f5092h;
                if (i5 == size) {
                    size++;
                }
                if (rVar.f5086b == aVar.f5032f && ((aVar.f5036j & 4080) == 64 || rVar.f5087c == aVar.f5034h)) {
                    if (i5 >= 0) {
                        this.f4567g.cancel(i5);
                    }
                    it.remove();
                }
            }
            r rVar2 = new r(aVar, iVar, str, z4);
            this.f4568h.add(rVar2);
            this.f4567g.notify(size, j(rVar2, size));
            rVar2.f5092h = size;
            Notification f5 = f();
            if (Build.VERSION.SDK_INT < 29) {
                startForeground(10000, f5);
            } else {
                startForeground(10000, f5, 16);
            }
            USBGateProvider uSBGateProvider = USBGateProvider.f4563k;
            if (uSBGateProvider != null) {
                uSBGateProvider.d(4, null);
            }
        }
    }

    public final void d(ArrayList arrayList) {
        synchronized (this.f4568h) {
            arrayList.ensureCapacity(this.f4568h.size());
            arrayList.addAll(this.f4568h);
        }
    }

    public final a[] e() {
        HashMap hashMap;
        HashMap hashMap2;
        ArrayList<a> arrayList;
        HashMap hashMap3;
        int i5;
        long D;
        int i6;
        HashMap hashMap4;
        HashMap<String, UsbDevice> deviceList;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(0);
        UsbManager x5 = e.x();
        if (x5 != null && (deviceList = x5.getDeviceList()) != null && !deviceList.isEmpty()) {
            Set<String> keySet = deviceList.keySet();
            arrayList3.ensureCapacity(keySet.size());
            CRC32 crc32 = new CRC32();
            for (String str : keySet) {
                UsbDevice usbDevice = deviceList.get(str);
                if (usbDevice != null && x4.j.b(usbDevice) != null) {
                    StringBuilder sb = new StringBuilder();
                    String manufacturerName = usbDevice.getManufacturerName();
                    if (manufacturerName != null) {
                        sb.append(manufacturerName);
                    }
                    String productName = usbDevice.getProductName();
                    if (productName != null) {
                        sb.append(' ');
                        sb.append(productName);
                    }
                    if (sb.length() == 0) {
                        sb.append(String.format("Device %04X:%04X", Integer.valueOf(usbDevice.getVendorId()), Integer.valueOf(usbDevice.getProductId())));
                    }
                    arrayList3.add(new a(sb.toString().trim(), str, x4.j.a(crc32, usbDevice)));
                }
            }
        }
        Iterator it = arrayList3.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            hashMap = this.f4569i;
            if (!hasNext) {
                break;
            }
            a aVar = (a) it.next();
            arrayList2.add(aVar);
            f fVar = (f) hashMap.get(Long.valueOf(aVar.f5032f));
            if (fVar != null) {
                aVar.a(1);
                if (fVar instanceof c) {
                    aVar.a(8192);
                }
                m(aVar, fVar, arrayList2);
            }
        }
        ZApp zApp = ZApp.f4571h;
        if (zApp == null) {
            arrayList = new ArrayList(0);
            hashMap2 = hashMap;
        } else {
            ContentResolver contentResolver = zApp.getContentResolver();
            List<UriPermission> persistedUriPermissions = contentResolver.getPersistedUriPermissions();
            int size = persistedUriPermissions.size();
            if (size > 0) {
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(zApp);
                ArrayList arrayList4 = new ArrayList(size);
                int i7 = 0;
                while (i7 < size) {
                    Uri uri = persistedUriPermissions.get(i7).getUri();
                    String C = i0.C(contentResolver, uri);
                    if (C == null) {
                        hashMap3 = hashMap;
                    } else {
                        hashMap3 = hashMap;
                        long a5 = Image.a(-1, uri.toString());
                        int i8 = defaultSharedPreferences.getInt("fs_" + a5, 0);
                        if (i8 == 41) {
                            i6 = 0;
                            i5 = 257;
                            D = i0.D(contentResolver, uri);
                        } else {
                            int i9 = DocumentsContract.isTreeUri(uri) ? 128 : 64;
                            i5 = i9;
                            D = i9 == 64 ? i0.D(contentResolver, uri) : 0L;
                            i6 = -1;
                        }
                        arrayList4.add(new a(C, uri, a5, i6, i8, i5, D));
                    }
                    i7++;
                    hashMap = hashMap3;
                }
                hashMap2 = hashMap;
                arrayList = arrayList4;
            } else {
                hashMap2 = hashMap;
                arrayList = new ArrayList(0);
            }
        }
        for (a aVar2 : arrayList) {
            arrayList2.add(aVar2);
            int i10 = aVar2.f5036j & 4080;
            if (i10 == 256) {
                hashMap4 = hashMap2;
            } else if (i10 == 128) {
                hashMap4 = hashMap2;
            } else {
                hashMap4 = hashMap2;
                f fVar2 = (f) hashMap4.get(Long.valueOf(aVar2.f5032f));
                if (fVar2 != null) {
                    aVar2.a(1);
                    if (fVar2 instanceof c) {
                        aVar2.a(8192);
                    }
                    m(aVar2, fVar2, arrayList2);
                }
                hashMap2 = hashMap4;
            }
            o(aVar2, null);
            hashMap2 = hashMap4;
        }
        return (a[]) arrayList2.toArray(new a[0]);
    }

    public final Notification f() {
        String string = getString(R.string.device_is_mounted);
        Notification.MessagingStyle messagingStyle = new Notification.MessagingStyle(getString(R.string.app_name));
        ArrayList arrayList = this.f4568h;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            messagingStyle.addMessage(string, System.currentTimeMillis(), ((r) it.next()).f5085a);
        }
        return new Notification.Builder(this, "mnt").setCategory("service").setContentText(getString(R.string.n_mounted_device, Integer.valueOf(arrayList.size()))).setSmallIcon(R.drawable.ic_usb_24).setColor(getColor(R.color.md_theme_light_primary)).setStyle(messagingStyle).setGroup("mnt").setGroupSummary(true).setOngoing(true).build();
    }

    public final String g(a aVar) {
        f fVar;
        f fVar2;
        d F;
        int i5 = 1;
        if ((aVar.f5036j & 4080) == 64) {
            Uri c5 = aVar.c();
            if (c5 == null) {
                return null;
            }
            fVar2 = Image.b(c5, 1, false, null);
        } else {
            synchronized (this.f4569i) {
                fVar = (f) this.f4569i.get(Long.valueOf(aVar.f5032f));
            }
            fVar2 = fVar;
        }
        if (fVar2 == null || (F = fVar2.F(aVar.f5034h)) == null) {
            return null;
        }
        int b5 = fVar2.b(aVar.f5034h);
        if (b5 == 6) {
            i5 = 3;
        } else if (b5 != 7) {
            if (b5 != 8) {
                return null;
            }
            i5 = 2;
        }
        String z4 = F.z(i5);
        if ((aVar.f5036j & 4080) == 64) {
            try {
                F.close();
            } catch (Exception unused) {
            }
        }
        return z4;
    }

    public final r i(long j5, int i5) {
        synchronized (this.f4568h) {
            Iterator it = this.f4568h.iterator();
            while (it.hasNext()) {
                r rVar = (r) it.next();
                if (rVar.f5086b == j5 && rVar.f5087c == i5) {
                    return rVar;
                }
            }
            return null;
        }
    }

    public final Notification j(r rVar, int i5) {
        int i6 = i5 * 10;
        Intent intent = new Intent(this, USBGateService.class);
        intent.setAction("ru.zdevs.zugate.service.DEVICE_UNMOUNT");
        long j5 = rVar.f5086b;
        intent.putExtra("devId", j5);
        intent.putExtra("devPart", rVar.f5087c);
        intent.putExtra("devType", rVar.f5088d);
        return new Notification.Builder(this, "mnt").setSmallIcon(R.drawable.ic_usb_24).setColor(e.m(this, h.o[Math.abs(((int) j5) % 11)])).setContentTitle(rVar.f5085a).setContentText(getString(R.string.device_is_mounted)).setGroup("mnt").addAction(new Notification.Action.Builder((Icon) null, getText(R.string.open), PendingIntent.getActivity(this, i6 + 1, h(rVar), 301989888)).build()).addAction(new Notification.Action.Builder((Icon) null, getText(R.string.unmount), PendingIntent.getService(this, i6, intent, 301989888)).build()).setOngoing(true).build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int k(a aVar, y4.j jVar, StringBuilder sb, int i5) {
        f fVar;
        f fVar2;
        boolean z4;
        int i6;
        boolean A;
        String str;
        int i7;
        String id;
        String str2;
        int i8;
        String str3;
        int i9 = i5;
        String a5 = jVar == null ? null : jVar.a();
        int i10 = 1;
        boolean z5 = (i9 & 1) == 0 ? 1 : false;
        int i11 = aVar.f5036j & 4080;
        if (i11 == 128) {
            Uri c5 = aVar.c();
            if (c5 == null) {
                return -1;
            }
            try {
                i L = EncFS.L(c5, a5, !z5);
                if (L == null) {
                    return -1;
                }
                c(aVar, L, null, z5);
                return 0;
            } catch (BlockDevice.BlockException e5) {
                return e5.f4595b;
            }
        }
        if (i11 == 256) {
            Uri c6 = aVar.c();
            if (c6 == null) {
                return -1;
            }
            fVar2 = Image.b(c6, !z5, false, sb);
            if (fVar2 == null) {
                return -106;
            }
            i9 |= 1024;
        } else {
            synchronized (this.f4569i) {
                fVar = (f) this.f4569i.get(Long.valueOf(aVar.f5032f));
            }
            if (fVar == null) {
                return -101;
            }
            fVar2 = fVar;
        }
        if (fVar2.l() && z5) {
            i9 |= 1;
            ZApp.c(R.string.fail_to_open_as_rw, new Object[0]);
            z4 = 0;
        } else {
            z4 = z5;
        }
        d F = fVar2.F(aVar.f5034h);
        if (F == null) {
            return -101;
        }
        int b5 = fVar2.b(aVar.f5034h);
        if (F.E()) {
            return -102;
        }
        try {
            if (b5 == 6) {
                i6 = 6;
                A = F.A(3, a5, null, null, sb);
            } else if (b5 == 7) {
                i6 = 6;
                A = F.A(1, a5, null, null, sb);
            } else if (b5 != 8) {
                if (b5 != 41) {
                    if (b5 != 100) {
                        i6 = 6;
                        A = true;
                    } else if ((i9 & 1024) == 0) {
                        return -105;
                    }
                }
                if (jVar == null) {
                    str2 = null;
                } else {
                    int i12 = jVar.f5741c;
                    str2 = i12 == 0 ? null : y4.j.f5738i[i12];
                }
                if (jVar != null && (i8 = jVar.f5742d) != 0) {
                    str3 = y4.j.f5739j[i8];
                    String str4 = str3;
                    i6 = 6;
                    A = F.A(4, a5, str2, str4, sb);
                }
                str3 = null;
                String str42 = str3;
                i6 = 6;
                A = F.A(4, a5, str2, str42, sb);
            } else {
                i6 = 6;
                A = F.A(2, a5, null, null, sb);
            }
            if (A) {
                if (aVar.d()) {
                    b bVar = (b) F;
                    if (bVar.H(aVar.f5028b, sb)) {
                        String str5 = bVar.f4625h;
                        c(aVar, null, str5 == null ? null : str5.replace(c.f5419e, "/storage/emulated/0"), z4);
                        return 0;
                    }
                    return -105;
                }
                i M = FS.M(F, !z4);
                if (M == null) {
                    int q5 = F.q();
                    return (q5 <= -1 || q5 == 100 || q5 >= i6) ? -109 : -104;
                }
                if (M.k(0L, 1) == 256) {
                    String locale = Locale.getDefault().toString();
                    int i13 = 2;
                    if (locale.startsWith("en") && (id = Calendar.getInstance().getTimeZone().getID()) != null && !id.startsWith("America")) {
                        try {
                            XmlResourceParser xml = ZApp.f4571h.getResources().getXml(R.xml.time_zones_by_country);
                            while (true) {
                                if (xml.getEventType() != i10) {
                                    if (xml.getEventType() == i13) {
                                        String name = xml.getName();
                                        if (name == null) {
                                            break;
                                        } else if (name.equals("timezone")) {
                                            String attributeValue = xml.getAttributeValue(null, "code");
                                            if (xml.next() == 4 && id.equals(xml.getText())) {
                                                if (!attributeValue.equals("ru") && !attributeValue.equals("ua") && !attributeValue.equals("by") && !attributeValue.equals("kz")) {
                                                    if (attributeValue.equals("de")) {
                                                        locale = "de";
                                                    } else {
                                                        if (!attributeValue.equals("cn") && !attributeValue.equals("hk")) {
                                                            if (attributeValue.equals("tw")) {
                                                                locale = Locale.TRADITIONAL_CHINESE.toString();
                                                            } else if (attributeValue.equals("fr")) {
                                                                locale = "fr";
                                                            } else if (attributeValue.equals("jp")) {
                                                                locale = Locale.JAPANESE.toString();
                                                            } else {
                                                                if (!attributeValue.equals("kp") && !attributeValue.equals("kr")) {
                                                                    if (attributeValue.equals("es")) {
                                                                        locale = "es";
                                                                    } else {
                                                                        if (!attributeValue.equals("il") && !attributeValue.equals("sy") && !attributeValue.equals("sa") && !attributeValue.equals("ae")) {
                                                                            if (id.startsWith("Europe")) {
                                                                                locale = attributeValue;
                                                                            }
                                                                        }
                                                                        locale = "ar";
                                                                    }
                                                                }
                                                                locale = Locale.KOREAN.toString();
                                                            }
                                                        }
                                                        locale = Locale.SIMPLIFIED_CHINESE.toString();
                                                    }
                                                }
                                                locale = "ru";
                                            } else {
                                                i10 = 1;
                                                i13 = 2;
                                            }
                                        } else {
                                            xml.next();
                                            i10 = 1;
                                        }
                                    } else {
                                        xml.next();
                                    }
                                } else {
                                    break;
                                }
                            }
                            xml.close();
                        } catch (Exception unused) {
                        }
                        locale.startsWith("en");
                    }
                    if (locale.startsWith(Locale.SIMPLIFIED_CHINESE.toString())) {
                        i7 = 936;
                    } else if (locale.startsWith(Locale.TRADITIONAL_CHINESE.toString()) || locale.startsWith(Locale.TAIWAN.toString())) {
                        i7 = 950;
                    } else if (locale.startsWith(Locale.JAPANESE.toString())) {
                        i7 = 932;
                    } else if (locale.startsWith(Locale.KOREAN.toString())) {
                        i7 = 949;
                    } else if (locale.startsWith(Locale.CANADA_FRENCH.toString()) || locale.startsWith(Locale.FRENCH.toString())) {
                        i7 = 863;
                    } else {
                        if (!locale.startsWith("ru") && !locale.startsWith("uk")) {
                            if (locale.startsWith("ar")) {
                                i7 = 720;
                            } else if (locale.startsWith("tr")) {
                                i7 = 857;
                            } else if (locale.startsWith("pt")) {
                                i7 = 860;
                            } else if (locale.startsWith("he")) {
                                i7 = 862;
                            } else if (locale.startsWith("el")) {
                                i7 = 737;
                            } else if (locale.startsWith("lv") || locale.startsWith("lt") || locale.startsWith("et")) {
                                i7 = 775;
                            } else if (locale.startsWith("en")) {
                                i7 = 437;
                            } else if (locale.startsWith("es") || locale.startsWith("fr") || locale.startsWith("de")) {
                                i7 = 850;
                            } else if (locale.startsWith("cs") || locale.startsWith("hu") || locale.startsWith("pl") || locale.startsWith("sr") || locale.startsWith("sk") || locale.startsWith("sl") || locale.startsWith("ro")) {
                                i7 = 852;
                            }
                        }
                        i7 = 866;
                    }
                    M.k(i7, 2);
                    str = null;
                } else {
                    str = null;
                }
                c(aVar, M, str, z4);
                return 0;
            }
            return -108;
        } catch (BlockDevice.BlockException e6) {
            return e6.f4595b;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:98:0x01fa, code lost:
        if (r9 == false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int l(t4.a r18, boolean r19, java.lang.StringBuilder r20) {
        /*
            Method dump skipped, instructions count: 611
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.zdevs.zugate.USBGateService.l(t4.a, boolean, java.lang.StringBuilder):int");
    }

    public final void m(a aVar, f fVar, ArrayList arrayList) {
        int i5;
        int lastIndexOf;
        a aVar2 = aVar;
        int i6 = 0;
        int i7 = (aVar2.f5036j & 4080) == 16 ? 4 : 0;
        if (aVar.d()) {
            i7 |= 8192;
        }
        if (fVar.l()) {
            i7 |= 16384;
        }
        int w5 = fVar.w();
        int i8 = 0;
        while (i8 < w5) {
            int b5 = fVar.b(i8);
            if (b5 <= -1) {
                i5 = i8;
            } else {
                String g5 = fVar.g(i8);
                if (g5 == null) {
                    if (w5 == 1) {
                        boolean m5 = fVar.m();
                        String str = aVar2.f5028b;
                        g5 = (!m5 || (lastIndexOf = str.lastIndexOf(46)) < 0) ? str : str.substring(i6, lastIndexOf);
                    } else {
                        g5 = getString(R.string.part_n, Integer.valueOf(i8 + 1));
                    }
                }
                i5 = i8;
                a aVar3 = new a(g5.trim(), aVar2.f5029c, aVar2.f5032f, i8, b5, i7, fVar.u(i8));
                long e5 = fVar.e(i5);
                if (e5 != -1) {
                    aVar3.f5033g = e5;
                    aVar3.f5036j |= 4096;
                }
                o(aVar3, fVar);
                arrayList.add(aVar3);
            }
            i8 = i5 + 1;
            aVar2 = aVar;
            i6 = 0;
        }
    }

    public final int n(a aVar) {
        Uri c5 = aVar.c();
        if (c5 == null) {
            return -106;
        }
        long j5 = aVar.f5032f;
        q(j5, aVar.f5036j & 4080, -1);
        ZApp zApp = ZApp.f4571h;
        if (zApp == null) {
            return 0;
        }
        zApp.getContentResolver().releasePersistableUriPermission(c5, 3);
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(zApp).edit();
        edit.remove("fs_" + j5);
        edit.apply();
        return 0;
    }

    public final void o(a aVar, f fVar) {
        b bVar;
        r rVar;
        boolean z4;
        if ((aVar.f5036j & 4080) == 16) {
            return;
        }
        synchronized (this.f4568h) {
            try {
                Iterator it = this.f4568h.iterator();
                do {
                    if (!it.hasNext()) {
                        if (aVar.d() && (aVar.f5036j & 4080) == 32 && (fVar instanceof c) && (bVar = (b) ((c) fVar).F(aVar.f5034h)) != null) {
                            String str = bVar.f4625h;
                            String replace = str == null ? null : str.replace(c.f5419e, "/storage/emulated/0");
                            if (replace != null) {
                                c(aVar, null, replace, (bVar.f4619b & 1) == 0);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    rVar = (r) it.next();
                    rVar.getClass();
                    if (rVar.f5086b != aVar.f5032f || ((aVar.f5036j & 4080) != 64 && rVar.f5087c != aVar.f5034h)) {
                        z4 = false;
                        continue;
                    }
                    z4 = true;
                } while (!z4);
                aVar.a(2);
                if (rVar.f5091g) {
                    aVar.a(8);
                }
                i iVar = rVar.f5089e;
                if (iVar != null) {
                    long k5 = iVar.k(0L, 1);
                    if (k5 > 0) {
                        aVar.f5031e = (int) k5;
                    } else {
                        aVar.f5031e = 0;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f4570j;
    }

    @Override // android.app.Service
    public final void onCreate() {
        this.f4567g = (NotificationManager) getSystemService(NotificationManager.class);
        this.f4567g.createNotificationChannel(new NotificationChannel("mnt", "Mount", 3));
        f4566k = this;
    }

    @Override // android.app.Service
    public final void onDestroy() {
        f4566k = null;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i5, int i6) {
        if ((i5 & 1) != 0) {
            stopSelf();
            return 2;
        }
        if (intent != null && "ru.zdevs.zugate.service.DEVICE_UNMOUNT".equals(intent.getAction())) {
            long longExtra = intent.getLongExtra("devId", -1L);
            int intExtra = intent.getIntExtra("devPart", -1);
            int intExtra2 = intent.getIntExtra("devType", -1);
            if (longExtra != -1 && intExtra2 != -1) {
                q(longExtra, intExtra2, intExtra);
            }
        }
        return 1;
    }

    public final void p(long j5, int i5, int i6) {
        boolean z4;
        f fVar;
        b bVar;
        synchronized (this.f4568h) {
            Iterator it = this.f4568h.iterator();
            z4 = false;
            while (it.hasNext()) {
                r rVar = (r) it.next();
                if (rVar.f5086b == j5 && ((i5 == rVar.f5088d && rVar.f5087c == i6) || i5 == 16 || i5 == 64)) {
                    i iVar = rVar.f5089e;
                    if (iVar != null) {
                        iVar.close();
                    }
                    if (rVar.f5090f != null) {
                        synchronized (this.f4569i) {
                            fVar = (f) this.f4569i.get(Long.valueOf(rVar.f5086b));
                        }
                        if ((fVar instanceof c) && (bVar = (b) fVar.F(rVar.f5087c)) != null) {
                            bVar.I();
                        }
                    }
                    it.remove();
                    int i7 = rVar.f5092h;
                    if (i7 > 0) {
                        this.f4567g.cancel(i7);
                    }
                    z4 = true;
                }
            }
        }
        if (z4) {
            String[] strArr = USBGateProvider.f4561i;
            ContentResolver a5 = ZApp.a();
            if (a5 != null) {
                a5.notifyChange(DocumentsContract.buildRootsUri("ru.zdevs.zugate.usbgate"), (ContentObserver) null, 16);
            }
        }
        if (this.f4568h.isEmpty()) {
            stopForeground(true);
        }
    }

    public final void q(long j5, int i5, int i6) {
        f fVar;
        p(j5, i5, i6);
        if (i5 == 16) {
            synchronized (this.f4569i) {
                fVar = (f) this.f4569i.remove(Long.valueOf(j5));
            }
            if (fVar != null) {
                try {
                    fVar.close();
                } catch (Exception unused) {
                }
            }
        }
    }
}

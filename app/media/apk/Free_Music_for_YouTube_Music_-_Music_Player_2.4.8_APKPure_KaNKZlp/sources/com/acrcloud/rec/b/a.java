package com.acrcloud.rec.b;

import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import com.acrcloud.rec.b.b;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.places.model.PlaceFields;
import com.flurry.android.Constants;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.util.Enumeration;
/* compiled from: ACRCloudClient.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private b f322a = null;

    /* renamed from: b  reason: collision with root package name */
    private com.acrcloud.rec.b.c.a f323b = null;

    /* renamed from: c  reason: collision with root package name */
    private com.acrcloud.rec.b.a.d f324c = null;
    private boolean d = false;
    private boolean e = false;
    private final int f = 1001;
    private final int g = 1002;
    private Handler h = new Handler(Looper.getMainLooper()) { // from class: com.acrcloud.rec.b.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    c cVar = (c) message.obj;
                    if (a.this.f322a.i != null) {
                        a.this.f322a.i.a(cVar);
                        return;
                    } else {
                        a.this.f322a.h.a(cVar.a());
                        return;
                    }
                case 1002:
                    double doubleValue = ((Double) message.obj).doubleValue();
                    if (a.this.f322a.i != null) {
                        a.this.f322a.i.a(doubleValue);
                        return;
                    } else {
                        a.this.f322a.h.a(doubleValue);
                        return;
                    }
                default:
                    return;
            }
        }
    };

    public boolean a(b bVar) {
        if (bVar == null || bVar.j == null) {
            return false;
        }
        this.f322a = bVar;
        String e = e();
        if (this.f324c == null) {
            if (this.f322a.f335a == b.EnumC0014b.REC_MODE_LOCAL) {
                this.f324c = new com.acrcloud.rec.b.a.b(this.f322a, e);
            } else if (this.f322a.f335a == b.EnumC0014b.REC_MODE_REMOTE) {
                this.f324c = new com.acrcloud.rec.b.a.c(this.f322a, e);
            } else if (this.f322a.f335a != b.EnumC0014b.REC_MODE_BOTH) {
                return false;
            } else {
                this.f324c = new com.acrcloud.rec.b.a.a(this.f322a, e);
            }
            try {
                this.f324c.a();
                return true;
            } catch (com.acrcloud.rec.b.b.a e2) {
                c cVar = new c();
                cVar.a(e2.toString());
                a(cVar);
                this.f324c = null;
                return false;
            }
        }
        return true;
    }

    public boolean a() {
        if (this.f322a == null || this.f324c == null || this.f322a.h == null) {
            return false;
        }
        d();
        this.f323b = new com.acrcloud.rec.b.c.a(this.f324c, this);
        this.f323b.start();
        this.e = true;
        return true;
    }

    public void b() {
        try {
            if (this.f323b != null) {
                this.f323b.b();
            }
            if (!this.d) {
                com.acrcloud.rec.a.a.a().d();
            }
            this.e = false;
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public void a(int i) {
        try {
            com.acrcloud.rec.a.a.a().a(i);
            com.acrcloud.rec.a.a.a().a(this);
            this.d = true;
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public void c() {
        try {
            if (this.d) {
                com.acrcloud.rec.a.a.a().d();
                this.d = false;
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public void d() {
        try {
            if (this.f323b != null) {
                this.f323b.a();
                this.f323b = null;
            }
            if (!this.d) {
                com.acrcloud.rec.a.a.a().d();
            }
            this.e = false;
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public void a(c cVar) {
        try {
            Message message = new Message();
            message.obj = cVar;
            message.what = 1001;
            this.h.sendMessage(message);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public void a(double d) {
        try {
            if (this.e) {
                Message message = new Message();
                message.obj = Double.valueOf(d);
                message.what = 1002;
                this.h.sendMessage(message);
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    private InetAddress g() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress()) {
                        return nextElement;
                    }
                }
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
        return null;
    }

    private String h() {
        try {
            InetAddress g = g();
            if (g == null) {
                return null;
            }
            byte[] hardwareAddress = NetworkInterface.getByInetAddress(g).getHardwareAddress();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < hardwareAddress.length; i++) {
                if (i != 0) {
                    stringBuffer.append(':');
                }
                String hexString = Integer.toHexString(hardwareAddress[i] & Constants.UNKNOWN);
                if (hexString.length() == 1) {
                    hexString = 0 + hexString;
                }
                stringBuffer.append(hexString);
            }
            return stringBuffer.toString().toUpperCase();
        } catch (Exception e) {
            return null;
        }
    }

    private String i() {
        String str;
        try {
        } catch (Exception e) {
            str = "" + System.currentTimeMillis() + this.f322a.e + Math.random();
        }
        if (this.f322a.j == null) {
            return "";
        }
        TelephonyManager telephonyManager = (TelephonyManager) ((ContextWrapper) this.f322a.j).getBaseContext().getSystemService(PlaceFields.PHONE);
        String h = h();
        if (h != null) {
            return h;
        }
        String deviceId = telephonyManager.getDeviceId();
        if (deviceId == null) {
            deviceId = "";
        }
        str = deviceId + System.currentTimeMillis() + this.f322a.e + Math.random();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b2 : digest) {
                if ((b2 & Constants.UNKNOWN) < 16) {
                    sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                sb.append(Integer.toHexString(b2 & Constants.UNKNOWN));
            }
            return sb.toString();
        } catch (Exception e2) {
            ThrowableExtension.printStackTrace(e2);
            return "";
        }
    }

    public String e() {
        String str;
        Exception e;
        try {
            SharedPreferences sharedPreferences = this.f322a.j.getSharedPreferences("acrcloud", 0);
            String string = sharedPreferences.getString("id", "");
            if (string != null) {
                try {
                    if (!"".equals(string)) {
                        return string;
                    }
                } catch (Exception e2) {
                    e = e2;
                    ThrowableExtension.printStackTrace(e);
                    return str;
                }
            }
            str = i();
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("id", str);
            edit.commit();
            return str;
        } catch (Exception e3) {
            str = "";
            e = e3;
        }
    }

    public void f() {
        if (this.f324c != null) {
            try {
                d();
                c();
                this.f324c.b();
                this.f324c = null;
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
        }
    }
}

package com.fotoable.youtube.music.quicktools.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import com.fotoable.youtube.music.quicktools.settings.a;
/* loaded from: classes.dex */
public class PhoneStateHelper implements a.InterfaceC0062a {

    /* renamed from: b  reason: collision with root package name */
    private static final String f3127b = PhoneStateHelper.class.getSimpleName();
    private static PhoneStateReceiver d;

    /* renamed from: a  reason: collision with root package name */
    ContentObserver f3128a = new ContentObserver(new Handler()) { // from class: com.fotoable.youtube.music.quicktools.settings.PhoneStateHelper.1
        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            if (PhoneStateHelper.this.f3129c != null) {
                PhoneStateHelper.this.f3129c.g();
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private b f3129c;
    private IntentFilter e;
    private Context f;

    public PhoneStateHelper(b bVar) {
        this.f3129c = bVar;
        d = new PhoneStateReceiver();
        this.e = new IntentFilter();
        this.e.setPriority(1000);
        this.e.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        this.e.addAction("android.location.PROVIDERS_CHANGED");
        this.e.addAction("android.net.wifi.STATE_CHANGE");
        this.e.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.e.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        this.e.addAction("android.media.RINGER_MODE_CHANGED");
        this.e.addAction("android.media.VOLUME_CHANGED_ACTION");
    }

    @Override // com.fotoable.youtube.music.quicktools.settings.a.InterfaceC0062a
    public void a(String str) {
        if (this.f3129c != null) {
            this.f3129c.a(str);
        }
    }

    public void a(Context context) {
        this.f = context.getApplicationContext();
        this.f.registerReceiver(d, this.e);
        this.f.getContentResolver().registerContentObserver(Settings.System.getUriFor("screen_brightness"), true, this.f3128a);
    }

    public void a() {
        if (this.f != null) {
            this.f.unregisterReceiver(d);
            this.f.getContentResolver().unregisterContentObserver(this.f3128a);
            d = null;
            this.f3128a = null;
            this.f = null;
        }
    }

    /* loaded from: classes.dex */
    public class PhoneStateReceiver extends BroadcastReceiver {
        public PhoneStateReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (PhoneStateHelper.this.f3129c != null) {
                String str = "onReceive";
                if ("android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction())) {
                    str = "wifi开关";
                    PhoneStateHelper.this.f3129c.a();
                } else if ("android.location.PROVIDERS_CHANGED".equals(intent.getAction())) {
                    str = "GPS";
                    PhoneStateHelper.this.f3129c.b();
                } else if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction())) {
                    str = "移动数据NETWORK_STATE_CHANGED_ACTION";
                    PhoneStateHelper.this.f3129c.c();
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                    str = "移动数据CONNECTIVITY_ACTION";
                    PhoneStateHelper.this.f3129c.c();
                } else if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction())) {
                    str = "蓝牙";
                    PhoneStateHelper.this.f3129c.d();
                } else if ("android.media.RINGER_MODE_CHANGED".equals(intent.getAction())) {
                    str = "响铃";
                    PhoneStateHelper.this.f3129c.e();
                } else if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction())) {
                    str = "媒体音量";
                    PhoneStateHelper.this.f3129c.f();
                }
                Log.d(PhoneStateHelper.f3127b, str);
            }
        }
    }
}

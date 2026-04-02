package com.pili.pldroid.player.report.core;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
/* compiled from: QosReceiver.java */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static Context f5064a;

    /* renamed from: b  reason: collision with root package name */
    private f f5065b;

    /* renamed from: c  reason: collision with root package name */
    private Object f5066c;
    private boolean d;
    private BroadcastReceiver e;
    private BroadcastReceiver f;

    /* compiled from: QosReceiver.java */
    /* loaded from: classes2.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final d f5070a = new d();
    }

    private d() {
        this.f5066c = new Object();
        this.d = false;
        this.e = new BroadcastReceiver() { // from class: com.pili.pldroid.player.report.core.d.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if ("pldroid-player-qos-filter".equals(intent.getAction())) {
                    d.this.a(intent);
                }
            }
        };
        this.f = new BroadcastReceiver() { // from class: com.pili.pldroid.player.report.core.d.2
            @Override // android.content.BroadcastReceiver
            @TargetApi(11)
            public void onReceive(Context context, Intent intent) {
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                    AsyncTask.execute(new Runnable() { // from class: com.pili.pldroid.player.report.core.d.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.f5065b.d();
                        }
                    });
                }
            }
        };
    }

    public static d a() {
        return a.f5070a;
    }

    public void a(Context context) {
        synchronized (this.f5066c) {
            if (!this.d && context != null) {
                f5064a = context.getApplicationContext();
                this.f5065b = new f();
                this.f5065b.a(context);
                com.pili.pldroid.player.report.a.a().a(this.e, new IntentFilter("pldroid-player-qos-filter"));
                f5064a.registerReceiver(this.f, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.d = true;
            }
        }
    }

    public void b(Context context) {
        synchronized (this.f5066c) {
            if (f5064a != null && this.d) {
                f5064a.unregisterReceiver(this.f);
                f5064a = null;
                com.pili.pldroid.player.report.a.a().a(this.e);
                this.f5065b.a();
                this.d = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Intent intent) {
        switch (intent.getIntExtra("pldroid-qos-msg-type", -1)) {
            case 4:
                this.f5065b.b().a(intent.getStringExtra("scheme"), intent.getStringExtra("domain"), intent.getStringExtra("remoteIp"), intent.getStringExtra("path"), intent.getStringExtra("reqid"));
                this.f5065b.e();
                com.pili.pldroid.player.report.common.a.g();
                return true;
            case 162:
                this.f5065b.e();
                return true;
            case 193:
                b(intent);
                return true;
            case 195:
                this.f5065b.a(intent);
                return true;
            case 196:
                this.f5065b.b(intent);
                return true;
            default:
                return true;
        }
    }

    private void b(Intent intent) {
        if (this.f5065b.c().a(intent.getLongExtra("beginAt", 0L), intent.getLongExtra("endAt", 0L), intent.getLongExtra("bufferingTimes", 0L), intent.getIntExtra("videoSourceFps", 0), intent.getIntExtra("dropVideoFrames", 0), intent.getIntExtra("audioSourceFps", 0), intent.getIntExtra("audioDropFrames", 0), intent.getIntExtra("videoRenderFps", 0), intent.getIntExtra("audioRenderFps", 0), intent.getIntExtra("videoBufferTime", 0), intent.getIntExtra("audioBufferTime", 0), intent.getLongExtra("audioBitrate", 0L), intent.getLongExtra("videoBitrate", 0L))) {
            this.f5065b.f();
        }
    }
}
